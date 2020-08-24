/**
 */
package uw.cs.watform.forml.forml.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import uw.cs.watform.forml.forml.FormlPackage;
import uw.cs.watform.forml.forml.atomic;
import uw.cs.watform.forml.forml.setExprBase;
import uw.cs.watform.forml.forml.unspecified;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>set Expr Base</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uw.cs.watform.forml.forml.impl.setExprBaseImpl#getAtom <em>Atom</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.impl.setExprBaseImpl#getUnspec <em>Unspec</em>}</li>
 * </ul>
 *
 * @generated
 */
public class setExprBaseImpl extends MinimalEObjectImpl.Container implements setExprBase
{
  /**
   * The cached value of the '{@link #getAtom() <em>Atom</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAtom()
   * @generated
   * @ordered
   */
  protected atomic atom;

  /**
   * The cached value of the '{@link #getUnspec() <em>Unspec</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUnspec()
   * @generated
   * @ordered
   */
  protected unspecified unspec;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected setExprBaseImpl()
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
    return FormlPackage.Literals.SET_EXPR_BASE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public atomic getAtom()
  {
    return atom;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAtom(atomic newAtom, NotificationChain msgs)
  {
    atomic oldAtom = atom;
    atom = newAtom;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FormlPackage.SET_EXPR_BASE__ATOM, oldAtom, newAtom);
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
  public void setAtom(atomic newAtom)
  {
    if (newAtom != atom)
    {
      NotificationChain msgs = null;
      if (atom != null)
        msgs = ((InternalEObject)atom).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FormlPackage.SET_EXPR_BASE__ATOM, null, msgs);
      if (newAtom != null)
        msgs = ((InternalEObject)newAtom).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FormlPackage.SET_EXPR_BASE__ATOM, null, msgs);
      msgs = basicSetAtom(newAtom, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FormlPackage.SET_EXPR_BASE__ATOM, newAtom, newAtom));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public unspecified getUnspec()
  {
    return unspec;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetUnspec(unspecified newUnspec, NotificationChain msgs)
  {
    unspecified oldUnspec = unspec;
    unspec = newUnspec;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FormlPackage.SET_EXPR_BASE__UNSPEC, oldUnspec, newUnspec);
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
  public void setUnspec(unspecified newUnspec)
  {
    if (newUnspec != unspec)
    {
      NotificationChain msgs = null;
      if (unspec != null)
        msgs = ((InternalEObject)unspec).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FormlPackage.SET_EXPR_BASE__UNSPEC, null, msgs);
      if (newUnspec != null)
        msgs = ((InternalEObject)newUnspec).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FormlPackage.SET_EXPR_BASE__UNSPEC, null, msgs);
      msgs = basicSetUnspec(newUnspec, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FormlPackage.SET_EXPR_BASE__UNSPEC, newUnspec, newUnspec));
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
      case FormlPackage.SET_EXPR_BASE__ATOM:
        return basicSetAtom(null, msgs);
      case FormlPackage.SET_EXPR_BASE__UNSPEC:
        return basicSetUnspec(null, msgs);
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
      case FormlPackage.SET_EXPR_BASE__ATOM:
        return getAtom();
      case FormlPackage.SET_EXPR_BASE__UNSPEC:
        return getUnspec();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case FormlPackage.SET_EXPR_BASE__ATOM:
        setAtom((atomic)newValue);
        return;
      case FormlPackage.SET_EXPR_BASE__UNSPEC:
        setUnspec((unspecified)newValue);
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
      case FormlPackage.SET_EXPR_BASE__ATOM:
        setAtom((atomic)null);
        return;
      case FormlPackage.SET_EXPR_BASE__UNSPEC:
        setUnspec((unspecified)null);
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
      case FormlPackage.SET_EXPR_BASE__ATOM:
        return atom != null;
      case FormlPackage.SET_EXPR_BASE__UNSPEC:
        return unspec != null;
    }
    return super.eIsSet(featureID);
  }

} //setExprBaseImpl
