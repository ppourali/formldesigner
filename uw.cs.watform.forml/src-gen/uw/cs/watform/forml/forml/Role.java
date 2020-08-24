/**
 */
package uw.cs.watform.forml.forml;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Role</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uw.cs.watform.forml.forml.Role#getName <em>Name</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.Role#getMultiplicity <em>Multiplicity</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.Role#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see uw.cs.watform.forml.forml.FormlPackage#getRole()
 * @model
 * @generated
 */
public interface Role extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see uw.cs.watform.forml.forml.FormlPackage#getRole_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link uw.cs.watform.forml.forml.Role#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Multiplicity</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Multiplicity</em>' containment reference.
   * @see #setMultiplicity(Multiplicity)
   * @see uw.cs.watform.forml.forml.FormlPackage#getRole_Multiplicity()
   * @model containment="true"
   * @generated
   */
  Multiplicity getMultiplicity();

  /**
   * Sets the value of the '{@link uw.cs.watform.forml.forml.Role#getMultiplicity <em>Multiplicity</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Multiplicity</em>' containment reference.
   * @see #getMultiplicity()
   * @generated
   */
  void setMultiplicity(Multiplicity value);

  /**
   * Returns the value of the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' reference.
   * @see #setType(Roleable)
   * @see uw.cs.watform.forml.forml.FormlPackage#getRole_Type()
   * @model
   * @generated
   */
  Roleable getType();

  /**
   * Sets the value of the '{@link uw.cs.watform.forml.forml.Role#getType <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' reference.
   * @see #getType()
   * @generated
   */
  void setType(Roleable value);

} // Role
