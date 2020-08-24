/**
 */
package uw.cs.watform.forml.forml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Association</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uw.cs.watform.forml.forml.Association#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.Association#getSrcRole <em>Src Role</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.Association#getDesRole <em>Des Role</em>}</li>
 * </ul>
 *
 * @see uw.cs.watform.forml.forml.FormlPackage#getAssociation()
 * @model
 * @generated
 */
public interface Association extends Relationship
{
  /**
   * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
   * The list contents are of type {@link uw.cs.watform.forml.forml.ExprRef}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Attributes</em>' containment reference list.
   * @see uw.cs.watform.forml.forml.FormlPackage#getAssociation_Attributes()
   * @model containment="true"
   * @generated
   */
  EList<ExprRef> getAttributes();

  /**
   * Returns the value of the '<em><b>Src Role</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Src Role</em>' containment reference.
   * @see #setSrcRole(Role)
   * @see uw.cs.watform.forml.forml.FormlPackage#getAssociation_SrcRole()
   * @model containment="true"
   * @generated
   */
  Role getSrcRole();

  /**
   * Sets the value of the '{@link uw.cs.watform.forml.forml.Association#getSrcRole <em>Src Role</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Src Role</em>' containment reference.
   * @see #getSrcRole()
   * @generated
   */
  void setSrcRole(Role value);

  /**
   * Returns the value of the '<em><b>Des Role</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Des Role</em>' containment reference.
   * @see #setDesRole(Role)
   * @see uw.cs.watform.forml.forml.FormlPackage#getAssociation_DesRole()
   * @model containment="true"
   * @generated
   */
  Role getDesRole();

  /**
   * Sets the value of the '{@link uw.cs.watform.forml.forml.Association#getDesRole <em>Des Role</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Des Role</em>' containment reference.
   * @see #getDesRole()
   * @generated
   */
  void setDesRole(Role value);

} // Association
