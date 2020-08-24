/**
 */
package uw.cs.watform.forml.forml;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>WCA Fragment List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uw.cs.watform.forml.forml.WCAFragmentList#getFrag <em>Frag</em>}</li>
 * </ul>
 *
 * @see uw.cs.watform.forml.forml.FormlPackage#getWCAFragmentList()
 * @model
 * @generated
 */
public interface WCAFragmentList extends EObject
{
  /**
   * Returns the value of the '<em><b>Frag</b></em>' containment reference list.
   * The list contents are of type {@link uw.cs.watform.forml.forml.WCAFragment}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Frag</em>' containment reference list.
   * @see uw.cs.watform.forml.forml.FormlPackage#getWCAFragmentList_Frag()
   * @model containment="true"
   * @generated
   */
  EList<WCAFragment> getFrag();

} // WCAFragmentList
