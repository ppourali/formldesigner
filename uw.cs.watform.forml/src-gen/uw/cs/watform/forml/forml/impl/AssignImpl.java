/**
 */
package uw.cs.watform.forml.forml.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import uw.cs.watform.forml.forml.Assign;
import uw.cs.watform.forml.forml.ExprRef;
import uw.cs.watform.forml.forml.FormlPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Assign</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uw.cs.watform.forml.forml.impl.AssignImpl#getRef <em>Ref</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.impl.AssignImpl#getSexpr <em>Sexpr</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AssignImpl extends MinimalEObjectImpl.Container implements Assign
{
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
   * The cached value of the '{@link #getSexpr() <em>Sexpr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSexpr()
   * @generated
   * @ordered
   */
  protected EObject sexpr;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AssignImpl()
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
    return FormlPackage.Literals.ASSIGN;
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
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, FormlPackage.ASSIGN__REF, oldRef, ref));
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
      eNotify(new ENotificationImpl(this, Notification.SET, FormlPackage.ASSIGN__REF, oldRef, ref));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject getSexpr()
  {
    return sexpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSexpr(EObject newSexpr, NotificationChain msgs)
  {
    EObject oldSexpr = sexpr;
    sexpr = newSexpr;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FormlPackage.ASSIGN__SEXPR, oldSexpr, newSexpr);
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
  public void setSexpr(EObject newSexpr)
  {
    if (newSexpr != sexpr)
    {
      NotificationChain msgs = null;
      if (sexpr != null)
        msgs = ((InternalEObject)sexpr).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FormlPackage.ASSIGN__SEXPR, null, msgs);
      if (newSexpr != null)
        msgs = ((InternalEObject)newSexpr).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FormlPackage.ASSIGN__SEXPR, null, msgs);
      msgs = basicSetSexpr(newSexpr, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FormlPackage.ASSIGN__SEXPR, newSexpr, newSexpr));
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
      case FormlPackage.ASSIGN__SEXPR:
        return basicSetSexpr(null, msgs);
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
      case FormlPackage.ASSIGN__REF:
        if (resolve) return getRef();
        return basicGetRef();
      case FormlPackage.ASSIGN__SEXPR:
        return getSexpr();
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
      case FormlPackage.ASSIGN__REF:
        setRef((ExprRef)newValue);
        return;
      case FormlPackage.ASSIGN__SEXPR:
        setSexpr((EObject)newValue);
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
      case FormlPackage.ASSIGN__REF:
        setRef((ExprRef)null);
        return;
      case FormlPackage.ASSIGN__SEXPR:
        setSexpr((EObject)null);
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
      case FormlPackage.ASSIGN__REF:
        return ref != null;
      case FormlPackage.ASSIGN__SEXPR:
        return sexpr != null;
    }
    return super.eIsSet(featureID);
  }

} //AssignImpl
