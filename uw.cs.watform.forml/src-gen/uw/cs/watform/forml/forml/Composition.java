/**
 */
package uw.cs.watform.forml.forml;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uw.cs.watform.forml.forml.Composition#getWhole <em>Whole</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.Composition#getPart <em>Part</em>}</li>
 * </ul>
 *
 * @see uw.cs.watform.forml.forml.FormlPackage#getComposition()
 * @model
 * @generated
 */
public interface Composition extends Relationship
{
  /**
   * Returns the value of the '<em><b>Whole</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Whole</em>' containment reference.
   * @see #setWhole(Decl)
   * @see uw.cs.watform.forml.forml.FormlPackage#getComposition_Whole()
   * @model containment="true"
   * @generated
   */
  Decl getWhole();

  /**
   * Sets the value of the '{@link uw.cs.watform.forml.forml.Composition#getWhole <em>Whole</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Whole</em>' containment reference.
   * @see #getWhole()
   * @generated
   */
  void setWhole(Decl value);

  /**
   * Returns the value of the '<em><b>Part</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Part</em>' containment reference.
   * @see #setPart(Decl)
   * @see uw.cs.watform.forml.forml.FormlPackage#getComposition_Part()
   * @model containment="true"
   * @generated
   */
  Decl getPart();

  /**
   * Sets the value of the '{@link uw.cs.watform.forml.forml.Composition#getPart <em>Part</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Part</em>' containment reference.
   * @see #getPart()
   * @generated
   */
  void setPart(Decl value);

} // Composition
