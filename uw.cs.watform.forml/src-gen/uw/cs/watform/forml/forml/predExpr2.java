/**
 */
package uw.cs.watform.forml.forml;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>pred Expr2</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uw.cs.watform.forml.forml.predExpr2#getExpr <em>Expr</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.predExpr2#getOp <em>Op</em>}</li>
 * </ul>
 *
 * @see uw.cs.watform.forml.forml.FormlPackage#getpredExpr2()
 * @model
 * @generated
 */
public interface predExpr2 extends EObject
{
  /**
   * Returns the value of the '<em><b>Expr</b></em>' containment reference list.
   * The list contents are of type {@link uw.cs.watform.forml.forml.predExpr3}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expr</em>' containment reference list.
   * @see uw.cs.watform.forml.forml.FormlPackage#getpredExpr2_Expr()
   * @model containment="true"
   * @generated
   */
  EList<predExpr3> getExpr();

  /**
   * Returns the value of the '<em><b>Op</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Op</em>' attribute list.
   * @see uw.cs.watform.forml.forml.FormlPackage#getpredExpr2_Op()
   * @model unique="false"
   * @generated
   */
  EList<String> getOp();

} // predExpr2
