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

import uw.cs.watform.forml.forml.FormlPackage;
import uw.cs.watform.forml.forml.basePred;
import uw.cs.watform.forml.forml.orPred;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>or Pred</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uw.cs.watform.forml.forml.impl.orPredImpl#getPreds <em>Preds</em>}</li>
 * </ul>
 *
 * @generated
 */
public class orPredImpl extends MinimalEObjectImpl.Container implements orPred
{
  /**
   * The cached value of the '{@link #getPreds() <em>Preds</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPreds()
   * @generated
   * @ordered
   */
  protected EList<basePred> preds;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected orPredImpl()
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
    return FormlPackage.Literals.OR_PRED;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<basePred> getPreds()
  {
    if (preds == null)
    {
      preds = new EObjectContainmentEList<basePred>(basePred.class, this, FormlPackage.OR_PRED__PREDS);
    }
    return preds;
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
      case FormlPackage.OR_PRED__PREDS:
        return ((InternalEList<?>)getPreds()).basicRemove(otherEnd, msgs);
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
      case FormlPackage.OR_PRED__PREDS:
        return getPreds();
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
      case FormlPackage.OR_PRED__PREDS:
        getPreds().clear();
        getPreds().addAll((Collection<? extends basePred>)newValue);
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
      case FormlPackage.OR_PRED__PREDS:
        getPreds().clear();
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
      case FormlPackage.OR_PRED__PREDS:
        return preds != null && !preds.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //orPredImpl
