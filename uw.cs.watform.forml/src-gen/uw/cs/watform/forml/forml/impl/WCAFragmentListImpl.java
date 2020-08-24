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
import uw.cs.watform.forml.forml.WCAFragment;
import uw.cs.watform.forml.forml.WCAFragmentList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>WCA Fragment List</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uw.cs.watform.forml.forml.impl.WCAFragmentListImpl#getFrag <em>Frag</em>}</li>
 * </ul>
 *
 * @generated
 */
public class WCAFragmentListImpl extends MinimalEObjectImpl.Container implements WCAFragmentList
{
  /**
   * The cached value of the '{@link #getFrag() <em>Frag</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFrag()
   * @generated
   * @ordered
   */
  protected EList<WCAFragment> frag;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected WCAFragmentListImpl()
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
    return FormlPackage.Literals.WCA_FRAGMENT_LIST;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<WCAFragment> getFrag()
  {
    if (frag == null)
    {
      frag = new EObjectContainmentEList<WCAFragment>(WCAFragment.class, this, FormlPackage.WCA_FRAGMENT_LIST__FRAG);
    }
    return frag;
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
      case FormlPackage.WCA_FRAGMENT_LIST__FRAG:
        return ((InternalEList<?>)getFrag()).basicRemove(otherEnd, msgs);
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
      case FormlPackage.WCA_FRAGMENT_LIST__FRAG:
        return getFrag();
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
      case FormlPackage.WCA_FRAGMENT_LIST__FRAG:
        getFrag().clear();
        getFrag().addAll((Collection<? extends WCAFragment>)newValue);
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
      case FormlPackage.WCA_FRAGMENT_LIST__FRAG:
        getFrag().clear();
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
      case FormlPackage.WCA_FRAGMENT_LIST__FRAG:
        return frag != null && !frag.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //WCAFragmentListImpl
