/**
 */
package uw.cs.watform.forml.forml;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Predicate</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uw.cs.watform.forml.forml.Predicate#getLogicop <em>Logicop</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.Predicate#getVar <em>Var</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.Predicate#getSexpr <em>Sexpr</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.Predicate#getQuantPred <em>Quant Pred</em>}</li>
 * </ul>
 *
 * @see uw.cs.watform.forml.forml.FormlPackage#getPredicate()
 * @model
 * @generated
 */
public interface Predicate extends EObject
{
  /**
   * Returns the value of the '<em><b>Logicop</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Logicop</em>' attribute.
   * @see #setLogicop(String)
   * @see uw.cs.watform.forml.forml.FormlPackage#getPredicate_Logicop()
   * @model
   * @generated
   */
  String getLogicop();

  /**
   * Sets the value of the '{@link uw.cs.watform.forml.forml.Predicate#getLogicop <em>Logicop</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Logicop</em>' attribute.
   * @see #getLogicop()
   * @generated
   */
  void setLogicop(String value);

  /**
   * Returns the value of the '<em><b>Var</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Var</em>' containment reference.
   * @see #setVar(ExprRef)
   * @see uw.cs.watform.forml.forml.FormlPackage#getPredicate_Var()
   * @model containment="true"
   * @generated
   */
  ExprRef getVar();

  /**
   * Sets the value of the '{@link uw.cs.watform.forml.forml.Predicate#getVar <em>Var</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Var</em>' containment reference.
   * @see #getVar()
   * @generated
   */
  void setVar(ExprRef value);

  /**
   * Returns the value of the '<em><b>Sexpr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sexpr</em>' containment reference.
   * @see #setSexpr(setExpr)
   * @see uw.cs.watform.forml.forml.FormlPackage#getPredicate_Sexpr()
   * @model containment="true"
   * @generated
   */
  setExpr getSexpr();

  /**
   * Sets the value of the '{@link uw.cs.watform.forml.forml.Predicate#getSexpr <em>Sexpr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Sexpr</em>' containment reference.
   * @see #getSexpr()
   * @generated
   */
  void setSexpr(setExpr value);

  /**
   * Returns the value of the '<em><b>Quant Pred</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Quant Pred</em>' containment reference.
   * @see #setQuantPred(notPred)
   * @see uw.cs.watform.forml.forml.FormlPackage#getPredicate_QuantPred()
   * @model containment="true"
   * @generated
   */
  notPred getQuantPred();

  /**
   * Sets the value of the '{@link uw.cs.watform.forml.forml.Predicate#getQuantPred <em>Quant Pred</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Quant Pred</em>' containment reference.
   * @see #getQuantPred()
   * @generated
   */
  void setQuantPred(notPred value);

} // Predicate
