/*
 * Copyright (c) 2018-2026 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */

package nl.esi.pps.tmsc.reconstruct;

import static java.util.function.Function.identity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import nl.esi.pps.architecture.example.ExampleArchitecture;
import nl.esi.pps.architecture.example.ExampleFactory;
import nl.esi.pps.architecture.implemented.Function;
import nl.esi.pps.architecture.implemented.ImplementedFactory;
import nl.esi.pps.architecture.instantiated.Executor;
import nl.esi.pps.architecture.instantiated.InstantiatedFactory;
import nl.esi.pps.architecture.specified.Component;
import nl.esi.pps.architecture.specified.SpecifiedFactory;
import nl.esi.pps.tmsc.Event;
import nl.esi.pps.tmsc.FullScopeTMSC;
import nl.esi.pps.tmsc.Lifeline;
import nl.esi.pps.tmsc.Message;
import nl.esi.pps.tmsc.TmscFactory;
import nl.esi.pps.tmsc.metric.Metric;
import nl.esi.pps.tmsc.metric.MetricCategory;
import nl.esi.pps.tmsc.metric.MetricFactory;
import nl.esi.pps.tmsc.metric.MetricInstance;
import nl.esi.pps.tmsc.metric.MetricModel;
import nl.esi.pps.tmsc.util.TmscRefinements;

/**
 * Reconstructor that transforms a sequence of traced events into a
 * {@link FullScopeTMSC} model while populating an example architecture and a
 * metric model. The reconstructor keeps temporary caches for architecture
 * elements, lifelines, messages and metric instances while processing the
 * input events and applies refinements after reconstruction is finished.
 */
public class TmscTraceReconstructor {
    protected static final String VALUE_SEPARATOR = "::";

    private final ExampleArchitecture architecture;
    private final FullScopeTMSC tmsc;
    private final MetricModel metrics;

    private Map<String, Component> components;
    private Map<String, Function> functions;
    private Map<String, Executor> executors;
    private Map<String, Lifeline> lifelines;
    private Map<String, Message> messages;
    private Map<String, MetricInstance> metricInstances;

    /**
     * Create a reconstructor using a newly created empty example architecture.
     */
    public TmscTraceReconstructor() {
        this(null);
    }

    /**
     * Create a reconstructor that will use the provided {@link ExampleArchitecture}
     * as the starting architecture. If {@code architecture} is {@code null} a
     * new empty architecture will be created.
     *
     * @param architecture the example architecture to populate, or {@code null}
     *                     to create a new one
     */
    public TmscTraceReconstructor(ExampleArchitecture architecture) {
        if (architecture == null) {
            this.architecture = ExampleFactory.eINSTANCE.createExampleArchitecture();
        } else {
            this.architecture = architecture;
        }
        this.tmsc = TmscFactory.eINSTANCE.createFullScopeTMSC();
        this.metrics = MetricFactory.eINSTANCE.createMetricModel();
    }

    /**
     * Returns the reconstructed TMSC model. This model is populated while
     * processing trace events and refined after reconstruction.
     *
     * @return the FullScopeTMSC instance produced by this reconstructor
     */
    public FullScopeTMSC getTmsc() {
        return tmsc;
    }

    /**
     * Returns the example architecture that is populated during
     * reconstruction. The architecture may be pre-populated when passed to the
     * constructor or created empty by this class.
     *
     * @return the ExampleArchitecture instance used by this reconstructor
     */
    public ExampleArchitecture getArchitecture() {
        return architecture;
    }

    /**
     * Indicates whether any metrics were created while reconstructing the
     * trace.
     *
     * @return {@code true} when the metric model contains at least one metric
     */
    public boolean hasMetrics() {
        return !metrics.getMetrics().isEmpty();
    }

    /**
     * Returns the metric model constructed from trace events. The model may be
     * empty if no metric instances were encountered.
     *
     * @return the MetricModel containing categories, metrics and instances
     */
    public MetricModel getMetrics() {
        return metrics;
    }

    protected void preReconstruct() {
        // An architecture may already exist, populate caches
        executors = architecture.getExecutors().stream().collect(Collectors.toMap(Executor::getName, identity()));
        components = architecture.getComponents().stream().collect(Collectors.toMap(Component::getName, identity()));
        functions = architecture.getFunctions().stream().collect(Collectors.toMap(Function::getName, identity()));

        lifelines = new HashMap<>();
        messages = new HashMap<>();
        metricInstances = new HashMap<>();

        // Assign the architecture to the TMSC
        this.tmsc.getArchitectures().add(this.architecture);
    }

