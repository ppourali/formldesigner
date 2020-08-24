/**
 */
package uw.cs.watform.forml.forml;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>not Pred</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uw.cs.watform.forml.forml.notPred#getPred <em>Pred</em>}</li>
 * </ul>
 *
 * @see uw.cs.watform.forml.forml.FormlPackage#getnotPred()
 * @model
 * @generated
 */
public interface notPred extends EObject
{
  /**
   * Returns the value of the '<em><b>Pred</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Pred</em>' containment reference.
   * @see #setPred(EObject)
   * @see uw.cs.watform.forml.forml.FormlPackage#getnotPred_Pred()
   * @model containment="true"
   * @generated
   */
  EObject getPred();

  /**
   * Sets the value of the '{@link uw.cs.watform.forml.forml.notPred#getPred <em>Pred</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Pred</em>' containment reference.
   * @see #getPred()
   * @generated
   */
  void setPred(EObject value);

} // notPred
