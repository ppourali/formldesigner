/**
 */
package uw.cs.watform.forml.forml;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Assign</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uw.cs.watform.forml.forml.Assign#getRef <em>Ref</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.Assign#getSexpr <em>Sexpr</em>}</li>
 * </ul>
 *
 * @see uw.cs.watform.forml.forml.FormlPackage#getAssign()
 * @model
 * @generated
 */
public interface Assign extends EObject
{
  /**
   * Returns the value of the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ref</em>' reference.
   * @see #setRef(ExprRef)
   * @see uw.cs.watform.forml.forml.FormlPackage#getAssign_Ref()
   * @model
   * @generated
   */
  ExprRef getRef();

  /**
   * Sets the value of the '{@link uw.cs.watform.forml.forml.Assign#getRef <em>Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ref</em>' reference.
   * @see #getRef()
   * @generated
   */
  void setRef(ExprRef value);

  /**
   * Returns the value of the '<em><b>Sexpr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sexpr</em>' containment reference.
   * @see #setSexpr(EObject)
   * @see uw.cs.watform.forml.forml.FormlPackage#getAssign_Sexpr()
   * @model containment="true"
   * @generated
   */
  EObject getSexpr();

  /**
   * Sets the value of the '{@link uw.cs.watform.forml.forml.Assign#getSexpr <em>Sexpr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Sexpr</em>' containment reference.
   * @see #getSexpr()
   * @generated
   */
  void setSexpr(EObject value);

} // Assign
