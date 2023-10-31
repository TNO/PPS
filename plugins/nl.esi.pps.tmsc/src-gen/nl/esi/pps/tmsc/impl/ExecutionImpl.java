/**
 */
package nl.esi.pps.tmsc.impl;

import java.util.Collection;

import nl.esi.emf.properties.impl.PropertiesContainerImpl;

import nl.esi.pps.architecture.implemented.Function;

import nl.esi.pps.architecture.specified.Component;

import nl.esi.pps.tmsc.EntryEvent;
import nl.esi.pps.tmsc.Execution;
import nl.esi.pps.tmsc.ExitEvent;
import nl.esi.pps.tmsc.FullScopeTMSC;
import nl.esi.pps.tmsc.Lifeline;
import nl.esi.pps.tmsc.LifelineSegment;
import nl.esi.pps.tmsc.TmscPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Execution</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link nl.esi.pps.tmsc.impl.ExecutionImpl#getLifeline <em>Lifeline</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.impl.ExecutionImpl#getEntry <em>Entry</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.impl.ExecutionImpl#getChildren <em>Children</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.impl.ExecutionImpl#getExit <em>Exit</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.impl.ExecutionImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.impl.ExecutionImpl#getRoot <em>Root</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.impl.ExecutionImpl#getComponent <em>Component</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.impl.ExecutionImpl#getFunction <em>Function</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.impl.ExecutionImpl#getSegments <em>Segments</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.impl.ExecutionImpl#getStartTime <em>Start Time</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.impl.ExecutionImpl#getEndTime <em>End Time</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.impl.ExecutionImpl#getDuration <em>Duration</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.impl.ExecutionImpl#getTmsc <em>Tmsc</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ExecutionImpl extends PropertiesContainerImpl implements Execution {
	/**
	 * The cached value of the '{@link #getEntry() <em>Entry</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntry()
	 * @generated
	 * @ordered
	 */
	protected EntryEvent entry;

	/**
	 * The cached value of the '{@link #getChildren() <em>Children</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildren()
	 * @generated
	 * @ordered
	 */
	protected EList<Execution> children;

	/**
	 * The cached value of the '{@link #getExit() <em>Exit</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExit()
	 * @generated
	 * @ordered
	 */
	protected ExitEvent exit;

	/**
	 * The cached value of the '{@link #getParent() <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParent()
	 * @generated
	 * @ordered
	 */
	protected Execution parent;

	/**
	 * The default value of the '{@link #getStartTime() <em>Start Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartTime()
	 * @generated
	 * @ordered
	 */
	protected static final Long START_TIME_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getEndTime() <em>End Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndTime()
	 * @generated
	 * @ordered
	 */
	protected static final Long END_TIME_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getDuration() <em>Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDuration()
	 * @generated
	 * @ordered
	 */
	protected static final Long DURATION_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExecutionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TmscPackage.Literals.EXECUTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Lifeline getLifeline() {
		if (eContainerFeatureID() != TmscPackage.EXECUTION__LIFELINE)
			return null;
		return (Lifeline) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLifeline(Lifeline newLifeline, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newLifeline, TmscPackage.EXECUTION__LIFELINE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLifeline(Lifeline newLifeline) {
		if (newLifeline != eInternalContainer()
				|| (eContainerFeatureID() != TmscPackage.EXECUTION__LIFELINE && newLifeline != null)) {
			if (EcoreUtil.isAncestor(this, newLifeline))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newLifeline != null)
				msgs = ((InternalEObject) newLifeline).eInverseAdd(this, TmscPackage.LIFELINE__EXECUTIONS,
						Lifeline.class, msgs);
			msgs = basicSetLifeline(newLifeline, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TmscPackage.EXECUTION__LIFELINE, newLifeline,
					newLifeline));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EntryEvent getEntry() {
		return entry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEntry(EntryEvent newEntry, NotificationChain msgs) {
		EntryEvent oldEntry = entry;
		entry = newEntry;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TmscPackage.EXECUTION__ENTRY,
					oldEntry, newEntry);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEntry(EntryEvent newEntry) {
		if (newEntry != entry) {
			NotificationChain msgs = null;
			if (entry != null)
				msgs = ((InternalEObject) entry).eInverseRemove(this, TmscPackage.ENTRY_EVENT__EXECUTION,
						EntryEvent.class, msgs);
			if (newEntry != null)
				msgs = ((InternalEObject) newEntry).eInverseAdd(this, TmscPackage.ENTRY_EVENT__EXECUTION,
						EntryEvent.class, msgs);
			msgs = basicSetEntry(newEntry, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TmscPackage.EXECUTION__ENTRY, newEntry, newEntry));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Execution> getChildren() {
		if (children == null) {
			children = new EObjectWithInverseEList<Execution>(Execution.class, this, TmscPackage.EXECUTION__CHILDREN,
					TmscPackage.EXECUTION__PARENT);
		}
		return children;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ExitEvent getExit() {
		return exit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExit(ExitEvent newExit, NotificationChain msgs) {
		ExitEvent oldExit = exit;
		exit = newExit;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TmscPackage.EXECUTION__EXIT,
					oldExit, newExit);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setExit(ExitEvent newExit) {
		if (newExit != exit) {
			NotificationChain msgs = null;
			if (exit != null)
				msgs = ((InternalEObject) exit).eInverseRemove(this, TmscPackage.EXIT_EVENT__EXECUTION, ExitEvent.class,
						msgs);
			if (newExit != null)
				msgs = ((InternalEObject) newExit).eInverseAdd(this, TmscPackage.EXIT_EVENT__EXECUTION, ExitEvent.class,
						msgs);
			msgs = basicSetExit(newExit, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TmscPackage.EXECUTION__EXIT, newExit, newExit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Execution getParent() {
		return parent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParent(Execution newParent, NotificationChain msgs) {
		Execution oldParent = parent;
		parent = newParent;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					TmscPackage.EXECUTION__PARENT, oldParent, newParent);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setParent(Execution newParent) {
		if (newParent != parent) {
			NotificationChain msgs = null;
			if (parent != null)
				msgs = ((InternalEObject) parent).eInverseRemove(this, TmscPackage.EXECUTION__CHILDREN, Execution.class,
						msgs);
			if (newParent != null)
				msgs = ((InternalEObject) newParent).eInverseAdd(this, TmscPackage.EXECUTION__CHILDREN, Execution.class,
						msgs);
			msgs = basicSetParent(newParent, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TmscPackage.EXECUTION__PARENT, newParent, newParent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Execution getRoot() {
		return TmscImplQueries.getRootImpl(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Component getComponent() {
		return TmscImplQueries.getComponentImpl(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Function getFunction() {
		return TmscImplQueries.getFunctionImpl(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<LifelineSegment> getSegments() {
		return DerivedUtil.derivedEReference(this, TmscPackage.EXECUTION__SEGMENTS, TmscImplQueries::getSegmentsImpl);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Long getStartTime() {
		return TmscImplQueries.getStartTimeImpl(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Long getEndTime() {
		return TmscImplQueries.getEndTimeImpl(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Long getDuration() {
		final Long startTime = getStartTime();
		if (startTime == null) {
			return null;
		}
		final Long endTime = getEndTime();
		if (endTime == null) {
			return null;
		}
		return endTime - startTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FullScopeTMSC getTmsc() {
		return TmscImplQueries.getTmscImpl(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case TmscPackage.EXECUTION__LIFELINE:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetLifeline((Lifeline) otherEnd, msgs);
		case TmscPackage.EXECUTION__ENTRY:
			if (entry != null)
				msgs = ((InternalEObject) entry).eInverseRemove(this, TmscPackage.ENTRY_EVENT__EXECUTION,
						EntryEvent.class, msgs);
			return basicSetEntry((EntryEvent) otherEnd, msgs);
		case TmscPackage.EXECUTION__CHILDREN:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getChildren()).basicAdd(otherEnd, msgs);
		case TmscPackage.EXECUTION__EXIT:
			if (exit != null)
				msgs = ((InternalEObject) exit).eInverseRemove(this, TmscPackage.EXIT_EVENT__EXECUTION, ExitEvent.class,
						msgs);
			return basicSetExit((ExitEvent) otherEnd, msgs);
		case TmscPackage.EXECUTION__PARENT:
			if (parent != null)
				msgs = ((InternalEObject) parent).eInverseRemove(this, TmscPackage.EXECUTION__CHILDREN, Execution.class,
						msgs);
			return basicSetParent((Execution) otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case TmscPackage.EXECUTION__LIFELINE:
			return basicSetLifeline(null, msgs);
		case TmscPackage.EXECUTION__ENTRY:
			return basicSetEntry(null, msgs);
		case TmscPackage.EXECUTION__CHILDREN:
			return ((InternalEList<?>) getChildren()).basicRemove(otherEnd, msgs);
		case TmscPackage.EXECUTION__EXIT:
			return basicSetExit(null, msgs);
		case TmscPackage.EXECUTION__PARENT:
			return basicSetParent(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
		case TmscPackage.EXECUTION__LIFELINE:
			return eInternalContainer().eInverseRemove(this, TmscPackage.LIFELINE__EXECUTIONS, Lifeline.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case TmscPackage.EXECUTION__LIFELINE:
			return getLifeline();
		case TmscPackage.EXECUTION__ENTRY:
			return getEntry();
		case TmscPackage.EXECUTION__CHILDREN:
			return getChildren();
		case TmscPackage.EXECUTION__EXIT:
			return getExit();
		case TmscPackage.EXECUTION__PARENT:
			return getParent();
		case TmscPackage.EXECUTION__ROOT:
			return getRoot();
		case TmscPackage.EXECUTION__COMPONENT:
			return getComponent();
		case TmscPackage.EXECUTION__FUNCTION:
			return getFunction();
		case TmscPackage.EXECUTION__SEGMENTS:
			return getSegments();
		case TmscPackage.EXECUTION__START_TIME:
			return getStartTime();
		case TmscPackage.EXECUTION__END_TIME:
			return getEndTime();
		case TmscPackage.EXECUTION__DURATION:
			return getDuration();
		case TmscPackage.EXECUTION__TMSC:
			return getTmsc();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case TmscPackage.EXECUTION__LIFELINE:
			setLifeline((Lifeline) newValue);
			return;
		case TmscPackage.EXECUTION__ENTRY:
			setEntry((EntryEvent) newValue);
			return;
		case TmscPackage.EXECUTION__CHILDREN:
			getChildren().clear();
			getChildren().addAll((Collection<? extends Execution>) newValue);
			return;
		case TmscPackage.EXECUTION__EXIT:
			setExit((ExitEvent) newValue);
			return;
		case TmscPackage.EXECUTION__PARENT:
			setParent((Execution) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case TmscPackage.EXECUTION__LIFELINE:
			setLifeline((Lifeline) null);
			return;
		case TmscPackage.EXECUTION__ENTRY:
			setEntry((EntryEvent) null);
			return;
		case TmscPackage.EXECUTION__CHILDREN:
			getChildren().clear();
			return;
		case TmscPackage.EXECUTION__EXIT:
			setExit((ExitEvent) null);
			return;
		case TmscPackage.EXECUTION__PARENT:
			setParent((Execution) null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case TmscPackage.EXECUTION__LIFELINE:
			return getLifeline() != null;
		case TmscPackage.EXECUTION__ENTRY:
			return entry != null;
		case TmscPackage.EXECUTION__CHILDREN:
			return children != null && !children.isEmpty();
		case TmscPackage.EXECUTION__EXIT:
			return exit != null;
		case TmscPackage.EXECUTION__PARENT:
			return parent != null;
		case TmscPackage.EXECUTION__ROOT:
			return getRoot() != null;
		case TmscPackage.EXECUTION__COMPONENT:
			return getComponent() != null;
		case TmscPackage.EXECUTION__FUNCTION:
			return getFunction() != null;
		case TmscPackage.EXECUTION__SEGMENTS:
			return !getSegments().isEmpty();
		case TmscPackage.EXECUTION__START_TIME:
			return START_TIME_EDEFAULT == null ? getStartTime() != null : !START_TIME_EDEFAULT.equals(getStartTime());
		case TmscPackage.EXECUTION__END_TIME:
			return END_TIME_EDEFAULT == null ? getEndTime() != null : !END_TIME_EDEFAULT.equals(getEndTime());
		case TmscPackage.EXECUTION__DURATION:
			return DURATION_EDEFAULT == null ? getDuration() != null : !DURATION_EDEFAULT.equals(getDuration());
		case TmscPackage.EXECUTION__TMSC:
			return getTmsc() != null;
		}
		return super.eIsSet(featureID);
	}

} //ExecutionImpl
