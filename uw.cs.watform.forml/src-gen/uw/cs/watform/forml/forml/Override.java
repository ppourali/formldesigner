/**
 */
package uw.cs.watform.forml.forml;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Override</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uw.cs.watform.forml.forml.Override#getTransition <em>Transition</em>}</li>
 * </ul>
 *
 * @see uw.cs.watform.forml.forml.FormlPackage#getOverride()
 * @model
 * @generated
 */
public interface Override extends EObject
{
  /**
   * Returns the value of the '<em><b>Transition</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Transition</em>' reference.
   * @see #setTransition(Transition)
   * @see uw.cs.watform.forml.forml.FormlPackage#getOverride_Transition()
   * @model
   * @generated
   */
  Transition getTransition();

  /**
   * Sets the value of the '{@link uw.cs.watform.forml.forml.Override#getTransition <em>Transition</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Transition</em>' reference.
   * @see #getTransition()
   * @generated
   */
  void setTransition(Transition value);

} // Override
