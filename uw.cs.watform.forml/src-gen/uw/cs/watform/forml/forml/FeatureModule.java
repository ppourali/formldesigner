/**
 */
package uw.cs.watform.forml.forml;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feature Module</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uw.cs.watform.forml.forml.FeatureModule#getFeatureref <em>Featureref</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.FeatureModule#getConstraints <em>Constraints</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.FeatureModule#getStatemachine <em>Statemachine</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.FeatureModule#getFragments <em>Fragments</em>}</li>
 * </ul>
 *
 * @see uw.cs.watform.forml.forml.FormlPackage#getFeatureModule()
 * @model
 * @generated
 */
public interface FeatureModule extends EObject
{
  /**
   * Returns the value of the '<em><b>Featureref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Featureref</em>' reference.
   * @see #setFeatureref(Roleable)
   * @see uw.cs.watform.forml.forml.FormlPackage#getFeatureModule_Featureref()
   * @model
   * @generated
   */
  Roleable getFeatureref();

  /**
   * Sets the value of the '{@link uw.cs.watform.forml.forml.FeatureModule#getFeatureref <em>Featureref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Featureref</em>' reference.
   * @see #getFeatureref()
   * @generated
   */
  void setFeatureref(Roleable value);

  /**
   * Returns the value of the '<em><b>Constraints</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Constraints</em>' containment reference.
   * @see #setConstraints(Constraint)
   * @see uw.cs.watform.forml.forml.FormlPackage#getFeatureModule_Constraints()
   * @model containment="true"
   * @generated
   */
  Constraint getConstraints();

  /**
   * Sets the value of the '{@link uw.cs.watform.forml.forml.FeatureModule#getConstraints <em>Constraints</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Constraints</em>' containment reference.
   * @see #getConstraints()
   * @generated
   */
  void setConstraints(Constraint value);

  /**
   * Returns the value of the '<em><b>Statemachine</b></em>' containment reference list.
   * The list contents are of type {@link uw.cs.watform.forml.forml.StateMachine}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Statemachine</em>' containment reference list.
   * @see uw.cs.watform.forml.forml.FormlPackage#getFeatureModule_Statemachine()
   * @model containment="true"
   * @generated
   */
  EList<StateMachine> getStatemachine();

  /**
   * Returns the value of the '<em><b>Fragments</b></em>' containment reference list.
   * The list contents are of type {@link uw.cs.watform.forml.forml.Fragment}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Fragments</em>' containment reference list.
   * @see uw.cs.watform.forml.forml.FormlPackage#getFeatureModule_Fragments()
   * @model containment="true"
   * @generated
   */
  EList<Fragment> getFragments();

} // FeatureModule
