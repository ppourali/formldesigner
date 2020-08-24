/**
 */
package uw.cs.watform.forml.forml;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Region Context</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uw.cs.watform.forml.forml.RegionContext#getRef <em>Ref</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.RegionContext#getStates <em>States</em>}</li>
 * </ul>
 *
 * @see uw.cs.watform.forml.forml.FormlPackage#getRegionContext()
 * @model
 * @generated
 */
public interface RegionContext extends EObject
{
  /**
   * Returns the value of the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ref</em>' reference.
   * @see #setRef(Region)
   * @see uw.cs.watform.forml.forml.FormlPackage#getRegionContext_Ref()
   * @model
   * @generated
   */
  Region getRef();

  /**
   * Sets the value of the '{@link uw.cs.watform.forml.forml.RegionContext#getRef <em>Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ref</em>' reference.
   * @see #getRef()
   * @generated
   */
  void setRef(Region value);

  /**
   * Returns the value of the '<em><b>States</b></em>' containment reference list.
   * The list contents are of type {@link uw.cs.watform.forml.forml.Component}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>States</em>' containment reference list.
   * @see uw.cs.watform.forml.forml.FormlPackage#getRegionContext_States()
   * @model containment="true"
   * @generated
   */
  EList<Component> getStates();

} // RegionContext
