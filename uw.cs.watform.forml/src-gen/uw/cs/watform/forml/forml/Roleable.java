/**
 */
package uw.cs.watform.forml.forml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Roleable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uw.cs.watform.forml.forml.Roleable#getAttributes <em>Attributes</em>}</li>
 * </ul>
 *
 * @see uw.cs.watform.forml.forml.FormlPackage#getRoleable()
 * @model
 * @generated
 */
public interface Roleable extends ExprRef, Concept
{
  /**
   * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
   * The list contents are of type {@link uw.cs.watform.forml.forml.ExprRef}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Attributes</em>' containment reference list.
   * @see uw.cs.watform.forml.forml.FormlPackage#getRoleable_Attributes()
   * @model containment="true"
   * @generated
   */
  EList<ExprRef> getAttributes();

} // Roleable
