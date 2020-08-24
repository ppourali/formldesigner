/**
 */
package uw.cs.watform.forml.forml;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>WCA List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uw.cs.watform.forml.forml.WCAList#getActions <em>Actions</em>}</li>
 * </ul>
 *
 * @see uw.cs.watform.forml.forml.FormlPackage#getWCAList()
 * @model
 * @generated
 */
public interface WCAList extends EObject
{
  /**
   * Returns the value of the '<em><b>Actions</b></em>' containment reference list.
   * The list contents are of type {@link uw.cs.watform.forml.forml.WCA}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Actions</em>' containment reference list.
   * @see uw.cs.watform.forml.forml.FormlPackage#getWCAList_Actions()
   * @model containment="true"
   * @generated
   */
  EList<WCA> getActions();

} // WCAList
