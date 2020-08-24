/**
 */
package uw.cs.watform.forml.forml.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import uw.cs.watform.forml.forml.FormlPackage;
import uw.cs.watform.forml.forml.Trigger;
import uw.cs.watform.forml.forml.WCE;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Trigger</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uw.cs.watform.forml.forml.impl.TriggerImpl#getOverride <em>Override</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.impl.TriggerImpl#getWce <em>Wce</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TriggerImpl extends MinimalEObjectImpl.Container implements Trigger
{
  /**
   * The cached value of the '{@link #getOverride() <em>Override</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOverride()
   * @generated
   * @ordered
   */
  protected uw.cs.watform.forml.forml.Override override;

  /**
   * The cached value of the '{@link #getWce() <em>Wce</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getWce()
   * @generated
   * @ordered
   */
  protected WCE wce;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TriggerImpl()
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
    return FormlPackage.Literals.TRIGGER;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public uw.cs.watform.forml.forml.Override getOverride()
  {
    return override;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetOverride(uw.cs.watform.forml.forml.Override newOverride, NotificationChain msgs)
  {
    uw.cs.watform.forml.forml.Override oldOverride = override;
    override = newOverride;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FormlPackage.TRIGGER__OVERRIDE, oldOverride, newOverride);
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
  public void setOverride(uw.cs.watform.forml.forml.Override newOverride)
  {
    if (newOverride != override)
    {
      NotificationChain msgs = null;
      if (override != null)
        msgs = ((InternalEObject)override).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FormlPackage.TRIGGER__OVERRIDE, null, msgs);
      if (newOverride != null)
        msgs = ((InternalEObject)newOverride).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FormlPackage.TRIGGER__OVERRIDE, null, msgs);
      msgs = basicSetOverride(newOverride, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FormlPackage.TRIGGER__OVERRIDE, newOverride, newOverride));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public WCE getWce()
  {
    return wce;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetWce(WCE newWce, NotificationChain msgs)
  {
    WCE oldWce = wce;
    wce = newWce;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FormlPackage.TRIGGER__WCE, oldWce, newWce);
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
  public void setWce(WCE newWce)
  {
    if (newWce != wce)
    {
      NotificationChain msgs = null;
      if (wce != null)
        msgs = ((InternalEObject)wce).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FormlPackage.TRIGGER__WCE, null, msgs);
      if (newWce != null)
        msgs = ((InternalEObject)newWce).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FormlPackage.TRIGGER__WCE, null, msgs);
      msgs = basicSetWce(newWce, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FormlPackage.TRIGGER__WCE, newWce, newWce));
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
      case FormlPackage.TRIGGER__OVERRIDE:
        return basicSetOverride(null, msgs);
      case FormlPackage.TRIGGER__WCE:
        return basicSetWce(null, msgs);
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
      case FormlPackage.TRIGGER__OVERRIDE:
        return getOverride();
      case FormlPackage.TRIGGER__WCE:
        return getWce();
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
      case FormlPackage.TRIGGER__OVERRIDE:
        setOverride((uw.cs.watform.forml.forml.Override)newValue);
        return;
      case FormlPackage.TRIGGER__WCE:
        setWce((WCE)newValue);
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
      case FormlPackage.TRIGGER__OVERRIDE:
        setOverride((uw.cs.watform.forml.forml.Override)null);
        return;
      case FormlPackage.TRIGGER__WCE:
        setWce((WCE)null);
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
      case FormlPackage.TRIGGER__OVERRIDE:
        return override != null;
      case FormlPackage.TRIGGER__WCE:
        return wce != null;
    }
    return super.eIsSet(featureID);
  }

} //TriggerImpl
