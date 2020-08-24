/**
 */
package uw.cs.watform.forml.forml;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State Context</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uw.cs.watform.forml.forml.StateContext#getRef <em>Ref</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.StateContext#getRegions <em>Regions</em>}</li>
 * </ul>
 *
 * @see uw.cs.watform.forml.forml.FormlPackage#getStateContext()
 * @model
 * @generated
 */
public interface StateContext extends EObject
{
  /**
   * Returns the value of the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ref</em>' reference.
   * @see #setRef(State)
   * @see uw.cs.watform.forml.forml.FormlPackage#getStateContext_Ref()
   * @model
   * @generated
   */
  State getRef();

  /**
   * Sets the value of the '{@link uw.cs.watform.forml.forml.StateContext#getRef <em>Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ref</em>' reference.
   * @see #getRef()
   * @generated
   */
  void setRef(State value);

  /**
   * Returns the value of the '<em><b>Regions</b></em>' containment reference list.
   * The list contents are of type {@link uw.cs.watform.forml.forml.Component}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Regions</em>' containment reference list.
   * @see uw.cs.watform.forml.forml.FormlPackage#getStateContext_Regions()
   * @model containment="true"
   * @generated
   */
  EList<Component> getRegions();

} // StateContext
