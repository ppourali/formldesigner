/**
 */
package uw.cs.watform.forml.forml.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import uw.cs.watform.forml.forml.Action;
import uw.cs.watform.forml.forml.Aggregation;
import uw.cs.watform.forml.forml.AndNode;
import uw.cs.watform.forml.forml.Assign;
import uw.cs.watform.forml.forml.AssignList;
import uw.cs.watform.forml.forml.Association;
import uw.cs.watform.forml.forml.Attribute;
import uw.cs.watform.forml.forml.AttributeType;
import uw.cs.watform.forml.forml.BehaviourModel;
import uw.cs.watform.forml.forml.BoolType;
import uw.cs.watform.forml.forml.Cardinality;
import uw.cs.watform.forml.forml.CompDecl;
import uw.cs.watform.forml.forml.Component;
import uw.cs.watform.forml.forml.Composition;
import uw.cs.watform.forml.forml.Concept;
import uw.cs.watform.forml.forml.Constraint;
import uw.cs.watform.forml.forml.Decl;
import uw.cs.watform.forml.forml.Entity;
import uw.cs.watform.forml.forml.EnumConst;
import uw.cs.watform.forml.forml.Enumeration;
import uw.cs.watform.forml.forml.ExprRef;
import uw.cs.watform.forml.forml.Feature;
import uw.cs.watform.forml.forml.FeatureModule;
import uw.cs.watform.forml.forml.FeatureNode;
import uw.cs.watform.forml.forml.FormlPackage;
import uw.cs.watform.forml.forml.Fragment;
import uw.cs.watform.forml.forml.FragmentType;
import uw.cs.watform.forml.forml.Function;
import uw.cs.watform.forml.forml.Guard;
import uw.cs.watform.forml.forml.InitState;
import uw.cs.watform.forml.forml.Input;
import uw.cs.watform.forml.forml.InputList;
import uw.cs.watform.forml.forml.IntType;
import uw.cs.watform.forml.forml.Macro;
import uw.cs.watform.forml.forml.Message;
import uw.cs.watform.forml.forml.Multiplicity;
import uw.cs.watform.forml.forml.Node;
import uw.cs.watform.forml.forml.OrNode;
import uw.cs.watform.forml.forml.Output;
import uw.cs.watform.forml.forml.OutputList;
import uw.cs.watform.forml.forml.Predicate;
import uw.cs.watform.forml.forml.Priority;
import uw.cs.watform.forml.forml.RefMessage;
import uw.cs.watform.forml.forml.ReferenceType;
import uw.cs.watform.forml.forml.Region;
import uw.cs.watform.forml.forml.RegionContext;
import uw.cs.watform.forml.forml.Relationship;
import uw.cs.watform.forml.forml.Role;
import uw.cs.watform.forml.forml.Roleable;
import uw.cs.watform.forml.forml.SPL;
import uw.cs.watform.forml.forml.State;
import uw.cs.watform.forml.forml.StateContext;
import uw.cs.watform.forml.forml.StateMachine;
import uw.cs.watform.forml.forml.StateMachineContext;
import uw.cs.watform.forml.forml.StringType;
import uw.cs.watform.forml.forml.TranFragment;
import uw.cs.watform.forml.forml.TransList;
import uw.cs.watform.forml.forml.Transition;
import uw.cs.watform.forml.forml.Trigger;
import uw.cs.watform.forml.forml.UndefinedType;
import uw.cs.watform.forml.forml.Variable;
import uw.cs.watform.forml.forml.WCA;
import uw.cs.watform.forml.forml.WCAFragment;
import uw.cs.watform.forml.forml.WCAFragmentList;
import uw.cs.watform.forml.forml.WCAList;
import uw.cs.watform.forml.forml.WCE;
import uw.cs.watform.forml.forml.WorldModel;
import uw.cs.watform.forml.forml.XORNode;
import uw.cs.watform.forml.forml.andPred;
import uw.cs.watform.forml.forml.atomic;
import uw.cs.watform.forml.forml.basePred;
import uw.cs.watform.forml.forml.boolExpr;
import uw.cs.watform.forml.forml.impPred;
import uw.cs.watform.forml.forml.intBase;
import uw.cs.watform.forml.forml.intExpr;
import uw.cs.watform.forml.forml.multExpr;
import uw.cs.watform.forml.forml.notPred;
import uw.cs.watform.forml.forml.orPred;
import uw.cs.watform.forml.forml.predExpr;
import uw.cs.watform.forml.forml.predExpr2;
import uw.cs.watform.forml.forml.predExpr3;
import uw.cs.watform.forml.forml.setExpr;
import uw.cs.watform.forml.forml.setExpr2;
import uw.cs.watform.forml.forml.setExpr3;
import uw.cs.watform.forml.forml.setExprBase;
import uw.cs.watform.forml.forml.unspecified;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see uw.cs.watform.forml.forml.FormlPackage
 * @generated
 */
