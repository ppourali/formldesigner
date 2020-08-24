/**
 */
package uw.cs.watform.forml.forml.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import uw.cs.watform.forml.forml.FormlPackage;
import uw.cs.watform.forml.forml.Guard;
import uw.cs.watform.forml.forml.Priority;
import uw.cs.watform.forml.forml.State;
import uw.cs.watform.forml.forml.Transition;
import uw.cs.watform.forml.forml.Trigger;
import uw.cs.watform.forml.forml.WCAList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uw.cs.watform.forml.forml.impl.TransitionImpl#getName <em>Name</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.impl.TransitionImpl#getPriority <em>Priority</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.impl.TransitionImpl#getSrc <em>Src</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.impl.TransitionImpl#getDst <em>Dst</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.impl.TransitionImpl#getTrig <em>Trig</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.impl.TransitionImpl#getGuard <em>Guard</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.impl.TransitionImpl#getList <em>List</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TransitionImpl extends MinimalEObjectImpl.Container implements Transition
{
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getPriority() <em>Priority</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPriority()
   * @generated
   * @ordered
   */
  protected Priority priority;

  /**
   * The cached value of the '{@link #getSrc() <em>Src</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSrc()
   * @generated
   * @ordered
   */
  protected State src;

  /**
   * The cached value of the '{@link #getDst() <em>Dst</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDst()
   * @generated
   * @ordered
   */
  protected State dst;

  /**
   * The cached value of the '{@link #getTrig() <em>Trig</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTrig()
   * @generated
   * @ordered
   */
  protected Trigger trig;

  /**
   * The cached value of the '{@link #getGuard() <em>Guard</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGuard()
   * @generated
   * @ordered
   */
  protected Guard guard;

  /**
   * The cached value of the '{@link #getList() <em>List</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getList()
   * @generated
   * @ordered
   */
  protected WCAList list;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TransitionImpl()
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
    return FormlPackage.Literals.TRANSITION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FormlPackage.TRANSITION__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Priority getPriority()
  {
    return priority;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPriority(Priority newPriority, NotificationChain msgs)
  {
    Priority oldPriority = priority;
    priority = newPriority;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FormlPackage.TRANSITION__PRIORITY, oldPriority, newPriority);
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
  public void setPriority(Priority newPriority)
  {
    if (newPriority != priority)
    {
      NotificationChain msgs = null;
      if (priority != null)
        msgs = ((InternalEObject)priority).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FormlPackage.TRANSITION__PRIORITY, null, msgs);
      if (newPriority != null)
        msgs = ((InternalEObject)newPriority).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FormlPackage.TRANSITION__PRIORITY, null, msgs);
      msgs = basicSetPriority(newPriority, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FormlPackage.TRANSITION__PRIORITY, newPriority, newPriority));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public State getSrc()
  {
    if (src != null && src.eIsProxy())
    {
      InternalEObject oldSrc = (InternalEObject)src;
      src = (State)eResolveProxy(oldSrc);
      if (src != oldSrc)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, FormlPackage.TRANSITION__SRC, oldSrc, src));
      }
    }
    return src;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public State basicGetSrc()
  {
    return src;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setSrc(State newSrc)
  {
    State oldSrc = src;
    src = newSrc;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FormlPackage.TRANSITION__SRC, oldSrc, src));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public State getDst()
  {
    if (dst != null && dst.eIsProxy())
    {
      InternalEObject oldDst = (InternalEObject)dst;
      dst = (State)eResolveProxy(oldDst);
      if (dst != oldDst)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, FormlPackage.TRANSITION__DST, oldDst, dst));
      }
    }
    return dst;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public State basicGetDst()
  {
    return dst;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setDst(State newDst)
  {
    State oldDst = dst;
    dst = newDst;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FormlPackage.TRANSITION__DST, oldDst, dst));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Trigger getTrig()
  {
    return trig;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTrig(Trigger newTrig, NotificationChain msgs)
  {
    Trigger oldTrig = trig;
    trig = newTrig;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FormlPackage.TRANSITION__TRIG, oldTrig, newTrig);
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
  public void setTrig(Trigger newTrig)
  {
    if (newTrig != trig)
    {
      NotificationChain msgs = null;
      if (trig != null)
        msgs = ((InternalEObject)trig).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FormlPackage.TRANSITION__TRIG, null, msgs);
      if (newTrig != null)
        msgs = ((InternalEObject)newTrig).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FormlPackage.TRANSITION__TRIG, null, msgs);
      msgs = basicSetTrig(newTrig, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FormlPackage.TRANSITION__TRIG, newTrig, newTrig));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Guard getGuard()
  {
    return guard;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetGuard(Guard newGuard, NotificationChain msgs)
  {
    Guard oldGuard = guard;
    guard = newGuard;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FormlPackage.TRANSITION__GUARD, oldGuard, newGuard);
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
  public void setGuard(Guard newGuard)
  {
    if (newGuard != guard)
    {
      NotificationChain msgs = null;
      if (guard != null)
        msgs = ((InternalEObject)guard).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FormlPackage.TRANSITION__GUARD, null, msgs);
      if (newGuard != null)
        msgs = ((InternalEObject)newGuard).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FormlPackage.TRANSITION__GUARD, null, msgs);
      msgs = basicSetGuard(newGuard, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FormlPackage.TRANSITION__GUARD, newGuard, newGuard));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public WCAList getList()
  {
    return list;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetList(WCAList newList, NotificationChain msgs)
  {
    WCAList oldList = list;
    list = newList;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FormlPackage.TRANSITION__LIST, oldList, newList);
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
  public void setList(WCAList newList)
  {
    if (newList != list)
    {
      NotificationChain msgs = null;
      if (list != null)
        msgs = ((InternalEObject)list).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FormlPackage.TRANSITION__LIST, null, msgs);
      if (newList != null)
        msgs = ((InternalEObject)newList).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FormlPackage.TRANSITION__LIST, null, msgs);
      msgs = basicSetList(newList, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FormlPackage.TRANSITION__LIST, newList, newList));
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
      case FormlPackage.TRANSITION__PRIORITY:
        return basicSetPriority(null, msgs);
      case FormlPackage.TRANSITION__TRIG:
        return basicSetTrig(null, msgs);
      case FormlPackage.TRANSITION__GUARD:
        return basicSetGuard(null, msgs);
      case FormlPackage.TRANSITION__LIST:
        return basicSetList(null, msgs);
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
      case FormlPackage.TRANSITION__NAME:
        return getName();
      case FormlPackage.TRANSITION__PRIORITY:
        return getPriority();
      case FormlPackage.TRANSITION__SRC:
        if (resolve) return getSrc();
        return basicGetSrc();
      case FormlPackage.TRANSITION__DST:
        if (resolve) return getDst();
        return basicGetDst();
      case FormlPackage.TRANSITION__TRIG:
        return getTrig();
      case FormlPackage.TRANSITION__GUARD:
        return getGuard();
      case FormlPackage.TRANSITION__LIST:
        return getList();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case FormlPackage.TRANSITION__NAME:
        setName((String)newValue);
        return;
      case FormlPackage.TRANSITION__PRIORITY:
        setPriority((Priority)newValue);
        return;
      case FormlPackage.TRANSITION__SRC:
        setSrc((State)newValue);
        return;
      case FormlPackage.TRANSITION__DST:
        setDst((State)newValue);
        return;
      case FormlPackage.TRANSITION__TRIG:
        setTrig((Trigger)newValue);
        return;
      case FormlPackage.TRANSITION__GUARD:
        setGuard((Guard)newValue);
        return;
      case FormlPackage.TRANSITION__LIST:
        setList((WCAList)newValue);
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
      case FormlPackage.TRANSITION__NAME:
        setName(NAME_EDEFAULT);
        return;
      case FormlPackage.TRANSITION__PRIORITY:
        setPriority((Priority)null);
        return;
      case FormlPackage.TRANSITION__SRC:
        setSrc((State)null);
        return;
      case FormlPackage.TRANSITION__DST:
        setDst((State)null);
        return;
      case FormlPackage.TRANSITION__TRIG:
        setTrig((Trigger)null);
        return;
      case FormlPackage.TRANSITION__GUARD:
        setGuard((Guard)null);
        return;
      case FormlPackage.TRANSITION__LIST:
        setList((WCAList)null);
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
      case FormlPackage.TRANSITION__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case FormlPackage.TRANSITION__PRIORITY:
        return priority != null;
      case FormlPackage.TRANSITION__SRC:
        return src != null;
      case FormlPackage.TRANSITION__DST:
        return dst != null;
      case FormlPackage.TRANSITION__TRIG:
        return trig != null;
      case FormlPackage.TRANSITION__GUARD:
        return guard != null;
      case FormlPackage.TRANSITION__LIST:
        return list != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //TransitionImpl
