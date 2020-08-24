/**
 */
package uw.cs.watform.forml.forml;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>set Expr Base</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uw.cs.watform.forml.forml.setExprBase#getAtom <em>Atom</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.setExprBase#getUnspec <em>Unspec</em>}</li>
 * </ul>
 *
 * @see uw.cs.watform.forml.forml.FormlPackage#getsetExprBase()
 * @model
 * @generated
 */
public interface setExprBase extends EObject
{
  /**
   * Returns the value of the '<em><b>Atom</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Atom</em>' containment reference.
   * @see #setAtom(atomic)
   * @see uw.cs.watform.forml.forml.FormlPackage#getsetExprBase_Atom()
   * @model containment="true"
   * @generated
   */
  atomic getAtom();

  /**
   * Sets the value of the '{@link uw.cs.watform.forml.forml.setExprBase#getAtom <em>Atom</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Atom</em>' containment reference.
   * @see #getAtom()
   * @generated
   */
  void setAtom(atomic value);

  /**
   * Returns the value of the '<em><b>Unspec</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Unspec</em>' containment reference.
   * @see #setUnspec(unspecified)
   * @see uw.cs.watform.forml.forml.FormlPackage#getsetExprBase_Unspec()
   * @model containment="true"
   * @generated
   */
  unspecified getUnspec();

  /**
   * Sets the value of the '{@link uw.cs.watform.forml.forml.setExprBase#getUnspec <em>Unspec</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Unspec</em>' containment reference.
   * @see #getUnspec()
   * @generated
   */
  void setUnspec(unspecified value);

} // setExprBase
