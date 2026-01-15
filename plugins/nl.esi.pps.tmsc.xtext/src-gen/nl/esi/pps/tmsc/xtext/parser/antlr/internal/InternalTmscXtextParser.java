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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ABS_EBIGDECIMAL", "RULE_ID", "RULE_ISO8601", "RULE_POS_EBIGDECIMAL", "RULE_STRING", "RULE_NEG_EBIGDECIMAL", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "'tmsc'", "'settings'", "'{'", "'architecture'", "':'", "'time-bound'", "'scheduled'", "'}'", "'analyses'", "'time-bound-analysis'", "'defaultTimeBound'", "'time-shift'", "'delta'", "'interface'", "'as'", "'operation'", "'component'", "'provides'", "','", "'requires'", "'ipc-client'", "'ipc-server'", "'function'", "'('", "')'", "'implements'", "'untraced'", "'host'", "'executor'", "'!'", "'?'", "'request'", "'message'", "'prefix'", "'['", "']'", "'.'", "'true'", "'false'", "'internal'", "'external'", "'in'", "'out'", "'inout'", "'return'", "'>'", "'<'", "'reply'", "'domain-dependency'", "'lifeline-segment'", "'message-control'"
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
    public static final int T__62=62;
    public static final int T__63=63;
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

            	        if ( (LA2_0==22||LA2_0==24) ) {
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
    // InternalTmscXtext.g:406:1: ruleXTmscAnalysis returns [EObject current=null] : (this_XTimeBoundAnalysis_0= ruleXTimeBoundAnalysis | this_XTimeShift_1= ruleXTimeShift ) ;
    public final EObject ruleXTmscAnalysis() throws RecognitionException {
        EObject current = null;

        EObject this_XTimeBoundAnalysis_0 = null;

        EObject this_XTimeShift_1 = null;



        	enterRule();

        try {
            // InternalTmscXtext.g:412:2: ( (this_XTimeBoundAnalysis_0= ruleXTimeBoundAnalysis | this_XTimeShift_1= ruleXTimeShift ) )
            // InternalTmscXtext.g:413:2: (this_XTimeBoundAnalysis_0= ruleXTimeBoundAnalysis | this_XTimeShift_1= ruleXTimeShift )
            {
            // InternalTmscXtext.g:413:2: (this_XTimeBoundAnalysis_0= ruleXTimeBoundAnalysis | this_XTimeShift_1= ruleXTimeShift )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==22) ) {
                alt4=1;
            }
            else if ( (LA4_0==24) ) {
                alt4=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalTmscXtext.g:414:3: this_XTimeBoundAnalysis_0= ruleXTimeBoundAnalysis
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getXTmscAnalysisAccess().getXTimeBoundAnalysisParserRuleCall_0());
                      		
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
                    break;
                case 2 :
                    // InternalTmscXtext.g:423:3: this_XTimeShift_1= ruleXTimeShift
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getXTmscAnalysisAccess().getXTimeShiftParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XTimeShift_1=ruleXTimeShift();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XTimeShift_1;
                      			afterParserOrEnumRuleCall();
                      		
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
    // $ANTLR end "ruleXTmscAnalysis"


    // $ANTLR start "entryRuleXTimeBoundAnalysis"
    // InternalTmscXtext.g:435:1: entryRuleXTimeBoundAnalysis returns [EObject current=null] : iv_ruleXTimeBoundAnalysis= ruleXTimeBoundAnalysis EOF ;
    public final EObject entryRuleXTimeBoundAnalysis() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXTimeBoundAnalysis = null;


        try {
            // InternalTmscXtext.g:435:59: (iv_ruleXTimeBoundAnalysis= ruleXTimeBoundAnalysis EOF )
            // InternalTmscXtext.g:436:2: iv_ruleXTimeBoundAnalysis= ruleXTimeBoundAnalysis EOF
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
    // InternalTmscXtext.g:442:1: ruleXTimeBoundAnalysis returns [EObject current=null] : ( () otherlv_1= 'time-bound-analysis' (otherlv_2= '{' (otherlv_3= 'defaultTimeBound' otherlv_4= ':' ( (lv_defaultTimeBound_5_0= RULE_ABS_EBIGDECIMAL ) ) )? otherlv_6= '}' )? ) ;
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
            // InternalTmscXtext.g:448:2: ( ( () otherlv_1= 'time-bound-analysis' (otherlv_2= '{' (otherlv_3= 'defaultTimeBound' otherlv_4= ':' ( (lv_defaultTimeBound_5_0= RULE_ABS_EBIGDECIMAL ) ) )? otherlv_6= '}' )? ) )
            // InternalTmscXtext.g:449:2: ( () otherlv_1= 'time-bound-analysis' (otherlv_2= '{' (otherlv_3= 'defaultTimeBound' otherlv_4= ':' ( (lv_defaultTimeBound_5_0= RULE_ABS_EBIGDECIMAL ) ) )? otherlv_6= '}' )? )
            {
            // InternalTmscXtext.g:449:2: ( () otherlv_1= 'time-bound-analysis' (otherlv_2= '{' (otherlv_3= 'defaultTimeBound' otherlv_4= ':' ( (lv_defaultTimeBound_5_0= RULE_ABS_EBIGDECIMAL ) ) )? otherlv_6= '}' )? )
            // InternalTmscXtext.g:450:3: () otherlv_1= 'time-bound-analysis' (otherlv_2= '{' (otherlv_3= 'defaultTimeBound' otherlv_4= ':' ( (lv_defaultTimeBound_5_0= RULE_ABS_EBIGDECIMAL ) ) )? otherlv_6= '}' )?
            {
            // InternalTmscXtext.g:450:3: ()
            // InternalTmscXtext.g:451:4: 
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
            // InternalTmscXtext.g:461:3: (otherlv_2= '{' (otherlv_3= 'defaultTimeBound' otherlv_4= ':' ( (lv_defaultTimeBound_5_0= RULE_ABS_EBIGDECIMAL ) ) )? otherlv_6= '}' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==15) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalTmscXtext.g:462:4: otherlv_2= '{' (otherlv_3= 'defaultTimeBound' otherlv_4= ':' ( (lv_defaultTimeBound_5_0= RULE_ABS_EBIGDECIMAL ) ) )? otherlv_6= '}'
                    {
                    otherlv_2=(Token)match(input,15,FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getXTimeBoundAnalysisAccess().getLeftCurlyBracketKeyword_2_0());
                      			
                    }
                    // InternalTmscXtext.g:466:4: (otherlv_3= 'defaultTimeBound' otherlv_4= ':' ( (lv_defaultTimeBound_5_0= RULE_ABS_EBIGDECIMAL ) ) )?
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( (LA5_0==23) ) {
                        alt5=1;
                    }
                    switch (alt5) {
                        case 1 :
                            // InternalTmscXtext.g:467:5: otherlv_3= 'defaultTimeBound' otherlv_4= ':' ( (lv_defaultTimeBound_5_0= RULE_ABS_EBIGDECIMAL ) )
                            {
                            otherlv_3=(Token)match(input,23,FOLLOW_6); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_3, grammarAccess.getXTimeBoundAnalysisAccess().getDefaultTimeBoundKeyword_2_1_0());
                              				
                            }
                            otherlv_4=(Token)match(input,17,FOLLOW_8); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_4, grammarAccess.getXTimeBoundAnalysisAccess().getColonKeyword_2_1_1());
                              				
                            }
                            // InternalTmscXtext.g:475:5: ( (lv_defaultTimeBound_5_0= RULE_ABS_EBIGDECIMAL ) )
                            // InternalTmscXtext.g:476:6: (lv_defaultTimeBound_5_0= RULE_ABS_EBIGDECIMAL )
                            {
                            // InternalTmscXtext.g:476:6: (lv_defaultTimeBound_5_0= RULE_ABS_EBIGDECIMAL )
                            // InternalTmscXtext.g:477:7: lv_defaultTimeBound_5_0= RULE_ABS_EBIGDECIMAL
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


    // $ANTLR start "entryRuleXTimeShift"
    // InternalTmscXtext.g:503:1: entryRuleXTimeShift returns [EObject current=null] : iv_ruleXTimeShift= ruleXTimeShift EOF ;
    public final EObject entryRuleXTimeShift() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXTimeShift = null;


        try {
            // InternalTmscXtext.g:503:51: (iv_ruleXTimeShift= ruleXTimeShift EOF )
            // InternalTmscXtext.g:504:2: iv_ruleXTimeShift= ruleXTimeShift EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXTimeShiftRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXTimeShift=ruleXTimeShift();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXTimeShift; 
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
    // $ANTLR end "entryRuleXTimeShift"


    // $ANTLR start "ruleXTimeShift"
    // InternalTmscXtext.g:510:1: ruleXTimeShift returns [EObject current=null] : ( () otherlv_1= 'time-shift' (otherlv_2= '{' (otherlv_3= 'delta' otherlv_4= ':' ( (lv_delta_5_0= ruleEBIGDECIMAL ) ) )? otherlv_6= '}' )? ) ;
    public final EObject ruleXTimeShift() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_delta_5_0 = null;



        	enterRule();

        try {
            // InternalTmscXtext.g:516:2: ( ( () otherlv_1= 'time-shift' (otherlv_2= '{' (otherlv_3= 'delta' otherlv_4= ':' ( (lv_delta_5_0= ruleEBIGDECIMAL ) ) )? otherlv_6= '}' )? ) )
            // InternalTmscXtext.g:517:2: ( () otherlv_1= 'time-shift' (otherlv_2= '{' (otherlv_3= 'delta' otherlv_4= ':' ( (lv_delta_5_0= ruleEBIGDECIMAL ) ) )? otherlv_6= '}' )? )
            {
            // InternalTmscXtext.g:517:2: ( () otherlv_1= 'time-shift' (otherlv_2= '{' (otherlv_3= 'delta' otherlv_4= ':' ( (lv_delta_5_0= ruleEBIGDECIMAL ) ) )? otherlv_6= '}' )? )
            // InternalTmscXtext.g:518:3: () otherlv_1= 'time-shift' (otherlv_2= '{' (otherlv_3= 'delta' otherlv_4= ':' ( (lv_delta_5_0= ruleEBIGDECIMAL ) ) )? otherlv_6= '}' )?
            {
            // InternalTmscXtext.g:518:3: ()
            // InternalTmscXtext.g:519:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getXTimeShiftAccess().getXTimeShiftAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,24,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getXTimeShiftAccess().getTimeShiftKeyword_1());
              		
            }
            // InternalTmscXtext.g:529:3: (otherlv_2= '{' (otherlv_3= 'delta' otherlv_4= ':' ( (lv_delta_5_0= ruleEBIGDECIMAL ) ) )? otherlv_6= '}' )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==15) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalTmscXtext.g:530:4: otherlv_2= '{' (otherlv_3= 'delta' otherlv_4= ':' ( (lv_delta_5_0= ruleEBIGDECIMAL ) ) )? otherlv_6= '}'
                    {
                    otherlv_2=(Token)match(input,15,FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getXTimeShiftAccess().getLeftCurlyBracketKeyword_2_0());
                      			
                    }
                    // InternalTmscXtext.g:534:4: (otherlv_3= 'delta' otherlv_4= ':' ( (lv_delta_5_0= ruleEBIGDECIMAL ) ) )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==25) ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // InternalTmscXtext.g:535:5: otherlv_3= 'delta' otherlv_4= ':' ( (lv_delta_5_0= ruleEBIGDECIMAL ) )
                            {
                            otherlv_3=(Token)match(input,25,FOLLOW_6); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_3, grammarAccess.getXTimeShiftAccess().getDeltaKeyword_2_1_0());
                              				
                            }
                            otherlv_4=(Token)match(input,17,FOLLOW_17); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_4, grammarAccess.getXTimeShiftAccess().getColonKeyword_2_1_1());
                              				
                            }
                            // InternalTmscXtext.g:543:5: ( (lv_delta_5_0= ruleEBIGDECIMAL ) )
                            // InternalTmscXtext.g:544:6: (lv_delta_5_0= ruleEBIGDECIMAL )
                            {
                            // InternalTmscXtext.g:544:6: (lv_delta_5_0= ruleEBIGDECIMAL )
                            // InternalTmscXtext.g:545:7: lv_delta_5_0= ruleEBIGDECIMAL
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getXTimeShiftAccess().getDeltaEBIGDECIMALParserRuleCall_2_1_2_0());
                              						
                            }
                            pushFollow(FOLLOW_15);
                            lv_delta_5_0=ruleEBIGDECIMAL();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getXTimeShiftRule());
                              							}
                              							set(
                              								current,
                              								"delta",
                              								lv_delta_5_0,
                              								"nl.esi.pps.tmsc.xtext.TmscXtext.EBIGDECIMAL");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }


                            }


                            }
                            break;

                    }

                    otherlv_6=(Token)match(input,20,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_6, grammarAccess.getXTimeShiftAccess().getRightCurlyBracketKeyword_2_2());
                      			
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
    // $ANTLR end "ruleXTimeShift"


    // $ANTLR start "entryRuleXInterface"
    // InternalTmscXtext.g:572:1: entryRuleXInterface returns [EObject current=null] : iv_ruleXInterface= ruleXInterface EOF ;
    public final EObject entryRuleXInterface() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXInterface = null;


        try {
            // InternalTmscXtext.g:572:51: (iv_ruleXInterface= ruleXInterface EOF )
            // InternalTmscXtext.g:573:2: iv_ruleXInterface= ruleXInterface EOF
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
    // InternalTmscXtext.g:579:1: ruleXInterface returns [EObject current=null] : (otherlv_0= 'interface' ( ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as' )? ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '{' ( ( (lv_properties_5_0= ruleXProperty ) ) | ( (lv_operations_6_0= ruleXOperation ) ) )* otherlv_7= '}' )? ) ;
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
            // InternalTmscXtext.g:585:2: ( (otherlv_0= 'interface' ( ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as' )? ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '{' ( ( (lv_properties_5_0= ruleXProperty ) ) | ( (lv_operations_6_0= ruleXOperation ) ) )* otherlv_7= '}' )? ) )
            // InternalTmscXtext.g:586:2: (otherlv_0= 'interface' ( ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as' )? ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '{' ( ( (lv_properties_5_0= ruleXProperty ) ) | ( (lv_operations_6_0= ruleXOperation ) ) )* otherlv_7= '}' )? )
            {
            // InternalTmscXtext.g:586:2: (otherlv_0= 'interface' ( ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as' )? ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '{' ( ( (lv_properties_5_0= ruleXProperty ) ) | ( (lv_operations_6_0= ruleXOperation ) ) )* otherlv_7= '}' )? )
            // InternalTmscXtext.g:587:3: otherlv_0= 'interface' ( ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as' )? ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '{' ( ( (lv_properties_5_0= ruleXProperty ) ) | ( (lv_operations_6_0= ruleXOperation ) ) )* otherlv_7= '}' )?
            {
            otherlv_0=(Token)match(input,26,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getXInterfaceAccess().getInterfaceKeyword_0());
              		
            }
            // InternalTmscXtext.g:591:3: ( ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_ID) ) {
                int LA9_1 = input.LA(2);

                if ( (LA9_1==27) ) {
                    alt9=1;
                }
            }
            else if ( (LA9_0==RULE_STRING) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalTmscXtext.g:592:4: ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as'
                    {
                    // InternalTmscXtext.g:592:4: ( (lv_description_1_0= ruleIDString ) )
                    // InternalTmscXtext.g:593:5: (lv_description_1_0= ruleIDString )
                    {
                    // InternalTmscXtext.g:593:5: (lv_description_1_0= ruleIDString )
                    // InternalTmscXtext.g:594:6: lv_description_1_0= ruleIDString
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getXInterfaceAccess().getDescriptionIDStringParserRuleCall_1_0_0());
                      					
                    }
                    pushFollow(FOLLOW_19);
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

                    otherlv_2=(Token)match(input,27,FOLLOW_20); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getXInterfaceAccess().getAsKeyword_1_1());
                      			
                    }

                    }
                    break;

            }

            // InternalTmscXtext.g:616:3: ( (lv_name_3_0= RULE_ID ) )
            // InternalTmscXtext.g:617:4: (lv_name_3_0= RULE_ID )
            {
            // InternalTmscXtext.g:617:4: (lv_name_3_0= RULE_ID )
            // InternalTmscXtext.g:618:5: lv_name_3_0= RULE_ID
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

            // InternalTmscXtext.g:634:3: (otherlv_4= '{' ( ( (lv_properties_5_0= ruleXProperty ) ) | ( (lv_operations_6_0= ruleXOperation ) ) )* otherlv_7= '}' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==15) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalTmscXtext.g:635:4: otherlv_4= '{' ( ( (lv_properties_5_0= ruleXProperty ) ) | ( (lv_operations_6_0= ruleXOperation ) ) )* otherlv_7= '}'
                    {
                    otherlv_4=(Token)match(input,15,FOLLOW_21); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getXInterfaceAccess().getLeftCurlyBracketKeyword_3_0());
                      			
                    }
                    // InternalTmscXtext.g:639:4: ( ( (lv_properties_5_0= ruleXProperty ) ) | ( (lv_operations_6_0= ruleXOperation ) ) )*
                    loop10:
                    do {
                        int alt10=3;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==RULE_ID||LA10_0==RULE_STRING) ) {
                            alt10=1;
                        }
                        else if ( (LA10_0==28) ) {
                            alt10=2;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // InternalTmscXtext.g:640:5: ( (lv_properties_5_0= ruleXProperty ) )
                    	    {
                    	    // InternalTmscXtext.g:640:5: ( (lv_properties_5_0= ruleXProperty ) )
                    	    // InternalTmscXtext.g:641:6: (lv_properties_5_0= ruleXProperty )
                    	    {
                    	    // InternalTmscXtext.g:641:6: (lv_properties_5_0= ruleXProperty )
                    	    // InternalTmscXtext.g:642:7: lv_properties_5_0= ruleXProperty
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getXInterfaceAccess().getPropertiesXPropertyParserRuleCall_3_1_0_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_21);
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
                    	    // InternalTmscXtext.g:660:5: ( (lv_operations_6_0= ruleXOperation ) )
                    	    {
                    	    // InternalTmscXtext.g:660:5: ( (lv_operations_6_0= ruleXOperation ) )
                    	    // InternalTmscXtext.g:661:6: (lv_operations_6_0= ruleXOperation )
                    	    {
                    	    // InternalTmscXtext.g:661:6: (lv_operations_6_0= ruleXOperation )
                    	    // InternalTmscXtext.g:662:7: lv_operations_6_0= ruleXOperation
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getXInterfaceAccess().getOperationsXOperationParserRuleCall_3_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_21);
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
                    	    break loop10;
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
    // InternalTmscXtext.g:689:1: entryRuleXOperation returns [EObject current=null] : iv_ruleXOperation= ruleXOperation EOF ;
    public final EObject entryRuleXOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXOperation = null;


        try {
            // InternalTmscXtext.g:689:51: (iv_ruleXOperation= ruleXOperation EOF )
            // InternalTmscXtext.g:690:2: iv_ruleXOperation= ruleXOperation EOF
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
    // InternalTmscXtext.g:696:1: ruleXOperation returns [EObject current=null] : (otherlv_0= 'operation' ( ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as' )? ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '{' ( (lv_properties_5_0= ruleXProperty ) )* otherlv_6= '}' )? ) ;
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
            // InternalTmscXtext.g:702:2: ( (otherlv_0= 'operation' ( ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as' )? ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '{' ( (lv_properties_5_0= ruleXProperty ) )* otherlv_6= '}' )? ) )
            // InternalTmscXtext.g:703:2: (otherlv_0= 'operation' ( ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as' )? ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '{' ( (lv_properties_5_0= ruleXProperty ) )* otherlv_6= '}' )? )
            {
            // InternalTmscXtext.g:703:2: (otherlv_0= 'operation' ( ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as' )? ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '{' ( (lv_properties_5_0= ruleXProperty ) )* otherlv_6= '}' )? )
            // InternalTmscXtext.g:704:3: otherlv_0= 'operation' ( ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as' )? ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '{' ( (lv_properties_5_0= ruleXProperty ) )* otherlv_6= '}' )?
            {
            otherlv_0=(Token)match(input,28,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getXOperationAccess().getOperationKeyword_0());
              		
            }
            // InternalTmscXtext.g:708:3: ( ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as' )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_ID) ) {
                int LA12_1 = input.LA(2);

                if ( (LA12_1==27) ) {
                    alt12=1;
                }
            }
            else if ( (LA12_0==RULE_STRING) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalTmscXtext.g:709:4: ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as'
                    {
                    // InternalTmscXtext.g:709:4: ( (lv_description_1_0= ruleIDString ) )
                    // InternalTmscXtext.g:710:5: (lv_description_1_0= ruleIDString )
                    {
                    // InternalTmscXtext.g:710:5: (lv_description_1_0= ruleIDString )
                    // InternalTmscXtext.g:711:6: lv_description_1_0= ruleIDString
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getXOperationAccess().getDescriptionIDStringParserRuleCall_1_0_0());
                      					
                    }
                    pushFollow(FOLLOW_19);
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

                    otherlv_2=(Token)match(input,27,FOLLOW_20); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getXOperationAccess().getAsKeyword_1_1());
                      			
                    }

                    }
                    break;

            }

            // InternalTmscXtext.g:733:3: ( (lv_name_3_0= RULE_ID ) )
            // InternalTmscXtext.g:734:4: (lv_name_3_0= RULE_ID )
            {
            // InternalTmscXtext.g:734:4: (lv_name_3_0= RULE_ID )
            // InternalTmscXtext.g:735:5: lv_name_3_0= RULE_ID
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

            // InternalTmscXtext.g:751:3: (otherlv_4= '{' ( (lv_properties_5_0= ruleXProperty ) )* otherlv_6= '}' )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==15) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalTmscXtext.g:752:4: otherlv_4= '{' ( (lv_properties_5_0= ruleXProperty ) )* otherlv_6= '}'
                    {
                    otherlv_4=(Token)match(input,15,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getXOperationAccess().getLeftCurlyBracketKeyword_3_0());
                      			
                    }
                    // InternalTmscXtext.g:756:4: ( (lv_properties_5_0= ruleXProperty ) )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==RULE_ID||LA13_0==RULE_STRING) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // InternalTmscXtext.g:757:5: (lv_properties_5_0= ruleXProperty )
                    	    {
                    	    // InternalTmscXtext.g:757:5: (lv_properties_5_0= ruleXProperty )
                    	    // InternalTmscXtext.g:758:6: lv_properties_5_0= ruleXProperty
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
                    	    break loop13;
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
    // InternalTmscXtext.g:784:1: entryRuleXComponent returns [EObject current=null] : iv_ruleXComponent= ruleXComponent EOF ;
    public final EObject entryRuleXComponent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXComponent = null;


        try {
            // InternalTmscXtext.g:784:51: (iv_ruleXComponent= ruleXComponent EOF )
            // InternalTmscXtext.g:785:2: iv_ruleXComponent= ruleXComponent EOF
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
    // InternalTmscXtext.g:791:1: ruleXComponent returns [EObject current=null] : (otherlv_0= 'component' ( ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as' )? ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= 'provides' ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )? (otherlv_8= 'requires' ( (otherlv_9= RULE_ID ) ) (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )* )? (otherlv_12= '{' ( (otherlv_13= 'time-bound' otherlv_14= ':' ( (lv_timeBound_15_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_16= 'scheduled' otherlv_17= ':' ( (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_19_0= ruleXProperty ) ) )* otherlv_20= '}' )? ) ;
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
            // InternalTmscXtext.g:797:2: ( (otherlv_0= 'component' ( ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as' )? ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= 'provides' ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )? (otherlv_8= 'requires' ( (otherlv_9= RULE_ID ) ) (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )* )? (otherlv_12= '{' ( (otherlv_13= 'time-bound' otherlv_14= ':' ( (lv_timeBound_15_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_16= 'scheduled' otherlv_17= ':' ( (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_19_0= ruleXProperty ) ) )* otherlv_20= '}' )? ) )
            // InternalTmscXtext.g:798:2: (otherlv_0= 'component' ( ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as' )? ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= 'provides' ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )? (otherlv_8= 'requires' ( (otherlv_9= RULE_ID ) ) (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )* )? (otherlv_12= '{' ( (otherlv_13= 'time-bound' otherlv_14= ':' ( (lv_timeBound_15_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_16= 'scheduled' otherlv_17= ':' ( (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_19_0= ruleXProperty ) ) )* otherlv_20= '}' )? )
            {
            // InternalTmscXtext.g:798:2: (otherlv_0= 'component' ( ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as' )? ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= 'provides' ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )? (otherlv_8= 'requires' ( (otherlv_9= RULE_ID ) ) (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )* )? (otherlv_12= '{' ( (otherlv_13= 'time-bound' otherlv_14= ':' ( (lv_timeBound_15_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_16= 'scheduled' otherlv_17= ':' ( (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_19_0= ruleXProperty ) ) )* otherlv_20= '}' )? )
            // InternalTmscXtext.g:799:3: otherlv_0= 'component' ( ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as' )? ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= 'provides' ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )? (otherlv_8= 'requires' ( (otherlv_9= RULE_ID ) ) (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )* )? (otherlv_12= '{' ( (otherlv_13= 'time-bound' otherlv_14= ':' ( (lv_timeBound_15_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_16= 'scheduled' otherlv_17= ':' ( (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_19_0= ruleXProperty ) ) )* otherlv_20= '}' )?
            {
            otherlv_0=(Token)match(input,29,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getXComponentAccess().getComponentKeyword_0());
              		
            }
            // InternalTmscXtext.g:803:3: ( ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==RULE_ID) ) {
                int LA15_1 = input.LA(2);

                if ( (LA15_1==27) ) {
                    alt15=1;
                }
            }
            else if ( (LA15_0==RULE_STRING) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalTmscXtext.g:804:4: ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as'
                    {
                    // InternalTmscXtext.g:804:4: ( (lv_description_1_0= ruleIDString ) )
                    // InternalTmscXtext.g:805:5: (lv_description_1_0= ruleIDString )
                    {
                    // InternalTmscXtext.g:805:5: (lv_description_1_0= ruleIDString )
                    // InternalTmscXtext.g:806:6: lv_description_1_0= ruleIDString
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getXComponentAccess().getDescriptionIDStringParserRuleCall_1_0_0());
                      					
                    }
                    pushFollow(FOLLOW_19);
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

                    otherlv_2=(Token)match(input,27,FOLLOW_20); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getXComponentAccess().getAsKeyword_1_1());
                      			
                    }

                    }
                    break;

            }

            // InternalTmscXtext.g:828:3: ( (lv_name_3_0= RULE_ID ) )
            // InternalTmscXtext.g:829:4: (lv_name_3_0= RULE_ID )
            {
            // InternalTmscXtext.g:829:4: (lv_name_3_0= RULE_ID )
            // InternalTmscXtext.g:830:5: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_22); if (state.failed) return current;
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

            // InternalTmscXtext.g:846:3: (otherlv_4= 'provides' ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==30) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalTmscXtext.g:847:4: otherlv_4= 'provides' ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )*
                    {
                    otherlv_4=(Token)match(input,30,FOLLOW_20); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getXComponentAccess().getProvidesKeyword_3_0());
                      			
                    }
                    // InternalTmscXtext.g:851:4: ( (otherlv_5= RULE_ID ) )
                    // InternalTmscXtext.g:852:5: (otherlv_5= RULE_ID )
                    {
                    // InternalTmscXtext.g:852:5: (otherlv_5= RULE_ID )
                    // InternalTmscXtext.g:853:6: otherlv_5= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getXComponentRule());
                      						}
                      					
                    }
                    otherlv_5=(Token)match(input,RULE_ID,FOLLOW_23); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_5, grammarAccess.getXComponentAccess().getProvidesXInterfaceCrossReference_3_1_0());
                      					
                    }

                    }


                    }

                    // InternalTmscXtext.g:864:4: (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==31) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // InternalTmscXtext.g:865:5: otherlv_6= ',' ( (otherlv_7= RULE_ID ) )
                    	    {
                    	    otherlv_6=(Token)match(input,31,FOLLOW_20); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_6, grammarAccess.getXComponentAccess().getCommaKeyword_3_2_0());
                    	      				
                    	    }
                    	    // InternalTmscXtext.g:869:5: ( (otherlv_7= RULE_ID ) )
                    	    // InternalTmscXtext.g:870:6: (otherlv_7= RULE_ID )
                    	    {
                    	    // InternalTmscXtext.g:870:6: (otherlv_7= RULE_ID )
                    	    // InternalTmscXtext.g:871:7: otherlv_7= RULE_ID
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElement(grammarAccess.getXComponentRule());
                    	      							}
                    	      						
                    	    }
                    	    otherlv_7=(Token)match(input,RULE_ID,FOLLOW_23); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							newLeafNode(otherlv_7, grammarAccess.getXComponentAccess().getProvidesXInterfaceCrossReference_3_2_1_0());
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop16;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalTmscXtext.g:884:3: (otherlv_8= 'requires' ( (otherlv_9= RULE_ID ) ) (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )* )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==32) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalTmscXtext.g:885:4: otherlv_8= 'requires' ( (otherlv_9= RULE_ID ) ) (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )*
                    {
                    otherlv_8=(Token)match(input,32,FOLLOW_20); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_8, grammarAccess.getXComponentAccess().getRequiresKeyword_4_0());
                      			
                    }
                    // InternalTmscXtext.g:889:4: ( (otherlv_9= RULE_ID ) )
                    // InternalTmscXtext.g:890:5: (otherlv_9= RULE_ID )
                    {
                    // InternalTmscXtext.g:890:5: (otherlv_9= RULE_ID )
                    // InternalTmscXtext.g:891:6: otherlv_9= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getXComponentRule());
                      						}
                      					
                    }
                    otherlv_9=(Token)match(input,RULE_ID,FOLLOW_24); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_9, grammarAccess.getXComponentAccess().getRequiresXInterfaceCrossReference_4_1_0());
                      					
                    }

                    }


                    }

                    // InternalTmscXtext.g:902:4: (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )*
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0==31) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // InternalTmscXtext.g:903:5: otherlv_10= ',' ( (otherlv_11= RULE_ID ) )
                    	    {
                    	    otherlv_10=(Token)match(input,31,FOLLOW_20); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_10, grammarAccess.getXComponentAccess().getCommaKeyword_4_2_0());
                    	      				
                    	    }
                    	    // InternalTmscXtext.g:907:5: ( (otherlv_11= RULE_ID ) )
                    	    // InternalTmscXtext.g:908:6: (otherlv_11= RULE_ID )
                    	    {
                    	    // InternalTmscXtext.g:908:6: (otherlv_11= RULE_ID )
                    	    // InternalTmscXtext.g:909:7: otherlv_11= RULE_ID
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElement(grammarAccess.getXComponentRule());
                    	      							}
                    	      						
                    	    }
                    	    otherlv_11=(Token)match(input,RULE_ID,FOLLOW_24); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							newLeafNode(otherlv_11, grammarAccess.getXComponentAccess().getRequiresXInterfaceCrossReference_4_2_1_0());
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop18;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalTmscXtext.g:922:3: (otherlv_12= '{' ( (otherlv_13= 'time-bound' otherlv_14= ':' ( (lv_timeBound_15_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_16= 'scheduled' otherlv_17= ':' ( (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_19_0= ruleXProperty ) ) )* otherlv_20= '}' )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==15) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalTmscXtext.g:923:4: otherlv_12= '{' ( (otherlv_13= 'time-bound' otherlv_14= ':' ( (lv_timeBound_15_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_16= 'scheduled' otherlv_17= ':' ( (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_19_0= ruleXProperty ) ) )* otherlv_20= '}'
                    {
                    otherlv_12=(Token)match(input,15,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_12, grammarAccess.getXComponentAccess().getLeftCurlyBracketKeyword_5_0());
                      			
                    }
                    // InternalTmscXtext.g:927:4: ( (otherlv_13= 'time-bound' otherlv_14= ':' ( (lv_timeBound_15_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_16= 'scheduled' otherlv_17= ':' ( (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_19_0= ruleXProperty ) ) )*
                    loop20:
                    do {
                        int alt20=4;
                        switch ( input.LA(1) ) {
                        case 18:
                            {
                            alt20=1;
                            }
                            break;
                        case 19:
                            {
                            alt20=2;
                            }
                            break;
                        case RULE_ID:
                        case RULE_STRING:
                            {
                            alt20=3;
                            }
                            break;

                        }

                        switch (alt20) {
                    	case 1 :
                    	    // InternalTmscXtext.g:928:5: (otherlv_13= 'time-bound' otherlv_14= ':' ( (lv_timeBound_15_0= RULE_ABS_EBIGDECIMAL ) ) )
                    	    {
                    	    // InternalTmscXtext.g:928:5: (otherlv_13= 'time-bound' otherlv_14= ':' ( (lv_timeBound_15_0= RULE_ABS_EBIGDECIMAL ) ) )
                    	    // InternalTmscXtext.g:929:6: otherlv_13= 'time-bound' otherlv_14= ':' ( (lv_timeBound_15_0= RULE_ABS_EBIGDECIMAL ) )
                    	    {
                    	    otherlv_13=(Token)match(input,18,FOLLOW_6); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_13, grammarAccess.getXComponentAccess().getTimeBoundKeyword_5_1_0_0());
                    	      					
                    	    }
                    	    otherlv_14=(Token)match(input,17,FOLLOW_8); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_14, grammarAccess.getXComponentAccess().getColonKeyword_5_1_0_1());
                    	      					
                    	    }
                    	    // InternalTmscXtext.g:937:6: ( (lv_timeBound_15_0= RULE_ABS_EBIGDECIMAL ) )
                    	    // InternalTmscXtext.g:938:7: (lv_timeBound_15_0= RULE_ABS_EBIGDECIMAL )
                    	    {
                    	    // InternalTmscXtext.g:938:7: (lv_timeBound_15_0= RULE_ABS_EBIGDECIMAL )
                    	    // InternalTmscXtext.g:939:8: lv_timeBound_15_0= RULE_ABS_EBIGDECIMAL
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
                    	    // InternalTmscXtext.g:957:5: (otherlv_16= 'scheduled' otherlv_17= ':' ( (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT ) ) )
                    	    {
                    	    // InternalTmscXtext.g:957:5: (otherlv_16= 'scheduled' otherlv_17= ':' ( (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT ) ) )
                    	    // InternalTmscXtext.g:958:6: otherlv_16= 'scheduled' otherlv_17= ':' ( (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT ) )
                    	    {
                    	    otherlv_16=(Token)match(input,19,FOLLOW_6); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_16, grammarAccess.getXComponentAccess().getScheduledKeyword_5_1_1_0());
                    	      					
                    	    }
                    	    otherlv_17=(Token)match(input,17,FOLLOW_9); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_17, grammarAccess.getXComponentAccess().getColonKeyword_5_1_1_1());
                    	      					
                    	    }
                    	    // InternalTmscXtext.g:966:6: ( (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT ) )
                    	    // InternalTmscXtext.g:967:7: (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT )
                    	    {
                    	    // InternalTmscXtext.g:967:7: (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT )
                    	    // InternalTmscXtext.g:968:8: lv_scheduled_18_0= ruleEBOOLEAN_OBJECT
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
                    	    // InternalTmscXtext.g:987:5: ( (lv_properties_19_0= ruleXProperty ) )
                    	    {
                    	    // InternalTmscXtext.g:987:5: ( (lv_properties_19_0= ruleXProperty ) )
                    	    // InternalTmscXtext.g:988:6: (lv_properties_19_0= ruleXProperty )
                    	    {
                    	    // InternalTmscXtext.g:988:6: (lv_properties_19_0= ruleXProperty )
                    	    // InternalTmscXtext.g:989:7: lv_properties_19_0= ruleXProperty
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
                    	    break loop20;
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
    // InternalTmscXtext.g:1016:1: entryRuleXFunction returns [EObject current=null] : iv_ruleXFunction= ruleXFunction EOF ;
    public final EObject entryRuleXFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXFunction = null;


        try {
            // InternalTmscXtext.g:1016:50: (iv_ruleXFunction= ruleXFunction EOF )
            // InternalTmscXtext.g:1017:2: iv_ruleXFunction= ruleXFunction EOF
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
    // InternalTmscXtext.g:1023:1: ruleXFunction returns [EObject current=null] : ( ( ( (lv_ipcClient_0_0= 'ipc-client' ) ) | ( (lv_ipcServer_1_0= 'ipc-server' ) ) )? otherlv_2= 'function' ( ( (lv_description_3_0= ruleIDString ) ) otherlv_4= 'as' )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '(' ( (lv_parameters_7_0= ruleXFunctionParameter ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleXFunctionParameter ) ) )* otherlv_10= ')' )? (otherlv_11= 'implements' ( ( ruleFQN ) ) )? (otherlv_13= '{' ( (otherlv_14= 'time-bound' otherlv_15= ':' ( (lv_timeBound_16_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_17= 'scheduled' otherlv_18= ':' ( (lv_scheduled_19_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_20_0= ruleXProperty ) ) )* otherlv_21= '}' )? ) ;
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
            // InternalTmscXtext.g:1029:2: ( ( ( ( (lv_ipcClient_0_0= 'ipc-client' ) ) | ( (lv_ipcServer_1_0= 'ipc-server' ) ) )? otherlv_2= 'function' ( ( (lv_description_3_0= ruleIDString ) ) otherlv_4= 'as' )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '(' ( (lv_parameters_7_0= ruleXFunctionParameter ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleXFunctionParameter ) ) )* otherlv_10= ')' )? (otherlv_11= 'implements' ( ( ruleFQN ) ) )? (otherlv_13= '{' ( (otherlv_14= 'time-bound' otherlv_15= ':' ( (lv_timeBound_16_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_17= 'scheduled' otherlv_18= ':' ( (lv_scheduled_19_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_20_0= ruleXProperty ) ) )* otherlv_21= '}' )? ) )
            // InternalTmscXtext.g:1030:2: ( ( ( (lv_ipcClient_0_0= 'ipc-client' ) ) | ( (lv_ipcServer_1_0= 'ipc-server' ) ) )? otherlv_2= 'function' ( ( (lv_description_3_0= ruleIDString ) ) otherlv_4= 'as' )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '(' ( (lv_parameters_7_0= ruleXFunctionParameter ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleXFunctionParameter ) ) )* otherlv_10= ')' )? (otherlv_11= 'implements' ( ( ruleFQN ) ) )? (otherlv_13= '{' ( (otherlv_14= 'time-bound' otherlv_15= ':' ( (lv_timeBound_16_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_17= 'scheduled' otherlv_18= ':' ( (lv_scheduled_19_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_20_0= ruleXProperty ) ) )* otherlv_21= '}' )? )
            {
            // InternalTmscXtext.g:1030:2: ( ( ( (lv_ipcClient_0_0= 'ipc-client' ) ) | ( (lv_ipcServer_1_0= 'ipc-server' ) ) )? otherlv_2= 'function' ( ( (lv_description_3_0= ruleIDString ) ) otherlv_4= 'as' )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '(' ( (lv_parameters_7_0= ruleXFunctionParameter ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleXFunctionParameter ) ) )* otherlv_10= ')' )? (otherlv_11= 'implements' ( ( ruleFQN ) ) )? (otherlv_13= '{' ( (otherlv_14= 'time-bound' otherlv_15= ':' ( (lv_timeBound_16_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_17= 'scheduled' otherlv_18= ':' ( (lv_scheduled_19_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_20_0= ruleXProperty ) ) )* otherlv_21= '}' )? )
            // InternalTmscXtext.g:1031:3: ( ( (lv_ipcClient_0_0= 'ipc-client' ) ) | ( (lv_ipcServer_1_0= 'ipc-server' ) ) )? otherlv_2= 'function' ( ( (lv_description_3_0= ruleIDString ) ) otherlv_4= 'as' )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '(' ( (lv_parameters_7_0= ruleXFunctionParameter ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleXFunctionParameter ) ) )* otherlv_10= ')' )? (otherlv_11= 'implements' ( ( ruleFQN ) ) )? (otherlv_13= '{' ( (otherlv_14= 'time-bound' otherlv_15= ':' ( (lv_timeBound_16_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_17= 'scheduled' otherlv_18= ':' ( (lv_scheduled_19_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_20_0= ruleXProperty ) ) )* otherlv_21= '}' )?
            {
            // InternalTmscXtext.g:1031:3: ( ( (lv_ipcClient_0_0= 'ipc-client' ) ) | ( (lv_ipcServer_1_0= 'ipc-server' ) ) )?
            int alt22=3;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==33) ) {
                alt22=1;
            }
            else if ( (LA22_0==34) ) {
                alt22=2;
            }
            switch (alt22) {
                case 1 :
                    // InternalTmscXtext.g:1032:4: ( (lv_ipcClient_0_0= 'ipc-client' ) )
                    {
                    // InternalTmscXtext.g:1032:4: ( (lv_ipcClient_0_0= 'ipc-client' ) )
                    // InternalTmscXtext.g:1033:5: (lv_ipcClient_0_0= 'ipc-client' )
                    {
                    // InternalTmscXtext.g:1033:5: (lv_ipcClient_0_0= 'ipc-client' )
                    // InternalTmscXtext.g:1034:6: lv_ipcClient_0_0= 'ipc-client'
                    {
                    lv_ipcClient_0_0=(Token)match(input,33,FOLLOW_25); if (state.failed) return current;
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
                    // InternalTmscXtext.g:1047:4: ( (lv_ipcServer_1_0= 'ipc-server' ) )
                    {
                    // InternalTmscXtext.g:1047:4: ( (lv_ipcServer_1_0= 'ipc-server' ) )
                    // InternalTmscXtext.g:1048:5: (lv_ipcServer_1_0= 'ipc-server' )
                    {
                    // InternalTmscXtext.g:1048:5: (lv_ipcServer_1_0= 'ipc-server' )
                    // InternalTmscXtext.g:1049:6: lv_ipcServer_1_0= 'ipc-server'
                    {
                    lv_ipcServer_1_0=(Token)match(input,34,FOLLOW_25); if (state.failed) return current;
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

            otherlv_2=(Token)match(input,35,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getXFunctionAccess().getFunctionKeyword_1());
              		
            }
            // InternalTmscXtext.g:1066:3: ( ( (lv_description_3_0= ruleIDString ) ) otherlv_4= 'as' )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==RULE_ID) ) {
                int LA23_1 = input.LA(2);

                if ( (LA23_1==27) ) {
                    alt23=1;
                }
            }
            else if ( (LA23_0==RULE_STRING) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalTmscXtext.g:1067:4: ( (lv_description_3_0= ruleIDString ) ) otherlv_4= 'as'
                    {
                    // InternalTmscXtext.g:1067:4: ( (lv_description_3_0= ruleIDString ) )
                    // InternalTmscXtext.g:1068:5: (lv_description_3_0= ruleIDString )
                    {
                    // InternalTmscXtext.g:1068:5: (lv_description_3_0= ruleIDString )
                    // InternalTmscXtext.g:1069:6: lv_description_3_0= ruleIDString
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getXFunctionAccess().getDescriptionIDStringParserRuleCall_2_0_0());
                      					
                    }
                    pushFollow(FOLLOW_19);
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

                    otherlv_4=(Token)match(input,27,FOLLOW_20); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getXFunctionAccess().getAsKeyword_2_1());
                      			
                    }

                    }
                    break;

            }

            // InternalTmscXtext.g:1091:3: ( (lv_name_5_0= RULE_ID ) )
            // InternalTmscXtext.g:1092:4: (lv_name_5_0= RULE_ID )
            {
            // InternalTmscXtext.g:1092:4: (lv_name_5_0= RULE_ID )
            // InternalTmscXtext.g:1093:5: lv_name_5_0= RULE_ID
            {
            lv_name_5_0=(Token)match(input,RULE_ID,FOLLOW_26); if (state.failed) return current;
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

            // InternalTmscXtext.g:1109:3: (otherlv_6= '(' ( (lv_parameters_7_0= ruleXFunctionParameter ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleXFunctionParameter ) ) )* otherlv_10= ')' )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==36) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalTmscXtext.g:1110:4: otherlv_6= '(' ( (lv_parameters_7_0= ruleXFunctionParameter ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleXFunctionParameter ) ) )* otherlv_10= ')'
                    {
                    otherlv_6=(Token)match(input,36,FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_6, grammarAccess.getXFunctionAccess().getLeftParenthesisKeyword_4_0());
                      			
                    }
                    // InternalTmscXtext.g:1114:4: ( (lv_parameters_7_0= ruleXFunctionParameter ) )
                    // InternalTmscXtext.g:1115:5: (lv_parameters_7_0= ruleXFunctionParameter )
                    {
                    // InternalTmscXtext.g:1115:5: (lv_parameters_7_0= ruleXFunctionParameter )
                    // InternalTmscXtext.g:1116:6: lv_parameters_7_0= ruleXFunctionParameter
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getXFunctionAccess().getParametersXFunctionParameterParserRuleCall_4_1_0());
                      					
                    }
                    pushFollow(FOLLOW_28);
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

                    // InternalTmscXtext.g:1133:4: (otherlv_8= ',' ( (lv_parameters_9_0= ruleXFunctionParameter ) ) )*
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==31) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // InternalTmscXtext.g:1134:5: otherlv_8= ',' ( (lv_parameters_9_0= ruleXFunctionParameter ) )
                    	    {
                    	    otherlv_8=(Token)match(input,31,FOLLOW_27); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_8, grammarAccess.getXFunctionAccess().getCommaKeyword_4_2_0());
                    	      				
                    	    }
                    	    // InternalTmscXtext.g:1138:5: ( (lv_parameters_9_0= ruleXFunctionParameter ) )
                    	    // InternalTmscXtext.g:1139:6: (lv_parameters_9_0= ruleXFunctionParameter )
                    	    {
                    	    // InternalTmscXtext.g:1139:6: (lv_parameters_9_0= ruleXFunctionParameter )
                    	    // InternalTmscXtext.g:1140:7: lv_parameters_9_0= ruleXFunctionParameter
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getXFunctionAccess().getParametersXFunctionParameterParserRuleCall_4_2_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_28);
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
                    	    break loop24;
                        }
                    } while (true);

                    otherlv_10=(Token)match(input,37,FOLLOW_29); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_10, grammarAccess.getXFunctionAccess().getRightParenthesisKeyword_4_3());
                      			
                    }

                    }
                    break;

            }

            // InternalTmscXtext.g:1163:3: (otherlv_11= 'implements' ( ( ruleFQN ) ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==38) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalTmscXtext.g:1164:4: otherlv_11= 'implements' ( ( ruleFQN ) )
                    {
                    otherlv_11=(Token)match(input,38,FOLLOW_20); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_11, grammarAccess.getXFunctionAccess().getImplementsKeyword_5_0());
                      			
                    }
                    // InternalTmscXtext.g:1168:4: ( ( ruleFQN ) )
                    // InternalTmscXtext.g:1169:5: ( ruleFQN )
                    {
                    // InternalTmscXtext.g:1169:5: ( ruleFQN )
                    // InternalTmscXtext.g:1170:6: ruleFQN
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

            // InternalTmscXtext.g:1185:3: (otherlv_13= '{' ( (otherlv_14= 'time-bound' otherlv_15= ':' ( (lv_timeBound_16_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_17= 'scheduled' otherlv_18= ':' ( (lv_scheduled_19_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_20_0= ruleXProperty ) ) )* otherlv_21= '}' )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==15) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalTmscXtext.g:1186:4: otherlv_13= '{' ( (otherlv_14= 'time-bound' otherlv_15= ':' ( (lv_timeBound_16_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_17= 'scheduled' otherlv_18= ':' ( (lv_scheduled_19_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_20_0= ruleXProperty ) ) )* otherlv_21= '}'
                    {
                    otherlv_13=(Token)match(input,15,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_13, grammarAccess.getXFunctionAccess().getLeftCurlyBracketKeyword_6_0());
                      			
                    }
                    // InternalTmscXtext.g:1190:4: ( (otherlv_14= 'time-bound' otherlv_15= ':' ( (lv_timeBound_16_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_17= 'scheduled' otherlv_18= ':' ( (lv_scheduled_19_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_20_0= ruleXProperty ) ) )*
                    loop27:
                    do {
                        int alt27=4;
                        switch ( input.LA(1) ) {
                        case 18:
                            {
                            alt27=1;
                            }
                            break;
                        case 19:
                            {
                            alt27=2;
                            }
                            break;
                        case RULE_ID:
                        case RULE_STRING:
                            {
                            alt27=3;
                            }
                            break;

                        }

                        switch (alt27) {
                    	case 1 :
                    	    // InternalTmscXtext.g:1191:5: (otherlv_14= 'time-bound' otherlv_15= ':' ( (lv_timeBound_16_0= RULE_ABS_EBIGDECIMAL ) ) )
                    	    {
                    	    // InternalTmscXtext.g:1191:5: (otherlv_14= 'time-bound' otherlv_15= ':' ( (lv_timeBound_16_0= RULE_ABS_EBIGDECIMAL ) ) )
                    	    // InternalTmscXtext.g:1192:6: otherlv_14= 'time-bound' otherlv_15= ':' ( (lv_timeBound_16_0= RULE_ABS_EBIGDECIMAL ) )
                    	    {
                    	    otherlv_14=(Token)match(input,18,FOLLOW_6); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_14, grammarAccess.getXFunctionAccess().getTimeBoundKeyword_6_1_0_0());
                    	      					
                    	    }
                    	    otherlv_15=(Token)match(input,17,FOLLOW_8); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_15, grammarAccess.getXFunctionAccess().getColonKeyword_6_1_0_1());
                    	      					
                    	    }
                    	    // InternalTmscXtext.g:1200:6: ( (lv_timeBound_16_0= RULE_ABS_EBIGDECIMAL ) )
                    	    // InternalTmscXtext.g:1201:7: (lv_timeBound_16_0= RULE_ABS_EBIGDECIMAL )
                    	    {
                    	    // InternalTmscXtext.g:1201:7: (lv_timeBound_16_0= RULE_ABS_EBIGDECIMAL )
                    	    // InternalTmscXtext.g:1202:8: lv_timeBound_16_0= RULE_ABS_EBIGDECIMAL
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
                    	    // InternalTmscXtext.g:1220:5: (otherlv_17= 'scheduled' otherlv_18= ':' ( (lv_scheduled_19_0= ruleEBOOLEAN_OBJECT ) ) )
                    	    {
                    	    // InternalTmscXtext.g:1220:5: (otherlv_17= 'scheduled' otherlv_18= ':' ( (lv_scheduled_19_0= ruleEBOOLEAN_OBJECT ) ) )
                    	    // InternalTmscXtext.g:1221:6: otherlv_17= 'scheduled' otherlv_18= ':' ( (lv_scheduled_19_0= ruleEBOOLEAN_OBJECT ) )
                    	    {
                    	    otherlv_17=(Token)match(input,19,FOLLOW_6); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_17, grammarAccess.getXFunctionAccess().getScheduledKeyword_6_1_1_0());
                    	      					
                    	    }
                    	    otherlv_18=(Token)match(input,17,FOLLOW_9); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_18, grammarAccess.getXFunctionAccess().getColonKeyword_6_1_1_1());
                    	      					
                    	    }
                    	    // InternalTmscXtext.g:1229:6: ( (lv_scheduled_19_0= ruleEBOOLEAN_OBJECT ) )
                    	    // InternalTmscXtext.g:1230:7: (lv_scheduled_19_0= ruleEBOOLEAN_OBJECT )
                    	    {
                    	    // InternalTmscXtext.g:1230:7: (lv_scheduled_19_0= ruleEBOOLEAN_OBJECT )
                    	    // InternalTmscXtext.g:1231:8: lv_scheduled_19_0= ruleEBOOLEAN_OBJECT
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
                    	    // InternalTmscXtext.g:1250:5: ( (lv_properties_20_0= ruleXProperty ) )
                    	    {
                    	    // InternalTmscXtext.g:1250:5: ( (lv_properties_20_0= ruleXProperty ) )
                    	    // InternalTmscXtext.g:1251:6: (lv_properties_20_0= ruleXProperty )
                    	    {
                    	    // InternalTmscXtext.g:1251:6: (lv_properties_20_0= ruleXProperty )
                    	    // InternalTmscXtext.g:1252:7: lv_properties_20_0= ruleXProperty
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
                    	    break loop27;
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
    // InternalTmscXtext.g:1279:1: entryRuleXFunctionParameter returns [EObject current=null] : iv_ruleXFunctionParameter= ruleXFunctionParameter EOF ;
    public final EObject entryRuleXFunctionParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXFunctionParameter = null;


        try {
            // InternalTmscXtext.g:1279:59: (iv_ruleXFunctionParameter= ruleXFunctionParameter EOF )
            // InternalTmscXtext.g:1280:2: iv_ruleXFunctionParameter= ruleXFunctionParameter EOF
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
    // InternalTmscXtext.g:1286:1: ruleXFunctionParameter returns [EObject current=null] : ( ( (lv_kind_0_0= ruleXFunctionParameterKind ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_properties_3_0= ruleXProperty ) ) (otherlv_4= ',' ( (lv_properties_5_0= ruleXProperty ) ) )* otherlv_6= ')' )? ) ;
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
            // InternalTmscXtext.g:1292:2: ( ( ( (lv_kind_0_0= ruleXFunctionParameterKind ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_properties_3_0= ruleXProperty ) ) (otherlv_4= ',' ( (lv_properties_5_0= ruleXProperty ) ) )* otherlv_6= ')' )? ) )
            // InternalTmscXtext.g:1293:2: ( ( (lv_kind_0_0= ruleXFunctionParameterKind ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_properties_3_0= ruleXProperty ) ) (otherlv_4= ',' ( (lv_properties_5_0= ruleXProperty ) ) )* otherlv_6= ')' )? )
            {
            // InternalTmscXtext.g:1293:2: ( ( (lv_kind_0_0= ruleXFunctionParameterKind ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_properties_3_0= ruleXProperty ) ) (otherlv_4= ',' ( (lv_properties_5_0= ruleXProperty ) ) )* otherlv_6= ')' )? )
            // InternalTmscXtext.g:1294:3: ( (lv_kind_0_0= ruleXFunctionParameterKind ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_properties_3_0= ruleXProperty ) ) (otherlv_4= ',' ( (lv_properties_5_0= ruleXProperty ) ) )* otherlv_6= ')' )?
            {
            // InternalTmscXtext.g:1294:3: ( (lv_kind_0_0= ruleXFunctionParameterKind ) )
            // InternalTmscXtext.g:1295:4: (lv_kind_0_0= ruleXFunctionParameterKind )
            {
            // InternalTmscXtext.g:1295:4: (lv_kind_0_0= ruleXFunctionParameterKind )
            // InternalTmscXtext.g:1296:5: lv_kind_0_0= ruleXFunctionParameterKind
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getXFunctionParameterAccess().getKindXFunctionParameterKindEnumRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_20);
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

            // InternalTmscXtext.g:1313:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalTmscXtext.g:1314:4: (lv_name_1_0= RULE_ID )
            {
            // InternalTmscXtext.g:1314:4: (lv_name_1_0= RULE_ID )
            // InternalTmscXtext.g:1315:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_30); if (state.failed) return current;
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

            // InternalTmscXtext.g:1331:3: (otherlv_2= '(' ( (lv_properties_3_0= ruleXProperty ) ) (otherlv_4= ',' ( (lv_properties_5_0= ruleXProperty ) ) )* otherlv_6= ')' )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==36) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalTmscXtext.g:1332:4: otherlv_2= '(' ( (lv_properties_3_0= ruleXProperty ) ) (otherlv_4= ',' ( (lv_properties_5_0= ruleXProperty ) ) )* otherlv_6= ')'
                    {
                    otherlv_2=(Token)match(input,36,FOLLOW_18); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getXFunctionParameterAccess().getLeftParenthesisKeyword_2_0());
                      			
                    }
                    // InternalTmscXtext.g:1336:4: ( (lv_properties_3_0= ruleXProperty ) )
                    // InternalTmscXtext.g:1337:5: (lv_properties_3_0= ruleXProperty )
                    {
                    // InternalTmscXtext.g:1337:5: (lv_properties_3_0= ruleXProperty )
                    // InternalTmscXtext.g:1338:6: lv_properties_3_0= ruleXProperty
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getXFunctionParameterAccess().getPropertiesXPropertyParserRuleCall_2_1_0());
                      					
                    }
                    pushFollow(FOLLOW_28);
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

                    // InternalTmscXtext.g:1355:4: (otherlv_4= ',' ( (lv_properties_5_0= ruleXProperty ) ) )*
                    loop29:
                    do {
                        int alt29=2;
                        int LA29_0 = input.LA(1);

                        if ( (LA29_0==31) ) {
                            alt29=1;
                        }


                        switch (alt29) {
                    	case 1 :
                    	    // InternalTmscXtext.g:1356:5: otherlv_4= ',' ( (lv_properties_5_0= ruleXProperty ) )
                    	    {
                    	    otherlv_4=(Token)match(input,31,FOLLOW_18); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_4, grammarAccess.getXFunctionParameterAccess().getCommaKeyword_2_2_0());
                    	      				
                    	    }
                    	    // InternalTmscXtext.g:1360:5: ( (lv_properties_5_0= ruleXProperty ) )
                    	    // InternalTmscXtext.g:1361:6: (lv_properties_5_0= ruleXProperty )
                    	    {
                    	    // InternalTmscXtext.g:1361:6: (lv_properties_5_0= ruleXProperty )
                    	    // InternalTmscXtext.g:1362:7: lv_properties_5_0= ruleXProperty
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getXFunctionParameterAccess().getPropertiesXPropertyParserRuleCall_2_2_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_28);
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
                    	    break loop29;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,37,FOLLOW_2); if (state.failed) return current;
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
    // InternalTmscXtext.g:1389:1: entryRuleXHost returns [EObject current=null] : iv_ruleXHost= ruleXHost EOF ;
    public final EObject entryRuleXHost() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXHost = null;


        try {
            // InternalTmscXtext.g:1389:46: (iv_ruleXHost= ruleXHost EOF )
            // InternalTmscXtext.g:1390:2: iv_ruleXHost= ruleXHost EOF
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
    // InternalTmscXtext.g:1396:1: ruleXHost returns [EObject current=null] : ( ( (lv_untraced_0_0= 'untraced' ) )? otherlv_1= 'host' ( ( (lv_description_2_0= ruleIDString ) ) otherlv_3= 'as' )? ( (lv_name_4_0= RULE_ID ) ) (otherlv_5= '{' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) | ( (lv_executors_13_0= ruleXExecutor ) ) )* otherlv_14= '}' )? ) ;
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
            // InternalTmscXtext.g:1402:2: ( ( ( (lv_untraced_0_0= 'untraced' ) )? otherlv_1= 'host' ( ( (lv_description_2_0= ruleIDString ) ) otherlv_3= 'as' )? ( (lv_name_4_0= RULE_ID ) ) (otherlv_5= '{' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) | ( (lv_executors_13_0= ruleXExecutor ) ) )* otherlv_14= '}' )? ) )
            // InternalTmscXtext.g:1403:2: ( ( (lv_untraced_0_0= 'untraced' ) )? otherlv_1= 'host' ( ( (lv_description_2_0= ruleIDString ) ) otherlv_3= 'as' )? ( (lv_name_4_0= RULE_ID ) ) (otherlv_5= '{' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) | ( (lv_executors_13_0= ruleXExecutor ) ) )* otherlv_14= '}' )? )
            {
            // InternalTmscXtext.g:1403:2: ( ( (lv_untraced_0_0= 'untraced' ) )? otherlv_1= 'host' ( ( (lv_description_2_0= ruleIDString ) ) otherlv_3= 'as' )? ( (lv_name_4_0= RULE_ID ) ) (otherlv_5= '{' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) | ( (lv_executors_13_0= ruleXExecutor ) ) )* otherlv_14= '}' )? )
            // InternalTmscXtext.g:1404:3: ( (lv_untraced_0_0= 'untraced' ) )? otherlv_1= 'host' ( ( (lv_description_2_0= ruleIDString ) ) otherlv_3= 'as' )? ( (lv_name_4_0= RULE_ID ) ) (otherlv_5= '{' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) | ( (lv_executors_13_0= ruleXExecutor ) ) )* otherlv_14= '}' )?
            {
            // InternalTmscXtext.g:1404:3: ( (lv_untraced_0_0= 'untraced' ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==39) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalTmscXtext.g:1405:4: (lv_untraced_0_0= 'untraced' )
                    {
                    // InternalTmscXtext.g:1405:4: (lv_untraced_0_0= 'untraced' )
                    // InternalTmscXtext.g:1406:5: lv_untraced_0_0= 'untraced'
                    {
                    lv_untraced_0_0=(Token)match(input,39,FOLLOW_31); if (state.failed) return current;
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

            otherlv_1=(Token)match(input,40,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getXHostAccess().getHostKeyword_1());
              		
            }
            // InternalTmscXtext.g:1422:3: ( ( (lv_description_2_0= ruleIDString ) ) otherlv_3= 'as' )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==RULE_ID) ) {
                int LA32_1 = input.LA(2);

                if ( (LA32_1==27) ) {
                    alt32=1;
                }
            }
            else if ( (LA32_0==RULE_STRING) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalTmscXtext.g:1423:4: ( (lv_description_2_0= ruleIDString ) ) otherlv_3= 'as'
                    {
                    // InternalTmscXtext.g:1423:4: ( (lv_description_2_0= ruleIDString ) )
                    // InternalTmscXtext.g:1424:5: (lv_description_2_0= ruleIDString )
                    {
                    // InternalTmscXtext.g:1424:5: (lv_description_2_0= ruleIDString )
                    // InternalTmscXtext.g:1425:6: lv_description_2_0= ruleIDString
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getXHostAccess().getDescriptionIDStringParserRuleCall_2_0_0());
                      					
                    }
                    pushFollow(FOLLOW_19);
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

                    otherlv_3=(Token)match(input,27,FOLLOW_20); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getXHostAccess().getAsKeyword_2_1());
                      			
                    }

                    }
                    break;

            }

            // InternalTmscXtext.g:1447:3: ( (lv_name_4_0= RULE_ID ) )
            // InternalTmscXtext.g:1448:4: (lv_name_4_0= RULE_ID )
            {
            // InternalTmscXtext.g:1448:4: (lv_name_4_0= RULE_ID )
            // InternalTmscXtext.g:1449:5: lv_name_4_0= RULE_ID
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

            // InternalTmscXtext.g:1465:3: (otherlv_5= '{' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) | ( (lv_executors_13_0= ruleXExecutor ) ) )* otherlv_14= '}' )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==15) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalTmscXtext.g:1466:4: otherlv_5= '{' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) | ( (lv_executors_13_0= ruleXExecutor ) ) )* otherlv_14= '}'
                    {
                    otherlv_5=(Token)match(input,15,FOLLOW_32); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getXHostAccess().getLeftCurlyBracketKeyword_4_0());
                      			
                    }
                    // InternalTmscXtext.g:1470:4: ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) | ( (lv_executors_13_0= ruleXExecutor ) ) )*
                    loop33:
                    do {
                        int alt33=5;
                        switch ( input.LA(1) ) {
                        case 18:
                            {
                            alt33=1;
                            }
                            break;
                        case 19:
                            {
                            alt33=2;
                            }
                            break;
                        case RULE_ID:
                        case RULE_STRING:
                            {
                            alt33=3;
                            }
                            break;
                        case 39:
                        case 41:
                            {
                            alt33=4;
                            }
                            break;

                        }

                        switch (alt33) {
                    	case 1 :
                    	    // InternalTmscXtext.g:1471:5: (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) )
                    	    {
                    	    // InternalTmscXtext.g:1471:5: (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) )
                    	    // InternalTmscXtext.g:1472:6: otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) )
                    	    {
                    	    otherlv_6=(Token)match(input,18,FOLLOW_6); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_6, grammarAccess.getXHostAccess().getTimeBoundKeyword_4_1_0_0());
                    	      					
                    	    }
                    	    otherlv_7=(Token)match(input,17,FOLLOW_8); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_7, grammarAccess.getXHostAccess().getColonKeyword_4_1_0_1());
                    	      					
                    	    }
                    	    // InternalTmscXtext.g:1480:6: ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) )
                    	    // InternalTmscXtext.g:1481:7: (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL )
                    	    {
                    	    // InternalTmscXtext.g:1481:7: (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL )
                    	    // InternalTmscXtext.g:1482:8: lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL
                    	    {
                    	    lv_timeBound_8_0=(Token)match(input,RULE_ABS_EBIGDECIMAL,FOLLOW_32); if (state.failed) return current;
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
                    	    // InternalTmscXtext.g:1500:5: (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) )
                    	    {
                    	    // InternalTmscXtext.g:1500:5: (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) )
                    	    // InternalTmscXtext.g:1501:6: otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) )
                    	    {
                    	    otherlv_9=(Token)match(input,19,FOLLOW_6); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_9, grammarAccess.getXHostAccess().getScheduledKeyword_4_1_1_0());
                    	      					
                    	    }
                    	    otherlv_10=(Token)match(input,17,FOLLOW_9); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_10, grammarAccess.getXHostAccess().getColonKeyword_4_1_1_1());
                    	      					
                    	    }
                    	    // InternalTmscXtext.g:1509:6: ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) )
                    	    // InternalTmscXtext.g:1510:7: (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT )
                    	    {
                    	    // InternalTmscXtext.g:1510:7: (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT )
                    	    // InternalTmscXtext.g:1511:8: lv_scheduled_11_0= ruleEBOOLEAN_OBJECT
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      								newCompositeNode(grammarAccess.getXHostAccess().getScheduledEBOOLEAN_OBJECTParserRuleCall_4_1_1_2_0());
                    	      							
                    	    }
                    	    pushFollow(FOLLOW_32);
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
                    	    // InternalTmscXtext.g:1530:5: ( (lv_properties_12_0= ruleXProperty ) )
                    	    {
                    	    // InternalTmscXtext.g:1530:5: ( (lv_properties_12_0= ruleXProperty ) )
                    	    // InternalTmscXtext.g:1531:6: (lv_properties_12_0= ruleXProperty )
                    	    {
                    	    // InternalTmscXtext.g:1531:6: (lv_properties_12_0= ruleXProperty )
                    	    // InternalTmscXtext.g:1532:7: lv_properties_12_0= ruleXProperty
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getXHostAccess().getPropertiesXPropertyParserRuleCall_4_1_2_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_32);
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
                    	    // InternalTmscXtext.g:1550:5: ( (lv_executors_13_0= ruleXExecutor ) )
                    	    {
                    	    // InternalTmscXtext.g:1550:5: ( (lv_executors_13_0= ruleXExecutor ) )
                    	    // InternalTmscXtext.g:1551:6: (lv_executors_13_0= ruleXExecutor )
                    	    {
                    	    // InternalTmscXtext.g:1551:6: (lv_executors_13_0= ruleXExecutor )
                    	    // InternalTmscXtext.g:1552:7: lv_executors_13_0= ruleXExecutor
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getXHostAccess().getExecutorsXExecutorParserRuleCall_4_1_3_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_32);
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
                    	    break loop33;
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
    // InternalTmscXtext.g:1579:1: entryRuleXExecutor returns [EObject current=null] : iv_ruleXExecutor= ruleXExecutor EOF ;
    public final EObject entryRuleXExecutor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXExecutor = null;


        try {
            // InternalTmscXtext.g:1579:50: (iv_ruleXExecutor= ruleXExecutor EOF )
            // InternalTmscXtext.g:1580:2: iv_ruleXExecutor= ruleXExecutor EOF
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
    // InternalTmscXtext.g:1586:1: ruleXExecutor returns [EObject current=null] : ( ( (lv_untraced_0_0= 'untraced' ) )? otherlv_1= 'executor' ( ( (lv_description_2_0= ruleIDString ) ) otherlv_3= 'as' )? ( (lv_name_4_0= RULE_ID ) ) (otherlv_5= '{' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) )* otherlv_13= '}' )? ) ;
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
            // InternalTmscXtext.g:1592:2: ( ( ( (lv_untraced_0_0= 'untraced' ) )? otherlv_1= 'executor' ( ( (lv_description_2_0= ruleIDString ) ) otherlv_3= 'as' )? ( (lv_name_4_0= RULE_ID ) ) (otherlv_5= '{' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) )* otherlv_13= '}' )? ) )
            // InternalTmscXtext.g:1593:2: ( ( (lv_untraced_0_0= 'untraced' ) )? otherlv_1= 'executor' ( ( (lv_description_2_0= ruleIDString ) ) otherlv_3= 'as' )? ( (lv_name_4_0= RULE_ID ) ) (otherlv_5= '{' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) )* otherlv_13= '}' )? )
            {
            // InternalTmscXtext.g:1593:2: ( ( (lv_untraced_0_0= 'untraced' ) )? otherlv_1= 'executor' ( ( (lv_description_2_0= ruleIDString ) ) otherlv_3= 'as' )? ( (lv_name_4_0= RULE_ID ) ) (otherlv_5= '{' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) )* otherlv_13= '}' )? )
            // InternalTmscXtext.g:1594:3: ( (lv_untraced_0_0= 'untraced' ) )? otherlv_1= 'executor' ( ( (lv_description_2_0= ruleIDString ) ) otherlv_3= 'as' )? ( (lv_name_4_0= RULE_ID ) ) (otherlv_5= '{' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) )* otherlv_13= '}' )?
            {
            // InternalTmscXtext.g:1594:3: ( (lv_untraced_0_0= 'untraced' ) )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==39) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalTmscXtext.g:1595:4: (lv_untraced_0_0= 'untraced' )
                    {
                    // InternalTmscXtext.g:1595:4: (lv_untraced_0_0= 'untraced' )
                    // InternalTmscXtext.g:1596:5: lv_untraced_0_0= 'untraced'
                    {
                    lv_untraced_0_0=(Token)match(input,39,FOLLOW_33); if (state.failed) return current;
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

            otherlv_1=(Token)match(input,41,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getXExecutorAccess().getExecutorKeyword_1());
              		
            }
            // InternalTmscXtext.g:1612:3: ( ( (lv_description_2_0= ruleIDString ) ) otherlv_3= 'as' )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==RULE_ID) ) {
                int LA36_1 = input.LA(2);

                if ( (LA36_1==27) ) {
                    alt36=1;
                }
            }
            else if ( (LA36_0==RULE_STRING) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalTmscXtext.g:1613:4: ( (lv_description_2_0= ruleIDString ) ) otherlv_3= 'as'
                    {
                    // InternalTmscXtext.g:1613:4: ( (lv_description_2_0= ruleIDString ) )
                    // InternalTmscXtext.g:1614:5: (lv_description_2_0= ruleIDString )
                    {
                    // InternalTmscXtext.g:1614:5: (lv_description_2_0= ruleIDString )
                    // InternalTmscXtext.g:1615:6: lv_description_2_0= ruleIDString
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getXExecutorAccess().getDescriptionIDStringParserRuleCall_2_0_0());
                      					
                    }
                    pushFollow(FOLLOW_19);
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

                    otherlv_3=(Token)match(input,27,FOLLOW_20); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getXExecutorAccess().getAsKeyword_2_1());
                      			
                    }

                    }
                    break;

            }

            // InternalTmscXtext.g:1637:3: ( (lv_name_4_0= RULE_ID ) )
            // InternalTmscXtext.g:1638:4: (lv_name_4_0= RULE_ID )
            {
            // InternalTmscXtext.g:1638:4: (lv_name_4_0= RULE_ID )
            // InternalTmscXtext.g:1639:5: lv_name_4_0= RULE_ID
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

            // InternalTmscXtext.g:1655:3: (otherlv_5= '{' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) )* otherlv_13= '}' )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==15) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalTmscXtext.g:1656:4: otherlv_5= '{' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) )* otherlv_13= '}'
                    {
                    otherlv_5=(Token)match(input,15,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getXExecutorAccess().getLeftCurlyBracketKeyword_4_0());
                      			
                    }
                    // InternalTmscXtext.g:1660:4: ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) )*
                    loop37:
                    do {
                        int alt37=4;
                        switch ( input.LA(1) ) {
                        case 18:
                            {
                            alt37=1;
                            }
                            break;
                        case 19:
                            {
                            alt37=2;
                            }
                            break;
                        case RULE_ID:
                        case RULE_STRING:
                            {
                            alt37=3;
                            }
                            break;

                        }

                        switch (alt37) {
                    	case 1 :
                    	    // InternalTmscXtext.g:1661:5: (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) )
                    	    {
                    	    // InternalTmscXtext.g:1661:5: (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) )
                    	    // InternalTmscXtext.g:1662:6: otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) )
                    	    {
                    	    otherlv_6=(Token)match(input,18,FOLLOW_6); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_6, grammarAccess.getXExecutorAccess().getTimeBoundKeyword_4_1_0_0());
                    	      					
                    	    }
                    	    otherlv_7=(Token)match(input,17,FOLLOW_8); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_7, grammarAccess.getXExecutorAccess().getColonKeyword_4_1_0_1());
                    	      					
                    	    }
                    	    // InternalTmscXtext.g:1670:6: ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) )
                    	    // InternalTmscXtext.g:1671:7: (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL )
                    	    {
                    	    // InternalTmscXtext.g:1671:7: (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL )
                    	    // InternalTmscXtext.g:1672:8: lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL
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
                    	    // InternalTmscXtext.g:1690:5: (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) )
                    	    {
                    	    // InternalTmscXtext.g:1690:5: (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) )
                    	    // InternalTmscXtext.g:1691:6: otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) )
                    	    {
                    	    otherlv_9=(Token)match(input,19,FOLLOW_6); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_9, grammarAccess.getXExecutorAccess().getScheduledKeyword_4_1_1_0());
                    	      					
                    	    }
                    	    otherlv_10=(Token)match(input,17,FOLLOW_9); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_10, grammarAccess.getXExecutorAccess().getColonKeyword_4_1_1_1());
                    	      					
                    	    }
                    	    // InternalTmscXtext.g:1699:6: ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) )
                    	    // InternalTmscXtext.g:1700:7: (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT )
                    	    {
                    	    // InternalTmscXtext.g:1700:7: (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT )
                    	    // InternalTmscXtext.g:1701:8: lv_scheduled_11_0= ruleEBOOLEAN_OBJECT
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
                    	    // InternalTmscXtext.g:1720:5: ( (lv_properties_12_0= ruleXProperty ) )
                    	    {
                    	    // InternalTmscXtext.g:1720:5: ( (lv_properties_12_0= ruleXProperty ) )
                    	    // InternalTmscXtext.g:1721:6: (lv_properties_12_0= ruleXProperty )
                    	    {
                    	    // InternalTmscXtext.g:1721:6: (lv_properties_12_0= ruleXProperty )
                    	    // InternalTmscXtext.g:1722:7: lv_properties_12_0= ruleXProperty
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
                    	    break loop37;
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
    // InternalTmscXtext.g:1749:1: entryRuleXEvent returns [EObject current=null] : iv_ruleXEvent= ruleXEvent EOF ;
    public final EObject entryRuleXEvent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXEvent = null;


        try {
            // InternalTmscXtext.g:1749:47: (iv_ruleXEvent= ruleXEvent EOF )
            // InternalTmscXtext.g:1750:2: iv_ruleXEvent= ruleXEvent EOF
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
    // InternalTmscXtext.g:1756:1: ruleXEvent returns [EObject current=null] : ( ( ( (lv_timestamp_0_1= RULE_ISO8601 | lv_timestamp_0_2= RULE_ABS_EBIGDECIMAL ) ) )? ( (lv_timeBound_1_0= RULE_POS_EBIGDECIMAL ) )? ( ( ruleFQNString ) ) ( ( ruleIDString ) )? ( (lv_type_4_0= ruleXEventType ) ) ( ( ruleIDString ) ) (otherlv_6= '(' ( (lv_arguments_7_0= ruleXEventArgument ) ) (otherlv_8= ',' ( (lv_arguments_9_0= ruleXEventArgument ) ) )* otherlv_10= ')' )? ( (otherlv_11= '!' ( (lv_outgoingDependencies_12_0= ruleXDependency ) ) ) | (otherlv_13= '?' ( ( ruleIDString ) ) ) )* (otherlv_15= '{' ( (otherlv_16= 'time-bound' otherlv_17= ':' ( (lv_timeBound_18_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_19= 'scheduled' otherlv_20= ':' ( (lv_scheduled_21_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_22_0= ruleXProperty ) ) )* otherlv_23= '}' )? ) ;
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
            // InternalTmscXtext.g:1762:2: ( ( ( ( (lv_timestamp_0_1= RULE_ISO8601 | lv_timestamp_0_2= RULE_ABS_EBIGDECIMAL ) ) )? ( (lv_timeBound_1_0= RULE_POS_EBIGDECIMAL ) )? ( ( ruleFQNString ) ) ( ( ruleIDString ) )? ( (lv_type_4_0= ruleXEventType ) ) ( ( ruleIDString ) ) (otherlv_6= '(' ( (lv_arguments_7_0= ruleXEventArgument ) ) (otherlv_8= ',' ( (lv_arguments_9_0= ruleXEventArgument ) ) )* otherlv_10= ')' )? ( (otherlv_11= '!' ( (lv_outgoingDependencies_12_0= ruleXDependency ) ) ) | (otherlv_13= '?' ( ( ruleIDString ) ) ) )* (otherlv_15= '{' ( (otherlv_16= 'time-bound' otherlv_17= ':' ( (lv_timeBound_18_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_19= 'scheduled' otherlv_20= ':' ( (lv_scheduled_21_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_22_0= ruleXProperty ) ) )* otherlv_23= '}' )? ) )
            // InternalTmscXtext.g:1763:2: ( ( ( (lv_timestamp_0_1= RULE_ISO8601 | lv_timestamp_0_2= RULE_ABS_EBIGDECIMAL ) ) )? ( (lv_timeBound_1_0= RULE_POS_EBIGDECIMAL ) )? ( ( ruleFQNString ) ) ( ( ruleIDString ) )? ( (lv_type_4_0= ruleXEventType ) ) ( ( ruleIDString ) ) (otherlv_6= '(' ( (lv_arguments_7_0= ruleXEventArgument ) ) (otherlv_8= ',' ( (lv_arguments_9_0= ruleXEventArgument ) ) )* otherlv_10= ')' )? ( (otherlv_11= '!' ( (lv_outgoingDependencies_12_0= ruleXDependency ) ) ) | (otherlv_13= '?' ( ( ruleIDString ) ) ) )* (otherlv_15= '{' ( (otherlv_16= 'time-bound' otherlv_17= ':' ( (lv_timeBound_18_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_19= 'scheduled' otherlv_20= ':' ( (lv_scheduled_21_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_22_0= ruleXProperty ) ) )* otherlv_23= '}' )? )
            {
            // InternalTmscXtext.g:1763:2: ( ( ( (lv_timestamp_0_1= RULE_ISO8601 | lv_timestamp_0_2= RULE_ABS_EBIGDECIMAL ) ) )? ( (lv_timeBound_1_0= RULE_POS_EBIGDECIMAL ) )? ( ( ruleFQNString ) ) ( ( ruleIDString ) )? ( (lv_type_4_0= ruleXEventType ) ) ( ( ruleIDString ) ) (otherlv_6= '(' ( (lv_arguments_7_0= ruleXEventArgument ) ) (otherlv_8= ',' ( (lv_arguments_9_0= ruleXEventArgument ) ) )* otherlv_10= ')' )? ( (otherlv_11= '!' ( (lv_outgoingDependencies_12_0= ruleXDependency ) ) ) | (otherlv_13= '?' ( ( ruleIDString ) ) ) )* (otherlv_15= '{' ( (otherlv_16= 'time-bound' otherlv_17= ':' ( (lv_timeBound_18_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_19= 'scheduled' otherlv_20= ':' ( (lv_scheduled_21_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_22_0= ruleXProperty ) ) )* otherlv_23= '}' )? )
            // InternalTmscXtext.g:1764:3: ( ( (lv_timestamp_0_1= RULE_ISO8601 | lv_timestamp_0_2= RULE_ABS_EBIGDECIMAL ) ) )? ( (lv_timeBound_1_0= RULE_POS_EBIGDECIMAL ) )? ( ( ruleFQNString ) ) ( ( ruleIDString ) )? ( (lv_type_4_0= ruleXEventType ) ) ( ( ruleIDString ) ) (otherlv_6= '(' ( (lv_arguments_7_0= ruleXEventArgument ) ) (otherlv_8= ',' ( (lv_arguments_9_0= ruleXEventArgument ) ) )* otherlv_10= ')' )? ( (otherlv_11= '!' ( (lv_outgoingDependencies_12_0= ruleXDependency ) ) ) | (otherlv_13= '?' ( ( ruleIDString ) ) ) )* (otherlv_15= '{' ( (otherlv_16= 'time-bound' otherlv_17= ':' ( (lv_timeBound_18_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_19= 'scheduled' otherlv_20= ':' ( (lv_scheduled_21_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_22_0= ruleXProperty ) ) )* otherlv_23= '}' )?
            {
            // InternalTmscXtext.g:1764:3: ( ( (lv_timestamp_0_1= RULE_ISO8601 | lv_timestamp_0_2= RULE_ABS_EBIGDECIMAL ) ) )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==RULE_ABS_EBIGDECIMAL||LA40_0==RULE_ISO8601) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // InternalTmscXtext.g:1765:4: ( (lv_timestamp_0_1= RULE_ISO8601 | lv_timestamp_0_2= RULE_ABS_EBIGDECIMAL ) )
                    {
                    // InternalTmscXtext.g:1765:4: ( (lv_timestamp_0_1= RULE_ISO8601 | lv_timestamp_0_2= RULE_ABS_EBIGDECIMAL ) )
                    // InternalTmscXtext.g:1766:5: (lv_timestamp_0_1= RULE_ISO8601 | lv_timestamp_0_2= RULE_ABS_EBIGDECIMAL )
                    {
                    // InternalTmscXtext.g:1766:5: (lv_timestamp_0_1= RULE_ISO8601 | lv_timestamp_0_2= RULE_ABS_EBIGDECIMAL )
                    int alt39=2;
                    int LA39_0 = input.LA(1);

                    if ( (LA39_0==RULE_ISO8601) ) {
                        alt39=1;
                    }
                    else if ( (LA39_0==RULE_ABS_EBIGDECIMAL) ) {
                        alt39=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 39, 0, input);

                        throw nvae;
                    }
                    switch (alt39) {
                        case 1 :
                            // InternalTmscXtext.g:1767:6: lv_timestamp_0_1= RULE_ISO8601
                            {
                            lv_timestamp_0_1=(Token)match(input,RULE_ISO8601,FOLLOW_34); if (state.failed) return current;
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
                            // InternalTmscXtext.g:1782:6: lv_timestamp_0_2= RULE_ABS_EBIGDECIMAL
                            {
                            lv_timestamp_0_2=(Token)match(input,RULE_ABS_EBIGDECIMAL,FOLLOW_34); if (state.failed) return current;
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

            // InternalTmscXtext.g:1799:3: ( (lv_timeBound_1_0= RULE_POS_EBIGDECIMAL ) )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==RULE_POS_EBIGDECIMAL) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalTmscXtext.g:1800:4: (lv_timeBound_1_0= RULE_POS_EBIGDECIMAL )
                    {
                    // InternalTmscXtext.g:1800:4: (lv_timeBound_1_0= RULE_POS_EBIGDECIMAL )
                    // InternalTmscXtext.g:1801:5: lv_timeBound_1_0= RULE_POS_EBIGDECIMAL
                    {
                    lv_timeBound_1_0=(Token)match(input,RULE_POS_EBIGDECIMAL,FOLLOW_34); if (state.failed) return current;
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

            // InternalTmscXtext.g:1817:3: ( ( ruleFQNString ) )
            // InternalTmscXtext.g:1818:4: ( ruleFQNString )
            {
            // InternalTmscXtext.g:1818:4: ( ruleFQNString )
            // InternalTmscXtext.g:1819:5: ruleFQNString
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getXEventRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getXEventAccess().getExecutorXExecutorCrossReference_2_0());
              				
            }
            pushFollow(FOLLOW_34);
            ruleFQNString();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalTmscXtext.g:1833:3: ( ( ruleIDString ) )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==RULE_ID||LA42_0==RULE_STRING) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // InternalTmscXtext.g:1834:4: ( ruleIDString )
                    {
                    // InternalTmscXtext.g:1834:4: ( ruleIDString )
                    // InternalTmscXtext.g:1835:5: ruleIDString
                    {
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getXEventRule());
                      					}
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getXEventAccess().getComponentXComponentCrossReference_3_0());
                      				
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
                    break;

            }

            // InternalTmscXtext.g:1849:3: ( (lv_type_4_0= ruleXEventType ) )
            // InternalTmscXtext.g:1850:4: (lv_type_4_0= ruleXEventType )
            {
            // InternalTmscXtext.g:1850:4: (lv_type_4_0= ruleXEventType )
            // InternalTmscXtext.g:1851:5: lv_type_4_0= ruleXEventType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getXEventAccess().getTypeXEventTypeEnumRuleCall_4_0());
              				
            }
            pushFollow(FOLLOW_18);
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

            // InternalTmscXtext.g:1868:3: ( ( ruleIDString ) )
            // InternalTmscXtext.g:1869:4: ( ruleIDString )
            {
            // InternalTmscXtext.g:1869:4: ( ruleIDString )
            // InternalTmscXtext.g:1870:5: ruleIDString
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getXEventRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getXEventAccess().getFunctionXFunctionCrossReference_5_0());
              				
            }
            pushFollow(FOLLOW_35);
            ruleIDString();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalTmscXtext.g:1884:3: (otherlv_6= '(' ( (lv_arguments_7_0= ruleXEventArgument ) ) (otherlv_8= ',' ( (lv_arguments_9_0= ruleXEventArgument ) ) )* otherlv_10= ')' )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==36) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // InternalTmscXtext.g:1885:4: otherlv_6= '(' ( (lv_arguments_7_0= ruleXEventArgument ) ) (otherlv_8= ',' ( (lv_arguments_9_0= ruleXEventArgument ) ) )* otherlv_10= ')'
                    {
                    otherlv_6=(Token)match(input,36,FOLLOW_20); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_6, grammarAccess.getXEventAccess().getLeftParenthesisKeyword_6_0());
                      			
                    }
                    // InternalTmscXtext.g:1889:4: ( (lv_arguments_7_0= ruleXEventArgument ) )
                    // InternalTmscXtext.g:1890:5: (lv_arguments_7_0= ruleXEventArgument )
                    {
                    // InternalTmscXtext.g:1890:5: (lv_arguments_7_0= ruleXEventArgument )
                    // InternalTmscXtext.g:1891:6: lv_arguments_7_0= ruleXEventArgument
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getXEventAccess().getArgumentsXEventArgumentParserRuleCall_6_1_0());
                      					
                    }
                    pushFollow(FOLLOW_28);
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

                    // InternalTmscXtext.g:1908:4: (otherlv_8= ',' ( (lv_arguments_9_0= ruleXEventArgument ) ) )*
                    loop43:
                    do {
                        int alt43=2;
                        int LA43_0 = input.LA(1);

                        if ( (LA43_0==31) ) {
                            alt43=1;
                        }


                        switch (alt43) {
                    	case 1 :
                    	    // InternalTmscXtext.g:1909:5: otherlv_8= ',' ( (lv_arguments_9_0= ruleXEventArgument ) )
                    	    {
                    	    otherlv_8=(Token)match(input,31,FOLLOW_20); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_8, grammarAccess.getXEventAccess().getCommaKeyword_6_2_0());
                    	      				
                    	    }
                    	    // InternalTmscXtext.g:1913:5: ( (lv_arguments_9_0= ruleXEventArgument ) )
                    	    // InternalTmscXtext.g:1914:6: (lv_arguments_9_0= ruleXEventArgument )
                    	    {
                    	    // InternalTmscXtext.g:1914:6: (lv_arguments_9_0= ruleXEventArgument )
                    	    // InternalTmscXtext.g:1915:7: lv_arguments_9_0= ruleXEventArgument
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getXEventAccess().getArgumentsXEventArgumentParserRuleCall_6_2_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_28);
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
                    	    break loop43;
                        }
                    } while (true);

                    otherlv_10=(Token)match(input,37,FOLLOW_36); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_10, grammarAccess.getXEventAccess().getRightParenthesisKeyword_6_3());
                      			
                    }

                    }
                    break;

            }

            // InternalTmscXtext.g:1938:3: ( (otherlv_11= '!' ( (lv_outgoingDependencies_12_0= ruleXDependency ) ) ) | (otherlv_13= '?' ( ( ruleIDString ) ) ) )*
            loop45:
            do {
                int alt45=3;
                int LA45_0 = input.LA(1);

                if ( (LA45_0==42) ) {
                    alt45=1;
                }
                else if ( (LA45_0==43) ) {
                    alt45=2;
                }


                switch (alt45) {
            	case 1 :
            	    // InternalTmscXtext.g:1939:4: (otherlv_11= '!' ( (lv_outgoingDependencies_12_0= ruleXDependency ) ) )
            	    {
            	    // InternalTmscXtext.g:1939:4: (otherlv_11= '!' ( (lv_outgoingDependencies_12_0= ruleXDependency ) ) )
            	    // InternalTmscXtext.g:1940:5: otherlv_11= '!' ( (lv_outgoingDependencies_12_0= ruleXDependency ) )
            	    {
            	    otherlv_11=(Token)match(input,42,FOLLOW_37); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_11, grammarAccess.getXEventAccess().getExclamationMarkKeyword_7_0_0());
            	      				
            	    }
            	    // InternalTmscXtext.g:1944:5: ( (lv_outgoingDependencies_12_0= ruleXDependency ) )
            	    // InternalTmscXtext.g:1945:6: (lv_outgoingDependencies_12_0= ruleXDependency )
            	    {
            	    // InternalTmscXtext.g:1945:6: (lv_outgoingDependencies_12_0= ruleXDependency )
            	    // InternalTmscXtext.g:1946:7: lv_outgoingDependencies_12_0= ruleXDependency
            	    {
            	    if ( state.backtracking==0 ) {

            	      							newCompositeNode(grammarAccess.getXEventAccess().getOutgoingDependenciesXDependencyParserRuleCall_7_0_1_0());
            	      						
            	    }
            	    pushFollow(FOLLOW_36);
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
            	    // InternalTmscXtext.g:1965:4: (otherlv_13= '?' ( ( ruleIDString ) ) )
            	    {
            	    // InternalTmscXtext.g:1965:4: (otherlv_13= '?' ( ( ruleIDString ) ) )
            	    // InternalTmscXtext.g:1966:5: otherlv_13= '?' ( ( ruleIDString ) )
            	    {
            	    otherlv_13=(Token)match(input,43,FOLLOW_18); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_13, grammarAccess.getXEventAccess().getQuestionMarkKeyword_7_1_0());
            	      				
            	    }
            	    // InternalTmscXtext.g:1970:5: ( ( ruleIDString ) )
            	    // InternalTmscXtext.g:1971:6: ( ruleIDString )
            	    {
            	    // InternalTmscXtext.g:1971:6: ( ruleIDString )
            	    // InternalTmscXtext.g:1972:7: ruleIDString
            	    {
            	    if ( state.backtracking==0 ) {

            	      							if (current==null) {
            	      								current = createModelElement(grammarAccess.getXEventRule());
            	      							}
            	      						
            	    }
            	    if ( state.backtracking==0 ) {

            	      							newCompositeNode(grammarAccess.getXEventAccess().getIncomingDependenciesXDependencyCrossReference_7_1_1_0());
            	      						
            	    }
            	    pushFollow(FOLLOW_36);
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
            	    break loop45;
                }
            } while (true);

            // InternalTmscXtext.g:1988:3: (otherlv_15= '{' ( (otherlv_16= 'time-bound' otherlv_17= ':' ( (lv_timeBound_18_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_19= 'scheduled' otherlv_20= ':' ( (lv_scheduled_21_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_22_0= ruleXProperty ) ) )* otherlv_23= '}' )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==15) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // InternalTmscXtext.g:1989:4: otherlv_15= '{' ( (otherlv_16= 'time-bound' otherlv_17= ':' ( (lv_timeBound_18_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_19= 'scheduled' otherlv_20= ':' ( (lv_scheduled_21_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_22_0= ruleXProperty ) ) )* otherlv_23= '}'
                    {
                    otherlv_15=(Token)match(input,15,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_15, grammarAccess.getXEventAccess().getLeftCurlyBracketKeyword_8_0());
                      			
                    }
                    // InternalTmscXtext.g:1993:4: ( (otherlv_16= 'time-bound' otherlv_17= ':' ( (lv_timeBound_18_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_19= 'scheduled' otherlv_20= ':' ( (lv_scheduled_21_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_22_0= ruleXProperty ) ) )*
                    loop46:
                    do {
                        int alt46=4;
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
                        case RULE_ID:
                        case RULE_STRING:
                            {
                            alt46=3;
                            }
                            break;

                        }

                        switch (alt46) {
                    	case 1 :
                    	    // InternalTmscXtext.g:1994:5: (otherlv_16= 'time-bound' otherlv_17= ':' ( (lv_timeBound_18_0= RULE_ABS_EBIGDECIMAL ) ) )
                    	    {
                    	    // InternalTmscXtext.g:1994:5: (otherlv_16= 'time-bound' otherlv_17= ':' ( (lv_timeBound_18_0= RULE_ABS_EBIGDECIMAL ) ) )
                    	    // InternalTmscXtext.g:1995:6: otherlv_16= 'time-bound' otherlv_17= ':' ( (lv_timeBound_18_0= RULE_ABS_EBIGDECIMAL ) )
                    	    {
                    	    otherlv_16=(Token)match(input,18,FOLLOW_6); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_16, grammarAccess.getXEventAccess().getTimeBoundKeyword_8_1_0_0());
                    	      					
                    	    }
                    	    otherlv_17=(Token)match(input,17,FOLLOW_8); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_17, grammarAccess.getXEventAccess().getColonKeyword_8_1_0_1());
                    	      					
                    	    }
                    	    // InternalTmscXtext.g:2003:6: ( (lv_timeBound_18_0= RULE_ABS_EBIGDECIMAL ) )
                    	    // InternalTmscXtext.g:2004:7: (lv_timeBound_18_0= RULE_ABS_EBIGDECIMAL )
                    	    {
                    	    // InternalTmscXtext.g:2004:7: (lv_timeBound_18_0= RULE_ABS_EBIGDECIMAL )
                    	    // InternalTmscXtext.g:2005:8: lv_timeBound_18_0= RULE_ABS_EBIGDECIMAL
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
                    	    // InternalTmscXtext.g:2023:5: (otherlv_19= 'scheduled' otherlv_20= ':' ( (lv_scheduled_21_0= ruleEBOOLEAN_OBJECT ) ) )
                    	    {
                    	    // InternalTmscXtext.g:2023:5: (otherlv_19= 'scheduled' otherlv_20= ':' ( (lv_scheduled_21_0= ruleEBOOLEAN_OBJECT ) ) )
                    	    // InternalTmscXtext.g:2024:6: otherlv_19= 'scheduled' otherlv_20= ':' ( (lv_scheduled_21_0= ruleEBOOLEAN_OBJECT ) )
                    	    {
                    	    otherlv_19=(Token)match(input,19,FOLLOW_6); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_19, grammarAccess.getXEventAccess().getScheduledKeyword_8_1_1_0());
                    	      					
                    	    }
                    	    otherlv_20=(Token)match(input,17,FOLLOW_9); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_20, grammarAccess.getXEventAccess().getColonKeyword_8_1_1_1());
                    	      					
                    	    }
                    	    // InternalTmscXtext.g:2032:6: ( (lv_scheduled_21_0= ruleEBOOLEAN_OBJECT ) )
                    	    // InternalTmscXtext.g:2033:7: (lv_scheduled_21_0= ruleEBOOLEAN_OBJECT )
                    	    {
                    	    // InternalTmscXtext.g:2033:7: (lv_scheduled_21_0= ruleEBOOLEAN_OBJECT )
                    	    // InternalTmscXtext.g:2034:8: lv_scheduled_21_0= ruleEBOOLEAN_OBJECT
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
                    	    // InternalTmscXtext.g:2053:5: ( (lv_properties_22_0= ruleXProperty ) )
                    	    {
                    	    // InternalTmscXtext.g:2053:5: ( (lv_properties_22_0= ruleXProperty ) )
                    	    // InternalTmscXtext.g:2054:6: (lv_properties_22_0= ruleXProperty )
                    	    {
                    	    // InternalTmscXtext.g:2054:6: (lv_properties_22_0= ruleXProperty )
                    	    // InternalTmscXtext.g:2055:7: lv_properties_22_0= ruleXProperty
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
                    	    break loop46;
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
    // InternalTmscXtext.g:2082:1: entryRuleXEventArgument returns [EObject current=null] : iv_ruleXEventArgument= ruleXEventArgument EOF ;
    public final EObject entryRuleXEventArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXEventArgument = null;


        try {
            // InternalTmscXtext.g:2082:55: (iv_ruleXEventArgument= ruleXEventArgument EOF )
            // InternalTmscXtext.g:2083:2: iv_ruleXEventArgument= ruleXEventArgument EOF
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
    // InternalTmscXtext.g:2089:1: ruleXEventArgument returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' ( (lv_value_2_0= ruleIDString ) ) ) ;
    public final EObject ruleXEventArgument() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalTmscXtext.g:2095:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' ( (lv_value_2_0= ruleIDString ) ) ) )
            // InternalTmscXtext.g:2096:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' ( (lv_value_2_0= ruleIDString ) ) )
            {
            // InternalTmscXtext.g:2096:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' ( (lv_value_2_0= ruleIDString ) ) )
            // InternalTmscXtext.g:2097:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' ( (lv_value_2_0= ruleIDString ) )
            {
            // InternalTmscXtext.g:2097:3: ( (otherlv_0= RULE_ID ) )
            // InternalTmscXtext.g:2098:4: (otherlv_0= RULE_ID )
            {
            // InternalTmscXtext.g:2098:4: (otherlv_0= RULE_ID )
            // InternalTmscXtext.g:2099:5: otherlv_0= RULE_ID
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

            otherlv_1=(Token)match(input,17,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getXEventArgumentAccess().getColonKeyword_1());
              		
            }
            // InternalTmscXtext.g:2114:3: ( (lv_value_2_0= ruleIDString ) )
            // InternalTmscXtext.g:2115:4: (lv_value_2_0= ruleIDString )
            {
            // InternalTmscXtext.g:2115:4: (lv_value_2_0= ruleIDString )
            // InternalTmscXtext.g:2116:5: lv_value_2_0= ruleIDString
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
    // InternalTmscXtext.g:2137:1: entryRuleXDependency returns [EObject current=null] : iv_ruleXDependency= ruleXDependency EOF ;
    public final EObject entryRuleXDependency() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXDependency = null;


        try {
            // InternalTmscXtext.g:2137:52: (iv_ruleXDependency= ruleXDependency EOF )
            // InternalTmscXtext.g:2138:2: iv_ruleXDependency= ruleXDependency EOF
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
    // InternalTmscXtext.g:2144:1: ruleXDependency returns [EObject current=null] : ( ( (lv_typeObject_0_0= ruleXDependencyTypeObject ) )? ( (lv_name_1_0= ruleIDString ) ) ( (otherlv_2= '(' ( (lv_timeBound_3_0= RULE_ABS_EBIGDECIMAL ) ) otherlv_4= ')' ) | (otherlv_5= '(' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_12= 'request' otherlv_13= ':' ( ( ruleIDString ) ) ) | (otherlv_15= 'message' otherlv_16= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_18_0= ruleXProperty ) ) ) (otherlv_19= ',' ( (otherlv_20= 'time-bound' otherlv_21= ':' ( (lv_timeBound_22_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_23= 'scheduled' otherlv_24= ':' ( (lv_scheduled_25_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_26= 'request' otherlv_27= ':' ( ( ruleIDString ) ) ) | (otherlv_29= 'message' otherlv_30= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_32_0= ruleXProperty ) ) ) )* otherlv_33= ')' ) )? ) ;
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
            // InternalTmscXtext.g:2150:2: ( ( ( (lv_typeObject_0_0= ruleXDependencyTypeObject ) )? ( (lv_name_1_0= ruleIDString ) ) ( (otherlv_2= '(' ( (lv_timeBound_3_0= RULE_ABS_EBIGDECIMAL ) ) otherlv_4= ')' ) | (otherlv_5= '(' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_12= 'request' otherlv_13= ':' ( ( ruleIDString ) ) ) | (otherlv_15= 'message' otherlv_16= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_18_0= ruleXProperty ) ) ) (otherlv_19= ',' ( (otherlv_20= 'time-bound' otherlv_21= ':' ( (lv_timeBound_22_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_23= 'scheduled' otherlv_24= ':' ( (lv_scheduled_25_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_26= 'request' otherlv_27= ':' ( ( ruleIDString ) ) ) | (otherlv_29= 'message' otherlv_30= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_32_0= ruleXProperty ) ) ) )* otherlv_33= ')' ) )? ) )
            // InternalTmscXtext.g:2151:2: ( ( (lv_typeObject_0_0= ruleXDependencyTypeObject ) )? ( (lv_name_1_0= ruleIDString ) ) ( (otherlv_2= '(' ( (lv_timeBound_3_0= RULE_ABS_EBIGDECIMAL ) ) otherlv_4= ')' ) | (otherlv_5= '(' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_12= 'request' otherlv_13= ':' ( ( ruleIDString ) ) ) | (otherlv_15= 'message' otherlv_16= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_18_0= ruleXProperty ) ) ) (otherlv_19= ',' ( (otherlv_20= 'time-bound' otherlv_21= ':' ( (lv_timeBound_22_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_23= 'scheduled' otherlv_24= ':' ( (lv_scheduled_25_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_26= 'request' otherlv_27= ':' ( ( ruleIDString ) ) ) | (otherlv_29= 'message' otherlv_30= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_32_0= ruleXProperty ) ) ) )* otherlv_33= ')' ) )? )
            {
            // InternalTmscXtext.g:2151:2: ( ( (lv_typeObject_0_0= ruleXDependencyTypeObject ) )? ( (lv_name_1_0= ruleIDString ) ) ( (otherlv_2= '(' ( (lv_timeBound_3_0= RULE_ABS_EBIGDECIMAL ) ) otherlv_4= ')' ) | (otherlv_5= '(' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_12= 'request' otherlv_13= ':' ( ( ruleIDString ) ) ) | (otherlv_15= 'message' otherlv_16= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_18_0= ruleXProperty ) ) ) (otherlv_19= ',' ( (otherlv_20= 'time-bound' otherlv_21= ':' ( (lv_timeBound_22_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_23= 'scheduled' otherlv_24= ':' ( (lv_scheduled_25_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_26= 'request' otherlv_27= ':' ( ( ruleIDString ) ) ) | (otherlv_29= 'message' otherlv_30= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_32_0= ruleXProperty ) ) ) )* otherlv_33= ')' ) )? )
            // InternalTmscXtext.g:2152:3: ( (lv_typeObject_0_0= ruleXDependencyTypeObject ) )? ( (lv_name_1_0= ruleIDString ) ) ( (otherlv_2= '(' ( (lv_timeBound_3_0= RULE_ABS_EBIGDECIMAL ) ) otherlv_4= ')' ) | (otherlv_5= '(' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_12= 'request' otherlv_13= ':' ( ( ruleIDString ) ) ) | (otherlv_15= 'message' otherlv_16= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_18_0= ruleXProperty ) ) ) (otherlv_19= ',' ( (otherlv_20= 'time-bound' otherlv_21= ':' ( (lv_timeBound_22_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_23= 'scheduled' otherlv_24= ':' ( (lv_scheduled_25_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_26= 'request' otherlv_27= ':' ( ( ruleIDString ) ) ) | (otherlv_29= 'message' otherlv_30= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_32_0= ruleXProperty ) ) ) )* otherlv_33= ')' ) )?
            {
            // InternalTmscXtext.g:2152:3: ( (lv_typeObject_0_0= ruleXDependencyTypeObject ) )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( ((LA48_0>=44 && LA48_0<=45)||(LA48_0>=60 && LA48_0<=63)) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // InternalTmscXtext.g:2153:4: (lv_typeObject_0_0= ruleXDependencyTypeObject )
                    {
                    // InternalTmscXtext.g:2153:4: (lv_typeObject_0_0= ruleXDependencyTypeObject )
                    // InternalTmscXtext.g:2154:5: lv_typeObject_0_0= ruleXDependencyTypeObject
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getXDependencyAccess().getTypeObjectXDependencyTypeObjectParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_18);
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

            // InternalTmscXtext.g:2171:3: ( (lv_name_1_0= ruleIDString ) )
            // InternalTmscXtext.g:2172:4: (lv_name_1_0= ruleIDString )
            {
            // InternalTmscXtext.g:2172:4: (lv_name_1_0= ruleIDString )
            // InternalTmscXtext.g:2173:5: lv_name_1_0= ruleIDString
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getXDependencyAccess().getNameIDStringParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_30);
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

            // InternalTmscXtext.g:2190:3: ( (otherlv_2= '(' ( (lv_timeBound_3_0= RULE_ABS_EBIGDECIMAL ) ) otherlv_4= ')' ) | (otherlv_5= '(' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_12= 'request' otherlv_13= ':' ( ( ruleIDString ) ) ) | (otherlv_15= 'message' otherlv_16= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_18_0= ruleXProperty ) ) ) (otherlv_19= ',' ( (otherlv_20= 'time-bound' otherlv_21= ':' ( (lv_timeBound_22_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_23= 'scheduled' otherlv_24= ':' ( (lv_scheduled_25_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_26= 'request' otherlv_27= ':' ( ( ruleIDString ) ) ) | (otherlv_29= 'message' otherlv_30= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_32_0= ruleXProperty ) ) ) )* otherlv_33= ')' ) )?
            int alt52=3;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==36) ) {
                int LA52_1 = input.LA(2);

                if ( (LA52_1==RULE_ABS_EBIGDECIMAL) ) {
                    alt52=1;
                }
                else if ( (LA52_1==RULE_ID||LA52_1==RULE_STRING||(LA52_1>=18 && LA52_1<=19)||(LA52_1>=44 && LA52_1<=45)) ) {
                    alt52=2;
                }
            }
            switch (alt52) {
                case 1 :
                    // InternalTmscXtext.g:2191:4: (otherlv_2= '(' ( (lv_timeBound_3_0= RULE_ABS_EBIGDECIMAL ) ) otherlv_4= ')' )
                    {
                    // InternalTmscXtext.g:2191:4: (otherlv_2= '(' ( (lv_timeBound_3_0= RULE_ABS_EBIGDECIMAL ) ) otherlv_4= ')' )
                    // InternalTmscXtext.g:2192:5: otherlv_2= '(' ( (lv_timeBound_3_0= RULE_ABS_EBIGDECIMAL ) ) otherlv_4= ')'
                    {
                    otherlv_2=(Token)match(input,36,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_2, grammarAccess.getXDependencyAccess().getLeftParenthesisKeyword_2_0_0());
                      				
                    }
                    // InternalTmscXtext.g:2196:5: ( (lv_timeBound_3_0= RULE_ABS_EBIGDECIMAL ) )
                    // InternalTmscXtext.g:2197:6: (lv_timeBound_3_0= RULE_ABS_EBIGDECIMAL )
                    {
                    // InternalTmscXtext.g:2197:6: (lv_timeBound_3_0= RULE_ABS_EBIGDECIMAL )
                    // InternalTmscXtext.g:2198:7: lv_timeBound_3_0= RULE_ABS_EBIGDECIMAL
                    {
                    lv_timeBound_3_0=(Token)match(input,RULE_ABS_EBIGDECIMAL,FOLLOW_38); if (state.failed) return current;
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

                    otherlv_4=(Token)match(input,37,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_4, grammarAccess.getXDependencyAccess().getRightParenthesisKeyword_2_0_2());
                      				
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalTmscXtext.g:2220:4: (otherlv_5= '(' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_12= 'request' otherlv_13= ':' ( ( ruleIDString ) ) ) | (otherlv_15= 'message' otherlv_16= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_18_0= ruleXProperty ) ) ) (otherlv_19= ',' ( (otherlv_20= 'time-bound' otherlv_21= ':' ( (lv_timeBound_22_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_23= 'scheduled' otherlv_24= ':' ( (lv_scheduled_25_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_26= 'request' otherlv_27= ':' ( ( ruleIDString ) ) ) | (otherlv_29= 'message' otherlv_30= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_32_0= ruleXProperty ) ) ) )* otherlv_33= ')' )
                    {
                    // InternalTmscXtext.g:2220:4: (otherlv_5= '(' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_12= 'request' otherlv_13= ':' ( ( ruleIDString ) ) ) | (otherlv_15= 'message' otherlv_16= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_18_0= ruleXProperty ) ) ) (otherlv_19= ',' ( (otherlv_20= 'time-bound' otherlv_21= ':' ( (lv_timeBound_22_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_23= 'scheduled' otherlv_24= ':' ( (lv_scheduled_25_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_26= 'request' otherlv_27= ':' ( ( ruleIDString ) ) ) | (otherlv_29= 'message' otherlv_30= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_32_0= ruleXProperty ) ) ) )* otherlv_33= ')' )
                    // InternalTmscXtext.g:2221:5: otherlv_5= '(' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_12= 'request' otherlv_13= ':' ( ( ruleIDString ) ) ) | (otherlv_15= 'message' otherlv_16= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_18_0= ruleXProperty ) ) ) (otherlv_19= ',' ( (otherlv_20= 'time-bound' otherlv_21= ':' ( (lv_timeBound_22_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_23= 'scheduled' otherlv_24= ':' ( (lv_scheduled_25_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_26= 'request' otherlv_27= ':' ( ( ruleIDString ) ) ) | (otherlv_29= 'message' otherlv_30= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_32_0= ruleXProperty ) ) ) )* otherlv_33= ')'
                    {
                    otherlv_5=(Token)match(input,36,FOLLOW_39); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_5, grammarAccess.getXDependencyAccess().getLeftParenthesisKeyword_2_1_0());
                      				
                    }
                    // InternalTmscXtext.g:2225:5: ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_12= 'request' otherlv_13= ':' ( ( ruleIDString ) ) ) | (otherlv_15= 'message' otherlv_16= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_18_0= ruleXProperty ) ) )
                    int alt49=5;
                    switch ( input.LA(1) ) {
                    case 18:
                        {
                        alt49=1;
                        }
                        break;
                    case 19:
                        {
                        alt49=2;
                        }
                        break;
                    case 44:
                        {
                        alt49=3;
                        }
                        break;
                    case 45:
                        {
                        alt49=4;
                        }
                        break;
                    case RULE_ID:
                    case RULE_STRING:
                        {
                        alt49=5;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 49, 0, input);

                        throw nvae;
                    }

                    switch (alt49) {
                        case 1 :
                            // InternalTmscXtext.g:2226:6: (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) )
                            {
                            // InternalTmscXtext.g:2226:6: (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) )
                            // InternalTmscXtext.g:2227:7: otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) )
                            {
                            otherlv_6=(Token)match(input,18,FOLLOW_6); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(otherlv_6, grammarAccess.getXDependencyAccess().getTimeBoundKeyword_2_1_1_0_0());
                              						
                            }
                            otherlv_7=(Token)match(input,17,FOLLOW_8); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(otherlv_7, grammarAccess.getXDependencyAccess().getColonKeyword_2_1_1_0_1());
                              						
                            }
                            // InternalTmscXtext.g:2235:7: ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) )
                            // InternalTmscXtext.g:2236:8: (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL )
                            {
                            // InternalTmscXtext.g:2236:8: (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL )
                            // InternalTmscXtext.g:2237:9: lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL
                            {
                            lv_timeBound_8_0=(Token)match(input,RULE_ABS_EBIGDECIMAL,FOLLOW_28); if (state.failed) return current;
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
                            // InternalTmscXtext.g:2255:6: (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) )
                            {
                            // InternalTmscXtext.g:2255:6: (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) )
                            // InternalTmscXtext.g:2256:7: otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) )
                            {
                            otherlv_9=(Token)match(input,19,FOLLOW_6); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(otherlv_9, grammarAccess.getXDependencyAccess().getScheduledKeyword_2_1_1_1_0());
                              						
                            }
                            otherlv_10=(Token)match(input,17,FOLLOW_9); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(otherlv_10, grammarAccess.getXDependencyAccess().getColonKeyword_2_1_1_1_1());
                              						
                            }
                            // InternalTmscXtext.g:2264:7: ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) )
                            // InternalTmscXtext.g:2265:8: (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT )
                            {
                            // InternalTmscXtext.g:2265:8: (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT )
                            // InternalTmscXtext.g:2266:9: lv_scheduled_11_0= ruleEBOOLEAN_OBJECT
                            {
                            if ( state.backtracking==0 ) {

                              									newCompositeNode(grammarAccess.getXDependencyAccess().getScheduledEBOOLEAN_OBJECTParserRuleCall_2_1_1_1_2_0());
                              								
                            }
                            pushFollow(FOLLOW_28);
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
                            // InternalTmscXtext.g:2285:6: (otherlv_12= 'request' otherlv_13= ':' ( ( ruleIDString ) ) )
                            {
                            // InternalTmscXtext.g:2285:6: (otherlv_12= 'request' otherlv_13= ':' ( ( ruleIDString ) ) )
                            // InternalTmscXtext.g:2286:7: otherlv_12= 'request' otherlv_13= ':' ( ( ruleIDString ) )
                            {
                            otherlv_12=(Token)match(input,44,FOLLOW_6); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(otherlv_12, grammarAccess.getXDependencyAccess().getRequestKeyword_2_1_1_2_0());
                              						
                            }
                            otherlv_13=(Token)match(input,17,FOLLOW_18); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(otherlv_13, grammarAccess.getXDependencyAccess().getColonKeyword_2_1_1_2_1());
                              						
                            }
                            // InternalTmscXtext.g:2294:7: ( ( ruleIDString ) )
                            // InternalTmscXtext.g:2295:8: ( ruleIDString )
                            {
                            // InternalTmscXtext.g:2295:8: ( ruleIDString )
                            // InternalTmscXtext.g:2296:9: ruleIDString
                            {
                            if ( state.backtracking==0 ) {

                              									if (current==null) {
                              										current = createModelElement(grammarAccess.getXDependencyRule());
                              									}
                              								
                            }
                            if ( state.backtracking==0 ) {

                              									newCompositeNode(grammarAccess.getXDependencyAccess().getRequestXDependencyCrossReference_2_1_1_2_2_0());
                              								
                            }
                            pushFollow(FOLLOW_28);
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
                            // InternalTmscXtext.g:2312:6: (otherlv_15= 'message' otherlv_16= ':' ( ( ruleIDString ) ) )
                            {
                            // InternalTmscXtext.g:2312:6: (otherlv_15= 'message' otherlv_16= ':' ( ( ruleIDString ) ) )
                            // InternalTmscXtext.g:2313:7: otherlv_15= 'message' otherlv_16= ':' ( ( ruleIDString ) )
                            {
                            otherlv_15=(Token)match(input,45,FOLLOW_6); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(otherlv_15, grammarAccess.getXDependencyAccess().getMessageKeyword_2_1_1_3_0());
                              						
                            }
                            otherlv_16=(Token)match(input,17,FOLLOW_18); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(otherlv_16, grammarAccess.getXDependencyAccess().getColonKeyword_2_1_1_3_1());
                              						
                            }
                            // InternalTmscXtext.g:2321:7: ( ( ruleIDString ) )
                            // InternalTmscXtext.g:2322:8: ( ruleIDString )
                            {
                            // InternalTmscXtext.g:2322:8: ( ruleIDString )
                            // InternalTmscXtext.g:2323:9: ruleIDString
                            {
                            if ( state.backtracking==0 ) {

                              									if (current==null) {
                              										current = createModelElement(grammarAccess.getXDependencyRule());
                              									}
                              								
                            }
                            if ( state.backtracking==0 ) {

                              									newCompositeNode(grammarAccess.getXDependencyAccess().getMessageXDependencyCrossReference_2_1_1_3_2_0());
                              								
                            }
                            pushFollow(FOLLOW_28);
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
                            // InternalTmscXtext.g:2339:6: ( (lv_properties_18_0= ruleXProperty ) )
                            {
                            // InternalTmscXtext.g:2339:6: ( (lv_properties_18_0= ruleXProperty ) )
                            // InternalTmscXtext.g:2340:7: (lv_properties_18_0= ruleXProperty )
                            {
                            // InternalTmscXtext.g:2340:7: (lv_properties_18_0= ruleXProperty )
                            // InternalTmscXtext.g:2341:8: lv_properties_18_0= ruleXProperty
                            {
                            if ( state.backtracking==0 ) {

                              								newCompositeNode(grammarAccess.getXDependencyAccess().getPropertiesXPropertyParserRuleCall_2_1_1_4_0());
                              							
                            }
                            pushFollow(FOLLOW_28);
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

                    // InternalTmscXtext.g:2359:5: (otherlv_19= ',' ( (otherlv_20= 'time-bound' otherlv_21= ':' ( (lv_timeBound_22_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_23= 'scheduled' otherlv_24= ':' ( (lv_scheduled_25_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_26= 'request' otherlv_27= ':' ( ( ruleIDString ) ) ) | (otherlv_29= 'message' otherlv_30= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_32_0= ruleXProperty ) ) ) )*
                    loop51:
                    do {
                        int alt51=2;
                        int LA51_0 = input.LA(1);

                        if ( (LA51_0==31) ) {
                            alt51=1;
                        }


                        switch (alt51) {
                    	case 1 :
                    	    // InternalTmscXtext.g:2360:6: otherlv_19= ',' ( (otherlv_20= 'time-bound' otherlv_21= ':' ( (lv_timeBound_22_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_23= 'scheduled' otherlv_24= ':' ( (lv_scheduled_25_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_26= 'request' otherlv_27= ':' ( ( ruleIDString ) ) ) | (otherlv_29= 'message' otherlv_30= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_32_0= ruleXProperty ) ) )
                    	    {
                    	    otherlv_19=(Token)match(input,31,FOLLOW_39); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_19, grammarAccess.getXDependencyAccess().getCommaKeyword_2_1_2_0());
                    	      					
                    	    }
                    	    // InternalTmscXtext.g:2364:6: ( (otherlv_20= 'time-bound' otherlv_21= ':' ( (lv_timeBound_22_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_23= 'scheduled' otherlv_24= ':' ( (lv_scheduled_25_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_26= 'request' otherlv_27= ':' ( ( ruleIDString ) ) ) | (otherlv_29= 'message' otherlv_30= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_32_0= ruleXProperty ) ) )
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
                    	    case 45:
                    	        {
                    	        alt50=4;
                    	        }
                    	        break;
                    	    case RULE_ID:
                    	    case RULE_STRING:
                    	        {
                    	        alt50=5;
                    	        }
                    	        break;
                    	    default:
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        NoViableAltException nvae =
                    	            new NoViableAltException("", 50, 0, input);

                    	        throw nvae;
                    	    }

                    	    switch (alt50) {
                    	        case 1 :
                    	            // InternalTmscXtext.g:2365:7: (otherlv_20= 'time-bound' otherlv_21= ':' ( (lv_timeBound_22_0= RULE_ABS_EBIGDECIMAL ) ) )
                    	            {
                    	            // InternalTmscXtext.g:2365:7: (otherlv_20= 'time-bound' otherlv_21= ':' ( (lv_timeBound_22_0= RULE_ABS_EBIGDECIMAL ) ) )
                    	            // InternalTmscXtext.g:2366:8: otherlv_20= 'time-bound' otherlv_21= ':' ( (lv_timeBound_22_0= RULE_ABS_EBIGDECIMAL ) )
                    	            {
                    	            otherlv_20=(Token)match(input,18,FOLLOW_6); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              								newLeafNode(otherlv_20, grammarAccess.getXDependencyAccess().getTimeBoundKeyword_2_1_2_1_0_0());
                    	              							
                    	            }
                    	            otherlv_21=(Token)match(input,17,FOLLOW_8); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              								newLeafNode(otherlv_21, grammarAccess.getXDependencyAccess().getColonKeyword_2_1_2_1_0_1());
                    	              							
                    	            }
                    	            // InternalTmscXtext.g:2374:8: ( (lv_timeBound_22_0= RULE_ABS_EBIGDECIMAL ) )
                    	            // InternalTmscXtext.g:2375:9: (lv_timeBound_22_0= RULE_ABS_EBIGDECIMAL )
                    	            {
                    	            // InternalTmscXtext.g:2375:9: (lv_timeBound_22_0= RULE_ABS_EBIGDECIMAL )
                    	            // InternalTmscXtext.g:2376:10: lv_timeBound_22_0= RULE_ABS_EBIGDECIMAL
                    	            {
                    	            lv_timeBound_22_0=(Token)match(input,RULE_ABS_EBIGDECIMAL,FOLLOW_28); if (state.failed) return current;
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
                    	            // InternalTmscXtext.g:2394:7: (otherlv_23= 'scheduled' otherlv_24= ':' ( (lv_scheduled_25_0= ruleEBOOLEAN_OBJECT ) ) )
                    	            {
                    	            // InternalTmscXtext.g:2394:7: (otherlv_23= 'scheduled' otherlv_24= ':' ( (lv_scheduled_25_0= ruleEBOOLEAN_OBJECT ) ) )
                    	            // InternalTmscXtext.g:2395:8: otherlv_23= 'scheduled' otherlv_24= ':' ( (lv_scheduled_25_0= ruleEBOOLEAN_OBJECT ) )
                    	            {
                    	            otherlv_23=(Token)match(input,19,FOLLOW_6); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              								newLeafNode(otherlv_23, grammarAccess.getXDependencyAccess().getScheduledKeyword_2_1_2_1_1_0());
                    	              							
                    	            }
                    	            otherlv_24=(Token)match(input,17,FOLLOW_9); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              								newLeafNode(otherlv_24, grammarAccess.getXDependencyAccess().getColonKeyword_2_1_2_1_1_1());
                    	              							
                    	            }
                    	            // InternalTmscXtext.g:2403:8: ( (lv_scheduled_25_0= ruleEBOOLEAN_OBJECT ) )
                    	            // InternalTmscXtext.g:2404:9: (lv_scheduled_25_0= ruleEBOOLEAN_OBJECT )
                    	            {
                    	            // InternalTmscXtext.g:2404:9: (lv_scheduled_25_0= ruleEBOOLEAN_OBJECT )
                    	            // InternalTmscXtext.g:2405:10: lv_scheduled_25_0= ruleEBOOLEAN_OBJECT
                    	            {
                    	            if ( state.backtracking==0 ) {

                    	              										newCompositeNode(grammarAccess.getXDependencyAccess().getScheduledEBOOLEAN_OBJECTParserRuleCall_2_1_2_1_1_2_0());
                    	              									
                    	            }
                    	            pushFollow(FOLLOW_28);
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
                    	            // InternalTmscXtext.g:2424:7: (otherlv_26= 'request' otherlv_27= ':' ( ( ruleIDString ) ) )
                    	            {
                    	            // InternalTmscXtext.g:2424:7: (otherlv_26= 'request' otherlv_27= ':' ( ( ruleIDString ) ) )
                    	            // InternalTmscXtext.g:2425:8: otherlv_26= 'request' otherlv_27= ':' ( ( ruleIDString ) )
                    	            {
                    	            otherlv_26=(Token)match(input,44,FOLLOW_6); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              								newLeafNode(otherlv_26, grammarAccess.getXDependencyAccess().getRequestKeyword_2_1_2_1_2_0());
                    	              							
                    	            }
                    	            otherlv_27=(Token)match(input,17,FOLLOW_18); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              								newLeafNode(otherlv_27, grammarAccess.getXDependencyAccess().getColonKeyword_2_1_2_1_2_1());
                    	              							
                    	            }
                    	            // InternalTmscXtext.g:2433:8: ( ( ruleIDString ) )
                    	            // InternalTmscXtext.g:2434:9: ( ruleIDString )
                    	            {
                    	            // InternalTmscXtext.g:2434:9: ( ruleIDString )
                    	            // InternalTmscXtext.g:2435:10: ruleIDString
                    	            {
                    	            if ( state.backtracking==0 ) {

                    	              										if (current==null) {
                    	              											current = createModelElement(grammarAccess.getXDependencyRule());
                    	              										}
                    	              									
                    	            }
                    	            if ( state.backtracking==0 ) {

                    	              										newCompositeNode(grammarAccess.getXDependencyAccess().getRequestXDependencyCrossReference_2_1_2_1_2_2_0());
                    	              									
                    	            }
                    	            pushFollow(FOLLOW_28);
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
                    	            // InternalTmscXtext.g:2451:7: (otherlv_29= 'message' otherlv_30= ':' ( ( ruleIDString ) ) )
                    	            {
                    	            // InternalTmscXtext.g:2451:7: (otherlv_29= 'message' otherlv_30= ':' ( ( ruleIDString ) ) )
                    	            // InternalTmscXtext.g:2452:8: otherlv_29= 'message' otherlv_30= ':' ( ( ruleIDString ) )
                    	            {
                    	            otherlv_29=(Token)match(input,45,FOLLOW_6); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              								newLeafNode(otherlv_29, grammarAccess.getXDependencyAccess().getMessageKeyword_2_1_2_1_3_0());
                    	              							
                    	            }
                    	            otherlv_30=(Token)match(input,17,FOLLOW_18); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              								newLeafNode(otherlv_30, grammarAccess.getXDependencyAccess().getColonKeyword_2_1_2_1_3_1());
                    	              							
                    	            }
                    	            // InternalTmscXtext.g:2460:8: ( ( ruleIDString ) )
                    	            // InternalTmscXtext.g:2461:9: ( ruleIDString )
                    	            {
                    	            // InternalTmscXtext.g:2461:9: ( ruleIDString )
                    	            // InternalTmscXtext.g:2462:10: ruleIDString
                    	            {
                    	            if ( state.backtracking==0 ) {

                    	              										if (current==null) {
                    	              											current = createModelElement(grammarAccess.getXDependencyRule());
                    	              										}
                    	              									
                    	            }
                    	            if ( state.backtracking==0 ) {

                    	              										newCompositeNode(grammarAccess.getXDependencyAccess().getMessageXDependencyCrossReference_2_1_2_1_3_2_0());
                    	              									
                    	            }
                    	            pushFollow(FOLLOW_28);
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
                    	            // InternalTmscXtext.g:2478:7: ( (lv_properties_32_0= ruleXProperty ) )
                    	            {
                    	            // InternalTmscXtext.g:2478:7: ( (lv_properties_32_0= ruleXProperty ) )
                    	            // InternalTmscXtext.g:2479:8: (lv_properties_32_0= ruleXProperty )
                    	            {
                    	            // InternalTmscXtext.g:2479:8: (lv_properties_32_0= ruleXProperty )
                    	            // InternalTmscXtext.g:2480:9: lv_properties_32_0= ruleXProperty
                    	            {
                    	            if ( state.backtracking==0 ) {

                    	              									newCompositeNode(grammarAccess.getXDependencyAccess().getPropertiesXPropertyParserRuleCall_2_1_2_1_4_0());
                    	              								
                    	            }
                    	            pushFollow(FOLLOW_28);
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
                    	    break loop51;
                        }
                    } while (true);

                    otherlv_33=(Token)match(input,37,FOLLOW_2); if (state.failed) return current;
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
    // InternalTmscXtext.g:2509:1: entryRuleXDependencyTypeObject returns [EObject current=null] : iv_ruleXDependencyTypeObject= ruleXDependencyTypeObject EOF ;
    public final EObject entryRuleXDependencyTypeObject() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXDependencyTypeObject = null;


        try {
            // InternalTmscXtext.g:2509:62: (iv_ruleXDependencyTypeObject= ruleXDependencyTypeObject EOF )
            // InternalTmscXtext.g:2510:2: iv_ruleXDependencyTypeObject= ruleXDependencyTypeObject EOF
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
    // InternalTmscXtext.g:2516:1: ruleXDependencyTypeObject returns [EObject current=null] : ( (lv_value_0_0= ruleXDependencyType ) ) ;
    public final EObject ruleXDependencyTypeObject() throws RecognitionException {
        EObject current = null;

        Enumerator lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalTmscXtext.g:2522:2: ( ( (lv_value_0_0= ruleXDependencyType ) ) )
            // InternalTmscXtext.g:2523:2: ( (lv_value_0_0= ruleXDependencyType ) )
            {
            // InternalTmscXtext.g:2523:2: ( (lv_value_0_0= ruleXDependencyType ) )
            // InternalTmscXtext.g:2524:3: (lv_value_0_0= ruleXDependencyType )
            {
            // InternalTmscXtext.g:2524:3: (lv_value_0_0= ruleXDependencyType )
            // InternalTmscXtext.g:2525:4: lv_value_0_0= ruleXDependencyType
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
    // InternalTmscXtext.g:2545:1: entryRuleXDependencySettings returns [EObject current=null] : iv_ruleXDependencySettings= ruleXDependencySettings EOF ;
    public final EObject entryRuleXDependencySettings() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXDependencySettings = null;


        try {
            // InternalTmscXtext.g:2545:60: (iv_ruleXDependencySettings= ruleXDependencySettings EOF )
            // InternalTmscXtext.g:2546:2: iv_ruleXDependencySettings= ruleXDependencySettings EOF
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
    // InternalTmscXtext.g:2552:1: ruleXDependencySettings returns [EObject current=null] : ( ( (lv_type_0_0= ruleXDependencyType ) ) otherlv_1= 'settings' otherlv_2= '{' ( (otherlv_3= 'time-bound' otherlv_4= ':' ( (lv_timeBound_5_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_6= 'scheduled' otherlv_7= ':' ( (lv_scheduled_8_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_9= 'prefix' otherlv_10= ':' ( (lv_prefix_11_0= ruleIDString ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) )* otherlv_13= '}' ) ;
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
            // InternalTmscXtext.g:2558:2: ( ( ( (lv_type_0_0= ruleXDependencyType ) ) otherlv_1= 'settings' otherlv_2= '{' ( (otherlv_3= 'time-bound' otherlv_4= ':' ( (lv_timeBound_5_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_6= 'scheduled' otherlv_7= ':' ( (lv_scheduled_8_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_9= 'prefix' otherlv_10= ':' ( (lv_prefix_11_0= ruleIDString ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) )* otherlv_13= '}' ) )
            // InternalTmscXtext.g:2559:2: ( ( (lv_type_0_0= ruleXDependencyType ) ) otherlv_1= 'settings' otherlv_2= '{' ( (otherlv_3= 'time-bound' otherlv_4= ':' ( (lv_timeBound_5_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_6= 'scheduled' otherlv_7= ':' ( (lv_scheduled_8_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_9= 'prefix' otherlv_10= ':' ( (lv_prefix_11_0= ruleIDString ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) )* otherlv_13= '}' )
            {
            // InternalTmscXtext.g:2559:2: ( ( (lv_type_0_0= ruleXDependencyType ) ) otherlv_1= 'settings' otherlv_2= '{' ( (otherlv_3= 'time-bound' otherlv_4= ':' ( (lv_timeBound_5_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_6= 'scheduled' otherlv_7= ':' ( (lv_scheduled_8_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_9= 'prefix' otherlv_10= ':' ( (lv_prefix_11_0= ruleIDString ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) )* otherlv_13= '}' )
            // InternalTmscXtext.g:2560:3: ( (lv_type_0_0= ruleXDependencyType ) ) otherlv_1= 'settings' otherlv_2= '{' ( (otherlv_3= 'time-bound' otherlv_4= ':' ( (lv_timeBound_5_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_6= 'scheduled' otherlv_7= ':' ( (lv_scheduled_8_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_9= 'prefix' otherlv_10= ':' ( (lv_prefix_11_0= ruleIDString ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) )* otherlv_13= '}'
            {
            // InternalTmscXtext.g:2560:3: ( (lv_type_0_0= ruleXDependencyType ) )
            // InternalTmscXtext.g:2561:4: (lv_type_0_0= ruleXDependencyType )
            {
            // InternalTmscXtext.g:2561:4: (lv_type_0_0= ruleXDependencyType )
            // InternalTmscXtext.g:2562:5: lv_type_0_0= ruleXDependencyType
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
            otherlv_2=(Token)match(input,15,FOLLOW_40); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getXDependencySettingsAccess().getLeftCurlyBracketKeyword_2());
              		
            }
            // InternalTmscXtext.g:2587:3: ( (otherlv_3= 'time-bound' otherlv_4= ':' ( (lv_timeBound_5_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_6= 'scheduled' otherlv_7= ':' ( (lv_scheduled_8_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_9= 'prefix' otherlv_10= ':' ( (lv_prefix_11_0= ruleIDString ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) )*
            loop53:
            do {
                int alt53=5;
                switch ( input.LA(1) ) {
                case 18:
                    {
                    alt53=1;
                    }
                    break;
                case 19:
                    {
                    alt53=2;
                    }
                    break;
                case 46:
                    {
                    alt53=3;
                    }
                    break;
                case RULE_ID:
                case RULE_STRING:
                    {
                    alt53=4;
                    }
                    break;

                }

                switch (alt53) {
            	case 1 :
            	    // InternalTmscXtext.g:2588:4: (otherlv_3= 'time-bound' otherlv_4= ':' ( (lv_timeBound_5_0= RULE_ABS_EBIGDECIMAL ) ) )
            	    {
            	    // InternalTmscXtext.g:2588:4: (otherlv_3= 'time-bound' otherlv_4= ':' ( (lv_timeBound_5_0= RULE_ABS_EBIGDECIMAL ) ) )
            	    // InternalTmscXtext.g:2589:5: otherlv_3= 'time-bound' otherlv_4= ':' ( (lv_timeBound_5_0= RULE_ABS_EBIGDECIMAL ) )
            	    {
            	    otherlv_3=(Token)match(input,18,FOLLOW_6); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_3, grammarAccess.getXDependencySettingsAccess().getTimeBoundKeyword_3_0_0());
            	      				
            	    }
            	    otherlv_4=(Token)match(input,17,FOLLOW_8); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_4, grammarAccess.getXDependencySettingsAccess().getColonKeyword_3_0_1());
            	      				
            	    }
            	    // InternalTmscXtext.g:2597:5: ( (lv_timeBound_5_0= RULE_ABS_EBIGDECIMAL ) )
            	    // InternalTmscXtext.g:2598:6: (lv_timeBound_5_0= RULE_ABS_EBIGDECIMAL )
            	    {
            	    // InternalTmscXtext.g:2598:6: (lv_timeBound_5_0= RULE_ABS_EBIGDECIMAL )
            	    // InternalTmscXtext.g:2599:7: lv_timeBound_5_0= RULE_ABS_EBIGDECIMAL
            	    {
            	    lv_timeBound_5_0=(Token)match(input,RULE_ABS_EBIGDECIMAL,FOLLOW_40); if (state.failed) return current;
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
            	    // InternalTmscXtext.g:2617:4: (otherlv_6= 'scheduled' otherlv_7= ':' ( (lv_scheduled_8_0= ruleEBOOLEAN_OBJECT ) ) )
            	    {
            	    // InternalTmscXtext.g:2617:4: (otherlv_6= 'scheduled' otherlv_7= ':' ( (lv_scheduled_8_0= ruleEBOOLEAN_OBJECT ) ) )
            	    // InternalTmscXtext.g:2618:5: otherlv_6= 'scheduled' otherlv_7= ':' ( (lv_scheduled_8_0= ruleEBOOLEAN_OBJECT ) )
            	    {
            	    otherlv_6=(Token)match(input,19,FOLLOW_6); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_6, grammarAccess.getXDependencySettingsAccess().getScheduledKeyword_3_1_0());
            	      				
            	    }
            	    otherlv_7=(Token)match(input,17,FOLLOW_9); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_7, grammarAccess.getXDependencySettingsAccess().getColonKeyword_3_1_1());
            	      				
            	    }
            	    // InternalTmscXtext.g:2626:5: ( (lv_scheduled_8_0= ruleEBOOLEAN_OBJECT ) )
            	    // InternalTmscXtext.g:2627:6: (lv_scheduled_8_0= ruleEBOOLEAN_OBJECT )
            	    {
            	    // InternalTmscXtext.g:2627:6: (lv_scheduled_8_0= ruleEBOOLEAN_OBJECT )
            	    // InternalTmscXtext.g:2628:7: lv_scheduled_8_0= ruleEBOOLEAN_OBJECT
            	    {
            	    if ( state.backtracking==0 ) {

            	      							newCompositeNode(grammarAccess.getXDependencySettingsAccess().getScheduledEBOOLEAN_OBJECTParserRuleCall_3_1_2_0());
            	      						
            	    }
            	    pushFollow(FOLLOW_40);
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
            	    // InternalTmscXtext.g:2647:4: (otherlv_9= 'prefix' otherlv_10= ':' ( (lv_prefix_11_0= ruleIDString ) ) )
            	    {
            	    // InternalTmscXtext.g:2647:4: (otherlv_9= 'prefix' otherlv_10= ':' ( (lv_prefix_11_0= ruleIDString ) ) )
            	    // InternalTmscXtext.g:2648:5: otherlv_9= 'prefix' otherlv_10= ':' ( (lv_prefix_11_0= ruleIDString ) )
            	    {
            	    otherlv_9=(Token)match(input,46,FOLLOW_6); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_9, grammarAccess.getXDependencySettingsAccess().getPrefixKeyword_3_2_0());
            	      				
            	    }
            	    otherlv_10=(Token)match(input,17,FOLLOW_18); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_10, grammarAccess.getXDependencySettingsAccess().getColonKeyword_3_2_1());
            	      				
            	    }
            	    // InternalTmscXtext.g:2656:5: ( (lv_prefix_11_0= ruleIDString ) )
            	    // InternalTmscXtext.g:2657:6: (lv_prefix_11_0= ruleIDString )
            	    {
            	    // InternalTmscXtext.g:2657:6: (lv_prefix_11_0= ruleIDString )
            	    // InternalTmscXtext.g:2658:7: lv_prefix_11_0= ruleIDString
            	    {
            	    if ( state.backtracking==0 ) {

            	      							newCompositeNode(grammarAccess.getXDependencySettingsAccess().getPrefixIDStringParserRuleCall_3_2_2_0());
            	      						
            	    }
            	    pushFollow(FOLLOW_40);
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
            	    // InternalTmscXtext.g:2677:4: ( (lv_properties_12_0= ruleXProperty ) )
            	    {
            	    // InternalTmscXtext.g:2677:4: ( (lv_properties_12_0= ruleXProperty ) )
            	    // InternalTmscXtext.g:2678:5: (lv_properties_12_0= ruleXProperty )
            	    {
            	    // InternalTmscXtext.g:2678:5: (lv_properties_12_0= ruleXProperty )
            	    // InternalTmscXtext.g:2679:6: lv_properties_12_0= ruleXProperty
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getXDependencySettingsAccess().getPropertiesXPropertyParserRuleCall_3_3_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_40);
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
            	    break loop53;
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
    // InternalTmscXtext.g:2705:1: entryRuleXProperty returns [EObject current=null] : iv_ruleXProperty= ruleXProperty EOF ;
    public final EObject entryRuleXProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXProperty = null;


        try {
            // InternalTmscXtext.g:2705:50: (iv_ruleXProperty= ruleXProperty EOF )
            // InternalTmscXtext.g:2706:2: iv_ruleXProperty= ruleXProperty EOF
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
    // InternalTmscXtext.g:2712:1: ruleXProperty returns [EObject current=null] : ( ( (lv_name_0_0= ruleIDString ) ) otherlv_1= ':' ( (lv_value_2_0= ruleXPropertyValue ) ) ) ;
    public final EObject ruleXProperty() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalTmscXtext.g:2718:2: ( ( ( (lv_name_0_0= ruleIDString ) ) otherlv_1= ':' ( (lv_value_2_0= ruleXPropertyValue ) ) ) )
            // InternalTmscXtext.g:2719:2: ( ( (lv_name_0_0= ruleIDString ) ) otherlv_1= ':' ( (lv_value_2_0= ruleXPropertyValue ) ) )
            {
            // InternalTmscXtext.g:2719:2: ( ( (lv_name_0_0= ruleIDString ) ) otherlv_1= ':' ( (lv_value_2_0= ruleXPropertyValue ) ) )
            // InternalTmscXtext.g:2720:3: ( (lv_name_0_0= ruleIDString ) ) otherlv_1= ':' ( (lv_value_2_0= ruleXPropertyValue ) )
            {
            // InternalTmscXtext.g:2720:3: ( (lv_name_0_0= ruleIDString ) )
            // InternalTmscXtext.g:2721:4: (lv_name_0_0= ruleIDString )
            {
            // InternalTmscXtext.g:2721:4: (lv_name_0_0= ruleIDString )
            // InternalTmscXtext.g:2722:5: lv_name_0_0= ruleIDString
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

            otherlv_1=(Token)match(input,17,FOLLOW_41); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getXPropertyAccess().getColonKeyword_1());
              		
            }
            // InternalTmscXtext.g:2743:3: ( (lv_value_2_0= ruleXPropertyValue ) )
            // InternalTmscXtext.g:2744:4: (lv_value_2_0= ruleXPropertyValue )
            {
            // InternalTmscXtext.g:2744:4: (lv_value_2_0= ruleXPropertyValue )
            // InternalTmscXtext.g:2745:5: lv_value_2_0= ruleXPropertyValue
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
    // InternalTmscXtext.g:2766:1: entryRuleXPropertyValue returns [EObject current=null] : iv_ruleXPropertyValue= ruleXPropertyValue EOF ;
    public final EObject entryRuleXPropertyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXPropertyValue = null;


        try {
            // InternalTmscXtext.g:2766:55: (iv_ruleXPropertyValue= ruleXPropertyValue EOF )
            // InternalTmscXtext.g:2767:2: iv_ruleXPropertyValue= ruleXPropertyValue EOF
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
    // InternalTmscXtext.g:2773:1: ruleXPropertyValue returns [EObject current=null] : ( ( () ( ( ( ruleIDString ) )=> (lv_value_1_0= ruleIDString ) ) ) | ( () ( ( ( ruleEBIGDECIMAL ) )=> (lv_value_3_0= ruleEBIGDECIMAL ) ) ) | ( () ( ( ( ruleEBOOLEAN_OBJECT ) )=> (lv_value_5_0= ruleEBOOLEAN_OBJECT ) ) ) | ( () ( ( '[' )=>otherlv_7= '[' ) ( (lv_values_8_0= ruleXPropertyValue ) ) (otherlv_9= ',' ( (lv_values_10_0= ruleXPropertyValue ) ) )* otherlv_11= ']' ) ) ;
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
            // InternalTmscXtext.g:2779:2: ( ( ( () ( ( ( ruleIDString ) )=> (lv_value_1_0= ruleIDString ) ) ) | ( () ( ( ( ruleEBIGDECIMAL ) )=> (lv_value_3_0= ruleEBIGDECIMAL ) ) ) | ( () ( ( ( ruleEBOOLEAN_OBJECT ) )=> (lv_value_5_0= ruleEBOOLEAN_OBJECT ) ) ) | ( () ( ( '[' )=>otherlv_7= '[' ) ( (lv_values_8_0= ruleXPropertyValue ) ) (otherlv_9= ',' ( (lv_values_10_0= ruleXPropertyValue ) ) )* otherlv_11= ']' ) ) )
            // InternalTmscXtext.g:2780:2: ( ( () ( ( ( ruleIDString ) )=> (lv_value_1_0= ruleIDString ) ) ) | ( () ( ( ( ruleEBIGDECIMAL ) )=> (lv_value_3_0= ruleEBIGDECIMAL ) ) ) | ( () ( ( ( ruleEBOOLEAN_OBJECT ) )=> (lv_value_5_0= ruleEBOOLEAN_OBJECT ) ) ) | ( () ( ( '[' )=>otherlv_7= '[' ) ( (lv_values_8_0= ruleXPropertyValue ) ) (otherlv_9= ',' ( (lv_values_10_0= ruleXPropertyValue ) ) )* otherlv_11= ']' ) )
            {
            // InternalTmscXtext.g:2780:2: ( ( () ( ( ( ruleIDString ) )=> (lv_value_1_0= ruleIDString ) ) ) | ( () ( ( ( ruleEBIGDECIMAL ) )=> (lv_value_3_0= ruleEBIGDECIMAL ) ) ) | ( () ( ( ( ruleEBOOLEAN_OBJECT ) )=> (lv_value_5_0= ruleEBOOLEAN_OBJECT ) ) ) | ( () ( ( '[' )=>otherlv_7= '[' ) ( (lv_values_8_0= ruleXPropertyValue ) ) (otherlv_9= ',' ( (lv_values_10_0= ruleXPropertyValue ) ) )* otherlv_11= ']' ) )
            int alt55=4;
            switch ( input.LA(1) ) {
            case RULE_ID:
            case RULE_STRING:
                {
                alt55=1;
                }
                break;
            case RULE_ABS_EBIGDECIMAL:
            case RULE_POS_EBIGDECIMAL:
            case RULE_NEG_EBIGDECIMAL:
                {
                alt55=2;
                }
                break;
            case 50:
            case 51:
                {
                alt55=3;
                }
                break;
            case 47:
                {
                alt55=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 55, 0, input);

                throw nvae;
            }

            switch (alt55) {
                case 1 :
                    // InternalTmscXtext.g:2781:3: ( () ( ( ( ruleIDString ) )=> (lv_value_1_0= ruleIDString ) ) )
                    {
                    // InternalTmscXtext.g:2781:3: ( () ( ( ( ruleIDString ) )=> (lv_value_1_0= ruleIDString ) ) )
                    // InternalTmscXtext.g:2782:4: () ( ( ( ruleIDString ) )=> (lv_value_1_0= ruleIDString ) )
                    {
                    // InternalTmscXtext.g:2782:4: ()
                    // InternalTmscXtext.g:2783:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getXPropertyValueAccess().getXPropertyStringValueAction_0_0(),
                      						current);
                      				
                    }

                    }

                    // InternalTmscXtext.g:2789:4: ( ( ( ruleIDString ) )=> (lv_value_1_0= ruleIDString ) )
                    // InternalTmscXtext.g:2790:5: ( ( ruleIDString ) )=> (lv_value_1_0= ruleIDString )
                    {
                    // InternalTmscXtext.g:2794:5: (lv_value_1_0= ruleIDString )
                    // InternalTmscXtext.g:2795:6: lv_value_1_0= ruleIDString
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
                    // InternalTmscXtext.g:2814:3: ( () ( ( ( ruleEBIGDECIMAL ) )=> (lv_value_3_0= ruleEBIGDECIMAL ) ) )
                    {
                    // InternalTmscXtext.g:2814:3: ( () ( ( ( ruleEBIGDECIMAL ) )=> (lv_value_3_0= ruleEBIGDECIMAL ) ) )
                    // InternalTmscXtext.g:2815:4: () ( ( ( ruleEBIGDECIMAL ) )=> (lv_value_3_0= ruleEBIGDECIMAL ) )
                    {
                    // InternalTmscXtext.g:2815:4: ()
                    // InternalTmscXtext.g:2816:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getXPropertyValueAccess().getXPropertyNumberValueAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalTmscXtext.g:2822:4: ( ( ( ruleEBIGDECIMAL ) )=> (lv_value_3_0= ruleEBIGDECIMAL ) )
                    // InternalTmscXtext.g:2823:5: ( ( ruleEBIGDECIMAL ) )=> (lv_value_3_0= ruleEBIGDECIMAL )
                    {
                    // InternalTmscXtext.g:2827:5: (lv_value_3_0= ruleEBIGDECIMAL )
                    // InternalTmscXtext.g:2828:6: lv_value_3_0= ruleEBIGDECIMAL
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
                    // InternalTmscXtext.g:2847:3: ( () ( ( ( ruleEBOOLEAN_OBJECT ) )=> (lv_value_5_0= ruleEBOOLEAN_OBJECT ) ) )
                    {
                    // InternalTmscXtext.g:2847:3: ( () ( ( ( ruleEBOOLEAN_OBJECT ) )=> (lv_value_5_0= ruleEBOOLEAN_OBJECT ) ) )
                    // InternalTmscXtext.g:2848:4: () ( ( ( ruleEBOOLEAN_OBJECT ) )=> (lv_value_5_0= ruleEBOOLEAN_OBJECT ) )
                    {
                    // InternalTmscXtext.g:2848:4: ()
                    // InternalTmscXtext.g:2849:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getXPropertyValueAccess().getXPropertyBooleanValueAction_2_0(),
                      						current);
                      				
                    }

                    }

                    // InternalTmscXtext.g:2855:4: ( ( ( ruleEBOOLEAN_OBJECT ) )=> (lv_value_5_0= ruleEBOOLEAN_OBJECT ) )
                    // InternalTmscXtext.g:2856:5: ( ( ruleEBOOLEAN_OBJECT ) )=> (lv_value_5_0= ruleEBOOLEAN_OBJECT )
                    {
                    // InternalTmscXtext.g:2860:5: (lv_value_5_0= ruleEBOOLEAN_OBJECT )
                    // InternalTmscXtext.g:2861:6: lv_value_5_0= ruleEBOOLEAN_OBJECT
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
                    // InternalTmscXtext.g:2880:3: ( () ( ( '[' )=>otherlv_7= '[' ) ( (lv_values_8_0= ruleXPropertyValue ) ) (otherlv_9= ',' ( (lv_values_10_0= ruleXPropertyValue ) ) )* otherlv_11= ']' )
                    {
                    // InternalTmscXtext.g:2880:3: ( () ( ( '[' )=>otherlv_7= '[' ) ( (lv_values_8_0= ruleXPropertyValue ) ) (otherlv_9= ',' ( (lv_values_10_0= ruleXPropertyValue ) ) )* otherlv_11= ']' )
                    // InternalTmscXtext.g:2881:4: () ( ( '[' )=>otherlv_7= '[' ) ( (lv_values_8_0= ruleXPropertyValue ) ) (otherlv_9= ',' ( (lv_values_10_0= ruleXPropertyValue ) ) )* otherlv_11= ']'
                    {
                    // InternalTmscXtext.g:2881:4: ()
                    // InternalTmscXtext.g:2882:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getXPropertyValueAccess().getXPropertyMutliValueAction_3_0(),
                      						current);
                      				
                    }

                    }

                    // InternalTmscXtext.g:2888:4: ( ( '[' )=>otherlv_7= '[' )
                    // InternalTmscXtext.g:2889:5: ( '[' )=>otherlv_7= '['
                    {
                    otherlv_7=(Token)match(input,47,FOLLOW_41); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_7, grammarAccess.getXPropertyValueAccess().getLeftSquareBracketKeyword_3_1());
                      				
                    }

                    }

                    // InternalTmscXtext.g:2895:4: ( (lv_values_8_0= ruleXPropertyValue ) )
                    // InternalTmscXtext.g:2896:5: (lv_values_8_0= ruleXPropertyValue )
                    {
                    // InternalTmscXtext.g:2896:5: (lv_values_8_0= ruleXPropertyValue )
                    // InternalTmscXtext.g:2897:6: lv_values_8_0= ruleXPropertyValue
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getXPropertyValueAccess().getValuesXPropertyValueParserRuleCall_3_2_0());
                      					
                    }
                    pushFollow(FOLLOW_42);
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

                    // InternalTmscXtext.g:2914:4: (otherlv_9= ',' ( (lv_values_10_0= ruleXPropertyValue ) ) )*
                    loop54:
                    do {
                        int alt54=2;
                        int LA54_0 = input.LA(1);

                        if ( (LA54_0==31) ) {
                            alt54=1;
                        }


                        switch (alt54) {
                    	case 1 :
                    	    // InternalTmscXtext.g:2915:5: otherlv_9= ',' ( (lv_values_10_0= ruleXPropertyValue ) )
                    	    {
                    	    otherlv_9=(Token)match(input,31,FOLLOW_41); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_9, grammarAccess.getXPropertyValueAccess().getCommaKeyword_3_3_0());
                    	      				
                    	    }
                    	    // InternalTmscXtext.g:2919:5: ( (lv_values_10_0= ruleXPropertyValue ) )
                    	    // InternalTmscXtext.g:2920:6: (lv_values_10_0= ruleXPropertyValue )
                    	    {
                    	    // InternalTmscXtext.g:2920:6: (lv_values_10_0= ruleXPropertyValue )
                    	    // InternalTmscXtext.g:2921:7: lv_values_10_0= ruleXPropertyValue
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getXPropertyValueAccess().getValuesXPropertyValueParserRuleCall_3_3_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_42);
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
                    	    break loop54;
                        }
                    } while (true);

                    otherlv_11=(Token)match(input,48,FOLLOW_2); if (state.failed) return current;
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
    // InternalTmscXtext.g:2948:1: entryRuleFQNString returns [String current=null] : iv_ruleFQNString= ruleFQNString EOF ;
    public final String entryRuleFQNString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQNString = null;


        try {
            // InternalTmscXtext.g:2948:49: (iv_ruleFQNString= ruleFQNString EOF )
            // InternalTmscXtext.g:2949:2: iv_ruleFQNString= ruleFQNString EOF
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
    // InternalTmscXtext.g:2955:1: ruleFQNString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_FQN_0= ruleFQN | this_STRING_1= RULE_STRING ) ;
    public final AntlrDatatypeRuleToken ruleFQNString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_1=null;
        AntlrDatatypeRuleToken this_FQN_0 = null;



        	enterRule();

        try {
            // InternalTmscXtext.g:2961:2: ( (this_FQN_0= ruleFQN | this_STRING_1= RULE_STRING ) )
            // InternalTmscXtext.g:2962:2: (this_FQN_0= ruleFQN | this_STRING_1= RULE_STRING )
            {
            // InternalTmscXtext.g:2962:2: (this_FQN_0= ruleFQN | this_STRING_1= RULE_STRING )
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==RULE_ID) ) {
                alt56=1;
            }
            else if ( (LA56_0==RULE_STRING) ) {
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
                    // InternalTmscXtext.g:2963:3: this_FQN_0= ruleFQN
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
                    // InternalTmscXtext.g:2974:3: this_STRING_1= RULE_STRING
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
    // InternalTmscXtext.g:2985:1: entryRuleIDString returns [String current=null] : iv_ruleIDString= ruleIDString EOF ;
    public final String entryRuleIDString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIDString = null;


        try {
            // InternalTmscXtext.g:2985:48: (iv_ruleIDString= ruleIDString EOF )
            // InternalTmscXtext.g:2986:2: iv_ruleIDString= ruleIDString EOF
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
    // InternalTmscXtext.g:2992:1: ruleIDString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | this_STRING_1= RULE_STRING ) ;
    public final AntlrDatatypeRuleToken ruleIDString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token this_STRING_1=null;


        	enterRule();

        try {
            // InternalTmscXtext.g:2998:2: ( (this_ID_0= RULE_ID | this_STRING_1= RULE_STRING ) )
            // InternalTmscXtext.g:2999:2: (this_ID_0= RULE_ID | this_STRING_1= RULE_STRING )
            {
            // InternalTmscXtext.g:2999:2: (this_ID_0= RULE_ID | this_STRING_1= RULE_STRING )
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==RULE_ID) ) {
                alt57=1;
            }
            else if ( (LA57_0==RULE_STRING) ) {
                alt57=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 57, 0, input);

                throw nvae;
            }
            switch (alt57) {
                case 1 :
                    // InternalTmscXtext.g:3000:3: this_ID_0= RULE_ID
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
                    // InternalTmscXtext.g:3008:3: this_STRING_1= RULE_STRING
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
    // InternalTmscXtext.g:3019:1: entryRuleFQN returns [String current=null] : iv_ruleFQN= ruleFQN EOF ;
    public final String entryRuleFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQN = null;


        try {
            // InternalTmscXtext.g:3019:43: (iv_ruleFQN= ruleFQN EOF )
            // InternalTmscXtext.g:3020:2: iv_ruleFQN= ruleFQN EOF
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
    // InternalTmscXtext.g:3026:1: ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalTmscXtext.g:3032:2: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalTmscXtext.g:3033:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalTmscXtext.g:3033:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalTmscXtext.g:3034:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_43); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_ID_0);
              		
            }
            if ( state.backtracking==0 ) {

              			newLeafNode(this_ID_0, grammarAccess.getFQNAccess().getIDTerminalRuleCall_0());
              		
            }
            // InternalTmscXtext.g:3041:3: (kw= '.' this_ID_2= RULE_ID )*
            loop58:
            do {
                int alt58=2;
                int LA58_0 = input.LA(1);

                if ( (LA58_0==49) ) {
                    alt58=1;
                }


                switch (alt58) {
            	case 1 :
            	    // InternalTmscXtext.g:3042:4: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,49,FOLLOW_20); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				current.merge(kw);
            	      				newLeafNode(kw, grammarAccess.getFQNAccess().getFullStopKeyword_1_0());
            	      			
            	    }
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_43); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				current.merge(this_ID_2);
            	      			
            	    }
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(this_ID_2, grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1());
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop58;
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
    // InternalTmscXtext.g:3059:1: entryRuleEBOOLEAN_OBJECT returns [String current=null] : iv_ruleEBOOLEAN_OBJECT= ruleEBOOLEAN_OBJECT EOF ;
    public final String entryRuleEBOOLEAN_OBJECT() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEBOOLEAN_OBJECT = null;


        try {
            // InternalTmscXtext.g:3059:55: (iv_ruleEBOOLEAN_OBJECT= ruleEBOOLEAN_OBJECT EOF )
            // InternalTmscXtext.g:3060:2: iv_ruleEBOOLEAN_OBJECT= ruleEBOOLEAN_OBJECT EOF
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
    // InternalTmscXtext.g:3066:1: ruleEBOOLEAN_OBJECT returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'true' | kw= 'false' ) ;
    public final AntlrDatatypeRuleToken ruleEBOOLEAN_OBJECT() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalTmscXtext.g:3072:2: ( (kw= 'true' | kw= 'false' ) )
            // InternalTmscXtext.g:3073:2: (kw= 'true' | kw= 'false' )
            {
            // InternalTmscXtext.g:3073:2: (kw= 'true' | kw= 'false' )
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==50) ) {
                alt59=1;
            }
            else if ( (LA59_0==51) ) {
                alt59=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 59, 0, input);

                throw nvae;
            }
            switch (alt59) {
                case 1 :
                    // InternalTmscXtext.g:3074:3: kw= 'true'
                    {
                    kw=(Token)match(input,50,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getEBOOLEAN_OBJECTAccess().getTrueKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalTmscXtext.g:3080:3: kw= 'false'
                    {
                    kw=(Token)match(input,51,FOLLOW_2); if (state.failed) return current;
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
    // InternalTmscXtext.g:3089:1: entryRuleEBIGDECIMAL returns [String current=null] : iv_ruleEBIGDECIMAL= ruleEBIGDECIMAL EOF ;
    public final String entryRuleEBIGDECIMAL() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEBIGDECIMAL = null;


        try {
            // InternalTmscXtext.g:3089:51: (iv_ruleEBIGDECIMAL= ruleEBIGDECIMAL EOF )
            // InternalTmscXtext.g:3090:2: iv_ruleEBIGDECIMAL= ruleEBIGDECIMAL EOF
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
    // InternalTmscXtext.g:3096:1: ruleEBIGDECIMAL returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ABS_EBIGDECIMAL_0= RULE_ABS_EBIGDECIMAL | this_POS_EBIGDECIMAL_1= RULE_POS_EBIGDECIMAL | this_NEG_EBIGDECIMAL_2= RULE_NEG_EBIGDECIMAL ) ;
    public final AntlrDatatypeRuleToken ruleEBIGDECIMAL() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ABS_EBIGDECIMAL_0=null;
        Token this_POS_EBIGDECIMAL_1=null;
        Token this_NEG_EBIGDECIMAL_2=null;


        	enterRule();

        try {
            // InternalTmscXtext.g:3102:2: ( (this_ABS_EBIGDECIMAL_0= RULE_ABS_EBIGDECIMAL | this_POS_EBIGDECIMAL_1= RULE_POS_EBIGDECIMAL | this_NEG_EBIGDECIMAL_2= RULE_NEG_EBIGDECIMAL ) )
            // InternalTmscXtext.g:3103:2: (this_ABS_EBIGDECIMAL_0= RULE_ABS_EBIGDECIMAL | this_POS_EBIGDECIMAL_1= RULE_POS_EBIGDECIMAL | this_NEG_EBIGDECIMAL_2= RULE_NEG_EBIGDECIMAL )
            {
            // InternalTmscXtext.g:3103:2: (this_ABS_EBIGDECIMAL_0= RULE_ABS_EBIGDECIMAL | this_POS_EBIGDECIMAL_1= RULE_POS_EBIGDECIMAL | this_NEG_EBIGDECIMAL_2= RULE_NEG_EBIGDECIMAL )
            int alt60=3;
            switch ( input.LA(1) ) {
            case RULE_ABS_EBIGDECIMAL:
                {
                alt60=1;
                }
                break;
            case RULE_POS_EBIGDECIMAL:
                {
                alt60=2;
                }
                break;
            case RULE_NEG_EBIGDECIMAL:
                {
                alt60=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 60, 0, input);

                throw nvae;
            }

            switch (alt60) {
                case 1 :
                    // InternalTmscXtext.g:3104:3: this_ABS_EBIGDECIMAL_0= RULE_ABS_EBIGDECIMAL
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
                    // InternalTmscXtext.g:3112:3: this_POS_EBIGDECIMAL_1= RULE_POS_EBIGDECIMAL
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
                    // InternalTmscXtext.g:3120:3: this_NEG_EBIGDECIMAL_2= RULE_NEG_EBIGDECIMAL
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
    // InternalTmscXtext.g:3131:1: ruleXArchitectureKind returns [Enumerator current=null] : ( (enumLiteral_0= 'internal' ) | (enumLiteral_1= 'external' ) ) ;
    public final Enumerator ruleXArchitectureKind() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalTmscXtext.g:3137:2: ( ( (enumLiteral_0= 'internal' ) | (enumLiteral_1= 'external' ) ) )
            // InternalTmscXtext.g:3138:2: ( (enumLiteral_0= 'internal' ) | (enumLiteral_1= 'external' ) )
            {
            // InternalTmscXtext.g:3138:2: ( (enumLiteral_0= 'internal' ) | (enumLiteral_1= 'external' ) )
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==52) ) {
                alt61=1;
            }
            else if ( (LA61_0==53) ) {
                alt61=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 61, 0, input);

                throw nvae;
            }
            switch (alt61) {
                case 1 :
                    // InternalTmscXtext.g:3139:3: (enumLiteral_0= 'internal' )
                    {
                    // InternalTmscXtext.g:3139:3: (enumLiteral_0= 'internal' )
                    // InternalTmscXtext.g:3140:4: enumLiteral_0= 'internal'
                    {
                    enumLiteral_0=(Token)match(input,52,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getXArchitectureKindAccess().getINTERNALEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getXArchitectureKindAccess().getINTERNALEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalTmscXtext.g:3147:3: (enumLiteral_1= 'external' )
                    {
                    // InternalTmscXtext.g:3147:3: (enumLiteral_1= 'external' )
                    // InternalTmscXtext.g:3148:4: enumLiteral_1= 'external'
                    {
                    enumLiteral_1=(Token)match(input,53,FOLLOW_2); if (state.failed) return current;
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
    // InternalTmscXtext.g:3158:1: ruleXFunctionParameterKind returns [Enumerator current=null] : ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'out' ) | (enumLiteral_2= 'inout' ) | (enumLiteral_3= 'return' ) ) ;
    public final Enumerator ruleXFunctionParameterKind() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalTmscXtext.g:3164:2: ( ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'out' ) | (enumLiteral_2= 'inout' ) | (enumLiteral_3= 'return' ) ) )
            // InternalTmscXtext.g:3165:2: ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'out' ) | (enumLiteral_2= 'inout' ) | (enumLiteral_3= 'return' ) )
            {
            // InternalTmscXtext.g:3165:2: ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'out' ) | (enumLiteral_2= 'inout' ) | (enumLiteral_3= 'return' ) )
            int alt62=4;
            switch ( input.LA(1) ) {
            case 54:
                {
                alt62=1;
                }
                break;
            case 55:
                {
                alt62=2;
                }
                break;
            case 56:
                {
                alt62=3;
                }
                break;
            case 57:
                {
                alt62=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 62, 0, input);

                throw nvae;
            }

            switch (alt62) {
                case 1 :
                    // InternalTmscXtext.g:3166:3: (enumLiteral_0= 'in' )
                    {
                    // InternalTmscXtext.g:3166:3: (enumLiteral_0= 'in' )
                    // InternalTmscXtext.g:3167:4: enumLiteral_0= 'in'
                    {
                    enumLiteral_0=(Token)match(input,54,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getXFunctionParameterKindAccess().getINEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getXFunctionParameterKindAccess().getINEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalTmscXtext.g:3174:3: (enumLiteral_1= 'out' )
                    {
                    // InternalTmscXtext.g:3174:3: (enumLiteral_1= 'out' )
                    // InternalTmscXtext.g:3175:4: enumLiteral_1= 'out'
                    {
                    enumLiteral_1=(Token)match(input,55,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getXFunctionParameterKindAccess().getOUTEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getXFunctionParameterKindAccess().getOUTEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalTmscXtext.g:3182:3: (enumLiteral_2= 'inout' )
                    {
                    // InternalTmscXtext.g:3182:3: (enumLiteral_2= 'inout' )
                    // InternalTmscXtext.g:3183:4: enumLiteral_2= 'inout'
                    {
                    enumLiteral_2=(Token)match(input,56,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getXFunctionParameterKindAccess().getIN_OUTEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getXFunctionParameterKindAccess().getIN_OUTEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalTmscXtext.g:3190:3: (enumLiteral_3= 'return' )
                    {
                    // InternalTmscXtext.g:3190:3: (enumLiteral_3= 'return' )
                    // InternalTmscXtext.g:3191:4: enumLiteral_3= 'return'
                    {
                    enumLiteral_3=(Token)match(input,57,FOLLOW_2); if (state.failed) return current;
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
    // InternalTmscXtext.g:3201:1: ruleXEventType returns [Enumerator current=null] : ( (enumLiteral_0= '>' ) | (enumLiteral_1= '<' ) ) ;
    public final Enumerator ruleXEventType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalTmscXtext.g:3207:2: ( ( (enumLiteral_0= '>' ) | (enumLiteral_1= '<' ) ) )
            // InternalTmscXtext.g:3208:2: ( (enumLiteral_0= '>' ) | (enumLiteral_1= '<' ) )
            {
            // InternalTmscXtext.g:3208:2: ( (enumLiteral_0= '>' ) | (enumLiteral_1= '<' ) )
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==58) ) {
                alt63=1;
            }
            else if ( (LA63_0==59) ) {
                alt63=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 63, 0, input);

                throw nvae;
            }
            switch (alt63) {
                case 1 :
                    // InternalTmscXtext.g:3209:3: (enumLiteral_0= '>' )
                    {
                    // InternalTmscXtext.g:3209:3: (enumLiteral_0= '>' )
                    // InternalTmscXtext.g:3210:4: enumLiteral_0= '>'
                    {
                    enumLiteral_0=(Token)match(input,58,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getXEventTypeAccess().getENTRYEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getXEventTypeAccess().getENTRYEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalTmscXtext.g:3217:3: (enumLiteral_1= '<' )
                    {
                    // InternalTmscXtext.g:3217:3: (enumLiteral_1= '<' )
                    // InternalTmscXtext.g:3218:4: enumLiteral_1= '<'
                    {
                    enumLiteral_1=(Token)match(input,59,FOLLOW_2); if (state.failed) return current;
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
    // InternalTmscXtext.g:3228:1: ruleXDependencyType returns [Enumerator current=null] : ( (enumLiteral_0= 'message' ) | (enumLiteral_1= 'request' ) | (enumLiteral_2= 'reply' ) | (enumLiteral_3= 'domain-dependency' ) | (enumLiteral_4= 'lifeline-segment' ) | (enumLiteral_5= 'message-control' ) ) ;
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
            // InternalTmscXtext.g:3234:2: ( ( (enumLiteral_0= 'message' ) | (enumLiteral_1= 'request' ) | (enumLiteral_2= 'reply' ) | (enumLiteral_3= 'domain-dependency' ) | (enumLiteral_4= 'lifeline-segment' ) | (enumLiteral_5= 'message-control' ) ) )
            // InternalTmscXtext.g:3235:2: ( (enumLiteral_0= 'message' ) | (enumLiteral_1= 'request' ) | (enumLiteral_2= 'reply' ) | (enumLiteral_3= 'domain-dependency' ) | (enumLiteral_4= 'lifeline-segment' ) | (enumLiteral_5= 'message-control' ) )
            {
            // InternalTmscXtext.g:3235:2: ( (enumLiteral_0= 'message' ) | (enumLiteral_1= 'request' ) | (enumLiteral_2= 'reply' ) | (enumLiteral_3= 'domain-dependency' ) | (enumLiteral_4= 'lifeline-segment' ) | (enumLiteral_5= 'message-control' ) )
            int alt64=6;
            switch ( input.LA(1) ) {
            case 45:
                {
                alt64=1;
                }
                break;
            case 44:
                {
                alt64=2;
                }
                break;
            case 60:
                {
                alt64=3;
                }
                break;
            case 61:
                {
                alt64=4;
                }
                break;
            case 62:
                {
                alt64=5;
                }
                break;
            case 63:
                {
                alt64=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 64, 0, input);

                throw nvae;
            }

            switch (alt64) {
                case 1 :
                    // InternalTmscXtext.g:3236:3: (enumLiteral_0= 'message' )
                    {
                    // InternalTmscXtext.g:3236:3: (enumLiteral_0= 'message' )
                    // InternalTmscXtext.g:3237:4: enumLiteral_0= 'message'
                    {
                    enumLiteral_0=(Token)match(input,45,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getXDependencyTypeAccess().getMESSAGEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getXDependencyTypeAccess().getMESSAGEEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalTmscXtext.g:3244:3: (enumLiteral_1= 'request' )
                    {
                    // InternalTmscXtext.g:3244:3: (enumLiteral_1= 'request' )
                    // InternalTmscXtext.g:3245:4: enumLiteral_1= 'request'
                    {
                    enumLiteral_1=(Token)match(input,44,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getXDependencyTypeAccess().getREQUESTEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getXDependencyTypeAccess().getREQUESTEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalTmscXtext.g:3252:3: (enumLiteral_2= 'reply' )
                    {
                    // InternalTmscXtext.g:3252:3: (enumLiteral_2= 'reply' )
                    // InternalTmscXtext.g:3253:4: enumLiteral_2= 'reply'
                    {
                    enumLiteral_2=(Token)match(input,60,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getXDependencyTypeAccess().getREPLYEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getXDependencyTypeAccess().getREPLYEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalTmscXtext.g:3260:3: (enumLiteral_3= 'domain-dependency' )
                    {
                    // InternalTmscXtext.g:3260:3: (enumLiteral_3= 'domain-dependency' )
                    // InternalTmscXtext.g:3261:4: enumLiteral_3= 'domain-dependency'
                    {
                    enumLiteral_3=(Token)match(input,61,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getXDependencyTypeAccess().getDOMAINEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_3, grammarAccess.getXDependencyTypeAccess().getDOMAINEnumLiteralDeclaration_3());
                      			
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalTmscXtext.g:3268:3: (enumLiteral_4= 'lifeline-segment' )
                    {
                    // InternalTmscXtext.g:3268:3: (enumLiteral_4= 'lifeline-segment' )
                    // InternalTmscXtext.g:3269:4: enumLiteral_4= 'lifeline-segment'
                    {
                    enumLiteral_4=(Token)match(input,62,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getXDependencyTypeAccess().getLIFELINE_SEGMENTEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_4, grammarAccess.getXDependencyTypeAccess().getLIFELINE_SEGMENTEnumLiteralDeclaration_4());
                      			
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalTmscXtext.g:3276:3: (enumLiteral_5= 'message-control' )
                    {
                    // InternalTmscXtext.g:3276:3: (enumLiteral_5= 'message-control' )
                    // InternalTmscXtext.g:3277:4: enumLiteral_5= 'message-control'
                    {
                    enumLiteral_5=(Token)match(input,63,FOLLOW_2); if (state.failed) return current;
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
    static final String dfa_3s = "\1\4\1\uffff\1\16\4\uffff\1\50\5\uffff";
    static final String dfa_4s = "\1\77\1\uffff\1\25\4\uffff\1\51\5\uffff";
    static final String dfa_5s = "\1\uffff\1\12\1\uffff\1\3\1\4\1\5\1\6\1\uffff\1\7\1\10\1\11\1\1\1\2";
    static final String dfa_6s = "\15\uffff}>";
    static final String[] dfa_7s = {
            "\5\12\4\uffff\1\2\14\uffff\1\4\2\uffff\1\5\3\uffff\3\6\3\uffff\1\7\1\10\1\11\2\uffff\2\3\16\uffff\4\3",
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
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0030000000000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x000C000000000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0xF000338E240021F2L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000001500000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000900000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000002100000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000000290L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x00000000000D0120L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x00000000101D0120L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000140008002L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000180008002L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000080008002L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000005000008002L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x03C0000000000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000002080000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000004000008002L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x00000280001D0120L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0xFC00338E240D21F0L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x00000C1000008002L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x00000C0000008002L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0xF0003000000D0120L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x00003000000D0120L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x00004000001D0120L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x000C8000000D03B0L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0001000080000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0002000000000002L});

}