public class FormlSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static FormlPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FormlSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = FormlPackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case FormlPackage.SYSTEM:
      {
        uw.cs.watform.forml.forml.System system = (uw.cs.watform.forml.forml.System)theEObject;
        T result = caseSystem(system);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FormlPackage.WORLD_MODEL:
      {
        WorldModel worldModel = (WorldModel)theEObject;
        T result = caseWorldModel(worldModel);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FormlPackage.CONSTRAINT:
      {
        Constraint constraint = (Constraint)theEObject;
        T result = caseConstraint(constraint);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FormlPackage.EXPR_REF:
      {
        ExprRef exprRef = (ExprRef)theEObject;
        T result = caseExprRef(exprRef);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FormlPackage.CONCEPT:
      {
        Concept concept = (Concept)theEObject;
        T result = caseConcept(concept);
        if (result == null) result = caseExprRef(concept);
        if (result == null) result = caseAttributeType(concept);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FormlPackage.ROLEABLE:
      {
        Roleable roleable = (Roleable)theEObject;
        T result = caseRoleable(roleable);
        if (result == null) result = caseConcept(roleable);
        if (result == null) result = caseExprRef(roleable);
        if (result == null) result = caseAttributeType(roleable);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FormlPackage.RELATIONSHIP:
      {
        Relationship relationship = (Relationship)theEObject;
        T result = caseRelationship(relationship);
        if (result == null) result = caseConcept(relationship);
        if (result == null) result = caseExprRef(relationship);
        if (result == null) result = caseAttributeType(relationship);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FormlPackage.ATTRIBUTE_TYPE:
      {
        AttributeType attributeType = (AttributeType)theEObject;
        T result = caseAttributeType(attributeType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FormlPackage.STRING_TYPE:
      {
        StringType stringType = (StringType)theEObject;
        T result = caseStringType(stringType);
        if (result == null) result = caseAttributeType(stringType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FormlPackage.INT_TYPE:
      {
        IntType intType = (IntType)theEObject;
        T result = caseIntType(intType);
        if (result == null) result = caseAttributeType(intType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FormlPackage.BOOL_TYPE:
      {
        BoolType boolType = (BoolType)theEObject;
        T result = caseBoolType(boolType);
        if (result == null) result = caseAttributeType(boolType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FormlPackage.REFERENCE_TYPE:
      {
        ReferenceType referenceType = (ReferenceType)theEObject;
        T result = caseReferenceType(referenceType);
        if (result == null) result = caseAttributeType(referenceType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FormlPackage.MULTIPLICITY:
      {
        Multiplicity multiplicity = (Multiplicity)theEObject;
        T result = caseMultiplicity(multiplicity);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FormlPackage.CARDINALITY:
      {
        Cardinality cardinality = (Cardinality)theEObject;
        T result = caseCardinality(cardinality);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FormlPackage.ROLE:
      {
        Role role = (Role)theEObject;
        T result = caseRole(role);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FormlPackage.DECL:
      {
        Decl decl = (Decl)theEObject;
        T result = caseDecl(decl);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FormlPackage.MESSAGE:
      {
        Message message = (Message)theEObject;
        T result = caseMessage(message);
        if (result == null) result = caseConcept(message);
        if (result == null) result = caseExprRef(message);
        if (result == null) result = caseAttributeType(message);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FormlPackage.INPUT_LIST:
      {
        InputList inputList = (InputList)theEObject;
        T result = caseInputList(inputList);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FormlPackage.OUTPUT_LIST:
      {
        OutputList outputList = (OutputList)theEObject;
        T result = caseOutputList(outputList);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FormlPackage.REF_MESSAGE:
      {
        RefMessage refMessage = (RefMessage)theEObject;
        T result = caseRefMessage(refMessage);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FormlPackage.NODE:
      {
        Node node = (Node)theEObject;
        T result = caseNode(node);
        if (result == null) result = caseExprRef(node);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FormlPackage.BEHAVIOUR_MODEL:
      {
        BehaviourModel behaviourModel = (BehaviourModel)theEObject;
        T result = caseBehaviourModel(behaviourModel);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FormlPackage.FEATURE_MODULE:
      {
        FeatureModule featureModule = (FeatureModule)theEObject;
        T result = caseFeatureModule(featureModule);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FormlPackage.STATE_MACHINE:
      {
        StateMachine stateMachine = (StateMachine)theEObject;
        T result = caseStateMachine(stateMachine);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FormlPackage.INIT_STATE:
      {
        InitState initState = (InitState)theEObject;
        T result = caseInitState(initState);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FormlPackage.COMPONENT:
      {
        Component component = (Component)theEObject;
        T result = caseComponent(component);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FormlPackage.TRANSITION:
      {
        Transition transition = (Transition)theEObject;
        T result = caseTransition(transition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FormlPackage.PRIORITY:
      {
        Priority priority = (Priority)theEObject;
        T result = casePriority(priority);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FormlPackage.TRANS_LIST:
      {
        TransList transList = (TransList)theEObject;
        T result = caseTransList(transList);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FormlPackage.GUARD:
      {
        Guard guard = (Guard)theEObject;
        T result = caseGuard(guard);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FormlPackage.TRIGGER:
      {
        Trigger trigger = (Trigger)theEObject;
        T result = caseTrigger(trigger);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FormlPackage.OVERRIDE:
      {
        uw.cs.watform.forml.forml.Override override = (uw.cs.watform.forml.forml.Override)theEObject;
        T result = caseOverride(override);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FormlPackage.WCE:
      {
        WCE wce = (WCE)theEObject;
        T result = caseWCE(wce);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FormlPackage.WCA_LIST:
      {
        WCAList wcaList = (WCAList)theEObject;
        T result = caseWCAList(wcaList);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FormlPackage.WCA:
      {
        WCA wca = (WCA)theEObject;
        T result = caseWCA(wca);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FormlPackage.ACTION:
      {
        Action action = (Action)theEObject;
        T result = caseAction(action);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FormlPackage.ASSIGN_LIST:
      {
        AssignList assignList = (AssignList)theEObject;
        T result = caseAssignList(assignList);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FormlPackage.ASSIGN:
      {
        Assign assign = (Assign)theEObject;
        T result = caseAssign(assign);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FormlPackage.MACRO:
      {
        Macro macro = (Macro)theEObject;
        T result = caseMacro(macro);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FormlPackage.PREDICATE:
      {
        Predicate predicate = (Predicate)theEObject;
        T result = casePredicate(predicate);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FormlPackage.NOT_PRED:
      {
        notPred notPred = (notPred)theEObject;
        T result = casenotPred(notPred);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FormlPackage.AND_PRED:
      {
        andPred andPred = (andPred)theEObject;
        T result = caseandPred(andPred);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FormlPackage.IMP_PRED:
      {
        impPred impPred = (impPred)theEObject;
        T result = caseimpPred(impPred);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FormlPackage.OR_PRED:
      {
        orPred orPred = (orPred)theEObject;
        T result = caseorPred(orPred);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FormlPackage.BASE_PRED:
      {
        basePred basePred = (basePred)theEObject;
        T result = casebasePred(basePred);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FormlPackage.BOOL_EXPR:
      {
        boolExpr boolExpr = (boolExpr)theEObject;
        T result = caseboolExpr(boolExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FormlPackage.PRED_EXPR:
      {
        predExpr predExpr = (predExpr)theEObject;
        T result = casepredExpr(predExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FormlPackage.PRED_EXPR2:
      {
        predExpr2 predExpr2 = (predExpr2)theEObject;
        T result = casepredExpr2(predExpr2);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FormlPackage.PRED_EXPR3:
      {
        predExpr3 predExpr3 = (predExpr3)theEObject;
        T result = casepredExpr3(predExpr3);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FormlPackage.SET_EXPR:
      {
        setExpr setExpr = (setExpr)theEObject;
        T result = casesetExpr(setExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FormlPackage.SET_EXPR2:
      {
        setExpr2 setExpr2 = (setExpr2)theEObject;
        T result = casesetExpr2(setExpr2);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FormlPackage.SET_EXPR3:
      {
        setExpr3 setExpr3 = (setExpr3)theEObject;
        T result = casesetExpr3(setExpr3);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FormlPackage.SET_EXPR_BASE:
      {
        setExprBase setExprBase = (setExprBase)theEObject;
        T result = casesetExprBase(setExprBase);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FormlPackage.INT_EXPR:
      {
        intExpr intExpr = (intExpr)theEObject;
        T result = caseintExpr(intExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FormlPackage.MULT_EXPR:
      {
        multExpr multExpr = (multExpr)theEObject;
        T result = casemultExpr(multExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FormlPackage.INT_BASE:
      {
        intBase intBase = (intBase)theEObject;
        T result = caseintBase(intBase);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FormlPackage.ATOMIC:
      {
        atomic atomic = (atomic)theEObject;
        T result = caseatomic(atomic);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FormlPackage.UNSPECIFIED:
      {
        unspecified unspecified = (unspecified)theEObject;
        T result = caseunspecified(unspecified);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FormlPackage.FRAGMENT:
      {
        Fragment fragment = (Fragment)theEObject;
        T result = caseFragment(fragment);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FormlPackage.FRAGMENT_TYPE:
      {
        FragmentType fragmentType = (FragmentType)theEObject;
        T result = caseFragmentType(fragmentType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FormlPackage.STATE_CONTEXT:
      {
        StateContext stateContext = (StateContext)theEObject;
        T result = caseStateContext(stateContext);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FormlPackage.REGION_CONTEXT:
      {
        RegionContext regionContext = (RegionContext)theEObject;
        T result = caseRegionContext(regionContext);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FormlPackage.STATE_MACHINE_CONTEXT:
      {
        StateMachineContext stateMachineContext = (StateMachineContext)theEObject;
        T result = caseStateMachineContext(stateMachineContext);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FormlPackage.TRAN_FRAGMENT:
      {
        TranFragment tranFragment = (TranFragment)theEObject;
        T result = caseTranFragment(tranFragment);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FormlPackage.WCA_FRAGMENT_LIST:
      {
        WCAFragmentList wcaFragmentList = (WCAFragmentList)theEObject;
        T result = caseWCAFragmentList(wcaFragmentList);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FormlPackage.WCA_FRAGMENT:
      {
        WCAFragment wcaFragment = (WCAFragment)theEObject;
        T result = caseWCAFragment(wcaFragment);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FormlPackage.ENTITY:
      {
        Entity entity = (Entity)theEObject;
        T result = caseEntity(entity);
        if (result == null) result = caseRoleable(entity);
        if (result == null) result = caseConcept(entity);
        if (result == null) result = caseExprRef(entity);
        if (result == null) result = caseAttributeType(entity);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FormlPackage.ASSOCIATION:
      {
        Association association = (Association)theEObject;
        T result = caseAssociation(association);
        if (result == null) result = caseRelationship(association);
        if (result == null) result = caseConcept(association);
        if (result == null) result = caseExprRef(association);
        if (result == null) result = caseAttributeType(association);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FormlPackage.ATTRIBUTE:
      {
        Attribute attribute = (Attribute)theEObject;
        T result = caseAttribute(attribute);
        if (result == null) result = caseExprRef(attribute);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FormlPackage.FUNCTION:
      {
        Function function = (Function)theEObject;
        T result = caseFunction(function);
        if (result == null) result = caseExprRef(function);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FormlPackage.UNDEFINED_TYPE:
      {
        UndefinedType undefinedType = (UndefinedType)theEObject;
        T result = caseUndefinedType(undefinedType);
        if (result == null) result = caseConcept(undefinedType);
        if (result == null) result = caseExprRef(undefinedType);
        if (result == null) result = caseAttributeType(undefinedType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FormlPackage.AGGREGATION:
      {
        Aggregation aggregation = (Aggregation)theEObject;
        T result = caseAggregation(aggregation);
        if (result == null) result = caseRelationship(aggregation);
        if (result == null) result = caseConcept(aggregation);
        if (result == null) result = caseExprRef(aggregation);
        if (result == null) result = caseAttributeType(aggregation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FormlPackage.COMPOSITION:
      {
        Composition composition = (Composition)theEObject;
        T result = caseComposition(composition);
        if (result == null) result = caseRelationship(composition);
        if (result == null) result = caseConcept(composition);
        if (result == null) result = caseExprRef(composition);
        if (result == null) result = caseAttributeType(composition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FormlPackage.COMP_DECL:
      {
        CompDecl compDecl = (CompDecl)theEObject;
        T result = caseCompDecl(compDecl);
        if (result == null) result = caseDecl(compDecl);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FormlPackage.INPUT:
      {
        Input input = (Input)theEObject;
        T result = caseInput(input);
        if (result == null) result = caseMessage(input);
        if (result == null) result = caseConcept(input);
        if (result == null) result = caseExprRef(input);
        if (result == null) result = caseAttributeType(input);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FormlPackage.OUTPUT:
      {
        Output output = (Output)theEObject;
        T result = caseOutput(output);
        if (result == null) result = caseMessage(output);
        if (result == null) result = caseConcept(output);
        if (result == null) result = caseExprRef(output);
        if (result == null) result = caseAttributeType(output);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FormlPackage.FEATURE:
      {
        Feature feature = (Feature)theEObject;
        T result = caseFeature(feature);
        if (result == null) result = caseRoleable(feature);
        if (result == null) result = caseConcept(feature);
        if (result == null) result = caseExprRef(feature);
        if (result == null) result = caseAttributeType(feature);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FormlPackage.SPL:
      {
        SPL spl = (SPL)theEObject;
        T result = caseSPL(spl);
        if (result == null) result = caseNode(spl);
        if (result == null) result = caseExprRef(spl);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FormlPackage.XOR_NODE:
      {
        XORNode xorNode = (XORNode)theEObject;
        T result = caseXORNode(xorNode);
        if (result == null) result = caseNode(xorNode);
        if (result == null) result = caseExprRef(xorNode);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FormlPackage.AND_NODE:
      {
        AndNode andNode = (AndNode)theEObject;
        T result = caseAndNode(andNode);
        if (result == null) result = caseNode(andNode);
        if (result == null) result = caseExprRef(andNode);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FormlPackage.OR_NODE:
      {
        OrNode orNode = (OrNode)theEObject;
        T result = caseOrNode(orNode);
        if (result == null) result = caseNode(orNode);
        if (result == null) result = caseExprRef(orNode);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FormlPackage.FEATURE_NODE:
      {
        FeatureNode featureNode = (FeatureNode)theEObject;
        T result = caseFeatureNode(featureNode);
        if (result == null) result = caseNode(featureNode);
        if (result == null) result = caseExprRef(featureNode);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FormlPackage.ENUMERATION:
      {
        Enumeration enumeration = (Enumeration)theEObject;
        T result = caseEnumeration(enumeration);
        if (result == null) result = caseConcept(enumeration);
        if (result == null) result = caseExprRef(enumeration);
        if (result == null) result = caseAttributeType(enumeration);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FormlPackage.ENUM_CONST:
      {
        EnumConst enumConst = (EnumConst)theEObject;
        T result = caseEnumConst(enumConst);
        if (result == null) result = caseExprRef(enumConst);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FormlPackage.STATE:
      {
        State state = (State)theEObject;
        T result = caseState(state);
        if (result == null) result = caseComponent(state);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FormlPackage.REGION:
      {
        Region region = (Region)theEObject;
        T result = caseRegion(region);
        if (result == null) result = caseComponent(region);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FormlPackage.VARIABLE:
      {
        Variable variable = (Variable)theEObject;
        T result = caseVariable(variable);
        if (result == null) result = caseExprRef(variable);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>System</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>System</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSystem(uw.cs.watform.forml.forml.System object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>World Model</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>World Model</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseWorldModel(WorldModel object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Constraint</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Constraint</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseConstraint(Constraint object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Expr Ref</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Expr Ref</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExprRef(ExprRef object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Concept</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Concept</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseConcept(Concept object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Roleable</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Roleable</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRoleable(Roleable object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Relationship</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Relationship</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRelationship(Relationship object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Attribute Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Attribute Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAttributeType(AttributeType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>String Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>String Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStringType(StringType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Int Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Int Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIntType(IntType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Bool Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Bool Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBoolType(BoolType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Reference Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Reference Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseReferenceType(ReferenceType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Multiplicity</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Multiplicity</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMultiplicity(Multiplicity object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Cardinality</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Cardinality</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCardinality(Cardinality object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Role</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Role</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRole(Role object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Decl</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Decl</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDecl(Decl object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Message</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Message</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMessage(Message object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Input List</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Input List</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInputList(InputList object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Output List</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Output List</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOutputList(OutputList object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Ref Message</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Ref Message</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRefMessage(RefMessage object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Node</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Node</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNode(Node object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Behaviour Model</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Behaviour Model</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBehaviourModel(BehaviourModel object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Feature Module</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Feature Module</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFeatureModule(FeatureModule object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>State Machine</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>State Machine</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStateMachine(StateMachine object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Init State</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Init State</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInitState(InitState object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Component</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Component</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseComponent(Component object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Transition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Transition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTransition(Transition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Priority</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Priority</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePriority(Priority object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Trans List</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Trans List</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTransList(TransList object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Guard</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Guard</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseGuard(Guard object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Trigger</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Trigger</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTrigger(Trigger object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Override</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Override</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOverride(uw.cs.watform.forml.forml.Override object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>WCE</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>WCE</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseWCE(WCE object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>WCA List</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>WCA List</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseWCAList(WCAList object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>WCA</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>WCA</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseWCA(WCA object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Action</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Action</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAction(Action object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Assign List</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Assign List</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAssignList(AssignList object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Assign</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Assign</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAssign(Assign object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Macro</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Macro</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMacro(Macro object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Predicate</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Predicate</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePredicate(Predicate object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>not Pred</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>not Pred</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casenotPred(notPred object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>and Pred</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>and Pred</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseandPred(andPred object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>imp Pred</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>imp Pred</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseimpPred(impPred object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>or Pred</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>or Pred</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseorPred(orPred object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>base Pred</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>base Pred</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casebasePred(basePred object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>bool Expr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>bool Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseboolExpr(boolExpr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>pred Expr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>pred Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casepredExpr(predExpr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>pred Expr2</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>pred Expr2</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casepredExpr2(predExpr2 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>pred Expr3</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>pred Expr3</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casepredExpr3(predExpr3 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>set Expr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>set Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casesetExpr(setExpr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>set Expr2</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>set Expr2</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casesetExpr2(setExpr2 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>set Expr3</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>set Expr3</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casesetExpr3(setExpr3 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>set Expr Base</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>set Expr Base</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casesetExprBase(setExprBase object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>int Expr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>int Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseintExpr(intExpr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>mult Expr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>mult Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casemultExpr(multExpr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>int Base</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>int Base</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseintBase(intBase object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>atomic</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>atomic</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseatomic(atomic object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>unspecified</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>unspecified</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseunspecified(unspecified object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Fragment</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Fragment</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFragment(Fragment object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Fragment Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Fragment Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFragmentType(FragmentType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>State Context</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>State Context</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStateContext(StateContext object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Region Context</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Region Context</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRegionContext(RegionContext object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>State Machine Context</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>State Machine Context</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStateMachineContext(StateMachineContext object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Tran Fragment</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Tran Fragment</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTranFragment(TranFragment object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>WCA Fragment List</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>WCA Fragment List</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseWCAFragmentList(WCAFragmentList object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>WCA Fragment</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>WCA Fragment</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseWCAFragment(WCAFragment object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Entity</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Entity</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEntity(Entity object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Association</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Association</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAssociation(Association object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Attribute</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Attribute</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAttribute(Attribute object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Function</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Function</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFunction(Function object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Undefined Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Undefined Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUndefinedType(UndefinedType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Aggregation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Aggregation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAggregation(Aggregation object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Composition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Composition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseComposition(Composition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Comp Decl</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Comp Decl</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCompDecl(CompDecl object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Input</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Input</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInput(Input object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Output</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Output</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOutput(Output object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Feature</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Feature</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFeature(Feature object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>SPL</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>SPL</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSPL(SPL object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>XOR Node</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>XOR Node</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseXORNode(XORNode object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>And Node</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>And Node</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAndNode(AndNode object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Or Node</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Or Node</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOrNode(OrNode object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Feature Node</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Feature Node</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFeatureNode(FeatureNode object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Enumeration</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Enumeration</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEnumeration(Enumeration object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Enum Const</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Enum Const</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEnumConst(EnumConst object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>State</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>State</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseState(State object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Region</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Region</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRegion(Region object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Variable</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Variable</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVariable(Variable object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object)
  {
    return null;
  }

} //FormlSwitch
