/**
 */
package uw.cs.watform.forml.forml.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import uw.cs.watform.forml.forml.BehaviourModel;
import uw.cs.watform.forml.forml.FeatureModule;
import uw.cs.watform.forml.forml.FormlPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Behaviour Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uw.cs.watform.forml.forml.impl.BehaviourModelImpl#getFeaturemodules <em>Featuremodules</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BehaviourModelImpl extends MinimalEObjectImpl.Container implements BehaviourModel
{
  /**
   * The cached value of the '{@link #getFeaturemodules() <em>Featuremodules</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFeaturemodules()
   * @generated
   * @ordered
   */
  protected EList<FeatureModule> featuremodules;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected BehaviourModelImpl()
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
    return FormlPackage.Literals.BEHAVIOUR_MODEL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<FeatureModule> getFeaturemodules()
  {
    if (featuremodules == null)
    {
      featuremodules = new EObjectContainmentEList<FeatureModule>(FeatureModule.class, this, FormlPackage.BEHAVIOUR_MODEL__FEATUREMODULES);
    }
    return featuremodules;
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
      case FormlPackage.BEHAVIOUR_MODEL__FEATUREMODULES:
        return ((InternalEList<?>)getFeaturemodules()).basicRemove(otherEnd, msgs);
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
      case FormlPackage.BEHAVIOUR_MODEL__FEATUREMODULES:
        return getFeaturemodules();
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
      case FormlPackage.BEHAVIOUR_MODEL__FEATUREMODULES:
        getFeaturemodules().clear();
        getFeaturemodules().addAll((Collection<? extends FeatureModule>)newValue);
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
      case FormlPackage.BEHAVIOUR_MODEL__FEATUREMODULES:
        getFeaturemodules().clear();
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
      case FormlPackage.BEHAVIOUR_MODEL__FEATUREMODULES:
        return featuremodules != null && !featuremodules.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //BehaviourModelImpl
