package uw.cs.watform.forml.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import uw.cs.watform.forml.services.FormlGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalFormlParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'World'", "'{'", "'}'", "'Constraints'", "'abstract'", "'ctrl'", "'entity'", "'extends'", "'association'", "'attribute'", "'['", "']'", "':'", "'string'", "'String'", "'function'", "'int'", "'Integer'", "'bool'", "'Boolean'", "'undefined_type'", "'*'", "'..'", "'role'", "'aggregation'", "'whole'", "'part'", "'composition'", "'input'", "'type'", "'to'", "'output'", "'from'", "'inputs'", "','", "'outputs'", "'feature'", "'SPL'", "'XOR'", "'AND'", "'OR'", "'FeatureNode'", "'enum'", "'Behaviour'", "'FeatureModule'", "'statemachine'", "'init'", "'='", "'state'", "'region'", "'transition'", "'->'", "'>'", "'[]'", "'event:'", "'override'", "'('", "')'", "'+'", "'-'", "'/'", "'!'", "':='", "'let'", "'no'", "'lone'", "'one'", "'some'", "'all'", "'|'", "'not'", "'and'", "'implies'", "'iff'", "'or'", "'in'", "'<>'", "'<'", "'>='", "'=>'", "'<='", "'=<'", "'true'", "'false'", "'&'", "'#'", "'none'", "'@pre'", "'s'", "'()'", "'fragment'", "'StateFragment'", "'RegionFragment'", "'SMFragment'", "'TransitionFragment'", "'.'"
    };
    public static final int T__50=50;
    public static final int T__59=59;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=4;
    public static final int RULE_INT=5;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__67=67;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__91=91;
    public static final int T__100=100;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__102=102;
    public static final int T__94=94;
    public static final int T__101=101;
    public static final int T__90=90;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__99=99;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__95=95;
    public static final int T__96=96;
    public static final int T__97=97;
    public static final int T__98=98;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__77=77;
    public static final int T__78=78;
    public static final int T__79=79;
    public static final int T__73=73;
    public static final int EOF=-1;
    public static final int T__74=74;
    public static final int T__75=75;
    public static final int T__76=76;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__88=88;
    public static final int T__89=89;
    public static final int T__84=84;
    public static final int T__104=104;
    public static final int T__85=85;
    public static final int T__103=103;
    public static final int T__86=86;
    public static final int T__106=106;
    public static final int T__87=87;
    public static final int T__105=105;

    // delegates
    // delegators


        public InternalFormlParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalFormlParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalFormlParser.tokenNames; }
    public String getGrammarFileName() { return "InternalForml.g"; }



     	private FormlGrammarAccess grammarAccess;
     	
        public InternalFormlParser(TokenStream input, FormlGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "System";	
       	}
       	
       	@Override
       	protected FormlGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleSystem"
    // InternalForml.g:67:1: entryRuleSystem returns [EObject current=null] : iv_ruleSystem= ruleSystem EOF ;
    public final EObject entryRuleSystem() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSystem = null;


        try {
            // InternalForml.g:68:2: (iv_ruleSystem= ruleSystem EOF )
            // InternalForml.g:69:2: iv_ruleSystem= ruleSystem EOF
            {
             newCompositeNode(grammarAccess.getSystemRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSystem=ruleSystem();

            state._fsp--;

             current =iv_ruleSystem; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSystem"


    // $ANTLR start "ruleSystem"
    // InternalForml.g:76:1: ruleSystem returns [EObject current=null] : ( () ( ( ( ( ({...}? => ( ({...}? => ( (lv_worldmodel_2_0= ruleWorldModel ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_behaviourmodel_3_0= ruleBehaviourModel ) ) ) ) ) )* ) ) ) ) ;
    public final EObject ruleSystem() throws RecognitionException {
        EObject current = null;

        EObject lv_worldmodel_2_0 = null;

        EObject lv_behaviourmodel_3_0 = null;


         enterRule(); 
            
        try {
            // InternalForml.g:79:28: ( ( () ( ( ( ( ({...}? => ( ({...}? => ( (lv_worldmodel_2_0= ruleWorldModel ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_behaviourmodel_3_0= ruleBehaviourModel ) ) ) ) ) )* ) ) ) ) )
            // InternalForml.g:80:1: ( () ( ( ( ( ({...}? => ( ({...}? => ( (lv_worldmodel_2_0= ruleWorldModel ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_behaviourmodel_3_0= ruleBehaviourModel ) ) ) ) ) )* ) ) ) )
            {
            // InternalForml.g:80:1: ( () ( ( ( ( ({...}? => ( ({...}? => ( (lv_worldmodel_2_0= ruleWorldModel ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_behaviourmodel_3_0= ruleBehaviourModel ) ) ) ) ) )* ) ) ) )
            // InternalForml.g:80:2: () ( ( ( ( ({...}? => ( ({...}? => ( (lv_worldmodel_2_0= ruleWorldModel ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_behaviourmodel_3_0= ruleBehaviourModel ) ) ) ) ) )* ) ) )
            {
            // InternalForml.g:80:2: ()
            // InternalForml.g:81:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getSystemAccess().getSystemAction_0(),
                        current);
                

            }

            // InternalForml.g:86:2: ( ( ( ( ({...}? => ( ({...}? => ( (lv_worldmodel_2_0= ruleWorldModel ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_behaviourmodel_3_0= ruleBehaviourModel ) ) ) ) ) )* ) ) )
            // InternalForml.g:88:1: ( ( ( ({...}? => ( ({...}? => ( (lv_worldmodel_2_0= ruleWorldModel ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_behaviourmodel_3_0= ruleBehaviourModel ) ) ) ) ) )* ) )
            {
            // InternalForml.g:88:1: ( ( ( ({...}? => ( ({...}? => ( (lv_worldmodel_2_0= ruleWorldModel ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_behaviourmodel_3_0= ruleBehaviourModel ) ) ) ) ) )* ) )
            // InternalForml.g:89:2: ( ( ({...}? => ( ({...}? => ( (lv_worldmodel_2_0= ruleWorldModel ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_behaviourmodel_3_0= ruleBehaviourModel ) ) ) ) ) )* )
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getSystemAccess().getUnorderedGroup_1());
            	
            // InternalForml.g:92:2: ( ( ({...}? => ( ({...}? => ( (lv_worldmodel_2_0= ruleWorldModel ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_behaviourmodel_3_0= ruleBehaviourModel ) ) ) ) ) )* )
            // InternalForml.g:93:3: ( ({...}? => ( ({...}? => ( (lv_worldmodel_2_0= ruleWorldModel ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_behaviourmodel_3_0= ruleBehaviourModel ) ) ) ) ) )*
            {
            // InternalForml.g:93:3: ( ({...}? => ( ({...}? => ( (lv_worldmodel_2_0= ruleWorldModel ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_behaviourmodel_3_0= ruleBehaviourModel ) ) ) ) ) )*
            loop1:
            do {
                int alt1=3;
                int LA1_0 = input.LA(1);

                if ( LA1_0 == 11 && getUnorderedGroupHelper().canSelect(grammarAccess.getSystemAccess().getUnorderedGroup_1(), 0) ) {
                    alt1=1;
                }
                else if ( LA1_0 == 54 && getUnorderedGroupHelper().canSelect(grammarAccess.getSystemAccess().getUnorderedGroup_1(), 1) ) {
                    alt1=2;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalForml.g:95:4: ({...}? => ( ({...}? => ( (lv_worldmodel_2_0= ruleWorldModel ) ) ) ) )
            	    {
            	    // InternalForml.g:95:4: ({...}? => ( ({...}? => ( (lv_worldmodel_2_0= ruleWorldModel ) ) ) ) )
            	    // InternalForml.g:96:5: {...}? => ( ({...}? => ( (lv_worldmodel_2_0= ruleWorldModel ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getSystemAccess().getUnorderedGroup_1(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleSystem", "getUnorderedGroupHelper().canSelect(grammarAccess.getSystemAccess().getUnorderedGroup_1(), 0)");
            	    }
            	    // InternalForml.g:96:103: ( ({...}? => ( (lv_worldmodel_2_0= ruleWorldModel ) ) ) )
            	    // InternalForml.g:97:6: ({...}? => ( (lv_worldmodel_2_0= ruleWorldModel ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getSystemAccess().getUnorderedGroup_1(), 0);
            	    	 				
            	    // InternalForml.g:100:6: ({...}? => ( (lv_worldmodel_2_0= ruleWorldModel ) ) )
            	    // InternalForml.g:100:7: {...}? => ( (lv_worldmodel_2_0= ruleWorldModel ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleSystem", "true");
            	    }
            	    // InternalForml.g:100:16: ( (lv_worldmodel_2_0= ruleWorldModel ) )
            	    // InternalForml.g:101:1: (lv_worldmodel_2_0= ruleWorldModel )
            	    {
            	    // InternalForml.g:101:1: (lv_worldmodel_2_0= ruleWorldModel )
            	    // InternalForml.g:102:3: lv_worldmodel_2_0= ruleWorldModel
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSystemAccess().getWorldmodelWorldModelParserRuleCall_1_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_3);
            	    lv_worldmodel_2_0=ruleWorldModel();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSystemRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"worldmodel",
            	            		lv_worldmodel_2_0, 
            	            		"uw.cs.watform.forml.Forml.WorldModel");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getSystemAccess().getUnorderedGroup_1());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalForml.g:125:4: ({...}? => ( ({...}? => ( (lv_behaviourmodel_3_0= ruleBehaviourModel ) ) ) ) )
            	    {
            	    // InternalForml.g:125:4: ({...}? => ( ({...}? => ( (lv_behaviourmodel_3_0= ruleBehaviourModel ) ) ) ) )
            	    // InternalForml.g:126:5: {...}? => ( ({...}? => ( (lv_behaviourmodel_3_0= ruleBehaviourModel ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getSystemAccess().getUnorderedGroup_1(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleSystem", "getUnorderedGroupHelper().canSelect(grammarAccess.getSystemAccess().getUnorderedGroup_1(), 1)");
            	    }
            	    // InternalForml.g:126:103: ( ({...}? => ( (lv_behaviourmodel_3_0= ruleBehaviourModel ) ) ) )
            	    // InternalForml.g:127:6: ({...}? => ( (lv_behaviourmodel_3_0= ruleBehaviourModel ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getSystemAccess().getUnorderedGroup_1(), 1);
            	    	 				
            	    // InternalForml.g:130:6: ({...}? => ( (lv_behaviourmodel_3_0= ruleBehaviourModel ) ) )
            	    // InternalForml.g:130:7: {...}? => ( (lv_behaviourmodel_3_0= ruleBehaviourModel ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleSystem", "true");
            	    }
            	    // InternalForml.g:130:16: ( (lv_behaviourmodel_3_0= ruleBehaviourModel ) )
            	    // InternalForml.g:131:1: (lv_behaviourmodel_3_0= ruleBehaviourModel )
            	    {
            	    // InternalForml.g:131:1: (lv_behaviourmodel_3_0= ruleBehaviourModel )
            	    // InternalForml.g:132:3: lv_behaviourmodel_3_0= ruleBehaviourModel
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSystemAccess().getBehaviourmodelBehaviourModelParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_3);
            	    lv_behaviourmodel_3_0=ruleBehaviourModel();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSystemRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"behaviourmodel",
            	            		lv_behaviourmodel_3_0, 
            	            		"uw.cs.watform.forml.Forml.BehaviourModel");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getSystemAccess().getUnorderedGroup_1());
            	    	 				

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }


            }

             
            	  getUnorderedGroupHelper().leave(grammarAccess.getSystemAccess().getUnorderedGroup_1());
            	

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSystem"


    // $ANTLR start "entryRuleWorldModel"
    // InternalForml.g:170:1: entryRuleWorldModel returns [EObject current=null] : iv_ruleWorldModel= ruleWorldModel EOF ;
    public final EObject entryRuleWorldModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWorldModel = null;


        try {
            // InternalForml.g:171:2: (iv_ruleWorldModel= ruleWorldModel EOF )
            // InternalForml.g:172:2: iv_ruleWorldModel= ruleWorldModel EOF
            {
             newCompositeNode(grammarAccess.getWorldModelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleWorldModel=ruleWorldModel();

            state._fsp--;

             current =iv_ruleWorldModel; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleWorldModel"


    // $ANTLR start "ruleWorldModel"
    // InternalForml.g:179:1: ruleWorldModel returns [EObject current=null] : ( () (otherlv_1= 'World' otherlv_2= '{' ( ( (lv_concepts_3_0= ruleConcept ) )* ( (lv_constraints_4_0= ruleConstraint ) )? ) otherlv_5= '}' ) ) ;
    public final EObject ruleWorldModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        EObject lv_concepts_3_0 = null;

        EObject lv_constraints_4_0 = null;


         enterRule(); 
            
        try {
            // InternalForml.g:182:28: ( ( () (otherlv_1= 'World' otherlv_2= '{' ( ( (lv_concepts_3_0= ruleConcept ) )* ( (lv_constraints_4_0= ruleConstraint ) )? ) otherlv_5= '}' ) ) )
            // InternalForml.g:183:1: ( () (otherlv_1= 'World' otherlv_2= '{' ( ( (lv_concepts_3_0= ruleConcept ) )* ( (lv_constraints_4_0= ruleConstraint ) )? ) otherlv_5= '}' ) )
            {
            // InternalForml.g:183:1: ( () (otherlv_1= 'World' otherlv_2= '{' ( ( (lv_concepts_3_0= ruleConcept ) )* ( (lv_constraints_4_0= ruleConstraint ) )? ) otherlv_5= '}' ) )
            // InternalForml.g:183:2: () (otherlv_1= 'World' otherlv_2= '{' ( ( (lv_concepts_3_0= ruleConcept ) )* ( (lv_constraints_4_0= ruleConstraint ) )? ) otherlv_5= '}' )
            {
            // InternalForml.g:183:2: ()
            // InternalForml.g:184:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getWorldModelAccess().getWorldModelAction_0(),
                        current);
                

            }

            // InternalForml.g:189:2: (otherlv_1= 'World' otherlv_2= '{' ( ( (lv_concepts_3_0= ruleConcept ) )* ( (lv_constraints_4_0= ruleConstraint ) )? ) otherlv_5= '}' )
            // InternalForml.g:189:4: otherlv_1= 'World' otherlv_2= '{' ( ( (lv_concepts_3_0= ruleConcept ) )* ( (lv_constraints_4_0= ruleConstraint ) )? ) otherlv_5= '}'
            {
            otherlv_1=(Token)match(input,11,FOLLOW_4); 

                	newLeafNode(otherlv_1, grammarAccess.getWorldModelAccess().getWorldKeyword_1_0());
                
            otherlv_2=(Token)match(input,12,FOLLOW_5); 

                	newLeafNode(otherlv_2, grammarAccess.getWorldModelAccess().getLeftCurlyBracketKeyword_1_1());
                
            // InternalForml.g:197:1: ( ( (lv_concepts_3_0= ruleConcept ) )* ( (lv_constraints_4_0= ruleConstraint ) )? )
            // InternalForml.g:197:2: ( (lv_concepts_3_0= ruleConcept ) )* ( (lv_constraints_4_0= ruleConstraint ) )?
            {
            // InternalForml.g:197:2: ( (lv_concepts_3_0= ruleConcept ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>=15 && LA2_0<=17)||LA2_0==19||LA2_0==31||LA2_0==35||(LA2_0>=38 && LA2_0<=39)||LA2_0==42||(LA2_0>=47 && LA2_0<=48)||LA2_0==53) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalForml.g:198:1: (lv_concepts_3_0= ruleConcept )
            	    {
            	    // InternalForml.g:198:1: (lv_concepts_3_0= ruleConcept )
            	    // InternalForml.g:199:3: lv_concepts_3_0= ruleConcept
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getWorldModelAccess().getConceptsConceptParserRuleCall_1_2_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_5);
            	    lv_concepts_3_0=ruleConcept();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getWorldModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"concepts",
            	            		lv_concepts_3_0, 
            	            		"uw.cs.watform.forml.Forml.Concept");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // InternalForml.g:215:3: ( (lv_constraints_4_0= ruleConstraint ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==14) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalForml.g:216:1: (lv_constraints_4_0= ruleConstraint )
                    {
                    // InternalForml.g:216:1: (lv_constraints_4_0= ruleConstraint )
                    // InternalForml.g:217:3: lv_constraints_4_0= ruleConstraint
                    {
                     
                    	        newCompositeNode(grammarAccess.getWorldModelAccess().getConstraintsConstraintParserRuleCall_1_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_6);
                    lv_constraints_4_0=ruleConstraint();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getWorldModelRule());
                    	        }
                           		set(
                           			current, 
                           			"constraints",
                            		lv_constraints_4_0, 
                            		"uw.cs.watform.forml.Forml.Constraint");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }


            }

            otherlv_5=(Token)match(input,13,FOLLOW_2); 

                	newLeafNode(otherlv_5, grammarAccess.getWorldModelAccess().getRightCurlyBracketKeyword_1_3());
                

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleWorldModel"


    // $ANTLR start "entryRuleConstraint"
    // InternalForml.g:245:1: entryRuleConstraint returns [EObject current=null] : iv_ruleConstraint= ruleConstraint EOF ;
    public final EObject entryRuleConstraint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstraint = null;


        try {
            // InternalForml.g:246:2: (iv_ruleConstraint= ruleConstraint EOF )
            // InternalForml.g:247:2: iv_ruleConstraint= ruleConstraint EOF
            {
             newCompositeNode(grammarAccess.getConstraintRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConstraint=ruleConstraint();

            state._fsp--;

             current =iv_ruleConstraint; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConstraint"


    // $ANTLR start "ruleConstraint"
    // InternalForml.g:254:1: ruleConstraint returns [EObject current=null] : ( () otherlv_1= 'Constraints' otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => ( (lv_predicates_4_0= rulePredicate ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_macro_5_0= ruleMacro ) ) )+ ) ) )* ) ) ) otherlv_6= '}' ) ;
    public final EObject ruleConstraint() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_6=null;
        EObject lv_predicates_4_0 = null;

        EObject lv_macro_5_0 = null;


         enterRule(); 
            
        try {
            // InternalForml.g:257:28: ( ( () otherlv_1= 'Constraints' otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => ( (lv_predicates_4_0= rulePredicate ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_macro_5_0= ruleMacro ) ) )+ ) ) )* ) ) ) otherlv_6= '}' ) )
            // InternalForml.g:258:1: ( () otherlv_1= 'Constraints' otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => ( (lv_predicates_4_0= rulePredicate ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_macro_5_0= ruleMacro ) ) )+ ) ) )* ) ) ) otherlv_6= '}' )
            {
            // InternalForml.g:258:1: ( () otherlv_1= 'Constraints' otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => ( (lv_predicates_4_0= rulePredicate ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_macro_5_0= ruleMacro ) ) )+ ) ) )* ) ) ) otherlv_6= '}' )
            // InternalForml.g:258:2: () otherlv_1= 'Constraints' otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => ( (lv_predicates_4_0= rulePredicate ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_macro_5_0= ruleMacro ) ) )+ ) ) )* ) ) ) otherlv_6= '}'
            {
            // InternalForml.g:258:2: ()
            // InternalForml.g:259:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getConstraintAccess().getConstraintAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,14,FOLLOW_4); 

                	newLeafNode(otherlv_1, grammarAccess.getConstraintAccess().getConstraintsKeyword_1());
                
            otherlv_2=(Token)match(input,12,FOLLOW_7); 

                	newLeafNode(otherlv_2, grammarAccess.getConstraintAccess().getLeftCurlyBracketKeyword_2());
                
            // InternalForml.g:272:1: ( ( ( ( ({...}? => ( ({...}? => ( (lv_predicates_4_0= rulePredicate ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_macro_5_0= ruleMacro ) ) )+ ) ) )* ) ) )
            // InternalForml.g:274:1: ( ( ( ({...}? => ( ({...}? => ( (lv_predicates_4_0= rulePredicate ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_macro_5_0= ruleMacro ) ) )+ ) ) )* ) )
            {
            // InternalForml.g:274:1: ( ( ( ({...}? => ( ({...}? => ( (lv_predicates_4_0= rulePredicate ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_macro_5_0= ruleMacro ) ) )+ ) ) )* ) )
            // InternalForml.g:275:2: ( ( ({...}? => ( ({...}? => ( (lv_predicates_4_0= rulePredicate ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_macro_5_0= ruleMacro ) ) )+ ) ) )* )
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getConstraintAccess().getUnorderedGroup_3());
            	
            // InternalForml.g:278:2: ( ( ({...}? => ( ({...}? => ( (lv_predicates_4_0= rulePredicate ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_macro_5_0= ruleMacro ) ) )+ ) ) )* )
            // InternalForml.g:279:3: ( ({...}? => ( ({...}? => ( (lv_predicates_4_0= rulePredicate ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_macro_5_0= ruleMacro ) ) )+ ) ) )*
            {
            // InternalForml.g:279:3: ( ({...}? => ( ({...}? => ( (lv_predicates_4_0= rulePredicate ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_macro_5_0= ruleMacro ) ) )+ ) ) )*
            loop6:
            do {
                int alt6=3;
                int LA6_0 = input.LA(1);

                if ( ( LA6_0 >= RULE_ID && LA6_0 <= RULE_INT || LA6_0 == 67 || LA6_0 >= 75 && LA6_0 <= 79 || LA6_0 == 81 || LA6_0 >= 96 && LA6_0 <= 97 ) && getUnorderedGroupHelper().canSelect(grammarAccess.getConstraintAccess().getUnorderedGroup_3(), 0) ) {
                    alt6=1;
                }
                else if ( LA6_0 == 74 && getUnorderedGroupHelper().canSelect(grammarAccess.getConstraintAccess().getUnorderedGroup_3(), 1) ) {
                    alt6=2;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalForml.g:281:4: ({...}? => ( ({...}? => ( (lv_predicates_4_0= rulePredicate ) ) )+ ) )
            	    {
            	    // InternalForml.g:281:4: ({...}? => ( ({...}? => ( (lv_predicates_4_0= rulePredicate ) ) )+ ) )
            	    // InternalForml.g:282:5: {...}? => ( ({...}? => ( (lv_predicates_4_0= rulePredicate ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getConstraintAccess().getUnorderedGroup_3(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleConstraint", "getUnorderedGroupHelper().canSelect(grammarAccess.getConstraintAccess().getUnorderedGroup_3(), 0)");
            	    }
            	    // InternalForml.g:282:107: ( ({...}? => ( (lv_predicates_4_0= rulePredicate ) ) )+ )
            	    // InternalForml.g:283:6: ({...}? => ( (lv_predicates_4_0= rulePredicate ) ) )+
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getConstraintAccess().getUnorderedGroup_3(), 0);
            	    	 				
            	    // InternalForml.g:286:6: ({...}? => ( (lv_predicates_4_0= rulePredicate ) ) )+
            	    int cnt4=0;
            	    loop4:
            	    do {
            	        int alt4=2;
            	        alt4 = dfa4.predict(input);
            	        switch (alt4) {
            	    	case 1 :
            	    	    // InternalForml.g:286:7: {...}? => ( (lv_predicates_4_0= rulePredicate ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleConstraint", "true");
            	    	    }
            	    	    // InternalForml.g:286:16: ( (lv_predicates_4_0= rulePredicate ) )
            	    	    // InternalForml.g:287:1: (lv_predicates_4_0= rulePredicate )
            	    	    {
            	    	    // InternalForml.g:287:1: (lv_predicates_4_0= rulePredicate )
            	    	    // InternalForml.g:288:3: lv_predicates_4_0= rulePredicate
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getConstraintAccess().getPredicatesPredicateParserRuleCall_3_0_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_7);
            	    	    lv_predicates_4_0=rulePredicate();

            	    	    state._fsp--;


            	    	    	        if (current==null) {
            	    	    	            current = createModelElementForParent(grammarAccess.getConstraintRule());
            	    	    	        }
            	    	           		add(
            	    	           			current, 
            	    	           			"predicates",
            	    	            		lv_predicates_4_0, 
            	    	            		"uw.cs.watform.forml.Forml.Predicate");
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt4 >= 1 ) break loop4;
            	                EarlyExitException eee =
            	                    new EarlyExitException(4, input);
            	                throw eee;
            	        }
            	        cnt4++;
            	    } while (true);

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getConstraintAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalForml.g:311:4: ({...}? => ( ({...}? => ( (lv_macro_5_0= ruleMacro ) ) )+ ) )
            	    {
            	    // InternalForml.g:311:4: ({...}? => ( ({...}? => ( (lv_macro_5_0= ruleMacro ) ) )+ ) )
            	    // InternalForml.g:312:5: {...}? => ( ({...}? => ( (lv_macro_5_0= ruleMacro ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getConstraintAccess().getUnorderedGroup_3(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleConstraint", "getUnorderedGroupHelper().canSelect(grammarAccess.getConstraintAccess().getUnorderedGroup_3(), 1)");
            	    }
            	    // InternalForml.g:312:107: ( ({...}? => ( (lv_macro_5_0= ruleMacro ) ) )+ )
            	    // InternalForml.g:313:6: ({...}? => ( (lv_macro_5_0= ruleMacro ) ) )+
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getConstraintAccess().getUnorderedGroup_3(), 1);
            	    	 				
            	    // InternalForml.g:316:6: ({...}? => ( (lv_macro_5_0= ruleMacro ) ) )+
            	    int cnt5=0;
            	    loop5:
            	    do {
            	        int alt5=2;
            	        int LA5_0 = input.LA(1);

            	        if ( (LA5_0==74) ) {
            	            int LA5_2 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt5=1;
            	            }


            	        }


            	        switch (alt5) {
            	    	case 1 :
            	    	    // InternalForml.g:316:7: {...}? => ( (lv_macro_5_0= ruleMacro ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleConstraint", "true");
            	    	    }
            	    	    // InternalForml.g:316:16: ( (lv_macro_5_0= ruleMacro ) )
            	    	    // InternalForml.g:317:1: (lv_macro_5_0= ruleMacro )
            	    	    {
            	    	    // InternalForml.g:317:1: (lv_macro_5_0= ruleMacro )
            	    	    // InternalForml.g:318:3: lv_macro_5_0= ruleMacro
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getConstraintAccess().getMacroMacroParserRuleCall_3_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_7);
            	    	    lv_macro_5_0=ruleMacro();

            	    	    state._fsp--;


            	    	    	        if (current==null) {
            	    	    	            current = createModelElementForParent(grammarAccess.getConstraintRule());
            	    	    	        }
            	    	           		add(
            	    	           			current, 
            	    	           			"macro",
            	    	            		lv_macro_5_0, 
            	    	            		"uw.cs.watform.forml.Forml.Macro");
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt5 >= 1 ) break loop5;
            	                EarlyExitException eee =
            	                    new EarlyExitException(5, input);
            	                throw eee;
            	        }
            	        cnt5++;
            	    } while (true);

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getConstraintAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            }


            }

             
            	  getUnorderedGroupHelper().leave(grammarAccess.getConstraintAccess().getUnorderedGroup_3());
            	

            }

            otherlv_6=(Token)match(input,13,FOLLOW_2); 

                	newLeafNode(otherlv_6, grammarAccess.getConstraintAccess().getRightCurlyBracketKeyword_4());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConstraint"


    // $ANTLR start "entryRuleConcept"
    // InternalForml.g:362:1: entryRuleConcept returns [EObject current=null] : iv_ruleConcept= ruleConcept EOF ;
    public final EObject entryRuleConcept() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConcept = null;


        try {
            // InternalForml.g:363:2: (iv_ruleConcept= ruleConcept EOF )
            // InternalForml.g:364:2: iv_ruleConcept= ruleConcept EOF
            {
             newCompositeNode(grammarAccess.getConceptRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConcept=ruleConcept();

            state._fsp--;

             current =iv_ruleConcept; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConcept"


    // $ANTLR start "ruleConcept"
    // InternalForml.g:371:1: ruleConcept returns [EObject current=null] : (this_Entity_0= ruleEntity | this_Relationship_1= ruleRelationship | this_SPL_2= ruleSPL | this_Message_3= ruleMessage | this_Feature_4= ruleFeature | this_Enumeration_5= ruleEnumeration | this_UndefinedType_6= ruleUndefinedType ) ;
    public final EObject ruleConcept() throws RecognitionException {
        EObject current = null;

        EObject this_Entity_0 = null;

        EObject this_Relationship_1 = null;

        EObject this_SPL_2 = null;

        EObject this_Message_3 = null;

        EObject this_Feature_4 = null;

        EObject this_Enumeration_5 = null;

        EObject this_UndefinedType_6 = null;


         enterRule(); 
            
        try {
            // InternalForml.g:374:28: ( (this_Entity_0= ruleEntity | this_Relationship_1= ruleRelationship | this_SPL_2= ruleSPL | this_Message_3= ruleMessage | this_Feature_4= ruleFeature | this_Enumeration_5= ruleEnumeration | this_UndefinedType_6= ruleUndefinedType ) )
            // InternalForml.g:375:1: (this_Entity_0= ruleEntity | this_Relationship_1= ruleRelationship | this_SPL_2= ruleSPL | this_Message_3= ruleMessage | this_Feature_4= ruleFeature | this_Enumeration_5= ruleEnumeration | this_UndefinedType_6= ruleUndefinedType )
            {
            // InternalForml.g:375:1: (this_Entity_0= ruleEntity | this_Relationship_1= ruleRelationship | this_SPL_2= ruleSPL | this_Message_3= ruleMessage | this_Feature_4= ruleFeature | this_Enumeration_5= ruleEnumeration | this_UndefinedType_6= ruleUndefinedType )
            int alt7=7;
            switch ( input.LA(1) ) {
            case 15:
            case 17:
                {
                alt7=1;
                }
                break;
            case 16:
                {
                int LA7_2 = input.LA(2);

                if ( (LA7_2==17) ) {
                    alt7=1;
                }
                else if ( (LA7_2==19||LA7_2==35||LA7_2==38) ) {
                    alt7=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 2, input);

                    throw nvae;
                }
                }
                break;
            case 19:
            case 35:
            case 38:
                {
                alt7=2;
                }
                break;
            case 48:
                {
                alt7=3;
                }
                break;
            case 39:
            case 42:
                {
                alt7=4;
                }
                break;
            case 47:
                {
                alt7=5;
                }
                break;
            case 53:
                {
                alt7=6;
                }
                break;
            case 31:
                {
                alt7=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // InternalForml.g:376:5: this_Entity_0= ruleEntity
                    {
                     
                            newCompositeNode(grammarAccess.getConceptAccess().getEntityParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_2);
                    this_Entity_0=ruleEntity();

                    state._fsp--;

                     
                            current = this_Entity_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalForml.g:386:5: this_Relationship_1= ruleRelationship
                    {
                     
                            newCompositeNode(grammarAccess.getConceptAccess().getRelationshipParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_2);
                    this_Relationship_1=ruleRelationship();

                    state._fsp--;

                     
                            current = this_Relationship_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // InternalForml.g:396:5: this_SPL_2= ruleSPL
                    {
                     
                            newCompositeNode(grammarAccess.getConceptAccess().getSPLParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_2);
                    this_SPL_2=ruleSPL();

                    state._fsp--;

                     
                            current = this_SPL_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // InternalForml.g:406:5: this_Message_3= ruleMessage
                    {
                     
                            newCompositeNode(grammarAccess.getConceptAccess().getMessageParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_2);
                    this_Message_3=ruleMessage();

                    state._fsp--;

                     
                            current = this_Message_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // InternalForml.g:416:5: this_Feature_4= ruleFeature
                    {
                     
                            newCompositeNode(grammarAccess.getConceptAccess().getFeatureParserRuleCall_4()); 
                        
                    pushFollow(FOLLOW_2);
                    this_Feature_4=ruleFeature();

                    state._fsp--;

                     
                            current = this_Feature_4; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 6 :
                    // InternalForml.g:426:5: this_Enumeration_5= ruleEnumeration
                    {
                     
                            newCompositeNode(grammarAccess.getConceptAccess().getEnumerationParserRuleCall_5()); 
                        
                    pushFollow(FOLLOW_2);
                    this_Enumeration_5=ruleEnumeration();

                    state._fsp--;

                     
                            current = this_Enumeration_5; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 7 :
                    // InternalForml.g:436:5: this_UndefinedType_6= ruleUndefinedType
                    {
                     
                            newCompositeNode(grammarAccess.getConceptAccess().getUndefinedTypeParserRuleCall_6()); 
                        
                    pushFollow(FOLLOW_2);
                    this_UndefinedType_6=ruleUndefinedType();

                    state._fsp--;

                     
                            current = this_UndefinedType_6; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConcept"


    // $ANTLR start "entryRuleRelationship"
    // InternalForml.g:452:1: entryRuleRelationship returns [EObject current=null] : iv_ruleRelationship= ruleRelationship EOF ;
    public final EObject entryRuleRelationship() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationship = null;


        try {
            // InternalForml.g:453:2: (iv_ruleRelationship= ruleRelationship EOF )
            // InternalForml.g:454:2: iv_ruleRelationship= ruleRelationship EOF
            {
             newCompositeNode(grammarAccess.getRelationshipRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRelationship=ruleRelationship();

            state._fsp--;

             current =iv_ruleRelationship; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRelationship"


    // $ANTLR start "ruleRelationship"
    // InternalForml.g:461:1: ruleRelationship returns [EObject current=null] : (this_Association_0= ruleAssociation | this_Aggregation_1= ruleAggregation | this_Composition_2= ruleComposition ) ;
    public final EObject ruleRelationship() throws RecognitionException {
        EObject current = null;

        EObject this_Association_0 = null;

        EObject this_Aggregation_1 = null;

        EObject this_Composition_2 = null;


         enterRule(); 
            
        try {
            // InternalForml.g:464:28: ( (this_Association_0= ruleAssociation | this_Aggregation_1= ruleAggregation | this_Composition_2= ruleComposition ) )
            // InternalForml.g:465:1: (this_Association_0= ruleAssociation | this_Aggregation_1= ruleAggregation | this_Composition_2= ruleComposition )
            {
            // InternalForml.g:465:1: (this_Association_0= ruleAssociation | this_Aggregation_1= ruleAggregation | this_Composition_2= ruleComposition )
            int alt8=3;
            switch ( input.LA(1) ) {
            case 16:
                {
                switch ( input.LA(2) ) {
                case 19:
                    {
                    alt8=1;
                    }
                    break;
                case 35:
                    {
                    alt8=2;
                    }
                    break;
                case 38:
                    {
                    alt8=3;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 1, input);

                    throw nvae;
                }

                }
                break;
            case 19:
                {
                alt8=1;
                }
                break;
            case 35:
                {
                alt8=2;
                }
                break;
            case 38:
                {
                alt8=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // InternalForml.g:466:5: this_Association_0= ruleAssociation
                    {
                     
                            newCompositeNode(grammarAccess.getRelationshipAccess().getAssociationParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_2);
                    this_Association_0=ruleAssociation();

                    state._fsp--;

                     
                            current = this_Association_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalForml.g:476:5: this_Aggregation_1= ruleAggregation
                    {
                     
                            newCompositeNode(grammarAccess.getRelationshipAccess().getAggregationParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_2);
                    this_Aggregation_1=ruleAggregation();

                    state._fsp--;

                     
                            current = this_Aggregation_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // InternalForml.g:486:5: this_Composition_2= ruleComposition
                    {
                     
                            newCompositeNode(grammarAccess.getRelationshipAccess().getCompositionParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_2);
                    this_Composition_2=ruleComposition();

                    state._fsp--;

                     
                            current = this_Composition_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRelationship"


    // $ANTLR start "entryRuleEntity"
    // InternalForml.g:504:1: entryRuleEntity returns [EObject current=null] : iv_ruleEntity= ruleEntity EOF ;
    public final EObject entryRuleEntity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntity = null;


        try {
            // InternalForml.g:505:2: (iv_ruleEntity= ruleEntity EOF )
            // InternalForml.g:506:2: iv_ruleEntity= ruleEntity EOF
            {
             newCompositeNode(grammarAccess.getEntityRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEntity=ruleEntity();

            state._fsp--;

             current =iv_ruleEntity; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEntity"


    // $ANTLR start "ruleEntity"
    // InternalForml.g:513:1: ruleEntity returns [EObject current=null] : ( () (otherlv_1= 'abstract' )? ( (lv_ctrl_2_0= 'ctrl' ) )? otherlv_3= 'entity' ( (lv_name_4_0= RULE_ID ) ) (otherlv_5= 'extends' ( (otherlv_6= RULE_ID ) ) )? (otherlv_7= '{' ( (lv_attributes_8_0= ruleAttribute ) )* ( (lv_functions_9_0= ruleFunction ) )* otherlv_10= '}' )? ) ;
    public final EObject ruleEntity() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_ctrl_2_0=null;
        Token otherlv_3=null;
        Token lv_name_4_0=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_10=null;
        EObject lv_attributes_8_0 = null;

        EObject lv_functions_9_0 = null;


         enterRule(); 
            
        try {
            // InternalForml.g:516:28: ( ( () (otherlv_1= 'abstract' )? ( (lv_ctrl_2_0= 'ctrl' ) )? otherlv_3= 'entity' ( (lv_name_4_0= RULE_ID ) ) (otherlv_5= 'extends' ( (otherlv_6= RULE_ID ) ) )? (otherlv_7= '{' ( (lv_attributes_8_0= ruleAttribute ) )* ( (lv_functions_9_0= ruleFunction ) )* otherlv_10= '}' )? ) )
            // InternalForml.g:517:1: ( () (otherlv_1= 'abstract' )? ( (lv_ctrl_2_0= 'ctrl' ) )? otherlv_3= 'entity' ( (lv_name_4_0= RULE_ID ) ) (otherlv_5= 'extends' ( (otherlv_6= RULE_ID ) ) )? (otherlv_7= '{' ( (lv_attributes_8_0= ruleAttribute ) )* ( (lv_functions_9_0= ruleFunction ) )* otherlv_10= '}' )? )
            {
            // InternalForml.g:517:1: ( () (otherlv_1= 'abstract' )? ( (lv_ctrl_2_0= 'ctrl' ) )? otherlv_3= 'entity' ( (lv_name_4_0= RULE_ID ) ) (otherlv_5= 'extends' ( (otherlv_6= RULE_ID ) ) )? (otherlv_7= '{' ( (lv_attributes_8_0= ruleAttribute ) )* ( (lv_functions_9_0= ruleFunction ) )* otherlv_10= '}' )? )
            // InternalForml.g:517:2: () (otherlv_1= 'abstract' )? ( (lv_ctrl_2_0= 'ctrl' ) )? otherlv_3= 'entity' ( (lv_name_4_0= RULE_ID ) ) (otherlv_5= 'extends' ( (otherlv_6= RULE_ID ) ) )? (otherlv_7= '{' ( (lv_attributes_8_0= ruleAttribute ) )* ( (lv_functions_9_0= ruleFunction ) )* otherlv_10= '}' )?
            {
            // InternalForml.g:517:2: ()
            // InternalForml.g:518:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getEntityAccess().getEntityAction_0(),
                        current);
                

            }

            // InternalForml.g:523:2: (otherlv_1= 'abstract' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==15) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalForml.g:523:4: otherlv_1= 'abstract'
                    {
                    otherlv_1=(Token)match(input,15,FOLLOW_8); 

                        	newLeafNode(otherlv_1, grammarAccess.getEntityAccess().getAbstractKeyword_1());
                        

                    }
                    break;

            }

            // InternalForml.g:527:3: ( (lv_ctrl_2_0= 'ctrl' ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==16) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalForml.g:528:1: (lv_ctrl_2_0= 'ctrl' )
                    {
                    // InternalForml.g:528:1: (lv_ctrl_2_0= 'ctrl' )
                    // InternalForml.g:529:3: lv_ctrl_2_0= 'ctrl'
                    {
                    lv_ctrl_2_0=(Token)match(input,16,FOLLOW_9); 

                            newLeafNode(lv_ctrl_2_0, grammarAccess.getEntityAccess().getCtrlCtrlKeyword_2_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getEntityRule());
                    	        }
                           		setWithLastConsumed(current, "ctrl", true, "ctrl");
                    	    

                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,17,FOLLOW_10); 

                	newLeafNode(otherlv_3, grammarAccess.getEntityAccess().getEntityKeyword_3());
                
            // InternalForml.g:546:1: ( (lv_name_4_0= RULE_ID ) )
            // InternalForml.g:547:1: (lv_name_4_0= RULE_ID )
            {
            // InternalForml.g:547:1: (lv_name_4_0= RULE_ID )
            // InternalForml.g:548:3: lv_name_4_0= RULE_ID
            {
            lv_name_4_0=(Token)match(input,RULE_ID,FOLLOW_11); 

            			newLeafNode(lv_name_4_0, grammarAccess.getEntityAccess().getNameIDTerminalRuleCall_4_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getEntityRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_4_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            // InternalForml.g:564:2: (otherlv_5= 'extends' ( (otherlv_6= RULE_ID ) ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==18) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalForml.g:564:4: otherlv_5= 'extends' ( (otherlv_6= RULE_ID ) )
                    {
                    otherlv_5=(Token)match(input,18,FOLLOW_10); 

                        	newLeafNode(otherlv_5, grammarAccess.getEntityAccess().getExtendsKeyword_5_0());
                        
                    // InternalForml.g:568:1: ( (otherlv_6= RULE_ID ) )
                    // InternalForml.g:569:1: (otherlv_6= RULE_ID )
                    {
                    // InternalForml.g:569:1: (otherlv_6= RULE_ID )
                    // InternalForml.g:570:3: otherlv_6= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getEntityRule());
                    	        }
                            
                    otherlv_6=(Token)match(input,RULE_ID,FOLLOW_12); 

                    		newLeafNode(otherlv_6, grammarAccess.getEntityAccess().getSuperTypeEntityCrossReference_5_1_0()); 
                    	

                    }


                    }


                    }
                    break;

            }

            // InternalForml.g:581:4: (otherlv_7= '{' ( (lv_attributes_8_0= ruleAttribute ) )* ( (lv_functions_9_0= ruleFunction ) )* otherlv_10= '}' )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==12) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalForml.g:581:6: otherlv_7= '{' ( (lv_attributes_8_0= ruleAttribute ) )* ( (lv_functions_9_0= ruleFunction ) )* otherlv_10= '}'
                    {
                    otherlv_7=(Token)match(input,12,FOLLOW_13); 

                        	newLeafNode(otherlv_7, grammarAccess.getEntityAccess().getLeftCurlyBracketKeyword_6_0());
                        
                    // InternalForml.g:585:1: ( (lv_attributes_8_0= ruleAttribute ) )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==16||LA12_0==20) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // InternalForml.g:586:1: (lv_attributes_8_0= ruleAttribute )
                    	    {
                    	    // InternalForml.g:586:1: (lv_attributes_8_0= ruleAttribute )
                    	    // InternalForml.g:587:3: lv_attributes_8_0= ruleAttribute
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getEntityAccess().getAttributesAttributeParserRuleCall_6_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_13);
                    	    lv_attributes_8_0=ruleAttribute();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getEntityRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"attributes",
                    	            		lv_attributes_8_0, 
                    	            		"uw.cs.watform.forml.Forml.Attribute");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);

                    // InternalForml.g:603:3: ( (lv_functions_9_0= ruleFunction ) )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==26) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // InternalForml.g:604:1: (lv_functions_9_0= ruleFunction )
                    	    {
                    	    // InternalForml.g:604:1: (lv_functions_9_0= ruleFunction )
                    	    // InternalForml.g:605:3: lv_functions_9_0= ruleFunction
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getEntityAccess().getFunctionsFunctionParserRuleCall_6_2_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_14);
                    	    lv_functions_9_0=ruleFunction();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getEntityRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"functions",
                    	            		lv_functions_9_0, 
                    	            		"uw.cs.watform.forml.Forml.Function");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);

                    otherlv_10=(Token)match(input,13,FOLLOW_2); 

                        	newLeafNode(otherlv_10, grammarAccess.getEntityAccess().getRightCurlyBracketKeyword_6_3());
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEntity"


    // $ANTLR start "entryRuleAssociation"
    // InternalForml.g:633:1: entryRuleAssociation returns [EObject current=null] : iv_ruleAssociation= ruleAssociation EOF ;
    public final EObject entryRuleAssociation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssociation = null;


        try {
            // InternalForml.g:634:2: (iv_ruleAssociation= ruleAssociation EOF )
            // InternalForml.g:635:2: iv_ruleAssociation= ruleAssociation EOF
            {
             newCompositeNode(grammarAccess.getAssociationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAssociation=ruleAssociation();

            state._fsp--;

             current =iv_ruleAssociation; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAssociation"


    // $ANTLR start "ruleAssociation"
    // InternalForml.g:642:1: ruleAssociation returns [EObject current=null] : ( () ( (lv_ctrl_1_0= 'ctrl' ) )? otherlv_2= 'association' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '{' ( ( ( ( ({...}? => ( ({...}? => ( (lv_attributes_6_0= ruleAttribute ) ) )+ ) ) | ({...}? => ( ({...}? => ( ( ( ( ({...}? => ( ({...}? => ( (lv_srcRole_8_0= ruleRole ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_desRole_9_0= ruleRole ) ) ) ) ) )+ {...}?) ) ) ) ) ) )+ {...}?) ) ) otherlv_10= '}' ) ;
    public final EObject ruleAssociation() throws RecognitionException {
        EObject current = null;

        Token lv_ctrl_1_0=null;
        Token otherlv_2=null;
        Token lv_name_3_0=null;
        Token otherlv_4=null;
        Token otherlv_10=null;
        EObject lv_attributes_6_0 = null;

        EObject lv_srcRole_8_0 = null;

        EObject lv_desRole_9_0 = null;


         enterRule(); 
            
        try {
            // InternalForml.g:645:28: ( ( () ( (lv_ctrl_1_0= 'ctrl' ) )? otherlv_2= 'association' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '{' ( ( ( ( ({...}? => ( ({...}? => ( (lv_attributes_6_0= ruleAttribute ) ) )+ ) ) | ({...}? => ( ({...}? => ( ( ( ( ({...}? => ( ({...}? => ( (lv_srcRole_8_0= ruleRole ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_desRole_9_0= ruleRole ) ) ) ) ) )+ {...}?) ) ) ) ) ) )+ {...}?) ) ) otherlv_10= '}' ) )
            // InternalForml.g:646:1: ( () ( (lv_ctrl_1_0= 'ctrl' ) )? otherlv_2= 'association' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '{' ( ( ( ( ({...}? => ( ({...}? => ( (lv_attributes_6_0= ruleAttribute ) ) )+ ) ) | ({...}? => ( ({...}? => ( ( ( ( ({...}? => ( ({...}? => ( (lv_srcRole_8_0= ruleRole ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_desRole_9_0= ruleRole ) ) ) ) ) )+ {...}?) ) ) ) ) ) )+ {...}?) ) ) otherlv_10= '}' )
            {
            // InternalForml.g:646:1: ( () ( (lv_ctrl_1_0= 'ctrl' ) )? otherlv_2= 'association' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '{' ( ( ( ( ({...}? => ( ({...}? => ( (lv_attributes_6_0= ruleAttribute ) ) )+ ) ) | ({...}? => ( ({...}? => ( ( ( ( ({...}? => ( ({...}? => ( (lv_srcRole_8_0= ruleRole ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_desRole_9_0= ruleRole ) ) ) ) ) )+ {...}?) ) ) ) ) ) )+ {...}?) ) ) otherlv_10= '}' )
            // InternalForml.g:646:2: () ( (lv_ctrl_1_0= 'ctrl' ) )? otherlv_2= 'association' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '{' ( ( ( ( ({...}? => ( ({...}? => ( (lv_attributes_6_0= ruleAttribute ) ) )+ ) ) | ({...}? => ( ({...}? => ( ( ( ( ({...}? => ( ({...}? => ( (lv_srcRole_8_0= ruleRole ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_desRole_9_0= ruleRole ) ) ) ) ) )+ {...}?) ) ) ) ) ) )+ {...}?) ) ) otherlv_10= '}'
            {
            // InternalForml.g:646:2: ()
            // InternalForml.g:647:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getAssociationAccess().getAssociationAction_0(),
                        current);
                

            }

            // InternalForml.g:652:2: ( (lv_ctrl_1_0= 'ctrl' ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==16) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalForml.g:653:1: (lv_ctrl_1_0= 'ctrl' )
                    {
                    // InternalForml.g:653:1: (lv_ctrl_1_0= 'ctrl' )
                    // InternalForml.g:654:3: lv_ctrl_1_0= 'ctrl'
                    {
                    lv_ctrl_1_0=(Token)match(input,16,FOLLOW_15); 

                            newLeafNode(lv_ctrl_1_0, grammarAccess.getAssociationAccess().getCtrlCtrlKeyword_1_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getAssociationRule());
                    	        }
                           		setWithLastConsumed(current, "ctrl", true, "ctrl");
                    	    

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,19,FOLLOW_10); 

                	newLeafNode(otherlv_2, grammarAccess.getAssociationAccess().getAssociationKeyword_2());
                
            // InternalForml.g:671:1: ( (lv_name_3_0= RULE_ID ) )
            // InternalForml.g:672:1: (lv_name_3_0= RULE_ID )
            {
            // InternalForml.g:672:1: (lv_name_3_0= RULE_ID )
            // InternalForml.g:673:3: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            			newLeafNode(lv_name_3_0, grammarAccess.getAssociationAccess().getNameIDTerminalRuleCall_3_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getAssociationRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_3_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            otherlv_4=(Token)match(input,12,FOLLOW_16); 

                	newLeafNode(otherlv_4, grammarAccess.getAssociationAccess().getLeftCurlyBracketKeyword_4());
                
            // InternalForml.g:693:1: ( ( ( ( ({...}? => ( ({...}? => ( (lv_attributes_6_0= ruleAttribute ) ) )+ ) ) | ({...}? => ( ({...}? => ( ( ( ( ({...}? => ( ({...}? => ( (lv_srcRole_8_0= ruleRole ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_desRole_9_0= ruleRole ) ) ) ) ) )+ {...}?) ) ) ) ) ) )+ {...}?) ) )
            // InternalForml.g:695:1: ( ( ( ({...}? => ( ({...}? => ( (lv_attributes_6_0= ruleAttribute ) ) )+ ) ) | ({...}? => ( ({...}? => ( ( ( ( ({...}? => ( ({...}? => ( (lv_srcRole_8_0= ruleRole ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_desRole_9_0= ruleRole ) ) ) ) ) )+ {...}?) ) ) ) ) ) )+ {...}?) )
            {
            // InternalForml.g:695:1: ( ( ( ({...}? => ( ({...}? => ( (lv_attributes_6_0= ruleAttribute ) ) )+ ) ) | ({...}? => ( ({...}? => ( ( ( ( ({...}? => ( ({...}? => ( (lv_srcRole_8_0= ruleRole ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_desRole_9_0= ruleRole ) ) ) ) ) )+ {...}?) ) ) ) ) ) )+ {...}?) )
            // InternalForml.g:696:2: ( ( ({...}? => ( ({...}? => ( (lv_attributes_6_0= ruleAttribute ) ) )+ ) ) | ({...}? => ( ({...}? => ( ( ( ( ({...}? => ( ({...}? => ( (lv_srcRole_8_0= ruleRole ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_desRole_9_0= ruleRole ) ) ) ) ) )+ {...}?) ) ) ) ) ) )+ {...}?)
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getAssociationAccess().getUnorderedGroup_5());
            	
            // InternalForml.g:699:2: ( ( ({...}? => ( ({...}? => ( (lv_attributes_6_0= ruleAttribute ) ) )+ ) ) | ({...}? => ( ({...}? => ( ( ( ( ({...}? => ( ({...}? => ( (lv_srcRole_8_0= ruleRole ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_desRole_9_0= ruleRole ) ) ) ) ) )+ {...}?) ) ) ) ) ) )+ {...}?)
            // InternalForml.g:700:3: ( ({...}? => ( ({...}? => ( (lv_attributes_6_0= ruleAttribute ) ) )+ ) ) | ({...}? => ( ({...}? => ( ( ( ( ({...}? => ( ({...}? => ( (lv_srcRole_8_0= ruleRole ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_desRole_9_0= ruleRole ) ) ) ) ) )+ {...}?) ) ) ) ) ) )+ {...}?
            {
            // InternalForml.g:700:3: ( ({...}? => ( ({...}? => ( (lv_attributes_6_0= ruleAttribute ) ) )+ ) ) | ({...}? => ( ({...}? => ( ( ( ( ({...}? => ( ({...}? => ( (lv_srcRole_8_0= ruleRole ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_desRole_9_0= ruleRole ) ) ) ) ) )+ {...}?) ) ) ) ) ) )+
            int cnt18=0;
            loop18:
            do {
                int alt18=3;
                int LA18_0 = input.LA(1);

                if ( ( LA18_0 == 16 || LA18_0 == 20 ) && getUnorderedGroupHelper().canSelect(grammarAccess.getAssociationAccess().getUnorderedGroup_5(), 0) ) {
                    alt18=1;
                }
                else if ( LA18_0 == 34 && getUnorderedGroupHelper().canSelect(grammarAccess.getAssociationAccess().getUnorderedGroup_5(), 1) ) {
                    alt18=2;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalForml.g:702:4: ({...}? => ( ({...}? => ( (lv_attributes_6_0= ruleAttribute ) ) )+ ) )
            	    {
            	    // InternalForml.g:702:4: ({...}? => ( ({...}? => ( (lv_attributes_6_0= ruleAttribute ) ) )+ ) )
            	    // InternalForml.g:703:5: {...}? => ( ({...}? => ( (lv_attributes_6_0= ruleAttribute ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAssociationAccess().getUnorderedGroup_5(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleAssociation", "getUnorderedGroupHelper().canSelect(grammarAccess.getAssociationAccess().getUnorderedGroup_5(), 0)");
            	    }
            	    // InternalForml.g:703:108: ( ({...}? => ( (lv_attributes_6_0= ruleAttribute ) ) )+ )
            	    // InternalForml.g:704:6: ({...}? => ( (lv_attributes_6_0= ruleAttribute ) ) )+
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getAssociationAccess().getUnorderedGroup_5(), 0);
            	    	 				
            	    // InternalForml.g:707:6: ({...}? => ( (lv_attributes_6_0= ruleAttribute ) ) )+
            	    int cnt16=0;
            	    loop16:
            	    do {
            	        int alt16=2;
            	        int LA16_0 = input.LA(1);

            	        if ( (LA16_0==16) ) {
            	            int LA16_2 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt16=1;
            	            }


            	        }
            	        else if ( (LA16_0==20) ) {
            	            int LA16_3 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt16=1;
            	            }


            	        }


            	        switch (alt16) {
            	    	case 1 :
            	    	    // InternalForml.g:707:7: {...}? => ( (lv_attributes_6_0= ruleAttribute ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleAssociation", "true");
            	    	    }
            	    	    // InternalForml.g:707:16: ( (lv_attributes_6_0= ruleAttribute ) )
            	    	    // InternalForml.g:708:1: (lv_attributes_6_0= ruleAttribute )
            	    	    {
            	    	    // InternalForml.g:708:1: (lv_attributes_6_0= ruleAttribute )
            	    	    // InternalForml.g:709:3: lv_attributes_6_0= ruleAttribute
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getAssociationAccess().getAttributesAttributeParserRuleCall_5_0_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_17);
            	    	    lv_attributes_6_0=ruleAttribute();

            	    	    state._fsp--;


            	    	    	        if (current==null) {
            	    	    	            current = createModelElementForParent(grammarAccess.getAssociationRule());
            	    	    	        }
            	    	           		add(
            	    	           			current, 
            	    	           			"attributes",
            	    	            		lv_attributes_6_0, 
            	    	            		"uw.cs.watform.forml.Forml.Attribute");
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt16 >= 1 ) break loop16;
            	                EarlyExitException eee =
            	                    new EarlyExitException(16, input);
            	                throw eee;
            	        }
            	        cnt16++;
            	    } while (true);

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getAssociationAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalForml.g:732:4: ({...}? => ( ({...}? => ( ( ( ( ({...}? => ( ({...}? => ( (lv_srcRole_8_0= ruleRole ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_desRole_9_0= ruleRole ) ) ) ) ) )+ {...}?) ) ) ) ) )
            	    {
            	    // InternalForml.g:732:4: ({...}? => ( ({...}? => ( ( ( ( ({...}? => ( ({...}? => ( (lv_srcRole_8_0= ruleRole ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_desRole_9_0= ruleRole ) ) ) ) ) )+ {...}?) ) ) ) ) )
            	    // InternalForml.g:733:5: {...}? => ( ({...}? => ( ( ( ( ({...}? => ( ({...}? => ( (lv_srcRole_8_0= ruleRole ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_desRole_9_0= ruleRole ) ) ) ) ) )+ {...}?) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAssociationAccess().getUnorderedGroup_5(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleAssociation", "getUnorderedGroupHelper().canSelect(grammarAccess.getAssociationAccess().getUnorderedGroup_5(), 1)");
            	    }
            	    // InternalForml.g:733:108: ( ({...}? => ( ( ( ( ({...}? => ( ({...}? => ( (lv_srcRole_8_0= ruleRole ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_desRole_9_0= ruleRole ) ) ) ) ) )+ {...}?) ) ) ) )
            	    // InternalForml.g:734:6: ({...}? => ( ( ( ( ({...}? => ( ({...}? => ( (lv_srcRole_8_0= ruleRole ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_desRole_9_0= ruleRole ) ) ) ) ) )+ {...}?) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getAssociationAccess().getUnorderedGroup_5(), 1);
            	    	 				
            	    // InternalForml.g:737:6: ({...}? => ( ( ( ( ({...}? => ( ({...}? => ( (lv_srcRole_8_0= ruleRole ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_desRole_9_0= ruleRole ) ) ) ) ) )+ {...}?) ) ) )
            	    // InternalForml.g:737:7: {...}? => ( ( ( ( ({...}? => ( ({...}? => ( (lv_srcRole_8_0= ruleRole ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_desRole_9_0= ruleRole ) ) ) ) ) )+ {...}?) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleAssociation", "true");
            	    }
            	    // InternalForml.g:737:16: ( ( ( ( ({...}? => ( ({...}? => ( (lv_srcRole_8_0= ruleRole ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_desRole_9_0= ruleRole ) ) ) ) ) )+ {...}?) ) )
            	    // InternalForml.g:739:1: ( ( ( ({...}? => ( ({...}? => ( (lv_srcRole_8_0= ruleRole ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_desRole_9_0= ruleRole ) ) ) ) ) )+ {...}?) )
            	    {
            	    // InternalForml.g:739:1: ( ( ( ({...}? => ( ({...}? => ( (lv_srcRole_8_0= ruleRole ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_desRole_9_0= ruleRole ) ) ) ) ) )+ {...}?) )
            	    // InternalForml.g:740:2: ( ( ({...}? => ( ({...}? => ( (lv_srcRole_8_0= ruleRole ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_desRole_9_0= ruleRole ) ) ) ) ) )+ {...}?)
            	    {
            	     
            	    	  getUnorderedGroupHelper().enter(grammarAccess.getAssociationAccess().getUnorderedGroup_5_1());
            	    	
            	    // InternalForml.g:743:2: ( ( ({...}? => ( ({...}? => ( (lv_srcRole_8_0= ruleRole ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_desRole_9_0= ruleRole ) ) ) ) ) )+ {...}?)
            	    // InternalForml.g:744:3: ( ({...}? => ( ({...}? => ( (lv_srcRole_8_0= ruleRole ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_desRole_9_0= ruleRole ) ) ) ) ) )+ {...}?
            	    {
            	    // InternalForml.g:744:3: ( ({...}? => ( ({...}? => ( (lv_srcRole_8_0= ruleRole ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_desRole_9_0= ruleRole ) ) ) ) ) )+
            	    int cnt17=0;
            	    loop17:
            	    do {
            	        int alt17=3;
            	        int LA17_0 = input.LA(1);

            	        if ( (LA17_0==34) ) {
            	            int LA17_2 = input.LA(2);

            	            if ( getUnorderedGroupHelper().canSelect(grammarAccess.getAssociationAccess().getUnorderedGroup_5_1(), 0) ) {
            	                alt17=1;
            	            }
            	            else if ( getUnorderedGroupHelper().canSelect(grammarAccess.getAssociationAccess().getUnorderedGroup_5_1(), 1) ) {
            	                alt17=2;
            	            }


            	        }


            	        switch (alt17) {
            	    	case 1 :
            	    	    // InternalForml.g:746:4: ({...}? => ( ({...}? => ( (lv_srcRole_8_0= ruleRole ) ) ) ) )
            	    	    {
            	    	    // InternalForml.g:746:4: ({...}? => ( ({...}? => ( (lv_srcRole_8_0= ruleRole ) ) ) ) )
            	    	    // InternalForml.g:747:5: {...}? => ( ({...}? => ( (lv_srcRole_8_0= ruleRole ) ) ) )
            	    	    {
            	    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAssociationAccess().getUnorderedGroup_5_1(), 0) ) {
            	    	        throw new FailedPredicateException(input, "ruleAssociation", "getUnorderedGroupHelper().canSelect(grammarAccess.getAssociationAccess().getUnorderedGroup_5_1(), 0)");
            	    	    }
            	    	    // InternalForml.g:747:110: ( ({...}? => ( (lv_srcRole_8_0= ruleRole ) ) ) )
            	    	    // InternalForml.g:748:6: ({...}? => ( (lv_srcRole_8_0= ruleRole ) ) )
            	    	    {
            	    	     
            	    	    	 				  getUnorderedGroupHelper().select(grammarAccess.getAssociationAccess().getUnorderedGroup_5_1(), 0);
            	    	    	 				
            	    	    // InternalForml.g:751:6: ({...}? => ( (lv_srcRole_8_0= ruleRole ) ) )
            	    	    // InternalForml.g:751:7: {...}? => ( (lv_srcRole_8_0= ruleRole ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleAssociation", "true");
            	    	    }
            	    	    // InternalForml.g:751:16: ( (lv_srcRole_8_0= ruleRole ) )
            	    	    // InternalForml.g:752:1: (lv_srcRole_8_0= ruleRole )
            	    	    {
            	    	    // InternalForml.g:752:1: (lv_srcRole_8_0= ruleRole )
            	    	    // InternalForml.g:753:3: lv_srcRole_8_0= ruleRole
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getAssociationAccess().getSrcRoleRoleParserRuleCall_5_1_0_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_17);
            	    	    lv_srcRole_8_0=ruleRole();

            	    	    state._fsp--;


            	    	    	        if (current==null) {
            	    	    	            current = createModelElementForParent(grammarAccess.getAssociationRule());
            	    	    	        }
            	    	           		set(
            	    	           			current, 
            	    	           			"srcRole",
            	    	            		lv_srcRole_8_0, 
            	    	            		"uw.cs.watform.forml.Forml.Role");
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }


            	    	    }

            	    	     
            	    	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getAssociationAccess().getUnorderedGroup_5_1());
            	    	    	 				

            	    	    }


            	    	    }


            	    	    }
            	    	    break;
            	    	case 2 :
            	    	    // InternalForml.g:776:4: ({...}? => ( ({...}? => ( (lv_desRole_9_0= ruleRole ) ) ) ) )
            	    	    {
            	    	    // InternalForml.g:776:4: ({...}? => ( ({...}? => ( (lv_desRole_9_0= ruleRole ) ) ) ) )
            	    	    // InternalForml.g:777:5: {...}? => ( ({...}? => ( (lv_desRole_9_0= ruleRole ) ) ) )
            	    	    {
            	    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAssociationAccess().getUnorderedGroup_5_1(), 1) ) {
            	    	        throw new FailedPredicateException(input, "ruleAssociation", "getUnorderedGroupHelper().canSelect(grammarAccess.getAssociationAccess().getUnorderedGroup_5_1(), 1)");
            	    	    }
            	    	    // InternalForml.g:777:110: ( ({...}? => ( (lv_desRole_9_0= ruleRole ) ) ) )
            	    	    // InternalForml.g:778:6: ({...}? => ( (lv_desRole_9_0= ruleRole ) ) )
            	    	    {
            	    	     
            	    	    	 				  getUnorderedGroupHelper().select(grammarAccess.getAssociationAccess().getUnorderedGroup_5_1(), 1);
            	    	    	 				
            	    	    // InternalForml.g:781:6: ({...}? => ( (lv_desRole_9_0= ruleRole ) ) )
            	    	    // InternalForml.g:781:7: {...}? => ( (lv_desRole_9_0= ruleRole ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleAssociation", "true");
            	    	    }
            	    	    // InternalForml.g:781:16: ( (lv_desRole_9_0= ruleRole ) )
            	    	    // InternalForml.g:782:1: (lv_desRole_9_0= ruleRole )
            	    	    {
            	    	    // InternalForml.g:782:1: (lv_desRole_9_0= ruleRole )
            	    	    // InternalForml.g:783:3: lv_desRole_9_0= ruleRole
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getAssociationAccess().getDesRoleRoleParserRuleCall_5_1_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_17);
            	    	    lv_desRole_9_0=ruleRole();

            	    	    state._fsp--;


            	    	    	        if (current==null) {
            	    	    	            current = createModelElementForParent(grammarAccess.getAssociationRule());
            	    	    	        }
            	    	           		set(
            	    	           			current, 
            	    	           			"desRole",
            	    	            		lv_desRole_9_0, 
            	    	            		"uw.cs.watform.forml.Forml.Role");
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }


            	    	    }

            	    	     
            	    	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getAssociationAccess().getUnorderedGroup_5_1());
            	    	    	 				

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt17 >= 1 ) break loop17;
            	                EarlyExitException eee =
            	                    new EarlyExitException(17, input);
            	                throw eee;
            	        }
            	        cnt17++;
            	    } while (true);

            	    if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getAssociationAccess().getUnorderedGroup_5_1()) ) {
            	        throw new FailedPredicateException(input, "ruleAssociation", "getUnorderedGroupHelper().canLeave(grammarAccess.getAssociationAccess().getUnorderedGroup_5_1())");
            	    }

            	    }


            	    }

            	     
            	    	  getUnorderedGroupHelper().leave(grammarAccess.getAssociationAccess().getUnorderedGroup_5_1());
            	    	

            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getAssociationAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt18 >= 1 ) break loop18;
                        EarlyExitException eee =
                            new EarlyExitException(18, input);
                        throw eee;
                }
                cnt18++;
            } while (true);

            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getAssociationAccess().getUnorderedGroup_5()) ) {
                throw new FailedPredicateException(input, "ruleAssociation", "getUnorderedGroupHelper().canLeave(grammarAccess.getAssociationAccess().getUnorderedGroup_5())");
            }

            }


            }

             
            	  getUnorderedGroupHelper().leave(grammarAccess.getAssociationAccess().getUnorderedGroup_5());
            	

            }

            otherlv_10=(Token)match(input,13,FOLLOW_2); 

                	newLeafNode(otherlv_10, grammarAccess.getAssociationAccess().getRightCurlyBracketKeyword_6());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAssociation"


    // $ANTLR start "entryRuleAttribute"
    // InternalForml.g:841:1: entryRuleAttribute returns [EObject current=null] : iv_ruleAttribute= ruleAttribute EOF ;
    public final EObject entryRuleAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttribute = null;


        try {
            // InternalForml.g:842:2: (iv_ruleAttribute= ruleAttribute EOF )
            // InternalForml.g:843:2: iv_ruleAttribute= ruleAttribute EOF
            {
             newCompositeNode(grammarAccess.getAttributeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAttribute=ruleAttribute();

            state._fsp--;

             current =iv_ruleAttribute; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAttribute"


    // $ANTLR start "ruleAttribute"
    // InternalForml.g:850:1: ruleAttribute returns [EObject current=null] : ( () ( (lv_ctrl_1_0= 'ctrl' ) )? otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '[' ( (lv_multiplicity_5_0= ruleMultiplicity ) ) otherlv_6= ']' )? otherlv_7= ':' ( (lv_type_8_0= ruleAttributeType ) )? ) ;
    public final EObject ruleAttribute() throws RecognitionException {
        EObject current = null;

        Token lv_ctrl_1_0=null;
        Token otherlv_2=null;
        Token lv_name_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        EObject lv_multiplicity_5_0 = null;

        EObject lv_type_8_0 = null;


         enterRule(); 
            
        try {
            // InternalForml.g:853:28: ( ( () ( (lv_ctrl_1_0= 'ctrl' ) )? otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '[' ( (lv_multiplicity_5_0= ruleMultiplicity ) ) otherlv_6= ']' )? otherlv_7= ':' ( (lv_type_8_0= ruleAttributeType ) )? ) )
            // InternalForml.g:854:1: ( () ( (lv_ctrl_1_0= 'ctrl' ) )? otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '[' ( (lv_multiplicity_5_0= ruleMultiplicity ) ) otherlv_6= ']' )? otherlv_7= ':' ( (lv_type_8_0= ruleAttributeType ) )? )
            {
            // InternalForml.g:854:1: ( () ( (lv_ctrl_1_0= 'ctrl' ) )? otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '[' ( (lv_multiplicity_5_0= ruleMultiplicity ) ) otherlv_6= ']' )? otherlv_7= ':' ( (lv_type_8_0= ruleAttributeType ) )? )
            // InternalForml.g:854:2: () ( (lv_ctrl_1_0= 'ctrl' ) )? otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '[' ( (lv_multiplicity_5_0= ruleMultiplicity ) ) otherlv_6= ']' )? otherlv_7= ':' ( (lv_type_8_0= ruleAttributeType ) )?
            {
            // InternalForml.g:854:2: ()
            // InternalForml.g:855:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getAttributeAccess().getAttributeAction_0(),
                        current);
                

            }

            // InternalForml.g:860:2: ( (lv_ctrl_1_0= 'ctrl' ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==16) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalForml.g:861:1: (lv_ctrl_1_0= 'ctrl' )
                    {
                    // InternalForml.g:861:1: (lv_ctrl_1_0= 'ctrl' )
                    // InternalForml.g:862:3: lv_ctrl_1_0= 'ctrl'
                    {
                    lv_ctrl_1_0=(Token)match(input,16,FOLLOW_18); 

                            newLeafNode(lv_ctrl_1_0, grammarAccess.getAttributeAccess().getCtrlCtrlKeyword_1_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getAttributeRule());
                    	        }
                           		setWithLastConsumed(current, "ctrl", true, "ctrl");
                    	    

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,20,FOLLOW_10); 

                	newLeafNode(otherlv_2, grammarAccess.getAttributeAccess().getAttributeKeyword_2());
                
            // InternalForml.g:879:1: ( (lv_name_3_0= RULE_ID ) )
            // InternalForml.g:880:1: (lv_name_3_0= RULE_ID )
            {
            // InternalForml.g:880:1: (lv_name_3_0= RULE_ID )
            // InternalForml.g:881:3: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_19); 

            			newLeafNode(lv_name_3_0, grammarAccess.getAttributeAccess().getNameIDTerminalRuleCall_3_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getAttributeRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_3_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            // InternalForml.g:897:2: (otherlv_4= '[' ( (lv_multiplicity_5_0= ruleMultiplicity ) ) otherlv_6= ']' )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==21) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalForml.g:897:4: otherlv_4= '[' ( (lv_multiplicity_5_0= ruleMultiplicity ) ) otherlv_6= ']'
                    {
                    otherlv_4=(Token)match(input,21,FOLLOW_20); 

                        	newLeafNode(otherlv_4, grammarAccess.getAttributeAccess().getLeftSquareBracketKeyword_4_0());
                        
                    // InternalForml.g:901:1: ( (lv_multiplicity_5_0= ruleMultiplicity ) )
                    // InternalForml.g:902:1: (lv_multiplicity_5_0= ruleMultiplicity )
                    {
                    // InternalForml.g:902:1: (lv_multiplicity_5_0= ruleMultiplicity )
                    // InternalForml.g:903:3: lv_multiplicity_5_0= ruleMultiplicity
                    {
                     
                    	        newCompositeNode(grammarAccess.getAttributeAccess().getMultiplicityMultiplicityParserRuleCall_4_1_0()); 
                    	    
                    pushFollow(FOLLOW_21);
                    lv_multiplicity_5_0=ruleMultiplicity();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getAttributeRule());
                    	        }
                           		set(
                           			current, 
                           			"multiplicity",
                            		lv_multiplicity_5_0, 
                            		"uw.cs.watform.forml.Forml.Multiplicity");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_6=(Token)match(input,22,FOLLOW_22); 

                        	newLeafNode(otherlv_6, grammarAccess.getAttributeAccess().getRightSquareBracketKeyword_4_2());
                        

                    }
                    break;

            }

            otherlv_7=(Token)match(input,23,FOLLOW_23); 

                	newLeafNode(otherlv_7, grammarAccess.getAttributeAccess().getColonKeyword_5());
                
            // InternalForml.g:927:1: ( (lv_type_8_0= ruleAttributeType ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==RULE_ID||(LA21_0>=24 && LA21_0<=25)||(LA21_0>=27 && LA21_0<=31)) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalForml.g:928:1: (lv_type_8_0= ruleAttributeType )
                    {
                    // InternalForml.g:928:1: (lv_type_8_0= ruleAttributeType )
                    // InternalForml.g:929:3: lv_type_8_0= ruleAttributeType
                    {
                     
                    	        newCompositeNode(grammarAccess.getAttributeAccess().getTypeAttributeTypeParserRuleCall_6_0()); 
                    	    
                    pushFollow(FOLLOW_2);
                    lv_type_8_0=ruleAttributeType();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getAttributeRule());
                    	        }
                           		set(
                           			current, 
                           			"type",
                            		lv_type_8_0, 
                            		"uw.cs.watform.forml.Forml.AttributeType");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAttribute"


    // $ANTLR start "entryRuleAttributeType"
    // InternalForml.g:953:1: entryRuleAttributeType returns [EObject current=null] : iv_ruleAttributeType= ruleAttributeType EOF ;
    public final EObject entryRuleAttributeType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeType = null;


        try {
            // InternalForml.g:954:2: (iv_ruleAttributeType= ruleAttributeType EOF )
            // InternalForml.g:955:2: iv_ruleAttributeType= ruleAttributeType EOF
            {
             newCompositeNode(grammarAccess.getAttributeTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAttributeType=ruleAttributeType();

            state._fsp--;

             current =iv_ruleAttributeType; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAttributeType"


    // $ANTLR start "ruleAttributeType"
    // InternalForml.g:962:1: ruleAttributeType returns [EObject current=null] : (this_ReferenceType_0= ruleReferenceType | this_IntType_1= ruleIntType | this_BoolType_2= ruleBoolType | this_StringType_3= ruleStringType | this_UndefinedType_4= ruleUndefinedType ) ;
    public final EObject ruleAttributeType() throws RecognitionException {
        EObject current = null;

        EObject this_ReferenceType_0 = null;

        EObject this_IntType_1 = null;

        EObject this_BoolType_2 = null;

        EObject this_StringType_3 = null;

        EObject this_UndefinedType_4 = null;


         enterRule(); 
            
        try {
            // InternalForml.g:965:28: ( (this_ReferenceType_0= ruleReferenceType | this_IntType_1= ruleIntType | this_BoolType_2= ruleBoolType | this_StringType_3= ruleStringType | this_UndefinedType_4= ruleUndefinedType ) )
            // InternalForml.g:966:1: (this_ReferenceType_0= ruleReferenceType | this_IntType_1= ruleIntType | this_BoolType_2= ruleBoolType | this_StringType_3= ruleStringType | this_UndefinedType_4= ruleUndefinedType )
            {
            // InternalForml.g:966:1: (this_ReferenceType_0= ruleReferenceType | this_IntType_1= ruleIntType | this_BoolType_2= ruleBoolType | this_StringType_3= ruleStringType | this_UndefinedType_4= ruleUndefinedType )
            int alt22=5;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt22=1;
                }
                break;
            case 27:
            case 28:
                {
                alt22=2;
                }
                break;
            case 29:
            case 30:
                {
                alt22=3;
                }
                break;
            case 24:
            case 25:
                {
                alt22=4;
                }
                break;
            case 31:
                {
                alt22=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }

            switch (alt22) {
                case 1 :
                    // InternalForml.g:967:5: this_ReferenceType_0= ruleReferenceType
                    {
                     
                            newCompositeNode(grammarAccess.getAttributeTypeAccess().getReferenceTypeParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_2);
                    this_ReferenceType_0=ruleReferenceType();

                    state._fsp--;

                     
                            current = this_ReferenceType_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalForml.g:977:5: this_IntType_1= ruleIntType
                    {
                     
                            newCompositeNode(grammarAccess.getAttributeTypeAccess().getIntTypeParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_2);
                    this_IntType_1=ruleIntType();

                    state._fsp--;

                     
                            current = this_IntType_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // InternalForml.g:987:5: this_BoolType_2= ruleBoolType
                    {
                     
                            newCompositeNode(grammarAccess.getAttributeTypeAccess().getBoolTypeParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_2);
                    this_BoolType_2=ruleBoolType();

                    state._fsp--;

                     
                            current = this_BoolType_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // InternalForml.g:997:5: this_StringType_3= ruleStringType
                    {
                     
                            newCompositeNode(grammarAccess.getAttributeTypeAccess().getStringTypeParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_2);
                    this_StringType_3=ruleStringType();

                    state._fsp--;

                     
                            current = this_StringType_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // InternalForml.g:1007:5: this_UndefinedType_4= ruleUndefinedType
                    {
                     
                            newCompositeNode(grammarAccess.getAttributeTypeAccess().getUndefinedTypeParserRuleCall_4()); 
                        
                    pushFollow(FOLLOW_2);
                    this_UndefinedType_4=ruleUndefinedType();

                    state._fsp--;

                     
                            current = this_UndefinedType_4; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAttributeType"


    // $ANTLR start "entryRuleStringType"
    // InternalForml.g:1023:1: entryRuleStringType returns [EObject current=null] : iv_ruleStringType= ruleStringType EOF ;
    public final EObject entryRuleStringType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringType = null;


        try {
            // InternalForml.g:1024:2: (iv_ruleStringType= ruleStringType EOF )
            // InternalForml.g:1025:2: iv_ruleStringType= ruleStringType EOF
            {
             newCompositeNode(grammarAccess.getStringTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStringType=ruleStringType();

            state._fsp--;

             current =iv_ruleStringType; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStringType"


    // $ANTLR start "ruleStringType"
    // InternalForml.g:1032:1: ruleStringType returns [EObject current=null] : ( ( () otherlv_1= 'string' ) | otherlv_2= 'String' ) ;
    public final EObject ruleStringType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // InternalForml.g:1035:28: ( ( ( () otherlv_1= 'string' ) | otherlv_2= 'String' ) )
            // InternalForml.g:1036:1: ( ( () otherlv_1= 'string' ) | otherlv_2= 'String' )
            {
            // InternalForml.g:1036:1: ( ( () otherlv_1= 'string' ) | otherlv_2= 'String' )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==24) ) {
                alt23=1;
            }
            else if ( (LA23_0==25) ) {
                alt23=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // InternalForml.g:1036:2: ( () otherlv_1= 'string' )
                    {
                    // InternalForml.g:1036:2: ( () otherlv_1= 'string' )
                    // InternalForml.g:1036:3: () otherlv_1= 'string'
                    {
                    // InternalForml.g:1036:3: ()
                    // InternalForml.g:1037:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getStringTypeAccess().getStringTypeAction_0_0(),
                                current);
                        

                    }

                    otherlv_1=(Token)match(input,24,FOLLOW_2); 

                        	newLeafNode(otherlv_1, grammarAccess.getStringTypeAccess().getStringKeyword_0_1());
                        

                    }


                    }
                    break;
                case 2 :
                    // InternalForml.g:1047:7: otherlv_2= 'String'
                    {
                    otherlv_2=(Token)match(input,25,FOLLOW_2); 

                        	newLeafNode(otherlv_2, grammarAccess.getStringTypeAccess().getStringKeyword_1());
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStringType"


    // $ANTLR start "entryRuleFunction"
    // InternalForml.g:1059:1: entryRuleFunction returns [EObject current=null] : iv_ruleFunction= ruleFunction EOF ;
    public final EObject entryRuleFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunction = null;


        try {
            // InternalForml.g:1060:2: (iv_ruleFunction= ruleFunction EOF )
            // InternalForml.g:1061:2: iv_ruleFunction= ruleFunction EOF
            {
             newCompositeNode(grammarAccess.getFunctionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFunction=ruleFunction();

            state._fsp--;

             current =iv_ruleFunction; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFunction"


    // $ANTLR start "ruleFunction"
    // InternalForml.g:1068:1: ruleFunction returns [EObject current=null] : ( () otherlv_1= 'function' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_type_4_0= ruleAttributeType ) )? ) ;
    public final EObject ruleFunction() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        EObject lv_type_4_0 = null;


         enterRule(); 
            
        try {
            // InternalForml.g:1071:28: ( ( () otherlv_1= 'function' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_type_4_0= ruleAttributeType ) )? ) )
            // InternalForml.g:1072:1: ( () otherlv_1= 'function' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_type_4_0= ruleAttributeType ) )? )
            {
            // InternalForml.g:1072:1: ( () otherlv_1= 'function' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_type_4_0= ruleAttributeType ) )? )
            // InternalForml.g:1072:2: () otherlv_1= 'function' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_type_4_0= ruleAttributeType ) )?
            {
            // InternalForml.g:1072:2: ()
            // InternalForml.g:1073:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getFunctionAccess().getFunctionAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,26,FOLLOW_10); 

                	newLeafNode(otherlv_1, grammarAccess.getFunctionAccess().getFunctionKeyword_1());
                
            // InternalForml.g:1082:1: ( (lv_name_2_0= RULE_ID ) )
            // InternalForml.g:1083:1: (lv_name_2_0= RULE_ID )
            {
            // InternalForml.g:1083:1: (lv_name_2_0= RULE_ID )
            // InternalForml.g:1084:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_22); 

            			newLeafNode(lv_name_2_0, grammarAccess.getFunctionAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getFunctionRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            otherlv_3=(Token)match(input,23,FOLLOW_23); 

                	newLeafNode(otherlv_3, grammarAccess.getFunctionAccess().getColonKeyword_3());
                
            // InternalForml.g:1104:1: ( (lv_type_4_0= ruleAttributeType ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==RULE_ID||(LA24_0>=24 && LA24_0<=25)||(LA24_0>=27 && LA24_0<=31)) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalForml.g:1105:1: (lv_type_4_0= ruleAttributeType )
                    {
                    // InternalForml.g:1105:1: (lv_type_4_0= ruleAttributeType )
                    // InternalForml.g:1106:3: lv_type_4_0= ruleAttributeType
                    {
                     
                    	        newCompositeNode(grammarAccess.getFunctionAccess().getTypeAttributeTypeParserRuleCall_4_0()); 
                    	    
                    pushFollow(FOLLOW_2);
                    lv_type_4_0=ruleAttributeType();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getFunctionRule());
                    	        }
                           		set(
                           			current, 
                           			"type",
                            		lv_type_4_0, 
                            		"uw.cs.watform.forml.Forml.AttributeType");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFunction"


    // $ANTLR start "entryRuleIntType"
    // InternalForml.g:1130:1: entryRuleIntType returns [EObject current=null] : iv_ruleIntType= ruleIntType EOF ;
    public final EObject entryRuleIntType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntType = null;


        try {
            // InternalForml.g:1131:2: (iv_ruleIntType= ruleIntType EOF )
            // InternalForml.g:1132:2: iv_ruleIntType= ruleIntType EOF
            {
             newCompositeNode(grammarAccess.getIntTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIntType=ruleIntType();

            state._fsp--;

             current =iv_ruleIntType; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIntType"


    // $ANTLR start "ruleIntType"
    // InternalForml.g:1139:1: ruleIntType returns [EObject current=null] : ( ( () otherlv_1= 'int' ) | otherlv_2= 'Integer' ) ;
    public final EObject ruleIntType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // InternalForml.g:1142:28: ( ( ( () otherlv_1= 'int' ) | otherlv_2= 'Integer' ) )
            // InternalForml.g:1143:1: ( ( () otherlv_1= 'int' ) | otherlv_2= 'Integer' )
            {
            // InternalForml.g:1143:1: ( ( () otherlv_1= 'int' ) | otherlv_2= 'Integer' )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==27) ) {
                alt25=1;
            }
            else if ( (LA25_0==28) ) {
                alt25=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // InternalForml.g:1143:2: ( () otherlv_1= 'int' )
                    {
                    // InternalForml.g:1143:2: ( () otherlv_1= 'int' )
                    // InternalForml.g:1143:3: () otherlv_1= 'int'
                    {
                    // InternalForml.g:1143:3: ()
                    // InternalForml.g:1144:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getIntTypeAccess().getIntTypeAction_0_0(),
                                current);
                        

                    }

                    otherlv_1=(Token)match(input,27,FOLLOW_2); 

                        	newLeafNode(otherlv_1, grammarAccess.getIntTypeAccess().getIntKeyword_0_1());
                        

                    }


                    }
                    break;
                case 2 :
                    // InternalForml.g:1154:7: otherlv_2= 'Integer'
                    {
                    otherlv_2=(Token)match(input,28,FOLLOW_2); 

                        	newLeafNode(otherlv_2, grammarAccess.getIntTypeAccess().getIntegerKeyword_1());
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIntType"


    // $ANTLR start "entryRuleBoolType"
    // InternalForml.g:1166:1: entryRuleBoolType returns [EObject current=null] : iv_ruleBoolType= ruleBoolType EOF ;
    public final EObject entryRuleBoolType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBoolType = null;


        try {
            // InternalForml.g:1167:2: (iv_ruleBoolType= ruleBoolType EOF )
            // InternalForml.g:1168:2: iv_ruleBoolType= ruleBoolType EOF
            {
             newCompositeNode(grammarAccess.getBoolTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBoolType=ruleBoolType();

            state._fsp--;

             current =iv_ruleBoolType; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBoolType"


    // $ANTLR start "ruleBoolType"
    // InternalForml.g:1175:1: ruleBoolType returns [EObject current=null] : ( ( () otherlv_1= 'bool' ) | otherlv_2= 'Boolean' ) ;
    public final EObject ruleBoolType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // InternalForml.g:1178:28: ( ( ( () otherlv_1= 'bool' ) | otherlv_2= 'Boolean' ) )
            // InternalForml.g:1179:1: ( ( () otherlv_1= 'bool' ) | otherlv_2= 'Boolean' )
            {
            // InternalForml.g:1179:1: ( ( () otherlv_1= 'bool' ) | otherlv_2= 'Boolean' )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==29) ) {
                alt26=1;
            }
            else if ( (LA26_0==30) ) {
                alt26=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // InternalForml.g:1179:2: ( () otherlv_1= 'bool' )
                    {
                    // InternalForml.g:1179:2: ( () otherlv_1= 'bool' )
                    // InternalForml.g:1179:3: () otherlv_1= 'bool'
                    {
                    // InternalForml.g:1179:3: ()
                    // InternalForml.g:1180:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getBoolTypeAccess().getBoolTypeAction_0_0(),
                                current);
                        

                    }

                    otherlv_1=(Token)match(input,29,FOLLOW_2); 

                        	newLeafNode(otherlv_1, grammarAccess.getBoolTypeAccess().getBoolKeyword_0_1());
                        

                    }


                    }
                    break;
                case 2 :
                    // InternalForml.g:1190:7: otherlv_2= 'Boolean'
                    {
                    otherlv_2=(Token)match(input,30,FOLLOW_2); 

                        	newLeafNode(otherlv_2, grammarAccess.getBoolTypeAccess().getBooleanKeyword_1());
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBoolType"


    // $ANTLR start "entryRuleReferenceType"
    // InternalForml.g:1202:1: entryRuleReferenceType returns [EObject current=null] : iv_ruleReferenceType= ruleReferenceType EOF ;
    public final EObject entryRuleReferenceType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceType = null;


        try {
            // InternalForml.g:1203:2: (iv_ruleReferenceType= ruleReferenceType EOF )
            // InternalForml.g:1204:2: iv_ruleReferenceType= ruleReferenceType EOF
            {
             newCompositeNode(grammarAccess.getReferenceTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleReferenceType=ruleReferenceType();

            state._fsp--;

             current =iv_ruleReferenceType; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleReferenceType"


    // $ANTLR start "ruleReferenceType"
    // InternalForml.g:1211:1: ruleReferenceType returns [EObject current=null] : ( (otherlv_0= RULE_ID ) ) ;
    public final EObject ruleReferenceType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;

         enterRule(); 
            
        try {
            // InternalForml.g:1214:28: ( ( (otherlv_0= RULE_ID ) ) )
            // InternalForml.g:1215:1: ( (otherlv_0= RULE_ID ) )
            {
            // InternalForml.g:1215:1: ( (otherlv_0= RULE_ID ) )
            // InternalForml.g:1216:1: (otherlv_0= RULE_ID )
            {
            // InternalForml.g:1216:1: (otherlv_0= RULE_ID )
            // InternalForml.g:1217:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getReferenceTypeRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            		newLeafNode(otherlv_0, grammarAccess.getReferenceTypeAccess().getRefConceptCrossReference_0()); 
            	

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleReferenceType"


    // $ANTLR start "entryRuleUndefinedType"
    // InternalForml.g:1236:1: entryRuleUndefinedType returns [EObject current=null] : iv_ruleUndefinedType= ruleUndefinedType EOF ;
    public final EObject entryRuleUndefinedType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUndefinedType = null;


        try {
            // InternalForml.g:1237:2: (iv_ruleUndefinedType= ruleUndefinedType EOF )
            // InternalForml.g:1238:2: iv_ruleUndefinedType= ruleUndefinedType EOF
            {
             newCompositeNode(grammarAccess.getUndefinedTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleUndefinedType=ruleUndefinedType();

            state._fsp--;

             current =iv_ruleUndefinedType; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUndefinedType"


    // $ANTLR start "ruleUndefinedType"
    // InternalForml.g:1245:1: ruleUndefinedType returns [EObject current=null] : ( () otherlv_1= 'undefined_type' ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleUndefinedType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;

         enterRule(); 
            
        try {
            // InternalForml.g:1248:28: ( ( () otherlv_1= 'undefined_type' ( (lv_name_2_0= RULE_ID ) ) ) )
            // InternalForml.g:1249:1: ( () otherlv_1= 'undefined_type' ( (lv_name_2_0= RULE_ID ) ) )
            {
            // InternalForml.g:1249:1: ( () otherlv_1= 'undefined_type' ( (lv_name_2_0= RULE_ID ) ) )
            // InternalForml.g:1249:2: () otherlv_1= 'undefined_type' ( (lv_name_2_0= RULE_ID ) )
            {
            // InternalForml.g:1249:2: ()
            // InternalForml.g:1250:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getUndefinedTypeAccess().getUndefinedTypeAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,31,FOLLOW_10); 

                	newLeafNode(otherlv_1, grammarAccess.getUndefinedTypeAccess().getUndefined_typeKeyword_1());
                
            // InternalForml.g:1259:1: ( (lv_name_2_0= RULE_ID ) )
            // InternalForml.g:1260:1: (lv_name_2_0= RULE_ID )
            {
            // InternalForml.g:1260:1: (lv_name_2_0= RULE_ID )
            // InternalForml.g:1261:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            			newLeafNode(lv_name_2_0, grammarAccess.getUndefinedTypeAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getUndefinedTypeRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUndefinedType"


    // $ANTLR start "entryRuleMultiplicity"
    // InternalForml.g:1285:1: entryRuleMultiplicity returns [EObject current=null] : iv_ruleMultiplicity= ruleMultiplicity EOF ;
    public final EObject entryRuleMultiplicity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicity = null;


        try {
            // InternalForml.g:1286:2: (iv_ruleMultiplicity= ruleMultiplicity EOF )
            // InternalForml.g:1287:2: iv_ruleMultiplicity= ruleMultiplicity EOF
            {
             newCompositeNode(grammarAccess.getMultiplicityRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMultiplicity=ruleMultiplicity();

            state._fsp--;

             current =iv_ruleMultiplicity; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMultiplicity"


    // $ANTLR start "ruleMultiplicity"
    // InternalForml.g:1294:1: ruleMultiplicity returns [EObject current=null] : ( ( ( (lv_value_0_0= RULE_INT ) ) | ( (lv_many_1_0= '*' ) ) ) | ( (lv_cardinality_2_0= ruleCardinality ) ) ) ;
    public final EObject ruleMultiplicity() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;
        Token lv_many_1_0=null;
        EObject lv_cardinality_2_0 = null;


         enterRule(); 
            
        try {
            // InternalForml.g:1297:28: ( ( ( ( (lv_value_0_0= RULE_INT ) ) | ( (lv_many_1_0= '*' ) ) ) | ( (lv_cardinality_2_0= ruleCardinality ) ) ) )
            // InternalForml.g:1298:1: ( ( ( (lv_value_0_0= RULE_INT ) ) | ( (lv_many_1_0= '*' ) ) ) | ( (lv_cardinality_2_0= ruleCardinality ) ) )
            {
            // InternalForml.g:1298:1: ( ( ( (lv_value_0_0= RULE_INT ) ) | ( (lv_many_1_0= '*' ) ) ) | ( (lv_cardinality_2_0= ruleCardinality ) ) )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==RULE_INT) ) {
                int LA28_1 = input.LA(2);

                if ( (LA28_1==EOF||LA28_1==22) ) {
                    alt28=1;
                }
                else if ( (LA28_1==33) ) {
                    alt28=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 28, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA28_0==32) ) {
                alt28=1;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // InternalForml.g:1298:2: ( ( (lv_value_0_0= RULE_INT ) ) | ( (lv_many_1_0= '*' ) ) )
                    {
                    // InternalForml.g:1298:2: ( ( (lv_value_0_0= RULE_INT ) ) | ( (lv_many_1_0= '*' ) ) )
                    int alt27=2;
                    int LA27_0 = input.LA(1);

                    if ( (LA27_0==RULE_INT) ) {
                        alt27=1;
                    }
                    else if ( (LA27_0==32) ) {
                        alt27=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 27, 0, input);

                        throw nvae;
                    }
                    switch (alt27) {
                        case 1 :
                            // InternalForml.g:1298:3: ( (lv_value_0_0= RULE_INT ) )
                            {
                            // InternalForml.g:1298:3: ( (lv_value_0_0= RULE_INT ) )
                            // InternalForml.g:1299:1: (lv_value_0_0= RULE_INT )
                            {
                            // InternalForml.g:1299:1: (lv_value_0_0= RULE_INT )
                            // InternalForml.g:1300:3: lv_value_0_0= RULE_INT
                            {
                            lv_value_0_0=(Token)match(input,RULE_INT,FOLLOW_2); 

                            			newLeafNode(lv_value_0_0, grammarAccess.getMultiplicityAccess().getValueINTTerminalRuleCall_0_0_0()); 
                            		

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getMultiplicityRule());
                            	        }
                                   		setWithLastConsumed(
                                   			current, 
                                   			"value",
                                    		lv_value_0_0, 
                                    		"org.eclipse.xtext.common.Terminals.INT");
                            	    

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalForml.g:1317:6: ( (lv_many_1_0= '*' ) )
                            {
                            // InternalForml.g:1317:6: ( (lv_many_1_0= '*' ) )
                            // InternalForml.g:1318:1: (lv_many_1_0= '*' )
                            {
                            // InternalForml.g:1318:1: (lv_many_1_0= '*' )
                            // InternalForml.g:1319:3: lv_many_1_0= '*'
                            {
                            lv_many_1_0=(Token)match(input,32,FOLLOW_2); 

                                    newLeafNode(lv_many_1_0, grammarAccess.getMultiplicityAccess().getManyAsteriskKeyword_0_1_0());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getMultiplicityRule());
                            	        }
                                   		setWithLastConsumed(current, "many", lv_many_1_0, "*");
                            	    

                            }


                            }


                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // InternalForml.g:1333:6: ( (lv_cardinality_2_0= ruleCardinality ) )
                    {
                    // InternalForml.g:1333:6: ( (lv_cardinality_2_0= ruleCardinality ) )
                    // InternalForml.g:1334:1: (lv_cardinality_2_0= ruleCardinality )
                    {
                    // InternalForml.g:1334:1: (lv_cardinality_2_0= ruleCardinality )
                    // InternalForml.g:1335:3: lv_cardinality_2_0= ruleCardinality
                    {
                     
                    	        newCompositeNode(grammarAccess.getMultiplicityAccess().getCardinalityCardinalityParserRuleCall_1_0()); 
                    	    
                    pushFollow(FOLLOW_2);
                    lv_cardinality_2_0=ruleCardinality();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getMultiplicityRule());
                    	        }
                           		set(
                           			current, 
                           			"cardinality",
                            		lv_cardinality_2_0, 
                            		"uw.cs.watform.forml.Forml.Cardinality");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMultiplicity"


    // $ANTLR start "entryRuleCardinality"
    // InternalForml.g:1359:1: entryRuleCardinality returns [EObject current=null] : iv_ruleCardinality= ruleCardinality EOF ;
    public final EObject entryRuleCardinality() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCardinality = null;


        try {
            // InternalForml.g:1360:2: (iv_ruleCardinality= ruleCardinality EOF )
            // InternalForml.g:1361:2: iv_ruleCardinality= ruleCardinality EOF
            {
             newCompositeNode(grammarAccess.getCardinalityRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCardinality=ruleCardinality();

            state._fsp--;

             current =iv_ruleCardinality; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCardinality"


    // $ANTLR start "ruleCardinality"
    // InternalForml.g:1368:1: ruleCardinality returns [EObject current=null] : ( ( (lv_lower_0_0= RULE_INT ) ) otherlv_1= '..' ( ( (lv_upper_2_0= RULE_INT ) ) | ( (lv_many_3_0= '*' ) ) ) ) ;
    public final EObject ruleCardinality() throws RecognitionException {
        EObject current = null;

        Token lv_lower_0_0=null;
        Token otherlv_1=null;
        Token lv_upper_2_0=null;
        Token lv_many_3_0=null;

         enterRule(); 
            
        try {
            // InternalForml.g:1371:28: ( ( ( (lv_lower_0_0= RULE_INT ) ) otherlv_1= '..' ( ( (lv_upper_2_0= RULE_INT ) ) | ( (lv_many_3_0= '*' ) ) ) ) )
            // InternalForml.g:1372:1: ( ( (lv_lower_0_0= RULE_INT ) ) otherlv_1= '..' ( ( (lv_upper_2_0= RULE_INT ) ) | ( (lv_many_3_0= '*' ) ) ) )
            {
            // InternalForml.g:1372:1: ( ( (lv_lower_0_0= RULE_INT ) ) otherlv_1= '..' ( ( (lv_upper_2_0= RULE_INT ) ) | ( (lv_many_3_0= '*' ) ) ) )
            // InternalForml.g:1372:2: ( (lv_lower_0_0= RULE_INT ) ) otherlv_1= '..' ( ( (lv_upper_2_0= RULE_INT ) ) | ( (lv_many_3_0= '*' ) ) )
            {
            // InternalForml.g:1372:2: ( (lv_lower_0_0= RULE_INT ) )
            // InternalForml.g:1373:1: (lv_lower_0_0= RULE_INT )
            {
            // InternalForml.g:1373:1: (lv_lower_0_0= RULE_INT )
            // InternalForml.g:1374:3: lv_lower_0_0= RULE_INT
            {
            lv_lower_0_0=(Token)match(input,RULE_INT,FOLLOW_24); 

            			newLeafNode(lv_lower_0_0, grammarAccess.getCardinalityAccess().getLowerINTTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getCardinalityRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"lower",
                    		lv_lower_0_0, 
                    		"org.eclipse.xtext.common.Terminals.INT");
            	    

            }


            }

            otherlv_1=(Token)match(input,33,FOLLOW_20); 

                	newLeafNode(otherlv_1, grammarAccess.getCardinalityAccess().getFullStopFullStopKeyword_1());
                
            // InternalForml.g:1394:1: ( ( (lv_upper_2_0= RULE_INT ) ) | ( (lv_many_3_0= '*' ) ) )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==RULE_INT) ) {
                alt29=1;
            }
            else if ( (LA29_0==32) ) {
                alt29=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // InternalForml.g:1394:2: ( (lv_upper_2_0= RULE_INT ) )
                    {
                    // InternalForml.g:1394:2: ( (lv_upper_2_0= RULE_INT ) )
                    // InternalForml.g:1395:1: (lv_upper_2_0= RULE_INT )
                    {
                    // InternalForml.g:1395:1: (lv_upper_2_0= RULE_INT )
                    // InternalForml.g:1396:3: lv_upper_2_0= RULE_INT
                    {
                    lv_upper_2_0=(Token)match(input,RULE_INT,FOLLOW_2); 

                    			newLeafNode(lv_upper_2_0, grammarAccess.getCardinalityAccess().getUpperINTTerminalRuleCall_2_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getCardinalityRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"upper",
                            		lv_upper_2_0, 
                            		"org.eclipse.xtext.common.Terminals.INT");
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalForml.g:1413:6: ( (lv_many_3_0= '*' ) )
                    {
                    // InternalForml.g:1413:6: ( (lv_many_3_0= '*' ) )
                    // InternalForml.g:1414:1: (lv_many_3_0= '*' )
                    {
                    // InternalForml.g:1414:1: (lv_many_3_0= '*' )
                    // InternalForml.g:1415:3: lv_many_3_0= '*'
                    {
                    lv_many_3_0=(Token)match(input,32,FOLLOW_2); 

                            newLeafNode(lv_many_3_0, grammarAccess.getCardinalityAccess().getManyAsteriskKeyword_2_1_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getCardinalityRule());
                    	        }
                           		setWithLastConsumed(current, "many", lv_many_3_0, "*");
                    	    

                    }


                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCardinality"


    // $ANTLR start "entryRuleRole"
    // InternalForml.g:1436:1: entryRuleRole returns [EObject current=null] : iv_ruleRole= ruleRole EOF ;
    public final EObject entryRuleRole() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRole = null;


        try {
            // InternalForml.g:1437:2: (iv_ruleRole= ruleRole EOF )
            // InternalForml.g:1438:2: iv_ruleRole= ruleRole EOF
            {
             newCompositeNode(grammarAccess.getRoleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRole=ruleRole();

            state._fsp--;

             current =iv_ruleRole; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRole"


    // $ANTLR start "ruleRole"
    // InternalForml.g:1445:1: ruleRole returns [EObject current=null] : (otherlv_0= 'role' () ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '[' ( (lv_multiplicity_4_0= ruleMultiplicity ) ) otherlv_5= ']' )? otherlv_6= ':' ( (otherlv_7= RULE_ID ) ) ) ;
    public final EObject ruleRole() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        EObject lv_multiplicity_4_0 = null;


         enterRule(); 
            
        try {
            // InternalForml.g:1448:28: ( (otherlv_0= 'role' () ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '[' ( (lv_multiplicity_4_0= ruleMultiplicity ) ) otherlv_5= ']' )? otherlv_6= ':' ( (otherlv_7= RULE_ID ) ) ) )
            // InternalForml.g:1449:1: (otherlv_0= 'role' () ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '[' ( (lv_multiplicity_4_0= ruleMultiplicity ) ) otherlv_5= ']' )? otherlv_6= ':' ( (otherlv_7= RULE_ID ) ) )
            {
            // InternalForml.g:1449:1: (otherlv_0= 'role' () ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '[' ( (lv_multiplicity_4_0= ruleMultiplicity ) ) otherlv_5= ']' )? otherlv_6= ':' ( (otherlv_7= RULE_ID ) ) )
            // InternalForml.g:1449:3: otherlv_0= 'role' () ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '[' ( (lv_multiplicity_4_0= ruleMultiplicity ) ) otherlv_5= ']' )? otherlv_6= ':' ( (otherlv_7= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,34,FOLLOW_10); 

                	newLeafNode(otherlv_0, grammarAccess.getRoleAccess().getRoleKeyword_0());
                
            // InternalForml.g:1453:1: ()
            // InternalForml.g:1454:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getRoleAccess().getRoleAction_1(),
                        current);
                

            }

            // InternalForml.g:1459:2: ( (lv_name_2_0= RULE_ID ) )
            // InternalForml.g:1460:1: (lv_name_2_0= RULE_ID )
            {
            // InternalForml.g:1460:1: (lv_name_2_0= RULE_ID )
            // InternalForml.g:1461:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_19); 

            			newLeafNode(lv_name_2_0, grammarAccess.getRoleAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getRoleRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            // InternalForml.g:1477:2: (otherlv_3= '[' ( (lv_multiplicity_4_0= ruleMultiplicity ) ) otherlv_5= ']' )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==21) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalForml.g:1477:4: otherlv_3= '[' ( (lv_multiplicity_4_0= ruleMultiplicity ) ) otherlv_5= ']'
                    {
                    otherlv_3=(Token)match(input,21,FOLLOW_20); 

                        	newLeafNode(otherlv_3, grammarAccess.getRoleAccess().getLeftSquareBracketKeyword_3_0());
                        
                    // InternalForml.g:1481:1: ( (lv_multiplicity_4_0= ruleMultiplicity ) )
                    // InternalForml.g:1482:1: (lv_multiplicity_4_0= ruleMultiplicity )
                    {
                    // InternalForml.g:1482:1: (lv_multiplicity_4_0= ruleMultiplicity )
                    // InternalForml.g:1483:3: lv_multiplicity_4_0= ruleMultiplicity
                    {
                     
                    	        newCompositeNode(grammarAccess.getRoleAccess().getMultiplicityMultiplicityParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FOLLOW_21);
                    lv_multiplicity_4_0=ruleMultiplicity();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRoleRule());
                    	        }
                           		set(
                           			current, 
                           			"multiplicity",
                            		lv_multiplicity_4_0, 
                            		"uw.cs.watform.forml.Forml.Multiplicity");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_5=(Token)match(input,22,FOLLOW_22); 

                        	newLeafNode(otherlv_5, grammarAccess.getRoleAccess().getRightSquareBracketKeyword_3_2());
                        

                    }
                    break;

            }

            otherlv_6=(Token)match(input,23,FOLLOW_10); 

                	newLeafNode(otherlv_6, grammarAccess.getRoleAccess().getColonKeyword_4());
                
            // InternalForml.g:1507:1: ( (otherlv_7= RULE_ID ) )
            // InternalForml.g:1508:1: (otherlv_7= RULE_ID )
            {
            // InternalForml.g:1508:1: (otherlv_7= RULE_ID )
            // InternalForml.g:1509:3: otherlv_7= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getRoleRule());
            	        }
                    
            otherlv_7=(Token)match(input,RULE_ID,FOLLOW_2); 

            		newLeafNode(otherlv_7, grammarAccess.getRoleAccess().getTypeRoleableCrossReference_5_0()); 
            	

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRole"


    // $ANTLR start "entryRuleAggregation"
    // InternalForml.g:1528:1: entryRuleAggregation returns [EObject current=null] : iv_ruleAggregation= ruleAggregation EOF ;
    public final EObject entryRuleAggregation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAggregation = null;


        try {
            // InternalForml.g:1529:2: (iv_ruleAggregation= ruleAggregation EOF )
            // InternalForml.g:1530:2: iv_ruleAggregation= ruleAggregation EOF
            {
             newCompositeNode(grammarAccess.getAggregationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAggregation=ruleAggregation();

            state._fsp--;

             current =iv_ruleAggregation; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAggregation"


    // $ANTLR start "ruleAggregation"
    // InternalForml.g:1537:1: ruleAggregation returns [EObject current=null] : ( () ( (lv_ctrl_1_0= 'ctrl' ) )? otherlv_2= 'aggregation' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'whole' ( (lv_whole_7_0= ruleDecl ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'part' ( (lv_part_9_0= ruleDecl ) ) ) ) ) ) )+ {...}?) ) ) otherlv_10= '}' ) ;
    public final EObject ruleAggregation() throws RecognitionException {
        EObject current = null;

        Token lv_ctrl_1_0=null;
        Token otherlv_2=null;
        Token lv_name_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        EObject lv_whole_7_0 = null;

        EObject lv_part_9_0 = null;


         enterRule(); 
            
        try {
            // InternalForml.g:1540:28: ( ( () ( (lv_ctrl_1_0= 'ctrl' ) )? otherlv_2= 'aggregation' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'whole' ( (lv_whole_7_0= ruleDecl ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'part' ( (lv_part_9_0= ruleDecl ) ) ) ) ) ) )+ {...}?) ) ) otherlv_10= '}' ) )
            // InternalForml.g:1541:1: ( () ( (lv_ctrl_1_0= 'ctrl' ) )? otherlv_2= 'aggregation' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'whole' ( (lv_whole_7_0= ruleDecl ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'part' ( (lv_part_9_0= ruleDecl ) ) ) ) ) ) )+ {...}?) ) ) otherlv_10= '}' )
            {
            // InternalForml.g:1541:1: ( () ( (lv_ctrl_1_0= 'ctrl' ) )? otherlv_2= 'aggregation' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'whole' ( (lv_whole_7_0= ruleDecl ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'part' ( (lv_part_9_0= ruleDecl ) ) ) ) ) ) )+ {...}?) ) ) otherlv_10= '}' )
            // InternalForml.g:1541:2: () ( (lv_ctrl_1_0= 'ctrl' ) )? otherlv_2= 'aggregation' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'whole' ( (lv_whole_7_0= ruleDecl ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'part' ( (lv_part_9_0= ruleDecl ) ) ) ) ) ) )+ {...}?) ) ) otherlv_10= '}'
            {
            // InternalForml.g:1541:2: ()
            // InternalForml.g:1542:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getAggregationAccess().getAggregationAction_0(),
                        current);
                

            }

            // InternalForml.g:1547:2: ( (lv_ctrl_1_0= 'ctrl' ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==16) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalForml.g:1548:1: (lv_ctrl_1_0= 'ctrl' )
                    {
                    // InternalForml.g:1548:1: (lv_ctrl_1_0= 'ctrl' )
                    // InternalForml.g:1549:3: lv_ctrl_1_0= 'ctrl'
                    {
                    lv_ctrl_1_0=(Token)match(input,16,FOLLOW_25); 

                            newLeafNode(lv_ctrl_1_0, grammarAccess.getAggregationAccess().getCtrlCtrlKeyword_1_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getAggregationRule());
                    	        }
                           		setWithLastConsumed(current, "ctrl", true, "ctrl");
                    	    

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,35,FOLLOW_10); 

                	newLeafNode(otherlv_2, grammarAccess.getAggregationAccess().getAggregationKeyword_2());
                
            // InternalForml.g:1566:1: ( (lv_name_3_0= RULE_ID ) )
            // InternalForml.g:1567:1: (lv_name_3_0= RULE_ID )
            {
            // InternalForml.g:1567:1: (lv_name_3_0= RULE_ID )
            // InternalForml.g:1568:3: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            			newLeafNode(lv_name_3_0, grammarAccess.getAggregationAccess().getNameIDTerminalRuleCall_3_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getAggregationRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_3_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            otherlv_4=(Token)match(input,12,FOLLOW_26); 

                	newLeafNode(otherlv_4, grammarAccess.getAggregationAccess().getLeftCurlyBracketKeyword_4());
                
            // InternalForml.g:1588:1: ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'whole' ( (lv_whole_7_0= ruleDecl ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'part' ( (lv_part_9_0= ruleDecl ) ) ) ) ) ) )+ {...}?) ) )
            // InternalForml.g:1590:1: ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'whole' ( (lv_whole_7_0= ruleDecl ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'part' ( (lv_part_9_0= ruleDecl ) ) ) ) ) ) )+ {...}?) )
            {
            // InternalForml.g:1590:1: ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'whole' ( (lv_whole_7_0= ruleDecl ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'part' ( (lv_part_9_0= ruleDecl ) ) ) ) ) ) )+ {...}?) )
            // InternalForml.g:1591:2: ( ( ({...}? => ( ({...}? => (otherlv_6= 'whole' ( (lv_whole_7_0= ruleDecl ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'part' ( (lv_part_9_0= ruleDecl ) ) ) ) ) ) )+ {...}?)
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getAggregationAccess().getUnorderedGroup_5());
            	
            // InternalForml.g:1594:2: ( ( ({...}? => ( ({...}? => (otherlv_6= 'whole' ( (lv_whole_7_0= ruleDecl ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'part' ( (lv_part_9_0= ruleDecl ) ) ) ) ) ) )+ {...}?)
            // InternalForml.g:1595:3: ( ({...}? => ( ({...}? => (otherlv_6= 'whole' ( (lv_whole_7_0= ruleDecl ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'part' ( (lv_part_9_0= ruleDecl ) ) ) ) ) ) )+ {...}?
            {
            // InternalForml.g:1595:3: ( ({...}? => ( ({...}? => (otherlv_6= 'whole' ( (lv_whole_7_0= ruleDecl ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'part' ( (lv_part_9_0= ruleDecl ) ) ) ) ) ) )+
            int cnt32=0;
            loop32:
            do {
                int alt32=3;
                int LA32_0 = input.LA(1);

                if ( LA32_0 == 36 && getUnorderedGroupHelper().canSelect(grammarAccess.getAggregationAccess().getUnorderedGroup_5(), 0) ) {
                    alt32=1;
                }
                else if ( LA32_0 == 37 && getUnorderedGroupHelper().canSelect(grammarAccess.getAggregationAccess().getUnorderedGroup_5(), 1) ) {
                    alt32=2;
                }


                switch (alt32) {
            	case 1 :
            	    // InternalForml.g:1597:4: ({...}? => ( ({...}? => (otherlv_6= 'whole' ( (lv_whole_7_0= ruleDecl ) ) ) ) ) )
            	    {
            	    // InternalForml.g:1597:4: ({...}? => ( ({...}? => (otherlv_6= 'whole' ( (lv_whole_7_0= ruleDecl ) ) ) ) ) )
            	    // InternalForml.g:1598:5: {...}? => ( ({...}? => (otherlv_6= 'whole' ( (lv_whole_7_0= ruleDecl ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAggregationAccess().getUnorderedGroup_5(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleAggregation", "getUnorderedGroupHelper().canSelect(grammarAccess.getAggregationAccess().getUnorderedGroup_5(), 0)");
            	    }
            	    // InternalForml.g:1598:108: ( ({...}? => (otherlv_6= 'whole' ( (lv_whole_7_0= ruleDecl ) ) ) ) )
            	    // InternalForml.g:1599:6: ({...}? => (otherlv_6= 'whole' ( (lv_whole_7_0= ruleDecl ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getAggregationAccess().getUnorderedGroup_5(), 0);
            	    	 				
            	    // InternalForml.g:1602:6: ({...}? => (otherlv_6= 'whole' ( (lv_whole_7_0= ruleDecl ) ) ) )
            	    // InternalForml.g:1602:7: {...}? => (otherlv_6= 'whole' ( (lv_whole_7_0= ruleDecl ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleAggregation", "true");
            	    }
            	    // InternalForml.g:1602:16: (otherlv_6= 'whole' ( (lv_whole_7_0= ruleDecl ) ) )
            	    // InternalForml.g:1602:18: otherlv_6= 'whole' ( (lv_whole_7_0= ruleDecl ) )
            	    {
            	    otherlv_6=(Token)match(input,36,FOLLOW_10); 

            	        	newLeafNode(otherlv_6, grammarAccess.getAggregationAccess().getWholeKeyword_5_0_0());
            	        
            	    // InternalForml.g:1606:1: ( (lv_whole_7_0= ruleDecl ) )
            	    // InternalForml.g:1607:1: (lv_whole_7_0= ruleDecl )
            	    {
            	    // InternalForml.g:1607:1: (lv_whole_7_0= ruleDecl )
            	    // InternalForml.g:1608:3: lv_whole_7_0= ruleDecl
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAggregationAccess().getWholeDeclParserRuleCall_5_0_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_27);
            	    lv_whole_7_0=ruleDecl();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getAggregationRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"whole",
            	            		lv_whole_7_0, 
            	            		"uw.cs.watform.forml.Forml.Decl");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getAggregationAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalForml.g:1631:4: ({...}? => ( ({...}? => (otherlv_8= 'part' ( (lv_part_9_0= ruleDecl ) ) ) ) ) )
            	    {
            	    // InternalForml.g:1631:4: ({...}? => ( ({...}? => (otherlv_8= 'part' ( (lv_part_9_0= ruleDecl ) ) ) ) ) )
            	    // InternalForml.g:1632:5: {...}? => ( ({...}? => (otherlv_8= 'part' ( (lv_part_9_0= ruleDecl ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAggregationAccess().getUnorderedGroup_5(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleAggregation", "getUnorderedGroupHelper().canSelect(grammarAccess.getAggregationAccess().getUnorderedGroup_5(), 1)");
            	    }
            	    // InternalForml.g:1632:108: ( ({...}? => (otherlv_8= 'part' ( (lv_part_9_0= ruleDecl ) ) ) ) )
            	    // InternalForml.g:1633:6: ({...}? => (otherlv_8= 'part' ( (lv_part_9_0= ruleDecl ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getAggregationAccess().getUnorderedGroup_5(), 1);
            	    	 				
            	    // InternalForml.g:1636:6: ({...}? => (otherlv_8= 'part' ( (lv_part_9_0= ruleDecl ) ) ) )
            	    // InternalForml.g:1636:7: {...}? => (otherlv_8= 'part' ( (lv_part_9_0= ruleDecl ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleAggregation", "true");
            	    }
            	    // InternalForml.g:1636:16: (otherlv_8= 'part' ( (lv_part_9_0= ruleDecl ) ) )
            	    // InternalForml.g:1636:18: otherlv_8= 'part' ( (lv_part_9_0= ruleDecl ) )
            	    {
            	    otherlv_8=(Token)match(input,37,FOLLOW_10); 

            	        	newLeafNode(otherlv_8, grammarAccess.getAggregationAccess().getPartKeyword_5_1_0());
            	        
            	    // InternalForml.g:1640:1: ( (lv_part_9_0= ruleDecl ) )
            	    // InternalForml.g:1641:1: (lv_part_9_0= ruleDecl )
            	    {
            	    // InternalForml.g:1641:1: (lv_part_9_0= ruleDecl )
            	    // InternalForml.g:1642:3: lv_part_9_0= ruleDecl
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAggregationAccess().getPartDeclParserRuleCall_5_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_27);
            	    lv_part_9_0=ruleDecl();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getAggregationRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"part",
            	            		lv_part_9_0, 
            	            		"uw.cs.watform.forml.Forml.Decl");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getAggregationAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt32 >= 1 ) break loop32;
                        EarlyExitException eee =
                            new EarlyExitException(32, input);
                        throw eee;
                }
                cnt32++;
            } while (true);

            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getAggregationAccess().getUnorderedGroup_5()) ) {
                throw new FailedPredicateException(input, "ruleAggregation", "getUnorderedGroupHelper().canLeave(grammarAccess.getAggregationAccess().getUnorderedGroup_5())");
            }

            }


            }

             
            	  getUnorderedGroupHelper().leave(grammarAccess.getAggregationAccess().getUnorderedGroup_5());
            	

            }

            otherlv_10=(Token)match(input,13,FOLLOW_2); 

                	newLeafNode(otherlv_10, grammarAccess.getAggregationAccess().getRightCurlyBracketKeyword_6());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAggregation"


    // $ANTLR start "entryRuleComposition"
    // InternalForml.g:1685:1: entryRuleComposition returns [EObject current=null] : iv_ruleComposition= ruleComposition EOF ;
    public final EObject entryRuleComposition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComposition = null;


        try {
            // InternalForml.g:1686:2: (iv_ruleComposition= ruleComposition EOF )
            // InternalForml.g:1687:2: iv_ruleComposition= ruleComposition EOF
            {
             newCompositeNode(grammarAccess.getCompositionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleComposition=ruleComposition();

            state._fsp--;

             current =iv_ruleComposition; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleComposition"


    // $ANTLR start "ruleComposition"
    // InternalForml.g:1694:1: ruleComposition returns [EObject current=null] : ( () ( (lv_ctrl_1_0= 'ctrl' ) )? otherlv_2= 'composition' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'whole' ( (lv_whole_7_0= ruleDecl ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'part' ( (lv_part_9_0= ruleDecl ) ) ) ) ) ) )+ {...}?) ) ) otherlv_10= '}' ) ;
    public final EObject ruleComposition() throws RecognitionException {
        EObject current = null;

        Token lv_ctrl_1_0=null;
        Token otherlv_2=null;
        Token lv_name_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        EObject lv_whole_7_0 = null;

        EObject lv_part_9_0 = null;


         enterRule(); 
            
        try {
            // InternalForml.g:1697:28: ( ( () ( (lv_ctrl_1_0= 'ctrl' ) )? otherlv_2= 'composition' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'whole' ( (lv_whole_7_0= ruleDecl ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'part' ( (lv_part_9_0= ruleDecl ) ) ) ) ) ) )+ {...}?) ) ) otherlv_10= '}' ) )
            // InternalForml.g:1698:1: ( () ( (lv_ctrl_1_0= 'ctrl' ) )? otherlv_2= 'composition' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'whole' ( (lv_whole_7_0= ruleDecl ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'part' ( (lv_part_9_0= ruleDecl ) ) ) ) ) ) )+ {...}?) ) ) otherlv_10= '}' )
            {
            // InternalForml.g:1698:1: ( () ( (lv_ctrl_1_0= 'ctrl' ) )? otherlv_2= 'composition' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'whole' ( (lv_whole_7_0= ruleDecl ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'part' ( (lv_part_9_0= ruleDecl ) ) ) ) ) ) )+ {...}?) ) ) otherlv_10= '}' )
            // InternalForml.g:1698:2: () ( (lv_ctrl_1_0= 'ctrl' ) )? otherlv_2= 'composition' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'whole' ( (lv_whole_7_0= ruleDecl ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'part' ( (lv_part_9_0= ruleDecl ) ) ) ) ) ) )+ {...}?) ) ) otherlv_10= '}'
            {
            // InternalForml.g:1698:2: ()
            // InternalForml.g:1699:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getCompositionAccess().getCompositionAction_0(),
                        current);
                

            }

            // InternalForml.g:1704:2: ( (lv_ctrl_1_0= 'ctrl' ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==16) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalForml.g:1705:1: (lv_ctrl_1_0= 'ctrl' )
                    {
                    // InternalForml.g:1705:1: (lv_ctrl_1_0= 'ctrl' )
                    // InternalForml.g:1706:3: lv_ctrl_1_0= 'ctrl'
                    {
                    lv_ctrl_1_0=(Token)match(input,16,FOLLOW_28); 

                            newLeafNode(lv_ctrl_1_0, grammarAccess.getCompositionAccess().getCtrlCtrlKeyword_1_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getCompositionRule());
                    	        }
                           		setWithLastConsumed(current, "ctrl", true, "ctrl");
                    	    

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,38,FOLLOW_10); 

                	newLeafNode(otherlv_2, grammarAccess.getCompositionAccess().getCompositionKeyword_2());
                
            // InternalForml.g:1723:1: ( (lv_name_3_0= RULE_ID ) )
            // InternalForml.g:1724:1: (lv_name_3_0= RULE_ID )
            {
            // InternalForml.g:1724:1: (lv_name_3_0= RULE_ID )
            // InternalForml.g:1725:3: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            			newLeafNode(lv_name_3_0, grammarAccess.getCompositionAccess().getNameIDTerminalRuleCall_3_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getCompositionRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_3_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            otherlv_4=(Token)match(input,12,FOLLOW_26); 

                	newLeafNode(otherlv_4, grammarAccess.getCompositionAccess().getLeftCurlyBracketKeyword_4());
                
            // InternalForml.g:1745:1: ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'whole' ( (lv_whole_7_0= ruleDecl ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'part' ( (lv_part_9_0= ruleDecl ) ) ) ) ) ) )+ {...}?) ) )
            // InternalForml.g:1747:1: ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'whole' ( (lv_whole_7_0= ruleDecl ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'part' ( (lv_part_9_0= ruleDecl ) ) ) ) ) ) )+ {...}?) )
            {
            // InternalForml.g:1747:1: ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'whole' ( (lv_whole_7_0= ruleDecl ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'part' ( (lv_part_9_0= ruleDecl ) ) ) ) ) ) )+ {...}?) )
            // InternalForml.g:1748:2: ( ( ({...}? => ( ({...}? => (otherlv_6= 'whole' ( (lv_whole_7_0= ruleDecl ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'part' ( (lv_part_9_0= ruleDecl ) ) ) ) ) ) )+ {...}?)
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getCompositionAccess().getUnorderedGroup_5());
            	
            // InternalForml.g:1751:2: ( ( ({...}? => ( ({...}? => (otherlv_6= 'whole' ( (lv_whole_7_0= ruleDecl ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'part' ( (lv_part_9_0= ruleDecl ) ) ) ) ) ) )+ {...}?)
            // InternalForml.g:1752:3: ( ({...}? => ( ({...}? => (otherlv_6= 'whole' ( (lv_whole_7_0= ruleDecl ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'part' ( (lv_part_9_0= ruleDecl ) ) ) ) ) ) )+ {...}?
            {
            // InternalForml.g:1752:3: ( ({...}? => ( ({...}? => (otherlv_6= 'whole' ( (lv_whole_7_0= ruleDecl ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'part' ( (lv_part_9_0= ruleDecl ) ) ) ) ) ) )+
            int cnt34=0;
            loop34:
            do {
                int alt34=3;
                int LA34_0 = input.LA(1);

                if ( LA34_0 == 36 && getUnorderedGroupHelper().canSelect(grammarAccess.getCompositionAccess().getUnorderedGroup_5(), 0) ) {
                    alt34=1;
                }
                else if ( LA34_0 == 37 && getUnorderedGroupHelper().canSelect(grammarAccess.getCompositionAccess().getUnorderedGroup_5(), 1) ) {
                    alt34=2;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalForml.g:1754:4: ({...}? => ( ({...}? => (otherlv_6= 'whole' ( (lv_whole_7_0= ruleDecl ) ) ) ) ) )
            	    {
            	    // InternalForml.g:1754:4: ({...}? => ( ({...}? => (otherlv_6= 'whole' ( (lv_whole_7_0= ruleDecl ) ) ) ) ) )
            	    // InternalForml.g:1755:5: {...}? => ( ({...}? => (otherlv_6= 'whole' ( (lv_whole_7_0= ruleDecl ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getCompositionAccess().getUnorderedGroup_5(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleComposition", "getUnorderedGroupHelper().canSelect(grammarAccess.getCompositionAccess().getUnorderedGroup_5(), 0)");
            	    }
            	    // InternalForml.g:1755:108: ( ({...}? => (otherlv_6= 'whole' ( (lv_whole_7_0= ruleDecl ) ) ) ) )
            	    // InternalForml.g:1756:6: ({...}? => (otherlv_6= 'whole' ( (lv_whole_7_0= ruleDecl ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getCompositionAccess().getUnorderedGroup_5(), 0);
            	    	 				
            	    // InternalForml.g:1759:6: ({...}? => (otherlv_6= 'whole' ( (lv_whole_7_0= ruleDecl ) ) ) )
            	    // InternalForml.g:1759:7: {...}? => (otherlv_6= 'whole' ( (lv_whole_7_0= ruleDecl ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleComposition", "true");
            	    }
            	    // InternalForml.g:1759:16: (otherlv_6= 'whole' ( (lv_whole_7_0= ruleDecl ) ) )
            	    // InternalForml.g:1759:18: otherlv_6= 'whole' ( (lv_whole_7_0= ruleDecl ) )
            	    {
            	    otherlv_6=(Token)match(input,36,FOLLOW_10); 

            	        	newLeafNode(otherlv_6, grammarAccess.getCompositionAccess().getWholeKeyword_5_0_0());
            	        
            	    // InternalForml.g:1763:1: ( (lv_whole_7_0= ruleDecl ) )
            	    // InternalForml.g:1764:1: (lv_whole_7_0= ruleDecl )
            	    {
            	    // InternalForml.g:1764:1: (lv_whole_7_0= ruleDecl )
            	    // InternalForml.g:1765:3: lv_whole_7_0= ruleDecl
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getCompositionAccess().getWholeDeclParserRuleCall_5_0_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_27);
            	    lv_whole_7_0=ruleDecl();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getCompositionRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"whole",
            	            		lv_whole_7_0, 
            	            		"uw.cs.watform.forml.Forml.Decl");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getCompositionAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalForml.g:1788:4: ({...}? => ( ({...}? => (otherlv_8= 'part' ( (lv_part_9_0= ruleDecl ) ) ) ) ) )
            	    {
            	    // InternalForml.g:1788:4: ({...}? => ( ({...}? => (otherlv_8= 'part' ( (lv_part_9_0= ruleDecl ) ) ) ) ) )
            	    // InternalForml.g:1789:5: {...}? => ( ({...}? => (otherlv_8= 'part' ( (lv_part_9_0= ruleDecl ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getCompositionAccess().getUnorderedGroup_5(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleComposition", "getUnorderedGroupHelper().canSelect(grammarAccess.getCompositionAccess().getUnorderedGroup_5(), 1)");
            	    }
            	    // InternalForml.g:1789:108: ( ({...}? => (otherlv_8= 'part' ( (lv_part_9_0= ruleDecl ) ) ) ) )
            	    // InternalForml.g:1790:6: ({...}? => (otherlv_8= 'part' ( (lv_part_9_0= ruleDecl ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getCompositionAccess().getUnorderedGroup_5(), 1);
            	    	 				
            	    // InternalForml.g:1793:6: ({...}? => (otherlv_8= 'part' ( (lv_part_9_0= ruleDecl ) ) ) )
            	    // InternalForml.g:1793:7: {...}? => (otherlv_8= 'part' ( (lv_part_9_0= ruleDecl ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleComposition", "true");
            	    }
            	    // InternalForml.g:1793:16: (otherlv_8= 'part' ( (lv_part_9_0= ruleDecl ) ) )
            	    // InternalForml.g:1793:18: otherlv_8= 'part' ( (lv_part_9_0= ruleDecl ) )
            	    {
            	    otherlv_8=(Token)match(input,37,FOLLOW_10); 

            	        	newLeafNode(otherlv_8, grammarAccess.getCompositionAccess().getPartKeyword_5_1_0());
            	        
            	    // InternalForml.g:1797:1: ( (lv_part_9_0= ruleDecl ) )
            	    // InternalForml.g:1798:1: (lv_part_9_0= ruleDecl )
            	    {
            	    // InternalForml.g:1798:1: (lv_part_9_0= ruleDecl )
            	    // InternalForml.g:1799:3: lv_part_9_0= ruleDecl
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getCompositionAccess().getPartDeclParserRuleCall_5_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_27);
            	    lv_part_9_0=ruleDecl();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getCompositionRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"part",
            	            		lv_part_9_0, 
            	            		"uw.cs.watform.forml.Forml.Decl");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getCompositionAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt34 >= 1 ) break loop34;
                        EarlyExitException eee =
                            new EarlyExitException(34, input);
                        throw eee;
                }
                cnt34++;
            } while (true);

            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getCompositionAccess().getUnorderedGroup_5()) ) {
                throw new FailedPredicateException(input, "ruleComposition", "getUnorderedGroupHelper().canLeave(grammarAccess.getCompositionAccess().getUnorderedGroup_5())");
            }

            }


            }

             
            	  getUnorderedGroupHelper().leave(grammarAccess.getCompositionAccess().getUnorderedGroup_5());
            	

            }

            otherlv_10=(Token)match(input,13,FOLLOW_2); 

                	newLeafNode(otherlv_10, grammarAccess.getCompositionAccess().getRightCurlyBracketKeyword_6());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleComposition"


    // $ANTLR start "entryRuleDecl"
    // InternalForml.g:1842:1: entryRuleDecl returns [EObject current=null] : iv_ruleDecl= ruleDecl EOF ;
    public final EObject entryRuleDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDecl = null;


        try {
            // InternalForml.g:1843:2: (iv_ruleDecl= ruleDecl EOF )
            // InternalForml.g:1844:2: iv_ruleDecl= ruleDecl EOF
            {
             newCompositeNode(grammarAccess.getDeclRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDecl=ruleDecl();

            state._fsp--;

             current =iv_ruleDecl; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDecl"


    // $ANTLR start "ruleDecl"
    // InternalForml.g:1851:1: ruleDecl returns [EObject current=null] : ( () ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_multiplicity_3_0= ruleMultiplicity ) ) otherlv_4= ']' )? otherlv_5= ':' ( (otherlv_6= RULE_ID ) ) ) ;
    public final EObject ruleDecl() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        EObject lv_multiplicity_3_0 = null;


         enterRule(); 
            
        try {
            // InternalForml.g:1854:28: ( ( () ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_multiplicity_3_0= ruleMultiplicity ) ) otherlv_4= ']' )? otherlv_5= ':' ( (otherlv_6= RULE_ID ) ) ) )
            // InternalForml.g:1855:1: ( () ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_multiplicity_3_0= ruleMultiplicity ) ) otherlv_4= ']' )? otherlv_5= ':' ( (otherlv_6= RULE_ID ) ) )
            {
            // InternalForml.g:1855:1: ( () ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_multiplicity_3_0= ruleMultiplicity ) ) otherlv_4= ']' )? otherlv_5= ':' ( (otherlv_6= RULE_ID ) ) )
            // InternalForml.g:1855:2: () ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_multiplicity_3_0= ruleMultiplicity ) ) otherlv_4= ']' )? otherlv_5= ':' ( (otherlv_6= RULE_ID ) )
            {
            // InternalForml.g:1855:2: ()
            // InternalForml.g:1856:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getDeclAccess().getDeclAction_0(),
                        current);
                

            }

            // InternalForml.g:1861:2: ( (lv_name_1_0= RULE_ID ) )
            // InternalForml.g:1862:1: (lv_name_1_0= RULE_ID )
            {
            // InternalForml.g:1862:1: (lv_name_1_0= RULE_ID )
            // InternalForml.g:1863:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_19); 

            			newLeafNode(lv_name_1_0, grammarAccess.getDeclAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getDeclRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            // InternalForml.g:1879:2: (otherlv_2= '[' ( (lv_multiplicity_3_0= ruleMultiplicity ) ) otherlv_4= ']' )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==21) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalForml.g:1879:4: otherlv_2= '[' ( (lv_multiplicity_3_0= ruleMultiplicity ) ) otherlv_4= ']'
                    {
                    otherlv_2=(Token)match(input,21,FOLLOW_20); 

                        	newLeafNode(otherlv_2, grammarAccess.getDeclAccess().getLeftSquareBracketKeyword_2_0());
                        
                    // InternalForml.g:1883:1: ( (lv_multiplicity_3_0= ruleMultiplicity ) )
                    // InternalForml.g:1884:1: (lv_multiplicity_3_0= ruleMultiplicity )
                    {
                    // InternalForml.g:1884:1: (lv_multiplicity_3_0= ruleMultiplicity )
                    // InternalForml.g:1885:3: lv_multiplicity_3_0= ruleMultiplicity
                    {
                     
                    	        newCompositeNode(grammarAccess.getDeclAccess().getMultiplicityMultiplicityParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_21);
                    lv_multiplicity_3_0=ruleMultiplicity();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getDeclRule());
                    	        }
                           		set(
                           			current, 
                           			"multiplicity",
                            		lv_multiplicity_3_0, 
                            		"uw.cs.watform.forml.Forml.Multiplicity");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_4=(Token)match(input,22,FOLLOW_22); 

                        	newLeafNode(otherlv_4, grammarAccess.getDeclAccess().getRightSquareBracketKeyword_2_2());
                        

                    }
                    break;

            }

            otherlv_5=(Token)match(input,23,FOLLOW_10); 

                	newLeafNode(otherlv_5, grammarAccess.getDeclAccess().getColonKeyword_3());
                
            // InternalForml.g:1909:1: ( (otherlv_6= RULE_ID ) )
            // InternalForml.g:1910:1: (otherlv_6= RULE_ID )
            {
            // InternalForml.g:1910:1: (otherlv_6= RULE_ID )
            // InternalForml.g:1911:3: otherlv_6= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getDeclRule());
            	        }
                    
            otherlv_6=(Token)match(input,RULE_ID,FOLLOW_2); 

            		newLeafNode(otherlv_6, grammarAccess.getDeclAccess().getTypeEntityCrossReference_4_0()); 
            	

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDecl"


    // $ANTLR start "entryRuleMessage"
    // InternalForml.g:1934:1: entryRuleMessage returns [EObject current=null] : iv_ruleMessage= ruleMessage EOF ;
    public final EObject entryRuleMessage() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMessage = null;


        try {
            // InternalForml.g:1935:2: (iv_ruleMessage= ruleMessage EOF )
            // InternalForml.g:1936:2: iv_ruleMessage= ruleMessage EOF
            {
             newCompositeNode(grammarAccess.getMessageRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMessage=ruleMessage();

            state._fsp--;

             current =iv_ruleMessage; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMessage"


    // $ANTLR start "ruleMessage"
    // InternalForml.g:1943:1: ruleMessage returns [EObject current=null] : (this_Input_0= ruleInput | this_Output_1= ruleOutput ) ;
    public final EObject ruleMessage() throws RecognitionException {
        EObject current = null;

        EObject this_Input_0 = null;

        EObject this_Output_1 = null;


         enterRule(); 
            
        try {
            // InternalForml.g:1946:28: ( (this_Input_0= ruleInput | this_Output_1= ruleOutput ) )
            // InternalForml.g:1947:1: (this_Input_0= ruleInput | this_Output_1= ruleOutput )
            {
            // InternalForml.g:1947:1: (this_Input_0= ruleInput | this_Output_1= ruleOutput )
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==39) ) {
                alt36=1;
            }
            else if ( (LA36_0==42) ) {
                alt36=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }
            switch (alt36) {
                case 1 :
                    // InternalForml.g:1948:5: this_Input_0= ruleInput
                    {
                     
                            newCompositeNode(grammarAccess.getMessageAccess().getInputParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_2);
                    this_Input_0=ruleInput();

                    state._fsp--;

                     
                            current = this_Input_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalForml.g:1958:5: this_Output_1= ruleOutput
                    {
                     
                            newCompositeNode(grammarAccess.getMessageAccess().getOutputParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_2);
                    this_Output_1=ruleOutput();

                    state._fsp--;

                     
                            current = this_Output_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMessage"


    // $ANTLR start "entryRuleInput"
    // InternalForml.g:1974:1: entryRuleInput returns [EObject current=null] : iv_ruleInput= ruleInput EOF ;
    public final EObject entryRuleInput() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInput = null;


        try {
            // InternalForml.g:1975:2: (iv_ruleInput= ruleInput EOF )
            // InternalForml.g:1976:2: iv_ruleInput= ruleInput EOF
            {
             newCompositeNode(grammarAccess.getInputRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInput=ruleInput();

            state._fsp--;

             current =iv_ruleInput; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInput"


    // $ANTLR start "ruleInput"
    // InternalForml.g:1983:1: ruleInput returns [EObject current=null] : ( () otherlv_1= 'input' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' (otherlv_4= 'type' ( (lv_type_5_0= ruleAttributeType ) ) )? ( (lv_attributes_6_0= ruleAttribute ) )* (otherlv_7= 'to' ( (otherlv_8= RULE_ID ) )* )? otherlv_9= '}' ) ;
    public final EObject ruleInput() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        EObject lv_type_5_0 = null;

        EObject lv_attributes_6_0 = null;


         enterRule(); 
            
        try {
            // InternalForml.g:1986:28: ( ( () otherlv_1= 'input' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' (otherlv_4= 'type' ( (lv_type_5_0= ruleAttributeType ) ) )? ( (lv_attributes_6_0= ruleAttribute ) )* (otherlv_7= 'to' ( (otherlv_8= RULE_ID ) )* )? otherlv_9= '}' ) )
            // InternalForml.g:1987:1: ( () otherlv_1= 'input' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' (otherlv_4= 'type' ( (lv_type_5_0= ruleAttributeType ) ) )? ( (lv_attributes_6_0= ruleAttribute ) )* (otherlv_7= 'to' ( (otherlv_8= RULE_ID ) )* )? otherlv_9= '}' )
            {
            // InternalForml.g:1987:1: ( () otherlv_1= 'input' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' (otherlv_4= 'type' ( (lv_type_5_0= ruleAttributeType ) ) )? ( (lv_attributes_6_0= ruleAttribute ) )* (otherlv_7= 'to' ( (otherlv_8= RULE_ID ) )* )? otherlv_9= '}' )
            // InternalForml.g:1987:2: () otherlv_1= 'input' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' (otherlv_4= 'type' ( (lv_type_5_0= ruleAttributeType ) ) )? ( (lv_attributes_6_0= ruleAttribute ) )* (otherlv_7= 'to' ( (otherlv_8= RULE_ID ) )* )? otherlv_9= '}'
            {
            // InternalForml.g:1987:2: ()
            // InternalForml.g:1988:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getInputAccess().getInputAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,39,FOLLOW_10); 

                	newLeafNode(otherlv_1, grammarAccess.getInputAccess().getInputKeyword_1());
                
            // InternalForml.g:1997:1: ( (lv_name_2_0= RULE_ID ) )
            // InternalForml.g:1998:1: (lv_name_2_0= RULE_ID )
            {
            // InternalForml.g:1998:1: (lv_name_2_0= RULE_ID )
            // InternalForml.g:1999:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            			newLeafNode(lv_name_2_0, grammarAccess.getInputAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getInputRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            otherlv_3=(Token)match(input,12,FOLLOW_29); 

                	newLeafNode(otherlv_3, grammarAccess.getInputAccess().getLeftCurlyBracketKeyword_3());
                
            // InternalForml.g:2019:1: (otherlv_4= 'type' ( (lv_type_5_0= ruleAttributeType ) ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==40) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalForml.g:2019:3: otherlv_4= 'type' ( (lv_type_5_0= ruleAttributeType ) )
                    {
                    otherlv_4=(Token)match(input,40,FOLLOW_30); 

                        	newLeafNode(otherlv_4, grammarAccess.getInputAccess().getTypeKeyword_4_0());
                        
                    // InternalForml.g:2023:1: ( (lv_type_5_0= ruleAttributeType ) )
                    // InternalForml.g:2024:1: (lv_type_5_0= ruleAttributeType )
                    {
                    // InternalForml.g:2024:1: (lv_type_5_0= ruleAttributeType )
                    // InternalForml.g:2025:3: lv_type_5_0= ruleAttributeType
                    {
                     
                    	        newCompositeNode(grammarAccess.getInputAccess().getTypeAttributeTypeParserRuleCall_4_1_0()); 
                    	    
                    pushFollow(FOLLOW_31);
                    lv_type_5_0=ruleAttributeType();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getInputRule());
                    	        }
                           		set(
                           			current, 
                           			"type",
                            		lv_type_5_0, 
                            		"uw.cs.watform.forml.Forml.AttributeType");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // InternalForml.g:2041:4: ( (lv_attributes_6_0= ruleAttribute ) )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==16||LA38_0==20) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // InternalForml.g:2042:1: (lv_attributes_6_0= ruleAttribute )
            	    {
            	    // InternalForml.g:2042:1: (lv_attributes_6_0= ruleAttribute )
            	    // InternalForml.g:2043:3: lv_attributes_6_0= ruleAttribute
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getInputAccess().getAttributesAttributeParserRuleCall_5_0()); 
            	    	    
            	    pushFollow(FOLLOW_31);
            	    lv_attributes_6_0=ruleAttribute();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getInputRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"attributes",
            	            		lv_attributes_6_0, 
            	            		"uw.cs.watform.forml.Forml.Attribute");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop38;
                }
            } while (true);

            // InternalForml.g:2059:3: (otherlv_7= 'to' ( (otherlv_8= RULE_ID ) )* )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==41) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // InternalForml.g:2059:5: otherlv_7= 'to' ( (otherlv_8= RULE_ID ) )*
                    {
                    otherlv_7=(Token)match(input,41,FOLLOW_32); 

                        	newLeafNode(otherlv_7, grammarAccess.getInputAccess().getToKeyword_6_0());
                        
                    // InternalForml.g:2063:1: ( (otherlv_8= RULE_ID ) )*
                    loop39:
                    do {
                        int alt39=2;
                        int LA39_0 = input.LA(1);

                        if ( (LA39_0==RULE_ID) ) {
                            alt39=1;
                        }


                        switch (alt39) {
                    	case 1 :
                    	    // InternalForml.g:2064:1: (otherlv_8= RULE_ID )
                    	    {
                    	    // InternalForml.g:2064:1: (otherlv_8= RULE_ID )
                    	    // InternalForml.g:2065:3: otherlv_8= RULE_ID
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getInputRule());
                    	    	        }
                    	            
                    	    otherlv_8=(Token)match(input,RULE_ID,FOLLOW_32); 

                    	    		newLeafNode(otherlv_8, grammarAccess.getInputAccess().getTosFeatureCrossReference_6_1_0()); 
                    	    	

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop39;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_9=(Token)match(input,13,FOLLOW_2); 

                	newLeafNode(otherlv_9, grammarAccess.getInputAccess().getRightCurlyBracketKeyword_7());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInput"


    // $ANTLR start "entryRuleOutput"
    // InternalForml.g:2088:1: entryRuleOutput returns [EObject current=null] : iv_ruleOutput= ruleOutput EOF ;
    public final EObject entryRuleOutput() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOutput = null;


        try {
            // InternalForml.g:2089:2: (iv_ruleOutput= ruleOutput EOF )
            // InternalForml.g:2090:2: iv_ruleOutput= ruleOutput EOF
            {
             newCompositeNode(grammarAccess.getOutputRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOutput=ruleOutput();

            state._fsp--;

             current =iv_ruleOutput; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOutput"


    // $ANTLR start "ruleOutput"
    // InternalForml.g:2097:1: ruleOutput returns [EObject current=null] : ( () otherlv_1= 'output' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' (otherlv_4= 'type' ( (lv_type_5_0= ruleAttributeType ) ) )? ( (lv_attributes_6_0= ruleAttribute ) )* (otherlv_7= 'from' ( (otherlv_8= RULE_ID ) )* )? otherlv_9= '}' ) ;
    public final EObject ruleOutput() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        EObject lv_type_5_0 = null;

        EObject lv_attributes_6_0 = null;


         enterRule(); 
            
        try {
            // InternalForml.g:2100:28: ( ( () otherlv_1= 'output' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' (otherlv_4= 'type' ( (lv_type_5_0= ruleAttributeType ) ) )? ( (lv_attributes_6_0= ruleAttribute ) )* (otherlv_7= 'from' ( (otherlv_8= RULE_ID ) )* )? otherlv_9= '}' ) )
            // InternalForml.g:2101:1: ( () otherlv_1= 'output' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' (otherlv_4= 'type' ( (lv_type_5_0= ruleAttributeType ) ) )? ( (lv_attributes_6_0= ruleAttribute ) )* (otherlv_7= 'from' ( (otherlv_8= RULE_ID ) )* )? otherlv_9= '}' )
            {
            // InternalForml.g:2101:1: ( () otherlv_1= 'output' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' (otherlv_4= 'type' ( (lv_type_5_0= ruleAttributeType ) ) )? ( (lv_attributes_6_0= ruleAttribute ) )* (otherlv_7= 'from' ( (otherlv_8= RULE_ID ) )* )? otherlv_9= '}' )
            // InternalForml.g:2101:2: () otherlv_1= 'output' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' (otherlv_4= 'type' ( (lv_type_5_0= ruleAttributeType ) ) )? ( (lv_attributes_6_0= ruleAttribute ) )* (otherlv_7= 'from' ( (otherlv_8= RULE_ID ) )* )? otherlv_9= '}'
            {
            // InternalForml.g:2101:2: ()
            // InternalForml.g:2102:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getOutputAccess().getOutputAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,42,FOLLOW_10); 

                	newLeafNode(otherlv_1, grammarAccess.getOutputAccess().getOutputKeyword_1());
                
            // InternalForml.g:2111:1: ( (lv_name_2_0= RULE_ID ) )
            // InternalForml.g:2112:1: (lv_name_2_0= RULE_ID )
            {
            // InternalForml.g:2112:1: (lv_name_2_0= RULE_ID )
            // InternalForml.g:2113:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            			newLeafNode(lv_name_2_0, grammarAccess.getOutputAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getOutputRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            otherlv_3=(Token)match(input,12,FOLLOW_33); 

                	newLeafNode(otherlv_3, grammarAccess.getOutputAccess().getLeftCurlyBracketKeyword_3());
                
            // InternalForml.g:2133:1: (otherlv_4= 'type' ( (lv_type_5_0= ruleAttributeType ) ) )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==40) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalForml.g:2133:3: otherlv_4= 'type' ( (lv_type_5_0= ruleAttributeType ) )
                    {
                    otherlv_4=(Token)match(input,40,FOLLOW_30); 

                        	newLeafNode(otherlv_4, grammarAccess.getOutputAccess().getTypeKeyword_4_0());
                        
                    // InternalForml.g:2137:1: ( (lv_type_5_0= ruleAttributeType ) )
                    // InternalForml.g:2138:1: (lv_type_5_0= ruleAttributeType )
                    {
                    // InternalForml.g:2138:1: (lv_type_5_0= ruleAttributeType )
                    // InternalForml.g:2139:3: lv_type_5_0= ruleAttributeType
                    {
                     
                    	        newCompositeNode(grammarAccess.getOutputAccess().getTypeAttributeTypeParserRuleCall_4_1_0()); 
                    	    
                    pushFollow(FOLLOW_34);
                    lv_type_5_0=ruleAttributeType();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getOutputRule());
                    	        }
                           		set(
                           			current, 
                           			"type",
                            		lv_type_5_0, 
                            		"uw.cs.watform.forml.Forml.AttributeType");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // InternalForml.g:2155:4: ( (lv_attributes_6_0= ruleAttribute ) )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==16||LA42_0==20) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // InternalForml.g:2156:1: (lv_attributes_6_0= ruleAttribute )
            	    {
            	    // InternalForml.g:2156:1: (lv_attributes_6_0= ruleAttribute )
            	    // InternalForml.g:2157:3: lv_attributes_6_0= ruleAttribute
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getOutputAccess().getAttributesAttributeParserRuleCall_5_0()); 
            	    	    
            	    pushFollow(FOLLOW_34);
            	    lv_attributes_6_0=ruleAttribute();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getOutputRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"attributes",
            	            		lv_attributes_6_0, 
            	            		"uw.cs.watform.forml.Forml.Attribute");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop42;
                }
            } while (true);

            // InternalForml.g:2173:3: (otherlv_7= 'from' ( (otherlv_8= RULE_ID ) )* )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==43) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // InternalForml.g:2173:5: otherlv_7= 'from' ( (otherlv_8= RULE_ID ) )*
                    {
                    otherlv_7=(Token)match(input,43,FOLLOW_32); 

                        	newLeafNode(otherlv_7, grammarAccess.getOutputAccess().getFromKeyword_6_0());
                        
                    // InternalForml.g:2177:1: ( (otherlv_8= RULE_ID ) )*
                    loop43:
                    do {
                        int alt43=2;
                        int LA43_0 = input.LA(1);

                        if ( (LA43_0==RULE_ID) ) {
                            alt43=1;
                        }


                        switch (alt43) {
                    	case 1 :
                    	    // InternalForml.g:2178:1: (otherlv_8= RULE_ID )
                    	    {
                    	    // InternalForml.g:2178:1: (otherlv_8= RULE_ID )
                    	    // InternalForml.g:2179:3: otherlv_8= RULE_ID
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getOutputRule());
                    	    	        }
                    	            
                    	    otherlv_8=(Token)match(input,RULE_ID,FOLLOW_32); 

                    	    		newLeafNode(otherlv_8, grammarAccess.getOutputAccess().getFromsFeatureCrossReference_6_1_0()); 
                    	    	

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop43;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_9=(Token)match(input,13,FOLLOW_2); 

                	newLeafNode(otherlv_9, grammarAccess.getOutputAccess().getRightCurlyBracketKeyword_7());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOutput"


    // $ANTLR start "entryRuleInputList"
    // InternalForml.g:2202:1: entryRuleInputList returns [EObject current=null] : iv_ruleInputList= ruleInputList EOF ;
    public final EObject entryRuleInputList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInputList = null;


        try {
            // InternalForml.g:2203:2: (iv_ruleInputList= ruleInputList EOF )
            // InternalForml.g:2204:2: iv_ruleInputList= ruleInputList EOF
            {
             newCompositeNode(grammarAccess.getInputListRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInputList=ruleInputList();

            state._fsp--;

             current =iv_ruleInputList; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInputList"


    // $ANTLR start "ruleInputList"
    // InternalForml.g:2211:1: ruleInputList returns [EObject current=null] : ( () otherlv_1= 'inputs' otherlv_2= '{' ( ( (lv_inputs_3_0= ruleRefMessage ) ) (otherlv_4= ',' ( (lv_inputs_5_0= ruleRefMessage ) ) )* )? otherlv_6= '}' ) ;
    public final EObject ruleInputList() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_inputs_3_0 = null;

        EObject lv_inputs_5_0 = null;


         enterRule(); 
            
        try {
            // InternalForml.g:2214:28: ( ( () otherlv_1= 'inputs' otherlv_2= '{' ( ( (lv_inputs_3_0= ruleRefMessage ) ) (otherlv_4= ',' ( (lv_inputs_5_0= ruleRefMessage ) ) )* )? otherlv_6= '}' ) )
            // InternalForml.g:2215:1: ( () otherlv_1= 'inputs' otherlv_2= '{' ( ( (lv_inputs_3_0= ruleRefMessage ) ) (otherlv_4= ',' ( (lv_inputs_5_0= ruleRefMessage ) ) )* )? otherlv_6= '}' )
            {
            // InternalForml.g:2215:1: ( () otherlv_1= 'inputs' otherlv_2= '{' ( ( (lv_inputs_3_0= ruleRefMessage ) ) (otherlv_4= ',' ( (lv_inputs_5_0= ruleRefMessage ) ) )* )? otherlv_6= '}' )
            // InternalForml.g:2215:2: () otherlv_1= 'inputs' otherlv_2= '{' ( ( (lv_inputs_3_0= ruleRefMessage ) ) (otherlv_4= ',' ( (lv_inputs_5_0= ruleRefMessage ) ) )* )? otherlv_6= '}'
            {
            // InternalForml.g:2215:2: ()
            // InternalForml.g:2216:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getInputListAccess().getInputListAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,44,FOLLOW_4); 

                	newLeafNode(otherlv_1, grammarAccess.getInputListAccess().getInputsKeyword_1());
                
            otherlv_2=(Token)match(input,12,FOLLOW_32); 

                	newLeafNode(otherlv_2, grammarAccess.getInputListAccess().getLeftCurlyBracketKeyword_2());
                
            // InternalForml.g:2229:1: ( ( (lv_inputs_3_0= ruleRefMessage ) ) (otherlv_4= ',' ( (lv_inputs_5_0= ruleRefMessage ) ) )* )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==RULE_ID) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // InternalForml.g:2229:2: ( (lv_inputs_3_0= ruleRefMessage ) ) (otherlv_4= ',' ( (lv_inputs_5_0= ruleRefMessage ) ) )*
                    {
                    // InternalForml.g:2229:2: ( (lv_inputs_3_0= ruleRefMessage ) )
                    // InternalForml.g:2230:1: (lv_inputs_3_0= ruleRefMessage )
                    {
                    // InternalForml.g:2230:1: (lv_inputs_3_0= ruleRefMessage )
                    // InternalForml.g:2231:3: lv_inputs_3_0= ruleRefMessage
                    {
                     
                    	        newCompositeNode(grammarAccess.getInputListAccess().getInputsRefMessageParserRuleCall_3_0_0()); 
                    	    
                    pushFollow(FOLLOW_35);
                    lv_inputs_3_0=ruleRefMessage();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getInputListRule());
                    	        }
                           		add(
                           			current, 
                           			"inputs",
                            		lv_inputs_3_0, 
                            		"uw.cs.watform.forml.Forml.RefMessage");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // InternalForml.g:2247:2: (otherlv_4= ',' ( (lv_inputs_5_0= ruleRefMessage ) ) )*
                    loop45:
                    do {
                        int alt45=2;
                        int LA45_0 = input.LA(1);

                        if ( (LA45_0==45) ) {
                            alt45=1;
                        }


                        switch (alt45) {
                    	case 1 :
                    	    // InternalForml.g:2247:4: otherlv_4= ',' ( (lv_inputs_5_0= ruleRefMessage ) )
                    	    {
                    	    otherlv_4=(Token)match(input,45,FOLLOW_10); 

                    	        	newLeafNode(otherlv_4, grammarAccess.getInputListAccess().getCommaKeyword_3_1_0());
                    	        
                    	    // InternalForml.g:2251:1: ( (lv_inputs_5_0= ruleRefMessage ) )
                    	    // InternalForml.g:2252:1: (lv_inputs_5_0= ruleRefMessage )
                    	    {
                    	    // InternalForml.g:2252:1: (lv_inputs_5_0= ruleRefMessage )
                    	    // InternalForml.g:2253:3: lv_inputs_5_0= ruleRefMessage
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getInputListAccess().getInputsRefMessageParserRuleCall_3_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_35);
                    	    lv_inputs_5_0=ruleRefMessage();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getInputListRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"inputs",
                    	            		lv_inputs_5_0, 
                    	            		"uw.cs.watform.forml.Forml.RefMessage");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop45;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,13,FOLLOW_2); 

                	newLeafNode(otherlv_6, grammarAccess.getInputListAccess().getRightCurlyBracketKeyword_4());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInputList"


    // $ANTLR start "entryRuleOutputList"
    // InternalForml.g:2281:1: entryRuleOutputList returns [EObject current=null] : iv_ruleOutputList= ruleOutputList EOF ;
    public final EObject entryRuleOutputList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOutputList = null;


        try {
            // InternalForml.g:2282:2: (iv_ruleOutputList= ruleOutputList EOF )
            // InternalForml.g:2283:2: iv_ruleOutputList= ruleOutputList EOF
            {
             newCompositeNode(grammarAccess.getOutputListRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOutputList=ruleOutputList();

            state._fsp--;

             current =iv_ruleOutputList; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOutputList"


    // $ANTLR start "ruleOutputList"
    // InternalForml.g:2290:1: ruleOutputList returns [EObject current=null] : ( () otherlv_1= 'outputs' otherlv_2= '{' ( ( (lv_outputs_3_0= ruleRefMessage ) ) (otherlv_4= ',' ( (lv_outputs_5_0= ruleRefMessage ) ) )* )? otherlv_6= '}' ) ;
    public final EObject ruleOutputList() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_outputs_3_0 = null;

        EObject lv_outputs_5_0 = null;


         enterRule(); 
            
        try {
            // InternalForml.g:2293:28: ( ( () otherlv_1= 'outputs' otherlv_2= '{' ( ( (lv_outputs_3_0= ruleRefMessage ) ) (otherlv_4= ',' ( (lv_outputs_5_0= ruleRefMessage ) ) )* )? otherlv_6= '}' ) )
            // InternalForml.g:2294:1: ( () otherlv_1= 'outputs' otherlv_2= '{' ( ( (lv_outputs_3_0= ruleRefMessage ) ) (otherlv_4= ',' ( (lv_outputs_5_0= ruleRefMessage ) ) )* )? otherlv_6= '}' )
            {
            // InternalForml.g:2294:1: ( () otherlv_1= 'outputs' otherlv_2= '{' ( ( (lv_outputs_3_0= ruleRefMessage ) ) (otherlv_4= ',' ( (lv_outputs_5_0= ruleRefMessage ) ) )* )? otherlv_6= '}' )
            // InternalForml.g:2294:2: () otherlv_1= 'outputs' otherlv_2= '{' ( ( (lv_outputs_3_0= ruleRefMessage ) ) (otherlv_4= ',' ( (lv_outputs_5_0= ruleRefMessage ) ) )* )? otherlv_6= '}'
            {
            // InternalForml.g:2294:2: ()
            // InternalForml.g:2295:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getOutputListAccess().getOutputListAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,46,FOLLOW_4); 

                	newLeafNode(otherlv_1, grammarAccess.getOutputListAccess().getOutputsKeyword_1());
                
            otherlv_2=(Token)match(input,12,FOLLOW_32); 

                	newLeafNode(otherlv_2, grammarAccess.getOutputListAccess().getLeftCurlyBracketKeyword_2());
                
            // InternalForml.g:2308:1: ( ( (lv_outputs_3_0= ruleRefMessage ) ) (otherlv_4= ',' ( (lv_outputs_5_0= ruleRefMessage ) ) )* )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==RULE_ID) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // InternalForml.g:2308:2: ( (lv_outputs_3_0= ruleRefMessage ) ) (otherlv_4= ',' ( (lv_outputs_5_0= ruleRefMessage ) ) )*
                    {
                    // InternalForml.g:2308:2: ( (lv_outputs_3_0= ruleRefMessage ) )
                    // InternalForml.g:2309:1: (lv_outputs_3_0= ruleRefMessage )
                    {
                    // InternalForml.g:2309:1: (lv_outputs_3_0= ruleRefMessage )
                    // InternalForml.g:2310:3: lv_outputs_3_0= ruleRefMessage
                    {
                     
                    	        newCompositeNode(grammarAccess.getOutputListAccess().getOutputsRefMessageParserRuleCall_3_0_0()); 
                    	    
                    pushFollow(FOLLOW_35);
                    lv_outputs_3_0=ruleRefMessage();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getOutputListRule());
                    	        }
                           		add(
                           			current, 
                           			"outputs",
                            		lv_outputs_3_0, 
                            		"uw.cs.watform.forml.Forml.RefMessage");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // InternalForml.g:2326:2: (otherlv_4= ',' ( (lv_outputs_5_0= ruleRefMessage ) ) )*
                    loop47:
                    do {
                        int alt47=2;
                        int LA47_0 = input.LA(1);

                        if ( (LA47_0==45) ) {
                            alt47=1;
                        }


                        switch (alt47) {
                    	case 1 :
                    	    // InternalForml.g:2326:4: otherlv_4= ',' ( (lv_outputs_5_0= ruleRefMessage ) )
                    	    {
                    	    otherlv_4=(Token)match(input,45,FOLLOW_10); 

                    	        	newLeafNode(otherlv_4, grammarAccess.getOutputListAccess().getCommaKeyword_3_1_0());
                    	        
                    	    // InternalForml.g:2330:1: ( (lv_outputs_5_0= ruleRefMessage ) )
                    	    // InternalForml.g:2331:1: (lv_outputs_5_0= ruleRefMessage )
                    	    {
                    	    // InternalForml.g:2331:1: (lv_outputs_5_0= ruleRefMessage )
                    	    // InternalForml.g:2332:3: lv_outputs_5_0= ruleRefMessage
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getOutputListAccess().getOutputsRefMessageParserRuleCall_3_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_35);
                    	    lv_outputs_5_0=ruleRefMessage();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getOutputListRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"outputs",
                    	            		lv_outputs_5_0, 
                    	            		"uw.cs.watform.forml.Forml.RefMessage");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop47;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,13,FOLLOW_2); 

                	newLeafNode(otherlv_6, grammarAccess.getOutputListAccess().getRightCurlyBracketKeyword_4());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOutputList"


    // $ANTLR start "entryRuleRefMessage"
    // InternalForml.g:2360:1: entryRuleRefMessage returns [EObject current=null] : iv_ruleRefMessage= ruleRefMessage EOF ;
    public final EObject entryRuleRefMessage() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRefMessage = null;


        try {
            // InternalForml.g:2361:2: (iv_ruleRefMessage= ruleRefMessage EOF )
            // InternalForml.g:2362:2: iv_ruleRefMessage= ruleRefMessage EOF
            {
             newCompositeNode(grammarAccess.getRefMessageRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRefMessage=ruleRefMessage();

            state._fsp--;

             current =iv_ruleRefMessage; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRefMessage"


    // $ANTLR start "ruleRefMessage"
    // InternalForml.g:2369:1: ruleRefMessage returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleRefMessage() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // InternalForml.g:2372:28: ( ( () ( (otherlv_1= RULE_ID ) ) ) )
            // InternalForml.g:2373:1: ( () ( (otherlv_1= RULE_ID ) ) )
            {
            // InternalForml.g:2373:1: ( () ( (otherlv_1= RULE_ID ) ) )
            // InternalForml.g:2373:2: () ( (otherlv_1= RULE_ID ) )
            {
            // InternalForml.g:2373:2: ()
            // InternalForml.g:2374:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getRefMessageAccess().getRefMessageAction_0(),
                        current);
                

            }

            // InternalForml.g:2379:2: ( (otherlv_1= RULE_ID ) )
            // InternalForml.g:2380:1: (otherlv_1= RULE_ID )
            {
            // InternalForml.g:2380:1: (otherlv_1= RULE_ID )
            // InternalForml.g:2381:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getRefMessageRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_2); 

            		newLeafNode(otherlv_1, grammarAccess.getRefMessageAccess().getRefMsgMessageCrossReference_1_0()); 
            	

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRefMessage"


    // $ANTLR start "entryRuleFeature"
    // InternalForml.g:2400:1: entryRuleFeature returns [EObject current=null] : iv_ruleFeature= ruleFeature EOF ;
    public final EObject entryRuleFeature() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeature = null;


        try {
            // InternalForml.g:2401:2: (iv_ruleFeature= ruleFeature EOF )
            // InternalForml.g:2402:2: iv_ruleFeature= ruleFeature EOF
            {
             newCompositeNode(grammarAccess.getFeatureRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFeature=ruleFeature();

            state._fsp--;

             current =iv_ruleFeature; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFeature"


    // $ANTLR start "ruleFeature"
    // InternalForml.g:2409:1: ruleFeature returns [EObject current=null] : ( () otherlv_1= 'feature' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '{' ( ( (lv_attributes_4_0= ruleAttribute ) )* ( (lv_inputlist_5_0= ruleInputList ) )? ( (lv_outputlist_6_0= ruleOutputList ) )? ) otherlv_7= '}' )? ) ;
    public final EObject ruleFeature() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_7=null;
        EObject lv_attributes_4_0 = null;

        EObject lv_inputlist_5_0 = null;

        EObject lv_outputlist_6_0 = null;


         enterRule(); 
            
        try {
            // InternalForml.g:2412:28: ( ( () otherlv_1= 'feature' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '{' ( ( (lv_attributes_4_0= ruleAttribute ) )* ( (lv_inputlist_5_0= ruleInputList ) )? ( (lv_outputlist_6_0= ruleOutputList ) )? ) otherlv_7= '}' )? ) )
            // InternalForml.g:2413:1: ( () otherlv_1= 'feature' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '{' ( ( (lv_attributes_4_0= ruleAttribute ) )* ( (lv_inputlist_5_0= ruleInputList ) )? ( (lv_outputlist_6_0= ruleOutputList ) )? ) otherlv_7= '}' )? )
            {
            // InternalForml.g:2413:1: ( () otherlv_1= 'feature' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '{' ( ( (lv_attributes_4_0= ruleAttribute ) )* ( (lv_inputlist_5_0= ruleInputList ) )? ( (lv_outputlist_6_0= ruleOutputList ) )? ) otherlv_7= '}' )? )
            // InternalForml.g:2413:2: () otherlv_1= 'feature' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '{' ( ( (lv_attributes_4_0= ruleAttribute ) )* ( (lv_inputlist_5_0= ruleInputList ) )? ( (lv_outputlist_6_0= ruleOutputList ) )? ) otherlv_7= '}' )?
            {
            // InternalForml.g:2413:2: ()
            // InternalForml.g:2414:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getFeatureAccess().getFeatureAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,47,FOLLOW_10); 

                	newLeafNode(otherlv_1, grammarAccess.getFeatureAccess().getFeatureKeyword_1());
                
            // InternalForml.g:2423:1: ( (lv_name_2_0= RULE_ID ) )
            // InternalForml.g:2424:1: (lv_name_2_0= RULE_ID )
            {
            // InternalForml.g:2424:1: (lv_name_2_0= RULE_ID )
            // InternalForml.g:2425:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_12); 

            			newLeafNode(lv_name_2_0, grammarAccess.getFeatureAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getFeatureRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            // InternalForml.g:2441:2: (otherlv_3= '{' ( ( (lv_attributes_4_0= ruleAttribute ) )* ( (lv_inputlist_5_0= ruleInputList ) )? ( (lv_outputlist_6_0= ruleOutputList ) )? ) otherlv_7= '}' )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==12) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // InternalForml.g:2441:4: otherlv_3= '{' ( ( (lv_attributes_4_0= ruleAttribute ) )* ( (lv_inputlist_5_0= ruleInputList ) )? ( (lv_outputlist_6_0= ruleOutputList ) )? ) otherlv_7= '}'
                    {
                    otherlv_3=(Token)match(input,12,FOLLOW_36); 

                        	newLeafNode(otherlv_3, grammarAccess.getFeatureAccess().getLeftCurlyBracketKeyword_3_0());
                        
                    // InternalForml.g:2445:1: ( ( (lv_attributes_4_0= ruleAttribute ) )* ( (lv_inputlist_5_0= ruleInputList ) )? ( (lv_outputlist_6_0= ruleOutputList ) )? )
                    // InternalForml.g:2445:2: ( (lv_attributes_4_0= ruleAttribute ) )* ( (lv_inputlist_5_0= ruleInputList ) )? ( (lv_outputlist_6_0= ruleOutputList ) )?
                    {
                    // InternalForml.g:2445:2: ( (lv_attributes_4_0= ruleAttribute ) )*
                    loop49:
                    do {
                        int alt49=2;
                        int LA49_0 = input.LA(1);

                        if ( (LA49_0==16||LA49_0==20) ) {
                            alt49=1;
                        }


                        switch (alt49) {
                    	case 1 :
                    	    // InternalForml.g:2446:1: (lv_attributes_4_0= ruleAttribute )
                    	    {
                    	    // InternalForml.g:2446:1: (lv_attributes_4_0= ruleAttribute )
                    	    // InternalForml.g:2447:3: lv_attributes_4_0= ruleAttribute
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getFeatureAccess().getAttributesAttributeParserRuleCall_3_1_0_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_36);
                    	    lv_attributes_4_0=ruleAttribute();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getFeatureRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"attributes",
                    	            		lv_attributes_4_0, 
                    	            		"uw.cs.watform.forml.Forml.Attribute");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop49;
                        }
                    } while (true);

                    // InternalForml.g:2463:3: ( (lv_inputlist_5_0= ruleInputList ) )?
                    int alt50=2;
                    int LA50_0 = input.LA(1);

                    if ( (LA50_0==44) ) {
                        alt50=1;
                    }
                    switch (alt50) {
                        case 1 :
                            // InternalForml.g:2464:1: (lv_inputlist_5_0= ruleInputList )
                            {
                            // InternalForml.g:2464:1: (lv_inputlist_5_0= ruleInputList )
                            // InternalForml.g:2465:3: lv_inputlist_5_0= ruleInputList
                            {
                             
                            	        newCompositeNode(grammarAccess.getFeatureAccess().getInputlistInputListParserRuleCall_3_1_1_0()); 
                            	    
                            pushFollow(FOLLOW_37);
                            lv_inputlist_5_0=ruleInputList();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getFeatureRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"inputlist",
                                    		lv_inputlist_5_0, 
                                    		"uw.cs.watform.forml.Forml.InputList");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }
                            break;

                    }

                    // InternalForml.g:2481:3: ( (lv_outputlist_6_0= ruleOutputList ) )?
                    int alt51=2;
                    int LA51_0 = input.LA(1);

                    if ( (LA51_0==46) ) {
                        alt51=1;
                    }
                    switch (alt51) {
                        case 1 :
                            // InternalForml.g:2482:1: (lv_outputlist_6_0= ruleOutputList )
                            {
                            // InternalForml.g:2482:1: (lv_outputlist_6_0= ruleOutputList )
                            // InternalForml.g:2483:3: lv_outputlist_6_0= ruleOutputList
                            {
                             
                            	        newCompositeNode(grammarAccess.getFeatureAccess().getOutputlistOutputListParserRuleCall_3_1_2_0()); 
                            	    
                            pushFollow(FOLLOW_6);
                            lv_outputlist_6_0=ruleOutputList();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getFeatureRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"outputlist",
                                    		lv_outputlist_6_0, 
                                    		"uw.cs.watform.forml.Forml.OutputList");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }
                            break;

                    }


                    }

                    otherlv_7=(Token)match(input,13,FOLLOW_2); 

                        	newLeafNode(otherlv_7, grammarAccess.getFeatureAccess().getRightCurlyBracketKeyword_3_2());
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFeature"


    // $ANTLR start "entryRuleSPL"
    // InternalForml.g:2511:1: entryRuleSPL returns [EObject current=null] : iv_ruleSPL= ruleSPL EOF ;
    public final EObject entryRuleSPL() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSPL = null;


        try {
            // InternalForml.g:2512:2: (iv_ruleSPL= ruleSPL EOF )
            // InternalForml.g:2513:2: iv_ruleSPL= ruleSPL EOF
            {
             newCompositeNode(grammarAccess.getSPLRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSPL=ruleSPL();

            state._fsp--;

             current =iv_ruleSPL; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSPL"


    // $ANTLR start "ruleSPL"
    // InternalForml.g:2520:1: ruleSPL returns [EObject current=null] : ( () otherlv_1= 'SPL' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( (lv_featureNodes_4_0= ruleFeatureNode ) )* ( (lv_xors_5_0= ruleXORNode ) )* ( (lv_ands_6_0= ruleAndNode ) )* ( (lv_ors_7_0= ruleOrNode ) )* ) otherlv_8= '}' ) ;
    public final EObject ruleSPL() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_8=null;
        EObject lv_featureNodes_4_0 = null;

        EObject lv_xors_5_0 = null;

        EObject lv_ands_6_0 = null;

        EObject lv_ors_7_0 = null;


         enterRule(); 
            
        try {
            // InternalForml.g:2523:28: ( ( () otherlv_1= 'SPL' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( (lv_featureNodes_4_0= ruleFeatureNode ) )* ( (lv_xors_5_0= ruleXORNode ) )* ( (lv_ands_6_0= ruleAndNode ) )* ( (lv_ors_7_0= ruleOrNode ) )* ) otherlv_8= '}' ) )
            // InternalForml.g:2524:1: ( () otherlv_1= 'SPL' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( (lv_featureNodes_4_0= ruleFeatureNode ) )* ( (lv_xors_5_0= ruleXORNode ) )* ( (lv_ands_6_0= ruleAndNode ) )* ( (lv_ors_7_0= ruleOrNode ) )* ) otherlv_8= '}' )
            {
            // InternalForml.g:2524:1: ( () otherlv_1= 'SPL' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( (lv_featureNodes_4_0= ruleFeatureNode ) )* ( (lv_xors_5_0= ruleXORNode ) )* ( (lv_ands_6_0= ruleAndNode ) )* ( (lv_ors_7_0= ruleOrNode ) )* ) otherlv_8= '}' )
            // InternalForml.g:2524:2: () otherlv_1= 'SPL' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( (lv_featureNodes_4_0= ruleFeatureNode ) )* ( (lv_xors_5_0= ruleXORNode ) )* ( (lv_ands_6_0= ruleAndNode ) )* ( (lv_ors_7_0= ruleOrNode ) )* ) otherlv_8= '}'
            {
            // InternalForml.g:2524:2: ()
            // InternalForml.g:2525:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getSPLAccess().getSPLAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,48,FOLLOW_10); 

                	newLeafNode(otherlv_1, grammarAccess.getSPLAccess().getSPLKeyword_1());
                
            // InternalForml.g:2534:1: ( (lv_name_2_0= RULE_ID ) )
            // InternalForml.g:2535:1: (lv_name_2_0= RULE_ID )
            {
            // InternalForml.g:2535:1: (lv_name_2_0= RULE_ID )
            // InternalForml.g:2536:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            			newLeafNode(lv_name_2_0, grammarAccess.getSPLAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSPLRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            otherlv_3=(Token)match(input,12,FOLLOW_38); 

                	newLeafNode(otherlv_3, grammarAccess.getSPLAccess().getLeftCurlyBracketKeyword_3());
                
            // InternalForml.g:2556:1: ( ( (lv_featureNodes_4_0= ruleFeatureNode ) )* ( (lv_xors_5_0= ruleXORNode ) )* ( (lv_ands_6_0= ruleAndNode ) )* ( (lv_ors_7_0= ruleOrNode ) )* )
            // InternalForml.g:2556:2: ( (lv_featureNodes_4_0= ruleFeatureNode ) )* ( (lv_xors_5_0= ruleXORNode ) )* ( (lv_ands_6_0= ruleAndNode ) )* ( (lv_ors_7_0= ruleOrNode ) )*
            {
            // InternalForml.g:2556:2: ( (lv_featureNodes_4_0= ruleFeatureNode ) )*
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==52) ) {
                    alt53=1;
                }


                switch (alt53) {
            	case 1 :
            	    // InternalForml.g:2557:1: (lv_featureNodes_4_0= ruleFeatureNode )
            	    {
            	    // InternalForml.g:2557:1: (lv_featureNodes_4_0= ruleFeatureNode )
            	    // InternalForml.g:2558:3: lv_featureNodes_4_0= ruleFeatureNode
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSPLAccess().getFeatureNodesFeatureNodeParserRuleCall_4_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_38);
            	    lv_featureNodes_4_0=ruleFeatureNode();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSPLRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"featureNodes",
            	            		lv_featureNodes_4_0, 
            	            		"uw.cs.watform.forml.Forml.FeatureNode");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop53;
                }
            } while (true);

            // InternalForml.g:2574:3: ( (lv_xors_5_0= ruleXORNode ) )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==49) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // InternalForml.g:2575:1: (lv_xors_5_0= ruleXORNode )
            	    {
            	    // InternalForml.g:2575:1: (lv_xors_5_0= ruleXORNode )
            	    // InternalForml.g:2576:3: lv_xors_5_0= ruleXORNode
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSPLAccess().getXorsXORNodeParserRuleCall_4_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_39);
            	    lv_xors_5_0=ruleXORNode();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSPLRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"xors",
            	            		lv_xors_5_0, 
            	            		"uw.cs.watform.forml.Forml.XORNode");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop54;
                }
            } while (true);

            // InternalForml.g:2592:3: ( (lv_ands_6_0= ruleAndNode ) )*
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( (LA55_0==50) ) {
                    alt55=1;
                }


                switch (alt55) {
            	case 1 :
            	    // InternalForml.g:2593:1: (lv_ands_6_0= ruleAndNode )
            	    {
            	    // InternalForml.g:2593:1: (lv_ands_6_0= ruleAndNode )
            	    // InternalForml.g:2594:3: lv_ands_6_0= ruleAndNode
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSPLAccess().getAndsAndNodeParserRuleCall_4_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_40);
            	    lv_ands_6_0=ruleAndNode();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSPLRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"ands",
            	            		lv_ands_6_0, 
            	            		"uw.cs.watform.forml.Forml.AndNode");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop55;
                }
            } while (true);

            // InternalForml.g:2610:3: ( (lv_ors_7_0= ruleOrNode ) )*
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==51) ) {
                    alt56=1;
                }


                switch (alt56) {
            	case 1 :
            	    // InternalForml.g:2611:1: (lv_ors_7_0= ruleOrNode )
            	    {
            	    // InternalForml.g:2611:1: (lv_ors_7_0= ruleOrNode )
            	    // InternalForml.g:2612:3: lv_ors_7_0= ruleOrNode
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSPLAccess().getOrsOrNodeParserRuleCall_4_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_41);
            	    lv_ors_7_0=ruleOrNode();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSPLRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"ors",
            	            		lv_ors_7_0, 
            	            		"uw.cs.watform.forml.Forml.OrNode");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop56;
                }
            } while (true);


            }

            otherlv_8=(Token)match(input,13,FOLLOW_2); 

                	newLeafNode(otherlv_8, grammarAccess.getSPLAccess().getRightCurlyBracketKeyword_5());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSPL"


    // $ANTLR start "entryRuleXORNode"
    // InternalForml.g:2640:1: entryRuleXORNode returns [EObject current=null] : iv_ruleXORNode= ruleXORNode EOF ;
    public final EObject entryRuleXORNode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXORNode = null;


        try {
            // InternalForml.g:2641:2: (iv_ruleXORNode= ruleXORNode EOF )
            // InternalForml.g:2642:2: iv_ruleXORNode= ruleXORNode EOF
            {
             newCompositeNode(grammarAccess.getXORNodeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleXORNode=ruleXORNode();

            state._fsp--;

             current =iv_ruleXORNode; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXORNode"


    // $ANTLR start "ruleXORNode"
    // InternalForml.g:2649:1: ruleXORNode returns [EObject current=null] : ( () otherlv_1= 'XOR' otherlv_2= '{' ( (lv_featureNodes_3_0= ruleFeatureNode ) ) ( (lv_featureNodes_4_0= ruleFeatureNode ) )+ otherlv_5= '}' ) ;
    public final EObject ruleXORNode() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        EObject lv_featureNodes_3_0 = null;

        EObject lv_featureNodes_4_0 = null;


         enterRule(); 
            
        try {
            // InternalForml.g:2652:28: ( ( () otherlv_1= 'XOR' otherlv_2= '{' ( (lv_featureNodes_3_0= ruleFeatureNode ) ) ( (lv_featureNodes_4_0= ruleFeatureNode ) )+ otherlv_5= '}' ) )
            // InternalForml.g:2653:1: ( () otherlv_1= 'XOR' otherlv_2= '{' ( (lv_featureNodes_3_0= ruleFeatureNode ) ) ( (lv_featureNodes_4_0= ruleFeatureNode ) )+ otherlv_5= '}' )
            {
            // InternalForml.g:2653:1: ( () otherlv_1= 'XOR' otherlv_2= '{' ( (lv_featureNodes_3_0= ruleFeatureNode ) ) ( (lv_featureNodes_4_0= ruleFeatureNode ) )+ otherlv_5= '}' )
            // InternalForml.g:2653:2: () otherlv_1= 'XOR' otherlv_2= '{' ( (lv_featureNodes_3_0= ruleFeatureNode ) ) ( (lv_featureNodes_4_0= ruleFeatureNode ) )+ otherlv_5= '}'
            {
            // InternalForml.g:2653:2: ()
            // InternalForml.g:2654:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getXORNodeAccess().getXORNodeAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,49,FOLLOW_4); 

                	newLeafNode(otherlv_1, grammarAccess.getXORNodeAccess().getXORKeyword_1());
                
            otherlv_2=(Token)match(input,12,FOLLOW_42); 

                	newLeafNode(otherlv_2, grammarAccess.getXORNodeAccess().getLeftCurlyBracketKeyword_2());
                
            // InternalForml.g:2667:1: ( (lv_featureNodes_3_0= ruleFeatureNode ) )
            // InternalForml.g:2668:1: (lv_featureNodes_3_0= ruleFeatureNode )
            {
            // InternalForml.g:2668:1: (lv_featureNodes_3_0= ruleFeatureNode )
            // InternalForml.g:2669:3: lv_featureNodes_3_0= ruleFeatureNode
            {
             
            	        newCompositeNode(grammarAccess.getXORNodeAccess().getFeatureNodesFeatureNodeParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_42);
            lv_featureNodes_3_0=ruleFeatureNode();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getXORNodeRule());
            	        }
                   		add(
                   			current, 
                   			"featureNodes",
                    		lv_featureNodes_3_0, 
                    		"uw.cs.watform.forml.Forml.FeatureNode");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalForml.g:2685:2: ( (lv_featureNodes_4_0= ruleFeatureNode ) )+
            int cnt57=0;
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( (LA57_0==52) ) {
                    alt57=1;
                }


                switch (alt57) {
            	case 1 :
            	    // InternalForml.g:2686:1: (lv_featureNodes_4_0= ruleFeatureNode )
            	    {
            	    // InternalForml.g:2686:1: (lv_featureNodes_4_0= ruleFeatureNode )
            	    // InternalForml.g:2687:3: lv_featureNodes_4_0= ruleFeatureNode
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getXORNodeAccess().getFeatureNodesFeatureNodeParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_43);
            	    lv_featureNodes_4_0=ruleFeatureNode();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getXORNodeRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"featureNodes",
            	            		lv_featureNodes_4_0, 
            	            		"uw.cs.watform.forml.Forml.FeatureNode");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt57 >= 1 ) break loop57;
                        EarlyExitException eee =
                            new EarlyExitException(57, input);
                        throw eee;
                }
                cnt57++;
            } while (true);

            otherlv_5=(Token)match(input,13,FOLLOW_2); 

                	newLeafNode(otherlv_5, grammarAccess.getXORNodeAccess().getRightCurlyBracketKeyword_5());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXORNode"


    // $ANTLR start "entryRuleAndNode"
    // InternalForml.g:2715:1: entryRuleAndNode returns [EObject current=null] : iv_ruleAndNode= ruleAndNode EOF ;
    public final EObject entryRuleAndNode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndNode = null;


        try {
            // InternalForml.g:2716:2: (iv_ruleAndNode= ruleAndNode EOF )
            // InternalForml.g:2717:2: iv_ruleAndNode= ruleAndNode EOF
            {
             newCompositeNode(grammarAccess.getAndNodeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAndNode=ruleAndNode();

            state._fsp--;

             current =iv_ruleAndNode; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAndNode"


    // $ANTLR start "ruleAndNode"
    // InternalForml.g:2724:1: ruleAndNode returns [EObject current=null] : ( () otherlv_1= 'AND' otherlv_2= '{' ( (lv_featureNodes_3_0= ruleFeatureNode ) ) ( (lv_featureNodes_4_0= ruleFeatureNode ) )+ otherlv_5= '}' ) ;
    public final EObject ruleAndNode() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        EObject lv_featureNodes_3_0 = null;

        EObject lv_featureNodes_4_0 = null;


         enterRule(); 
            
        try {
            // InternalForml.g:2727:28: ( ( () otherlv_1= 'AND' otherlv_2= '{' ( (lv_featureNodes_3_0= ruleFeatureNode ) ) ( (lv_featureNodes_4_0= ruleFeatureNode ) )+ otherlv_5= '}' ) )
            // InternalForml.g:2728:1: ( () otherlv_1= 'AND' otherlv_2= '{' ( (lv_featureNodes_3_0= ruleFeatureNode ) ) ( (lv_featureNodes_4_0= ruleFeatureNode ) )+ otherlv_5= '}' )
            {
            // InternalForml.g:2728:1: ( () otherlv_1= 'AND' otherlv_2= '{' ( (lv_featureNodes_3_0= ruleFeatureNode ) ) ( (lv_featureNodes_4_0= ruleFeatureNode ) )+ otherlv_5= '}' )
            // InternalForml.g:2728:2: () otherlv_1= 'AND' otherlv_2= '{' ( (lv_featureNodes_3_0= ruleFeatureNode ) ) ( (lv_featureNodes_4_0= ruleFeatureNode ) )+ otherlv_5= '}'
            {
            // InternalForml.g:2728:2: ()
            // InternalForml.g:2729:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getAndNodeAccess().getAndNodeAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,50,FOLLOW_4); 

                	newLeafNode(otherlv_1, grammarAccess.getAndNodeAccess().getANDKeyword_1());
                
            otherlv_2=(Token)match(input,12,FOLLOW_42); 

                	newLeafNode(otherlv_2, grammarAccess.getAndNodeAccess().getLeftCurlyBracketKeyword_2());
                
            // InternalForml.g:2742:1: ( (lv_featureNodes_3_0= ruleFeatureNode ) )
            // InternalForml.g:2743:1: (lv_featureNodes_3_0= ruleFeatureNode )
            {
            // InternalForml.g:2743:1: (lv_featureNodes_3_0= ruleFeatureNode )
            // InternalForml.g:2744:3: lv_featureNodes_3_0= ruleFeatureNode
            {
             
            	        newCompositeNode(grammarAccess.getAndNodeAccess().getFeatureNodesFeatureNodeParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_42);
            lv_featureNodes_3_0=ruleFeatureNode();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAndNodeRule());
            	        }
                   		add(
                   			current, 
                   			"featureNodes",
                    		lv_featureNodes_3_0, 
                    		"uw.cs.watform.forml.Forml.FeatureNode");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalForml.g:2760:2: ( (lv_featureNodes_4_0= ruleFeatureNode ) )+
            int cnt58=0;
            loop58:
            do {
                int alt58=2;
                int LA58_0 = input.LA(1);

                if ( (LA58_0==52) ) {
                    alt58=1;
                }


                switch (alt58) {
            	case 1 :
            	    // InternalForml.g:2761:1: (lv_featureNodes_4_0= ruleFeatureNode )
            	    {
            	    // InternalForml.g:2761:1: (lv_featureNodes_4_0= ruleFeatureNode )
            	    // InternalForml.g:2762:3: lv_featureNodes_4_0= ruleFeatureNode
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAndNodeAccess().getFeatureNodesFeatureNodeParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_43);
            	    lv_featureNodes_4_0=ruleFeatureNode();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getAndNodeRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"featureNodes",
            	            		lv_featureNodes_4_0, 
            	            		"uw.cs.watform.forml.Forml.FeatureNode");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt58 >= 1 ) break loop58;
                        EarlyExitException eee =
                            new EarlyExitException(58, input);
                        throw eee;
                }
                cnt58++;
            } while (true);

            otherlv_5=(Token)match(input,13,FOLLOW_2); 

                	newLeafNode(otherlv_5, grammarAccess.getAndNodeAccess().getRightCurlyBracketKeyword_5());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAndNode"


    // $ANTLR start "entryRuleOrNode"
    // InternalForml.g:2790:1: entryRuleOrNode returns [EObject current=null] : iv_ruleOrNode= ruleOrNode EOF ;
    public final EObject entryRuleOrNode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrNode = null;


        try {
            // InternalForml.g:2791:2: (iv_ruleOrNode= ruleOrNode EOF )
            // InternalForml.g:2792:2: iv_ruleOrNode= ruleOrNode EOF
            {
             newCompositeNode(grammarAccess.getOrNodeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOrNode=ruleOrNode();

            state._fsp--;

             current =iv_ruleOrNode; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOrNode"


    // $ANTLR start "ruleOrNode"
    // InternalForml.g:2799:1: ruleOrNode returns [EObject current=null] : ( () otherlv_1= 'OR' otherlv_2= '{' ( (lv_featureNodes_3_0= ruleFeatureNode ) ) ( (lv_featureNodes_4_0= ruleFeatureNode ) )+ otherlv_5= '}' ) ;
    public final EObject ruleOrNode() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        EObject lv_featureNodes_3_0 = null;

        EObject lv_featureNodes_4_0 = null;


         enterRule(); 
            
        try {
            // InternalForml.g:2802:28: ( ( () otherlv_1= 'OR' otherlv_2= '{' ( (lv_featureNodes_3_0= ruleFeatureNode ) ) ( (lv_featureNodes_4_0= ruleFeatureNode ) )+ otherlv_5= '}' ) )
            // InternalForml.g:2803:1: ( () otherlv_1= 'OR' otherlv_2= '{' ( (lv_featureNodes_3_0= ruleFeatureNode ) ) ( (lv_featureNodes_4_0= ruleFeatureNode ) )+ otherlv_5= '}' )
            {
            // InternalForml.g:2803:1: ( () otherlv_1= 'OR' otherlv_2= '{' ( (lv_featureNodes_3_0= ruleFeatureNode ) ) ( (lv_featureNodes_4_0= ruleFeatureNode ) )+ otherlv_5= '}' )
            // InternalForml.g:2803:2: () otherlv_1= 'OR' otherlv_2= '{' ( (lv_featureNodes_3_0= ruleFeatureNode ) ) ( (lv_featureNodes_4_0= ruleFeatureNode ) )+ otherlv_5= '}'
            {
            // InternalForml.g:2803:2: ()
            // InternalForml.g:2804:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getOrNodeAccess().getOrNodeAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,51,FOLLOW_4); 

                	newLeafNode(otherlv_1, grammarAccess.getOrNodeAccess().getORKeyword_1());
                
            otherlv_2=(Token)match(input,12,FOLLOW_42); 

                	newLeafNode(otherlv_2, grammarAccess.getOrNodeAccess().getLeftCurlyBracketKeyword_2());
                
            // InternalForml.g:2817:1: ( (lv_featureNodes_3_0= ruleFeatureNode ) )
            // InternalForml.g:2818:1: (lv_featureNodes_3_0= ruleFeatureNode )
            {
            // InternalForml.g:2818:1: (lv_featureNodes_3_0= ruleFeatureNode )
            // InternalForml.g:2819:3: lv_featureNodes_3_0= ruleFeatureNode
            {
             
            	        newCompositeNode(grammarAccess.getOrNodeAccess().getFeatureNodesFeatureNodeParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_42);
            lv_featureNodes_3_0=ruleFeatureNode();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getOrNodeRule());
            	        }
                   		add(
                   			current, 
                   			"featureNodes",
                    		lv_featureNodes_3_0, 
                    		"uw.cs.watform.forml.Forml.FeatureNode");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalForml.g:2835:2: ( (lv_featureNodes_4_0= ruleFeatureNode ) )+
            int cnt59=0;
            loop59:
            do {
                int alt59=2;
                int LA59_0 = input.LA(1);

                if ( (LA59_0==52) ) {
                    alt59=1;
                }


                switch (alt59) {
            	case 1 :
            	    // InternalForml.g:2836:1: (lv_featureNodes_4_0= ruleFeatureNode )
            	    {
            	    // InternalForml.g:2836:1: (lv_featureNodes_4_0= ruleFeatureNode )
            	    // InternalForml.g:2837:3: lv_featureNodes_4_0= ruleFeatureNode
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getOrNodeAccess().getFeatureNodesFeatureNodeParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_43);
            	    lv_featureNodes_4_0=ruleFeatureNode();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getOrNodeRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"featureNodes",
            	            		lv_featureNodes_4_0, 
            	            		"uw.cs.watform.forml.Forml.FeatureNode");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt59 >= 1 ) break loop59;
                        EarlyExitException eee =
                            new EarlyExitException(59, input);
                        throw eee;
                }
                cnt59++;
            } while (true);

            otherlv_5=(Token)match(input,13,FOLLOW_2); 

                	newLeafNode(otherlv_5, grammarAccess.getOrNodeAccess().getRightCurlyBracketKeyword_5());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOrNode"


    // $ANTLR start "entryRuleFeatureNode"
    // InternalForml.g:2865:1: entryRuleFeatureNode returns [EObject current=null] : iv_ruleFeatureNode= ruleFeatureNode EOF ;
    public final EObject entryRuleFeatureNode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeatureNode = null;


        try {
            // InternalForml.g:2866:2: (iv_ruleFeatureNode= ruleFeatureNode EOF )
            // InternalForml.g:2867:2: iv_ruleFeatureNode= ruleFeatureNode EOF
            {
             newCompositeNode(grammarAccess.getFeatureNodeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFeatureNode=ruleFeatureNode();

            state._fsp--;

             current =iv_ruleFeatureNode; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFeatureNode"


    // $ANTLR start "ruleFeatureNode"
    // InternalForml.g:2874:1: ruleFeatureNode returns [EObject current=null] : ( () otherlv_1= 'FeatureNode' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '[' ( (lv_multiplicity_4_0= ruleMultiplicity ) ) otherlv_5= ']' )? (otherlv_6= '{' ( ( (lv_featureNodes_7_0= ruleFeatureNode ) )* ( (lv_xors_8_0= ruleXORNode ) )* ( (lv_ands_9_0= ruleAndNode ) )* ( (lv_ors_10_0= ruleOrNode ) )* ) otherlv_11= '}' )? ) ;
    public final EObject ruleFeatureNode() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_11=null;
        EObject lv_multiplicity_4_0 = null;

        EObject lv_featureNodes_7_0 = null;

        EObject lv_xors_8_0 = null;

        EObject lv_ands_9_0 = null;

        EObject lv_ors_10_0 = null;


         enterRule(); 
            
        try {
            // InternalForml.g:2877:28: ( ( () otherlv_1= 'FeatureNode' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '[' ( (lv_multiplicity_4_0= ruleMultiplicity ) ) otherlv_5= ']' )? (otherlv_6= '{' ( ( (lv_featureNodes_7_0= ruleFeatureNode ) )* ( (lv_xors_8_0= ruleXORNode ) )* ( (lv_ands_9_0= ruleAndNode ) )* ( (lv_ors_10_0= ruleOrNode ) )* ) otherlv_11= '}' )? ) )
            // InternalForml.g:2878:1: ( () otherlv_1= 'FeatureNode' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '[' ( (lv_multiplicity_4_0= ruleMultiplicity ) ) otherlv_5= ']' )? (otherlv_6= '{' ( ( (lv_featureNodes_7_0= ruleFeatureNode ) )* ( (lv_xors_8_0= ruleXORNode ) )* ( (lv_ands_9_0= ruleAndNode ) )* ( (lv_ors_10_0= ruleOrNode ) )* ) otherlv_11= '}' )? )
            {
            // InternalForml.g:2878:1: ( () otherlv_1= 'FeatureNode' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '[' ( (lv_multiplicity_4_0= ruleMultiplicity ) ) otherlv_5= ']' )? (otherlv_6= '{' ( ( (lv_featureNodes_7_0= ruleFeatureNode ) )* ( (lv_xors_8_0= ruleXORNode ) )* ( (lv_ands_9_0= ruleAndNode ) )* ( (lv_ors_10_0= ruleOrNode ) )* ) otherlv_11= '}' )? )
            // InternalForml.g:2878:2: () otherlv_1= 'FeatureNode' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '[' ( (lv_multiplicity_4_0= ruleMultiplicity ) ) otherlv_5= ']' )? (otherlv_6= '{' ( ( (lv_featureNodes_7_0= ruleFeatureNode ) )* ( (lv_xors_8_0= ruleXORNode ) )* ( (lv_ands_9_0= ruleAndNode ) )* ( (lv_ors_10_0= ruleOrNode ) )* ) otherlv_11= '}' )?
            {
            // InternalForml.g:2878:2: ()
            // InternalForml.g:2879:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getFeatureNodeAccess().getFeatureNodeAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,52,FOLLOW_10); 

                	newLeafNode(otherlv_1, grammarAccess.getFeatureNodeAccess().getFeatureNodeKeyword_1());
                
            // InternalForml.g:2888:1: ( (otherlv_2= RULE_ID ) )
            // InternalForml.g:2889:1: (otherlv_2= RULE_ID )
            {
            // InternalForml.g:2889:1: (otherlv_2= RULE_ID )
            // InternalForml.g:2890:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getFeatureNodeRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_44); 

            		newLeafNode(otherlv_2, grammarAccess.getFeatureNodeAccess().getFeatureFeatureCrossReference_2_0()); 
            	

            }


            }

            // InternalForml.g:2901:2: (otherlv_3= '[' ( (lv_multiplicity_4_0= ruleMultiplicity ) ) otherlv_5= ']' )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==21) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // InternalForml.g:2901:4: otherlv_3= '[' ( (lv_multiplicity_4_0= ruleMultiplicity ) ) otherlv_5= ']'
                    {
                    otherlv_3=(Token)match(input,21,FOLLOW_20); 

                        	newLeafNode(otherlv_3, grammarAccess.getFeatureNodeAccess().getLeftSquareBracketKeyword_3_0());
                        
                    // InternalForml.g:2905:1: ( (lv_multiplicity_4_0= ruleMultiplicity ) )
                    // InternalForml.g:2906:1: (lv_multiplicity_4_0= ruleMultiplicity )
                    {
                    // InternalForml.g:2906:1: (lv_multiplicity_4_0= ruleMultiplicity )
                    // InternalForml.g:2907:3: lv_multiplicity_4_0= ruleMultiplicity
                    {
                     
                    	        newCompositeNode(grammarAccess.getFeatureNodeAccess().getMultiplicityMultiplicityParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FOLLOW_21);
                    lv_multiplicity_4_0=ruleMultiplicity();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getFeatureNodeRule());
                    	        }
                           		set(
                           			current, 
                           			"multiplicity",
                            		lv_multiplicity_4_0, 
                            		"uw.cs.watform.forml.Forml.Multiplicity");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_5=(Token)match(input,22,FOLLOW_12); 

                        	newLeafNode(otherlv_5, grammarAccess.getFeatureNodeAccess().getRightSquareBracketKeyword_3_2());
                        

                    }
                    break;

            }

            // InternalForml.g:2927:3: (otherlv_6= '{' ( ( (lv_featureNodes_7_0= ruleFeatureNode ) )* ( (lv_xors_8_0= ruleXORNode ) )* ( (lv_ands_9_0= ruleAndNode ) )* ( (lv_ors_10_0= ruleOrNode ) )* ) otherlv_11= '}' )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==12) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // InternalForml.g:2927:5: otherlv_6= '{' ( ( (lv_featureNodes_7_0= ruleFeatureNode ) )* ( (lv_xors_8_0= ruleXORNode ) )* ( (lv_ands_9_0= ruleAndNode ) )* ( (lv_ors_10_0= ruleOrNode ) )* ) otherlv_11= '}'
                    {
                    otherlv_6=(Token)match(input,12,FOLLOW_38); 

                        	newLeafNode(otherlv_6, grammarAccess.getFeatureNodeAccess().getLeftCurlyBracketKeyword_4_0());
                        
                    // InternalForml.g:2931:1: ( ( (lv_featureNodes_7_0= ruleFeatureNode ) )* ( (lv_xors_8_0= ruleXORNode ) )* ( (lv_ands_9_0= ruleAndNode ) )* ( (lv_ors_10_0= ruleOrNode ) )* )
                    // InternalForml.g:2931:2: ( (lv_featureNodes_7_0= ruleFeatureNode ) )* ( (lv_xors_8_0= ruleXORNode ) )* ( (lv_ands_9_0= ruleAndNode ) )* ( (lv_ors_10_0= ruleOrNode ) )*
                    {
                    // InternalForml.g:2931:2: ( (lv_featureNodes_7_0= ruleFeatureNode ) )*
                    loop61:
                    do {
                        int alt61=2;
                        int LA61_0 = input.LA(1);

                        if ( (LA61_0==52) ) {
                            alt61=1;
                        }


                        switch (alt61) {
                    	case 1 :
                    	    // InternalForml.g:2932:1: (lv_featureNodes_7_0= ruleFeatureNode )
                    	    {
                    	    // InternalForml.g:2932:1: (lv_featureNodes_7_0= ruleFeatureNode )
                    	    // InternalForml.g:2933:3: lv_featureNodes_7_0= ruleFeatureNode
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getFeatureNodeAccess().getFeatureNodesFeatureNodeParserRuleCall_4_1_0_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_38);
                    	    lv_featureNodes_7_0=ruleFeatureNode();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getFeatureNodeRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"featureNodes",
                    	            		lv_featureNodes_7_0, 
                    	            		"uw.cs.watform.forml.Forml.FeatureNode");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop61;
                        }
                    } while (true);

                    // InternalForml.g:2949:3: ( (lv_xors_8_0= ruleXORNode ) )*
                    loop62:
                    do {
                        int alt62=2;
                        int LA62_0 = input.LA(1);

                        if ( (LA62_0==49) ) {
                            alt62=1;
                        }


                        switch (alt62) {
                    	case 1 :
                    	    // InternalForml.g:2950:1: (lv_xors_8_0= ruleXORNode )
                    	    {
                    	    // InternalForml.g:2950:1: (lv_xors_8_0= ruleXORNode )
                    	    // InternalForml.g:2951:3: lv_xors_8_0= ruleXORNode
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getFeatureNodeAccess().getXorsXORNodeParserRuleCall_4_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_39);
                    	    lv_xors_8_0=ruleXORNode();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getFeatureNodeRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"xors",
                    	            		lv_xors_8_0, 
                    	            		"uw.cs.watform.forml.Forml.XORNode");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop62;
                        }
                    } while (true);

                    // InternalForml.g:2967:3: ( (lv_ands_9_0= ruleAndNode ) )*
                    loop63:
                    do {
                        int alt63=2;
                        int LA63_0 = input.LA(1);

                        if ( (LA63_0==50) ) {
                            alt63=1;
                        }


                        switch (alt63) {
                    	case 1 :
                    	    // InternalForml.g:2968:1: (lv_ands_9_0= ruleAndNode )
                    	    {
                    	    // InternalForml.g:2968:1: (lv_ands_9_0= ruleAndNode )
                    	    // InternalForml.g:2969:3: lv_ands_9_0= ruleAndNode
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getFeatureNodeAccess().getAndsAndNodeParserRuleCall_4_1_2_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_40);
                    	    lv_ands_9_0=ruleAndNode();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getFeatureNodeRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"ands",
                    	            		lv_ands_9_0, 
                    	            		"uw.cs.watform.forml.Forml.AndNode");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop63;
                        }
                    } while (true);

                    // InternalForml.g:2985:3: ( (lv_ors_10_0= ruleOrNode ) )*
                    loop64:
                    do {
                        int alt64=2;
                        int LA64_0 = input.LA(1);

                        if ( (LA64_0==51) ) {
                            alt64=1;
                        }


                        switch (alt64) {
                    	case 1 :
                    	    // InternalForml.g:2986:1: (lv_ors_10_0= ruleOrNode )
                    	    {
                    	    // InternalForml.g:2986:1: (lv_ors_10_0= ruleOrNode )
                    	    // InternalForml.g:2987:3: lv_ors_10_0= ruleOrNode
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getFeatureNodeAccess().getOrsOrNodeParserRuleCall_4_1_3_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_41);
                    	    lv_ors_10_0=ruleOrNode();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getFeatureNodeRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"ors",
                    	            		lv_ors_10_0, 
                    	            		"uw.cs.watform.forml.Forml.OrNode");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop64;
                        }
                    } while (true);


                    }

                    otherlv_11=(Token)match(input,13,FOLLOW_2); 

                        	newLeafNode(otherlv_11, grammarAccess.getFeatureNodeAccess().getRightCurlyBracketKeyword_4_2());
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFeatureNode"


    // $ANTLR start "entryRuleEnumeration"
    // InternalForml.g:3015:1: entryRuleEnumeration returns [EObject current=null] : iv_ruleEnumeration= ruleEnumeration EOF ;
    public final EObject entryRuleEnumeration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumeration = null;


        try {
            // InternalForml.g:3016:2: (iv_ruleEnumeration= ruleEnumeration EOF )
            // InternalForml.g:3017:2: iv_ruleEnumeration= ruleEnumeration EOF
            {
             newCompositeNode(grammarAccess.getEnumerationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEnumeration=ruleEnumeration();

            state._fsp--;

             current =iv_ruleEnumeration; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEnumeration"


    // $ANTLR start "ruleEnumeration"
    // InternalForml.g:3024:1: ruleEnumeration returns [EObject current=null] : ( () otherlv_1= 'enum' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( (lv_constant_4_0= ruleEnumConst ) ) (otherlv_5= ',' ( (lv_constant_6_0= ruleEnumConst ) ) )* ) otherlv_7= '}' ) ;
    public final EObject ruleEnumeration() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_constant_4_0 = null;

        EObject lv_constant_6_0 = null;


         enterRule(); 
            
        try {
            // InternalForml.g:3027:28: ( ( () otherlv_1= 'enum' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( (lv_constant_4_0= ruleEnumConst ) ) (otherlv_5= ',' ( (lv_constant_6_0= ruleEnumConst ) ) )* ) otherlv_7= '}' ) )
            // InternalForml.g:3028:1: ( () otherlv_1= 'enum' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( (lv_constant_4_0= ruleEnumConst ) ) (otherlv_5= ',' ( (lv_constant_6_0= ruleEnumConst ) ) )* ) otherlv_7= '}' )
            {
            // InternalForml.g:3028:1: ( () otherlv_1= 'enum' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( (lv_constant_4_0= ruleEnumConst ) ) (otherlv_5= ',' ( (lv_constant_6_0= ruleEnumConst ) ) )* ) otherlv_7= '}' )
            // InternalForml.g:3028:2: () otherlv_1= 'enum' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( (lv_constant_4_0= ruleEnumConst ) ) (otherlv_5= ',' ( (lv_constant_6_0= ruleEnumConst ) ) )* ) otherlv_7= '}'
            {
            // InternalForml.g:3028:2: ()
            // InternalForml.g:3029:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getEnumerationAccess().getEnumerationAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,53,FOLLOW_10); 

                	newLeafNode(otherlv_1, grammarAccess.getEnumerationAccess().getEnumKeyword_1());
                
            // InternalForml.g:3038:1: ( (lv_name_2_0= RULE_ID ) )
            // InternalForml.g:3039:1: (lv_name_2_0= RULE_ID )
            {
            // InternalForml.g:3039:1: (lv_name_2_0= RULE_ID )
            // InternalForml.g:3040:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            			newLeafNode(lv_name_2_0, grammarAccess.getEnumerationAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getEnumerationRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            otherlv_3=(Token)match(input,12,FOLLOW_10); 

                	newLeafNode(otherlv_3, grammarAccess.getEnumerationAccess().getLeftCurlyBracketKeyword_3());
                
            // InternalForml.g:3060:1: ( ( (lv_constant_4_0= ruleEnumConst ) ) (otherlv_5= ',' ( (lv_constant_6_0= ruleEnumConst ) ) )* )
            // InternalForml.g:3060:2: ( (lv_constant_4_0= ruleEnumConst ) ) (otherlv_5= ',' ( (lv_constant_6_0= ruleEnumConst ) ) )*
            {
            // InternalForml.g:3060:2: ( (lv_constant_4_0= ruleEnumConst ) )
            // InternalForml.g:3061:1: (lv_constant_4_0= ruleEnumConst )
            {
            // InternalForml.g:3061:1: (lv_constant_4_0= ruleEnumConst )
            // InternalForml.g:3062:3: lv_constant_4_0= ruleEnumConst
            {
             
            	        newCompositeNode(grammarAccess.getEnumerationAccess().getConstantEnumConstParserRuleCall_4_0_0()); 
            	    
            pushFollow(FOLLOW_35);
            lv_constant_4_0=ruleEnumConst();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getEnumerationRule());
            	        }
                   		add(
                   			current, 
                   			"constant",
                    		lv_constant_4_0, 
                    		"uw.cs.watform.forml.Forml.EnumConst");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalForml.g:3078:2: (otherlv_5= ',' ( (lv_constant_6_0= ruleEnumConst ) ) )*
            loop66:
            do {
                int alt66=2;
                int LA66_0 = input.LA(1);

                if ( (LA66_0==45) ) {
                    alt66=1;
                }


                switch (alt66) {
            	case 1 :
            	    // InternalForml.g:3078:4: otherlv_5= ',' ( (lv_constant_6_0= ruleEnumConst ) )
            	    {
            	    otherlv_5=(Token)match(input,45,FOLLOW_10); 

            	        	newLeafNode(otherlv_5, grammarAccess.getEnumerationAccess().getCommaKeyword_4_1_0());
            	        
            	    // InternalForml.g:3082:1: ( (lv_constant_6_0= ruleEnumConst ) )
            	    // InternalForml.g:3083:1: (lv_constant_6_0= ruleEnumConst )
            	    {
            	    // InternalForml.g:3083:1: (lv_constant_6_0= ruleEnumConst )
            	    // InternalForml.g:3084:3: lv_constant_6_0= ruleEnumConst
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getEnumerationAccess().getConstantEnumConstParserRuleCall_4_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_35);
            	    lv_constant_6_0=ruleEnumConst();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getEnumerationRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"constant",
            	            		lv_constant_6_0, 
            	            		"uw.cs.watform.forml.Forml.EnumConst");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop66;
                }
            } while (true);


            }

            otherlv_7=(Token)match(input,13,FOLLOW_2); 

                	newLeafNode(otherlv_7, grammarAccess.getEnumerationAccess().getRightCurlyBracketKeyword_5());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEnumeration"


    // $ANTLR start "entryRuleEnumConst"
    // InternalForml.g:3112:1: entryRuleEnumConst returns [EObject current=null] : iv_ruleEnumConst= ruleEnumConst EOF ;
    public final EObject entryRuleEnumConst() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumConst = null;


        try {
            // InternalForml.g:3113:2: (iv_ruleEnumConst= ruleEnumConst EOF )
            // InternalForml.g:3114:2: iv_ruleEnumConst= ruleEnumConst EOF
            {
             newCompositeNode(grammarAccess.getEnumConstRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEnumConst=ruleEnumConst();

            state._fsp--;

             current =iv_ruleEnumConst; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEnumConst"


    // $ANTLR start "ruleEnumConst"
    // InternalForml.g:3121:1: ruleEnumConst returns [EObject current=null] : ( () ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleEnumConst() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // InternalForml.g:3124:28: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalForml.g:3125:1: ( () ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalForml.g:3125:1: ( () ( (lv_name_1_0= RULE_ID ) ) )
            // InternalForml.g:3125:2: () ( (lv_name_1_0= RULE_ID ) )
            {
            // InternalForml.g:3125:2: ()
            // InternalForml.g:3126:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getEnumConstAccess().getEnumConstAction_0(),
                        current);
                

            }

            // InternalForml.g:3131:2: ( (lv_name_1_0= RULE_ID ) )
            // InternalForml.g:3132:1: (lv_name_1_0= RULE_ID )
            {
            // InternalForml.g:3132:1: (lv_name_1_0= RULE_ID )
            // InternalForml.g:3133:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            			newLeafNode(lv_name_1_0, grammarAccess.getEnumConstAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getEnumConstRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEnumConst"


    // $ANTLR start "entryRuleBehaviourModel"
    // InternalForml.g:3157:1: entryRuleBehaviourModel returns [EObject current=null] : iv_ruleBehaviourModel= ruleBehaviourModel EOF ;
    public final EObject entryRuleBehaviourModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBehaviourModel = null;


        try {
            // InternalForml.g:3158:2: (iv_ruleBehaviourModel= ruleBehaviourModel EOF )
            // InternalForml.g:3159:2: iv_ruleBehaviourModel= ruleBehaviourModel EOF
            {
             newCompositeNode(grammarAccess.getBehaviourModelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBehaviourModel=ruleBehaviourModel();

            state._fsp--;

             current =iv_ruleBehaviourModel; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBehaviourModel"


    // $ANTLR start "ruleBehaviourModel"
    // InternalForml.g:3166:1: ruleBehaviourModel returns [EObject current=null] : ( () otherlv_1= 'Behaviour' otherlv_2= '{' ( (lv_featuremodules_3_0= ruleFeatureModule ) )* otherlv_4= '}' ) ;
    public final EObject ruleBehaviourModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_featuremodules_3_0 = null;


         enterRule(); 
            
        try {
            // InternalForml.g:3169:28: ( ( () otherlv_1= 'Behaviour' otherlv_2= '{' ( (lv_featuremodules_3_0= ruleFeatureModule ) )* otherlv_4= '}' ) )
            // InternalForml.g:3170:1: ( () otherlv_1= 'Behaviour' otherlv_2= '{' ( (lv_featuremodules_3_0= ruleFeatureModule ) )* otherlv_4= '}' )
            {
            // InternalForml.g:3170:1: ( () otherlv_1= 'Behaviour' otherlv_2= '{' ( (lv_featuremodules_3_0= ruleFeatureModule ) )* otherlv_4= '}' )
            // InternalForml.g:3170:2: () otherlv_1= 'Behaviour' otherlv_2= '{' ( (lv_featuremodules_3_0= ruleFeatureModule ) )* otherlv_4= '}'
            {
            // InternalForml.g:3170:2: ()
            // InternalForml.g:3171:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getBehaviourModelAccess().getBehaviourModelAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,54,FOLLOW_4); 

                	newLeafNode(otherlv_1, grammarAccess.getBehaviourModelAccess().getBehaviourKeyword_1());
                
            otherlv_2=(Token)match(input,12,FOLLOW_45); 

                	newLeafNode(otherlv_2, grammarAccess.getBehaviourModelAccess().getLeftCurlyBracketKeyword_2());
                
            // InternalForml.g:3184:1: ( (lv_featuremodules_3_0= ruleFeatureModule ) )*
            loop67:
            do {
                int alt67=2;
                int LA67_0 = input.LA(1);

                if ( (LA67_0==55) ) {
                    alt67=1;
                }


                switch (alt67) {
            	case 1 :
            	    // InternalForml.g:3185:1: (lv_featuremodules_3_0= ruleFeatureModule )
            	    {
            	    // InternalForml.g:3185:1: (lv_featuremodules_3_0= ruleFeatureModule )
            	    // InternalForml.g:3186:3: lv_featuremodules_3_0= ruleFeatureModule
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getBehaviourModelAccess().getFeaturemodulesFeatureModuleParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_45);
            	    lv_featuremodules_3_0=ruleFeatureModule();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getBehaviourModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"featuremodules",
            	            		lv_featuremodules_3_0, 
            	            		"uw.cs.watform.forml.Forml.FeatureModule");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop67;
                }
            } while (true);

            otherlv_4=(Token)match(input,13,FOLLOW_2); 

                	newLeafNode(otherlv_4, grammarAccess.getBehaviourModelAccess().getRightCurlyBracketKeyword_4());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBehaviourModel"


    // $ANTLR start "entryRuleFeatureModule"
    // InternalForml.g:3214:1: entryRuleFeatureModule returns [EObject current=null] : iv_ruleFeatureModule= ruleFeatureModule EOF ;
    public final EObject entryRuleFeatureModule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeatureModule = null;


        try {
            // InternalForml.g:3215:2: (iv_ruleFeatureModule= ruleFeatureModule EOF )
            // InternalForml.g:3216:2: iv_ruleFeatureModule= ruleFeatureModule EOF
            {
             newCompositeNode(grammarAccess.getFeatureModuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFeatureModule=ruleFeatureModule();

            state._fsp--;

             current =iv_ruleFeatureModule; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFeatureModule"


    // $ANTLR start "ruleFeatureModule"
    // InternalForml.g:3223:1: ruleFeatureModule returns [EObject current=null] : (otherlv_0= 'FeatureModule' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => ( (lv_constraints_4_0= ruleConstraint ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_statemachine_5_0= ruleStateMachine ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_fragments_6_0= ruleFragment ) ) )+ ) ) )* ) ) ) otherlv_7= '}' ) ;
    public final EObject ruleFeatureModule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_7=null;
        EObject lv_constraints_4_0 = null;

        EObject lv_statemachine_5_0 = null;

        EObject lv_fragments_6_0 = null;


         enterRule(); 
            
        try {
            // InternalForml.g:3226:28: ( (otherlv_0= 'FeatureModule' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => ( (lv_constraints_4_0= ruleConstraint ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_statemachine_5_0= ruleStateMachine ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_fragments_6_0= ruleFragment ) ) )+ ) ) )* ) ) ) otherlv_7= '}' ) )
            // InternalForml.g:3227:1: (otherlv_0= 'FeatureModule' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => ( (lv_constraints_4_0= ruleConstraint ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_statemachine_5_0= ruleStateMachine ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_fragments_6_0= ruleFragment ) ) )+ ) ) )* ) ) ) otherlv_7= '}' )
            {
            // InternalForml.g:3227:1: (otherlv_0= 'FeatureModule' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => ( (lv_constraints_4_0= ruleConstraint ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_statemachine_5_0= ruleStateMachine ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_fragments_6_0= ruleFragment ) ) )+ ) ) )* ) ) ) otherlv_7= '}' )
            // InternalForml.g:3227:3: otherlv_0= 'FeatureModule' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => ( (lv_constraints_4_0= ruleConstraint ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_statemachine_5_0= ruleStateMachine ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_fragments_6_0= ruleFragment ) ) )+ ) ) )* ) ) ) otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,55,FOLLOW_10); 

                	newLeafNode(otherlv_0, grammarAccess.getFeatureModuleAccess().getFeatureModuleKeyword_0());
                
            // InternalForml.g:3231:1: ( (otherlv_1= RULE_ID ) )
            // InternalForml.g:3232:1: (otherlv_1= RULE_ID )
            {
            // InternalForml.g:3232:1: (otherlv_1= RULE_ID )
            // InternalForml.g:3233:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getFeatureModuleRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_4); 

            		newLeafNode(otherlv_1, grammarAccess.getFeatureModuleAccess().getFeaturerefRoleableCrossReference_1_0()); 
            	

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_46); 

                	newLeafNode(otherlv_2, grammarAccess.getFeatureModuleAccess().getLeftCurlyBracketKeyword_2());
                
            // InternalForml.g:3248:1: ( ( ( ( ({...}? => ( ({...}? => ( (lv_constraints_4_0= ruleConstraint ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_statemachine_5_0= ruleStateMachine ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_fragments_6_0= ruleFragment ) ) )+ ) ) )* ) ) )
            // InternalForml.g:3250:1: ( ( ( ({...}? => ( ({...}? => ( (lv_constraints_4_0= ruleConstraint ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_statemachine_5_0= ruleStateMachine ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_fragments_6_0= ruleFragment ) ) )+ ) ) )* ) )
            {
            // InternalForml.g:3250:1: ( ( ( ({...}? => ( ({...}? => ( (lv_constraints_4_0= ruleConstraint ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_statemachine_5_0= ruleStateMachine ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_fragments_6_0= ruleFragment ) ) )+ ) ) )* ) )
            // InternalForml.g:3251:2: ( ( ({...}? => ( ({...}? => ( (lv_constraints_4_0= ruleConstraint ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_statemachine_5_0= ruleStateMachine ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_fragments_6_0= ruleFragment ) ) )+ ) ) )* )
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getFeatureModuleAccess().getUnorderedGroup_3());
            	
            // InternalForml.g:3254:2: ( ( ({...}? => ( ({...}? => ( (lv_constraints_4_0= ruleConstraint ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_statemachine_5_0= ruleStateMachine ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_fragments_6_0= ruleFragment ) ) )+ ) ) )* )
            // InternalForml.g:3255:3: ( ({...}? => ( ({...}? => ( (lv_constraints_4_0= ruleConstraint ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_statemachine_5_0= ruleStateMachine ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_fragments_6_0= ruleFragment ) ) )+ ) ) )*
            {
            // InternalForml.g:3255:3: ( ({...}? => ( ({...}? => ( (lv_constraints_4_0= ruleConstraint ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_statemachine_5_0= ruleStateMachine ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_fragments_6_0= ruleFragment ) ) )+ ) ) )*
            loop70:
            do {
                int alt70=4;
                int LA70_0 = input.LA(1);

                if ( LA70_0 == 14 && getUnorderedGroupHelper().canSelect(grammarAccess.getFeatureModuleAccess().getUnorderedGroup_3(), 0) ) {
                    alt70=1;
                }
                else if ( LA70_0 == 56 && getUnorderedGroupHelper().canSelect(grammarAccess.getFeatureModuleAccess().getUnorderedGroup_3(), 1) ) {
                    alt70=2;
                }
                else if ( LA70_0 == 101 && getUnorderedGroupHelper().canSelect(grammarAccess.getFeatureModuleAccess().getUnorderedGroup_3(), 2) ) {
                    alt70=3;
                }


                switch (alt70) {
            	case 1 :
            	    // InternalForml.g:3257:4: ({...}? => ( ({...}? => ( (lv_constraints_4_0= ruleConstraint ) ) ) ) )
            	    {
            	    // InternalForml.g:3257:4: ({...}? => ( ({...}? => ( (lv_constraints_4_0= ruleConstraint ) ) ) ) )
            	    // InternalForml.g:3258:5: {...}? => ( ({...}? => ( (lv_constraints_4_0= ruleConstraint ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getFeatureModuleAccess().getUnorderedGroup_3(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleFeatureModule", "getUnorderedGroupHelper().canSelect(grammarAccess.getFeatureModuleAccess().getUnorderedGroup_3(), 0)");
            	    }
            	    // InternalForml.g:3258:110: ( ({...}? => ( (lv_constraints_4_0= ruleConstraint ) ) ) )
            	    // InternalForml.g:3259:6: ({...}? => ( (lv_constraints_4_0= ruleConstraint ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getFeatureModuleAccess().getUnorderedGroup_3(), 0);
            	    	 				
            	    // InternalForml.g:3262:6: ({...}? => ( (lv_constraints_4_0= ruleConstraint ) ) )
            	    // InternalForml.g:3262:7: {...}? => ( (lv_constraints_4_0= ruleConstraint ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleFeatureModule", "true");
            	    }
            	    // InternalForml.g:3262:16: ( (lv_constraints_4_0= ruleConstraint ) )
            	    // InternalForml.g:3263:1: (lv_constraints_4_0= ruleConstraint )
            	    {
            	    // InternalForml.g:3263:1: (lv_constraints_4_0= ruleConstraint )
            	    // InternalForml.g:3264:3: lv_constraints_4_0= ruleConstraint
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getFeatureModuleAccess().getConstraintsConstraintParserRuleCall_3_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_46);
            	    lv_constraints_4_0=ruleConstraint();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getFeatureModuleRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"constraints",
            	            		lv_constraints_4_0, 
            	            		"uw.cs.watform.forml.Forml.Constraint");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getFeatureModuleAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalForml.g:3287:4: ({...}? => ( ({...}? => ( (lv_statemachine_5_0= ruleStateMachine ) ) )+ ) )
            	    {
            	    // InternalForml.g:3287:4: ({...}? => ( ({...}? => ( (lv_statemachine_5_0= ruleStateMachine ) ) )+ ) )
            	    // InternalForml.g:3288:5: {...}? => ( ({...}? => ( (lv_statemachine_5_0= ruleStateMachine ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getFeatureModuleAccess().getUnorderedGroup_3(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleFeatureModule", "getUnorderedGroupHelper().canSelect(grammarAccess.getFeatureModuleAccess().getUnorderedGroup_3(), 1)");
            	    }
            	    // InternalForml.g:3288:110: ( ({...}? => ( (lv_statemachine_5_0= ruleStateMachine ) ) )+ )
            	    // InternalForml.g:3289:6: ({...}? => ( (lv_statemachine_5_0= ruleStateMachine ) ) )+
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getFeatureModuleAccess().getUnorderedGroup_3(), 1);
            	    	 				
            	    // InternalForml.g:3292:6: ({...}? => ( (lv_statemachine_5_0= ruleStateMachine ) ) )+
            	    int cnt68=0;
            	    loop68:
            	    do {
            	        int alt68=2;
            	        int LA68_0 = input.LA(1);

            	        if ( (LA68_0==56) ) {
            	            int LA68_2 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt68=1;
            	            }


            	        }


            	        switch (alt68) {
            	    	case 1 :
            	    	    // InternalForml.g:3292:7: {...}? => ( (lv_statemachine_5_0= ruleStateMachine ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleFeatureModule", "true");
            	    	    }
            	    	    // InternalForml.g:3292:16: ( (lv_statemachine_5_0= ruleStateMachine ) )
            	    	    // InternalForml.g:3293:1: (lv_statemachine_5_0= ruleStateMachine )
            	    	    {
            	    	    // InternalForml.g:3293:1: (lv_statemachine_5_0= ruleStateMachine )
            	    	    // InternalForml.g:3294:3: lv_statemachine_5_0= ruleStateMachine
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getFeatureModuleAccess().getStatemachineStateMachineParserRuleCall_3_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_46);
            	    	    lv_statemachine_5_0=ruleStateMachine();

            	    	    state._fsp--;


            	    	    	        if (current==null) {
            	    	    	            current = createModelElementForParent(grammarAccess.getFeatureModuleRule());
            	    	    	        }
            	    	           		add(
            	    	           			current, 
            	    	           			"statemachine",
            	    	            		lv_statemachine_5_0, 
            	    	            		"uw.cs.watform.forml.Forml.StateMachine");
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt68 >= 1 ) break loop68;
            	                EarlyExitException eee =
            	                    new EarlyExitException(68, input);
            	                throw eee;
            	        }
            	        cnt68++;
            	    } while (true);

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getFeatureModuleAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalForml.g:3317:4: ({...}? => ( ({...}? => ( (lv_fragments_6_0= ruleFragment ) ) )+ ) )
            	    {
            	    // InternalForml.g:3317:4: ({...}? => ( ({...}? => ( (lv_fragments_6_0= ruleFragment ) ) )+ ) )
            	    // InternalForml.g:3318:5: {...}? => ( ({...}? => ( (lv_fragments_6_0= ruleFragment ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getFeatureModuleAccess().getUnorderedGroup_3(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleFeatureModule", "getUnorderedGroupHelper().canSelect(grammarAccess.getFeatureModuleAccess().getUnorderedGroup_3(), 2)");
            	    }
            	    // InternalForml.g:3318:110: ( ({...}? => ( (lv_fragments_6_0= ruleFragment ) ) )+ )
            	    // InternalForml.g:3319:6: ({...}? => ( (lv_fragments_6_0= ruleFragment ) ) )+
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getFeatureModuleAccess().getUnorderedGroup_3(), 2);
            	    	 				
            	    // InternalForml.g:3322:6: ({...}? => ( (lv_fragments_6_0= ruleFragment ) ) )+
            	    int cnt69=0;
            	    loop69:
            	    do {
            	        int alt69=2;
            	        int LA69_0 = input.LA(1);

            	        if ( (LA69_0==101) ) {
            	            int LA69_2 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt69=1;
            	            }


            	        }


            	        switch (alt69) {
            	    	case 1 :
            	    	    // InternalForml.g:3322:7: {...}? => ( (lv_fragments_6_0= ruleFragment ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleFeatureModule", "true");
            	    	    }
            	    	    // InternalForml.g:3322:16: ( (lv_fragments_6_0= ruleFragment ) )
            	    	    // InternalForml.g:3323:1: (lv_fragments_6_0= ruleFragment )
            	    	    {
            	    	    // InternalForml.g:3323:1: (lv_fragments_6_0= ruleFragment )
            	    	    // InternalForml.g:3324:3: lv_fragments_6_0= ruleFragment
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getFeatureModuleAccess().getFragmentsFragmentParserRuleCall_3_2_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_46);
            	    	    lv_fragments_6_0=ruleFragment();

            	    	    state._fsp--;


            	    	    	        if (current==null) {
            	    	    	            current = createModelElementForParent(grammarAccess.getFeatureModuleRule());
            	    	    	        }
            	    	           		add(
            	    	           			current, 
            	    	           			"fragments",
            	    	            		lv_fragments_6_0, 
            	    	            		"uw.cs.watform.forml.Forml.Fragment");
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt69 >= 1 ) break loop69;
            	                EarlyExitException eee =
            	                    new EarlyExitException(69, input);
            	                throw eee;
            	        }
            	        cnt69++;
            	    } while (true);

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getFeatureModuleAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop70;
                }
            } while (true);


            }


            }

             
            	  getUnorderedGroupHelper().leave(grammarAccess.getFeatureModuleAccess().getUnorderedGroup_3());
            	

            }

            otherlv_7=(Token)match(input,13,FOLLOW_2); 

                	newLeafNode(otherlv_7, grammarAccess.getFeatureModuleAccess().getRightCurlyBracketKeyword_4());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFeatureModule"


    // $ANTLR start "entryRuleStateMachine"
    // InternalForml.g:3366:1: entryRuleStateMachine returns [EObject current=null] : iv_ruleStateMachine= ruleStateMachine EOF ;
    public final EObject entryRuleStateMachine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStateMachine = null;


        try {
            // InternalForml.g:3367:2: (iv_ruleStateMachine= ruleStateMachine EOF )
            // InternalForml.g:3368:2: iv_ruleStateMachine= ruleStateMachine EOF
            {
             newCompositeNode(grammarAccess.getStateMachineRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStateMachine=ruleStateMachine();

            state._fsp--;

             current =iv_ruleStateMachine; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStateMachine"


    // $ANTLR start "ruleStateMachine"
    // InternalForml.g:3375:1: ruleStateMachine returns [EObject current=null] : (otherlv_0= 'statemachine' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => ( (lv_regions_4_0= ruleRegion ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_transitions_5_0= ruleTransition ) ) )+ ) ) )+ {...}?) ) ) otherlv_6= '}' ) ;
    public final EObject ruleStateMachine() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_6=null;
        EObject lv_regions_4_0 = null;

        EObject lv_transitions_5_0 = null;


         enterRule(); 
            
        try {
            // InternalForml.g:3378:28: ( (otherlv_0= 'statemachine' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => ( (lv_regions_4_0= ruleRegion ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_transitions_5_0= ruleTransition ) ) )+ ) ) )+ {...}?) ) ) otherlv_6= '}' ) )
            // InternalForml.g:3379:1: (otherlv_0= 'statemachine' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => ( (lv_regions_4_0= ruleRegion ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_transitions_5_0= ruleTransition ) ) )+ ) ) )+ {...}?) ) ) otherlv_6= '}' )
            {
            // InternalForml.g:3379:1: (otherlv_0= 'statemachine' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => ( (lv_regions_4_0= ruleRegion ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_transitions_5_0= ruleTransition ) ) )+ ) ) )+ {...}?) ) ) otherlv_6= '}' )
            // InternalForml.g:3379:3: otherlv_0= 'statemachine' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => ( (lv_regions_4_0= ruleRegion ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_transitions_5_0= ruleTransition ) ) )+ ) ) )+ {...}?) ) ) otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,56,FOLLOW_10); 

                	newLeafNode(otherlv_0, grammarAccess.getStateMachineAccess().getStatemachineKeyword_0());
                
            // InternalForml.g:3383:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalForml.g:3384:1: (lv_name_1_0= RULE_ID )
            {
            // InternalForml.g:3384:1: (lv_name_1_0= RULE_ID )
            // InternalForml.g:3385:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            			newLeafNode(lv_name_1_0, grammarAccess.getStateMachineAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getStateMachineRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_47); 

                	newLeafNode(otherlv_2, grammarAccess.getStateMachineAccess().getLeftCurlyBracketKeyword_2());
                
            // InternalForml.g:3405:1: ( ( ( ( ({...}? => ( ({...}? => ( (lv_regions_4_0= ruleRegion ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_transitions_5_0= ruleTransition ) ) )+ ) ) )+ {...}?) ) )
            // InternalForml.g:3407:1: ( ( ( ({...}? => ( ({...}? => ( (lv_regions_4_0= ruleRegion ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_transitions_5_0= ruleTransition ) ) )+ ) ) )+ {...}?) )
            {
            // InternalForml.g:3407:1: ( ( ( ({...}? => ( ({...}? => ( (lv_regions_4_0= ruleRegion ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_transitions_5_0= ruleTransition ) ) )+ ) ) )+ {...}?) )
            // InternalForml.g:3408:2: ( ( ({...}? => ( ({...}? => ( (lv_regions_4_0= ruleRegion ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_transitions_5_0= ruleTransition ) ) )+ ) ) )+ {...}?)
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getStateMachineAccess().getUnorderedGroup_3());
            	
            // InternalForml.g:3411:2: ( ( ({...}? => ( ({...}? => ( (lv_regions_4_0= ruleRegion ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_transitions_5_0= ruleTransition ) ) )+ ) ) )+ {...}?)
            // InternalForml.g:3412:3: ( ({...}? => ( ({...}? => ( (lv_regions_4_0= ruleRegion ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_transitions_5_0= ruleTransition ) ) )+ ) ) )+ {...}?
            {
            // InternalForml.g:3412:3: ( ({...}? => ( ({...}? => ( (lv_regions_4_0= ruleRegion ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_transitions_5_0= ruleTransition ) ) )+ ) ) )+
            int cnt73=0;
            loop73:
            do {
                int alt73=3;
                int LA73_0 = input.LA(1);

                if ( LA73_0 == 60 && getUnorderedGroupHelper().canSelect(grammarAccess.getStateMachineAccess().getUnorderedGroup_3(), 0) ) {
                    alt73=1;
                }
                else if ( LA73_0 == 61 && getUnorderedGroupHelper().canSelect(grammarAccess.getStateMachineAccess().getUnorderedGroup_3(), 1) ) {
                    alt73=2;
                }


                switch (alt73) {
            	case 1 :
            	    // InternalForml.g:3414:4: ({...}? => ( ({...}? => ( (lv_regions_4_0= ruleRegion ) ) )+ ) )
            	    {
            	    // InternalForml.g:3414:4: ({...}? => ( ({...}? => ( (lv_regions_4_0= ruleRegion ) ) )+ ) )
            	    // InternalForml.g:3415:5: {...}? => ( ({...}? => ( (lv_regions_4_0= ruleRegion ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStateMachineAccess().getUnorderedGroup_3(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleStateMachine", "getUnorderedGroupHelper().canSelect(grammarAccess.getStateMachineAccess().getUnorderedGroup_3(), 0)");
            	    }
            	    // InternalForml.g:3415:109: ( ({...}? => ( (lv_regions_4_0= ruleRegion ) ) )+ )
            	    // InternalForml.g:3416:6: ({...}? => ( (lv_regions_4_0= ruleRegion ) ) )+
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getStateMachineAccess().getUnorderedGroup_3(), 0);
            	    	 				
            	    // InternalForml.g:3419:6: ({...}? => ( (lv_regions_4_0= ruleRegion ) ) )+
            	    int cnt71=0;
            	    loop71:
            	    do {
            	        int alt71=2;
            	        int LA71_0 = input.LA(1);

            	        if ( (LA71_0==60) ) {
            	            int LA71_2 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt71=1;
            	            }


            	        }


            	        switch (alt71) {
            	    	case 1 :
            	    	    // InternalForml.g:3419:7: {...}? => ( (lv_regions_4_0= ruleRegion ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleStateMachine", "true");
            	    	    }
            	    	    // InternalForml.g:3419:16: ( (lv_regions_4_0= ruleRegion ) )
            	    	    // InternalForml.g:3420:1: (lv_regions_4_0= ruleRegion )
            	    	    {
            	    	    // InternalForml.g:3420:1: (lv_regions_4_0= ruleRegion )
            	    	    // InternalForml.g:3421:3: lv_regions_4_0= ruleRegion
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getStateMachineAccess().getRegionsRegionParserRuleCall_3_0_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_48);
            	    	    lv_regions_4_0=ruleRegion();

            	    	    state._fsp--;


            	    	    	        if (current==null) {
            	    	    	            current = createModelElementForParent(grammarAccess.getStateMachineRule());
            	    	    	        }
            	    	           		add(
            	    	           			current, 
            	    	           			"regions",
            	    	            		lv_regions_4_0, 
            	    	            		"uw.cs.watform.forml.Forml.Region");
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt71 >= 1 ) break loop71;
            	                EarlyExitException eee =
            	                    new EarlyExitException(71, input);
            	                throw eee;
            	        }
            	        cnt71++;
            	    } while (true);

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getStateMachineAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalForml.g:3444:4: ({...}? => ( ({...}? => ( (lv_transitions_5_0= ruleTransition ) ) )+ ) )
            	    {
            	    // InternalForml.g:3444:4: ({...}? => ( ({...}? => ( (lv_transitions_5_0= ruleTransition ) ) )+ ) )
            	    // InternalForml.g:3445:5: {...}? => ( ({...}? => ( (lv_transitions_5_0= ruleTransition ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStateMachineAccess().getUnorderedGroup_3(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleStateMachine", "getUnorderedGroupHelper().canSelect(grammarAccess.getStateMachineAccess().getUnorderedGroup_3(), 1)");
            	    }
            	    // InternalForml.g:3445:109: ( ({...}? => ( (lv_transitions_5_0= ruleTransition ) ) )+ )
            	    // InternalForml.g:3446:6: ({...}? => ( (lv_transitions_5_0= ruleTransition ) ) )+
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getStateMachineAccess().getUnorderedGroup_3(), 1);
            	    	 				
            	    // InternalForml.g:3449:6: ({...}? => ( (lv_transitions_5_0= ruleTransition ) ) )+
            	    int cnt72=0;
            	    loop72:
            	    do {
            	        int alt72=2;
            	        int LA72_0 = input.LA(1);

            	        if ( (LA72_0==61) ) {
            	            int LA72_2 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt72=1;
            	            }


            	        }


            	        switch (alt72) {
            	    	case 1 :
            	    	    // InternalForml.g:3449:7: {...}? => ( (lv_transitions_5_0= ruleTransition ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleStateMachine", "true");
            	    	    }
            	    	    // InternalForml.g:3449:16: ( (lv_transitions_5_0= ruleTransition ) )
            	    	    // InternalForml.g:3450:1: (lv_transitions_5_0= ruleTransition )
            	    	    {
            	    	    // InternalForml.g:3450:1: (lv_transitions_5_0= ruleTransition )
            	    	    // InternalForml.g:3451:3: lv_transitions_5_0= ruleTransition
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getStateMachineAccess().getTransitionsTransitionParserRuleCall_3_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_48);
            	    	    lv_transitions_5_0=ruleTransition();

            	    	    state._fsp--;


            	    	    	        if (current==null) {
            	    	    	            current = createModelElementForParent(grammarAccess.getStateMachineRule());
            	    	    	        }
            	    	           		add(
            	    	           			current, 
            	    	           			"transitions",
            	    	            		lv_transitions_5_0, 
            	    	            		"uw.cs.watform.forml.Forml.Transition");
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt72 >= 1 ) break loop72;
            	                EarlyExitException eee =
            	                    new EarlyExitException(72, input);
            	                throw eee;
            	        }
            	        cnt72++;
            	    } while (true);

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getStateMachineAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt73 >= 1 ) break loop73;
                        EarlyExitException eee =
                            new EarlyExitException(73, input);
                        throw eee;
                }
                cnt73++;
            } while (true);

            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getStateMachineAccess().getUnorderedGroup_3()) ) {
                throw new FailedPredicateException(input, "ruleStateMachine", "getUnorderedGroupHelper().canLeave(grammarAccess.getStateMachineAccess().getUnorderedGroup_3())");
            }

            }


            }

             
            	  getUnorderedGroupHelper().leave(grammarAccess.getStateMachineAccess().getUnorderedGroup_3());
            	

            }

            otherlv_6=(Token)match(input,13,FOLLOW_2); 

                	newLeafNode(otherlv_6, grammarAccess.getStateMachineAccess().getRightCurlyBracketKeyword_4());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStateMachine"


    // $ANTLR start "entryRuleInitState"
    // InternalForml.g:3494:1: entryRuleInitState returns [EObject current=null] : iv_ruleInitState= ruleInitState EOF ;
    public final EObject entryRuleInitState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInitState = null;


        try {
            // InternalForml.g:3495:2: (iv_ruleInitState= ruleInitState EOF )
            // InternalForml.g:3496:2: iv_ruleInitState= ruleInitState EOF
            {
             newCompositeNode(grammarAccess.getInitStateRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInitState=ruleInitState();

            state._fsp--;

             current =iv_ruleInitState; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInitState"


    // $ANTLR start "ruleInitState"
    // InternalForml.g:3503:1: ruleInitState returns [EObject current=null] : ( () otherlv_1= 'init' otherlv_2= '=' ( (otherlv_3= RULE_ID ) )? ) ;
    public final EObject ruleInitState() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // InternalForml.g:3506:28: ( ( () otherlv_1= 'init' otherlv_2= '=' ( (otherlv_3= RULE_ID ) )? ) )
            // InternalForml.g:3507:1: ( () otherlv_1= 'init' otherlv_2= '=' ( (otherlv_3= RULE_ID ) )? )
            {
            // InternalForml.g:3507:1: ( () otherlv_1= 'init' otherlv_2= '=' ( (otherlv_3= RULE_ID ) )? )
            // InternalForml.g:3507:2: () otherlv_1= 'init' otherlv_2= '=' ( (otherlv_3= RULE_ID ) )?
            {
            // InternalForml.g:3507:2: ()
            // InternalForml.g:3508:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getInitStateAccess().getInitStateAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,57,FOLLOW_49); 

                	newLeafNode(otherlv_1, grammarAccess.getInitStateAccess().getInitKeyword_1());
                
            otherlv_2=(Token)match(input,58,FOLLOW_50); 

                	newLeafNode(otherlv_2, grammarAccess.getInitStateAccess().getEqualsSignKeyword_2());
                
            // InternalForml.g:3521:1: ( (otherlv_3= RULE_ID ) )?
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==RULE_ID) ) {
                alt74=1;
            }
            switch (alt74) {
                case 1 :
                    // InternalForml.g:3522:1: (otherlv_3= RULE_ID )
                    {
                    // InternalForml.g:3522:1: (otherlv_3= RULE_ID )
                    // InternalForml.g:3523:3: otherlv_3= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getInitStateRule());
                    	        }
                            
                    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_2); 

                    		newLeafNode(otherlv_3, grammarAccess.getInitStateAccess().getStaterefStateCrossReference_3_0()); 
                    	

                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInitState"


    // $ANTLR start "entryRuleState"
    // InternalForml.g:3542:1: entryRuleState returns [EObject current=null] : iv_ruleState= ruleState EOF ;
    public final EObject entryRuleState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleState = null;


        try {
            // InternalForml.g:3543:2: (iv_ruleState= ruleState EOF )
            // InternalForml.g:3544:2: iv_ruleState= ruleState EOF
            {
             newCompositeNode(grammarAccess.getStateRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleState=ruleState();

            state._fsp--;

             current =iv_ruleState; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleState"


    // $ANTLR start "ruleState"
    // InternalForml.g:3551:1: ruleState returns [EObject current=null] : ( () otherlv_1= 'state' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_regions_4_0= ruleRegion ) )* otherlv_5= '}' ) ;
    public final EObject ruleState() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_regions_4_0 = null;


         enterRule(); 
            
        try {
            // InternalForml.g:3554:28: ( ( () otherlv_1= 'state' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_regions_4_0= ruleRegion ) )* otherlv_5= '}' ) )
            // InternalForml.g:3555:1: ( () otherlv_1= 'state' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_regions_4_0= ruleRegion ) )* otherlv_5= '}' )
            {
            // InternalForml.g:3555:1: ( () otherlv_1= 'state' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_regions_4_0= ruleRegion ) )* otherlv_5= '}' )
            // InternalForml.g:3555:2: () otherlv_1= 'state' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_regions_4_0= ruleRegion ) )* otherlv_5= '}'
            {
            // InternalForml.g:3555:2: ()
            // InternalForml.g:3556:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getStateAccess().getStateAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,59,FOLLOW_10); 

                	newLeafNode(otherlv_1, grammarAccess.getStateAccess().getStateKeyword_1());
                
            // InternalForml.g:3565:1: ( (lv_name_2_0= RULE_ID ) )
            // InternalForml.g:3566:1: (lv_name_2_0= RULE_ID )
            {
            // InternalForml.g:3566:1: (lv_name_2_0= RULE_ID )
            // InternalForml.g:3567:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            			newLeafNode(lv_name_2_0, grammarAccess.getStateAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getStateRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            otherlv_3=(Token)match(input,12,FOLLOW_51); 

                	newLeafNode(otherlv_3, grammarAccess.getStateAccess().getLeftCurlyBracketKeyword_3());
                
            // InternalForml.g:3587:1: ( (lv_regions_4_0= ruleRegion ) )*
            loop75:
            do {
                int alt75=2;
                int LA75_0 = input.LA(1);

                if ( (LA75_0==60) ) {
                    alt75=1;
                }


                switch (alt75) {
            	case 1 :
            	    // InternalForml.g:3588:1: (lv_regions_4_0= ruleRegion )
            	    {
            	    // InternalForml.g:3588:1: (lv_regions_4_0= ruleRegion )
            	    // InternalForml.g:3589:3: lv_regions_4_0= ruleRegion
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStateAccess().getRegionsRegionParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_51);
            	    lv_regions_4_0=ruleRegion();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getStateRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"regions",
            	            		lv_regions_4_0, 
            	            		"uw.cs.watform.forml.Forml.Region");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop75;
                }
            } while (true);

            otherlv_5=(Token)match(input,13,FOLLOW_2); 

                	newLeafNode(otherlv_5, grammarAccess.getStateAccess().getRightCurlyBracketKeyword_5());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleState"


    // $ANTLR start "entryRuleRegion"
    // InternalForml.g:3617:1: entryRuleRegion returns [EObject current=null] : iv_ruleRegion= ruleRegion EOF ;
    public final EObject entryRuleRegion() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRegion = null;


        try {
            // InternalForml.g:3618:2: (iv_ruleRegion= ruleRegion EOF )
            // InternalForml.g:3619:2: iv_ruleRegion= ruleRegion EOF
            {
             newCompositeNode(grammarAccess.getRegionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRegion=ruleRegion();

            state._fsp--;

             current =iv_ruleRegion; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRegion"


    // $ANTLR start "ruleRegion"
    // InternalForml.g:3626:1: ruleRegion returns [EObject current=null] : ( () otherlv_1= 'region' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_init_4_0= ruleInitState ) )? ( (lv_states_5_0= ruleState ) )* otherlv_6= '}' ) ;
    public final EObject ruleRegion() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_6=null;
        EObject lv_init_4_0 = null;

        EObject lv_states_5_0 = null;


         enterRule(); 
            
        try {
            // InternalForml.g:3629:28: ( ( () otherlv_1= 'region' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_init_4_0= ruleInitState ) )? ( (lv_states_5_0= ruleState ) )* otherlv_6= '}' ) )
            // InternalForml.g:3630:1: ( () otherlv_1= 'region' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_init_4_0= ruleInitState ) )? ( (lv_states_5_0= ruleState ) )* otherlv_6= '}' )
            {
            // InternalForml.g:3630:1: ( () otherlv_1= 'region' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_init_4_0= ruleInitState ) )? ( (lv_states_5_0= ruleState ) )* otherlv_6= '}' )
            // InternalForml.g:3630:2: () otherlv_1= 'region' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_init_4_0= ruleInitState ) )? ( (lv_states_5_0= ruleState ) )* otherlv_6= '}'
            {
            // InternalForml.g:3630:2: ()
            // InternalForml.g:3631:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getRegionAccess().getRegionAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,60,FOLLOW_10); 

                	newLeafNode(otherlv_1, grammarAccess.getRegionAccess().getRegionKeyword_1());
                
            // InternalForml.g:3640:1: ( (lv_name_2_0= RULE_ID ) )
            // InternalForml.g:3641:1: (lv_name_2_0= RULE_ID )
            {
            // InternalForml.g:3641:1: (lv_name_2_0= RULE_ID )
            // InternalForml.g:3642:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            			newLeafNode(lv_name_2_0, grammarAccess.getRegionAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getRegionRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            otherlv_3=(Token)match(input,12,FOLLOW_52); 

                	newLeafNode(otherlv_3, grammarAccess.getRegionAccess().getLeftCurlyBracketKeyword_3());
                
            // InternalForml.g:3662:1: ( (lv_init_4_0= ruleInitState ) )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==57) ) {
                alt76=1;
            }
            switch (alt76) {
                case 1 :
                    // InternalForml.g:3663:1: (lv_init_4_0= ruleInitState )
                    {
                    // InternalForml.g:3663:1: (lv_init_4_0= ruleInitState )
                    // InternalForml.g:3664:3: lv_init_4_0= ruleInitState
                    {
                     
                    	        newCompositeNode(grammarAccess.getRegionAccess().getInitInitStateParserRuleCall_4_0()); 
                    	    
                    pushFollow(FOLLOW_53);
                    lv_init_4_0=ruleInitState();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRegionRule());
                    	        }
                           		set(
                           			current, 
                           			"init",
                            		lv_init_4_0, 
                            		"uw.cs.watform.forml.Forml.InitState");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // InternalForml.g:3680:3: ( (lv_states_5_0= ruleState ) )*
            loop77:
            do {
                int alt77=2;
                int LA77_0 = input.LA(1);

                if ( (LA77_0==59) ) {
                    alt77=1;
                }


                switch (alt77) {
            	case 1 :
            	    // InternalForml.g:3681:1: (lv_states_5_0= ruleState )
            	    {
            	    // InternalForml.g:3681:1: (lv_states_5_0= ruleState )
            	    // InternalForml.g:3682:3: lv_states_5_0= ruleState
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRegionAccess().getStatesStateParserRuleCall_5_0()); 
            	    	    
            	    pushFollow(FOLLOW_53);
            	    lv_states_5_0=ruleState();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRegionRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"states",
            	            		lv_states_5_0, 
            	            		"uw.cs.watform.forml.Forml.State");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop77;
                }
            } while (true);

            otherlv_6=(Token)match(input,13,FOLLOW_2); 

                	newLeafNode(otherlv_6, grammarAccess.getRegionAccess().getRightCurlyBracketKeyword_6());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRegion"


    // $ANTLR start "entryRuleTransition"
    // InternalForml.g:3710:1: entryRuleTransition returns [EObject current=null] : iv_ruleTransition= ruleTransition EOF ;
    public final EObject entryRuleTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransition = null;


        try {
            // InternalForml.g:3711:2: (iv_ruleTransition= ruleTransition EOF )
            // InternalForml.g:3712:2: iv_ruleTransition= ruleTransition EOF
            {
             newCompositeNode(grammarAccess.getTransitionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTransition=ruleTransition();

            state._fsp--;

             current =iv_ruleTransition; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTransition"


    // $ANTLR start "ruleTransition"
    // InternalForml.g:3719:1: ruleTransition returns [EObject current=null] : ( () otherlv_1= 'transition' ( (lv_name_2_0= RULE_ID ) ) ( (lv_priority_3_0= rulePriority ) )? otherlv_4= ':' ( ( ruleQualifiedName ) ) otherlv_6= '->' ( ( ruleQualifiedName ) ) otherlv_8= '{' ( (lv_trig_9_0= ruleTrigger ) )? ( (lv_guard_10_0= ruleGuard ) )? ( (lv_list_11_0= ruleWCAList ) )? otherlv_12= '}' ) ;
    public final EObject ruleTransition() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_12=null;
        EObject lv_priority_3_0 = null;

        EObject lv_trig_9_0 = null;

        EObject lv_guard_10_0 = null;

        EObject lv_list_11_0 = null;


         enterRule(); 
            
        try {
            // InternalForml.g:3722:28: ( ( () otherlv_1= 'transition' ( (lv_name_2_0= RULE_ID ) ) ( (lv_priority_3_0= rulePriority ) )? otherlv_4= ':' ( ( ruleQualifiedName ) ) otherlv_6= '->' ( ( ruleQualifiedName ) ) otherlv_8= '{' ( (lv_trig_9_0= ruleTrigger ) )? ( (lv_guard_10_0= ruleGuard ) )? ( (lv_list_11_0= ruleWCAList ) )? otherlv_12= '}' ) )
            // InternalForml.g:3723:1: ( () otherlv_1= 'transition' ( (lv_name_2_0= RULE_ID ) ) ( (lv_priority_3_0= rulePriority ) )? otherlv_4= ':' ( ( ruleQualifiedName ) ) otherlv_6= '->' ( ( ruleQualifiedName ) ) otherlv_8= '{' ( (lv_trig_9_0= ruleTrigger ) )? ( (lv_guard_10_0= ruleGuard ) )? ( (lv_list_11_0= ruleWCAList ) )? otherlv_12= '}' )
            {
            // InternalForml.g:3723:1: ( () otherlv_1= 'transition' ( (lv_name_2_0= RULE_ID ) ) ( (lv_priority_3_0= rulePriority ) )? otherlv_4= ':' ( ( ruleQualifiedName ) ) otherlv_6= '->' ( ( ruleQualifiedName ) ) otherlv_8= '{' ( (lv_trig_9_0= ruleTrigger ) )? ( (lv_guard_10_0= ruleGuard ) )? ( (lv_list_11_0= ruleWCAList ) )? otherlv_12= '}' )
            // InternalForml.g:3723:2: () otherlv_1= 'transition' ( (lv_name_2_0= RULE_ID ) ) ( (lv_priority_3_0= rulePriority ) )? otherlv_4= ':' ( ( ruleQualifiedName ) ) otherlv_6= '->' ( ( ruleQualifiedName ) ) otherlv_8= '{' ( (lv_trig_9_0= ruleTrigger ) )? ( (lv_guard_10_0= ruleGuard ) )? ( (lv_list_11_0= ruleWCAList ) )? otherlv_12= '}'
            {
            // InternalForml.g:3723:2: ()
            // InternalForml.g:3724:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getTransitionAccess().getTransitionAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,61,FOLLOW_10); 

                	newLeafNode(otherlv_1, grammarAccess.getTransitionAccess().getTransitionKeyword_1());
                
            // InternalForml.g:3733:1: ( (lv_name_2_0= RULE_ID ) )
            // InternalForml.g:3734:1: (lv_name_2_0= RULE_ID )
            {
            // InternalForml.g:3734:1: (lv_name_2_0= RULE_ID )
            // InternalForml.g:3735:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_54); 

            			newLeafNode(lv_name_2_0, grammarAccess.getTransitionAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getTransitionRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            // InternalForml.g:3751:2: ( (lv_priority_3_0= rulePriority ) )?
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==63) ) {
                alt78=1;
            }
            switch (alt78) {
                case 1 :
                    // InternalForml.g:3752:1: (lv_priority_3_0= rulePriority )
                    {
                    // InternalForml.g:3752:1: (lv_priority_3_0= rulePriority )
                    // InternalForml.g:3753:3: lv_priority_3_0= rulePriority
                    {
                     
                    	        newCompositeNode(grammarAccess.getTransitionAccess().getPriorityPriorityParserRuleCall_3_0()); 
                    	    
                    pushFollow(FOLLOW_22);
                    lv_priority_3_0=rulePriority();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getTransitionRule());
                    	        }
                           		set(
                           			current, 
                           			"priority",
                            		lv_priority_3_0, 
                            		"uw.cs.watform.forml.Forml.Priority");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,23,FOLLOW_10); 

                	newLeafNode(otherlv_4, grammarAccess.getTransitionAccess().getColonKeyword_4());
                
            // InternalForml.g:3773:1: ( ( ruleQualifiedName ) )
            // InternalForml.g:3774:1: ( ruleQualifiedName )
            {
            // InternalForml.g:3774:1: ( ruleQualifiedName )
            // InternalForml.g:3775:3: ruleQualifiedName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getTransitionRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getTransitionAccess().getSrcStateCrossReference_5_0()); 
            	    
            pushFollow(FOLLOW_55);
            ruleQualifiedName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_6=(Token)match(input,62,FOLLOW_10); 

                	newLeafNode(otherlv_6, grammarAccess.getTransitionAccess().getHyphenMinusGreaterThanSignKeyword_6());
                
            // InternalForml.g:3792:1: ( ( ruleQualifiedName ) )
            // InternalForml.g:3793:1: ( ruleQualifiedName )
            {
            // InternalForml.g:3793:1: ( ruleQualifiedName )
            // InternalForml.g:3794:3: ruleQualifiedName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getTransitionRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getTransitionAccess().getDstStateCrossReference_7_0()); 
            	    
            pushFollow(FOLLOW_4);
            ruleQualifiedName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_8=(Token)match(input,12,FOLLOW_56); 

                	newLeafNode(otherlv_8, grammarAccess.getTransitionAccess().getLeftCurlyBracketKeyword_8());
                
            // InternalForml.g:3811:1: ( (lv_trig_9_0= ruleTrigger ) )?
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==65) ) {
                alt79=1;
            }
            switch (alt79) {
                case 1 :
                    // InternalForml.g:3812:1: (lv_trig_9_0= ruleTrigger )
                    {
                    // InternalForml.g:3812:1: (lv_trig_9_0= ruleTrigger )
                    // InternalForml.g:3813:3: lv_trig_9_0= ruleTrigger
                    {
                     
                    	        newCompositeNode(grammarAccess.getTransitionAccess().getTrigTriggerParserRuleCall_9_0()); 
                    	    
                    pushFollow(FOLLOW_57);
                    lv_trig_9_0=ruleTrigger();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getTransitionRule());
                    	        }
                           		set(
                           			current, 
                           			"trig",
                            		lv_trig_9_0, 
                            		"uw.cs.watform.forml.Forml.Trigger");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // InternalForml.g:3829:3: ( (lv_guard_10_0= ruleGuard ) )?
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==21||LA80_0==64) ) {
                alt80=1;
            }
            switch (alt80) {
                case 1 :
                    // InternalForml.g:3830:1: (lv_guard_10_0= ruleGuard )
                    {
                    // InternalForml.g:3830:1: (lv_guard_10_0= ruleGuard )
                    // InternalForml.g:3831:3: lv_guard_10_0= ruleGuard
                    {
                     
                    	        newCompositeNode(grammarAccess.getTransitionAccess().getGuardGuardParserRuleCall_10_0()); 
                    	    
                    pushFollow(FOLLOW_58);
                    lv_guard_10_0=ruleGuard();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getTransitionRule());
                    	        }
                           		set(
                           			current, 
                           			"guard",
                            		lv_guard_10_0, 
                            		"uw.cs.watform.forml.Forml.Guard");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // InternalForml.g:3847:3: ( (lv_list_11_0= ruleWCAList ) )?
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==71) ) {
                alt81=1;
            }
            switch (alt81) {
                case 1 :
                    // InternalForml.g:3848:1: (lv_list_11_0= ruleWCAList )
                    {
                    // InternalForml.g:3848:1: (lv_list_11_0= ruleWCAList )
                    // InternalForml.g:3849:3: lv_list_11_0= ruleWCAList
                    {
                     
                    	        newCompositeNode(grammarAccess.getTransitionAccess().getListWCAListParserRuleCall_11_0()); 
                    	    
                    pushFollow(FOLLOW_6);
                    lv_list_11_0=ruleWCAList();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getTransitionRule());
                    	        }
                           		set(
                           			current, 
                           			"list",
                            		lv_list_11_0, 
                            		"uw.cs.watform.forml.Forml.WCAList");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_12=(Token)match(input,13,FOLLOW_2); 

                	newLeafNode(otherlv_12, grammarAccess.getTransitionAccess().getRightCurlyBracketKeyword_12());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTransition"


    // $ANTLR start "entryRulePriority"
    // InternalForml.g:3877:1: entryRulePriority returns [EObject current=null] : iv_rulePriority= rulePriority EOF ;
    public final EObject entryRulePriority() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePriority = null;


        try {
            // InternalForml.g:3878:2: (iv_rulePriority= rulePriority EOF )
            // InternalForml.g:3879:2: iv_rulePriority= rulePriority EOF
            {
             newCompositeNode(grammarAccess.getPriorityRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePriority=rulePriority();

            state._fsp--;

             current =iv_rulePriority; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePriority"


    // $ANTLR start "rulePriority"
    // InternalForml.g:3886:1: rulePriority returns [EObject current=null] : (otherlv_0= '>' ( (lv_translist_1_0= ruleTransList ) ) ) ;
    public final EObject rulePriority() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_translist_1_0 = null;


         enterRule(); 
            
        try {
            // InternalForml.g:3889:28: ( (otherlv_0= '>' ( (lv_translist_1_0= ruleTransList ) ) ) )
            // InternalForml.g:3890:1: (otherlv_0= '>' ( (lv_translist_1_0= ruleTransList ) ) )
            {
            // InternalForml.g:3890:1: (otherlv_0= '>' ( (lv_translist_1_0= ruleTransList ) ) )
            // InternalForml.g:3890:3: otherlv_0= '>' ( (lv_translist_1_0= ruleTransList ) )
            {
            otherlv_0=(Token)match(input,63,FOLLOW_10); 

                	newLeafNode(otherlv_0, grammarAccess.getPriorityAccess().getGreaterThanSignKeyword_0());
                
            // InternalForml.g:3894:1: ( (lv_translist_1_0= ruleTransList ) )
            // InternalForml.g:3895:1: (lv_translist_1_0= ruleTransList )
            {
            // InternalForml.g:3895:1: (lv_translist_1_0= ruleTransList )
            // InternalForml.g:3896:3: lv_translist_1_0= ruleTransList
            {
             
            	        newCompositeNode(grammarAccess.getPriorityAccess().getTranslistTransListParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_2);
            lv_translist_1_0=ruleTransList();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getPriorityRule());
            	        }
                   		set(
                   			current, 
                   			"translist",
                    		lv_translist_1_0, 
                    		"uw.cs.watform.forml.Forml.TransList");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePriority"


    // $ANTLR start "entryRuleTransList"
    // InternalForml.g:3920:1: entryRuleTransList returns [EObject current=null] : iv_ruleTransList= ruleTransList EOF ;
    public final EObject entryRuleTransList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransList = null;


        try {
            // InternalForml.g:3921:2: (iv_ruleTransList= ruleTransList EOF )
            // InternalForml.g:3922:2: iv_ruleTransList= ruleTransList EOF
            {
             newCompositeNode(grammarAccess.getTransListRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTransList=ruleTransList();

            state._fsp--;

             current =iv_ruleTransList; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTransList"


    // $ANTLR start "ruleTransList"
    // InternalForml.g:3929:1: ruleTransList returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= ',' ( (otherlv_2= RULE_ID ) ) )* ) ;
    public final EObject ruleTransList() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // InternalForml.g:3932:28: ( ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= ',' ( (otherlv_2= RULE_ID ) ) )* ) )
            // InternalForml.g:3933:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= ',' ( (otherlv_2= RULE_ID ) ) )* )
            {
            // InternalForml.g:3933:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= ',' ( (otherlv_2= RULE_ID ) ) )* )
            // InternalForml.g:3933:2: ( (otherlv_0= RULE_ID ) ) (otherlv_1= ',' ( (otherlv_2= RULE_ID ) ) )*
            {
            // InternalForml.g:3933:2: ( (otherlv_0= RULE_ID ) )
            // InternalForml.g:3934:1: (otherlv_0= RULE_ID )
            {
            // InternalForml.g:3934:1: (otherlv_0= RULE_ID )
            // InternalForml.g:3935:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getTransListRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_59); 

            		newLeafNode(otherlv_0, grammarAccess.getTransListAccess().getTransitionsTransitionCrossReference_0_0()); 
            	

            }


            }

            // InternalForml.g:3946:2: (otherlv_1= ',' ( (otherlv_2= RULE_ID ) ) )*
            loop82:
            do {
                int alt82=2;
                int LA82_0 = input.LA(1);

                if ( (LA82_0==45) ) {
                    alt82=1;
                }


                switch (alt82) {
            	case 1 :
            	    // InternalForml.g:3946:4: otherlv_1= ',' ( (otherlv_2= RULE_ID ) )
            	    {
            	    otherlv_1=(Token)match(input,45,FOLLOW_10); 

            	        	newLeafNode(otherlv_1, grammarAccess.getTransListAccess().getCommaKeyword_1_0());
            	        
            	    // InternalForml.g:3950:1: ( (otherlv_2= RULE_ID ) )
            	    // InternalForml.g:3951:1: (otherlv_2= RULE_ID )
            	    {
            	    // InternalForml.g:3951:1: (otherlv_2= RULE_ID )
            	    // InternalForml.g:3952:3: otherlv_2= RULE_ID
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getTransListRule());
            	    	        }
            	            
            	    otherlv_2=(Token)match(input,RULE_ID,FOLLOW_59); 

            	    		newLeafNode(otherlv_2, grammarAccess.getTransListAccess().getTransitionsTransitionCrossReference_1_1_0()); 
            	    	

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop82;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTransList"


    // $ANTLR start "entryRuleGuard"
    // InternalForml.g:3971:1: entryRuleGuard returns [EObject current=null] : iv_ruleGuard= ruleGuard EOF ;
    public final EObject entryRuleGuard() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGuard = null;


        try {
            // InternalForml.g:3972:2: (iv_ruleGuard= ruleGuard EOF )
            // InternalForml.g:3973:2: iv_ruleGuard= ruleGuard EOF
            {
             newCompositeNode(grammarAccess.getGuardRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleGuard=ruleGuard();

            state._fsp--;

             current =iv_ruleGuard; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGuard"


    // $ANTLR start "ruleGuard"
    // InternalForml.g:3980:1: ruleGuard returns [EObject current=null] : ( () ( (otherlv_1= '[' ( (lv_predicate_2_0= rulePredicate ) )? otherlv_3= ']' ) | otherlv_4= '[]' ) ) ;
    public final EObject ruleGuard() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        EObject lv_predicate_2_0 = null;


         enterRule(); 
            
        try {
            // InternalForml.g:3983:28: ( ( () ( (otherlv_1= '[' ( (lv_predicate_2_0= rulePredicate ) )? otherlv_3= ']' ) | otherlv_4= '[]' ) ) )
            // InternalForml.g:3984:1: ( () ( (otherlv_1= '[' ( (lv_predicate_2_0= rulePredicate ) )? otherlv_3= ']' ) | otherlv_4= '[]' ) )
            {
            // InternalForml.g:3984:1: ( () ( (otherlv_1= '[' ( (lv_predicate_2_0= rulePredicate ) )? otherlv_3= ']' ) | otherlv_4= '[]' ) )
            // InternalForml.g:3984:2: () ( (otherlv_1= '[' ( (lv_predicate_2_0= rulePredicate ) )? otherlv_3= ']' ) | otherlv_4= '[]' )
            {
            // InternalForml.g:3984:2: ()
            // InternalForml.g:3985:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getGuardAccess().getGuardAction_0(),
                        current);
                

            }

            // InternalForml.g:3990:2: ( (otherlv_1= '[' ( (lv_predicate_2_0= rulePredicate ) )? otherlv_3= ']' ) | otherlv_4= '[]' )
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==21) ) {
                alt84=1;
            }
            else if ( (LA84_0==64) ) {
                alt84=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 84, 0, input);

                throw nvae;
            }
            switch (alt84) {
                case 1 :
                    // InternalForml.g:3990:3: (otherlv_1= '[' ( (lv_predicate_2_0= rulePredicate ) )? otherlv_3= ']' )
                    {
                    // InternalForml.g:3990:3: (otherlv_1= '[' ( (lv_predicate_2_0= rulePredicate ) )? otherlv_3= ']' )
                    // InternalForml.g:3990:5: otherlv_1= '[' ( (lv_predicate_2_0= rulePredicate ) )? otherlv_3= ']'
                    {
                    otherlv_1=(Token)match(input,21,FOLLOW_60); 

                        	newLeafNode(otherlv_1, grammarAccess.getGuardAccess().getLeftSquareBracketKeyword_1_0_0());
                        
                    // InternalForml.g:3994:1: ( (lv_predicate_2_0= rulePredicate ) )?
                    int alt83=2;
                    int LA83_0 = input.LA(1);

                    if ( ((LA83_0>=RULE_ID && LA83_0<=RULE_INT)||LA83_0==67||(LA83_0>=75 && LA83_0<=79)||LA83_0==81||(LA83_0>=96 && LA83_0<=97)) ) {
                        alt83=1;
                    }
                    switch (alt83) {
                        case 1 :
                            // InternalForml.g:3995:1: (lv_predicate_2_0= rulePredicate )
                            {
                            // InternalForml.g:3995:1: (lv_predicate_2_0= rulePredicate )
                            // InternalForml.g:3996:3: lv_predicate_2_0= rulePredicate
                            {
                             
                            	        newCompositeNode(grammarAccess.getGuardAccess().getPredicatePredicateParserRuleCall_1_0_1_0()); 
                            	    
                            pushFollow(FOLLOW_21);
                            lv_predicate_2_0=rulePredicate();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getGuardRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"predicate",
                                    		lv_predicate_2_0, 
                                    		"uw.cs.watform.forml.Forml.Predicate");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }
                            break;

                    }

                    otherlv_3=(Token)match(input,22,FOLLOW_2); 

                        	newLeafNode(otherlv_3, grammarAccess.getGuardAccess().getRightSquareBracketKeyword_1_0_2());
                        

                    }


                    }
                    break;
                case 2 :
                    // InternalForml.g:4017:7: otherlv_4= '[]'
                    {
                    otherlv_4=(Token)match(input,64,FOLLOW_2); 

                        	newLeafNode(otherlv_4, grammarAccess.getGuardAccess().getLeftSquareBracketRightSquareBracketKeyword_1_1());
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGuard"


    // $ANTLR start "entryRuleTrigger"
    // InternalForml.g:4029:1: entryRuleTrigger returns [EObject current=null] : iv_ruleTrigger= ruleTrigger EOF ;
    public final EObject entryRuleTrigger() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTrigger = null;


        try {
            // InternalForml.g:4030:2: (iv_ruleTrigger= ruleTrigger EOF )
            // InternalForml.g:4031:2: iv_ruleTrigger= ruleTrigger EOF
            {
             newCompositeNode(grammarAccess.getTriggerRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTrigger=ruleTrigger();

            state._fsp--;

             current =iv_ruleTrigger; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTrigger"


    // $ANTLR start "ruleTrigger"
    // InternalForml.g:4038:1: ruleTrigger returns [EObject current=null] : ( () otherlv_1= 'event:' ( ( (lv_override_2_0= ruleOverride ) ) | ( (lv_wce_3_0= ruleWCE ) ) )? ) ;
    public final EObject ruleTrigger() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_override_2_0 = null;

        EObject lv_wce_3_0 = null;


         enterRule(); 
            
        try {
            // InternalForml.g:4041:28: ( ( () otherlv_1= 'event:' ( ( (lv_override_2_0= ruleOverride ) ) | ( (lv_wce_3_0= ruleWCE ) ) )? ) )
            // InternalForml.g:4042:1: ( () otherlv_1= 'event:' ( ( (lv_override_2_0= ruleOverride ) ) | ( (lv_wce_3_0= ruleWCE ) ) )? )
            {
            // InternalForml.g:4042:1: ( () otherlv_1= 'event:' ( ( (lv_override_2_0= ruleOverride ) ) | ( (lv_wce_3_0= ruleWCE ) ) )? )
            // InternalForml.g:4042:2: () otherlv_1= 'event:' ( ( (lv_override_2_0= ruleOverride ) ) | ( (lv_wce_3_0= ruleWCE ) ) )?
            {
            // InternalForml.g:4042:2: ()
            // InternalForml.g:4043:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getTriggerAccess().getTriggerAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,65,FOLLOW_61); 

                	newLeafNode(otherlv_1, grammarAccess.getTriggerAccess().getEventKeyword_1());
                
            // InternalForml.g:4052:1: ( ( (lv_override_2_0= ruleOverride ) ) | ( (lv_wce_3_0= ruleWCE ) ) )?
            int alt85=3;
            int LA85_0 = input.LA(1);

            if ( (LA85_0==66) ) {
                alt85=1;
            }
            else if ( (LA85_0==RULE_ID) ) {
                alt85=2;
            }
            switch (alt85) {
                case 1 :
                    // InternalForml.g:4052:2: ( (lv_override_2_0= ruleOverride ) )
                    {
                    // InternalForml.g:4052:2: ( (lv_override_2_0= ruleOverride ) )
                    // InternalForml.g:4053:1: (lv_override_2_0= ruleOverride )
                    {
                    // InternalForml.g:4053:1: (lv_override_2_0= ruleOverride )
                    // InternalForml.g:4054:3: lv_override_2_0= ruleOverride
                    {
                     
                    	        newCompositeNode(grammarAccess.getTriggerAccess().getOverrideOverrideParserRuleCall_2_0_0()); 
                    	    
                    pushFollow(FOLLOW_2);
                    lv_override_2_0=ruleOverride();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getTriggerRule());
                    	        }
                           		set(
                           			current, 
                           			"override",
                            		lv_override_2_0, 
                            		"uw.cs.watform.forml.Forml.Override");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalForml.g:4071:6: ( (lv_wce_3_0= ruleWCE ) )
                    {
                    // InternalForml.g:4071:6: ( (lv_wce_3_0= ruleWCE ) )
                    // InternalForml.g:4072:1: (lv_wce_3_0= ruleWCE )
                    {
                    // InternalForml.g:4072:1: (lv_wce_3_0= ruleWCE )
                    // InternalForml.g:4073:3: lv_wce_3_0= ruleWCE
                    {
                     
                    	        newCompositeNode(grammarAccess.getTriggerAccess().getWceWCEParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_2);
                    lv_wce_3_0=ruleWCE();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getTriggerRule());
                    	        }
                           		set(
                           			current, 
                           			"wce",
                            		lv_wce_3_0, 
                            		"uw.cs.watform.forml.Forml.WCE");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTrigger"


    // $ANTLR start "entryRuleOverride"
    // InternalForml.g:4097:1: entryRuleOverride returns [EObject current=null] : iv_ruleOverride= ruleOverride EOF ;
    public final EObject entryRuleOverride() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOverride = null;


        try {
            // InternalForml.g:4098:2: (iv_ruleOverride= ruleOverride EOF )
            // InternalForml.g:4099:2: iv_ruleOverride= ruleOverride EOF
            {
             newCompositeNode(grammarAccess.getOverrideRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOverride=ruleOverride();

            state._fsp--;

             current =iv_ruleOverride; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOverride"


    // $ANTLR start "ruleOverride"
    // InternalForml.g:4106:1: ruleOverride returns [EObject current=null] : (otherlv_0= 'override' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ')' ) ;
    public final EObject ruleOverride() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // InternalForml.g:4109:28: ( (otherlv_0= 'override' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ')' ) )
            // InternalForml.g:4110:1: (otherlv_0= 'override' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ')' )
            {
            // InternalForml.g:4110:1: (otherlv_0= 'override' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ')' )
            // InternalForml.g:4110:3: otherlv_0= 'override' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,66,FOLLOW_62); 

                	newLeafNode(otherlv_0, grammarAccess.getOverrideAccess().getOverrideKeyword_0());
                
            otherlv_1=(Token)match(input,67,FOLLOW_10); 

                	newLeafNode(otherlv_1, grammarAccess.getOverrideAccess().getLeftParenthesisKeyword_1());
                
            // InternalForml.g:4118:1: ( (otherlv_2= RULE_ID ) )
            // InternalForml.g:4119:1: (otherlv_2= RULE_ID )
            {
            // InternalForml.g:4119:1: (otherlv_2= RULE_ID )
            // InternalForml.g:4120:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getOverrideRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_63); 

            		newLeafNode(otherlv_2, grammarAccess.getOverrideAccess().getTransitionTransitionCrossReference_2_0()); 
            	

            }


            }

            otherlv_3=(Token)match(input,68,FOLLOW_2); 

                	newLeafNode(otherlv_3, grammarAccess.getOverrideAccess().getRightParenthesisKeyword_3());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOverride"


    // $ANTLR start "entryRuleWCE"
    // InternalForml.g:4143:1: entryRuleWCE returns [EObject current=null] : iv_ruleWCE= ruleWCE EOF ;
    public final EObject entryRuleWCE() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWCE = null;


        try {
            // InternalForml.g:4144:2: (iv_ruleWCE= ruleWCE EOF )
            // InternalForml.g:4145:2: iv_ruleWCE= ruleWCE EOF
            {
             newCompositeNode(grammarAccess.getWCERule()); 
            pushFollow(FOLLOW_1);
            iv_ruleWCE=ruleWCE();

            state._fsp--;

             current =iv_ruleWCE; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleWCE"


    // $ANTLR start "ruleWCE"
    // InternalForml.g:4152:1: ruleWCE returns [EObject current=null] : ( ( ( ( ruleQualifiedName ) ) otherlv_1= '+' ) | ( ( ruleQualifiedName ) ) | ( ( ( ruleQualifiedName ) ) otherlv_4= '-' ) ) ;
    public final EObject ruleWCE() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;

         enterRule(); 
            
        try {
            // InternalForml.g:4155:28: ( ( ( ( ( ruleQualifiedName ) ) otherlv_1= '+' ) | ( ( ruleQualifiedName ) ) | ( ( ( ruleQualifiedName ) ) otherlv_4= '-' ) ) )
            // InternalForml.g:4156:1: ( ( ( ( ruleQualifiedName ) ) otherlv_1= '+' ) | ( ( ruleQualifiedName ) ) | ( ( ( ruleQualifiedName ) ) otherlv_4= '-' ) )
            {
            // InternalForml.g:4156:1: ( ( ( ( ruleQualifiedName ) ) otherlv_1= '+' ) | ( ( ruleQualifiedName ) ) | ( ( ( ruleQualifiedName ) ) otherlv_4= '-' ) )
            int alt86=3;
            alt86 = dfa86.predict(input);
            switch (alt86) {
                case 1 :
                    // InternalForml.g:4156:2: ( ( ( ruleQualifiedName ) ) otherlv_1= '+' )
                    {
                    // InternalForml.g:4156:2: ( ( ( ruleQualifiedName ) ) otherlv_1= '+' )
                    // InternalForml.g:4156:3: ( ( ruleQualifiedName ) ) otherlv_1= '+'
                    {
                    // InternalForml.g:4156:3: ( ( ruleQualifiedName ) )
                    // InternalForml.g:4157:1: ( ruleQualifiedName )
                    {
                    // InternalForml.g:4157:1: ( ruleQualifiedName )
                    // InternalForml.g:4158:3: ruleQualifiedName
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getWCERule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getWCEAccess().getAddobjExprRefCrossReference_0_0_0()); 
                    	    
                    pushFollow(FOLLOW_64);
                    ruleQualifiedName();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_1=(Token)match(input,69,FOLLOW_2); 

                        	newLeafNode(otherlv_1, grammarAccess.getWCEAccess().getPlusSignKeyword_0_1());
                        

                    }


                    }
                    break;
                case 2 :
                    // InternalForml.g:4176:6: ( ( ruleQualifiedName ) )
                    {
                    // InternalForml.g:4176:6: ( ( ruleQualifiedName ) )
                    // InternalForml.g:4177:1: ( ruleQualifiedName )
                    {
                    // InternalForml.g:4177:1: ( ruleQualifiedName )
                    // InternalForml.g:4178:3: ruleQualifiedName
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getWCERule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getWCEAccess().getAttrAttributeCrossReference_1_0()); 
                    	    
                    pushFollow(FOLLOW_2);
                    ruleQualifiedName();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalForml.g:4192:6: ( ( ( ruleQualifiedName ) ) otherlv_4= '-' )
                    {
                    // InternalForml.g:4192:6: ( ( ( ruleQualifiedName ) ) otherlv_4= '-' )
                    // InternalForml.g:4192:7: ( ( ruleQualifiedName ) ) otherlv_4= '-'
                    {
                    // InternalForml.g:4192:7: ( ( ruleQualifiedName ) )
                    // InternalForml.g:4193:1: ( ruleQualifiedName )
                    {
                    // InternalForml.g:4193:1: ( ruleQualifiedName )
                    // InternalForml.g:4194:3: ruleQualifiedName
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getWCERule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getWCEAccess().getRemobjExprRefCrossReference_2_0_0()); 
                    	    
                    pushFollow(FOLLOW_65);
                    ruleQualifiedName();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_4=(Token)match(input,70,FOLLOW_2); 

                        	newLeafNode(otherlv_4, grammarAccess.getWCEAccess().getHyphenMinusKeyword_2_1());
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleWCE"


    // $ANTLR start "entryRuleWCAList"
    // InternalForml.g:4219:1: entryRuleWCAList returns [EObject current=null] : iv_ruleWCAList= ruleWCAList EOF ;
    public final EObject entryRuleWCAList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWCAList = null;


        try {
            // InternalForml.g:4220:2: (iv_ruleWCAList= ruleWCAList EOF )
            // InternalForml.g:4221:2: iv_ruleWCAList= ruleWCAList EOF
            {
             newCompositeNode(grammarAccess.getWCAListRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleWCAList=ruleWCAList();

            state._fsp--;

             current =iv_ruleWCAList; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleWCAList"


    // $ANTLR start "ruleWCAList"
    // InternalForml.g:4228:1: ruleWCAList returns [EObject current=null] : ( () otherlv_1= '/' ( ( (lv_actions_2_0= ruleWCA ) ) (otherlv_3= ',' ( (lv_actions_4_0= ruleWCA ) ) )* )? ) ;
    public final EObject ruleWCAList() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_actions_2_0 = null;

        EObject lv_actions_4_0 = null;


         enterRule(); 
            
        try {
            // InternalForml.g:4231:28: ( ( () otherlv_1= '/' ( ( (lv_actions_2_0= ruleWCA ) ) (otherlv_3= ',' ( (lv_actions_4_0= ruleWCA ) ) )* )? ) )
            // InternalForml.g:4232:1: ( () otherlv_1= '/' ( ( (lv_actions_2_0= ruleWCA ) ) (otherlv_3= ',' ( (lv_actions_4_0= ruleWCA ) ) )* )? )
            {
            // InternalForml.g:4232:1: ( () otherlv_1= '/' ( ( (lv_actions_2_0= ruleWCA ) ) (otherlv_3= ',' ( (lv_actions_4_0= ruleWCA ) ) )* )? )
            // InternalForml.g:4232:2: () otherlv_1= '/' ( ( (lv_actions_2_0= ruleWCA ) ) (otherlv_3= ',' ( (lv_actions_4_0= ruleWCA ) ) )* )?
            {
            // InternalForml.g:4232:2: ()
            // InternalForml.g:4233:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getWCAListAccess().getWCAListAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,71,FOLLOW_50); 

                	newLeafNode(otherlv_1, grammarAccess.getWCAListAccess().getSolidusKeyword_1());
                
            // InternalForml.g:4242:1: ( ( (lv_actions_2_0= ruleWCA ) ) (otherlv_3= ',' ( (lv_actions_4_0= ruleWCA ) ) )* )?
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( (LA88_0==RULE_ID) ) {
                int LA88_1 = input.LA(2);

                if ( (LA88_1==12) ) {
                    alt88=1;
                }
            }
            switch (alt88) {
                case 1 :
                    // InternalForml.g:4242:2: ( (lv_actions_2_0= ruleWCA ) ) (otherlv_3= ',' ( (lv_actions_4_0= ruleWCA ) ) )*
                    {
                    // InternalForml.g:4242:2: ( (lv_actions_2_0= ruleWCA ) )
                    // InternalForml.g:4243:1: (lv_actions_2_0= ruleWCA )
                    {
                    // InternalForml.g:4243:1: (lv_actions_2_0= ruleWCA )
                    // InternalForml.g:4244:3: lv_actions_2_0= ruleWCA
                    {
                     
                    	        newCompositeNode(grammarAccess.getWCAListAccess().getActionsWCAParserRuleCall_2_0_0()); 
                    	    
                    pushFollow(FOLLOW_59);
                    lv_actions_2_0=ruleWCA();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getWCAListRule());
                    	        }
                           		add(
                           			current, 
                           			"actions",
                            		lv_actions_2_0, 
                            		"uw.cs.watform.forml.Forml.WCA");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // InternalForml.g:4260:2: (otherlv_3= ',' ( (lv_actions_4_0= ruleWCA ) ) )*
                    loop87:
                    do {
                        int alt87=2;
                        int LA87_0 = input.LA(1);

                        if ( (LA87_0==45) ) {
                            alt87=1;
                        }


                        switch (alt87) {
                    	case 1 :
                    	    // InternalForml.g:4260:4: otherlv_3= ',' ( (lv_actions_4_0= ruleWCA ) )
                    	    {
                    	    otherlv_3=(Token)match(input,45,FOLLOW_10); 

                    	        	newLeafNode(otherlv_3, grammarAccess.getWCAListAccess().getCommaKeyword_2_1_0());
                    	        
                    	    // InternalForml.g:4264:1: ( (lv_actions_4_0= ruleWCA ) )
                    	    // InternalForml.g:4265:1: (lv_actions_4_0= ruleWCA )
                    	    {
                    	    // InternalForml.g:4265:1: (lv_actions_4_0= ruleWCA )
                    	    // InternalForml.g:4266:3: lv_actions_4_0= ruleWCA
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getWCAListAccess().getActionsWCAParserRuleCall_2_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_59);
                    	    lv_actions_4_0=ruleWCA();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getWCAListRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"actions",
                    	            		lv_actions_4_0, 
                    	            		"uw.cs.watform.forml.Forml.WCA");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop87;
                        }
                    } while (true);


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleWCAList"


    // $ANTLR start "entryRuleWCA"
    // InternalForml.g:4290:1: entryRuleWCA returns [EObject current=null] : iv_ruleWCA= ruleWCA EOF ;
    public final EObject entryRuleWCA() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWCA = null;


        try {
            // InternalForml.g:4291:2: (iv_ruleWCA= ruleWCA EOF )
            // InternalForml.g:4292:2: iv_ruleWCA= ruleWCA EOF
            {
             newCompositeNode(grammarAccess.getWCARule()); 
            pushFollow(FOLLOW_1);
            iv_ruleWCA=ruleWCA();

            state._fsp--;

             current =iv_ruleWCA; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleWCA"


    // $ANTLR start "ruleWCA"
    // InternalForml.g:4299:1: ruleWCA returns [EObject current=null] : ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_action_3_0= ruleAction ) )? otherlv_4= '}' ) ;
    public final EObject ruleWCA() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_action_3_0 = null;


         enterRule(); 
            
        try {
            // InternalForml.g:4302:28: ( ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_action_3_0= ruleAction ) )? otherlv_4= '}' ) )
            // InternalForml.g:4303:1: ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_action_3_0= ruleAction ) )? otherlv_4= '}' )
            {
            // InternalForml.g:4303:1: ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_action_3_0= ruleAction ) )? otherlv_4= '}' )
            // InternalForml.g:4303:2: () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_action_3_0= ruleAction ) )? otherlv_4= '}'
            {
            // InternalForml.g:4303:2: ()
            // InternalForml.g:4304:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getWCAAccess().getWCAAction_0(),
                        current);
                

            }

            // InternalForml.g:4309:2: ( (lv_name_1_0= RULE_ID ) )
            // InternalForml.g:4310:1: (lv_name_1_0= RULE_ID )
            {
            // InternalForml.g:4310:1: (lv_name_1_0= RULE_ID )
            // InternalForml.g:4311:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            			newLeafNode(lv_name_1_0, grammarAccess.getWCAAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getWCARule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_66); 

                	newLeafNode(otherlv_2, grammarAccess.getWCAAccess().getLeftCurlyBracketKeyword_2());
                
            // InternalForml.g:4331:1: ( (lv_action_3_0= ruleAction ) )?
            int alt89=2;
            int LA89_0 = input.LA(1);

            if ( ((LA89_0>=RULE_ID && LA89_0<=RULE_INT)||LA89_0==67||(LA89_0>=69 && LA89_0<=70)||(LA89_0>=72 && LA89_0<=73)||(LA89_0>=96 && LA89_0<=97)) ) {
                alt89=1;
            }
            switch (alt89) {
                case 1 :
                    // InternalForml.g:4332:1: (lv_action_3_0= ruleAction )
                    {
                    // InternalForml.g:4332:1: (lv_action_3_0= ruleAction )
                    // InternalForml.g:4333:3: lv_action_3_0= ruleAction
                    {
                     
                    	        newCompositeNode(grammarAccess.getWCAAccess().getActionActionParserRuleCall_3_0()); 
                    	    
                    pushFollow(FOLLOW_6);
                    lv_action_3_0=ruleAction();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getWCARule());
                    	        }
                           		set(
                           			current, 
                           			"action",
                            		lv_action_3_0, 
                            		"uw.cs.watform.forml.Forml.Action");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,13,FOLLOW_2); 

                	newLeafNode(otherlv_4, grammarAccess.getWCAAccess().getRightCurlyBracketKeyword_4());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleWCA"


    // $ANTLR start "entryRuleAction"
    // InternalForml.g:4361:1: entryRuleAction returns [EObject current=null] : iv_ruleAction= ruleAction EOF ;
    public final EObject entryRuleAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAction = null;


        try {
            // InternalForml.g:4362:2: (iv_ruleAction= ruleAction EOF )
            // InternalForml.g:4363:2: iv_ruleAction= ruleAction EOF
            {
             newCompositeNode(grammarAccess.getActionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAction=ruleAction();

            state._fsp--;

             current =iv_ruleAction; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAction"


    // $ANTLR start "ruleAction"
    // InternalForml.g:4370:1: ruleAction returns [EObject current=null] : ( ( () otherlv_1= '+' ( ( ruleQualifiedName ) ) ) | (otherlv_3= '!' ( (otherlv_4= RULE_ID ) ) otherlv_5= '(' ( (lv_list_6_0= ruleAssignList ) ) otherlv_7= ')' ) | (otherlv_8= '-' ( (lv_minexpr_9_0= rulesetExpr ) ) ) | ( ( (lv_lvalue_10_0= rulesetExpr ) )? otherlv_11= ':=' ( (lv_rvalue_12_0= rulesetExpr ) )? ) | ( ( (lv_lvalue_13_0= ruleintExpr ) ) otherlv_14= ':=' ( (lv_rvalue_15_0= ruleintExpr ) ) ) ) ;
    public final EObject ruleAction() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_11=null;
        Token otherlv_14=null;
        EObject lv_list_6_0 = null;

        EObject lv_minexpr_9_0 = null;

        EObject lv_lvalue_10_0 = null;

        EObject lv_rvalue_12_0 = null;

        EObject lv_lvalue_13_0 = null;

        EObject lv_rvalue_15_0 = null;


         enterRule(); 
            
        try {
            // InternalForml.g:4373:28: ( ( ( () otherlv_1= '+' ( ( ruleQualifiedName ) ) ) | (otherlv_3= '!' ( (otherlv_4= RULE_ID ) ) otherlv_5= '(' ( (lv_list_6_0= ruleAssignList ) ) otherlv_7= ')' ) | (otherlv_8= '-' ( (lv_minexpr_9_0= rulesetExpr ) ) ) | ( ( (lv_lvalue_10_0= rulesetExpr ) )? otherlv_11= ':=' ( (lv_rvalue_12_0= rulesetExpr ) )? ) | ( ( (lv_lvalue_13_0= ruleintExpr ) ) otherlv_14= ':=' ( (lv_rvalue_15_0= ruleintExpr ) ) ) ) )
            // InternalForml.g:4374:1: ( ( () otherlv_1= '+' ( ( ruleQualifiedName ) ) ) | (otherlv_3= '!' ( (otherlv_4= RULE_ID ) ) otherlv_5= '(' ( (lv_list_6_0= ruleAssignList ) ) otherlv_7= ')' ) | (otherlv_8= '-' ( (lv_minexpr_9_0= rulesetExpr ) ) ) | ( ( (lv_lvalue_10_0= rulesetExpr ) )? otherlv_11= ':=' ( (lv_rvalue_12_0= rulesetExpr ) )? ) | ( ( (lv_lvalue_13_0= ruleintExpr ) ) otherlv_14= ':=' ( (lv_rvalue_15_0= ruleintExpr ) ) ) )
            {
            // InternalForml.g:4374:1: ( ( () otherlv_1= '+' ( ( ruleQualifiedName ) ) ) | (otherlv_3= '!' ( (otherlv_4= RULE_ID ) ) otherlv_5= '(' ( (lv_list_6_0= ruleAssignList ) ) otherlv_7= ')' ) | (otherlv_8= '-' ( (lv_minexpr_9_0= rulesetExpr ) ) ) | ( ( (lv_lvalue_10_0= rulesetExpr ) )? otherlv_11= ':=' ( (lv_rvalue_12_0= rulesetExpr ) )? ) | ( ( (lv_lvalue_13_0= ruleintExpr ) ) otherlv_14= ':=' ( (lv_rvalue_15_0= ruleintExpr ) ) ) )
            int alt92=5;
            switch ( input.LA(1) ) {
            case 69:
                {
                alt92=1;
                }
                break;
            case 72:
                {
                alt92=2;
                }
                break;
            case 70:
                {
                alt92=3;
                }
                break;
            case RULE_ID:
            case 67:
            case 73:
            case 97:
                {
                alt92=4;
                }
                break;
            case RULE_INT:
            case 96:
                {
                alt92=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 92, 0, input);

                throw nvae;
            }

            switch (alt92) {
                case 1 :
                    // InternalForml.g:4374:2: ( () otherlv_1= '+' ( ( ruleQualifiedName ) ) )
                    {
                    // InternalForml.g:4374:2: ( () otherlv_1= '+' ( ( ruleQualifiedName ) ) )
                    // InternalForml.g:4374:3: () otherlv_1= '+' ( ( ruleQualifiedName ) )
                    {
                    // InternalForml.g:4374:3: ()
                    // InternalForml.g:4375:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getActionAccess().getActionAction_0_0(),
                                current);
                        

                    }

                    otherlv_1=(Token)match(input,69,FOLLOW_10); 

                        	newLeafNode(otherlv_1, grammarAccess.getActionAccess().getPlusSignKeyword_0_1());
                        
                    // InternalForml.g:4384:1: ( ( ruleQualifiedName ) )
                    // InternalForml.g:4385:1: ( ruleQualifiedName )
                    {
                    // InternalForml.g:4385:1: ( ruleQualifiedName )
                    // InternalForml.g:4386:3: ruleQualifiedName
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getActionRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getActionAccess().getTypeExprRefCrossReference_0_2_0()); 
                    	    
                    pushFollow(FOLLOW_2);
                    ruleQualifiedName();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalForml.g:4400:6: (otherlv_3= '!' ( (otherlv_4= RULE_ID ) ) otherlv_5= '(' ( (lv_list_6_0= ruleAssignList ) ) otherlv_7= ')' )
                    {
                    // InternalForml.g:4400:6: (otherlv_3= '!' ( (otherlv_4= RULE_ID ) ) otherlv_5= '(' ( (lv_list_6_0= ruleAssignList ) ) otherlv_7= ')' )
                    // InternalForml.g:4400:8: otherlv_3= '!' ( (otherlv_4= RULE_ID ) ) otherlv_5= '(' ( (lv_list_6_0= ruleAssignList ) ) otherlv_7= ')'
                    {
                    otherlv_3=(Token)match(input,72,FOLLOW_10); 

                        	newLeafNode(otherlv_3, grammarAccess.getActionAccess().getExclamationMarkKeyword_1_0());
                        
                    // InternalForml.g:4404:1: ( (otherlv_4= RULE_ID ) )
                    // InternalForml.g:4405:1: (otherlv_4= RULE_ID )
                    {
                    // InternalForml.g:4405:1: (otherlv_4= RULE_ID )
                    // InternalForml.g:4406:3: otherlv_4= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getActionRule());
                    	        }
                            
                    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_62); 

                    		newLeafNode(otherlv_4, grammarAccess.getActionAccess().getOutOutputCrossReference_1_1_0()); 
                    	

                    }


                    }

                    otherlv_5=(Token)match(input,67,FOLLOW_10); 

                        	newLeafNode(otherlv_5, grammarAccess.getActionAccess().getLeftParenthesisKeyword_1_2());
                        
                    // InternalForml.g:4421:1: ( (lv_list_6_0= ruleAssignList ) )
                    // InternalForml.g:4422:1: (lv_list_6_0= ruleAssignList )
                    {
                    // InternalForml.g:4422:1: (lv_list_6_0= ruleAssignList )
                    // InternalForml.g:4423:3: lv_list_6_0= ruleAssignList
                    {
                     
                    	        newCompositeNode(grammarAccess.getActionAccess().getListAssignListParserRuleCall_1_3_0()); 
                    	    
                    pushFollow(FOLLOW_63);
                    lv_list_6_0=ruleAssignList();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getActionRule());
                    	        }
                           		add(
                           			current, 
                           			"list",
                            		lv_list_6_0, 
                            		"uw.cs.watform.forml.Forml.AssignList");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_7=(Token)match(input,68,FOLLOW_2); 

                        	newLeafNode(otherlv_7, grammarAccess.getActionAccess().getRightParenthesisKeyword_1_4());
                        

                    }


                    }
                    break;
                case 3 :
                    // InternalForml.g:4444:6: (otherlv_8= '-' ( (lv_minexpr_9_0= rulesetExpr ) ) )
                    {
                    // InternalForml.g:4444:6: (otherlv_8= '-' ( (lv_minexpr_9_0= rulesetExpr ) ) )
                    // InternalForml.g:4444:8: otherlv_8= '-' ( (lv_minexpr_9_0= rulesetExpr ) )
                    {
                    otherlv_8=(Token)match(input,70,FOLLOW_67); 

                        	newLeafNode(otherlv_8, grammarAccess.getActionAccess().getHyphenMinusKeyword_2_0());
                        
                    // InternalForml.g:4448:1: ( (lv_minexpr_9_0= rulesetExpr ) )
                    // InternalForml.g:4449:1: (lv_minexpr_9_0= rulesetExpr )
                    {
                    // InternalForml.g:4449:1: (lv_minexpr_9_0= rulesetExpr )
                    // InternalForml.g:4450:3: lv_minexpr_9_0= rulesetExpr
                    {
                     
                    	        newCompositeNode(grammarAccess.getActionAccess().getMinexprSetExprParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_2);
                    lv_minexpr_9_0=rulesetExpr();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getActionRule());
                    	        }
                           		set(
                           			current, 
                           			"minexpr",
                            		lv_minexpr_9_0, 
                            		"uw.cs.watform.forml.Forml.setExpr");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalForml.g:4467:6: ( ( (lv_lvalue_10_0= rulesetExpr ) )? otherlv_11= ':=' ( (lv_rvalue_12_0= rulesetExpr ) )? )
                    {
                    // InternalForml.g:4467:6: ( ( (lv_lvalue_10_0= rulesetExpr ) )? otherlv_11= ':=' ( (lv_rvalue_12_0= rulesetExpr ) )? )
                    // InternalForml.g:4467:7: ( (lv_lvalue_10_0= rulesetExpr ) )? otherlv_11= ':=' ( (lv_rvalue_12_0= rulesetExpr ) )?
                    {
                    // InternalForml.g:4467:7: ( (lv_lvalue_10_0= rulesetExpr ) )?
                    int alt90=2;
                    int LA90_0 = input.LA(1);

                    if ( (LA90_0==RULE_ID||LA90_0==67||LA90_0==97) ) {
                        alt90=1;
                    }
                    switch (alt90) {
                        case 1 :
                            // InternalForml.g:4468:1: (lv_lvalue_10_0= rulesetExpr )
                            {
                            // InternalForml.g:4468:1: (lv_lvalue_10_0= rulesetExpr )
                            // InternalForml.g:4469:3: lv_lvalue_10_0= rulesetExpr
                            {
                             
                            	        newCompositeNode(grammarAccess.getActionAccess().getLvalueSetExprParserRuleCall_3_0_0()); 
                            	    
                            pushFollow(FOLLOW_68);
                            lv_lvalue_10_0=rulesetExpr();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getActionRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"lvalue",
                                    		lv_lvalue_10_0, 
                                    		"uw.cs.watform.forml.Forml.setExpr");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }
                            break;

                    }

                    otherlv_11=(Token)match(input,73,FOLLOW_69); 

                        	newLeafNode(otherlv_11, grammarAccess.getActionAccess().getColonEqualsSignKeyword_3_1());
                        
                    // InternalForml.g:4489:1: ( (lv_rvalue_12_0= rulesetExpr ) )?
                    int alt91=2;
                    int LA91_0 = input.LA(1);

                    if ( (LA91_0==RULE_ID||LA91_0==67||LA91_0==97) ) {
                        alt91=1;
                    }
                    switch (alt91) {
                        case 1 :
                            // InternalForml.g:4490:1: (lv_rvalue_12_0= rulesetExpr )
                            {
                            // InternalForml.g:4490:1: (lv_rvalue_12_0= rulesetExpr )
                            // InternalForml.g:4491:3: lv_rvalue_12_0= rulesetExpr
                            {
                             
                            	        newCompositeNode(grammarAccess.getActionAccess().getRvalueSetExprParserRuleCall_3_2_0()); 
                            	    
                            pushFollow(FOLLOW_2);
                            lv_rvalue_12_0=rulesetExpr();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getActionRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"rvalue",
                                    		lv_rvalue_12_0, 
                                    		"uw.cs.watform.forml.Forml.setExpr");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalForml.g:4508:6: ( ( (lv_lvalue_13_0= ruleintExpr ) ) otherlv_14= ':=' ( (lv_rvalue_15_0= ruleintExpr ) ) )
                    {
                    // InternalForml.g:4508:6: ( ( (lv_lvalue_13_0= ruleintExpr ) ) otherlv_14= ':=' ( (lv_rvalue_15_0= ruleintExpr ) ) )
                    // InternalForml.g:4508:7: ( (lv_lvalue_13_0= ruleintExpr ) ) otherlv_14= ':=' ( (lv_rvalue_15_0= ruleintExpr ) )
                    {
                    // InternalForml.g:4508:7: ( (lv_lvalue_13_0= ruleintExpr ) )
                    // InternalForml.g:4509:1: (lv_lvalue_13_0= ruleintExpr )
                    {
                    // InternalForml.g:4509:1: (lv_lvalue_13_0= ruleintExpr )
                    // InternalForml.g:4510:3: lv_lvalue_13_0= ruleintExpr
                    {
                     
                    	        newCompositeNode(grammarAccess.getActionAccess().getLvalueIntExprParserRuleCall_4_0_0()); 
                    	    
                    pushFollow(FOLLOW_68);
                    lv_lvalue_13_0=ruleintExpr();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getActionRule());
                    	        }
                           		set(
                           			current, 
                           			"lvalue",
                            		lv_lvalue_13_0, 
                            		"uw.cs.watform.forml.Forml.intExpr");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_14=(Token)match(input,73,FOLLOW_70); 

                        	newLeafNode(otherlv_14, grammarAccess.getActionAccess().getColonEqualsSignKeyword_4_1());
                        
                    // InternalForml.g:4530:1: ( (lv_rvalue_15_0= ruleintExpr ) )
                    // InternalForml.g:4531:1: (lv_rvalue_15_0= ruleintExpr )
                    {
                    // InternalForml.g:4531:1: (lv_rvalue_15_0= ruleintExpr )
                    // InternalForml.g:4532:3: lv_rvalue_15_0= ruleintExpr
                    {
                     
                    	        newCompositeNode(grammarAccess.getActionAccess().getRvalueIntExprParserRuleCall_4_2_0()); 
                    	    
                    pushFollow(FOLLOW_2);
                    lv_rvalue_15_0=ruleintExpr();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getActionRule());
                    	        }
                           		set(
                           			current, 
                           			"rvalue",
                            		lv_rvalue_15_0, 
                            		"uw.cs.watform.forml.Forml.intExpr");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAction"


    // $ANTLR start "entryRuleAssignList"
    // InternalForml.g:4556:1: entryRuleAssignList returns [EObject current=null] : iv_ruleAssignList= ruleAssignList EOF ;
    public final EObject entryRuleAssignList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignList = null;


        try {
            // InternalForml.g:4557:2: (iv_ruleAssignList= ruleAssignList EOF )
            // InternalForml.g:4558:2: iv_ruleAssignList= ruleAssignList EOF
            {
             newCompositeNode(grammarAccess.getAssignListRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAssignList=ruleAssignList();

            state._fsp--;

             current =iv_ruleAssignList; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAssignList"


    // $ANTLR start "ruleAssignList"
    // InternalForml.g:4565:1: ruleAssignList returns [EObject current=null] : ( ( (lv_list_0_0= ruleAssign ) ) (otherlv_1= ',' ( (lv_list_2_0= ruleAssign ) ) )* ) ;
    public final EObject ruleAssignList() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_list_0_0 = null;

        EObject lv_list_2_0 = null;


         enterRule(); 
            
        try {
            // InternalForml.g:4568:28: ( ( ( (lv_list_0_0= ruleAssign ) ) (otherlv_1= ',' ( (lv_list_2_0= ruleAssign ) ) )* ) )
            // InternalForml.g:4569:1: ( ( (lv_list_0_0= ruleAssign ) ) (otherlv_1= ',' ( (lv_list_2_0= ruleAssign ) ) )* )
            {
            // InternalForml.g:4569:1: ( ( (lv_list_0_0= ruleAssign ) ) (otherlv_1= ',' ( (lv_list_2_0= ruleAssign ) ) )* )
            // InternalForml.g:4569:2: ( (lv_list_0_0= ruleAssign ) ) (otherlv_1= ',' ( (lv_list_2_0= ruleAssign ) ) )*
            {
            // InternalForml.g:4569:2: ( (lv_list_0_0= ruleAssign ) )
            // InternalForml.g:4570:1: (lv_list_0_0= ruleAssign )
            {
            // InternalForml.g:4570:1: (lv_list_0_0= ruleAssign )
            // InternalForml.g:4571:3: lv_list_0_0= ruleAssign
            {
             
            	        newCompositeNode(grammarAccess.getAssignListAccess().getListAssignParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_59);
            lv_list_0_0=ruleAssign();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAssignListRule());
            	        }
                   		add(
                   			current, 
                   			"list",
                    		lv_list_0_0, 
                    		"uw.cs.watform.forml.Forml.Assign");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalForml.g:4587:2: (otherlv_1= ',' ( (lv_list_2_0= ruleAssign ) ) )*
            loop93:
            do {
                int alt93=2;
                int LA93_0 = input.LA(1);

                if ( (LA93_0==45) ) {
                    alt93=1;
                }


                switch (alt93) {
            	case 1 :
            	    // InternalForml.g:4587:4: otherlv_1= ',' ( (lv_list_2_0= ruleAssign ) )
            	    {
            	    otherlv_1=(Token)match(input,45,FOLLOW_10); 

            	        	newLeafNode(otherlv_1, grammarAccess.getAssignListAccess().getCommaKeyword_1_0());
            	        
            	    // InternalForml.g:4591:1: ( (lv_list_2_0= ruleAssign ) )
            	    // InternalForml.g:4592:1: (lv_list_2_0= ruleAssign )
            	    {
            	    // InternalForml.g:4592:1: (lv_list_2_0= ruleAssign )
            	    // InternalForml.g:4593:3: lv_list_2_0= ruleAssign
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAssignListAccess().getListAssignParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_59);
            	    lv_list_2_0=ruleAssign();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getAssignListRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"list",
            	            		lv_list_2_0, 
            	            		"uw.cs.watform.forml.Forml.Assign");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop93;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAssignList"


    // $ANTLR start "entryRuleAssign"
    // InternalForml.g:4617:1: entryRuleAssign returns [EObject current=null] : iv_ruleAssign= ruleAssign EOF ;
    public final EObject entryRuleAssign() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssign = null;


        try {
            // InternalForml.g:4618:2: (iv_ruleAssign= ruleAssign EOF )
            // InternalForml.g:4619:2: iv_ruleAssign= ruleAssign EOF
            {
             newCompositeNode(grammarAccess.getAssignRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAssign=ruleAssign();

            state._fsp--;

             current =iv_ruleAssign; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAssign"


    // $ANTLR start "ruleAssign"
    // InternalForml.g:4626:1: ruleAssign returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( ( (lv_sexpr_2_1= rulesetExpr | lv_sexpr_2_2= ruleintExpr ) ) ) ) ;
    public final EObject ruleAssign() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_sexpr_2_1 = null;

        EObject lv_sexpr_2_2 = null;


         enterRule(); 
            
        try {
            // InternalForml.g:4629:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( ( (lv_sexpr_2_1= rulesetExpr | lv_sexpr_2_2= ruleintExpr ) ) ) ) )
            // InternalForml.g:4630:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( ( (lv_sexpr_2_1= rulesetExpr | lv_sexpr_2_2= ruleintExpr ) ) ) )
            {
            // InternalForml.g:4630:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( ( (lv_sexpr_2_1= rulesetExpr | lv_sexpr_2_2= ruleintExpr ) ) ) )
            // InternalForml.g:4630:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( ( (lv_sexpr_2_1= rulesetExpr | lv_sexpr_2_2= ruleintExpr ) ) )
            {
            // InternalForml.g:4630:2: ( (otherlv_0= RULE_ID ) )
            // InternalForml.g:4631:1: (otherlv_0= RULE_ID )
            {
            // InternalForml.g:4631:1: (otherlv_0= RULE_ID )
            // InternalForml.g:4632:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getAssignRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_49); 

            		newLeafNode(otherlv_0, grammarAccess.getAssignAccess().getRefExprRefCrossReference_0_0()); 
            	

            }


            }

            otherlv_1=(Token)match(input,58,FOLLOW_71); 

                	newLeafNode(otherlv_1, grammarAccess.getAssignAccess().getEqualsSignKeyword_1());
                
            // InternalForml.g:4647:1: ( ( (lv_sexpr_2_1= rulesetExpr | lv_sexpr_2_2= ruleintExpr ) ) )
            // InternalForml.g:4648:1: ( (lv_sexpr_2_1= rulesetExpr | lv_sexpr_2_2= ruleintExpr ) )
            {
            // InternalForml.g:4648:1: ( (lv_sexpr_2_1= rulesetExpr | lv_sexpr_2_2= ruleintExpr ) )
            // InternalForml.g:4649:1: (lv_sexpr_2_1= rulesetExpr | lv_sexpr_2_2= ruleintExpr )
            {
            // InternalForml.g:4649:1: (lv_sexpr_2_1= rulesetExpr | lv_sexpr_2_2= ruleintExpr )
            int alt94=2;
            int LA94_0 = input.LA(1);

            if ( (LA94_0==RULE_ID||LA94_0==67||LA94_0==97) ) {
                alt94=1;
            }
            else if ( (LA94_0==RULE_INT||LA94_0==96) ) {
                alt94=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 94, 0, input);

                throw nvae;
            }
            switch (alt94) {
                case 1 :
                    // InternalForml.g:4650:3: lv_sexpr_2_1= rulesetExpr
                    {
                     
                    	        newCompositeNode(grammarAccess.getAssignAccess().getSexprSetExprParserRuleCall_2_0_0()); 
                    	    
                    pushFollow(FOLLOW_2);
                    lv_sexpr_2_1=rulesetExpr();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getAssignRule());
                    	        }
                           		set(
                           			current, 
                           			"sexpr",
                            		lv_sexpr_2_1, 
                            		"uw.cs.watform.forml.Forml.setExpr");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }
                    break;
                case 2 :
                    // InternalForml.g:4665:8: lv_sexpr_2_2= ruleintExpr
                    {
                     
                    	        newCompositeNode(grammarAccess.getAssignAccess().getSexprIntExprParserRuleCall_2_0_1()); 
                    	    
                    pushFollow(FOLLOW_2);
                    lv_sexpr_2_2=ruleintExpr();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getAssignRule());
                    	        }
                           		set(
                           			current, 
                           			"sexpr",
                            		lv_sexpr_2_2, 
                            		"uw.cs.watform.forml.Forml.intExpr");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }
                    break;

            }


            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAssign"


    // $ANTLR start "entryRuleMacro"
    // InternalForml.g:4691:1: entryRuleMacro returns [EObject current=null] : iv_ruleMacro= ruleMacro EOF ;
    public final EObject entryRuleMacro() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMacro = null;


        try {
            // InternalForml.g:4692:2: (iv_ruleMacro= ruleMacro EOF )
            // InternalForml.g:4693:2: iv_ruleMacro= ruleMacro EOF
            {
             newCompositeNode(grammarAccess.getMacroRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMacro=ruleMacro();

            state._fsp--;

             current =iv_ruleMacro; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMacro"


    // $ANTLR start "ruleMacro"
    // InternalForml.g:4700:1: ruleMacro returns [EObject current=null] : (otherlv_0= 'let' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( ( (lv_expr_3_1= rulesetExpr | lv_expr_3_2= ruleintExpr ) ) ) ) ;
    public final EObject ruleMacro() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        EObject lv_expr_3_1 = null;

        EObject lv_expr_3_2 = null;


         enterRule(); 
            
        try {
            // InternalForml.g:4703:28: ( (otherlv_0= 'let' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( ( (lv_expr_3_1= rulesetExpr | lv_expr_3_2= ruleintExpr ) ) ) ) )
            // InternalForml.g:4704:1: (otherlv_0= 'let' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( ( (lv_expr_3_1= rulesetExpr | lv_expr_3_2= ruleintExpr ) ) ) )
            {
            // InternalForml.g:4704:1: (otherlv_0= 'let' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( ( (lv_expr_3_1= rulesetExpr | lv_expr_3_2= ruleintExpr ) ) ) )
            // InternalForml.g:4704:3: otherlv_0= 'let' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( ( (lv_expr_3_1= rulesetExpr | lv_expr_3_2= ruleintExpr ) ) )
            {
            otherlv_0=(Token)match(input,74,FOLLOW_10); 

                	newLeafNode(otherlv_0, grammarAccess.getMacroAccess().getLetKeyword_0());
                
            // InternalForml.g:4708:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalForml.g:4709:1: (lv_name_1_0= RULE_ID )
            {
            // InternalForml.g:4709:1: (lv_name_1_0= RULE_ID )
            // InternalForml.g:4710:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_49); 

            			newLeafNode(lv_name_1_0, grammarAccess.getMacroAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getMacroRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,58,FOLLOW_71); 

                	newLeafNode(otherlv_2, grammarAccess.getMacroAccess().getEqualsSignKeyword_2());
                
            // InternalForml.g:4730:1: ( ( (lv_expr_3_1= rulesetExpr | lv_expr_3_2= ruleintExpr ) ) )
            // InternalForml.g:4731:1: ( (lv_expr_3_1= rulesetExpr | lv_expr_3_2= ruleintExpr ) )
            {
            // InternalForml.g:4731:1: ( (lv_expr_3_1= rulesetExpr | lv_expr_3_2= ruleintExpr ) )
            // InternalForml.g:4732:1: (lv_expr_3_1= rulesetExpr | lv_expr_3_2= ruleintExpr )
            {
            // InternalForml.g:4732:1: (lv_expr_3_1= rulesetExpr | lv_expr_3_2= ruleintExpr )
            int alt95=2;
            int LA95_0 = input.LA(1);

            if ( (LA95_0==RULE_ID||LA95_0==67||LA95_0==97) ) {
                alt95=1;
            }
            else if ( (LA95_0==RULE_INT||LA95_0==96) ) {
                alt95=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 95, 0, input);

                throw nvae;
            }
            switch (alt95) {
                case 1 :
                    // InternalForml.g:4733:3: lv_expr_3_1= rulesetExpr
                    {
                     
                    	        newCompositeNode(grammarAccess.getMacroAccess().getExprSetExprParserRuleCall_3_0_0()); 
                    	    
                    pushFollow(FOLLOW_2);
                    lv_expr_3_1=rulesetExpr();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getMacroRule());
                    	        }
                           		set(
                           			current, 
                           			"expr",
                            		lv_expr_3_1, 
                            		"uw.cs.watform.forml.Forml.setExpr");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }
                    break;
                case 2 :
                    // InternalForml.g:4748:8: lv_expr_3_2= ruleintExpr
                    {
                     
                    	        newCompositeNode(grammarAccess.getMacroAccess().getExprIntExprParserRuleCall_3_0_1()); 
                    	    
                    pushFollow(FOLLOW_2);
                    lv_expr_3_2=ruleintExpr();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getMacroRule());
                    	        }
                           		set(
                           			current, 
                           			"expr",
                            		lv_expr_3_2, 
                            		"uw.cs.watform.forml.Forml.intExpr");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }
                    break;

            }


            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMacro"


    // $ANTLR start "entryRulePredicate"
    // InternalForml.g:4774:1: entryRulePredicate returns [EObject current=null] : iv_rulePredicate= rulePredicate EOF ;
    public final EObject entryRulePredicate() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePredicate = null;


        try {
            // InternalForml.g:4775:2: (iv_rulePredicate= rulePredicate EOF )
            // InternalForml.g:4776:2: iv_rulePredicate= rulePredicate EOF
            {
             newCompositeNode(grammarAccess.getPredicateRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePredicate=rulePredicate();

            state._fsp--;

             current =iv_rulePredicate; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePredicate"


    // $ANTLR start "rulePredicate"
    // InternalForml.g:4783:1: rulePredicate returns [EObject current=null] : ( ( ( ( (lv_logicop_0_1= 'no' | lv_logicop_0_2= 'lone' | lv_logicop_0_3= 'one' | lv_logicop_0_4= 'some' | lv_logicop_0_5= 'all' ) ) ) ( (lv_var_1_0= ruleVariable ) ) otherlv_2= ':' ( (lv_sexpr_3_0= rulesetExpr ) ) otherlv_4= '|' )? ( (lv_quantPred_5_0= rulenotPred ) ) ) ;
    public final EObject rulePredicate() throws RecognitionException {
        EObject current = null;

        Token lv_logicop_0_1=null;
        Token lv_logicop_0_2=null;
        Token lv_logicop_0_3=null;
        Token lv_logicop_0_4=null;
        Token lv_logicop_0_5=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_var_1_0 = null;

        EObject lv_sexpr_3_0 = null;

        EObject lv_quantPred_5_0 = null;


         enterRule(); 
            
        try {
            // InternalForml.g:4786:28: ( ( ( ( ( (lv_logicop_0_1= 'no' | lv_logicop_0_2= 'lone' | lv_logicop_0_3= 'one' | lv_logicop_0_4= 'some' | lv_logicop_0_5= 'all' ) ) ) ( (lv_var_1_0= ruleVariable ) ) otherlv_2= ':' ( (lv_sexpr_3_0= rulesetExpr ) ) otherlv_4= '|' )? ( (lv_quantPred_5_0= rulenotPred ) ) ) )
            // InternalForml.g:4787:1: ( ( ( ( (lv_logicop_0_1= 'no' | lv_logicop_0_2= 'lone' | lv_logicop_0_3= 'one' | lv_logicop_0_4= 'some' | lv_logicop_0_5= 'all' ) ) ) ( (lv_var_1_0= ruleVariable ) ) otherlv_2= ':' ( (lv_sexpr_3_0= rulesetExpr ) ) otherlv_4= '|' )? ( (lv_quantPred_5_0= rulenotPred ) ) )
            {
            // InternalForml.g:4787:1: ( ( ( ( (lv_logicop_0_1= 'no' | lv_logicop_0_2= 'lone' | lv_logicop_0_3= 'one' | lv_logicop_0_4= 'some' | lv_logicop_0_5= 'all' ) ) ) ( (lv_var_1_0= ruleVariable ) ) otherlv_2= ':' ( (lv_sexpr_3_0= rulesetExpr ) ) otherlv_4= '|' )? ( (lv_quantPred_5_0= rulenotPred ) ) )
            // InternalForml.g:4787:2: ( ( ( (lv_logicop_0_1= 'no' | lv_logicop_0_2= 'lone' | lv_logicop_0_3= 'one' | lv_logicop_0_4= 'some' | lv_logicop_0_5= 'all' ) ) ) ( (lv_var_1_0= ruleVariable ) ) otherlv_2= ':' ( (lv_sexpr_3_0= rulesetExpr ) ) otherlv_4= '|' )? ( (lv_quantPred_5_0= rulenotPred ) )
            {
            // InternalForml.g:4787:2: ( ( ( (lv_logicop_0_1= 'no' | lv_logicop_0_2= 'lone' | lv_logicop_0_3= 'one' | lv_logicop_0_4= 'some' | lv_logicop_0_5= 'all' ) ) ) ( (lv_var_1_0= ruleVariable ) ) otherlv_2= ':' ( (lv_sexpr_3_0= rulesetExpr ) ) otherlv_4= '|' )?
            int alt97=2;
            switch ( input.LA(1) ) {
                case 75:
                    {
                    int LA97_1 = input.LA(2);

                    if ( (LA97_1==RULE_ID) ) {
                        int LA97_7 = input.LA(3);

                        if ( (LA97_7==23) ) {
                            alt97=1;
                        }
                    }
                    }
                    break;
                case 76:
                    {
                    int LA97_2 = input.LA(2);

                    if ( (LA97_2==RULE_ID) ) {
                        int LA97_7 = input.LA(3);

                        if ( (LA97_7==23) ) {
                            alt97=1;
                        }
                    }
                    }
                    break;
                case 77:
                    {
                    int LA97_3 = input.LA(2);

                    if ( (LA97_3==RULE_ID) ) {
                        int LA97_7 = input.LA(3);

                        if ( (LA97_7==23) ) {
                            alt97=1;
                        }
                    }
                    }
                    break;
                case 78:
                    {
                    int LA97_4 = input.LA(2);

                    if ( (LA97_4==RULE_ID) ) {
                        int LA97_7 = input.LA(3);

                        if ( (LA97_7==23) ) {
                            alt97=1;
                        }
                    }
                    }
                    break;
                case 79:
                    {
                    int LA97_5 = input.LA(2);

                    if ( (LA97_5==RULE_ID) ) {
                        int LA97_7 = input.LA(3);

                        if ( (LA97_7==23) ) {
                            alt97=1;
                        }
                    }
                    }
                    break;
            }

            switch (alt97) {
                case 1 :
                    // InternalForml.g:4787:3: ( ( (lv_logicop_0_1= 'no' | lv_logicop_0_2= 'lone' | lv_logicop_0_3= 'one' | lv_logicop_0_4= 'some' | lv_logicop_0_5= 'all' ) ) ) ( (lv_var_1_0= ruleVariable ) ) otherlv_2= ':' ( (lv_sexpr_3_0= rulesetExpr ) ) otherlv_4= '|'
                    {
                    // InternalForml.g:4787:3: ( ( (lv_logicop_0_1= 'no' | lv_logicop_0_2= 'lone' | lv_logicop_0_3= 'one' | lv_logicop_0_4= 'some' | lv_logicop_0_5= 'all' ) ) )
                    // InternalForml.g:4788:1: ( (lv_logicop_0_1= 'no' | lv_logicop_0_2= 'lone' | lv_logicop_0_3= 'one' | lv_logicop_0_4= 'some' | lv_logicop_0_5= 'all' ) )
                    {
                    // InternalForml.g:4788:1: ( (lv_logicop_0_1= 'no' | lv_logicop_0_2= 'lone' | lv_logicop_0_3= 'one' | lv_logicop_0_4= 'some' | lv_logicop_0_5= 'all' ) )
                    // InternalForml.g:4789:1: (lv_logicop_0_1= 'no' | lv_logicop_0_2= 'lone' | lv_logicop_0_3= 'one' | lv_logicop_0_4= 'some' | lv_logicop_0_5= 'all' )
                    {
                    // InternalForml.g:4789:1: (lv_logicop_0_1= 'no' | lv_logicop_0_2= 'lone' | lv_logicop_0_3= 'one' | lv_logicop_0_4= 'some' | lv_logicop_0_5= 'all' )
                    int alt96=5;
                    switch ( input.LA(1) ) {
                    case 75:
                        {
                        alt96=1;
                        }
                        break;
                    case 76:
                        {
                        alt96=2;
                        }
                        break;
                    case 77:
                        {
                        alt96=3;
                        }
                        break;
                    case 78:
                        {
                        alt96=4;
                        }
                        break;
                    case 79:
                        {
                        alt96=5;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 96, 0, input);

                        throw nvae;
                    }

                    switch (alt96) {
                        case 1 :
                            // InternalForml.g:4790:3: lv_logicop_0_1= 'no'
                            {
                            lv_logicop_0_1=(Token)match(input,75,FOLLOW_10); 

                                    newLeafNode(lv_logicop_0_1, grammarAccess.getPredicateAccess().getLogicopNoKeyword_0_0_0_0());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getPredicateRule());
                            	        }
                                   		setWithLastConsumed(current, "logicop", lv_logicop_0_1, null);
                            	    

                            }
                            break;
                        case 2 :
                            // InternalForml.g:4802:8: lv_logicop_0_2= 'lone'
                            {
                            lv_logicop_0_2=(Token)match(input,76,FOLLOW_10); 

                                    newLeafNode(lv_logicop_0_2, grammarAccess.getPredicateAccess().getLogicopLoneKeyword_0_0_0_1());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getPredicateRule());
                            	        }
                                   		setWithLastConsumed(current, "logicop", lv_logicop_0_2, null);
                            	    

                            }
                            break;
                        case 3 :
                            // InternalForml.g:4814:8: lv_logicop_0_3= 'one'
                            {
                            lv_logicop_0_3=(Token)match(input,77,FOLLOW_10); 

                                    newLeafNode(lv_logicop_0_3, grammarAccess.getPredicateAccess().getLogicopOneKeyword_0_0_0_2());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getPredicateRule());
                            	        }
                                   		setWithLastConsumed(current, "logicop", lv_logicop_0_3, null);
                            	    

                            }
                            break;
                        case 4 :
                            // InternalForml.g:4826:8: lv_logicop_0_4= 'some'
                            {
                            lv_logicop_0_4=(Token)match(input,78,FOLLOW_10); 

                                    newLeafNode(lv_logicop_0_4, grammarAccess.getPredicateAccess().getLogicopSomeKeyword_0_0_0_3());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getPredicateRule());
                            	        }
                                   		setWithLastConsumed(current, "logicop", lv_logicop_0_4, null);
                            	    

                            }
                            break;
                        case 5 :
                            // InternalForml.g:4838:8: lv_logicop_0_5= 'all'
                            {
                            lv_logicop_0_5=(Token)match(input,79,FOLLOW_10); 

                                    newLeafNode(lv_logicop_0_5, grammarAccess.getPredicateAccess().getLogicopAllKeyword_0_0_0_4());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getPredicateRule());
                            	        }
                                   		setWithLastConsumed(current, "logicop", lv_logicop_0_5, null);
                            	    

                            }
                            break;

                    }


                    }


                    }

                    // InternalForml.g:4853:2: ( (lv_var_1_0= ruleVariable ) )
                    // InternalForml.g:4854:1: (lv_var_1_0= ruleVariable )
                    {
                    // InternalForml.g:4854:1: (lv_var_1_0= ruleVariable )
                    // InternalForml.g:4855:3: lv_var_1_0= ruleVariable
                    {
                     
                    	        newCompositeNode(grammarAccess.getPredicateAccess().getVarVariableParserRuleCall_0_1_0()); 
                    	    
                    pushFollow(FOLLOW_22);
                    lv_var_1_0=ruleVariable();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPredicateRule());
                    	        }
                           		set(
                           			current, 
                           			"var",
                            		lv_var_1_0, 
                            		"uw.cs.watform.forml.Forml.Variable");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_2=(Token)match(input,23,FOLLOW_67); 

                        	newLeafNode(otherlv_2, grammarAccess.getPredicateAccess().getColonKeyword_0_2());
                        
                    // InternalForml.g:4875:1: ( (lv_sexpr_3_0= rulesetExpr ) )
                    // InternalForml.g:4876:1: (lv_sexpr_3_0= rulesetExpr )
                    {
                    // InternalForml.g:4876:1: (lv_sexpr_3_0= rulesetExpr )
                    // InternalForml.g:4877:3: lv_sexpr_3_0= rulesetExpr
                    {
                     
                    	        newCompositeNode(grammarAccess.getPredicateAccess().getSexprSetExprParserRuleCall_0_3_0()); 
                    	    
                    pushFollow(FOLLOW_72);
                    lv_sexpr_3_0=rulesetExpr();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPredicateRule());
                    	        }
                           		set(
                           			current, 
                           			"sexpr",
                            		lv_sexpr_3_0, 
                            		"uw.cs.watform.forml.Forml.setExpr");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_4=(Token)match(input,80,FOLLOW_73); 

                        	newLeafNode(otherlv_4, grammarAccess.getPredicateAccess().getVerticalLineKeyword_0_4());
                        

                    }
                    break;

            }

            // InternalForml.g:4897:3: ( (lv_quantPred_5_0= rulenotPred ) )
            // InternalForml.g:4898:1: (lv_quantPred_5_0= rulenotPred )
            {
            // InternalForml.g:4898:1: (lv_quantPred_5_0= rulenotPred )
            // InternalForml.g:4899:3: lv_quantPred_5_0= rulenotPred
            {
             
            	        newCompositeNode(grammarAccess.getPredicateAccess().getQuantPredNotPredParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_2);
            lv_quantPred_5_0=rulenotPred();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getPredicateRule());
            	        }
                   		set(
                   			current, 
                   			"quantPred",
                    		lv_quantPred_5_0, 
                    		"uw.cs.watform.forml.Forml.notPred");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePredicate"


    // $ANTLR start "entryRulenotPred"
    // InternalForml.g:4923:1: entryRulenotPred returns [EObject current=null] : iv_rulenotPred= rulenotPred EOF ;
    public final EObject entryRulenotPred() throws RecognitionException {
        EObject current = null;

        EObject iv_rulenotPred = null;


        try {
            // InternalForml.g:4924:2: (iv_rulenotPred= rulenotPred EOF )
            // InternalForml.g:4925:2: iv_rulenotPred= rulenotPred EOF
            {
             newCompositeNode(grammarAccess.getNotPredRule()); 
            pushFollow(FOLLOW_1);
            iv_rulenotPred=rulenotPred();

            state._fsp--;

             current =iv_rulenotPred; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulenotPred"


    // $ANTLR start "rulenotPred"
    // InternalForml.g:4932:1: rulenotPred returns [EObject current=null] : ( (otherlv_0= 'not' ( (lv_pred_1_0= rulePredicate ) ) ) | ( (lv_pred_2_0= ruleandPred ) ) ) ;
    public final EObject rulenotPred() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_pred_1_0 = null;

        EObject lv_pred_2_0 = null;


         enterRule(); 
            
        try {
            // InternalForml.g:4935:28: ( ( (otherlv_0= 'not' ( (lv_pred_1_0= rulePredicate ) ) ) | ( (lv_pred_2_0= ruleandPred ) ) ) )
            // InternalForml.g:4936:1: ( (otherlv_0= 'not' ( (lv_pred_1_0= rulePredicate ) ) ) | ( (lv_pred_2_0= ruleandPred ) ) )
            {
            // InternalForml.g:4936:1: ( (otherlv_0= 'not' ( (lv_pred_1_0= rulePredicate ) ) ) | ( (lv_pred_2_0= ruleandPred ) ) )
            int alt98=2;
            int LA98_0 = input.LA(1);

            if ( (LA98_0==81) ) {
                alt98=1;
            }
            else if ( ((LA98_0>=RULE_ID && LA98_0<=RULE_INT)||LA98_0==67||(LA98_0>=75 && LA98_0<=79)||(LA98_0>=96 && LA98_0<=97)) ) {
                alt98=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 98, 0, input);

                throw nvae;
            }
            switch (alt98) {
                case 1 :
                    // InternalForml.g:4936:2: (otherlv_0= 'not' ( (lv_pred_1_0= rulePredicate ) ) )
                    {
                    // InternalForml.g:4936:2: (otherlv_0= 'not' ( (lv_pred_1_0= rulePredicate ) ) )
                    // InternalForml.g:4936:4: otherlv_0= 'not' ( (lv_pred_1_0= rulePredicate ) )
                    {
                    otherlv_0=(Token)match(input,81,FOLLOW_73); 

                        	newLeafNode(otherlv_0, grammarAccess.getNotPredAccess().getNotKeyword_0_0());
                        
                    // InternalForml.g:4940:1: ( (lv_pred_1_0= rulePredicate ) )
                    // InternalForml.g:4941:1: (lv_pred_1_0= rulePredicate )
                    {
                    // InternalForml.g:4941:1: (lv_pred_1_0= rulePredicate )
                    // InternalForml.g:4942:3: lv_pred_1_0= rulePredicate
                    {
                     
                    	        newCompositeNode(grammarAccess.getNotPredAccess().getPredPredicateParserRuleCall_0_1_0()); 
                    	    
                    pushFollow(FOLLOW_2);
                    lv_pred_1_0=rulePredicate();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getNotPredRule());
                    	        }
                           		set(
                           			current, 
                           			"pred",
                            		lv_pred_1_0, 
                            		"uw.cs.watform.forml.Forml.Predicate");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalForml.g:4959:6: ( (lv_pred_2_0= ruleandPred ) )
                    {
                    // InternalForml.g:4959:6: ( (lv_pred_2_0= ruleandPred ) )
                    // InternalForml.g:4960:1: (lv_pred_2_0= ruleandPred )
                    {
                    // InternalForml.g:4960:1: (lv_pred_2_0= ruleandPred )
                    // InternalForml.g:4961:3: lv_pred_2_0= ruleandPred
                    {
                     
                    	        newCompositeNode(grammarAccess.getNotPredAccess().getPredAndPredParserRuleCall_1_0()); 
                    	    
                    pushFollow(FOLLOW_2);
                    lv_pred_2_0=ruleandPred();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getNotPredRule());
                    	        }
                           		set(
                           			current, 
                           			"pred",
                            		lv_pred_2_0, 
                            		"uw.cs.watform.forml.Forml.andPred");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulenotPred"


    // $ANTLR start "entryRuleandPred"
    // InternalForml.g:4985:1: entryRuleandPred returns [EObject current=null] : iv_ruleandPred= ruleandPred EOF ;
    public final EObject entryRuleandPred() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleandPred = null;


        try {
            // InternalForml.g:4986:2: (iv_ruleandPred= ruleandPred EOF )
            // InternalForml.g:4987:2: iv_ruleandPred= ruleandPred EOF
            {
             newCompositeNode(grammarAccess.getAndPredRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleandPred=ruleandPred();

            state._fsp--;

             current =iv_ruleandPred; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleandPred"


    // $ANTLR start "ruleandPred"
    // InternalForml.g:4994:1: ruleandPred returns [EObject current=null] : ( ( (lv_preds_0_0= ruleimpPred ) ) (otherlv_1= 'and' ( (lv_preds_2_0= ruleimpPred ) ) )* ) ;
    public final EObject ruleandPred() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_preds_0_0 = null;

        EObject lv_preds_2_0 = null;


         enterRule(); 
            
        try {
            // InternalForml.g:4997:28: ( ( ( (lv_preds_0_0= ruleimpPred ) ) (otherlv_1= 'and' ( (lv_preds_2_0= ruleimpPred ) ) )* ) )
            // InternalForml.g:4998:1: ( ( (lv_preds_0_0= ruleimpPred ) ) (otherlv_1= 'and' ( (lv_preds_2_0= ruleimpPred ) ) )* )
            {
            // InternalForml.g:4998:1: ( ( (lv_preds_0_0= ruleimpPred ) ) (otherlv_1= 'and' ( (lv_preds_2_0= ruleimpPred ) ) )* )
            // InternalForml.g:4998:2: ( (lv_preds_0_0= ruleimpPred ) ) (otherlv_1= 'and' ( (lv_preds_2_0= ruleimpPred ) ) )*
            {
            // InternalForml.g:4998:2: ( (lv_preds_0_0= ruleimpPred ) )
            // InternalForml.g:4999:1: (lv_preds_0_0= ruleimpPred )
            {
            // InternalForml.g:4999:1: (lv_preds_0_0= ruleimpPred )
            // InternalForml.g:5000:3: lv_preds_0_0= ruleimpPred
            {
             
            	        newCompositeNode(grammarAccess.getAndPredAccess().getPredsImpPredParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_74);
            lv_preds_0_0=ruleimpPred();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAndPredRule());
            	        }
                   		add(
                   			current, 
                   			"preds",
                    		lv_preds_0_0, 
                    		"uw.cs.watform.forml.Forml.impPred");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalForml.g:5016:2: (otherlv_1= 'and' ( (lv_preds_2_0= ruleimpPred ) ) )*
            loop99:
            do {
                int alt99=2;
                int LA99_0 = input.LA(1);

                if ( (LA99_0==82) ) {
                    alt99=1;
                }


                switch (alt99) {
            	case 1 :
            	    // InternalForml.g:5016:4: otherlv_1= 'and' ( (lv_preds_2_0= ruleimpPred ) )
            	    {
            	    otherlv_1=(Token)match(input,82,FOLLOW_73); 

            	        	newLeafNode(otherlv_1, grammarAccess.getAndPredAccess().getAndKeyword_1_0());
            	        
            	    // InternalForml.g:5020:1: ( (lv_preds_2_0= ruleimpPred ) )
            	    // InternalForml.g:5021:1: (lv_preds_2_0= ruleimpPred )
            	    {
            	    // InternalForml.g:5021:1: (lv_preds_2_0= ruleimpPred )
            	    // InternalForml.g:5022:3: lv_preds_2_0= ruleimpPred
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAndPredAccess().getPredsImpPredParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_74);
            	    lv_preds_2_0=ruleimpPred();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getAndPredRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"preds",
            	            		lv_preds_2_0, 
            	            		"uw.cs.watform.forml.Forml.impPred");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop99;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleandPred"


    // $ANTLR start "entryRuleimpPred"
    // InternalForml.g:5046:1: entryRuleimpPred returns [EObject current=null] : iv_ruleimpPred= ruleimpPred EOF ;
    public final EObject entryRuleimpPred() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleimpPred = null;


        try {
            // InternalForml.g:5047:2: (iv_ruleimpPred= ruleimpPred EOF )
            // InternalForml.g:5048:2: iv_ruleimpPred= ruleimpPred EOF
            {
             newCompositeNode(grammarAccess.getImpPredRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleimpPred=ruleimpPred();

            state._fsp--;

             current =iv_ruleimpPred; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleimpPred"


    // $ANTLR start "ruleimpPred"
    // InternalForml.g:5055:1: ruleimpPred returns [EObject current=null] : ( ( (lv_preds_0_0= ruleorPred ) ) ( ( ( (lv_logicop_1_1= 'implies' | lv_logicop_1_2= 'iff' ) ) ) ( (lv_preds_2_0= ruleorPred ) ) )* ) ;
    public final EObject ruleimpPred() throws RecognitionException {
        EObject current = null;

        Token lv_logicop_1_1=null;
        Token lv_logicop_1_2=null;
        EObject lv_preds_0_0 = null;

        EObject lv_preds_2_0 = null;


         enterRule(); 
            
        try {
            // InternalForml.g:5058:28: ( ( ( (lv_preds_0_0= ruleorPred ) ) ( ( ( (lv_logicop_1_1= 'implies' | lv_logicop_1_2= 'iff' ) ) ) ( (lv_preds_2_0= ruleorPred ) ) )* ) )
            // InternalForml.g:5059:1: ( ( (lv_preds_0_0= ruleorPred ) ) ( ( ( (lv_logicop_1_1= 'implies' | lv_logicop_1_2= 'iff' ) ) ) ( (lv_preds_2_0= ruleorPred ) ) )* )
            {
            // InternalForml.g:5059:1: ( ( (lv_preds_0_0= ruleorPred ) ) ( ( ( (lv_logicop_1_1= 'implies' | lv_logicop_1_2= 'iff' ) ) ) ( (lv_preds_2_0= ruleorPred ) ) )* )
            // InternalForml.g:5059:2: ( (lv_preds_0_0= ruleorPred ) ) ( ( ( (lv_logicop_1_1= 'implies' | lv_logicop_1_2= 'iff' ) ) ) ( (lv_preds_2_0= ruleorPred ) ) )*
            {
            // InternalForml.g:5059:2: ( (lv_preds_0_0= ruleorPred ) )
            // InternalForml.g:5060:1: (lv_preds_0_0= ruleorPred )
            {
            // InternalForml.g:5060:1: (lv_preds_0_0= ruleorPred )
            // InternalForml.g:5061:3: lv_preds_0_0= ruleorPred
            {
             
            	        newCompositeNode(grammarAccess.getImpPredAccess().getPredsOrPredParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_75);
            lv_preds_0_0=ruleorPred();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getImpPredRule());
            	        }
                   		add(
                   			current, 
                   			"preds",
                    		lv_preds_0_0, 
                    		"uw.cs.watform.forml.Forml.orPred");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalForml.g:5077:2: ( ( ( (lv_logicop_1_1= 'implies' | lv_logicop_1_2= 'iff' ) ) ) ( (lv_preds_2_0= ruleorPred ) ) )*
            loop101:
            do {
                int alt101=2;
                int LA101_0 = input.LA(1);

                if ( ((LA101_0>=83 && LA101_0<=84)) ) {
                    alt101=1;
                }


                switch (alt101) {
            	case 1 :
            	    // InternalForml.g:5077:3: ( ( (lv_logicop_1_1= 'implies' | lv_logicop_1_2= 'iff' ) ) ) ( (lv_preds_2_0= ruleorPred ) )
            	    {
            	    // InternalForml.g:5077:3: ( ( (lv_logicop_1_1= 'implies' | lv_logicop_1_2= 'iff' ) ) )
            	    // InternalForml.g:5078:1: ( (lv_logicop_1_1= 'implies' | lv_logicop_1_2= 'iff' ) )
            	    {
            	    // InternalForml.g:5078:1: ( (lv_logicop_1_1= 'implies' | lv_logicop_1_2= 'iff' ) )
            	    // InternalForml.g:5079:1: (lv_logicop_1_1= 'implies' | lv_logicop_1_2= 'iff' )
            	    {
            	    // InternalForml.g:5079:1: (lv_logicop_1_1= 'implies' | lv_logicop_1_2= 'iff' )
            	    int alt100=2;
            	    int LA100_0 = input.LA(1);

            	    if ( (LA100_0==83) ) {
            	        alt100=1;
            	    }
            	    else if ( (LA100_0==84) ) {
            	        alt100=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 100, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt100) {
            	        case 1 :
            	            // InternalForml.g:5080:3: lv_logicop_1_1= 'implies'
            	            {
            	            lv_logicop_1_1=(Token)match(input,83,FOLLOW_73); 

            	                    newLeafNode(lv_logicop_1_1, grammarAccess.getImpPredAccess().getLogicopImpliesKeyword_1_0_0_0());
            	                

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getImpPredRule());
            	            	        }
            	                   		addWithLastConsumed(current, "logicop", lv_logicop_1_1, null);
            	            	    

            	            }
            	            break;
            	        case 2 :
            	            // InternalForml.g:5092:8: lv_logicop_1_2= 'iff'
            	            {
            	            lv_logicop_1_2=(Token)match(input,84,FOLLOW_73); 

            	                    newLeafNode(lv_logicop_1_2, grammarAccess.getImpPredAccess().getLogicopIffKeyword_1_0_0_1());
            	                

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getImpPredRule());
            	            	        }
            	                   		addWithLastConsumed(current, "logicop", lv_logicop_1_2, null);
            	            	    

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // InternalForml.g:5107:2: ( (lv_preds_2_0= ruleorPred ) )
            	    // InternalForml.g:5108:1: (lv_preds_2_0= ruleorPred )
            	    {
            	    // InternalForml.g:5108:1: (lv_preds_2_0= ruleorPred )
            	    // InternalForml.g:5109:3: lv_preds_2_0= ruleorPred
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getImpPredAccess().getPredsOrPredParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_75);
            	    lv_preds_2_0=ruleorPred();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getImpPredRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"preds",
            	            		lv_preds_2_0, 
            	            		"uw.cs.watform.forml.Forml.orPred");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop101;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleimpPred"


    // $ANTLR start "entryRuleorPred"
    // InternalForml.g:5133:1: entryRuleorPred returns [EObject current=null] : iv_ruleorPred= ruleorPred EOF ;
    public final EObject entryRuleorPred() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleorPred = null;


        try {
            // InternalForml.g:5134:2: (iv_ruleorPred= ruleorPred EOF )
            // InternalForml.g:5135:2: iv_ruleorPred= ruleorPred EOF
            {
             newCompositeNode(grammarAccess.getOrPredRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleorPred=ruleorPred();

            state._fsp--;

             current =iv_ruleorPred; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleorPred"


    // $ANTLR start "ruleorPred"
    // InternalForml.g:5142:1: ruleorPred returns [EObject current=null] : ( ( (lv_preds_0_0= rulebasePred ) ) (otherlv_1= 'or' ( (lv_preds_2_0= rulebasePred ) ) )* ) ;
    public final EObject ruleorPred() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_preds_0_0 = null;

        EObject lv_preds_2_0 = null;


         enterRule(); 
            
        try {
            // InternalForml.g:5145:28: ( ( ( (lv_preds_0_0= rulebasePred ) ) (otherlv_1= 'or' ( (lv_preds_2_0= rulebasePred ) ) )* ) )
            // InternalForml.g:5146:1: ( ( (lv_preds_0_0= rulebasePred ) ) (otherlv_1= 'or' ( (lv_preds_2_0= rulebasePred ) ) )* )
            {
            // InternalForml.g:5146:1: ( ( (lv_preds_0_0= rulebasePred ) ) (otherlv_1= 'or' ( (lv_preds_2_0= rulebasePred ) ) )* )
            // InternalForml.g:5146:2: ( (lv_preds_0_0= rulebasePred ) ) (otherlv_1= 'or' ( (lv_preds_2_0= rulebasePred ) ) )*
            {
            // InternalForml.g:5146:2: ( (lv_preds_0_0= rulebasePred ) )
            // InternalForml.g:5147:1: (lv_preds_0_0= rulebasePred )
            {
            // InternalForml.g:5147:1: (lv_preds_0_0= rulebasePred )
            // InternalForml.g:5148:3: lv_preds_0_0= rulebasePred
            {
             
            	        newCompositeNode(grammarAccess.getOrPredAccess().getPredsBasePredParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_76);
            lv_preds_0_0=rulebasePred();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getOrPredRule());
            	        }
                   		add(
                   			current, 
                   			"preds",
                    		lv_preds_0_0, 
                    		"uw.cs.watform.forml.Forml.basePred");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalForml.g:5164:2: (otherlv_1= 'or' ( (lv_preds_2_0= rulebasePred ) ) )*
            loop102:
            do {
                int alt102=2;
                int LA102_0 = input.LA(1);

                if ( (LA102_0==85) ) {
                    alt102=1;
                }


                switch (alt102) {
            	case 1 :
            	    // InternalForml.g:5164:4: otherlv_1= 'or' ( (lv_preds_2_0= rulebasePred ) )
            	    {
            	    otherlv_1=(Token)match(input,85,FOLLOW_73); 

            	        	newLeafNode(otherlv_1, grammarAccess.getOrPredAccess().getOrKeyword_1_0());
            	        
            	    // InternalForml.g:5168:1: ( (lv_preds_2_0= rulebasePred ) )
            	    // InternalForml.g:5169:1: (lv_preds_2_0= rulebasePred )
            	    {
            	    // InternalForml.g:5169:1: (lv_preds_2_0= rulebasePred )
            	    // InternalForml.g:5170:3: lv_preds_2_0= rulebasePred
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getOrPredAccess().getPredsBasePredParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_76);
            	    lv_preds_2_0=rulebasePred();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getOrPredRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"preds",
            	            		lv_preds_2_0, 
            	            		"uw.cs.watform.forml.Forml.basePred");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop102;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleorPred"


    // $ANTLR start "entryRulebasePred"
    // InternalForml.g:5194:1: entryRulebasePred returns [EObject current=null] : iv_rulebasePred= rulebasePred EOF ;
    public final EObject entryRulebasePred() throws RecognitionException {
        EObject current = null;

        EObject iv_rulebasePred = null;


        try {
            // InternalForml.g:5195:2: (iv_rulebasePred= rulebasePred EOF )
            // InternalForml.g:5196:2: iv_rulebasePred= rulebasePred EOF
            {
             newCompositeNode(grammarAccess.getBasePredRule()); 
            pushFollow(FOLLOW_1);
            iv_rulebasePred=rulebasePred();

            state._fsp--;

             current =iv_rulebasePred; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulebasePred"


    // $ANTLR start "rulebasePred"
    // InternalForml.g:5203:1: rulebasePred returns [EObject current=null] : ( ( ( ( (lv_logicop_0_1= 'no' | lv_logicop_0_2= 'lone' | lv_logicop_0_3= 'one' | lv_logicop_0_4= 'some' | lv_logicop_0_5= 'all' ) ) ) ( (lv_cardpred_1_0= rulesetExpr ) ) ) | ( ( (lv_setlhs_2_0= rulepredExpr ) ) ( ( (lv_logicop_3_1= 'in' | lv_logicop_3_2= '=' ) ) ) ( (lv_setrhs_4_0= rulepredExpr ) )? ) | ( ( (lv_setlhs_5_0= rulepredExpr ) ) ( ( (lv_logicop_6_1= 'in' | lv_logicop_6_2= '=' ) ) ) ( (lv_boolrhs_7_0= ruleboolExpr ) ) ) | ( ( (lv_intlhs_8_0= ruleintExpr ) ) ( ( (lv_op_9_1= '=' | lv_op_9_2= '<>' | lv_op_9_3= '>' | lv_op_9_4= '<' | lv_op_9_5= '>=' | lv_op_9_6= '=>' | lv_op_9_7= '<=' | lv_op_9_8= '=<' ) ) ) ( (lv_intrhs_10_0= ruleintExpr ) )? ) | (otherlv_11= '(' ( (lv_parenPred_12_0= rulePredicate ) ) otherlv_13= ')' ) ) ;
    public final EObject rulebasePred() throws RecognitionException {
        EObject current = null;

        Token lv_logicop_0_1=null;
        Token lv_logicop_0_2=null;
        Token lv_logicop_0_3=null;
        Token lv_logicop_0_4=null;
        Token lv_logicop_0_5=null;
        Token lv_logicop_3_1=null;
        Token lv_logicop_3_2=null;
        Token lv_logicop_6_1=null;
        Token lv_logicop_6_2=null;
        Token lv_op_9_1=null;
        Token lv_op_9_2=null;
        Token lv_op_9_3=null;
        Token lv_op_9_4=null;
        Token lv_op_9_5=null;
        Token lv_op_9_6=null;
        Token lv_op_9_7=null;
        Token lv_op_9_8=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        EObject lv_cardpred_1_0 = null;

        EObject lv_setlhs_2_0 = null;

        EObject lv_setrhs_4_0 = null;

        EObject lv_setlhs_5_0 = null;

        EObject lv_boolrhs_7_0 = null;

        EObject lv_intlhs_8_0 = null;

        EObject lv_intrhs_10_0 = null;

        EObject lv_parenPred_12_0 = null;


         enterRule(); 
            
        try {
            // InternalForml.g:5206:28: ( ( ( ( ( (lv_logicop_0_1= 'no' | lv_logicop_0_2= 'lone' | lv_logicop_0_3= 'one' | lv_logicop_0_4= 'some' | lv_logicop_0_5= 'all' ) ) ) ( (lv_cardpred_1_0= rulesetExpr ) ) ) | ( ( (lv_setlhs_2_0= rulepredExpr ) ) ( ( (lv_logicop_3_1= 'in' | lv_logicop_3_2= '=' ) ) ) ( (lv_setrhs_4_0= rulepredExpr ) )? ) | ( ( (lv_setlhs_5_0= rulepredExpr ) ) ( ( (lv_logicop_6_1= 'in' | lv_logicop_6_2= '=' ) ) ) ( (lv_boolrhs_7_0= ruleboolExpr ) ) ) | ( ( (lv_intlhs_8_0= ruleintExpr ) ) ( ( (lv_op_9_1= '=' | lv_op_9_2= '<>' | lv_op_9_3= '>' | lv_op_9_4= '<' | lv_op_9_5= '>=' | lv_op_9_6= '=>' | lv_op_9_7= '<=' | lv_op_9_8= '=<' ) ) ) ( (lv_intrhs_10_0= ruleintExpr ) )? ) | (otherlv_11= '(' ( (lv_parenPred_12_0= rulePredicate ) ) otherlv_13= ')' ) ) )
            // InternalForml.g:5207:1: ( ( ( ( (lv_logicop_0_1= 'no' | lv_logicop_0_2= 'lone' | lv_logicop_0_3= 'one' | lv_logicop_0_4= 'some' | lv_logicop_0_5= 'all' ) ) ) ( (lv_cardpred_1_0= rulesetExpr ) ) ) | ( ( (lv_setlhs_2_0= rulepredExpr ) ) ( ( (lv_logicop_3_1= 'in' | lv_logicop_3_2= '=' ) ) ) ( (lv_setrhs_4_0= rulepredExpr ) )? ) | ( ( (lv_setlhs_5_0= rulepredExpr ) ) ( ( (lv_logicop_6_1= 'in' | lv_logicop_6_2= '=' ) ) ) ( (lv_boolrhs_7_0= ruleboolExpr ) ) ) | ( ( (lv_intlhs_8_0= ruleintExpr ) ) ( ( (lv_op_9_1= '=' | lv_op_9_2= '<>' | lv_op_9_3= '>' | lv_op_9_4= '<' | lv_op_9_5= '>=' | lv_op_9_6= '=>' | lv_op_9_7= '<=' | lv_op_9_8= '=<' ) ) ) ( (lv_intrhs_10_0= ruleintExpr ) )? ) | (otherlv_11= '(' ( (lv_parenPred_12_0= rulePredicate ) ) otherlv_13= ')' ) )
            {
            // InternalForml.g:5207:1: ( ( ( ( (lv_logicop_0_1= 'no' | lv_logicop_0_2= 'lone' | lv_logicop_0_3= 'one' | lv_logicop_0_4= 'some' | lv_logicop_0_5= 'all' ) ) ) ( (lv_cardpred_1_0= rulesetExpr ) ) ) | ( ( (lv_setlhs_2_0= rulepredExpr ) ) ( ( (lv_logicop_3_1= 'in' | lv_logicop_3_2= '=' ) ) ) ( (lv_setrhs_4_0= rulepredExpr ) )? ) | ( ( (lv_setlhs_5_0= rulepredExpr ) ) ( ( (lv_logicop_6_1= 'in' | lv_logicop_6_2= '=' ) ) ) ( (lv_boolrhs_7_0= ruleboolExpr ) ) ) | ( ( (lv_intlhs_8_0= ruleintExpr ) ) ( ( (lv_op_9_1= '=' | lv_op_9_2= '<>' | lv_op_9_3= '>' | lv_op_9_4= '<' | lv_op_9_5= '>=' | lv_op_9_6= '=>' | lv_op_9_7= '<=' | lv_op_9_8= '=<' ) ) ) ( (lv_intrhs_10_0= ruleintExpr ) )? ) | (otherlv_11= '(' ( (lv_parenPred_12_0= rulePredicate ) ) otherlv_13= ')' ) )
            int alt109=5;
            alt109 = dfa109.predict(input);
            switch (alt109) {
                case 1 :
                    // InternalForml.g:5207:2: ( ( ( (lv_logicop_0_1= 'no' | lv_logicop_0_2= 'lone' | lv_logicop_0_3= 'one' | lv_logicop_0_4= 'some' | lv_logicop_0_5= 'all' ) ) ) ( (lv_cardpred_1_0= rulesetExpr ) ) )
                    {
                    // InternalForml.g:5207:2: ( ( ( (lv_logicop_0_1= 'no' | lv_logicop_0_2= 'lone' | lv_logicop_0_3= 'one' | lv_logicop_0_4= 'some' | lv_logicop_0_5= 'all' ) ) ) ( (lv_cardpred_1_0= rulesetExpr ) ) )
                    // InternalForml.g:5207:3: ( ( (lv_logicop_0_1= 'no' | lv_logicop_0_2= 'lone' | lv_logicop_0_3= 'one' | lv_logicop_0_4= 'some' | lv_logicop_0_5= 'all' ) ) ) ( (lv_cardpred_1_0= rulesetExpr ) )
                    {
                    // InternalForml.g:5207:3: ( ( (lv_logicop_0_1= 'no' | lv_logicop_0_2= 'lone' | lv_logicop_0_3= 'one' | lv_logicop_0_4= 'some' | lv_logicop_0_5= 'all' ) ) )
                    // InternalForml.g:5208:1: ( (lv_logicop_0_1= 'no' | lv_logicop_0_2= 'lone' | lv_logicop_0_3= 'one' | lv_logicop_0_4= 'some' | lv_logicop_0_5= 'all' ) )
                    {
                    // InternalForml.g:5208:1: ( (lv_logicop_0_1= 'no' | lv_logicop_0_2= 'lone' | lv_logicop_0_3= 'one' | lv_logicop_0_4= 'some' | lv_logicop_0_5= 'all' ) )
                    // InternalForml.g:5209:1: (lv_logicop_0_1= 'no' | lv_logicop_0_2= 'lone' | lv_logicop_0_3= 'one' | lv_logicop_0_4= 'some' | lv_logicop_0_5= 'all' )
                    {
                    // InternalForml.g:5209:1: (lv_logicop_0_1= 'no' | lv_logicop_0_2= 'lone' | lv_logicop_0_3= 'one' | lv_logicop_0_4= 'some' | lv_logicop_0_5= 'all' )
                    int alt103=5;
                    switch ( input.LA(1) ) {
                    case 75:
                        {
                        alt103=1;
                        }
                        break;
                    case 76:
                        {
                        alt103=2;
                        }
                        break;
                    case 77:
                        {
                        alt103=3;
                        }
                        break;
                    case 78:
                        {
                        alt103=4;
                        }
                        break;
                    case 79:
                        {
                        alt103=5;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 103, 0, input);

                        throw nvae;
                    }

                    switch (alt103) {
                        case 1 :
                            // InternalForml.g:5210:3: lv_logicop_0_1= 'no'
                            {
                            lv_logicop_0_1=(Token)match(input,75,FOLLOW_67); 

                                    newLeafNode(lv_logicop_0_1, grammarAccess.getBasePredAccess().getLogicopNoKeyword_0_0_0_0());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getBasePredRule());
                            	        }
                                   		setWithLastConsumed(current, "logicop", lv_logicop_0_1, null);
                            	    

                            }
                            break;
                        case 2 :
                            // InternalForml.g:5222:8: lv_logicop_0_2= 'lone'
                            {
                            lv_logicop_0_2=(Token)match(input,76,FOLLOW_67); 

                                    newLeafNode(lv_logicop_0_2, grammarAccess.getBasePredAccess().getLogicopLoneKeyword_0_0_0_1());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getBasePredRule());
                            	        }
                                   		setWithLastConsumed(current, "logicop", lv_logicop_0_2, null);
                            	    

                            }
                            break;
                        case 3 :
                            // InternalForml.g:5234:8: lv_logicop_0_3= 'one'
                            {
                            lv_logicop_0_3=(Token)match(input,77,FOLLOW_67); 

                                    newLeafNode(lv_logicop_0_3, grammarAccess.getBasePredAccess().getLogicopOneKeyword_0_0_0_2());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getBasePredRule());
                            	        }
                                   		setWithLastConsumed(current, "logicop", lv_logicop_0_3, null);
                            	    

                            }
                            break;
                        case 4 :
                            // InternalForml.g:5246:8: lv_logicop_0_4= 'some'
                            {
                            lv_logicop_0_4=(Token)match(input,78,FOLLOW_67); 

                                    newLeafNode(lv_logicop_0_4, grammarAccess.getBasePredAccess().getLogicopSomeKeyword_0_0_0_3());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getBasePredRule());
                            	        }
                                   		setWithLastConsumed(current, "logicop", lv_logicop_0_4, null);
                            	    

                            }
                            break;
                        case 5 :
                            // InternalForml.g:5258:8: lv_logicop_0_5= 'all'
                            {
                            lv_logicop_0_5=(Token)match(input,79,FOLLOW_67); 

                                    newLeafNode(lv_logicop_0_5, grammarAccess.getBasePredAccess().getLogicopAllKeyword_0_0_0_4());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getBasePredRule());
                            	        }
                                   		setWithLastConsumed(current, "logicop", lv_logicop_0_5, null);
                            	    

                            }
                            break;

                    }


                    }


                    }

                    // InternalForml.g:5273:2: ( (lv_cardpred_1_0= rulesetExpr ) )
                    // InternalForml.g:5274:1: (lv_cardpred_1_0= rulesetExpr )
                    {
                    // InternalForml.g:5274:1: (lv_cardpred_1_0= rulesetExpr )
                    // InternalForml.g:5275:3: lv_cardpred_1_0= rulesetExpr
                    {
                     
                    	        newCompositeNode(grammarAccess.getBasePredAccess().getCardpredSetExprParserRuleCall_0_1_0()); 
                    	    
                    pushFollow(FOLLOW_2);
                    lv_cardpred_1_0=rulesetExpr();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getBasePredRule());
                    	        }
                           		set(
                           			current, 
                           			"cardpred",
                            		lv_cardpred_1_0, 
                            		"uw.cs.watform.forml.Forml.setExpr");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalForml.g:5292:6: ( ( (lv_setlhs_2_0= rulepredExpr ) ) ( ( (lv_logicop_3_1= 'in' | lv_logicop_3_2= '=' ) ) ) ( (lv_setrhs_4_0= rulepredExpr ) )? )
                    {
                    // InternalForml.g:5292:6: ( ( (lv_setlhs_2_0= rulepredExpr ) ) ( ( (lv_logicop_3_1= 'in' | lv_logicop_3_2= '=' ) ) ) ( (lv_setrhs_4_0= rulepredExpr ) )? )
                    // InternalForml.g:5292:7: ( (lv_setlhs_2_0= rulepredExpr ) ) ( ( (lv_logicop_3_1= 'in' | lv_logicop_3_2= '=' ) ) ) ( (lv_setrhs_4_0= rulepredExpr ) )?
                    {
                    // InternalForml.g:5292:7: ( (lv_setlhs_2_0= rulepredExpr ) )
                    // InternalForml.g:5293:1: (lv_setlhs_2_0= rulepredExpr )
                    {
                    // InternalForml.g:5293:1: (lv_setlhs_2_0= rulepredExpr )
                    // InternalForml.g:5294:3: lv_setlhs_2_0= rulepredExpr
                    {
                     
                    	        newCompositeNode(grammarAccess.getBasePredAccess().getSetlhsPredExprParserRuleCall_1_0_0()); 
                    	    
                    pushFollow(FOLLOW_77);
                    lv_setlhs_2_0=rulepredExpr();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getBasePredRule());
                    	        }
                           		set(
                           			current, 
                           			"setlhs",
                            		lv_setlhs_2_0, 
                            		"uw.cs.watform.forml.Forml.predExpr");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // InternalForml.g:5310:2: ( ( (lv_logicop_3_1= 'in' | lv_logicop_3_2= '=' ) ) )
                    // InternalForml.g:5311:1: ( (lv_logicop_3_1= 'in' | lv_logicop_3_2= '=' ) )
                    {
                    // InternalForml.g:5311:1: ( (lv_logicop_3_1= 'in' | lv_logicop_3_2= '=' ) )
                    // InternalForml.g:5312:1: (lv_logicop_3_1= 'in' | lv_logicop_3_2= '=' )
                    {
                    // InternalForml.g:5312:1: (lv_logicop_3_1= 'in' | lv_logicop_3_2= '=' )
                    int alt104=2;
                    int LA104_0 = input.LA(1);

                    if ( (LA104_0==86) ) {
                        alt104=1;
                    }
                    else if ( (LA104_0==58) ) {
                        alt104=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 104, 0, input);

                        throw nvae;
                    }
                    switch (alt104) {
                        case 1 :
                            // InternalForml.g:5313:3: lv_logicop_3_1= 'in'
                            {
                            lv_logicop_3_1=(Token)match(input,86,FOLLOW_78); 

                                    newLeafNode(lv_logicop_3_1, grammarAccess.getBasePredAccess().getLogicopInKeyword_1_1_0_0());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getBasePredRule());
                            	        }
                                   		setWithLastConsumed(current, "logicop", lv_logicop_3_1, null);
                            	    

                            }
                            break;
                        case 2 :
                            // InternalForml.g:5325:8: lv_logicop_3_2= '='
                            {
                            lv_logicop_3_2=(Token)match(input,58,FOLLOW_78); 

                                    newLeafNode(lv_logicop_3_2, grammarAccess.getBasePredAccess().getLogicopEqualsSignKeyword_1_1_0_1());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getBasePredRule());
                            	        }
                                   		setWithLastConsumed(current, "logicop", lv_logicop_3_2, null);
                            	    

                            }
                            break;

                    }


                    }


                    }

                    // InternalForml.g:5340:2: ( (lv_setrhs_4_0= rulepredExpr ) )?
                    int alt105=2;
                    alt105 = dfa105.predict(input);
                    switch (alt105) {
                        case 1 :
                            // InternalForml.g:5341:1: (lv_setrhs_4_0= rulepredExpr )
                            {
                            // InternalForml.g:5341:1: (lv_setrhs_4_0= rulepredExpr )
                            // InternalForml.g:5342:3: lv_setrhs_4_0= rulepredExpr
                            {
                             
                            	        newCompositeNode(grammarAccess.getBasePredAccess().getSetrhsPredExprParserRuleCall_1_2_0()); 
                            	    
                            pushFollow(FOLLOW_2);
                            lv_setrhs_4_0=rulepredExpr();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getBasePredRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"setrhs",
                                    		lv_setrhs_4_0, 
                                    		"uw.cs.watform.forml.Forml.predExpr");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalForml.g:5359:6: ( ( (lv_setlhs_5_0= rulepredExpr ) ) ( ( (lv_logicop_6_1= 'in' | lv_logicop_6_2= '=' ) ) ) ( (lv_boolrhs_7_0= ruleboolExpr ) ) )
                    {
                    // InternalForml.g:5359:6: ( ( (lv_setlhs_5_0= rulepredExpr ) ) ( ( (lv_logicop_6_1= 'in' | lv_logicop_6_2= '=' ) ) ) ( (lv_boolrhs_7_0= ruleboolExpr ) ) )
                    // InternalForml.g:5359:7: ( (lv_setlhs_5_0= rulepredExpr ) ) ( ( (lv_logicop_6_1= 'in' | lv_logicop_6_2= '=' ) ) ) ( (lv_boolrhs_7_0= ruleboolExpr ) )
                    {
                    // InternalForml.g:5359:7: ( (lv_setlhs_5_0= rulepredExpr ) )
                    // InternalForml.g:5360:1: (lv_setlhs_5_0= rulepredExpr )
                    {
                    // InternalForml.g:5360:1: (lv_setlhs_5_0= rulepredExpr )
                    // InternalForml.g:5361:3: lv_setlhs_5_0= rulepredExpr
                    {
                     
                    	        newCompositeNode(grammarAccess.getBasePredAccess().getSetlhsPredExprParserRuleCall_2_0_0()); 
                    	    
                    pushFollow(FOLLOW_77);
                    lv_setlhs_5_0=rulepredExpr();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getBasePredRule());
                    	        }
                           		set(
                           			current, 
                           			"setlhs",
                            		lv_setlhs_5_0, 
                            		"uw.cs.watform.forml.Forml.predExpr");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // InternalForml.g:5377:2: ( ( (lv_logicop_6_1= 'in' | lv_logicop_6_2= '=' ) ) )
                    // InternalForml.g:5378:1: ( (lv_logicop_6_1= 'in' | lv_logicop_6_2= '=' ) )
                    {
                    // InternalForml.g:5378:1: ( (lv_logicop_6_1= 'in' | lv_logicop_6_2= '=' ) )
                    // InternalForml.g:5379:1: (lv_logicop_6_1= 'in' | lv_logicop_6_2= '=' )
                    {
                    // InternalForml.g:5379:1: (lv_logicop_6_1= 'in' | lv_logicop_6_2= '=' )
                    int alt106=2;
                    int LA106_0 = input.LA(1);

                    if ( (LA106_0==86) ) {
                        alt106=1;
                    }
                    else if ( (LA106_0==58) ) {
                        alt106=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 106, 0, input);

                        throw nvae;
                    }
                    switch (alt106) {
                        case 1 :
                            // InternalForml.g:5380:3: lv_logicop_6_1= 'in'
                            {
                            lv_logicop_6_1=(Token)match(input,86,FOLLOW_79); 

                                    newLeafNode(lv_logicop_6_1, grammarAccess.getBasePredAccess().getLogicopInKeyword_2_1_0_0());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getBasePredRule());
                            	        }
                                   		setWithLastConsumed(current, "logicop", lv_logicop_6_1, null);
                            	    

                            }
                            break;
                        case 2 :
                            // InternalForml.g:5392:8: lv_logicop_6_2= '='
                            {
                            lv_logicop_6_2=(Token)match(input,58,FOLLOW_79); 

                                    newLeafNode(lv_logicop_6_2, grammarAccess.getBasePredAccess().getLogicopEqualsSignKeyword_2_1_0_1());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getBasePredRule());
                            	        }
                                   		setWithLastConsumed(current, "logicop", lv_logicop_6_2, null);
                            	    

                            }
                            break;

                    }


                    }


                    }

                    // InternalForml.g:5407:2: ( (lv_boolrhs_7_0= ruleboolExpr ) )
                    // InternalForml.g:5408:1: (lv_boolrhs_7_0= ruleboolExpr )
                    {
                    // InternalForml.g:5408:1: (lv_boolrhs_7_0= ruleboolExpr )
                    // InternalForml.g:5409:3: lv_boolrhs_7_0= ruleboolExpr
                    {
                     
                    	        newCompositeNode(grammarAccess.getBasePredAccess().getBoolrhsBoolExprParserRuleCall_2_2_0()); 
                    	    
                    pushFollow(FOLLOW_2);
                    lv_boolrhs_7_0=ruleboolExpr();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getBasePredRule());
                    	        }
                           		set(
                           			current, 
                           			"boolrhs",
                            		lv_boolrhs_7_0, 
                            		"uw.cs.watform.forml.Forml.boolExpr");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalForml.g:5426:6: ( ( (lv_intlhs_8_0= ruleintExpr ) ) ( ( (lv_op_9_1= '=' | lv_op_9_2= '<>' | lv_op_9_3= '>' | lv_op_9_4= '<' | lv_op_9_5= '>=' | lv_op_9_6= '=>' | lv_op_9_7= '<=' | lv_op_9_8= '=<' ) ) ) ( (lv_intrhs_10_0= ruleintExpr ) )? )
                    {
                    // InternalForml.g:5426:6: ( ( (lv_intlhs_8_0= ruleintExpr ) ) ( ( (lv_op_9_1= '=' | lv_op_9_2= '<>' | lv_op_9_3= '>' | lv_op_9_4= '<' | lv_op_9_5= '>=' | lv_op_9_6= '=>' | lv_op_9_7= '<=' | lv_op_9_8= '=<' ) ) ) ( (lv_intrhs_10_0= ruleintExpr ) )? )
                    // InternalForml.g:5426:7: ( (lv_intlhs_8_0= ruleintExpr ) ) ( ( (lv_op_9_1= '=' | lv_op_9_2= '<>' | lv_op_9_3= '>' | lv_op_9_4= '<' | lv_op_9_5= '>=' | lv_op_9_6= '=>' | lv_op_9_7= '<=' | lv_op_9_8= '=<' ) ) ) ( (lv_intrhs_10_0= ruleintExpr ) )?
                    {
                    // InternalForml.g:5426:7: ( (lv_intlhs_8_0= ruleintExpr ) )
                    // InternalForml.g:5427:1: (lv_intlhs_8_0= ruleintExpr )
                    {
                    // InternalForml.g:5427:1: (lv_intlhs_8_0= ruleintExpr )
                    // InternalForml.g:5428:3: lv_intlhs_8_0= ruleintExpr
                    {
                     
                    	        newCompositeNode(grammarAccess.getBasePredAccess().getIntlhsIntExprParserRuleCall_3_0_0()); 
                    	    
                    pushFollow(FOLLOW_80);
                    lv_intlhs_8_0=ruleintExpr();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getBasePredRule());
                    	        }
                           		set(
                           			current, 
                           			"intlhs",
                            		lv_intlhs_8_0, 
                            		"uw.cs.watform.forml.Forml.intExpr");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // InternalForml.g:5444:2: ( ( (lv_op_9_1= '=' | lv_op_9_2= '<>' | lv_op_9_3= '>' | lv_op_9_4= '<' | lv_op_9_5= '>=' | lv_op_9_6= '=>' | lv_op_9_7= '<=' | lv_op_9_8= '=<' ) ) )
                    // InternalForml.g:5445:1: ( (lv_op_9_1= '=' | lv_op_9_2= '<>' | lv_op_9_3= '>' | lv_op_9_4= '<' | lv_op_9_5= '>=' | lv_op_9_6= '=>' | lv_op_9_7= '<=' | lv_op_9_8= '=<' ) )
                    {
                    // InternalForml.g:5445:1: ( (lv_op_9_1= '=' | lv_op_9_2= '<>' | lv_op_9_3= '>' | lv_op_9_4= '<' | lv_op_9_5= '>=' | lv_op_9_6= '=>' | lv_op_9_7= '<=' | lv_op_9_8= '=<' ) )
                    // InternalForml.g:5446:1: (lv_op_9_1= '=' | lv_op_9_2= '<>' | lv_op_9_3= '>' | lv_op_9_4= '<' | lv_op_9_5= '>=' | lv_op_9_6= '=>' | lv_op_9_7= '<=' | lv_op_9_8= '=<' )
                    {
                    // InternalForml.g:5446:1: (lv_op_9_1= '=' | lv_op_9_2= '<>' | lv_op_9_3= '>' | lv_op_9_4= '<' | lv_op_9_5= '>=' | lv_op_9_6= '=>' | lv_op_9_7= '<=' | lv_op_9_8= '=<' )
                    int alt107=8;
                    switch ( input.LA(1) ) {
                    case 58:
                        {
                        alt107=1;
                        }
                        break;
                    case 87:
                        {
                        alt107=2;
                        }
                        break;
                    case 63:
                        {
                        alt107=3;
                        }
                        break;
                    case 88:
                        {
                        alt107=4;
                        }
                        break;
                    case 89:
                        {
                        alt107=5;
                        }
                        break;
                    case 90:
                        {
                        alt107=6;
                        }
                        break;
                    case 91:
                        {
                        alt107=7;
                        }
                        break;
                    case 92:
                        {
                        alt107=8;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 107, 0, input);

                        throw nvae;
                    }

                    switch (alt107) {
                        case 1 :
                            // InternalForml.g:5447:3: lv_op_9_1= '='
                            {
                            lv_op_9_1=(Token)match(input,58,FOLLOW_81); 

                                    newLeafNode(lv_op_9_1, grammarAccess.getBasePredAccess().getOpEqualsSignKeyword_3_1_0_0());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getBasePredRule());
                            	        }
                                   		setWithLastConsumed(current, "op", lv_op_9_1, null);
                            	    

                            }
                            break;
                        case 2 :
                            // InternalForml.g:5459:8: lv_op_9_2= '<>'
                            {
                            lv_op_9_2=(Token)match(input,87,FOLLOW_81); 

                                    newLeafNode(lv_op_9_2, grammarAccess.getBasePredAccess().getOpLessThanSignGreaterThanSignKeyword_3_1_0_1());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getBasePredRule());
                            	        }
                                   		setWithLastConsumed(current, "op", lv_op_9_2, null);
                            	    

                            }
                            break;
                        case 3 :
                            // InternalForml.g:5471:8: lv_op_9_3= '>'
                            {
                            lv_op_9_3=(Token)match(input,63,FOLLOW_81); 

                                    newLeafNode(lv_op_9_3, grammarAccess.getBasePredAccess().getOpGreaterThanSignKeyword_3_1_0_2());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getBasePredRule());
                            	        }
                                   		setWithLastConsumed(current, "op", lv_op_9_3, null);
                            	    

                            }
                            break;
                        case 4 :
                            // InternalForml.g:5483:8: lv_op_9_4= '<'
                            {
                            lv_op_9_4=(Token)match(input,88,FOLLOW_81); 

                                    newLeafNode(lv_op_9_4, grammarAccess.getBasePredAccess().getOpLessThanSignKeyword_3_1_0_3());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getBasePredRule());
                            	        }
                                   		setWithLastConsumed(current, "op", lv_op_9_4, null);
                            	    

                            }
                            break;
                        case 5 :
                            // InternalForml.g:5495:8: lv_op_9_5= '>='
                            {
                            lv_op_9_5=(Token)match(input,89,FOLLOW_81); 

                                    newLeafNode(lv_op_9_5, grammarAccess.getBasePredAccess().getOpGreaterThanSignEqualsSignKeyword_3_1_0_4());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getBasePredRule());
                            	        }
                                   		setWithLastConsumed(current, "op", lv_op_9_5, null);
                            	    

                            }
                            break;
                        case 6 :
                            // InternalForml.g:5507:8: lv_op_9_6= '=>'
                            {
                            lv_op_9_6=(Token)match(input,90,FOLLOW_81); 

                                    newLeafNode(lv_op_9_6, grammarAccess.getBasePredAccess().getOpEqualsSignGreaterThanSignKeyword_3_1_0_5());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getBasePredRule());
                            	        }
                                   		setWithLastConsumed(current, "op", lv_op_9_6, null);
                            	    

                            }
                            break;
                        case 7 :
                            // InternalForml.g:5519:8: lv_op_9_7= '<='
                            {
                            lv_op_9_7=(Token)match(input,91,FOLLOW_81); 

                                    newLeafNode(lv_op_9_7, grammarAccess.getBasePredAccess().getOpLessThanSignEqualsSignKeyword_3_1_0_6());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getBasePredRule());
                            	        }
                                   		setWithLastConsumed(current, "op", lv_op_9_7, null);
                            	    

                            }
                            break;
                        case 8 :
                            // InternalForml.g:5531:8: lv_op_9_8= '=<'
                            {
                            lv_op_9_8=(Token)match(input,92,FOLLOW_81); 

                                    newLeafNode(lv_op_9_8, grammarAccess.getBasePredAccess().getOpEqualsSignLessThanSignKeyword_3_1_0_7());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getBasePredRule());
                            	        }
                                   		setWithLastConsumed(current, "op", lv_op_9_8, null);
                            	    

                            }
                            break;

                    }


                    }


                    }

                    // InternalForml.g:5546:2: ( (lv_intrhs_10_0= ruleintExpr ) )?
                    int alt108=2;
                    alt108 = dfa108.predict(input);
                    switch (alt108) {
                        case 1 :
                            // InternalForml.g:5547:1: (lv_intrhs_10_0= ruleintExpr )
                            {
                            // InternalForml.g:5547:1: (lv_intrhs_10_0= ruleintExpr )
                            // InternalForml.g:5548:3: lv_intrhs_10_0= ruleintExpr
                            {
                             
                            	        newCompositeNode(grammarAccess.getBasePredAccess().getIntrhsIntExprParserRuleCall_3_2_0()); 
                            	    
                            pushFollow(FOLLOW_2);
                            lv_intrhs_10_0=ruleintExpr();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getBasePredRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"intrhs",
                                    		lv_intrhs_10_0, 
                                    		"uw.cs.watform.forml.Forml.intExpr");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalForml.g:5565:6: (otherlv_11= '(' ( (lv_parenPred_12_0= rulePredicate ) ) otherlv_13= ')' )
                    {
                    // InternalForml.g:5565:6: (otherlv_11= '(' ( (lv_parenPred_12_0= rulePredicate ) ) otherlv_13= ')' )
                    // InternalForml.g:5565:8: otherlv_11= '(' ( (lv_parenPred_12_0= rulePredicate ) ) otherlv_13= ')'
                    {
                    otherlv_11=(Token)match(input,67,FOLLOW_73); 

                        	newLeafNode(otherlv_11, grammarAccess.getBasePredAccess().getLeftParenthesisKeyword_4_0());
                        
                    // InternalForml.g:5569:1: ( (lv_parenPred_12_0= rulePredicate ) )
                    // InternalForml.g:5570:1: (lv_parenPred_12_0= rulePredicate )
                    {
                    // InternalForml.g:5570:1: (lv_parenPred_12_0= rulePredicate )
                    // InternalForml.g:5571:3: lv_parenPred_12_0= rulePredicate
                    {
                     
                    	        newCompositeNode(grammarAccess.getBasePredAccess().getParenPredPredicateParserRuleCall_4_1_0()); 
                    	    
                    pushFollow(FOLLOW_63);
                    lv_parenPred_12_0=rulePredicate();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getBasePredRule());
                    	        }
                           		set(
                           			current, 
                           			"parenPred",
                            		lv_parenPred_12_0, 
                            		"uw.cs.watform.forml.Forml.Predicate");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_13=(Token)match(input,68,FOLLOW_2); 

                        	newLeafNode(otherlv_13, grammarAccess.getBasePredAccess().getRightParenthesisKeyword_4_2());
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulebasePred"


    // $ANTLR start "entryRuleboolExpr"
    // InternalForml.g:5599:1: entryRuleboolExpr returns [EObject current=null] : iv_ruleboolExpr= ruleboolExpr EOF ;
    public final EObject entryRuleboolExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleboolExpr = null;


        try {
            // InternalForml.g:5600:2: (iv_ruleboolExpr= ruleboolExpr EOF )
            // InternalForml.g:5601:2: iv_ruleboolExpr= ruleboolExpr EOF
            {
             newCompositeNode(grammarAccess.getBoolExprRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleboolExpr=ruleboolExpr();

            state._fsp--;

             current =iv_ruleboolExpr; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleboolExpr"


    // $ANTLR start "ruleboolExpr"
    // InternalForml.g:5608:1: ruleboolExpr returns [EObject current=null] : ( ( (lv_isTrue_0_0= 'true' ) ) | ( (lv_isFalse_1_0= 'false' ) ) ) ;
    public final EObject ruleboolExpr() throws RecognitionException {
        EObject current = null;

        Token lv_isTrue_0_0=null;
        Token lv_isFalse_1_0=null;

         enterRule(); 
            
        try {
            // InternalForml.g:5611:28: ( ( ( (lv_isTrue_0_0= 'true' ) ) | ( (lv_isFalse_1_0= 'false' ) ) ) )
            // InternalForml.g:5612:1: ( ( (lv_isTrue_0_0= 'true' ) ) | ( (lv_isFalse_1_0= 'false' ) ) )
            {
            // InternalForml.g:5612:1: ( ( (lv_isTrue_0_0= 'true' ) ) | ( (lv_isFalse_1_0= 'false' ) ) )
            int alt110=2;
            int LA110_0 = input.LA(1);

            if ( (LA110_0==93) ) {
                alt110=1;
            }
            else if ( (LA110_0==94) ) {
                alt110=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 110, 0, input);

                throw nvae;
            }
            switch (alt110) {
                case 1 :
                    // InternalForml.g:5612:2: ( (lv_isTrue_0_0= 'true' ) )
                    {
                    // InternalForml.g:5612:2: ( (lv_isTrue_0_0= 'true' ) )
                    // InternalForml.g:5613:1: (lv_isTrue_0_0= 'true' )
                    {
                    // InternalForml.g:5613:1: (lv_isTrue_0_0= 'true' )
                    // InternalForml.g:5614:3: lv_isTrue_0_0= 'true'
                    {
                    lv_isTrue_0_0=(Token)match(input,93,FOLLOW_2); 

                            newLeafNode(lv_isTrue_0_0, grammarAccess.getBoolExprAccess().getIsTrueTrueKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getBoolExprRule());
                    	        }
                           		setWithLastConsumed(current, "isTrue", lv_isTrue_0_0, "true");
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalForml.g:5628:6: ( (lv_isFalse_1_0= 'false' ) )
                    {
                    // InternalForml.g:5628:6: ( (lv_isFalse_1_0= 'false' ) )
                    // InternalForml.g:5629:1: (lv_isFalse_1_0= 'false' )
                    {
                    // InternalForml.g:5629:1: (lv_isFalse_1_0= 'false' )
                    // InternalForml.g:5630:3: lv_isFalse_1_0= 'false'
                    {
                    lv_isFalse_1_0=(Token)match(input,94,FOLLOW_2); 

                            newLeafNode(lv_isFalse_1_0, grammarAccess.getBoolExprAccess().getIsFalseFalseKeyword_1_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getBoolExprRule());
                    	        }
                           		setWithLastConsumed(current, "isFalse", lv_isFalse_1_0, "false");
                    	    

                    }


                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleboolExpr"


    // $ANTLR start "entryRulepredExpr"
    // InternalForml.g:5651:1: entryRulepredExpr returns [EObject current=null] : iv_rulepredExpr= rulepredExpr EOF ;
    public final EObject entryRulepredExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_rulepredExpr = null;


        try {
            // InternalForml.g:5652:2: (iv_rulepredExpr= rulepredExpr EOF )
            // InternalForml.g:5653:2: iv_rulepredExpr= rulepredExpr EOF
            {
             newCompositeNode(grammarAccess.getPredExprRule()); 
            pushFollow(FOLLOW_1);
            iv_rulepredExpr=rulepredExpr();

            state._fsp--;

             current =iv_rulepredExpr; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulepredExpr"


    // $ANTLR start "rulepredExpr"
    // InternalForml.g:5660:1: rulepredExpr returns [EObject current=null] : ( ( (lv_expr_0_0= rulepredExpr2 ) ) (otherlv_1= '&' ( (lv_expr_2_0= rulepredExpr2 ) ) )* ) ;
    public final EObject rulepredExpr() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_expr_0_0 = null;

        EObject lv_expr_2_0 = null;


         enterRule(); 
            
        try {
            // InternalForml.g:5663:28: ( ( ( (lv_expr_0_0= rulepredExpr2 ) ) (otherlv_1= '&' ( (lv_expr_2_0= rulepredExpr2 ) ) )* ) )
            // InternalForml.g:5664:1: ( ( (lv_expr_0_0= rulepredExpr2 ) ) (otherlv_1= '&' ( (lv_expr_2_0= rulepredExpr2 ) ) )* )
            {
            // InternalForml.g:5664:1: ( ( (lv_expr_0_0= rulepredExpr2 ) ) (otherlv_1= '&' ( (lv_expr_2_0= rulepredExpr2 ) ) )* )
            // InternalForml.g:5664:2: ( (lv_expr_0_0= rulepredExpr2 ) ) (otherlv_1= '&' ( (lv_expr_2_0= rulepredExpr2 ) ) )*
            {
            // InternalForml.g:5664:2: ( (lv_expr_0_0= rulepredExpr2 ) )
            // InternalForml.g:5665:1: (lv_expr_0_0= rulepredExpr2 )
            {
            // InternalForml.g:5665:1: (lv_expr_0_0= rulepredExpr2 )
            // InternalForml.g:5666:3: lv_expr_0_0= rulepredExpr2
            {
             
            	        newCompositeNode(grammarAccess.getPredExprAccess().getExprPredExpr2ParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_82);
            lv_expr_0_0=rulepredExpr2();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getPredExprRule());
            	        }
                   		add(
                   			current, 
                   			"expr",
                    		lv_expr_0_0, 
                    		"uw.cs.watform.forml.Forml.predExpr2");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalForml.g:5682:2: (otherlv_1= '&' ( (lv_expr_2_0= rulepredExpr2 ) ) )*
            loop111:
            do {
                int alt111=2;
                int LA111_0 = input.LA(1);

                if ( (LA111_0==95) ) {
                    alt111=1;
                }


                switch (alt111) {
            	case 1 :
            	    // InternalForml.g:5682:4: otherlv_1= '&' ( (lv_expr_2_0= rulepredExpr2 ) )
            	    {
            	    otherlv_1=(Token)match(input,95,FOLLOW_83); 

            	        	newLeafNode(otherlv_1, grammarAccess.getPredExprAccess().getAmpersandKeyword_1_0());
            	        
            	    // InternalForml.g:5686:1: ( (lv_expr_2_0= rulepredExpr2 ) )
            	    // InternalForml.g:5687:1: (lv_expr_2_0= rulepredExpr2 )
            	    {
            	    // InternalForml.g:5687:1: (lv_expr_2_0= rulepredExpr2 )
            	    // InternalForml.g:5688:3: lv_expr_2_0= rulepredExpr2
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPredExprAccess().getExprPredExpr2ParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_82);
            	    lv_expr_2_0=rulepredExpr2();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getPredExprRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"expr",
            	            		lv_expr_2_0, 
            	            		"uw.cs.watform.forml.Forml.predExpr2");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop111;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulepredExpr"


    // $ANTLR start "entryRulepredExpr2"
    // InternalForml.g:5712:1: entryRulepredExpr2 returns [EObject current=null] : iv_rulepredExpr2= rulepredExpr2 EOF ;
    public final EObject entryRulepredExpr2() throws RecognitionException {
        EObject current = null;

        EObject iv_rulepredExpr2 = null;


        try {
            // InternalForml.g:5713:2: (iv_rulepredExpr2= rulepredExpr2 EOF )
            // InternalForml.g:5714:2: iv_rulepredExpr2= rulepredExpr2 EOF
            {
             newCompositeNode(grammarAccess.getPredExpr2Rule()); 
            pushFollow(FOLLOW_1);
            iv_rulepredExpr2=rulepredExpr2();

            state._fsp--;

             current =iv_rulepredExpr2; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulepredExpr2"


    // $ANTLR start "rulepredExpr2"
    // InternalForml.g:5721:1: rulepredExpr2 returns [EObject current=null] : ( ( (lv_expr_0_0= rulepredExpr3 ) ) ( ( ( (lv_op_1_1= '-' | lv_op_1_2= '+' ) ) ) ( (lv_expr_2_0= rulepredExpr3 ) ) )* ) ;
    public final EObject rulepredExpr2() throws RecognitionException {
        EObject current = null;

        Token lv_op_1_1=null;
        Token lv_op_1_2=null;
        EObject lv_expr_0_0 = null;

        EObject lv_expr_2_0 = null;


         enterRule(); 
            
        try {
            // InternalForml.g:5724:28: ( ( ( (lv_expr_0_0= rulepredExpr3 ) ) ( ( ( (lv_op_1_1= '-' | lv_op_1_2= '+' ) ) ) ( (lv_expr_2_0= rulepredExpr3 ) ) )* ) )
            // InternalForml.g:5725:1: ( ( (lv_expr_0_0= rulepredExpr3 ) ) ( ( ( (lv_op_1_1= '-' | lv_op_1_2= '+' ) ) ) ( (lv_expr_2_0= rulepredExpr3 ) ) )* )
            {
            // InternalForml.g:5725:1: ( ( (lv_expr_0_0= rulepredExpr3 ) ) ( ( ( (lv_op_1_1= '-' | lv_op_1_2= '+' ) ) ) ( (lv_expr_2_0= rulepredExpr3 ) ) )* )
            // InternalForml.g:5725:2: ( (lv_expr_0_0= rulepredExpr3 ) ) ( ( ( (lv_op_1_1= '-' | lv_op_1_2= '+' ) ) ) ( (lv_expr_2_0= rulepredExpr3 ) ) )*
            {
            // InternalForml.g:5725:2: ( (lv_expr_0_0= rulepredExpr3 ) )
            // InternalForml.g:5726:1: (lv_expr_0_0= rulepredExpr3 )
            {
            // InternalForml.g:5726:1: (lv_expr_0_0= rulepredExpr3 )
            // InternalForml.g:5727:3: lv_expr_0_0= rulepredExpr3
            {
             
            	        newCompositeNode(grammarAccess.getPredExpr2Access().getExprPredExpr3ParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_84);
            lv_expr_0_0=rulepredExpr3();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getPredExpr2Rule());
            	        }
                   		add(
                   			current, 
                   			"expr",
                    		lv_expr_0_0, 
                    		"uw.cs.watform.forml.Forml.predExpr3");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalForml.g:5743:2: ( ( ( (lv_op_1_1= '-' | lv_op_1_2= '+' ) ) ) ( (lv_expr_2_0= rulepredExpr3 ) ) )*
            loop113:
            do {
                int alt113=2;
                int LA113_0 = input.LA(1);

                if ( ((LA113_0>=69 && LA113_0<=70)) ) {
                    alt113=1;
                }


                switch (alt113) {
            	case 1 :
            	    // InternalForml.g:5743:3: ( ( (lv_op_1_1= '-' | lv_op_1_2= '+' ) ) ) ( (lv_expr_2_0= rulepredExpr3 ) )
            	    {
            	    // InternalForml.g:5743:3: ( ( (lv_op_1_1= '-' | lv_op_1_2= '+' ) ) )
            	    // InternalForml.g:5744:1: ( (lv_op_1_1= '-' | lv_op_1_2= '+' ) )
            	    {
            	    // InternalForml.g:5744:1: ( (lv_op_1_1= '-' | lv_op_1_2= '+' ) )
            	    // InternalForml.g:5745:1: (lv_op_1_1= '-' | lv_op_1_2= '+' )
            	    {
            	    // InternalForml.g:5745:1: (lv_op_1_1= '-' | lv_op_1_2= '+' )
            	    int alt112=2;
            	    int LA112_0 = input.LA(1);

            	    if ( (LA112_0==70) ) {
            	        alt112=1;
            	    }
            	    else if ( (LA112_0==69) ) {
            	        alt112=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 112, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt112) {
            	        case 1 :
            	            // InternalForml.g:5746:3: lv_op_1_1= '-'
            	            {
            	            lv_op_1_1=(Token)match(input,70,FOLLOW_83); 

            	                    newLeafNode(lv_op_1_1, grammarAccess.getPredExpr2Access().getOpHyphenMinusKeyword_1_0_0_0());
            	                

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getPredExpr2Rule());
            	            	        }
            	                   		addWithLastConsumed(current, "op", lv_op_1_1, null);
            	            	    

            	            }
            	            break;
            	        case 2 :
            	            // InternalForml.g:5758:8: lv_op_1_2= '+'
            	            {
            	            lv_op_1_2=(Token)match(input,69,FOLLOW_83); 

            	                    newLeafNode(lv_op_1_2, grammarAccess.getPredExpr2Access().getOpPlusSignKeyword_1_0_0_1());
            	                

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getPredExpr2Rule());
            	            	        }
            	                   		addWithLastConsumed(current, "op", lv_op_1_2, null);
            	            	    

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // InternalForml.g:5773:2: ( (lv_expr_2_0= rulepredExpr3 ) )
            	    // InternalForml.g:5774:1: (lv_expr_2_0= rulepredExpr3 )
            	    {
            	    // InternalForml.g:5774:1: (lv_expr_2_0= rulepredExpr3 )
            	    // InternalForml.g:5775:3: lv_expr_2_0= rulepredExpr3
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPredExpr2Access().getExprPredExpr3ParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_84);
            	    lv_expr_2_0=rulepredExpr3();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getPredExpr2Rule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"expr",
            	            		lv_expr_2_0, 
            	            		"uw.cs.watform.forml.Forml.predExpr3");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop113;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulepredExpr2"


    // $ANTLR start "entryRulepredExpr3"
    // InternalForml.g:5799:1: entryRulepredExpr3 returns [EObject current=null] : iv_rulepredExpr3= rulepredExpr3 EOF ;
    public final EObject entryRulepredExpr3() throws RecognitionException {
        EObject current = null;

        EObject iv_rulepredExpr3 = null;


        try {
            // InternalForml.g:5800:2: (iv_rulepredExpr3= rulepredExpr3 EOF )
            // InternalForml.g:5801:2: iv_rulepredExpr3= rulepredExpr3 EOF
            {
             newCompositeNode(grammarAccess.getPredExpr3Rule()); 
            pushFollow(FOLLOW_1);
            iv_rulepredExpr3=rulepredExpr3();

            state._fsp--;

             current =iv_rulepredExpr3; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulepredExpr3"


    // $ANTLR start "rulepredExpr3"
    // InternalForml.g:5808:1: rulepredExpr3 returns [EObject current=null] : ( (lv_base_0_0= rulesetExprBase ) ) ;
    public final EObject rulepredExpr3() throws RecognitionException {
        EObject current = null;

        EObject lv_base_0_0 = null;


         enterRule(); 
            
        try {
            // InternalForml.g:5811:28: ( ( (lv_base_0_0= rulesetExprBase ) ) )
            // InternalForml.g:5812:1: ( (lv_base_0_0= rulesetExprBase ) )
            {
            // InternalForml.g:5812:1: ( (lv_base_0_0= rulesetExprBase ) )
            // InternalForml.g:5813:1: (lv_base_0_0= rulesetExprBase )
            {
            // InternalForml.g:5813:1: (lv_base_0_0= rulesetExprBase )
            // InternalForml.g:5814:3: lv_base_0_0= rulesetExprBase
            {
             
            	        newCompositeNode(grammarAccess.getPredExpr3Access().getBaseSetExprBaseParserRuleCall_0()); 
            	    
            pushFollow(FOLLOW_2);
            lv_base_0_0=rulesetExprBase();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getPredExpr3Rule());
            	        }
                   		set(
                   			current, 
                   			"base",
                    		lv_base_0_0, 
                    		"uw.cs.watform.forml.Forml.setExprBase");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulepredExpr3"


    // $ANTLR start "entryRulesetExpr"
    // InternalForml.g:5838:1: entryRulesetExpr returns [EObject current=null] : iv_rulesetExpr= rulesetExpr EOF ;
    public final EObject entryRulesetExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_rulesetExpr = null;


        try {
            // InternalForml.g:5839:2: (iv_rulesetExpr= rulesetExpr EOF )
            // InternalForml.g:5840:2: iv_rulesetExpr= rulesetExpr EOF
            {
             newCompositeNode(grammarAccess.getSetExprRule()); 
            pushFollow(FOLLOW_1);
            iv_rulesetExpr=rulesetExpr();

            state._fsp--;

             current =iv_rulesetExpr; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulesetExpr"


    // $ANTLR start "rulesetExpr"
    // InternalForml.g:5847:1: rulesetExpr returns [EObject current=null] : ( ( (lv_expr_0_0= rulesetExpr2 ) ) (otherlv_1= '&' ( (lv_expr_2_0= rulesetExpr2 ) ) )* ) ;
    public final EObject rulesetExpr() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_expr_0_0 = null;

        EObject lv_expr_2_0 = null;


         enterRule(); 
            
        try {
            // InternalForml.g:5850:28: ( ( ( (lv_expr_0_0= rulesetExpr2 ) ) (otherlv_1= '&' ( (lv_expr_2_0= rulesetExpr2 ) ) )* ) )
            // InternalForml.g:5851:1: ( ( (lv_expr_0_0= rulesetExpr2 ) ) (otherlv_1= '&' ( (lv_expr_2_0= rulesetExpr2 ) ) )* )
            {
            // InternalForml.g:5851:1: ( ( (lv_expr_0_0= rulesetExpr2 ) ) (otherlv_1= '&' ( (lv_expr_2_0= rulesetExpr2 ) ) )* )
            // InternalForml.g:5851:2: ( (lv_expr_0_0= rulesetExpr2 ) ) (otherlv_1= '&' ( (lv_expr_2_0= rulesetExpr2 ) ) )*
            {
            // InternalForml.g:5851:2: ( (lv_expr_0_0= rulesetExpr2 ) )
            // InternalForml.g:5852:1: (lv_expr_0_0= rulesetExpr2 )
            {
            // InternalForml.g:5852:1: (lv_expr_0_0= rulesetExpr2 )
            // InternalForml.g:5853:3: lv_expr_0_0= rulesetExpr2
            {
             
            	        newCompositeNode(grammarAccess.getSetExprAccess().getExprSetExpr2ParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_82);
            lv_expr_0_0=rulesetExpr2();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSetExprRule());
            	        }
                   		add(
                   			current, 
                   			"expr",
                    		lv_expr_0_0, 
                    		"uw.cs.watform.forml.Forml.setExpr2");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalForml.g:5869:2: (otherlv_1= '&' ( (lv_expr_2_0= rulesetExpr2 ) ) )*
            loop114:
            do {
                int alt114=2;
                int LA114_0 = input.LA(1);

                if ( (LA114_0==95) ) {
                    alt114=1;
                }


                switch (alt114) {
            	case 1 :
            	    // InternalForml.g:5869:4: otherlv_1= '&' ( (lv_expr_2_0= rulesetExpr2 ) )
            	    {
            	    otherlv_1=(Token)match(input,95,FOLLOW_67); 

            	        	newLeafNode(otherlv_1, grammarAccess.getSetExprAccess().getAmpersandKeyword_1_0());
            	        
            	    // InternalForml.g:5873:1: ( (lv_expr_2_0= rulesetExpr2 ) )
            	    // InternalForml.g:5874:1: (lv_expr_2_0= rulesetExpr2 )
            	    {
            	    // InternalForml.g:5874:1: (lv_expr_2_0= rulesetExpr2 )
            	    // InternalForml.g:5875:3: lv_expr_2_0= rulesetExpr2
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSetExprAccess().getExprSetExpr2ParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_82);
            	    lv_expr_2_0=rulesetExpr2();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSetExprRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"expr",
            	            		lv_expr_2_0, 
            	            		"uw.cs.watform.forml.Forml.setExpr2");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop114;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulesetExpr"


    // $ANTLR start "entryRulesetExpr2"
    // InternalForml.g:5899:1: entryRulesetExpr2 returns [EObject current=null] : iv_rulesetExpr2= rulesetExpr2 EOF ;
    public final EObject entryRulesetExpr2() throws RecognitionException {
        EObject current = null;

        EObject iv_rulesetExpr2 = null;


        try {
            // InternalForml.g:5900:2: (iv_rulesetExpr2= rulesetExpr2 EOF )
            // InternalForml.g:5901:2: iv_rulesetExpr2= rulesetExpr2 EOF
            {
             newCompositeNode(grammarAccess.getSetExpr2Rule()); 
            pushFollow(FOLLOW_1);
            iv_rulesetExpr2=rulesetExpr2();

            state._fsp--;

             current =iv_rulesetExpr2; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulesetExpr2"


    // $ANTLR start "rulesetExpr2"
    // InternalForml.g:5908:1: rulesetExpr2 returns [EObject current=null] : ( ( (lv_expr_0_0= rulesetExpr3 ) ) ( ( ( (lv_op_1_1= '-' | lv_op_1_2= '+' ) ) ) ( (lv_expr_2_0= rulesetExpr3 ) ) )* ) ;
    public final EObject rulesetExpr2() throws RecognitionException {
        EObject current = null;

        Token lv_op_1_1=null;
        Token lv_op_1_2=null;
        EObject lv_expr_0_0 = null;

        EObject lv_expr_2_0 = null;


         enterRule(); 
            
        try {
            // InternalForml.g:5911:28: ( ( ( (lv_expr_0_0= rulesetExpr3 ) ) ( ( ( (lv_op_1_1= '-' | lv_op_1_2= '+' ) ) ) ( (lv_expr_2_0= rulesetExpr3 ) ) )* ) )
            // InternalForml.g:5912:1: ( ( (lv_expr_0_0= rulesetExpr3 ) ) ( ( ( (lv_op_1_1= '-' | lv_op_1_2= '+' ) ) ) ( (lv_expr_2_0= rulesetExpr3 ) ) )* )
            {
            // InternalForml.g:5912:1: ( ( (lv_expr_0_0= rulesetExpr3 ) ) ( ( ( (lv_op_1_1= '-' | lv_op_1_2= '+' ) ) ) ( (lv_expr_2_0= rulesetExpr3 ) ) )* )
            // InternalForml.g:5912:2: ( (lv_expr_0_0= rulesetExpr3 ) ) ( ( ( (lv_op_1_1= '-' | lv_op_1_2= '+' ) ) ) ( (lv_expr_2_0= rulesetExpr3 ) ) )*
            {
            // InternalForml.g:5912:2: ( (lv_expr_0_0= rulesetExpr3 ) )
            // InternalForml.g:5913:1: (lv_expr_0_0= rulesetExpr3 )
            {
            // InternalForml.g:5913:1: (lv_expr_0_0= rulesetExpr3 )
            // InternalForml.g:5914:3: lv_expr_0_0= rulesetExpr3
            {
             
            	        newCompositeNode(grammarAccess.getSetExpr2Access().getExprSetExpr3ParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_84);
            lv_expr_0_0=rulesetExpr3();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSetExpr2Rule());
            	        }
                   		add(
                   			current, 
                   			"expr",
                    		lv_expr_0_0, 
                    		"uw.cs.watform.forml.Forml.setExpr3");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalForml.g:5930:2: ( ( ( (lv_op_1_1= '-' | lv_op_1_2= '+' ) ) ) ( (lv_expr_2_0= rulesetExpr3 ) ) )*
            loop116:
            do {
                int alt116=2;
                int LA116_0 = input.LA(1);

                if ( ((LA116_0>=69 && LA116_0<=70)) ) {
                    alt116=1;
                }


                switch (alt116) {
            	case 1 :
            	    // InternalForml.g:5930:3: ( ( (lv_op_1_1= '-' | lv_op_1_2= '+' ) ) ) ( (lv_expr_2_0= rulesetExpr3 ) )
            	    {
            	    // InternalForml.g:5930:3: ( ( (lv_op_1_1= '-' | lv_op_1_2= '+' ) ) )
            	    // InternalForml.g:5931:1: ( (lv_op_1_1= '-' | lv_op_1_2= '+' ) )
            	    {
            	    // InternalForml.g:5931:1: ( (lv_op_1_1= '-' | lv_op_1_2= '+' ) )
            	    // InternalForml.g:5932:1: (lv_op_1_1= '-' | lv_op_1_2= '+' )
            	    {
            	    // InternalForml.g:5932:1: (lv_op_1_1= '-' | lv_op_1_2= '+' )
            	    int alt115=2;
            	    int LA115_0 = input.LA(1);

            	    if ( (LA115_0==70) ) {
            	        alt115=1;
            	    }
            	    else if ( (LA115_0==69) ) {
            	        alt115=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 115, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt115) {
            	        case 1 :
            	            // InternalForml.g:5933:3: lv_op_1_1= '-'
            	            {
            	            lv_op_1_1=(Token)match(input,70,FOLLOW_67); 

            	                    newLeafNode(lv_op_1_1, grammarAccess.getSetExpr2Access().getOpHyphenMinusKeyword_1_0_0_0());
            	                

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getSetExpr2Rule());
            	            	        }
            	                   		addWithLastConsumed(current, "op", lv_op_1_1, null);
            	            	    

            	            }
            	            break;
            	        case 2 :
            	            // InternalForml.g:5945:8: lv_op_1_2= '+'
            	            {
            	            lv_op_1_2=(Token)match(input,69,FOLLOW_67); 

            	                    newLeafNode(lv_op_1_2, grammarAccess.getSetExpr2Access().getOpPlusSignKeyword_1_0_0_1());
            	                

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getSetExpr2Rule());
            	            	        }
            	                   		addWithLastConsumed(current, "op", lv_op_1_2, null);
            	            	    

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // InternalForml.g:5960:2: ( (lv_expr_2_0= rulesetExpr3 ) )
            	    // InternalForml.g:5961:1: (lv_expr_2_0= rulesetExpr3 )
            	    {
            	    // InternalForml.g:5961:1: (lv_expr_2_0= rulesetExpr3 )
            	    // InternalForml.g:5962:3: lv_expr_2_0= rulesetExpr3
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSetExpr2Access().getExprSetExpr3ParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_84);
            	    lv_expr_2_0=rulesetExpr3();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSetExpr2Rule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"expr",
            	            		lv_expr_2_0, 
            	            		"uw.cs.watform.forml.Forml.setExpr3");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop116;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulesetExpr2"


    // $ANTLR start "entryRulesetExpr3"
    // InternalForml.g:5986:1: entryRulesetExpr3 returns [EObject current=null] : iv_rulesetExpr3= rulesetExpr3 EOF ;
    public final EObject entryRulesetExpr3() throws RecognitionException {
        EObject current = null;

        EObject iv_rulesetExpr3 = null;


        try {
            // InternalForml.g:5987:2: (iv_rulesetExpr3= rulesetExpr3 EOF )
            // InternalForml.g:5988:2: iv_rulesetExpr3= rulesetExpr3 EOF
            {
             newCompositeNode(grammarAccess.getSetExpr3Rule()); 
            pushFollow(FOLLOW_1);
            iv_rulesetExpr3=rulesetExpr3();

            state._fsp--;

             current =iv_rulesetExpr3; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulesetExpr3"


    // $ANTLR start "rulesetExpr3"
    // InternalForml.g:5995:1: rulesetExpr3 returns [EObject current=null] : ( (otherlv_0= '(' ( (lv_paren_1_0= rulesetExprBase ) ) otherlv_2= ')' ) | ( (lv_base_3_0= rulesetExprBase ) ) ) ;
    public final EObject rulesetExpr3() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_paren_1_0 = null;

        EObject lv_base_3_0 = null;


         enterRule(); 
            
        try {
            // InternalForml.g:5998:28: ( ( (otherlv_0= '(' ( (lv_paren_1_0= rulesetExprBase ) ) otherlv_2= ')' ) | ( (lv_base_3_0= rulesetExprBase ) ) ) )
            // InternalForml.g:5999:1: ( (otherlv_0= '(' ( (lv_paren_1_0= rulesetExprBase ) ) otherlv_2= ')' ) | ( (lv_base_3_0= rulesetExprBase ) ) )
            {
            // InternalForml.g:5999:1: ( (otherlv_0= '(' ( (lv_paren_1_0= rulesetExprBase ) ) otherlv_2= ')' ) | ( (lv_base_3_0= rulesetExprBase ) ) )
            int alt117=2;
            int LA117_0 = input.LA(1);

            if ( (LA117_0==67) ) {
                alt117=1;
            }
            else if ( (LA117_0==RULE_ID||LA117_0==97) ) {
                alt117=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 117, 0, input);

                throw nvae;
            }
            switch (alt117) {
                case 1 :
                    // InternalForml.g:5999:2: (otherlv_0= '(' ( (lv_paren_1_0= rulesetExprBase ) ) otherlv_2= ')' )
                    {
                    // InternalForml.g:5999:2: (otherlv_0= '(' ( (lv_paren_1_0= rulesetExprBase ) ) otherlv_2= ')' )
                    // InternalForml.g:5999:4: otherlv_0= '(' ( (lv_paren_1_0= rulesetExprBase ) ) otherlv_2= ')'
                    {
                    otherlv_0=(Token)match(input,67,FOLLOW_83); 

                        	newLeafNode(otherlv_0, grammarAccess.getSetExpr3Access().getLeftParenthesisKeyword_0_0());
                        
                    // InternalForml.g:6003:1: ( (lv_paren_1_0= rulesetExprBase ) )
                    // InternalForml.g:6004:1: (lv_paren_1_0= rulesetExprBase )
                    {
                    // InternalForml.g:6004:1: (lv_paren_1_0= rulesetExprBase )
                    // InternalForml.g:6005:3: lv_paren_1_0= rulesetExprBase
                    {
                     
                    	        newCompositeNode(grammarAccess.getSetExpr3Access().getParenSetExprBaseParserRuleCall_0_1_0()); 
                    	    
                    pushFollow(FOLLOW_63);
                    lv_paren_1_0=rulesetExprBase();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSetExpr3Rule());
                    	        }
                           		set(
                           			current, 
                           			"paren",
                            		lv_paren_1_0, 
                            		"uw.cs.watform.forml.Forml.setExprBase");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_2=(Token)match(input,68,FOLLOW_2); 

                        	newLeafNode(otherlv_2, grammarAccess.getSetExpr3Access().getRightParenthesisKeyword_0_2());
                        

                    }


                    }
                    break;
                case 2 :
                    // InternalForml.g:6026:6: ( (lv_base_3_0= rulesetExprBase ) )
                    {
                    // InternalForml.g:6026:6: ( (lv_base_3_0= rulesetExprBase ) )
                    // InternalForml.g:6027:1: (lv_base_3_0= rulesetExprBase )
                    {
                    // InternalForml.g:6027:1: (lv_base_3_0= rulesetExprBase )
                    // InternalForml.g:6028:3: lv_base_3_0= rulesetExprBase
                    {
                     
                    	        newCompositeNode(grammarAccess.getSetExpr3Access().getBaseSetExprBaseParserRuleCall_1_0()); 
                    	    
                    pushFollow(FOLLOW_2);
                    lv_base_3_0=rulesetExprBase();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSetExpr3Rule());
                    	        }
                           		set(
                           			current, 
                           			"base",
                            		lv_base_3_0, 
                            		"uw.cs.watform.forml.Forml.setExprBase");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulesetExpr3"


    // $ANTLR start "entryRulesetExprBase"
    // InternalForml.g:6052:1: entryRulesetExprBase returns [EObject current=null] : iv_rulesetExprBase= rulesetExprBase EOF ;
    public final EObject entryRulesetExprBase() throws RecognitionException {
        EObject current = null;

        EObject iv_rulesetExprBase = null;


        try {
            // InternalForml.g:6053:2: (iv_rulesetExprBase= rulesetExprBase EOF )
            // InternalForml.g:6054:2: iv_rulesetExprBase= rulesetExprBase EOF
            {
             newCompositeNode(grammarAccess.getSetExprBaseRule()); 
            pushFollow(FOLLOW_1);
            iv_rulesetExprBase=rulesetExprBase();

            state._fsp--;

             current =iv_rulesetExprBase; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulesetExprBase"


    // $ANTLR start "rulesetExprBase"
    // InternalForml.g:6061:1: rulesetExprBase returns [EObject current=null] : ( ( (lv_atom_0_0= ruleatomic ) ) | ( (lv_unspec_1_0= ruleunspecified ) ) ) ;
    public final EObject rulesetExprBase() throws RecognitionException {
        EObject current = null;

        EObject lv_atom_0_0 = null;

        EObject lv_unspec_1_0 = null;


         enterRule(); 
            
        try {
            // InternalForml.g:6064:28: ( ( ( (lv_atom_0_0= ruleatomic ) ) | ( (lv_unspec_1_0= ruleunspecified ) ) ) )
            // InternalForml.g:6065:1: ( ( (lv_atom_0_0= ruleatomic ) ) | ( (lv_unspec_1_0= ruleunspecified ) ) )
            {
            // InternalForml.g:6065:1: ( ( (lv_atom_0_0= ruleatomic ) ) | ( (lv_unspec_1_0= ruleunspecified ) ) )
            int alt118=2;
            int LA118_0 = input.LA(1);

            if ( (LA118_0==97) ) {
                alt118=1;
            }
            else if ( (LA118_0==RULE_ID) ) {
                int LA118_2 = input.LA(2);

                if ( (LA118_2==EOF||(LA118_2>=RULE_ID && LA118_2<=RULE_INT)||LA118_2==13||LA118_2==22||LA118_2==45||LA118_2==58||(LA118_2>=67 && LA118_2<=70)||(LA118_2>=73 && LA118_2<=86)||(LA118_2>=95 && LA118_2<=99)||LA118_2==106) ) {
                    alt118=1;
                }
                else if ( (LA118_2==100) ) {
                    alt118=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 118, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 118, 0, input);

                throw nvae;
            }
            switch (alt118) {
                case 1 :
                    // InternalForml.g:6065:2: ( (lv_atom_0_0= ruleatomic ) )
                    {
                    // InternalForml.g:6065:2: ( (lv_atom_0_0= ruleatomic ) )
                    // InternalForml.g:6066:1: (lv_atom_0_0= ruleatomic )
                    {
                    // InternalForml.g:6066:1: (lv_atom_0_0= ruleatomic )
                    // InternalForml.g:6067:3: lv_atom_0_0= ruleatomic
                    {
                     
                    	        newCompositeNode(grammarAccess.getSetExprBaseAccess().getAtomAtomicParserRuleCall_0_0()); 
                    	    
                    pushFollow(FOLLOW_2);
                    lv_atom_0_0=ruleatomic();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSetExprBaseRule());
                    	        }
                           		set(
                           			current, 
                           			"atom",
                            		lv_atom_0_0, 
                            		"uw.cs.watform.forml.Forml.atomic");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalForml.g:6084:6: ( (lv_unspec_1_0= ruleunspecified ) )
                    {
                    // InternalForml.g:6084:6: ( (lv_unspec_1_0= ruleunspecified ) )
                    // InternalForml.g:6085:1: (lv_unspec_1_0= ruleunspecified )
                    {
                    // InternalForml.g:6085:1: (lv_unspec_1_0= ruleunspecified )
                    // InternalForml.g:6086:3: lv_unspec_1_0= ruleunspecified
                    {
                     
                    	        newCompositeNode(grammarAccess.getSetExprBaseAccess().getUnspecUnspecifiedParserRuleCall_1_0()); 
                    	    
                    pushFollow(FOLLOW_2);
                    lv_unspec_1_0=ruleunspecified();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSetExprBaseRule());
                    	        }
                           		set(
                           			current, 
                           			"unspec",
                            		lv_unspec_1_0, 
                            		"uw.cs.watform.forml.Forml.unspecified");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulesetExprBase"


    // $ANTLR start "entryRuleintExpr"
    // InternalForml.g:6110:1: entryRuleintExpr returns [EObject current=null] : iv_ruleintExpr= ruleintExpr EOF ;
    public final EObject entryRuleintExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleintExpr = null;


        try {
            // InternalForml.g:6111:2: (iv_ruleintExpr= ruleintExpr EOF )
            // InternalForml.g:6112:2: iv_ruleintExpr= ruleintExpr EOF
            {
             newCompositeNode(grammarAccess.getIntExprRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleintExpr=ruleintExpr();

            state._fsp--;

             current =iv_ruleintExpr; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleintExpr"


    // $ANTLR start "ruleintExpr"
    // InternalForml.g:6119:1: ruleintExpr returns [EObject current=null] : ( ( (lv_lhs_0_0= rulemultExpr ) ) ( ( ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) ) ) ( (lv_rhs_2_0= rulemultExpr ) ) )* ) ;
    public final EObject ruleintExpr() throws RecognitionException {
        EObject current = null;

        Token lv_op_1_1=null;
        Token lv_op_1_2=null;
        EObject lv_lhs_0_0 = null;

        EObject lv_rhs_2_0 = null;


         enterRule(); 
            
        try {
            // InternalForml.g:6122:28: ( ( ( (lv_lhs_0_0= rulemultExpr ) ) ( ( ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) ) ) ( (lv_rhs_2_0= rulemultExpr ) ) )* ) )
            // InternalForml.g:6123:1: ( ( (lv_lhs_0_0= rulemultExpr ) ) ( ( ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) ) ) ( (lv_rhs_2_0= rulemultExpr ) ) )* )
            {
            // InternalForml.g:6123:1: ( ( (lv_lhs_0_0= rulemultExpr ) ) ( ( ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) ) ) ( (lv_rhs_2_0= rulemultExpr ) ) )* )
            // InternalForml.g:6123:2: ( (lv_lhs_0_0= rulemultExpr ) ) ( ( ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) ) ) ( (lv_rhs_2_0= rulemultExpr ) ) )*
            {
            // InternalForml.g:6123:2: ( (lv_lhs_0_0= rulemultExpr ) )
            // InternalForml.g:6124:1: (lv_lhs_0_0= rulemultExpr )
            {
            // InternalForml.g:6124:1: (lv_lhs_0_0= rulemultExpr )
            // InternalForml.g:6125:3: lv_lhs_0_0= rulemultExpr
            {
             
            	        newCompositeNode(grammarAccess.getIntExprAccess().getLhsMultExprParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_84);
            lv_lhs_0_0=rulemultExpr();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getIntExprRule());
            	        }
                   		set(
                   			current, 
                   			"lhs",
                    		lv_lhs_0_0, 
                    		"uw.cs.watform.forml.Forml.multExpr");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalForml.g:6141:2: ( ( ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) ) ) ( (lv_rhs_2_0= rulemultExpr ) ) )*
            loop120:
            do {
                int alt120=2;
                int LA120_0 = input.LA(1);

                if ( ((LA120_0>=69 && LA120_0<=70)) ) {
                    alt120=1;
                }


                switch (alt120) {
            	case 1 :
            	    // InternalForml.g:6141:3: ( ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) ) ) ( (lv_rhs_2_0= rulemultExpr ) )
            	    {
            	    // InternalForml.g:6141:3: ( ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) ) )
            	    // InternalForml.g:6142:1: ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) )
            	    {
            	    // InternalForml.g:6142:1: ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) )
            	    // InternalForml.g:6143:1: (lv_op_1_1= '+' | lv_op_1_2= '-' )
            	    {
            	    // InternalForml.g:6143:1: (lv_op_1_1= '+' | lv_op_1_2= '-' )
            	    int alt119=2;
            	    int LA119_0 = input.LA(1);

            	    if ( (LA119_0==69) ) {
            	        alt119=1;
            	    }
            	    else if ( (LA119_0==70) ) {
            	        alt119=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 119, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt119) {
            	        case 1 :
            	            // InternalForml.g:6144:3: lv_op_1_1= '+'
            	            {
            	            lv_op_1_1=(Token)match(input,69,FOLLOW_70); 

            	                    newLeafNode(lv_op_1_1, grammarAccess.getIntExprAccess().getOpPlusSignKeyword_1_0_0_0());
            	                

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getIntExprRule());
            	            	        }
            	                   		addWithLastConsumed(current, "op", lv_op_1_1, null);
            	            	    

            	            }
            	            break;
            	        case 2 :
            	            // InternalForml.g:6156:8: lv_op_1_2= '-'
            	            {
            	            lv_op_1_2=(Token)match(input,70,FOLLOW_70); 

            	                    newLeafNode(lv_op_1_2, grammarAccess.getIntExprAccess().getOpHyphenMinusKeyword_1_0_0_1());
            	                

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getIntExprRule());
            	            	        }
            	                   		addWithLastConsumed(current, "op", lv_op_1_2, null);
            	            	    

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // InternalForml.g:6171:2: ( (lv_rhs_2_0= rulemultExpr ) )
            	    // InternalForml.g:6172:1: (lv_rhs_2_0= rulemultExpr )
            	    {
            	    // InternalForml.g:6172:1: (lv_rhs_2_0= rulemultExpr )
            	    // InternalForml.g:6173:3: lv_rhs_2_0= rulemultExpr
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getIntExprAccess().getRhsMultExprParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_84);
            	    lv_rhs_2_0=rulemultExpr();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getIntExprRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"rhs",
            	            		lv_rhs_2_0, 
            	            		"uw.cs.watform.forml.Forml.multExpr");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop120;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleintExpr"


    // $ANTLR start "entryRulemultExpr"
    // InternalForml.g:6197:1: entryRulemultExpr returns [EObject current=null] : iv_rulemultExpr= rulemultExpr EOF ;
    public final EObject entryRulemultExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_rulemultExpr = null;


        try {
            // InternalForml.g:6198:2: (iv_rulemultExpr= rulemultExpr EOF )
            // InternalForml.g:6199:2: iv_rulemultExpr= rulemultExpr EOF
            {
             newCompositeNode(grammarAccess.getMultExprRule()); 
            pushFollow(FOLLOW_1);
            iv_rulemultExpr=rulemultExpr();

            state._fsp--;

             current =iv_rulemultExpr; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulemultExpr"


    // $ANTLR start "rulemultExpr"
    // InternalForml.g:6206:1: rulemultExpr returns [EObject current=null] : ( ( (lv_lhs_0_0= ruleintBase ) ) ( ( ( (lv_op_1_1= '*' | lv_op_1_2= '/' ) ) ) ( (lv_rhs_2_0= ruleintBase ) ) )* ) ;
    public final EObject rulemultExpr() throws RecognitionException {
        EObject current = null;

        Token lv_op_1_1=null;
        Token lv_op_1_2=null;
        EObject lv_lhs_0_0 = null;

        EObject lv_rhs_2_0 = null;


         enterRule(); 
            
        try {
            // InternalForml.g:6209:28: ( ( ( (lv_lhs_0_0= ruleintBase ) ) ( ( ( (lv_op_1_1= '*' | lv_op_1_2= '/' ) ) ) ( (lv_rhs_2_0= ruleintBase ) ) )* ) )
            // InternalForml.g:6210:1: ( ( (lv_lhs_0_0= ruleintBase ) ) ( ( ( (lv_op_1_1= '*' | lv_op_1_2= '/' ) ) ) ( (lv_rhs_2_0= ruleintBase ) ) )* )
            {
            // InternalForml.g:6210:1: ( ( (lv_lhs_0_0= ruleintBase ) ) ( ( ( (lv_op_1_1= '*' | lv_op_1_2= '/' ) ) ) ( (lv_rhs_2_0= ruleintBase ) ) )* )
            // InternalForml.g:6210:2: ( (lv_lhs_0_0= ruleintBase ) ) ( ( ( (lv_op_1_1= '*' | lv_op_1_2= '/' ) ) ) ( (lv_rhs_2_0= ruleintBase ) ) )*
            {
            // InternalForml.g:6210:2: ( (lv_lhs_0_0= ruleintBase ) )
            // InternalForml.g:6211:1: (lv_lhs_0_0= ruleintBase )
            {
            // InternalForml.g:6211:1: (lv_lhs_0_0= ruleintBase )
            // InternalForml.g:6212:3: lv_lhs_0_0= ruleintBase
            {
             
            	        newCompositeNode(grammarAccess.getMultExprAccess().getLhsIntBaseParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_85);
            lv_lhs_0_0=ruleintBase();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getMultExprRule());
            	        }
                   		set(
                   			current, 
                   			"lhs",
                    		lv_lhs_0_0, 
                    		"uw.cs.watform.forml.Forml.intBase");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalForml.g:6228:2: ( ( ( (lv_op_1_1= '*' | lv_op_1_2= '/' ) ) ) ( (lv_rhs_2_0= ruleintBase ) ) )*
            loop122:
            do {
                int alt122=2;
                int LA122_0 = input.LA(1);

                if ( (LA122_0==32||LA122_0==71) ) {
                    alt122=1;
                }


                switch (alt122) {
            	case 1 :
            	    // InternalForml.g:6228:3: ( ( (lv_op_1_1= '*' | lv_op_1_2= '/' ) ) ) ( (lv_rhs_2_0= ruleintBase ) )
            	    {
            	    // InternalForml.g:6228:3: ( ( (lv_op_1_1= '*' | lv_op_1_2= '/' ) ) )
            	    // InternalForml.g:6229:1: ( (lv_op_1_1= '*' | lv_op_1_2= '/' ) )
            	    {
            	    // InternalForml.g:6229:1: ( (lv_op_1_1= '*' | lv_op_1_2= '/' ) )
            	    // InternalForml.g:6230:1: (lv_op_1_1= '*' | lv_op_1_2= '/' )
            	    {
            	    // InternalForml.g:6230:1: (lv_op_1_1= '*' | lv_op_1_2= '/' )
            	    int alt121=2;
            	    int LA121_0 = input.LA(1);

            	    if ( (LA121_0==32) ) {
            	        alt121=1;
            	    }
            	    else if ( (LA121_0==71) ) {
            	        alt121=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 121, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt121) {
            	        case 1 :
            	            // InternalForml.g:6231:3: lv_op_1_1= '*'
            	            {
            	            lv_op_1_1=(Token)match(input,32,FOLLOW_70); 

            	                    newLeafNode(lv_op_1_1, grammarAccess.getMultExprAccess().getOpAsteriskKeyword_1_0_0_0());
            	                

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getMultExprRule());
            	            	        }
            	                   		addWithLastConsumed(current, "op", lv_op_1_1, null);
            	            	    

            	            }
            	            break;
            	        case 2 :
            	            // InternalForml.g:6243:8: lv_op_1_2= '/'
            	            {
            	            lv_op_1_2=(Token)match(input,71,FOLLOW_70); 

            	                    newLeafNode(lv_op_1_2, grammarAccess.getMultExprAccess().getOpSolidusKeyword_1_0_0_1());
            	                

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getMultExprRule());
            	            	        }
            	                   		addWithLastConsumed(current, "op", lv_op_1_2, null);
            	            	    

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // InternalForml.g:6258:2: ( (lv_rhs_2_0= ruleintBase ) )
            	    // InternalForml.g:6259:1: (lv_rhs_2_0= ruleintBase )
            	    {
            	    // InternalForml.g:6259:1: (lv_rhs_2_0= ruleintBase )
            	    // InternalForml.g:6260:3: lv_rhs_2_0= ruleintBase
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getMultExprAccess().getRhsIntBaseParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_85);
            	    lv_rhs_2_0=ruleintBase();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getMultExprRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"rhs",
            	            		lv_rhs_2_0, 
            	            		"uw.cs.watform.forml.Forml.intBase");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop122;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulemultExpr"


    // $ANTLR start "entryRuleintBase"
    // InternalForml.g:6284:1: entryRuleintBase returns [EObject current=null] : iv_ruleintBase= ruleintBase EOF ;
    public final EObject entryRuleintBase() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleintBase = null;


        try {
            // InternalForml.g:6285:2: (iv_ruleintBase= ruleintBase EOF )
            // InternalForml.g:6286:2: iv_ruleintBase= ruleintBase EOF
            {
             newCompositeNode(grammarAccess.getIntBaseRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleintBase=ruleintBase();

            state._fsp--;

             current =iv_ruleintBase; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleintBase"


    // $ANTLR start "ruleintBase"
    // InternalForml.g:6293:1: ruleintBase returns [EObject current=null] : ( (otherlv_0= '#' ( (lv_atom_1_0= ruleatomic ) ) ) | ( (lv_num_2_0= RULE_INT ) ) ) ;
    public final EObject ruleintBase() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_num_2_0=null;
        EObject lv_atom_1_0 = null;


         enterRule(); 
            
        try {
            // InternalForml.g:6296:28: ( ( (otherlv_0= '#' ( (lv_atom_1_0= ruleatomic ) ) ) | ( (lv_num_2_0= RULE_INT ) ) ) )
            // InternalForml.g:6297:1: ( (otherlv_0= '#' ( (lv_atom_1_0= ruleatomic ) ) ) | ( (lv_num_2_0= RULE_INT ) ) )
            {
            // InternalForml.g:6297:1: ( (otherlv_0= '#' ( (lv_atom_1_0= ruleatomic ) ) ) | ( (lv_num_2_0= RULE_INT ) ) )
            int alt123=2;
            int LA123_0 = input.LA(1);

            if ( (LA123_0==96) ) {
                alt123=1;
            }
            else if ( (LA123_0==RULE_INT) ) {
                alt123=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 123, 0, input);

                throw nvae;
            }
            switch (alt123) {
                case 1 :
                    // InternalForml.g:6297:2: (otherlv_0= '#' ( (lv_atom_1_0= ruleatomic ) ) )
                    {
                    // InternalForml.g:6297:2: (otherlv_0= '#' ( (lv_atom_1_0= ruleatomic ) ) )
                    // InternalForml.g:6297:4: otherlv_0= '#' ( (lv_atom_1_0= ruleatomic ) )
                    {
                    otherlv_0=(Token)match(input,96,FOLLOW_83); 

                        	newLeafNode(otherlv_0, grammarAccess.getIntBaseAccess().getNumberSignKeyword_0_0());
                        
                    // InternalForml.g:6301:1: ( (lv_atom_1_0= ruleatomic ) )
                    // InternalForml.g:6302:1: (lv_atom_1_0= ruleatomic )
                    {
                    // InternalForml.g:6302:1: (lv_atom_1_0= ruleatomic )
                    // InternalForml.g:6303:3: lv_atom_1_0= ruleatomic
                    {
                     
                    	        newCompositeNode(grammarAccess.getIntBaseAccess().getAtomAtomicParserRuleCall_0_1_0()); 
                    	    
                    pushFollow(FOLLOW_2);
                    lv_atom_1_0=ruleatomic();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getIntBaseRule());
                    	        }
                           		set(
                           			current, 
                           			"atom",
                            		lv_atom_1_0, 
                            		"uw.cs.watform.forml.Forml.atomic");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalForml.g:6320:6: ( (lv_num_2_0= RULE_INT ) )
                    {
                    // InternalForml.g:6320:6: ( (lv_num_2_0= RULE_INT ) )
                    // InternalForml.g:6321:1: (lv_num_2_0= RULE_INT )
                    {
                    // InternalForml.g:6321:1: (lv_num_2_0= RULE_INT )
                    // InternalForml.g:6322:3: lv_num_2_0= RULE_INT
                    {
                    lv_num_2_0=(Token)match(input,RULE_INT,FOLLOW_2); 

                    			newLeafNode(lv_num_2_0, grammarAccess.getIntBaseAccess().getNumINTTerminalRuleCall_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntBaseRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"num",
                            		lv_num_2_0, 
                            		"org.eclipse.xtext.common.Terminals.INT");
                    	    

                    }


                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleintBase"


    // $ANTLR start "entryRuleatomic"
    // InternalForml.g:6346:1: entryRuleatomic returns [EObject current=null] : iv_ruleatomic= ruleatomic EOF ;
    public final EObject entryRuleatomic() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleatomic = null;


        try {
            // InternalForml.g:6347:2: (iv_ruleatomic= ruleatomic EOF )
            // InternalForml.g:6348:2: iv_ruleatomic= ruleatomic EOF
            {
             newCompositeNode(grammarAccess.getAtomicRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleatomic=ruleatomic();

            state._fsp--;

             current =iv_ruleatomic; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleatomic"


    // $ANTLR start "ruleatomic"
    // InternalForml.g:6355:1: ruleatomic returns [EObject current=null] : ( ( (lv_none_0_0= 'none' ) ) | ( ( ( ruleQualifiedName ) ) (otherlv_2= '@pre' )? ) | ( ( ( ruleQualifiedName ) ) otherlv_4= 's' (otherlv_5= '@pre' )? ) ) ;
    public final EObject ruleatomic() throws RecognitionException {
        EObject current = null;

        Token lv_none_0_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;

         enterRule(); 
            
        try {
            // InternalForml.g:6358:28: ( ( ( (lv_none_0_0= 'none' ) ) | ( ( ( ruleQualifiedName ) ) (otherlv_2= '@pre' )? ) | ( ( ( ruleQualifiedName ) ) otherlv_4= 's' (otherlv_5= '@pre' )? ) ) )
            // InternalForml.g:6359:1: ( ( (lv_none_0_0= 'none' ) ) | ( ( ( ruleQualifiedName ) ) (otherlv_2= '@pre' )? ) | ( ( ( ruleQualifiedName ) ) otherlv_4= 's' (otherlv_5= '@pre' )? ) )
            {
            // InternalForml.g:6359:1: ( ( (lv_none_0_0= 'none' ) ) | ( ( ( ruleQualifiedName ) ) (otherlv_2= '@pre' )? ) | ( ( ( ruleQualifiedName ) ) otherlv_4= 's' (otherlv_5= '@pre' )? ) )
            int alt126=3;
            alt126 = dfa126.predict(input);
            switch (alt126) {
                case 1 :
                    // InternalForml.g:6359:2: ( (lv_none_0_0= 'none' ) )
                    {
                    // InternalForml.g:6359:2: ( (lv_none_0_0= 'none' ) )
                    // InternalForml.g:6360:1: (lv_none_0_0= 'none' )
                    {
                    // InternalForml.g:6360:1: (lv_none_0_0= 'none' )
                    // InternalForml.g:6361:3: lv_none_0_0= 'none'
                    {
                    lv_none_0_0=(Token)match(input,97,FOLLOW_2); 

                            newLeafNode(lv_none_0_0, grammarAccess.getAtomicAccess().getNoneNoneKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getAtomicRule());
                    	        }
                           		setWithLastConsumed(current, "none", lv_none_0_0, "none");
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalForml.g:6375:6: ( ( ( ruleQualifiedName ) ) (otherlv_2= '@pre' )? )
                    {
                    // InternalForml.g:6375:6: ( ( ( ruleQualifiedName ) ) (otherlv_2= '@pre' )? )
                    // InternalForml.g:6375:7: ( ( ruleQualifiedName ) ) (otherlv_2= '@pre' )?
                    {
                    // InternalForml.g:6375:7: ( ( ruleQualifiedName ) )
                    // InternalForml.g:6376:1: ( ruleQualifiedName )
                    {
                    // InternalForml.g:6376:1: ( ruleQualifiedName )
                    // InternalForml.g:6377:3: ruleQualifiedName
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getAtomicRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getAtomicAccess().getRefExprRefCrossReference_1_0_0()); 
                    	    
                    pushFollow(FOLLOW_86);
                    ruleQualifiedName();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // InternalForml.g:6390:2: (otherlv_2= '@pre' )?
                    int alt124=2;
                    int LA124_0 = input.LA(1);

                    if ( (LA124_0==98) ) {
                        alt124=1;
                    }
                    switch (alt124) {
                        case 1 :
                            // InternalForml.g:6390:4: otherlv_2= '@pre'
                            {
                            otherlv_2=(Token)match(input,98,FOLLOW_2); 

                                	newLeafNode(otherlv_2, grammarAccess.getAtomicAccess().getPreKeyword_1_1());
                                

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalForml.g:6395:6: ( ( ( ruleQualifiedName ) ) otherlv_4= 's' (otherlv_5= '@pre' )? )
                    {
                    // InternalForml.g:6395:6: ( ( ( ruleQualifiedName ) ) otherlv_4= 's' (otherlv_5= '@pre' )? )
                    // InternalForml.g:6395:7: ( ( ruleQualifiedName ) ) otherlv_4= 's' (otherlv_5= '@pre' )?
                    {
                    // InternalForml.g:6395:7: ( ( ruleQualifiedName ) )
                    // InternalForml.g:6396:1: ( ruleQualifiedName )
                    {
                    // InternalForml.g:6396:1: ( ruleQualifiedName )
                    // InternalForml.g:6397:3: ruleQualifiedName
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getAtomicRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getAtomicAccess().getRefsExprRefCrossReference_2_0_0()); 
                    	    
                    pushFollow(FOLLOW_87);
                    ruleQualifiedName();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_4=(Token)match(input,99,FOLLOW_86); 

                        	newLeafNode(otherlv_4, grammarAccess.getAtomicAccess().getSKeyword_2_1());
                        
                    // InternalForml.g:6414:1: (otherlv_5= '@pre' )?
                    int alt125=2;
                    int LA125_0 = input.LA(1);

                    if ( (LA125_0==98) ) {
                        alt125=1;
                    }
                    switch (alt125) {
                        case 1 :
                            // InternalForml.g:6414:3: otherlv_5= '@pre'
                            {
                            otherlv_5=(Token)match(input,98,FOLLOW_2); 

                                	newLeafNode(otherlv_5, grammarAccess.getAtomicAccess().getPreKeyword_2_2());
                                

                            }
                            break;

                    }


                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleatomic"


    // $ANTLR start "entryRuleunspecified"
    // InternalForml.g:6426:1: entryRuleunspecified returns [EObject current=null] : iv_ruleunspecified= ruleunspecified EOF ;
    public final EObject entryRuleunspecified() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleunspecified = null;


        try {
            // InternalForml.g:6427:2: (iv_ruleunspecified= ruleunspecified EOF )
            // InternalForml.g:6428:2: iv_ruleunspecified= ruleunspecified EOF
            {
             newCompositeNode(grammarAccess.getUnspecifiedRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleunspecified=ruleunspecified();

            state._fsp--;

             current =iv_ruleunspecified; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleunspecified"


    // $ANTLR start "ruleunspecified"
    // InternalForml.g:6435:1: ruleunspecified returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '()' (otherlv_2= '@pre' )? ) ;
    public final EObject ruleunspecified() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // InternalForml.g:6438:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '()' (otherlv_2= '@pre' )? ) )
            // InternalForml.g:6439:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '()' (otherlv_2= '@pre' )? )
            {
            // InternalForml.g:6439:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '()' (otherlv_2= '@pre' )? )
            // InternalForml.g:6439:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= '()' (otherlv_2= '@pre' )?
            {
            // InternalForml.g:6439:2: ( (otherlv_0= RULE_ID ) )
            // InternalForml.g:6440:1: (otherlv_0= RULE_ID )
            {
            // InternalForml.g:6440:1: (otherlv_0= RULE_ID )
            // InternalForml.g:6441:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getUnspecifiedRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_88); 

            		newLeafNode(otherlv_0, grammarAccess.getUnspecifiedAccess().getRefExprRefCrossReference_0_0()); 
            	

            }


            }

            otherlv_1=(Token)match(input,100,FOLLOW_86); 

                	newLeafNode(otherlv_1, grammarAccess.getUnspecifiedAccess().getLeftParenthesisRightParenthesisKeyword_1());
                
            // InternalForml.g:6456:1: (otherlv_2= '@pre' )?
            int alt127=2;
            int LA127_0 = input.LA(1);

            if ( (LA127_0==98) ) {
                alt127=1;
            }
            switch (alt127) {
                case 1 :
                    // InternalForml.g:6456:3: otherlv_2= '@pre'
                    {
                    otherlv_2=(Token)match(input,98,FOLLOW_2); 

                        	newLeafNode(otherlv_2, grammarAccess.getUnspecifiedAccess().getPreKeyword_2());
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleunspecified"


    // $ANTLR start "entryRuleVariable"
    // InternalForml.g:6470:1: entryRuleVariable returns [EObject current=null] : iv_ruleVariable= ruleVariable EOF ;
    public final EObject entryRuleVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariable = null;


        try {
            // InternalForml.g:6471:2: (iv_ruleVariable= ruleVariable EOF )
            // InternalForml.g:6472:2: iv_ruleVariable= ruleVariable EOF
            {
             newCompositeNode(grammarAccess.getVariableRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVariable=ruleVariable();

            state._fsp--;

             current =iv_ruleVariable; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVariable"


    // $ANTLR start "ruleVariable"
    // InternalForml.g:6479:1: ruleVariable returns [EObject current=null] : ( () ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleVariable() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // InternalForml.g:6482:28: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalForml.g:6483:1: ( () ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalForml.g:6483:1: ( () ( (lv_name_1_0= RULE_ID ) ) )
            // InternalForml.g:6483:2: () ( (lv_name_1_0= RULE_ID ) )
            {
            // InternalForml.g:6483:2: ()
            // InternalForml.g:6484:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getVariableAccess().getVariableAction_0(),
                        current);
                

            }

            // InternalForml.g:6489:2: ( (lv_name_1_0= RULE_ID ) )
            // InternalForml.g:6490:1: (lv_name_1_0= RULE_ID )
            {
            // InternalForml.g:6490:1: (lv_name_1_0= RULE_ID )
            // InternalForml.g:6491:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            			newLeafNode(lv_name_1_0, grammarAccess.getVariableAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getVariableRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVariable"


    // $ANTLR start "entryRuleFragment"
    // InternalForml.g:6515:1: entryRuleFragment returns [EObject current=null] : iv_ruleFragment= ruleFragment EOF ;
    public final EObject entryRuleFragment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFragment = null;


        try {
            // InternalForml.g:6516:2: (iv_ruleFragment= ruleFragment EOF )
            // InternalForml.g:6517:2: iv_ruleFragment= ruleFragment EOF
            {
             newCompositeNode(grammarAccess.getFragmentRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFragment=ruleFragment();

            state._fsp--;

             current =iv_ruleFragment; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFragment"


    // $ANTLR start "ruleFragment"
    // InternalForml.g:6524:1: ruleFragment returns [EObject current=null] : ( () otherlv_1= 'fragment' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_fragmentType_4_0= ruleFragmentType ) )* otherlv_5= '}' ) ;
    public final EObject ruleFragment() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_fragmentType_4_0 = null;


         enterRule(); 
            
        try {
            // InternalForml.g:6527:28: ( ( () otherlv_1= 'fragment' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_fragmentType_4_0= ruleFragmentType ) )* otherlv_5= '}' ) )
            // InternalForml.g:6528:1: ( () otherlv_1= 'fragment' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_fragmentType_4_0= ruleFragmentType ) )* otherlv_5= '}' )
            {
            // InternalForml.g:6528:1: ( () otherlv_1= 'fragment' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_fragmentType_4_0= ruleFragmentType ) )* otherlv_5= '}' )
            // InternalForml.g:6528:2: () otherlv_1= 'fragment' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_fragmentType_4_0= ruleFragmentType ) )* otherlv_5= '}'
            {
            // InternalForml.g:6528:2: ()
            // InternalForml.g:6529:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getFragmentAccess().getFragmentAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,101,FOLLOW_10); 

                	newLeafNode(otherlv_1, grammarAccess.getFragmentAccess().getFragmentKeyword_1());
                
            // InternalForml.g:6538:1: ( (lv_name_2_0= RULE_ID ) )
            // InternalForml.g:6539:1: (lv_name_2_0= RULE_ID )
            {
            // InternalForml.g:6539:1: (lv_name_2_0= RULE_ID )
            // InternalForml.g:6540:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            			newLeafNode(lv_name_2_0, grammarAccess.getFragmentAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getFragmentRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            otherlv_3=(Token)match(input,12,FOLLOW_89); 

                	newLeafNode(otherlv_3, grammarAccess.getFragmentAccess().getLeftCurlyBracketKeyword_3());
                
            // InternalForml.g:6560:1: ( (lv_fragmentType_4_0= ruleFragmentType ) )*
            loop128:
            do {
                int alt128=2;
                int LA128_0 = input.LA(1);

                if ( (LA128_0==61||(LA128_0>=102 && LA128_0<=105)) ) {
                    alt128=1;
                }


                switch (alt128) {
            	case 1 :
            	    // InternalForml.g:6561:1: (lv_fragmentType_4_0= ruleFragmentType )
            	    {
            	    // InternalForml.g:6561:1: (lv_fragmentType_4_0= ruleFragmentType )
            	    // InternalForml.g:6562:3: lv_fragmentType_4_0= ruleFragmentType
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getFragmentAccess().getFragmentTypeFragmentTypeParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_89);
            	    lv_fragmentType_4_0=ruleFragmentType();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getFragmentRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"fragmentType",
            	            		lv_fragmentType_4_0, 
            	            		"uw.cs.watform.forml.Forml.FragmentType");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop128;
                }
            } while (true);

            otherlv_5=(Token)match(input,13,FOLLOW_2); 

                	newLeafNode(otherlv_5, grammarAccess.getFragmentAccess().getRightCurlyBracketKeyword_5());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFragment"


    // $ANTLR start "entryRuleFragmentType"
    // InternalForml.g:6590:1: entryRuleFragmentType returns [EObject current=null] : iv_ruleFragmentType= ruleFragmentType EOF ;
    public final EObject entryRuleFragmentType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFragmentType = null;


        try {
            // InternalForml.g:6591:2: (iv_ruleFragmentType= ruleFragmentType EOF )
            // InternalForml.g:6592:2: iv_ruleFragmentType= ruleFragmentType EOF
            {
             newCompositeNode(grammarAccess.getFragmentTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFragmentType=ruleFragmentType();

            state._fsp--;

             current =iv_ruleFragmentType; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFragmentType"


    // $ANTLR start "ruleFragmentType"
    // InternalForml.g:6599:1: ruleFragmentType returns [EObject current=null] : ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_state_1_0= ruleStateContext ) ) | ( (lv_region_2_0= ruleRegionContext ) ) | ( (lv_frag_3_0= ruleTranFragment ) ) | ( (lv_statemachine_4_0= ruleStateMachineContext ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_transitions_5_0= ruleTransition ) ) )+ ) ) )+ {...}?) ) ) ;
    public final EObject ruleFragmentType() throws RecognitionException {
        EObject current = null;

        EObject lv_state_1_0 = null;

        EObject lv_region_2_0 = null;

        EObject lv_frag_3_0 = null;

        EObject lv_statemachine_4_0 = null;

        EObject lv_transitions_5_0 = null;


         enterRule(); 
            
        try {
            // InternalForml.g:6602:28: ( ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_state_1_0= ruleStateContext ) ) | ( (lv_region_2_0= ruleRegionContext ) ) | ( (lv_frag_3_0= ruleTranFragment ) ) | ( (lv_statemachine_4_0= ruleStateMachineContext ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_transitions_5_0= ruleTransition ) ) )+ ) ) )+ {...}?) ) ) )
            // InternalForml.g:6603:1: ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_state_1_0= ruleStateContext ) ) | ( (lv_region_2_0= ruleRegionContext ) ) | ( (lv_frag_3_0= ruleTranFragment ) ) | ( (lv_statemachine_4_0= ruleStateMachineContext ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_transitions_5_0= ruleTransition ) ) )+ ) ) )+ {...}?) ) )
            {
            // InternalForml.g:6603:1: ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_state_1_0= ruleStateContext ) ) | ( (lv_region_2_0= ruleRegionContext ) ) | ( (lv_frag_3_0= ruleTranFragment ) ) | ( (lv_statemachine_4_0= ruleStateMachineContext ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_transitions_5_0= ruleTransition ) ) )+ ) ) )+ {...}?) ) )
            // InternalForml.g:6605:1: ( ( ( ({...}? => ( ({...}? => ( ( (lv_state_1_0= ruleStateContext ) ) | ( (lv_region_2_0= ruleRegionContext ) ) | ( (lv_frag_3_0= ruleTranFragment ) ) | ( (lv_statemachine_4_0= ruleStateMachineContext ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_transitions_5_0= ruleTransition ) ) )+ ) ) )+ {...}?) )
            {
            // InternalForml.g:6605:1: ( ( ( ({...}? => ( ({...}? => ( ( (lv_state_1_0= ruleStateContext ) ) | ( (lv_region_2_0= ruleRegionContext ) ) | ( (lv_frag_3_0= ruleTranFragment ) ) | ( (lv_statemachine_4_0= ruleStateMachineContext ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_transitions_5_0= ruleTransition ) ) )+ ) ) )+ {...}?) )
            // InternalForml.g:6606:2: ( ( ({...}? => ( ({...}? => ( ( (lv_state_1_0= ruleStateContext ) ) | ( (lv_region_2_0= ruleRegionContext ) ) | ( (lv_frag_3_0= ruleTranFragment ) ) | ( (lv_statemachine_4_0= ruleStateMachineContext ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_transitions_5_0= ruleTransition ) ) )+ ) ) )+ {...}?)
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getFragmentTypeAccess().getUnorderedGroup());
            	
            // InternalForml.g:6609:2: ( ( ({...}? => ( ({...}? => ( ( (lv_state_1_0= ruleStateContext ) ) | ( (lv_region_2_0= ruleRegionContext ) ) | ( (lv_frag_3_0= ruleTranFragment ) ) | ( (lv_statemachine_4_0= ruleStateMachineContext ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_transitions_5_0= ruleTransition ) ) )+ ) ) )+ {...}?)
            // InternalForml.g:6610:3: ( ({...}? => ( ({...}? => ( ( (lv_state_1_0= ruleStateContext ) ) | ( (lv_region_2_0= ruleRegionContext ) ) | ( (lv_frag_3_0= ruleTranFragment ) ) | ( (lv_statemachine_4_0= ruleStateMachineContext ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_transitions_5_0= ruleTransition ) ) )+ ) ) )+ {...}?
            {
            // InternalForml.g:6610:3: ( ({...}? => ( ({...}? => ( ( (lv_state_1_0= ruleStateContext ) ) | ( (lv_region_2_0= ruleRegionContext ) ) | ( (lv_frag_3_0= ruleTranFragment ) ) | ( (lv_statemachine_4_0= ruleStateMachineContext ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_transitions_5_0= ruleTransition ) ) )+ ) ) )+
            int cnt131=0;
            loop131:
            do {
                int alt131=3;
                switch ( input.LA(1) ) {
                case 102:
                    {
                    int LA131_2 = input.LA(2);

                    if ( getUnorderedGroupHelper().canSelect(grammarAccess.getFragmentTypeAccess().getUnorderedGroup(), 0) ) {
                        alt131=1;
                    }


                    }
                    break;
                case 103:
                    {
                    int LA131_3 = input.LA(2);

                    if ( getUnorderedGroupHelper().canSelect(grammarAccess.getFragmentTypeAccess().getUnorderedGroup(), 0) ) {
                        alt131=1;
                    }


                    }
                    break;
                case 105:
                    {
                    int LA131_4 = input.LA(2);

                    if ( getUnorderedGroupHelper().canSelect(grammarAccess.getFragmentTypeAccess().getUnorderedGroup(), 0) ) {
                        alt131=1;
                    }


                    }
                    break;
                case 104:
                    {
                    int LA131_5 = input.LA(2);

                    if ( getUnorderedGroupHelper().canSelect(grammarAccess.getFragmentTypeAccess().getUnorderedGroup(), 0) ) {
                        alt131=1;
                    }


                    }
                    break;
                case 61:
                    {
                    int LA131_6 = input.LA(2);

                    if ( getUnorderedGroupHelper().canSelect(grammarAccess.getFragmentTypeAccess().getUnorderedGroup(), 1) ) {
                        alt131=2;
                    }


                    }
                    break;

                }

                switch (alt131) {
            	case 1 :
            	    // InternalForml.g:6612:4: ({...}? => ( ({...}? => ( ( (lv_state_1_0= ruleStateContext ) ) | ( (lv_region_2_0= ruleRegionContext ) ) | ( (lv_frag_3_0= ruleTranFragment ) ) | ( (lv_statemachine_4_0= ruleStateMachineContext ) ) ) ) ) )
            	    {
            	    // InternalForml.g:6612:4: ({...}? => ( ({...}? => ( ( (lv_state_1_0= ruleStateContext ) ) | ( (lv_region_2_0= ruleRegionContext ) ) | ( (lv_frag_3_0= ruleTranFragment ) ) | ( (lv_statemachine_4_0= ruleStateMachineContext ) ) ) ) ) )
            	    // InternalForml.g:6613:5: {...}? => ( ({...}? => ( ( (lv_state_1_0= ruleStateContext ) ) | ( (lv_region_2_0= ruleRegionContext ) ) | ( (lv_frag_3_0= ruleTranFragment ) ) | ( (lv_statemachine_4_0= ruleStateMachineContext ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getFragmentTypeAccess().getUnorderedGroup(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleFragmentType", "getUnorderedGroupHelper().canSelect(grammarAccess.getFragmentTypeAccess().getUnorderedGroup(), 0)");
            	    }
            	    // InternalForml.g:6613:107: ( ({...}? => ( ( (lv_state_1_0= ruleStateContext ) ) | ( (lv_region_2_0= ruleRegionContext ) ) | ( (lv_frag_3_0= ruleTranFragment ) ) | ( (lv_statemachine_4_0= ruleStateMachineContext ) ) ) ) )
            	    // InternalForml.g:6614:6: ({...}? => ( ( (lv_state_1_0= ruleStateContext ) ) | ( (lv_region_2_0= ruleRegionContext ) ) | ( (lv_frag_3_0= ruleTranFragment ) ) | ( (lv_statemachine_4_0= ruleStateMachineContext ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getFragmentTypeAccess().getUnorderedGroup(), 0);
            	    	 				
            	    // InternalForml.g:6617:6: ({...}? => ( ( (lv_state_1_0= ruleStateContext ) ) | ( (lv_region_2_0= ruleRegionContext ) ) | ( (lv_frag_3_0= ruleTranFragment ) ) | ( (lv_statemachine_4_0= ruleStateMachineContext ) ) ) )
            	    // InternalForml.g:6617:7: {...}? => ( ( (lv_state_1_0= ruleStateContext ) ) | ( (lv_region_2_0= ruleRegionContext ) ) | ( (lv_frag_3_0= ruleTranFragment ) ) | ( (lv_statemachine_4_0= ruleStateMachineContext ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleFragmentType", "true");
            	    }
            	    // InternalForml.g:6617:16: ( ( (lv_state_1_0= ruleStateContext ) ) | ( (lv_region_2_0= ruleRegionContext ) ) | ( (lv_frag_3_0= ruleTranFragment ) ) | ( (lv_statemachine_4_0= ruleStateMachineContext ) ) )
            	    int alt129=4;
            	    switch ( input.LA(1) ) {
            	    case 102:
            	        {
            	        alt129=1;
            	        }
            	        break;
            	    case 103:
            	        {
            	        alt129=2;
            	        }
            	        break;
            	    case 105:
            	        {
            	        alt129=3;
            	        }
            	        break;
            	    case 104:
            	        {
            	        alt129=4;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 129, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt129) {
            	        case 1 :
            	            // InternalForml.g:6617:17: ( (lv_state_1_0= ruleStateContext ) )
            	            {
            	            // InternalForml.g:6617:17: ( (lv_state_1_0= ruleStateContext ) )
            	            // InternalForml.g:6618:1: (lv_state_1_0= ruleStateContext )
            	            {
            	            // InternalForml.g:6618:1: (lv_state_1_0= ruleStateContext )
            	            // InternalForml.g:6619:3: lv_state_1_0= ruleStateContext
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getFragmentTypeAccess().getStateStateContextParserRuleCall_0_0_0()); 
            	            	    
            	            pushFollow(FOLLOW_90);
            	            lv_state_1_0=ruleStateContext();

            	            state._fsp--;


            	            	        if (current==null) {
            	            	            current = createModelElementForParent(grammarAccess.getFragmentTypeRule());
            	            	        }
            	                   		set(
            	                   			current, 
            	                   			"state",
            	                    		lv_state_1_0, 
            	                    		"uw.cs.watform.forml.Forml.StateContext");
            	            	        afterParserOrEnumRuleCall();
            	            	    

            	            }


            	            }


            	            }
            	            break;
            	        case 2 :
            	            // InternalForml.g:6636:6: ( (lv_region_2_0= ruleRegionContext ) )
            	            {
            	            // InternalForml.g:6636:6: ( (lv_region_2_0= ruleRegionContext ) )
            	            // InternalForml.g:6637:1: (lv_region_2_0= ruleRegionContext )
            	            {
            	            // InternalForml.g:6637:1: (lv_region_2_0= ruleRegionContext )
            	            // InternalForml.g:6638:3: lv_region_2_0= ruleRegionContext
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getFragmentTypeAccess().getRegionRegionContextParserRuleCall_0_1_0()); 
            	            	    
            	            pushFollow(FOLLOW_90);
            	            lv_region_2_0=ruleRegionContext();

            	            state._fsp--;


            	            	        if (current==null) {
            	            	            current = createModelElementForParent(grammarAccess.getFragmentTypeRule());
            	            	        }
            	                   		set(
            	                   			current, 
            	                   			"region",
            	                    		lv_region_2_0, 
            	                    		"uw.cs.watform.forml.Forml.RegionContext");
            	            	        afterParserOrEnumRuleCall();
            	            	    

            	            }


            	            }


            	            }
            	            break;
            	        case 3 :
            	            // InternalForml.g:6655:6: ( (lv_frag_3_0= ruleTranFragment ) )
            	            {
            	            // InternalForml.g:6655:6: ( (lv_frag_3_0= ruleTranFragment ) )
            	            // InternalForml.g:6656:1: (lv_frag_3_0= ruleTranFragment )
            	            {
            	            // InternalForml.g:6656:1: (lv_frag_3_0= ruleTranFragment )
            	            // InternalForml.g:6657:3: lv_frag_3_0= ruleTranFragment
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getFragmentTypeAccess().getFragTranFragmentParserRuleCall_0_2_0()); 
            	            	    
            	            pushFollow(FOLLOW_90);
            	            lv_frag_3_0=ruleTranFragment();

            	            state._fsp--;


            	            	        if (current==null) {
            	            	            current = createModelElementForParent(grammarAccess.getFragmentTypeRule());
            	            	        }
            	                   		set(
            	                   			current, 
            	                   			"frag",
            	                    		lv_frag_3_0, 
            	                    		"uw.cs.watform.forml.Forml.TranFragment");
            	            	        afterParserOrEnumRuleCall();
            	            	    

            	            }


            	            }


            	            }
            	            break;
            	        case 4 :
            	            // InternalForml.g:6674:6: ( (lv_statemachine_4_0= ruleStateMachineContext ) )
            	            {
            	            // InternalForml.g:6674:6: ( (lv_statemachine_4_0= ruleStateMachineContext ) )
            	            // InternalForml.g:6675:1: (lv_statemachine_4_0= ruleStateMachineContext )
            	            {
            	            // InternalForml.g:6675:1: (lv_statemachine_4_0= ruleStateMachineContext )
            	            // InternalForml.g:6676:3: lv_statemachine_4_0= ruleStateMachineContext
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getFragmentTypeAccess().getStatemachineStateMachineContextParserRuleCall_0_3_0()); 
            	            	    
            	            pushFollow(FOLLOW_90);
            	            lv_statemachine_4_0=ruleStateMachineContext();

            	            state._fsp--;


            	            	        if (current==null) {
            	            	            current = createModelElementForParent(grammarAccess.getFragmentTypeRule());
            	            	        }
            	                   		set(
            	                   			current, 
            	                   			"statemachine",
            	                    		lv_statemachine_4_0, 
            	                    		"uw.cs.watform.forml.Forml.StateMachineContext");
            	            	        afterParserOrEnumRuleCall();
            	            	    

            	            }


            	            }


            	            }
            	            break;

            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getFragmentTypeAccess().getUnorderedGroup());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalForml.g:6699:4: ({...}? => ( ({...}? => ( (lv_transitions_5_0= ruleTransition ) ) )+ ) )
            	    {
            	    // InternalForml.g:6699:4: ({...}? => ( ({...}? => ( (lv_transitions_5_0= ruleTransition ) ) )+ ) )
            	    // InternalForml.g:6700:5: {...}? => ( ({...}? => ( (lv_transitions_5_0= ruleTransition ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getFragmentTypeAccess().getUnorderedGroup(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleFragmentType", "getUnorderedGroupHelper().canSelect(grammarAccess.getFragmentTypeAccess().getUnorderedGroup(), 1)");
            	    }
            	    // InternalForml.g:6700:107: ( ({...}? => ( (lv_transitions_5_0= ruleTransition ) ) )+ )
            	    // InternalForml.g:6701:6: ({...}? => ( (lv_transitions_5_0= ruleTransition ) ) )+
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getFragmentTypeAccess().getUnorderedGroup(), 1);
            	    	 				
            	    // InternalForml.g:6704:6: ({...}? => ( (lv_transitions_5_0= ruleTransition ) ) )+
            	    int cnt130=0;
            	    loop130:
            	    do {
            	        int alt130=2;
            	        int LA130_0 = input.LA(1);

            	        if ( (LA130_0==61) ) {
            	            int LA130_2 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt130=1;
            	            }


            	        }


            	        switch (alt130) {
            	    	case 1 :
            	    	    // InternalForml.g:6704:7: {...}? => ( (lv_transitions_5_0= ruleTransition ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleFragmentType", "true");
            	    	    }
            	    	    // InternalForml.g:6704:16: ( (lv_transitions_5_0= ruleTransition ) )
            	    	    // InternalForml.g:6705:1: (lv_transitions_5_0= ruleTransition )
            	    	    {
            	    	    // InternalForml.g:6705:1: (lv_transitions_5_0= ruleTransition )
            	    	    // InternalForml.g:6706:3: lv_transitions_5_0= ruleTransition
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getFragmentTypeAccess().getTransitionsTransitionParserRuleCall_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_90);
            	    	    lv_transitions_5_0=ruleTransition();

            	    	    state._fsp--;


            	    	    	        if (current==null) {
            	    	    	            current = createModelElementForParent(grammarAccess.getFragmentTypeRule());
            	    	    	        }
            	    	           		add(
            	    	           			current, 
            	    	           			"transitions",
            	    	            		lv_transitions_5_0, 
            	    	            		"uw.cs.watform.forml.Forml.Transition");
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt130 >= 1 ) break loop130;
            	                EarlyExitException eee =
            	                    new EarlyExitException(130, input);
            	                throw eee;
            	        }
            	        cnt130++;
            	    } while (true);

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getFragmentTypeAccess().getUnorderedGroup());
            	    	 				

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt131 >= 1 ) break loop131;
                        EarlyExitException eee =
                            new EarlyExitException(131, input);
                        throw eee;
                }
                cnt131++;
            } while (true);

            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getFragmentTypeAccess().getUnorderedGroup()) ) {
                throw new FailedPredicateException(input, "ruleFragmentType", "getUnorderedGroupHelper().canLeave(grammarAccess.getFragmentTypeAccess().getUnorderedGroup())");
            }

            }


            }

             
            	  getUnorderedGroupHelper().leave(grammarAccess.getFragmentTypeAccess().getUnorderedGroup());
            	

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFragmentType"


    // $ANTLR start "entryRuleStateContext"
    // InternalForml.g:6745:1: entryRuleStateContext returns [EObject current=null] : iv_ruleStateContext= ruleStateContext EOF ;
    public final EObject entryRuleStateContext() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStateContext = null;


        try {
            // InternalForml.g:6746:2: (iv_ruleStateContext= ruleStateContext EOF )
            // InternalForml.g:6747:2: iv_ruleStateContext= ruleStateContext EOF
            {
             newCompositeNode(grammarAccess.getStateContextRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStateContext=ruleStateContext();

            state._fsp--;

             current =iv_ruleStateContext; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStateContext"


    // $ANTLR start "ruleStateContext"
    // InternalForml.g:6754:1: ruleStateContext returns [EObject current=null] : ( () otherlv_1= 'StateFragment' otherlv_2= '{' otherlv_3= 'state' ( ( ruleQualifiedName ) ) ( (lv_regions_5_0= ruleRegion ) )* otherlv_6= '}' ) ;
    public final EObject ruleStateContext() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_6=null;
        EObject lv_regions_5_0 = null;


         enterRule(); 
            
        try {
            // InternalForml.g:6757:28: ( ( () otherlv_1= 'StateFragment' otherlv_2= '{' otherlv_3= 'state' ( ( ruleQualifiedName ) ) ( (lv_regions_5_0= ruleRegion ) )* otherlv_6= '}' ) )
            // InternalForml.g:6758:1: ( () otherlv_1= 'StateFragment' otherlv_2= '{' otherlv_3= 'state' ( ( ruleQualifiedName ) ) ( (lv_regions_5_0= ruleRegion ) )* otherlv_6= '}' )
            {
            // InternalForml.g:6758:1: ( () otherlv_1= 'StateFragment' otherlv_2= '{' otherlv_3= 'state' ( ( ruleQualifiedName ) ) ( (lv_regions_5_0= ruleRegion ) )* otherlv_6= '}' )
            // InternalForml.g:6758:2: () otherlv_1= 'StateFragment' otherlv_2= '{' otherlv_3= 'state' ( ( ruleQualifiedName ) ) ( (lv_regions_5_0= ruleRegion ) )* otherlv_6= '}'
            {
            // InternalForml.g:6758:2: ()
            // InternalForml.g:6759:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getStateContextAccess().getStateContextAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,102,FOLLOW_4); 

                	newLeafNode(otherlv_1, grammarAccess.getStateContextAccess().getStateFragmentKeyword_1());
                
            otherlv_2=(Token)match(input,12,FOLLOW_91); 

                	newLeafNode(otherlv_2, grammarAccess.getStateContextAccess().getLeftCurlyBracketKeyword_2());
                
            otherlv_3=(Token)match(input,59,FOLLOW_10); 

                	newLeafNode(otherlv_3, grammarAccess.getStateContextAccess().getStateKeyword_3());
                
            // InternalForml.g:6776:1: ( ( ruleQualifiedName ) )
            // InternalForml.g:6777:1: ( ruleQualifiedName )
            {
            // InternalForml.g:6777:1: ( ruleQualifiedName )
            // InternalForml.g:6778:3: ruleQualifiedName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getStateContextRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getStateContextAccess().getRefStateCrossReference_4_0()); 
            	    
            pushFollow(FOLLOW_51);
            ruleQualifiedName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalForml.g:6791:2: ( (lv_regions_5_0= ruleRegion ) )*
            loop132:
            do {
                int alt132=2;
                int LA132_0 = input.LA(1);

                if ( (LA132_0==60) ) {
                    alt132=1;
                }


                switch (alt132) {
            	case 1 :
            	    // InternalForml.g:6792:1: (lv_regions_5_0= ruleRegion )
            	    {
            	    // InternalForml.g:6792:1: (lv_regions_5_0= ruleRegion )
            	    // InternalForml.g:6793:3: lv_regions_5_0= ruleRegion
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStateContextAccess().getRegionsRegionParserRuleCall_5_0()); 
            	    	    
            	    pushFollow(FOLLOW_51);
            	    lv_regions_5_0=ruleRegion();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getStateContextRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"regions",
            	            		lv_regions_5_0, 
            	            		"uw.cs.watform.forml.Forml.Region");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop132;
                }
            } while (true);

            otherlv_6=(Token)match(input,13,FOLLOW_2); 

                	newLeafNode(otherlv_6, grammarAccess.getStateContextAccess().getRightCurlyBracketKeyword_6());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStateContext"


    // $ANTLR start "entryRuleRegionContext"
    // InternalForml.g:6821:1: entryRuleRegionContext returns [EObject current=null] : iv_ruleRegionContext= ruleRegionContext EOF ;
    public final EObject entryRuleRegionContext() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRegionContext = null;


        try {
            // InternalForml.g:6822:2: (iv_ruleRegionContext= ruleRegionContext EOF )
            // InternalForml.g:6823:2: iv_ruleRegionContext= ruleRegionContext EOF
            {
             newCompositeNode(grammarAccess.getRegionContextRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRegionContext=ruleRegionContext();

            state._fsp--;

             current =iv_ruleRegionContext; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRegionContext"


    // $ANTLR start "ruleRegionContext"
    // InternalForml.g:6830:1: ruleRegionContext returns [EObject current=null] : ( () otherlv_1= 'RegionFragment' otherlv_2= '{' otherlv_3= 'region' ( ( ruleQualifiedName ) ) ( (lv_states_5_0= ruleState ) )* otherlv_6= '}' ) ;
    public final EObject ruleRegionContext() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_6=null;
        EObject lv_states_5_0 = null;


         enterRule(); 
            
        try {
            // InternalForml.g:6833:28: ( ( () otherlv_1= 'RegionFragment' otherlv_2= '{' otherlv_3= 'region' ( ( ruleQualifiedName ) ) ( (lv_states_5_0= ruleState ) )* otherlv_6= '}' ) )
            // InternalForml.g:6834:1: ( () otherlv_1= 'RegionFragment' otherlv_2= '{' otherlv_3= 'region' ( ( ruleQualifiedName ) ) ( (lv_states_5_0= ruleState ) )* otherlv_6= '}' )
            {
            // InternalForml.g:6834:1: ( () otherlv_1= 'RegionFragment' otherlv_2= '{' otherlv_3= 'region' ( ( ruleQualifiedName ) ) ( (lv_states_5_0= ruleState ) )* otherlv_6= '}' )
            // InternalForml.g:6834:2: () otherlv_1= 'RegionFragment' otherlv_2= '{' otherlv_3= 'region' ( ( ruleQualifiedName ) ) ( (lv_states_5_0= ruleState ) )* otherlv_6= '}'
            {
            // InternalForml.g:6834:2: ()
            // InternalForml.g:6835:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getRegionContextAccess().getRegionContextAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,103,FOLLOW_4); 

                	newLeafNode(otherlv_1, grammarAccess.getRegionContextAccess().getRegionFragmentKeyword_1());
                
            otherlv_2=(Token)match(input,12,FOLLOW_92); 

                	newLeafNode(otherlv_2, grammarAccess.getRegionContextAccess().getLeftCurlyBracketKeyword_2());
                
            otherlv_3=(Token)match(input,60,FOLLOW_10); 

                	newLeafNode(otherlv_3, grammarAccess.getRegionContextAccess().getRegionKeyword_3());
                
            // InternalForml.g:6852:1: ( ( ruleQualifiedName ) )
            // InternalForml.g:6853:1: ( ruleQualifiedName )
            {
            // InternalForml.g:6853:1: ( ruleQualifiedName )
            // InternalForml.g:6854:3: ruleQualifiedName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getRegionContextRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getRegionContextAccess().getRefRegionCrossReference_4_0()); 
            	    
            pushFollow(FOLLOW_53);
            ruleQualifiedName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalForml.g:6867:2: ( (lv_states_5_0= ruleState ) )*
            loop133:
            do {
                int alt133=2;
                int LA133_0 = input.LA(1);

                if ( (LA133_0==59) ) {
                    alt133=1;
                }


                switch (alt133) {
            	case 1 :
            	    // InternalForml.g:6868:1: (lv_states_5_0= ruleState )
            	    {
            	    // InternalForml.g:6868:1: (lv_states_5_0= ruleState )
            	    // InternalForml.g:6869:3: lv_states_5_0= ruleState
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRegionContextAccess().getStatesStateParserRuleCall_5_0()); 
            	    	    
            	    pushFollow(FOLLOW_53);
            	    lv_states_5_0=ruleState();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRegionContextRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"states",
            	            		lv_states_5_0, 
            	            		"uw.cs.watform.forml.Forml.State");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop133;
                }
            } while (true);

            otherlv_6=(Token)match(input,13,FOLLOW_2); 

                	newLeafNode(otherlv_6, grammarAccess.getRegionContextAccess().getRightCurlyBracketKeyword_6());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRegionContext"


    // $ANTLR start "entryRuleStateMachineContext"
    // InternalForml.g:6897:1: entryRuleStateMachineContext returns [EObject current=null] : iv_ruleStateMachineContext= ruleStateMachineContext EOF ;
    public final EObject entryRuleStateMachineContext() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStateMachineContext = null;


        try {
            // InternalForml.g:6898:2: (iv_ruleStateMachineContext= ruleStateMachineContext EOF )
            // InternalForml.g:6899:2: iv_ruleStateMachineContext= ruleStateMachineContext EOF
            {
             newCompositeNode(grammarAccess.getStateMachineContextRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStateMachineContext=ruleStateMachineContext();

            state._fsp--;

             current =iv_ruleStateMachineContext; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStateMachineContext"


    // $ANTLR start "ruleStateMachineContext"
    // InternalForml.g:6906:1: ruleStateMachineContext returns [EObject current=null] : ( () otherlv_1= 'SMFragment' otherlv_2= '{' otherlv_3= 'statemachine' ( ( ruleQualifiedName ) ) ( (lv_state_5_0= ruleState ) )* ) ;
    public final EObject ruleStateMachineContext() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        EObject lv_state_5_0 = null;


         enterRule(); 
            
        try {
            // InternalForml.g:6909:28: ( ( () otherlv_1= 'SMFragment' otherlv_2= '{' otherlv_3= 'statemachine' ( ( ruleQualifiedName ) ) ( (lv_state_5_0= ruleState ) )* ) )
            // InternalForml.g:6910:1: ( () otherlv_1= 'SMFragment' otherlv_2= '{' otherlv_3= 'statemachine' ( ( ruleQualifiedName ) ) ( (lv_state_5_0= ruleState ) )* )
            {
            // InternalForml.g:6910:1: ( () otherlv_1= 'SMFragment' otherlv_2= '{' otherlv_3= 'statemachine' ( ( ruleQualifiedName ) ) ( (lv_state_5_0= ruleState ) )* )
            // InternalForml.g:6910:2: () otherlv_1= 'SMFragment' otherlv_2= '{' otherlv_3= 'statemachine' ( ( ruleQualifiedName ) ) ( (lv_state_5_0= ruleState ) )*
            {
            // InternalForml.g:6910:2: ()
            // InternalForml.g:6911:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getStateMachineContextAccess().getStateMachineContextAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,104,FOLLOW_4); 

                	newLeafNode(otherlv_1, grammarAccess.getStateMachineContextAccess().getSMFragmentKeyword_1());
                
            otherlv_2=(Token)match(input,12,FOLLOW_93); 

                	newLeafNode(otherlv_2, grammarAccess.getStateMachineContextAccess().getLeftCurlyBracketKeyword_2());
                
            otherlv_3=(Token)match(input,56,FOLLOW_10); 

                	newLeafNode(otherlv_3, grammarAccess.getStateMachineContextAccess().getStatemachineKeyword_3());
                
            // InternalForml.g:6928:1: ( ( ruleQualifiedName ) )
            // InternalForml.g:6929:1: ( ruleQualifiedName )
            {
            // InternalForml.g:6929:1: ( ruleQualifiedName )
            // InternalForml.g:6930:3: ruleQualifiedName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getStateMachineContextRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getStateMachineContextAccess().getRefStateMachineCrossReference_4_0()); 
            	    
            pushFollow(FOLLOW_94);
            ruleQualifiedName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalForml.g:6943:2: ( (lv_state_5_0= ruleState ) )*
            loop134:
            do {
                int alt134=2;
                int LA134_0 = input.LA(1);

                if ( (LA134_0==59) ) {
                    alt134=1;
                }


                switch (alt134) {
            	case 1 :
            	    // InternalForml.g:6944:1: (lv_state_5_0= ruleState )
            	    {
            	    // InternalForml.g:6944:1: (lv_state_5_0= ruleState )
            	    // InternalForml.g:6945:3: lv_state_5_0= ruleState
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStateMachineContextAccess().getStateStateParserRuleCall_5_0()); 
            	    	    
            	    pushFollow(FOLLOW_94);
            	    lv_state_5_0=ruleState();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getStateMachineContextRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"state",
            	            		lv_state_5_0, 
            	            		"uw.cs.watform.forml.Forml.State");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop134;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStateMachineContext"


    // $ANTLR start "entryRuleTranFragment"
    // InternalForml.g:6969:1: entryRuleTranFragment returns [EObject current=null] : iv_ruleTranFragment= ruleTranFragment EOF ;
    public final EObject entryRuleTranFragment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTranFragment = null;


        try {
            // InternalForml.g:6970:2: (iv_ruleTranFragment= ruleTranFragment EOF )
            // InternalForml.g:6971:2: iv_ruleTranFragment= ruleTranFragment EOF
            {
             newCompositeNode(grammarAccess.getTranFragmentRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTranFragment=ruleTranFragment();

            state._fsp--;

             current =iv_ruleTranFragment; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTranFragment"


    // $ANTLR start "ruleTranFragment"
    // InternalForml.g:6978:1: ruleTranFragment returns [EObject current=null] : (otherlv_0= 'TransitionFragment' otherlv_1= '{' ( ( ruleQualifiedName ) ) otherlv_3= ':' ( (lv_trig_4_0= ruleTrigger ) )? ( (lv_fragType_5_0= ruleGuard ) ) (otherlv_6= '/' ( (lv_list_7_0= ruleWCAList ) )? ( (lv_fragList_8_0= ruleWCAFragmentList ) )? )? otherlv_9= '}' ) ;
    public final EObject ruleTranFragment() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_6=null;
        Token otherlv_9=null;
        EObject lv_trig_4_0 = null;

        EObject lv_fragType_5_0 = null;

        EObject lv_list_7_0 = null;

        EObject lv_fragList_8_0 = null;


         enterRule(); 
            
        try {
            // InternalForml.g:6981:28: ( (otherlv_0= 'TransitionFragment' otherlv_1= '{' ( ( ruleQualifiedName ) ) otherlv_3= ':' ( (lv_trig_4_0= ruleTrigger ) )? ( (lv_fragType_5_0= ruleGuard ) ) (otherlv_6= '/' ( (lv_list_7_0= ruleWCAList ) )? ( (lv_fragList_8_0= ruleWCAFragmentList ) )? )? otherlv_9= '}' ) )
            // InternalForml.g:6982:1: (otherlv_0= 'TransitionFragment' otherlv_1= '{' ( ( ruleQualifiedName ) ) otherlv_3= ':' ( (lv_trig_4_0= ruleTrigger ) )? ( (lv_fragType_5_0= ruleGuard ) ) (otherlv_6= '/' ( (lv_list_7_0= ruleWCAList ) )? ( (lv_fragList_8_0= ruleWCAFragmentList ) )? )? otherlv_9= '}' )
            {
            // InternalForml.g:6982:1: (otherlv_0= 'TransitionFragment' otherlv_1= '{' ( ( ruleQualifiedName ) ) otherlv_3= ':' ( (lv_trig_4_0= ruleTrigger ) )? ( (lv_fragType_5_0= ruleGuard ) ) (otherlv_6= '/' ( (lv_list_7_0= ruleWCAList ) )? ( (lv_fragList_8_0= ruleWCAFragmentList ) )? )? otherlv_9= '}' )
            // InternalForml.g:6982:3: otherlv_0= 'TransitionFragment' otherlv_1= '{' ( ( ruleQualifiedName ) ) otherlv_3= ':' ( (lv_trig_4_0= ruleTrigger ) )? ( (lv_fragType_5_0= ruleGuard ) ) (otherlv_6= '/' ( (lv_list_7_0= ruleWCAList ) )? ( (lv_fragList_8_0= ruleWCAFragmentList ) )? )? otherlv_9= '}'
            {
            otherlv_0=(Token)match(input,105,FOLLOW_4); 

                	newLeafNode(otherlv_0, grammarAccess.getTranFragmentAccess().getTransitionFragmentKeyword_0());
                
            otherlv_1=(Token)match(input,12,FOLLOW_10); 

                	newLeafNode(otherlv_1, grammarAccess.getTranFragmentAccess().getLeftCurlyBracketKeyword_1());
                
            // InternalForml.g:6990:1: ( ( ruleQualifiedName ) )
            // InternalForml.g:6991:1: ( ruleQualifiedName )
            {
            // InternalForml.g:6991:1: ( ruleQualifiedName )
            // InternalForml.g:6992:3: ruleQualifiedName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getTranFragmentRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getTranFragmentAccess().getRefTransitionCrossReference_2_0()); 
            	    
            pushFollow(FOLLOW_22);
            ruleQualifiedName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,23,FOLLOW_95); 

                	newLeafNode(otherlv_3, grammarAccess.getTranFragmentAccess().getColonKeyword_3());
                
            // InternalForml.g:7009:1: ( (lv_trig_4_0= ruleTrigger ) )?
            int alt135=2;
            int LA135_0 = input.LA(1);

            if ( (LA135_0==65) ) {
                alt135=1;
            }
            switch (alt135) {
                case 1 :
                    // InternalForml.g:7010:1: (lv_trig_4_0= ruleTrigger )
                    {
                    // InternalForml.g:7010:1: (lv_trig_4_0= ruleTrigger )
                    // InternalForml.g:7011:3: lv_trig_4_0= ruleTrigger
                    {
                     
                    	        newCompositeNode(grammarAccess.getTranFragmentAccess().getTrigTriggerParserRuleCall_4_0()); 
                    	    
                    pushFollow(FOLLOW_96);
                    lv_trig_4_0=ruleTrigger();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getTranFragmentRule());
                    	        }
                           		set(
                           			current, 
                           			"trig",
                            		lv_trig_4_0, 
                            		"uw.cs.watform.forml.Forml.Trigger");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // InternalForml.g:7027:3: ( (lv_fragType_5_0= ruleGuard ) )
            // InternalForml.g:7028:1: (lv_fragType_5_0= ruleGuard )
            {
            // InternalForml.g:7028:1: (lv_fragType_5_0= ruleGuard )
            // InternalForml.g:7029:3: lv_fragType_5_0= ruleGuard
            {
             
            	        newCompositeNode(grammarAccess.getTranFragmentAccess().getFragTypeGuardParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_58);
            lv_fragType_5_0=ruleGuard();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getTranFragmentRule());
            	        }
                   		set(
                   			current, 
                   			"fragType",
                    		lv_fragType_5_0, 
                    		"uw.cs.watform.forml.Forml.Guard");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalForml.g:7045:2: (otherlv_6= '/' ( (lv_list_7_0= ruleWCAList ) )? ( (lv_fragList_8_0= ruleWCAFragmentList ) )? )?
            int alt138=2;
            int LA138_0 = input.LA(1);

            if ( (LA138_0==71) ) {
                alt138=1;
            }
            switch (alt138) {
                case 1 :
                    // InternalForml.g:7045:4: otherlv_6= '/' ( (lv_list_7_0= ruleWCAList ) )? ( (lv_fragList_8_0= ruleWCAFragmentList ) )?
                    {
                    otherlv_6=(Token)match(input,71,FOLLOW_97); 

                        	newLeafNode(otherlv_6, grammarAccess.getTranFragmentAccess().getSolidusKeyword_6_0());
                        
                    // InternalForml.g:7049:1: ( (lv_list_7_0= ruleWCAList ) )?
                    int alt136=2;
                    int LA136_0 = input.LA(1);

                    if ( (LA136_0==71) ) {
                        alt136=1;
                    }
                    switch (alt136) {
                        case 1 :
                            // InternalForml.g:7050:1: (lv_list_7_0= ruleWCAList )
                            {
                            // InternalForml.g:7050:1: (lv_list_7_0= ruleWCAList )
                            // InternalForml.g:7051:3: lv_list_7_0= ruleWCAList
                            {
                             
                            	        newCompositeNode(grammarAccess.getTranFragmentAccess().getListWCAListParserRuleCall_6_1_0()); 
                            	    
                            pushFollow(FOLLOW_32);
                            lv_list_7_0=ruleWCAList();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getTranFragmentRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"list",
                                    		lv_list_7_0, 
                                    		"uw.cs.watform.forml.Forml.WCAList");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }
                            break;

                    }

                    // InternalForml.g:7067:3: ( (lv_fragList_8_0= ruleWCAFragmentList ) )?
                    int alt137=2;
                    int LA137_0 = input.LA(1);

                    if ( (LA137_0==RULE_ID) ) {
                        alt137=1;
                    }
                    switch (alt137) {
                        case 1 :
                            // InternalForml.g:7068:1: (lv_fragList_8_0= ruleWCAFragmentList )
                            {
                            // InternalForml.g:7068:1: (lv_fragList_8_0= ruleWCAFragmentList )
                            // InternalForml.g:7069:3: lv_fragList_8_0= ruleWCAFragmentList
                            {
                             
                            	        newCompositeNode(grammarAccess.getTranFragmentAccess().getFragListWCAFragmentListParserRuleCall_6_2_0()); 
                            	    
                            pushFollow(FOLLOW_6);
                            lv_fragList_8_0=ruleWCAFragmentList();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getTranFragmentRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"fragList",
                                    		lv_fragList_8_0, 
                                    		"uw.cs.watform.forml.Forml.WCAFragmentList");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }
                            break;

                    }


                    }
                    break;

            }

            otherlv_9=(Token)match(input,13,FOLLOW_2); 

                	newLeafNode(otherlv_9, grammarAccess.getTranFragmentAccess().getRightCurlyBracketKeyword_7());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTranFragment"


    // $ANTLR start "entryRuleWCAFragmentList"
    // InternalForml.g:7097:1: entryRuleWCAFragmentList returns [EObject current=null] : iv_ruleWCAFragmentList= ruleWCAFragmentList EOF ;
    public final EObject entryRuleWCAFragmentList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWCAFragmentList = null;


        try {
            // InternalForml.g:7098:2: (iv_ruleWCAFragmentList= ruleWCAFragmentList EOF )
            // InternalForml.g:7099:2: iv_ruleWCAFragmentList= ruleWCAFragmentList EOF
            {
             newCompositeNode(grammarAccess.getWCAFragmentListRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleWCAFragmentList=ruleWCAFragmentList();

            state._fsp--;

             current =iv_ruleWCAFragmentList; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleWCAFragmentList"


    // $ANTLR start "ruleWCAFragmentList"
    // InternalForml.g:7106:1: ruleWCAFragmentList returns [EObject current=null] : ( ( (lv_frag_0_0= ruleWCAFragment ) ) (otherlv_1= ',' ( (lv_frag_2_0= ruleWCAFragment ) ) )* ) ;
    public final EObject ruleWCAFragmentList() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_frag_0_0 = null;

        EObject lv_frag_2_0 = null;


         enterRule(); 
            
        try {
            // InternalForml.g:7109:28: ( ( ( (lv_frag_0_0= ruleWCAFragment ) ) (otherlv_1= ',' ( (lv_frag_2_0= ruleWCAFragment ) ) )* ) )
            // InternalForml.g:7110:1: ( ( (lv_frag_0_0= ruleWCAFragment ) ) (otherlv_1= ',' ( (lv_frag_2_0= ruleWCAFragment ) ) )* )
            {
            // InternalForml.g:7110:1: ( ( (lv_frag_0_0= ruleWCAFragment ) ) (otherlv_1= ',' ( (lv_frag_2_0= ruleWCAFragment ) ) )* )
            // InternalForml.g:7110:2: ( (lv_frag_0_0= ruleWCAFragment ) ) (otherlv_1= ',' ( (lv_frag_2_0= ruleWCAFragment ) ) )*
            {
            // InternalForml.g:7110:2: ( (lv_frag_0_0= ruleWCAFragment ) )
            // InternalForml.g:7111:1: (lv_frag_0_0= ruleWCAFragment )
            {
            // InternalForml.g:7111:1: (lv_frag_0_0= ruleWCAFragment )
            // InternalForml.g:7112:3: lv_frag_0_0= ruleWCAFragment
            {
             
            	        newCompositeNode(grammarAccess.getWCAFragmentListAccess().getFragWCAFragmentParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_59);
            lv_frag_0_0=ruleWCAFragment();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getWCAFragmentListRule());
            	        }
                   		add(
                   			current, 
                   			"frag",
                    		lv_frag_0_0, 
                    		"uw.cs.watform.forml.Forml.WCAFragment");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalForml.g:7128:2: (otherlv_1= ',' ( (lv_frag_2_0= ruleWCAFragment ) ) )*
            loop139:
            do {
                int alt139=2;
                int LA139_0 = input.LA(1);

                if ( (LA139_0==45) ) {
                    alt139=1;
                }


                switch (alt139) {
            	case 1 :
            	    // InternalForml.g:7128:4: otherlv_1= ',' ( (lv_frag_2_0= ruleWCAFragment ) )
            	    {
            	    otherlv_1=(Token)match(input,45,FOLLOW_10); 

            	        	newLeafNode(otherlv_1, grammarAccess.getWCAFragmentListAccess().getCommaKeyword_1_0());
            	        
            	    // InternalForml.g:7132:1: ( (lv_frag_2_0= ruleWCAFragment ) )
            	    // InternalForml.g:7133:1: (lv_frag_2_0= ruleWCAFragment )
            	    {
            	    // InternalForml.g:7133:1: (lv_frag_2_0= ruleWCAFragment )
            	    // InternalForml.g:7134:3: lv_frag_2_0= ruleWCAFragment
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getWCAFragmentListAccess().getFragWCAFragmentParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_59);
            	    lv_frag_2_0=ruleWCAFragment();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getWCAFragmentListRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"frag",
            	            		lv_frag_2_0, 
            	            		"uw.cs.watform.forml.Forml.WCAFragment");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop139;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleWCAFragmentList"


    // $ANTLR start "entryRuleWCAFragment"
    // InternalForml.g:7158:1: entryRuleWCAFragment returns [EObject current=null] : iv_ruleWCAFragment= ruleWCAFragment EOF ;
    public final EObject entryRuleWCAFragment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWCAFragment = null;


        try {
            // InternalForml.g:7159:2: (iv_ruleWCAFragment= ruleWCAFragment EOF )
            // InternalForml.g:7160:2: iv_ruleWCAFragment= ruleWCAFragment EOF
            {
             newCompositeNode(grammarAccess.getWCAFragmentRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleWCAFragment=ruleWCAFragment();

            state._fsp--;

             current =iv_ruleWCAFragment; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleWCAFragment"


    // $ANTLR start "ruleWCAFragment"
    // InternalForml.g:7167:1: ruleWCAFragment returns [EObject current=null] : ( () ( ( ruleQualifiedName ) ) otherlv_2= ':' ( (lv_fragType_3_0= ruleGuard ) ) ) ;
    public final EObject ruleWCAFragment() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_fragType_3_0 = null;


         enterRule(); 
            
        try {
            // InternalForml.g:7170:28: ( ( () ( ( ruleQualifiedName ) ) otherlv_2= ':' ( (lv_fragType_3_0= ruleGuard ) ) ) )
            // InternalForml.g:7171:1: ( () ( ( ruleQualifiedName ) ) otherlv_2= ':' ( (lv_fragType_3_0= ruleGuard ) ) )
            {
            // InternalForml.g:7171:1: ( () ( ( ruleQualifiedName ) ) otherlv_2= ':' ( (lv_fragType_3_0= ruleGuard ) ) )
            // InternalForml.g:7171:2: () ( ( ruleQualifiedName ) ) otherlv_2= ':' ( (lv_fragType_3_0= ruleGuard ) )
            {
            // InternalForml.g:7171:2: ()
            // InternalForml.g:7172:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getWCAFragmentAccess().getWCAFragmentAction_0(),
                        current);
                

            }

            // InternalForml.g:7177:2: ( ( ruleQualifiedName ) )
            // InternalForml.g:7178:1: ( ruleQualifiedName )
            {
            // InternalForml.g:7178:1: ( ruleQualifiedName )
            // InternalForml.g:7179:3: ruleQualifiedName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getWCAFragmentRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getWCAFragmentAccess().getRefWCACrossReference_1_0()); 
            	    
            pushFollow(FOLLOW_22);
            ruleQualifiedName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,23,FOLLOW_96); 

                	newLeafNode(otherlv_2, grammarAccess.getWCAFragmentAccess().getColonKeyword_2());
                
            // InternalForml.g:7196:1: ( (lv_fragType_3_0= ruleGuard ) )
            // InternalForml.g:7197:1: (lv_fragType_3_0= ruleGuard )
            {
            // InternalForml.g:7197:1: (lv_fragType_3_0= ruleGuard )
            // InternalForml.g:7198:3: lv_fragType_3_0= ruleGuard
            {
             
            	        newCompositeNode(grammarAccess.getWCAFragmentAccess().getFragTypeGuardParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_2);
            lv_fragType_3_0=ruleGuard();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getWCAFragmentRule());
            	        }
                   		set(
                   			current, 
                   			"fragType",
                    		lv_fragType_3_0, 
                    		"uw.cs.watform.forml.Forml.Guard");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleWCAFragment"


    // $ANTLR start "entryRuleQualifiedName"
    // InternalForml.g:7222:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalForml.g:7223:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalForml.g:7224:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;

             current =iv_ruleQualifiedName.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // InternalForml.g:7231:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // InternalForml.g:7234:28: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalForml.g:7235:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalForml.g:7235:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalForml.g:7235:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_98); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
                
            // InternalForml.g:7242:1: (kw= '.' this_ID_2= RULE_ID )*
            loop140:
            do {
                int alt140=2;
                int LA140_0 = input.LA(1);

                if ( (LA140_0==106) ) {
                    alt140=1;
                }


                switch (alt140) {
            	case 1 :
            	    // InternalForml.g:7243:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,106,FOLLOW_10); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_98); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop140;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQualifiedName"

    // Delegated rules


    protected DFA4 dfa4 = new DFA4(this);
    protected DFA86 dfa86 = new DFA86(this);
    protected DFA109 dfa109 = new DFA109(this);
    protected DFA105 dfa105 = new DFA105(this);
    protected DFA108 dfa108 = new DFA108(this);
    protected DFA126 dfa126 = new DFA126(this);
    static final String dfa_1s = "\17\uffff";
    static final String dfa_2s = "\1\4\1\uffff\13\0\2\uffff";
    static final String dfa_3s = "\1\141\1\uffff\13\0\2\uffff";
    static final String dfa_4s = "\1\uffff\1\2\14\uffff\1\1";
    static final String dfa_5s = "\2\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\2\uffff}>";
    static final String[] dfa_6s = {
            "\1\11\1\13\7\uffff\1\1\65\uffff\1\14\6\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\uffff\1\7\16\uffff\1\12\1\10",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA4 extends DFA {

        public DFA4(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 4;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "()+ loopback of 286:6: ({...}? => ( (lv_predicates_4_0= rulePredicate ) ) )+";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA4_2 = input.LA(1);

                         
                        int index4_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((true)) ) {s = 14;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index4_2);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA4_3 = input.LA(1);

                         
                        int index4_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((true)) ) {s = 14;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index4_3);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA4_4 = input.LA(1);

                         
                        int index4_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((true)) ) {s = 14;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index4_4);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA4_5 = input.LA(1);

                         
                        int index4_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((true)) ) {s = 14;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index4_5);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA4_6 = input.LA(1);

                         
                        int index4_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((true)) ) {s = 14;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index4_6);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA4_7 = input.LA(1);

                         
                        int index4_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((true)) ) {s = 14;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index4_7);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA4_8 = input.LA(1);

                         
                        int index4_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((true)) ) {s = 14;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index4_8);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA4_9 = input.LA(1);

                         
                        int index4_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((true)) ) {s = 14;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index4_9);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA4_10 = input.LA(1);

                         
                        int index4_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((true)) ) {s = 14;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index4_10);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA4_11 = input.LA(1);

                         
                        int index4_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((true)) ) {s = 14;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index4_11);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA4_12 = input.LA(1);

                         
                        int index4_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((true)) ) {s = 14;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index4_12);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 4, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_7s = "\7\uffff";
    static final String dfa_8s = "\1\uffff\1\5\4\uffff\1\5";
    static final String dfa_9s = "\1\4\1\15\1\4\3\uffff\1\15";
    static final String dfa_10s = "\1\4\1\152\1\4\3\uffff\1\152";
    static final String dfa_11s = "\3\uffff\1\3\1\1\1\2\1\uffff";
    static final String dfa_12s = "\7\uffff}>";
    static final String[] dfa_13s = {
            "\1\1",
            "\1\5\7\uffff\1\5\52\uffff\1\5\4\uffff\1\4\1\3\1\5\42\uffff\1\2",
            "\1\6",
            "",
            "",
            "",
            "\1\5\7\uffff\1\5\52\uffff\1\5\4\uffff\1\4\1\3\1\5\42\uffff\1\2"
    };

    static final short[] dfa_7 = DFA.unpackEncodedString(dfa_7s);
    static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final short[][] dfa_13 = unpackEncodedStringArray(dfa_13s);

    class DFA86 extends DFA {

        public DFA86(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 86;
            this.eot = dfa_7;
            this.eof = dfa_8;
            this.min = dfa_9;
            this.max = dfa_10;
            this.accept = dfa_11;
            this.special = dfa_12;
            this.transition = dfa_13;
        }
        public String getDescription() {
            return "4156:1: ( ( ( ( ruleQualifiedName ) ) otherlv_1= '+' ) | ( ( ruleQualifiedName ) ) | ( ( ( ruleQualifiedName ) ) otherlv_4= '-' ) )";
        }
    }
    static final String dfa_14s = "\61\uffff";
    static final String dfa_15s = "\11\uffff\2\24\46\uffff";
    static final String dfa_16s = "\1\4\1\uffff\2\72\2\uffff\6\4\7\72\2\uffff\4\72\1\4\2\72\2\4\1\72\1\4\12\72\1\4\6\72";
    static final String dfa_17s = "\1\141\1\uffff\1\137\1\152\2\uffff\5\141\1\4\2\142\2\137\1\152\1\137\1\152\2\uffff\1\152\2\137\1\142\1\4\1\137\1\142\2\141\1\142\1\4\1\137\1\142\1\137\1\152\2\137\1\152\1\137\1\152\1\137\1\4\2\142\1\137\1\152\2\137";
    static final String dfa_18s = "\1\uffff\1\1\2\uffff\1\4\1\5\15\uffff\1\3\1\2\34\uffff";
    static final String dfa_19s = "\61\uffff}>";
    static final String[] dfa_20s = {
            "\1\3\1\4\75\uffff\1\5\7\uffff\5\1\20\uffff\1\4\1\2",
            "",
            "\1\12\12\uffff\1\7\1\6\17\uffff\1\11\10\uffff\1\10",
            "\1\12\12\uffff\1\7\1\6\17\uffff\1\11\10\uffff\1\10\2\uffff\1\16\1\14\1\15\5\uffff\1\13",
            "",
            "",
            "\1\20\134\uffff\1\17",
            "\1\20\134\uffff\1\17",
            "\1\22\134\uffff\1\21",
            "\2\24\7\uffff\1\24\10\uffff\1\24\54\uffff\2\24\5\uffff\6\24\1\uffff\5\24\7\uffff\2\23\1\uffff\2\24",
            "\2\24\7\uffff\1\24\10\uffff\1\24\54\uffff\2\24\5\uffff\6\24\1\uffff\5\24\7\uffff\2\23\1\uffff\2\24",
            "\1\25",
            "\1\12\12\uffff\1\7\1\6\17\uffff\1\11\10\uffff\1\10\2\uffff\1\26",
            "\1\12\12\uffff\1\7\1\6\17\uffff\1\11\10\uffff\1\10\2\uffff\1\27",
            "\1\12\12\uffff\1\7\1\6\17\uffff\1\11\10\uffff\1\10",
            "\1\12\12\uffff\1\7\1\6\17\uffff\1\11\10\uffff\1\10",
            "\1\12\12\uffff\1\7\1\6\17\uffff\1\11\10\uffff\1\10\2\uffff\1\32\1\33\1\30\5\uffff\1\31",
            "\1\12\12\uffff\1\35\1\34\17\uffff\1\11\10\uffff\1\10",
            "\1\12\12\uffff\1\35\1\34\17\uffff\1\11\10\uffff\1\10\2\uffff\1\40\1\41\1\36\5\uffff\1\37",
            "",
            "",
            "\1\12\12\uffff\1\7\1\6\17\uffff\1\11\10\uffff\1\10\2\uffff\1\16\1\14\6\uffff\1\13",
            "\1\12\12\uffff\1\7\1\6\17\uffff\1\11\10\uffff\1\10",
            "\1\12\12\uffff\1\7\1\6\17\uffff\1\11\10\uffff\1\10",
            "\1\12\12\uffff\1\7\1\6\17\uffff\1\11\10\uffff\1\10\2\uffff\1\42",
            "\1\43",
            "\1\12\12\uffff\1\7\1\6\17\uffff\1\11\10\uffff\1\10",
            "\1\12\12\uffff\1\7\1\6\17\uffff\1\11\10\uffff\1\10\2\uffff\1\44",
            "\1\46\134\uffff\1\45",
            "\1\46\134\uffff\1\45",
            "\1\12\12\uffff\1\35\1\34\17\uffff\1\11\10\uffff\1\10\2\uffff\1\47",
            "\1\50",
            "\1\12\12\uffff\1\35\1\34\17\uffff\1\11\10\uffff\1\10",
            "\1\12\12\uffff\1\35\1\34\17\uffff\1\11\10\uffff\1\10\2\uffff\1\51",
            "\1\12\12\uffff\1\7\1\6\17\uffff\1\11\10\uffff\1\10",
            "\1\12\12\uffff\1\7\1\6\17\uffff\1\11\10\uffff\1\10\2\uffff\1\32\1\33\6\uffff\1\31",
            "\1\12\12\uffff\1\7\1\6\17\uffff\1\11\10\uffff\1\10",
            "\1\12\12\uffff\1\35\1\34\17\uffff\1\11\10\uffff\1\10",
            "\1\12\12\uffff\1\35\1\34\17\uffff\1\11\10\uffff\1\10\2\uffff\1\55\1\53\1\54\5\uffff\1\52",
            "\1\12\12\uffff\1\35\1\34\17\uffff\1\11\10\uffff\1\10",
            "\1\12\12\uffff\1\35\1\34\17\uffff\1\11\10\uffff\1\10\2\uffff\1\40\1\41\6\uffff\1\37",
            "\1\12\12\uffff\1\35\1\34\17\uffff\1\11\10\uffff\1\10",
            "\1\56",
            "\1\12\12\uffff\1\35\1\34\17\uffff\1\11\10\uffff\1\10\2\uffff\1\57",
            "\1\12\12\uffff\1\35\1\34\17\uffff\1\11\10\uffff\1\10\2\uffff\1\60",
            "\1\12\12\uffff\1\35\1\34\17\uffff\1\11\10\uffff\1\10",
            "\1\12\12\uffff\1\35\1\34\17\uffff\1\11\10\uffff\1\10\2\uffff\1\55\1\53\6\uffff\1\52",
            "\1\12\12\uffff\1\35\1\34\17\uffff\1\11\10\uffff\1\10",
            "\1\12\12\uffff\1\35\1\34\17\uffff\1\11\10\uffff\1\10"
    };

    static final short[] dfa_14 = DFA.unpackEncodedString(dfa_14s);
    static final short[] dfa_15 = DFA.unpackEncodedString(dfa_15s);
    static final char[] dfa_16 = DFA.unpackEncodedStringToUnsignedChars(dfa_16s);
    static final char[] dfa_17 = DFA.unpackEncodedStringToUnsignedChars(dfa_17s);
    static final short[] dfa_18 = DFA.unpackEncodedString(dfa_18s);
    static final short[] dfa_19 = DFA.unpackEncodedString(dfa_19s);
    static final short[][] dfa_20 = unpackEncodedStringArray(dfa_20s);

    class DFA109 extends DFA {

        public DFA109(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 109;
            this.eot = dfa_14;
            this.eof = dfa_15;
            this.min = dfa_16;
            this.max = dfa_17;
            this.accept = dfa_18;
            this.special = dfa_19;
            this.transition = dfa_20;
        }
        public String getDescription() {
            return "5207:1: ( ( ( ( (lv_logicop_0_1= 'no' | lv_logicop_0_2= 'lone' | lv_logicop_0_3= 'one' | lv_logicop_0_4= 'some' | lv_logicop_0_5= 'all' ) ) ) ( (lv_cardpred_1_0= rulesetExpr ) ) ) | ( ( (lv_setlhs_2_0= rulepredExpr ) ) ( ( (lv_logicop_3_1= 'in' | lv_logicop_3_2= '=' ) ) ) ( (lv_setrhs_4_0= rulepredExpr ) )? ) | ( ( (lv_setlhs_5_0= rulepredExpr ) ) ( ( (lv_logicop_6_1= 'in' | lv_logicop_6_2= '=' ) ) ) ( (lv_boolrhs_7_0= ruleboolExpr ) ) ) | ( ( (lv_intlhs_8_0= ruleintExpr ) ) ( ( (lv_op_9_1= '=' | lv_op_9_2= '<>' | lv_op_9_3= '>' | lv_op_9_4= '<' | lv_op_9_5= '>=' | lv_op_9_6= '=>' | lv_op_9_7= '<=' | lv_op_9_8= '=<' ) ) ) ( (lv_intrhs_10_0= ruleintExpr ) )? ) | (otherlv_11= '(' ( (lv_parenPred_12_0= rulePredicate ) ) otherlv_13= ')' ) )";
        }
    }
    static final String dfa_21s = "\54\uffff";
    static final String dfa_22s = "\1\3\2\7\5\uffff\1\7\1\uffff\12\7\1\uffff\2\7\3\uffff\14\7\1\uffff\5\7";
    static final String dfa_23s = "\3\4\1\uffff\3\4\1\uffff\44\4";
    static final String dfa_24s = "\2\141\1\152\1\uffff\3\141\1\uffff\1\142\1\4\1\141\1\142\1\141\1\152\1\141\1\152\1\141\1\152\1\141\1\142\1\4\1\141\1\142\2\141\1\4\2\142\2\141\1\152\2\141\2\152\2\141\1\142\1\4\1\141\1\142\1\141\1\152\1\141";
    static final String dfa_25s = "\3\uffff\1\2\3\uffff\1\1\44\uffff";
    static final String dfa_26s = "\54\uffff}>";
    static final String[] dfa_27s = {
            "\1\2\1\3\7\uffff\1\3\10\uffff\1\3\54\uffff\2\3\5\uffff\6\3\1\uffff\5\3\12\uffff\1\3\1\1",
            "\2\7\7\uffff\1\7\10\uffff\1\7\43\uffff\1\3\10\uffff\2\7\1\5\1\4\3\uffff\6\7\1\uffff\5\7\1\3\10\uffff\1\6\2\7",
            "\2\7\7\uffff\1\7\10\uffff\1\7\43\uffff\1\3\10\uffff\2\7\1\5\1\4\3\uffff\6\7\1\uffff\5\7\1\3\10\uffff\1\6\2\7\1\12\1\13\1\10\5\uffff\1\11",
            "",
            "\1\15\134\uffff\1\14",
            "\1\15\134\uffff\1\14",
            "\1\17\134\uffff\1\16",
            "",
            "\2\7\7\uffff\1\7\10\uffff\1\7\43\uffff\1\3\10\uffff\2\7\1\5\1\4\3\uffff\6\7\1\uffff\5\7\1\3\10\uffff\1\6\2\7\1\20",
            "\1\21",
            "\2\7\7\uffff\1\7\10\uffff\1\7\43\uffff\1\3\10\uffff\2\7\1\5\1\4\3\uffff\6\7\1\uffff\5\7\1\3\10\uffff\1\6\2\7",
            "\2\7\7\uffff\1\7\10\uffff\1\7\43\uffff\1\3\10\uffff\2\7\1\5\1\4\3\uffff\6\7\1\uffff\5\7\1\3\10\uffff\1\6\2\7\1\22",
            "\2\7\7\uffff\1\7\10\uffff\1\7\43\uffff\1\3\10\uffff\2\7\1\5\1\4\3\uffff\6\7\1\uffff\5\7\1\3\10\uffff\1\6\2\7",
            "\2\7\7\uffff\1\7\10\uffff\1\7\43\uffff\1\3\10\uffff\2\7\1\5\1\4\3\uffff\6\7\1\uffff\5\7\1\3\10\uffff\1\6\2\7\1\25\1\26\1\23\5\uffff\1\24",
            "\2\7\7\uffff\1\7\10\uffff\1\7\43\uffff\1\3\10\uffff\2\7\1\30\1\27\3\uffff\6\7\1\uffff\5\7\1\3\10\uffff\1\6\2\7",
            "\2\7\7\uffff\1\7\10\uffff\1\7\43\uffff\1\3\10\uffff\2\7\1\30\1\27\3\uffff\6\7\1\uffff\5\7\1\3\10\uffff\1\6\2\7\1\34\1\32\1\33\5\uffff\1\31",
            "\2\7\7\uffff\1\7\10\uffff\1\7\43\uffff\1\3\10\uffff\2\7\1\5\1\4\3\uffff\6\7\1\uffff\5\7\1\3\10\uffff\1\6\2\7",
            "\2\7\7\uffff\1\7\10\uffff\1\7\43\uffff\1\3\10\uffff\2\7\1\5\1\4\3\uffff\6\7\1\uffff\5\7\1\3\10\uffff\1\6\2\7\1\12\1\13\6\uffff\1\11",
            "\2\7\7\uffff\1\7\10\uffff\1\7\43\uffff\1\3\10\uffff\2\7\1\5\1\4\3\uffff\6\7\1\uffff\5\7\1\3\10\uffff\1\6\2\7",
            "\2\7\7\uffff\1\7\10\uffff\1\7\43\uffff\1\3\10\uffff\2\7\1\5\1\4\3\uffff\6\7\1\uffff\5\7\1\3\10\uffff\1\6\2\7\1\35",
            "\1\36",
            "\2\7\7\uffff\1\7\10\uffff\1\7\43\uffff\1\3\10\uffff\2\7\1\5\1\4\3\uffff\6\7\1\uffff\5\7\1\3\10\uffff\1\6\2\7",
            "\2\7\7\uffff\1\7\10\uffff\1\7\43\uffff\1\3\10\uffff\2\7\1\5\1\4\3\uffff\6\7\1\uffff\5\7\1\3\10\uffff\1\6\2\7\1\37",
            "\1\41\134\uffff\1\40",
            "\1\41\134\uffff\1\40",
            "\1\42",
            "\2\7\7\uffff\1\7\10\uffff\1\7\43\uffff\1\3\10\uffff\2\7\1\30\1\27\3\uffff\6\7\1\uffff\5\7\1\3\10\uffff\1\6\2\7\1\43",
            "\2\7\7\uffff\1\7\10\uffff\1\7\43\uffff\1\3\10\uffff\2\7\1\30\1\27\3\uffff\6\7\1\uffff\5\7\1\3\10\uffff\1\6\2\7\1\44",
            "\2\7\7\uffff\1\7\10\uffff\1\7\43\uffff\1\3\10\uffff\2\7\1\30\1\27\3\uffff\6\7\1\uffff\5\7\1\3\10\uffff\1\6\2\7",
            "\2\7\7\uffff\1\7\10\uffff\1\7\43\uffff\1\3\10\uffff\2\7\1\5\1\4\3\uffff\6\7\1\uffff\5\7\1\3\10\uffff\1\6\2\7",
            "\2\7\7\uffff\1\7\10\uffff\1\7\43\uffff\1\3\10\uffff\2\7\1\5\1\4\3\uffff\6\7\1\uffff\5\7\1\3\10\uffff\1\6\2\7\1\25\1\26\6\uffff\1\24",
            "\2\7\7\uffff\1\7\10\uffff\1\7\43\uffff\1\3\10\uffff\2\7\1\5\1\4\3\uffff\6\7\1\uffff\5\7\1\3\10\uffff\1\6\2\7",
            "\2\7\7\uffff\1\7\10\uffff\1\7\43\uffff\1\3\10\uffff\2\7\1\30\1\27\3\uffff\6\7\1\uffff\5\7\1\3\10\uffff\1\6\2\7",
            "\2\7\7\uffff\1\7\10\uffff\1\7\43\uffff\1\3\10\uffff\2\7\1\30\1\27\3\uffff\6\7\1\uffff\5\7\1\3\10\uffff\1\6\2\7\1\47\1\50\1\45\5\uffff\1\46",
            "\2\7\7\uffff\1\7\10\uffff\1\7\43\uffff\1\3\10\uffff\2\7\1\30\1\27\3\uffff\6\7\1\uffff\5\7\1\3\10\uffff\1\6\2\7\1\34\1\32\6\uffff\1\31",
            "\2\7\7\uffff\1\7\10\uffff\1\7\43\uffff\1\3\10\uffff\2\7\1\30\1\27\3\uffff\6\7\1\uffff\5\7\1\3\10\uffff\1\6\2\7",
            "\2\7\7\uffff\1\7\10\uffff\1\7\43\uffff\1\3\10\uffff\2\7\1\30\1\27\3\uffff\6\7\1\uffff\5\7\1\3\10\uffff\1\6\2\7",
            "\2\7\7\uffff\1\7\10\uffff\1\7\43\uffff\1\3\10\uffff\2\7\1\30\1\27\3\uffff\6\7\1\uffff\5\7\1\3\10\uffff\1\6\2\7\1\51",
            "\1\52",
            "\2\7\7\uffff\1\7\10\uffff\1\7\43\uffff\1\3\10\uffff\2\7\1\30\1\27\3\uffff\6\7\1\uffff\5\7\1\3\10\uffff\1\6\2\7",
            "\2\7\7\uffff\1\7\10\uffff\1\7\43\uffff\1\3\10\uffff\2\7\1\30\1\27\3\uffff\6\7\1\uffff\5\7\1\3\10\uffff\1\6\2\7\1\53",
            "\2\7\7\uffff\1\7\10\uffff\1\7\43\uffff\1\3\10\uffff\2\7\1\30\1\27\3\uffff\6\7\1\uffff\5\7\1\3\10\uffff\1\6\2\7",
            "\2\7\7\uffff\1\7\10\uffff\1\7\43\uffff\1\3\10\uffff\2\7\1\30\1\27\3\uffff\6\7\1\uffff\5\7\1\3\10\uffff\1\6\2\7\1\47\1\50\6\uffff\1\46",
            "\2\7\7\uffff\1\7\10\uffff\1\7\43\uffff\1\3\10\uffff\2\7\1\30\1\27\3\uffff\6\7\1\uffff\5\7\1\3\10\uffff\1\6\2\7"
    };

    static final short[] dfa_21 = DFA.unpackEncodedString(dfa_21s);
    static final short[] dfa_22 = DFA.unpackEncodedString(dfa_22s);
    static final char[] dfa_23 = DFA.unpackEncodedStringToUnsignedChars(dfa_23s);
    static final char[] dfa_24 = DFA.unpackEncodedStringToUnsignedChars(dfa_24s);
    static final short[] dfa_25 = DFA.unpackEncodedString(dfa_25s);
    static final short[] dfa_26 = DFA.unpackEncodedString(dfa_26s);
    static final short[][] dfa_27 = unpackEncodedStringArray(dfa_27s);

    class DFA105 extends DFA {

        public DFA105(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 105;
            this.eot = dfa_21;
            this.eof = dfa_22;
            this.min = dfa_23;
            this.max = dfa_24;
            this.accept = dfa_25;
            this.special = dfa_26;
            this.transition = dfa_27;
        }
        public String getDescription() {
            return "5340:2: ( (lv_setrhs_4_0= rulepredExpr ) )?";
        }
    }
    static final String dfa_28s = "\55\uffff";
    static final String dfa_29s = "\1\3\1\uffff\1\12\1\uffff\2\12\6\uffff\2\12\1\uffff\1\12\1\uffff\7\12\3\uffff\2\12\1\uffff\2\12\1\uffff\7\12\1\uffff\4\12";
    static final String dfa_30s = "\3\4\1\uffff\2\4\4\5\1\uffff\15\4\2\5\23\4";
    static final String dfa_31s = "\3\141\1\uffff\1\141\1\152\4\140\1\uffff\1\4\1\141\1\142\4\141\1\152\2\141\1\152\1\141\1\152\2\140\1\4\1\141\1\142\1\4\1\141\1\142\2\141\1\152\1\141\1\152\2\141\1\152\1\4\1\141\1\142\1\152\1\141";
    static final String dfa_32s = "\3\uffff\1\2\6\uffff\1\1\42\uffff";
    static final String dfa_33s = "\55\uffff}>";
    static final String[] dfa_34s = {
            "\1\3\1\2\7\uffff\1\3\10\uffff\1\3\54\uffff\2\3\5\uffff\6\3\1\uffff\5\3\12\uffff\1\1\1\3",
            "\1\5\134\uffff\1\4",
            "\2\12\7\uffff\1\12\10\uffff\1\12\11\uffff\1\6\31\uffff\1\3\4\uffff\1\3\3\uffff\2\12\1\10\1\11\1\7\2\uffff\6\12\1\uffff\5\12\1\uffff\6\3\3\uffff\2\12",
            "",
            "\2\12\7\uffff\1\12\10\uffff\1\12\11\uffff\1\6\31\uffff\1\3\4\uffff\1\3\3\uffff\2\12\1\10\1\11\1\7\2\uffff\6\12\1\uffff\5\12\1\uffff\6\3\3\uffff\2\12",
            "\2\12\7\uffff\1\12\10\uffff\1\12\11\uffff\1\6\31\uffff\1\3\4\uffff\1\3\3\uffff\2\12\1\10\1\11\1\7\2\uffff\6\12\1\uffff\5\12\1\uffff\6\3\3\uffff\2\12\1\14\1\15\6\uffff\1\13",
            "\1\17\132\uffff\1\16",
            "\1\17\132\uffff\1\16",
            "\1\21\132\uffff\1\20",
            "\1\21\132\uffff\1\20",
            "",
            "\1\22",
            "\2\12\7\uffff\1\12\10\uffff\1\12\11\uffff\1\6\31\uffff\1\3\4\uffff\1\3\3\uffff\2\12\1\10\1\11\1\7\2\uffff\6\12\1\uffff\5\12\1\uffff\6\3\3\uffff\2\12",
            "\2\12\7\uffff\1\12\10\uffff\1\12\11\uffff\1\6\31\uffff\1\3\4\uffff\1\3\3\uffff\2\12\1\10\1\11\1\7\2\uffff\6\12\1\uffff\5\12\1\uffff\6\3\3\uffff\2\12\1\23",
            "\1\25\134\uffff\1\24",
            "\2\12\7\uffff\1\12\10\uffff\1\12\11\uffff\1\6\31\uffff\1\3\4\uffff\1\3\3\uffff\2\12\1\10\1\11\1\7\2\uffff\6\12\1\uffff\5\12\1\uffff\6\3\3\uffff\2\12",
            "\1\27\134\uffff\1\26",
            "\2\12\7\uffff\1\12\10\uffff\1\12\11\uffff\1\30\31\uffff\1\3\4\uffff\1\3\3\uffff\2\12\1\10\1\11\1\31\2\uffff\6\12\1\uffff\5\12\1\uffff\6\3\3\uffff\2\12",
            "\2\12\7\uffff\1\12\10\uffff\1\12\11\uffff\1\6\31\uffff\1\3\4\uffff\1\3\3\uffff\2\12\1\10\1\11\1\7\2\uffff\6\12\1\uffff\5\12\1\uffff\6\3\3\uffff\2\12\1\14\1\15\6\uffff\1\13",
            "\2\12\7\uffff\1\12\10\uffff\1\12\11\uffff\1\6\31\uffff\1\3\4\uffff\1\3\3\uffff\2\12\1\10\1\11\1\7\2\uffff\6\12\1\uffff\5\12\1\uffff\6\3\3\uffff\2\12",
            "\2\12\7\uffff\1\12\10\uffff\1\12\11\uffff\1\6\31\uffff\1\3\4\uffff\1\3\3\uffff\2\12\1\10\1\11\1\7\2\uffff\6\12\1\uffff\5\12\1\uffff\6\3\3\uffff\2\12",
            "\2\12\7\uffff\1\12\10\uffff\1\12\11\uffff\1\6\31\uffff\1\3\4\uffff\1\3\3\uffff\2\12\1\10\1\11\1\7\2\uffff\6\12\1\uffff\5\12\1\uffff\6\3\3\uffff\2\12\1\33\1\34\6\uffff\1\32",
            "\2\12\7\uffff\1\12\10\uffff\1\12\11\uffff\1\30\31\uffff\1\3\4\uffff\1\3\3\uffff\2\12\1\10\1\11\1\31\2\uffff\6\12\1\uffff\5\12\1\uffff\6\3\3\uffff\2\12",
            "\2\12\7\uffff\1\12\10\uffff\1\12\11\uffff\1\30\31\uffff\1\3\4\uffff\1\3\3\uffff\2\12\1\10\1\11\1\31\2\uffff\6\12\1\uffff\5\12\1\uffff\6\3\3\uffff\2\12\1\36\1\37\6\uffff\1\35",
            "\1\41\132\uffff\1\40",
            "\1\41\132\uffff\1\40",
            "\1\42",
            "\2\12\7\uffff\1\12\10\uffff\1\12\11\uffff\1\6\31\uffff\1\3\4\uffff\1\3\3\uffff\2\12\1\10\1\11\1\7\2\uffff\6\12\1\uffff\5\12\1\uffff\6\3\3\uffff\2\12",
            "\2\12\7\uffff\1\12\10\uffff\1\12\11\uffff\1\6\31\uffff\1\3\4\uffff\1\3\3\uffff\2\12\1\10\1\11\1\7\2\uffff\6\12\1\uffff\5\12\1\uffff\6\3\3\uffff\2\12\1\43",
            "\1\44",
            "\2\12\7\uffff\1\12\10\uffff\1\12\11\uffff\1\30\31\uffff\1\3\4\uffff\1\3\3\uffff\2\12\1\10\1\11\1\31\2\uffff\6\12\1\uffff\5\12\1\uffff\6\3\3\uffff\2\12",
            "\2\12\7\uffff\1\12\10\uffff\1\12\11\uffff\1\30\31\uffff\1\3\4\uffff\1\3\3\uffff\2\12\1\10\1\11\1\31\2\uffff\6\12\1\uffff\5\12\1\uffff\6\3\3\uffff\2\12\1\45",
            "\1\47\134\uffff\1\46",
            "\2\12\7\uffff\1\12\10\uffff\1\12\11\uffff\1\30\31\uffff\1\3\4\uffff\1\3\3\uffff\2\12\1\10\1\11\1\31\2\uffff\6\12\1\uffff\5\12\1\uffff\6\3\3\uffff\2\12",
            "\2\12\7\uffff\1\12\10\uffff\1\12\11\uffff\1\6\31\uffff\1\3\4\uffff\1\3\3\uffff\2\12\1\10\1\11\1\7\2\uffff\6\12\1\uffff\5\12\1\uffff\6\3\3\uffff\2\12\1\33\1\34\6\uffff\1\32",
            "\2\12\7\uffff\1\12\10\uffff\1\12\11\uffff\1\6\31\uffff\1\3\4\uffff\1\3\3\uffff\2\12\1\10\1\11\1\7\2\uffff\6\12\1\uffff\5\12\1\uffff\6\3\3\uffff\2\12",
            "\2\12\7\uffff\1\12\10\uffff\1\12\11\uffff\1\30\31\uffff\1\3\4\uffff\1\3\3\uffff\2\12\1\10\1\11\1\31\2\uffff\6\12\1\uffff\5\12\1\uffff\6\3\3\uffff\2\12\1\36\1\37\6\uffff\1\35",
            "\2\12\7\uffff\1\12\10\uffff\1\12\11\uffff\1\30\31\uffff\1\3\4\uffff\1\3\3\uffff\2\12\1\10\1\11\1\31\2\uffff\6\12\1\uffff\5\12\1\uffff\6\3\3\uffff\2\12",
            "\2\12\7\uffff\1\12\10\uffff\1\12\11\uffff\1\30\31\uffff\1\3\4\uffff\1\3\3\uffff\2\12\1\10\1\11\1\31\2\uffff\6\12\1\uffff\5\12\1\uffff\6\3\3\uffff\2\12",
            "\2\12\7\uffff\1\12\10\uffff\1\12\11\uffff\1\30\31\uffff\1\3\4\uffff\1\3\3\uffff\2\12\1\10\1\11\1\31\2\uffff\6\12\1\uffff\5\12\1\uffff\6\3\3\uffff\2\12\1\51\1\52\6\uffff\1\50",
            "\1\53",
            "\2\12\7\uffff\1\12\10\uffff\1\12\11\uffff\1\30\31\uffff\1\3\4\uffff\1\3\3\uffff\2\12\1\10\1\11\1\31\2\uffff\6\12\1\uffff\5\12\1\uffff\6\3\3\uffff\2\12",
            "\2\12\7\uffff\1\12\10\uffff\1\12\11\uffff\1\30\31\uffff\1\3\4\uffff\1\3\3\uffff\2\12\1\10\1\11\1\31\2\uffff\6\12\1\uffff\5\12\1\uffff\6\3\3\uffff\2\12\1\54",
            "\2\12\7\uffff\1\12\10\uffff\1\12\11\uffff\1\30\31\uffff\1\3\4\uffff\1\3\3\uffff\2\12\1\10\1\11\1\31\2\uffff\6\12\1\uffff\5\12\1\uffff\6\3\3\uffff\2\12\1\51\1\52\6\uffff\1\50",
            "\2\12\7\uffff\1\12\10\uffff\1\12\11\uffff\1\30\31\uffff\1\3\4\uffff\1\3\3\uffff\2\12\1\10\1\11\1\31\2\uffff\6\12\1\uffff\5\12\1\uffff\6\3\3\uffff\2\12"
    };

    static final short[] dfa_28 = DFA.unpackEncodedString(dfa_28s);
    static final short[] dfa_29 = DFA.unpackEncodedString(dfa_29s);
    static final char[] dfa_30 = DFA.unpackEncodedStringToUnsignedChars(dfa_30s);
    static final char[] dfa_31 = DFA.unpackEncodedStringToUnsignedChars(dfa_31s);
    static final short[] dfa_32 = DFA.unpackEncodedString(dfa_32s);
    static final short[] dfa_33 = DFA.unpackEncodedString(dfa_33s);
    static final short[][] dfa_34 = unpackEncodedStringArray(dfa_34s);

    class DFA108 extends DFA {

        public DFA108(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 108;
            this.eot = dfa_28;
            this.eof = dfa_29;
            this.min = dfa_30;
            this.max = dfa_31;
            this.accept = dfa_32;
            this.special = dfa_33;
            this.transition = dfa_34;
        }
        public String getDescription() {
            return "5546:2: ( (lv_intrhs_10_0= ruleintExpr ) )?";
        }
    }
    static final String dfa_35s = "\2\uffff\1\4\3\uffff\1\4";
    static final String dfa_36s = "\1\4\1\uffff\2\4\2\uffff\1\4";
    static final String dfa_37s = "\1\141\1\uffff\1\152\1\4\2\uffff\1\152";
    static final String dfa_38s = "\1\uffff\1\1\2\uffff\1\2\1\3\1\uffff";
    static final String[] dfa_39s = {
            "\1\2\134\uffff\1\1",
            "",
            "\2\4\7\uffff\1\4\10\uffff\1\4\11\uffff\1\4\14\uffff\1\4\14\uffff\1\4\4\uffff\1\4\3\uffff\5\4\1\uffff\24\4\2\uffff\4\4\1\5\6\uffff\1\3",
            "\1\6",
            "",
            "",
            "\2\4\7\uffff\1\4\10\uffff\1\4\11\uffff\1\4\14\uffff\1\4\14\uffff\1\4\4\uffff\1\4\3\uffff\5\4\1\uffff\24\4\2\uffff\4\4\1\5\6\uffff\1\3"
    };
    static final short[] dfa_35 = DFA.unpackEncodedString(dfa_35s);
    static final char[] dfa_36 = DFA.unpackEncodedStringToUnsignedChars(dfa_36s);
    static final char[] dfa_37 = DFA.unpackEncodedStringToUnsignedChars(dfa_37s);
    static final short[] dfa_38 = DFA.unpackEncodedString(dfa_38s);
    static final short[][] dfa_39 = unpackEncodedStringArray(dfa_39s);

    class DFA126 extends DFA {

        public DFA126(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 126;
            this.eot = dfa_7;
            this.eof = dfa_35;
            this.min = dfa_36;
            this.max = dfa_37;
            this.accept = dfa_38;
            this.special = dfa_12;
            this.transition = dfa_39;
        }
        public String getDescription() {
            return "6359:1: ( ( (lv_none_0_0= 'none' ) ) | ( ( ( ruleQualifiedName ) ) (otherlv_2= '@pre' )? ) | ( ( ( ruleQualifiedName ) ) otherlv_4= 's' (otherlv_5= '@pre' )? ) )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0040000000000802L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x002184C8800BE000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000002030L,0x000000030002FC08L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000041002L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000004112000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000004002000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000400110000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000400112000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000A00000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000100000020L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x002184C8FB0B8012L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000003000000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000003000002000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000030000112000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x002184C8FB0B8010L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000020000112000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000002010L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000090000112000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000080000112000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000200000002000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000500000112000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000400000002000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x001E000000002000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x000E000000002000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x000C000000002000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0008000000002000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0010000000002000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000000201002L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0080000000002000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0100000000006000L,0x0000002000000000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x3000000000000000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x3000000000002000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x1000000000002000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0A00000000002000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0800000000002000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x8000000000800000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000000000202000L,0x0000000000000083L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000000202000L,0x0000000000000081L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000000000002000L,0x0000000000000080L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000000000400030L,0x000000030002F808L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000000000000012L,0x0000000000000004L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0000000000002030L,0x0000000300000368L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0000000000000010L,0x0000000200000008L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0000000000000012L,0x0000000200000008L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0000000000000020L,0x0000000100000000L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x0000000000000030L,0x0000000300000008L});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x0000000000000030L,0x000000030002F808L});
    public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x0000000000000002L,0x0000000000040000L});
    public static final BitSet FOLLOW_75 = new BitSet(new long[]{0x0000000000000002L,0x0000000000180000L});
    public static final BitSet FOLLOW_76 = new BitSet(new long[]{0x0000000000000002L,0x0000000000200000L});
    public static final BitSet FOLLOW_77 = new BitSet(new long[]{0x0400000000000000L,0x0000000000400000L});
    public static final BitSet FOLLOW_78 = new BitSet(new long[]{0x0000000000000012L,0x0000000200000000L});
    public static final BitSet FOLLOW_79 = new BitSet(new long[]{0x0000000000000000L,0x0000000060000000L});
    public static final BitSet FOLLOW_80 = new BitSet(new long[]{0x8400000000000000L,0x000000001F800000L});
    public static final BitSet FOLLOW_81 = new BitSet(new long[]{0x0000000000000022L,0x0000000100000000L});
    public static final BitSet FOLLOW_82 = new BitSet(new long[]{0x0000000000000002L,0x0000000080000000L});
    public static final BitSet FOLLOW_83 = new BitSet(new long[]{0x0000000000000010L,0x0000000200000000L});
    public static final BitSet FOLLOW_84 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000060L});
    public static final BitSet FOLLOW_85 = new BitSet(new long[]{0x0000000100000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_86 = new BitSet(new long[]{0x0000000000000002L,0x0000000400000000L});
    public static final BitSet FOLLOW_87 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_88 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_89 = new BitSet(new long[]{0x3000000000002000L,0x000003C000000000L});
    public static final BitSet FOLLOW_90 = new BitSet(new long[]{0x3000000000000002L,0x000003C000000000L});
    public static final BitSet FOLLOW_91 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_92 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_93 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_94 = new BitSet(new long[]{0x0800000000000002L});
    public static final BitSet FOLLOW_95 = new BitSet(new long[]{0x0000000000200000L,0x0000000000000003L});
    public static final BitSet FOLLOW_96 = new BitSet(new long[]{0x0000000000200000L,0x0000000000000001L});
    public static final BitSet FOLLOW_97 = new BitSet(new long[]{0x0000000000002010L,0x0000000000000080L});
    public static final BitSet FOLLOW_98 = new BitSet(new long[]{0x0000000000000002L,0x0000040000000000L});

}
