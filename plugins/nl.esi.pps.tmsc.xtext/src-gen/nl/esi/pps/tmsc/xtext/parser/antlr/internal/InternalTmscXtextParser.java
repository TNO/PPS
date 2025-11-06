package nl.esi.pps.tmsc.xtext.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import nl.esi.pps.tmsc.xtext.services.TmscXtextGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalTmscXtextParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ABS_EBIGDECIMAL", "RULE_ID", "RULE_ISO8601", "RULE_POS_EBIGDECIMAL", "RULE_STRING", "RULE_NEG_EBIGDECIMAL", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "'tmsc'", "'settings'", "'{'", "'architecture'", "':'", "'time-bound'", "'scheduled'", "'}'", "'analyses'", "'time-bound-analysis'", "'defaultTimeBound'", "'interface'", "'as'", "'operation'", "'component'", "'provides'", "','", "'requires'", "'ipc-client'", "'ipc-server'", "'function'", "'('", "')'", "'implements'", "'untraced'", "'host'", "'executor'", "'!'", "'?'", "'request'", "'message'", "'prefix'", "'['", "']'", "'.'", "'true'", "'false'", "'internal'", "'external'", "'in'", "'out'", "'inout'", "'return'", "'>'", "'<'", "'reply'", "'domain-dependency'", "'lifeline-segment'", "'message-control'"
    };
    public static final int T__50=50;
    public static final int RULE_NEG_EBIGDECIMAL=9;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__59=59;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int RULE_ABS_EBIGDECIMAL=4;
    public static final int T__18=18;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__13=13;
    public static final int T__57=57;
    public static final int T__14=14;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=5;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=10;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int RULE_ISO8601=6;
    public static final int RULE_POS_EBIGDECIMAL=7;
    public static final int RULE_STRING=8;
    public static final int RULE_SL_COMMENT=11;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_WS=12;
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

    // delegates
    // delegators


        public InternalTmscXtextParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalTmscXtextParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalTmscXtextParser.tokenNames; }
    public String getGrammarFileName() { return "InternalTmscXtext.g"; }



     	private TmscXtextGrammarAccess grammarAccess;

        public InternalTmscXtextParser(TokenStream input, TmscXtextGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "TmscXtextModel";
       	}

       	@Override
       	protected TmscXtextGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleTmscXtextModel"
    // InternalTmscXtext.g:65:1: entryRuleTmscXtextModel returns [EObject current=null] : iv_ruleTmscXtextModel= ruleTmscXtextModel EOF ;
    public final EObject entryRuleTmscXtextModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTmscXtextModel = null;


        try {
            // InternalTmscXtext.g:65:55: (iv_ruleTmscXtextModel= ruleTmscXtextModel EOF )
            // InternalTmscXtext.g:66:2: iv_ruleTmscXtextModel= ruleTmscXtextModel EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTmscXtextModelRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleTmscXtextModel=ruleTmscXtextModel();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTmscXtextModel; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleTmscXtextModel"


    // $ANTLR start "ruleTmscXtextModel"
    // InternalTmscXtext.g:72:1: ruleTmscXtextModel returns [EObject current=null] : ( () ( (otherlv_1= 'tmsc' otherlv_2= 'settings' otherlv_3= '{' ( (otherlv_4= 'architecture' otherlv_5= ':' ( (lv_architectureKind_6_0= ruleXArchitectureKind ) ) ) | (otherlv_7= 'time-bound' otherlv_8= ':' ( (lv_timeBound_9_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_10= 'scheduled' otherlv_11= ':' ( (lv_scheduled_12_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_13_0= ruleXProperty ) ) )* otherlv_14= '}' ) | (otherlv_15= 'tmsc' otherlv_16= 'analyses' otherlv_17= '{' ( (lv_analyses_18_0= ruleXTmscAnalysis ) )* otherlv_19= '}' ) | ( (lv_dependencySettings_20_0= ruleXDependencySettings ) ) | ( (lv_interfaces_21_0= ruleXInterface ) ) | ( (lv_components_22_0= ruleXComponent ) ) | ( (lv_functions_23_0= ruleXFunction ) ) | ( (lv_hosts_24_0= ruleXHost ) ) | ( (lv_executors_25_0= ruleXExecutor ) ) | ( (lv_events_26_0= ruleXEvent ) ) )* ) ;
    public final EObject ruleTmscXtextModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token lv_timeBound_9_0=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token otherlv_19=null;
        Enumerator lv_architectureKind_6_0 = null;

        AntlrDatatypeRuleToken lv_scheduled_12_0 = null;

        EObject lv_properties_13_0 = null;

        EObject lv_analyses_18_0 = null;

        EObject lv_dependencySettings_20_0 = null;

        EObject lv_interfaces_21_0 = null;

        EObject lv_components_22_0 = null;

        EObject lv_functions_23_0 = null;

        EObject lv_hosts_24_0 = null;

        EObject lv_executors_25_0 = null;

        EObject lv_events_26_0 = null;



        	enterRule();

        try {
            // InternalTmscXtext.g:78:2: ( ( () ( (otherlv_1= 'tmsc' otherlv_2= 'settings' otherlv_3= '{' ( (otherlv_4= 'architecture' otherlv_5= ':' ( (lv_architectureKind_6_0= ruleXArchitectureKind ) ) ) | (otherlv_7= 'time-bound' otherlv_8= ':' ( (lv_timeBound_9_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_10= 'scheduled' otherlv_11= ':' ( (lv_scheduled_12_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_13_0= ruleXProperty ) ) )* otherlv_14= '}' ) | (otherlv_15= 'tmsc' otherlv_16= 'analyses' otherlv_17= '{' ( (lv_analyses_18_0= ruleXTmscAnalysis ) )* otherlv_19= '}' ) | ( (lv_dependencySettings_20_0= ruleXDependencySettings ) ) | ( (lv_interfaces_21_0= ruleXInterface ) ) | ( (lv_components_22_0= ruleXComponent ) ) | ( (lv_functions_23_0= ruleXFunction ) ) | ( (lv_hosts_24_0= ruleXHost ) ) | ( (lv_executors_25_0= ruleXExecutor ) ) | ( (lv_events_26_0= ruleXEvent ) ) )* ) )
            // InternalTmscXtext.g:79:2: ( () ( (otherlv_1= 'tmsc' otherlv_2= 'settings' otherlv_3= '{' ( (otherlv_4= 'architecture' otherlv_5= ':' ( (lv_architectureKind_6_0= ruleXArchitectureKind ) ) ) | (otherlv_7= 'time-bound' otherlv_8= ':' ( (lv_timeBound_9_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_10= 'scheduled' otherlv_11= ':' ( (lv_scheduled_12_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_13_0= ruleXProperty ) ) )* otherlv_14= '}' ) | (otherlv_15= 'tmsc' otherlv_16= 'analyses' otherlv_17= '{' ( (lv_analyses_18_0= ruleXTmscAnalysis ) )* otherlv_19= '}' ) | ( (lv_dependencySettings_20_0= ruleXDependencySettings ) ) | ( (lv_interfaces_21_0= ruleXInterface ) ) | ( (lv_components_22_0= ruleXComponent ) ) | ( (lv_functions_23_0= ruleXFunction ) ) | ( (lv_hosts_24_0= ruleXHost ) ) | ( (lv_executors_25_0= ruleXExecutor ) ) | ( (lv_events_26_0= ruleXEvent ) ) )* )
            {
            // InternalTmscXtext.g:79:2: ( () ( (otherlv_1= 'tmsc' otherlv_2= 'settings' otherlv_3= '{' ( (otherlv_4= 'architecture' otherlv_5= ':' ( (lv_architectureKind_6_0= ruleXArchitectureKind ) ) ) | (otherlv_7= 'time-bound' otherlv_8= ':' ( (lv_timeBound_9_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_10= 'scheduled' otherlv_11= ':' ( (lv_scheduled_12_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_13_0= ruleXProperty ) ) )* otherlv_14= '}' ) | (otherlv_15= 'tmsc' otherlv_16= 'analyses' otherlv_17= '{' ( (lv_analyses_18_0= ruleXTmscAnalysis ) )* otherlv_19= '}' ) | ( (lv_dependencySettings_20_0= ruleXDependencySettings ) ) | ( (lv_interfaces_21_0= ruleXInterface ) ) | ( (lv_components_22_0= ruleXComponent ) ) | ( (lv_functions_23_0= ruleXFunction ) ) | ( (lv_hosts_24_0= ruleXHost ) ) | ( (lv_executors_25_0= ruleXExecutor ) ) | ( (lv_events_26_0= ruleXEvent ) ) )* )
            // InternalTmscXtext.g:80:3: () ( (otherlv_1= 'tmsc' otherlv_2= 'settings' otherlv_3= '{' ( (otherlv_4= 'architecture' otherlv_5= ':' ( (lv_architectureKind_6_0= ruleXArchitectureKind ) ) ) | (otherlv_7= 'time-bound' otherlv_8= ':' ( (lv_timeBound_9_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_10= 'scheduled' otherlv_11= ':' ( (lv_scheduled_12_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_13_0= ruleXProperty ) ) )* otherlv_14= '}' ) | (otherlv_15= 'tmsc' otherlv_16= 'analyses' otherlv_17= '{' ( (lv_analyses_18_0= ruleXTmscAnalysis ) )* otherlv_19= '}' ) | ( (lv_dependencySettings_20_0= ruleXDependencySettings ) ) | ( (lv_interfaces_21_0= ruleXInterface ) ) | ( (lv_components_22_0= ruleXComponent ) ) | ( (lv_functions_23_0= ruleXFunction ) ) | ( (lv_hosts_24_0= ruleXHost ) ) | ( (lv_executors_25_0= ruleXExecutor ) ) | ( (lv_events_26_0= ruleXEvent ) ) )*
            {
            // InternalTmscXtext.g:80:3: ()
            // InternalTmscXtext.g:81:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getTmscXtextModelAccess().getTmscXtextModelAction_0(),
              					current);
              			
            }

            }

            // InternalTmscXtext.g:87:3: ( (otherlv_1= 'tmsc' otherlv_2= 'settings' otherlv_3= '{' ( (otherlv_4= 'architecture' otherlv_5= ':' ( (lv_architectureKind_6_0= ruleXArchitectureKind ) ) ) | (otherlv_7= 'time-bound' otherlv_8= ':' ( (lv_timeBound_9_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_10= 'scheduled' otherlv_11= ':' ( (lv_scheduled_12_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_13_0= ruleXProperty ) ) )* otherlv_14= '}' ) | (otherlv_15= 'tmsc' otherlv_16= 'analyses' otherlv_17= '{' ( (lv_analyses_18_0= ruleXTmscAnalysis ) )* otherlv_19= '}' ) | ( (lv_dependencySettings_20_0= ruleXDependencySettings ) ) | ( (lv_interfaces_21_0= ruleXInterface ) ) | ( (lv_components_22_0= ruleXComponent ) ) | ( (lv_functions_23_0= ruleXFunction ) ) | ( (lv_hosts_24_0= ruleXHost ) ) | ( (lv_executors_25_0= ruleXExecutor ) ) | ( (lv_events_26_0= ruleXEvent ) ) )*
            loop3:
            do {
                int alt3=10;
                alt3 = dfa3.predict(input);
                switch (alt3) {
            	case 1 :
            	    // InternalTmscXtext.g:88:4: (otherlv_1= 'tmsc' otherlv_2= 'settings' otherlv_3= '{' ( (otherlv_4= 'architecture' otherlv_5= ':' ( (lv_architectureKind_6_0= ruleXArchitectureKind ) ) ) | (otherlv_7= 'time-bound' otherlv_8= ':' ( (lv_timeBound_9_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_10= 'scheduled' otherlv_11= ':' ( (lv_scheduled_12_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_13_0= ruleXProperty ) ) )* otherlv_14= '}' )
            	    {
            	    // InternalTmscXtext.g:88:4: (otherlv_1= 'tmsc' otherlv_2= 'settings' otherlv_3= '{' ( (otherlv_4= 'architecture' otherlv_5= ':' ( (lv_architectureKind_6_0= ruleXArchitectureKind ) ) ) | (otherlv_7= 'time-bound' otherlv_8= ':' ( (lv_timeBound_9_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_10= 'scheduled' otherlv_11= ':' ( (lv_scheduled_12_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_13_0= ruleXProperty ) ) )* otherlv_14= '}' )
            	    // InternalTmscXtext.g:89:5: otherlv_1= 'tmsc' otherlv_2= 'settings' otherlv_3= '{' ( (otherlv_4= 'architecture' otherlv_5= ':' ( (lv_architectureKind_6_0= ruleXArchitectureKind ) ) ) | (otherlv_7= 'time-bound' otherlv_8= ':' ( (lv_timeBound_9_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_10= 'scheduled' otherlv_11= ':' ( (lv_scheduled_12_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_13_0= ruleXProperty ) ) )* otherlv_14= '}'
            	    {
            	    otherlv_1=(Token)match(input,13,FOLLOW_3); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_1, grammarAccess.getTmscXtextModelAccess().getTmscKeyword_1_0_0());
            	      				
            	    }
            	    otherlv_2=(Token)match(input,14,FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_2, grammarAccess.getTmscXtextModelAccess().getSettingsKeyword_1_0_1());
            	      				
            	    }
            	    otherlv_3=(Token)match(input,15,FOLLOW_5); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_3, grammarAccess.getTmscXtextModelAccess().getLeftCurlyBracketKeyword_1_0_2());
            	      				
            	    }
            	    // InternalTmscXtext.g:101:5: ( (otherlv_4= 'architecture' otherlv_5= ':' ( (lv_architectureKind_6_0= ruleXArchitectureKind ) ) ) | (otherlv_7= 'time-bound' otherlv_8= ':' ( (lv_timeBound_9_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_10= 'scheduled' otherlv_11= ':' ( (lv_scheduled_12_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_13_0= ruleXProperty ) ) )*
            	    loop1:
            	    do {
            	        int alt1=5;
            	        switch ( input.LA(1) ) {
            	        case 16:
            	            {
            	            alt1=1;
            	            }
            	            break;
            	        case 18:
            	            {
            	            alt1=2;
            	            }
            	            break;
            	        case 19:
            	            {
            	            alt1=3;
            	            }
            	            break;
            	        case RULE_ID:
            	        case RULE_STRING:
            	            {
            	            alt1=4;
            	            }
            	            break;

            	        }

            	        switch (alt1) {
            	    	case 1 :
            	    	    // InternalTmscXtext.g:102:6: (otherlv_4= 'architecture' otherlv_5= ':' ( (lv_architectureKind_6_0= ruleXArchitectureKind ) ) )
            	    	    {
            	    	    // InternalTmscXtext.g:102:6: (otherlv_4= 'architecture' otherlv_5= ':' ( (lv_architectureKind_6_0= ruleXArchitectureKind ) ) )
            	    	    // InternalTmscXtext.g:103:7: otherlv_4= 'architecture' otherlv_5= ':' ( (lv_architectureKind_6_0= ruleXArchitectureKind ) )
            	    	    {
            	    	    otherlv_4=(Token)match(input,16,FOLLOW_6); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      							newLeafNode(otherlv_4, grammarAccess.getTmscXtextModelAccess().getArchitectureKeyword_1_0_3_0_0());
            	    	      						
            	    	    }
            	    	    otherlv_5=(Token)match(input,17,FOLLOW_7); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      							newLeafNode(otherlv_5, grammarAccess.getTmscXtextModelAccess().getColonKeyword_1_0_3_0_1());
            	    	      						
            	    	    }
            	    	    // InternalTmscXtext.g:111:7: ( (lv_architectureKind_6_0= ruleXArchitectureKind ) )
            	    	    // InternalTmscXtext.g:112:8: (lv_architectureKind_6_0= ruleXArchitectureKind )
            	    	    {
            	    	    // InternalTmscXtext.g:112:8: (lv_architectureKind_6_0= ruleXArchitectureKind )
            	    	    // InternalTmscXtext.g:113:9: lv_architectureKind_6_0= ruleXArchitectureKind
            	    	    {
            	    	    if ( state.backtracking==0 ) {

            	    	      									newCompositeNode(grammarAccess.getTmscXtextModelAccess().getArchitectureKindXArchitectureKindEnumRuleCall_1_0_3_0_2_0());
            	    	      								
            	    	    }
            	    	    pushFollow(FOLLOW_5);
            	    	    lv_architectureKind_6_0=ruleXArchitectureKind();

            	    	    state._fsp--;
            	    	    if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      									if (current==null) {
            	    	      										current = createModelElementForParent(grammarAccess.getTmscXtextModelRule());
            	    	      									}
            	    	      									set(
            	    	      										current,
            	    	      										"architectureKind",
            	    	      										lv_architectureKind_6_0,
            	    	      										"nl.esi.pps.tmsc.xtext.TmscXtext.XArchitectureKind");
            	    	      									afterParserOrEnumRuleCall();
            	    	      								
            	    	    }

            	    	    }


            	    	    }


            	    	    }


            	    	    }
            	    	    break;
            	    	case 2 :
            	    	    // InternalTmscXtext.g:132:6: (otherlv_7= 'time-bound' otherlv_8= ':' ( (lv_timeBound_9_0= RULE_ABS_EBIGDECIMAL ) ) )
            	    	    {
            	    	    // InternalTmscXtext.g:132:6: (otherlv_7= 'time-bound' otherlv_8= ':' ( (lv_timeBound_9_0= RULE_ABS_EBIGDECIMAL ) ) )
            	    	    // InternalTmscXtext.g:133:7: otherlv_7= 'time-bound' otherlv_8= ':' ( (lv_timeBound_9_0= RULE_ABS_EBIGDECIMAL ) )
            	    	    {
            	    	    otherlv_7=(Token)match(input,18,FOLLOW_6); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      							newLeafNode(otherlv_7, grammarAccess.getTmscXtextModelAccess().getTimeBoundKeyword_1_0_3_1_0());
            	    	      						
            	    	    }
            	    	    otherlv_8=(Token)match(input,17,FOLLOW_8); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      							newLeafNode(otherlv_8, grammarAccess.getTmscXtextModelAccess().getColonKeyword_1_0_3_1_1());
            	    	      						
            	    	    }
            	    	    // InternalTmscXtext.g:141:7: ( (lv_timeBound_9_0= RULE_ABS_EBIGDECIMAL ) )
            	    	    // InternalTmscXtext.g:142:8: (lv_timeBound_9_0= RULE_ABS_EBIGDECIMAL )
            	    	    {
            	    	    // InternalTmscXtext.g:142:8: (lv_timeBound_9_0= RULE_ABS_EBIGDECIMAL )
            	    	    // InternalTmscXtext.g:143:9: lv_timeBound_9_0= RULE_ABS_EBIGDECIMAL
            	    	    {
            	    	    lv_timeBound_9_0=(Token)match(input,RULE_ABS_EBIGDECIMAL,FOLLOW_5); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      									newLeafNode(lv_timeBound_9_0, grammarAccess.getTmscXtextModelAccess().getTimeBoundABS_EBIGDECIMALTerminalRuleCall_1_0_3_1_2_0());
            	    	      								
            	    	    }
            	    	    if ( state.backtracking==0 ) {

            	    	      									if (current==null) {
            	    	      										current = createModelElement(grammarAccess.getTmscXtextModelRule());
            	    	      									}
            	    	      									setWithLastConsumed(
            	    	      										current,
            	    	      										"timeBound",
            	    	      										lv_timeBound_9_0,
            	    	      										"nl.esi.pps.tmsc.xtext.TmscXtext.ABS_EBIGDECIMAL");
            	    	      								
            	    	    }

            	    	    }


            	    	    }


            	    	    }


            	    	    }
            	    	    break;
            	    	case 3 :
            	    	    // InternalTmscXtext.g:161:6: (otherlv_10= 'scheduled' otherlv_11= ':' ( (lv_scheduled_12_0= ruleEBOOLEAN_OBJECT ) ) )
            	    	    {
            	    	    // InternalTmscXtext.g:161:6: (otherlv_10= 'scheduled' otherlv_11= ':' ( (lv_scheduled_12_0= ruleEBOOLEAN_OBJECT ) ) )
            	    	    // InternalTmscXtext.g:162:7: otherlv_10= 'scheduled' otherlv_11= ':' ( (lv_scheduled_12_0= ruleEBOOLEAN_OBJECT ) )
            	    	    {
            	    	    otherlv_10=(Token)match(input,19,FOLLOW_6); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      							newLeafNode(otherlv_10, grammarAccess.getTmscXtextModelAccess().getScheduledKeyword_1_0_3_2_0());
            	    	      						
            	    	    }
            	    	    otherlv_11=(Token)match(input,17,FOLLOW_9); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      							newLeafNode(otherlv_11, grammarAccess.getTmscXtextModelAccess().getColonKeyword_1_0_3_2_1());
            	    	      						
            	    	    }
            	    	    // InternalTmscXtext.g:170:7: ( (lv_scheduled_12_0= ruleEBOOLEAN_OBJECT ) )
            	    	    // InternalTmscXtext.g:171:8: (lv_scheduled_12_0= ruleEBOOLEAN_OBJECT )
            	    	    {
            	    	    // InternalTmscXtext.g:171:8: (lv_scheduled_12_0= ruleEBOOLEAN_OBJECT )
            	    	    // InternalTmscXtext.g:172:9: lv_scheduled_12_0= ruleEBOOLEAN_OBJECT
            	    	    {
            	    	    if ( state.backtracking==0 ) {

            	    	      									newCompositeNode(grammarAccess.getTmscXtextModelAccess().getScheduledEBOOLEAN_OBJECTParserRuleCall_1_0_3_2_2_0());
            	    	      								
            	    	    }
            	    	    pushFollow(FOLLOW_5);
            	    	    lv_scheduled_12_0=ruleEBOOLEAN_OBJECT();

            	    	    state._fsp--;
            	    	    if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      									if (current==null) {
            	    	      										current = createModelElementForParent(grammarAccess.getTmscXtextModelRule());
            	    	      									}
            	    	      									set(
            	    	      										current,
            	    	      										"scheduled",
            	    	      										lv_scheduled_12_0,
            	    	      										"nl.esi.pps.tmsc.xtext.TmscXtext.EBOOLEAN_OBJECT");
            	    	      									afterParserOrEnumRuleCall();
            	    	      								
            	    	    }

            	    	    }


            	    	    }


            	    	    }


            	    	    }
            	    	    break;
            	    	case 4 :
            	    	    // InternalTmscXtext.g:191:6: ( (lv_properties_13_0= ruleXProperty ) )
            	    	    {
            	    	    // InternalTmscXtext.g:191:6: ( (lv_properties_13_0= ruleXProperty ) )
            	    	    // InternalTmscXtext.g:192:7: (lv_properties_13_0= ruleXProperty )
            	    	    {
            	    	    // InternalTmscXtext.g:192:7: (lv_properties_13_0= ruleXProperty )
            	    	    // InternalTmscXtext.g:193:8: lv_properties_13_0= ruleXProperty
            	    	    {
            	    	    if ( state.backtracking==0 ) {

            	    	      								newCompositeNode(grammarAccess.getTmscXtextModelAccess().getPropertiesXPropertyParserRuleCall_1_0_3_3_0());
            	    	      							
            	    	    }
            	    	    pushFollow(FOLLOW_5);
            	    	    lv_properties_13_0=ruleXProperty();

            	    	    state._fsp--;
            	    	    if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      								if (current==null) {
            	    	      									current = createModelElementForParent(grammarAccess.getTmscXtextModelRule());
            	    	      								}
            	    	      								add(
            	    	      									current,
            	    	      									"properties",
            	    	      									lv_properties_13_0,
            	    	      									"nl.esi.pps.tmsc.xtext.TmscXtext.XProperty");
            	    	      								afterParserOrEnumRuleCall();
            	    	      							
            	    	    }

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop1;
            	        }
            	    } while (true);

            	    otherlv_14=(Token)match(input,20,FOLLOW_10); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_14, grammarAccess.getTmscXtextModelAccess().getRightCurlyBracketKeyword_1_0_4());
            	      				
            	    }

            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalTmscXtext.g:217:4: (otherlv_15= 'tmsc' otherlv_16= 'analyses' otherlv_17= '{' ( (lv_analyses_18_0= ruleXTmscAnalysis ) )* otherlv_19= '}' )
            	    {
            	    // InternalTmscXtext.g:217:4: (otherlv_15= 'tmsc' otherlv_16= 'analyses' otherlv_17= '{' ( (lv_analyses_18_0= ruleXTmscAnalysis ) )* otherlv_19= '}' )
            	    // InternalTmscXtext.g:218:5: otherlv_15= 'tmsc' otherlv_16= 'analyses' otherlv_17= '{' ( (lv_analyses_18_0= ruleXTmscAnalysis ) )* otherlv_19= '}'
            	    {
            	    otherlv_15=(Token)match(input,13,FOLLOW_11); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_15, grammarAccess.getTmscXtextModelAccess().getTmscKeyword_1_1_0());
            	      				
            	    }
            	    otherlv_16=(Token)match(input,21,FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_16, grammarAccess.getTmscXtextModelAccess().getAnalysesKeyword_1_1_1());
            	      				
            	    }
            	    otherlv_17=(Token)match(input,15,FOLLOW_12); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_17, grammarAccess.getTmscXtextModelAccess().getLeftCurlyBracketKeyword_1_1_2());
            	      				
            	    }
            	    // InternalTmscXtext.g:230:5: ( (lv_analyses_18_0= ruleXTmscAnalysis ) )*
            	    loop2:
            	    do {
            	        int alt2=2;
            	        int LA2_0 = input.LA(1);

            	        if ( (LA2_0==22) ) {
            	            alt2=1;
            	        }


            	        switch (alt2) {
            	    	case 1 :
            	    	    // InternalTmscXtext.g:231:6: (lv_analyses_18_0= ruleXTmscAnalysis )
            	    	    {
            	    	    // InternalTmscXtext.g:231:6: (lv_analyses_18_0= ruleXTmscAnalysis )
            	    	    // InternalTmscXtext.g:232:7: lv_analyses_18_0= ruleXTmscAnalysis
            	    	    {
            	    	    if ( state.backtracking==0 ) {

            	    	      							newCompositeNode(grammarAccess.getTmscXtextModelAccess().getAnalysesXTmscAnalysisParserRuleCall_1_1_3_0());
            	    	      						
            	    	    }
            	    	    pushFollow(FOLLOW_12);
            	    	    lv_analyses_18_0=ruleXTmscAnalysis();

            	    	    state._fsp--;
            	    	    if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      							if (current==null) {
            	    	      								current = createModelElementForParent(grammarAccess.getTmscXtextModelRule());
            	    	      							}
            	    	      							add(
            	    	      								current,
            	    	      								"analyses",
            	    	      								lv_analyses_18_0,
            	    	      								"nl.esi.pps.tmsc.xtext.TmscXtext.XTmscAnalysis");
            	    	      							afterParserOrEnumRuleCall();
            	    	      						
            	    	    }

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop2;
            	        }
            	    } while (true);

            	    otherlv_19=(Token)match(input,20,FOLLOW_10); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_19, grammarAccess.getTmscXtextModelAccess().getRightCurlyBracketKeyword_1_1_4());
            	      				
            	    }

            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalTmscXtext.g:255:4: ( (lv_dependencySettings_20_0= ruleXDependencySettings ) )
            	    {
            	    // InternalTmscXtext.g:255:4: ( (lv_dependencySettings_20_0= ruleXDependencySettings ) )
            	    // InternalTmscXtext.g:256:5: (lv_dependencySettings_20_0= ruleXDependencySettings )
            	    {
            	    // InternalTmscXtext.g:256:5: (lv_dependencySettings_20_0= ruleXDependencySettings )
            	    // InternalTmscXtext.g:257:6: lv_dependencySettings_20_0= ruleXDependencySettings
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getTmscXtextModelAccess().getDependencySettingsXDependencySettingsParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_10);
            	    lv_dependencySettings_20_0=ruleXDependencySettings();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getTmscXtextModelRule());
            	      						}
            	      						add(
            	      							current,
            	      							"dependencySettings",
            	      							lv_dependencySettings_20_0,
            	      							"nl.esi.pps.tmsc.xtext.TmscXtext.XDependencySettings");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalTmscXtext.g:275:4: ( (lv_interfaces_21_0= ruleXInterface ) )
            	    {
            	    // InternalTmscXtext.g:275:4: ( (lv_interfaces_21_0= ruleXInterface ) )
            	    // InternalTmscXtext.g:276:5: (lv_interfaces_21_0= ruleXInterface )
            	    {
            	    // InternalTmscXtext.g:276:5: (lv_interfaces_21_0= ruleXInterface )
            	    // InternalTmscXtext.g:277:6: lv_interfaces_21_0= ruleXInterface
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getTmscXtextModelAccess().getInterfacesXInterfaceParserRuleCall_1_3_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_10);
            	    lv_interfaces_21_0=ruleXInterface();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getTmscXtextModelRule());
            	      						}
            	      						add(
            	      							current,
            	      							"interfaces",
            	      							lv_interfaces_21_0,
            	      							"nl.esi.pps.tmsc.xtext.TmscXtext.XInterface");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // InternalTmscXtext.g:295:4: ( (lv_components_22_0= ruleXComponent ) )
            	    {
            	    // InternalTmscXtext.g:295:4: ( (lv_components_22_0= ruleXComponent ) )
            	    // InternalTmscXtext.g:296:5: (lv_components_22_0= ruleXComponent )
            	    {
            	    // InternalTmscXtext.g:296:5: (lv_components_22_0= ruleXComponent )
            	    // InternalTmscXtext.g:297:6: lv_components_22_0= ruleXComponent
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getTmscXtextModelAccess().getComponentsXComponentParserRuleCall_1_4_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_10);
            	    lv_components_22_0=ruleXComponent();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getTmscXtextModelRule());
            	      						}
            	      						add(
            	      							current,
            	      							"components",
            	      							lv_components_22_0,
            	      							"nl.esi.pps.tmsc.xtext.TmscXtext.XComponent");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 6 :
            	    // InternalTmscXtext.g:315:4: ( (lv_functions_23_0= ruleXFunction ) )
            	    {
            	    // InternalTmscXtext.g:315:4: ( (lv_functions_23_0= ruleXFunction ) )
            	    // InternalTmscXtext.g:316:5: (lv_functions_23_0= ruleXFunction )
            	    {
            	    // InternalTmscXtext.g:316:5: (lv_functions_23_0= ruleXFunction )
            	    // InternalTmscXtext.g:317:6: lv_functions_23_0= ruleXFunction
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getTmscXtextModelAccess().getFunctionsXFunctionParserRuleCall_1_5_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_10);
            	    lv_functions_23_0=ruleXFunction();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getTmscXtextModelRule());
            	      						}
            	      						add(
            	      							current,
            	      							"functions",
            	      							lv_functions_23_0,
            	      							"nl.esi.pps.tmsc.xtext.TmscXtext.XFunction");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 7 :
            	    // InternalTmscXtext.g:335:4: ( (lv_hosts_24_0= ruleXHost ) )
            	    {
            	    // InternalTmscXtext.g:335:4: ( (lv_hosts_24_0= ruleXHost ) )
            	    // InternalTmscXtext.g:336:5: (lv_hosts_24_0= ruleXHost )
            	    {
            	    // InternalTmscXtext.g:336:5: (lv_hosts_24_0= ruleXHost )
            	    // InternalTmscXtext.g:337:6: lv_hosts_24_0= ruleXHost
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getTmscXtextModelAccess().getHostsXHostParserRuleCall_1_6_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_10);
            	    lv_hosts_24_0=ruleXHost();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getTmscXtextModelRule());
            	      						}
            	      						add(
            	      							current,
            	      							"hosts",
            	      							lv_hosts_24_0,
            	      							"nl.esi.pps.tmsc.xtext.TmscXtext.XHost");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 8 :
            	    // InternalTmscXtext.g:355:4: ( (lv_executors_25_0= ruleXExecutor ) )
            	    {
            	    // InternalTmscXtext.g:355:4: ( (lv_executors_25_0= ruleXExecutor ) )
            	    // InternalTmscXtext.g:356:5: (lv_executors_25_0= ruleXExecutor )
            	    {
            	    // InternalTmscXtext.g:356:5: (lv_executors_25_0= ruleXExecutor )
            	    // InternalTmscXtext.g:357:6: lv_executors_25_0= ruleXExecutor
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getTmscXtextModelAccess().getExecutorsXExecutorParserRuleCall_1_7_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_10);
            	    lv_executors_25_0=ruleXExecutor();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getTmscXtextModelRule());
            	      						}
            	      						add(
            	      							current,
            	      							"executors",
            	      							lv_executors_25_0,
            	      							"nl.esi.pps.tmsc.xtext.TmscXtext.XExecutor");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 9 :
            	    // InternalTmscXtext.g:375:4: ( (lv_events_26_0= ruleXEvent ) )
            	    {
            	    // InternalTmscXtext.g:375:4: ( (lv_events_26_0= ruleXEvent ) )
            	    // InternalTmscXtext.g:376:5: (lv_events_26_0= ruleXEvent )
            	    {
            	    // InternalTmscXtext.g:376:5: (lv_events_26_0= ruleXEvent )
            	    // InternalTmscXtext.g:377:6: lv_events_26_0= ruleXEvent
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getTmscXtextModelAccess().getEventsXEventParserRuleCall_1_8_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_10);
            	    lv_events_26_0=ruleXEvent();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getTmscXtextModelRule());
            	      						}
            	      						add(
            	      							current,
            	      							"events",
            	      							lv_events_26_0,
            	      							"nl.esi.pps.tmsc.xtext.TmscXtext.XEvent");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleTmscXtextModel"


    // $ANTLR start "entryRuleXTmscAnalysis"
    // InternalTmscXtext.g:399:1: entryRuleXTmscAnalysis returns [EObject current=null] : iv_ruleXTmscAnalysis= ruleXTmscAnalysis EOF ;
    public final EObject entryRuleXTmscAnalysis() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXTmscAnalysis = null;


        try {
            // InternalTmscXtext.g:399:54: (iv_ruleXTmscAnalysis= ruleXTmscAnalysis EOF )
            // InternalTmscXtext.g:400:2: iv_ruleXTmscAnalysis= ruleXTmscAnalysis EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXTmscAnalysisRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXTmscAnalysis=ruleXTmscAnalysis();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXTmscAnalysis; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXTmscAnalysis"


    // $ANTLR start "ruleXTmscAnalysis"
    // InternalTmscXtext.g:406:1: ruleXTmscAnalysis returns [EObject current=null] : this_XTimeBoundAnalysis_0= ruleXTimeBoundAnalysis ;
    public final EObject ruleXTmscAnalysis() throws RecognitionException {
        EObject current = null;

        EObject this_XTimeBoundAnalysis_0 = null;



        	enterRule();

        try {
            // InternalTmscXtext.g:412:2: (this_XTimeBoundAnalysis_0= ruleXTimeBoundAnalysis )
            // InternalTmscXtext.g:413:2: this_XTimeBoundAnalysis_0= ruleXTimeBoundAnalysis
            {
            if ( state.backtracking==0 ) {

              		newCompositeNode(grammarAccess.getXTmscAnalysisAccess().getXTimeBoundAnalysisParserRuleCall());
              	
            }
            pushFollow(FOLLOW_2);
            this_XTimeBoundAnalysis_0=ruleXTimeBoundAnalysis();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current = this_XTimeBoundAnalysis_0;
              		afterParserOrEnumRuleCall();
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleXTmscAnalysis"


    // $ANTLR start "entryRuleXTimeBoundAnalysis"
    // InternalTmscXtext.g:424:1: entryRuleXTimeBoundAnalysis returns [EObject current=null] : iv_ruleXTimeBoundAnalysis= ruleXTimeBoundAnalysis EOF ;
    public final EObject entryRuleXTimeBoundAnalysis() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXTimeBoundAnalysis = null;


        try {
            // InternalTmscXtext.g:424:59: (iv_ruleXTimeBoundAnalysis= ruleXTimeBoundAnalysis EOF )
            // InternalTmscXtext.g:425:2: iv_ruleXTimeBoundAnalysis= ruleXTimeBoundAnalysis EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXTimeBoundAnalysisRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXTimeBoundAnalysis=ruleXTimeBoundAnalysis();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXTimeBoundAnalysis; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXTimeBoundAnalysis"


    // $ANTLR start "ruleXTimeBoundAnalysis"
    // InternalTmscXtext.g:431:1: ruleXTimeBoundAnalysis returns [EObject current=null] : ( () otherlv_1= 'time-bound-analysis' (otherlv_2= '{' (otherlv_3= 'defaultTimeBound' otherlv_4= ':' ( (lv_defaultTimeBound_5_0= RULE_ABS_EBIGDECIMAL ) ) )? otherlv_6= '}' )? ) ;
    public final EObject ruleXTimeBoundAnalysis() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token lv_defaultTimeBound_5_0=null;
        Token otherlv_6=null;


        	enterRule();

        try {
            // InternalTmscXtext.g:437:2: ( ( () otherlv_1= 'time-bound-analysis' (otherlv_2= '{' (otherlv_3= 'defaultTimeBound' otherlv_4= ':' ( (lv_defaultTimeBound_5_0= RULE_ABS_EBIGDECIMAL ) ) )? otherlv_6= '}' )? ) )
            // InternalTmscXtext.g:438:2: ( () otherlv_1= 'time-bound-analysis' (otherlv_2= '{' (otherlv_3= 'defaultTimeBound' otherlv_4= ':' ( (lv_defaultTimeBound_5_0= RULE_ABS_EBIGDECIMAL ) ) )? otherlv_6= '}' )? )
            {
            // InternalTmscXtext.g:438:2: ( () otherlv_1= 'time-bound-analysis' (otherlv_2= '{' (otherlv_3= 'defaultTimeBound' otherlv_4= ':' ( (lv_defaultTimeBound_5_0= RULE_ABS_EBIGDECIMAL ) ) )? otherlv_6= '}' )? )
            // InternalTmscXtext.g:439:3: () otherlv_1= 'time-bound-analysis' (otherlv_2= '{' (otherlv_3= 'defaultTimeBound' otherlv_4= ':' ( (lv_defaultTimeBound_5_0= RULE_ABS_EBIGDECIMAL ) ) )? otherlv_6= '}' )?
            {
            // InternalTmscXtext.g:439:3: ()
            // InternalTmscXtext.g:440:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getXTimeBoundAnalysisAccess().getXTimeBoundAnalysisAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,22,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getXTimeBoundAnalysisAccess().getTimeBoundAnalysisKeyword_1());
              		
            }
            // InternalTmscXtext.g:450:3: (otherlv_2= '{' (otherlv_3= 'defaultTimeBound' otherlv_4= ':' ( (lv_defaultTimeBound_5_0= RULE_ABS_EBIGDECIMAL ) ) )? otherlv_6= '}' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==15) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalTmscXtext.g:451:4: otherlv_2= '{' (otherlv_3= 'defaultTimeBound' otherlv_4= ':' ( (lv_defaultTimeBound_5_0= RULE_ABS_EBIGDECIMAL ) ) )? otherlv_6= '}'
                    {
                    otherlv_2=(Token)match(input,15,FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getXTimeBoundAnalysisAccess().getLeftCurlyBracketKeyword_2_0());
                      			
                    }
                    // InternalTmscXtext.g:455:4: (otherlv_3= 'defaultTimeBound' otherlv_4= ':' ( (lv_defaultTimeBound_5_0= RULE_ABS_EBIGDECIMAL ) ) )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==23) ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // InternalTmscXtext.g:456:5: otherlv_3= 'defaultTimeBound' otherlv_4= ':' ( (lv_defaultTimeBound_5_0= RULE_ABS_EBIGDECIMAL ) )
                            {
                            otherlv_3=(Token)match(input,23,FOLLOW_6); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_3, grammarAccess.getXTimeBoundAnalysisAccess().getDefaultTimeBoundKeyword_2_1_0());
                              				
                            }
                            otherlv_4=(Token)match(input,17,FOLLOW_8); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_4, grammarAccess.getXTimeBoundAnalysisAccess().getColonKeyword_2_1_1());
                              				
                            }
                            // InternalTmscXtext.g:464:5: ( (lv_defaultTimeBound_5_0= RULE_ABS_EBIGDECIMAL ) )
                            // InternalTmscXtext.g:465:6: (lv_defaultTimeBound_5_0= RULE_ABS_EBIGDECIMAL )
                            {
                            // InternalTmscXtext.g:465:6: (lv_defaultTimeBound_5_0= RULE_ABS_EBIGDECIMAL )
                            // InternalTmscXtext.g:466:7: lv_defaultTimeBound_5_0= RULE_ABS_EBIGDECIMAL
                            {
                            lv_defaultTimeBound_5_0=(Token)match(input,RULE_ABS_EBIGDECIMAL,FOLLOW_15); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_defaultTimeBound_5_0, grammarAccess.getXTimeBoundAnalysisAccess().getDefaultTimeBoundABS_EBIGDECIMALTerminalRuleCall_2_1_2_0());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getXTimeBoundAnalysisRule());
                              							}
                              							setWithLastConsumed(
                              								current,
                              								"defaultTimeBound",
                              								lv_defaultTimeBound_5_0,
                              								"nl.esi.pps.tmsc.xtext.TmscXtext.ABS_EBIGDECIMAL");
                              						
                            }

                            }


                            }


                            }
                            break;

                    }

                    otherlv_6=(Token)match(input,20,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_6, grammarAccess.getXTimeBoundAnalysisAccess().getRightCurlyBracketKeyword_2_2());
                      			
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleXTimeBoundAnalysis"


    // $ANTLR start "entryRuleXInterface"
    // InternalTmscXtext.g:492:1: entryRuleXInterface returns [EObject current=null] : iv_ruleXInterface= ruleXInterface EOF ;
    public final EObject entryRuleXInterface() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXInterface = null;


        try {
            // InternalTmscXtext.g:492:51: (iv_ruleXInterface= ruleXInterface EOF )
            // InternalTmscXtext.g:493:2: iv_ruleXInterface= ruleXInterface EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXInterfaceRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXInterface=ruleXInterface();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXInterface; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXInterface"


    // $ANTLR start "ruleXInterface"
    // InternalTmscXtext.g:499:1: ruleXInterface returns [EObject current=null] : (otherlv_0= 'interface' ( ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as' )? ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '{' ( ( (lv_properties_5_0= ruleXProperty ) ) | ( (lv_operations_6_0= ruleXOperation ) ) )* otherlv_7= '}' )? ) ;
    public final EObject ruleXInterface() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token lv_name_3_0=null;
        Token otherlv_4=null;
        Token otherlv_7=null;
        AntlrDatatypeRuleToken lv_description_1_0 = null;

        EObject lv_properties_5_0 = null;

        EObject lv_operations_6_0 = null;



        	enterRule();

        try {
            // InternalTmscXtext.g:505:2: ( (otherlv_0= 'interface' ( ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as' )? ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '{' ( ( (lv_properties_5_0= ruleXProperty ) ) | ( (lv_operations_6_0= ruleXOperation ) ) )* otherlv_7= '}' )? ) )
            // InternalTmscXtext.g:506:2: (otherlv_0= 'interface' ( ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as' )? ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '{' ( ( (lv_properties_5_0= ruleXProperty ) ) | ( (lv_operations_6_0= ruleXOperation ) ) )* otherlv_7= '}' )? )
            {
            // InternalTmscXtext.g:506:2: (otherlv_0= 'interface' ( ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as' )? ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '{' ( ( (lv_properties_5_0= ruleXProperty ) ) | ( (lv_operations_6_0= ruleXOperation ) ) )* otherlv_7= '}' )? )
            // InternalTmscXtext.g:507:3: otherlv_0= 'interface' ( ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as' )? ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '{' ( ( (lv_properties_5_0= ruleXProperty ) ) | ( (lv_operations_6_0= ruleXOperation ) ) )* otherlv_7= '}' )?
            {
            otherlv_0=(Token)match(input,24,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getXInterfaceAccess().getInterfaceKeyword_0());
              		
            }
            // InternalTmscXtext.g:511:3: ( ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_ID) ) {
                int LA6_1 = input.LA(2);

                if ( (LA6_1==25) ) {
                    alt6=1;
                }
            }
            else if ( (LA6_0==RULE_STRING) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalTmscXtext.g:512:4: ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as'
                    {
                    // InternalTmscXtext.g:512:4: ( (lv_description_1_0= ruleIDString ) )
                    // InternalTmscXtext.g:513:5: (lv_description_1_0= ruleIDString )
                    {
                    // InternalTmscXtext.g:513:5: (lv_description_1_0= ruleIDString )
                    // InternalTmscXtext.g:514:6: lv_description_1_0= ruleIDString
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getXInterfaceAccess().getDescriptionIDStringParserRuleCall_1_0_0());
                      					
                    }
                    pushFollow(FOLLOW_17);
                    lv_description_1_0=ruleIDString();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getXInterfaceRule());
                      						}
                      						set(
                      							current,
                      							"description",
                      							lv_description_1_0,
                      							"nl.esi.pps.tmsc.xtext.TmscXtext.IDString");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    otherlv_2=(Token)match(input,25,FOLLOW_18); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getXInterfaceAccess().getAsKeyword_1_1());
                      			
                    }

                    }
                    break;

            }

            // InternalTmscXtext.g:536:3: ( (lv_name_3_0= RULE_ID ) )
            // InternalTmscXtext.g:537:4: (lv_name_3_0= RULE_ID )
            {
            // InternalTmscXtext.g:537:4: (lv_name_3_0= RULE_ID )
            // InternalTmscXtext.g:538:5: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_3_0, grammarAccess.getXInterfaceAccess().getNameIDTerminalRuleCall_2_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getXInterfaceRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_3_0,
              						"nl.esi.pps.tmsc.xtext.TmscXtext.ID");
              				
            }

            }


            }

            // InternalTmscXtext.g:554:3: (otherlv_4= '{' ( ( (lv_properties_5_0= ruleXProperty ) ) | ( (lv_operations_6_0= ruleXOperation ) ) )* otherlv_7= '}' )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==15) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalTmscXtext.g:555:4: otherlv_4= '{' ( ( (lv_properties_5_0= ruleXProperty ) ) | ( (lv_operations_6_0= ruleXOperation ) ) )* otherlv_7= '}'
                    {
                    otherlv_4=(Token)match(input,15,FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getXInterfaceAccess().getLeftCurlyBracketKeyword_3_0());
                      			
                    }
                    // InternalTmscXtext.g:559:4: ( ( (lv_properties_5_0= ruleXProperty ) ) | ( (lv_operations_6_0= ruleXOperation ) ) )*
                    loop7:
                    do {
                        int alt7=3;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==RULE_ID||LA7_0==RULE_STRING) ) {
                            alt7=1;
                        }
                        else if ( (LA7_0==26) ) {
                            alt7=2;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // InternalTmscXtext.g:560:5: ( (lv_properties_5_0= ruleXProperty ) )
                    	    {
                    	    // InternalTmscXtext.g:560:5: ( (lv_properties_5_0= ruleXProperty ) )
                    	    // InternalTmscXtext.g:561:6: (lv_properties_5_0= ruleXProperty )
                    	    {
                    	    // InternalTmscXtext.g:561:6: (lv_properties_5_0= ruleXProperty )
                    	    // InternalTmscXtext.g:562:7: lv_properties_5_0= ruleXProperty
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getXInterfaceAccess().getPropertiesXPropertyParserRuleCall_3_1_0_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_19);
                    	    lv_properties_5_0=ruleXProperty();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getXInterfaceRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"properties",
                    	      								lv_properties_5_0,
                    	      								"nl.esi.pps.tmsc.xtext.TmscXtext.XProperty");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalTmscXtext.g:580:5: ( (lv_operations_6_0= ruleXOperation ) )
                    	    {
                    	    // InternalTmscXtext.g:580:5: ( (lv_operations_6_0= ruleXOperation ) )
                    	    // InternalTmscXtext.g:581:6: (lv_operations_6_0= ruleXOperation )
                    	    {
                    	    // InternalTmscXtext.g:581:6: (lv_operations_6_0= ruleXOperation )
                    	    // InternalTmscXtext.g:582:7: lv_operations_6_0= ruleXOperation
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getXInterfaceAccess().getOperationsXOperationParserRuleCall_3_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_19);
                    	    lv_operations_6_0=ruleXOperation();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getXInterfaceRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"operations",
                    	      								lv_operations_6_0,
                    	      								"nl.esi.pps.tmsc.xtext.TmscXtext.XOperation");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);

                    otherlv_7=(Token)match(input,20,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_7, grammarAccess.getXInterfaceAccess().getRightCurlyBracketKeyword_3_2());
                      			
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleXInterface"


    // $ANTLR start "entryRuleXOperation"
    // InternalTmscXtext.g:609:1: entryRuleXOperation returns [EObject current=null] : iv_ruleXOperation= ruleXOperation EOF ;
    public final EObject entryRuleXOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXOperation = null;


        try {
            // InternalTmscXtext.g:609:51: (iv_ruleXOperation= ruleXOperation EOF )
            // InternalTmscXtext.g:610:2: iv_ruleXOperation= ruleXOperation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXOperationRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXOperation=ruleXOperation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXOperation; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXOperation"


    // $ANTLR start "ruleXOperation"
    // InternalTmscXtext.g:616:1: ruleXOperation returns [EObject current=null] : (otherlv_0= 'operation' ( ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as' )? ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '{' ( (lv_properties_5_0= ruleXProperty ) )* otherlv_6= '}' )? ) ;
    public final EObject ruleXOperation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token lv_name_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_description_1_0 = null;

        EObject lv_properties_5_0 = null;



        	enterRule();

        try {
            // InternalTmscXtext.g:622:2: ( (otherlv_0= 'operation' ( ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as' )? ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '{' ( (lv_properties_5_0= ruleXProperty ) )* otherlv_6= '}' )? ) )
            // InternalTmscXtext.g:623:2: (otherlv_0= 'operation' ( ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as' )? ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '{' ( (lv_properties_5_0= ruleXProperty ) )* otherlv_6= '}' )? )
            {
            // InternalTmscXtext.g:623:2: (otherlv_0= 'operation' ( ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as' )? ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '{' ( (lv_properties_5_0= ruleXProperty ) )* otherlv_6= '}' )? )
            // InternalTmscXtext.g:624:3: otherlv_0= 'operation' ( ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as' )? ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '{' ( (lv_properties_5_0= ruleXProperty ) )* otherlv_6= '}' )?
            {
            otherlv_0=(Token)match(input,26,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getXOperationAccess().getOperationKeyword_0());
              		
            }
            // InternalTmscXtext.g:628:3: ( ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_ID) ) {
                int LA9_1 = input.LA(2);

                if ( (LA9_1==25) ) {
                    alt9=1;
                }
            }
            else if ( (LA9_0==RULE_STRING) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalTmscXtext.g:629:4: ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as'
                    {
                    // InternalTmscXtext.g:629:4: ( (lv_description_1_0= ruleIDString ) )
                    // InternalTmscXtext.g:630:5: (lv_description_1_0= ruleIDString )
                    {
                    // InternalTmscXtext.g:630:5: (lv_description_1_0= ruleIDString )
                    // InternalTmscXtext.g:631:6: lv_description_1_0= ruleIDString
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getXOperationAccess().getDescriptionIDStringParserRuleCall_1_0_0());
                      					
                    }
                    pushFollow(FOLLOW_17);
                    lv_description_1_0=ruleIDString();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getXOperationRule());
                      						}
                      						set(
                      							current,
                      							"description",
                      							lv_description_1_0,
                      							"nl.esi.pps.tmsc.xtext.TmscXtext.IDString");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    otherlv_2=(Token)match(input,25,FOLLOW_18); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getXOperationAccess().getAsKeyword_1_1());
                      			
                    }

                    }
                    break;

            }

            // InternalTmscXtext.g:653:3: ( (lv_name_3_0= RULE_ID ) )
            // InternalTmscXtext.g:654:4: (lv_name_3_0= RULE_ID )
            {
            // InternalTmscXtext.g:654:4: (lv_name_3_0= RULE_ID )
            // InternalTmscXtext.g:655:5: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_3_0, grammarAccess.getXOperationAccess().getNameIDTerminalRuleCall_2_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getXOperationRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_3_0,
              						"nl.esi.pps.tmsc.xtext.TmscXtext.ID");
              				
            }

            }


            }

            // InternalTmscXtext.g:671:3: (otherlv_4= '{' ( (lv_properties_5_0= ruleXProperty ) )* otherlv_6= '}' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==15) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalTmscXtext.g:672:4: otherlv_4= '{' ( (lv_properties_5_0= ruleXProperty ) )* otherlv_6= '}'
                    {
                    otherlv_4=(Token)match(input,15,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getXOperationAccess().getLeftCurlyBracketKeyword_3_0());
                      			
                    }
                    // InternalTmscXtext.g:676:4: ( (lv_properties_5_0= ruleXProperty ) )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==RULE_ID||LA10_0==RULE_STRING) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // InternalTmscXtext.g:677:5: (lv_properties_5_0= ruleXProperty )
                    	    {
                    	    // InternalTmscXtext.g:677:5: (lv_properties_5_0= ruleXProperty )
                    	    // InternalTmscXtext.g:678:6: lv_properties_5_0= ruleXProperty
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						newCompositeNode(grammarAccess.getXOperationAccess().getPropertiesXPropertyParserRuleCall_3_1_0());
                    	      					
                    	    }
                    	    pushFollow(FOLLOW_5);
                    	    lv_properties_5_0=ruleXProperty();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						if (current==null) {
                    	      							current = createModelElementForParent(grammarAccess.getXOperationRule());
                    	      						}
                    	      						add(
                    	      							current,
                    	      							"properties",
                    	      							lv_properties_5_0,
                    	      							"nl.esi.pps.tmsc.xtext.TmscXtext.XProperty");
                    	      						afterParserOrEnumRuleCall();
                    	      					
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,20,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_6, grammarAccess.getXOperationAccess().getRightCurlyBracketKeyword_3_2());
                      			
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleXOperation"


    // $ANTLR start "entryRuleXComponent"
    // InternalTmscXtext.g:704:1: entryRuleXComponent returns [EObject current=null] : iv_ruleXComponent= ruleXComponent EOF ;
    public final EObject entryRuleXComponent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXComponent = null;


        try {
            // InternalTmscXtext.g:704:51: (iv_ruleXComponent= ruleXComponent EOF )
            // InternalTmscXtext.g:705:2: iv_ruleXComponent= ruleXComponent EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXComponentRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXComponent=ruleXComponent();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXComponent; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXComponent"


    // $ANTLR start "ruleXComponent"
    // InternalTmscXtext.g:711:1: ruleXComponent returns [EObject current=null] : (otherlv_0= 'component' ( ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as' )? ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= 'provides' ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )? (otherlv_8= 'requires' ( (otherlv_9= RULE_ID ) ) (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )* )? (otherlv_12= '{' ( (otherlv_13= 'time-bound' otherlv_14= ':' ( (lv_timeBound_15_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_16= 'scheduled' otherlv_17= ':' ( (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_19_0= ruleXProperty ) ) )* otherlv_20= '}' )? ) ;
    public final EObject ruleXComponent() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token lv_name_3_0=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token lv_timeBound_15_0=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token otherlv_20=null;
        AntlrDatatypeRuleToken lv_description_1_0 = null;

        AntlrDatatypeRuleToken lv_scheduled_18_0 = null;

        EObject lv_properties_19_0 = null;



        	enterRule();

        try {
            // InternalTmscXtext.g:717:2: ( (otherlv_0= 'component' ( ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as' )? ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= 'provides' ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )? (otherlv_8= 'requires' ( (otherlv_9= RULE_ID ) ) (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )* )? (otherlv_12= '{' ( (otherlv_13= 'time-bound' otherlv_14= ':' ( (lv_timeBound_15_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_16= 'scheduled' otherlv_17= ':' ( (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_19_0= ruleXProperty ) ) )* otherlv_20= '}' )? ) )
            // InternalTmscXtext.g:718:2: (otherlv_0= 'component' ( ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as' )? ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= 'provides' ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )? (otherlv_8= 'requires' ( (otherlv_9= RULE_ID ) ) (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )* )? (otherlv_12= '{' ( (otherlv_13= 'time-bound' otherlv_14= ':' ( (lv_timeBound_15_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_16= 'scheduled' otherlv_17= ':' ( (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_19_0= ruleXProperty ) ) )* otherlv_20= '}' )? )
            {
            // InternalTmscXtext.g:718:2: (otherlv_0= 'component' ( ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as' )? ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= 'provides' ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )? (otherlv_8= 'requires' ( (otherlv_9= RULE_ID ) ) (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )* )? (otherlv_12= '{' ( (otherlv_13= 'time-bound' otherlv_14= ':' ( (lv_timeBound_15_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_16= 'scheduled' otherlv_17= ':' ( (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_19_0= ruleXProperty ) ) )* otherlv_20= '}' )? )
            // InternalTmscXtext.g:719:3: otherlv_0= 'component' ( ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as' )? ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= 'provides' ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )? (otherlv_8= 'requires' ( (otherlv_9= RULE_ID ) ) (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )* )? (otherlv_12= '{' ( (otherlv_13= 'time-bound' otherlv_14= ':' ( (lv_timeBound_15_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_16= 'scheduled' otherlv_17= ':' ( (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_19_0= ruleXProperty ) ) )* otherlv_20= '}' )?
            {
            otherlv_0=(Token)match(input,27,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getXComponentAccess().getComponentKeyword_0());
              		
            }
            // InternalTmscXtext.g:723:3: ( ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as' )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_ID) ) {
                int LA12_1 = input.LA(2);

                if ( (LA12_1==25) ) {
                    alt12=1;
                }
            }
            else if ( (LA12_0==RULE_STRING) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalTmscXtext.g:724:4: ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as'
                    {
                    // InternalTmscXtext.g:724:4: ( (lv_description_1_0= ruleIDString ) )
                    // InternalTmscXtext.g:725:5: (lv_description_1_0= ruleIDString )
                    {
                    // InternalTmscXtext.g:725:5: (lv_description_1_0= ruleIDString )
                    // InternalTmscXtext.g:726:6: lv_description_1_0= ruleIDString
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getXComponentAccess().getDescriptionIDStringParserRuleCall_1_0_0());
                      					
                    }
                    pushFollow(FOLLOW_17);
                    lv_description_1_0=ruleIDString();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getXComponentRule());
                      						}
                      						set(
                      							current,
                      							"description",
                      							lv_description_1_0,
                      							"nl.esi.pps.tmsc.xtext.TmscXtext.IDString");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    otherlv_2=(Token)match(input,25,FOLLOW_18); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getXComponentAccess().getAsKeyword_1_1());
                      			
                    }

                    }
                    break;

            }

            // InternalTmscXtext.g:748:3: ( (lv_name_3_0= RULE_ID ) )
            // InternalTmscXtext.g:749:4: (lv_name_3_0= RULE_ID )
            {
            // InternalTmscXtext.g:749:4: (lv_name_3_0= RULE_ID )
            // InternalTmscXtext.g:750:5: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_20); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_3_0, grammarAccess.getXComponentAccess().getNameIDTerminalRuleCall_2_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getXComponentRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_3_0,
              						"nl.esi.pps.tmsc.xtext.TmscXtext.ID");
              				
            }

            }


            }

            // InternalTmscXtext.g:766:3: (otherlv_4= 'provides' ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==28) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalTmscXtext.g:767:4: otherlv_4= 'provides' ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )*
                    {
                    otherlv_4=(Token)match(input,28,FOLLOW_18); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getXComponentAccess().getProvidesKeyword_3_0());
                      			
                    }
                    // InternalTmscXtext.g:771:4: ( (otherlv_5= RULE_ID ) )
                    // InternalTmscXtext.g:772:5: (otherlv_5= RULE_ID )
                    {
                    // InternalTmscXtext.g:772:5: (otherlv_5= RULE_ID )
                    // InternalTmscXtext.g:773:6: otherlv_5= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getXComponentRule());
                      						}
                      					
                    }
                    otherlv_5=(Token)match(input,RULE_ID,FOLLOW_21); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_5, grammarAccess.getXComponentAccess().getProvidesXInterfaceCrossReference_3_1_0());
                      					
                    }

                    }


                    }

                    // InternalTmscXtext.g:784:4: (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==29) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // InternalTmscXtext.g:785:5: otherlv_6= ',' ( (otherlv_7= RULE_ID ) )
                    	    {
                    	    otherlv_6=(Token)match(input,29,FOLLOW_18); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_6, grammarAccess.getXComponentAccess().getCommaKeyword_3_2_0());
                    	      				
                    	    }
                    	    // InternalTmscXtext.g:789:5: ( (otherlv_7= RULE_ID ) )
                    	    // InternalTmscXtext.g:790:6: (otherlv_7= RULE_ID )
                    	    {
                    	    // InternalTmscXtext.g:790:6: (otherlv_7= RULE_ID )
                    	    // InternalTmscXtext.g:791:7: otherlv_7= RULE_ID
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElement(grammarAccess.getXComponentRule());
                    	      							}
                    	      						
                    	    }
                    	    otherlv_7=(Token)match(input,RULE_ID,FOLLOW_21); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							newLeafNode(otherlv_7, grammarAccess.getXComponentAccess().getProvidesXInterfaceCrossReference_3_2_1_0());
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalTmscXtext.g:804:3: (otherlv_8= 'requires' ( (otherlv_9= RULE_ID ) ) (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )* )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==30) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalTmscXtext.g:805:4: otherlv_8= 'requires' ( (otherlv_9= RULE_ID ) ) (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )*
                    {
                    otherlv_8=(Token)match(input,30,FOLLOW_18); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_8, grammarAccess.getXComponentAccess().getRequiresKeyword_4_0());
                      			
                    }
                    // InternalTmscXtext.g:809:4: ( (otherlv_9= RULE_ID ) )
                    // InternalTmscXtext.g:810:5: (otherlv_9= RULE_ID )
                    {
                    // InternalTmscXtext.g:810:5: (otherlv_9= RULE_ID )
                    // InternalTmscXtext.g:811:6: otherlv_9= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getXComponentRule());
                      						}
                      					
                    }
                    otherlv_9=(Token)match(input,RULE_ID,FOLLOW_22); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_9, grammarAccess.getXComponentAccess().getRequiresXInterfaceCrossReference_4_1_0());
                      					
                    }

                    }


                    }

                    // InternalTmscXtext.g:822:4: (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==29) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // InternalTmscXtext.g:823:5: otherlv_10= ',' ( (otherlv_11= RULE_ID ) )
                    	    {
                    	    otherlv_10=(Token)match(input,29,FOLLOW_18); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_10, grammarAccess.getXComponentAccess().getCommaKeyword_4_2_0());
                    	      				
                    	    }
                    	    // InternalTmscXtext.g:827:5: ( (otherlv_11= RULE_ID ) )
                    	    // InternalTmscXtext.g:828:6: (otherlv_11= RULE_ID )
                    	    {
                    	    // InternalTmscXtext.g:828:6: (otherlv_11= RULE_ID )
                    	    // InternalTmscXtext.g:829:7: otherlv_11= RULE_ID
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElement(grammarAccess.getXComponentRule());
                    	      							}
                    	      						
                    	    }
                    	    otherlv_11=(Token)match(input,RULE_ID,FOLLOW_22); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							newLeafNode(otherlv_11, grammarAccess.getXComponentAccess().getRequiresXInterfaceCrossReference_4_2_1_0());
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop15;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalTmscXtext.g:842:3: (otherlv_12= '{' ( (otherlv_13= 'time-bound' otherlv_14= ':' ( (lv_timeBound_15_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_16= 'scheduled' otherlv_17= ':' ( (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_19_0= ruleXProperty ) ) )* otherlv_20= '}' )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==15) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalTmscXtext.g:843:4: otherlv_12= '{' ( (otherlv_13= 'time-bound' otherlv_14= ':' ( (lv_timeBound_15_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_16= 'scheduled' otherlv_17= ':' ( (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_19_0= ruleXProperty ) ) )* otherlv_20= '}'
                    {
                    otherlv_12=(Token)match(input,15,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_12, grammarAccess.getXComponentAccess().getLeftCurlyBracketKeyword_5_0());
                      			
                    }
                    // InternalTmscXtext.g:847:4: ( (otherlv_13= 'time-bound' otherlv_14= ':' ( (lv_timeBound_15_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_16= 'scheduled' otherlv_17= ':' ( (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_19_0= ruleXProperty ) ) )*
                    loop17:
                    do {
                        int alt17=4;
                        switch ( input.LA(1) ) {
                        case 18:
                            {
                            alt17=1;
                            }
                            break;
                        case 19:
                            {
                            alt17=2;
                            }
                            break;
                        case RULE_ID:
                        case RULE_STRING:
                            {
                            alt17=3;
                            }
                            break;

                        }

                        switch (alt17) {
                    	case 1 :
                    	    // InternalTmscXtext.g:848:5: (otherlv_13= 'time-bound' otherlv_14= ':' ( (lv_timeBound_15_0= RULE_ABS_EBIGDECIMAL ) ) )
                    	    {
                    	    // InternalTmscXtext.g:848:5: (otherlv_13= 'time-bound' otherlv_14= ':' ( (lv_timeBound_15_0= RULE_ABS_EBIGDECIMAL ) ) )
                    	    // InternalTmscXtext.g:849:6: otherlv_13= 'time-bound' otherlv_14= ':' ( (lv_timeBound_15_0= RULE_ABS_EBIGDECIMAL ) )
                    	    {
                    	    otherlv_13=(Token)match(input,18,FOLLOW_6); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_13, grammarAccess.getXComponentAccess().getTimeBoundKeyword_5_1_0_0());
                    	      					
                    	    }
                    	    otherlv_14=(Token)match(input,17,FOLLOW_8); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_14, grammarAccess.getXComponentAccess().getColonKeyword_5_1_0_1());
                    	      					
                    	    }
                    	    // InternalTmscXtext.g:857:6: ( (lv_timeBound_15_0= RULE_ABS_EBIGDECIMAL ) )
                    	    // InternalTmscXtext.g:858:7: (lv_timeBound_15_0= RULE_ABS_EBIGDECIMAL )
                    	    {
                    	    // InternalTmscXtext.g:858:7: (lv_timeBound_15_0= RULE_ABS_EBIGDECIMAL )
                    	    // InternalTmscXtext.g:859:8: lv_timeBound_15_0= RULE_ABS_EBIGDECIMAL
                    	    {
                    	    lv_timeBound_15_0=(Token)match(input,RULE_ABS_EBIGDECIMAL,FOLLOW_5); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      								newLeafNode(lv_timeBound_15_0, grammarAccess.getXComponentAccess().getTimeBoundABS_EBIGDECIMALTerminalRuleCall_5_1_0_2_0());
                    	      							
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      								if (current==null) {
                    	      									current = createModelElement(grammarAccess.getXComponentRule());
                    	      								}
                    	      								setWithLastConsumed(
                    	      									current,
                    	      									"timeBound",
                    	      									lv_timeBound_15_0,
                    	      									"nl.esi.pps.tmsc.xtext.TmscXtext.ABS_EBIGDECIMAL");
                    	      							
                    	    }

                    	    }


                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalTmscXtext.g:877:5: (otherlv_16= 'scheduled' otherlv_17= ':' ( (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT ) ) )
                    	    {
                    	    // InternalTmscXtext.g:877:5: (otherlv_16= 'scheduled' otherlv_17= ':' ( (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT ) ) )
                    	    // InternalTmscXtext.g:878:6: otherlv_16= 'scheduled' otherlv_17= ':' ( (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT ) )
                    	    {
                    	    otherlv_16=(Token)match(input,19,FOLLOW_6); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_16, grammarAccess.getXComponentAccess().getScheduledKeyword_5_1_1_0());
                    	      					
                    	    }
                    	    otherlv_17=(Token)match(input,17,FOLLOW_9); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_17, grammarAccess.getXComponentAccess().getColonKeyword_5_1_1_1());
                    	      					
                    	    }
                    	    // InternalTmscXtext.g:886:6: ( (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT ) )
                    	    // InternalTmscXtext.g:887:7: (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT )
                    	    {
                    	    // InternalTmscXtext.g:887:7: (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT )
                    	    // InternalTmscXtext.g:888:8: lv_scheduled_18_0= ruleEBOOLEAN_OBJECT
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      								newCompositeNode(grammarAccess.getXComponentAccess().getScheduledEBOOLEAN_OBJECTParserRuleCall_5_1_1_2_0());
                    	      							
                    	    }
                    	    pushFollow(FOLLOW_5);
                    	    lv_scheduled_18_0=ruleEBOOLEAN_OBJECT();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      								if (current==null) {
                    	      									current = createModelElementForParent(grammarAccess.getXComponentRule());
                    	      								}
                    	      								set(
                    	      									current,
                    	      									"scheduled",
                    	      									lv_scheduled_18_0,
                    	      									"nl.esi.pps.tmsc.xtext.TmscXtext.EBOOLEAN_OBJECT");
                    	      								afterParserOrEnumRuleCall();
                    	      							
                    	    }

                    	    }


                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 3 :
                    	    // InternalTmscXtext.g:907:5: ( (lv_properties_19_0= ruleXProperty ) )
                    	    {
                    	    // InternalTmscXtext.g:907:5: ( (lv_properties_19_0= ruleXProperty ) )
                    	    // InternalTmscXtext.g:908:6: (lv_properties_19_0= ruleXProperty )
                    	    {
                    	    // InternalTmscXtext.g:908:6: (lv_properties_19_0= ruleXProperty )
                    	    // InternalTmscXtext.g:909:7: lv_properties_19_0= ruleXProperty
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getXComponentAccess().getPropertiesXPropertyParserRuleCall_5_1_2_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_5);
                    	    lv_properties_19_0=ruleXProperty();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getXComponentRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"properties",
                    	      								lv_properties_19_0,
                    	      								"nl.esi.pps.tmsc.xtext.TmscXtext.XProperty");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop17;
                        }
                    } while (true);

                    otherlv_20=(Token)match(input,20,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_20, grammarAccess.getXComponentAccess().getRightCurlyBracketKeyword_5_2());
                      			
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleXComponent"


    // $ANTLR start "entryRuleXFunction"
    // InternalTmscXtext.g:936:1: entryRuleXFunction returns [EObject current=null] : iv_ruleXFunction= ruleXFunction EOF ;
    public final EObject entryRuleXFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXFunction = null;


        try {
            // InternalTmscXtext.g:936:50: (iv_ruleXFunction= ruleXFunction EOF )
            // InternalTmscXtext.g:937:2: iv_ruleXFunction= ruleXFunction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXFunctionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXFunction=ruleXFunction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXFunction; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXFunction"


    // $ANTLR start "ruleXFunction"
    // InternalTmscXtext.g:943:1: ruleXFunction returns [EObject current=null] : ( ( ( (lv_ipcClient_0_0= 'ipc-client' ) ) | ( (lv_ipcServer_1_0= 'ipc-server' ) ) )? otherlv_2= 'function' ( ( (lv_description_3_0= ruleIDString ) ) otherlv_4= 'as' )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '(' ( (lv_parameters_7_0= ruleXFunctionParameter ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleXFunctionParameter ) ) )* otherlv_10= ')' )? (otherlv_11= 'implements' ( ( ruleFQN ) ) )? (otherlv_13= '{' ( (otherlv_14= 'time-bound' otherlv_15= ':' ( (lv_timeBound_16_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_17= 'scheduled' otherlv_18= ':' ( (lv_scheduled_19_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_20_0= ruleXProperty ) ) )* otherlv_21= '}' )? ) ;
    public final EObject ruleXFunction() throws RecognitionException {
        EObject current = null;

        Token lv_ipcClient_0_0=null;
        Token lv_ipcServer_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token lv_name_5_0=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token lv_timeBound_16_0=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token otherlv_21=null;
        AntlrDatatypeRuleToken lv_description_3_0 = null;

        EObject lv_parameters_7_0 = null;

        EObject lv_parameters_9_0 = null;

        AntlrDatatypeRuleToken lv_scheduled_19_0 = null;

        EObject lv_properties_20_0 = null;



        	enterRule();

        try {
            // InternalTmscXtext.g:949:2: ( ( ( ( (lv_ipcClient_0_0= 'ipc-client' ) ) | ( (lv_ipcServer_1_0= 'ipc-server' ) ) )? otherlv_2= 'function' ( ( (lv_description_3_0= ruleIDString ) ) otherlv_4= 'as' )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '(' ( (lv_parameters_7_0= ruleXFunctionParameter ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleXFunctionParameter ) ) )* otherlv_10= ')' )? (otherlv_11= 'implements' ( ( ruleFQN ) ) )? (otherlv_13= '{' ( (otherlv_14= 'time-bound' otherlv_15= ':' ( (lv_timeBound_16_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_17= 'scheduled' otherlv_18= ':' ( (lv_scheduled_19_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_20_0= ruleXProperty ) ) )* otherlv_21= '}' )? ) )
            // InternalTmscXtext.g:950:2: ( ( ( (lv_ipcClient_0_0= 'ipc-client' ) ) | ( (lv_ipcServer_1_0= 'ipc-server' ) ) )? otherlv_2= 'function' ( ( (lv_description_3_0= ruleIDString ) ) otherlv_4= 'as' )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '(' ( (lv_parameters_7_0= ruleXFunctionParameter ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleXFunctionParameter ) ) )* otherlv_10= ')' )? (otherlv_11= 'implements' ( ( ruleFQN ) ) )? (otherlv_13= '{' ( (otherlv_14= 'time-bound' otherlv_15= ':' ( (lv_timeBound_16_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_17= 'scheduled' otherlv_18= ':' ( (lv_scheduled_19_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_20_0= ruleXProperty ) ) )* otherlv_21= '}' )? )
            {
            // InternalTmscXtext.g:950:2: ( ( ( (lv_ipcClient_0_0= 'ipc-client' ) ) | ( (lv_ipcServer_1_0= 'ipc-server' ) ) )? otherlv_2= 'function' ( ( (lv_description_3_0= ruleIDString ) ) otherlv_4= 'as' )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '(' ( (lv_parameters_7_0= ruleXFunctionParameter ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleXFunctionParameter ) ) )* otherlv_10= ')' )? (otherlv_11= 'implements' ( ( ruleFQN ) ) )? (otherlv_13= '{' ( (otherlv_14= 'time-bound' otherlv_15= ':' ( (lv_timeBound_16_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_17= 'scheduled' otherlv_18= ':' ( (lv_scheduled_19_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_20_0= ruleXProperty ) ) )* otherlv_21= '}' )? )
            // InternalTmscXtext.g:951:3: ( ( (lv_ipcClient_0_0= 'ipc-client' ) ) | ( (lv_ipcServer_1_0= 'ipc-server' ) ) )? otherlv_2= 'function' ( ( (lv_description_3_0= ruleIDString ) ) otherlv_4= 'as' )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '(' ( (lv_parameters_7_0= ruleXFunctionParameter ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleXFunctionParameter ) ) )* otherlv_10= ')' )? (otherlv_11= 'implements' ( ( ruleFQN ) ) )? (otherlv_13= '{' ( (otherlv_14= 'time-bound' otherlv_15= ':' ( (lv_timeBound_16_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_17= 'scheduled' otherlv_18= ':' ( (lv_scheduled_19_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_20_0= ruleXProperty ) ) )* otherlv_21= '}' )?
            {
            // InternalTmscXtext.g:951:3: ( ( (lv_ipcClient_0_0= 'ipc-client' ) ) | ( (lv_ipcServer_1_0= 'ipc-server' ) ) )?
            int alt19=3;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==31) ) {
                alt19=1;
            }
            else if ( (LA19_0==32) ) {
                alt19=2;
            }
            switch (alt19) {
                case 1 :
                    // InternalTmscXtext.g:952:4: ( (lv_ipcClient_0_0= 'ipc-client' ) )
                    {
                    // InternalTmscXtext.g:952:4: ( (lv_ipcClient_0_0= 'ipc-client' ) )
                    // InternalTmscXtext.g:953:5: (lv_ipcClient_0_0= 'ipc-client' )
                    {
                    // InternalTmscXtext.g:953:5: (lv_ipcClient_0_0= 'ipc-client' )
                    // InternalTmscXtext.g:954:6: lv_ipcClient_0_0= 'ipc-client'
                    {
                    lv_ipcClient_0_0=(Token)match(input,31,FOLLOW_23); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_ipcClient_0_0, grammarAccess.getXFunctionAccess().getIpcClientIpcClientKeyword_0_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getXFunctionRule());
                      						}
                      						setWithLastConsumed(current, "ipcClient", lv_ipcClient_0_0 != null, "ipc-client");
                      					
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalTmscXtext.g:967:4: ( (lv_ipcServer_1_0= 'ipc-server' ) )
                    {
                    // InternalTmscXtext.g:967:4: ( (lv_ipcServer_1_0= 'ipc-server' ) )
                    // InternalTmscXtext.g:968:5: (lv_ipcServer_1_0= 'ipc-server' )
                    {
                    // InternalTmscXtext.g:968:5: (lv_ipcServer_1_0= 'ipc-server' )
                    // InternalTmscXtext.g:969:6: lv_ipcServer_1_0= 'ipc-server'
                    {
                    lv_ipcServer_1_0=(Token)match(input,32,FOLLOW_23); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_ipcServer_1_0, grammarAccess.getXFunctionAccess().getIpcServerIpcServerKeyword_0_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getXFunctionRule());
                      						}
                      						setWithLastConsumed(current, "ipcServer", lv_ipcServer_1_0 != null, "ipc-server");
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,33,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getXFunctionAccess().getFunctionKeyword_1());
              		
            }
            // InternalTmscXtext.g:986:3: ( ( (lv_description_3_0= ruleIDString ) ) otherlv_4= 'as' )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==RULE_ID) ) {
                int LA20_1 = input.LA(2);

                if ( (LA20_1==25) ) {
                    alt20=1;
                }
            }
            else if ( (LA20_0==RULE_STRING) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalTmscXtext.g:987:4: ( (lv_description_3_0= ruleIDString ) ) otherlv_4= 'as'
                    {
                    // InternalTmscXtext.g:987:4: ( (lv_description_3_0= ruleIDString ) )
                    // InternalTmscXtext.g:988:5: (lv_description_3_0= ruleIDString )
                    {
                    // InternalTmscXtext.g:988:5: (lv_description_3_0= ruleIDString )
                    // InternalTmscXtext.g:989:6: lv_description_3_0= ruleIDString
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getXFunctionAccess().getDescriptionIDStringParserRuleCall_2_0_0());
                      					
                    }
                    pushFollow(FOLLOW_17);
                    lv_description_3_0=ruleIDString();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getXFunctionRule());
                      						}
                      						set(
                      							current,
                      							"description",
                      							lv_description_3_0,
                      							"nl.esi.pps.tmsc.xtext.TmscXtext.IDString");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    otherlv_4=(Token)match(input,25,FOLLOW_18); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getXFunctionAccess().getAsKeyword_2_1());
                      			
                    }

                    }
                    break;

            }

            // InternalTmscXtext.g:1011:3: ( (lv_name_5_0= RULE_ID ) )
            // InternalTmscXtext.g:1012:4: (lv_name_5_0= RULE_ID )
            {
            // InternalTmscXtext.g:1012:4: (lv_name_5_0= RULE_ID )
            // InternalTmscXtext.g:1013:5: lv_name_5_0= RULE_ID
            {
            lv_name_5_0=(Token)match(input,RULE_ID,FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_5_0, grammarAccess.getXFunctionAccess().getNameIDTerminalRuleCall_3_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getXFunctionRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_5_0,
              						"nl.esi.pps.tmsc.xtext.TmscXtext.ID");
              				
            }

            }


            }

            // InternalTmscXtext.g:1029:3: (otherlv_6= '(' ( (lv_parameters_7_0= ruleXFunctionParameter ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleXFunctionParameter ) ) )* otherlv_10= ')' )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==34) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalTmscXtext.g:1030:4: otherlv_6= '(' ( (lv_parameters_7_0= ruleXFunctionParameter ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleXFunctionParameter ) ) )* otherlv_10= ')'
                    {
                    otherlv_6=(Token)match(input,34,FOLLOW_25); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_6, grammarAccess.getXFunctionAccess().getLeftParenthesisKeyword_4_0());
                      			
                    }
                    // InternalTmscXtext.g:1034:4: ( (lv_parameters_7_0= ruleXFunctionParameter ) )
                    // InternalTmscXtext.g:1035:5: (lv_parameters_7_0= ruleXFunctionParameter )
                    {
                    // InternalTmscXtext.g:1035:5: (lv_parameters_7_0= ruleXFunctionParameter )
                    // InternalTmscXtext.g:1036:6: lv_parameters_7_0= ruleXFunctionParameter
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getXFunctionAccess().getParametersXFunctionParameterParserRuleCall_4_1_0());
                      					
                    }
                    pushFollow(FOLLOW_26);
                    lv_parameters_7_0=ruleXFunctionParameter();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getXFunctionRule());
                      						}
                      						add(
                      							current,
                      							"parameters",
                      							lv_parameters_7_0,
                      							"nl.esi.pps.tmsc.xtext.TmscXtext.XFunctionParameter");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalTmscXtext.g:1053:4: (otherlv_8= ',' ( (lv_parameters_9_0= ruleXFunctionParameter ) ) )*
                    loop21:
                    do {
                        int alt21=2;
                        int LA21_0 = input.LA(1);

                        if ( (LA21_0==29) ) {
                            alt21=1;
                        }


                        switch (alt21) {
                    	case 1 :
                    	    // InternalTmscXtext.g:1054:5: otherlv_8= ',' ( (lv_parameters_9_0= ruleXFunctionParameter ) )
                    	    {
                    	    otherlv_8=(Token)match(input,29,FOLLOW_25); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_8, grammarAccess.getXFunctionAccess().getCommaKeyword_4_2_0());
                    	      				
                    	    }
                    	    // InternalTmscXtext.g:1058:5: ( (lv_parameters_9_0= ruleXFunctionParameter ) )
                    	    // InternalTmscXtext.g:1059:6: (lv_parameters_9_0= ruleXFunctionParameter )
                    	    {
                    	    // InternalTmscXtext.g:1059:6: (lv_parameters_9_0= ruleXFunctionParameter )
                    	    // InternalTmscXtext.g:1060:7: lv_parameters_9_0= ruleXFunctionParameter
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getXFunctionAccess().getParametersXFunctionParameterParserRuleCall_4_2_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_26);
                    	    lv_parameters_9_0=ruleXFunctionParameter();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getXFunctionRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"parameters",
                    	      								lv_parameters_9_0,
                    	      								"nl.esi.pps.tmsc.xtext.TmscXtext.XFunctionParameter");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop21;
                        }
                    } while (true);

                    otherlv_10=(Token)match(input,35,FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_10, grammarAccess.getXFunctionAccess().getRightParenthesisKeyword_4_3());
                      			
                    }

                    }
                    break;

            }

            // InternalTmscXtext.g:1083:3: (otherlv_11= 'implements' ( ( ruleFQN ) ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==36) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalTmscXtext.g:1084:4: otherlv_11= 'implements' ( ( ruleFQN ) )
                    {
                    otherlv_11=(Token)match(input,36,FOLLOW_18); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_11, grammarAccess.getXFunctionAccess().getImplementsKeyword_5_0());
                      			
                    }
                    // InternalTmscXtext.g:1088:4: ( ( ruleFQN ) )
                    // InternalTmscXtext.g:1089:5: ( ruleFQN )
                    {
                    // InternalTmscXtext.g:1089:5: ( ruleFQN )
                    // InternalTmscXtext.g:1090:6: ruleFQN
                    {
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getXFunctionRule());
                      						}
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getXFunctionAccess().getOperationXOperationCrossReference_5_1_0());
                      					
                    }
                    pushFollow(FOLLOW_13);
                    ruleFQN();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalTmscXtext.g:1105:3: (otherlv_13= '{' ( (otherlv_14= 'time-bound' otherlv_15= ':' ( (lv_timeBound_16_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_17= 'scheduled' otherlv_18= ':' ( (lv_scheduled_19_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_20_0= ruleXProperty ) ) )* otherlv_21= '}' )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==15) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalTmscXtext.g:1106:4: otherlv_13= '{' ( (otherlv_14= 'time-bound' otherlv_15= ':' ( (lv_timeBound_16_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_17= 'scheduled' otherlv_18= ':' ( (lv_scheduled_19_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_20_0= ruleXProperty ) ) )* otherlv_21= '}'
                    {
                    otherlv_13=(Token)match(input,15,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_13, grammarAccess.getXFunctionAccess().getLeftCurlyBracketKeyword_6_0());
                      			
                    }
                    // InternalTmscXtext.g:1110:4: ( (otherlv_14= 'time-bound' otherlv_15= ':' ( (lv_timeBound_16_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_17= 'scheduled' otherlv_18= ':' ( (lv_scheduled_19_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_20_0= ruleXProperty ) ) )*
                    loop24:
                    do {
                        int alt24=4;
                        switch ( input.LA(1) ) {
                        case 18:
                            {
                            alt24=1;
                            }
                            break;
                        case 19:
                            {
                            alt24=2;
                            }
                            break;
                        case RULE_ID:
                        case RULE_STRING:
                            {
                            alt24=3;
                            }
                            break;

                        }

                        switch (alt24) {
                    	case 1 :
                    	    // InternalTmscXtext.g:1111:5: (otherlv_14= 'time-bound' otherlv_15= ':' ( (lv_timeBound_16_0= RULE_ABS_EBIGDECIMAL ) ) )
                    	    {
                    	    // InternalTmscXtext.g:1111:5: (otherlv_14= 'time-bound' otherlv_15= ':' ( (lv_timeBound_16_0= RULE_ABS_EBIGDECIMAL ) ) )
                    	    // InternalTmscXtext.g:1112:6: otherlv_14= 'time-bound' otherlv_15= ':' ( (lv_timeBound_16_0= RULE_ABS_EBIGDECIMAL ) )
                    	    {
                    	    otherlv_14=(Token)match(input,18,FOLLOW_6); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_14, grammarAccess.getXFunctionAccess().getTimeBoundKeyword_6_1_0_0());
                    	      					
                    	    }
                    	    otherlv_15=(Token)match(input,17,FOLLOW_8); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_15, grammarAccess.getXFunctionAccess().getColonKeyword_6_1_0_1());
                    	      					
                    	    }
                    	    // InternalTmscXtext.g:1120:6: ( (lv_timeBound_16_0= RULE_ABS_EBIGDECIMAL ) )
                    	    // InternalTmscXtext.g:1121:7: (lv_timeBound_16_0= RULE_ABS_EBIGDECIMAL )
                    	    {
                    	    // InternalTmscXtext.g:1121:7: (lv_timeBound_16_0= RULE_ABS_EBIGDECIMAL )
                    	    // InternalTmscXtext.g:1122:8: lv_timeBound_16_0= RULE_ABS_EBIGDECIMAL
                    	    {
                    	    lv_timeBound_16_0=(Token)match(input,RULE_ABS_EBIGDECIMAL,FOLLOW_5); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      								newLeafNode(lv_timeBound_16_0, grammarAccess.getXFunctionAccess().getTimeBoundABS_EBIGDECIMALTerminalRuleCall_6_1_0_2_0());
                    	      							
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      								if (current==null) {
                    	      									current = createModelElement(grammarAccess.getXFunctionRule());
                    	      								}
                    	      								setWithLastConsumed(
                    	      									current,
                    	      									"timeBound",
                    	      									lv_timeBound_16_0,
                    	      									"nl.esi.pps.tmsc.xtext.TmscXtext.ABS_EBIGDECIMAL");
                    	      							
                    	    }

                    	    }


                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalTmscXtext.g:1140:5: (otherlv_17= 'scheduled' otherlv_18= ':' ( (lv_scheduled_19_0= ruleEBOOLEAN_OBJECT ) ) )
                    	    {
                    	    // InternalTmscXtext.g:1140:5: (otherlv_17= 'scheduled' otherlv_18= ':' ( (lv_scheduled_19_0= ruleEBOOLEAN_OBJECT ) ) )
                    	    // InternalTmscXtext.g:1141:6: otherlv_17= 'scheduled' otherlv_18= ':' ( (lv_scheduled_19_0= ruleEBOOLEAN_OBJECT ) )
                    	    {
                    	    otherlv_17=(Token)match(input,19,FOLLOW_6); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_17, grammarAccess.getXFunctionAccess().getScheduledKeyword_6_1_1_0());
                    	      					
                    	    }
                    	    otherlv_18=(Token)match(input,17,FOLLOW_9); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_18, grammarAccess.getXFunctionAccess().getColonKeyword_6_1_1_1());
                    	      					
                    	    }
                    	    // InternalTmscXtext.g:1149:6: ( (lv_scheduled_19_0= ruleEBOOLEAN_OBJECT ) )
                    	    // InternalTmscXtext.g:1150:7: (lv_scheduled_19_0= ruleEBOOLEAN_OBJECT )
                    	    {
                    	    // InternalTmscXtext.g:1150:7: (lv_scheduled_19_0= ruleEBOOLEAN_OBJECT )
                    	    // InternalTmscXtext.g:1151:8: lv_scheduled_19_0= ruleEBOOLEAN_OBJECT
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      								newCompositeNode(grammarAccess.getXFunctionAccess().getScheduledEBOOLEAN_OBJECTParserRuleCall_6_1_1_2_0());
                    	      							
                    	    }
                    	    pushFollow(FOLLOW_5);
                    	    lv_scheduled_19_0=ruleEBOOLEAN_OBJECT();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      								if (current==null) {
                    	      									current = createModelElementForParent(grammarAccess.getXFunctionRule());
                    	      								}
                    	      								set(
                    	      									current,
                    	      									"scheduled",
                    	      									lv_scheduled_19_0,
                    	      									"nl.esi.pps.tmsc.xtext.TmscXtext.EBOOLEAN_OBJECT");
                    	      								afterParserOrEnumRuleCall();
                    	      							
                    	    }

                    	    }


                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 3 :
                    	    // InternalTmscXtext.g:1170:5: ( (lv_properties_20_0= ruleXProperty ) )
                    	    {
                    	    // InternalTmscXtext.g:1170:5: ( (lv_properties_20_0= ruleXProperty ) )
                    	    // InternalTmscXtext.g:1171:6: (lv_properties_20_0= ruleXProperty )
                    	    {
                    	    // InternalTmscXtext.g:1171:6: (lv_properties_20_0= ruleXProperty )
                    	    // InternalTmscXtext.g:1172:7: lv_properties_20_0= ruleXProperty
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getXFunctionAccess().getPropertiesXPropertyParserRuleCall_6_1_2_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_5);
                    	    lv_properties_20_0=ruleXProperty();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getXFunctionRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"properties",
                    	      								lv_properties_20_0,
                    	      								"nl.esi.pps.tmsc.xtext.TmscXtext.XProperty");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop24;
                        }
                    } while (true);

                    otherlv_21=(Token)match(input,20,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_21, grammarAccess.getXFunctionAccess().getRightCurlyBracketKeyword_6_2());
                      			
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleXFunction"


    // $ANTLR start "entryRuleXFunctionParameter"
    // InternalTmscXtext.g:1199:1: entryRuleXFunctionParameter returns [EObject current=null] : iv_ruleXFunctionParameter= ruleXFunctionParameter EOF ;
    public final EObject entryRuleXFunctionParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXFunctionParameter = null;


        try {
            // InternalTmscXtext.g:1199:59: (iv_ruleXFunctionParameter= ruleXFunctionParameter EOF )
            // InternalTmscXtext.g:1200:2: iv_ruleXFunctionParameter= ruleXFunctionParameter EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXFunctionParameterRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXFunctionParameter=ruleXFunctionParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXFunctionParameter; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXFunctionParameter"


    // $ANTLR start "ruleXFunctionParameter"
    // InternalTmscXtext.g:1206:1: ruleXFunctionParameter returns [EObject current=null] : ( ( (lv_kind_0_0= ruleXFunctionParameterKind ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_properties_3_0= ruleXProperty ) ) (otherlv_4= ',' ( (lv_properties_5_0= ruleXProperty ) ) )* otherlv_6= ')' )? ) ;
    public final EObject ruleXFunctionParameter() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Enumerator lv_kind_0_0 = null;

        EObject lv_properties_3_0 = null;

        EObject lv_properties_5_0 = null;



        	enterRule();

        try {
            // InternalTmscXtext.g:1212:2: ( ( ( (lv_kind_0_0= ruleXFunctionParameterKind ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_properties_3_0= ruleXProperty ) ) (otherlv_4= ',' ( (lv_properties_5_0= ruleXProperty ) ) )* otherlv_6= ')' )? ) )
            // InternalTmscXtext.g:1213:2: ( ( (lv_kind_0_0= ruleXFunctionParameterKind ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_properties_3_0= ruleXProperty ) ) (otherlv_4= ',' ( (lv_properties_5_0= ruleXProperty ) ) )* otherlv_6= ')' )? )
            {
            // InternalTmscXtext.g:1213:2: ( ( (lv_kind_0_0= ruleXFunctionParameterKind ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_properties_3_0= ruleXProperty ) ) (otherlv_4= ',' ( (lv_properties_5_0= ruleXProperty ) ) )* otherlv_6= ')' )? )
            // InternalTmscXtext.g:1214:3: ( (lv_kind_0_0= ruleXFunctionParameterKind ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_properties_3_0= ruleXProperty ) ) (otherlv_4= ',' ( (lv_properties_5_0= ruleXProperty ) ) )* otherlv_6= ')' )?
            {
            // InternalTmscXtext.g:1214:3: ( (lv_kind_0_0= ruleXFunctionParameterKind ) )
            // InternalTmscXtext.g:1215:4: (lv_kind_0_0= ruleXFunctionParameterKind )
            {
            // InternalTmscXtext.g:1215:4: (lv_kind_0_0= ruleXFunctionParameterKind )
            // InternalTmscXtext.g:1216:5: lv_kind_0_0= ruleXFunctionParameterKind
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getXFunctionParameterAccess().getKindXFunctionParameterKindEnumRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_18);
            lv_kind_0_0=ruleXFunctionParameterKind();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getXFunctionParameterRule());
              					}
              					set(
              						current,
              						"kind",
              						lv_kind_0_0,
              						"nl.esi.pps.tmsc.xtext.TmscXtext.XFunctionParameterKind");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalTmscXtext.g:1233:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalTmscXtext.g:1234:4: (lv_name_1_0= RULE_ID )
            {
            // InternalTmscXtext.g:1234:4: (lv_name_1_0= RULE_ID )
            // InternalTmscXtext.g:1235:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_28); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getXFunctionParameterAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getXFunctionParameterRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"nl.esi.pps.tmsc.xtext.TmscXtext.ID");
              				
            }

            }


            }

            // InternalTmscXtext.g:1251:3: (otherlv_2= '(' ( (lv_properties_3_0= ruleXProperty ) ) (otherlv_4= ',' ( (lv_properties_5_0= ruleXProperty ) ) )* otherlv_6= ')' )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==34) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalTmscXtext.g:1252:4: otherlv_2= '(' ( (lv_properties_3_0= ruleXProperty ) ) (otherlv_4= ',' ( (lv_properties_5_0= ruleXProperty ) ) )* otherlv_6= ')'
                    {
                    otherlv_2=(Token)match(input,34,FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getXFunctionParameterAccess().getLeftParenthesisKeyword_2_0());
                      			
                    }
                    // InternalTmscXtext.g:1256:4: ( (lv_properties_3_0= ruleXProperty ) )
                    // InternalTmscXtext.g:1257:5: (lv_properties_3_0= ruleXProperty )
                    {
                    // InternalTmscXtext.g:1257:5: (lv_properties_3_0= ruleXProperty )
                    // InternalTmscXtext.g:1258:6: lv_properties_3_0= ruleXProperty
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getXFunctionParameterAccess().getPropertiesXPropertyParserRuleCall_2_1_0());
                      					
                    }
                    pushFollow(FOLLOW_26);
                    lv_properties_3_0=ruleXProperty();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getXFunctionParameterRule());
                      						}
                      						add(
                      							current,
                      							"properties",
                      							lv_properties_3_0,
                      							"nl.esi.pps.tmsc.xtext.TmscXtext.XProperty");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalTmscXtext.g:1275:4: (otherlv_4= ',' ( (lv_properties_5_0= ruleXProperty ) ) )*
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( (LA26_0==29) ) {
                            alt26=1;
                        }


                        switch (alt26) {
                    	case 1 :
                    	    // InternalTmscXtext.g:1276:5: otherlv_4= ',' ( (lv_properties_5_0= ruleXProperty ) )
                    	    {
                    	    otherlv_4=(Token)match(input,29,FOLLOW_16); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_4, grammarAccess.getXFunctionParameterAccess().getCommaKeyword_2_2_0());
                    	      				
                    	    }
                    	    // InternalTmscXtext.g:1280:5: ( (lv_properties_5_0= ruleXProperty ) )
                    	    // InternalTmscXtext.g:1281:6: (lv_properties_5_0= ruleXProperty )
                    	    {
                    	    // InternalTmscXtext.g:1281:6: (lv_properties_5_0= ruleXProperty )
                    	    // InternalTmscXtext.g:1282:7: lv_properties_5_0= ruleXProperty
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getXFunctionParameterAccess().getPropertiesXPropertyParserRuleCall_2_2_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_26);
                    	    lv_properties_5_0=ruleXProperty();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getXFunctionParameterRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"properties",
                    	      								lv_properties_5_0,
                    	      								"nl.esi.pps.tmsc.xtext.TmscXtext.XProperty");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop26;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,35,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_6, grammarAccess.getXFunctionParameterAccess().getRightParenthesisKeyword_2_3());
                      			
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleXFunctionParameter"


    // $ANTLR start "entryRuleXHost"
    // InternalTmscXtext.g:1309:1: entryRuleXHost returns [EObject current=null] : iv_ruleXHost= ruleXHost EOF ;
    public final EObject entryRuleXHost() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXHost = null;


        try {
            // InternalTmscXtext.g:1309:46: (iv_ruleXHost= ruleXHost EOF )
            // InternalTmscXtext.g:1310:2: iv_ruleXHost= ruleXHost EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXHostRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXHost=ruleXHost();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXHost; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXHost"


    // $ANTLR start "ruleXHost"
    // InternalTmscXtext.g:1316:1: ruleXHost returns [EObject current=null] : ( ( (lv_untraced_0_0= 'untraced' ) )? otherlv_1= 'host' ( ( (lv_description_2_0= ruleIDString ) ) otherlv_3= 'as' )? ( (lv_name_4_0= RULE_ID ) ) (otherlv_5= '{' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) | ( (lv_executors_13_0= ruleXExecutor ) ) )* otherlv_14= '}' )? ) ;
    public final EObject ruleXHost() throws RecognitionException {
        EObject current = null;

        Token lv_untraced_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token lv_name_4_0=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token lv_timeBound_8_0=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_14=null;
        AntlrDatatypeRuleToken lv_description_2_0 = null;

        AntlrDatatypeRuleToken lv_scheduled_11_0 = null;

        EObject lv_properties_12_0 = null;

        EObject lv_executors_13_0 = null;



        	enterRule();

        try {
            // InternalTmscXtext.g:1322:2: ( ( ( (lv_untraced_0_0= 'untraced' ) )? otherlv_1= 'host' ( ( (lv_description_2_0= ruleIDString ) ) otherlv_3= 'as' )? ( (lv_name_4_0= RULE_ID ) ) (otherlv_5= '{' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) | ( (lv_executors_13_0= ruleXExecutor ) ) )* otherlv_14= '}' )? ) )
            // InternalTmscXtext.g:1323:2: ( ( (lv_untraced_0_0= 'untraced' ) )? otherlv_1= 'host' ( ( (lv_description_2_0= ruleIDString ) ) otherlv_3= 'as' )? ( (lv_name_4_0= RULE_ID ) ) (otherlv_5= '{' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) | ( (lv_executors_13_0= ruleXExecutor ) ) )* otherlv_14= '}' )? )
            {
            // InternalTmscXtext.g:1323:2: ( ( (lv_untraced_0_0= 'untraced' ) )? otherlv_1= 'host' ( ( (lv_description_2_0= ruleIDString ) ) otherlv_3= 'as' )? ( (lv_name_4_0= RULE_ID ) ) (otherlv_5= '{' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) | ( (lv_executors_13_0= ruleXExecutor ) ) )* otherlv_14= '}' )? )
            // InternalTmscXtext.g:1324:3: ( (lv_untraced_0_0= 'untraced' ) )? otherlv_1= 'host' ( ( (lv_description_2_0= ruleIDString ) ) otherlv_3= 'as' )? ( (lv_name_4_0= RULE_ID ) ) (otherlv_5= '{' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) | ( (lv_executors_13_0= ruleXExecutor ) ) )* otherlv_14= '}' )?
            {
            // InternalTmscXtext.g:1324:3: ( (lv_untraced_0_0= 'untraced' ) )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==37) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalTmscXtext.g:1325:4: (lv_untraced_0_0= 'untraced' )
                    {
                    // InternalTmscXtext.g:1325:4: (lv_untraced_0_0= 'untraced' )
                    // InternalTmscXtext.g:1326:5: lv_untraced_0_0= 'untraced'
                    {
                    lv_untraced_0_0=(Token)match(input,37,FOLLOW_29); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_untraced_0_0, grammarAccess.getXHostAccess().getUntracedUntracedKeyword_0_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getXHostRule());
                      					}
                      					setWithLastConsumed(current, "untraced", lv_untraced_0_0 != null, "untraced");
                      				
                    }

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,38,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getXHostAccess().getHostKeyword_1());
              		
            }
            // InternalTmscXtext.g:1342:3: ( ( (lv_description_2_0= ruleIDString ) ) otherlv_3= 'as' )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==RULE_ID) ) {
                int LA29_1 = input.LA(2);

                if ( (LA29_1==25) ) {
                    alt29=1;
                }
            }
            else if ( (LA29_0==RULE_STRING) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalTmscXtext.g:1343:4: ( (lv_description_2_0= ruleIDString ) ) otherlv_3= 'as'
                    {
                    // InternalTmscXtext.g:1343:4: ( (lv_description_2_0= ruleIDString ) )
                    // InternalTmscXtext.g:1344:5: (lv_description_2_0= ruleIDString )
                    {
                    // InternalTmscXtext.g:1344:5: (lv_description_2_0= ruleIDString )
                    // InternalTmscXtext.g:1345:6: lv_description_2_0= ruleIDString
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getXHostAccess().getDescriptionIDStringParserRuleCall_2_0_0());
                      					
                    }
                    pushFollow(FOLLOW_17);
                    lv_description_2_0=ruleIDString();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getXHostRule());
                      						}
                      						set(
                      							current,
                      							"description",
                      							lv_description_2_0,
                      							"nl.esi.pps.tmsc.xtext.TmscXtext.IDString");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    otherlv_3=(Token)match(input,25,FOLLOW_18); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getXHostAccess().getAsKeyword_2_1());
                      			
                    }

                    }
                    break;

            }

            // InternalTmscXtext.g:1367:3: ( (lv_name_4_0= RULE_ID ) )
            // InternalTmscXtext.g:1368:4: (lv_name_4_0= RULE_ID )
            {
            // InternalTmscXtext.g:1368:4: (lv_name_4_0= RULE_ID )
            // InternalTmscXtext.g:1369:5: lv_name_4_0= RULE_ID
            {
            lv_name_4_0=(Token)match(input,RULE_ID,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_4_0, grammarAccess.getXHostAccess().getNameIDTerminalRuleCall_3_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getXHostRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_4_0,
              						"nl.esi.pps.tmsc.xtext.TmscXtext.ID");
              				
            }

            }


            }

            // InternalTmscXtext.g:1385:3: (otherlv_5= '{' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) | ( (lv_executors_13_0= ruleXExecutor ) ) )* otherlv_14= '}' )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==15) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalTmscXtext.g:1386:4: otherlv_5= '{' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) | ( (lv_executors_13_0= ruleXExecutor ) ) )* otherlv_14= '}'
                    {
                    otherlv_5=(Token)match(input,15,FOLLOW_30); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getXHostAccess().getLeftCurlyBracketKeyword_4_0());
                      			
                    }
                    // InternalTmscXtext.g:1390:4: ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) | ( (lv_executors_13_0= ruleXExecutor ) ) )*
                    loop30:
                    do {
                        int alt30=5;
                        switch ( input.LA(1) ) {
                        case 18:
                            {
                            alt30=1;
                            }
                            break;
                        case 19:
                            {
                            alt30=2;
                            }
                            break;
                        case RULE_ID:
                        case RULE_STRING:
                            {
                            alt30=3;
                            }
                            break;
                        case 37:
                        case 39:
                            {
                            alt30=4;
                            }
                            break;

                        }

                        switch (alt30) {
                    	case 1 :
                    	    // InternalTmscXtext.g:1391:5: (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) )
                    	    {
                    	    // InternalTmscXtext.g:1391:5: (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) )
                    	    // InternalTmscXtext.g:1392:6: otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) )
                    	    {
                    	    otherlv_6=(Token)match(input,18,FOLLOW_6); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_6, grammarAccess.getXHostAccess().getTimeBoundKeyword_4_1_0_0());
                    	      					
                    	    }
                    	    otherlv_7=(Token)match(input,17,FOLLOW_8); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_7, grammarAccess.getXHostAccess().getColonKeyword_4_1_0_1());
                    	      					
                    	    }
                    	    // InternalTmscXtext.g:1400:6: ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) )
                    	    // InternalTmscXtext.g:1401:7: (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL )
                    	    {
                    	    // InternalTmscXtext.g:1401:7: (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL )
                    	    // InternalTmscXtext.g:1402:8: lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL
                    	    {
                    	    lv_timeBound_8_0=(Token)match(input,RULE_ABS_EBIGDECIMAL,FOLLOW_30); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      								newLeafNode(lv_timeBound_8_0, grammarAccess.getXHostAccess().getTimeBoundABS_EBIGDECIMALTerminalRuleCall_4_1_0_2_0());
                    	      							
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      								if (current==null) {
                    	      									current = createModelElement(grammarAccess.getXHostRule());
                    	      								}
                    	      								setWithLastConsumed(
                    	      									current,
                    	      									"timeBound",
                    	      									lv_timeBound_8_0,
                    	      									"nl.esi.pps.tmsc.xtext.TmscXtext.ABS_EBIGDECIMAL");
                    	      							
                    	    }

                    	    }


                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalTmscXtext.g:1420:5: (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) )
                    	    {
                    	    // InternalTmscXtext.g:1420:5: (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) )
                    	    // InternalTmscXtext.g:1421:6: otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) )
                    	    {
                    	    otherlv_9=(Token)match(input,19,FOLLOW_6); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_9, grammarAccess.getXHostAccess().getScheduledKeyword_4_1_1_0());
                    	      					
                    	    }
                    	    otherlv_10=(Token)match(input,17,FOLLOW_9); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_10, grammarAccess.getXHostAccess().getColonKeyword_4_1_1_1());
                    	      					
                    	    }
                    	    // InternalTmscXtext.g:1429:6: ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) )
                    	    // InternalTmscXtext.g:1430:7: (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT )
                    	    {
                    	    // InternalTmscXtext.g:1430:7: (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT )
                    	    // InternalTmscXtext.g:1431:8: lv_scheduled_11_0= ruleEBOOLEAN_OBJECT
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      								newCompositeNode(grammarAccess.getXHostAccess().getScheduledEBOOLEAN_OBJECTParserRuleCall_4_1_1_2_0());
                    	      							
                    	    }
                    	    pushFollow(FOLLOW_30);
                    	    lv_scheduled_11_0=ruleEBOOLEAN_OBJECT();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      								if (current==null) {
                    	      									current = createModelElementForParent(grammarAccess.getXHostRule());
                    	      								}
                    	      								set(
                    	      									current,
                    	      									"scheduled",
                    	      									lv_scheduled_11_0,
                    	      									"nl.esi.pps.tmsc.xtext.TmscXtext.EBOOLEAN_OBJECT");
                    	      								afterParserOrEnumRuleCall();
                    	      							
                    	    }

                    	    }


                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 3 :
                    	    // InternalTmscXtext.g:1450:5: ( (lv_properties_12_0= ruleXProperty ) )
                    	    {
                    	    // InternalTmscXtext.g:1450:5: ( (lv_properties_12_0= ruleXProperty ) )
                    	    // InternalTmscXtext.g:1451:6: (lv_properties_12_0= ruleXProperty )
                    	    {
                    	    // InternalTmscXtext.g:1451:6: (lv_properties_12_0= ruleXProperty )
                    	    // InternalTmscXtext.g:1452:7: lv_properties_12_0= ruleXProperty
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getXHostAccess().getPropertiesXPropertyParserRuleCall_4_1_2_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_30);
                    	    lv_properties_12_0=ruleXProperty();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getXHostRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"properties",
                    	      								lv_properties_12_0,
                    	      								"nl.esi.pps.tmsc.xtext.TmscXtext.XProperty");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 4 :
                    	    // InternalTmscXtext.g:1470:5: ( (lv_executors_13_0= ruleXExecutor ) )
                    	    {
                    	    // InternalTmscXtext.g:1470:5: ( (lv_executors_13_0= ruleXExecutor ) )
                    	    // InternalTmscXtext.g:1471:6: (lv_executors_13_0= ruleXExecutor )
                    	    {
                    	    // InternalTmscXtext.g:1471:6: (lv_executors_13_0= ruleXExecutor )
                    	    // InternalTmscXtext.g:1472:7: lv_executors_13_0= ruleXExecutor
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getXHostAccess().getExecutorsXExecutorParserRuleCall_4_1_3_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_30);
                    	    lv_executors_13_0=ruleXExecutor();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getXHostRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"executors",
                    	      								lv_executors_13_0,
                    	      								"nl.esi.pps.tmsc.xtext.TmscXtext.XExecutor");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop30;
                        }
                    } while (true);

                    otherlv_14=(Token)match(input,20,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_14, grammarAccess.getXHostAccess().getRightCurlyBracketKeyword_4_2());
                      			
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleXHost"


    // $ANTLR start "entryRuleXExecutor"
    // InternalTmscXtext.g:1499:1: entryRuleXExecutor returns [EObject current=null] : iv_ruleXExecutor= ruleXExecutor EOF ;
    public final EObject entryRuleXExecutor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXExecutor = null;


        try {
            // InternalTmscXtext.g:1499:50: (iv_ruleXExecutor= ruleXExecutor EOF )
            // InternalTmscXtext.g:1500:2: iv_ruleXExecutor= ruleXExecutor EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXExecutorRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXExecutor=ruleXExecutor();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXExecutor; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXExecutor"


    // $ANTLR start "ruleXExecutor"
    // InternalTmscXtext.g:1506:1: ruleXExecutor returns [EObject current=null] : ( ( (lv_untraced_0_0= 'untraced' ) )? otherlv_1= 'executor' ( ( (lv_description_2_0= ruleIDString ) ) otherlv_3= 'as' )? ( (lv_name_4_0= RULE_ID ) ) (otherlv_5= '{' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) )* otherlv_13= '}' )? ) ;
    public final EObject ruleXExecutor() throws RecognitionException {
        EObject current = null;

        Token lv_untraced_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token lv_name_4_0=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token lv_timeBound_8_0=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_13=null;
        AntlrDatatypeRuleToken lv_description_2_0 = null;

        AntlrDatatypeRuleToken lv_scheduled_11_0 = null;

        EObject lv_properties_12_0 = null;



        	enterRule();

        try {
            // InternalTmscXtext.g:1512:2: ( ( ( (lv_untraced_0_0= 'untraced' ) )? otherlv_1= 'executor' ( ( (lv_description_2_0= ruleIDString ) ) otherlv_3= 'as' )? ( (lv_name_4_0= RULE_ID ) ) (otherlv_5= '{' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) )* otherlv_13= '}' )? ) )
            // InternalTmscXtext.g:1513:2: ( ( (lv_untraced_0_0= 'untraced' ) )? otherlv_1= 'executor' ( ( (lv_description_2_0= ruleIDString ) ) otherlv_3= 'as' )? ( (lv_name_4_0= RULE_ID ) ) (otherlv_5= '{' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) )* otherlv_13= '}' )? )
            {
            // InternalTmscXtext.g:1513:2: ( ( (lv_untraced_0_0= 'untraced' ) )? otherlv_1= 'executor' ( ( (lv_description_2_0= ruleIDString ) ) otherlv_3= 'as' )? ( (lv_name_4_0= RULE_ID ) ) (otherlv_5= '{' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) )* otherlv_13= '}' )? )
            // InternalTmscXtext.g:1514:3: ( (lv_untraced_0_0= 'untraced' ) )? otherlv_1= 'executor' ( ( (lv_description_2_0= ruleIDString ) ) otherlv_3= 'as' )? ( (lv_name_4_0= RULE_ID ) ) (otherlv_5= '{' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) )* otherlv_13= '}' )?
            {
            // InternalTmscXtext.g:1514:3: ( (lv_untraced_0_0= 'untraced' ) )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==37) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalTmscXtext.g:1515:4: (lv_untraced_0_0= 'untraced' )
                    {
                    // InternalTmscXtext.g:1515:4: (lv_untraced_0_0= 'untraced' )
                    // InternalTmscXtext.g:1516:5: lv_untraced_0_0= 'untraced'
                    {
                    lv_untraced_0_0=(Token)match(input,37,FOLLOW_31); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_untraced_0_0, grammarAccess.getXExecutorAccess().getUntracedUntracedKeyword_0_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getXExecutorRule());
                      					}
                      					setWithLastConsumed(current, "untraced", lv_untraced_0_0 != null, "untraced");
                      				
                    }

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,39,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getXExecutorAccess().getExecutorKeyword_1());
              		
            }
            // InternalTmscXtext.g:1532:3: ( ( (lv_description_2_0= ruleIDString ) ) otherlv_3= 'as' )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==RULE_ID) ) {
                int LA33_1 = input.LA(2);

                if ( (LA33_1==25) ) {
                    alt33=1;
                }
            }
            else if ( (LA33_0==RULE_STRING) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalTmscXtext.g:1533:4: ( (lv_description_2_0= ruleIDString ) ) otherlv_3= 'as'
                    {
                    // InternalTmscXtext.g:1533:4: ( (lv_description_2_0= ruleIDString ) )
                    // InternalTmscXtext.g:1534:5: (lv_description_2_0= ruleIDString )
                    {
                    // InternalTmscXtext.g:1534:5: (lv_description_2_0= ruleIDString )
                    // InternalTmscXtext.g:1535:6: lv_description_2_0= ruleIDString
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getXExecutorAccess().getDescriptionIDStringParserRuleCall_2_0_0());
                      					
                    }
                    pushFollow(FOLLOW_17);
                    lv_description_2_0=ruleIDString();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getXExecutorRule());
                      						}
                      						set(
                      							current,
                      							"description",
                      							lv_description_2_0,
                      							"nl.esi.pps.tmsc.xtext.TmscXtext.IDString");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    otherlv_3=(Token)match(input,25,FOLLOW_18); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getXExecutorAccess().getAsKeyword_2_1());
                      			
                    }

                    }
                    break;

            }

            // InternalTmscXtext.g:1557:3: ( (lv_name_4_0= RULE_ID ) )
            // InternalTmscXtext.g:1558:4: (lv_name_4_0= RULE_ID )
            {
            // InternalTmscXtext.g:1558:4: (lv_name_4_0= RULE_ID )
            // InternalTmscXtext.g:1559:5: lv_name_4_0= RULE_ID
            {
            lv_name_4_0=(Token)match(input,RULE_ID,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_4_0, grammarAccess.getXExecutorAccess().getNameIDTerminalRuleCall_3_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getXExecutorRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_4_0,
              						"nl.esi.pps.tmsc.xtext.TmscXtext.ID");
              				
            }

            }


            }

            // InternalTmscXtext.g:1575:3: (otherlv_5= '{' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) )* otherlv_13= '}' )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==15) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalTmscXtext.g:1576:4: otherlv_5= '{' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) )* otherlv_13= '}'
                    {
                    otherlv_5=(Token)match(input,15,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getXExecutorAccess().getLeftCurlyBracketKeyword_4_0());
                      			
                    }
                    // InternalTmscXtext.g:1580:4: ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) )*
                    loop34:
                    do {
                        int alt34=4;
                        switch ( input.LA(1) ) {
                        case 18:
                            {
                            alt34=1;
                            }
                            break;
                        case 19:
                            {
                            alt34=2;
                            }
                            break;
                        case RULE_ID:
                        case RULE_STRING:
                            {
                            alt34=3;
                            }
                            break;

                        }

                        switch (alt34) {
                    	case 1 :
                    	    // InternalTmscXtext.g:1581:5: (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) )
                    	    {
                    	    // InternalTmscXtext.g:1581:5: (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) )
                    	    // InternalTmscXtext.g:1582:6: otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) )
                    	    {
                    	    otherlv_6=(Token)match(input,18,FOLLOW_6); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_6, grammarAccess.getXExecutorAccess().getTimeBoundKeyword_4_1_0_0());
                    	      					
                    	    }
                    	    otherlv_7=(Token)match(input,17,FOLLOW_8); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_7, grammarAccess.getXExecutorAccess().getColonKeyword_4_1_0_1());
                    	      					
                    	    }
                    	    // InternalTmscXtext.g:1590:6: ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) )
                    	    // InternalTmscXtext.g:1591:7: (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL )
                    	    {
                    	    // InternalTmscXtext.g:1591:7: (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL )
                    	    // InternalTmscXtext.g:1592:8: lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL
                    	    {
                    	    lv_timeBound_8_0=(Token)match(input,RULE_ABS_EBIGDECIMAL,FOLLOW_5); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      								newLeafNode(lv_timeBound_8_0, grammarAccess.getXExecutorAccess().getTimeBoundABS_EBIGDECIMALTerminalRuleCall_4_1_0_2_0());
                    	      							
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      								if (current==null) {
                    	      									current = createModelElement(grammarAccess.getXExecutorRule());
                    	      								}
                    	      								setWithLastConsumed(
                    	      									current,
                    	      									"timeBound",
                    	      									lv_timeBound_8_0,
                    	      									"nl.esi.pps.tmsc.xtext.TmscXtext.ABS_EBIGDECIMAL");
                    	      							
                    	    }

                    	    }


                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalTmscXtext.g:1610:5: (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) )
                    	    {
                    	    // InternalTmscXtext.g:1610:5: (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) )
                    	    // InternalTmscXtext.g:1611:6: otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) )
                    	    {
                    	    otherlv_9=(Token)match(input,19,FOLLOW_6); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_9, grammarAccess.getXExecutorAccess().getScheduledKeyword_4_1_1_0());
                    	      					
                    	    }
                    	    otherlv_10=(Token)match(input,17,FOLLOW_9); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_10, grammarAccess.getXExecutorAccess().getColonKeyword_4_1_1_1());
                    	      					
                    	    }
                    	    // InternalTmscXtext.g:1619:6: ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) )
                    	    // InternalTmscXtext.g:1620:7: (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT )
                    	    {
                    	    // InternalTmscXtext.g:1620:7: (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT )
                    	    // InternalTmscXtext.g:1621:8: lv_scheduled_11_0= ruleEBOOLEAN_OBJECT
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      								newCompositeNode(grammarAccess.getXExecutorAccess().getScheduledEBOOLEAN_OBJECTParserRuleCall_4_1_1_2_0());
                    	      							
                    	    }
                    	    pushFollow(FOLLOW_5);
                    	    lv_scheduled_11_0=ruleEBOOLEAN_OBJECT();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      								if (current==null) {
                    	      									current = createModelElementForParent(grammarAccess.getXExecutorRule());
                    	      								}
                    	      								set(
                    	      									current,
                    	      									"scheduled",
                    	      									lv_scheduled_11_0,
                    	      									"nl.esi.pps.tmsc.xtext.TmscXtext.EBOOLEAN_OBJECT");
                    	      								afterParserOrEnumRuleCall();
                    	      							
                    	    }

                    	    }


                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 3 :
                    	    // InternalTmscXtext.g:1640:5: ( (lv_properties_12_0= ruleXProperty ) )
                    	    {
                    	    // InternalTmscXtext.g:1640:5: ( (lv_properties_12_0= ruleXProperty ) )
                    	    // InternalTmscXtext.g:1641:6: (lv_properties_12_0= ruleXProperty )
                    	    {
                    	    // InternalTmscXtext.g:1641:6: (lv_properties_12_0= ruleXProperty )
                    	    // InternalTmscXtext.g:1642:7: lv_properties_12_0= ruleXProperty
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getXExecutorAccess().getPropertiesXPropertyParserRuleCall_4_1_2_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_5);
                    	    lv_properties_12_0=ruleXProperty();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getXExecutorRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"properties",
                    	      								lv_properties_12_0,
                    	      								"nl.esi.pps.tmsc.xtext.TmscXtext.XProperty");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop34;
                        }
                    } while (true);

                    otherlv_13=(Token)match(input,20,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_13, grammarAccess.getXExecutorAccess().getRightCurlyBracketKeyword_4_2());
                      			
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleXExecutor"


    // $ANTLR start "entryRuleXEvent"
    // InternalTmscXtext.g:1669:1: entryRuleXEvent returns [EObject current=null] : iv_ruleXEvent= ruleXEvent EOF ;
    public final EObject entryRuleXEvent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXEvent = null;


        try {
            // InternalTmscXtext.g:1669:47: (iv_ruleXEvent= ruleXEvent EOF )
            // InternalTmscXtext.g:1670:2: iv_ruleXEvent= ruleXEvent EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXEventRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXEvent=ruleXEvent();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXEvent; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXEvent"


    // $ANTLR start "ruleXEvent"
    // InternalTmscXtext.g:1676:1: ruleXEvent returns [EObject current=null] : ( ( ( (lv_timestamp_0_1= RULE_ISO8601 | lv_timestamp_0_2= RULE_ABS_EBIGDECIMAL ) ) )? ( (lv_timeBound_1_0= RULE_POS_EBIGDECIMAL ) )? ( ( ruleFQNString ) ) ( ( ruleIDString ) )? ( (lv_type_4_0= ruleXEventType ) ) ( ( ruleIDString ) ) (otherlv_6= '(' ( (lv_arguments_7_0= ruleXEventArgument ) ) (otherlv_8= ',' ( (lv_arguments_9_0= ruleXEventArgument ) ) )* otherlv_10= ')' )? ( (otherlv_11= '!' ( (lv_outgoingDependencies_12_0= ruleXDependency ) ) ) | (otherlv_13= '?' ( ( ruleIDString ) ) ) )* (otherlv_15= '{' ( (otherlv_16= 'time-bound' otherlv_17= ':' ( (lv_timeBound_18_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_19= 'scheduled' otherlv_20= ':' ( (lv_scheduled_21_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_22_0= ruleXProperty ) ) )* otherlv_23= '}' )? ) ;
    public final EObject ruleXEvent() throws RecognitionException {
        EObject current = null;

        Token lv_timestamp_0_1=null;
        Token lv_timestamp_0_2=null;
        Token lv_timeBound_1_0=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token lv_timeBound_18_0=null;
        Token otherlv_19=null;
        Token otherlv_20=null;
        Token otherlv_23=null;
        Enumerator lv_type_4_0 = null;

        EObject lv_arguments_7_0 = null;

        EObject lv_arguments_9_0 = null;

        EObject lv_outgoingDependencies_12_0 = null;

        AntlrDatatypeRuleToken lv_scheduled_21_0 = null;

        EObject lv_properties_22_0 = null;



        	enterRule();

        try {
            // InternalTmscXtext.g:1682:2: ( ( ( ( (lv_timestamp_0_1= RULE_ISO8601 | lv_timestamp_0_2= RULE_ABS_EBIGDECIMAL ) ) )? ( (lv_timeBound_1_0= RULE_POS_EBIGDECIMAL ) )? ( ( ruleFQNString ) ) ( ( ruleIDString ) )? ( (lv_type_4_0= ruleXEventType ) ) ( ( ruleIDString ) ) (otherlv_6= '(' ( (lv_arguments_7_0= ruleXEventArgument ) ) (otherlv_8= ',' ( (lv_arguments_9_0= ruleXEventArgument ) ) )* otherlv_10= ')' )? ( (otherlv_11= '!' ( (lv_outgoingDependencies_12_0= ruleXDependency ) ) ) | (otherlv_13= '?' ( ( ruleIDString ) ) ) )* (otherlv_15= '{' ( (otherlv_16= 'time-bound' otherlv_17= ':' ( (lv_timeBound_18_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_19= 'scheduled' otherlv_20= ':' ( (lv_scheduled_21_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_22_0= ruleXProperty ) ) )* otherlv_23= '}' )? ) )
            // InternalTmscXtext.g:1683:2: ( ( ( (lv_timestamp_0_1= RULE_ISO8601 | lv_timestamp_0_2= RULE_ABS_EBIGDECIMAL ) ) )? ( (lv_timeBound_1_0= RULE_POS_EBIGDECIMAL ) )? ( ( ruleFQNString ) ) ( ( ruleIDString ) )? ( (lv_type_4_0= ruleXEventType ) ) ( ( ruleIDString ) ) (otherlv_6= '(' ( (lv_arguments_7_0= ruleXEventArgument ) ) (otherlv_8= ',' ( (lv_arguments_9_0= ruleXEventArgument ) ) )* otherlv_10= ')' )? ( (otherlv_11= '!' ( (lv_outgoingDependencies_12_0= ruleXDependency ) ) ) | (otherlv_13= '?' ( ( ruleIDString ) ) ) )* (otherlv_15= '{' ( (otherlv_16= 'time-bound' otherlv_17= ':' ( (lv_timeBound_18_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_19= 'scheduled' otherlv_20= ':' ( (lv_scheduled_21_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_22_0= ruleXProperty ) ) )* otherlv_23= '}' )? )
            {
            // InternalTmscXtext.g:1683:2: ( ( ( (lv_timestamp_0_1= RULE_ISO8601 | lv_timestamp_0_2= RULE_ABS_EBIGDECIMAL ) ) )? ( (lv_timeBound_1_0= RULE_POS_EBIGDECIMAL ) )? ( ( ruleFQNString ) ) ( ( ruleIDString ) )? ( (lv_type_4_0= ruleXEventType ) ) ( ( ruleIDString ) ) (otherlv_6= '(' ( (lv_arguments_7_0= ruleXEventArgument ) ) (otherlv_8= ',' ( (lv_arguments_9_0= ruleXEventArgument ) ) )* otherlv_10= ')' )? ( (otherlv_11= '!' ( (lv_outgoingDependencies_12_0= ruleXDependency ) ) ) | (otherlv_13= '?' ( ( ruleIDString ) ) ) )* (otherlv_15= '{' ( (otherlv_16= 'time-bound' otherlv_17= ':' ( (lv_timeBound_18_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_19= 'scheduled' otherlv_20= ':' ( (lv_scheduled_21_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_22_0= ruleXProperty ) ) )* otherlv_23= '}' )? )
            // InternalTmscXtext.g:1684:3: ( ( (lv_timestamp_0_1= RULE_ISO8601 | lv_timestamp_0_2= RULE_ABS_EBIGDECIMAL ) ) )? ( (lv_timeBound_1_0= RULE_POS_EBIGDECIMAL ) )? ( ( ruleFQNString ) ) ( ( ruleIDString ) )? ( (lv_type_4_0= ruleXEventType ) ) ( ( ruleIDString ) ) (otherlv_6= '(' ( (lv_arguments_7_0= ruleXEventArgument ) ) (otherlv_8= ',' ( (lv_arguments_9_0= ruleXEventArgument ) ) )* otherlv_10= ')' )? ( (otherlv_11= '!' ( (lv_outgoingDependencies_12_0= ruleXDependency ) ) ) | (otherlv_13= '?' ( ( ruleIDString ) ) ) )* (otherlv_15= '{' ( (otherlv_16= 'time-bound' otherlv_17= ':' ( (lv_timeBound_18_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_19= 'scheduled' otherlv_20= ':' ( (lv_scheduled_21_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_22_0= ruleXProperty ) ) )* otherlv_23= '}' )?
            {
            // InternalTmscXtext.g:1684:3: ( ( (lv_timestamp_0_1= RULE_ISO8601 | lv_timestamp_0_2= RULE_ABS_EBIGDECIMAL ) ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==RULE_ABS_EBIGDECIMAL||LA37_0==RULE_ISO8601) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalTmscXtext.g:1685:4: ( (lv_timestamp_0_1= RULE_ISO8601 | lv_timestamp_0_2= RULE_ABS_EBIGDECIMAL ) )
                    {
                    // InternalTmscXtext.g:1685:4: ( (lv_timestamp_0_1= RULE_ISO8601 | lv_timestamp_0_2= RULE_ABS_EBIGDECIMAL ) )
                    // InternalTmscXtext.g:1686:5: (lv_timestamp_0_1= RULE_ISO8601 | lv_timestamp_0_2= RULE_ABS_EBIGDECIMAL )
                    {
                    // InternalTmscXtext.g:1686:5: (lv_timestamp_0_1= RULE_ISO8601 | lv_timestamp_0_2= RULE_ABS_EBIGDECIMAL )
                    int alt36=2;
                    int LA36_0 = input.LA(1);

                    if ( (LA36_0==RULE_ISO8601) ) {
                        alt36=1;
                    }
                    else if ( (LA36_0==RULE_ABS_EBIGDECIMAL) ) {
                        alt36=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 36, 0, input);

                        throw nvae;
                    }
                    switch (alt36) {
                        case 1 :
                            // InternalTmscXtext.g:1687:6: lv_timestamp_0_1= RULE_ISO8601
                            {
                            lv_timestamp_0_1=(Token)match(input,RULE_ISO8601,FOLLOW_32); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(lv_timestamp_0_1, grammarAccess.getXEventAccess().getTimestampISO8601TerminalRuleCall_0_0_0());
                              					
                            }
                            if ( state.backtracking==0 ) {

                              						if (current==null) {
                              							current = createModelElement(grammarAccess.getXEventRule());
                              						}
                              						setWithLastConsumed(
                              							current,
                              							"timestamp",
                              							lv_timestamp_0_1,
                              							"nl.esi.pps.tmsc.xtext.TmscXtext.ISO8601");
                              					
                            }

                            }
                            break;
                        case 2 :
                            // InternalTmscXtext.g:1702:6: lv_timestamp_0_2= RULE_ABS_EBIGDECIMAL
                            {
                            lv_timestamp_0_2=(Token)match(input,RULE_ABS_EBIGDECIMAL,FOLLOW_32); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(lv_timestamp_0_2, grammarAccess.getXEventAccess().getTimestampABS_EBIGDECIMALTerminalRuleCall_0_0_1());
                              					
                            }
                            if ( state.backtracking==0 ) {

                              						if (current==null) {
                              							current = createModelElement(grammarAccess.getXEventRule());
                              						}
                              						setWithLastConsumed(
                              							current,
                              							"timestamp",
                              							lv_timestamp_0_2,
                              							"nl.esi.pps.tmsc.xtext.TmscXtext.ABS_EBIGDECIMAL");
                              					
                            }

                            }
                            break;

                    }


                    }


                    }
                    break;

            }

            // InternalTmscXtext.g:1719:3: ( (lv_timeBound_1_0= RULE_POS_EBIGDECIMAL ) )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==RULE_POS_EBIGDECIMAL) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalTmscXtext.g:1720:4: (lv_timeBound_1_0= RULE_POS_EBIGDECIMAL )
                    {
                    // InternalTmscXtext.g:1720:4: (lv_timeBound_1_0= RULE_POS_EBIGDECIMAL )
                    // InternalTmscXtext.g:1721:5: lv_timeBound_1_0= RULE_POS_EBIGDECIMAL
                    {
                    lv_timeBound_1_0=(Token)match(input,RULE_POS_EBIGDECIMAL,FOLLOW_32); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_timeBound_1_0, grammarAccess.getXEventAccess().getTimeBoundPOS_EBIGDECIMALTerminalRuleCall_1_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getXEventRule());
                      					}
                      					setWithLastConsumed(
                      						current,
                      						"timeBound",
                      						lv_timeBound_1_0,
                      						"nl.esi.pps.tmsc.xtext.TmscXtext.POS_EBIGDECIMAL");
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalTmscXtext.g:1737:3: ( ( ruleFQNString ) )
            // InternalTmscXtext.g:1738:4: ( ruleFQNString )
            {
            // InternalTmscXtext.g:1738:4: ( ruleFQNString )
            // InternalTmscXtext.g:1739:5: ruleFQNString
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getXEventRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getXEventAccess().getExecutorXExecutorCrossReference_2_0());
              				
            }
            pushFollow(FOLLOW_32);
            ruleFQNString();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalTmscXtext.g:1753:3: ( ( ruleIDString ) )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==RULE_ID||LA39_0==RULE_STRING) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // InternalTmscXtext.g:1754:4: ( ruleIDString )
                    {
                    // InternalTmscXtext.g:1754:4: ( ruleIDString )
                    // InternalTmscXtext.g:1755:5: ruleIDString
                    {
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getXEventRule());
                      					}
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getXEventAccess().getComponentXComponentCrossReference_3_0());
                      				
                    }
                    pushFollow(FOLLOW_32);
                    ruleIDString();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalTmscXtext.g:1769:3: ( (lv_type_4_0= ruleXEventType ) )
            // InternalTmscXtext.g:1770:4: (lv_type_4_0= ruleXEventType )
            {
            // InternalTmscXtext.g:1770:4: (lv_type_4_0= ruleXEventType )
            // InternalTmscXtext.g:1771:5: lv_type_4_0= ruleXEventType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getXEventAccess().getTypeXEventTypeEnumRuleCall_4_0());
              				
            }
            pushFollow(FOLLOW_16);
            lv_type_4_0=ruleXEventType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getXEventRule());
              					}
              					set(
              						current,
              						"type",
              						lv_type_4_0,
              						"nl.esi.pps.tmsc.xtext.TmscXtext.XEventType");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalTmscXtext.g:1788:3: ( ( ruleIDString ) )
            // InternalTmscXtext.g:1789:4: ( ruleIDString )
            {
            // InternalTmscXtext.g:1789:4: ( ruleIDString )
            // InternalTmscXtext.g:1790:5: ruleIDString
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getXEventRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getXEventAccess().getFunctionXFunctionCrossReference_5_0());
              				
            }
            pushFollow(FOLLOW_33);
            ruleIDString();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalTmscXtext.g:1804:3: (otherlv_6= '(' ( (lv_arguments_7_0= ruleXEventArgument ) ) (otherlv_8= ',' ( (lv_arguments_9_0= ruleXEventArgument ) ) )* otherlv_10= ')' )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==34) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalTmscXtext.g:1805:4: otherlv_6= '(' ( (lv_arguments_7_0= ruleXEventArgument ) ) (otherlv_8= ',' ( (lv_arguments_9_0= ruleXEventArgument ) ) )* otherlv_10= ')'
                    {
                    otherlv_6=(Token)match(input,34,FOLLOW_18); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_6, grammarAccess.getXEventAccess().getLeftParenthesisKeyword_6_0());
                      			
                    }
                    // InternalTmscXtext.g:1809:4: ( (lv_arguments_7_0= ruleXEventArgument ) )
                    // InternalTmscXtext.g:1810:5: (lv_arguments_7_0= ruleXEventArgument )
                    {
                    // InternalTmscXtext.g:1810:5: (lv_arguments_7_0= ruleXEventArgument )
                    // InternalTmscXtext.g:1811:6: lv_arguments_7_0= ruleXEventArgument
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getXEventAccess().getArgumentsXEventArgumentParserRuleCall_6_1_0());
                      					
                    }
                    pushFollow(FOLLOW_26);
                    lv_arguments_7_0=ruleXEventArgument();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getXEventRule());
                      						}
                      						add(
                      							current,
                      							"arguments",
                      							lv_arguments_7_0,
                      							"nl.esi.pps.tmsc.xtext.TmscXtext.XEventArgument");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalTmscXtext.g:1828:4: (otherlv_8= ',' ( (lv_arguments_9_0= ruleXEventArgument ) ) )*
                    loop40:
                    do {
                        int alt40=2;
                        int LA40_0 = input.LA(1);

                        if ( (LA40_0==29) ) {
                            alt40=1;
                        }


                        switch (alt40) {
                    	case 1 :
                    	    // InternalTmscXtext.g:1829:5: otherlv_8= ',' ( (lv_arguments_9_0= ruleXEventArgument ) )
                    	    {
                    	    otherlv_8=(Token)match(input,29,FOLLOW_18); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_8, grammarAccess.getXEventAccess().getCommaKeyword_6_2_0());
                    	      				
                    	    }
                    	    // InternalTmscXtext.g:1833:5: ( (lv_arguments_9_0= ruleXEventArgument ) )
                    	    // InternalTmscXtext.g:1834:6: (lv_arguments_9_0= ruleXEventArgument )
                    	    {
                    	    // InternalTmscXtext.g:1834:6: (lv_arguments_9_0= ruleXEventArgument )
                    	    // InternalTmscXtext.g:1835:7: lv_arguments_9_0= ruleXEventArgument
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getXEventAccess().getArgumentsXEventArgumentParserRuleCall_6_2_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_26);
                    	    lv_arguments_9_0=ruleXEventArgument();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getXEventRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"arguments",
                    	      								lv_arguments_9_0,
                    	      								"nl.esi.pps.tmsc.xtext.TmscXtext.XEventArgument");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop40;
                        }
                    } while (true);

                    otherlv_10=(Token)match(input,35,FOLLOW_34); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_10, grammarAccess.getXEventAccess().getRightParenthesisKeyword_6_3());
                      			
                    }

                    }
                    break;

            }

            // InternalTmscXtext.g:1858:3: ( (otherlv_11= '!' ( (lv_outgoingDependencies_12_0= ruleXDependency ) ) ) | (otherlv_13= '?' ( ( ruleIDString ) ) ) )*
            loop42:
            do {
                int alt42=3;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==40) ) {
                    alt42=1;
                }
                else if ( (LA42_0==41) ) {
                    alt42=2;
                }


                switch (alt42) {
            	case 1 :
            	    // InternalTmscXtext.g:1859:4: (otherlv_11= '!' ( (lv_outgoingDependencies_12_0= ruleXDependency ) ) )
            	    {
            	    // InternalTmscXtext.g:1859:4: (otherlv_11= '!' ( (lv_outgoingDependencies_12_0= ruleXDependency ) ) )
            	    // InternalTmscXtext.g:1860:5: otherlv_11= '!' ( (lv_outgoingDependencies_12_0= ruleXDependency ) )
            	    {
            	    otherlv_11=(Token)match(input,40,FOLLOW_35); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_11, grammarAccess.getXEventAccess().getExclamationMarkKeyword_7_0_0());
            	      				
            	    }
            	    // InternalTmscXtext.g:1864:5: ( (lv_outgoingDependencies_12_0= ruleXDependency ) )
            	    // InternalTmscXtext.g:1865:6: (lv_outgoingDependencies_12_0= ruleXDependency )
            	    {
            	    // InternalTmscXtext.g:1865:6: (lv_outgoingDependencies_12_0= ruleXDependency )
            	    // InternalTmscXtext.g:1866:7: lv_outgoingDependencies_12_0= ruleXDependency
            	    {
            	    if ( state.backtracking==0 ) {

            	      							newCompositeNode(grammarAccess.getXEventAccess().getOutgoingDependenciesXDependencyParserRuleCall_7_0_1_0());
            	      						
            	    }
            	    pushFollow(FOLLOW_34);
            	    lv_outgoingDependencies_12_0=ruleXDependency();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      							if (current==null) {
            	      								current = createModelElementForParent(grammarAccess.getXEventRule());
            	      							}
            	      							add(
            	      								current,
            	      								"outgoingDependencies",
            	      								lv_outgoingDependencies_12_0,
            	      								"nl.esi.pps.tmsc.xtext.TmscXtext.XDependency");
            	      							afterParserOrEnumRuleCall();
            	      						
            	    }

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalTmscXtext.g:1885:4: (otherlv_13= '?' ( ( ruleIDString ) ) )
            	    {
            	    // InternalTmscXtext.g:1885:4: (otherlv_13= '?' ( ( ruleIDString ) ) )
            	    // InternalTmscXtext.g:1886:5: otherlv_13= '?' ( ( ruleIDString ) )
            	    {
            	    otherlv_13=(Token)match(input,41,FOLLOW_16); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_13, grammarAccess.getXEventAccess().getQuestionMarkKeyword_7_1_0());
            	      				
            	    }
            	    // InternalTmscXtext.g:1890:5: ( ( ruleIDString ) )
            	    // InternalTmscXtext.g:1891:6: ( ruleIDString )
            	    {
            	    // InternalTmscXtext.g:1891:6: ( ruleIDString )
            	    // InternalTmscXtext.g:1892:7: ruleIDString
            	    {
            	    if ( state.backtracking==0 ) {

            	      							if (current==null) {
            	      								current = createModelElement(grammarAccess.getXEventRule());
            	      							}
            	      						
            	    }
            	    if ( state.backtracking==0 ) {

            	      							newCompositeNode(grammarAccess.getXEventAccess().getIncomingDependenciesXDependencyCrossReference_7_1_1_0());
            	      						
            	    }
            	    pushFollow(FOLLOW_34);
            	    ruleIDString();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      							afterParserOrEnumRuleCall();
            	      						
            	    }

            	    }


            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop42;
                }
            } while (true);

            // InternalTmscXtext.g:1908:3: (otherlv_15= '{' ( (otherlv_16= 'time-bound' otherlv_17= ':' ( (lv_timeBound_18_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_19= 'scheduled' otherlv_20= ':' ( (lv_scheduled_21_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_22_0= ruleXProperty ) ) )* otherlv_23= '}' )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==15) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // InternalTmscXtext.g:1909:4: otherlv_15= '{' ( (otherlv_16= 'time-bound' otherlv_17= ':' ( (lv_timeBound_18_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_19= 'scheduled' otherlv_20= ':' ( (lv_scheduled_21_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_22_0= ruleXProperty ) ) )* otherlv_23= '}'
                    {
                    otherlv_15=(Token)match(input,15,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_15, grammarAccess.getXEventAccess().getLeftCurlyBracketKeyword_8_0());
                      			
                    }
                    // InternalTmscXtext.g:1913:4: ( (otherlv_16= 'time-bound' otherlv_17= ':' ( (lv_timeBound_18_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_19= 'scheduled' otherlv_20= ':' ( (lv_scheduled_21_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_22_0= ruleXProperty ) ) )*
                    loop43:
                    do {
                        int alt43=4;
                        switch ( input.LA(1) ) {
                        case 18:
                            {
                            alt43=1;
                            }
                            break;
                        case 19:
                            {
                            alt43=2;
                            }
                            break;
                        case RULE_ID:
                        case RULE_STRING:
                            {
                            alt43=3;
                            }
                            break;

                        }

                        switch (alt43) {
                    	case 1 :
                    	    // InternalTmscXtext.g:1914:5: (otherlv_16= 'time-bound' otherlv_17= ':' ( (lv_timeBound_18_0= RULE_ABS_EBIGDECIMAL ) ) )
                    	    {
                    	    // InternalTmscXtext.g:1914:5: (otherlv_16= 'time-bound' otherlv_17= ':' ( (lv_timeBound_18_0= RULE_ABS_EBIGDECIMAL ) ) )
                    	    // InternalTmscXtext.g:1915:6: otherlv_16= 'time-bound' otherlv_17= ':' ( (lv_timeBound_18_0= RULE_ABS_EBIGDECIMAL ) )
                    	    {
                    	    otherlv_16=(Token)match(input,18,FOLLOW_6); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_16, grammarAccess.getXEventAccess().getTimeBoundKeyword_8_1_0_0());
                    	      					
                    	    }
                    	    otherlv_17=(Token)match(input,17,FOLLOW_8); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_17, grammarAccess.getXEventAccess().getColonKeyword_8_1_0_1());
                    	      					
                    	    }
                    	    // InternalTmscXtext.g:1923:6: ( (lv_timeBound_18_0= RULE_ABS_EBIGDECIMAL ) )
                    	    // InternalTmscXtext.g:1924:7: (lv_timeBound_18_0= RULE_ABS_EBIGDECIMAL )
                    	    {
                    	    // InternalTmscXtext.g:1924:7: (lv_timeBound_18_0= RULE_ABS_EBIGDECIMAL )
                    	    // InternalTmscXtext.g:1925:8: lv_timeBound_18_0= RULE_ABS_EBIGDECIMAL
                    	    {
                    	    lv_timeBound_18_0=(Token)match(input,RULE_ABS_EBIGDECIMAL,FOLLOW_5); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      								newLeafNode(lv_timeBound_18_0, grammarAccess.getXEventAccess().getTimeBoundABS_EBIGDECIMALTerminalRuleCall_8_1_0_2_0());
                    	      							
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      								if (current==null) {
                    	      									current = createModelElement(grammarAccess.getXEventRule());
                    	      								}
                    	      								setWithLastConsumed(
                    	      									current,
                    	      									"timeBound",
                    	      									lv_timeBound_18_0,
                    	      									"nl.esi.pps.tmsc.xtext.TmscXtext.ABS_EBIGDECIMAL");
                    	      							
                    	    }

                    	    }


                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalTmscXtext.g:1943:5: (otherlv_19= 'scheduled' otherlv_20= ':' ( (lv_scheduled_21_0= ruleEBOOLEAN_OBJECT ) ) )
                    	    {
                    	    // InternalTmscXtext.g:1943:5: (otherlv_19= 'scheduled' otherlv_20= ':' ( (lv_scheduled_21_0= ruleEBOOLEAN_OBJECT ) ) )
                    	    // InternalTmscXtext.g:1944:6: otherlv_19= 'scheduled' otherlv_20= ':' ( (lv_scheduled_21_0= ruleEBOOLEAN_OBJECT ) )
                    	    {
                    	    otherlv_19=(Token)match(input,19,FOLLOW_6); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_19, grammarAccess.getXEventAccess().getScheduledKeyword_8_1_1_0());
                    	      					
                    	    }
                    	    otherlv_20=(Token)match(input,17,FOLLOW_9); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_20, grammarAccess.getXEventAccess().getColonKeyword_8_1_1_1());
                    	      					
                    	    }
                    	    // InternalTmscXtext.g:1952:6: ( (lv_scheduled_21_0= ruleEBOOLEAN_OBJECT ) )
                    	    // InternalTmscXtext.g:1953:7: (lv_scheduled_21_0= ruleEBOOLEAN_OBJECT )
                    	    {
                    	    // InternalTmscXtext.g:1953:7: (lv_scheduled_21_0= ruleEBOOLEAN_OBJECT )
                    	    // InternalTmscXtext.g:1954:8: lv_scheduled_21_0= ruleEBOOLEAN_OBJECT
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      								newCompositeNode(grammarAccess.getXEventAccess().getScheduledEBOOLEAN_OBJECTParserRuleCall_8_1_1_2_0());
                    	      							
                    	    }
                    	    pushFollow(FOLLOW_5);
                    	    lv_scheduled_21_0=ruleEBOOLEAN_OBJECT();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      								if (current==null) {
                    	      									current = createModelElementForParent(grammarAccess.getXEventRule());
                    	      								}
                    	      								set(
                    	      									current,
                    	      									"scheduled",
                    	      									lv_scheduled_21_0,
                    	      									"nl.esi.pps.tmsc.xtext.TmscXtext.EBOOLEAN_OBJECT");
                    	      								afterParserOrEnumRuleCall();
                    	      							
                    	    }

                    	    }


                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 3 :
                    	    // InternalTmscXtext.g:1973:5: ( (lv_properties_22_0= ruleXProperty ) )
                    	    {
                    	    // InternalTmscXtext.g:1973:5: ( (lv_properties_22_0= ruleXProperty ) )
                    	    // InternalTmscXtext.g:1974:6: (lv_properties_22_0= ruleXProperty )
                    	    {
                    	    // InternalTmscXtext.g:1974:6: (lv_properties_22_0= ruleXProperty )
                    	    // InternalTmscXtext.g:1975:7: lv_properties_22_0= ruleXProperty
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getXEventAccess().getPropertiesXPropertyParserRuleCall_8_1_2_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_5);
                    	    lv_properties_22_0=ruleXProperty();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getXEventRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"properties",
                    	      								lv_properties_22_0,
                    	      								"nl.esi.pps.tmsc.xtext.TmscXtext.XProperty");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop43;
                        }
                    } while (true);

                    otherlv_23=(Token)match(input,20,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_23, grammarAccess.getXEventAccess().getRightCurlyBracketKeyword_8_2());
                      			
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleXEvent"


    // $ANTLR start "entryRuleXEventArgument"
    // InternalTmscXtext.g:2002:1: entryRuleXEventArgument returns [EObject current=null] : iv_ruleXEventArgument= ruleXEventArgument EOF ;
    public final EObject entryRuleXEventArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXEventArgument = null;


        try {
            // InternalTmscXtext.g:2002:55: (iv_ruleXEventArgument= ruleXEventArgument EOF )
            // InternalTmscXtext.g:2003:2: iv_ruleXEventArgument= ruleXEventArgument EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXEventArgumentRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXEventArgument=ruleXEventArgument();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXEventArgument; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXEventArgument"


    // $ANTLR start "ruleXEventArgument"
    // InternalTmscXtext.g:2009:1: ruleXEventArgument returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' ( (lv_value_2_0= ruleIDString ) ) ) ;
    public final EObject ruleXEventArgument() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalTmscXtext.g:2015:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' ( (lv_value_2_0= ruleIDString ) ) ) )
            // InternalTmscXtext.g:2016:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' ( (lv_value_2_0= ruleIDString ) ) )
            {
            // InternalTmscXtext.g:2016:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' ( (lv_value_2_0= ruleIDString ) ) )
            // InternalTmscXtext.g:2017:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' ( (lv_value_2_0= ruleIDString ) )
            {
            // InternalTmscXtext.g:2017:3: ( (otherlv_0= RULE_ID ) )
            // InternalTmscXtext.g:2018:4: (otherlv_0= RULE_ID )
            {
            // InternalTmscXtext.g:2018:4: (otherlv_0= RULE_ID )
            // InternalTmscXtext.g:2019:5: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getXEventArgumentRule());
              					}
              				
            }
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_0, grammarAccess.getXEventArgumentAccess().getParameterXFunctionParameterCrossReference_0_0());
              				
            }

            }


            }

            otherlv_1=(Token)match(input,17,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getXEventArgumentAccess().getColonKeyword_1());
              		
            }
            // InternalTmscXtext.g:2034:3: ( (lv_value_2_0= ruleIDString ) )
            // InternalTmscXtext.g:2035:4: (lv_value_2_0= ruleIDString )
            {
            // InternalTmscXtext.g:2035:4: (lv_value_2_0= ruleIDString )
            // InternalTmscXtext.g:2036:5: lv_value_2_0= ruleIDString
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getXEventArgumentAccess().getValueIDStringParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_value_2_0=ruleIDString();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getXEventArgumentRule());
              					}
              					set(
              						current,
              						"value",
              						lv_value_2_0,
              						"nl.esi.pps.tmsc.xtext.TmscXtext.IDString");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleXEventArgument"


    // $ANTLR start "entryRuleXDependency"
    // InternalTmscXtext.g:2057:1: entryRuleXDependency returns [EObject current=null] : iv_ruleXDependency= ruleXDependency EOF ;
    public final EObject entryRuleXDependency() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXDependency = null;


        try {
            // InternalTmscXtext.g:2057:52: (iv_ruleXDependency= ruleXDependency EOF )
            // InternalTmscXtext.g:2058:2: iv_ruleXDependency= ruleXDependency EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXDependencyRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXDependency=ruleXDependency();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXDependency; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXDependency"


    // $ANTLR start "ruleXDependency"
    // InternalTmscXtext.g:2064:1: ruleXDependency returns [EObject current=null] : ( ( (lv_typeObject_0_0= ruleXDependencyTypeObject ) )? ( (lv_name_1_0= ruleIDString ) ) ( (otherlv_2= '(' ( (lv_timeBound_3_0= RULE_ABS_EBIGDECIMAL ) ) otherlv_4= ')' ) | (otherlv_5= '(' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_12= 'request' otherlv_13= ':' ( ( ruleIDString ) ) ) | (otherlv_15= 'message' otherlv_16= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_18_0= ruleXProperty ) ) ) (otherlv_19= ',' ( (otherlv_20= 'time-bound' otherlv_21= ':' ( (lv_timeBound_22_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_23= 'scheduled' otherlv_24= ':' ( (lv_scheduled_25_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_26= 'request' otherlv_27= ':' ( ( ruleIDString ) ) ) | (otherlv_29= 'message' otherlv_30= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_32_0= ruleXProperty ) ) ) )* otherlv_33= ')' ) )? ) ;
    public final EObject ruleXDependency() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token lv_timeBound_3_0=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token lv_timeBound_8_0=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_19=null;
        Token otherlv_20=null;
        Token otherlv_21=null;
        Token lv_timeBound_22_0=null;
        Token otherlv_23=null;
        Token otherlv_24=null;
        Token otherlv_26=null;
        Token otherlv_27=null;
        Token otherlv_29=null;
        Token otherlv_30=null;
        Token otherlv_33=null;
        EObject lv_typeObject_0_0 = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_scheduled_11_0 = null;

        EObject lv_properties_18_0 = null;

        AntlrDatatypeRuleToken lv_scheduled_25_0 = null;

        EObject lv_properties_32_0 = null;



        	enterRule();

        try {
            // InternalTmscXtext.g:2070:2: ( ( ( (lv_typeObject_0_0= ruleXDependencyTypeObject ) )? ( (lv_name_1_0= ruleIDString ) ) ( (otherlv_2= '(' ( (lv_timeBound_3_0= RULE_ABS_EBIGDECIMAL ) ) otherlv_4= ')' ) | (otherlv_5= '(' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_12= 'request' otherlv_13= ':' ( ( ruleIDString ) ) ) | (otherlv_15= 'message' otherlv_16= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_18_0= ruleXProperty ) ) ) (otherlv_19= ',' ( (otherlv_20= 'time-bound' otherlv_21= ':' ( (lv_timeBound_22_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_23= 'scheduled' otherlv_24= ':' ( (lv_scheduled_25_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_26= 'request' otherlv_27= ':' ( ( ruleIDString ) ) ) | (otherlv_29= 'message' otherlv_30= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_32_0= ruleXProperty ) ) ) )* otherlv_33= ')' ) )? ) )
            // InternalTmscXtext.g:2071:2: ( ( (lv_typeObject_0_0= ruleXDependencyTypeObject ) )? ( (lv_name_1_0= ruleIDString ) ) ( (otherlv_2= '(' ( (lv_timeBound_3_0= RULE_ABS_EBIGDECIMAL ) ) otherlv_4= ')' ) | (otherlv_5= '(' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_12= 'request' otherlv_13= ':' ( ( ruleIDString ) ) ) | (otherlv_15= 'message' otherlv_16= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_18_0= ruleXProperty ) ) ) (otherlv_19= ',' ( (otherlv_20= 'time-bound' otherlv_21= ':' ( (lv_timeBound_22_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_23= 'scheduled' otherlv_24= ':' ( (lv_scheduled_25_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_26= 'request' otherlv_27= ':' ( ( ruleIDString ) ) ) | (otherlv_29= 'message' otherlv_30= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_32_0= ruleXProperty ) ) ) )* otherlv_33= ')' ) )? )
            {
            // InternalTmscXtext.g:2071:2: ( ( (lv_typeObject_0_0= ruleXDependencyTypeObject ) )? ( (lv_name_1_0= ruleIDString ) ) ( (otherlv_2= '(' ( (lv_timeBound_3_0= RULE_ABS_EBIGDECIMAL ) ) otherlv_4= ')' ) | (otherlv_5= '(' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_12= 'request' otherlv_13= ':' ( ( ruleIDString ) ) ) | (otherlv_15= 'message' otherlv_16= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_18_0= ruleXProperty ) ) ) (otherlv_19= ',' ( (otherlv_20= 'time-bound' otherlv_21= ':' ( (lv_timeBound_22_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_23= 'scheduled' otherlv_24= ':' ( (lv_scheduled_25_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_26= 'request' otherlv_27= ':' ( ( ruleIDString ) ) ) | (otherlv_29= 'message' otherlv_30= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_32_0= ruleXProperty ) ) ) )* otherlv_33= ')' ) )? )
            // InternalTmscXtext.g:2072:3: ( (lv_typeObject_0_0= ruleXDependencyTypeObject ) )? ( (lv_name_1_0= ruleIDString ) ) ( (otherlv_2= '(' ( (lv_timeBound_3_0= RULE_ABS_EBIGDECIMAL ) ) otherlv_4= ')' ) | (otherlv_5= '(' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_12= 'request' otherlv_13= ':' ( ( ruleIDString ) ) ) | (otherlv_15= 'message' otherlv_16= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_18_0= ruleXProperty ) ) ) (otherlv_19= ',' ( (otherlv_20= 'time-bound' otherlv_21= ':' ( (lv_timeBound_22_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_23= 'scheduled' otherlv_24= ':' ( (lv_scheduled_25_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_26= 'request' otherlv_27= ':' ( ( ruleIDString ) ) ) | (otherlv_29= 'message' otherlv_30= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_32_0= ruleXProperty ) ) ) )* otherlv_33= ')' ) )?
            {
            // InternalTmscXtext.g:2072:3: ( (lv_typeObject_0_0= ruleXDependencyTypeObject ) )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( ((LA45_0>=42 && LA45_0<=43)||(LA45_0>=58 && LA45_0<=61)) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalTmscXtext.g:2073:4: (lv_typeObject_0_0= ruleXDependencyTypeObject )
                    {
                    // InternalTmscXtext.g:2073:4: (lv_typeObject_0_0= ruleXDependencyTypeObject )
                    // InternalTmscXtext.g:2074:5: lv_typeObject_0_0= ruleXDependencyTypeObject
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getXDependencyAccess().getTypeObjectXDependencyTypeObjectParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_16);
                    lv_typeObject_0_0=ruleXDependencyTypeObject();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getXDependencyRule());
                      					}
                      					set(
                      						current,
                      						"typeObject",
                      						lv_typeObject_0_0,
                      						"nl.esi.pps.tmsc.xtext.TmscXtext.XDependencyTypeObject");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalTmscXtext.g:2091:3: ( (lv_name_1_0= ruleIDString ) )
            // InternalTmscXtext.g:2092:4: (lv_name_1_0= ruleIDString )
            {
            // InternalTmscXtext.g:2092:4: (lv_name_1_0= ruleIDString )
            // InternalTmscXtext.g:2093:5: lv_name_1_0= ruleIDString
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getXDependencyAccess().getNameIDStringParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_28);
            lv_name_1_0=ruleIDString();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getXDependencyRule());
              					}
              					set(
              						current,
              						"name",
              						lv_name_1_0,
              						"nl.esi.pps.tmsc.xtext.TmscXtext.IDString");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalTmscXtext.g:2110:3: ( (otherlv_2= '(' ( (lv_timeBound_3_0= RULE_ABS_EBIGDECIMAL ) ) otherlv_4= ')' ) | (otherlv_5= '(' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_12= 'request' otherlv_13= ':' ( ( ruleIDString ) ) ) | (otherlv_15= 'message' otherlv_16= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_18_0= ruleXProperty ) ) ) (otherlv_19= ',' ( (otherlv_20= 'time-bound' otherlv_21= ':' ( (lv_timeBound_22_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_23= 'scheduled' otherlv_24= ':' ( (lv_scheduled_25_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_26= 'request' otherlv_27= ':' ( ( ruleIDString ) ) ) | (otherlv_29= 'message' otherlv_30= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_32_0= ruleXProperty ) ) ) )* otherlv_33= ')' ) )?
            int alt49=3;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==34) ) {
                int LA49_1 = input.LA(2);

                if ( (LA49_1==RULE_ABS_EBIGDECIMAL) ) {
                    alt49=1;
                }
                else if ( (LA49_1==RULE_ID||LA49_1==RULE_STRING||(LA49_1>=18 && LA49_1<=19)||(LA49_1>=42 && LA49_1<=43)) ) {
                    alt49=2;
                }
            }
            switch (alt49) {
                case 1 :
                    // InternalTmscXtext.g:2111:4: (otherlv_2= '(' ( (lv_timeBound_3_0= RULE_ABS_EBIGDECIMAL ) ) otherlv_4= ')' )
                    {
                    // InternalTmscXtext.g:2111:4: (otherlv_2= '(' ( (lv_timeBound_3_0= RULE_ABS_EBIGDECIMAL ) ) otherlv_4= ')' )
                    // InternalTmscXtext.g:2112:5: otherlv_2= '(' ( (lv_timeBound_3_0= RULE_ABS_EBIGDECIMAL ) ) otherlv_4= ')'
                    {
                    otherlv_2=(Token)match(input,34,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_2, grammarAccess.getXDependencyAccess().getLeftParenthesisKeyword_2_0_0());
                      				
                    }
                    // InternalTmscXtext.g:2116:5: ( (lv_timeBound_3_0= RULE_ABS_EBIGDECIMAL ) )
                    // InternalTmscXtext.g:2117:6: (lv_timeBound_3_0= RULE_ABS_EBIGDECIMAL )
                    {
                    // InternalTmscXtext.g:2117:6: (lv_timeBound_3_0= RULE_ABS_EBIGDECIMAL )
                    // InternalTmscXtext.g:2118:7: lv_timeBound_3_0= RULE_ABS_EBIGDECIMAL
                    {
                    lv_timeBound_3_0=(Token)match(input,RULE_ABS_EBIGDECIMAL,FOLLOW_36); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							newLeafNode(lv_timeBound_3_0, grammarAccess.getXDependencyAccess().getTimeBoundABS_EBIGDECIMALTerminalRuleCall_2_0_1_0());
                      						
                    }
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElement(grammarAccess.getXDependencyRule());
                      							}
                      							setWithLastConsumed(
                      								current,
                      								"timeBound",
                      								lv_timeBound_3_0,
                      								"nl.esi.pps.tmsc.xtext.TmscXtext.ABS_EBIGDECIMAL");
                      						
                    }

                    }


                    }

                    otherlv_4=(Token)match(input,35,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_4, grammarAccess.getXDependencyAccess().getRightParenthesisKeyword_2_0_2());
                      				
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalTmscXtext.g:2140:4: (otherlv_5= '(' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_12= 'request' otherlv_13= ':' ( ( ruleIDString ) ) ) | (otherlv_15= 'message' otherlv_16= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_18_0= ruleXProperty ) ) ) (otherlv_19= ',' ( (otherlv_20= 'time-bound' otherlv_21= ':' ( (lv_timeBound_22_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_23= 'scheduled' otherlv_24= ':' ( (lv_scheduled_25_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_26= 'request' otherlv_27= ':' ( ( ruleIDString ) ) ) | (otherlv_29= 'message' otherlv_30= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_32_0= ruleXProperty ) ) ) )* otherlv_33= ')' )
                    {
                    // InternalTmscXtext.g:2140:4: (otherlv_5= '(' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_12= 'request' otherlv_13= ':' ( ( ruleIDString ) ) ) | (otherlv_15= 'message' otherlv_16= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_18_0= ruleXProperty ) ) ) (otherlv_19= ',' ( (otherlv_20= 'time-bound' otherlv_21= ':' ( (lv_timeBound_22_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_23= 'scheduled' otherlv_24= ':' ( (lv_scheduled_25_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_26= 'request' otherlv_27= ':' ( ( ruleIDString ) ) ) | (otherlv_29= 'message' otherlv_30= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_32_0= ruleXProperty ) ) ) )* otherlv_33= ')' )
                    // InternalTmscXtext.g:2141:5: otherlv_5= '(' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_12= 'request' otherlv_13= ':' ( ( ruleIDString ) ) ) | (otherlv_15= 'message' otherlv_16= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_18_0= ruleXProperty ) ) ) (otherlv_19= ',' ( (otherlv_20= 'time-bound' otherlv_21= ':' ( (lv_timeBound_22_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_23= 'scheduled' otherlv_24= ':' ( (lv_scheduled_25_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_26= 'request' otherlv_27= ':' ( ( ruleIDString ) ) ) | (otherlv_29= 'message' otherlv_30= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_32_0= ruleXProperty ) ) ) )* otherlv_33= ')'
                    {
                    otherlv_5=(Token)match(input,34,FOLLOW_37); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_5, grammarAccess.getXDependencyAccess().getLeftParenthesisKeyword_2_1_0());
                      				
                    }
                    // InternalTmscXtext.g:2145:5: ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_12= 'request' otherlv_13= ':' ( ( ruleIDString ) ) ) | (otherlv_15= 'message' otherlv_16= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_18_0= ruleXProperty ) ) )
                    int alt46=5;
                    switch ( input.LA(1) ) {
                    case 18:
                        {
                        alt46=1;
                        }
                        break;
                    case 19:
                        {
                        alt46=2;
                        }
                        break;
                    case 42:
                        {
                        alt46=3;
                        }
                        break;
                    case 43:
                        {
                        alt46=4;
                        }
                        break;
                    case RULE_ID:
                    case RULE_STRING:
                        {
                        alt46=5;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 46, 0, input);

                        throw nvae;
                    }

                    switch (alt46) {
                        case 1 :
                            // InternalTmscXtext.g:2146:6: (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) )
                            {
                            // InternalTmscXtext.g:2146:6: (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) )
                            // InternalTmscXtext.g:2147:7: otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) )
                            {
                            otherlv_6=(Token)match(input,18,FOLLOW_6); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(otherlv_6, grammarAccess.getXDependencyAccess().getTimeBoundKeyword_2_1_1_0_0());
                              						
                            }
                            otherlv_7=(Token)match(input,17,FOLLOW_8); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(otherlv_7, grammarAccess.getXDependencyAccess().getColonKeyword_2_1_1_0_1());
                              						
                            }
                            // InternalTmscXtext.g:2155:7: ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) )
                            // InternalTmscXtext.g:2156:8: (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL )
                            {
                            // InternalTmscXtext.g:2156:8: (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL )
                            // InternalTmscXtext.g:2157:9: lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL
                            {
                            lv_timeBound_8_0=(Token)match(input,RULE_ABS_EBIGDECIMAL,FOLLOW_26); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              									newLeafNode(lv_timeBound_8_0, grammarAccess.getXDependencyAccess().getTimeBoundABS_EBIGDECIMALTerminalRuleCall_2_1_1_0_2_0());
                              								
                            }
                            if ( state.backtracking==0 ) {

                              									if (current==null) {
                              										current = createModelElement(grammarAccess.getXDependencyRule());
                              									}
                              									setWithLastConsumed(
                              										current,
                              										"timeBound",
                              										lv_timeBound_8_0,
                              										"nl.esi.pps.tmsc.xtext.TmscXtext.ABS_EBIGDECIMAL");
                              								
                            }

                            }


                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalTmscXtext.g:2175:6: (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) )
                            {
                            // InternalTmscXtext.g:2175:6: (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) )
                            // InternalTmscXtext.g:2176:7: otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) )
                            {
                            otherlv_9=(Token)match(input,19,FOLLOW_6); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(otherlv_9, grammarAccess.getXDependencyAccess().getScheduledKeyword_2_1_1_1_0());
                              						
                            }
                            otherlv_10=(Token)match(input,17,FOLLOW_9); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(otherlv_10, grammarAccess.getXDependencyAccess().getColonKeyword_2_1_1_1_1());
                              						
                            }
                            // InternalTmscXtext.g:2184:7: ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) )
                            // InternalTmscXtext.g:2185:8: (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT )
                            {
                            // InternalTmscXtext.g:2185:8: (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT )
                            // InternalTmscXtext.g:2186:9: lv_scheduled_11_0= ruleEBOOLEAN_OBJECT
                            {
                            if ( state.backtracking==0 ) {

                              									newCompositeNode(grammarAccess.getXDependencyAccess().getScheduledEBOOLEAN_OBJECTParserRuleCall_2_1_1_1_2_0());
                              								
                            }
                            pushFollow(FOLLOW_26);
                            lv_scheduled_11_0=ruleEBOOLEAN_OBJECT();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              									if (current==null) {
                              										current = createModelElementForParent(grammarAccess.getXDependencyRule());
                              									}
                              									set(
                              										current,
                              										"scheduled",
                              										lv_scheduled_11_0,
                              										"nl.esi.pps.tmsc.xtext.TmscXtext.EBOOLEAN_OBJECT");
                              									afterParserOrEnumRuleCall();
                              								
                            }

                            }


                            }


                            }


                            }
                            break;
                        case 3 :
                            // InternalTmscXtext.g:2205:6: (otherlv_12= 'request' otherlv_13= ':' ( ( ruleIDString ) ) )
                            {
                            // InternalTmscXtext.g:2205:6: (otherlv_12= 'request' otherlv_13= ':' ( ( ruleIDString ) ) )
                            // InternalTmscXtext.g:2206:7: otherlv_12= 'request' otherlv_13= ':' ( ( ruleIDString ) )
                            {
                            otherlv_12=(Token)match(input,42,FOLLOW_6); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(otherlv_12, grammarAccess.getXDependencyAccess().getRequestKeyword_2_1_1_2_0());
                              						
                            }
                            otherlv_13=(Token)match(input,17,FOLLOW_16); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(otherlv_13, grammarAccess.getXDependencyAccess().getColonKeyword_2_1_1_2_1());
                              						
                            }
                            // InternalTmscXtext.g:2214:7: ( ( ruleIDString ) )
                            // InternalTmscXtext.g:2215:8: ( ruleIDString )
                            {
                            // InternalTmscXtext.g:2215:8: ( ruleIDString )
                            // InternalTmscXtext.g:2216:9: ruleIDString
                            {
                            if ( state.backtracking==0 ) {

                              									if (current==null) {
                              										current = createModelElement(grammarAccess.getXDependencyRule());
                              									}
                              								
                            }
                            if ( state.backtracking==0 ) {

                              									newCompositeNode(grammarAccess.getXDependencyAccess().getRequestXDependencyCrossReference_2_1_1_2_2_0());
                              								
                            }
                            pushFollow(FOLLOW_26);
                            ruleIDString();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              									afterParserOrEnumRuleCall();
                              								
                            }

                            }


                            }


                            }


                            }
                            break;
                        case 4 :
                            // InternalTmscXtext.g:2232:6: (otherlv_15= 'message' otherlv_16= ':' ( ( ruleIDString ) ) )
                            {
                            // InternalTmscXtext.g:2232:6: (otherlv_15= 'message' otherlv_16= ':' ( ( ruleIDString ) ) )
                            // InternalTmscXtext.g:2233:7: otherlv_15= 'message' otherlv_16= ':' ( ( ruleIDString ) )
                            {
                            otherlv_15=(Token)match(input,43,FOLLOW_6); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(otherlv_15, grammarAccess.getXDependencyAccess().getMessageKeyword_2_1_1_3_0());
                              						
                            }
                            otherlv_16=(Token)match(input,17,FOLLOW_16); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(otherlv_16, grammarAccess.getXDependencyAccess().getColonKeyword_2_1_1_3_1());
                              						
                            }
                            // InternalTmscXtext.g:2241:7: ( ( ruleIDString ) )
                            // InternalTmscXtext.g:2242:8: ( ruleIDString )
                            {
                            // InternalTmscXtext.g:2242:8: ( ruleIDString )
                            // InternalTmscXtext.g:2243:9: ruleIDString
                            {
                            if ( state.backtracking==0 ) {

                              									if (current==null) {
                              										current = createModelElement(grammarAccess.getXDependencyRule());
                              									}
                              								
                            }
                            if ( state.backtracking==0 ) {

                              									newCompositeNode(grammarAccess.getXDependencyAccess().getMessageXDependencyCrossReference_2_1_1_3_2_0());
                              								
                            }
                            pushFollow(FOLLOW_26);
                            ruleIDString();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              									afterParserOrEnumRuleCall();
                              								
                            }

                            }


                            }


                            }


                            }
                            break;
                        case 5 :
                            // InternalTmscXtext.g:2259:6: ( (lv_properties_18_0= ruleXProperty ) )
                            {
                            // InternalTmscXtext.g:2259:6: ( (lv_properties_18_0= ruleXProperty ) )
                            // InternalTmscXtext.g:2260:7: (lv_properties_18_0= ruleXProperty )
                            {
                            // InternalTmscXtext.g:2260:7: (lv_properties_18_0= ruleXProperty )
                            // InternalTmscXtext.g:2261:8: lv_properties_18_0= ruleXProperty
                            {
                            if ( state.backtracking==0 ) {

                              								newCompositeNode(grammarAccess.getXDependencyAccess().getPropertiesXPropertyParserRuleCall_2_1_1_4_0());
                              							
                            }
                            pushFollow(FOLLOW_26);
                            lv_properties_18_0=ruleXProperty();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElementForParent(grammarAccess.getXDependencyRule());
                              								}
                              								add(
                              									current,
                              									"properties",
                              									lv_properties_18_0,
                              									"nl.esi.pps.tmsc.xtext.TmscXtext.XProperty");
                              								afterParserOrEnumRuleCall();
                              							
                            }

                            }


                            }


                            }
                            break;

                    }

                    // InternalTmscXtext.g:2279:5: (otherlv_19= ',' ( (otherlv_20= 'time-bound' otherlv_21= ':' ( (lv_timeBound_22_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_23= 'scheduled' otherlv_24= ':' ( (lv_scheduled_25_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_26= 'request' otherlv_27= ':' ( ( ruleIDString ) ) ) | (otherlv_29= 'message' otherlv_30= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_32_0= ruleXProperty ) ) ) )*
                    loop48:
                    do {
                        int alt48=2;
                        int LA48_0 = input.LA(1);

                        if ( (LA48_0==29) ) {
                            alt48=1;
                        }


                        switch (alt48) {
                    	case 1 :
                    	    // InternalTmscXtext.g:2280:6: otherlv_19= ',' ( (otherlv_20= 'time-bound' otherlv_21= ':' ( (lv_timeBound_22_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_23= 'scheduled' otherlv_24= ':' ( (lv_scheduled_25_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_26= 'request' otherlv_27= ':' ( ( ruleIDString ) ) ) | (otherlv_29= 'message' otherlv_30= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_32_0= ruleXProperty ) ) )
                    	    {
                    	    otherlv_19=(Token)match(input,29,FOLLOW_37); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_19, grammarAccess.getXDependencyAccess().getCommaKeyword_2_1_2_0());
                    	      					
                    	    }
                    	    // InternalTmscXtext.g:2284:6: ( (otherlv_20= 'time-bound' otherlv_21= ':' ( (lv_timeBound_22_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_23= 'scheduled' otherlv_24= ':' ( (lv_scheduled_25_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_26= 'request' otherlv_27= ':' ( ( ruleIDString ) ) ) | (otherlv_29= 'message' otherlv_30= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_32_0= ruleXProperty ) ) )
                    	    int alt47=5;
                    	    switch ( input.LA(1) ) {
                    	    case 18:
                    	        {
                    	        alt47=1;
                    	        }
                    	        break;
                    	    case 19:
                    	        {
                    	        alt47=2;
                    	        }
                    	        break;
                    	    case 42:
                    	        {
                    	        alt47=3;
                    	        }
                    	        break;
                    	    case 43:
                    	        {
                    	        alt47=4;
                    	        }
                    	        break;
                    	    case RULE_ID:
                    	    case RULE_STRING:
                    	        {
                    	        alt47=5;
                    	        }
                    	        break;
                    	    default:
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        NoViableAltException nvae =
                    	            new NoViableAltException("", 47, 0, input);

                    	        throw nvae;
                    	    }

                    	    switch (alt47) {
                    	        case 1 :
                    	            // InternalTmscXtext.g:2285:7: (otherlv_20= 'time-bound' otherlv_21= ':' ( (lv_timeBound_22_0= RULE_ABS_EBIGDECIMAL ) ) )
                    	            {
                    	            // InternalTmscXtext.g:2285:7: (otherlv_20= 'time-bound' otherlv_21= ':' ( (lv_timeBound_22_0= RULE_ABS_EBIGDECIMAL ) ) )
                    	            // InternalTmscXtext.g:2286:8: otherlv_20= 'time-bound' otherlv_21= ':' ( (lv_timeBound_22_0= RULE_ABS_EBIGDECIMAL ) )
                    	            {
                    	            otherlv_20=(Token)match(input,18,FOLLOW_6); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              								newLeafNode(otherlv_20, grammarAccess.getXDependencyAccess().getTimeBoundKeyword_2_1_2_1_0_0());
                    	              							
                    	            }
                    	            otherlv_21=(Token)match(input,17,FOLLOW_8); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              								newLeafNode(otherlv_21, grammarAccess.getXDependencyAccess().getColonKeyword_2_1_2_1_0_1());
                    	              							
                    	            }
                    	            // InternalTmscXtext.g:2294:8: ( (lv_timeBound_22_0= RULE_ABS_EBIGDECIMAL ) )
                    	            // InternalTmscXtext.g:2295:9: (lv_timeBound_22_0= RULE_ABS_EBIGDECIMAL )
                    	            {
                    	            // InternalTmscXtext.g:2295:9: (lv_timeBound_22_0= RULE_ABS_EBIGDECIMAL )
                    	            // InternalTmscXtext.g:2296:10: lv_timeBound_22_0= RULE_ABS_EBIGDECIMAL
                    	            {
                    	            lv_timeBound_22_0=(Token)match(input,RULE_ABS_EBIGDECIMAL,FOLLOW_26); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              										newLeafNode(lv_timeBound_22_0, grammarAccess.getXDependencyAccess().getTimeBoundABS_EBIGDECIMALTerminalRuleCall_2_1_2_1_0_2_0());
                    	              									
                    	            }
                    	            if ( state.backtracking==0 ) {

                    	              										if (current==null) {
                    	              											current = createModelElement(grammarAccess.getXDependencyRule());
                    	              										}
                    	              										setWithLastConsumed(
                    	              											current,
                    	              											"timeBound",
                    	              											lv_timeBound_22_0,
                    	              											"nl.esi.pps.tmsc.xtext.TmscXtext.ABS_EBIGDECIMAL");
                    	              									
                    	            }

                    	            }


                    	            }


                    	            }


                    	            }
                    	            break;
                    	        case 2 :
                    	            // InternalTmscXtext.g:2314:7: (otherlv_23= 'scheduled' otherlv_24= ':' ( (lv_scheduled_25_0= ruleEBOOLEAN_OBJECT ) ) )
                    	            {
                    	            // InternalTmscXtext.g:2314:7: (otherlv_23= 'scheduled' otherlv_24= ':' ( (lv_scheduled_25_0= ruleEBOOLEAN_OBJECT ) ) )
                    	            // InternalTmscXtext.g:2315:8: otherlv_23= 'scheduled' otherlv_24= ':' ( (lv_scheduled_25_0= ruleEBOOLEAN_OBJECT ) )
                    	            {
                    	            otherlv_23=(Token)match(input,19,FOLLOW_6); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              								newLeafNode(otherlv_23, grammarAccess.getXDependencyAccess().getScheduledKeyword_2_1_2_1_1_0());
                    	              							
                    	            }
                    	            otherlv_24=(Token)match(input,17,FOLLOW_9); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              								newLeafNode(otherlv_24, grammarAccess.getXDependencyAccess().getColonKeyword_2_1_2_1_1_1());
                    	              							
                    	            }
                    	            // InternalTmscXtext.g:2323:8: ( (lv_scheduled_25_0= ruleEBOOLEAN_OBJECT ) )
                    	            // InternalTmscXtext.g:2324:9: (lv_scheduled_25_0= ruleEBOOLEAN_OBJECT )
                    	            {
                    	            // InternalTmscXtext.g:2324:9: (lv_scheduled_25_0= ruleEBOOLEAN_OBJECT )
                    	            // InternalTmscXtext.g:2325:10: lv_scheduled_25_0= ruleEBOOLEAN_OBJECT
                    	            {
                    	            if ( state.backtracking==0 ) {

                    	              										newCompositeNode(grammarAccess.getXDependencyAccess().getScheduledEBOOLEAN_OBJECTParserRuleCall_2_1_2_1_1_2_0());
                    	              									
                    	            }
                    	            pushFollow(FOLLOW_26);
                    	            lv_scheduled_25_0=ruleEBOOLEAN_OBJECT();

                    	            state._fsp--;
                    	            if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              										if (current==null) {
                    	              											current = createModelElementForParent(grammarAccess.getXDependencyRule());
                    	              										}
                    	              										set(
                    	              											current,
                    	              											"scheduled",
                    	              											lv_scheduled_25_0,
                    	              											"nl.esi.pps.tmsc.xtext.TmscXtext.EBOOLEAN_OBJECT");
                    	              										afterParserOrEnumRuleCall();
                    	              									
                    	            }

                    	            }


                    	            }


                    	            }


                    	            }
                    	            break;
                    	        case 3 :
                    	            // InternalTmscXtext.g:2344:7: (otherlv_26= 'request' otherlv_27= ':' ( ( ruleIDString ) ) )
                    	            {
                    	            // InternalTmscXtext.g:2344:7: (otherlv_26= 'request' otherlv_27= ':' ( ( ruleIDString ) ) )
                    	            // InternalTmscXtext.g:2345:8: otherlv_26= 'request' otherlv_27= ':' ( ( ruleIDString ) )
                    	            {
                    	            otherlv_26=(Token)match(input,42,FOLLOW_6); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              								newLeafNode(otherlv_26, grammarAccess.getXDependencyAccess().getRequestKeyword_2_1_2_1_2_0());
                    	              							
                    	            }
                    	            otherlv_27=(Token)match(input,17,FOLLOW_16); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              								newLeafNode(otherlv_27, grammarAccess.getXDependencyAccess().getColonKeyword_2_1_2_1_2_1());
                    	              							
                    	            }
                    	            // InternalTmscXtext.g:2353:8: ( ( ruleIDString ) )
                    	            // InternalTmscXtext.g:2354:9: ( ruleIDString )
                    	            {
                    	            // InternalTmscXtext.g:2354:9: ( ruleIDString )
                    	            // InternalTmscXtext.g:2355:10: ruleIDString
                    	            {
                    	            if ( state.backtracking==0 ) {

                    	              										if (current==null) {
                    	              											current = createModelElement(grammarAccess.getXDependencyRule());
                    	              										}
                    	              									
                    	            }
                    	            if ( state.backtracking==0 ) {

                    	              										newCompositeNode(grammarAccess.getXDependencyAccess().getRequestXDependencyCrossReference_2_1_2_1_2_2_0());
                    	              									
                    	            }
                    	            pushFollow(FOLLOW_26);
                    	            ruleIDString();

                    	            state._fsp--;
                    	            if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              										afterParserOrEnumRuleCall();
                    	              									
                    	            }

                    	            }


                    	            }


                    	            }


                    	            }
                    	            break;
                    	        case 4 :
                    	            // InternalTmscXtext.g:2371:7: (otherlv_29= 'message' otherlv_30= ':' ( ( ruleIDString ) ) )
                    	            {
                    	            // InternalTmscXtext.g:2371:7: (otherlv_29= 'message' otherlv_30= ':' ( ( ruleIDString ) ) )
                    	            // InternalTmscXtext.g:2372:8: otherlv_29= 'message' otherlv_30= ':' ( ( ruleIDString ) )
                    	            {
                    	            otherlv_29=(Token)match(input,43,FOLLOW_6); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              								newLeafNode(otherlv_29, grammarAccess.getXDependencyAccess().getMessageKeyword_2_1_2_1_3_0());
                    	              							
                    	            }
                    	            otherlv_30=(Token)match(input,17,FOLLOW_16); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              								newLeafNode(otherlv_30, grammarAccess.getXDependencyAccess().getColonKeyword_2_1_2_1_3_1());
                    	              							
                    	            }
                    	            // InternalTmscXtext.g:2380:8: ( ( ruleIDString ) )
                    	            // InternalTmscXtext.g:2381:9: ( ruleIDString )
                    	            {
                    	            // InternalTmscXtext.g:2381:9: ( ruleIDString )
                    	            // InternalTmscXtext.g:2382:10: ruleIDString
                    	            {
                    	            if ( state.backtracking==0 ) {

                    	              										if (current==null) {
                    	              											current = createModelElement(grammarAccess.getXDependencyRule());
                    	              										}
                    	              									
                    	            }
                    	            if ( state.backtracking==0 ) {

                    	              										newCompositeNode(grammarAccess.getXDependencyAccess().getMessageXDependencyCrossReference_2_1_2_1_3_2_0());
                    	              									
                    	            }
                    	            pushFollow(FOLLOW_26);
                    	            ruleIDString();

                    	            state._fsp--;
                    	            if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              										afterParserOrEnumRuleCall();
                    	              									
                    	            }

                    	            }


                    	            }


                    	            }


                    	            }
                    	            break;
                    	        case 5 :
                    	            // InternalTmscXtext.g:2398:7: ( (lv_properties_32_0= ruleXProperty ) )
                    	            {
                    	            // InternalTmscXtext.g:2398:7: ( (lv_properties_32_0= ruleXProperty ) )
                    	            // InternalTmscXtext.g:2399:8: (lv_properties_32_0= ruleXProperty )
                    	            {
                    	            // InternalTmscXtext.g:2399:8: (lv_properties_32_0= ruleXProperty )
                    	            // InternalTmscXtext.g:2400:9: lv_properties_32_0= ruleXProperty
                    	            {
                    	            if ( state.backtracking==0 ) {

                    	              									newCompositeNode(grammarAccess.getXDependencyAccess().getPropertiesXPropertyParserRuleCall_2_1_2_1_4_0());
                    	              								
                    	            }
                    	            pushFollow(FOLLOW_26);
                    	            lv_properties_32_0=ruleXProperty();

                    	            state._fsp--;
                    	            if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              									if (current==null) {
                    	              										current = createModelElementForParent(grammarAccess.getXDependencyRule());
                    	              									}
                    	              									add(
                    	              										current,
                    	              										"properties",
                    	              										lv_properties_32_0,
                    	              										"nl.esi.pps.tmsc.xtext.TmscXtext.XProperty");
                    	              									afterParserOrEnumRuleCall();
                    	              								
                    	            }

                    	            }


                    	            }


                    	            }
                    	            break;

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop48;
                        }
                    } while (true);

                    otherlv_33=(Token)match(input,35,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_33, grammarAccess.getXDependencyAccess().getRightParenthesisKeyword_2_1_3());
                      				
                    }

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleXDependency"


    // $ANTLR start "entryRuleXDependencyTypeObject"
    // InternalTmscXtext.g:2429:1: entryRuleXDependencyTypeObject returns [EObject current=null] : iv_ruleXDependencyTypeObject= ruleXDependencyTypeObject EOF ;
    public final EObject entryRuleXDependencyTypeObject() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXDependencyTypeObject = null;


        try {
            // InternalTmscXtext.g:2429:62: (iv_ruleXDependencyTypeObject= ruleXDependencyTypeObject EOF )
            // InternalTmscXtext.g:2430:2: iv_ruleXDependencyTypeObject= ruleXDependencyTypeObject EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXDependencyTypeObjectRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXDependencyTypeObject=ruleXDependencyTypeObject();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXDependencyTypeObject; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXDependencyTypeObject"


    // $ANTLR start "ruleXDependencyTypeObject"
    // InternalTmscXtext.g:2436:1: ruleXDependencyTypeObject returns [EObject current=null] : ( (lv_value_0_0= ruleXDependencyType ) ) ;
    public final EObject ruleXDependencyTypeObject() throws RecognitionException {
        EObject current = null;

        Enumerator lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalTmscXtext.g:2442:2: ( ( (lv_value_0_0= ruleXDependencyType ) ) )
            // InternalTmscXtext.g:2443:2: ( (lv_value_0_0= ruleXDependencyType ) )
            {
            // InternalTmscXtext.g:2443:2: ( (lv_value_0_0= ruleXDependencyType ) )
            // InternalTmscXtext.g:2444:3: (lv_value_0_0= ruleXDependencyType )
            {
            // InternalTmscXtext.g:2444:3: (lv_value_0_0= ruleXDependencyType )
            // InternalTmscXtext.g:2445:4: lv_value_0_0= ruleXDependencyType
            {
            if ( state.backtracking==0 ) {

              				newCompositeNode(grammarAccess.getXDependencyTypeObjectAccess().getValueXDependencyTypeEnumRuleCall_0());
              			
            }
            pushFollow(FOLLOW_2);
            lv_value_0_0=ruleXDependencyType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElementForParent(grammarAccess.getXDependencyTypeObjectRule());
              				}
              				set(
              					current,
              					"value",
              					lv_value_0_0,
              					"nl.esi.pps.tmsc.xtext.TmscXtext.XDependencyType");
              				afterParserOrEnumRuleCall();
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleXDependencyTypeObject"


    // $ANTLR start "entryRuleXDependencySettings"
    // InternalTmscXtext.g:2465:1: entryRuleXDependencySettings returns [EObject current=null] : iv_ruleXDependencySettings= ruleXDependencySettings EOF ;
    public final EObject entryRuleXDependencySettings() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXDependencySettings = null;


        try {
            // InternalTmscXtext.g:2465:60: (iv_ruleXDependencySettings= ruleXDependencySettings EOF )
            // InternalTmscXtext.g:2466:2: iv_ruleXDependencySettings= ruleXDependencySettings EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXDependencySettingsRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXDependencySettings=ruleXDependencySettings();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXDependencySettings; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXDependencySettings"


    // $ANTLR start "ruleXDependencySettings"
    // InternalTmscXtext.g:2472:1: ruleXDependencySettings returns [EObject current=null] : ( ( (lv_type_0_0= ruleXDependencyType ) ) otherlv_1= 'settings' otherlv_2= '{' ( (otherlv_3= 'time-bound' otherlv_4= ':' ( (lv_timeBound_5_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_6= 'scheduled' otherlv_7= ':' ( (lv_scheduled_8_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_9= 'prefix' otherlv_10= ':' ( (lv_prefix_11_0= ruleIDString ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) )* otherlv_13= '}' ) ;
    public final EObject ruleXDependencySettings() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token lv_timeBound_5_0=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_13=null;
        Enumerator lv_type_0_0 = null;

        AntlrDatatypeRuleToken lv_scheduled_8_0 = null;

        AntlrDatatypeRuleToken lv_prefix_11_0 = null;

        EObject lv_properties_12_0 = null;



        	enterRule();

        try {
            // InternalTmscXtext.g:2478:2: ( ( ( (lv_type_0_0= ruleXDependencyType ) ) otherlv_1= 'settings' otherlv_2= '{' ( (otherlv_3= 'time-bound' otherlv_4= ':' ( (lv_timeBound_5_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_6= 'scheduled' otherlv_7= ':' ( (lv_scheduled_8_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_9= 'prefix' otherlv_10= ':' ( (lv_prefix_11_0= ruleIDString ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) )* otherlv_13= '}' ) )
            // InternalTmscXtext.g:2479:2: ( ( (lv_type_0_0= ruleXDependencyType ) ) otherlv_1= 'settings' otherlv_2= '{' ( (otherlv_3= 'time-bound' otherlv_4= ':' ( (lv_timeBound_5_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_6= 'scheduled' otherlv_7= ':' ( (lv_scheduled_8_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_9= 'prefix' otherlv_10= ':' ( (lv_prefix_11_0= ruleIDString ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) )* otherlv_13= '}' )
            {
            // InternalTmscXtext.g:2479:2: ( ( (lv_type_0_0= ruleXDependencyType ) ) otherlv_1= 'settings' otherlv_2= '{' ( (otherlv_3= 'time-bound' otherlv_4= ':' ( (lv_timeBound_5_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_6= 'scheduled' otherlv_7= ':' ( (lv_scheduled_8_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_9= 'prefix' otherlv_10= ':' ( (lv_prefix_11_0= ruleIDString ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) )* otherlv_13= '}' )
            // InternalTmscXtext.g:2480:3: ( (lv_type_0_0= ruleXDependencyType ) ) otherlv_1= 'settings' otherlv_2= '{' ( (otherlv_3= 'time-bound' otherlv_4= ':' ( (lv_timeBound_5_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_6= 'scheduled' otherlv_7= ':' ( (lv_scheduled_8_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_9= 'prefix' otherlv_10= ':' ( (lv_prefix_11_0= ruleIDString ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) )* otherlv_13= '}'
            {
            // InternalTmscXtext.g:2480:3: ( (lv_type_0_0= ruleXDependencyType ) )
            // InternalTmscXtext.g:2481:4: (lv_type_0_0= ruleXDependencyType )
            {
            // InternalTmscXtext.g:2481:4: (lv_type_0_0= ruleXDependencyType )
            // InternalTmscXtext.g:2482:5: lv_type_0_0= ruleXDependencyType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getXDependencySettingsAccess().getTypeXDependencyTypeEnumRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_3);
            lv_type_0_0=ruleXDependencyType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getXDependencySettingsRule());
              					}
              					set(
              						current,
              						"type",
              						lv_type_0_0,
              						"nl.esi.pps.tmsc.xtext.TmscXtext.XDependencyType");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_1=(Token)match(input,14,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getXDependencySettingsAccess().getSettingsKeyword_1());
              		
            }
            otherlv_2=(Token)match(input,15,FOLLOW_38); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getXDependencySettingsAccess().getLeftCurlyBracketKeyword_2());
              		
            }
            // InternalTmscXtext.g:2507:3: ( (otherlv_3= 'time-bound' otherlv_4= ':' ( (lv_timeBound_5_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_6= 'scheduled' otherlv_7= ':' ( (lv_scheduled_8_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_9= 'prefix' otherlv_10= ':' ( (lv_prefix_11_0= ruleIDString ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) )*
            loop50:
            do {
                int alt50=5;
                switch ( input.LA(1) ) {
                case 18:
                    {
                    alt50=1;
                    }
                    break;
                case 19:
                    {
                    alt50=2;
                    }
                    break;
                case 44:
                    {
                    alt50=3;
                    }
                    break;
                case RULE_ID:
                case RULE_STRING:
                    {
                    alt50=4;
                    }
                    break;

                }

                switch (alt50) {
            	case 1 :
            	    // InternalTmscXtext.g:2508:4: (otherlv_3= 'time-bound' otherlv_4= ':' ( (lv_timeBound_5_0= RULE_ABS_EBIGDECIMAL ) ) )
            	    {
            	    // InternalTmscXtext.g:2508:4: (otherlv_3= 'time-bound' otherlv_4= ':' ( (lv_timeBound_5_0= RULE_ABS_EBIGDECIMAL ) ) )
            	    // InternalTmscXtext.g:2509:5: otherlv_3= 'time-bound' otherlv_4= ':' ( (lv_timeBound_5_0= RULE_ABS_EBIGDECIMAL ) )
            	    {
            	    otherlv_3=(Token)match(input,18,FOLLOW_6); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_3, grammarAccess.getXDependencySettingsAccess().getTimeBoundKeyword_3_0_0());
            	      				
            	    }
            	    otherlv_4=(Token)match(input,17,FOLLOW_8); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_4, grammarAccess.getXDependencySettingsAccess().getColonKeyword_3_0_1());
            	      				
            	    }
            	    // InternalTmscXtext.g:2517:5: ( (lv_timeBound_5_0= RULE_ABS_EBIGDECIMAL ) )
            	    // InternalTmscXtext.g:2518:6: (lv_timeBound_5_0= RULE_ABS_EBIGDECIMAL )
            	    {
            	    // InternalTmscXtext.g:2518:6: (lv_timeBound_5_0= RULE_ABS_EBIGDECIMAL )
            	    // InternalTmscXtext.g:2519:7: lv_timeBound_5_0= RULE_ABS_EBIGDECIMAL
            	    {
            	    lv_timeBound_5_0=(Token)match(input,RULE_ABS_EBIGDECIMAL,FOLLOW_38); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      							newLeafNode(lv_timeBound_5_0, grammarAccess.getXDependencySettingsAccess().getTimeBoundABS_EBIGDECIMALTerminalRuleCall_3_0_2_0());
            	      						
            	    }
            	    if ( state.backtracking==0 ) {

            	      							if (current==null) {
            	      								current = createModelElement(grammarAccess.getXDependencySettingsRule());
            	      							}
            	      							setWithLastConsumed(
            	      								current,
            	      								"timeBound",
            	      								lv_timeBound_5_0,
            	      								"nl.esi.pps.tmsc.xtext.TmscXtext.ABS_EBIGDECIMAL");
            	      						
            	    }

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalTmscXtext.g:2537:4: (otherlv_6= 'scheduled' otherlv_7= ':' ( (lv_scheduled_8_0= ruleEBOOLEAN_OBJECT ) ) )
            	    {
            	    // InternalTmscXtext.g:2537:4: (otherlv_6= 'scheduled' otherlv_7= ':' ( (lv_scheduled_8_0= ruleEBOOLEAN_OBJECT ) ) )
            	    // InternalTmscXtext.g:2538:5: otherlv_6= 'scheduled' otherlv_7= ':' ( (lv_scheduled_8_0= ruleEBOOLEAN_OBJECT ) )
            	    {
            	    otherlv_6=(Token)match(input,19,FOLLOW_6); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_6, grammarAccess.getXDependencySettingsAccess().getScheduledKeyword_3_1_0());
            	      				
            	    }
            	    otherlv_7=(Token)match(input,17,FOLLOW_9); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_7, grammarAccess.getXDependencySettingsAccess().getColonKeyword_3_1_1());
            	      				
            	    }
            	    // InternalTmscXtext.g:2546:5: ( (lv_scheduled_8_0= ruleEBOOLEAN_OBJECT ) )
            	    // InternalTmscXtext.g:2547:6: (lv_scheduled_8_0= ruleEBOOLEAN_OBJECT )
            	    {
            	    // InternalTmscXtext.g:2547:6: (lv_scheduled_8_0= ruleEBOOLEAN_OBJECT )
            	    // InternalTmscXtext.g:2548:7: lv_scheduled_8_0= ruleEBOOLEAN_OBJECT
            	    {
            	    if ( state.backtracking==0 ) {

            	      							newCompositeNode(grammarAccess.getXDependencySettingsAccess().getScheduledEBOOLEAN_OBJECTParserRuleCall_3_1_2_0());
            	      						
            	    }
            	    pushFollow(FOLLOW_38);
            	    lv_scheduled_8_0=ruleEBOOLEAN_OBJECT();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      							if (current==null) {
            	      								current = createModelElementForParent(grammarAccess.getXDependencySettingsRule());
            	      							}
            	      							set(
            	      								current,
            	      								"scheduled",
            	      								lv_scheduled_8_0,
            	      								"nl.esi.pps.tmsc.xtext.TmscXtext.EBOOLEAN_OBJECT");
            	      							afterParserOrEnumRuleCall();
            	      						
            	    }

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalTmscXtext.g:2567:4: (otherlv_9= 'prefix' otherlv_10= ':' ( (lv_prefix_11_0= ruleIDString ) ) )
            	    {
            	    // InternalTmscXtext.g:2567:4: (otherlv_9= 'prefix' otherlv_10= ':' ( (lv_prefix_11_0= ruleIDString ) ) )
            	    // InternalTmscXtext.g:2568:5: otherlv_9= 'prefix' otherlv_10= ':' ( (lv_prefix_11_0= ruleIDString ) )
            	    {
            	    otherlv_9=(Token)match(input,44,FOLLOW_6); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_9, grammarAccess.getXDependencySettingsAccess().getPrefixKeyword_3_2_0());
            	      				
            	    }
            	    otherlv_10=(Token)match(input,17,FOLLOW_16); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_10, grammarAccess.getXDependencySettingsAccess().getColonKeyword_3_2_1());
            	      				
            	    }
            	    // InternalTmscXtext.g:2576:5: ( (lv_prefix_11_0= ruleIDString ) )
            	    // InternalTmscXtext.g:2577:6: (lv_prefix_11_0= ruleIDString )
            	    {
            	    // InternalTmscXtext.g:2577:6: (lv_prefix_11_0= ruleIDString )
            	    // InternalTmscXtext.g:2578:7: lv_prefix_11_0= ruleIDString
            	    {
            	    if ( state.backtracking==0 ) {

            	      							newCompositeNode(grammarAccess.getXDependencySettingsAccess().getPrefixIDStringParserRuleCall_3_2_2_0());
            	      						
            	    }
            	    pushFollow(FOLLOW_38);
            	    lv_prefix_11_0=ruleIDString();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      							if (current==null) {
            	      								current = createModelElementForParent(grammarAccess.getXDependencySettingsRule());
            	      							}
            	      							set(
            	      								current,
            	      								"prefix",
            	      								lv_prefix_11_0,
            	      								"nl.esi.pps.tmsc.xtext.TmscXtext.IDString");
            	      							afterParserOrEnumRuleCall();
            	      						
            	    }

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalTmscXtext.g:2597:4: ( (lv_properties_12_0= ruleXProperty ) )
            	    {
            	    // InternalTmscXtext.g:2597:4: ( (lv_properties_12_0= ruleXProperty ) )
            	    // InternalTmscXtext.g:2598:5: (lv_properties_12_0= ruleXProperty )
            	    {
            	    // InternalTmscXtext.g:2598:5: (lv_properties_12_0= ruleXProperty )
            	    // InternalTmscXtext.g:2599:6: lv_properties_12_0= ruleXProperty
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getXDependencySettingsAccess().getPropertiesXPropertyParserRuleCall_3_3_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_38);
            	    lv_properties_12_0=ruleXProperty();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getXDependencySettingsRule());
            	      						}
            	      						add(
            	      							current,
            	      							"properties",
            	      							lv_properties_12_0,
            	      							"nl.esi.pps.tmsc.xtext.TmscXtext.XProperty");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop50;
                }
            } while (true);

            otherlv_13=(Token)match(input,20,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_13, grammarAccess.getXDependencySettingsAccess().getRightCurlyBracketKeyword_4());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleXDependencySettings"


    // $ANTLR start "entryRuleXProperty"
    // InternalTmscXtext.g:2625:1: entryRuleXProperty returns [EObject current=null] : iv_ruleXProperty= ruleXProperty EOF ;
    public final EObject entryRuleXProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXProperty = null;


        try {
            // InternalTmscXtext.g:2625:50: (iv_ruleXProperty= ruleXProperty EOF )
            // InternalTmscXtext.g:2626:2: iv_ruleXProperty= ruleXProperty EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXPropertyRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXProperty=ruleXProperty();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXProperty; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXProperty"


    // $ANTLR start "ruleXProperty"
    // InternalTmscXtext.g:2632:1: ruleXProperty returns [EObject current=null] : ( ( (lv_name_0_0= ruleIDString ) ) otherlv_1= ':' ( (lv_value_2_0= ruleXPropertyValue ) ) ) ;
    public final EObject ruleXProperty() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalTmscXtext.g:2638:2: ( ( ( (lv_name_0_0= ruleIDString ) ) otherlv_1= ':' ( (lv_value_2_0= ruleXPropertyValue ) ) ) )
            // InternalTmscXtext.g:2639:2: ( ( (lv_name_0_0= ruleIDString ) ) otherlv_1= ':' ( (lv_value_2_0= ruleXPropertyValue ) ) )
            {
            // InternalTmscXtext.g:2639:2: ( ( (lv_name_0_0= ruleIDString ) ) otherlv_1= ':' ( (lv_value_2_0= ruleXPropertyValue ) ) )
            // InternalTmscXtext.g:2640:3: ( (lv_name_0_0= ruleIDString ) ) otherlv_1= ':' ( (lv_value_2_0= ruleXPropertyValue ) )
            {
            // InternalTmscXtext.g:2640:3: ( (lv_name_0_0= ruleIDString ) )
            // InternalTmscXtext.g:2641:4: (lv_name_0_0= ruleIDString )
            {
            // InternalTmscXtext.g:2641:4: (lv_name_0_0= ruleIDString )
            // InternalTmscXtext.g:2642:5: lv_name_0_0= ruleIDString
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getXPropertyAccess().getNameIDStringParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_6);
            lv_name_0_0=ruleIDString();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getXPropertyRule());
              					}
              					set(
              						current,
              						"name",
              						lv_name_0_0,
              						"nl.esi.pps.tmsc.xtext.TmscXtext.IDString");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_1=(Token)match(input,17,FOLLOW_39); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getXPropertyAccess().getColonKeyword_1());
              		
            }
            // InternalTmscXtext.g:2663:3: ( (lv_value_2_0= ruleXPropertyValue ) )
            // InternalTmscXtext.g:2664:4: (lv_value_2_0= ruleXPropertyValue )
            {
            // InternalTmscXtext.g:2664:4: (lv_value_2_0= ruleXPropertyValue )
            // InternalTmscXtext.g:2665:5: lv_value_2_0= ruleXPropertyValue
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getXPropertyAccess().getValueXPropertyValueParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_value_2_0=ruleXPropertyValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getXPropertyRule());
              					}
              					set(
              						current,
              						"value",
              						lv_value_2_0,
              						"nl.esi.pps.tmsc.xtext.TmscXtext.XPropertyValue");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleXProperty"


    // $ANTLR start "entryRuleXPropertyValue"
    // InternalTmscXtext.g:2686:1: entryRuleXPropertyValue returns [EObject current=null] : iv_ruleXPropertyValue= ruleXPropertyValue EOF ;
    public final EObject entryRuleXPropertyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXPropertyValue = null;


        try {
            // InternalTmscXtext.g:2686:55: (iv_ruleXPropertyValue= ruleXPropertyValue EOF )
            // InternalTmscXtext.g:2687:2: iv_ruleXPropertyValue= ruleXPropertyValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXPropertyValueRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXPropertyValue=ruleXPropertyValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXPropertyValue; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXPropertyValue"


    // $ANTLR start "ruleXPropertyValue"
    // InternalTmscXtext.g:2693:1: ruleXPropertyValue returns [EObject current=null] : ( ( () ( ( ( ruleIDString ) )=> (lv_value_1_0= ruleIDString ) ) ) | ( () ( ( ( ruleEBIGDECIMAL ) )=> (lv_value_3_0= ruleEBIGDECIMAL ) ) ) | ( () ( ( ( ruleEBOOLEAN_OBJECT ) )=> (lv_value_5_0= ruleEBOOLEAN_OBJECT ) ) ) | ( () ( ( '[' )=>otherlv_7= '[' ) ( (lv_values_8_0= ruleXPropertyValue ) ) (otherlv_9= ',' ( (lv_values_10_0= ruleXPropertyValue ) ) )* otherlv_11= ']' ) ) ;
    public final EObject ruleXPropertyValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        AntlrDatatypeRuleToken lv_value_1_0 = null;

        AntlrDatatypeRuleToken lv_value_3_0 = null;

        AntlrDatatypeRuleToken lv_value_5_0 = null;

        EObject lv_values_8_0 = null;

        EObject lv_values_10_0 = null;



        	enterRule();

        try {
            // InternalTmscXtext.g:2699:2: ( ( ( () ( ( ( ruleIDString ) )=> (lv_value_1_0= ruleIDString ) ) ) | ( () ( ( ( ruleEBIGDECIMAL ) )=> (lv_value_3_0= ruleEBIGDECIMAL ) ) ) | ( () ( ( ( ruleEBOOLEAN_OBJECT ) )=> (lv_value_5_0= ruleEBOOLEAN_OBJECT ) ) ) | ( () ( ( '[' )=>otherlv_7= '[' ) ( (lv_values_8_0= ruleXPropertyValue ) ) (otherlv_9= ',' ( (lv_values_10_0= ruleXPropertyValue ) ) )* otherlv_11= ']' ) ) )
            // InternalTmscXtext.g:2700:2: ( ( () ( ( ( ruleIDString ) )=> (lv_value_1_0= ruleIDString ) ) ) | ( () ( ( ( ruleEBIGDECIMAL ) )=> (lv_value_3_0= ruleEBIGDECIMAL ) ) ) | ( () ( ( ( ruleEBOOLEAN_OBJECT ) )=> (lv_value_5_0= ruleEBOOLEAN_OBJECT ) ) ) | ( () ( ( '[' )=>otherlv_7= '[' ) ( (lv_values_8_0= ruleXPropertyValue ) ) (otherlv_9= ',' ( (lv_values_10_0= ruleXPropertyValue ) ) )* otherlv_11= ']' ) )
            {
            // InternalTmscXtext.g:2700:2: ( ( () ( ( ( ruleIDString ) )=> (lv_value_1_0= ruleIDString ) ) ) | ( () ( ( ( ruleEBIGDECIMAL ) )=> (lv_value_3_0= ruleEBIGDECIMAL ) ) ) | ( () ( ( ( ruleEBOOLEAN_OBJECT ) )=> (lv_value_5_0= ruleEBOOLEAN_OBJECT ) ) ) | ( () ( ( '[' )=>otherlv_7= '[' ) ( (lv_values_8_0= ruleXPropertyValue ) ) (otherlv_9= ',' ( (lv_values_10_0= ruleXPropertyValue ) ) )* otherlv_11= ']' ) )
            int alt52=4;
            switch ( input.LA(1) ) {
            case RULE_ID:
            case RULE_STRING:
                {
                alt52=1;
                }
                break;
            case RULE_ABS_EBIGDECIMAL:
            case RULE_POS_EBIGDECIMAL:
            case RULE_NEG_EBIGDECIMAL:
                {
                alt52=2;
                }
                break;
            case 48:
            case 49:
                {
                alt52=3;
                }
                break;
            case 45:
                {
                alt52=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;
            }

            switch (alt52) {
                case 1 :
                    // InternalTmscXtext.g:2701:3: ( () ( ( ( ruleIDString ) )=> (lv_value_1_0= ruleIDString ) ) )
                    {
                    // InternalTmscXtext.g:2701:3: ( () ( ( ( ruleIDString ) )=> (lv_value_1_0= ruleIDString ) ) )
                    // InternalTmscXtext.g:2702:4: () ( ( ( ruleIDString ) )=> (lv_value_1_0= ruleIDString ) )
                    {
                    // InternalTmscXtext.g:2702:4: ()
                    // InternalTmscXtext.g:2703:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getXPropertyValueAccess().getXPropertyStringValueAction_0_0(),
                      						current);
                      				
                    }

                    }

                    // InternalTmscXtext.g:2709:4: ( ( ( ruleIDString ) )=> (lv_value_1_0= ruleIDString ) )
                    // InternalTmscXtext.g:2710:5: ( ( ruleIDString ) )=> (lv_value_1_0= ruleIDString )
                    {
                    // InternalTmscXtext.g:2714:5: (lv_value_1_0= ruleIDString )
                    // InternalTmscXtext.g:2715:6: lv_value_1_0= ruleIDString
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getXPropertyValueAccess().getValueIDStringParserRuleCall_0_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_value_1_0=ruleIDString();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getXPropertyValueRule());
                      						}
                      						set(
                      							current,
                      							"value",
                      							lv_value_1_0,
                      							"nl.esi.pps.tmsc.xtext.TmscXtext.IDString");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalTmscXtext.g:2734:3: ( () ( ( ( ruleEBIGDECIMAL ) )=> (lv_value_3_0= ruleEBIGDECIMAL ) ) )
                    {
                    // InternalTmscXtext.g:2734:3: ( () ( ( ( ruleEBIGDECIMAL ) )=> (lv_value_3_0= ruleEBIGDECIMAL ) ) )
                    // InternalTmscXtext.g:2735:4: () ( ( ( ruleEBIGDECIMAL ) )=> (lv_value_3_0= ruleEBIGDECIMAL ) )
                    {
                    // InternalTmscXtext.g:2735:4: ()
                    // InternalTmscXtext.g:2736:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getXPropertyValueAccess().getXPropertyNumberValueAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalTmscXtext.g:2742:4: ( ( ( ruleEBIGDECIMAL ) )=> (lv_value_3_0= ruleEBIGDECIMAL ) )
                    // InternalTmscXtext.g:2743:5: ( ( ruleEBIGDECIMAL ) )=> (lv_value_3_0= ruleEBIGDECIMAL )
                    {
                    // InternalTmscXtext.g:2747:5: (lv_value_3_0= ruleEBIGDECIMAL )
                    // InternalTmscXtext.g:2748:6: lv_value_3_0= ruleEBIGDECIMAL
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getXPropertyValueAccess().getValueEBIGDECIMALParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_value_3_0=ruleEBIGDECIMAL();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getXPropertyValueRule());
                      						}
                      						set(
                      							current,
                      							"value",
                      							lv_value_3_0,
                      							"nl.esi.pps.tmsc.xtext.TmscXtext.EBIGDECIMAL");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalTmscXtext.g:2767:3: ( () ( ( ( ruleEBOOLEAN_OBJECT ) )=> (lv_value_5_0= ruleEBOOLEAN_OBJECT ) ) )
                    {
                    // InternalTmscXtext.g:2767:3: ( () ( ( ( ruleEBOOLEAN_OBJECT ) )=> (lv_value_5_0= ruleEBOOLEAN_OBJECT ) ) )
                    // InternalTmscXtext.g:2768:4: () ( ( ( ruleEBOOLEAN_OBJECT ) )=> (lv_value_5_0= ruleEBOOLEAN_OBJECT ) )
                    {
                    // InternalTmscXtext.g:2768:4: ()
                    // InternalTmscXtext.g:2769:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getXPropertyValueAccess().getXPropertyBooleanValueAction_2_0(),
                      						current);
                      				
                    }

                    }

                    // InternalTmscXtext.g:2775:4: ( ( ( ruleEBOOLEAN_OBJECT ) )=> (lv_value_5_0= ruleEBOOLEAN_OBJECT ) )
                    // InternalTmscXtext.g:2776:5: ( ( ruleEBOOLEAN_OBJECT ) )=> (lv_value_5_0= ruleEBOOLEAN_OBJECT )
                    {
                    // InternalTmscXtext.g:2780:5: (lv_value_5_0= ruleEBOOLEAN_OBJECT )
                    // InternalTmscXtext.g:2781:6: lv_value_5_0= ruleEBOOLEAN_OBJECT
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getXPropertyValueAccess().getValueEBOOLEAN_OBJECTParserRuleCall_2_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_value_5_0=ruleEBOOLEAN_OBJECT();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getXPropertyValueRule());
                      						}
                      						set(
                      							current,
                      							"value",
                      							lv_value_5_0,
                      							"nl.esi.pps.tmsc.xtext.TmscXtext.EBOOLEAN_OBJECT");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalTmscXtext.g:2800:3: ( () ( ( '[' )=>otherlv_7= '[' ) ( (lv_values_8_0= ruleXPropertyValue ) ) (otherlv_9= ',' ( (lv_values_10_0= ruleXPropertyValue ) ) )* otherlv_11= ']' )
                    {
                    // InternalTmscXtext.g:2800:3: ( () ( ( '[' )=>otherlv_7= '[' ) ( (lv_values_8_0= ruleXPropertyValue ) ) (otherlv_9= ',' ( (lv_values_10_0= ruleXPropertyValue ) ) )* otherlv_11= ']' )
                    // InternalTmscXtext.g:2801:4: () ( ( '[' )=>otherlv_7= '[' ) ( (lv_values_8_0= ruleXPropertyValue ) ) (otherlv_9= ',' ( (lv_values_10_0= ruleXPropertyValue ) ) )* otherlv_11= ']'
                    {
                    // InternalTmscXtext.g:2801:4: ()
                    // InternalTmscXtext.g:2802:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getXPropertyValueAccess().getXPropertyMutliValueAction_3_0(),
                      						current);
                      				
                    }

                    }

                    // InternalTmscXtext.g:2808:4: ( ( '[' )=>otherlv_7= '[' )
                    // InternalTmscXtext.g:2809:5: ( '[' )=>otherlv_7= '['
                    {
                    otherlv_7=(Token)match(input,45,FOLLOW_39); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_7, grammarAccess.getXPropertyValueAccess().getLeftSquareBracketKeyword_3_1());
                      				
                    }

                    }

                    // InternalTmscXtext.g:2815:4: ( (lv_values_8_0= ruleXPropertyValue ) )
                    // InternalTmscXtext.g:2816:5: (lv_values_8_0= ruleXPropertyValue )
                    {
                    // InternalTmscXtext.g:2816:5: (lv_values_8_0= ruleXPropertyValue )
                    // InternalTmscXtext.g:2817:6: lv_values_8_0= ruleXPropertyValue
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getXPropertyValueAccess().getValuesXPropertyValueParserRuleCall_3_2_0());
                      					
                    }
                    pushFollow(FOLLOW_40);
                    lv_values_8_0=ruleXPropertyValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getXPropertyValueRule());
                      						}
                      						add(
                      							current,
                      							"values",
                      							lv_values_8_0,
                      							"nl.esi.pps.tmsc.xtext.TmscXtext.XPropertyValue");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalTmscXtext.g:2834:4: (otherlv_9= ',' ( (lv_values_10_0= ruleXPropertyValue ) ) )*
                    loop51:
                    do {
                        int alt51=2;
                        int LA51_0 = input.LA(1);

                        if ( (LA51_0==29) ) {
                            alt51=1;
                        }


                        switch (alt51) {
                    	case 1 :
                    	    // InternalTmscXtext.g:2835:5: otherlv_9= ',' ( (lv_values_10_0= ruleXPropertyValue ) )
                    	    {
                    	    otherlv_9=(Token)match(input,29,FOLLOW_39); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_9, grammarAccess.getXPropertyValueAccess().getCommaKeyword_3_3_0());
                    	      				
                    	    }
                    	    // InternalTmscXtext.g:2839:5: ( (lv_values_10_0= ruleXPropertyValue ) )
                    	    // InternalTmscXtext.g:2840:6: (lv_values_10_0= ruleXPropertyValue )
                    	    {
                    	    // InternalTmscXtext.g:2840:6: (lv_values_10_0= ruleXPropertyValue )
                    	    // InternalTmscXtext.g:2841:7: lv_values_10_0= ruleXPropertyValue
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getXPropertyValueAccess().getValuesXPropertyValueParserRuleCall_3_3_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_40);
                    	    lv_values_10_0=ruleXPropertyValue();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getXPropertyValueRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"values",
                    	      								lv_values_10_0,
                    	      								"nl.esi.pps.tmsc.xtext.TmscXtext.XPropertyValue");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop51;
                        }
                    } while (true);

                    otherlv_11=(Token)match(input,46,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_11, grammarAccess.getXPropertyValueAccess().getRightSquareBracketKeyword_3_4());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleXPropertyValue"


    // $ANTLR start "entryRuleFQNString"
    // InternalTmscXtext.g:2868:1: entryRuleFQNString returns [String current=null] : iv_ruleFQNString= ruleFQNString EOF ;
    public final String entryRuleFQNString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQNString = null;


        try {
            // InternalTmscXtext.g:2868:49: (iv_ruleFQNString= ruleFQNString EOF )
            // InternalTmscXtext.g:2869:2: iv_ruleFQNString= ruleFQNString EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFQNStringRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFQNString=ruleFQNString();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFQNString.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleFQNString"


    // $ANTLR start "ruleFQNString"
    // InternalTmscXtext.g:2875:1: ruleFQNString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_FQN_0= ruleFQN | this_STRING_1= RULE_STRING ) ;
    public final AntlrDatatypeRuleToken ruleFQNString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_1=null;
        AntlrDatatypeRuleToken this_FQN_0 = null;



        	enterRule();

        try {
            // InternalTmscXtext.g:2881:2: ( (this_FQN_0= ruleFQN | this_STRING_1= RULE_STRING ) )
            // InternalTmscXtext.g:2882:2: (this_FQN_0= ruleFQN | this_STRING_1= RULE_STRING )
            {
            // InternalTmscXtext.g:2882:2: (this_FQN_0= ruleFQN | this_STRING_1= RULE_STRING )
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==RULE_ID) ) {
                alt53=1;
            }
            else if ( (LA53_0==RULE_STRING) ) {
                alt53=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 53, 0, input);

                throw nvae;
            }
            switch (alt53) {
                case 1 :
                    // InternalTmscXtext.g:2883:3: this_FQN_0= ruleFQN
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getFQNStringAccess().getFQNParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_FQN_0=ruleFQN();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_FQN_0);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalTmscXtext.g:2894:3: this_STRING_1= RULE_STRING
                    {
                    this_STRING_1=(Token)match(input,RULE_STRING,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_STRING_1);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newLeafNode(this_STRING_1, grammarAccess.getFQNStringAccess().getSTRINGTerminalRuleCall_1());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleFQNString"


    // $ANTLR start "entryRuleIDString"
    // InternalTmscXtext.g:2905:1: entryRuleIDString returns [String current=null] : iv_ruleIDString= ruleIDString EOF ;
    public final String entryRuleIDString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIDString = null;


        try {
            // InternalTmscXtext.g:2905:48: (iv_ruleIDString= ruleIDString EOF )
            // InternalTmscXtext.g:2906:2: iv_ruleIDString= ruleIDString EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIDStringRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleIDString=ruleIDString();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIDString.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleIDString"


    // $ANTLR start "ruleIDString"
    // InternalTmscXtext.g:2912:1: ruleIDString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | this_STRING_1= RULE_STRING ) ;
    public final AntlrDatatypeRuleToken ruleIDString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token this_STRING_1=null;


        	enterRule();

        try {
            // InternalTmscXtext.g:2918:2: ( (this_ID_0= RULE_ID | this_STRING_1= RULE_STRING ) )
            // InternalTmscXtext.g:2919:2: (this_ID_0= RULE_ID | this_STRING_1= RULE_STRING )
            {
            // InternalTmscXtext.g:2919:2: (this_ID_0= RULE_ID | this_STRING_1= RULE_STRING )
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==RULE_ID) ) {
                alt54=1;
            }
            else if ( (LA54_0==RULE_STRING) ) {
                alt54=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 54, 0, input);

                throw nvae;
            }
            switch (alt54) {
                case 1 :
                    // InternalTmscXtext.g:2920:3: this_ID_0= RULE_ID
                    {
                    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_ID_0);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newLeafNode(this_ID_0, grammarAccess.getIDStringAccess().getIDTerminalRuleCall_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalTmscXtext.g:2928:3: this_STRING_1= RULE_STRING
                    {
                    this_STRING_1=(Token)match(input,RULE_STRING,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_STRING_1);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newLeafNode(this_STRING_1, grammarAccess.getIDStringAccess().getSTRINGTerminalRuleCall_1());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleIDString"


    // $ANTLR start "entryRuleFQN"
    // InternalTmscXtext.g:2939:1: entryRuleFQN returns [String current=null] : iv_ruleFQN= ruleFQN EOF ;
    public final String entryRuleFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQN = null;


        try {
            // InternalTmscXtext.g:2939:43: (iv_ruleFQN= ruleFQN EOF )
            // InternalTmscXtext.g:2940:2: iv_ruleFQN= ruleFQN EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFQNRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFQN=ruleFQN();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFQN.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleFQN"


    // $ANTLR start "ruleFQN"
    // InternalTmscXtext.g:2946:1: ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalTmscXtext.g:2952:2: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalTmscXtext.g:2953:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalTmscXtext.g:2953:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalTmscXtext.g:2954:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_41); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_ID_0);
              		
            }
            if ( state.backtracking==0 ) {

              			newLeafNode(this_ID_0, grammarAccess.getFQNAccess().getIDTerminalRuleCall_0());
              		
            }
            // InternalTmscXtext.g:2961:3: (kw= '.' this_ID_2= RULE_ID )*
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( (LA55_0==47) ) {
                    alt55=1;
                }


                switch (alt55) {
            	case 1 :
            	    // InternalTmscXtext.g:2962:4: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,47,FOLLOW_18); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				current.merge(kw);
            	      				newLeafNode(kw, grammarAccess.getFQNAccess().getFullStopKeyword_1_0());
            	      			
            	    }
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_41); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				current.merge(this_ID_2);
            	      			
            	    }
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(this_ID_2, grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1());
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop55;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleFQN"


    // $ANTLR start "entryRuleEBOOLEAN_OBJECT"
    // InternalTmscXtext.g:2979:1: entryRuleEBOOLEAN_OBJECT returns [String current=null] : iv_ruleEBOOLEAN_OBJECT= ruleEBOOLEAN_OBJECT EOF ;
    public final String entryRuleEBOOLEAN_OBJECT() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEBOOLEAN_OBJECT = null;


        try {
            // InternalTmscXtext.g:2979:55: (iv_ruleEBOOLEAN_OBJECT= ruleEBOOLEAN_OBJECT EOF )
            // InternalTmscXtext.g:2980:2: iv_ruleEBOOLEAN_OBJECT= ruleEBOOLEAN_OBJECT EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEBOOLEAN_OBJECTRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEBOOLEAN_OBJECT=ruleEBOOLEAN_OBJECT();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEBOOLEAN_OBJECT.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleEBOOLEAN_OBJECT"


    // $ANTLR start "ruleEBOOLEAN_OBJECT"
    // InternalTmscXtext.g:2986:1: ruleEBOOLEAN_OBJECT returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'true' | kw= 'false' ) ;
    public final AntlrDatatypeRuleToken ruleEBOOLEAN_OBJECT() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalTmscXtext.g:2992:2: ( (kw= 'true' | kw= 'false' ) )
            // InternalTmscXtext.g:2993:2: (kw= 'true' | kw= 'false' )
            {
            // InternalTmscXtext.g:2993:2: (kw= 'true' | kw= 'false' )
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==48) ) {
                alt56=1;
            }
            else if ( (LA56_0==49) ) {
                alt56=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 56, 0, input);

                throw nvae;
            }
            switch (alt56) {
                case 1 :
                    // InternalTmscXtext.g:2994:3: kw= 'true'
                    {
                    kw=(Token)match(input,48,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getEBOOLEAN_OBJECTAccess().getTrueKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalTmscXtext.g:3000:3: kw= 'false'
                    {
                    kw=(Token)match(input,49,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getEBOOLEAN_OBJECTAccess().getFalseKeyword_1());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleEBOOLEAN_OBJECT"


    // $ANTLR start "entryRuleEBIGDECIMAL"
    // InternalTmscXtext.g:3009:1: entryRuleEBIGDECIMAL returns [String current=null] : iv_ruleEBIGDECIMAL= ruleEBIGDECIMAL EOF ;
    public final String entryRuleEBIGDECIMAL() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEBIGDECIMAL = null;


        try {
            // InternalTmscXtext.g:3009:51: (iv_ruleEBIGDECIMAL= ruleEBIGDECIMAL EOF )
            // InternalTmscXtext.g:3010:2: iv_ruleEBIGDECIMAL= ruleEBIGDECIMAL EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEBIGDECIMALRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEBIGDECIMAL=ruleEBIGDECIMAL();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEBIGDECIMAL.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleEBIGDECIMAL"


    // $ANTLR start "ruleEBIGDECIMAL"
    // InternalTmscXtext.g:3016:1: ruleEBIGDECIMAL returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ABS_EBIGDECIMAL_0= RULE_ABS_EBIGDECIMAL | this_POS_EBIGDECIMAL_1= RULE_POS_EBIGDECIMAL | this_NEG_EBIGDECIMAL_2= RULE_NEG_EBIGDECIMAL ) ;
    public final AntlrDatatypeRuleToken ruleEBIGDECIMAL() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ABS_EBIGDECIMAL_0=null;
        Token this_POS_EBIGDECIMAL_1=null;
        Token this_NEG_EBIGDECIMAL_2=null;


        	enterRule();

        try {
            // InternalTmscXtext.g:3022:2: ( (this_ABS_EBIGDECIMAL_0= RULE_ABS_EBIGDECIMAL | this_POS_EBIGDECIMAL_1= RULE_POS_EBIGDECIMAL | this_NEG_EBIGDECIMAL_2= RULE_NEG_EBIGDECIMAL ) )
            // InternalTmscXtext.g:3023:2: (this_ABS_EBIGDECIMAL_0= RULE_ABS_EBIGDECIMAL | this_POS_EBIGDECIMAL_1= RULE_POS_EBIGDECIMAL | this_NEG_EBIGDECIMAL_2= RULE_NEG_EBIGDECIMAL )
            {
            // InternalTmscXtext.g:3023:2: (this_ABS_EBIGDECIMAL_0= RULE_ABS_EBIGDECIMAL | this_POS_EBIGDECIMAL_1= RULE_POS_EBIGDECIMAL | this_NEG_EBIGDECIMAL_2= RULE_NEG_EBIGDECIMAL )
            int alt57=3;
            switch ( input.LA(1) ) {
            case RULE_ABS_EBIGDECIMAL:
                {
                alt57=1;
                }
                break;
            case RULE_POS_EBIGDECIMAL:
                {
                alt57=2;
                }
                break;
            case RULE_NEG_EBIGDECIMAL:
                {
                alt57=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 57, 0, input);

                throw nvae;
            }

            switch (alt57) {
                case 1 :
                    // InternalTmscXtext.g:3024:3: this_ABS_EBIGDECIMAL_0= RULE_ABS_EBIGDECIMAL
                    {
                    this_ABS_EBIGDECIMAL_0=(Token)match(input,RULE_ABS_EBIGDECIMAL,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_ABS_EBIGDECIMAL_0);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newLeafNode(this_ABS_EBIGDECIMAL_0, grammarAccess.getEBIGDECIMALAccess().getABS_EBIGDECIMALTerminalRuleCall_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalTmscXtext.g:3032:3: this_POS_EBIGDECIMAL_1= RULE_POS_EBIGDECIMAL
                    {
                    this_POS_EBIGDECIMAL_1=(Token)match(input,RULE_POS_EBIGDECIMAL,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_POS_EBIGDECIMAL_1);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newLeafNode(this_POS_EBIGDECIMAL_1, grammarAccess.getEBIGDECIMALAccess().getPOS_EBIGDECIMALTerminalRuleCall_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalTmscXtext.g:3040:3: this_NEG_EBIGDECIMAL_2= RULE_NEG_EBIGDECIMAL
                    {
                    this_NEG_EBIGDECIMAL_2=(Token)match(input,RULE_NEG_EBIGDECIMAL,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_NEG_EBIGDECIMAL_2);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newLeafNode(this_NEG_EBIGDECIMAL_2, grammarAccess.getEBIGDECIMALAccess().getNEG_EBIGDECIMALTerminalRuleCall_2());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleEBIGDECIMAL"


    // $ANTLR start "ruleXArchitectureKind"
    // InternalTmscXtext.g:3051:1: ruleXArchitectureKind returns [Enumerator current=null] : ( (enumLiteral_0= 'internal' ) | (enumLiteral_1= 'external' ) ) ;
    public final Enumerator ruleXArchitectureKind() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalTmscXtext.g:3057:2: ( ( (enumLiteral_0= 'internal' ) | (enumLiteral_1= 'external' ) ) )
            // InternalTmscXtext.g:3058:2: ( (enumLiteral_0= 'internal' ) | (enumLiteral_1= 'external' ) )
            {
            // InternalTmscXtext.g:3058:2: ( (enumLiteral_0= 'internal' ) | (enumLiteral_1= 'external' ) )
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==50) ) {
                alt58=1;
            }
            else if ( (LA58_0==51) ) {
                alt58=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 58, 0, input);

                throw nvae;
            }
            switch (alt58) {
                case 1 :
                    // InternalTmscXtext.g:3059:3: (enumLiteral_0= 'internal' )
                    {
                    // InternalTmscXtext.g:3059:3: (enumLiteral_0= 'internal' )
                    // InternalTmscXtext.g:3060:4: enumLiteral_0= 'internal'
                    {
                    enumLiteral_0=(Token)match(input,50,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getXArchitectureKindAccess().getINTERNALEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getXArchitectureKindAccess().getINTERNALEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalTmscXtext.g:3067:3: (enumLiteral_1= 'external' )
                    {
                    // InternalTmscXtext.g:3067:3: (enumLiteral_1= 'external' )
                    // InternalTmscXtext.g:3068:4: enumLiteral_1= 'external'
                    {
                    enumLiteral_1=(Token)match(input,51,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getXArchitectureKindAccess().getEXTERNALEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getXArchitectureKindAccess().getEXTERNALEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleXArchitectureKind"


    // $ANTLR start "ruleXFunctionParameterKind"
    // InternalTmscXtext.g:3078:1: ruleXFunctionParameterKind returns [Enumerator current=null] : ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'out' ) | (enumLiteral_2= 'inout' ) | (enumLiteral_3= 'return' ) ) ;
    public final Enumerator ruleXFunctionParameterKind() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalTmscXtext.g:3084:2: ( ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'out' ) | (enumLiteral_2= 'inout' ) | (enumLiteral_3= 'return' ) ) )
            // InternalTmscXtext.g:3085:2: ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'out' ) | (enumLiteral_2= 'inout' ) | (enumLiteral_3= 'return' ) )
            {
            // InternalTmscXtext.g:3085:2: ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'out' ) | (enumLiteral_2= 'inout' ) | (enumLiteral_3= 'return' ) )
            int alt59=4;
            switch ( input.LA(1) ) {
            case 52:
                {
                alt59=1;
                }
                break;
            case 53:
                {
                alt59=2;
                }
                break;
            case 54:
                {
                alt59=3;
                }
                break;
            case 55:
                {
                alt59=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 59, 0, input);

                throw nvae;
            }

            switch (alt59) {
                case 1 :
                    // InternalTmscXtext.g:3086:3: (enumLiteral_0= 'in' )
                    {
                    // InternalTmscXtext.g:3086:3: (enumLiteral_0= 'in' )
                    // InternalTmscXtext.g:3087:4: enumLiteral_0= 'in'
                    {
                    enumLiteral_0=(Token)match(input,52,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getXFunctionParameterKindAccess().getINEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getXFunctionParameterKindAccess().getINEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalTmscXtext.g:3094:3: (enumLiteral_1= 'out' )
                    {
                    // InternalTmscXtext.g:3094:3: (enumLiteral_1= 'out' )
                    // InternalTmscXtext.g:3095:4: enumLiteral_1= 'out'
                    {
                    enumLiteral_1=(Token)match(input,53,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getXFunctionParameterKindAccess().getOUTEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getXFunctionParameterKindAccess().getOUTEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalTmscXtext.g:3102:3: (enumLiteral_2= 'inout' )
                    {
                    // InternalTmscXtext.g:3102:3: (enumLiteral_2= 'inout' )
                    // InternalTmscXtext.g:3103:4: enumLiteral_2= 'inout'
                    {
                    enumLiteral_2=(Token)match(input,54,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getXFunctionParameterKindAccess().getIN_OUTEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getXFunctionParameterKindAccess().getIN_OUTEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalTmscXtext.g:3110:3: (enumLiteral_3= 'return' )
                    {
                    // InternalTmscXtext.g:3110:3: (enumLiteral_3= 'return' )
                    // InternalTmscXtext.g:3111:4: enumLiteral_3= 'return'
                    {
                    enumLiteral_3=(Token)match(input,55,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getXFunctionParameterKindAccess().getRETURNEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_3, grammarAccess.getXFunctionParameterKindAccess().getRETURNEnumLiteralDeclaration_3());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleXFunctionParameterKind"


    // $ANTLR start "ruleXEventType"
    // InternalTmscXtext.g:3121:1: ruleXEventType returns [Enumerator current=null] : ( (enumLiteral_0= '>' ) | (enumLiteral_1= '<' ) ) ;
    public final Enumerator ruleXEventType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalTmscXtext.g:3127:2: ( ( (enumLiteral_0= '>' ) | (enumLiteral_1= '<' ) ) )
            // InternalTmscXtext.g:3128:2: ( (enumLiteral_0= '>' ) | (enumLiteral_1= '<' ) )
            {
            // InternalTmscXtext.g:3128:2: ( (enumLiteral_0= '>' ) | (enumLiteral_1= '<' ) )
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==56) ) {
                alt60=1;
            }
            else if ( (LA60_0==57) ) {
                alt60=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 60, 0, input);

                throw nvae;
            }
            switch (alt60) {
                case 1 :
                    // InternalTmscXtext.g:3129:3: (enumLiteral_0= '>' )
                    {
                    // InternalTmscXtext.g:3129:3: (enumLiteral_0= '>' )
                    // InternalTmscXtext.g:3130:4: enumLiteral_0= '>'
                    {
                    enumLiteral_0=(Token)match(input,56,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getXEventTypeAccess().getENTRYEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getXEventTypeAccess().getENTRYEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalTmscXtext.g:3137:3: (enumLiteral_1= '<' )
                    {
                    // InternalTmscXtext.g:3137:3: (enumLiteral_1= '<' )
                    // InternalTmscXtext.g:3138:4: enumLiteral_1= '<'
                    {
                    enumLiteral_1=(Token)match(input,57,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getXEventTypeAccess().getEXITEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getXEventTypeAccess().getEXITEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleXEventType"


    // $ANTLR start "ruleXDependencyType"
    // InternalTmscXtext.g:3148:1: ruleXDependencyType returns [Enumerator current=null] : ( (enumLiteral_0= 'message' ) | (enumLiteral_1= 'request' ) | (enumLiteral_2= 'reply' ) | (enumLiteral_3= 'domain-dependency' ) | (enumLiteral_4= 'lifeline-segment' ) | (enumLiteral_5= 'message-control' ) ) ;
    public final Enumerator ruleXDependencyType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;


        	enterRule();

        try {
            // InternalTmscXtext.g:3154:2: ( ( (enumLiteral_0= 'message' ) | (enumLiteral_1= 'request' ) | (enumLiteral_2= 'reply' ) | (enumLiteral_3= 'domain-dependency' ) | (enumLiteral_4= 'lifeline-segment' ) | (enumLiteral_5= 'message-control' ) ) )
            // InternalTmscXtext.g:3155:2: ( (enumLiteral_0= 'message' ) | (enumLiteral_1= 'request' ) | (enumLiteral_2= 'reply' ) | (enumLiteral_3= 'domain-dependency' ) | (enumLiteral_4= 'lifeline-segment' ) | (enumLiteral_5= 'message-control' ) )
            {
            // InternalTmscXtext.g:3155:2: ( (enumLiteral_0= 'message' ) | (enumLiteral_1= 'request' ) | (enumLiteral_2= 'reply' ) | (enumLiteral_3= 'domain-dependency' ) | (enumLiteral_4= 'lifeline-segment' ) | (enumLiteral_5= 'message-control' ) )
            int alt61=6;
            switch ( input.LA(1) ) {
            case 43:
                {
                alt61=1;
                }
                break;
            case 42:
                {
                alt61=2;
                }
                break;
            case 58:
                {
                alt61=3;
                }
                break;
            case 59:
                {
                alt61=4;
                }
                break;
            case 60:
                {
                alt61=5;
                }
                break;
            case 61:
                {
                alt61=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 61, 0, input);

                throw nvae;
            }

            switch (alt61) {
                case 1 :
                    // InternalTmscXtext.g:3156:3: (enumLiteral_0= 'message' )
                    {
                    // InternalTmscXtext.g:3156:3: (enumLiteral_0= 'message' )
                    // InternalTmscXtext.g:3157:4: enumLiteral_0= 'message'
                    {
                    enumLiteral_0=(Token)match(input,43,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getXDependencyTypeAccess().getMESSAGEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getXDependencyTypeAccess().getMESSAGEEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalTmscXtext.g:3164:3: (enumLiteral_1= 'request' )
                    {
                    // InternalTmscXtext.g:3164:3: (enumLiteral_1= 'request' )
                    // InternalTmscXtext.g:3165:4: enumLiteral_1= 'request'
                    {
                    enumLiteral_1=(Token)match(input,42,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getXDependencyTypeAccess().getREQUESTEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getXDependencyTypeAccess().getREQUESTEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalTmscXtext.g:3172:3: (enumLiteral_2= 'reply' )
                    {
                    // InternalTmscXtext.g:3172:3: (enumLiteral_2= 'reply' )
                    // InternalTmscXtext.g:3173:4: enumLiteral_2= 'reply'
                    {
                    enumLiteral_2=(Token)match(input,58,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getXDependencyTypeAccess().getREPLYEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getXDependencyTypeAccess().getREPLYEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalTmscXtext.g:3180:3: (enumLiteral_3= 'domain-dependency' )
                    {
                    // InternalTmscXtext.g:3180:3: (enumLiteral_3= 'domain-dependency' )
                    // InternalTmscXtext.g:3181:4: enumLiteral_3= 'domain-dependency'
                    {
                    enumLiteral_3=(Token)match(input,59,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getXDependencyTypeAccess().getDOMAINEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_3, grammarAccess.getXDependencyTypeAccess().getDOMAINEnumLiteralDeclaration_3());
                      			
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalTmscXtext.g:3188:3: (enumLiteral_4= 'lifeline-segment' )
                    {
                    // InternalTmscXtext.g:3188:3: (enumLiteral_4= 'lifeline-segment' )
                    // InternalTmscXtext.g:3189:4: enumLiteral_4= 'lifeline-segment'
                    {
                    enumLiteral_4=(Token)match(input,60,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getXDependencyTypeAccess().getLIFELINE_SEGMENTEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_4, grammarAccess.getXDependencyTypeAccess().getLIFELINE_SEGMENTEnumLiteralDeclaration_4());
                      			
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalTmscXtext.g:3196:3: (enumLiteral_5= 'message-control' )
                    {
                    // InternalTmscXtext.g:3196:3: (enumLiteral_5= 'message-control' )
                    // InternalTmscXtext.g:3197:4: enumLiteral_5= 'message-control'
                    {
                    enumLiteral_5=(Token)match(input,61,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getXDependencyTypeAccess().getMESSAGE_CONTROLEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_5, grammarAccess.getXDependencyTypeAccess().getMESSAGE_CONTROLEnumLiteralDeclaration_5());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleXDependencyType"

    // Delegated rules


    protected DFA3 dfa3 = new DFA3(this);
    static final String dfa_1s = "\15\uffff";
    static final String dfa_2s = "\1\1\14\uffff";
    static final String dfa_3s = "\1\4\1\uffff\1\16\4\uffff\1\46\5\uffff";
    static final String dfa_4s = "\1\75\1\uffff\1\25\4\uffff\1\47\5\uffff";
    static final String dfa_5s = "\1\uffff\1\12\1\uffff\1\3\1\4\1\5\1\6\1\uffff\1\7\1\10\1\11\1\1\1\2";
    static final String dfa_6s = "\15\uffff}>";
    static final String[] dfa_7s = {
            "\5\12\4\uffff\1\2\12\uffff\1\4\2\uffff\1\5\3\uffff\3\6\3\uffff\1\7\1\10\1\11\2\uffff\2\3\16\uffff\4\3",
            "",
            "\1\13\6\uffff\1\14",
            "",
            "",
            "",
            "",
            "\1\10\1\11",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA3 extends DFA {

        public DFA3(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 3;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "()* loopback of 87:3: ( (otherlv_1= 'tmsc' otherlv_2= 'settings' otherlv_3= '{' ( (otherlv_4= 'architecture' otherlv_5= ':' ( (lv_architectureKind_6_0= ruleXArchitectureKind ) ) ) | (otherlv_7= 'time-bound' otherlv_8= ':' ( (lv_timeBound_9_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_10= 'scheduled' otherlv_11= ':' ( (lv_scheduled_12_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_13_0= ruleXProperty ) ) )* otherlv_14= '}' ) | (otherlv_15= 'tmsc' otherlv_16= 'analyses' otherlv_17= '{' ( (lv_analyses_18_0= ruleXTmscAnalysis ) )* otherlv_19= '}' ) | ( (lv_dependencySettings_20_0= ruleXDependencySettings ) ) | ( (lv_interfaces_21_0= ruleXInterface ) ) | ( (lv_components_22_0= ruleXComponent ) ) | ( (lv_functions_23_0= ruleXFunction ) ) | ( (lv_hosts_24_0= ruleXHost ) ) | ( (lv_executors_25_0= ruleXExecutor ) ) | ( (lv_events_26_0= ruleXEvent ) ) )*";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x00000000001D0120L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x000C000000000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0003000000000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x3C000CE3890021F2L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000500000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000900000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x00000000000D0120L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x00000000041D0120L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000050008002L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000060008002L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000020008002L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000001400008002L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x00F0000000000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000820000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000001000008002L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x000000A0001D0120L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x3F000CE3890D21F0L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000030400008002L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000030000008002L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x3C000C00000D0120L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x00000C00000D0120L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x00001000001D0120L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x00032000000D03B0L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000400020000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000800000000002L});

}