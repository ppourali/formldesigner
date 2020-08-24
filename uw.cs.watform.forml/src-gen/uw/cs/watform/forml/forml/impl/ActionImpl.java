/**
 */
package uw.cs.watform.forml.forml.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import uw.cs.watform.forml.forml.Action;
import uw.cs.watform.forml.forml.AssignList;
import uw.cs.watform.forml.forml.ExprRef;
import uw.cs.watform.forml.forml.FormlPackage;
import uw.cs.watform.forml.forml.Output;
import uw.cs.watform.forml.forml.setExpr;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uw.cs.watform.forml.forml.impl.ActionImpl#getType <em>Type</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.impl.ActionImpl#getOut <em>Out</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.impl.ActionImpl#getList <em>List</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.impl.ActionImpl#getMinexpr <em>Minexpr</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.impl.ActionImpl#getLvalue <em>Lvalue</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.impl.ActionImpl#getRvalue <em>Rvalue</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ActionImpl extends MinimalEObjectImpl.Container implements Action
{
  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected ExprRef type;

  /**
   * The cached value of the '{@link #getOut() <em>Out</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOut()
   * @generated
   * @ordered
   */
  protected Output out;

  /**
   * The cached value of the '{@link #getList() <em>List</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getList()
   * @generated
   * @ordered
   */
  protected EList<AssignList> list;

  /**
   * The cached value of the '{@link #getMinexpr() <em>Minexpr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMinexpr()
   * @generated
   * @ordered
   */
  protected setExpr minexpr;

  /**
   * The cached value of the '{@link #getLvalue() <em>Lvalue</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLvalue()
   * @generated
   * @ordered
   */
  protected EObject lvalue;

  /**
   * The cached value of the '{@link #getRvalue() <em>Rvalue</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRvalue()
   * @generated
   * @ordered
   */
  protected EObject rvalue;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ActionImpl()
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
    return FormlPackage.Literals.ACTION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ExprRef getType()
  {
    if (type != null && type.eIsProxy())
    {
      InternalEObject oldType = (InternalEObject)type;
      type = (ExprRef)eResolveProxy(oldType);
      if (type != oldType)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, FormlPackage.ACTION__TYPE, oldType, type));
      }
    }
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExprRef basicGetType()
  {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setType(ExprRef newType)
  {
    ExprRef oldType = type;
    type = newType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FormlPackage.ACTION__TYPE, oldType, type));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Output getOut()
  {
    if (out != null && out.eIsProxy())
    {
      InternalEObject oldOut = (InternalEObject)out;
      out = (Output)eResolveProxy(oldOut);
      if (out != oldOut)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, FormlPackage.ACTION__OUT, oldOut, out));
      }
    }
    return out;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Output basicGetOut()
  {
    return out;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setOut(Output newOut)
  {
    Output oldOut = out;
    out = newOut;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FormlPackage.ACTION__OUT, oldOut, out));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<AssignList> getList()
  {
    if (list == null)
    {
      list = new EObjectContainmentEList<AssignList>(AssignList.class, this, FormlPackage.ACTION__LIST);
    }
    return list;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public setExpr getMinexpr()
  {
    return minexpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetMinexpr(setExpr newMinexpr, NotificationChain msgs)
  {
    setExpr oldMinexpr = minexpr;
    minexpr = newMinexpr;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FormlPackage.ACTION__MINEXPR, oldMinexpr, newMinexpr);
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
  public void setMinexpr(setExpr newMinexpr)
  {
    if (newMinexpr != minexpr)
    {
      NotificationChain msgs = null;
      if (minexpr != null)
        msgs = ((InternalEObject)minexpr).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FormlPackage.ACTION__MINEXPR, null, msgs);
      if (newMinexpr != null)
        msgs = ((InternalEObject)newMinexpr).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FormlPackage.ACTION__MINEXPR, null, msgs);
      msgs = basicSetMinexpr(newMinexpr, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FormlPackage.ACTION__MINEXPR, newMinexpr, newMinexpr));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject getLvalue()
  {
    return lvalue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetLvalue(EObject newLvalue, NotificationChain msgs)
  {
    EObject oldLvalue = lvalue;
    lvalue = newLvalue;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FormlPackage.ACTION__LVALUE, oldLvalue, newLvalue);
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
  public void setLvalue(EObject newLvalue)
  {
    if (newLvalue != lvalue)
    {
      NotificationChain msgs = null;
      if (lvalue != null)
        msgs = ((InternalEObject)lvalue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FormlPackage.ACTION__LVALUE, null, msgs);
      if (newLvalue != null)
        msgs = ((InternalEObject)newLvalue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FormlPackage.ACTION__LVALUE, null, msgs);
      msgs = basicSetLvalue(newLvalue, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FormlPackage.ACTION__LVALUE, newLvalue, newLvalue));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject getRvalue()
  {
    return rvalue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetRvalue(EObject newRvalue, NotificationChain msgs)
  {
    EObject oldRvalue = rvalue;
    rvalue = newRvalue;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FormlPackage.ACTION__RVALUE, oldRvalue, newRvalue);
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
  public void setRvalue(EObject newRvalue)
  {
    if (newRvalue != rvalue)
    {
      NotificationChain msgs = null;
      if (rvalue != null)
        msgs = ((InternalEObject)rvalue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FormlPackage.ACTION__RVALUE, null, msgs);
      if (newRvalue != null)
        msgs = ((InternalEObject)newRvalue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FormlPackage.ACTION__RVALUE, null, msgs);
      msgs = basicSetRvalue(newRvalue, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FormlPackage.ACTION__RVALUE, newRvalue, newRvalue));
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
      case FormlPackage.ACTION__LIST:
        return ((InternalEList<?>)getList()).basicRemove(otherEnd, msgs);
      case FormlPackage.ACTION__MINEXPR:
        return basicSetMinexpr(null, msgs);
      case FormlPackage.ACTION__LVALUE:
        return basicSetLvalue(null, msgs);
      case FormlPackage.ACTION__RVALUE:
        return basicSetRvalue(null, msgs);
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
      case FormlPackage.ACTION__TYPE:
        if (resolve) return getType();
        return basicGetType();
      case FormlPackage.ACTION__OUT:
        if (resolve) return getOut();
        return basicGetOut();
      case FormlPackage.ACTION__LIST:
        return getList();
      case FormlPackage.ACTION__MINEXPR:
        return getMinexpr();
      case FormlPackage.ACTION__LVALUE:
        return getLvalue();
      case FormlPackage.ACTION__RVALUE:
        return getRvalue();
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
      case FormlPackage.ACTION__TYPE:
        setType((ExprRef)newValue);
        return;
      case FormlPackage.ACTION__OUT:
        setOut((Output)newValue);
        return;
      case FormlPackage.ACTION__LIST:
        getList().clear();
        getList().addAll((Collection<? extends AssignList>)newValue);
        return;
      case FormlPackage.ACTION__MINEXPR:
        setMinexpr((setExpr)newValue);
        return;
      case FormlPackage.ACTION__LVALUE:
        setLvalue((EObject)newValue);
        return;
      case FormlPackage.ACTION__RVALUE:
        setRvalue((EObject)newValue);
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
      case FormlPackage.ACTION__TYPE:
        setType((ExprRef)null);
        return;
      case FormlPackage.ACTION__OUT:
        setOut((Output)null);
        return;
      case FormlPackage.ACTION__LIST:
        getList().clear();
        return;
      case FormlPackage.ACTION__MINEXPR:
        setMinexpr((setExpr)null);
        return;
      case FormlPackage.ACTION__LVALUE:
        setLvalue((EObject)null);
        return;
      case FormlPackage.ACTION__RVALUE:
        setRvalue((EObject)null);
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
      case FormlPackage.ACTION__TYPE:
        return type != null;
      case FormlPackage.ACTION__OUT:
        return out != null;
      case FormlPackage.ACTION__LIST:
        return list != null && !list.isEmpty();
      case FormlPackage.ACTION__MINEXPR:
        return minexpr != null;
      case FormlPackage.ACTION__LVALUE:
        return lvalue != null;
      case FormlPackage.ACTION__RVALUE:
        return rvalue != null;
    }
    return super.eIsSet(featureID);
  }

} //ActionImpl
