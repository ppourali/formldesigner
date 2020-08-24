/**
 */
package uw.cs.watform.forml.forml;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>int Base</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uw.cs.watform.forml.forml.intBase#getAtom <em>Atom</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.intBase#getNum <em>Num</em>}</li>
 * </ul>
 *
 * @see uw.cs.watform.forml.forml.FormlPackage#getintBase()
 * @model
 * @generated
 */
public interface intBase extends EObject
{
  /**
   * Returns the value of the '<em><b>Atom</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Atom</em>' containment reference.
   * @see #setAtom(atomic)
   * @see uw.cs.watform.forml.forml.FormlPackage#getintBase_Atom()
   * @model containment="true"
   * @generated
   */
  atomic getAtom();

  /**
   * Sets the value of the '{@link uw.cs.watform.forml.forml.intBase#getAtom <em>Atom</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Atom</em>' containment reference.
   * @see #getAtom()
   * @generated
   */
  void setAtom(atomic value);

  /**
   * Returns the value of the '<em><b>Num</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Num</em>' attribute.
   * @see #setNum(int)
   * @see uw.cs.watform.forml.forml.FormlPackage#getintBase_Num()
   * @model
   * @generated
   */
  int getNum();

  /**
   * Sets the value of the '{@link uw.cs.watform.forml.forml.intBase#getNum <em>Num</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Num</em>' attribute.
   * @see #getNum()
   * @generated
   */
  void setNum(int value);

} // intBase
