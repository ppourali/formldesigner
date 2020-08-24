/**
 */
package uw.cs.watform.forml.forml;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>WCA Fragment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uw.cs.watform.forml.forml.WCAFragment#getRef <em>Ref</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.WCAFragment#getFragType <em>Frag Type</em>}</li>
 * </ul>
 *
 * @see uw.cs.watform.forml.forml.FormlPackage#getWCAFragment()
 * @model
 * @generated
 */
public interface WCAFragment extends EObject
{
  /**
   * Returns the value of the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ref</em>' reference.
   * @see #setRef(WCA)
   * @see uw.cs.watform.forml.forml.FormlPackage#getWCAFragment_Ref()
   * @model
   * @generated
   */
  WCA getRef();

  /**
   * Sets the value of the '{@link uw.cs.watform.forml.forml.WCAFragment#getRef <em>Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ref</em>' reference.
   * @see #getRef()
   * @generated
   */
  void setRef(WCA value);

  /**
   * Returns the value of the '<em><b>Frag Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Frag Type</em>' containment reference.
   * @see #setFragType(Guard)
   * @see uw.cs.watform.forml.forml.FormlPackage#getWCAFragment_FragType()
   * @model containment="true"
   * @generated
   */
  Guard getFragType();

  /**
   * Sets the value of the '{@link uw.cs.watform.forml.forml.WCAFragment#getFragType <em>Frag Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Frag Type</em>' containment reference.
   * @see #getFragType()
   * @generated
   */
  void setFragType(Guard value);

} // WCAFragment
