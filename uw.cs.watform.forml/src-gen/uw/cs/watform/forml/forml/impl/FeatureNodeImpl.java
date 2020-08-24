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

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import uw.cs.watform.forml.forml.Feature;
import uw.cs.watform.forml.forml.FeatureNode;
import uw.cs.watform.forml.forml.FormlPackage;
import uw.cs.watform.forml.forml.Multiplicity;
import uw.cs.watform.forml.forml.Node;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Feature Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uw.cs.watform.forml.forml.impl.FeatureNodeImpl#getFeature <em>Feature</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.impl.FeatureNodeImpl#getMultiplicity <em>Multiplicity</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.impl.FeatureNodeImpl#getXors <em>Xors</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.impl.FeatureNodeImpl#getAnds <em>Ands</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.impl.FeatureNodeImpl#getOrs <em>Ors</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FeatureNodeImpl extends NodeImpl implements FeatureNode
{
  /**
   * The cached value of the '{@link #getFeature() <em>Feature</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFeature()
   * @generated
   * @ordered
   */
  protected Feature feature;

  /**
   * The cached value of the '{@link #getMultiplicity() <em>Multiplicity</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMultiplicity()
   * @generated
   * @ordered
   */
  protected Multiplicity multiplicity;

  /**
   * The cached value of the '{@link #getXors() <em>Xors</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getXors()
   * @generated
   * @ordered
   */
  protected EList<Node> xors;

  /**
   * The cached value of the '{@link #getAnds() <em>Ands</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAnds()
   * @generated
   * @ordered
   */
  protected EList<Node> ands;

  /**
   * The cached value of the '{@link #getOrs() <em>Ors</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOrs()
   * @generated
   * @ordered
   */
  protected EList<Node> ors;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected FeatureNodeImpl()
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
    return FormlPackage.Literals.FEATURE_NODE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Feature getFeature()
  {
    if (feature != null && feature.eIsProxy())
    {
      InternalEObject oldFeature = (InternalEObject)feature;
      feature = (Feature)eResolveProxy(oldFeature);
      if (feature != oldFeature)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, FormlPackage.FEATURE_NODE__FEATURE, oldFeature, feature));
      }
    }
    return feature;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Feature basicGetFeature()
  {
    return feature;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setFeature(Feature newFeature)
  {
    Feature oldFeature = feature;
    feature = newFeature;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FormlPackage.FEATURE_NODE__FEATURE, oldFeature, feature));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Multiplicity getMultiplicity()
  {
    return multiplicity;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetMultiplicity(Multiplicity newMultiplicity, NotificationChain msgs)
  {
    Multiplicity oldMultiplicity = multiplicity;
    multiplicity = newMultiplicity;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FormlPackage.FEATURE_NODE__MULTIPLICITY, oldMultiplicity, newMultiplicity);
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
  public void setMultiplicity(Multiplicity newMultiplicity)
  {
    if (newMultiplicity != multiplicity)
    {
      NotificationChain msgs = null;
      if (multiplicity != null)
        msgs = ((InternalEObject)multiplicity).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FormlPackage.FEATURE_NODE__MULTIPLICITY, null, msgs);
      if (newMultiplicity != null)
        msgs = ((InternalEObject)newMultiplicity).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FormlPackage.FEATURE_NODE__MULTIPLICITY, null, msgs);
      msgs = basicSetMultiplicity(newMultiplicity, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FormlPackage.FEATURE_NODE__MULTIPLICITY, newMultiplicity, newMultiplicity));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Node> getXors()
  {
    if (xors == null)
    {
      xors = new EObjectContainmentEList<Node>(Node.class, this, FormlPackage.FEATURE_NODE__XORS);
    }
    return xors;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Node> getAnds()
  {
    if (ands == null)
    {
      ands = new EObjectContainmentEList<Node>(Node.class, this, FormlPackage.FEATURE_NODE__ANDS);
    }
    return ands;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Node> getOrs()
  {
    if (ors == null)
    {
      ors = new EObjectContainmentEList<Node>(Node.class, this, FormlPackage.FEATURE_NODE__ORS);
    }
    return ors;
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
      case FormlPackage.FEATURE_NODE__MULTIPLICITY:
        return basicSetMultiplicity(null, msgs);
      case FormlPackage.FEATURE_NODE__XORS:
        return ((InternalEList<?>)getXors()).basicRemove(otherEnd, msgs);
      case FormlPackage.FEATURE_NODE__ANDS:
        return ((InternalEList<?>)getAnds()).basicRemove(otherEnd, msgs);
      case FormlPackage.FEATURE_NODE__ORS:
        return ((InternalEList<?>)getOrs()).basicRemove(otherEnd, msgs);
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
      case FormlPackage.FEATURE_NODE__FEATURE:
        if (resolve) return getFeature();
        return basicGetFeature();
      case FormlPackage.FEATURE_NODE__MULTIPLICITY:
        return getMultiplicity();
      case FormlPackage.FEATURE_NODE__XORS:
        return getXors();
      case FormlPackage.FEATURE_NODE__ANDS:
        return getAnds();
      case FormlPackage.FEATURE_NODE__ORS:
        return getOrs();
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
      case FormlPackage.FEATURE_NODE__FEATURE:
        setFeature((Feature)newValue);
        return;
      case FormlPackage.FEATURE_NODE__MULTIPLICITY:
        setMultiplicity((Multiplicity)newValue);
        return;
      case FormlPackage.FEATURE_NODE__XORS:
        getXors().clear();
        getXors().addAll((Collection<? extends Node>)newValue);
        return;
      case FormlPackage.FEATURE_NODE__ANDS:
        getAnds().clear();
        getAnds().addAll((Collection<? extends Node>)newValue);
        return;
      case FormlPackage.FEATURE_NODE__ORS:
        getOrs().clear();
        getOrs().addAll((Collection<? extends Node>)newValue);
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
      case FormlPackage.FEATURE_NODE__FEATURE:
        setFeature((Feature)null);
        return;
      case FormlPackage.FEATURE_NODE__MULTIPLICITY:
        setMultiplicity((Multiplicity)null);
        return;
      case FormlPackage.FEATURE_NODE__XORS:
        getXors().clear();
        return;
      case FormlPackage.FEATURE_NODE__ANDS:
        getAnds().clear();
        return;
      case FormlPackage.FEATURE_NODE__ORS:
        getOrs().clear();
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
      case FormlPackage.FEATURE_NODE__FEATURE:
        return feature != null;
      case FormlPackage.FEATURE_NODE__MULTIPLICITY:
        return multiplicity != null;
      case FormlPackage.FEATURE_NODE__XORS:
        return xors != null && !xors.isEmpty();
      case FormlPackage.FEATURE_NODE__ANDS:
        return ands != null && !ands.isEmpty();
      case FormlPackage.FEATURE_NODE__ORS:
        return ors != null && !ors.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //FeatureNodeImpl
