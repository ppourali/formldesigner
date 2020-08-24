/**
 */
package uw.cs.watform.forml.forml;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Init State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uw.cs.watform.forml.forml.InitState#getStateref <em>Stateref</em>}</li>
 * </ul>
 *
 * @see uw.cs.watform.forml.forml.FormlPackage#getInitState()
 * @model
 * @generated
 */
public interface InitState extends EObject
{
  /**
   * Returns the value of the '<em><b>Stateref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Stateref</em>' reference.
   * @see #setStateref(State)
   * @see uw.cs.watform.forml.forml.FormlPackage#getInitState_Stateref()
   * @model
   * @generated
   */
  State getStateref();

  /**
   * Sets the value of the '{@link uw.cs.watform.forml.forml.InitState#getStateref <em>Stateref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Stateref</em>' reference.
   * @see #getStateref()
   * @generated
   */
  void setStateref(State value);

} // InitState
