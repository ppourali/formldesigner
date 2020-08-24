/**
 */
package uw.cs.watform.forml.forml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Message</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uw.cs.watform.forml.forml.Message#getType <em>Type</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.Message#getAttributes <em>Attributes</em>}</li>
 * </ul>
 *
 * @see uw.cs.watform.forml.forml.FormlPackage#getMessage()
 * @model
 * @generated
 */
public interface Message extends Concept
{
  /**
   * Returns the value of the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' containment reference.
   * @see #setType(AttributeType)
   * @see uw.cs.watform.forml.forml.FormlPackage#getMessage_Type()
   * @model containment="true"
   * @generated
   */
  AttributeType getType();

  /**
   * Sets the value of the '{@link uw.cs.watform.forml.forml.Message#getType <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' containment reference.
   * @see #getType()
   * @generated
   */
  void setType(AttributeType value);

  /**
   * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
   * The list contents are of type {@link uw.cs.watform.forml.forml.ExprRef}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Attributes</em>' containment reference list.
   * @see uw.cs.watform.forml.forml.FormlPackage#getMessage_Attributes()
   * @model containment="true"
   * @generated
   */
  EList<ExprRef> getAttributes();

} // Message
