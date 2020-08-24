/**
 */
package uw.cs.watform.forml.forml;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Behaviour Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uw.cs.watform.forml.forml.BehaviourModel#getFeaturemodules <em>Featuremodules</em>}</li>
 * </ul>
 *
 * @see uw.cs.watform.forml.forml.FormlPackage#getBehaviourModel()
 * @model
 * @generated
 */
public interface BehaviourModel extends EObject
{
  /**
   * Returns the value of the '<em><b>Featuremodules</b></em>' containment reference list.
   * The list contents are of type {@link uw.cs.watform.forml.forml.FeatureModule}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Featuremodules</em>' containment reference list.
   * @see uw.cs.watform.forml.forml.FormlPackage#getBehaviourModel_Featuremodules()
   * @model containment="true"
   * @generated
   */
  EList<FeatureModule> getFeaturemodules();

} // BehaviourModel