    /**
     * Process a single trace event and incorporate it into the TMSC model and
     * associated caches. This updates the TMSC start/end timestamps, creates
     * or reuses architecture elements and lifelines, attaches properties to the
     * created TMSC event, and links messages and metric instances to the
     * appropriate events.
     *
     * @param traceEvent the trace event to process
     * @throws IllegalArgumentException when duplicate message or metric-instance
     *                                  identifiers are encountered that would
     *                                  cause ambiguous linking
     */
    protected void reconstruct(TmscTraceEvent traceEvent) throws IllegalArgumentException {
        // Update start/end time of TMSC, assuming that events are ordered in time
        Long timeStamp = traceEvent.getTimeStamp();
        if (tmsc.getStartTime() == null) {
            tmsc.setStartTime(timeStamp);
            tmsc.setEpochTime(traceEvent.isEpochTime());
        }
        tmsc.setEndTime(timeStamp);

        // Creating the event with its references to the architecture
        Event tmscEvent = traceEvent.getEventType().createEvent();
        tmscEvent.setTimestamp(timeStamp);
        tmscEvent.setFunction(functions.computeIfAbsent(traceEvent.getFunction(), this::createFunction));
        tmscEvent.setComponent(components.computeIfAbsent(traceEvent.getComponent(), this::createComponent));
        tmscEvent.setLifeline(lifelines.computeIfAbsent(traceEvent.getExecutor(), this::createLifeline));

        // Properties
        for (String property: traceEvent.getProperties()) {
            addPropertyToEvent(tmscEvent, property);
        }

        // Sent messages
        for (String messageId: traceEvent.getSentMessages()) {
            messages.compute(messageId, (id, msg) -> {
                if (msg == null) {
                    msg = createMessage(id);
                }
                if (msg.getSource() == null) {
                    msg.setSource(tmscEvent);
                } else {
                    throw new IllegalArgumentException("Message IDs should be unique: " + id);
                }
                // Remove from cache when both source and target are set
                return msg.getTarget() == null ? msg : null;
            });
        }

        // Received messages
        for (String messageId: traceEvent.getReceivedMessages()) {
            messages.compute(messageId, (id, msg) -> {
                if (msg == null) {
                    msg = createMessage(id);
                }
                if (msg.getTarget() == null) {
                    msg.setTarget(tmscEvent);
                } else {
                    throw new IllegalArgumentException("Message IDs should be unique: " + id);
                }
                // Remove from cache when both source and target are set
                return msg.getSource() == null ? msg : null;
            });
        }

        // Metric starts
        for (String metricInstanceId: traceEvent.getMetricStarts()) {
            metricInstances.compute(metricInstanceId, (id, mi) -> {
                if (mi == null) {
                    mi = createMetricInstance(id);
                }
                if (mi.getFrom() == null) {
                    mi.setFrom(tmscEvent);
                } else {
                    throw new IllegalArgumentException("Metric-instance IDs should be unique: " + id);
                }
                // Remove from cache when both from and to are set
                return mi.getTo() == null ? mi : null;
            });
        }

        // Metric end
        for (String metricInstanceId: traceEvent.getMetricEnds()) {
            metricInstances.compute(metricInstanceId, (id, mi) -> {
                if (mi == null) {
                    mi = createMetricInstance(id);
                }
                if (mi.getTo() == null) {
                    mi.setTo(tmscEvent);
                } else {
                    throw new IllegalArgumentException("Metric-instance IDs should be unique: " + id);
                }
                // Remove from cache when both from and to are set
                return mi.getFrom() == null ? mi : null;
            });
        }
    }

    protected void postReconstruct() {
        TmscRefinements.refineWithCompleteOrder(tmsc);
        TmscRefinements.refineWithCallStacks(tmsc);
    }

    /**
     * Adds a property to the given event. The property string can be in the format "property-name" or
     * "property-name::property-value". If only the property name is provided, the value will be set to null.
     *
     * @param event The event to which the property should be added
     * @param property Supports format: <tt>property-name[::property-value]</tt>
     */
    @SuppressWarnings("deprecation")
    protected void addPropertyToEvent(Event event, String property) {
        String[] parts = property.split(VALUE_SEPARATOR, 2);
        if (parts.length == 1) {
            event.getProperties().put(parts[0], null);
        } else if (parts.length == 2) {
            Serializable value = parts[1];
            try {
                value = Long.parseLong(parts[1]);
            } catch (NumberFormatException e) {
                // Not a long, try big decimal
                try {
                    value = Double.parseDouble(parts[1]);
                } catch (NumberFormatException e2) {
                    // Not a double, try boolean
                    if ("true".equalsIgnoreCase(parts[1]) || "false".equalsIgnoreCase(parts[1])) {
                        value = Boolean.parseBoolean(parts[1]);
                    }
                }
            }
            event.getProperties().put(parts[0], value);
        }
    }

