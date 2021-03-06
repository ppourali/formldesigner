/**
 */
package uw.cs.watform.forml.forml;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cardinality</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uw.cs.watform.forml.forml.Cardinality#getLower <em>Lower</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.Cardinality#getUpper <em>Upper</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.Cardinality#getMany <em>Many</em>}</li>
 * </ul>
 *
 * @see uw.cs.watform.forml.forml.FormlPackage#getCardinality()
 * @model
 * @generated
 */
public interface Cardinality extends EObject
{
  /**
   * Returns the value of the '<em><b>Lower</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Lower</em>' attribute.
   * @see #setLower(int)
   * @see uw.cs.watform.forml.forml.FormlPackage#getCardinality_Lower()
   * @model
   * @generated
   */
  int getLower();

  /**
   * Sets the value of the '{@link uw.cs.watform.forml.forml.Cardinality#getLower <em>Lower</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Lower</em>' attribute.
   * @see #getLower()
   * @generated
   */
  void setLower(int value);

  /**
   * Returns the value of the '<em><b>Upper</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Upper</em>' attribute.
   * @see #setUpper(int)
   * @see uw.cs.watform.forml.forml.FormlPackage#getCardinality_Upper()
   * @model
   * @generated
   */
  int getUpper();

  /**
   * Sets the value of the '{@link uw.cs.watform.forml.forml.Cardinality#getUpper <em>Upper</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Upper</em>' attribute.
   * @see #getUpper()
   * @generated
   */
  void setUpper(int value);

  /**
   * Returns the value of the '<em><b>Many</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Many</em>' attribute.
   * @see #setMany(String)
   * @see uw.cs.watform.forml.forml.FormlPackage#getCardinality_Many()
   * @model
   * @generated
   */
  String getMany();

  /**
   * Sets the value of the '{@link uw.cs.watform.forml.forml.Cardinality#getMany <em>Many</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Many</em>' attribute.
   * @see #getMany()
   * @generated
   */
  void setMany(String value);

} // Cardinality
