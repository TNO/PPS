/**
 * Copyright (c) 2018-2025 TNO and Contributors to the GitHub community
 * 
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 * 
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.xtext.validation;

import com.google.common.collect.Iterables;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import nl.esi.pps.common.jfreechart.rendering.RenderingPaint;
import nl.esi.pps.common.jfreechart.rendering.RenderingStroke;
import nl.esi.pps.tmsc.rendering.RenderingDependencies;
import nl.esi.pps.tmsc.rendering.RenderingExecutions;
import nl.esi.pps.tmsc.rendering.RenderingProperties;
import nl.esi.pps.tmsc.xtext.TmscXtextQueries;
import nl.esi.pps.tmsc.xtext.tmscXtext.TmscXtextModel;
import nl.esi.pps.tmsc.xtext.tmscXtext.TmscXtextPackage;
import nl.esi.pps.tmsc.xtext.tmscXtext.XComponent;
import nl.esi.pps.tmsc.xtext.tmscXtext.XDependency;
import nl.esi.pps.tmsc.xtext.tmscXtext.XDependencySettings;
import nl.esi.pps.tmsc.xtext.tmscXtext.XDependencyType;
import nl.esi.pps.tmsc.xtext.tmscXtext.XEvent;
import nl.esi.pps.tmsc.xtext.tmscXtext.XEventArgument;
import nl.esi.pps.tmsc.xtext.tmscXtext.XEventType;
import nl.esi.pps.tmsc.xtext.tmscXtext.XExecutor;
import nl.esi.pps.tmsc.xtext.tmscXtext.XFunction;
import nl.esi.pps.tmsc.xtext.tmscXtext.XFunctionParameterKind;
import nl.esi.pps.tmsc.xtext.tmscXtext.XInterface;
import nl.esi.pps.tmsc.xtext.tmscXtext.XNamedArchitectureElement;
import nl.esi.pps.tmsc.xtext.tmscXtext.XOperation;
import nl.esi.pps.tmsc.xtext.tmscXtext.XProperty;
import nl.esi.pps.tmsc.xtext.tmscXtext.XPropertyStringValue;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.lsat.common.xtend.Queries;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckType;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.MapExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

/**
 * This class contains custom validation rules.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
@SuppressWarnings("all")
public class TmscXtextValidator extends AbstractTmscXtextValidator {
  public static final String UNIQUE_NAME_XNAMED_ARCHITECTURE_ELEMENT = "uniqueXNamedArchitectureElement";

  @Check
  public void checkUniqueXComponentName(final XNamedArchitectureElement namedElement) {
    final EStructuralFeature feature = namedElement.eContainingFeature();
    Object _eGet = namedElement.eContainer().eGet(feature);
    final Iterable<XNamedArchitectureElement> siblings = Queries.<XNamedArchitectureElement>excluding(((Iterable<XNamedArchitectureElement>) _eGet), namedElement);
    final Function1<XNamedArchitectureElement, Boolean> _function = (XNamedArchitectureElement it) -> {
      String _name = it.getName();
      String _name_1 = namedElement.getName();
      return Boolean.valueOf(Objects.equals(_name, _name_1));
    };
    boolean _exists = IterableExtensions.<XNamedArchitectureElement>exists(siblings, _function);
    if (_exists) {
      StringConcatenation _builder = new StringConcatenation();
      String _substring = namedElement.eClass().getName().substring(1);
      _builder.append(_substring);
      _builder.append(" name  ");
      String _name = namedElement.getName();
      _builder.append(_name);
      _builder.append(" should be unique");
      this.error(_builder.toString(), 
        TmscXtextPackage.Literals.XNAMED_ARCHITECTURE_ELEMENT__NAME, TmscXtextValidator.UNIQUE_NAME_XNAMED_ARCHITECTURE_ELEMENT);
    }
  }

  public static final String UNIQUE_NAME_XDEPENDENCY = "uniqueXDependencyName";

  @Check
  public void checkUniqueXDependencyName(final TmscXtextModel model) {
    final Function1<XEvent, EList<XDependency>> _function = (XEvent it) -> {
      return it.getOutgoingDependencies();
    };
    final Function1<XDependency, String> _function_1 = (XDependency it) -> {
      return it.getName();
    };
    final Function1<List<XDependency>, Boolean> _function_2 = (List<XDependency> it) -> {
      int _size = it.size();
      return Boolean.valueOf((_size > 1));
    };
    final Consumer<XDependency> _function_3 = (XDependency it) -> {
      StringConcatenation _builder = new StringConcatenation();
      String _firstUpper = StringExtensions.toFirstUpper(TmscXtextQueries.getType(it).getLiteral());
      _builder.append(_firstUpper);
      _builder.append(" ");
      String _name = it.getName();
      _builder.append(_name);
      _builder.append(" can be sent only once; ID should be unique");
      this.error(_builder.toString(), it, TmscXtextPackage.Literals.XDEPENDENCY__NAME, TmscXtextValidator.UNIQUE_NAME_XDEPENDENCY);
    };
    Iterables.<XDependency>concat(IterableExtensions.<List<XDependency>>filter(IterableExtensions.<String, XDependency>groupBy(IterableExtensions.<XEvent, XDependency>flatMap(model.getEvents(), _function), _function_1).values(), _function_2)).forEach(_function_3);
  }

  public static final String UNIQUE_NAME_XPROPERTY = "uniqueXPropertyName";

  @Check
  public void checkUniqueXPropertyName(final XProperty xProperty) {
    final EStructuralFeature feature = xProperty.eContainingFeature();
    Object _eGet = xProperty.eContainer().eGet(feature);
    final Iterable<XProperty> siblings = Queries.<XProperty>excluding(((Iterable<XProperty>) _eGet), xProperty);
    final Function1<XProperty, Boolean> _function = (XProperty it) -> {
      String _name = it.getName();
      String _name_1 = xProperty.getName();
      return Boolean.valueOf(Objects.equals(_name, _name_1));
    };
    boolean _exists = IterableExtensions.<XProperty>exists(siblings, _function);
    if (_exists) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Property name ");
      String _name = xProperty.getName();
      _builder.append(_name);
      _builder.append(" should be unique");
      this.error(_builder.toString(), TmscXtextPackage.Literals.XPROPERTY__NAME, 
        TmscXtextValidator.UNIQUE_NAME_XPROPERTY);
    }
  }

  public static final String UNIQUE_TYPE_XDEPENDENCY_DEFAULTS = "uniqueXDependencyDefaultsType";

  @Check
  public void checkUniqueXDependencyDefaultsType(final XDependencySettings xDependencySettings) {
    final Function1<XDependencySettings, Boolean> _function = (XDependencySettings it) -> {
      XDependencyType _type = it.getType();
      XDependencyType _type_1 = xDependencySettings.getType();
      return Boolean.valueOf(Objects.equals(_type, _type_1));
    };
    boolean _exists = IterableExtensions.<XDependencySettings>exists(EcoreUtil2.<XDependencySettings>getSiblingsOfType(xDependencySettings, XDependencySettings.class), _function);
    if (_exists) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Defaults can be set only once for type ");
      XDependencyType _type = xDependencySettings.getType();
      _builder.append(_type);
      this.error(_builder.toString(), 
        TmscXtextPackage.Literals.XDEPENDENCY_SETTINGS__TYPE, TmscXtextValidator.UNIQUE_TYPE_XDEPENDENCY_DEFAULTS);
    }
  }

  public static final String UNIQUE_PREFIX_XDEPENDENCY_DEFAULTS = "uniqueXDependencyDefaultsPrefix";

  @Check
  public void checkUniqueXDependencyDefaultsPrefix(final XDependencySettings xDependencySettings) {
    String _prefix = xDependencySettings.getPrefix();
    boolean _tripleEquals = (_prefix == null);
    if (_tripleEquals) {
      return;
    }
    final List<XDependencySettings> siblings = EcoreUtil2.<XDependencySettings>getSiblingsOfType(xDependencySettings, XDependencySettings.class);
    final Function1<XDependencySettings, String> _function = (XDependencySettings it) -> {
      return it.getPrefix();
    };
    final Function1<String, Boolean> _function_1 = (String prefix) -> {
      return Boolean.valueOf((prefix.startsWith(xDependencySettings.getPrefix()) || xDependencySettings.getPrefix().startsWith(prefix)));
    };
    final List<String> duplicates = IterableExtensions.<String>sort(IterableExtensions.<String>filter(IterableExtensions.<String>filterNull(ListExtensions.<XDependencySettings, String>map(siblings, _function)), _function_1));
    boolean _isEmpty = duplicates.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Prefix ");
      String _prefix_1 = xDependencySettings.getPrefix();
      _builder.append(_prefix_1);
      _builder.append(" collides with ");
      {
        boolean _hasElements = false;
        for(final String duplicate : duplicates) {
          if (!_hasElements) {
            _hasElements = true;
          } else {
            _builder.appendImmediate(", ", "");
          }
          _builder.append(duplicate);
        }
      }
      this.error(_builder.toString(), 
        TmscXtextPackage.Literals.XDEPENDENCY_SETTINGS__PREFIX, TmscXtextValidator.UNIQUE_PREFIX_XDEPENDENCY_DEFAULTS);
    }
  }

  public static final String MULTIPLE_XDEPENDENCY_RECEIVE = "multipleXDependencyReceive";

  @Check
  public void checkMultipleXDependencyReceive(final TmscXtextModel model) {
    final HashMap<XDependency, ArrayList<XEvent>> receives = CollectionLiterals.<XDependency, ArrayList<XEvent>>newHashMap();
    EList<XEvent> _events = model.getEvents();
    for (final XEvent event : _events) {
      final Consumer<XDependency> _function = (XDependency d) -> {
        final Function<XDependency, ArrayList<XEvent>> _function_1 = (XDependency it) -> {
          return CollectionLiterals.<XEvent>newArrayList();
        };
        ArrayList<XEvent> _computeIfAbsent = receives.computeIfAbsent(d, _function_1);
        _computeIfAbsent.add(event);
      };
      event.getIncomingDependencies().forEach(_function);
    }
    final Function2<XDependency, ArrayList<XEvent>, Boolean> _function_1 = (XDependency k, ArrayList<XEvent> v) -> {
      int _size = v.size();
      return Boolean.valueOf((_size > 1));
    };
    final BiConsumer<XDependency, ArrayList<XEvent>> _function_2 = (XDependency dependency, ArrayList<XEvent> events) -> {
      for (final XEvent event_1 : events) {
        StringConcatenation _builder = new StringConcatenation();
        String _firstUpper = StringExtensions.toFirstUpper(TmscXtextQueries.getType(dependency).getLiteral());
        _builder.append(_firstUpper);
        _builder.append(" ");
        String _name = dependency.getName();
        _builder.append(_name);
        _builder.append(" can be received only once");
        this.error(_builder.toString(), event_1, TmscXtextPackage.Literals.XEVENT__INCOMING_DEPENDENCIES, 
          event_1.getIncomingDependencies().indexOf(dependency), TmscXtextValidator.MULTIPLE_XDEPENDENCY_RECEIVE);
      }
    };
    MapExtensions.<XDependency, ArrayList<XEvent>>filter(receives, _function_1).forEach(_function_2);
  }

  public static final String XDEPENDENCY_TYPE_REPLY_REQUEST = "xDependencyTypeReplyRequest";

  public static final String XDEPENDENCY_REQUEST_TYPE_REQUEST = "xDependencyRequestTypeRequest";

  @Check
  public void checkXDependencyRequestReply(final XDependency dependency) {
    XDependency _request = dependency.getRequest();
    boolean _tripleEquals = (_request == null);
    if (_tripleEquals) {
      return;
    }
    XDependencyType _type = TmscXtextQueries.getType(dependency);
    boolean _notEquals = (!Objects.equals(_type, XDependencyType.REPLY));
    if (_notEquals) {
      this.error("Request is only applicable for a reply", TmscXtextPackage.Literals.XDEPENDENCY__REQUEST, 
        TmscXtextValidator.XDEPENDENCY_TYPE_REPLY_REQUEST);
    }
    XDependencyType _type_1 = TmscXtextQueries.getType(dependency.getRequest());
    boolean _notEquals_1 = (!Objects.equals(_type_1, XDependencyType.REQUEST));
    if (_notEquals_1) {
      this.error("Request should be of type request", TmscXtextPackage.Literals.XDEPENDENCY__REQUEST, 
        TmscXtextValidator.XDEPENDENCY_REQUEST_TYPE_REQUEST);
    }
  }

  public static final String XDEPENDENCY_TYPE_MESSAGE_DETECT_MESSAGE = "xDependencyTypeMessageControlMessage";

  public static final String XDEPENDENCY_MESSAGE_TYPE_MESSAGE = "xDependencyMessageTypeMessage";

  @Check
  public void checkXDependencyMessageControlMessage(final XDependency dependency) {
    XDependency _message = dependency.getMessage();
    boolean _tripleEquals = (_message == null);
    if (_tripleEquals) {
      return;
    }
    XDependencyType _type = TmscXtextQueries.getType(dependency);
    boolean _notEquals = (!Objects.equals(_type, XDependencyType.MESSAGE_CONTROL));
    if (_notEquals) {
      this.error("Message is only applicable for a message-control", TmscXtextPackage.Literals.XDEPENDENCY__MESSAGE, 
        TmscXtextValidator.XDEPENDENCY_TYPE_MESSAGE_DETECT_MESSAGE);
    }
    XDependencyType _type_1 = TmscXtextQueries.getType(dependency.getMessage());
    if (_type_1 != null) {
      switch (_type_1) {
        case DOMAIN:
        case LIFELINE_SEGMENT:
        case MESSAGE_CONTROL:
          this.error("Message should be of type message, request or reply", TmscXtextPackage.Literals.XDEPENDENCY__MESSAGE, 
            TmscXtextValidator.XDEPENDENCY_MESSAGE_TYPE_MESSAGE);
          break;
        default:
          break;
      }
    } else {
    }
  }

  public static final String XFUNCTION_NOT_USED = "xFunctionNotUsed";

  @Check
  public void checkXFunctionNotUsed(final XFunction xFunction) {
    final Function1<XEvent, XFunction> _function = (XEvent it) -> {
      return it.getFunction();
    };
    boolean _contains = ListExtensions.<XEvent, XFunction>map(EcoreUtil2.<TmscXtextModel>getContainerOfType(xFunction, TmscXtextModel.class).getEvents(), _function).contains(xFunction);
    boolean _not = (!_contains);
    if (_not) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Function ");
      String _name = xFunction.getName();
      _builder.append(_name);
      _builder.append(" is not used");
      this.info(_builder.toString(), null, TmscXtextValidator.XFUNCTION_NOT_USED);
    }
  }

  public static final String XCOMPONENT_NOT_USED = "xComponentNotUsed";

  @Check
  public void checkXComponentNotUsed(final XComponent xComponent) {
    final Function1<XEvent, XComponent> _function = (XEvent it) -> {
      return it.getComponent();
    };
    boolean _contains = ListExtensions.<XEvent, XComponent>map(EcoreUtil2.<TmscXtextModel>getContainerOfType(xComponent, TmscXtextModel.class).getEvents(), _function).contains(xComponent);
    boolean _not = (!_contains);
    if (_not) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Component ");
      String _name = xComponent.getName();
      _builder.append(_name);
      _builder.append(" is not used");
      this.info(_builder.toString(), null, TmscXtextValidator.XCOMPONENT_NOT_USED);
    }
  }

  public static final String XFUNCTION_OPERATION = "xFunctionOperation";

  @Check
  public void checkXFunctionOperation(final XFunction xFunction) {
    if (((xFunction.getOperation() == null) && (xFunction.isIpcClient() || xFunction.isIpcServer()))) {
      this.error("Please specify an operation from which this IPC function originates.", 
        TmscXtextPackage.Literals.XFUNCTION__OPERATION, TmscXtextValidator.XFUNCTION_OPERATION);
    }
  }

  public static final String XINTERFACE_NOT_PROVIDED = "xInterfaceNotProvided";

  @Check
  public void checkXInterfaceNotProvided(final XEvent xEvent) {
    final ICompositeNode componentNode = NodeModelUtils.getNode(xEvent.getComponent());
    if ((componentNode == null)) {
      return;
    }
    XOperation _operation = xEvent.getFunction().getOperation();
    EObject _eContainer = null;
    if (_operation!=null) {
      _eContainer=_operation.eContainer();
    }
    final XInterface xInterface = ((XInterface) _eContainer);
    if ((xEvent.getFunction().isIpcServer() && (!xEvent.getComponent().getProvides().contains(xInterface)))) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Component ");
      String _name = xEvent.getComponent().getName();
      _builder.append(_name);
      _builder.append(" does not provide interface ");
      String _name_1 = xInterface.getName();
      _builder.append(_name_1);
      _builder.append(", though it executes ipc-server function ");
      String _name_2 = xEvent.getFunction().getName();
      _builder.append(_name_2);
      this.info(_builder.toString(), 
        TmscXtextPackage.Literals.XEVENT__FUNCTION, TmscXtextValidator.XINTERFACE_NOT_PROVIDED);
    }
  }

  public static final String XINTERFACE_NOT_REQUIRED = "xInterfaceNotRequired";

  @Check
  public void checkXInterfaceNotRequired(final XEvent xEvent) {
    final ICompositeNode componentNode = NodeModelUtils.getNode(xEvent.getComponent());
    if ((componentNode == null)) {
      return;
    }
    XOperation _operation = xEvent.getFunction().getOperation();
    EObject _eContainer = null;
    if (_operation!=null) {
      _eContainer=_operation.eContainer();
    }
    final XInterface xInterface = ((XInterface) _eContainer);
    if ((xEvent.getFunction().isIpcClient() && (!xEvent.getComponent().getRequires().contains(xInterface)))) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Component ");
      String _name = xEvent.getComponent().getName();
      _builder.append(_name);
      _builder.append(" does not require interface ");
      String _name_1 = xInterface.getName();
      _builder.append(_name_1);
      _builder.append(", though it executes ipc-client function ");
      String _name_2 = xEvent.getFunction().getName();
      _builder.append(_name_2);
      this.info(_builder.toString(), 
        TmscXtextPackage.Literals.XEVENT__FUNCTION, TmscXtextValidator.XINTERFACE_NOT_REQUIRED);
    }
  }

  public static final String XEVENT_ARGUMENT_KIND_NOT_EXPECTED = "xEventArgumentKindNotExpected";

  @Check
  public void checkXEventArgumentKindNotExpected(final XEvent xEvent) {
    EnumSet<XFunctionParameterKind> _xifexpression = null;
    XEventType _type = xEvent.getType();
    boolean _equals = Objects.equals(_type, XEventType.ENTRY);
    if (_equals) {
      _xifexpression = EnumSet.<XFunctionParameterKind>of(XFunctionParameterKind.IN, XFunctionParameterKind.IN_OUT);
    } else {
      _xifexpression = EnumSet.<XFunctionParameterKind>of(XFunctionParameterKind.IN_OUT, XFunctionParameterKind.OUT, XFunctionParameterKind.RETURN);
    }
    final EnumSet<XFunctionParameterKind> parameterKinds = _xifexpression;
    final Function1<XEventArgument, Boolean> _function = (XEventArgument it) -> {
      return Boolean.valueOf(parameterKinds.contains(it.getParameter().getKind()));
    };
    final Consumer<XEventArgument> _function_1 = (XEventArgument arg) -> {
      StringConcatenation _builder = new StringConcatenation();
      String _firstUpper = StringExtensions.toFirstUpper(arg.getParameter().getKind().getLiteral());
      _builder.append(_firstUpper);
      _builder.append(" parameter \'");
      String _name = arg.getParameter().getName();
      _builder.append(_name);
      _builder.append("\' is not expected on an ");
      String _lowerCase = xEvent.getType().getName().toLowerCase();
      _builder.append(_lowerCase);
      _builder.append(" event");
      this.warning(_builder.toString(), arg, TmscXtextPackage.Literals.XEVENT_ARGUMENT__PARAMETER, TmscXtextValidator.XEVENT_ARGUMENT_KIND_NOT_EXPECTED);
    };
    IterableExtensions.<XEventArgument>reject(xEvent.getArguments(), _function).forEach(_function_1);
  }

  public static final String XEVENT_ORDER_TIME = "xEventOrderTime";

  public static final String XEVENT_ORDER_CALL_STACK = "xEventOrderCallStack";

  @Check(CheckType.NORMAL)
  public void checkXEventOrder(final TmscXtextModel model) {
    final Function1<XEvent, XExecutor> _function = (XEvent it) -> {
      return it.getExecutor();
    };
    Collection<List<XEvent>> _values = IterableExtensions.<XExecutor, XEvent>groupBy(model.getEvents(), _function).values();
    for (final List<XEvent> executorEvents : _values) {
      {
        final Function2<BigDecimal, XEvent, BigDecimal> _function_1 = (BigDecimal maxTimestamp, XEvent event) -> {
          if ((((maxTimestamp != null) && (event.getTimestamp() != null)) && (event.getTimestamp().compareTo(maxTimestamp) < 0))) {
            this.error("Events should be ordered in time per executor", event, 
              TmscXtextPackage.Literals.XEVENT__TIMESTAMP, TmscXtextValidator.XEVENT_ORDER_TIME);
          }
          BigDecimal _elvis = null;
          BigDecimal _timestamp = event.getTimestamp();
          if (_timestamp != null) {
            _elvis = _timestamp;
          } else {
            _elvis = maxTimestamp;
          }
          return _elvis;
        };
        IterableExtensions.<XEvent, BigDecimal>fold(executorEvents, null, _function_1);
        final Function2<LinkedList<XFunction>, XEvent, LinkedList<XFunction>> _function_2 = (LinkedList<XFunction> callStack, XEvent event) -> {
          XEventType _type = event.getType();
          boolean _equals = Objects.equals(_type, XEventType.ENTRY);
          if (_equals) {
            callStack.push(event.getFunction());
          } else {
            boolean _isEmpty = callStack.isEmpty();
            boolean _not = (!_isEmpty);
            if (_not) {
              final XFunction expectedFunction = callStack.pop();
              XFunction _function_3 = event.getFunction();
              boolean _notEquals = (!Objects.equals(_function_3, expectedFunction));
              if (_notEquals) {
                StringConcatenation _builder = new StringConcatenation();
                _builder.append("Expected exit of function ");
                String _name = expectedFunction.getName();
                _builder.append(_name);
                _builder.append(" on executor ");
                String _name_1 = event.getExecutor().getName();
                _builder.append(_name_1);
                _builder.append(". This is caused by missing events or incorrect ordering of events.");
                this.error(_builder.toString(), event, TmscXtextPackage.Literals.XEVENT__FUNCTION, TmscXtextValidator.XEVENT_ORDER_CALL_STACK, 
                  expectedFunction.getName());
                callStack.clear();
              }
            }
          }
          return callStack;
        };
        IterableExtensions.<XEvent, LinkedList<XFunction>>fold(executorEvents, CollectionLiterals.<XFunction>newLinkedList(), _function_2);
      }
    }
  }

  @Check
  public void checkXRenderingPropertyValue(final XPropertyStringValue propertyValue) {
    final EObject property = propertyValue.eContainer();
    if ((property instanceof XProperty)) {
      String _name = ((XProperty)property).getName();
      boolean _matched = false;
      if (Objects.equals(_name, null)) {
        _matched=true;
        return;
      }
      if (!_matched) {
        if (Objects.equals(_name, RenderingProperties.PROPERTY_PAINT)) {
          _matched=true;
          boolean _startsWith = propertyValue.getValue().startsWith("#");
          if (_startsWith) {
            try {
              RenderingProperties.decodeColor(propertyValue.getValue());
            } catch (final Throwable _t) {
              if (_t instanceof NumberFormatException) {
                final NumberFormatException e = (NumberFormatException)_t;
                String _message = e.getMessage();
                String _plus = ("Cannot parse color: " + _message);
                this.warning(_plus, TmscXtextPackage.Literals.XPROPERTY_STRING_VALUE__VALUE);
              } else {
                throw Exceptions.sneakyThrow(_t);
              }
            }
          } else {
            try {
              Enum.<RenderingPaint>valueOf(RenderingPaint.class, propertyValue.getValue());
            } catch (final Throwable _t) {
              if (_t instanceof IllegalArgumentException) {
                this.warning("Paint not defined, use Ctrl+Space for alternatives.", 
                  TmscXtextPackage.Literals.XPROPERTY_STRING_VALUE__VALUE);
              } else {
                throw Exceptions.sneakyThrow(_t);
              }
            }
          }
        }
      }
      if (!_matched) {
        if (Objects.equals(_name, RenderingProperties.PROPERTY_STROKE)) {
          _matched=true;
          try {
            Enum.<RenderingStroke>valueOf(RenderingStroke.class, propertyValue.getValue());
          } catch (final Throwable _t) {
            if (_t instanceof IllegalArgumentException) {
              this.warning("Stroke not defined, use Ctrl+Space for alternatives.", TmscXtextPackage.Literals.XPROPERTY_STRING_VALUE__VALUE);
            } else {
              throw Exceptions.sneakyThrow(_t);
            }
          }
        }
      }
      if (!_matched) {
        if (Objects.equals(_name, RenderingProperties.PROPERTY_RENDERING_DEPENDENCIES)) {
          _matched=true;
          try {
            Enum.<RenderingDependencies>valueOf(RenderingDependencies.class, propertyValue.getValue());
          } catch (final Throwable _t) {
            if (_t instanceof IllegalArgumentException) {
              this.warning("Value not defined, use Ctrl+Space for alternatives.", TmscXtextPackage.Literals.XPROPERTY_STRING_VALUE__VALUE);
            } else {
              throw Exceptions.sneakyThrow(_t);
            }
          }
        }
      }
      if (!_matched) {
        if (Objects.equals(_name, RenderingProperties.PROPERTY_RENDERING_EXECUTIONS)) {
          _matched=true;
          try {
            Enum.<RenderingExecutions>valueOf(RenderingExecutions.class, propertyValue.getValue());
          } catch (final Throwable _t) {
            if (_t instanceof IllegalArgumentException) {
              this.warning("Value not defined, use Ctrl+Space for alternatives.", TmscXtextPackage.Literals.XPROPERTY_STRING_VALUE__VALUE);
            } else {
              throw Exceptions.sneakyThrow(_t);
            }
          }
        }
      }
    }
  }
}
