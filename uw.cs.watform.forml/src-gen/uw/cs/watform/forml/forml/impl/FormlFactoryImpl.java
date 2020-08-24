/**
 */
package uw.cs.watform.forml.forml.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

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
import uw.cs.watform.forml.forml.FormlFactory;
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
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FormlFactoryImpl extends EFactoryImpl implements FormlFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static FormlFactory init()
  {
    try
    {
      FormlFactory theFormlFactory = (FormlFactory)EPackage.Registry.INSTANCE.getEFactory(FormlPackage.eNS_URI);
      if (theFormlFactory != null)
      {
        return theFormlFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new FormlFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FormlFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case FormlPackage.SYSTEM: return createSystem();
      case FormlPackage.WORLD_MODEL: return createWorldModel();
      case FormlPackage.CONSTRAINT: return createConstraint();
      case FormlPackage.EXPR_REF: return createExprRef();
      case FormlPackage.CONCEPT: return createConcept();
      case FormlPackage.ROLEABLE: return createRoleable();
      case FormlPackage.RELATIONSHIP: return createRelationship();
      case FormlPackage.ATTRIBUTE_TYPE: return createAttributeType();
      case FormlPackage.STRING_TYPE: return createStringType();
      case FormlPackage.INT_TYPE: return createIntType();
      case FormlPackage.BOOL_TYPE: return createBoolType();
      case FormlPackage.REFERENCE_TYPE: return createReferenceType();
      case FormlPackage.MULTIPLICITY: return createMultiplicity();
      case FormlPackage.CARDINALITY: return createCardinality();
      case FormlPackage.ROLE: return createRole();
      case FormlPackage.DECL: return createDecl();
      case FormlPackage.MESSAGE: return createMessage();
      case FormlPackage.INPUT_LIST: return createInputList();
      case FormlPackage.OUTPUT_LIST: return createOutputList();
      case FormlPackage.REF_MESSAGE: return createRefMessage();
      case FormlPackage.NODE: return createNode();
      case FormlPackage.BEHAVIOUR_MODEL: return createBehaviourModel();
      case FormlPackage.FEATURE_MODULE: return createFeatureModule();
      case FormlPackage.STATE_MACHINE: return createStateMachine();
      case FormlPackage.INIT_STATE: return createInitState();
      case FormlPackage.COMPONENT: return createComponent();
      case FormlPackage.TRANSITION: return createTransition();
      case FormlPackage.PRIORITY: return createPriority();
      case FormlPackage.TRANS_LIST: return createTransList();
      case FormlPackage.GUARD: return createGuard();
      case FormlPackage.TRIGGER: return createTrigger();
      case FormlPackage.OVERRIDE: return createOverride();
      case FormlPackage.WCE: return createWCE();
      case FormlPackage.WCA_LIST: return createWCAList();
      case FormlPackage.WCA: return createWCA();
      case FormlPackage.ACTION: return createAction();
      case FormlPackage.ASSIGN_LIST: return createAssignList();
      case FormlPackage.ASSIGN: return createAssign();
      case FormlPackage.MACRO: return createMacro();
      case FormlPackage.PREDICATE: return createPredicate();
      case FormlPackage.NOT_PRED: return createnotPred();
      case FormlPackage.AND_PRED: return createandPred();
      case FormlPackage.IMP_PRED: return createimpPred();
      case FormlPackage.OR_PRED: return createorPred();
      case FormlPackage.BASE_PRED: return createbasePred();
      case FormlPackage.BOOL_EXPR: return createboolExpr();
      case FormlPackage.PRED_EXPR: return createpredExpr();
      case FormlPackage.PRED_EXPR2: return createpredExpr2();
      case FormlPackage.PRED_EXPR3: return createpredExpr3();
      case FormlPackage.SET_EXPR: return createsetExpr();
      case FormlPackage.SET_EXPR2: return createsetExpr2();
      case FormlPackage.SET_EXPR3: return createsetExpr3();
      case FormlPackage.SET_EXPR_BASE: return createsetExprBase();
      case FormlPackage.INT_EXPR: return createintExpr();
      case FormlPackage.MULT_EXPR: return createmultExpr();
      case FormlPackage.INT_BASE: return createintBase();
      case FormlPackage.ATOMIC: return createatomic();
      case FormlPackage.UNSPECIFIED: return createunspecified();
      case FormlPackage.FRAGMENT: return createFragment();
      case FormlPackage.FRAGMENT_TYPE: return createFragmentType();
      case FormlPackage.STATE_CONTEXT: return createStateContext();
      case FormlPackage.REGION_CONTEXT: return createRegionContext();
      case FormlPackage.STATE_MACHINE_CONTEXT: return createStateMachineContext();
      case FormlPackage.TRAN_FRAGMENT: return createTranFragment();
      case FormlPackage.WCA_FRAGMENT_LIST: return createWCAFragmentList();
      case FormlPackage.WCA_FRAGMENT: return createWCAFragment();
      case FormlPackage.ENTITY: return createEntity();
      case FormlPackage.ASSOCIATION: return createAssociation();
      case FormlPackage.ATTRIBUTE: return createAttribute();
      case FormlPackage.FUNCTION: return createFunction();
      case FormlPackage.UNDEFINED_TYPE: return createUndefinedType();
      case FormlPackage.AGGREGATION: return createAggregation();
      case FormlPackage.COMPOSITION: return createComposition();
      case FormlPackage.COMP_DECL: return createCompDecl();
      case FormlPackage.INPUT: return createInput();
      case FormlPackage.OUTPUT: return createOutput();
      case FormlPackage.FEATURE: return createFeature();
      case FormlPackage.SPL: return createSPL();
      case FormlPackage.XOR_NODE: return createXORNode();
      case FormlPackage.AND_NODE: return createAndNode();
      case FormlPackage.OR_NODE: return createOrNode();
      case FormlPackage.FEATURE_NODE: return createFeatureNode();
      case FormlPackage.ENUMERATION: return createEnumeration();
      case FormlPackage.ENUM_CONST: return createEnumConst();
      case FormlPackage.STATE: return createState();
      case FormlPackage.REGION: return createRegion();
      case FormlPackage.VARIABLE: return createVariable();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public uw.cs.watform.forml.forml.System createSystem()
  {
    SystemImpl system = new SystemImpl();
    return system;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public WorldModel createWorldModel()
  {
    WorldModelImpl worldModel = new WorldModelImpl();
    return worldModel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Constraint createConstraint()
  {
    ConstraintImpl constraint = new ConstraintImpl();
    return constraint;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ExprRef createExprRef()
  {
    ExprRefImpl exprRef = new ExprRefImpl();
    return exprRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Concept createConcept()
  {
    ConceptImpl concept = new ConceptImpl();
    return concept;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Roleable createRoleable()
  {
    RoleableImpl roleable = new RoleableImpl();
    return roleable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Relationship createRelationship()
  {
    RelationshipImpl relationship = new RelationshipImpl();
    return relationship;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public AttributeType createAttributeType()
  {
    AttributeTypeImpl attributeType = new AttributeTypeImpl();
    return attributeType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public StringType createStringType()
  {
    StringTypeImpl stringType = new StringTypeImpl();
    return stringType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public IntType createIntType()
  {
    IntTypeImpl intType = new IntTypeImpl();
    return intType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public BoolType createBoolType()
  {
    BoolTypeImpl boolType = new BoolTypeImpl();
    return boolType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ReferenceType createReferenceType()
  {
    ReferenceTypeImpl referenceType = new ReferenceTypeImpl();
    return referenceType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Multiplicity createMultiplicity()
  {
    MultiplicityImpl multiplicity = new MultiplicityImpl();
    return multiplicity;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Cardinality createCardinality()
  {
    CardinalityImpl cardinality = new CardinalityImpl();
    return cardinality;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Role createRole()
  {
    RoleImpl role = new RoleImpl();
    return role;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Decl createDecl()
  {
    DeclImpl decl = new DeclImpl();
    return decl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Message createMessage()
  {
    MessageImpl message = new MessageImpl();
    return message;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public InputList createInputList()
  {
    InputListImpl inputList = new InputListImpl();
    return inputList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public OutputList createOutputList()
  {
    OutputListImpl outputList = new OutputListImpl();
    return outputList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public RefMessage createRefMessage()
  {
    RefMessageImpl refMessage = new RefMessageImpl();
    return refMessage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Node createNode()
  {
    NodeImpl node = new NodeImpl();
    return node;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public BehaviourModel createBehaviourModel()
  {
    BehaviourModelImpl behaviourModel = new BehaviourModelImpl();
    return behaviourModel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public FeatureModule createFeatureModule()
  {
    FeatureModuleImpl featureModule = new FeatureModuleImpl();
    return featureModule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public StateMachine createStateMachine()
  {
    StateMachineImpl stateMachine = new StateMachineImpl();
    return stateMachine;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public InitState createInitState()
  {
    InitStateImpl initState = new InitStateImpl();
    return initState;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Component createComponent()
  {
    ComponentImpl component = new ComponentImpl();
    return component;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Transition createTransition()
  {
    TransitionImpl transition = new TransitionImpl();
    return transition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Priority createPriority()
  {
    PriorityImpl priority = new PriorityImpl();
    return priority;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public TransList createTransList()
  {
    TransListImpl transList = new TransListImpl();
    return transList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Guard createGuard()
  {
    GuardImpl guard = new GuardImpl();
    return guard;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Trigger createTrigger()
  {
    TriggerImpl trigger = new TriggerImpl();
    return trigger;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public uw.cs.watform.forml.forml.Override createOverride()
  {
    OverrideImpl override = new OverrideImpl();
    return override;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public WCE createWCE()
  {
    WCEImpl wce = new WCEImpl();
    return wce;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public WCAList createWCAList()
  {
    WCAListImpl wcaList = new WCAListImpl();
    return wcaList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public WCA createWCA()
  {
    WCAImpl wca = new WCAImpl();
    return wca;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Action createAction()
  {
    ActionImpl action = new ActionImpl();
    return action;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public AssignList createAssignList()
  {
    AssignListImpl assignList = new AssignListImpl();
    return assignList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Assign createAssign()
  {
    AssignImpl assign = new AssignImpl();
    return assign;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Macro createMacro()
  {
    MacroImpl macro = new MacroImpl();
    return macro;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Predicate createPredicate()
  {
    PredicateImpl predicate = new PredicateImpl();
    return predicate;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public notPred createnotPred()
  {
    notPredImpl notPred = new notPredImpl();
    return notPred;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public andPred createandPred()
  {
    andPredImpl andPred = new andPredImpl();
    return andPred;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public impPred createimpPred()
  {
    impPredImpl impPred = new impPredImpl();
    return impPred;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public orPred createorPred()
  {
    orPredImpl orPred = new orPredImpl();
    return orPred;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public basePred createbasePred()
  {
    basePredImpl basePred = new basePredImpl();
    return basePred;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolExpr createboolExpr()
  {
    boolExprImpl boolExpr = new boolExprImpl();
    return boolExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public predExpr createpredExpr()
  {
    predExprImpl predExpr = new predExprImpl();
    return predExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public predExpr2 createpredExpr2()
  {
    predExpr2Impl predExpr2 = new predExpr2Impl();
    return predExpr2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public predExpr3 createpredExpr3()
  {
    predExpr3Impl predExpr3 = new predExpr3Impl();
    return predExpr3;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public setExpr createsetExpr()
  {
    setExprImpl setExpr = new setExprImpl();
    return setExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public setExpr2 createsetExpr2()
  {
    setExpr2Impl setExpr2 = new setExpr2Impl();
    return setExpr2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public setExpr3 createsetExpr3()
  {
    setExpr3Impl setExpr3 = new setExpr3Impl();
    return setExpr3;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public setExprBase createsetExprBase()
  {
    setExprBaseImpl setExprBase = new setExprBaseImpl();
    return setExprBase;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public intExpr createintExpr()
  {
    intExprImpl intExpr = new intExprImpl();
    return intExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public multExpr createmultExpr()
  {
    multExprImpl multExpr = new multExprImpl();
    return multExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public intBase createintBase()
  {
    intBaseImpl intBase = new intBaseImpl();
    return intBase;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public atomic createatomic()
  {
    atomicImpl atomic = new atomicImpl();
    return atomic;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public unspecified createunspecified()
  {
    unspecifiedImpl unspecified = new unspecifiedImpl();
    return unspecified;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Fragment createFragment()
  {
    FragmentImpl fragment = new FragmentImpl();
    return fragment;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public FragmentType createFragmentType()
  {
    FragmentTypeImpl fragmentType = new FragmentTypeImpl();
    return fragmentType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public StateContext createStateContext()
  {
    StateContextImpl stateContext = new StateContextImpl();
    return stateContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public RegionContext createRegionContext()
  {
    RegionContextImpl regionContext = new RegionContextImpl();
    return regionContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public StateMachineContext createStateMachineContext()
  {
    StateMachineContextImpl stateMachineContext = new StateMachineContextImpl();
    return stateMachineContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public TranFragment createTranFragment()
  {
    TranFragmentImpl tranFragment = new TranFragmentImpl();
    return tranFragment;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public WCAFragmentList createWCAFragmentList()
  {
    WCAFragmentListImpl wcaFragmentList = new WCAFragmentListImpl();
    return wcaFragmentList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public WCAFragment createWCAFragment()
  {
    WCAFragmentImpl wcaFragment = new WCAFragmentImpl();
    return wcaFragment;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Entity createEntity()
  {
    EntityImpl entity = new EntityImpl();
    return entity;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Association createAssociation()
  {
    AssociationImpl association = new AssociationImpl();
    return association;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Attribute createAttribute()
  {
    AttributeImpl attribute = new AttributeImpl();
    return attribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Function createFunction()
  {
    FunctionImpl function = new FunctionImpl();
    return function;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public UndefinedType createUndefinedType()
  {
    UndefinedTypeImpl undefinedType = new UndefinedTypeImpl();
    return undefinedType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Aggregation createAggregation()
  {
    AggregationImpl aggregation = new AggregationImpl();
    return aggregation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Composition createComposition()
  {
    CompositionImpl composition = new CompositionImpl();
    return composition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public CompDecl createCompDecl()
  {
    CompDeclImpl compDecl = new CompDeclImpl();
    return compDecl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Input createInput()
  {
    InputImpl input = new InputImpl();
    return input;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Output createOutput()
  {
    OutputImpl output = new OutputImpl();
    return output;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Feature createFeature()
  {
    FeatureImpl feature = new FeatureImpl();
    return feature;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public SPL createSPL()
  {
    SPLImpl spl = new SPLImpl();
    return spl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public XORNode createXORNode()
  {
    XORNodeImpl xorNode = new XORNodeImpl();
    return xorNode;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public AndNode createAndNode()
  {
    AndNodeImpl andNode = new AndNodeImpl();
    return andNode;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public OrNode createOrNode()
  {
    OrNodeImpl orNode = new OrNodeImpl();
    return orNode;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public FeatureNode createFeatureNode()
  {
    FeatureNodeImpl featureNode = new FeatureNodeImpl();
    return featureNode;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Enumeration createEnumeration()
  {
    EnumerationImpl enumeration = new EnumerationImpl();
    return enumeration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EnumConst createEnumConst()
  {
    EnumConstImpl enumConst = new EnumConstImpl();
    return enumConst;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public State createState()
  {
    StateImpl state = new StateImpl();
    return state;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Region createRegion()
  {
    RegionImpl region = new RegionImpl();
    return region;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Variable createVariable()
  {
    VariableImpl variable = new VariableImpl();
    return variable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public FormlPackage getFormlPackage()
  {
    return (FormlPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static FormlPackage getPackage()
  {
    return FormlPackage.eINSTANCE;
  }

} //FormlFactoryImpl
