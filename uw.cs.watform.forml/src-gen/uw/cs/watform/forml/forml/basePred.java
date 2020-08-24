/**
 */
package uw.cs.watform.forml.forml;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>base Pred</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uw.cs.watform.forml.forml.basePred#getLogicop <em>Logicop</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.basePred#getCardpred <em>Cardpred</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.basePred#getSetlhs <em>Setlhs</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.basePred#getSetrhs <em>Setrhs</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.basePred#getBoolrhs <em>Boolrhs</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.basePred#getIntlhs <em>Intlhs</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.basePred#getOp <em>Op</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.basePred#getIntrhs <em>Intrhs</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.basePred#getParenPred <em>Paren Pred</em>}</li>
 * </ul>
 *
 * @see uw.cs.watform.forml.forml.FormlPackage#getbasePred()
 * @model
 * @generated
 */
public interface basePred extends EObject
{
  /**
   * Returns the value of the '<em><b>Logicop</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Logicop</em>' attribute.
   * @see #setLogicop(String)
   * @see uw.cs.watform.forml.forml.FormlPackage#getbasePred_Logicop()
   * @model
   * @generated
   */
  String getLogicop();

  /**
   * Sets the value of the '{@link uw.cs.watform.forml.forml.basePred#getLogicop <em>Logicop</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Logicop</em>' attribute.
   * @see #getLogicop()
   * @generated
   */
  void setLogicop(String value);

  /**
   * Returns the value of the '<em><b>Cardpred</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Cardpred</em>' containment reference.
   * @see #setCardpred(setExpr)
   * @see uw.cs.watform.forml.forml.FormlPackage#getbasePred_Cardpred()
   * @model containment="true"
   * @generated
   */
  setExpr getCardpred();

  /**
   * Sets the value of the '{@link uw.cs.watform.forml.forml.basePred#getCardpred <em>Cardpred</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Cardpred</em>' containment reference.
   * @see #getCardpred()
   * @generated
   */
  void setCardpred(setExpr value);

  /**
   * Returns the value of the '<em><b>Setlhs</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Setlhs</em>' containment reference.
   * @see #setSetlhs(predExpr)
   * @see uw.cs.watform.forml.forml.FormlPackage#getbasePred_Setlhs()
   * @model containment="true"
   * @generated
   */
  predExpr getSetlhs();

  /**
   * Sets the value of the '{@link uw.cs.watform.forml.forml.basePred#getSetlhs <em>Setlhs</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Setlhs</em>' containment reference.
   * @see #getSetlhs()
   * @generated
   */
  void setSetlhs(predExpr value);

  /**
   * Returns the value of the '<em><b>Setrhs</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Setrhs</em>' containment reference.
   * @see #setSetrhs(predExpr)
   * @see uw.cs.watform.forml.forml.FormlPackage#getbasePred_Setrhs()
   * @model containment="true"
   * @generated
   */
  predExpr getSetrhs();

  /**
   * Sets the value of the '{@link uw.cs.watform.forml.forml.basePred#getSetrhs <em>Setrhs</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Setrhs</em>' containment reference.
   * @see #getSetrhs()
   * @generated
   */
  void setSetrhs(predExpr value);

  /**
   * Returns the value of the '<em><b>Boolrhs</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Boolrhs</em>' containment reference.
   * @see #setBoolrhs(boolExpr)
   * @see uw.cs.watform.forml.forml.FormlPackage#getbasePred_Boolrhs()
   * @model containment="true"
   * @generated
   */
  boolExpr getBoolrhs();

  /**
   * Sets the value of the '{@link uw.cs.watform.forml.forml.basePred#getBoolrhs <em>Boolrhs</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Boolrhs</em>' containment reference.
   * @see #getBoolrhs()
   * @generated
   */
  void setBoolrhs(boolExpr value);

  /**
   * Returns the value of the '<em><b>Intlhs</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Intlhs</em>' containment reference.
   * @see #setIntlhs(intExpr)
   * @see uw.cs.watform.forml.forml.FormlPackage#getbasePred_Intlhs()
   * @model containment="true"
   * @generated
   */
  intExpr getIntlhs();

  /**
   * Sets the value of the '{@link uw.cs.watform.forml.forml.basePred#getIntlhs <em>Intlhs</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Intlhs</em>' containment reference.
   * @see #getIntlhs()
   * @generated
   */
  void setIntlhs(intExpr value);

  /**
   * Returns the value of the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Op</em>' attribute.
   * @see #setOp(String)
   * @see uw.cs.watform.forml.forml.FormlPackage#getbasePred_Op()
   * @model
   * @generated
   */
  String getOp();

  /**
   * Sets the value of the '{@link uw.cs.watform.forml.forml.basePred#getOp <em>Op</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Op</em>' attribute.
   * @see #getOp()
   * @generated
   */
  void setOp(String value);

  /**
   * Returns the value of the '<em><b>Intrhs</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Intrhs</em>' containment reference.
   * @see #setIntrhs(intExpr)
   * @see uw.cs.watform.forml.forml.FormlPackage#getbasePred_Intrhs()
   * @model containment="true"
   * @generated
   */
  intExpr getIntrhs();

  /**
   * Sets the value of the '{@link uw.cs.watform.forml.forml.basePred#getIntrhs <em>Intrhs</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Intrhs</em>' containment reference.
   * @see #getIntrhs()
   * @generated
   */
  void setIntrhs(intExpr value);

  /**
   * Returns the value of the '<em><b>Paren Pred</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Paren Pred</em>' containment reference.
   * @see #setParenPred(Predicate)
   * @see uw.cs.watform.forml.forml.FormlPackage#getbasePred_ParenPred()
   * @model containment="true"
   * @generated
   */
  Predicate getParenPred();

  /**
   * Sets the value of the '{@link uw.cs.watform.forml.forml.basePred#getParenPred <em>Paren Pred</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Paren Pred</em>' containment reference.
   * @see #getParenPred()
   * @generated
   */
  void setParenPred(Predicate value);

} // basePred
