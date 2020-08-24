/**
 */
package uw.cs.watform.forml.forml;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reference Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uw.cs.watform.forml.forml.ReferenceType#getRef <em>Ref</em>}</li>
 * </ul>
 *
 * @see uw.cs.watform.forml.forml.FormlPackage#getReferenceType()
 * @model
 * @generated
 */
public interface ReferenceType extends AttributeType
{
  /**
   * Returns the value of the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ref</em>' reference.
   * @see #setRef(Concept)
   * @see uw.cs.watform.forml.forml.FormlPackage#getReferenceType_Ref()
   * @model
   * @generated
   */
  Concept getRef();

  /**
   * Sets the value of the '{@link uw.cs.watform.forml.forml.ReferenceType#getRef <em>Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ref</em>' reference.
   * @see #getRef()
   * @generated
   */
  void setRef(Concept value);

} // ReferenceType
