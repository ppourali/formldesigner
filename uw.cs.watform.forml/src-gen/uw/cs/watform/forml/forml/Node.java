/**
 */
package uw.cs.watform.forml.forml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uw.cs.watform.forml.forml.Node#getFeatureNodes <em>Feature Nodes</em>}</li>
 * </ul>
 *
 * @see uw.cs.watform.forml.forml.FormlPackage#getNode()
 * @model
 * @generated
 */
public interface Node extends ExprRef
{
  /**
   * Returns the value of the '<em><b>Feature Nodes</b></em>' containment reference list.
   * The list contents are of type {@link uw.cs.watform.forml.forml.Node}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Feature Nodes</em>' containment reference list.
   * @see uw.cs.watform.forml.forml.FormlPackage#getNode_FeatureNodes()
   * @model containment="true"
   * @generated
   */
  EList<Node> getFeatureNodes();

} // Node
