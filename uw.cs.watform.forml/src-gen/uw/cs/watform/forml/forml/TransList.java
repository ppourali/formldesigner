/**
 */
package uw.cs.watform.forml.forml;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Trans List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uw.cs.watform.forml.forml.TransList#getTransitions <em>Transitions</em>}</li>
 * </ul>
 *
 * @see uw.cs.watform.forml.forml.FormlPackage#getTransList()
 * @model
 * @generated
 */
public interface TransList extends EObject
{
  /**
   * Returns the value of the '<em><b>Transitions</b></em>' reference list.
   * The list contents are of type {@link uw.cs.watform.forml.forml.Transition}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Transitions</em>' reference list.
   * @see uw.cs.watform.forml.forml.FormlPackage#getTransList_Transitions()
   * @model
   * @generated
   */
  EList<Transition> getTransitions();

} // TransList
