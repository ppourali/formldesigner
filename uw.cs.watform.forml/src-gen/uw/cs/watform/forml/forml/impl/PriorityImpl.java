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
import uw.cs.watform.forml.forml.Priority;
import uw.cs.watform.forml.forml.TransList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Priority</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uw.cs.watform.forml.forml.impl.PriorityImpl#getTranslist <em>Translist</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PriorityImpl extends MinimalEObjectImpl.Container implements Priority
{
  /**
   * The cached value of the '{@link #getTranslist() <em>Translist</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTranslist()
   * @generated
   * @ordered
   */
  protected TransList translist;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PriorityImpl()
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
    return FormlPackage.Literals.PRIORITY;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public TransList getTranslist()
  {
    return translist;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTranslist(TransList newTranslist, NotificationChain msgs)
  {
    TransList oldTranslist = translist;
    translist = newTranslist;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FormlPackage.PRIORITY__TRANSLIST, oldTranslist, newTranslist);
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
  public void setTranslist(TransList newTranslist)
  {
    if (newTranslist != translist)
    {
      NotificationChain msgs = null;
      if (translist != null)
        msgs = ((InternalEObject)translist).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FormlPackage.PRIORITY__TRANSLIST, null, msgs);
      if (newTranslist != null)
        msgs = ((InternalEObject)newTranslist).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FormlPackage.PRIORITY__TRANSLIST, null, msgs);
      msgs = basicSetTranslist(newTranslist, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FormlPackage.PRIORITY__TRANSLIST, newTranslist, newTranslist));
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
      case FormlPackage.PRIORITY__TRANSLIST:
        return basicSetTranslist(null, msgs);
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
      case FormlPackage.PRIORITY__TRANSLIST:
        return getTranslist();
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
      case FormlPackage.PRIORITY__TRANSLIST:
        setTranslist((TransList)newValue);
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
      case FormlPackage.PRIORITY__TRANSLIST:
        setTranslist((TransList)null);
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
      case FormlPackage.PRIORITY__TRANSLIST:
        return translist != null;
    }
    return super.eIsSet(featureID);
  }

} //PriorityImpl
