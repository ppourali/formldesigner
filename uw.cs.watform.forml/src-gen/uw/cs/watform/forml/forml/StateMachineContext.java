/**
 */
package uw.cs.watform.forml.forml;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State Machine Context</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uw.cs.watform.forml.forml.StateMachineContext#getRef <em>Ref</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.StateMachineContext#getState <em>State</em>}</li>
 * </ul>
 *
 * @see uw.cs.watform.forml.forml.FormlPackage#getStateMachineContext()
 * @model
 * @generated
 */
public interface StateMachineContext extends EObject
{
  /**
   * Returns the value of the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ref</em>' reference.
   * @see #setRef(StateMachine)
   * @see uw.cs.watform.forml.forml.FormlPackage#getStateMachineContext_Ref()
   * @model
   * @generated
   */
  StateMachine getRef();

  /**
   * Sets the value of the '{@link uw.cs.watform.forml.forml.StateMachineContext#getRef <em>Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ref</em>' reference.
   * @see #getRef()
   * @generated
   */
  void setRef(StateMachine value);

  /**
   * Returns the value of the '<em><b>State</b></em>' containment reference list.
   * The list contents are of type {@link uw.cs.watform.forml.forml.Component}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>State</em>' containment reference list.
   * @see uw.cs.watform.forml.forml.FormlPackage#getStateMachineContext_State()
   * @model containment="true"
   * @generated
   */
  EList<Component> getState();

} // StateMachineContext
