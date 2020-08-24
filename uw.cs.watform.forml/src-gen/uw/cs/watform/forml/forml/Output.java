/**
 */
package uw.cs.watform.forml.forml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Output</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uw.cs.watform.forml.forml.Output#getFroms <em>Froms</em>}</li>
 * </ul>
 *
 * @see uw.cs.watform.forml.forml.FormlPackage#getOutput()
 * @model
 * @generated
 */
public interface Output extends Message
{
  /**
   * Returns the value of the '<em><b>Froms</b></em>' reference list.
   * The list contents are of type {@link uw.cs.watform.forml.forml.Feature}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Froms</em>' reference list.
   * @see uw.cs.watform.forml.forml.FormlPackage#getOutput_Froms()
   * @model
   * @generated
   */
  EList<Feature> getFroms();

} // Output
