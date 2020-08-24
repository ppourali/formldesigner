/**
 */
package uw.cs.watform.forml.forml;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tran Fragment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uw.cs.watform.forml.forml.TranFragment#getRef <em>Ref</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.TranFragment#getTrig <em>Trig</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.TranFragment#getFragType <em>Frag Type</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.TranFragment#getList <em>List</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.TranFragment#getFragList <em>Frag List</em>}</li>
 * </ul>
 *
 * @see uw.cs.watform.forml.forml.FormlPackage#getTranFragment()
 * @model
 * @generated
 */
public interface TranFragment extends EObject
{
  /**
   * Returns the value of the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ref</em>' reference.
   * @see #setRef(Transition)
   * @see uw.cs.watform.forml.forml.FormlPackage#getTranFragment_Ref()
   * @model
   * @generated
   */
  Transition getRef();

  /**
   * Sets the value of the '{@link uw.cs.watform.forml.forml.TranFragment#getRef <em>Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ref</em>' reference.
   * @see #getRef()
   * @generated
   */
  void setRef(Transition value);

  /**
   * Returns the value of the '<em><b>Trig</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Trig</em>' containment reference.
   * @see #setTrig(Trigger)
   * @see uw.cs.watform.forml.forml.FormlPackage#getTranFragment_Trig()
   * @model containment="true"
   * @generated
   */
  Trigger getTrig();

  /**
   * Sets the value of the '{@link uw.cs.watform.forml.forml.TranFragment#getTrig <em>Trig</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Trig</em>' containment reference.
   * @see #getTrig()
   * @generated
   */
  void setTrig(Trigger value);

  /**
   * Returns the value of the '<em><b>Frag Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Frag Type</em>' containment reference.
   * @see #setFragType(Guard)
   * @see uw.cs.watform.forml.forml.FormlPackage#getTranFragment_FragType()
   * @model containment="true"
   * @generated
   */
  Guard getFragType();

  /**
   * Sets the value of the '{@link uw.cs.watform.forml.forml.TranFragment#getFragType <em>Frag Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Frag Type</em>' containment reference.
   * @see #getFragType()
   * @generated
   */
  void setFragType(Guard value);

  /**
   * Returns the value of the '<em><b>List</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>List</em>' containment reference.
   * @see #setList(WCAList)
   * @see uw.cs.watform.forml.forml.FormlPackage#getTranFragment_List()
   * @model containment="true"
   * @generated
   */
  WCAList getList();

  /**
   * Sets the value of the '{@link uw.cs.watform.forml.forml.TranFragment#getList <em>List</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>List</em>' containment reference.
   * @see #getList()
   * @generated
   */
  void setList(WCAList value);

  /**
   * Returns the value of the '<em><b>Frag List</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Frag List</em>' containment reference.
   * @see #setFragList(WCAFragmentList)
   * @see uw.cs.watform.forml.forml.FormlPackage#getTranFragment_FragList()
   * @model containment="true"
   * @generated
   */
  WCAFragmentList getFragList();

  /**
   * Sets the value of the '{@link uw.cs.watform.forml.forml.TranFragment#getFragList <em>Frag List</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Frag List</em>' containment reference.
   * @see #getFragList()
   * @generated
   */
  void setFragList(WCAFragmentList value);

} // TranFragment
