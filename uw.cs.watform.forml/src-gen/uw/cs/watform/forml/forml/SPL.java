/**
 */
package uw.cs.watform.forml.forml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SPL</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uw.cs.watform.forml.forml.SPL#getName <em>Name</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.SPL#getXors <em>Xors</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.SPL#getAnds <em>Ands</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.SPL#getOrs <em>Ors</em>}</li>
 * </ul>
 *
 * @see uw.cs.watform.forml.forml.FormlPackage#getSPL()
 * @model
 * @generated
 */
public interface SPL extends Node
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see uw.cs.watform.forml.forml.FormlPackage#getSPL_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link uw.cs.watform.forml.forml.SPL#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Xors</b></em>' containment reference list.
   * The list contents are of type {@link uw.cs.watform.forml.forml.Node}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Xors</em>' containment reference list.
   * @see uw.cs.watform.forml.forml.FormlPackage#getSPL_Xors()
   * @model containment="true"
   * @generated
   */
  EList<Node> getXors();

  /**
   * Returns the value of the '<em><b>Ands</b></em>' containment reference list.
   * The list contents are of type {@link uw.cs.watform.forml.forml.Node}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ands</em>' containment reference list.
   * @see uw.cs.watform.forml.forml.FormlPackage#getSPL_Ands()
   * @model containment="true"
   * @generated
   */
  EList<Node> getAnds();

  /**
   * Returns the value of the '<em><b>Ors</b></em>' containment reference list.
   * The list contents are of type {@link uw.cs.watform.forml.forml.Node}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ors</em>' containment reference list.
   * @see uw.cs.watform.forml.forml.FormlPackage#getSPL_Ors()
   * @model containment="true"
   * @generated
   */
  EList<Node> getOrs();

} // SPL
