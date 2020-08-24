/**
 */
package uw.cs.watform.forml.forml;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>WCE</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uw.cs.watform.forml.forml.WCE#getAddobj <em>Addobj</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.WCE#getAttr <em>Attr</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.WCE#getRemobj <em>Remobj</em>}</li>
 * </ul>
 *
 * @see uw.cs.watform.forml.forml.FormlPackage#getWCE()
 * @model
 * @generated
 */
public interface WCE extends EObject
{
  /**
   * Returns the value of the '<em><b>Addobj</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Addobj</em>' reference.
   * @see #setAddobj(ExprRef)
   * @see uw.cs.watform.forml.forml.FormlPackage#getWCE_Addobj()
   * @model
   * @generated
   */
  ExprRef getAddobj();

  /**
   * Sets the value of the '{@link uw.cs.watform.forml.forml.WCE#getAddobj <em>Addobj</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Addobj</em>' reference.
   * @see #getAddobj()
   * @generated
   */
  void setAddobj(ExprRef value);

  /**
   * Returns the value of the '<em><b>Attr</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Attr</em>' reference.
   * @see #setAttr(Attribute)
   * @see uw.cs.watform.forml.forml.FormlPackage#getWCE_Attr()
   * @model
   * @generated
   */
  Attribute getAttr();

  /**
   * Sets the value of the '{@link uw.cs.watform.forml.forml.WCE#getAttr <em>Attr</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Attr</em>' reference.
   * @see #getAttr()
   * @generated
   */
  void setAttr(Attribute value);

  /**
   * Returns the value of the '<em><b>Remobj</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Remobj</em>' reference.
   * @see #setRemobj(ExprRef)
   * @see uw.cs.watform.forml.forml.FormlPackage#getWCE_Remobj()
   * @model
   * @generated
   */
  ExprRef getRemobj();

  /**
   * Sets the value of the '{@link uw.cs.watform.forml.forml.WCE#getRemobj <em>Remobj</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Remobj</em>' reference.
   * @see #getRemobj()
   * @generated
   */
  void setRemobj(ExprRef value);

} // WCE
