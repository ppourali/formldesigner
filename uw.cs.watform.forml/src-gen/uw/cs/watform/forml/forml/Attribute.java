/**
 */
package uw.cs.watform.forml.forml;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uw.cs.watform.forml.forml.Attribute#isCtrl <em>Ctrl</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.Attribute#getName <em>Name</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.Attribute#getMultiplicity <em>Multiplicity</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.Attribute#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see uw.cs.watform.forml.forml.FormlPackage#getAttribute()
 * @model
 * @generated
 */
public interface Attribute extends ExprRef
{
  /**
   * Returns the value of the '<em><b>Ctrl</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ctrl</em>' attribute.
   * @see #setCtrl(boolean)
   * @see uw.cs.watform.forml.forml.FormlPackage#getAttribute_Ctrl()
   * @model
   * @generated
   */
  boolean isCtrl();

  /**
   * Sets the value of the '{@link uw.cs.watform.forml.forml.Attribute#isCtrl <em>Ctrl</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ctrl</em>' attribute.
   * @see #isCtrl()
   * @generated
   */
  void setCtrl(boolean value);

  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see uw.cs.watform.forml.forml.FormlPackage#getAttribute_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link uw.cs.watform.forml.forml.Attribute#getName <em>Name</em>}' attribute.
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
   * @see uw.cs.watform.forml.forml.FormlPackage#getAttribute_Multiplicity()
   * @model containment="true"
   * @generated
   */
  Multiplicity getMultiplicity();

  /**
   * Sets the value of the '{@link uw.cs.watform.forml.forml.Attribute#getMultiplicity <em>Multiplicity</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Multiplicity</em>' containment reference.
   * @see #getMultiplicity()
   * @generated
   */
  void setMultiplicity(Multiplicity value);

  /**
   * Returns the value of the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' containment reference.
   * @see #setType(AttributeType)
   * @see uw.cs.watform.forml.forml.FormlPackage#getAttribute_Type()
   * @model containment="true"
   * @generated
   */
  AttributeType getType();

  /**
   * Sets the value of the '{@link uw.cs.watform.forml.forml.Attribute#getType <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' containment reference.
   * @see #getType()
   * @generated
   */
  void setType(AttributeType value);

} // Attribute
