/**
 */
package uw.cs.watform.forml.forml;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>set Expr3</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uw.cs.watform.forml.forml.setExpr3#getParen <em>Paren</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.setExpr3#getBase <em>Base</em>}</li>
 * </ul>
 *
 * @see uw.cs.watform.forml.forml.FormlPackage#getsetExpr3()
 * @model
 * @generated
 */
public interface setExpr3 extends EObject
{
  /**
   * Returns the value of the '<em><b>Paren</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Paren</em>' containment reference.
   * @see #setParen(setExprBase)
   * @see uw.cs.watform.forml.forml.FormlPackage#getsetExpr3_Paren()
   * @model containment="true"
   * @generated
   */
  setExprBase getParen();

  /**
   * Sets the value of the '{@link uw.cs.watform.forml.forml.setExpr3#getParen <em>Paren</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Paren</em>' containment reference.
   * @see #getParen()
   * @generated
   */
  void setParen(setExprBase value);

  /**
   * Returns the value of the '<em><b>Base</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Base</em>' containment reference.
   * @see #setBase(setExprBase)
   * @see uw.cs.watform.forml.forml.FormlPackage#getsetExpr3_Base()
   * @model containment="true"
   * @generated
   */
  setExprBase getBase();

  /**
   * Sets the value of the '{@link uw.cs.watform.forml.forml.setExpr3#getBase <em>Base</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Base</em>' containment reference.
   * @see #getBase()
   * @generated
   */
  void setBase(setExprBase value);

} // setExpr3
