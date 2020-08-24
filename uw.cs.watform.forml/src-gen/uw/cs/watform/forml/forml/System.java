/**
 */
package uw.cs.watform.forml.forml;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>System</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uw.cs.watform.forml.forml.System#getWorldmodel <em>Worldmodel</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.System#getBehaviourmodel <em>Behaviourmodel</em>}</li>
 * </ul>
 *
 * @see uw.cs.watform.forml.forml.FormlPackage#getSystem()
 * @model
 * @generated
 */
public interface System extends EObject
{
  /**
   * Returns the value of the '<em><b>Worldmodel</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Worldmodel</em>' containment reference.
   * @see #setWorldmodel(WorldModel)
   * @see uw.cs.watform.forml.forml.FormlPackage#getSystem_Worldmodel()
   * @model containment="true"
   * @generated
   */
  WorldModel getWorldmodel();

  /**
   * Sets the value of the '{@link uw.cs.watform.forml.forml.System#getWorldmodel <em>Worldmodel</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Worldmodel</em>' containment reference.
   * @see #getWorldmodel()
   * @generated
   */
  void setWorldmodel(WorldModel value);

  /**
   * Returns the value of the '<em><b>Behaviourmodel</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Behaviourmodel</em>' containment reference.
   * @see #setBehaviourmodel(BehaviourModel)
   * @see uw.cs.watform.forml.forml.FormlPackage#getSystem_Behaviourmodel()
   * @model containment="true"
   * @generated
   */
  BehaviourModel getBehaviourmodel();

  /**
   * Sets the value of the '{@link uw.cs.watform.forml.forml.System#getBehaviourmodel <em>Behaviourmodel</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Behaviourmodel</em>' containment reference.
   * @see #getBehaviourmodel()
   * @generated
   */
  void setBehaviourmodel(BehaviourModel value);

} // System
