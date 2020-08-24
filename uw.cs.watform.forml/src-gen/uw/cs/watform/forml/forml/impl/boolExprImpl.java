/**
 */
package uw.cs.watform.forml.forml.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import uw.cs.watform.forml.forml.FormlPackage;
import uw.cs.watform.forml.forml.boolExpr;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>bool Expr</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uw.cs.watform.forml.forml.impl.boolExprImpl#getIsTrue <em>Is True</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.impl.boolExprImpl#getIsFalse <em>Is False</em>}</li>
 * </ul>
 *
 * @generated
 */
public class boolExprImpl extends MinimalEObjectImpl.Container implements boolExpr
{
  /**
   * The default value of the '{@link #getIsTrue() <em>Is True</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIsTrue()
   * @generated
   * @ordered
   */
  protected static final String IS_TRUE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getIsTrue() <em>Is True</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIsTrue()
   * @generated
   * @ordered
   */
  protected String isTrue = IS_TRUE_EDEFAULT;

  /**
   * The default value of the '{@link #getIsFalse() <em>Is False</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIsFalse()
   * @generated
   * @ordered
   */
  protected static final String IS_FALSE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getIsFalse() <em>Is False</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIsFalse()
   * @generated
   * @ordered
   */
  protected String isFalse = IS_FALSE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected boolExprImpl()
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
    return FormlPackage.Literals.BOOL_EXPR;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getIsTrue()
  {
    return isTrue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setIsTrue(String newIsTrue)
  {
    String oldIsTrue = isTrue;
    isTrue = newIsTrue;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FormlPackage.BOOL_EXPR__IS_TRUE, oldIsTrue, isTrue));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getIsFalse()
  {
    return isFalse;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setIsFalse(String newIsFalse)
  {
    String oldIsFalse = isFalse;
    isFalse = newIsFalse;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FormlPackage.BOOL_EXPR__IS_FALSE, oldIsFalse, isFalse));
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
      case FormlPackage.BOOL_EXPR__IS_TRUE:
        return getIsTrue();
      case FormlPackage.BOOL_EXPR__IS_FALSE:
        return getIsFalse();
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
      case FormlPackage.BOOL_EXPR__IS_TRUE:
        setIsTrue((String)newValue);
        return;
      case FormlPackage.BOOL_EXPR__IS_FALSE:
        setIsFalse((String)newValue);
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
      case FormlPackage.BOOL_EXPR__IS_TRUE:
        setIsTrue(IS_TRUE_EDEFAULT);
        return;
      case FormlPackage.BOOL_EXPR__IS_FALSE:
        setIsFalse(IS_FALSE_EDEFAULT);
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
      case FormlPackage.BOOL_EXPR__IS_TRUE:
        return IS_TRUE_EDEFAULT == null ? isTrue != null : !IS_TRUE_EDEFAULT.equals(isTrue);
      case FormlPackage.BOOL_EXPR__IS_FALSE:
        return IS_FALSE_EDEFAULT == null ? isFalse != null : !IS_FALSE_EDEFAULT.equals(isFalse);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (isTrue: ");
    result.append(isTrue);
    result.append(", isFalse: ");
    result.append(isFalse);
    result.append(')');
    return result.toString();
  }

} //boolExprImpl
