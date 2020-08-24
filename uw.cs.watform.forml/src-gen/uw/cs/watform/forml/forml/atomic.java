/**
 */
package uw.cs.watform.forml.forml;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>atomic</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uw.cs.watform.forml.forml.atomic#getNone <em>None</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.atomic#getRef <em>Ref</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.atomic#getRefs <em>Refs</em>}</li>
 * </ul>
 *
 * @see uw.cs.watform.forml.forml.FormlPackage#getatomic()
 * @model
 * @generated
 */
public interface atomic extends EObject
{
  /**
   * Returns the value of the '<em><b>None</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>None</em>' attribute.
   * @see #setNone(String)
   * @see uw.cs.watform.forml.forml.FormlPackage#getatomic_None()
   * @model
   * @generated
   */
  String getNone();

  /**
   * Sets the value of the '{@link uw.cs.watform.forml.forml.atomic#getNone <em>None</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>None</em>' attribute.
   * @see #getNone()
   * @generated
   */
  void setNone(String value);

  /**
   * Returns the value of the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ref</em>' reference.
   * @see #setRef(ExprRef)
   * @see uw.cs.watform.forml.forml.FormlPackage#getatomic_Ref()
   * @model
   * @generated
   */
  ExprRef getRef();

  /**
   * Sets the value of the '{@link uw.cs.watform.forml.forml.atomic#getRef <em>Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ref</em>' reference.
   * @see #getRef()
   * @generated
   */
  void setRef(ExprRef value);

  /**
   * Returns the value of the '<em><b>Refs</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Refs</em>' reference.
   * @see #setRefs(ExprRef)
   * @see uw.cs.watform.forml.forml.FormlPackage#getatomic_Refs()
   * @model
   * @generated
   */
  ExprRef getRefs();

  /**
   * Sets the value of the '{@link uw.cs.watform.forml.forml.atomic#getRefs <em>Refs</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Refs</em>' reference.
   * @see #getRefs()
   * @generated
   */
  void setRefs(ExprRef value);

} // atomic
