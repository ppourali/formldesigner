/**
 */
package uw.cs.watform.forml.forml;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>World Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uw.cs.watform.forml.forml.WorldModel#getConcepts <em>Concepts</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.WorldModel#getConstraints <em>Constraints</em>}</li>
 * </ul>
 *
 * @see uw.cs.watform.forml.forml.FormlPackage#getWorldModel()
 * @model
 * @generated
 */
public interface WorldModel extends EObject
{
  /**
   * Returns the value of the '<em><b>Concepts</b></em>' containment reference list.
   * The list contents are of type {@link uw.cs.watform.forml.forml.ExprRef}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Concepts</em>' containment reference list.
   * @see uw.cs.watform.forml.forml.FormlPackage#getWorldModel_Concepts()
   * @model containment="true"
   * @generated
   */
  EList<ExprRef> getConcepts();

  /**
   * Returns the value of the '<em><b>Constraints</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Constraints</em>' containment reference.
   * @see #setConstraints(Constraint)
   * @see uw.cs.watform.forml.forml.FormlPackage#getWorldModel_Constraints()
   * @model containment="true"
   * @generated
   */
  Constraint getConstraints();

  /**
   * Sets the value of the '{@link uw.cs.watform.forml.forml.WorldModel#getConstraints <em>Constraints</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Constraints</em>' containment reference.
   * @see #getConstraints()
   * @generated
   */
  void setConstraints(Constraint value);

} // WorldModel
