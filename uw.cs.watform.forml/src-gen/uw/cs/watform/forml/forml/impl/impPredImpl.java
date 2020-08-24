/**
 */
package uw.cs.watform.forml.forml.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import uw.cs.watform.forml.forml.FormlPackage;
import uw.cs.watform.forml.forml.impPred;
import uw.cs.watform.forml.forml.orPred;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>imp Pred</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uw.cs.watform.forml.forml.impl.impPredImpl#getPreds <em>Preds</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.impl.impPredImpl#getLogicop <em>Logicop</em>}</li>
 * </ul>
 *
 * @generated
 */
public class impPredImpl extends MinimalEObjectImpl.Container implements impPred
{
  /**
   * The cached value of the '{@link #getPreds() <em>Preds</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPreds()
   * @generated
   * @ordered
   */
  protected EList<orPred> preds;

  /**
   * The cached value of the '{@link #getLogicop() <em>Logicop</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLogicop()
   * @generated
   * @ordered
   */
  protected EList<String> logicop;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected impPredImpl()
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
    return FormlPackage.Literals.IMP_PRED;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<orPred> getPreds()
  {
    if (preds == null)
    {
      preds = new EObjectContainmentEList<orPred>(orPred.class, this, FormlPackage.IMP_PRED__PREDS);
    }
    return preds;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<String> getLogicop()
  {
    if (logicop == null)
    {
      logicop = new EDataTypeEList<String>(String.class, this, FormlPackage.IMP_PRED__LOGICOP);
    }
    return logicop;
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
      case FormlPackage.IMP_PRED__PREDS:
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
      case FormlPackage.IMP_PRED__PREDS:
        return getPreds();
      case FormlPackage.IMP_PRED__LOGICOP:
        return getLogicop();
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
      case FormlPackage.IMP_PRED__PREDS:
        getPreds().clear();
        getPreds().addAll((Collection<? extends orPred>)newValue);
        return;
      case FormlPackage.IMP_PRED__LOGICOP:
        getLogicop().clear();
        getLogicop().addAll((Collection<? extends String>)newValue);
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
      case FormlPackage.IMP_PRED__PREDS:
        getPreds().clear();
        return;
      case FormlPackage.IMP_PRED__LOGICOP:
        getLogicop().clear();
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
      case FormlPackage.IMP_PRED__PREDS:
        return preds != null && !preds.isEmpty();
      case FormlPackage.IMP_PRED__LOGICOP:
        return logicop != null && !logicop.isEmpty();
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
    result.append(" (logicop: ");
    result.append(logicop);
    result.append(')');
    return result.toString();
  }

} //impPredImpl
