/**
 */
package nl.esi.pps.tmsc.provider;

import java.util.ArrayList;
import java.util.Collection;

import nl.esi.pps.tmsc.util.TmscAdapterFactory;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class TmscItemProviderAdapterFactory extends TmscAdapterFactory
		implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
	/**
	 * This keeps track of the root adapter factory that delegates to this adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<Object> supportedTypes = new ArrayList<Object>();

	/**
	 * This constructs an instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TmscItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link nl.esi.pps.tmsc.FullScopeTMSC} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FullScopeTMSCItemProvider fullScopeTMSCItemProvider;

	/**
	 * This creates an adapter for a {@link nl.esi.pps.tmsc.FullScopeTMSC}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createFullScopeTMSCAdapter() {
		if (fullScopeTMSCItemProvider == null) {
			fullScopeTMSCItemProvider = new FullScopeTMSCItemProvider(this);
		}

		return fullScopeTMSCItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link nl.esi.pps.tmsc.Execution} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExecutionItemProvider executionItemProvider;

	/**
	 * This creates an adapter for a {@link nl.esi.pps.tmsc.Execution}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createExecutionAdapter() {
		if (executionItemProvider == null) {
			executionItemProvider = new ExecutionItemProvider(this);
		}

		return executionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link nl.esi.pps.tmsc.Message} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MessageItemProvider messageItemProvider;

	/**
	 * This creates an adapter for a {@link nl.esi.pps.tmsc.Message}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createMessageAdapter() {
		if (messageItemProvider == null) {
			messageItemProvider = new MessageItemProvider(this);
		}

		return messageItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link nl.esi.pps.tmsc.Request} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RequestItemProvider requestItemProvider;

	/**
	 * This creates an adapter for a {@link nl.esi.pps.tmsc.Request}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createRequestAdapter() {
		if (requestItemProvider == null) {
			requestItemProvider = new RequestItemProvider(this);
		}

		return requestItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link nl.esi.pps.tmsc.Reply} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReplyItemProvider replyItemProvider;

	/**
	 * This creates an adapter for a {@link nl.esi.pps.tmsc.Reply}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createReplyAdapter() {
		if (replyItemProvider == null) {
			replyItemProvider = new ReplyItemProvider(this);
		}

		return replyItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link nl.esi.pps.tmsc.ScopedTMSC} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ScopedTMSCItemProvider scopedTMSCItemProvider;

	/**
	 * This creates an adapter for a {@link nl.esi.pps.tmsc.ScopedTMSC}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createScopedTMSCAdapter() {
		if (scopedTMSCItemProvider == null) {
			scopedTMSCItemProvider = new ScopedTMSCItemProvider(this);
		}

		return scopedTMSCItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link nl.esi.pps.tmsc.DomainDependency} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DomainDependencyItemProvider domainDependencyItemProvider;

	/**
	 * This creates an adapter for a {@link nl.esi.pps.tmsc.DomainDependency}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDomainDependencyAdapter() {
		if (domainDependencyItemProvider == null) {
			domainDependencyItemProvider = new DomainDependencyItemProvider(this);
		}

		return domainDependencyItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link nl.esi.pps.tmsc.Lifeline} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LifelineItemProvider lifelineItemProvider;

	/**
	 * This creates an adapter for a {@link nl.esi.pps.tmsc.Lifeline}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createLifelineAdapter() {
		if (lifelineItemProvider == null) {
			lifelineItemProvider = new LifelineItemProvider(this);
		}

		return lifelineItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link nl.esi.pps.tmsc.LifelineSegment} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LifelineSegmentItemProvider lifelineSegmentItemProvider;

	/**
	 * This creates an adapter for a {@link nl.esi.pps.tmsc.LifelineSegment}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createLifelineSegmentAdapter() {
		if (lifelineSegmentItemProvider == null) {
			lifelineSegmentItemProvider = new LifelineSegmentItemProvider(this);
		}

		return lifelineSegmentItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link nl.esi.pps.tmsc.MessageControl} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MessageControlItemProvider messageControlItemProvider;

	/**
	 * This creates an adapter for a {@link nl.esi.pps.tmsc.MessageControl}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createMessageControlAdapter() {
		if (messageControlItemProvider == null) {
			messageControlItemProvider = new MessageControlItemProvider(this);
		}

		return messageControlItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link java.util.Map.Entry} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FunctionArgumentMapEntryItemProvider functionArgumentMapEntryItemProvider;

	/**
	 * This creates an adapter for a {@link java.util.Map.Entry}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createFunctionArgumentMapEntryAdapter() {
		if (functionArgumentMapEntryItemProvider == null) {
			functionArgumentMapEntryItemProvider = new FunctionArgumentMapEntryItemProvider(this);
		}

		return functionArgumentMapEntryItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link nl.esi.pps.tmsc.Measurement} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MeasurementItemProvider measurementItemProvider;

	/**
	 * This creates an adapter for a {@link nl.esi.pps.tmsc.Measurement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createMeasurementAdapter() {
		if (measurementItemProvider == null) {
			measurementItemProvider = new MeasurementItemProvider(this);
		}

		return measurementItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link nl.esi.pps.tmsc.EntryEvent} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EntryEventItemProvider entryEventItemProvider;

	/**
	 * This creates an adapter for a {@link nl.esi.pps.tmsc.EntryEvent}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEntryEventAdapter() {
		if (entryEventItemProvider == null) {
			entryEventItemProvider = new EntryEventItemProvider(this);
		}

		return entryEventItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link nl.esi.pps.tmsc.ExitEvent} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExitEventItemProvider exitEventItemProvider;

	/**
	 * This creates an adapter for a {@link nl.esi.pps.tmsc.ExitEvent}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createExitEventAdapter() {
		if (exitEventItemProvider == null) {
			exitEventItemProvider = new ExitEventItemProvider(this);
		}

		return exitEventItemProvider;
	}

	/**
	 * This returns the root adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ComposeableAdapterFactory getRootAdapterFactory() {
		return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
	}

	/**
	 * This sets the composed adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
		this.parentAdapterFactory = parentAdapterFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object type) {
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter adapt(Notifier notifier, Object type) {
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object adapt(Object object, Object type) {
		if (isFactoryForType(type)) {
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class<?>) || (((Class<?>) type).isInstance(adapter))) {
				return adapter;
			}
		}

		return null;
	}

	/**
	 * This adds a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void addListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This removes a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void removeListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void fireNotifyChanged(Notification notification) {
		changeNotifier.fireNotifyChanged(notification);

		if (parentAdapterFactory != null) {
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * This disposes all of the item providers created by this factory. 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void dispose() {
		if (fullScopeTMSCItemProvider != null)
			fullScopeTMSCItemProvider.dispose();
		if (executionItemProvider != null)
			executionItemProvider.dispose();
		if (messageItemProvider != null)
			messageItemProvider.dispose();
		if (requestItemProvider != null)
			requestItemProvider.dispose();
		if (replyItemProvider != null)
			replyItemProvider.dispose();
		if (scopedTMSCItemProvider != null)
			scopedTMSCItemProvider.dispose();
		if (domainDependencyItemProvider != null)
			domainDependencyItemProvider.dispose();
		if (lifelineItemProvider != null)
			lifelineItemProvider.dispose();
		if (lifelineSegmentItemProvider != null)
			lifelineSegmentItemProvider.dispose();
		if (messageControlItemProvider != null)
			messageControlItemProvider.dispose();
		if (functionArgumentMapEntryItemProvider != null)
			functionArgumentMapEntryItemProvider.dispose();
		if (measurementItemProvider != null)
			measurementItemProvider.dispose();
		if (entryEventItemProvider != null)
			entryEventItemProvider.dispose();
		if (exitEventItemProvider != null)
			exitEventItemProvider.dispose();
	}

}
