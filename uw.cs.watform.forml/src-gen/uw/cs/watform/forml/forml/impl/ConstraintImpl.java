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

import uw.cs.watform.forml.forml.Constraint;
import uw.cs.watform.forml.forml.FormlPackage;
import uw.cs.watform.forml.forml.Macro;
import uw.cs.watform.forml.forml.Predicate;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uw.cs.watform.forml.forml.impl.ConstraintImpl#getPredicates <em>Predicates</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.impl.ConstraintImpl#getMacro <em>Macro</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConstraintImpl extends MinimalEObjectImpl.Container implements Constraint
{
  /**
   * The cached value of the '{@link #getPredicates() <em>Predicates</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPredicates()
   * @generated
   * @ordered
   */
  protected EList<Predicate> predicates;

  /**
   * The cached value of the '{@link #getMacro() <em>Macro</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMacro()
   * @generated
   * @ordered
   */
  protected EList<Macro> macro;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ConstraintImpl()
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
    return FormlPackage.Literals.CONSTRAINT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Predicate> getPredicates()
  {
    if (predicates == null)
    {
      predicates = new EObjectContainmentEList<Predicate>(Predicate.class, this, FormlPackage.CONSTRAINT__PREDICATES);
    }
    return predicates;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Macro> getMacro()
  {
    if (macro == null)
    {
      macro = new EObjectContainmentEList<Macro>(Macro.class, this, FormlPackage.CONSTRAINT__MACRO);
    }
    return macro;
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
      case FormlPackage.CONSTRAINT__PREDICATES:
        return ((InternalEList<?>)getPredicates()).basicRemove(otherEnd, msgs);
      case FormlPackage.CONSTRAINT__MACRO:
        return ((InternalEList<?>)getMacro()).basicRemove(otherEnd, msgs);
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
      case FormlPackage.CONSTRAINT__PREDICATES:
        return getPredicates();
      case FormlPackage.CONSTRAINT__MACRO:
        return getMacro();
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
      case FormlPackage.CONSTRAINT__PREDICATES:
        getPredicates().clear();
        getPredicates().addAll((Collection<? extends Predicate>)newValue);
        return;
      case FormlPackage.CONSTRAINT__MACRO:
        getMacro().clear();
        getMacro().addAll((Collection<? extends Macro>)newValue);
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
      case FormlPackage.CONSTRAINT__PREDICATES:
        getPredicates().clear();
        return;
      case FormlPackage.CONSTRAINT__MACRO:
        getMacro().clear();
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
      case FormlPackage.CONSTRAINT__PREDICATES:
        return predicates != null && !predicates.isEmpty();
      case FormlPackage.CONSTRAINT__MACRO:
        return macro != null && !macro.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ConstraintImpl
