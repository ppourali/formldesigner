/**
 */
package uw.cs.watform.forml.forml.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import uw.cs.watform.forml.forml.FormlPackage;
import uw.cs.watform.forml.forml.Transition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Override</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uw.cs.watform.forml.forml.impl.OverrideImpl#getTransition <em>Transition</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OverrideImpl extends MinimalEObjectImpl.Container implements uw.cs.watform.forml.forml.Override
{
  /**
   * The cached value of the '{@link #getTransition() <em>Transition</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTransition()
   * @generated
   * @ordered
   */
  protected Transition transition;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected OverrideImpl()
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
    return FormlPackage.Literals.OVERRIDE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Transition getTransition()
  {
    if (transition != null && transition.eIsProxy())
    {
      InternalEObject oldTransition = (InternalEObject)transition;
      transition = (Transition)eResolveProxy(oldTransition);
      if (transition != oldTransition)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, FormlPackage.OVERRIDE__TRANSITION, oldTransition, transition));
      }
    }
    return transition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Transition basicGetTransition()
  {
    return transition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setTransition(Transition newTransition)
  {
    Transition oldTransition = transition;
    transition = newTransition;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FormlPackage.OVERRIDE__TRANSITION, oldTransition, transition));
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
      case FormlPackage.OVERRIDE__TRANSITION:
        if (resolve) return getTransition();
        return basicGetTransition();
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
      case FormlPackage.OVERRIDE__TRANSITION:
        setTransition((Transition)newValue);
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
      case FormlPackage.OVERRIDE__TRANSITION:
        setTransition((Transition)null);
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
      case FormlPackage.OVERRIDE__TRANSITION:
        return transition != null;
    }
    return super.eIsSet(featureID);
  }

} //OverrideImpl
