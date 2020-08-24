/**
 */
package uw.cs.watform.forml.forml.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import uw.cs.watform.forml.forml.FormlPackage;
import uw.cs.watform.forml.forml.InitState;
import uw.cs.watform.forml.forml.State;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Init State</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uw.cs.watform.forml.forml.impl.InitStateImpl#getStateref <em>Stateref</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InitStateImpl extends MinimalEObjectImpl.Container implements InitState
{
  /**
   * The cached value of the '{@link #getStateref() <em>Stateref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStateref()
   * @generated
   * @ordered
   */
  protected State stateref;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected InitStateImpl()
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
    return FormlPackage.Literals.INIT_STATE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public State getStateref()
  {
    if (stateref != null && stateref.eIsProxy())
    {
      InternalEObject oldStateref = (InternalEObject)stateref;
      stateref = (State)eResolveProxy(oldStateref);
      if (stateref != oldStateref)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, FormlPackage.INIT_STATE__STATEREF, oldStateref, stateref));
      }
    }
    return stateref;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public State basicGetStateref()
  {
    return stateref;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setStateref(State newStateref)
  {
    State oldStateref = stateref;
    stateref = newStateref;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FormlPackage.INIT_STATE__STATEREF, oldStateref, stateref));
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
      case FormlPackage.INIT_STATE__STATEREF:
        if (resolve) return getStateref();
        return basicGetStateref();
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
      case FormlPackage.INIT_STATE__STATEREF:
        setStateref((State)newValue);
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
      case FormlPackage.INIT_STATE__STATEREF:
        setStateref((State)null);
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
      case FormlPackage.INIT_STATE__STATEREF:
        return stateref != null;
    }
    return super.eIsSet(featureID);
  }

} //InitStateImpl
