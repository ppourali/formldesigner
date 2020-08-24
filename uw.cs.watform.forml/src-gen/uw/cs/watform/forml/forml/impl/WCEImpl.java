/**
 */
package uw.cs.watform.forml.forml.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import uw.cs.watform.forml.forml.Attribute;
import uw.cs.watform.forml.forml.ExprRef;
import uw.cs.watform.forml.forml.FormlPackage;
import uw.cs.watform.forml.forml.WCE;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>WCE</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uw.cs.watform.forml.forml.impl.WCEImpl#getAddobj <em>Addobj</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.impl.WCEImpl#getAttr <em>Attr</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.impl.WCEImpl#getRemobj <em>Remobj</em>}</li>
 * </ul>
 *
 * @generated
 */
public class WCEImpl extends MinimalEObjectImpl.Container implements WCE
{
  /**
   * The cached value of the '{@link #getAddobj() <em>Addobj</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAddobj()
   * @generated
   * @ordered
   */
  protected ExprRef addobj;

  /**
   * The cached value of the '{@link #getAttr() <em>Attr</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAttr()
   * @generated
   * @ordered
   */
  protected Attribute attr;

  /**
   * The cached value of the '{@link #getRemobj() <em>Remobj</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRemobj()
   * @generated
   * @ordered
   */
  protected ExprRef remobj;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected WCEImpl()
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
    return FormlPackage.Literals.WCE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ExprRef getAddobj()
  {
    if (addobj != null && addobj.eIsProxy())
    {
      InternalEObject oldAddobj = (InternalEObject)addobj;
      addobj = (ExprRef)eResolveProxy(oldAddobj);
      if (addobj != oldAddobj)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, FormlPackage.WCE__ADDOBJ, oldAddobj, addobj));
      }
    }
    return addobj;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExprRef basicGetAddobj()
  {
    return addobj;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setAddobj(ExprRef newAddobj)
  {
    ExprRef oldAddobj = addobj;
    addobj = newAddobj;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FormlPackage.WCE__ADDOBJ, oldAddobj, addobj));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Attribute getAttr()
  {
    if (attr != null && attr.eIsProxy())
    {
      InternalEObject oldAttr = (InternalEObject)attr;
      attr = (Attribute)eResolveProxy(oldAttr);
      if (attr != oldAttr)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, FormlPackage.WCE__ATTR, oldAttr, attr));
      }
    }
    return attr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Attribute basicGetAttr()
  {
    return attr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setAttr(Attribute newAttr)
  {
    Attribute oldAttr = attr;
    attr = newAttr;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FormlPackage.WCE__ATTR, oldAttr, attr));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ExprRef getRemobj()
  {
    if (remobj != null && remobj.eIsProxy())
    {
      InternalEObject oldRemobj = (InternalEObject)remobj;
      remobj = (ExprRef)eResolveProxy(oldRemobj);
      if (remobj != oldRemobj)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, FormlPackage.WCE__REMOBJ, oldRemobj, remobj));
      }
    }
    return remobj;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExprRef basicGetRemobj()
  {
    return remobj;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setRemobj(ExprRef newRemobj)
  {
    ExprRef oldRemobj = remobj;
    remobj = newRemobj;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FormlPackage.WCE__REMOBJ, oldRemobj, remobj));
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
      case FormlPackage.WCE__ADDOBJ:
        if (resolve) return getAddobj();
        return basicGetAddobj();
      case FormlPackage.WCE__ATTR:
        if (resolve) return getAttr();
        return basicGetAttr();
      case FormlPackage.WCE__REMOBJ:
        if (resolve) return getRemobj();
        return basicGetRemobj();
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
      case FormlPackage.WCE__ADDOBJ:
        setAddobj((ExprRef)newValue);
        return;
      case FormlPackage.WCE__ATTR:
        setAttr((Attribute)newValue);
        return;
      case FormlPackage.WCE__REMOBJ:
        setRemobj((ExprRef)newValue);
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
      case FormlPackage.WCE__ADDOBJ:
        setAddobj((ExprRef)null);
        return;
      case FormlPackage.WCE__ATTR:
        setAttr((Attribute)null);
        return;
      case FormlPackage.WCE__REMOBJ:
        setRemobj((ExprRef)null);
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
      case FormlPackage.WCE__ADDOBJ:
        return addobj != null;
      case FormlPackage.WCE__ATTR:
        return attr != null;
      case FormlPackage.WCE__REMOBJ:
        return remobj != null;
    }
    return super.eIsSet(featureID);
  }

} //WCEImpl
