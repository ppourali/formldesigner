/**
 */
package uw.cs.watform.forml.forml.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import uw.cs.watform.forml.forml.FormlPackage;
import uw.cs.watform.forml.forml.Message;
import uw.cs.watform.forml.forml.RefMessage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ref Message</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uw.cs.watform.forml.forml.impl.RefMessageImpl#getRefMsg <em>Ref Msg</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RefMessageImpl extends MinimalEObjectImpl.Container implements RefMessage
{
  /**
   * The cached value of the '{@link #getRefMsg() <em>Ref Msg</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRefMsg()
   * @generated
   * @ordered
   */
  protected Message refMsg;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RefMessageImpl()
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
    return FormlPackage.Literals.REF_MESSAGE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Message getRefMsg()
  {
    if (refMsg != null && refMsg.eIsProxy())
    {
      InternalEObject oldRefMsg = (InternalEObject)refMsg;
      refMsg = (Message)eResolveProxy(oldRefMsg);
      if (refMsg != oldRefMsg)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, FormlPackage.REF_MESSAGE__REF_MSG, oldRefMsg, refMsg));
      }
    }
    return refMsg;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Message basicGetRefMsg()
  {
    return refMsg;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setRefMsg(Message newRefMsg)
  {
    Message oldRefMsg = refMsg;
    refMsg = newRefMsg;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FormlPackage.REF_MESSAGE__REF_MSG, oldRefMsg, refMsg));
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
      case FormlPackage.REF_MESSAGE__REF_MSG:
        if (resolve) return getRefMsg();
        return basicGetRefMsg();
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
      case FormlPackage.REF_MESSAGE__REF_MSG:
        setRefMsg((Message)newValue);
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
      case FormlPackage.REF_MESSAGE__REF_MSG:
        setRefMsg((Message)null);
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
      case FormlPackage.REF_MESSAGE__REF_MSG:
        return refMsg != null;
    }
    return super.eIsSet(featureID);
  }

} //RefMessageImpl
