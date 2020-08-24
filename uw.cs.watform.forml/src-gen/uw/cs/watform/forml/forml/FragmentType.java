/**
 */
package uw.cs.watform.forml.forml;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fragment Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uw.cs.watform.forml.forml.FragmentType#getState <em>State</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.FragmentType#getRegion <em>Region</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.FragmentType#getFrag <em>Frag</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.FragmentType#getStatemachine <em>Statemachine</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.FragmentType#getTransitions <em>Transitions</em>}</li>
 * </ul>
 *
 * @see uw.cs.watform.forml.forml.FormlPackage#getFragmentType()
 * @model
 * @generated
 */
public interface FragmentType extends EObject
{
  /**
   * Returns the value of the '<em><b>State</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>State</em>' containment reference.
   * @see #setState(StateContext)
   * @see uw.cs.watform.forml.forml.FormlPackage#getFragmentType_State()
   * @model containment="true"
   * @generated
   */
  StateContext getState();

  /**
   * Sets the value of the '{@link uw.cs.watform.forml.forml.FragmentType#getState <em>State</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>State</em>' containment reference.
   * @see #getState()
   * @generated
   */
  void setState(StateContext value);

  /**
   * Returns the value of the '<em><b>Region</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Region</em>' containment reference.
   * @see #setRegion(RegionContext)
   * @see uw.cs.watform.forml.forml.FormlPackage#getFragmentType_Region()
   * @model containment="true"
   * @generated
   */
  RegionContext getRegion();

  /**
   * Sets the value of the '{@link uw.cs.watform.forml.forml.FragmentType#getRegion <em>Region</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Region</em>' containment reference.
   * @see #getRegion()
   * @generated
   */
  void setRegion(RegionContext value);

  /**
   * Returns the value of the '<em><b>Frag</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Frag</em>' containment reference.
   * @see #setFrag(TranFragment)
   * @see uw.cs.watform.forml.forml.FormlPackage#getFragmentType_Frag()
   * @model containment="true"
   * @generated
   */
  TranFragment getFrag();

  /**
   * Sets the value of the '{@link uw.cs.watform.forml.forml.FragmentType#getFrag <em>Frag</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Frag</em>' containment reference.
   * @see #getFrag()
   * @generated
   */
  void setFrag(TranFragment value);

  /**
   * Returns the value of the '<em><b>Statemachine</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Statemachine</em>' containment reference.
   * @see #setStatemachine(StateMachineContext)
   * @see uw.cs.watform.forml.forml.FormlPackage#getFragmentType_Statemachine()
   * @model containment="true"
   * @generated
   */
  StateMachineContext getStatemachine();

  /**
   * Sets the value of the '{@link uw.cs.watform.forml.forml.FragmentType#getStatemachine <em>Statemachine</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Statemachine</em>' containment reference.
   * @see #getStatemachine()
   * @generated
   */
  void setStatemachine(StateMachineContext value);

  /**
   * Returns the value of the '<em><b>Transitions</b></em>' containment reference list.
   * The list contents are of type {@link uw.cs.watform.forml.forml.Transition}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Transitions</em>' containment reference list.
   * @see uw.cs.watform.forml.forml.FormlPackage#getFragmentType_Transitions()
   * @model containment="true"
   * @generated
   */
  EList<Transition> getTransitions();

} // FragmentType
