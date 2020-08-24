/**
 */
package uw.cs.watform.forml.forml.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import uw.cs.watform.forml.forml.Feature;
import uw.cs.watform.forml.forml.FormlPackage;
import uw.cs.watform.forml.forml.InputList;
import uw.cs.watform.forml.forml.OutputList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Feature</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uw.cs.watform.forml.forml.impl.FeatureImpl#getInputlist <em>Inputlist</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.impl.FeatureImpl#getOutputlist <em>Outputlist</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FeatureImpl extends RoleableImpl implements Feature
{
  /**
   * The cached value of the '{@link #getInputlist() <em>Inputlist</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInputlist()
   * @generated
   * @ordered
   */
  protected InputList inputlist;

  /**
   * The cached value of the '{@link #getOutputlist() <em>Outputlist</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOutputlist()
   * @generated
   * @ordered
   */
  protected OutputList outputlist;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected FeatureImpl()
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
    return FormlPackage.Literals.FEATURE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public InputList getInputlist()
  {
    return inputlist;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetInputlist(InputList newInputlist, NotificationChain msgs)
  {
    InputList oldInputlist = inputlist;
    inputlist = newInputlist;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FormlPackage.FEATURE__INPUTLIST, oldInputlist, newInputlist);
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
  public void setInputlist(InputList newInputlist)
  {
    if (newInputlist != inputlist)
    {
      NotificationChain msgs = null;
      if (inputlist != null)
        msgs = ((InternalEObject)inputlist).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FormlPackage.FEATURE__INPUTLIST, null, msgs);
      if (newInputlist != null)
        msgs = ((InternalEObject)newInputlist).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FormlPackage.FEATURE__INPUTLIST, null, msgs);
      msgs = basicSetInputlist(newInputlist, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FormlPackage.FEATURE__INPUTLIST, newInputlist, newInputlist));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public OutputList getOutputlist()
  {
    return outputlist;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetOutputlist(OutputList newOutputlist, NotificationChain msgs)
  {
    OutputList oldOutputlist = outputlist;
    outputlist = newOutputlist;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FormlPackage.FEATURE__OUTPUTLIST, oldOutputlist, newOutputlist);
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
  public void setOutputlist(OutputList newOutputlist)
  {
    if (newOutputlist != outputlist)
    {
      NotificationChain msgs = null;
      if (outputlist != null)
        msgs = ((InternalEObject)outputlist).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FormlPackage.FEATURE__OUTPUTLIST, null, msgs);
      if (newOutputlist != null)
        msgs = ((InternalEObject)newOutputlist).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FormlPackage.FEATURE__OUTPUTLIST, null, msgs);
      msgs = basicSetOutputlist(newOutputlist, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FormlPackage.FEATURE__OUTPUTLIST, newOutputlist, newOutputlist));
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
      case FormlPackage.FEATURE__INPUTLIST:
        return basicSetInputlist(null, msgs);
      case FormlPackage.FEATURE__OUTPUTLIST:
        return basicSetOutputlist(null, msgs);
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
      case FormlPackage.FEATURE__INPUTLIST:
        return getInputlist();
      case FormlPackage.FEATURE__OUTPUTLIST:
        return getOutputlist();
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
      case FormlPackage.FEATURE__INPUTLIST:
        setInputlist((InputList)newValue);
        return;
      case FormlPackage.FEATURE__OUTPUTLIST:
        setOutputlist((OutputList)newValue);
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
      case FormlPackage.FEATURE__INPUTLIST:
        setInputlist((InputList)null);
        return;
      case FormlPackage.FEATURE__OUTPUTLIST:
        setOutputlist((OutputList)null);
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
      case FormlPackage.FEATURE__INPUTLIST:
        return inputlist != null;
      case FormlPackage.FEATURE__OUTPUTLIST:
        return outputlist != null;
    }
    return super.eIsSet(featureID);
  }

} //FeatureImpl
