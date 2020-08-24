/**
 */
package uw.cs.watform.forml.forml.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import uw.cs.watform.forml.forml.ExprRef;
import uw.cs.watform.forml.forml.FormlPackage;
import uw.cs.watform.forml.forml.Predicate;
import uw.cs.watform.forml.forml.notPred;
import uw.cs.watform.forml.forml.setExpr;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Predicate</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uw.cs.watform.forml.forml.impl.PredicateImpl#getLogicop <em>Logicop</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.impl.PredicateImpl#getVar <em>Var</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.impl.PredicateImpl#getSexpr <em>Sexpr</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.impl.PredicateImpl#getQuantPred <em>Quant Pred</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PredicateImpl extends MinimalEObjectImpl.Container implements Predicate
{
  /**
   * The default value of the '{@link #getLogicop() <em>Logicop</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLogicop()
   * @generated
   * @ordered
   */
  protected static final String LOGICOP_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getLogicop() <em>Logicop</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLogicop()
   * @generated
   * @ordered
   */
  protected String logicop = LOGICOP_EDEFAULT;

  /**
   * The cached value of the '{@link #getVar() <em>Var</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVar()
   * @generated
   * @ordered
   */
  protected ExprRef var;

  /**
   * The cached value of the '{@link #getSexpr() <em>Sexpr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSexpr()
   * @generated
   * @ordered
   */
  protected setExpr sexpr;

  /**
   * The cached value of the '{@link #getQuantPred() <em>Quant Pred</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getQuantPred()
   * @generated
   * @ordered
   */
  protected notPred quantPred;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PredicateImpl()
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
    return FormlPackage.Literals.PREDICATE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getLogicop()
  {
    return logicop;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setLogicop(String newLogicop)
  {
    String oldLogicop = logicop;
    logicop = newLogicop;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FormlPackage.PREDICATE__LOGICOP, oldLogicop, logicop));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ExprRef getVar()
  {
    return var;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetVar(ExprRef newVar, NotificationChain msgs)
  {
    ExprRef oldVar = var;
    var = newVar;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FormlPackage.PREDICATE__VAR, oldVar, newVar);
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
  public void setVar(ExprRef newVar)
  {
    if (newVar != var)
    {
      NotificationChain msgs = null;
      if (var != null)
        msgs = ((InternalEObject)var).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FormlPackage.PREDICATE__VAR, null, msgs);
      if (newVar != null)
        msgs = ((InternalEObject)newVar).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FormlPackage.PREDICATE__VAR, null, msgs);
      msgs = basicSetVar(newVar, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FormlPackage.PREDICATE__VAR, newVar, newVar));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public setExpr getSexpr()
  {
    return sexpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSexpr(setExpr newSexpr, NotificationChain msgs)
  {
    setExpr oldSexpr = sexpr;
    sexpr = newSexpr;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FormlPackage.PREDICATE__SEXPR, oldSexpr, newSexpr);
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
  public void setSexpr(setExpr newSexpr)
  {
    if (newSexpr != sexpr)
    {
      NotificationChain msgs = null;
      if (sexpr != null)
        msgs = ((InternalEObject)sexpr).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FormlPackage.PREDICATE__SEXPR, null, msgs);
      if (newSexpr != null)
        msgs = ((InternalEObject)newSexpr).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FormlPackage.PREDICATE__SEXPR, null, msgs);
      msgs = basicSetSexpr(newSexpr, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FormlPackage.PREDICATE__SEXPR, newSexpr, newSexpr));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public notPred getQuantPred()
  {
    return quantPred;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetQuantPred(notPred newQuantPred, NotificationChain msgs)
  {
    notPred oldQuantPred = quantPred;
    quantPred = newQuantPred;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FormlPackage.PREDICATE__QUANT_PRED, oldQuantPred, newQuantPred);
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
  public void setQuantPred(notPred newQuantPred)
  {
    if (newQuantPred != quantPred)
    {
      NotificationChain msgs = null;
      if (quantPred != null)
        msgs = ((InternalEObject)quantPred).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FormlPackage.PREDICATE__QUANT_PRED, null, msgs);
      if (newQuantPred != null)
        msgs = ((InternalEObject)newQuantPred).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FormlPackage.PREDICATE__QUANT_PRED, null, msgs);
      msgs = basicSetQuantPred(newQuantPred, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FormlPackage.PREDICATE__QUANT_PRED, newQuantPred, newQuantPred));
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
      case FormlPackage.PREDICATE__VAR:
        return basicSetVar(null, msgs);
      case FormlPackage.PREDICATE__SEXPR:
        return basicSetSexpr(null, msgs);
      case FormlPackage.PREDICATE__QUANT_PRED:
        return basicSetQuantPred(null, msgs);
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
      case FormlPackage.PREDICATE__LOGICOP:
        return getLogicop();
      case FormlPackage.PREDICATE__VAR:
        return getVar();
      case FormlPackage.PREDICATE__SEXPR:
        return getSexpr();
      case FormlPackage.PREDICATE__QUANT_PRED:
        return getQuantPred();
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
      case FormlPackage.PREDICATE__LOGICOP:
        setLogicop((String)newValue);
        return;
      case FormlPackage.PREDICATE__VAR:
        setVar((ExprRef)newValue);
        return;
      case FormlPackage.PREDICATE__SEXPR:
        setSexpr((setExpr)newValue);
        return;
      case FormlPackage.PREDICATE__QUANT_PRED:
        setQuantPred((notPred)newValue);
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
      case FormlPackage.PREDICATE__LOGICOP:
        setLogicop(LOGICOP_EDEFAULT);
        return;
      case FormlPackage.PREDICATE__VAR:
        setVar((ExprRef)null);
        return;
      case FormlPackage.PREDICATE__SEXPR:
        setSexpr((setExpr)null);
        return;
      case FormlPackage.PREDICATE__QUANT_PRED:
        setQuantPred((notPred)null);
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
      case FormlPackage.PREDICATE__LOGICOP:
        return LOGICOP_EDEFAULT == null ? logicop != null : !LOGICOP_EDEFAULT.equals(logicop);
      case FormlPackage.PREDICATE__VAR:
        return var != null;
      case FormlPackage.PREDICATE__SEXPR:
        return sexpr != null;
      case FormlPackage.PREDICATE__QUANT_PRED:
        return quantPred != null;
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
    result.append(" (logicop: ");
    result.append(logicop);
    result.append(')');
    return result.toString();
  }

} //PredicateImpl
