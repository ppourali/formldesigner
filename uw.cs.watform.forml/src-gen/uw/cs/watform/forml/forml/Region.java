/**
 */
package uw.cs.watform.forml.forml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Region</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uw.cs.watform.forml.forml.Region#getInit <em>Init</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.Region#getStates <em>States</em>}</li>
 * </ul>
 *
 * @see uw.cs.watform.forml.forml.FormlPackage#getRegion()
 * @model
 * @generated
 */
public interface Region extends Component
{
  /**
   * Returns the value of the '<em><b>Init</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Init</em>' containment reference.
   * @see #setInit(InitState)
   * @see uw.cs.watform.forml.forml.FormlPackage#getRegion_Init()
   * @model containment="true"
   * @generated
   */
  InitState getInit();

  /**
   * Sets the value of the '{@link uw.cs.watform.forml.forml.Region#getInit <em>Init</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Init</em>' containment reference.
   * @see #getInit()
   * @generated
   */
  void setInit(InitState value);

  /**
   * Returns the value of the '<em><b>States</b></em>' containment reference list.
   * The list contents are of type {@link uw.cs.watform.forml.forml.Component}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>States</em>' containment reference list.
   * @see uw.cs.watform.forml.forml.FormlPackage#getRegion_States()
   * @model containment="true"
   * @generated
   */
  EList<Component> getStates();

} // Region
