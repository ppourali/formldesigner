/**
 */
package uw.cs.watform.forml.forml;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uw.cs.watform.forml.forml.Feature#getInputlist <em>Inputlist</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.Feature#getOutputlist <em>Outputlist</em>}</li>
 * </ul>
 *
 * @see uw.cs.watform.forml.forml.FormlPackage#getFeature()
 * @model
 * @generated
 */
public interface Feature extends Roleable
{
  /**
   * Returns the value of the '<em><b>Inputlist</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Inputlist</em>' containment reference.
   * @see #setInputlist(InputList)
   * @see uw.cs.watform.forml.forml.FormlPackage#getFeature_Inputlist()
   * @model containment="true"
   * @generated
   */
  InputList getInputlist();

  /**
   * Sets the value of the '{@link uw.cs.watform.forml.forml.Feature#getInputlist <em>Inputlist</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Inputlist</em>' containment reference.
   * @see #getInputlist()
   * @generated
   */
  void setInputlist(InputList value);

  /**
   * Returns the value of the '<em><b>Outputlist</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Outputlist</em>' containment reference.
   * @see #setOutputlist(OutputList)
   * @see uw.cs.watform.forml.forml.FormlPackage#getFeature_Outputlist()
   * @model containment="true"
   * @generated
   */
  OutputList getOutputlist();

  /**
   * Sets the value of the '{@link uw.cs.watform.forml.forml.Feature#getOutputlist <em>Outputlist</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Outputlist</em>' containment reference.
   * @see #getOutputlist()
   * @generated
   */
  void setOutputlist(OutputList value);

} // Feature
