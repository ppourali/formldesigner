/**
 */
package uw.cs.watform.forml.forml;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Assign List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uw.cs.watform.forml.forml.AssignList#getList <em>List</em>}</li>
 * </ul>
 *
 * @see uw.cs.watform.forml.forml.FormlPackage#getAssignList()
 * @model
 * @generated
 */
public interface AssignList extends EObject
{
  /**
   * Returns the value of the '<em><b>List</b></em>' containment reference list.
   * The list contents are of type {@link uw.cs.watform.forml.forml.Assign}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>List</em>' containment reference list.
   * @see uw.cs.watform.forml.forml.FormlPackage#getAssignList_List()
   * @model containment="true"
   * @generated
   */
  EList<Assign> getList();

} // AssignList
