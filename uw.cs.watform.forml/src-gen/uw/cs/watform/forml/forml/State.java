/**
 */
package uw.cs.watform.forml.forml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uw.cs.watform.forml.forml.State#getRegions <em>Regions</em>}</li>
 * </ul>
 *
 * @see uw.cs.watform.forml.forml.FormlPackage#getState()
 * @model
 * @generated
 */
public interface State extends Component
{
  /**
   * Returns the value of the '<em><b>Regions</b></em>' containment reference list.
   * The list contents are of type {@link uw.cs.watform.forml.forml.Component}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Regions</em>' containment reference list.
   * @see uw.cs.watform.forml.forml.FormlPackage#getState_Regions()
   * @model containment="true"
   * @generated
   */
  EList<Component> getRegions();

} // State
