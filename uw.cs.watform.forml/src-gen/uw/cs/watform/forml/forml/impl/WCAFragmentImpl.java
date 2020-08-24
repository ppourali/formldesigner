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
import uw.cs.watform.forml.forml.WCA;
import uw.cs.watform.forml.forml.WCAFragment;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>WCA Fragment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uw.cs.watform.forml.forml.impl.WCAFragmentImpl#getRef <em>Ref</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.impl.WCAFragmentImpl#getFragType <em>Frag Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class WCAFragmentImpl extends MinimalEObjectImpl.Container implements WCAFragment
{
  /**
   * The cached value of the '{@link #getRef() <em>Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRef()
   * @generated
   * @ordered
   */
  protected WCA ref;

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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected WCAFragmentImpl()
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
    return FormlPackage.Literals.WCA_FRAGMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public WCA getRef()
  {
    if (ref != null && ref.eIsProxy())
    {
      InternalEObject oldRef = (InternalEObject)ref;
      ref = (WCA)eResolveProxy(oldRef);
      if (ref != oldRef)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, FormlPackage.WCA_FRAGMENT__REF, oldRef, ref));
      }
    }
    return ref;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public WCA basicGetRef()
  {
    return ref;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setRef(WCA newRef)
  {
    WCA oldRef = ref;
    ref = newRef;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FormlPackage.WCA_FRAGMENT__REF, oldRef, ref));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FormlPackage.WCA_FRAGMENT__FRAG_TYPE, oldFragType, newFragType);
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
        msgs = ((InternalEObject)fragType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FormlPackage.WCA_FRAGMENT__FRAG_TYPE, null, msgs);
      if (newFragType != null)
        msgs = ((InternalEObject)newFragType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FormlPackage.WCA_FRAGMENT__FRAG_TYPE, null, msgs);
      msgs = basicSetFragType(newFragType, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FormlPackage.WCA_FRAGMENT__FRAG_TYPE, newFragType, newFragType));
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
      case FormlPackage.WCA_FRAGMENT__FRAG_TYPE:
        return basicSetFragType(null, msgs);
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
      case FormlPackage.WCA_FRAGMENT__REF:
        if (resolve) return getRef();
        return basicGetRef();
      case FormlPackage.WCA_FRAGMENT__FRAG_TYPE:
        return getFragType();
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
      case FormlPackage.WCA_FRAGMENT__REF:
        setRef((WCA)newValue);
        return;
      case FormlPackage.WCA_FRAGMENT__FRAG_TYPE:
        setFragType((Guard)newValue);
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
      case FormlPackage.WCA_FRAGMENT__REF:
        setRef((WCA)null);
        return;
      case FormlPackage.WCA_FRAGMENT__FRAG_TYPE:
        setFragType((Guard)null);
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
      case FormlPackage.WCA_FRAGMENT__REF:
        return ref != null;
      case FormlPackage.WCA_FRAGMENT__FRAG_TYPE:
        return fragType != null;
    }
    return super.eIsSet(featureID);
  }

} //WCAFragmentImpl
