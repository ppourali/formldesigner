/**
 */
package uw.cs.watform.forml.forml;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Output List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uw.cs.watform.forml.forml.OutputList#getOutputs <em>Outputs</em>}</li>
 * </ul>
 *
 * @see uw.cs.watform.forml.forml.FormlPackage#getOutputList()
 * @model
 * @generated
 */
public interface OutputList extends EObject
{
  /**
   * Returns the value of the '<em><b>Outputs</b></em>' containment reference list.
   * The list contents are of type {@link uw.cs.watform.forml.forml.RefMessage}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Outputs</em>' containment reference list.
   * @see uw.cs.watform.forml.forml.FormlPackage#getOutputList_Outputs()
   * @model containment="true"
   * @generated
   */
  EList<RefMessage> getOutputs();

} // OutputList
