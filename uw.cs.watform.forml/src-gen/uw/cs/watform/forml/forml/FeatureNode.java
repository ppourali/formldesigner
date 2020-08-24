/**
 */
package uw.cs.watform.forml.forml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feature Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uw.cs.watform.forml.forml.FeatureNode#getFeature <em>Feature</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.FeatureNode#getMultiplicity <em>Multiplicity</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.FeatureNode#getXors <em>Xors</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.FeatureNode#getAnds <em>Ands</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.FeatureNode#getOrs <em>Ors</em>}</li>
 * </ul>
 *
 * @see uw.cs.watform.forml.forml.FormlPackage#getFeatureNode()
 * @model
 * @generated
 */
public interface FeatureNode extends Node
{
  /**
   * Returns the value of the '<em><b>Feature</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Feature</em>' reference.
   * @see #setFeature(Feature)
   * @see uw.cs.watform.forml.forml.FormlPackage#getFeatureNode_Feature()
   * @model
   * @generated
   */
  Feature getFeature();

  /**
   * Sets the value of the '{@link uw.cs.watform.forml.forml.FeatureNode#getFeature <em>Feature</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Feature</em>' reference.
   * @see #getFeature()
   * @generated
   */
  void setFeature(Feature value);

  /**
   * Returns the value of the '<em><b>Multiplicity</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Multiplicity</em>' containment reference.
   * @see #setMultiplicity(Multiplicity)
   * @see uw.cs.watform.forml.forml.FormlPackage#getFeatureNode_Multiplicity()
   * @model containment="true"
   * @generated
   */
  Multiplicity getMultiplicity();

  /**
   * Sets the value of the '{@link uw.cs.watform.forml.forml.FeatureNode#getMultiplicity <em>Multiplicity</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Multiplicity</em>' containment reference.
   * @see #getMultiplicity()
   * @generated
   */
  void setMultiplicity(Multiplicity value);

  /**
   * Returns the value of the '<em><b>Xors</b></em>' containment reference list.
   * The list contents are of type {@link uw.cs.watform.forml.forml.Node}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Xors</em>' containment reference list.
   * @see uw.cs.watform.forml.forml.FormlPackage#getFeatureNode_Xors()
   * @model containment="true"
   * @generated
   */
  EList<Node> getXors();

  /**
   * Returns the value of the '<em><b>Ands</b></em>' containment reference list.
   * The list contents are of type {@link uw.cs.watform.forml.forml.Node}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ands</em>' containment reference list.
   * @see uw.cs.watform.forml.forml.FormlPackage#getFeatureNode_Ands()
   * @model containment="true"
   * @generated
   */
  EList<Node> getAnds();

  /**
   * Returns the value of the '<em><b>Ors</b></em>' containment reference list.
   * The list contents are of type {@link uw.cs.watform.forml.forml.Node}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ors</em>' containment reference list.
   * @see uw.cs.watform.forml.forml.FormlPackage#getFeatureNode_Ors()
   * @model containment="true"
   * @generated
   */
  EList<Node> getOrs();

} // FeatureNode
