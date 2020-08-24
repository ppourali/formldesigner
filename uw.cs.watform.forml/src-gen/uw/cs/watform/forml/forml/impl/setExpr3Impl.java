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
import uw.cs.watform.forml.forml.setExpr3;
import uw.cs.watform.forml.forml.setExprBase;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>set Expr3</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uw.cs.watform.forml.forml.impl.setExpr3Impl#getParen <em>Paren</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.impl.setExpr3Impl#getBase <em>Base</em>}</li>
 * </ul>
 *
 * @generated
 */
public class setExpr3Impl extends MinimalEObjectImpl.Container implements setExpr3
{
  /**
   * The cached value of the '{@link #getParen() <em>Paren</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParen()
   * @generated
   * @ordered
   */
  protected setExprBase paren;

  /**
   * The cached value of the '{@link #getBase() <em>Base</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBase()
   * @generated
   * @ordered
   */
  protected setExprBase base;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected setExpr3Impl()
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
    return FormlPackage.Literals.SET_EXPR3;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public setExprBase getParen()
  {
    return paren;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetParen(setExprBase newParen, NotificationChain msgs)
  {
    setExprBase oldParen = paren;
    paren = newParen;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FormlPackage.SET_EXPR3__PAREN, oldParen, newParen);
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
  public void setParen(setExprBase newParen)
  {
    if (newParen != paren)
    {
      NotificationChain msgs = null;
      if (paren != null)
        msgs = ((InternalEObject)paren).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FormlPackage.SET_EXPR3__PAREN, null, msgs);
      if (newParen != null)
        msgs = ((InternalEObject)newParen).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FormlPackage.SET_EXPR3__PAREN, null, msgs);
      msgs = basicSetParen(newParen, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FormlPackage.SET_EXPR3__PAREN, newParen, newParen));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public setExprBase getBase()
  {
    return base;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetBase(setExprBase newBase, NotificationChain msgs)
  {
    setExprBase oldBase = base;
    base = newBase;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FormlPackage.SET_EXPR3__BASE, oldBase, newBase);
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
  public void setBase(setExprBase newBase)
  {
    if (newBase != base)
    {
      NotificationChain msgs = null;
      if (base != null)
        msgs = ((InternalEObject)base).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FormlPackage.SET_EXPR3__BASE, null, msgs);
      if (newBase != null)
        msgs = ((InternalEObject)newBase).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FormlPackage.SET_EXPR3__BASE, null, msgs);
      msgs = basicSetBase(newBase, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FormlPackage.SET_EXPR3__BASE, newBase, newBase));
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
      case FormlPackage.SET_EXPR3__PAREN:
        return basicSetParen(null, msgs);
      case FormlPackage.SET_EXPR3__BASE:
        return basicSetBase(null, msgs);
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
      case FormlPackage.SET_EXPR3__PAREN:
        return getParen();
      case FormlPackage.SET_EXPR3__BASE:
        return getBase();
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
      case FormlPackage.SET_EXPR3__PAREN:
        setParen((setExprBase)newValue);
        return;
      case FormlPackage.SET_EXPR3__BASE:
        setBase((setExprBase)newValue);
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
      case FormlPackage.SET_EXPR3__PAREN:
        setParen((setExprBase)null);
        return;
      case FormlPackage.SET_EXPR3__BASE:
        setBase((setExprBase)null);
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
      case FormlPackage.SET_EXPR3__PAREN:
        return paren != null;
      case FormlPackage.SET_EXPR3__BASE:
        return base != null;
    }
    return super.eIsSet(featureID);
  }

} //setExpr3Impl
