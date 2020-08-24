/**
 */
package uw.cs.watform.forml.forml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Input</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uw.cs.watform.forml.forml.Input#getTos <em>Tos</em>}</li>
 * </ul>
 *
 * @see uw.cs.watform.forml.forml.FormlPackage#getInput()
 * @model
 * @generated
 */
public interface Input extends Message
{
  /**
   * Returns the value of the '<em><b>Tos</b></em>' reference list.
   * The list contents are of type {@link uw.cs.watform.forml.forml.Feature}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Tos</em>' reference list.
   * @see uw.cs.watform.forml.forml.FormlPackage#getInput_Tos()
   * @model
   * @generated
   */
  EList<Feature> getTos();

} // Input
