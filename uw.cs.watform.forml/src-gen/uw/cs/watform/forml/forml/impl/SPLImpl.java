/**
 */
package uw.cs.watform.forml.forml.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import uw.cs.watform.forml.forml.FormlPackage;
import uw.cs.watform.forml.forml.Node;
import uw.cs.watform.forml.forml.SPL;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SPL</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uw.cs.watform.forml.forml.impl.SPLImpl#getName <em>Name</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.impl.SPLImpl#getXors <em>Xors</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.impl.SPLImpl#getAnds <em>Ands</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.impl.SPLImpl#getOrs <em>Ors</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SPLImpl extends NodeImpl implements SPL
{
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getXors() <em>Xors</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getXors()
   * @generated
   * @ordered
   */
  protected EList<Node> xors;

  /**
   * The cached value of the '{@link #getAnds() <em>Ands</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAnds()
   * @generated
   * @ordered
   */
  protected EList<Node> ands;

  /**
   * The cached value of the '{@link #getOrs() <em>Ors</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOrs()
   * @generated
   * @ordered
   */
  protected EList<Node> ors;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SPLImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return FormlPackage.Literals.SPL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FormlPackage.SPL__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Node> getXors()
  {
    if (xors == null)
    {
      xors = new EObjectContainmentEList<Node>(Node.class, this, FormlPackage.SPL__XORS);
    }
    return xors;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Node> getAnds()
  {
    if (ands == null)
    {
      ands = new EObjectContainmentEList<Node>(Node.class, this, FormlPackage.SPL__ANDS);
    }
    return ands;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Node> getOrs()
  {
    if (ors == null)
    {
      ors = new EObjectContainmentEList<Node>(Node.class, this, FormlPackage.SPL__ORS);
    }
    return ors;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case FormlPackage.SPL__XORS:
        return ((InternalEList<?>)getXors()).basicRemove(otherEnd, msgs);
      case FormlPackage.SPL__ANDS:
        return ((InternalEList<?>)getAnds()).basicRemove(otherEnd, msgs);
      case FormlPackage.SPL__ORS:
        return ((InternalEList<?>)getOrs()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case FormlPackage.SPL__NAME:
        return getName();
      case FormlPackage.SPL__XORS:
        return getXors();
      case FormlPackage.SPL__ANDS:
        return getAnds();
      case FormlPackage.SPL__ORS:
        return getOrs();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case FormlPackage.SPL__NAME:
        setName((String)newValue);
        return;
      case FormlPackage.SPL__XORS:
        getXors().clear();
        getXors().addAll((Collection<? extends Node>)newValue);
        return;
      case FormlPackage.SPL__ANDS:
        getAnds().clear();
        getAnds().addAll((Collection<? extends Node>)newValue);
        return;
      case FormlPackage.SPL__ORS:
        getOrs().clear();
        getOrs().addAll((Collection<? extends Node>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case FormlPackage.SPL__NAME:
        setName(NAME_EDEFAULT);
        return;
      case FormlPackage.SPL__XORS:
        getXors().clear();
        return;
      case FormlPackage.SPL__ANDS:
        getAnds().clear();
        return;
      case FormlPackage.SPL__ORS:
        getOrs().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case FormlPackage.SPL__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case FormlPackage.SPL__XORS:
        return xors != null && !xors.isEmpty();
      case FormlPackage.SPL__ANDS:
        return ands != null && !ands.isEmpty();
      case FormlPackage.SPL__ORS:
        return ors != null && !ors.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //SPLImpl
