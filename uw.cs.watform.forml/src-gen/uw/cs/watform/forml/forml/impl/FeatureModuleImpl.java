/**
 */
package uw.cs.watform.forml.forml.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import uw.cs.watform.forml.forml.Constraint;
import uw.cs.watform.forml.forml.FeatureModule;
import uw.cs.watform.forml.forml.FormlPackage;
import uw.cs.watform.forml.forml.Fragment;
import uw.cs.watform.forml.forml.Roleable;
import uw.cs.watform.forml.forml.StateMachine;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Feature Module</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uw.cs.watform.forml.forml.impl.FeatureModuleImpl#getFeatureref <em>Featureref</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.impl.FeatureModuleImpl#getConstraints <em>Constraints</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.impl.FeatureModuleImpl#getStatemachine <em>Statemachine</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.impl.FeatureModuleImpl#getFragments <em>Fragments</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FeatureModuleImpl extends MinimalEObjectImpl.Container implements FeatureModule
{
  /**
   * The cached value of the '{@link #getFeatureref() <em>Featureref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFeatureref()
   * @generated
   * @ordered
   */
  protected Roleable featureref;

  /**
   * The cached value of the '{@link #getConstraints() <em>Constraints</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConstraints()
   * @generated
   * @ordered
   */
  protected Constraint constraints;

  /**
   * The cached value of the '{@link #getStatemachine() <em>Statemachine</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStatemachine()
   * @generated
   * @ordered
   */
  protected EList<StateMachine> statemachine;

  /**
   * The cached value of the '{@link #getFragments() <em>Fragments</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFragments()
   * @generated
   * @ordered
   */
  protected EList<Fragment> fragments;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected FeatureModuleImpl()
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
    return FormlPackage.Literals.FEATURE_MODULE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Roleable getFeatureref()
  {
    if (featureref != null && featureref.eIsProxy())
    {
      InternalEObject oldFeatureref = (InternalEObject)featureref;
      featureref = (Roleable)eResolveProxy(oldFeatureref);
      if (featureref != oldFeatureref)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, FormlPackage.FEATURE_MODULE__FEATUREREF, oldFeatureref, featureref));
      }
    }
    return featureref;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Roleable basicGetFeatureref()
  {
    return featureref;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setFeatureref(Roleable newFeatureref)
  {
    Roleable oldFeatureref = featureref;
    featureref = newFeatureref;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FormlPackage.FEATURE_MODULE__FEATUREREF, oldFeatureref, featureref));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Constraint getConstraints()
  {
    return constraints;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetConstraints(Constraint newConstraints, NotificationChain msgs)
  {
    Constraint oldConstraints = constraints;
    constraints = newConstraints;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FormlPackage.FEATURE_MODULE__CONSTRAINTS, oldConstraints, newConstraints);
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
  public void setConstraints(Constraint newConstraints)
  {
    if (newConstraints != constraints)
    {
      NotificationChain msgs = null;
      if (constraints != null)
        msgs = ((InternalEObject)constraints).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FormlPackage.FEATURE_MODULE__CONSTRAINTS, null, msgs);
      if (newConstraints != null)
        msgs = ((InternalEObject)newConstraints).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FormlPackage.FEATURE_MODULE__CONSTRAINTS, null, msgs);
      msgs = basicSetConstraints(newConstraints, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FormlPackage.FEATURE_MODULE__CONSTRAINTS, newConstraints, newConstraints));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<StateMachine> getStatemachine()
  {
    if (statemachine == null)
    {
      statemachine = new EObjectContainmentEList<StateMachine>(StateMachine.class, this, FormlPackage.FEATURE_MODULE__STATEMACHINE);
    }
    return statemachine;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Fragment> getFragments()
  {
    if (fragments == null)
    {
      fragments = new EObjectContainmentEList<Fragment>(Fragment.class, this, FormlPackage.FEATURE_MODULE__FRAGMENTS);
    }
    return fragments;
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
      case FormlPackage.FEATURE_MODULE__CONSTRAINTS:
        return basicSetConstraints(null, msgs);
      case FormlPackage.FEATURE_MODULE__STATEMACHINE:
        return ((InternalEList<?>)getStatemachine()).basicRemove(otherEnd, msgs);
      case FormlPackage.FEATURE_MODULE__FRAGMENTS:
        return ((InternalEList<?>)getFragments()).basicRemove(otherEnd, msgs);
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
      case FormlPackage.FEATURE_MODULE__FEATUREREF:
        if (resolve) return getFeatureref();
        return basicGetFeatureref();
      case FormlPackage.FEATURE_MODULE__CONSTRAINTS:
        return getConstraints();
      case FormlPackage.FEATURE_MODULE__STATEMACHINE:
        return getStatemachine();
      case FormlPackage.FEATURE_MODULE__FRAGMENTS:
        return getFragments();
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
      case FormlPackage.FEATURE_MODULE__FEATUREREF:
        setFeatureref((Roleable)newValue);
        return;
      case FormlPackage.FEATURE_MODULE__CONSTRAINTS:
        setConstraints((Constraint)newValue);
        return;
      case FormlPackage.FEATURE_MODULE__STATEMACHINE:
        getStatemachine().clear();
        getStatemachine().addAll((Collection<? extends StateMachine>)newValue);
        return;
      case FormlPackage.FEATURE_MODULE__FRAGMENTS:
        getFragments().clear();
        getFragments().addAll((Collection<? extends Fragment>)newValue);
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
      case FormlPackage.FEATURE_MODULE__FEATUREREF:
        setFeatureref((Roleable)null);
        return;
      case FormlPackage.FEATURE_MODULE__CONSTRAINTS:
        setConstraints((Constraint)null);
        return;
      case FormlPackage.FEATURE_MODULE__STATEMACHINE:
        getStatemachine().clear();
        return;
      case FormlPackage.FEATURE_MODULE__FRAGMENTS:
        getFragments().clear();
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
      case FormlPackage.FEATURE_MODULE__FEATUREREF:
        return featureref != null;
      case FormlPackage.FEATURE_MODULE__CONSTRAINTS:
        return constraints != null;
      case FormlPackage.FEATURE_MODULE__STATEMACHINE:
        return statemachine != null && !statemachine.isEmpty();
      case FormlPackage.FEATURE_MODULE__FRAGMENTS:
        return fragments != null && !fragments.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //FeatureModuleImpl
