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
import uw.cs.watform.forml.forml.TranFragment;
import uw.cs.watform.forml.forml.Transition;
import uw.cs.watform.forml.forml.Trigger;
import uw.cs.watform.forml.forml.WCAFragmentList;
import uw.cs.watform.forml.forml.WCAList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tran Fragment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uw.cs.watform.forml.forml.impl.TranFragmentImpl#getRef <em>Ref</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.impl.TranFragmentImpl#getTrig <em>Trig</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.impl.TranFragmentImpl#getFragType <em>Frag Type</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.impl.TranFragmentImpl#getList <em>List</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.impl.TranFragmentImpl#getFragList <em>Frag List</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TranFragmentImpl extends MinimalEObjectImpl.Container implements TranFragment
{
  /**
   * The cached value of the '{@link #getRef() <em>Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRef()
   * @generated
   * @ordered
   */
  protected Transition ref;

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
   * The cached value of the '{@link #getFragType() <em>Frag Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFragType()
   * @generated
   * @ordered
   */
  protected Guard fragType;

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
   * The cached value of the '{@link #getFragList() <em>Frag List</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFragList()
   * @generated
   * @ordered
   */
  protected WCAFragmentList fragList;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TranFragmentImpl()
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
    return FormlPackage.Literals.TRAN_FRAGMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Transition getRef()
  {
    if (ref != null && ref.eIsProxy())
    {
      InternalEObject oldRef = (InternalEObject)ref;
      ref = (Transition)eResolveProxy(oldRef);
      if (ref != oldRef)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, FormlPackage.TRAN_FRAGMENT__REF, oldRef, ref));
      }
    }
    return ref;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Transition basicGetRef()
  {
    return ref;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setRef(Transition newRef)
  {
    Transition oldRef = ref;
    ref = newRef;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FormlPackage.TRAN_FRAGMENT__REF, oldRef, ref));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FormlPackage.TRAN_FRAGMENT__TRIG, oldTrig, newTrig);
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
        msgs = ((InternalEObject)trig).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FormlPackage.TRAN_FRAGMENT__TRIG, null, msgs);
      if (newTrig != null)
        msgs = ((InternalEObject)newTrig).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FormlPackage.TRAN_FRAGMENT__TRIG, null, msgs);
      msgs = basicSetTrig(newTrig, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FormlPackage.TRAN_FRAGMENT__TRIG, newTrig, newTrig));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Guard getFragType()
  {
    return fragType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFragType(Guard newFragType, NotificationChain msgs)
  {
    Guard oldFragType = fragType;
    fragType = newFragType;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FormlPackage.TRAN_FRAGMENT__FRAG_TYPE, oldFragType, newFragType);
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
  public void setFragType(Guard newFragType)
  {
    if (newFragType != fragType)
    {
      NotificationChain msgs = null;
      if (fragType != null)
        msgs = ((InternalEObject)fragType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FormlPackage.TRAN_FRAGMENT__FRAG_TYPE, null, msgs);
      if (newFragType != null)
        msgs = ((InternalEObject)newFragType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FormlPackage.TRAN_FRAGMENT__FRAG_TYPE, null, msgs);
      msgs = basicSetFragType(newFragType, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FormlPackage.TRAN_FRAGMENT__FRAG_TYPE, newFragType, newFragType));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FormlPackage.TRAN_FRAGMENT__LIST, oldList, newList);
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
        msgs = ((InternalEObject)list).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FormlPackage.TRAN_FRAGMENT__LIST, null, msgs);
      if (newList != null)
        msgs = ((InternalEObject)newList).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FormlPackage.TRAN_FRAGMENT__LIST, null, msgs);
      msgs = basicSetList(newList, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FormlPackage.TRAN_FRAGMENT__LIST, newList, newList));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public WCAFragmentList getFragList()
  {
    return fragList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFragList(WCAFragmentList newFragList, NotificationChain msgs)
  {
    WCAFragmentList oldFragList = fragList;
    fragList = newFragList;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FormlPackage.TRAN_FRAGMENT__FRAG_LIST, oldFragList, newFragList);
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
  public void setFragList(WCAFragmentList newFragList)
  {
    if (newFragList != fragList)
    {
      NotificationChain msgs = null;
      if (fragList != null)
        msgs = ((InternalEObject)fragList).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FormlPackage.TRAN_FRAGMENT__FRAG_LIST, null, msgs);
      if (newFragList != null)
        msgs = ((InternalEObject)newFragList).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FormlPackage.TRAN_FRAGMENT__FRAG_LIST, null, msgs);
      msgs = basicSetFragList(newFragList, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FormlPackage.TRAN_FRAGMENT__FRAG_LIST, newFragList, newFragList));
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
      case FormlPackage.TRAN_FRAGMENT__TRIG:
        return basicSetTrig(null, msgs);
      case FormlPackage.TRAN_FRAGMENT__FRAG_TYPE:
        return basicSetFragType(null, msgs);
      case FormlPackage.TRAN_FRAGMENT__LIST:
        return basicSetList(null, msgs);
      case FormlPackage.TRAN_FRAGMENT__FRAG_LIST:
        return basicSetFragList(null, msgs);
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
      case FormlPackage.TRAN_FRAGMENT__REF:
        if (resolve) return getRef();
        return basicGetRef();
      case FormlPackage.TRAN_FRAGMENT__TRIG:
        return getTrig();
      case FormlPackage.TRAN_FRAGMENT__FRAG_TYPE:
        return getFragType();
      case FormlPackage.TRAN_FRAGMENT__LIST:
        return getList();
      case FormlPackage.TRAN_FRAGMENT__FRAG_LIST:
        return getFragList();
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
      case FormlPackage.TRAN_FRAGMENT__REF:
        setRef((Transition)newValue);
        return;
      case FormlPackage.TRAN_FRAGMENT__TRIG:
        setTrig((Trigger)newValue);
        return;
      case FormlPackage.TRAN_FRAGMENT__FRAG_TYPE:
        setFragType((Guard)newValue);
        return;
      case FormlPackage.TRAN_FRAGMENT__LIST:
        setList((WCAList)newValue);
        return;
      case FormlPackage.TRAN_FRAGMENT__FRAG_LIST:
        setFragList((WCAFragmentList)newValue);
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
      case FormlPackage.TRAN_FRAGMENT__REF:
        setRef((Transition)null);
        return;
      case FormlPackage.TRAN_FRAGMENT__TRIG:
        setTrig((Trigger)null);
        return;
      case FormlPackage.TRAN_FRAGMENT__FRAG_TYPE:
        setFragType((Guard)null);
        return;
      case FormlPackage.TRAN_FRAGMENT__LIST:
        setList((WCAList)null);
        return;
      case FormlPackage.TRAN_FRAGMENT__FRAG_LIST:
        setFragList((WCAFragmentList)null);
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
      case FormlPackage.TRAN_FRAGMENT__REF:
        return ref != null;
      case FormlPackage.TRAN_FRAGMENT__TRIG:
        return trig != null;
      case FormlPackage.TRAN_FRAGMENT__FRAG_TYPE:
        return fragType != null;
      case FormlPackage.TRAN_FRAGMENT__LIST:
        return list != null;
      case FormlPackage.TRAN_FRAGMENT__FRAG_LIST:
        return fragList != null;
    }
    return super.eIsSet(featureID);
  }

} //TranFragmentImpl
