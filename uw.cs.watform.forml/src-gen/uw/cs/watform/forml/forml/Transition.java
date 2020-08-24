/**
 */
package uw.cs.watform.forml.forml;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uw.cs.watform.forml.forml.Transition#getName <em>Name</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.Transition#getPriority <em>Priority</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.Transition#getSrc <em>Src</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.Transition#getDst <em>Dst</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.Transition#getTrig <em>Trig</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.Transition#getGuard <em>Guard</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.Transition#getList <em>List</em>}</li>
 * </ul>
 *
 * @see uw.cs.watform.forml.forml.FormlPackage#getTransition()
 * @model
 * @generated
 */
public interface Transition extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see uw.cs.watform.forml.forml.FormlPackage#getTransition_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link uw.cs.watform.forml.forml.Transition#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Priority</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Priority</em>' containment reference.
   * @see #setPriority(Priority)
   * @see uw.cs.watform.forml.forml.FormlPackage#getTransition_Priority()
   * @model containment="true"
   * @generated
   */
  Priority getPriority();

  /**
   * Sets the value of the '{@link uw.cs.watform.forml.forml.Transition#getPriority <em>Priority</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Priority</em>' containment reference.
   * @see #getPriority()
   * @generated
   */
  void setPriority(Priority value);

  /**
   * Returns the value of the '<em><b>Src</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Src</em>' reference.
   * @see #setSrc(State)
   * @see uw.cs.watform.forml.forml.FormlPackage#getTransition_Src()
   * @model
   * @generated
   */
  State getSrc();

  /**
   * Sets the value of the '{@link uw.cs.watform.forml.forml.Transition#getSrc <em>Src</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Src</em>' reference.
   * @see #getSrc()
   * @generated
   */
  void setSrc(State value);

  /**
   * Returns the value of the '<em><b>Dst</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Dst</em>' reference.
   * @see #setDst(State)
   * @see uw.cs.watform.forml.forml.FormlPackage#getTransition_Dst()
   * @model
   * @generated
   */
  State getDst();

  /**
   * Sets the value of the '{@link uw.cs.watform.forml.forml.Transition#getDst <em>Dst</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Dst</em>' reference.
   * @see #getDst()
   * @generated
   */
  void setDst(State value);

  /**
   * Returns the value of the '<em><b>Trig</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Trig</em>' containment reference.
   * @see #setTrig(Trigger)
   * @see uw.cs.watform.forml.forml.FormlPackage#getTransition_Trig()
   * @model containment="true"
   * @generated
   */
  Trigger getTrig();

  /**
   * Sets the value of the '{@link uw.cs.watform.forml.forml.Transition#getTrig <em>Trig</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Trig</em>' containment reference.
   * @see #getTrig()
   * @generated
   */
  void setTrig(Trigger value);

  /**
   * Returns the value of the '<em><b>Guard</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Guard</em>' containment reference.
   * @see #setGuard(Guard)
   * @see uw.cs.watform.forml.forml.FormlPackage#getTransition_Guard()
   * @model containment="true"
   * @generated
   */
  Guard getGuard();

  /**
   * Sets the value of the '{@link uw.cs.watform.forml.forml.Transition#getGuard <em>Guard</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Guard</em>' containment reference.
   * @see #getGuard()
   * @generated
   */
  void setGuard(Guard value);

  /**
   * Returns the value of the '<em><b>List</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>List</em>' containment reference.
   * @see #setList(WCAList)
   * @see uw.cs.watform.forml.forml.FormlPackage#getTransition_List()
   * @model containment="true"
   * @generated
   */
  WCAList getList();

  /**
   * Sets the value of the '{@link uw.cs.watform.forml.forml.Transition#getList <em>List</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>List</em>' containment reference.
   * @see #getList()
   * @generated
   */
  void setList(WCAList value);

} // Transition
