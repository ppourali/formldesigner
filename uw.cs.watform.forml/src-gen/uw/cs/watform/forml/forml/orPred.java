/**
 */
package uw.cs.watform.forml.forml;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>or Pred</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uw.cs.watform.forml.forml.orPred#getPreds <em>Preds</em>}</li>
 * </ul>
 *
 * @see uw.cs.watform.forml.forml.FormlPackage#getorPred()
 * @model
 * @generated
 */
public interface orPred extends EObject
{
  /**
   * Returns the value of the '<em><b>Preds</b></em>' containment reference list.
   * The list contents are of type {@link uw.cs.watform.forml.forml.basePred}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Preds</em>' containment reference list.
   * @see uw.cs.watform.forml.forml.FormlPackage#getorPred_Preds()
   * @model containment="true"
   * @generated
   */
  EList<basePred> getPreds();

} // orPred
