/**
 */
package uw.cs.watform.forml.forml;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Priority</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uw.cs.watform.forml.forml.Priority#getTranslist <em>Translist</em>}</li>
 * </ul>
 *
 * @see uw.cs.watform.forml.forml.FormlPackage#getPriority()
 * @model
 * @generated
 */
public interface Priority extends EObject
{
  /**
   * Returns the value of the '<em><b>Translist</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Translist</em>' containment reference.
   * @see #setTranslist(TransList)
   * @see uw.cs.watform.forml.forml.FormlPackage#getPriority_Translist()
   * @model containment="true"
   * @generated
   */
  TransList getTranslist();

  /**
   * Sets the value of the '{@link uw.cs.watform.forml.forml.Priority#getTranslist <em>Translist</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Translist</em>' containment reference.
   * @see #getTranslist()
   * @generated
   */
  void setTranslist(TransList value);

} // Priority
