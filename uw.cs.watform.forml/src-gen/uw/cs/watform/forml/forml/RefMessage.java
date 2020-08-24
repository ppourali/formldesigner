/**
 */
package uw.cs.watform.forml.forml;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ref Message</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uw.cs.watform.forml.forml.RefMessage#getRefMsg <em>Ref Msg</em>}</li>
 * </ul>
 *
 * @see uw.cs.watform.forml.forml.FormlPackage#getRefMessage()
 * @model
 * @generated
 */
public interface RefMessage extends EObject
{
  /**
   * Returns the value of the '<em><b>Ref Msg</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ref Msg</em>' reference.
   * @see #setRefMsg(Message)
   * @see uw.cs.watform.forml.forml.FormlPackage#getRefMessage_RefMsg()
   * @model
   * @generated
   */
  Message getRefMsg();

  /**
   * Sets the value of the '{@link uw.cs.watform.forml.forml.RefMessage#getRefMsg <em>Ref Msg</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ref Msg</em>' reference.
   * @see #getRefMsg()
   * @generated
   */
  void setRefMsg(Message value);

} // RefMessage
