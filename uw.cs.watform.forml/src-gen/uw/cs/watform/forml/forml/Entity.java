/**
 */
package uw.cs.watform.forml.forml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Entity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uw.cs.watform.forml.forml.Entity#isCtrl <em>Ctrl</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.Entity#getSuperType <em>Super Type</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.Entity#getFunctions <em>Functions</em>}</li>
 * </ul>
 *
 * @see uw.cs.watform.forml.forml.FormlPackage#getEntity()
 * @model
 * @generated
 */
public interface Entity extends Roleable
{
  /**
   * Returns the value of the '<em><b>Ctrl</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ctrl</em>' attribute.
   * @see #setCtrl(boolean)
   * @see uw.cs.watform.forml.forml.FormlPackage#getEntity_Ctrl()
   * @model
   * @generated
   */
  boolean isCtrl();

  /**
   * Sets the value of the '{@link uw.cs.watform.forml.forml.Entity#isCtrl <em>Ctrl</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ctrl</em>' attribute.
   * @see #isCtrl()
   * @generated
   */
  void setCtrl(boolean value);

  /**
   * Returns the value of the '<em><b>Super Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Super Type</em>' reference.
   * @see #setSuperType(Entity)
   * @see uw.cs.watform.forml.forml.FormlPackage#getEntity_SuperType()
   * @model
   * @generated
   */
  Entity getSuperType();

  /**
   * Sets the value of the '{@link uw.cs.watform.forml.forml.Entity#getSuperType <em>Super Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Super Type</em>' reference.
   * @see #getSuperType()
   * @generated
   */
  void setSuperType(Entity value);

  /**
   * Returns the value of the '<em><b>Functions</b></em>' containment reference list.
   * The list contents are of type {@link uw.cs.watform.forml.forml.ExprRef}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Functions</em>' containment reference list.
   * @see uw.cs.watform.forml.forml.FormlPackage#getEntity_Functions()
   * @model containment="true"
   * @generated
   */
  EList<ExprRef> getFunctions();

} // Entity
