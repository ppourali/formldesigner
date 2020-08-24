/**
 */
package uw.cs.watform.forml.forml;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>bool Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uw.cs.watform.forml.forml.boolExpr#getIsTrue <em>Is True</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.boolExpr#getIsFalse <em>Is False</em>}</li>
 * </ul>
 *
 * @see uw.cs.watform.forml.forml.FormlPackage#getboolExpr()
 * @model
 * @generated
 */
public interface boolExpr extends EObject
{
  /**
   * Returns the value of the '<em><b>Is True</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Is True</em>' attribute.
   * @see #setIsTrue(String)
   * @see uw.cs.watform.forml.forml.FormlPackage#getboolExpr_IsTrue()
   * @model
   * @generated
   */
  String getIsTrue();

  /**
   * Sets the value of the '{@link uw.cs.watform.forml.forml.boolExpr#getIsTrue <em>Is True</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Is True</em>' attribute.
   * @see #getIsTrue()
   * @generated
   */
  void setIsTrue(String value);

  /**
   * Returns the value of the '<em><b>Is False</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Is False</em>' attribute.
   * @see #setIsFalse(String)
   * @see uw.cs.watform.forml.forml.FormlPackage#getboolExpr_IsFalse()
   * @model
   * @generated
   */
  String getIsFalse();

  /**
   * Sets the value of the '{@link uw.cs.watform.forml.forml.boolExpr#getIsFalse <em>Is False</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Is False</em>' attribute.
   * @see #getIsFalse()
   * @generated
   */
  void setIsFalse(String value);

} // boolExpr
