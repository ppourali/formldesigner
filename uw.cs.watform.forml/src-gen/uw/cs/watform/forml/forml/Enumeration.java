/**
 */
package uw.cs.watform.forml.forml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enumeration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uw.cs.watform.forml.forml.Enumeration#getConstant <em>Constant</em>}</li>
 * </ul>
 *
 * @see uw.cs.watform.forml.forml.FormlPackage#getEnumeration()
 * @model
 * @generated
 */
public interface Enumeration extends Concept
{
  /**
   * Returns the value of the '<em><b>Constant</b></em>' containment reference list.
   * The list contents are of type {@link uw.cs.watform.forml.forml.ExprRef}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Constant</em>' containment reference list.
   * @see uw.cs.watform.forml.forml.FormlPackage#getEnumeration_Constant()
   * @model containment="true"
   * @generated
   */
  EList<ExprRef> getConstant();

} // Enumeration
