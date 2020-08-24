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
import uw.cs.watform.forml.forml.Predicate;
import uw.cs.watform.forml.forml.basePred;
import uw.cs.watform.forml.forml.boolExpr;
import uw.cs.watform.forml.forml.intExpr;
import uw.cs.watform.forml.forml.predExpr;
import uw.cs.watform.forml.forml.setExpr;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>base Pred</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uw.cs.watform.forml.forml.impl.basePredImpl#getLogicop <em>Logicop</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.impl.basePredImpl#getCardpred <em>Cardpred</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.impl.basePredImpl#getSetlhs <em>Setlhs</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.impl.basePredImpl#getSetrhs <em>Setrhs</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.impl.basePredImpl#getBoolrhs <em>Boolrhs</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.impl.basePredImpl#getIntlhs <em>Intlhs</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.impl.basePredImpl#getOp <em>Op</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.impl.basePredImpl#getIntrhs <em>Intrhs</em>}</li>
 *   <li>{@link uw.cs.watform.forml.forml.impl.basePredImpl#getParenPred <em>Paren Pred</em>}</li>
 * </ul>
 *
 * @generated
 */
public class basePredImpl extends MinimalEObjectImpl.Container implements basePred
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
   * The cached value of the '{@link #getCardpred() <em>Cardpred</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCardpred()
   * @generated
   * @ordered
   */
  protected setExpr cardpred;

  /**
   * The cached value of the '{@link #getSetlhs() <em>Setlhs</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSetlhs()
   * @generated
   * @ordered
   */
  protected predExpr setlhs;

  /**
   * The cached value of the '{@link #getSetrhs() <em>Setrhs</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSetrhs()
   * @generated
   * @ordered
   */
  protected predExpr setrhs;

  /**
   * The cached value of the '{@link #getBoolrhs() <em>Boolrhs</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBoolrhs()
   * @generated
   * @ordered
   */
  protected boolExpr boolrhs;

  /**
   * The cached value of the '{@link #getIntlhs() <em>Intlhs</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIntlhs()
   * @generated
   * @ordered
   */
  protected intExpr intlhs;

  /**
   * The default value of the '{@link #getOp() <em>Op</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOp()
   * @generated
   * @ordered
   */
  protected static final String OP_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getOp() <em>Op</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOp()
   * @generated
   * @ordered
   */
  protected String op = OP_EDEFAULT;

  /**
   * The cached value of the '{@link #getIntrhs() <em>Intrhs</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIntrhs()
   * @generated
   * @ordered
   */
  protected intExpr intrhs;

  /**
   * The cached value of the '{@link #getParenPred() <em>Paren Pred</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParenPred()
   * @generated
   * @ordered
   */
  protected Predicate parenPred;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected basePredImpl()
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
    return FormlPackage.Literals.BASE_PRED;
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
      eNotify(new ENotificationImpl(this, Notification.SET, FormlPackage.BASE_PRED__LOGICOP, oldLogicop, logicop));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public setExpr getCardpred()
  {
    return cardpred;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetCardpred(setExpr newCardpred, NotificationChain msgs)
  {
    setExpr oldCardpred = cardpred;
    cardpred = newCardpred;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FormlPackage.BASE_PRED__CARDPRED, oldCardpred, newCardpred);
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
  public void setCardpred(setExpr newCardpred)
  {
    if (newCardpred != cardpred)
    {
      NotificationChain msgs = null;
      if (cardpred != null)
        msgs = ((InternalEObject)cardpred).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FormlPackage.BASE_PRED__CARDPRED, null, msgs);
      if (newCardpred != null)
        msgs = ((InternalEObject)newCardpred).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FormlPackage.BASE_PRED__CARDPRED, null, msgs);
      msgs = basicSetCardpred(newCardpred, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FormlPackage.BASE_PRED__CARDPRED, newCardpred, newCardpred));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public predExpr getSetlhs()
  {
    return setlhs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSetlhs(predExpr newSetlhs, NotificationChain msgs)
  {
    predExpr oldSetlhs = setlhs;
    setlhs = newSetlhs;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FormlPackage.BASE_PRED__SETLHS, oldSetlhs, newSetlhs);
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
  public void setSetlhs(predExpr newSetlhs)
  {
    if (newSetlhs != setlhs)
    {
      NotificationChain msgs = null;
      if (setlhs != null)
        msgs = ((InternalEObject)setlhs).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FormlPackage.BASE_PRED__SETLHS, null, msgs);
      if (newSetlhs != null)
        msgs = ((InternalEObject)newSetlhs).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FormlPackage.BASE_PRED__SETLHS, null, msgs);
      msgs = basicSetSetlhs(newSetlhs, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FormlPackage.BASE_PRED__SETLHS, newSetlhs, newSetlhs));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public predExpr getSetrhs()
  {
    return setrhs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSetrhs(predExpr newSetrhs, NotificationChain msgs)
  {
    predExpr oldSetrhs = setrhs;
    setrhs = newSetrhs;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FormlPackage.BASE_PRED__SETRHS, oldSetrhs, newSetrhs);
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
  public void setSetrhs(predExpr newSetrhs)
  {
    if (newSetrhs != setrhs)
    {
      NotificationChain msgs = null;
      if (setrhs != null)
        msgs = ((InternalEObject)setrhs).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FormlPackage.BASE_PRED__SETRHS, null, msgs);
      if (newSetrhs != null)
        msgs = ((InternalEObject)newSetrhs).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FormlPackage.BASE_PRED__SETRHS, null, msgs);
      msgs = basicSetSetrhs(newSetrhs, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FormlPackage.BASE_PRED__SETRHS, newSetrhs, newSetrhs));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolExpr getBoolrhs()
  {
    return boolrhs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetBoolrhs(boolExpr newBoolrhs, NotificationChain msgs)
  {
    boolExpr oldBoolrhs = boolrhs;
    boolrhs = newBoolrhs;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FormlPackage.BASE_PRED__BOOLRHS, oldBoolrhs, newBoolrhs);
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
  public void setBoolrhs(boolExpr newBoolrhs)
  {
    if (newBoolrhs != boolrhs)
    {
      NotificationChain msgs = null;
      if (boolrhs != null)
        msgs = ((InternalEObject)boolrhs).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FormlPackage.BASE_PRED__BOOLRHS, null, msgs);
      if (newBoolrhs != null)
        msgs = ((InternalEObject)newBoolrhs).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FormlPackage.BASE_PRED__BOOLRHS, null, msgs);
      msgs = basicSetBoolrhs(newBoolrhs, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FormlPackage.BASE_PRED__BOOLRHS, newBoolrhs, newBoolrhs));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public intExpr getIntlhs()
  {
    return intlhs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetIntlhs(intExpr newIntlhs, NotificationChain msgs)
  {
    intExpr oldIntlhs = intlhs;
    intlhs = newIntlhs;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FormlPackage.BASE_PRED__INTLHS, oldIntlhs, newIntlhs);
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
  public void setIntlhs(intExpr newIntlhs)
  {
    if (newIntlhs != intlhs)
    {
      NotificationChain msgs = null;
      if (intlhs != null)
        msgs = ((InternalEObject)intlhs).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FormlPackage.BASE_PRED__INTLHS, null, msgs);
      if (newIntlhs != null)
        msgs = ((InternalEObject)newIntlhs).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FormlPackage.BASE_PRED__INTLHS, null, msgs);
      msgs = basicSetIntlhs(newIntlhs, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FormlPackage.BASE_PRED__INTLHS, newIntlhs, newIntlhs));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getOp()
  {
    return op;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setOp(String newOp)
  {
    String oldOp = op;
    op = newOp;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FormlPackage.BASE_PRED__OP, oldOp, op));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public intExpr getIntrhs()
  {
    return intrhs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetIntrhs(intExpr newIntrhs, NotificationChain msgs)
  {
    intExpr oldIntrhs = intrhs;
    intrhs = newIntrhs;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FormlPackage.BASE_PRED__INTRHS, oldIntrhs, newIntrhs);
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
  public void setIntrhs(intExpr newIntrhs)
  {
    if (newIntrhs != intrhs)
    {
      NotificationChain msgs = null;
      if (intrhs != null)
        msgs = ((InternalEObject)intrhs).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FormlPackage.BASE_PRED__INTRHS, null, msgs);
      if (newIntrhs != null)
        msgs = ((InternalEObject)newIntrhs).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FormlPackage.BASE_PRED__INTRHS, null, msgs);
      msgs = basicSetIntrhs(newIntrhs, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FormlPackage.BASE_PRED__INTRHS, newIntrhs, newIntrhs));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Predicate getParenPred()
  {
    return parenPred;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetParenPred(Predicate newParenPred, NotificationChain msgs)
  {
    Predicate oldParenPred = parenPred;
    parenPred = newParenPred;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FormlPackage.BASE_PRED__PAREN_PRED, oldParenPred, newParenPred);
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
  public void setParenPred(Predicate newParenPred)
  {
    if (newParenPred != parenPred)
    {
      NotificationChain msgs = null;
      if (parenPred != null)
        msgs = ((InternalEObject)parenPred).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FormlPackage.BASE_PRED__PAREN_PRED, null, msgs);
      if (newParenPred != null)
        msgs = ((InternalEObject)newParenPred).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FormlPackage.BASE_PRED__PAREN_PRED, null, msgs);
      msgs = basicSetParenPred(newParenPred, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FormlPackage.BASE_PRED__PAREN_PRED, newParenPred, newParenPred));
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
      case FormlPackage.BASE_PRED__CARDPRED:
        return basicSetCardpred(null, msgs);
      case FormlPackage.BASE_PRED__SETLHS:
        return basicSetSetlhs(null, msgs);
      case FormlPackage.BASE_PRED__SETRHS:
        return basicSetSetrhs(null, msgs);
      case FormlPackage.BASE_PRED__BOOLRHS:
        return basicSetBoolrhs(null, msgs);
      case FormlPackage.BASE_PRED__INTLHS:
        return basicSetIntlhs(null, msgs);
      case FormlPackage.BASE_PRED__INTRHS:
        return basicSetIntrhs(null, msgs);
      case FormlPackage.BASE_PRED__PAREN_PRED:
        return basicSetParenPred(null, msgs);
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
      case FormlPackage.BASE_PRED__LOGICOP:
        return getLogicop();
      case FormlPackage.BASE_PRED__CARDPRED:
        return getCardpred();
      case FormlPackage.BASE_PRED__SETLHS:
        return getSetlhs();
      case FormlPackage.BASE_PRED__SETRHS:
        return getSetrhs();
      case FormlPackage.BASE_PRED__BOOLRHS:
        return getBoolrhs();
      case FormlPackage.BASE_PRED__INTLHS:
        return getIntlhs();
      case FormlPackage.BASE_PRED__OP:
        return getOp();
      case FormlPackage.BASE_PRED__INTRHS:
        return getIntrhs();
      case FormlPackage.BASE_PRED__PAREN_PRED:
        return getParenPred();
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
      case FormlPackage.BASE_PRED__LOGICOP:
        setLogicop((String)newValue);
        return;
      case FormlPackage.BASE_PRED__CARDPRED:
        setCardpred((setExpr)newValue);
        return;
      case FormlPackage.BASE_PRED__SETLHS:
        setSetlhs((predExpr)newValue);
        return;
      case FormlPackage.BASE_PRED__SETRHS:
        setSetrhs((predExpr)newValue);
        return;
      case FormlPackage.BASE_PRED__BOOLRHS:
        setBoolrhs((boolExpr)newValue);
        return;
      case FormlPackage.BASE_PRED__INTLHS:
        setIntlhs((intExpr)newValue);
        return;
      case FormlPackage.BASE_PRED__OP:
        setOp((String)newValue);
        return;
      case FormlPackage.BASE_PRED__INTRHS:
        setIntrhs((intExpr)newValue);
        return;
      case FormlPackage.BASE_PRED__PAREN_PRED:
        setParenPred((Predicate)newValue);
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
      case FormlPackage.BASE_PRED__LOGICOP:
        setLogicop(LOGICOP_EDEFAULT);
        return;
      case FormlPackage.BASE_PRED__CARDPRED:
        setCardpred((setExpr)null);
        return;
      case FormlPackage.BASE_PRED__SETLHS:
        setSetlhs((predExpr)null);
        return;
      case FormlPackage.BASE_PRED__SETRHS:
        setSetrhs((predExpr)null);
        return;
      case FormlPackage.BASE_PRED__BOOLRHS:
        setBoolrhs((boolExpr)null);
        return;
      case FormlPackage.BASE_PRED__INTLHS:
        setIntlhs((intExpr)null);
        return;
      case FormlPackage.BASE_PRED__OP:
        setOp(OP_EDEFAULT);
        return;
      case FormlPackage.BASE_PRED__INTRHS:
        setIntrhs((intExpr)null);
        return;
      case FormlPackage.BASE_PRED__PAREN_PRED:
        setParenPred((Predicate)null);
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
      case FormlPackage.BASE_PRED__LOGICOP:
        return LOGICOP_EDEFAULT == null ? logicop != null : !LOGICOP_EDEFAULT.equals(logicop);
      case FormlPackage.BASE_PRED__CARDPRED:
        return cardpred != null;
      case FormlPackage.BASE_PRED__SETLHS:
        return setlhs != null;
      case FormlPackage.BASE_PRED__SETRHS:
        return setrhs != null;
      case FormlPackage.BASE_PRED__BOOLRHS:
        return boolrhs != null;
      case FormlPackage.BASE_PRED__INTLHS:
        return intlhs != null;
      case FormlPackage.BASE_PRED__OP:
        return OP_EDEFAULT == null ? op != null : !OP_EDEFAULT.equals(op);
      case FormlPackage.BASE_PRED__INTRHS:
        return intrhs != null;
      case FormlPackage.BASE_PRED__PAREN_PRED:
        return parenPred != null;
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
    result.append(", op: ");
    result.append(op);
    result.append(')');
    return result.toString();
  }

} //basePredImpl
