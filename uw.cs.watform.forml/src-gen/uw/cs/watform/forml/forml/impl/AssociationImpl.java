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

import uw.cs.watform.forml.forml.Association;
import uw.cs.watform.forml.forml.ExprRef;
import uw.cs.watform.forml.forml.FormlPackage;
import uw.cs.watform.forml.forml.Role;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Association</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uw.cs.watform.forml.forml.impl.AssociationImpl#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.impl.AssociationImpl#getSrcRole <em>Src Role</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.impl.AssociationImpl#getDesRole <em>Des Role</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AssociationImpl extends RelationshipImpl implements Association
{
  /**
   * The cached value of the '{@link #getAttributes() <em>Attributes</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAttributes()
   * @generated
   * @ordered
   */
  protected EList<ExprRef> attributes;

  /**
   * The cached value of the '{@link #getSrcRole() <em>Src Role</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSrcRole()
   * @generated
   * @ordered
   */
  protected Role srcRole;

  /**
   * The cached value of the '{@link #getDesRole() <em>Des Role</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDesRole()
   * @generated
   * @ordered
   */
  protected Role desRole;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AssociationImpl()
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
    return FormlPackage.Literals.ASSOCIATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<ExprRef> getAttributes()
  {
    if (attributes == null)
    {
      attributes = new EObjectContainmentEList<ExprRef>(ExprRef.class, this, FormlPackage.ASSOCIATION__ATTRIBUTES);
    }
    return attributes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Role getSrcRole()
  {
    return srcRole;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSrcRole(Role newSrcRole, NotificationChain msgs)
  {
    Role oldSrcRole = srcRole;
    srcRole = newSrcRole;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FormlPackage.ASSOCIATION__SRC_ROLE, oldSrcRole, newSrcRole);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setSrcRole(Role newSrcRole)
  {
    if (newSrcRole != srcRole)
    {
      NotificationChain msgs = null;
      if (srcRole != null)
        msgs = ((InternalEObject)srcRole).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FormlPackage.ASSOCIATION__SRC_ROLE, null, msgs);
      if (newSrcRole != null)
        msgs = ((InternalEObject)newSrcRole).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FormlPackage.ASSOCIATION__SRC_ROLE, null, msgs);
      msgs = basicSetSrcRole(newSrcRole, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FormlPackage.ASSOCIATION__SRC_ROLE, newSrcRole, newSrcRole));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Role getDesRole()
  {
    return desRole;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDesRole(Role newDesRole, NotificationChain msgs)
  {
    Role oldDesRole = desRole;
    desRole = newDesRole;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FormlPackage.ASSOCIATION__DES_ROLE, oldDesRole, newDesRole);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setDesRole(Role newDesRole)
  {
    if (newDesRole != desRole)
    {
      NotificationChain msgs = null;
      if (desRole != null)
        msgs = ((InternalEObject)desRole).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FormlPackage.ASSOCIATION__DES_ROLE, null, msgs);
      if (newDesRole != null)
        msgs = ((InternalEObject)newDesRole).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FormlPackage.ASSOCIATION__DES_ROLE, null, msgs);
      msgs = basicSetDesRole(newDesRole, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FormlPackage.ASSOCIATION__DES_ROLE, newDesRole, newDesRole));
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
      case FormlPackage.ASSOCIATION__ATTRIBUTES:
        return ((InternalEList<?>)getAttributes()).basicRemove(otherEnd, msgs);
      case FormlPackage.ASSOCIATION__SRC_ROLE:
        return basicSetSrcRole(null, msgs);
      case FormlPackage.ASSOCIATION__DES_ROLE:
        return basicSetDesRole(null, msgs);
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
      case FormlPackage.ASSOCIATION__ATTRIBUTES:
        return getAttributes();
      case FormlPackage.ASSOCIATION__SRC_ROLE:
        return getSrcRole();
      case FormlPackage.ASSOCIATION__DES_ROLE:
        return getDesRole();
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
      case FormlPackage.ASSOCIATION__ATTRIBUTES:
        getAttributes().clear();
        getAttributes().addAll((Collection<? extends ExprRef>)newValue);
        return;
      case FormlPackage.ASSOCIATION__SRC_ROLE:
        setSrcRole((Role)newValue);
        return;
      case FormlPackage.ASSOCIATION__DES_ROLE:
        setDesRole((Role)newValue);
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
      case FormlPackage.ASSOCIATION__ATTRIBUTES:
        getAttributes().clear();
        return;
      case FormlPackage.ASSOCIATION__SRC_ROLE:
        setSrcRole((Role)null);
        return;
      case FormlPackage.ASSOCIATION__DES_ROLE:
        setDesRole((Role)null);
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
      case FormlPackage.ASSOCIATION__ATTRIBUTES:
        return attributes != null && !attributes.isEmpty();
      case FormlPackage.ASSOCIATION__SRC_ROLE:
        return srcRole != null;
      case FormlPackage.ASSOCIATION__DES_ROLE:
        return desRole != null;
    }
    return super.eIsSet(featureID);
  }

} //AssociationImpl
