/**
 */
package uw.cs.watform.forml.forml;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uw.cs.watform.forml.forml.Constraint#getPredicates <em>Predicates</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.Constraint#getMacro <em>Macro</em>}</li>
 * </ul>
 *
 * @see uw.cs.watform.forml.forml.FormlPackage#getConstraint()
 * @model
 * @generated
 */
public interface Constraint extends EObject
{
  /**
   * Returns the value of the '<em><b>Predicates</b></em>' containment reference list.
   * The list contents are of type {@link uw.cs.watform.forml.forml.Predicate}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Predicates</em>' containment reference list.
   * @see uw.cs.watform.forml.forml.FormlPackage#getConstraint_Predicates()
   * @model containment="true"
   * @generated
   */
  EList<Predicate> getPredicates();

  /**
   * Returns the value of the '<em><b>Macro</b></em>' containment reference list.
   * The list contents are of type {@link uw.cs.watform.forml.forml.Macro}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Macro</em>' containment reference list.
   * @see uw.cs.watform.forml.forml.FormlPackage#getConstraint_Macro()
   * @model containment="true"
   * @generated
   */
  EList<Macro> getMacro();

} // Constraint
