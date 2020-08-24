/**
 */
package uw.cs.watform.forml.forml.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import uw.cs.watform.forml.forml.FormlPackage;
import uw.cs.watform.forml.forml.FragmentType;
import uw.cs.watform.forml.forml.RegionContext;
import uw.cs.watform.forml.forml.StateContext;
import uw.cs.watform.forml.forml.StateMachineContext;
import uw.cs.watform.forml.forml.TranFragment;
import uw.cs.watform.forml.forml.Transition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Fragment Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uw.cs.watform.forml.forml.impl.FragmentTypeImpl#getState <em>State</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.impl.FragmentTypeImpl#getRegion <em>Region</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.impl.FragmentTypeImpl#getFrag <em>Frag</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.impl.FragmentTypeImpl#getStatemachine <em>Statemachine</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.impl.FragmentTypeImpl#getTransitions <em>Transitions</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FragmentTypeImpl extends MinimalEObjectImpl.Container implements FragmentType
{
  /**
   * The cached value of the '{@link #getState() <em>State</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getState()
   * @generated
   * @ordered
   */
  protected StateContext state;

  /**
   * The cached value of the '{@link #getRegion() <em>Region</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRegion()
   * @generated
   * @ordered
   */
  protected RegionContext region;

  /**
   * The cached value of the '{@link #getFrag() <em>Frag</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFrag()
   * @generated
   * @ordered
   */
  protected TranFragment frag;

  /**
   * The cached value of the '{@link #getStatemachine() <em>Statemachine</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStatemachine()
   * @generated
   * @ordered
   */
  protected StateMachineContext statemachine;

  /**
   * The cached value of the '{@link #getTransitions() <em>Transitions</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTransitions()
   * @generated
   * @ordered
   */
  protected EList<Transition> transitions;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected FragmentTypeImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return FormlPackage.Literals.FRAGMENT_TYPE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public StateContext getState()
  {
    return state;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetState(StateContext newState, NotificationChain msgs)
  {
    StateContext oldState = state;
    state = newState;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FormlPackage.FRAGMENT_TYPE__STATE, oldState, newState);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setState(StateContext newState)
  {
    if (newState != state)
    {
      NotificationChain msgs = null;
      if (state != null)
        msgs = ((InternalEObject)state).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FormlPackage.FRAGMENT_TYPE__STATE, null, msgs);
      if (newState != null)
        msgs = ((InternalEObject)newState).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FormlPackage.FRAGMENT_TYPE__STATE, null, msgs);
      msgs = basicSetState(newState, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FormlPackage.FRAGMENT_TYPE__STATE, newState, newState));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public RegionContext getRegion()
  {
    return region;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetRegion(RegionContext newRegion, NotificationChain msgs)
  {
    RegionContext oldRegion = region;
    region = newRegion;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FormlPackage.FRAGMENT_TYPE__REGION, oldRegion, newRegion);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setRegion(RegionContext newRegion)
  {
    if (newRegion != region)
    {
      NotificationChain msgs = null;
      if (region != null)
        msgs = ((InternalEObject)region).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FormlPackage.FRAGMENT_TYPE__REGION, null, msgs);
      if (newRegion != null)
        msgs = ((InternalEObject)newRegion).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FormlPackage.FRAGMENT_TYPE__REGION, null, msgs);
      msgs = basicSetRegion(newRegion, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FormlPackage.FRAGMENT_TYPE__REGION, newRegion, newRegion));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public TranFragment getFrag()
  {
    return frag;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFrag(TranFragment newFrag, NotificationChain msgs)
  {
    TranFragment oldFrag = frag;
    frag = newFrag;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FormlPackage.FRAGMENT_TYPE__FRAG, oldFrag, newFrag);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setFrag(TranFragment newFrag)
  {
    if (newFrag != frag)
    {
      NotificationChain msgs = null;
      if (frag != null)
        msgs = ((InternalEObject)frag).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FormlPackage.FRAGMENT_TYPE__FRAG, null, msgs);
      if (newFrag != null)
        msgs = ((InternalEObject)newFrag).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FormlPackage.FRAGMENT_TYPE__FRAG, null, msgs);
      msgs = basicSetFrag(newFrag, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FormlPackage.FRAGMENT_TYPE__FRAG, newFrag, newFrag));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public StateMachineContext getStatemachine()
  {
    return statemachine;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetStatemachine(StateMachineContext newStatemachine, NotificationChain msgs)
  {
    StateMachineContext oldStatemachine = statemachine;
    statemachine = newStatemachine;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FormlPackage.FRAGMENT_TYPE__STATEMACHINE, oldStatemachine, newStatemachine);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setStatemachine(StateMachineContext newStatemachine)
  {
    if (newStatemachine != statemachine)
    {
      NotificationChain msgs = null;
      if (statemachine != null)
        msgs = ((InternalEObject)statemachine).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FormlPackage.FRAGMENT_TYPE__STATEMACHINE, null, msgs);
      if (newStatemachine != null)
        msgs = ((InternalEObject)newStatemachine).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FormlPackage.FRAGMENT_TYPE__STATEMACHINE, null, msgs);
      msgs = basicSetStatemachine(newStatemachine, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FormlPackage.FRAGMENT_TYPE__STATEMACHINE, newStatemachine, newStatemachine));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Transition> getTransitions()
  {
    if (transitions == null)
    {
      transitions = new EObjectContainmentEList<Transition>(Transition.class, this, FormlPackage.FRAGMENT_TYPE__TRANSITIONS);
    }
    return transitions;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case FormlPackage.FRAGMENT_TYPE__STATE:
        return basicSetState(null, msgs);
      case FormlPackage.FRAGMENT_TYPE__REGION:
        return basicSetRegion(null, msgs);
      case FormlPackage.FRAGMENT_TYPE__FRAG:
        return basicSetFrag(null, msgs);
      case FormlPackage.FRAGMENT_TYPE__STATEMACHINE:
        return basicSetStatemachine(null, msgs);
      case FormlPackage.FRAGMENT_TYPE__TRANSITIONS:
        return ((InternalEList<?>)getTransitions()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case FormlPackage.FRAGMENT_TYPE__STATE:
        return getState();
      case FormlPackage.FRAGMENT_TYPE__REGION:
        return getRegion();
      case FormlPackage.FRAGMENT_TYPE__FRAG:
        return getFrag();
      case FormlPackage.FRAGMENT_TYPE__STATEMACHINE:
        return getStatemachine();
      case FormlPackage.FRAGMENT_TYPE__TRANSITIONS:
        return getTransitions();
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
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case FormlPackage.FRAGMENT_TYPE__STATE:
        setState((StateContext)newValue);
        return;
      case FormlPackage.FRAGMENT_TYPE__REGION:
        setRegion((RegionContext)newValue);
        return;
      case FormlPackage.FRAGMENT_TYPE__FRAG:
        setFrag((TranFragment)newValue);
        return;
      case FormlPackage.FRAGMENT_TYPE__STATEMACHINE:
        setStatemachine((StateMachineContext)newValue);
        return;
      case FormlPackage.FRAGMENT_TYPE__TRANSITIONS:
        getTransitions().clear();
        getTransitions().addAll((Collection<? extends Transition>)newValue);
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
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case FormlPackage.FRAGMENT_TYPE__STATE:
        setState((StateContext)null);
        return;
      case FormlPackage.FRAGMENT_TYPE__REGION:
        setRegion((RegionContext)null);
        return;
      case FormlPackage.FRAGMENT_TYPE__FRAG:
        setFrag((TranFragment)null);
        return;
      case FormlPackage.FRAGMENT_TYPE__STATEMACHINE:
        setStatemachine((StateMachineContext)null);
        return;
      case FormlPackage.FRAGMENT_TYPE__TRANSITIONS:
        getTransitions().clear();
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
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case FormlPackage.FRAGMENT_TYPE__STATE:
        return state != null;
      case FormlPackage.FRAGMENT_TYPE__REGION:
        return region != null;
      case FormlPackage.FRAGMENT_TYPE__FRAG:
        return frag != null;
      case FormlPackage.FRAGMENT_TYPE__STATEMACHINE:
        return statemachine != null;
      case FormlPackage.FRAGMENT_TYPE__TRANSITIONS:
        return transitions != null && !transitions.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //FragmentTypeImpl
