/**
 */
package uw.cs.watform.forml.forml;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Trigger</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uw.cs.watform.forml.forml.Trigger#getOverride <em>Override</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.Trigger#getWce <em>Wce</em>}</li>
 * </ul>
 *
 * @see uw.cs.watform.forml.forml.FormlPackage#getTrigger()
 * @model
 * @generated
 */
public interface Trigger extends EObject
{
  /**
   * Returns the value of the '<em><b>Override</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Override</em>' containment reference.
   * @see #setOverride(uw.cs.watform.forml.forml.Override)
   * @see uw.cs.watform.forml.forml.FormlPackage#getTrigger_Override()
   * @model containment="true"
   * @generated
   */
  uw.cs.watform.forml.forml.Override getOverride();

  /**
   * Sets the value of the '{@link uw.cs.watform.forml.forml.Trigger#getOverride <em>Override</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Override</em>' containment reference.
   * @see #getOverride()
   * @generated
   */
  void setOverride(uw.cs.watform.forml.forml.Override value);

  /**
   * Returns the value of the '<em><b>Wce</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Wce</em>' containment reference.
   * @see #setWce(WCE)
   * @see uw.cs.watform.forml.forml.FormlPackage#getTrigger_Wce()
   * @model containment="true"
   * @generated
   */
  WCE getWce();

  /**
   * Sets the value of the '{@link uw.cs.watform.forml.forml.Trigger#getWce <em>Wce</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Wce</em>' containment reference.
   * @see #getWce()
   * @generated
   */
  void setWce(WCE value);

} // Trigger
