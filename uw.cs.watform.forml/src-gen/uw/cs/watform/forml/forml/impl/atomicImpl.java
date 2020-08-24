/**
 */
package uw.cs.watform.forml.forml.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import uw.cs.watform.forml.forml.ExprRef;
import uw.cs.watform.forml.forml.FormlPackage;
import uw.cs.watform.forml.forml.atomic;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>atomic</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uw.cs.watform.forml.forml.impl.atomicImpl#getNone <em>None</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.impl.atomicImpl#getRef <em>Ref</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.impl.atomicImpl#getRefs <em>Refs</em>}</li>
 * </ul>
 *
 * @generated
 */
public class atomicImpl extends MinimalEObjectImpl.Container implements atomic
{
  /**
   * The default value of the '{@link #getNone() <em>None</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNone()
   * @generated
   * @ordered
   */
  protected static final String NONE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getNone() <em>None</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNone()
   * @generated
   * @ordered
   */
  protected String none = NONE_EDEFAULT;

  /**
   * The cached value of the '{@link #getRef() <em>Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRef()
   * @generated
   * @ordered
   */
  protected ExprRef ref;

  /**
   * The cached value of the '{@link #getRefs() <em>Refs</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRefs()
   * @generated
   * @ordered
   */
  protected ExprRef refs;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected atomicImpl()
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
    return FormlPackage.Literals.ATOMIC;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getNone()
  {
    return none;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setNone(String newNone)
  {
    String oldNone = none;
    none = newNone;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FormlPackage.ATOMIC__NONE, oldNone, none));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ExprRef getRef()
  {
    if (ref != null && ref.eIsProxy())
    {
      InternalEObject oldRef = (InternalEObject)ref;
      ref = (ExprRef)eResolveProxy(oldRef);
      if (ref != oldRef)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, FormlPackage.ATOMIC__REF, oldRef, ref));
      }
    }
    return ref;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExprRef basicGetRef()
  {
    return ref;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setRef(ExprRef newRef)
  {
    ExprRef oldRef = ref;
    ref = newRef;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FormlPackage.ATOMIC__REF, oldRef, ref));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ExprRef getRefs()
  {
    if (refs != null && refs.eIsProxy())
    {
      InternalEObject oldRefs = (InternalEObject)refs;
      refs = (ExprRef)eResolveProxy(oldRefs);
      if (refs != oldRefs)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, FormlPackage.ATOMIC__REFS, oldRefs, refs));
      }
    }
    return refs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExprRef basicGetRefs()
  {
    return refs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setRefs(ExprRef newRefs)
  {
    ExprRef oldRefs = refs;
    refs = newRefs;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FormlPackage.ATOMIC__REFS, oldRefs, refs));
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
      case FormlPackage.ATOMIC__NONE:
        return getNone();
      case FormlPackage.ATOMIC__REF:
        if (resolve) return getRef();
        return basicGetRef();
      case FormlPackage.ATOMIC__REFS:
        if (resolve) return getRefs();
        return basicGetRefs();
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
      case FormlPackage.ATOMIC__NONE:
        setNone((String)newValue);
        return;
      case FormlPackage.ATOMIC__REF:
        setRef((ExprRef)newValue);
        return;
      case FormlPackage.ATOMIC__REFS:
        setRefs((ExprRef)newValue);
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
      case FormlPackage.ATOMIC__NONE:
        setNone(NONE_EDEFAULT);
        return;
      case FormlPackage.ATOMIC__REF:
        setRef((ExprRef)null);
        return;
      case FormlPackage.ATOMIC__REFS:
        setRefs((ExprRef)null);
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
      case FormlPackage.ATOMIC__NONE:
        return NONE_EDEFAULT == null ? none != null : !NONE_EDEFAULT.equals(none);
      case FormlPackage.ATOMIC__REF:
        return ref != null;
      case FormlPackage.ATOMIC__REFS:
        return refs != null;
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
    result.append(" (none: ");
    result.append(none);
    result.append(')');
    return result.toString();
  }

} //atomicImpl
