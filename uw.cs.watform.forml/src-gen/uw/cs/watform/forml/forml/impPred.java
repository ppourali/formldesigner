/**
 */
package uw.cs.watform.forml.forml;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>imp Pred</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uw.cs.watform.forml.forml.impPred#getPreds <em>Preds</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.impPred#getLogicop <em>Logicop</em>}</li>
 * </ul>
 *
 * @see uw.cs.watform.forml.forml.FormlPackage#getimpPred()
 * @model
 * @generated
 */
public interface impPred extends EObject
{
  /**
   * Returns the value of the '<em><b>Preds</b></em>' containment reference list.
   * The list contents are of type {@link uw.cs.watform.forml.forml.orPred}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Preds</em>' containment reference list.
   * @see uw.cs.watform.forml.forml.FormlPackage#getimpPred_Preds()
   * @model containment="true"
   * @generated
   */
  EList<orPred> getPreds();

  /**
   * Returns the value of the '<em><b>Logicop</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Logicop</em>' attribute list.
   * @see uw.cs.watform.forml.forml.FormlPackage#getimpPred_Logicop()
   * @model unique="false"
   * @generated
   */
  EList<String> getLogicop();

} // impPred
