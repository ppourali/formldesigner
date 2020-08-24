/**
 */
package uw.cs.watform.forml.forml.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import uw.cs.watform.forml.forml.Composition;
import uw.cs.watform.forml.forml.Decl;
import uw.cs.watform.forml.forml.FormlPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Composition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uw.cs.watform.forml.forml.impl.CompositionImpl#getWhole <em>Whole</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.impl.CompositionImpl#getPart <em>Part</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CompositionImpl extends RelationshipImpl implements Composition
{
  /**
   * The cached value of the '{@link #getWhole() <em>Whole</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getWhole()
   * @generated
   * @ordered
   */
  protected Decl whole;

  /**
   * The cached value of the '{@link #getPart() <em>Part</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPart()
   * @generated
   * @ordered
   */
  protected Decl part;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected CompositionImpl()
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
    return FormlPackage.Literals.COMPOSITION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Decl getWhole()
  {
    return whole;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetWhole(Decl newWhole, NotificationChain msgs)
  {
    Decl oldWhole = whole;
    whole = newWhole;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FormlPackage.COMPOSITION__WHOLE, oldWhole, newWhole);
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
  public void setWhole(Decl newWhole)
  {
    if (newWhole != whole)
    {
      NotificationChain msgs = null;
      if (whole != null)
        msgs = ((InternalEObject)whole).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FormlPackage.COMPOSITION__WHOLE, null, msgs);
      if (newWhole != null)
        msgs = ((InternalEObject)newWhole).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FormlPackage.COMPOSITION__WHOLE, null, msgs);
      msgs = basicSetWhole(newWhole, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FormlPackage.COMPOSITION__WHOLE, newWhole, newWhole));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Decl getPart()
  {
    return part;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPart(Decl newPart, NotificationChain msgs)
  {
    Decl oldPart = part;
    part = newPart;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FormlPackage.COMPOSITION__PART, oldPart, newPart);
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
  public void setPart(Decl newPart)
  {
    if (newPart != part)
    {
      NotificationChain msgs = null;
      if (part != null)
        msgs = ((InternalEObject)part).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FormlPackage.COMPOSITION__PART, null, msgs);
      if (newPart != null)
        msgs = ((InternalEObject)newPart).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FormlPackage.COMPOSITION__PART, null, msgs);
      msgs = basicSetPart(newPart, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FormlPackage.COMPOSITION__PART, newPart, newPart));
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
      case FormlPackage.COMPOSITION__WHOLE:
        return basicSetWhole(null, msgs);
      case FormlPackage.COMPOSITION__PART:
        return basicSetPart(null, msgs);
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
      case FormlPackage.COMPOSITION__WHOLE:
        return getWhole();
      case FormlPackage.COMPOSITION__PART:
        return getPart();
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
      case FormlPackage.COMPOSITION__WHOLE:
        setWhole((Decl)newValue);
        return;
      case FormlPackage.COMPOSITION__PART:
        setPart((Decl)newValue);
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
      case FormlPackage.COMPOSITION__WHOLE:
        setWhole((Decl)null);
        return;
      case FormlPackage.COMPOSITION__PART:
        setPart((Decl)null);
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
      case FormlPackage.COMPOSITION__WHOLE:
        return whole != null;
      case FormlPackage.COMPOSITION__PART:
        return part != null;
    }
    return super.eIsSet(featureID);
  }

} //CompositionImpl
