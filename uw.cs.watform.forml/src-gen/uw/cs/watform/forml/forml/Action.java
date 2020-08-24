/**
 */
package uw.cs.watform.forml.forml;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uw.cs.watform.forml.forml.Action#getType <em>Type</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.Action#getOut <em>Out</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.Action#getList <em>List</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.Action#getMinexpr <em>Minexpr</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.Action#getLvalue <em>Lvalue</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.Action#getRvalue <em>Rvalue</em>}</li>
 * </ul>
 *
 * @see uw.cs.watform.forml.forml.FormlPackage#getAction()
 * @model
 * @generated
 */
public interface Action extends EObject
{
  /**
   * Returns the value of the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' reference.
   * @see #setType(ExprRef)
   * @see uw.cs.watform.forml.forml.FormlPackage#getAction_Type()
   * @model
   * @generated
   */
  ExprRef getType();

  /**
   * Sets the value of the '{@link uw.cs.watform.forml.forml.Action#getType <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' reference.
   * @see #getType()
   * @generated
   */
  void setType(ExprRef value);

  /**
   * Returns the value of the '<em><b>Out</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Out</em>' reference.
   * @see #setOut(Output)
   * @see uw.cs.watform.forml.forml.FormlPackage#getAction_Out()
   * @model
   * @generated
   */
  Output getOut();

  /**
   * Sets the value of the '{@link uw.cs.watform.forml.forml.Action#getOut <em>Out</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Out</em>' reference.
   * @see #getOut()
   * @generated
   */
  void setOut(Output value);

  /**
   * Returns the value of the '<em><b>List</b></em>' containment reference list.
   * The list contents are of type {@link uw.cs.watform.forml.forml.AssignList}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>List</em>' containment reference list.
   * @see uw.cs.watform.forml.forml.FormlPackage#getAction_List()
   * @model containment="true"
   * @generated
   */
  EList<AssignList> getList();

  /**
   * Returns the value of the '<em><b>Minexpr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Minexpr</em>' containment reference.
   * @see #setMinexpr(setExpr)
   * @see uw.cs.watform.forml.forml.FormlPackage#getAction_Minexpr()
   * @model containment="true"
   * @generated
   */
  setExpr getMinexpr();

  /**
   * Sets the value of the '{@link uw.cs.watform.forml.forml.Action#getMinexpr <em>Minexpr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Minexpr</em>' containment reference.
   * @see #getMinexpr()
   * @generated
   */
  void setMinexpr(setExpr value);

  /**
   * Returns the value of the '<em><b>Lvalue</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Lvalue</em>' containment reference.
   * @see #setLvalue(EObject)
   * @see uw.cs.watform.forml.forml.FormlPackage#getAction_Lvalue()
   * @model containment="true"
   * @generated
   */
  EObject getLvalue();

  /**
   * Sets the value of the '{@link uw.cs.watform.forml.forml.Action#getLvalue <em>Lvalue</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Lvalue</em>' containment reference.
   * @see #getLvalue()
   * @generated
   */
  void setLvalue(EObject value);

  /**
   * Returns the value of the '<em><b>Rvalue</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Rvalue</em>' containment reference.
   * @see #setRvalue(EObject)
   * @see uw.cs.watform.forml.forml.FormlPackage#getAction_Rvalue()
   * @model containment="true"
   * @generated
   */
  EObject getRvalue();

  /**
   * Sets the value of the '{@link uw.cs.watform.forml.forml.Action#getRvalue <em>Rvalue</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Rvalue</em>' containment reference.
   * @see #getRvalue()
   * @generated
   */
  void setRvalue(EObject value);

} // Action
