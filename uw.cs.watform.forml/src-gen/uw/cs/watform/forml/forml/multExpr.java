/**
 */
package uw.cs.watform.forml.forml;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>mult Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uw.cs.watform.forml.forml.multExpr#getLhs <em>Lhs</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.multExpr#getOp <em>Op</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.multExpr#getRhs <em>Rhs</em>}</li>
 * </ul>
 *
 * @see uw.cs.watform.forml.forml.FormlPackage#getmultExpr()
 * @model
 * @generated
 */
public interface multExpr extends EObject
{
  /**
   * Returns the value of the '<em><b>Lhs</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Lhs</em>' containment reference.
   * @see #setLhs(intBase)
   * @see uw.cs.watform.forml.forml.FormlPackage#getmultExpr_Lhs()
   * @model containment="true"
   * @generated
   */
  intBase getLhs();

  /**
   * Sets the value of the '{@link uw.cs.watform.forml.forml.multExpr#getLhs <em>Lhs</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Lhs</em>' containment reference.
   * @see #getLhs()
   * @generated
   */
  void setLhs(intBase value);

  /**
   * Returns the value of the '<em><b>Op</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Op</em>' attribute list.
   * @see uw.cs.watform.forml.forml.FormlPackage#getmultExpr_Op()
   * @model unique="false"
   * @generated
   */
  EList<String> getOp();

  /**
   * Returns the value of the '<em><b>Rhs</b></em>' containment reference list.
   * The list contents are of type {@link uw.cs.watform.forml.forml.intBase}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Rhs</em>' containment reference list.
   * @see uw.cs.watform.forml.forml.FormlPackage#getmultExpr_Rhs()
   * @model containment="true"
   * @generated
   */
  EList<intBase> getRhs();

} // multExpr
