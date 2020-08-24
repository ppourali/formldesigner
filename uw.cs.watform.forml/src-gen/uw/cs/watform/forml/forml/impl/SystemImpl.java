/**
 */
package uw.cs.watform.forml.forml.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import uw.cs.watform.forml.forml.BehaviourModel;
import uw.cs.watform.forml.forml.FormlPackage;
import uw.cs.watform.forml.forml.WorldModel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>System</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uw.cs.watform.forml.forml.impl.SystemImpl#getWorldmodel <em>Worldmodel</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.impl.SystemImpl#getBehaviourmodel <em>Behaviourmodel</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SystemImpl extends MinimalEObjectImpl.Container implements uw.cs.watform.forml.forml.System
{
  /**
   * The cached value of the '{@link #getWorldmodel() <em>Worldmodel</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getWorldmodel()
   * @generated
   * @ordered
   */
  protected WorldModel worldmodel;

  /**
   * The cached value of the '{@link #getBehaviourmodel() <em>Behaviourmodel</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBehaviourmodel()
   * @generated
   * @ordered
   */
  protected BehaviourModel behaviourmodel;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SystemImpl()
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
    return FormlPackage.Literals.SYSTEM;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public WorldModel getWorldmodel()
  {
    return worldmodel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetWorldmodel(WorldModel newWorldmodel, NotificationChain msgs)
  {
    WorldModel oldWorldmodel = worldmodel;
    worldmodel = newWorldmodel;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FormlPackage.SYSTEM__WORLDMODEL, oldWorldmodel, newWorldmodel);
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
  public void setWorldmodel(WorldModel newWorldmodel)
  {
    if (newWorldmodel != worldmodel)
    {
      NotificationChain msgs = null;
      if (worldmodel != null)
        msgs = ((InternalEObject)worldmodel).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FormlPackage.SYSTEM__WORLDMODEL, null, msgs);
      if (newWorldmodel != null)
        msgs = ((InternalEObject)newWorldmodel).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FormlPackage.SYSTEM__WORLDMODEL, null, msgs);
      msgs = basicSetWorldmodel(newWorldmodel, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FormlPackage.SYSTEM__WORLDMODEL, newWorldmodel, newWorldmodel));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public BehaviourModel getBehaviourmodel()
  {
    return behaviourmodel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetBehaviourmodel(BehaviourModel newBehaviourmodel, NotificationChain msgs)
  {
    BehaviourModel oldBehaviourmodel = behaviourmodel;
    behaviourmodel = newBehaviourmodel;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FormlPackage.SYSTEM__BEHAVIOURMODEL, oldBehaviourmodel, newBehaviourmodel);
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
  public void setBehaviourmodel(BehaviourModel newBehaviourmodel)
  {
    if (newBehaviourmodel != behaviourmodel)
    {
      NotificationChain msgs = null;
      if (behaviourmodel != null)
        msgs = ((InternalEObject)behaviourmodel).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FormlPackage.SYSTEM__BEHAVIOURMODEL, null, msgs);
      if (newBehaviourmodel != null)
        msgs = ((InternalEObject)newBehaviourmodel).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FormlPackage.SYSTEM__BEHAVIOURMODEL, null, msgs);
      msgs = basicSetBehaviourmodel(newBehaviourmodel, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FormlPackage.SYSTEM__BEHAVIOURMODEL, newBehaviourmodel, newBehaviourmodel));
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
      case FormlPackage.SYSTEM__WORLDMODEL:
        return basicSetWorldmodel(null, msgs);
      case FormlPackage.SYSTEM__BEHAVIOURMODEL:
        return basicSetBehaviourmodel(null, msgs);
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
      case FormlPackage.SYSTEM__WORLDMODEL:
        return getWorldmodel();
      case FormlPackage.SYSTEM__BEHAVIOURMODEL:
        return getBehaviourmodel();
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
      case FormlPackage.SYSTEM__WORLDMODEL:
        setWorldmodel((WorldModel)newValue);
        return;
      case FormlPackage.SYSTEM__BEHAVIOURMODEL:
        setBehaviourmodel((BehaviourModel)newValue);
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
      case FormlPackage.SYSTEM__WORLDMODEL:
        setWorldmodel((WorldModel)null);
        return;
      case FormlPackage.SYSTEM__BEHAVIOURMODEL:
        setBehaviourmodel((BehaviourModel)null);
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
      case FormlPackage.SYSTEM__WORLDMODEL:
        return worldmodel != null;
      case FormlPackage.SYSTEM__BEHAVIOURMODEL:
        return behaviourmodel != null;
    }
    return super.eIsSet(featureID);
  }

} //SystemImpl