    /**
     * Create and register a new {@link Lifeline} with the provided name.
     *
     * @param executorName name of the lifeline to create
     * @return the created Lifeline instance
     */
    protected Lifeline createLifeline(String executorName) {
        Lifeline lifeline = TmscFactory.eINSTANCE.createLifeline();
        lifeline.setExecutor(executors.computeIfAbsent(executorName, this::createExecutor));
        tmsc.getLifelines().add(lifeline);
        return lifeline;
    }

    /**
     * Create and register a new {@link Executor} with the provided name.
     *
     * @param executorName name of the executor to create
     * @return the created Executor instance
     */
    protected Executor createExecutor(String executorName) {
        Executor executor = InstantiatedFactory.eINSTANCE.createExecutor();
        executor.setName(executorName);
        architecture.getExecutors().add(executor);
        return executor;
    }

    /**
     * Create and register a new {@link Function} with the provided name.
     *
     * @param functionName name of the function to create
     * @return the created Function instance
     */
    protected Function createFunction(String functionName) {
        Function function = ImplementedFactory.eINSTANCE.createFunction();
        function.setName(functionName);
        architecture.getFunctions().add(function);
        return function;
    }

    /**
     * Create and register a new {@link Component} with the provided name.
     *
     * @param componentName name of the component to create
     * @return the created Component instance
     */
    protected Component createComponent(String componentName) {
        Component component = SpecifiedFactory.eINSTANCE.createComponent();
        component.setName(componentName);
        architecture.getComponents().add(component);
        return component;
    }

    /**
     * Create and register a new {@link Message} with the provided id.
     *
     * @param messageId id of the message to create
     * @return the created Message instance
     */
    @SuppressWarnings("deprecation")
    protected Message createMessage(String messageId) {
        Message message = TmscFactory.eINSTANCE.createMessage();
        message.getProperties().put("id", messageId);
        tmsc.getDependencies().add(message);
        return message;
    }

    /**
     * Creates a metric instance with the given ID. If the metric does not exist, it will be created as well.
     *
     * @param metricInstanceId Supports format: <tt>[[category::]metric-id::]instance-id</tt>
     * @return the created metric instance, which is also added to the metric and category
     */
    protected MetricInstance createMetricInstance(String metricInstanceId) {
        String[] parts = metricInstanceId.split(VALUE_SEPARATOR, 3);
        String categoryId = parts.length == 3 ? parts[0] : "Traced";
        String metricId = parts.length >= 2 ? parts[parts.length - 2] : "Traced";
        String instanceId = parts[parts.length - 1];

        Metric metric = metrics.getMetrics().stream().filter(m -> Objects.equals(m.getId(), metricId)).findFirst()
                .orElseGet(() -> {
                    MetricCategory category = metrics.getCategories().stream()
                            .filter(c -> Objects.equals(c.getName(), categoryId)).findFirst()
                            .orElseGet(() -> createMetricCategory(categoryId));
                    return createMetric(metricId, category);
                });

        return createMetricInstance(instanceId, metric);
    }

    /**
     * Create a metric instance with the provided id and attach it to the
     * specified metric.
     *
     * @param metricInstanceId identifier for the metric instance
     * @param metric           the metric to which the instance will be added
     * @return the created MetricInstance
     */
    protected MetricInstance createMetricInstance(String metricInstanceId, Metric metric) {
        MetricInstance metricInstance = MetricFactory.eINSTANCE.createMetricInstance();
        metricInstance.setId(metricInstanceId);
        metric.getInstances().add(metricInstance);
        return metricInstance;
    }

    /**
     * Create a new {@link Metric} with the given id and register it in the
     * provided category and the global metric model.
     *
     * @param metricId the metric identifier
     * @param category the category to which the metric will belong
     * @return the created Metric
     */
    protected Metric createMetric(String metricId, MetricCategory category) {
        Metric metric = MetricFactory.eINSTANCE.createMetric();
        metric.setId(metricId);
        metric.setName(metricId);
        category.getMetrics().add(metric);
        getMetrics().getMetrics().add(metric);
        return metric;
    }

    /**
     * Create and register a new {@link MetricCategory} with the provided name.
     *
     * @param categoryId name of the category to create
     * @return the created MetricCategory
     */
    protected MetricCategory createMetricCategory(String categoryId) {
        MetricCategory category = MetricFactory.eINSTANCE.createMetricCategory();
        category.setName(categoryId);
        getMetrics().getCategories().add(category);
        return category;
    }
}
