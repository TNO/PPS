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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ABS_EBIGDECIMAL", "RULE_ISO8601", "RULE_ID", "RULE_POS_EBIGDECIMAL", "RULE_STRING", "RULE_NEG_EBIGDECIMAL", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "'tmsc'", "'settings'", "'{'", "'architecture'", "':'", "'time-bound'", "'scheduled'", "'start-time'", "'end-time'", "'}'", "'analyses'", "'time-bound-analysis'", "'defaultTimeBound'", "'time-shift'", "'delta'", "'interface'", "'as'", "'operation'", "'component'", "'provides'", "','", "'requires'", "'ipc-client'", "'ipc-server'", "'function'", "'('", "')'", "'implements'", "'untraced'", "'host'", "'executor'", "'!'", "'?'", "'request'", "'message'", "'prefix'", "'['", "']'", "'.'", "'true'", "'false'", "'internal'", "'external'", "'in'", "'out'", "'inout'", "'return'", "'>'", "'<'", "'reply'", "'domain-dependency'", "'lifeline-segment'", "'message-control'"
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
    public static final int RULE_ID=6;
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
    public static final int T__64=64;
    public static final int T__21=21;
    public static final int T__65=65;
    public static final int RULE_ISO8601=5;
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
    // InternalTmscXtext.g:72:1: ruleTmscXtextModel returns [EObject current=null] : ( () ( (otherlv_1= 'tmsc' otherlv_2= 'settings' otherlv_3= '{' ( (otherlv_4= 'architecture' otherlv_5= ':' ( (lv_architectureKind_6_0= ruleXArchitectureKind ) ) ) | (otherlv_7= 'time-bound' otherlv_8= ':' ( (lv_timeBound_9_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_10= 'scheduled' otherlv_11= ':' ( (lv_scheduled_12_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_13= 'start-time' otherlv_14= ':' ( ( (lv_startTime_15_1= RULE_ISO8601 | lv_startTime_15_2= RULE_ABS_EBIGDECIMAL ) ) ) ) | (otherlv_16= 'end-time' otherlv_17= ':' ( ( (lv_endTime_18_1= RULE_ISO8601 | lv_endTime_18_2= RULE_ABS_EBIGDECIMAL ) ) ) ) | ( (lv_properties_19_0= ruleXProperty ) ) )* otherlv_20= '}' ) | (otherlv_21= 'tmsc' otherlv_22= 'analyses' otherlv_23= '{' ( (lv_analyses_24_0= ruleXTmscAnalysis ) )* otherlv_25= '}' ) | ( (lv_dependencySettings_26_0= ruleXDependencySettings ) ) | ( (lv_interfaces_27_0= ruleXInterface ) ) | ( (lv_components_28_0= ruleXComponent ) ) | ( (lv_functions_29_0= ruleXFunction ) ) | ( (lv_hosts_30_0= ruleXHost ) ) | ( (lv_executors_31_0= ruleXExecutor ) ) | ( (lv_events_32_0= ruleXEvent ) ) )* ) ;
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
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token lv_startTime_15_1=null;
        Token lv_startTime_15_2=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token lv_endTime_18_1=null;
        Token lv_endTime_18_2=null;
        Token otherlv_20=null;
        Token otherlv_21=null;
        Token otherlv_22=null;
        Token otherlv_23=null;
        Token otherlv_25=null;
        Enumerator lv_architectureKind_6_0 = null;

        AntlrDatatypeRuleToken lv_scheduled_12_0 = null;

        EObject lv_properties_19_0 = null;

        EObject lv_analyses_24_0 = null;

        EObject lv_dependencySettings_26_0 = null;

        EObject lv_interfaces_27_0 = null;

        EObject lv_components_28_0 = null;

        EObject lv_functions_29_0 = null;

        EObject lv_hosts_30_0 = null;

        EObject lv_executors_31_0 = null;

        EObject lv_events_32_0 = null;



        	enterRule();

        try {
            // InternalTmscXtext.g:78:2: ( ( () ( (otherlv_1= 'tmsc' otherlv_2= 'settings' otherlv_3= '{' ( (otherlv_4= 'architecture' otherlv_5= ':' ( (lv_architectureKind_6_0= ruleXArchitectureKind ) ) ) | (otherlv_7= 'time-bound' otherlv_8= ':' ( (lv_timeBound_9_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_10= 'scheduled' otherlv_11= ':' ( (lv_scheduled_12_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_13= 'start-time' otherlv_14= ':' ( ( (lv_startTime_15_1= RULE_ISO8601 | lv_startTime_15_2= RULE_ABS_EBIGDECIMAL ) ) ) ) | (otherlv_16= 'end-time' otherlv_17= ':' ( ( (lv_endTime_18_1= RULE_ISO8601 | lv_endTime_18_2= RULE_ABS_EBIGDECIMAL ) ) ) ) | ( (lv_properties_19_0= ruleXProperty ) ) )* otherlv_20= '}' ) | (otherlv_21= 'tmsc' otherlv_22= 'analyses' otherlv_23= '{' ( (lv_analyses_24_0= ruleXTmscAnalysis ) )* otherlv_25= '}' ) | ( (lv_dependencySettings_26_0= ruleXDependencySettings ) ) | ( (lv_interfaces_27_0= ruleXInterface ) ) | ( (lv_components_28_0= ruleXComponent ) ) | ( (lv_functions_29_0= ruleXFunction ) ) | ( (lv_hosts_30_0= ruleXHost ) ) | ( (lv_executors_31_0= ruleXExecutor ) ) | ( (lv_events_32_0= ruleXEvent ) ) )* ) )
            // InternalTmscXtext.g:79:2: ( () ( (otherlv_1= 'tmsc' otherlv_2= 'settings' otherlv_3= '{' ( (otherlv_4= 'architecture' otherlv_5= ':' ( (lv_architectureKind_6_0= ruleXArchitectureKind ) ) ) | (otherlv_7= 'time-bound' otherlv_8= ':' ( (lv_timeBound_9_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_10= 'scheduled' otherlv_11= ':' ( (lv_scheduled_12_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_13= 'start-time' otherlv_14= ':' ( ( (lv_startTime_15_1= RULE_ISO8601 | lv_startTime_15_2= RULE_ABS_EBIGDECIMAL ) ) ) ) | (otherlv_16= 'end-time' otherlv_17= ':' ( ( (lv_endTime_18_1= RULE_ISO8601 | lv_endTime_18_2= RULE_ABS_EBIGDECIMAL ) ) ) ) | ( (lv_properties_19_0= ruleXProperty ) ) )* otherlv_20= '}' ) | (otherlv_21= 'tmsc' otherlv_22= 'analyses' otherlv_23= '{' ( (lv_analyses_24_0= ruleXTmscAnalysis ) )* otherlv_25= '}' ) | ( (lv_dependencySettings_26_0= ruleXDependencySettings ) ) | ( (lv_interfaces_27_0= ruleXInterface ) ) | ( (lv_components_28_0= ruleXComponent ) ) | ( (lv_functions_29_0= ruleXFunction ) ) | ( (lv_hosts_30_0= ruleXHost ) ) | ( (lv_executors_31_0= ruleXExecutor ) ) | ( (lv_events_32_0= ruleXEvent ) ) )* )
            {
            // InternalTmscXtext.g:79:2: ( () ( (otherlv_1= 'tmsc' otherlv_2= 'settings' otherlv_3= '{' ( (otherlv_4= 'architecture' otherlv_5= ':' ( (lv_architectureKind_6_0= ruleXArchitectureKind ) ) ) | (otherlv_7= 'time-bound' otherlv_8= ':' ( (lv_timeBound_9_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_10= 'scheduled' otherlv_11= ':' ( (lv_scheduled_12_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_13= 'start-time' otherlv_14= ':' ( ( (lv_startTime_15_1= RULE_ISO8601 | lv_startTime_15_2= RULE_ABS_EBIGDECIMAL ) ) ) ) | (otherlv_16= 'end-time' otherlv_17= ':' ( ( (lv_endTime_18_1= RULE_ISO8601 | lv_endTime_18_2= RULE_ABS_EBIGDECIMAL ) ) ) ) | ( (lv_properties_19_0= ruleXProperty ) ) )* otherlv_20= '}' ) | (otherlv_21= 'tmsc' otherlv_22= 'analyses' otherlv_23= '{' ( (lv_analyses_24_0= ruleXTmscAnalysis ) )* otherlv_25= '}' ) | ( (lv_dependencySettings_26_0= ruleXDependencySettings ) ) | ( (lv_interfaces_27_0= ruleXInterface ) ) | ( (lv_components_28_0= ruleXComponent ) ) | ( (lv_functions_29_0= ruleXFunction ) ) | ( (lv_hosts_30_0= ruleXHost ) ) | ( (lv_executors_31_0= ruleXExecutor ) ) | ( (lv_events_32_0= ruleXEvent ) ) )* )
            // InternalTmscXtext.g:80:3: () ( (otherlv_1= 'tmsc' otherlv_2= 'settings' otherlv_3= '{' ( (otherlv_4= 'architecture' otherlv_5= ':' ( (lv_architectureKind_6_0= ruleXArchitectureKind ) ) ) | (otherlv_7= 'time-bound' otherlv_8= ':' ( (lv_timeBound_9_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_10= 'scheduled' otherlv_11= ':' ( (lv_scheduled_12_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_13= 'start-time' otherlv_14= ':' ( ( (lv_startTime_15_1= RULE_ISO8601 | lv_startTime_15_2= RULE_ABS_EBIGDECIMAL ) ) ) ) | (otherlv_16= 'end-time' otherlv_17= ':' ( ( (lv_endTime_18_1= RULE_ISO8601 | lv_endTime_18_2= RULE_ABS_EBIGDECIMAL ) ) ) ) | ( (lv_properties_19_0= ruleXProperty ) ) )* otherlv_20= '}' ) | (otherlv_21= 'tmsc' otherlv_22= 'analyses' otherlv_23= '{' ( (lv_analyses_24_0= ruleXTmscAnalysis ) )* otherlv_25= '}' ) | ( (lv_dependencySettings_26_0= ruleXDependencySettings ) ) | ( (lv_interfaces_27_0= ruleXInterface ) ) | ( (lv_components_28_0= ruleXComponent ) ) | ( (lv_functions_29_0= ruleXFunction ) ) | ( (lv_hosts_30_0= ruleXHost ) ) | ( (lv_executors_31_0= ruleXExecutor ) ) | ( (lv_events_32_0= ruleXEvent ) ) )*
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

            // InternalTmscXtext.g:87:3: ( (otherlv_1= 'tmsc' otherlv_2= 'settings' otherlv_3= '{' ( (otherlv_4= 'architecture' otherlv_5= ':' ( (lv_architectureKind_6_0= ruleXArchitectureKind ) ) ) | (otherlv_7= 'time-bound' otherlv_8= ':' ( (lv_timeBound_9_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_10= 'scheduled' otherlv_11= ':' ( (lv_scheduled_12_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_13= 'start-time' otherlv_14= ':' ( ( (lv_startTime_15_1= RULE_ISO8601 | lv_startTime_15_2= RULE_ABS_EBIGDECIMAL ) ) ) ) | (otherlv_16= 'end-time' otherlv_17= ':' ( ( (lv_endTime_18_1= RULE_ISO8601 | lv_endTime_18_2= RULE_ABS_EBIGDECIMAL ) ) ) ) | ( (lv_properties_19_0= ruleXProperty ) ) )* otherlv_20= '}' ) | (otherlv_21= 'tmsc' otherlv_22= 'analyses' otherlv_23= '{' ( (lv_analyses_24_0= ruleXTmscAnalysis ) )* otherlv_25= '}' ) | ( (lv_dependencySettings_26_0= ruleXDependencySettings ) ) | ( (lv_interfaces_27_0= ruleXInterface ) ) | ( (lv_components_28_0= ruleXComponent ) ) | ( (lv_functions_29_0= ruleXFunction ) ) | ( (lv_hosts_30_0= ruleXHost ) ) | ( (lv_executors_31_0= ruleXExecutor ) ) | ( (lv_events_32_0= ruleXEvent ) ) )*
            loop5:
            do {
                int alt5=10;
                alt5 = dfa5.predict(input);
                switch (alt5) {
            	case 1 :
            	    // InternalTmscXtext.g:88:4: (otherlv_1= 'tmsc' otherlv_2= 'settings' otherlv_3= '{' ( (otherlv_4= 'architecture' otherlv_5= ':' ( (lv_architectureKind_6_0= ruleXArchitectureKind ) ) ) | (otherlv_7= 'time-bound' otherlv_8= ':' ( (lv_timeBound_9_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_10= 'scheduled' otherlv_11= ':' ( (lv_scheduled_12_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_13= 'start-time' otherlv_14= ':' ( ( (lv_startTime_15_1= RULE_ISO8601 | lv_startTime_15_2= RULE_ABS_EBIGDECIMAL ) ) ) ) | (otherlv_16= 'end-time' otherlv_17= ':' ( ( (lv_endTime_18_1= RULE_ISO8601 | lv_endTime_18_2= RULE_ABS_EBIGDECIMAL ) ) ) ) | ( (lv_properties_19_0= ruleXProperty ) ) )* otherlv_20= '}' )
            	    {
            	    // InternalTmscXtext.g:88:4: (otherlv_1= 'tmsc' otherlv_2= 'settings' otherlv_3= '{' ( (otherlv_4= 'architecture' otherlv_5= ':' ( (lv_architectureKind_6_0= ruleXArchitectureKind ) ) ) | (otherlv_7= 'time-bound' otherlv_8= ':' ( (lv_timeBound_9_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_10= 'scheduled' otherlv_11= ':' ( (lv_scheduled_12_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_13= 'start-time' otherlv_14= ':' ( ( (lv_startTime_15_1= RULE_ISO8601 | lv_startTime_15_2= RULE_ABS_EBIGDECIMAL ) ) ) ) | (otherlv_16= 'end-time' otherlv_17= ':' ( ( (lv_endTime_18_1= RULE_ISO8601 | lv_endTime_18_2= RULE_ABS_EBIGDECIMAL ) ) ) ) | ( (lv_properties_19_0= ruleXProperty ) ) )* otherlv_20= '}' )
            	    // InternalTmscXtext.g:89:5: otherlv_1= 'tmsc' otherlv_2= 'settings' otherlv_3= '{' ( (otherlv_4= 'architecture' otherlv_5= ':' ( (lv_architectureKind_6_0= ruleXArchitectureKind ) ) ) | (otherlv_7= 'time-bound' otherlv_8= ':' ( (lv_timeBound_9_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_10= 'scheduled' otherlv_11= ':' ( (lv_scheduled_12_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_13= 'start-time' otherlv_14= ':' ( ( (lv_startTime_15_1= RULE_ISO8601 | lv_startTime_15_2= RULE_ABS_EBIGDECIMAL ) ) ) ) | (otherlv_16= 'end-time' otherlv_17= ':' ( ( (lv_endTime_18_1= RULE_ISO8601 | lv_endTime_18_2= RULE_ABS_EBIGDECIMAL ) ) ) ) | ( (lv_properties_19_0= ruleXProperty ) ) )* otherlv_20= '}'
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
            	    // InternalTmscXtext.g:101:5: ( (otherlv_4= 'architecture' otherlv_5= ':' ( (lv_architectureKind_6_0= ruleXArchitectureKind ) ) ) | (otherlv_7= 'time-bound' otherlv_8= ':' ( (lv_timeBound_9_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_10= 'scheduled' otherlv_11= ':' ( (lv_scheduled_12_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_13= 'start-time' otherlv_14= ':' ( ( (lv_startTime_15_1= RULE_ISO8601 | lv_startTime_15_2= RULE_ABS_EBIGDECIMAL ) ) ) ) | (otherlv_16= 'end-time' otherlv_17= ':' ( ( (lv_endTime_18_1= RULE_ISO8601 | lv_endTime_18_2= RULE_ABS_EBIGDECIMAL ) ) ) ) | ( (lv_properties_19_0= ruleXProperty ) ) )*
            	    loop3:
            	    do {
            	        int alt3=7;
            	        switch ( input.LA(1) ) {
            	        case 16:
            	            {
            	            alt3=1;
            	            }
            	            break;
            	        case 18:
            	            {
            	            alt3=2;
            	            }
            	            break;
            	        case 19:
            	            {
            	            alt3=3;
            	            }
            	            break;
            	        case 20:
            	            {
            	            alt3=4;
            	            }
            	            break;
            	        case 21:
            	            {
            	            alt3=5;
            	            }
            	            break;
            	        case RULE_ID:
            	        case RULE_STRING:
            	            {
            	            alt3=6;
            	            }
            	            break;

            	        }

            	        switch (alt3) {
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
            	    	    // InternalTmscXtext.g:191:6: (otherlv_13= 'start-time' otherlv_14= ':' ( ( (lv_startTime_15_1= RULE_ISO8601 | lv_startTime_15_2= RULE_ABS_EBIGDECIMAL ) ) ) )
            	    	    {
            	    	    // InternalTmscXtext.g:191:6: (otherlv_13= 'start-time' otherlv_14= ':' ( ( (lv_startTime_15_1= RULE_ISO8601 | lv_startTime_15_2= RULE_ABS_EBIGDECIMAL ) ) ) )
            	    	    // InternalTmscXtext.g:192:7: otherlv_13= 'start-time' otherlv_14= ':' ( ( (lv_startTime_15_1= RULE_ISO8601 | lv_startTime_15_2= RULE_ABS_EBIGDECIMAL ) ) )
            	    	    {
            	    	    otherlv_13=(Token)match(input,20,FOLLOW_6); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      							newLeafNode(otherlv_13, grammarAccess.getTmscXtextModelAccess().getStartTimeKeyword_1_0_3_3_0());
            	    	      						
            	    	    }
            	    	    otherlv_14=(Token)match(input,17,FOLLOW_10); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      							newLeafNode(otherlv_14, grammarAccess.getTmscXtextModelAccess().getColonKeyword_1_0_3_3_1());
            	    	      						
            	    	    }
            	    	    // InternalTmscXtext.g:200:7: ( ( (lv_startTime_15_1= RULE_ISO8601 | lv_startTime_15_2= RULE_ABS_EBIGDECIMAL ) ) )
            	    	    // InternalTmscXtext.g:201:8: ( (lv_startTime_15_1= RULE_ISO8601 | lv_startTime_15_2= RULE_ABS_EBIGDECIMAL ) )
            	    	    {
            	    	    // InternalTmscXtext.g:201:8: ( (lv_startTime_15_1= RULE_ISO8601 | lv_startTime_15_2= RULE_ABS_EBIGDECIMAL ) )
            	    	    // InternalTmscXtext.g:202:9: (lv_startTime_15_1= RULE_ISO8601 | lv_startTime_15_2= RULE_ABS_EBIGDECIMAL )
            	    	    {
            	    	    // InternalTmscXtext.g:202:9: (lv_startTime_15_1= RULE_ISO8601 | lv_startTime_15_2= RULE_ABS_EBIGDECIMAL )
            	    	    int alt1=2;
            	    	    int LA1_0 = input.LA(1);

            	    	    if ( (LA1_0==RULE_ISO8601) ) {
            	    	        alt1=1;
            	    	    }
            	    	    else if ( (LA1_0==RULE_ABS_EBIGDECIMAL) ) {
            	    	        alt1=2;
            	    	    }
            	    	    else {
            	    	        if (state.backtracking>0) {state.failed=true; return current;}
            	    	        NoViableAltException nvae =
            	    	            new NoViableAltException("", 1, 0, input);

            	    	        throw nvae;
            	    	    }
            	    	    switch (alt1) {
            	    	        case 1 :
            	    	            // InternalTmscXtext.g:203:10: lv_startTime_15_1= RULE_ISO8601
            	    	            {
            	    	            lv_startTime_15_1=(Token)match(input,RULE_ISO8601,FOLLOW_5); if (state.failed) return current;
            	    	            if ( state.backtracking==0 ) {

            	    	              										newLeafNode(lv_startTime_15_1, grammarAccess.getTmscXtextModelAccess().getStartTimeISO8601TerminalRuleCall_1_0_3_3_2_0_0());
            	    	              									
            	    	            }
            	    	            if ( state.backtracking==0 ) {

            	    	              										if (current==null) {
            	    	              											current = createModelElement(grammarAccess.getTmscXtextModelRule());
            	    	              										}
            	    	              										setWithLastConsumed(
            	    	              											current,
            	    	              											"startTime",
            	    	              											lv_startTime_15_1,
            	    	              											"nl.esi.pps.tmsc.xtext.TmscXtext.ISO8601");
            	    	              									
            	    	            }

            	    	            }
            	    	            break;
            	    	        case 2 :
            	    	            // InternalTmscXtext.g:218:10: lv_startTime_15_2= RULE_ABS_EBIGDECIMAL
            	    	            {
            	    	            lv_startTime_15_2=(Token)match(input,RULE_ABS_EBIGDECIMAL,FOLLOW_5); if (state.failed) return current;
            	    	            if ( state.backtracking==0 ) {

            	    	              										newLeafNode(lv_startTime_15_2, grammarAccess.getTmscXtextModelAccess().getStartTimeABS_EBIGDECIMALTerminalRuleCall_1_0_3_3_2_0_1());
            	    	              									
            	    	            }
            	    	            if ( state.backtracking==0 ) {

            	    	              										if (current==null) {
            	    	              											current = createModelElement(grammarAccess.getTmscXtextModelRule());
            	    	              										}
            	    	              										setWithLastConsumed(
            	    	              											current,
            	    	              											"startTime",
            	    	              											lv_startTime_15_2,
            	    	              											"nl.esi.pps.tmsc.xtext.TmscXtext.ABS_EBIGDECIMAL");
            	    	              									
            	    	            }

            	    	            }
            	    	            break;

            	    	    }


            	    	    }


            	    	    }


            	    	    }


            	    	    }
            	    	    break;
            	    	case 5 :
            	    	    // InternalTmscXtext.g:237:6: (otherlv_16= 'end-time' otherlv_17= ':' ( ( (lv_endTime_18_1= RULE_ISO8601 | lv_endTime_18_2= RULE_ABS_EBIGDECIMAL ) ) ) )
            	    	    {
            	    	    // InternalTmscXtext.g:237:6: (otherlv_16= 'end-time' otherlv_17= ':' ( ( (lv_endTime_18_1= RULE_ISO8601 | lv_endTime_18_2= RULE_ABS_EBIGDECIMAL ) ) ) )
            	    	    // InternalTmscXtext.g:238:7: otherlv_16= 'end-time' otherlv_17= ':' ( ( (lv_endTime_18_1= RULE_ISO8601 | lv_endTime_18_2= RULE_ABS_EBIGDECIMAL ) ) )
            	    	    {
            	    	    otherlv_16=(Token)match(input,21,FOLLOW_6); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      							newLeafNode(otherlv_16, grammarAccess.getTmscXtextModelAccess().getEndTimeKeyword_1_0_3_4_0());
            	    	      						
            	    	    }
            	    	    otherlv_17=(Token)match(input,17,FOLLOW_10); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      							newLeafNode(otherlv_17, grammarAccess.getTmscXtextModelAccess().getColonKeyword_1_0_3_4_1());
            	    	      						
            	    	    }
            	    	    // InternalTmscXtext.g:246:7: ( ( (lv_endTime_18_1= RULE_ISO8601 | lv_endTime_18_2= RULE_ABS_EBIGDECIMAL ) ) )
            	    	    // InternalTmscXtext.g:247:8: ( (lv_endTime_18_1= RULE_ISO8601 | lv_endTime_18_2= RULE_ABS_EBIGDECIMAL ) )
            	    	    {
            	    	    // InternalTmscXtext.g:247:8: ( (lv_endTime_18_1= RULE_ISO8601 | lv_endTime_18_2= RULE_ABS_EBIGDECIMAL ) )
            	    	    // InternalTmscXtext.g:248:9: (lv_endTime_18_1= RULE_ISO8601 | lv_endTime_18_2= RULE_ABS_EBIGDECIMAL )
            	    	    {
            	    	    // InternalTmscXtext.g:248:9: (lv_endTime_18_1= RULE_ISO8601 | lv_endTime_18_2= RULE_ABS_EBIGDECIMAL )
            	    	    int alt2=2;
            	    	    int LA2_0 = input.LA(1);

            	    	    if ( (LA2_0==RULE_ISO8601) ) {
            	    	        alt2=1;
            	    	    }
            	    	    else if ( (LA2_0==RULE_ABS_EBIGDECIMAL) ) {
            	    	        alt2=2;
            	    	    }
            	    	    else {
            	    	        if (state.backtracking>0) {state.failed=true; return current;}
            	    	        NoViableAltException nvae =
            	    	            new NoViableAltException("", 2, 0, input);

            	    	        throw nvae;
            	    	    }
            	    	    switch (alt2) {
            	    	        case 1 :
            	    	            // InternalTmscXtext.g:249:10: lv_endTime_18_1= RULE_ISO8601
            	    	            {
            	    	            lv_endTime_18_1=(Token)match(input,RULE_ISO8601,FOLLOW_5); if (state.failed) return current;
            	    	            if ( state.backtracking==0 ) {

            	    	              										newLeafNode(lv_endTime_18_1, grammarAccess.getTmscXtextModelAccess().getEndTimeISO8601TerminalRuleCall_1_0_3_4_2_0_0());
            	    	              									
            	    	            }
            	    	            if ( state.backtracking==0 ) {

            	    	              										if (current==null) {
            	    	              											current = createModelElement(grammarAccess.getTmscXtextModelRule());
            	    	              										}
            	    	              										setWithLastConsumed(
            	    	              											current,
            	    	              											"endTime",
            	    	              											lv_endTime_18_1,
            	    	              											"nl.esi.pps.tmsc.xtext.TmscXtext.ISO8601");
            	    	              									
            	    	            }

            	    	            }
            	    	            break;
            	    	        case 2 :
            	    	            // InternalTmscXtext.g:264:10: lv_endTime_18_2= RULE_ABS_EBIGDECIMAL
            	    	            {
            	    	            lv_endTime_18_2=(Token)match(input,RULE_ABS_EBIGDECIMAL,FOLLOW_5); if (state.failed) return current;
            	    	            if ( state.backtracking==0 ) {

            	    	              										newLeafNode(lv_endTime_18_2, grammarAccess.getTmscXtextModelAccess().getEndTimeABS_EBIGDECIMALTerminalRuleCall_1_0_3_4_2_0_1());
            	    	              									
            	    	            }
            	    	            if ( state.backtracking==0 ) {

            	    	              										if (current==null) {
            	    	              											current = createModelElement(grammarAccess.getTmscXtextModelRule());
            	    	              										}
            	    	              										setWithLastConsumed(
            	    	              											current,
            	    	              											"endTime",
            	    	              											lv_endTime_18_2,
            	    	              											"nl.esi.pps.tmsc.xtext.TmscXtext.ABS_EBIGDECIMAL");
            	    	              									
            	    	            }

            	    	            }
            	    	            break;

            	    	    }


            	    	    }


            	    	    }


            	    	    }


            	    	    }
            	    	    break;
            	    	case 6 :
            	    	    // InternalTmscXtext.g:283:6: ( (lv_properties_19_0= ruleXProperty ) )
            	    	    {
            	    	    // InternalTmscXtext.g:283:6: ( (lv_properties_19_0= ruleXProperty ) )
            	    	    // InternalTmscXtext.g:284:7: (lv_properties_19_0= ruleXProperty )
            	    	    {
            	    	    // InternalTmscXtext.g:284:7: (lv_properties_19_0= ruleXProperty )
            	    	    // InternalTmscXtext.g:285:8: lv_properties_19_0= ruleXProperty
            	    	    {
            	    	    if ( state.backtracking==0 ) {

            	    	      								newCompositeNode(grammarAccess.getTmscXtextModelAccess().getPropertiesXPropertyParserRuleCall_1_0_3_5_0());
            	    	      							
            	    	    }
            	    	    pushFollow(FOLLOW_5);
            	    	    lv_properties_19_0=ruleXProperty();

            	    	    state._fsp--;
            	    	    if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      								if (current==null) {
            	    	      									current = createModelElementForParent(grammarAccess.getTmscXtextModelRule());
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
            	    	    break loop3;
            	        }
            	    } while (true);

            	    otherlv_20=(Token)match(input,22,FOLLOW_11); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_20, grammarAccess.getTmscXtextModelAccess().getRightCurlyBracketKeyword_1_0_4());
            	      				
            	    }

            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalTmscXtext.g:309:4: (otherlv_21= 'tmsc' otherlv_22= 'analyses' otherlv_23= '{' ( (lv_analyses_24_0= ruleXTmscAnalysis ) )* otherlv_25= '}' )
            	    {
            	    // InternalTmscXtext.g:309:4: (otherlv_21= 'tmsc' otherlv_22= 'analyses' otherlv_23= '{' ( (lv_analyses_24_0= ruleXTmscAnalysis ) )* otherlv_25= '}' )
            	    // InternalTmscXtext.g:310:5: otherlv_21= 'tmsc' otherlv_22= 'analyses' otherlv_23= '{' ( (lv_analyses_24_0= ruleXTmscAnalysis ) )* otherlv_25= '}'
            	    {
            	    otherlv_21=(Token)match(input,13,FOLLOW_12); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_21, grammarAccess.getTmscXtextModelAccess().getTmscKeyword_1_1_0());
            	      				
            	    }
            	    otherlv_22=(Token)match(input,23,FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_22, grammarAccess.getTmscXtextModelAccess().getAnalysesKeyword_1_1_1());
            	      				
            	    }
            	    otherlv_23=(Token)match(input,15,FOLLOW_13); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_23, grammarAccess.getTmscXtextModelAccess().getLeftCurlyBracketKeyword_1_1_2());
            	      				
            	    }
            	    // InternalTmscXtext.g:322:5: ( (lv_analyses_24_0= ruleXTmscAnalysis ) )*
            	    loop4:
            	    do {
            	        int alt4=2;
            	        int LA4_0 = input.LA(1);

            	        if ( (LA4_0==24||LA4_0==26) ) {
            	            alt4=1;
            	        }


            	        switch (alt4) {
            	    	case 1 :
            	    	    // InternalTmscXtext.g:323:6: (lv_analyses_24_0= ruleXTmscAnalysis )
            	    	    {
            	    	    // InternalTmscXtext.g:323:6: (lv_analyses_24_0= ruleXTmscAnalysis )
            	    	    // InternalTmscXtext.g:324:7: lv_analyses_24_0= ruleXTmscAnalysis
            	    	    {
            	    	    if ( state.backtracking==0 ) {

            	    	      							newCompositeNode(grammarAccess.getTmscXtextModelAccess().getAnalysesXTmscAnalysisParserRuleCall_1_1_3_0());
            	    	      						
            	    	    }
            	    	    pushFollow(FOLLOW_13);
            	    	    lv_analyses_24_0=ruleXTmscAnalysis();

            	    	    state._fsp--;
            	    	    if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      							if (current==null) {
            	    	      								current = createModelElementForParent(grammarAccess.getTmscXtextModelRule());
            	    	      							}
            	    	      							add(
            	    	      								current,
            	    	      								"analyses",
            	    	      								lv_analyses_24_0,
            	    	      								"nl.esi.pps.tmsc.xtext.TmscXtext.XTmscAnalysis");
            	    	      							afterParserOrEnumRuleCall();
            	    	      						
            	    	    }

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop4;
            	        }
            	    } while (true);

            	    otherlv_25=(Token)match(input,22,FOLLOW_11); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_25, grammarAccess.getTmscXtextModelAccess().getRightCurlyBracketKeyword_1_1_4());
            	      				
            	    }

            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalTmscXtext.g:347:4: ( (lv_dependencySettings_26_0= ruleXDependencySettings ) )
            	    {
            	    // InternalTmscXtext.g:347:4: ( (lv_dependencySettings_26_0= ruleXDependencySettings ) )
            	    // InternalTmscXtext.g:348:5: (lv_dependencySettings_26_0= ruleXDependencySettings )
            	    {
            	    // InternalTmscXtext.g:348:5: (lv_dependencySettings_26_0= ruleXDependencySettings )
            	    // InternalTmscXtext.g:349:6: lv_dependencySettings_26_0= ruleXDependencySettings
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getTmscXtextModelAccess().getDependencySettingsXDependencySettingsParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_11);
            	    lv_dependencySettings_26_0=ruleXDependencySettings();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getTmscXtextModelRule());
            	      						}
            	      						add(
            	      							current,
            	      							"dependencySettings",
            	      							lv_dependencySettings_26_0,
            	      							"nl.esi.pps.tmsc.xtext.TmscXtext.XDependencySettings");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalTmscXtext.g:367:4: ( (lv_interfaces_27_0= ruleXInterface ) )
            	    {
            	    // InternalTmscXtext.g:367:4: ( (lv_interfaces_27_0= ruleXInterface ) )
            	    // InternalTmscXtext.g:368:5: (lv_interfaces_27_0= ruleXInterface )
            	    {
            	    // InternalTmscXtext.g:368:5: (lv_interfaces_27_0= ruleXInterface )
            	    // InternalTmscXtext.g:369:6: lv_interfaces_27_0= ruleXInterface
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getTmscXtextModelAccess().getInterfacesXInterfaceParserRuleCall_1_3_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_11);
            	    lv_interfaces_27_0=ruleXInterface();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getTmscXtextModelRule());
            	      						}
            	      						add(
            	      							current,
            	      							"interfaces",
            	      							lv_interfaces_27_0,
            	      							"nl.esi.pps.tmsc.xtext.TmscXtext.XInterface");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // InternalTmscXtext.g:387:4: ( (lv_components_28_0= ruleXComponent ) )
            	    {
            	    // InternalTmscXtext.g:387:4: ( (lv_components_28_0= ruleXComponent ) )
            	    // InternalTmscXtext.g:388:5: (lv_components_28_0= ruleXComponent )
            	    {
            	    // InternalTmscXtext.g:388:5: (lv_components_28_0= ruleXComponent )
            	    // InternalTmscXtext.g:389:6: lv_components_28_0= ruleXComponent
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getTmscXtextModelAccess().getComponentsXComponentParserRuleCall_1_4_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_11);
            	    lv_components_28_0=ruleXComponent();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getTmscXtextModelRule());
            	      						}
            	      						add(
            	      							current,
            	      							"components",
            	      							lv_components_28_0,
            	      							"nl.esi.pps.tmsc.xtext.TmscXtext.XComponent");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 6 :
            	    // InternalTmscXtext.g:407:4: ( (lv_functions_29_0= ruleXFunction ) )
            	    {
            	    // InternalTmscXtext.g:407:4: ( (lv_functions_29_0= ruleXFunction ) )
            	    // InternalTmscXtext.g:408:5: (lv_functions_29_0= ruleXFunction )
            	    {
            	    // InternalTmscXtext.g:408:5: (lv_functions_29_0= ruleXFunction )
            	    // InternalTmscXtext.g:409:6: lv_functions_29_0= ruleXFunction
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getTmscXtextModelAccess().getFunctionsXFunctionParserRuleCall_1_5_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_11);
            	    lv_functions_29_0=ruleXFunction();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getTmscXtextModelRule());
            	      						}
            	      						add(
            	      							current,
            	      							"functions",
            	      							lv_functions_29_0,
            	      							"nl.esi.pps.tmsc.xtext.TmscXtext.XFunction");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 7 :
            	    // InternalTmscXtext.g:427:4: ( (lv_hosts_30_0= ruleXHost ) )
            	    {
            	    // InternalTmscXtext.g:427:4: ( (lv_hosts_30_0= ruleXHost ) )
            	    // InternalTmscXtext.g:428:5: (lv_hosts_30_0= ruleXHost )
            	    {
            	    // InternalTmscXtext.g:428:5: (lv_hosts_30_0= ruleXHost )
            	    // InternalTmscXtext.g:429:6: lv_hosts_30_0= ruleXHost
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getTmscXtextModelAccess().getHostsXHostParserRuleCall_1_6_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_11);
            	    lv_hosts_30_0=ruleXHost();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getTmscXtextModelRule());
            	      						}
            	      						add(
            	      							current,
            	      							"hosts",
            	      							lv_hosts_30_0,
            	      							"nl.esi.pps.tmsc.xtext.TmscXtext.XHost");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 8 :
            	    // InternalTmscXtext.g:447:4: ( (lv_executors_31_0= ruleXExecutor ) )
            	    {
            	    // InternalTmscXtext.g:447:4: ( (lv_executors_31_0= ruleXExecutor ) )
            	    // InternalTmscXtext.g:448:5: (lv_executors_31_0= ruleXExecutor )
            	    {
            	    // InternalTmscXtext.g:448:5: (lv_executors_31_0= ruleXExecutor )
            	    // InternalTmscXtext.g:449:6: lv_executors_31_0= ruleXExecutor
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getTmscXtextModelAccess().getExecutorsXExecutorParserRuleCall_1_7_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_11);
            	    lv_executors_31_0=ruleXExecutor();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getTmscXtextModelRule());
            	      						}
            	      						add(
            	      							current,
            	      							"executors",
            	      							lv_executors_31_0,
            	      							"nl.esi.pps.tmsc.xtext.TmscXtext.XExecutor");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 9 :
            	    // InternalTmscXtext.g:467:4: ( (lv_events_32_0= ruleXEvent ) )
            	    {
            	    // InternalTmscXtext.g:467:4: ( (lv_events_32_0= ruleXEvent ) )
            	    // InternalTmscXtext.g:468:5: (lv_events_32_0= ruleXEvent )
            	    {
            	    // InternalTmscXtext.g:468:5: (lv_events_32_0= ruleXEvent )
            	    // InternalTmscXtext.g:469:6: lv_events_32_0= ruleXEvent
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getTmscXtextModelAccess().getEventsXEventParserRuleCall_1_8_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_11);
            	    lv_events_32_0=ruleXEvent();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getTmscXtextModelRule());
            	      						}
            	      						add(
            	      							current,
            	      							"events",
            	      							lv_events_32_0,
            	      							"nl.esi.pps.tmsc.xtext.TmscXtext.XEvent");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
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
    // InternalTmscXtext.g:491:1: entryRuleXTmscAnalysis returns [EObject current=null] : iv_ruleXTmscAnalysis= ruleXTmscAnalysis EOF ;
    public final EObject entryRuleXTmscAnalysis() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXTmscAnalysis = null;


        try {
            // InternalTmscXtext.g:491:54: (iv_ruleXTmscAnalysis= ruleXTmscAnalysis EOF )
            // InternalTmscXtext.g:492:2: iv_ruleXTmscAnalysis= ruleXTmscAnalysis EOF
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
    // InternalTmscXtext.g:498:1: ruleXTmscAnalysis returns [EObject current=null] : (this_XTimeBoundAnalysis_0= ruleXTimeBoundAnalysis | this_XTimeShift_1= ruleXTimeShift ) ;
    public final EObject ruleXTmscAnalysis() throws RecognitionException {
        EObject current = null;

        EObject this_XTimeBoundAnalysis_0 = null;

        EObject this_XTimeShift_1 = null;



        	enterRule();

        try {
            // InternalTmscXtext.g:504:2: ( (this_XTimeBoundAnalysis_0= ruleXTimeBoundAnalysis | this_XTimeShift_1= ruleXTimeShift ) )
            // InternalTmscXtext.g:505:2: (this_XTimeBoundAnalysis_0= ruleXTimeBoundAnalysis | this_XTimeShift_1= ruleXTimeShift )
            {
            // InternalTmscXtext.g:505:2: (this_XTimeBoundAnalysis_0= ruleXTimeBoundAnalysis | this_XTimeShift_1= ruleXTimeShift )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==24) ) {
                alt6=1;
            }
            else if ( (LA6_0==26) ) {
                alt6=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalTmscXtext.g:506:3: this_XTimeBoundAnalysis_0= ruleXTimeBoundAnalysis
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
                    // InternalTmscXtext.g:515:3: this_XTimeShift_1= ruleXTimeShift
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
    // InternalTmscXtext.g:527:1: entryRuleXTimeBoundAnalysis returns [EObject current=null] : iv_ruleXTimeBoundAnalysis= ruleXTimeBoundAnalysis EOF ;
    public final EObject entryRuleXTimeBoundAnalysis() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXTimeBoundAnalysis = null;


        try {
            // InternalTmscXtext.g:527:59: (iv_ruleXTimeBoundAnalysis= ruleXTimeBoundAnalysis EOF )
            // InternalTmscXtext.g:528:2: iv_ruleXTimeBoundAnalysis= ruleXTimeBoundAnalysis EOF
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
    // InternalTmscXtext.g:534:1: ruleXTimeBoundAnalysis returns [EObject current=null] : ( () otherlv_1= 'time-bound-analysis' (otherlv_2= '{' (otherlv_3= 'defaultTimeBound' otherlv_4= ':' ( (lv_defaultTimeBound_5_0= RULE_ABS_EBIGDECIMAL ) ) )? otherlv_6= '}' )? ) ;
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
            // InternalTmscXtext.g:540:2: ( ( () otherlv_1= 'time-bound-analysis' (otherlv_2= '{' (otherlv_3= 'defaultTimeBound' otherlv_4= ':' ( (lv_defaultTimeBound_5_0= RULE_ABS_EBIGDECIMAL ) ) )? otherlv_6= '}' )? ) )
            // InternalTmscXtext.g:541:2: ( () otherlv_1= 'time-bound-analysis' (otherlv_2= '{' (otherlv_3= 'defaultTimeBound' otherlv_4= ':' ( (lv_defaultTimeBound_5_0= RULE_ABS_EBIGDECIMAL ) ) )? otherlv_6= '}' )? )
            {
            // InternalTmscXtext.g:541:2: ( () otherlv_1= 'time-bound-analysis' (otherlv_2= '{' (otherlv_3= 'defaultTimeBound' otherlv_4= ':' ( (lv_defaultTimeBound_5_0= RULE_ABS_EBIGDECIMAL ) ) )? otherlv_6= '}' )? )
            // InternalTmscXtext.g:542:3: () otherlv_1= 'time-bound-analysis' (otherlv_2= '{' (otherlv_3= 'defaultTimeBound' otherlv_4= ':' ( (lv_defaultTimeBound_5_0= RULE_ABS_EBIGDECIMAL ) ) )? otherlv_6= '}' )?
            {
            // InternalTmscXtext.g:542:3: ()
            // InternalTmscXtext.g:543:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getXTimeBoundAnalysisAccess().getXTimeBoundAnalysisAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,24,FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getXTimeBoundAnalysisAccess().getTimeBoundAnalysisKeyword_1());
              		
            }
            // InternalTmscXtext.g:553:3: (otherlv_2= '{' (otherlv_3= 'defaultTimeBound' otherlv_4= ':' ( (lv_defaultTimeBound_5_0= RULE_ABS_EBIGDECIMAL ) ) )? otherlv_6= '}' )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==15) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalTmscXtext.g:554:4: otherlv_2= '{' (otherlv_3= 'defaultTimeBound' otherlv_4= ':' ( (lv_defaultTimeBound_5_0= RULE_ABS_EBIGDECIMAL ) ) )? otherlv_6= '}'
                    {
                    otherlv_2=(Token)match(input,15,FOLLOW_15); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getXTimeBoundAnalysisAccess().getLeftCurlyBracketKeyword_2_0());
                      			
                    }
                    // InternalTmscXtext.g:558:4: (otherlv_3= 'defaultTimeBound' otherlv_4= ':' ( (lv_defaultTimeBound_5_0= RULE_ABS_EBIGDECIMAL ) ) )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==25) ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // InternalTmscXtext.g:559:5: otherlv_3= 'defaultTimeBound' otherlv_4= ':' ( (lv_defaultTimeBound_5_0= RULE_ABS_EBIGDECIMAL ) )
                            {
                            otherlv_3=(Token)match(input,25,FOLLOW_6); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_3, grammarAccess.getXTimeBoundAnalysisAccess().getDefaultTimeBoundKeyword_2_1_0());
                              				
                            }
                            otherlv_4=(Token)match(input,17,FOLLOW_8); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_4, grammarAccess.getXTimeBoundAnalysisAccess().getColonKeyword_2_1_1());
                              				
                            }
                            // InternalTmscXtext.g:567:5: ( (lv_defaultTimeBound_5_0= RULE_ABS_EBIGDECIMAL ) )
                            // InternalTmscXtext.g:568:6: (lv_defaultTimeBound_5_0= RULE_ABS_EBIGDECIMAL )
                            {
                            // InternalTmscXtext.g:568:6: (lv_defaultTimeBound_5_0= RULE_ABS_EBIGDECIMAL )
                            // InternalTmscXtext.g:569:7: lv_defaultTimeBound_5_0= RULE_ABS_EBIGDECIMAL
                            {
                            lv_defaultTimeBound_5_0=(Token)match(input,RULE_ABS_EBIGDECIMAL,FOLLOW_16); if (state.failed) return current;
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

                    otherlv_6=(Token)match(input,22,FOLLOW_2); if (state.failed) return current;
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
    // InternalTmscXtext.g:595:1: entryRuleXTimeShift returns [EObject current=null] : iv_ruleXTimeShift= ruleXTimeShift EOF ;
    public final EObject entryRuleXTimeShift() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXTimeShift = null;


        try {
            // InternalTmscXtext.g:595:51: (iv_ruleXTimeShift= ruleXTimeShift EOF )
            // InternalTmscXtext.g:596:2: iv_ruleXTimeShift= ruleXTimeShift EOF
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
    // InternalTmscXtext.g:602:1: ruleXTimeShift returns [EObject current=null] : ( () otherlv_1= 'time-shift' (otherlv_2= '{' (otherlv_3= 'delta' otherlv_4= ':' ( (lv_delta_5_0= ruleEBIGDECIMAL ) ) )? otherlv_6= '}' )? ) ;
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
            // InternalTmscXtext.g:608:2: ( ( () otherlv_1= 'time-shift' (otherlv_2= '{' (otherlv_3= 'delta' otherlv_4= ':' ( (lv_delta_5_0= ruleEBIGDECIMAL ) ) )? otherlv_6= '}' )? ) )
            // InternalTmscXtext.g:609:2: ( () otherlv_1= 'time-shift' (otherlv_2= '{' (otherlv_3= 'delta' otherlv_4= ':' ( (lv_delta_5_0= ruleEBIGDECIMAL ) ) )? otherlv_6= '}' )? )
            {
            // InternalTmscXtext.g:609:2: ( () otherlv_1= 'time-shift' (otherlv_2= '{' (otherlv_3= 'delta' otherlv_4= ':' ( (lv_delta_5_0= ruleEBIGDECIMAL ) ) )? otherlv_6= '}' )? )
            // InternalTmscXtext.g:610:3: () otherlv_1= 'time-shift' (otherlv_2= '{' (otherlv_3= 'delta' otherlv_4= ':' ( (lv_delta_5_0= ruleEBIGDECIMAL ) ) )? otherlv_6= '}' )?
            {
            // InternalTmscXtext.g:610:3: ()
            // InternalTmscXtext.g:611:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getXTimeShiftAccess().getXTimeShiftAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,26,FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getXTimeShiftAccess().getTimeShiftKeyword_1());
              		
            }
            // InternalTmscXtext.g:621:3: (otherlv_2= '{' (otherlv_3= 'delta' otherlv_4= ':' ( (lv_delta_5_0= ruleEBIGDECIMAL ) ) )? otherlv_6= '}' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==15) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalTmscXtext.g:622:4: otherlv_2= '{' (otherlv_3= 'delta' otherlv_4= ':' ( (lv_delta_5_0= ruleEBIGDECIMAL ) ) )? otherlv_6= '}'
                    {
                    otherlv_2=(Token)match(input,15,FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getXTimeShiftAccess().getLeftCurlyBracketKeyword_2_0());
                      			
                    }
                    // InternalTmscXtext.g:626:4: (otherlv_3= 'delta' otherlv_4= ':' ( (lv_delta_5_0= ruleEBIGDECIMAL ) ) )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==27) ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // InternalTmscXtext.g:627:5: otherlv_3= 'delta' otherlv_4= ':' ( (lv_delta_5_0= ruleEBIGDECIMAL ) )
                            {
                            otherlv_3=(Token)match(input,27,FOLLOW_6); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_3, grammarAccess.getXTimeShiftAccess().getDeltaKeyword_2_1_0());
                              				
                            }
                            otherlv_4=(Token)match(input,17,FOLLOW_18); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_4, grammarAccess.getXTimeShiftAccess().getColonKeyword_2_1_1());
                              				
                            }
                            // InternalTmscXtext.g:635:5: ( (lv_delta_5_0= ruleEBIGDECIMAL ) )
                            // InternalTmscXtext.g:636:6: (lv_delta_5_0= ruleEBIGDECIMAL )
                            {
                            // InternalTmscXtext.g:636:6: (lv_delta_5_0= ruleEBIGDECIMAL )
                            // InternalTmscXtext.g:637:7: lv_delta_5_0= ruleEBIGDECIMAL
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getXTimeShiftAccess().getDeltaEBIGDECIMALParserRuleCall_2_1_2_0());
                              						
                            }
                            pushFollow(FOLLOW_16);
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

                    otherlv_6=(Token)match(input,22,FOLLOW_2); if (state.failed) return current;
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
    // InternalTmscXtext.g:664:1: entryRuleXInterface returns [EObject current=null] : iv_ruleXInterface= ruleXInterface EOF ;
    public final EObject entryRuleXInterface() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXInterface = null;


        try {
            // InternalTmscXtext.g:664:51: (iv_ruleXInterface= ruleXInterface EOF )
            // InternalTmscXtext.g:665:2: iv_ruleXInterface= ruleXInterface EOF
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
    // InternalTmscXtext.g:671:1: ruleXInterface returns [EObject current=null] : (otherlv_0= 'interface' ( ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as' )? ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '{' ( ( (lv_properties_5_0= ruleXProperty ) ) | ( (lv_operations_6_0= ruleXOperation ) ) )* otherlv_7= '}' )? ) ;
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
            // InternalTmscXtext.g:677:2: ( (otherlv_0= 'interface' ( ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as' )? ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '{' ( ( (lv_properties_5_0= ruleXProperty ) ) | ( (lv_operations_6_0= ruleXOperation ) ) )* otherlv_7= '}' )? ) )
            // InternalTmscXtext.g:678:2: (otherlv_0= 'interface' ( ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as' )? ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '{' ( ( (lv_properties_5_0= ruleXProperty ) ) | ( (lv_operations_6_0= ruleXOperation ) ) )* otherlv_7= '}' )? )
            {
            // InternalTmscXtext.g:678:2: (otherlv_0= 'interface' ( ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as' )? ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '{' ( ( (lv_properties_5_0= ruleXProperty ) ) | ( (lv_operations_6_0= ruleXOperation ) ) )* otherlv_7= '}' )? )
            // InternalTmscXtext.g:679:3: otherlv_0= 'interface' ( ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as' )? ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '{' ( ( (lv_properties_5_0= ruleXProperty ) ) | ( (lv_operations_6_0= ruleXOperation ) ) )* otherlv_7= '}' )?
            {
            otherlv_0=(Token)match(input,28,FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getXInterfaceAccess().getInterfaceKeyword_0());
              		
            }
            // InternalTmscXtext.g:683:3: ( ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_ID) ) {
                int LA11_1 = input.LA(2);

                if ( (LA11_1==29) ) {
                    alt11=1;
                }
            }
            else if ( (LA11_0==RULE_STRING) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalTmscXtext.g:684:4: ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as'
                    {
                    // InternalTmscXtext.g:684:4: ( (lv_description_1_0= ruleIDString ) )
                    // InternalTmscXtext.g:685:5: (lv_description_1_0= ruleIDString )
                    {
                    // InternalTmscXtext.g:685:5: (lv_description_1_0= ruleIDString )
                    // InternalTmscXtext.g:686:6: lv_description_1_0= ruleIDString
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getXInterfaceAccess().getDescriptionIDStringParserRuleCall_1_0_0());
                      					
                    }
                    pushFollow(FOLLOW_20);
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

                    otherlv_2=(Token)match(input,29,FOLLOW_21); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getXInterfaceAccess().getAsKeyword_1_1());
                      			
                    }

                    }
                    break;

            }

            // InternalTmscXtext.g:708:3: ( (lv_name_3_0= RULE_ID ) )
            // InternalTmscXtext.g:709:4: (lv_name_3_0= RULE_ID )
            {
            // InternalTmscXtext.g:709:4: (lv_name_3_0= RULE_ID )
            // InternalTmscXtext.g:710:5: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_14); if (state.failed) return current;
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

            // InternalTmscXtext.g:726:3: (otherlv_4= '{' ( ( (lv_properties_5_0= ruleXProperty ) ) | ( (lv_operations_6_0= ruleXOperation ) ) )* otherlv_7= '}' )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==15) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalTmscXtext.g:727:4: otherlv_4= '{' ( ( (lv_properties_5_0= ruleXProperty ) ) | ( (lv_operations_6_0= ruleXOperation ) ) )* otherlv_7= '}'
                    {
                    otherlv_4=(Token)match(input,15,FOLLOW_22); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getXInterfaceAccess().getLeftCurlyBracketKeyword_3_0());
                      			
                    }
                    // InternalTmscXtext.g:731:4: ( ( (lv_properties_5_0= ruleXProperty ) ) | ( (lv_operations_6_0= ruleXOperation ) ) )*
                    loop12:
                    do {
                        int alt12=3;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==RULE_ID||LA12_0==RULE_STRING) ) {
                            alt12=1;
                        }
                        else if ( (LA12_0==30) ) {
                            alt12=2;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // InternalTmscXtext.g:732:5: ( (lv_properties_5_0= ruleXProperty ) )
                    	    {
                    	    // InternalTmscXtext.g:732:5: ( (lv_properties_5_0= ruleXProperty ) )
                    	    // InternalTmscXtext.g:733:6: (lv_properties_5_0= ruleXProperty )
                    	    {
                    	    // InternalTmscXtext.g:733:6: (lv_properties_5_0= ruleXProperty )
                    	    // InternalTmscXtext.g:734:7: lv_properties_5_0= ruleXProperty
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getXInterfaceAccess().getPropertiesXPropertyParserRuleCall_3_1_0_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_22);
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
                    	    // InternalTmscXtext.g:752:5: ( (lv_operations_6_0= ruleXOperation ) )
                    	    {
                    	    // InternalTmscXtext.g:752:5: ( (lv_operations_6_0= ruleXOperation ) )
                    	    // InternalTmscXtext.g:753:6: (lv_operations_6_0= ruleXOperation )
                    	    {
                    	    // InternalTmscXtext.g:753:6: (lv_operations_6_0= ruleXOperation )
                    	    // InternalTmscXtext.g:754:7: lv_operations_6_0= ruleXOperation
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getXInterfaceAccess().getOperationsXOperationParserRuleCall_3_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_22);
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
                    	    break loop12;
                        }
                    } while (true);

                    otherlv_7=(Token)match(input,22,FOLLOW_2); if (state.failed) return current;
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
    // InternalTmscXtext.g:781:1: entryRuleXOperation returns [EObject current=null] : iv_ruleXOperation= ruleXOperation EOF ;
    public final EObject entryRuleXOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXOperation = null;


        try {
            // InternalTmscXtext.g:781:51: (iv_ruleXOperation= ruleXOperation EOF )
            // InternalTmscXtext.g:782:2: iv_ruleXOperation= ruleXOperation EOF
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
    // InternalTmscXtext.g:788:1: ruleXOperation returns [EObject current=null] : (otherlv_0= 'operation' ( ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as' )? ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '{' ( (lv_properties_5_0= ruleXProperty ) )* otherlv_6= '}' )? ) ;
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
            // InternalTmscXtext.g:794:2: ( (otherlv_0= 'operation' ( ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as' )? ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '{' ( (lv_properties_5_0= ruleXProperty ) )* otherlv_6= '}' )? ) )
            // InternalTmscXtext.g:795:2: (otherlv_0= 'operation' ( ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as' )? ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '{' ( (lv_properties_5_0= ruleXProperty ) )* otherlv_6= '}' )? )
            {
            // InternalTmscXtext.g:795:2: (otherlv_0= 'operation' ( ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as' )? ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '{' ( (lv_properties_5_0= ruleXProperty ) )* otherlv_6= '}' )? )
            // InternalTmscXtext.g:796:3: otherlv_0= 'operation' ( ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as' )? ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '{' ( (lv_properties_5_0= ruleXProperty ) )* otherlv_6= '}' )?
            {
            otherlv_0=(Token)match(input,30,FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getXOperationAccess().getOperationKeyword_0());
              		
            }
            // InternalTmscXtext.g:800:3: ( ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as' )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_ID) ) {
                int LA14_1 = input.LA(2);

                if ( (LA14_1==29) ) {
                    alt14=1;
                }
            }
            else if ( (LA14_0==RULE_STRING) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalTmscXtext.g:801:4: ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as'
                    {
                    // InternalTmscXtext.g:801:4: ( (lv_description_1_0= ruleIDString ) )
                    // InternalTmscXtext.g:802:5: (lv_description_1_0= ruleIDString )
                    {
                    // InternalTmscXtext.g:802:5: (lv_description_1_0= ruleIDString )
                    // InternalTmscXtext.g:803:6: lv_description_1_0= ruleIDString
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getXOperationAccess().getDescriptionIDStringParserRuleCall_1_0_0());
                      					
                    }
                    pushFollow(FOLLOW_20);
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

                    otherlv_2=(Token)match(input,29,FOLLOW_21); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getXOperationAccess().getAsKeyword_1_1());
                      			
                    }

                    }
                    break;

            }

            // InternalTmscXtext.g:825:3: ( (lv_name_3_0= RULE_ID ) )
            // InternalTmscXtext.g:826:4: (lv_name_3_0= RULE_ID )
            {
            // InternalTmscXtext.g:826:4: (lv_name_3_0= RULE_ID )
            // InternalTmscXtext.g:827:5: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_14); if (state.failed) return current;
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

            // InternalTmscXtext.g:843:3: (otherlv_4= '{' ( (lv_properties_5_0= ruleXProperty ) )* otherlv_6= '}' )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==15) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalTmscXtext.g:844:4: otherlv_4= '{' ( (lv_properties_5_0= ruleXProperty ) )* otherlv_6= '}'
                    {
                    otherlv_4=(Token)match(input,15,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getXOperationAccess().getLeftCurlyBracketKeyword_3_0());
                      			
                    }
                    // InternalTmscXtext.g:848:4: ( (lv_properties_5_0= ruleXProperty ) )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==RULE_ID||LA15_0==RULE_STRING) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // InternalTmscXtext.g:849:5: (lv_properties_5_0= ruleXProperty )
                    	    {
                    	    // InternalTmscXtext.g:849:5: (lv_properties_5_0= ruleXProperty )
                    	    // InternalTmscXtext.g:850:6: lv_properties_5_0= ruleXProperty
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
                    	    break loop15;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,22,FOLLOW_2); if (state.failed) return current;
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
    // InternalTmscXtext.g:876:1: entryRuleXComponent returns [EObject current=null] : iv_ruleXComponent= ruleXComponent EOF ;
    public final EObject entryRuleXComponent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXComponent = null;


        try {
            // InternalTmscXtext.g:876:51: (iv_ruleXComponent= ruleXComponent EOF )
            // InternalTmscXtext.g:877:2: iv_ruleXComponent= ruleXComponent EOF
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
    // InternalTmscXtext.g:883:1: ruleXComponent returns [EObject current=null] : (otherlv_0= 'component' ( ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as' )? ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= 'provides' ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )? (otherlv_8= 'requires' ( (otherlv_9= RULE_ID ) ) (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )* )? (otherlv_12= '{' ( (otherlv_13= 'time-bound' otherlv_14= ':' ( (lv_timeBound_15_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_16= 'scheduled' otherlv_17= ':' ( (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_19_0= ruleXProperty ) ) )* otherlv_20= '}' )? ) ;
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
            // InternalTmscXtext.g:889:2: ( (otherlv_0= 'component' ( ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as' )? ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= 'provides' ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )? (otherlv_8= 'requires' ( (otherlv_9= RULE_ID ) ) (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )* )? (otherlv_12= '{' ( (otherlv_13= 'time-bound' otherlv_14= ':' ( (lv_timeBound_15_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_16= 'scheduled' otherlv_17= ':' ( (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_19_0= ruleXProperty ) ) )* otherlv_20= '}' )? ) )
            // InternalTmscXtext.g:890:2: (otherlv_0= 'component' ( ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as' )? ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= 'provides' ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )? (otherlv_8= 'requires' ( (otherlv_9= RULE_ID ) ) (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )* )? (otherlv_12= '{' ( (otherlv_13= 'time-bound' otherlv_14= ':' ( (lv_timeBound_15_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_16= 'scheduled' otherlv_17= ':' ( (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_19_0= ruleXProperty ) ) )* otherlv_20= '}' )? )
            {
            // InternalTmscXtext.g:890:2: (otherlv_0= 'component' ( ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as' )? ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= 'provides' ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )? (otherlv_8= 'requires' ( (otherlv_9= RULE_ID ) ) (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )* )? (otherlv_12= '{' ( (otherlv_13= 'time-bound' otherlv_14= ':' ( (lv_timeBound_15_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_16= 'scheduled' otherlv_17= ':' ( (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_19_0= ruleXProperty ) ) )* otherlv_20= '}' )? )
            // InternalTmscXtext.g:891:3: otherlv_0= 'component' ( ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as' )? ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= 'provides' ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )? (otherlv_8= 'requires' ( (otherlv_9= RULE_ID ) ) (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )* )? (otherlv_12= '{' ( (otherlv_13= 'time-bound' otherlv_14= ':' ( (lv_timeBound_15_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_16= 'scheduled' otherlv_17= ':' ( (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_19_0= ruleXProperty ) ) )* otherlv_20= '}' )?
            {
            otherlv_0=(Token)match(input,31,FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getXComponentAccess().getComponentKeyword_0());
              		
            }
            // InternalTmscXtext.g:895:3: ( ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_ID) ) {
                int LA17_1 = input.LA(2);

                if ( (LA17_1==29) ) {
                    alt17=1;
                }
            }
            else if ( (LA17_0==RULE_STRING) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalTmscXtext.g:896:4: ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as'
                    {
                    // InternalTmscXtext.g:896:4: ( (lv_description_1_0= ruleIDString ) )
                    // InternalTmscXtext.g:897:5: (lv_description_1_0= ruleIDString )
                    {
                    // InternalTmscXtext.g:897:5: (lv_description_1_0= ruleIDString )
                    // InternalTmscXtext.g:898:6: lv_description_1_0= ruleIDString
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getXComponentAccess().getDescriptionIDStringParserRuleCall_1_0_0());
                      					
                    }
                    pushFollow(FOLLOW_20);
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

                    otherlv_2=(Token)match(input,29,FOLLOW_21); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getXComponentAccess().getAsKeyword_1_1());
                      			
                    }

                    }
                    break;

            }

            // InternalTmscXtext.g:920:3: ( (lv_name_3_0= RULE_ID ) )
            // InternalTmscXtext.g:921:4: (lv_name_3_0= RULE_ID )
            {
            // InternalTmscXtext.g:921:4: (lv_name_3_0= RULE_ID )
            // InternalTmscXtext.g:922:5: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_23); if (state.failed) return current;
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

            // InternalTmscXtext.g:938:3: (otherlv_4= 'provides' ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==32) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalTmscXtext.g:939:4: otherlv_4= 'provides' ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )*
                    {
                    otherlv_4=(Token)match(input,32,FOLLOW_21); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getXComponentAccess().getProvidesKeyword_3_0());
                      			
                    }
                    // InternalTmscXtext.g:943:4: ( (otherlv_5= RULE_ID ) )
                    // InternalTmscXtext.g:944:5: (otherlv_5= RULE_ID )
                    {
                    // InternalTmscXtext.g:944:5: (otherlv_5= RULE_ID )
                    // InternalTmscXtext.g:945:6: otherlv_5= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getXComponentRule());
                      						}
                      					
                    }
                    otherlv_5=(Token)match(input,RULE_ID,FOLLOW_24); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_5, grammarAccess.getXComponentAccess().getProvidesXInterfaceCrossReference_3_1_0());
                      					
                    }

                    }


                    }

                    // InternalTmscXtext.g:956:4: (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )*
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0==33) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // InternalTmscXtext.g:957:5: otherlv_6= ',' ( (otherlv_7= RULE_ID ) )
                    	    {
                    	    otherlv_6=(Token)match(input,33,FOLLOW_21); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_6, grammarAccess.getXComponentAccess().getCommaKeyword_3_2_0());
                    	      				
                    	    }
                    	    // InternalTmscXtext.g:961:5: ( (otherlv_7= RULE_ID ) )
                    	    // InternalTmscXtext.g:962:6: (otherlv_7= RULE_ID )
                    	    {
                    	    // InternalTmscXtext.g:962:6: (otherlv_7= RULE_ID )
                    	    // InternalTmscXtext.g:963:7: otherlv_7= RULE_ID
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElement(grammarAccess.getXComponentRule());
                    	      							}
                    	      						
                    	    }
                    	    otherlv_7=(Token)match(input,RULE_ID,FOLLOW_24); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							newLeafNode(otherlv_7, grammarAccess.getXComponentAccess().getProvidesXInterfaceCrossReference_3_2_1_0());
                    	      						
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

            // InternalTmscXtext.g:976:3: (otherlv_8= 'requires' ( (otherlv_9= RULE_ID ) ) (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )* )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==34) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalTmscXtext.g:977:4: otherlv_8= 'requires' ( (otherlv_9= RULE_ID ) ) (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )*
                    {
                    otherlv_8=(Token)match(input,34,FOLLOW_21); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_8, grammarAccess.getXComponentAccess().getRequiresKeyword_4_0());
                      			
                    }
                    // InternalTmscXtext.g:981:4: ( (otherlv_9= RULE_ID ) )
                    // InternalTmscXtext.g:982:5: (otherlv_9= RULE_ID )
                    {
                    // InternalTmscXtext.g:982:5: (otherlv_9= RULE_ID )
                    // InternalTmscXtext.g:983:6: otherlv_9= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getXComponentRule());
                      						}
                      					
                    }
                    otherlv_9=(Token)match(input,RULE_ID,FOLLOW_25); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_9, grammarAccess.getXComponentAccess().getRequiresXInterfaceCrossReference_4_1_0());
                      					
                    }

                    }


                    }

                    // InternalTmscXtext.g:994:4: (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==33) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // InternalTmscXtext.g:995:5: otherlv_10= ',' ( (otherlv_11= RULE_ID ) )
                    	    {
                    	    otherlv_10=(Token)match(input,33,FOLLOW_21); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_10, grammarAccess.getXComponentAccess().getCommaKeyword_4_2_0());
                    	      				
                    	    }
                    	    // InternalTmscXtext.g:999:5: ( (otherlv_11= RULE_ID ) )
                    	    // InternalTmscXtext.g:1000:6: (otherlv_11= RULE_ID )
                    	    {
                    	    // InternalTmscXtext.g:1000:6: (otherlv_11= RULE_ID )
                    	    // InternalTmscXtext.g:1001:7: otherlv_11= RULE_ID
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElement(grammarAccess.getXComponentRule());
                    	      							}
                    	      						
                    	    }
                    	    otherlv_11=(Token)match(input,RULE_ID,FOLLOW_25); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							newLeafNode(otherlv_11, grammarAccess.getXComponentAccess().getRequiresXInterfaceCrossReference_4_2_1_0());
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop20;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalTmscXtext.g:1014:3: (otherlv_12= '{' ( (otherlv_13= 'time-bound' otherlv_14= ':' ( (lv_timeBound_15_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_16= 'scheduled' otherlv_17= ':' ( (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_19_0= ruleXProperty ) ) )* otherlv_20= '}' )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==15) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalTmscXtext.g:1015:4: otherlv_12= '{' ( (otherlv_13= 'time-bound' otherlv_14= ':' ( (lv_timeBound_15_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_16= 'scheduled' otherlv_17= ':' ( (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_19_0= ruleXProperty ) ) )* otherlv_20= '}'
                    {
                    otherlv_12=(Token)match(input,15,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_12, grammarAccess.getXComponentAccess().getLeftCurlyBracketKeyword_5_0());
                      			
                    }
                    // InternalTmscXtext.g:1019:4: ( (otherlv_13= 'time-bound' otherlv_14= ':' ( (lv_timeBound_15_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_16= 'scheduled' otherlv_17= ':' ( (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_19_0= ruleXProperty ) ) )*
                    loop22:
                    do {
                        int alt22=4;
                        switch ( input.LA(1) ) {
                        case 18:
                            {
                            alt22=1;
                            }
                            break;
                        case 19:
                            {
                            alt22=2;
                            }
                            break;
                        case RULE_ID:
                        case RULE_STRING:
                            {
                            alt22=3;
                            }
                            break;

                        }

                        switch (alt22) {
                    	case 1 :
                    	    // InternalTmscXtext.g:1020:5: (otherlv_13= 'time-bound' otherlv_14= ':' ( (lv_timeBound_15_0= RULE_ABS_EBIGDECIMAL ) ) )
                    	    {
                    	    // InternalTmscXtext.g:1020:5: (otherlv_13= 'time-bound' otherlv_14= ':' ( (lv_timeBound_15_0= RULE_ABS_EBIGDECIMAL ) ) )
                    	    // InternalTmscXtext.g:1021:6: otherlv_13= 'time-bound' otherlv_14= ':' ( (lv_timeBound_15_0= RULE_ABS_EBIGDECIMAL ) )
                    	    {
                    	    otherlv_13=(Token)match(input,18,FOLLOW_6); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_13, grammarAccess.getXComponentAccess().getTimeBoundKeyword_5_1_0_0());
                    	      					
                    	    }
                    	    otherlv_14=(Token)match(input,17,FOLLOW_8); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_14, grammarAccess.getXComponentAccess().getColonKeyword_5_1_0_1());
                    	      					
                    	    }
                    	    // InternalTmscXtext.g:1029:6: ( (lv_timeBound_15_0= RULE_ABS_EBIGDECIMAL ) )
                    	    // InternalTmscXtext.g:1030:7: (lv_timeBound_15_0= RULE_ABS_EBIGDECIMAL )
                    	    {
                    	    // InternalTmscXtext.g:1030:7: (lv_timeBound_15_0= RULE_ABS_EBIGDECIMAL )
                    	    // InternalTmscXtext.g:1031:8: lv_timeBound_15_0= RULE_ABS_EBIGDECIMAL
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
                    	    // InternalTmscXtext.g:1049:5: (otherlv_16= 'scheduled' otherlv_17= ':' ( (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT ) ) )
                    	    {
                    	    // InternalTmscXtext.g:1049:5: (otherlv_16= 'scheduled' otherlv_17= ':' ( (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT ) ) )
                    	    // InternalTmscXtext.g:1050:6: otherlv_16= 'scheduled' otherlv_17= ':' ( (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT ) )
                    	    {
                    	    otherlv_16=(Token)match(input,19,FOLLOW_6); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_16, grammarAccess.getXComponentAccess().getScheduledKeyword_5_1_1_0());
                    	      					
                    	    }
                    	    otherlv_17=(Token)match(input,17,FOLLOW_9); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_17, grammarAccess.getXComponentAccess().getColonKeyword_5_1_1_1());
                    	      					
                    	    }
                    	    // InternalTmscXtext.g:1058:6: ( (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT ) )
                    	    // InternalTmscXtext.g:1059:7: (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT )
                    	    {
                    	    // InternalTmscXtext.g:1059:7: (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT )
                    	    // InternalTmscXtext.g:1060:8: lv_scheduled_18_0= ruleEBOOLEAN_OBJECT
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
                    	    // InternalTmscXtext.g:1079:5: ( (lv_properties_19_0= ruleXProperty ) )
                    	    {
                    	    // InternalTmscXtext.g:1079:5: ( (lv_properties_19_0= ruleXProperty ) )
                    	    // InternalTmscXtext.g:1080:6: (lv_properties_19_0= ruleXProperty )
                    	    {
                    	    // InternalTmscXtext.g:1080:6: (lv_properties_19_0= ruleXProperty )
                    	    // InternalTmscXtext.g:1081:7: lv_properties_19_0= ruleXProperty
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
                    	    break loop22;
                        }
                    } while (true);

                    otherlv_20=(Token)match(input,22,FOLLOW_2); if (state.failed) return current;
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
    // InternalTmscXtext.g:1108:1: entryRuleXFunction returns [EObject current=null] : iv_ruleXFunction= ruleXFunction EOF ;
    public final EObject entryRuleXFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXFunction = null;


        try {
            // InternalTmscXtext.g:1108:50: (iv_ruleXFunction= ruleXFunction EOF )
            // InternalTmscXtext.g:1109:2: iv_ruleXFunction= ruleXFunction EOF
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
    // InternalTmscXtext.g:1115:1: ruleXFunction returns [EObject current=null] : ( ( ( (lv_ipcClient_0_0= 'ipc-client' ) ) | ( (lv_ipcServer_1_0= 'ipc-server' ) ) )? otherlv_2= 'function' ( ( (lv_description_3_0= ruleIDString ) ) otherlv_4= 'as' )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '(' ( (lv_parameters_7_0= ruleXFunctionParameter ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleXFunctionParameter ) ) )* otherlv_10= ')' )? (otherlv_11= 'implements' ( ( ruleFQN ) ) )? (otherlv_13= '{' ( (otherlv_14= 'time-bound' otherlv_15= ':' ( (lv_timeBound_16_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_17= 'scheduled' otherlv_18= ':' ( (lv_scheduled_19_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_20_0= ruleXProperty ) ) )* otherlv_21= '}' )? ) ;
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
            // InternalTmscXtext.g:1121:2: ( ( ( ( (lv_ipcClient_0_0= 'ipc-client' ) ) | ( (lv_ipcServer_1_0= 'ipc-server' ) ) )? otherlv_2= 'function' ( ( (lv_description_3_0= ruleIDString ) ) otherlv_4= 'as' )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '(' ( (lv_parameters_7_0= ruleXFunctionParameter ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleXFunctionParameter ) ) )* otherlv_10= ')' )? (otherlv_11= 'implements' ( ( ruleFQN ) ) )? (otherlv_13= '{' ( (otherlv_14= 'time-bound' otherlv_15= ':' ( (lv_timeBound_16_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_17= 'scheduled' otherlv_18= ':' ( (lv_scheduled_19_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_20_0= ruleXProperty ) ) )* otherlv_21= '}' )? ) )
            // InternalTmscXtext.g:1122:2: ( ( ( (lv_ipcClient_0_0= 'ipc-client' ) ) | ( (lv_ipcServer_1_0= 'ipc-server' ) ) )? otherlv_2= 'function' ( ( (lv_description_3_0= ruleIDString ) ) otherlv_4= 'as' )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '(' ( (lv_parameters_7_0= ruleXFunctionParameter ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleXFunctionParameter ) ) )* otherlv_10= ')' )? (otherlv_11= 'implements' ( ( ruleFQN ) ) )? (otherlv_13= '{' ( (otherlv_14= 'time-bound' otherlv_15= ':' ( (lv_timeBound_16_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_17= 'scheduled' otherlv_18= ':' ( (lv_scheduled_19_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_20_0= ruleXProperty ) ) )* otherlv_21= '}' )? )
            {
            // InternalTmscXtext.g:1122:2: ( ( ( (lv_ipcClient_0_0= 'ipc-client' ) ) | ( (lv_ipcServer_1_0= 'ipc-server' ) ) )? otherlv_2= 'function' ( ( (lv_description_3_0= ruleIDString ) ) otherlv_4= 'as' )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '(' ( (lv_parameters_7_0= ruleXFunctionParameter ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleXFunctionParameter ) ) )* otherlv_10= ')' )? (otherlv_11= 'implements' ( ( ruleFQN ) ) )? (otherlv_13= '{' ( (otherlv_14= 'time-bound' otherlv_15= ':' ( (lv_timeBound_16_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_17= 'scheduled' otherlv_18= ':' ( (lv_scheduled_19_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_20_0= ruleXProperty ) ) )* otherlv_21= '}' )? )
            // InternalTmscXtext.g:1123:3: ( ( (lv_ipcClient_0_0= 'ipc-client' ) ) | ( (lv_ipcServer_1_0= 'ipc-server' ) ) )? otherlv_2= 'function' ( ( (lv_description_3_0= ruleIDString ) ) otherlv_4= 'as' )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '(' ( (lv_parameters_7_0= ruleXFunctionParameter ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleXFunctionParameter ) ) )* otherlv_10= ')' )? (otherlv_11= 'implements' ( ( ruleFQN ) ) )? (otherlv_13= '{' ( (otherlv_14= 'time-bound' otherlv_15= ':' ( (lv_timeBound_16_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_17= 'scheduled' otherlv_18= ':' ( (lv_scheduled_19_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_20_0= ruleXProperty ) ) )* otherlv_21= '}' )?
            {
            // InternalTmscXtext.g:1123:3: ( ( (lv_ipcClient_0_0= 'ipc-client' ) ) | ( (lv_ipcServer_1_0= 'ipc-server' ) ) )?
            int alt24=3;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==35) ) {
                alt24=1;
            }
            else if ( (LA24_0==36) ) {
                alt24=2;
            }
            switch (alt24) {
                case 1 :
                    // InternalTmscXtext.g:1124:4: ( (lv_ipcClient_0_0= 'ipc-client' ) )
                    {
                    // InternalTmscXtext.g:1124:4: ( (lv_ipcClient_0_0= 'ipc-client' ) )
                    // InternalTmscXtext.g:1125:5: (lv_ipcClient_0_0= 'ipc-client' )
                    {
                    // InternalTmscXtext.g:1125:5: (lv_ipcClient_0_0= 'ipc-client' )
                    // InternalTmscXtext.g:1126:6: lv_ipcClient_0_0= 'ipc-client'
                    {
                    lv_ipcClient_0_0=(Token)match(input,35,FOLLOW_26); if (state.failed) return current;
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
                    // InternalTmscXtext.g:1139:4: ( (lv_ipcServer_1_0= 'ipc-server' ) )
                    {
                    // InternalTmscXtext.g:1139:4: ( (lv_ipcServer_1_0= 'ipc-server' ) )
                    // InternalTmscXtext.g:1140:5: (lv_ipcServer_1_0= 'ipc-server' )
                    {
                    // InternalTmscXtext.g:1140:5: (lv_ipcServer_1_0= 'ipc-server' )
                    // InternalTmscXtext.g:1141:6: lv_ipcServer_1_0= 'ipc-server'
                    {
                    lv_ipcServer_1_0=(Token)match(input,36,FOLLOW_26); if (state.failed) return current;
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

            otherlv_2=(Token)match(input,37,FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getXFunctionAccess().getFunctionKeyword_1());
              		
            }
            // InternalTmscXtext.g:1158:3: ( ( (lv_description_3_0= ruleIDString ) ) otherlv_4= 'as' )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==RULE_ID) ) {
                int LA25_1 = input.LA(2);

                if ( (LA25_1==29) ) {
                    alt25=1;
                }
            }
            else if ( (LA25_0==RULE_STRING) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalTmscXtext.g:1159:4: ( (lv_description_3_0= ruleIDString ) ) otherlv_4= 'as'
                    {
                    // InternalTmscXtext.g:1159:4: ( (lv_description_3_0= ruleIDString ) )
                    // InternalTmscXtext.g:1160:5: (lv_description_3_0= ruleIDString )
                    {
                    // InternalTmscXtext.g:1160:5: (lv_description_3_0= ruleIDString )
                    // InternalTmscXtext.g:1161:6: lv_description_3_0= ruleIDString
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getXFunctionAccess().getDescriptionIDStringParserRuleCall_2_0_0());
                      					
                    }
                    pushFollow(FOLLOW_20);
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

                    otherlv_4=(Token)match(input,29,FOLLOW_21); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getXFunctionAccess().getAsKeyword_2_1());
                      			
                    }

                    }
                    break;

            }

            // InternalTmscXtext.g:1183:3: ( (lv_name_5_0= RULE_ID ) )
            // InternalTmscXtext.g:1184:4: (lv_name_5_0= RULE_ID )
            {
            // InternalTmscXtext.g:1184:4: (lv_name_5_0= RULE_ID )
            // InternalTmscXtext.g:1185:5: lv_name_5_0= RULE_ID
            {
            lv_name_5_0=(Token)match(input,RULE_ID,FOLLOW_27); if (state.failed) return current;
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

            // InternalTmscXtext.g:1201:3: (otherlv_6= '(' ( (lv_parameters_7_0= ruleXFunctionParameter ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleXFunctionParameter ) ) )* otherlv_10= ')' )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==38) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalTmscXtext.g:1202:4: otherlv_6= '(' ( (lv_parameters_7_0= ruleXFunctionParameter ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleXFunctionParameter ) ) )* otherlv_10= ')'
                    {
                    otherlv_6=(Token)match(input,38,FOLLOW_28); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_6, grammarAccess.getXFunctionAccess().getLeftParenthesisKeyword_4_0());
                      			
                    }
                    // InternalTmscXtext.g:1206:4: ( (lv_parameters_7_0= ruleXFunctionParameter ) )
                    // InternalTmscXtext.g:1207:5: (lv_parameters_7_0= ruleXFunctionParameter )
                    {
                    // InternalTmscXtext.g:1207:5: (lv_parameters_7_0= ruleXFunctionParameter )
                    // InternalTmscXtext.g:1208:6: lv_parameters_7_0= ruleXFunctionParameter
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getXFunctionAccess().getParametersXFunctionParameterParserRuleCall_4_1_0());
                      					
                    }
                    pushFollow(FOLLOW_29);
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

                    // InternalTmscXtext.g:1225:4: (otherlv_8= ',' ( (lv_parameters_9_0= ruleXFunctionParameter ) ) )*
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( (LA26_0==33) ) {
                            alt26=1;
                        }


                        switch (alt26) {
                    	case 1 :
                    	    // InternalTmscXtext.g:1226:5: otherlv_8= ',' ( (lv_parameters_9_0= ruleXFunctionParameter ) )
                    	    {
                    	    otherlv_8=(Token)match(input,33,FOLLOW_28); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_8, grammarAccess.getXFunctionAccess().getCommaKeyword_4_2_0());
                    	      				
                    	    }
                    	    // InternalTmscXtext.g:1230:5: ( (lv_parameters_9_0= ruleXFunctionParameter ) )
                    	    // InternalTmscXtext.g:1231:6: (lv_parameters_9_0= ruleXFunctionParameter )
                    	    {
                    	    // InternalTmscXtext.g:1231:6: (lv_parameters_9_0= ruleXFunctionParameter )
                    	    // InternalTmscXtext.g:1232:7: lv_parameters_9_0= ruleXFunctionParameter
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getXFunctionAccess().getParametersXFunctionParameterParserRuleCall_4_2_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_29);
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
                    	    break loop26;
                        }
                    } while (true);

                    otherlv_10=(Token)match(input,39,FOLLOW_30); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_10, grammarAccess.getXFunctionAccess().getRightParenthesisKeyword_4_3());
                      			
                    }

                    }
                    break;

            }

            // InternalTmscXtext.g:1255:3: (otherlv_11= 'implements' ( ( ruleFQN ) ) )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==40) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalTmscXtext.g:1256:4: otherlv_11= 'implements' ( ( ruleFQN ) )
                    {
                    otherlv_11=(Token)match(input,40,FOLLOW_21); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_11, grammarAccess.getXFunctionAccess().getImplementsKeyword_5_0());
                      			
                    }
                    // InternalTmscXtext.g:1260:4: ( ( ruleFQN ) )
                    // InternalTmscXtext.g:1261:5: ( ruleFQN )
                    {
                    // InternalTmscXtext.g:1261:5: ( ruleFQN )
                    // InternalTmscXtext.g:1262:6: ruleFQN
                    {
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getXFunctionRule());
                      						}
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getXFunctionAccess().getOperationXOperationCrossReference_5_1_0());
                      					
                    }
                    pushFollow(FOLLOW_14);
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

            // InternalTmscXtext.g:1277:3: (otherlv_13= '{' ( (otherlv_14= 'time-bound' otherlv_15= ':' ( (lv_timeBound_16_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_17= 'scheduled' otherlv_18= ':' ( (lv_scheduled_19_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_20_0= ruleXProperty ) ) )* otherlv_21= '}' )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==15) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalTmscXtext.g:1278:4: otherlv_13= '{' ( (otherlv_14= 'time-bound' otherlv_15= ':' ( (lv_timeBound_16_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_17= 'scheduled' otherlv_18= ':' ( (lv_scheduled_19_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_20_0= ruleXProperty ) ) )* otherlv_21= '}'
                    {
                    otherlv_13=(Token)match(input,15,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_13, grammarAccess.getXFunctionAccess().getLeftCurlyBracketKeyword_6_0());
                      			
                    }
                    // InternalTmscXtext.g:1282:4: ( (otherlv_14= 'time-bound' otherlv_15= ':' ( (lv_timeBound_16_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_17= 'scheduled' otherlv_18= ':' ( (lv_scheduled_19_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_20_0= ruleXProperty ) ) )*
                    loop29:
                    do {
                        int alt29=4;
                        switch ( input.LA(1) ) {
                        case 18:
                            {
                            alt29=1;
                            }
                            break;
                        case 19:
                            {
                            alt29=2;
                            }
                            break;
                        case RULE_ID:
                        case RULE_STRING:
                            {
                            alt29=3;
                            }
                            break;

                        }

                        switch (alt29) {
                    	case 1 :
                    	    // InternalTmscXtext.g:1283:5: (otherlv_14= 'time-bound' otherlv_15= ':' ( (lv_timeBound_16_0= RULE_ABS_EBIGDECIMAL ) ) )
                    	    {
                    	    // InternalTmscXtext.g:1283:5: (otherlv_14= 'time-bound' otherlv_15= ':' ( (lv_timeBound_16_0= RULE_ABS_EBIGDECIMAL ) ) )
                    	    // InternalTmscXtext.g:1284:6: otherlv_14= 'time-bound' otherlv_15= ':' ( (lv_timeBound_16_0= RULE_ABS_EBIGDECIMAL ) )
                    	    {
                    	    otherlv_14=(Token)match(input,18,FOLLOW_6); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_14, grammarAccess.getXFunctionAccess().getTimeBoundKeyword_6_1_0_0());
                    	      					
                    	    }
                    	    otherlv_15=(Token)match(input,17,FOLLOW_8); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_15, grammarAccess.getXFunctionAccess().getColonKeyword_6_1_0_1());
                    	      					
                    	    }
                    	    // InternalTmscXtext.g:1292:6: ( (lv_timeBound_16_0= RULE_ABS_EBIGDECIMAL ) )
                    	    // InternalTmscXtext.g:1293:7: (lv_timeBound_16_0= RULE_ABS_EBIGDECIMAL )
                    	    {
                    	    // InternalTmscXtext.g:1293:7: (lv_timeBound_16_0= RULE_ABS_EBIGDECIMAL )
                    	    // InternalTmscXtext.g:1294:8: lv_timeBound_16_0= RULE_ABS_EBIGDECIMAL
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
                    	    // InternalTmscXtext.g:1312:5: (otherlv_17= 'scheduled' otherlv_18= ':' ( (lv_scheduled_19_0= ruleEBOOLEAN_OBJECT ) ) )
                    	    {
                    	    // InternalTmscXtext.g:1312:5: (otherlv_17= 'scheduled' otherlv_18= ':' ( (lv_scheduled_19_0= ruleEBOOLEAN_OBJECT ) ) )
                    	    // InternalTmscXtext.g:1313:6: otherlv_17= 'scheduled' otherlv_18= ':' ( (lv_scheduled_19_0= ruleEBOOLEAN_OBJECT ) )
                    	    {
                    	    otherlv_17=(Token)match(input,19,FOLLOW_6); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_17, grammarAccess.getXFunctionAccess().getScheduledKeyword_6_1_1_0());
                    	      					
                    	    }
                    	    otherlv_18=(Token)match(input,17,FOLLOW_9); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_18, grammarAccess.getXFunctionAccess().getColonKeyword_6_1_1_1());
                    	      					
                    	    }
                    	    // InternalTmscXtext.g:1321:6: ( (lv_scheduled_19_0= ruleEBOOLEAN_OBJECT ) )
                    	    // InternalTmscXtext.g:1322:7: (lv_scheduled_19_0= ruleEBOOLEAN_OBJECT )
                    	    {
                    	    // InternalTmscXtext.g:1322:7: (lv_scheduled_19_0= ruleEBOOLEAN_OBJECT )
                    	    // InternalTmscXtext.g:1323:8: lv_scheduled_19_0= ruleEBOOLEAN_OBJECT
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
                    	    // InternalTmscXtext.g:1342:5: ( (lv_properties_20_0= ruleXProperty ) )
                    	    {
                    	    // InternalTmscXtext.g:1342:5: ( (lv_properties_20_0= ruleXProperty ) )
                    	    // InternalTmscXtext.g:1343:6: (lv_properties_20_0= ruleXProperty )
                    	    {
                    	    // InternalTmscXtext.g:1343:6: (lv_properties_20_0= ruleXProperty )
                    	    // InternalTmscXtext.g:1344:7: lv_properties_20_0= ruleXProperty
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
                    	    break loop29;
                        }
                    } while (true);

                    otherlv_21=(Token)match(input,22,FOLLOW_2); if (state.failed) return current;
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
    // InternalTmscXtext.g:1371:1: entryRuleXFunctionParameter returns [EObject current=null] : iv_ruleXFunctionParameter= ruleXFunctionParameter EOF ;
    public final EObject entryRuleXFunctionParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXFunctionParameter = null;


        try {
            // InternalTmscXtext.g:1371:59: (iv_ruleXFunctionParameter= ruleXFunctionParameter EOF )
            // InternalTmscXtext.g:1372:2: iv_ruleXFunctionParameter= ruleXFunctionParameter EOF
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
    // InternalTmscXtext.g:1378:1: ruleXFunctionParameter returns [EObject current=null] : ( ( (lv_kind_0_0= ruleXFunctionParameterKind ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_properties_3_0= ruleXProperty ) ) (otherlv_4= ',' ( (lv_properties_5_0= ruleXProperty ) ) )* otherlv_6= ')' )? ) ;
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
            // InternalTmscXtext.g:1384:2: ( ( ( (lv_kind_0_0= ruleXFunctionParameterKind ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_properties_3_0= ruleXProperty ) ) (otherlv_4= ',' ( (lv_properties_5_0= ruleXProperty ) ) )* otherlv_6= ')' )? ) )
            // InternalTmscXtext.g:1385:2: ( ( (lv_kind_0_0= ruleXFunctionParameterKind ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_properties_3_0= ruleXProperty ) ) (otherlv_4= ',' ( (lv_properties_5_0= ruleXProperty ) ) )* otherlv_6= ')' )? )
            {
            // InternalTmscXtext.g:1385:2: ( ( (lv_kind_0_0= ruleXFunctionParameterKind ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_properties_3_0= ruleXProperty ) ) (otherlv_4= ',' ( (lv_properties_5_0= ruleXProperty ) ) )* otherlv_6= ')' )? )
            // InternalTmscXtext.g:1386:3: ( (lv_kind_0_0= ruleXFunctionParameterKind ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_properties_3_0= ruleXProperty ) ) (otherlv_4= ',' ( (lv_properties_5_0= ruleXProperty ) ) )* otherlv_6= ')' )?
            {
            // InternalTmscXtext.g:1386:3: ( (lv_kind_0_0= ruleXFunctionParameterKind ) )
            // InternalTmscXtext.g:1387:4: (lv_kind_0_0= ruleXFunctionParameterKind )
            {
            // InternalTmscXtext.g:1387:4: (lv_kind_0_0= ruleXFunctionParameterKind )
            // InternalTmscXtext.g:1388:5: lv_kind_0_0= ruleXFunctionParameterKind
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getXFunctionParameterAccess().getKindXFunctionParameterKindEnumRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_21);
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

            // InternalTmscXtext.g:1405:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalTmscXtext.g:1406:4: (lv_name_1_0= RULE_ID )
            {
            // InternalTmscXtext.g:1406:4: (lv_name_1_0= RULE_ID )
            // InternalTmscXtext.g:1407:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_31); if (state.failed) return current;
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

            // InternalTmscXtext.g:1423:3: (otherlv_2= '(' ( (lv_properties_3_0= ruleXProperty ) ) (otherlv_4= ',' ( (lv_properties_5_0= ruleXProperty ) ) )* otherlv_6= ')' )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==38) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalTmscXtext.g:1424:4: otherlv_2= '(' ( (lv_properties_3_0= ruleXProperty ) ) (otherlv_4= ',' ( (lv_properties_5_0= ruleXProperty ) ) )* otherlv_6= ')'
                    {
                    otherlv_2=(Token)match(input,38,FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getXFunctionParameterAccess().getLeftParenthesisKeyword_2_0());
                      			
                    }
                    // InternalTmscXtext.g:1428:4: ( (lv_properties_3_0= ruleXProperty ) )
                    // InternalTmscXtext.g:1429:5: (lv_properties_3_0= ruleXProperty )
                    {
                    // InternalTmscXtext.g:1429:5: (lv_properties_3_0= ruleXProperty )
                    // InternalTmscXtext.g:1430:6: lv_properties_3_0= ruleXProperty
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getXFunctionParameterAccess().getPropertiesXPropertyParserRuleCall_2_1_0());
                      					
                    }
                    pushFollow(FOLLOW_29);
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

                    // InternalTmscXtext.g:1447:4: (otherlv_4= ',' ( (lv_properties_5_0= ruleXProperty ) ) )*
                    loop31:
                    do {
                        int alt31=2;
                        int LA31_0 = input.LA(1);

                        if ( (LA31_0==33) ) {
                            alt31=1;
                        }


                        switch (alt31) {
                    	case 1 :
                    	    // InternalTmscXtext.g:1448:5: otherlv_4= ',' ( (lv_properties_5_0= ruleXProperty ) )
                    	    {
                    	    otherlv_4=(Token)match(input,33,FOLLOW_19); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_4, grammarAccess.getXFunctionParameterAccess().getCommaKeyword_2_2_0());
                    	      				
                    	    }
                    	    // InternalTmscXtext.g:1452:5: ( (lv_properties_5_0= ruleXProperty ) )
                    	    // InternalTmscXtext.g:1453:6: (lv_properties_5_0= ruleXProperty )
                    	    {
                    	    // InternalTmscXtext.g:1453:6: (lv_properties_5_0= ruleXProperty )
                    	    // InternalTmscXtext.g:1454:7: lv_properties_5_0= ruleXProperty
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getXFunctionParameterAccess().getPropertiesXPropertyParserRuleCall_2_2_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_29);
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
                    	    break loop31;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,39,FOLLOW_2); if (state.failed) return current;
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
    // InternalTmscXtext.g:1481:1: entryRuleXHost returns [EObject current=null] : iv_ruleXHost= ruleXHost EOF ;
    public final EObject entryRuleXHost() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXHost = null;


        try {
            // InternalTmscXtext.g:1481:46: (iv_ruleXHost= ruleXHost EOF )
            // InternalTmscXtext.g:1482:2: iv_ruleXHost= ruleXHost EOF
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
    // InternalTmscXtext.g:1488:1: ruleXHost returns [EObject current=null] : ( ( (lv_untraced_0_0= 'untraced' ) )? otherlv_1= 'host' ( ( (lv_description_2_0= ruleIDString ) ) otherlv_3= 'as' )? ( (lv_name_4_0= RULE_ID ) ) (otherlv_5= '{' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) | ( (lv_executors_13_0= ruleXExecutor ) ) )* otherlv_14= '}' )? ) ;
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
            // InternalTmscXtext.g:1494:2: ( ( ( (lv_untraced_0_0= 'untraced' ) )? otherlv_1= 'host' ( ( (lv_description_2_0= ruleIDString ) ) otherlv_3= 'as' )? ( (lv_name_4_0= RULE_ID ) ) (otherlv_5= '{' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) | ( (lv_executors_13_0= ruleXExecutor ) ) )* otherlv_14= '}' )? ) )
            // InternalTmscXtext.g:1495:2: ( ( (lv_untraced_0_0= 'untraced' ) )? otherlv_1= 'host' ( ( (lv_description_2_0= ruleIDString ) ) otherlv_3= 'as' )? ( (lv_name_4_0= RULE_ID ) ) (otherlv_5= '{' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) | ( (lv_executors_13_0= ruleXExecutor ) ) )* otherlv_14= '}' )? )
            {
            // InternalTmscXtext.g:1495:2: ( ( (lv_untraced_0_0= 'untraced' ) )? otherlv_1= 'host' ( ( (lv_description_2_0= ruleIDString ) ) otherlv_3= 'as' )? ( (lv_name_4_0= RULE_ID ) ) (otherlv_5= '{' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) | ( (lv_executors_13_0= ruleXExecutor ) ) )* otherlv_14= '}' )? )
            // InternalTmscXtext.g:1496:3: ( (lv_untraced_0_0= 'untraced' ) )? otherlv_1= 'host' ( ( (lv_description_2_0= ruleIDString ) ) otherlv_3= 'as' )? ( (lv_name_4_0= RULE_ID ) ) (otherlv_5= '{' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) | ( (lv_executors_13_0= ruleXExecutor ) ) )* otherlv_14= '}' )?
            {
            // InternalTmscXtext.g:1496:3: ( (lv_untraced_0_0= 'untraced' ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==41) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalTmscXtext.g:1497:4: (lv_untraced_0_0= 'untraced' )
                    {
                    // InternalTmscXtext.g:1497:4: (lv_untraced_0_0= 'untraced' )
                    // InternalTmscXtext.g:1498:5: lv_untraced_0_0= 'untraced'
                    {
                    lv_untraced_0_0=(Token)match(input,41,FOLLOW_32); if (state.failed) return current;
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

            otherlv_1=(Token)match(input,42,FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getXHostAccess().getHostKeyword_1());
              		
            }
            // InternalTmscXtext.g:1514:3: ( ( (lv_description_2_0= ruleIDString ) ) otherlv_3= 'as' )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==RULE_ID) ) {
                int LA34_1 = input.LA(2);

                if ( (LA34_1==29) ) {
                    alt34=1;
                }
            }
            else if ( (LA34_0==RULE_STRING) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalTmscXtext.g:1515:4: ( (lv_description_2_0= ruleIDString ) ) otherlv_3= 'as'
                    {
                    // InternalTmscXtext.g:1515:4: ( (lv_description_2_0= ruleIDString ) )
                    // InternalTmscXtext.g:1516:5: (lv_description_2_0= ruleIDString )
                    {
                    // InternalTmscXtext.g:1516:5: (lv_description_2_0= ruleIDString )
                    // InternalTmscXtext.g:1517:6: lv_description_2_0= ruleIDString
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getXHostAccess().getDescriptionIDStringParserRuleCall_2_0_0());
                      					
                    }
                    pushFollow(FOLLOW_20);
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

                    otherlv_3=(Token)match(input,29,FOLLOW_21); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getXHostAccess().getAsKeyword_2_1());
                      			
                    }

                    }
                    break;

            }

            // InternalTmscXtext.g:1539:3: ( (lv_name_4_0= RULE_ID ) )
            // InternalTmscXtext.g:1540:4: (lv_name_4_0= RULE_ID )
            {
            // InternalTmscXtext.g:1540:4: (lv_name_4_0= RULE_ID )
            // InternalTmscXtext.g:1541:5: lv_name_4_0= RULE_ID
            {
            lv_name_4_0=(Token)match(input,RULE_ID,FOLLOW_14); if (state.failed) return current;
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

            // InternalTmscXtext.g:1557:3: (otherlv_5= '{' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) | ( (lv_executors_13_0= ruleXExecutor ) ) )* otherlv_14= '}' )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==15) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalTmscXtext.g:1558:4: otherlv_5= '{' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) | ( (lv_executors_13_0= ruleXExecutor ) ) )* otherlv_14= '}'
                    {
                    otherlv_5=(Token)match(input,15,FOLLOW_33); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getXHostAccess().getLeftCurlyBracketKeyword_4_0());
                      			
                    }
                    // InternalTmscXtext.g:1562:4: ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) | ( (lv_executors_13_0= ruleXExecutor ) ) )*
                    loop35:
                    do {
                        int alt35=5;
                        switch ( input.LA(1) ) {
                        case 18:
                            {
                            alt35=1;
                            }
                            break;
                        case 19:
                            {
                            alt35=2;
                            }
                            break;
                        case RULE_ID:
                        case RULE_STRING:
                            {
                            alt35=3;
                            }
                            break;
                        case 41:
                        case 43:
                            {
                            alt35=4;
                            }
                            break;

                        }

                        switch (alt35) {
                    	case 1 :
                    	    // InternalTmscXtext.g:1563:5: (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) )
                    	    {
                    	    // InternalTmscXtext.g:1563:5: (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) )
                    	    // InternalTmscXtext.g:1564:6: otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) )
                    	    {
                    	    otherlv_6=(Token)match(input,18,FOLLOW_6); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_6, grammarAccess.getXHostAccess().getTimeBoundKeyword_4_1_0_0());
                    	      					
                    	    }
                    	    otherlv_7=(Token)match(input,17,FOLLOW_8); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_7, grammarAccess.getXHostAccess().getColonKeyword_4_1_0_1());
                    	      					
                    	    }
                    	    // InternalTmscXtext.g:1572:6: ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) )
                    	    // InternalTmscXtext.g:1573:7: (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL )
                    	    {
                    	    // InternalTmscXtext.g:1573:7: (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL )
                    	    // InternalTmscXtext.g:1574:8: lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL
                    	    {
                    	    lv_timeBound_8_0=(Token)match(input,RULE_ABS_EBIGDECIMAL,FOLLOW_33); if (state.failed) return current;
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
                    	    // InternalTmscXtext.g:1592:5: (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) )
                    	    {
                    	    // InternalTmscXtext.g:1592:5: (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) )
                    	    // InternalTmscXtext.g:1593:6: otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) )
                    	    {
                    	    otherlv_9=(Token)match(input,19,FOLLOW_6); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_9, grammarAccess.getXHostAccess().getScheduledKeyword_4_1_1_0());
                    	      					
                    	    }
                    	    otherlv_10=(Token)match(input,17,FOLLOW_9); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_10, grammarAccess.getXHostAccess().getColonKeyword_4_1_1_1());
                    	      					
                    	    }
                    	    // InternalTmscXtext.g:1601:6: ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) )
                    	    // InternalTmscXtext.g:1602:7: (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT )
                    	    {
                    	    // InternalTmscXtext.g:1602:7: (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT )
                    	    // InternalTmscXtext.g:1603:8: lv_scheduled_11_0= ruleEBOOLEAN_OBJECT
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      								newCompositeNode(grammarAccess.getXHostAccess().getScheduledEBOOLEAN_OBJECTParserRuleCall_4_1_1_2_0());
                    	      							
                    	    }
                    	    pushFollow(FOLLOW_33);
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
                    	    // InternalTmscXtext.g:1622:5: ( (lv_properties_12_0= ruleXProperty ) )
                    	    {
                    	    // InternalTmscXtext.g:1622:5: ( (lv_properties_12_0= ruleXProperty ) )
                    	    // InternalTmscXtext.g:1623:6: (lv_properties_12_0= ruleXProperty )
                    	    {
                    	    // InternalTmscXtext.g:1623:6: (lv_properties_12_0= ruleXProperty )
                    	    // InternalTmscXtext.g:1624:7: lv_properties_12_0= ruleXProperty
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getXHostAccess().getPropertiesXPropertyParserRuleCall_4_1_2_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_33);
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
                    	    // InternalTmscXtext.g:1642:5: ( (lv_executors_13_0= ruleXExecutor ) )
                    	    {
                    	    // InternalTmscXtext.g:1642:5: ( (lv_executors_13_0= ruleXExecutor ) )
                    	    // InternalTmscXtext.g:1643:6: (lv_executors_13_0= ruleXExecutor )
                    	    {
                    	    // InternalTmscXtext.g:1643:6: (lv_executors_13_0= ruleXExecutor )
                    	    // InternalTmscXtext.g:1644:7: lv_executors_13_0= ruleXExecutor
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getXHostAccess().getExecutorsXExecutorParserRuleCall_4_1_3_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_33);
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
                    	    break loop35;
                        }
                    } while (true);

                    otherlv_14=(Token)match(input,22,FOLLOW_2); if (state.failed) return current;
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
    // InternalTmscXtext.g:1671:1: entryRuleXExecutor returns [EObject current=null] : iv_ruleXExecutor= ruleXExecutor EOF ;
    public final EObject entryRuleXExecutor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXExecutor = null;


        try {
            // InternalTmscXtext.g:1671:50: (iv_ruleXExecutor= ruleXExecutor EOF )
            // InternalTmscXtext.g:1672:2: iv_ruleXExecutor= ruleXExecutor EOF
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
    // InternalTmscXtext.g:1678:1: ruleXExecutor returns [EObject current=null] : ( ( (lv_untraced_0_0= 'untraced' ) )? otherlv_1= 'executor' ( ( (lv_description_2_0= ruleIDString ) ) otherlv_3= 'as' )? ( (lv_name_4_0= RULE_ID ) ) (otherlv_5= '{' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) )* otherlv_13= '}' )? ) ;
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
            // InternalTmscXtext.g:1684:2: ( ( ( (lv_untraced_0_0= 'untraced' ) )? otherlv_1= 'executor' ( ( (lv_description_2_0= ruleIDString ) ) otherlv_3= 'as' )? ( (lv_name_4_0= RULE_ID ) ) (otherlv_5= '{' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) )* otherlv_13= '}' )? ) )
            // InternalTmscXtext.g:1685:2: ( ( (lv_untraced_0_0= 'untraced' ) )? otherlv_1= 'executor' ( ( (lv_description_2_0= ruleIDString ) ) otherlv_3= 'as' )? ( (lv_name_4_0= RULE_ID ) ) (otherlv_5= '{' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) )* otherlv_13= '}' )? )
            {
            // InternalTmscXtext.g:1685:2: ( ( (lv_untraced_0_0= 'untraced' ) )? otherlv_1= 'executor' ( ( (lv_description_2_0= ruleIDString ) ) otherlv_3= 'as' )? ( (lv_name_4_0= RULE_ID ) ) (otherlv_5= '{' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) )* otherlv_13= '}' )? )
            // InternalTmscXtext.g:1686:3: ( (lv_untraced_0_0= 'untraced' ) )? otherlv_1= 'executor' ( ( (lv_description_2_0= ruleIDString ) ) otherlv_3= 'as' )? ( (lv_name_4_0= RULE_ID ) ) (otherlv_5= '{' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) )* otherlv_13= '}' )?
            {
            // InternalTmscXtext.g:1686:3: ( (lv_untraced_0_0= 'untraced' ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==41) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalTmscXtext.g:1687:4: (lv_untraced_0_0= 'untraced' )
                    {
                    // InternalTmscXtext.g:1687:4: (lv_untraced_0_0= 'untraced' )
                    // InternalTmscXtext.g:1688:5: lv_untraced_0_0= 'untraced'
                    {
                    lv_untraced_0_0=(Token)match(input,41,FOLLOW_34); if (state.failed) return current;
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

            otherlv_1=(Token)match(input,43,FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getXExecutorAccess().getExecutorKeyword_1());
              		
            }
            // InternalTmscXtext.g:1704:3: ( ( (lv_description_2_0= ruleIDString ) ) otherlv_3= 'as' )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==RULE_ID) ) {
                int LA38_1 = input.LA(2);

                if ( (LA38_1==29) ) {
                    alt38=1;
                }
            }
            else if ( (LA38_0==RULE_STRING) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalTmscXtext.g:1705:4: ( (lv_description_2_0= ruleIDString ) ) otherlv_3= 'as'
                    {
                    // InternalTmscXtext.g:1705:4: ( (lv_description_2_0= ruleIDString ) )
                    // InternalTmscXtext.g:1706:5: (lv_description_2_0= ruleIDString )
                    {
                    // InternalTmscXtext.g:1706:5: (lv_description_2_0= ruleIDString )
                    // InternalTmscXtext.g:1707:6: lv_description_2_0= ruleIDString
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getXExecutorAccess().getDescriptionIDStringParserRuleCall_2_0_0());
                      					
                    }
                    pushFollow(FOLLOW_20);
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

                    otherlv_3=(Token)match(input,29,FOLLOW_21); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getXExecutorAccess().getAsKeyword_2_1());
                      			
                    }

                    }
                    break;

            }

            // InternalTmscXtext.g:1729:3: ( (lv_name_4_0= RULE_ID ) )
            // InternalTmscXtext.g:1730:4: (lv_name_4_0= RULE_ID )
            {
            // InternalTmscXtext.g:1730:4: (lv_name_4_0= RULE_ID )
            // InternalTmscXtext.g:1731:5: lv_name_4_0= RULE_ID
            {
            lv_name_4_0=(Token)match(input,RULE_ID,FOLLOW_14); if (state.failed) return current;
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

            // InternalTmscXtext.g:1747:3: (otherlv_5= '{' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) )* otherlv_13= '}' )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==15) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // InternalTmscXtext.g:1748:4: otherlv_5= '{' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) )* otherlv_13= '}'
                    {
                    otherlv_5=(Token)match(input,15,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getXExecutorAccess().getLeftCurlyBracketKeyword_4_0());
                      			
                    }
                    // InternalTmscXtext.g:1752:4: ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) )*
                    loop39:
                    do {
                        int alt39=4;
                        switch ( input.LA(1) ) {
                        case 18:
                            {
                            alt39=1;
                            }
                            break;
                        case 19:
                            {
                            alt39=2;
                            }
                            break;
                        case RULE_ID:
                        case RULE_STRING:
                            {
                            alt39=3;
                            }
                            break;

                        }

                        switch (alt39) {
                    	case 1 :
                    	    // InternalTmscXtext.g:1753:5: (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) )
                    	    {
                    	    // InternalTmscXtext.g:1753:5: (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) )
                    	    // InternalTmscXtext.g:1754:6: otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) )
                    	    {
                    	    otherlv_6=(Token)match(input,18,FOLLOW_6); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_6, grammarAccess.getXExecutorAccess().getTimeBoundKeyword_4_1_0_0());
                    	      					
                    	    }
                    	    otherlv_7=(Token)match(input,17,FOLLOW_8); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_7, grammarAccess.getXExecutorAccess().getColonKeyword_4_1_0_1());
                    	      					
                    	    }
                    	    // InternalTmscXtext.g:1762:6: ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) )
                    	    // InternalTmscXtext.g:1763:7: (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL )
                    	    {
                    	    // InternalTmscXtext.g:1763:7: (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL )
                    	    // InternalTmscXtext.g:1764:8: lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL
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
                    	    // InternalTmscXtext.g:1782:5: (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) )
                    	    {
                    	    // InternalTmscXtext.g:1782:5: (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) )
                    	    // InternalTmscXtext.g:1783:6: otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) )
                    	    {
                    	    otherlv_9=(Token)match(input,19,FOLLOW_6); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_9, grammarAccess.getXExecutorAccess().getScheduledKeyword_4_1_1_0());
                    	      					
                    	    }
                    	    otherlv_10=(Token)match(input,17,FOLLOW_9); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_10, grammarAccess.getXExecutorAccess().getColonKeyword_4_1_1_1());
                    	      					
                    	    }
                    	    // InternalTmscXtext.g:1791:6: ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) )
                    	    // InternalTmscXtext.g:1792:7: (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT )
                    	    {
                    	    // InternalTmscXtext.g:1792:7: (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT )
                    	    // InternalTmscXtext.g:1793:8: lv_scheduled_11_0= ruleEBOOLEAN_OBJECT
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
                    	    // InternalTmscXtext.g:1812:5: ( (lv_properties_12_0= ruleXProperty ) )
                    	    {
                    	    // InternalTmscXtext.g:1812:5: ( (lv_properties_12_0= ruleXProperty ) )
                    	    // InternalTmscXtext.g:1813:6: (lv_properties_12_0= ruleXProperty )
                    	    {
                    	    // InternalTmscXtext.g:1813:6: (lv_properties_12_0= ruleXProperty )
                    	    // InternalTmscXtext.g:1814:7: lv_properties_12_0= ruleXProperty
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
                    	    break loop39;
                        }
                    } while (true);

                    otherlv_13=(Token)match(input,22,FOLLOW_2); if (state.failed) return current;
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
    // InternalTmscXtext.g:1841:1: entryRuleXEvent returns [EObject current=null] : iv_ruleXEvent= ruleXEvent EOF ;
    public final EObject entryRuleXEvent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXEvent = null;


        try {
            // InternalTmscXtext.g:1841:47: (iv_ruleXEvent= ruleXEvent EOF )
            // InternalTmscXtext.g:1842:2: iv_ruleXEvent= ruleXEvent EOF
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
    // InternalTmscXtext.g:1848:1: ruleXEvent returns [EObject current=null] : ( ( ( (lv_timestamp_0_1= RULE_ISO8601 | lv_timestamp_0_2= RULE_ABS_EBIGDECIMAL ) ) )? ( (lv_timeBound_1_0= RULE_POS_EBIGDECIMAL ) )? ( ( ruleFQNString ) ) ( ( ruleIDString ) )? ( (lv_type_4_0= ruleXEventType ) ) ( ( ruleIDString ) ) (otherlv_6= '(' ( (lv_arguments_7_0= ruleXEventArgument ) ) (otherlv_8= ',' ( (lv_arguments_9_0= ruleXEventArgument ) ) )* otherlv_10= ')' )? ( (otherlv_11= '!' ( (lv_outgoingDependencies_12_0= ruleXDependency ) ) ) | (otherlv_13= '?' ( ( ruleIDString ) ) ) )* (otherlv_15= '{' ( (otherlv_16= 'time-bound' otherlv_17= ':' ( (lv_timeBound_18_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_19= 'scheduled' otherlv_20= ':' ( (lv_scheduled_21_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_22_0= ruleXProperty ) ) )* otherlv_23= '}' )? ) ;
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
            // InternalTmscXtext.g:1854:2: ( ( ( ( (lv_timestamp_0_1= RULE_ISO8601 | lv_timestamp_0_2= RULE_ABS_EBIGDECIMAL ) ) )? ( (lv_timeBound_1_0= RULE_POS_EBIGDECIMAL ) )? ( ( ruleFQNString ) ) ( ( ruleIDString ) )? ( (lv_type_4_0= ruleXEventType ) ) ( ( ruleIDString ) ) (otherlv_6= '(' ( (lv_arguments_7_0= ruleXEventArgument ) ) (otherlv_8= ',' ( (lv_arguments_9_0= ruleXEventArgument ) ) )* otherlv_10= ')' )? ( (otherlv_11= '!' ( (lv_outgoingDependencies_12_0= ruleXDependency ) ) ) | (otherlv_13= '?' ( ( ruleIDString ) ) ) )* (otherlv_15= '{' ( (otherlv_16= 'time-bound' otherlv_17= ':' ( (lv_timeBound_18_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_19= 'scheduled' otherlv_20= ':' ( (lv_scheduled_21_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_22_0= ruleXProperty ) ) )* otherlv_23= '}' )? ) )
            // InternalTmscXtext.g:1855:2: ( ( ( (lv_timestamp_0_1= RULE_ISO8601 | lv_timestamp_0_2= RULE_ABS_EBIGDECIMAL ) ) )? ( (lv_timeBound_1_0= RULE_POS_EBIGDECIMAL ) )? ( ( ruleFQNString ) ) ( ( ruleIDString ) )? ( (lv_type_4_0= ruleXEventType ) ) ( ( ruleIDString ) ) (otherlv_6= '(' ( (lv_arguments_7_0= ruleXEventArgument ) ) (otherlv_8= ',' ( (lv_arguments_9_0= ruleXEventArgument ) ) )* otherlv_10= ')' )? ( (otherlv_11= '!' ( (lv_outgoingDependencies_12_0= ruleXDependency ) ) ) | (otherlv_13= '?' ( ( ruleIDString ) ) ) )* (otherlv_15= '{' ( (otherlv_16= 'time-bound' otherlv_17= ':' ( (lv_timeBound_18_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_19= 'scheduled' otherlv_20= ':' ( (lv_scheduled_21_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_22_0= ruleXProperty ) ) )* otherlv_23= '}' )? )
            {
            // InternalTmscXtext.g:1855:2: ( ( ( (lv_timestamp_0_1= RULE_ISO8601 | lv_timestamp_0_2= RULE_ABS_EBIGDECIMAL ) ) )? ( (lv_timeBound_1_0= RULE_POS_EBIGDECIMAL ) )? ( ( ruleFQNString ) ) ( ( ruleIDString ) )? ( (lv_type_4_0= ruleXEventType ) ) ( ( ruleIDString ) ) (otherlv_6= '(' ( (lv_arguments_7_0= ruleXEventArgument ) ) (otherlv_8= ',' ( (lv_arguments_9_0= ruleXEventArgument ) ) )* otherlv_10= ')' )? ( (otherlv_11= '!' ( (lv_outgoingDependencies_12_0= ruleXDependency ) ) ) | (otherlv_13= '?' ( ( ruleIDString ) ) ) )* (otherlv_15= '{' ( (otherlv_16= 'time-bound' otherlv_17= ':' ( (lv_timeBound_18_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_19= 'scheduled' otherlv_20= ':' ( (lv_scheduled_21_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_22_0= ruleXProperty ) ) )* otherlv_23= '}' )? )
            // InternalTmscXtext.g:1856:3: ( ( (lv_timestamp_0_1= RULE_ISO8601 | lv_timestamp_0_2= RULE_ABS_EBIGDECIMAL ) ) )? ( (lv_timeBound_1_0= RULE_POS_EBIGDECIMAL ) )? ( ( ruleFQNString ) ) ( ( ruleIDString ) )? ( (lv_type_4_0= ruleXEventType ) ) ( ( ruleIDString ) ) (otherlv_6= '(' ( (lv_arguments_7_0= ruleXEventArgument ) ) (otherlv_8= ',' ( (lv_arguments_9_0= ruleXEventArgument ) ) )* otherlv_10= ')' )? ( (otherlv_11= '!' ( (lv_outgoingDependencies_12_0= ruleXDependency ) ) ) | (otherlv_13= '?' ( ( ruleIDString ) ) ) )* (otherlv_15= '{' ( (otherlv_16= 'time-bound' otherlv_17= ':' ( (lv_timeBound_18_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_19= 'scheduled' otherlv_20= ':' ( (lv_scheduled_21_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_22_0= ruleXProperty ) ) )* otherlv_23= '}' )?
            {
            // InternalTmscXtext.g:1856:3: ( ( (lv_timestamp_0_1= RULE_ISO8601 | lv_timestamp_0_2= RULE_ABS_EBIGDECIMAL ) ) )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( ((LA42_0>=RULE_ABS_EBIGDECIMAL && LA42_0<=RULE_ISO8601)) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // InternalTmscXtext.g:1857:4: ( (lv_timestamp_0_1= RULE_ISO8601 | lv_timestamp_0_2= RULE_ABS_EBIGDECIMAL ) )
                    {
                    // InternalTmscXtext.g:1857:4: ( (lv_timestamp_0_1= RULE_ISO8601 | lv_timestamp_0_2= RULE_ABS_EBIGDECIMAL ) )
                    // InternalTmscXtext.g:1858:5: (lv_timestamp_0_1= RULE_ISO8601 | lv_timestamp_0_2= RULE_ABS_EBIGDECIMAL )
                    {
                    // InternalTmscXtext.g:1858:5: (lv_timestamp_0_1= RULE_ISO8601 | lv_timestamp_0_2= RULE_ABS_EBIGDECIMAL )
                    int alt41=2;
                    int LA41_0 = input.LA(1);

                    if ( (LA41_0==RULE_ISO8601) ) {
                        alt41=1;
                    }
                    else if ( (LA41_0==RULE_ABS_EBIGDECIMAL) ) {
                        alt41=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 41, 0, input);

                        throw nvae;
                    }
                    switch (alt41) {
                        case 1 :
                            // InternalTmscXtext.g:1859:6: lv_timestamp_0_1= RULE_ISO8601
                            {
                            lv_timestamp_0_1=(Token)match(input,RULE_ISO8601,FOLLOW_35); if (state.failed) return current;
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
                            // InternalTmscXtext.g:1874:6: lv_timestamp_0_2= RULE_ABS_EBIGDECIMAL
                            {
                            lv_timestamp_0_2=(Token)match(input,RULE_ABS_EBIGDECIMAL,FOLLOW_35); if (state.failed) return current;
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

            // InternalTmscXtext.g:1891:3: ( (lv_timeBound_1_0= RULE_POS_EBIGDECIMAL ) )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==RULE_POS_EBIGDECIMAL) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // InternalTmscXtext.g:1892:4: (lv_timeBound_1_0= RULE_POS_EBIGDECIMAL )
                    {
                    // InternalTmscXtext.g:1892:4: (lv_timeBound_1_0= RULE_POS_EBIGDECIMAL )
                    // InternalTmscXtext.g:1893:5: lv_timeBound_1_0= RULE_POS_EBIGDECIMAL
                    {
                    lv_timeBound_1_0=(Token)match(input,RULE_POS_EBIGDECIMAL,FOLLOW_35); if (state.failed) return current;
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

            // InternalTmscXtext.g:1909:3: ( ( ruleFQNString ) )
            // InternalTmscXtext.g:1910:4: ( ruleFQNString )
            {
            // InternalTmscXtext.g:1910:4: ( ruleFQNString )
            // InternalTmscXtext.g:1911:5: ruleFQNString
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getXEventRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getXEventAccess().getExecutorXExecutorCrossReference_2_0());
              				
            }
            pushFollow(FOLLOW_35);
            ruleFQNString();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalTmscXtext.g:1925:3: ( ( ruleIDString ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==RULE_ID||LA44_0==RULE_STRING) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // InternalTmscXtext.g:1926:4: ( ruleIDString )
                    {
                    // InternalTmscXtext.g:1926:4: ( ruleIDString )
                    // InternalTmscXtext.g:1927:5: ruleIDString
                    {
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getXEventRule());
                      					}
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getXEventAccess().getComponentXComponentCrossReference_3_0());
                      				
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
                    break;

            }

            // InternalTmscXtext.g:1941:3: ( (lv_type_4_0= ruleXEventType ) )
            // InternalTmscXtext.g:1942:4: (lv_type_4_0= ruleXEventType )
            {
            // InternalTmscXtext.g:1942:4: (lv_type_4_0= ruleXEventType )
            // InternalTmscXtext.g:1943:5: lv_type_4_0= ruleXEventType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getXEventAccess().getTypeXEventTypeEnumRuleCall_4_0());
              				
            }
            pushFollow(FOLLOW_19);
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

            // InternalTmscXtext.g:1960:3: ( ( ruleIDString ) )
            // InternalTmscXtext.g:1961:4: ( ruleIDString )
            {
            // InternalTmscXtext.g:1961:4: ( ruleIDString )
            // InternalTmscXtext.g:1962:5: ruleIDString
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getXEventRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getXEventAccess().getFunctionXFunctionCrossReference_5_0());
              				
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

            // InternalTmscXtext.g:1976:3: (otherlv_6= '(' ( (lv_arguments_7_0= ruleXEventArgument ) ) (otherlv_8= ',' ( (lv_arguments_9_0= ruleXEventArgument ) ) )* otherlv_10= ')' )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==38) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // InternalTmscXtext.g:1977:4: otherlv_6= '(' ( (lv_arguments_7_0= ruleXEventArgument ) ) (otherlv_8= ',' ( (lv_arguments_9_0= ruleXEventArgument ) ) )* otherlv_10= ')'
                    {
                    otherlv_6=(Token)match(input,38,FOLLOW_21); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_6, grammarAccess.getXEventAccess().getLeftParenthesisKeyword_6_0());
                      			
                    }
                    // InternalTmscXtext.g:1981:4: ( (lv_arguments_7_0= ruleXEventArgument ) )
                    // InternalTmscXtext.g:1982:5: (lv_arguments_7_0= ruleXEventArgument )
                    {
                    // InternalTmscXtext.g:1982:5: (lv_arguments_7_0= ruleXEventArgument )
                    // InternalTmscXtext.g:1983:6: lv_arguments_7_0= ruleXEventArgument
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getXEventAccess().getArgumentsXEventArgumentParserRuleCall_6_1_0());
                      					
                    }
                    pushFollow(FOLLOW_29);
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

                    // InternalTmscXtext.g:2000:4: (otherlv_8= ',' ( (lv_arguments_9_0= ruleXEventArgument ) ) )*
                    loop45:
                    do {
                        int alt45=2;
                        int LA45_0 = input.LA(1);

                        if ( (LA45_0==33) ) {
                            alt45=1;
                        }


                        switch (alt45) {
                    	case 1 :
                    	    // InternalTmscXtext.g:2001:5: otherlv_8= ',' ( (lv_arguments_9_0= ruleXEventArgument ) )
                    	    {
                    	    otherlv_8=(Token)match(input,33,FOLLOW_21); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_8, grammarAccess.getXEventAccess().getCommaKeyword_6_2_0());
                    	      				
                    	    }
                    	    // InternalTmscXtext.g:2005:5: ( (lv_arguments_9_0= ruleXEventArgument ) )
                    	    // InternalTmscXtext.g:2006:6: (lv_arguments_9_0= ruleXEventArgument )
                    	    {
                    	    // InternalTmscXtext.g:2006:6: (lv_arguments_9_0= ruleXEventArgument )
                    	    // InternalTmscXtext.g:2007:7: lv_arguments_9_0= ruleXEventArgument
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getXEventAccess().getArgumentsXEventArgumentParserRuleCall_6_2_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_29);
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
                    	    break loop45;
                        }
                    } while (true);

                    otherlv_10=(Token)match(input,39,FOLLOW_37); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_10, grammarAccess.getXEventAccess().getRightParenthesisKeyword_6_3());
                      			
                    }

                    }
                    break;

            }

            // InternalTmscXtext.g:2030:3: ( (otherlv_11= '!' ( (lv_outgoingDependencies_12_0= ruleXDependency ) ) ) | (otherlv_13= '?' ( ( ruleIDString ) ) ) )*
            loop47:
            do {
                int alt47=3;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==44) ) {
                    alt47=1;
                }
                else if ( (LA47_0==45) ) {
                    alt47=2;
                }


                switch (alt47) {
            	case 1 :
            	    // InternalTmscXtext.g:2031:4: (otherlv_11= '!' ( (lv_outgoingDependencies_12_0= ruleXDependency ) ) )
            	    {
            	    // InternalTmscXtext.g:2031:4: (otherlv_11= '!' ( (lv_outgoingDependencies_12_0= ruleXDependency ) ) )
            	    // InternalTmscXtext.g:2032:5: otherlv_11= '!' ( (lv_outgoingDependencies_12_0= ruleXDependency ) )
            	    {
            	    otherlv_11=(Token)match(input,44,FOLLOW_38); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_11, grammarAccess.getXEventAccess().getExclamationMarkKeyword_7_0_0());
            	      				
            	    }
            	    // InternalTmscXtext.g:2036:5: ( (lv_outgoingDependencies_12_0= ruleXDependency ) )
            	    // InternalTmscXtext.g:2037:6: (lv_outgoingDependencies_12_0= ruleXDependency )
            	    {
            	    // InternalTmscXtext.g:2037:6: (lv_outgoingDependencies_12_0= ruleXDependency )
            	    // InternalTmscXtext.g:2038:7: lv_outgoingDependencies_12_0= ruleXDependency
            	    {
            	    if ( state.backtracking==0 ) {

            	      							newCompositeNode(grammarAccess.getXEventAccess().getOutgoingDependenciesXDependencyParserRuleCall_7_0_1_0());
            	      						
            	    }
            	    pushFollow(FOLLOW_37);
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
            	    // InternalTmscXtext.g:2057:4: (otherlv_13= '?' ( ( ruleIDString ) ) )
            	    {
            	    // InternalTmscXtext.g:2057:4: (otherlv_13= '?' ( ( ruleIDString ) ) )
            	    // InternalTmscXtext.g:2058:5: otherlv_13= '?' ( ( ruleIDString ) )
            	    {
            	    otherlv_13=(Token)match(input,45,FOLLOW_19); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_13, grammarAccess.getXEventAccess().getQuestionMarkKeyword_7_1_0());
            	      				
            	    }
            	    // InternalTmscXtext.g:2062:5: ( ( ruleIDString ) )
            	    // InternalTmscXtext.g:2063:6: ( ruleIDString )
            	    {
            	    // InternalTmscXtext.g:2063:6: ( ruleIDString )
            	    // InternalTmscXtext.g:2064:7: ruleIDString
            	    {
            	    if ( state.backtracking==0 ) {

            	      							if (current==null) {
            	      								current = createModelElement(grammarAccess.getXEventRule());
            	      							}
            	      						
            	    }
            	    if ( state.backtracking==0 ) {

            	      							newCompositeNode(grammarAccess.getXEventAccess().getIncomingDependenciesXDependencyCrossReference_7_1_1_0());
            	      						
            	    }
            	    pushFollow(FOLLOW_37);
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
            	    break loop47;
                }
            } while (true);

            // InternalTmscXtext.g:2080:3: (otherlv_15= '{' ( (otherlv_16= 'time-bound' otherlv_17= ':' ( (lv_timeBound_18_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_19= 'scheduled' otherlv_20= ':' ( (lv_scheduled_21_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_22_0= ruleXProperty ) ) )* otherlv_23= '}' )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==15) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // InternalTmscXtext.g:2081:4: otherlv_15= '{' ( (otherlv_16= 'time-bound' otherlv_17= ':' ( (lv_timeBound_18_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_19= 'scheduled' otherlv_20= ':' ( (lv_scheduled_21_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_22_0= ruleXProperty ) ) )* otherlv_23= '}'
                    {
                    otherlv_15=(Token)match(input,15,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_15, grammarAccess.getXEventAccess().getLeftCurlyBracketKeyword_8_0());
                      			
                    }
                    // InternalTmscXtext.g:2085:4: ( (otherlv_16= 'time-bound' otherlv_17= ':' ( (lv_timeBound_18_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_19= 'scheduled' otherlv_20= ':' ( (lv_scheduled_21_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_22_0= ruleXProperty ) ) )*
                    loop48:
                    do {
                        int alt48=4;
                        switch ( input.LA(1) ) {
                        case 18:
                            {
                            alt48=1;
                            }
                            break;
                        case 19:
                            {
                            alt48=2;
                            }
                            break;
                        case RULE_ID:
                        case RULE_STRING:
                            {
                            alt48=3;
                            }
                            break;

                        }

                        switch (alt48) {
                    	case 1 :
                    	    // InternalTmscXtext.g:2086:5: (otherlv_16= 'time-bound' otherlv_17= ':' ( (lv_timeBound_18_0= RULE_ABS_EBIGDECIMAL ) ) )
                    	    {
                    	    // InternalTmscXtext.g:2086:5: (otherlv_16= 'time-bound' otherlv_17= ':' ( (lv_timeBound_18_0= RULE_ABS_EBIGDECIMAL ) ) )
                    	    // InternalTmscXtext.g:2087:6: otherlv_16= 'time-bound' otherlv_17= ':' ( (lv_timeBound_18_0= RULE_ABS_EBIGDECIMAL ) )
                    	    {
                    	    otherlv_16=(Token)match(input,18,FOLLOW_6); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_16, grammarAccess.getXEventAccess().getTimeBoundKeyword_8_1_0_0());
                    	      					
                    	    }
                    	    otherlv_17=(Token)match(input,17,FOLLOW_8); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_17, grammarAccess.getXEventAccess().getColonKeyword_8_1_0_1());
                    	      					
                    	    }
                    	    // InternalTmscXtext.g:2095:6: ( (lv_timeBound_18_0= RULE_ABS_EBIGDECIMAL ) )
                    	    // InternalTmscXtext.g:2096:7: (lv_timeBound_18_0= RULE_ABS_EBIGDECIMAL )
                    	    {
                    	    // InternalTmscXtext.g:2096:7: (lv_timeBound_18_0= RULE_ABS_EBIGDECIMAL )
                    	    // InternalTmscXtext.g:2097:8: lv_timeBound_18_0= RULE_ABS_EBIGDECIMAL
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
                    	    // InternalTmscXtext.g:2115:5: (otherlv_19= 'scheduled' otherlv_20= ':' ( (lv_scheduled_21_0= ruleEBOOLEAN_OBJECT ) ) )
                    	    {
                    	    // InternalTmscXtext.g:2115:5: (otherlv_19= 'scheduled' otherlv_20= ':' ( (lv_scheduled_21_0= ruleEBOOLEAN_OBJECT ) ) )
                    	    // InternalTmscXtext.g:2116:6: otherlv_19= 'scheduled' otherlv_20= ':' ( (lv_scheduled_21_0= ruleEBOOLEAN_OBJECT ) )
                    	    {
                    	    otherlv_19=(Token)match(input,19,FOLLOW_6); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_19, grammarAccess.getXEventAccess().getScheduledKeyword_8_1_1_0());
                    	      					
                    	    }
                    	    otherlv_20=(Token)match(input,17,FOLLOW_9); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_20, grammarAccess.getXEventAccess().getColonKeyword_8_1_1_1());
                    	      					
                    	    }
                    	    // InternalTmscXtext.g:2124:6: ( (lv_scheduled_21_0= ruleEBOOLEAN_OBJECT ) )
                    	    // InternalTmscXtext.g:2125:7: (lv_scheduled_21_0= ruleEBOOLEAN_OBJECT )
                    	    {
                    	    // InternalTmscXtext.g:2125:7: (lv_scheduled_21_0= ruleEBOOLEAN_OBJECT )
                    	    // InternalTmscXtext.g:2126:8: lv_scheduled_21_0= ruleEBOOLEAN_OBJECT
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
                    	    // InternalTmscXtext.g:2145:5: ( (lv_properties_22_0= ruleXProperty ) )
                    	    {
                    	    // InternalTmscXtext.g:2145:5: ( (lv_properties_22_0= ruleXProperty ) )
                    	    // InternalTmscXtext.g:2146:6: (lv_properties_22_0= ruleXProperty )
                    	    {
                    	    // InternalTmscXtext.g:2146:6: (lv_properties_22_0= ruleXProperty )
                    	    // InternalTmscXtext.g:2147:7: lv_properties_22_0= ruleXProperty
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
                    	    break loop48;
                        }
                    } while (true);

                    otherlv_23=(Token)match(input,22,FOLLOW_2); if (state.failed) return current;
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
    // InternalTmscXtext.g:2174:1: entryRuleXEventArgument returns [EObject current=null] : iv_ruleXEventArgument= ruleXEventArgument EOF ;
    public final EObject entryRuleXEventArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXEventArgument = null;


        try {
            // InternalTmscXtext.g:2174:55: (iv_ruleXEventArgument= ruleXEventArgument EOF )
            // InternalTmscXtext.g:2175:2: iv_ruleXEventArgument= ruleXEventArgument EOF
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
    // InternalTmscXtext.g:2181:1: ruleXEventArgument returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' ( (lv_value_2_0= ruleIDString ) ) ) ;
    public final EObject ruleXEventArgument() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalTmscXtext.g:2187:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' ( (lv_value_2_0= ruleIDString ) ) ) )
            // InternalTmscXtext.g:2188:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' ( (lv_value_2_0= ruleIDString ) ) )
            {
            // InternalTmscXtext.g:2188:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' ( (lv_value_2_0= ruleIDString ) ) )
            // InternalTmscXtext.g:2189:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' ( (lv_value_2_0= ruleIDString ) )
            {
            // InternalTmscXtext.g:2189:3: ( (otherlv_0= RULE_ID ) )
            // InternalTmscXtext.g:2190:4: (otherlv_0= RULE_ID )
            {
            // InternalTmscXtext.g:2190:4: (otherlv_0= RULE_ID )
            // InternalTmscXtext.g:2191:5: otherlv_0= RULE_ID
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

            otherlv_1=(Token)match(input,17,FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getXEventArgumentAccess().getColonKeyword_1());
              		
            }
            // InternalTmscXtext.g:2206:3: ( (lv_value_2_0= ruleIDString ) )
            // InternalTmscXtext.g:2207:4: (lv_value_2_0= ruleIDString )
            {
            // InternalTmscXtext.g:2207:4: (lv_value_2_0= ruleIDString )
            // InternalTmscXtext.g:2208:5: lv_value_2_0= ruleIDString
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
    // InternalTmscXtext.g:2229:1: entryRuleXDependency returns [EObject current=null] : iv_ruleXDependency= ruleXDependency EOF ;
    public final EObject entryRuleXDependency() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXDependency = null;


        try {
            // InternalTmscXtext.g:2229:52: (iv_ruleXDependency= ruleXDependency EOF )
            // InternalTmscXtext.g:2230:2: iv_ruleXDependency= ruleXDependency EOF
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
    // InternalTmscXtext.g:2236:1: ruleXDependency returns [EObject current=null] : ( ( (lv_typeObject_0_0= ruleXDependencyTypeObject ) )? ( (lv_name_1_0= ruleIDString ) ) ( (otherlv_2= '(' ( (lv_timeBound_3_0= RULE_ABS_EBIGDECIMAL ) ) otherlv_4= ')' ) | (otherlv_5= '(' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_12= 'request' otherlv_13= ':' ( ( ruleIDString ) ) ) | (otherlv_15= 'message' otherlv_16= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_18_0= ruleXProperty ) ) ) (otherlv_19= ',' ( (otherlv_20= 'time-bound' otherlv_21= ':' ( (lv_timeBound_22_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_23= 'scheduled' otherlv_24= ':' ( (lv_scheduled_25_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_26= 'request' otherlv_27= ':' ( ( ruleIDString ) ) ) | (otherlv_29= 'message' otherlv_30= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_32_0= ruleXProperty ) ) ) )* otherlv_33= ')' ) )? ) ;
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
            // InternalTmscXtext.g:2242:2: ( ( ( (lv_typeObject_0_0= ruleXDependencyTypeObject ) )? ( (lv_name_1_0= ruleIDString ) ) ( (otherlv_2= '(' ( (lv_timeBound_3_0= RULE_ABS_EBIGDECIMAL ) ) otherlv_4= ')' ) | (otherlv_5= '(' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_12= 'request' otherlv_13= ':' ( ( ruleIDString ) ) ) | (otherlv_15= 'message' otherlv_16= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_18_0= ruleXProperty ) ) ) (otherlv_19= ',' ( (otherlv_20= 'time-bound' otherlv_21= ':' ( (lv_timeBound_22_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_23= 'scheduled' otherlv_24= ':' ( (lv_scheduled_25_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_26= 'request' otherlv_27= ':' ( ( ruleIDString ) ) ) | (otherlv_29= 'message' otherlv_30= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_32_0= ruleXProperty ) ) ) )* otherlv_33= ')' ) )? ) )
            // InternalTmscXtext.g:2243:2: ( ( (lv_typeObject_0_0= ruleXDependencyTypeObject ) )? ( (lv_name_1_0= ruleIDString ) ) ( (otherlv_2= '(' ( (lv_timeBound_3_0= RULE_ABS_EBIGDECIMAL ) ) otherlv_4= ')' ) | (otherlv_5= '(' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_12= 'request' otherlv_13= ':' ( ( ruleIDString ) ) ) | (otherlv_15= 'message' otherlv_16= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_18_0= ruleXProperty ) ) ) (otherlv_19= ',' ( (otherlv_20= 'time-bound' otherlv_21= ':' ( (lv_timeBound_22_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_23= 'scheduled' otherlv_24= ':' ( (lv_scheduled_25_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_26= 'request' otherlv_27= ':' ( ( ruleIDString ) ) ) | (otherlv_29= 'message' otherlv_30= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_32_0= ruleXProperty ) ) ) )* otherlv_33= ')' ) )? )
            {
            // InternalTmscXtext.g:2243:2: ( ( (lv_typeObject_0_0= ruleXDependencyTypeObject ) )? ( (lv_name_1_0= ruleIDString ) ) ( (otherlv_2= '(' ( (lv_timeBound_3_0= RULE_ABS_EBIGDECIMAL ) ) otherlv_4= ')' ) | (otherlv_5= '(' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_12= 'request' otherlv_13= ':' ( ( ruleIDString ) ) ) | (otherlv_15= 'message' otherlv_16= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_18_0= ruleXProperty ) ) ) (otherlv_19= ',' ( (otherlv_20= 'time-bound' otherlv_21= ':' ( (lv_timeBound_22_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_23= 'scheduled' otherlv_24= ':' ( (lv_scheduled_25_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_26= 'request' otherlv_27= ':' ( ( ruleIDString ) ) ) | (otherlv_29= 'message' otherlv_30= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_32_0= ruleXProperty ) ) ) )* otherlv_33= ')' ) )? )
            // InternalTmscXtext.g:2244:3: ( (lv_typeObject_0_0= ruleXDependencyTypeObject ) )? ( (lv_name_1_0= ruleIDString ) ) ( (otherlv_2= '(' ( (lv_timeBound_3_0= RULE_ABS_EBIGDECIMAL ) ) otherlv_4= ')' ) | (otherlv_5= '(' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_12= 'request' otherlv_13= ':' ( ( ruleIDString ) ) ) | (otherlv_15= 'message' otherlv_16= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_18_0= ruleXProperty ) ) ) (otherlv_19= ',' ( (otherlv_20= 'time-bound' otherlv_21= ':' ( (lv_timeBound_22_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_23= 'scheduled' otherlv_24= ':' ( (lv_scheduled_25_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_26= 'request' otherlv_27= ':' ( ( ruleIDString ) ) ) | (otherlv_29= 'message' otherlv_30= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_32_0= ruleXProperty ) ) ) )* otherlv_33= ')' ) )?
            {
            // InternalTmscXtext.g:2244:3: ( (lv_typeObject_0_0= ruleXDependencyTypeObject ) )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( ((LA50_0>=46 && LA50_0<=47)||(LA50_0>=62 && LA50_0<=65)) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // InternalTmscXtext.g:2245:4: (lv_typeObject_0_0= ruleXDependencyTypeObject )
                    {
                    // InternalTmscXtext.g:2245:4: (lv_typeObject_0_0= ruleXDependencyTypeObject )
                    // InternalTmscXtext.g:2246:5: lv_typeObject_0_0= ruleXDependencyTypeObject
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getXDependencyAccess().getTypeObjectXDependencyTypeObjectParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_19);
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

            // InternalTmscXtext.g:2263:3: ( (lv_name_1_0= ruleIDString ) )
            // InternalTmscXtext.g:2264:4: (lv_name_1_0= ruleIDString )
            {
            // InternalTmscXtext.g:2264:4: (lv_name_1_0= ruleIDString )
            // InternalTmscXtext.g:2265:5: lv_name_1_0= ruleIDString
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getXDependencyAccess().getNameIDStringParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_31);
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

            // InternalTmscXtext.g:2282:3: ( (otherlv_2= '(' ( (lv_timeBound_3_0= RULE_ABS_EBIGDECIMAL ) ) otherlv_4= ')' ) | (otherlv_5= '(' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_12= 'request' otherlv_13= ':' ( ( ruleIDString ) ) ) | (otherlv_15= 'message' otherlv_16= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_18_0= ruleXProperty ) ) ) (otherlv_19= ',' ( (otherlv_20= 'time-bound' otherlv_21= ':' ( (lv_timeBound_22_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_23= 'scheduled' otherlv_24= ':' ( (lv_scheduled_25_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_26= 'request' otherlv_27= ':' ( ( ruleIDString ) ) ) | (otherlv_29= 'message' otherlv_30= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_32_0= ruleXProperty ) ) ) )* otherlv_33= ')' ) )?
            int alt54=3;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==38) ) {
                int LA54_1 = input.LA(2);

                if ( (LA54_1==RULE_ID||LA54_1==RULE_STRING||(LA54_1>=18 && LA54_1<=19)||(LA54_1>=46 && LA54_1<=47)) ) {
                    alt54=2;
                }
                else if ( (LA54_1==RULE_ABS_EBIGDECIMAL) ) {
                    alt54=1;
                }
            }
            switch (alt54) {
                case 1 :
                    // InternalTmscXtext.g:2283:4: (otherlv_2= '(' ( (lv_timeBound_3_0= RULE_ABS_EBIGDECIMAL ) ) otherlv_4= ')' )
                    {
                    // InternalTmscXtext.g:2283:4: (otherlv_2= '(' ( (lv_timeBound_3_0= RULE_ABS_EBIGDECIMAL ) ) otherlv_4= ')' )
                    // InternalTmscXtext.g:2284:5: otherlv_2= '(' ( (lv_timeBound_3_0= RULE_ABS_EBIGDECIMAL ) ) otherlv_4= ')'
                    {
                    otherlv_2=(Token)match(input,38,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_2, grammarAccess.getXDependencyAccess().getLeftParenthesisKeyword_2_0_0());
                      				
                    }
                    // InternalTmscXtext.g:2288:5: ( (lv_timeBound_3_0= RULE_ABS_EBIGDECIMAL ) )
                    // InternalTmscXtext.g:2289:6: (lv_timeBound_3_0= RULE_ABS_EBIGDECIMAL )
                    {
                    // InternalTmscXtext.g:2289:6: (lv_timeBound_3_0= RULE_ABS_EBIGDECIMAL )
                    // InternalTmscXtext.g:2290:7: lv_timeBound_3_0= RULE_ABS_EBIGDECIMAL
                    {
                    lv_timeBound_3_0=(Token)match(input,RULE_ABS_EBIGDECIMAL,FOLLOW_39); if (state.failed) return current;
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

                    otherlv_4=(Token)match(input,39,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_4, grammarAccess.getXDependencyAccess().getRightParenthesisKeyword_2_0_2());
                      				
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalTmscXtext.g:2312:4: (otherlv_5= '(' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_12= 'request' otherlv_13= ':' ( ( ruleIDString ) ) ) | (otherlv_15= 'message' otherlv_16= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_18_0= ruleXProperty ) ) ) (otherlv_19= ',' ( (otherlv_20= 'time-bound' otherlv_21= ':' ( (lv_timeBound_22_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_23= 'scheduled' otherlv_24= ':' ( (lv_scheduled_25_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_26= 'request' otherlv_27= ':' ( ( ruleIDString ) ) ) | (otherlv_29= 'message' otherlv_30= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_32_0= ruleXProperty ) ) ) )* otherlv_33= ')' )
                    {
                    // InternalTmscXtext.g:2312:4: (otherlv_5= '(' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_12= 'request' otherlv_13= ':' ( ( ruleIDString ) ) ) | (otherlv_15= 'message' otherlv_16= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_18_0= ruleXProperty ) ) ) (otherlv_19= ',' ( (otherlv_20= 'time-bound' otherlv_21= ':' ( (lv_timeBound_22_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_23= 'scheduled' otherlv_24= ':' ( (lv_scheduled_25_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_26= 'request' otherlv_27= ':' ( ( ruleIDString ) ) ) | (otherlv_29= 'message' otherlv_30= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_32_0= ruleXProperty ) ) ) )* otherlv_33= ')' )
                    // InternalTmscXtext.g:2313:5: otherlv_5= '(' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_12= 'request' otherlv_13= ':' ( ( ruleIDString ) ) ) | (otherlv_15= 'message' otherlv_16= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_18_0= ruleXProperty ) ) ) (otherlv_19= ',' ( (otherlv_20= 'time-bound' otherlv_21= ':' ( (lv_timeBound_22_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_23= 'scheduled' otherlv_24= ':' ( (lv_scheduled_25_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_26= 'request' otherlv_27= ':' ( ( ruleIDString ) ) ) | (otherlv_29= 'message' otherlv_30= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_32_0= ruleXProperty ) ) ) )* otherlv_33= ')'
                    {
                    otherlv_5=(Token)match(input,38,FOLLOW_40); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_5, grammarAccess.getXDependencyAccess().getLeftParenthesisKeyword_2_1_0());
                      				
                    }
                    // InternalTmscXtext.g:2317:5: ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_12= 'request' otherlv_13= ':' ( ( ruleIDString ) ) ) | (otherlv_15= 'message' otherlv_16= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_18_0= ruleXProperty ) ) )
                    int alt51=5;
                    switch ( input.LA(1) ) {
                    case 18:
                        {
                        alt51=1;
                        }
                        break;
                    case 19:
                        {
                        alt51=2;
                        }
                        break;
                    case 46:
                        {
                        alt51=3;
                        }
                        break;
                    case 47:
                        {
                        alt51=4;
                        }
                        break;
                    case RULE_ID:
                    case RULE_STRING:
                        {
                        alt51=5;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 51, 0, input);

                        throw nvae;
                    }

                    switch (alt51) {
                        case 1 :
                            // InternalTmscXtext.g:2318:6: (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) )
                            {
                            // InternalTmscXtext.g:2318:6: (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) )
                            // InternalTmscXtext.g:2319:7: otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) )
                            {
                            otherlv_6=(Token)match(input,18,FOLLOW_6); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(otherlv_6, grammarAccess.getXDependencyAccess().getTimeBoundKeyword_2_1_1_0_0());
                              						
                            }
                            otherlv_7=(Token)match(input,17,FOLLOW_8); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(otherlv_7, grammarAccess.getXDependencyAccess().getColonKeyword_2_1_1_0_1());
                              						
                            }
                            // InternalTmscXtext.g:2327:7: ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) )
                            // InternalTmscXtext.g:2328:8: (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL )
                            {
                            // InternalTmscXtext.g:2328:8: (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL )
                            // InternalTmscXtext.g:2329:9: lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL
                            {
                            lv_timeBound_8_0=(Token)match(input,RULE_ABS_EBIGDECIMAL,FOLLOW_29); if (state.failed) return current;
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
                            // InternalTmscXtext.g:2347:6: (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) )
                            {
                            // InternalTmscXtext.g:2347:6: (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) )
                            // InternalTmscXtext.g:2348:7: otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) )
                            {
                            otherlv_9=(Token)match(input,19,FOLLOW_6); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(otherlv_9, grammarAccess.getXDependencyAccess().getScheduledKeyword_2_1_1_1_0());
                              						
                            }
                            otherlv_10=(Token)match(input,17,FOLLOW_9); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(otherlv_10, grammarAccess.getXDependencyAccess().getColonKeyword_2_1_1_1_1());
                              						
                            }
                            // InternalTmscXtext.g:2356:7: ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) )
                            // InternalTmscXtext.g:2357:8: (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT )
                            {
                            // InternalTmscXtext.g:2357:8: (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT )
                            // InternalTmscXtext.g:2358:9: lv_scheduled_11_0= ruleEBOOLEAN_OBJECT
                            {
                            if ( state.backtracking==0 ) {

                              									newCompositeNode(grammarAccess.getXDependencyAccess().getScheduledEBOOLEAN_OBJECTParserRuleCall_2_1_1_1_2_0());
                              								
                            }
                            pushFollow(FOLLOW_29);
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
                            // InternalTmscXtext.g:2377:6: (otherlv_12= 'request' otherlv_13= ':' ( ( ruleIDString ) ) )
                            {
                            // InternalTmscXtext.g:2377:6: (otherlv_12= 'request' otherlv_13= ':' ( ( ruleIDString ) ) )
                            // InternalTmscXtext.g:2378:7: otherlv_12= 'request' otherlv_13= ':' ( ( ruleIDString ) )
                            {
                            otherlv_12=(Token)match(input,46,FOLLOW_6); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(otherlv_12, grammarAccess.getXDependencyAccess().getRequestKeyword_2_1_1_2_0());
                              						
                            }
                            otherlv_13=(Token)match(input,17,FOLLOW_19); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(otherlv_13, grammarAccess.getXDependencyAccess().getColonKeyword_2_1_1_2_1());
                              						
                            }
                            // InternalTmscXtext.g:2386:7: ( ( ruleIDString ) )
                            // InternalTmscXtext.g:2387:8: ( ruleIDString )
                            {
                            // InternalTmscXtext.g:2387:8: ( ruleIDString )
                            // InternalTmscXtext.g:2388:9: ruleIDString
                            {
                            if ( state.backtracking==0 ) {

                              									if (current==null) {
                              										current = createModelElement(grammarAccess.getXDependencyRule());
                              									}
                              								
                            }
                            if ( state.backtracking==0 ) {

                              									newCompositeNode(grammarAccess.getXDependencyAccess().getRequestXDependencyCrossReference_2_1_1_2_2_0());
                              								
                            }
                            pushFollow(FOLLOW_29);
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
                            // InternalTmscXtext.g:2404:6: (otherlv_15= 'message' otherlv_16= ':' ( ( ruleIDString ) ) )
                            {
                            // InternalTmscXtext.g:2404:6: (otherlv_15= 'message' otherlv_16= ':' ( ( ruleIDString ) ) )
                            // InternalTmscXtext.g:2405:7: otherlv_15= 'message' otherlv_16= ':' ( ( ruleIDString ) )
                            {
                            otherlv_15=(Token)match(input,47,FOLLOW_6); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(otherlv_15, grammarAccess.getXDependencyAccess().getMessageKeyword_2_1_1_3_0());
                              						
                            }
                            otherlv_16=(Token)match(input,17,FOLLOW_19); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(otherlv_16, grammarAccess.getXDependencyAccess().getColonKeyword_2_1_1_3_1());
                              						
                            }
                            // InternalTmscXtext.g:2413:7: ( ( ruleIDString ) )
                            // InternalTmscXtext.g:2414:8: ( ruleIDString )
                            {
                            // InternalTmscXtext.g:2414:8: ( ruleIDString )
                            // InternalTmscXtext.g:2415:9: ruleIDString
                            {
                            if ( state.backtracking==0 ) {

                              									if (current==null) {
                              										current = createModelElement(grammarAccess.getXDependencyRule());
                              									}
                              								
                            }
                            if ( state.backtracking==0 ) {

                              									newCompositeNode(grammarAccess.getXDependencyAccess().getMessageXDependencyCrossReference_2_1_1_3_2_0());
                              								
                            }
                            pushFollow(FOLLOW_29);
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
                            // InternalTmscXtext.g:2431:6: ( (lv_properties_18_0= ruleXProperty ) )
                            {
                            // InternalTmscXtext.g:2431:6: ( (lv_properties_18_0= ruleXProperty ) )
                            // InternalTmscXtext.g:2432:7: (lv_properties_18_0= ruleXProperty )
                            {
                            // InternalTmscXtext.g:2432:7: (lv_properties_18_0= ruleXProperty )
                            // InternalTmscXtext.g:2433:8: lv_properties_18_0= ruleXProperty
                            {
                            if ( state.backtracking==0 ) {

                              								newCompositeNode(grammarAccess.getXDependencyAccess().getPropertiesXPropertyParserRuleCall_2_1_1_4_0());
                              							
                            }
                            pushFollow(FOLLOW_29);
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

                    // InternalTmscXtext.g:2451:5: (otherlv_19= ',' ( (otherlv_20= 'time-bound' otherlv_21= ':' ( (lv_timeBound_22_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_23= 'scheduled' otherlv_24= ':' ( (lv_scheduled_25_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_26= 'request' otherlv_27= ':' ( ( ruleIDString ) ) ) | (otherlv_29= 'message' otherlv_30= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_32_0= ruleXProperty ) ) ) )*
                    loop53:
                    do {
                        int alt53=2;
                        int LA53_0 = input.LA(1);

                        if ( (LA53_0==33) ) {
                            alt53=1;
                        }


                        switch (alt53) {
                    	case 1 :
                    	    // InternalTmscXtext.g:2452:6: otherlv_19= ',' ( (otherlv_20= 'time-bound' otherlv_21= ':' ( (lv_timeBound_22_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_23= 'scheduled' otherlv_24= ':' ( (lv_scheduled_25_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_26= 'request' otherlv_27= ':' ( ( ruleIDString ) ) ) | (otherlv_29= 'message' otherlv_30= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_32_0= ruleXProperty ) ) )
                    	    {
                    	    otherlv_19=(Token)match(input,33,FOLLOW_40); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_19, grammarAccess.getXDependencyAccess().getCommaKeyword_2_1_2_0());
                    	      					
                    	    }
                    	    // InternalTmscXtext.g:2456:6: ( (otherlv_20= 'time-bound' otherlv_21= ':' ( (lv_timeBound_22_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_23= 'scheduled' otherlv_24= ':' ( (lv_scheduled_25_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_26= 'request' otherlv_27= ':' ( ( ruleIDString ) ) ) | (otherlv_29= 'message' otherlv_30= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_32_0= ruleXProperty ) ) )
                    	    int alt52=5;
                    	    switch ( input.LA(1) ) {
                    	    case 18:
                    	        {
                    	        alt52=1;
                    	        }
                    	        break;
                    	    case 19:
                    	        {
                    	        alt52=2;
                    	        }
                    	        break;
                    	    case 46:
                    	        {
                    	        alt52=3;
                    	        }
                    	        break;
                    	    case 47:
                    	        {
                    	        alt52=4;
                    	        }
                    	        break;
                    	    case RULE_ID:
                    	    case RULE_STRING:
                    	        {
                    	        alt52=5;
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
                    	            // InternalTmscXtext.g:2457:7: (otherlv_20= 'time-bound' otherlv_21= ':' ( (lv_timeBound_22_0= RULE_ABS_EBIGDECIMAL ) ) )
                    	            {
                    	            // InternalTmscXtext.g:2457:7: (otherlv_20= 'time-bound' otherlv_21= ':' ( (lv_timeBound_22_0= RULE_ABS_EBIGDECIMAL ) ) )
                    	            // InternalTmscXtext.g:2458:8: otherlv_20= 'time-bound' otherlv_21= ':' ( (lv_timeBound_22_0= RULE_ABS_EBIGDECIMAL ) )
                    	            {
                    	            otherlv_20=(Token)match(input,18,FOLLOW_6); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              								newLeafNode(otherlv_20, grammarAccess.getXDependencyAccess().getTimeBoundKeyword_2_1_2_1_0_0());
                    	              							
                    	            }
                    	            otherlv_21=(Token)match(input,17,FOLLOW_8); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              								newLeafNode(otherlv_21, grammarAccess.getXDependencyAccess().getColonKeyword_2_1_2_1_0_1());
                    	              							
                    	            }
                    	            // InternalTmscXtext.g:2466:8: ( (lv_timeBound_22_0= RULE_ABS_EBIGDECIMAL ) )
                    	            // InternalTmscXtext.g:2467:9: (lv_timeBound_22_0= RULE_ABS_EBIGDECIMAL )
                    	            {
                    	            // InternalTmscXtext.g:2467:9: (lv_timeBound_22_0= RULE_ABS_EBIGDECIMAL )
                    	            // InternalTmscXtext.g:2468:10: lv_timeBound_22_0= RULE_ABS_EBIGDECIMAL
                    	            {
                    	            lv_timeBound_22_0=(Token)match(input,RULE_ABS_EBIGDECIMAL,FOLLOW_29); if (state.failed) return current;
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
                    	            // InternalTmscXtext.g:2486:7: (otherlv_23= 'scheduled' otherlv_24= ':' ( (lv_scheduled_25_0= ruleEBOOLEAN_OBJECT ) ) )
                    	            {
                    	            // InternalTmscXtext.g:2486:7: (otherlv_23= 'scheduled' otherlv_24= ':' ( (lv_scheduled_25_0= ruleEBOOLEAN_OBJECT ) ) )
                    	            // InternalTmscXtext.g:2487:8: otherlv_23= 'scheduled' otherlv_24= ':' ( (lv_scheduled_25_0= ruleEBOOLEAN_OBJECT ) )
                    	            {
                    	            otherlv_23=(Token)match(input,19,FOLLOW_6); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              								newLeafNode(otherlv_23, grammarAccess.getXDependencyAccess().getScheduledKeyword_2_1_2_1_1_0());
                    	              							
                    	            }
                    	            otherlv_24=(Token)match(input,17,FOLLOW_9); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              								newLeafNode(otherlv_24, grammarAccess.getXDependencyAccess().getColonKeyword_2_1_2_1_1_1());
                    	              							
                    	            }
                    	            // InternalTmscXtext.g:2495:8: ( (lv_scheduled_25_0= ruleEBOOLEAN_OBJECT ) )
                    	            // InternalTmscXtext.g:2496:9: (lv_scheduled_25_0= ruleEBOOLEAN_OBJECT )
                    	            {
                    	            // InternalTmscXtext.g:2496:9: (lv_scheduled_25_0= ruleEBOOLEAN_OBJECT )
                    	            // InternalTmscXtext.g:2497:10: lv_scheduled_25_0= ruleEBOOLEAN_OBJECT
                    	            {
                    	            if ( state.backtracking==0 ) {

                    	              										newCompositeNode(grammarAccess.getXDependencyAccess().getScheduledEBOOLEAN_OBJECTParserRuleCall_2_1_2_1_1_2_0());
                    	              									
                    	            }
                    	            pushFollow(FOLLOW_29);
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
                    	            // InternalTmscXtext.g:2516:7: (otherlv_26= 'request' otherlv_27= ':' ( ( ruleIDString ) ) )
                    	            {
                    	            // InternalTmscXtext.g:2516:7: (otherlv_26= 'request' otherlv_27= ':' ( ( ruleIDString ) ) )
                    	            // InternalTmscXtext.g:2517:8: otherlv_26= 'request' otherlv_27= ':' ( ( ruleIDString ) )
                    	            {
                    	            otherlv_26=(Token)match(input,46,FOLLOW_6); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              								newLeafNode(otherlv_26, grammarAccess.getXDependencyAccess().getRequestKeyword_2_1_2_1_2_0());
                    	              							
                    	            }
                    	            otherlv_27=(Token)match(input,17,FOLLOW_19); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              								newLeafNode(otherlv_27, grammarAccess.getXDependencyAccess().getColonKeyword_2_1_2_1_2_1());
                    	              							
                    	            }
                    	            // InternalTmscXtext.g:2525:8: ( ( ruleIDString ) )
                    	            // InternalTmscXtext.g:2526:9: ( ruleIDString )
                    	            {
                    	            // InternalTmscXtext.g:2526:9: ( ruleIDString )
                    	            // InternalTmscXtext.g:2527:10: ruleIDString
                    	            {
                    	            if ( state.backtracking==0 ) {

                    	              										if (current==null) {
                    	              											current = createModelElement(grammarAccess.getXDependencyRule());
                    	              										}
                    	              									
                    	            }
                    	            if ( state.backtracking==0 ) {

                    	              										newCompositeNode(grammarAccess.getXDependencyAccess().getRequestXDependencyCrossReference_2_1_2_1_2_2_0());
                    	              									
                    	            }
                    	            pushFollow(FOLLOW_29);
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
                    	            // InternalTmscXtext.g:2543:7: (otherlv_29= 'message' otherlv_30= ':' ( ( ruleIDString ) ) )
                    	            {
                    	            // InternalTmscXtext.g:2543:7: (otherlv_29= 'message' otherlv_30= ':' ( ( ruleIDString ) ) )
                    	            // InternalTmscXtext.g:2544:8: otherlv_29= 'message' otherlv_30= ':' ( ( ruleIDString ) )
                    	            {
                    	            otherlv_29=(Token)match(input,47,FOLLOW_6); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              								newLeafNode(otherlv_29, grammarAccess.getXDependencyAccess().getMessageKeyword_2_1_2_1_3_0());
                    	              							
                    	            }
                    	            otherlv_30=(Token)match(input,17,FOLLOW_19); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              								newLeafNode(otherlv_30, grammarAccess.getXDependencyAccess().getColonKeyword_2_1_2_1_3_1());
                    	              							
                    	            }
                    	            // InternalTmscXtext.g:2552:8: ( ( ruleIDString ) )
                    	            // InternalTmscXtext.g:2553:9: ( ruleIDString )
                    	            {
                    	            // InternalTmscXtext.g:2553:9: ( ruleIDString )
                    	            // InternalTmscXtext.g:2554:10: ruleIDString
                    	            {
                    	            if ( state.backtracking==0 ) {

                    	              										if (current==null) {
                    	              											current = createModelElement(grammarAccess.getXDependencyRule());
                    	              										}
                    	              									
                    	            }
                    	            if ( state.backtracking==0 ) {

                    	              										newCompositeNode(grammarAccess.getXDependencyAccess().getMessageXDependencyCrossReference_2_1_2_1_3_2_0());
                    	              									
                    	            }
                    	            pushFollow(FOLLOW_29);
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
                    	            // InternalTmscXtext.g:2570:7: ( (lv_properties_32_0= ruleXProperty ) )
                    	            {
                    	            // InternalTmscXtext.g:2570:7: ( (lv_properties_32_0= ruleXProperty ) )
                    	            // InternalTmscXtext.g:2571:8: (lv_properties_32_0= ruleXProperty )
                    	            {
                    	            // InternalTmscXtext.g:2571:8: (lv_properties_32_0= ruleXProperty )
                    	            // InternalTmscXtext.g:2572:9: lv_properties_32_0= ruleXProperty
                    	            {
                    	            if ( state.backtracking==0 ) {

                    	              									newCompositeNode(grammarAccess.getXDependencyAccess().getPropertiesXPropertyParserRuleCall_2_1_2_1_4_0());
                    	              								
                    	            }
                    	            pushFollow(FOLLOW_29);
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
                    	    break loop53;
                        }
                    } while (true);

                    otherlv_33=(Token)match(input,39,FOLLOW_2); if (state.failed) return current;
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
    // InternalTmscXtext.g:2601:1: entryRuleXDependencyTypeObject returns [EObject current=null] : iv_ruleXDependencyTypeObject= ruleXDependencyTypeObject EOF ;
    public final EObject entryRuleXDependencyTypeObject() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXDependencyTypeObject = null;


        try {
            // InternalTmscXtext.g:2601:62: (iv_ruleXDependencyTypeObject= ruleXDependencyTypeObject EOF )
            // InternalTmscXtext.g:2602:2: iv_ruleXDependencyTypeObject= ruleXDependencyTypeObject EOF
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
    // InternalTmscXtext.g:2608:1: ruleXDependencyTypeObject returns [EObject current=null] : ( (lv_value_0_0= ruleXDependencyType ) ) ;
    public final EObject ruleXDependencyTypeObject() throws RecognitionException {
        EObject current = null;

        Enumerator lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalTmscXtext.g:2614:2: ( ( (lv_value_0_0= ruleXDependencyType ) ) )
            // InternalTmscXtext.g:2615:2: ( (lv_value_0_0= ruleXDependencyType ) )
            {
            // InternalTmscXtext.g:2615:2: ( (lv_value_0_0= ruleXDependencyType ) )
            // InternalTmscXtext.g:2616:3: (lv_value_0_0= ruleXDependencyType )
            {
            // InternalTmscXtext.g:2616:3: (lv_value_0_0= ruleXDependencyType )
            // InternalTmscXtext.g:2617:4: lv_value_0_0= ruleXDependencyType
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
    // InternalTmscXtext.g:2637:1: entryRuleXDependencySettings returns [EObject current=null] : iv_ruleXDependencySettings= ruleXDependencySettings EOF ;
    public final EObject entryRuleXDependencySettings() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXDependencySettings = null;


        try {
            // InternalTmscXtext.g:2637:60: (iv_ruleXDependencySettings= ruleXDependencySettings EOF )
            // InternalTmscXtext.g:2638:2: iv_ruleXDependencySettings= ruleXDependencySettings EOF
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
    // InternalTmscXtext.g:2644:1: ruleXDependencySettings returns [EObject current=null] : ( ( (lv_type_0_0= ruleXDependencyType ) ) otherlv_1= 'settings' otherlv_2= '{' ( (otherlv_3= 'time-bound' otherlv_4= ':' ( (lv_timeBound_5_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_6= 'scheduled' otherlv_7= ':' ( (lv_scheduled_8_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_9= 'prefix' otherlv_10= ':' ( (lv_prefix_11_0= ruleIDString ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) )* otherlv_13= '}' ) ;
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
            // InternalTmscXtext.g:2650:2: ( ( ( (lv_type_0_0= ruleXDependencyType ) ) otherlv_1= 'settings' otherlv_2= '{' ( (otherlv_3= 'time-bound' otherlv_4= ':' ( (lv_timeBound_5_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_6= 'scheduled' otherlv_7= ':' ( (lv_scheduled_8_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_9= 'prefix' otherlv_10= ':' ( (lv_prefix_11_0= ruleIDString ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) )* otherlv_13= '}' ) )
            // InternalTmscXtext.g:2651:2: ( ( (lv_type_0_0= ruleXDependencyType ) ) otherlv_1= 'settings' otherlv_2= '{' ( (otherlv_3= 'time-bound' otherlv_4= ':' ( (lv_timeBound_5_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_6= 'scheduled' otherlv_7= ':' ( (lv_scheduled_8_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_9= 'prefix' otherlv_10= ':' ( (lv_prefix_11_0= ruleIDString ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) )* otherlv_13= '}' )
            {
            // InternalTmscXtext.g:2651:2: ( ( (lv_type_0_0= ruleXDependencyType ) ) otherlv_1= 'settings' otherlv_2= '{' ( (otherlv_3= 'time-bound' otherlv_4= ':' ( (lv_timeBound_5_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_6= 'scheduled' otherlv_7= ':' ( (lv_scheduled_8_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_9= 'prefix' otherlv_10= ':' ( (lv_prefix_11_0= ruleIDString ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) )* otherlv_13= '}' )
            // InternalTmscXtext.g:2652:3: ( (lv_type_0_0= ruleXDependencyType ) ) otherlv_1= 'settings' otherlv_2= '{' ( (otherlv_3= 'time-bound' otherlv_4= ':' ( (lv_timeBound_5_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_6= 'scheduled' otherlv_7= ':' ( (lv_scheduled_8_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_9= 'prefix' otherlv_10= ':' ( (lv_prefix_11_0= ruleIDString ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) )* otherlv_13= '}'
            {
            // InternalTmscXtext.g:2652:3: ( (lv_type_0_0= ruleXDependencyType ) )
            // InternalTmscXtext.g:2653:4: (lv_type_0_0= ruleXDependencyType )
            {
            // InternalTmscXtext.g:2653:4: (lv_type_0_0= ruleXDependencyType )
            // InternalTmscXtext.g:2654:5: lv_type_0_0= ruleXDependencyType
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
            otherlv_2=(Token)match(input,15,FOLLOW_41); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getXDependencySettingsAccess().getLeftCurlyBracketKeyword_2());
              		
            }
            // InternalTmscXtext.g:2679:3: ( (otherlv_3= 'time-bound' otherlv_4= ':' ( (lv_timeBound_5_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_6= 'scheduled' otherlv_7= ':' ( (lv_scheduled_8_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_9= 'prefix' otherlv_10= ':' ( (lv_prefix_11_0= ruleIDString ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) )*
            loop55:
            do {
                int alt55=5;
                switch ( input.LA(1) ) {
                case 18:
                    {
                    alt55=1;
                    }
                    break;
                case 19:
                    {
                    alt55=2;
                    }
                    break;
                case 48:
                    {
                    alt55=3;
                    }
                    break;
                case RULE_ID:
                case RULE_STRING:
                    {
                    alt55=4;
                    }
                    break;

                }

                switch (alt55) {
            	case 1 :
            	    // InternalTmscXtext.g:2680:4: (otherlv_3= 'time-bound' otherlv_4= ':' ( (lv_timeBound_5_0= RULE_ABS_EBIGDECIMAL ) ) )
            	    {
            	    // InternalTmscXtext.g:2680:4: (otherlv_3= 'time-bound' otherlv_4= ':' ( (lv_timeBound_5_0= RULE_ABS_EBIGDECIMAL ) ) )
            	    // InternalTmscXtext.g:2681:5: otherlv_3= 'time-bound' otherlv_4= ':' ( (lv_timeBound_5_0= RULE_ABS_EBIGDECIMAL ) )
            	    {
            	    otherlv_3=(Token)match(input,18,FOLLOW_6); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_3, grammarAccess.getXDependencySettingsAccess().getTimeBoundKeyword_3_0_0());
            	      				
            	    }
            	    otherlv_4=(Token)match(input,17,FOLLOW_8); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_4, grammarAccess.getXDependencySettingsAccess().getColonKeyword_3_0_1());
            	      				
            	    }
            	    // InternalTmscXtext.g:2689:5: ( (lv_timeBound_5_0= RULE_ABS_EBIGDECIMAL ) )
            	    // InternalTmscXtext.g:2690:6: (lv_timeBound_5_0= RULE_ABS_EBIGDECIMAL )
            	    {
            	    // InternalTmscXtext.g:2690:6: (lv_timeBound_5_0= RULE_ABS_EBIGDECIMAL )
            	    // InternalTmscXtext.g:2691:7: lv_timeBound_5_0= RULE_ABS_EBIGDECIMAL
            	    {
            	    lv_timeBound_5_0=(Token)match(input,RULE_ABS_EBIGDECIMAL,FOLLOW_41); if (state.failed) return current;
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
            	    // InternalTmscXtext.g:2709:4: (otherlv_6= 'scheduled' otherlv_7= ':' ( (lv_scheduled_8_0= ruleEBOOLEAN_OBJECT ) ) )
            	    {
            	    // InternalTmscXtext.g:2709:4: (otherlv_6= 'scheduled' otherlv_7= ':' ( (lv_scheduled_8_0= ruleEBOOLEAN_OBJECT ) ) )
            	    // InternalTmscXtext.g:2710:5: otherlv_6= 'scheduled' otherlv_7= ':' ( (lv_scheduled_8_0= ruleEBOOLEAN_OBJECT ) )
            	    {
            	    otherlv_6=(Token)match(input,19,FOLLOW_6); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_6, grammarAccess.getXDependencySettingsAccess().getScheduledKeyword_3_1_0());
            	      				
            	    }
            	    otherlv_7=(Token)match(input,17,FOLLOW_9); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_7, grammarAccess.getXDependencySettingsAccess().getColonKeyword_3_1_1());
            	      				
            	    }
            	    // InternalTmscXtext.g:2718:5: ( (lv_scheduled_8_0= ruleEBOOLEAN_OBJECT ) )
            	    // InternalTmscXtext.g:2719:6: (lv_scheduled_8_0= ruleEBOOLEAN_OBJECT )
            	    {
            	    // InternalTmscXtext.g:2719:6: (lv_scheduled_8_0= ruleEBOOLEAN_OBJECT )
            	    // InternalTmscXtext.g:2720:7: lv_scheduled_8_0= ruleEBOOLEAN_OBJECT
            	    {
            	    if ( state.backtracking==0 ) {

            	      							newCompositeNode(grammarAccess.getXDependencySettingsAccess().getScheduledEBOOLEAN_OBJECTParserRuleCall_3_1_2_0());
            	      						
            	    }
            	    pushFollow(FOLLOW_41);
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
            	    // InternalTmscXtext.g:2739:4: (otherlv_9= 'prefix' otherlv_10= ':' ( (lv_prefix_11_0= ruleIDString ) ) )
            	    {
            	    // InternalTmscXtext.g:2739:4: (otherlv_9= 'prefix' otherlv_10= ':' ( (lv_prefix_11_0= ruleIDString ) ) )
            	    // InternalTmscXtext.g:2740:5: otherlv_9= 'prefix' otherlv_10= ':' ( (lv_prefix_11_0= ruleIDString ) )
            	    {
            	    otherlv_9=(Token)match(input,48,FOLLOW_6); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_9, grammarAccess.getXDependencySettingsAccess().getPrefixKeyword_3_2_0());
            	      				
            	    }
            	    otherlv_10=(Token)match(input,17,FOLLOW_19); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_10, grammarAccess.getXDependencySettingsAccess().getColonKeyword_3_2_1());
            	      				
            	    }
            	    // InternalTmscXtext.g:2748:5: ( (lv_prefix_11_0= ruleIDString ) )
            	    // InternalTmscXtext.g:2749:6: (lv_prefix_11_0= ruleIDString )
            	    {
            	    // InternalTmscXtext.g:2749:6: (lv_prefix_11_0= ruleIDString )
            	    // InternalTmscXtext.g:2750:7: lv_prefix_11_0= ruleIDString
            	    {
            	    if ( state.backtracking==0 ) {

            	      							newCompositeNode(grammarAccess.getXDependencySettingsAccess().getPrefixIDStringParserRuleCall_3_2_2_0());
            	      						
            	    }
            	    pushFollow(FOLLOW_41);
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
            	    // InternalTmscXtext.g:2769:4: ( (lv_properties_12_0= ruleXProperty ) )
            	    {
            	    // InternalTmscXtext.g:2769:4: ( (lv_properties_12_0= ruleXProperty ) )
            	    // InternalTmscXtext.g:2770:5: (lv_properties_12_0= ruleXProperty )
            	    {
            	    // InternalTmscXtext.g:2770:5: (lv_properties_12_0= ruleXProperty )
            	    // InternalTmscXtext.g:2771:6: lv_properties_12_0= ruleXProperty
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getXDependencySettingsAccess().getPropertiesXPropertyParserRuleCall_3_3_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_41);
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
            	    break loop55;
                }
            } while (true);

            otherlv_13=(Token)match(input,22,FOLLOW_2); if (state.failed) return current;
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
    // InternalTmscXtext.g:2797:1: entryRuleXProperty returns [EObject current=null] : iv_ruleXProperty= ruleXProperty EOF ;
    public final EObject entryRuleXProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXProperty = null;


        try {
            // InternalTmscXtext.g:2797:50: (iv_ruleXProperty= ruleXProperty EOF )
            // InternalTmscXtext.g:2798:2: iv_ruleXProperty= ruleXProperty EOF
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
    // InternalTmscXtext.g:2804:1: ruleXProperty returns [EObject current=null] : ( ( (lv_name_0_0= ruleIDString ) ) otherlv_1= ':' ( (lv_value_2_0= ruleXPropertyValue ) ) ) ;
    public final EObject ruleXProperty() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalTmscXtext.g:2810:2: ( ( ( (lv_name_0_0= ruleIDString ) ) otherlv_1= ':' ( (lv_value_2_0= ruleXPropertyValue ) ) ) )
            // InternalTmscXtext.g:2811:2: ( ( (lv_name_0_0= ruleIDString ) ) otherlv_1= ':' ( (lv_value_2_0= ruleXPropertyValue ) ) )
            {
            // InternalTmscXtext.g:2811:2: ( ( (lv_name_0_0= ruleIDString ) ) otherlv_1= ':' ( (lv_value_2_0= ruleXPropertyValue ) ) )
            // InternalTmscXtext.g:2812:3: ( (lv_name_0_0= ruleIDString ) ) otherlv_1= ':' ( (lv_value_2_0= ruleXPropertyValue ) )
            {
            // InternalTmscXtext.g:2812:3: ( (lv_name_0_0= ruleIDString ) )
            // InternalTmscXtext.g:2813:4: (lv_name_0_0= ruleIDString )
            {
            // InternalTmscXtext.g:2813:4: (lv_name_0_0= ruleIDString )
            // InternalTmscXtext.g:2814:5: lv_name_0_0= ruleIDString
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

            otherlv_1=(Token)match(input,17,FOLLOW_42); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getXPropertyAccess().getColonKeyword_1());
              		
            }
            // InternalTmscXtext.g:2835:3: ( (lv_value_2_0= ruleXPropertyValue ) )
            // InternalTmscXtext.g:2836:4: (lv_value_2_0= ruleXPropertyValue )
            {
            // InternalTmscXtext.g:2836:4: (lv_value_2_0= ruleXPropertyValue )
            // InternalTmscXtext.g:2837:5: lv_value_2_0= ruleXPropertyValue
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
    // InternalTmscXtext.g:2858:1: entryRuleXPropertyValue returns [EObject current=null] : iv_ruleXPropertyValue= ruleXPropertyValue EOF ;
    public final EObject entryRuleXPropertyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXPropertyValue = null;


        try {
            // InternalTmscXtext.g:2858:55: (iv_ruleXPropertyValue= ruleXPropertyValue EOF )
            // InternalTmscXtext.g:2859:2: iv_ruleXPropertyValue= ruleXPropertyValue EOF
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
    // InternalTmscXtext.g:2865:1: ruleXPropertyValue returns [EObject current=null] : ( ( () ( ( ( ruleIDString ) )=> (lv_value_1_0= ruleIDString ) ) ) | ( () ( ( ( ruleEBIGDECIMAL ) )=> (lv_value_3_0= ruleEBIGDECIMAL ) ) ) | ( () ( ( ( ruleEBOOLEAN_OBJECT ) )=> (lv_value_5_0= ruleEBOOLEAN_OBJECT ) ) ) | ( () ( ( '[' )=>otherlv_7= '[' ) ( (lv_values_8_0= ruleXPropertyValue ) ) (otherlv_9= ',' ( (lv_values_10_0= ruleXPropertyValue ) ) )* otherlv_11= ']' ) ) ;
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
            // InternalTmscXtext.g:2871:2: ( ( ( () ( ( ( ruleIDString ) )=> (lv_value_1_0= ruleIDString ) ) ) | ( () ( ( ( ruleEBIGDECIMAL ) )=> (lv_value_3_0= ruleEBIGDECIMAL ) ) ) | ( () ( ( ( ruleEBOOLEAN_OBJECT ) )=> (lv_value_5_0= ruleEBOOLEAN_OBJECT ) ) ) | ( () ( ( '[' )=>otherlv_7= '[' ) ( (lv_values_8_0= ruleXPropertyValue ) ) (otherlv_9= ',' ( (lv_values_10_0= ruleXPropertyValue ) ) )* otherlv_11= ']' ) ) )
            // InternalTmscXtext.g:2872:2: ( ( () ( ( ( ruleIDString ) )=> (lv_value_1_0= ruleIDString ) ) ) | ( () ( ( ( ruleEBIGDECIMAL ) )=> (lv_value_3_0= ruleEBIGDECIMAL ) ) ) | ( () ( ( ( ruleEBOOLEAN_OBJECT ) )=> (lv_value_5_0= ruleEBOOLEAN_OBJECT ) ) ) | ( () ( ( '[' )=>otherlv_7= '[' ) ( (lv_values_8_0= ruleXPropertyValue ) ) (otherlv_9= ',' ( (lv_values_10_0= ruleXPropertyValue ) ) )* otherlv_11= ']' ) )
            {
            // InternalTmscXtext.g:2872:2: ( ( () ( ( ( ruleIDString ) )=> (lv_value_1_0= ruleIDString ) ) ) | ( () ( ( ( ruleEBIGDECIMAL ) )=> (lv_value_3_0= ruleEBIGDECIMAL ) ) ) | ( () ( ( ( ruleEBOOLEAN_OBJECT ) )=> (lv_value_5_0= ruleEBOOLEAN_OBJECT ) ) ) | ( () ( ( '[' )=>otherlv_7= '[' ) ( (lv_values_8_0= ruleXPropertyValue ) ) (otherlv_9= ',' ( (lv_values_10_0= ruleXPropertyValue ) ) )* otherlv_11= ']' ) )
            int alt57=4;
            switch ( input.LA(1) ) {
            case RULE_ID:
            case RULE_STRING:
                {
                alt57=1;
                }
                break;
            case RULE_ABS_EBIGDECIMAL:
            case RULE_POS_EBIGDECIMAL:
            case RULE_NEG_EBIGDECIMAL:
                {
                alt57=2;
                }
                break;
            case 52:
            case 53:
                {
                alt57=3;
                }
                break;
            case 49:
                {
                alt57=4;
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
                    // InternalTmscXtext.g:2873:3: ( () ( ( ( ruleIDString ) )=> (lv_value_1_0= ruleIDString ) ) )
                    {
                    // InternalTmscXtext.g:2873:3: ( () ( ( ( ruleIDString ) )=> (lv_value_1_0= ruleIDString ) ) )
                    // InternalTmscXtext.g:2874:4: () ( ( ( ruleIDString ) )=> (lv_value_1_0= ruleIDString ) )
                    {
                    // InternalTmscXtext.g:2874:4: ()
                    // InternalTmscXtext.g:2875:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getXPropertyValueAccess().getXPropertyStringValueAction_0_0(),
                      						current);
                      				
                    }

                    }

                    // InternalTmscXtext.g:2881:4: ( ( ( ruleIDString ) )=> (lv_value_1_0= ruleIDString ) )
                    // InternalTmscXtext.g:2882:5: ( ( ruleIDString ) )=> (lv_value_1_0= ruleIDString )
                    {
                    // InternalTmscXtext.g:2886:5: (lv_value_1_0= ruleIDString )
                    // InternalTmscXtext.g:2887:6: lv_value_1_0= ruleIDString
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
                    // InternalTmscXtext.g:2906:3: ( () ( ( ( ruleEBIGDECIMAL ) )=> (lv_value_3_0= ruleEBIGDECIMAL ) ) )
                    {
                    // InternalTmscXtext.g:2906:3: ( () ( ( ( ruleEBIGDECIMAL ) )=> (lv_value_3_0= ruleEBIGDECIMAL ) ) )
                    // InternalTmscXtext.g:2907:4: () ( ( ( ruleEBIGDECIMAL ) )=> (lv_value_3_0= ruleEBIGDECIMAL ) )
                    {
                    // InternalTmscXtext.g:2907:4: ()
                    // InternalTmscXtext.g:2908:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getXPropertyValueAccess().getXPropertyNumberValueAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalTmscXtext.g:2914:4: ( ( ( ruleEBIGDECIMAL ) )=> (lv_value_3_0= ruleEBIGDECIMAL ) )
                    // InternalTmscXtext.g:2915:5: ( ( ruleEBIGDECIMAL ) )=> (lv_value_3_0= ruleEBIGDECIMAL )
                    {
                    // InternalTmscXtext.g:2919:5: (lv_value_3_0= ruleEBIGDECIMAL )
                    // InternalTmscXtext.g:2920:6: lv_value_3_0= ruleEBIGDECIMAL
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
                    // InternalTmscXtext.g:2939:3: ( () ( ( ( ruleEBOOLEAN_OBJECT ) )=> (lv_value_5_0= ruleEBOOLEAN_OBJECT ) ) )
                    {
                    // InternalTmscXtext.g:2939:3: ( () ( ( ( ruleEBOOLEAN_OBJECT ) )=> (lv_value_5_0= ruleEBOOLEAN_OBJECT ) ) )
                    // InternalTmscXtext.g:2940:4: () ( ( ( ruleEBOOLEAN_OBJECT ) )=> (lv_value_5_0= ruleEBOOLEAN_OBJECT ) )
                    {
                    // InternalTmscXtext.g:2940:4: ()
                    // InternalTmscXtext.g:2941:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getXPropertyValueAccess().getXPropertyBooleanValueAction_2_0(),
                      						current);
                      				
                    }

                    }

                    // InternalTmscXtext.g:2947:4: ( ( ( ruleEBOOLEAN_OBJECT ) )=> (lv_value_5_0= ruleEBOOLEAN_OBJECT ) )
                    // InternalTmscXtext.g:2948:5: ( ( ruleEBOOLEAN_OBJECT ) )=> (lv_value_5_0= ruleEBOOLEAN_OBJECT )
                    {
                    // InternalTmscXtext.g:2952:5: (lv_value_5_0= ruleEBOOLEAN_OBJECT )
                    // InternalTmscXtext.g:2953:6: lv_value_5_0= ruleEBOOLEAN_OBJECT
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
                    // InternalTmscXtext.g:2972:3: ( () ( ( '[' )=>otherlv_7= '[' ) ( (lv_values_8_0= ruleXPropertyValue ) ) (otherlv_9= ',' ( (lv_values_10_0= ruleXPropertyValue ) ) )* otherlv_11= ']' )
                    {
                    // InternalTmscXtext.g:2972:3: ( () ( ( '[' )=>otherlv_7= '[' ) ( (lv_values_8_0= ruleXPropertyValue ) ) (otherlv_9= ',' ( (lv_values_10_0= ruleXPropertyValue ) ) )* otherlv_11= ']' )
                    // InternalTmscXtext.g:2973:4: () ( ( '[' )=>otherlv_7= '[' ) ( (lv_values_8_0= ruleXPropertyValue ) ) (otherlv_9= ',' ( (lv_values_10_0= ruleXPropertyValue ) ) )* otherlv_11= ']'
                    {
                    // InternalTmscXtext.g:2973:4: ()
                    // InternalTmscXtext.g:2974:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getXPropertyValueAccess().getXPropertyMutliValueAction_3_0(),
                      						current);
                      				
                    }

                    }

                    // InternalTmscXtext.g:2980:4: ( ( '[' )=>otherlv_7= '[' )
                    // InternalTmscXtext.g:2981:5: ( '[' )=>otherlv_7= '['
                    {
                    otherlv_7=(Token)match(input,49,FOLLOW_42); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_7, grammarAccess.getXPropertyValueAccess().getLeftSquareBracketKeyword_3_1());
                      				
                    }

                    }

                    // InternalTmscXtext.g:2987:4: ( (lv_values_8_0= ruleXPropertyValue ) )
                    // InternalTmscXtext.g:2988:5: (lv_values_8_0= ruleXPropertyValue )
                    {
                    // InternalTmscXtext.g:2988:5: (lv_values_8_0= ruleXPropertyValue )
                    // InternalTmscXtext.g:2989:6: lv_values_8_0= ruleXPropertyValue
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getXPropertyValueAccess().getValuesXPropertyValueParserRuleCall_3_2_0());
                      					
                    }
                    pushFollow(FOLLOW_43);
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

                    // InternalTmscXtext.g:3006:4: (otherlv_9= ',' ( (lv_values_10_0= ruleXPropertyValue ) ) )*
                    loop56:
                    do {
                        int alt56=2;
                        int LA56_0 = input.LA(1);

                        if ( (LA56_0==33) ) {
                            alt56=1;
                        }


                        switch (alt56) {
                    	case 1 :
                    	    // InternalTmscXtext.g:3007:5: otherlv_9= ',' ( (lv_values_10_0= ruleXPropertyValue ) )
                    	    {
                    	    otherlv_9=(Token)match(input,33,FOLLOW_42); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_9, grammarAccess.getXPropertyValueAccess().getCommaKeyword_3_3_0());
                    	      				
                    	    }
                    	    // InternalTmscXtext.g:3011:5: ( (lv_values_10_0= ruleXPropertyValue ) )
                    	    // InternalTmscXtext.g:3012:6: (lv_values_10_0= ruleXPropertyValue )
                    	    {
                    	    // InternalTmscXtext.g:3012:6: (lv_values_10_0= ruleXPropertyValue )
                    	    // InternalTmscXtext.g:3013:7: lv_values_10_0= ruleXPropertyValue
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getXPropertyValueAccess().getValuesXPropertyValueParserRuleCall_3_3_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_43);
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
                    	    break loop56;
                        }
                    } while (true);

                    otherlv_11=(Token)match(input,50,FOLLOW_2); if (state.failed) return current;
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
    // InternalTmscXtext.g:3040:1: entryRuleFQNString returns [String current=null] : iv_ruleFQNString= ruleFQNString EOF ;
    public final String entryRuleFQNString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQNString = null;


        try {
            // InternalTmscXtext.g:3040:49: (iv_ruleFQNString= ruleFQNString EOF )
            // InternalTmscXtext.g:3041:2: iv_ruleFQNString= ruleFQNString EOF
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
    // InternalTmscXtext.g:3047:1: ruleFQNString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_FQN_0= ruleFQN | this_STRING_1= RULE_STRING ) ;
    public final AntlrDatatypeRuleToken ruleFQNString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_1=null;
        AntlrDatatypeRuleToken this_FQN_0 = null;



        	enterRule();

        try {
            // InternalTmscXtext.g:3053:2: ( (this_FQN_0= ruleFQN | this_STRING_1= RULE_STRING ) )
            // InternalTmscXtext.g:3054:2: (this_FQN_0= ruleFQN | this_STRING_1= RULE_STRING )
            {
            // InternalTmscXtext.g:3054:2: (this_FQN_0= ruleFQN | this_STRING_1= RULE_STRING )
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==RULE_ID) ) {
                alt58=1;
            }
            else if ( (LA58_0==RULE_STRING) ) {
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
                    // InternalTmscXtext.g:3055:3: this_FQN_0= ruleFQN
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
                    // InternalTmscXtext.g:3066:3: this_STRING_1= RULE_STRING
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
    // InternalTmscXtext.g:3077:1: entryRuleIDString returns [String current=null] : iv_ruleIDString= ruleIDString EOF ;
    public final String entryRuleIDString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIDString = null;


        try {
            // InternalTmscXtext.g:3077:48: (iv_ruleIDString= ruleIDString EOF )
            // InternalTmscXtext.g:3078:2: iv_ruleIDString= ruleIDString EOF
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
    // InternalTmscXtext.g:3084:1: ruleIDString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | this_STRING_1= RULE_STRING ) ;
    public final AntlrDatatypeRuleToken ruleIDString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token this_STRING_1=null;


        	enterRule();

        try {
            // InternalTmscXtext.g:3090:2: ( (this_ID_0= RULE_ID | this_STRING_1= RULE_STRING ) )
            // InternalTmscXtext.g:3091:2: (this_ID_0= RULE_ID | this_STRING_1= RULE_STRING )
            {
            // InternalTmscXtext.g:3091:2: (this_ID_0= RULE_ID | this_STRING_1= RULE_STRING )
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==RULE_ID) ) {
                alt59=1;
            }
            else if ( (LA59_0==RULE_STRING) ) {
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
                    // InternalTmscXtext.g:3092:3: this_ID_0= RULE_ID
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
                    // InternalTmscXtext.g:3100:3: this_STRING_1= RULE_STRING
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
    // InternalTmscXtext.g:3111:1: entryRuleFQN returns [String current=null] : iv_ruleFQN= ruleFQN EOF ;
    public final String entryRuleFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQN = null;


        try {
            // InternalTmscXtext.g:3111:43: (iv_ruleFQN= ruleFQN EOF )
            // InternalTmscXtext.g:3112:2: iv_ruleFQN= ruleFQN EOF
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
    // InternalTmscXtext.g:3118:1: ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalTmscXtext.g:3124:2: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalTmscXtext.g:3125:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalTmscXtext.g:3125:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalTmscXtext.g:3126:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_44); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_ID_0);
              		
            }
            if ( state.backtracking==0 ) {

              			newLeafNode(this_ID_0, grammarAccess.getFQNAccess().getIDTerminalRuleCall_0());
              		
            }
            // InternalTmscXtext.g:3133:3: (kw= '.' this_ID_2= RULE_ID )*
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( (LA60_0==51) ) {
                    alt60=1;
                }


                switch (alt60) {
            	case 1 :
            	    // InternalTmscXtext.g:3134:4: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,51,FOLLOW_21); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				current.merge(kw);
            	      				newLeafNode(kw, grammarAccess.getFQNAccess().getFullStopKeyword_1_0());
            	      			
            	    }
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_44); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				current.merge(this_ID_2);
            	      			
            	    }
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(this_ID_2, grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1());
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop60;
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
    // InternalTmscXtext.g:3151:1: entryRuleEBOOLEAN_OBJECT returns [String current=null] : iv_ruleEBOOLEAN_OBJECT= ruleEBOOLEAN_OBJECT EOF ;
    public final String entryRuleEBOOLEAN_OBJECT() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEBOOLEAN_OBJECT = null;


        try {
            // InternalTmscXtext.g:3151:55: (iv_ruleEBOOLEAN_OBJECT= ruleEBOOLEAN_OBJECT EOF )
            // InternalTmscXtext.g:3152:2: iv_ruleEBOOLEAN_OBJECT= ruleEBOOLEAN_OBJECT EOF
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
    // InternalTmscXtext.g:3158:1: ruleEBOOLEAN_OBJECT returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'true' | kw= 'false' ) ;
    public final AntlrDatatypeRuleToken ruleEBOOLEAN_OBJECT() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalTmscXtext.g:3164:2: ( (kw= 'true' | kw= 'false' ) )
            // InternalTmscXtext.g:3165:2: (kw= 'true' | kw= 'false' )
            {
            // InternalTmscXtext.g:3165:2: (kw= 'true' | kw= 'false' )
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
                    // InternalTmscXtext.g:3166:3: kw= 'true'
                    {
                    kw=(Token)match(input,52,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getEBOOLEAN_OBJECTAccess().getTrueKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalTmscXtext.g:3172:3: kw= 'false'
                    {
                    kw=(Token)match(input,53,FOLLOW_2); if (state.failed) return current;
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
    // InternalTmscXtext.g:3181:1: entryRuleEBIGDECIMAL returns [String current=null] : iv_ruleEBIGDECIMAL= ruleEBIGDECIMAL EOF ;
    public final String entryRuleEBIGDECIMAL() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEBIGDECIMAL = null;


        try {
            // InternalTmscXtext.g:3181:51: (iv_ruleEBIGDECIMAL= ruleEBIGDECIMAL EOF )
            // InternalTmscXtext.g:3182:2: iv_ruleEBIGDECIMAL= ruleEBIGDECIMAL EOF
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
    // InternalTmscXtext.g:3188:1: ruleEBIGDECIMAL returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ABS_EBIGDECIMAL_0= RULE_ABS_EBIGDECIMAL | this_POS_EBIGDECIMAL_1= RULE_POS_EBIGDECIMAL | this_NEG_EBIGDECIMAL_2= RULE_NEG_EBIGDECIMAL ) ;
    public final AntlrDatatypeRuleToken ruleEBIGDECIMAL() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ABS_EBIGDECIMAL_0=null;
        Token this_POS_EBIGDECIMAL_1=null;
        Token this_NEG_EBIGDECIMAL_2=null;


        	enterRule();

        try {
            // InternalTmscXtext.g:3194:2: ( (this_ABS_EBIGDECIMAL_0= RULE_ABS_EBIGDECIMAL | this_POS_EBIGDECIMAL_1= RULE_POS_EBIGDECIMAL | this_NEG_EBIGDECIMAL_2= RULE_NEG_EBIGDECIMAL ) )
            // InternalTmscXtext.g:3195:2: (this_ABS_EBIGDECIMAL_0= RULE_ABS_EBIGDECIMAL | this_POS_EBIGDECIMAL_1= RULE_POS_EBIGDECIMAL | this_NEG_EBIGDECIMAL_2= RULE_NEG_EBIGDECIMAL )
            {
            // InternalTmscXtext.g:3195:2: (this_ABS_EBIGDECIMAL_0= RULE_ABS_EBIGDECIMAL | this_POS_EBIGDECIMAL_1= RULE_POS_EBIGDECIMAL | this_NEG_EBIGDECIMAL_2= RULE_NEG_EBIGDECIMAL )
            int alt62=3;
            switch ( input.LA(1) ) {
            case RULE_ABS_EBIGDECIMAL:
                {
                alt62=1;
                }
                break;
            case RULE_POS_EBIGDECIMAL:
                {
                alt62=2;
                }
                break;
            case RULE_NEG_EBIGDECIMAL:
                {
                alt62=3;
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
                    // InternalTmscXtext.g:3196:3: this_ABS_EBIGDECIMAL_0= RULE_ABS_EBIGDECIMAL
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
                    // InternalTmscXtext.g:3204:3: this_POS_EBIGDECIMAL_1= RULE_POS_EBIGDECIMAL
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
                    // InternalTmscXtext.g:3212:3: this_NEG_EBIGDECIMAL_2= RULE_NEG_EBIGDECIMAL
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
    // InternalTmscXtext.g:3223:1: ruleXArchitectureKind returns [Enumerator current=null] : ( (enumLiteral_0= 'internal' ) | (enumLiteral_1= 'external' ) ) ;
    public final Enumerator ruleXArchitectureKind() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalTmscXtext.g:3229:2: ( ( (enumLiteral_0= 'internal' ) | (enumLiteral_1= 'external' ) ) )
            // InternalTmscXtext.g:3230:2: ( (enumLiteral_0= 'internal' ) | (enumLiteral_1= 'external' ) )
            {
            // InternalTmscXtext.g:3230:2: ( (enumLiteral_0= 'internal' ) | (enumLiteral_1= 'external' ) )
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==54) ) {
                alt63=1;
            }
            else if ( (LA63_0==55) ) {
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
                    // InternalTmscXtext.g:3231:3: (enumLiteral_0= 'internal' )
                    {
                    // InternalTmscXtext.g:3231:3: (enumLiteral_0= 'internal' )
                    // InternalTmscXtext.g:3232:4: enumLiteral_0= 'internal'
                    {
                    enumLiteral_0=(Token)match(input,54,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getXArchitectureKindAccess().getINTERNALEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getXArchitectureKindAccess().getINTERNALEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalTmscXtext.g:3239:3: (enumLiteral_1= 'external' )
                    {
                    // InternalTmscXtext.g:3239:3: (enumLiteral_1= 'external' )
                    // InternalTmscXtext.g:3240:4: enumLiteral_1= 'external'
                    {
                    enumLiteral_1=(Token)match(input,55,FOLLOW_2); if (state.failed) return current;
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
    // InternalTmscXtext.g:3250:1: ruleXFunctionParameterKind returns [Enumerator current=null] : ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'out' ) | (enumLiteral_2= 'inout' ) | (enumLiteral_3= 'return' ) ) ;
    public final Enumerator ruleXFunctionParameterKind() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalTmscXtext.g:3256:2: ( ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'out' ) | (enumLiteral_2= 'inout' ) | (enumLiteral_3= 'return' ) ) )
            // InternalTmscXtext.g:3257:2: ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'out' ) | (enumLiteral_2= 'inout' ) | (enumLiteral_3= 'return' ) )
            {
            // InternalTmscXtext.g:3257:2: ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'out' ) | (enumLiteral_2= 'inout' ) | (enumLiteral_3= 'return' ) )
            int alt64=4;
            switch ( input.LA(1) ) {
            case 56:
                {
                alt64=1;
                }
                break;
            case 57:
                {
                alt64=2;
                }
                break;
            case 58:
                {
                alt64=3;
                }
                break;
            case 59:
                {
                alt64=4;
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
                    // InternalTmscXtext.g:3258:3: (enumLiteral_0= 'in' )
                    {
                    // InternalTmscXtext.g:3258:3: (enumLiteral_0= 'in' )
                    // InternalTmscXtext.g:3259:4: enumLiteral_0= 'in'
                    {
                    enumLiteral_0=(Token)match(input,56,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getXFunctionParameterKindAccess().getINEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getXFunctionParameterKindAccess().getINEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalTmscXtext.g:3266:3: (enumLiteral_1= 'out' )
                    {
                    // InternalTmscXtext.g:3266:3: (enumLiteral_1= 'out' )
                    // InternalTmscXtext.g:3267:4: enumLiteral_1= 'out'
                    {
                    enumLiteral_1=(Token)match(input,57,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getXFunctionParameterKindAccess().getOUTEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getXFunctionParameterKindAccess().getOUTEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalTmscXtext.g:3274:3: (enumLiteral_2= 'inout' )
                    {
                    // InternalTmscXtext.g:3274:3: (enumLiteral_2= 'inout' )
                    // InternalTmscXtext.g:3275:4: enumLiteral_2= 'inout'
                    {
                    enumLiteral_2=(Token)match(input,58,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getXFunctionParameterKindAccess().getIN_OUTEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getXFunctionParameterKindAccess().getIN_OUTEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalTmscXtext.g:3282:3: (enumLiteral_3= 'return' )
                    {
                    // InternalTmscXtext.g:3282:3: (enumLiteral_3= 'return' )
                    // InternalTmscXtext.g:3283:4: enumLiteral_3= 'return'
                    {
                    enumLiteral_3=(Token)match(input,59,FOLLOW_2); if (state.failed) return current;
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
    // InternalTmscXtext.g:3293:1: ruleXEventType returns [Enumerator current=null] : ( (enumLiteral_0= '>' ) | (enumLiteral_1= '<' ) ) ;
    public final Enumerator ruleXEventType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalTmscXtext.g:3299:2: ( ( (enumLiteral_0= '>' ) | (enumLiteral_1= '<' ) ) )
            // InternalTmscXtext.g:3300:2: ( (enumLiteral_0= '>' ) | (enumLiteral_1= '<' ) )
            {
            // InternalTmscXtext.g:3300:2: ( (enumLiteral_0= '>' ) | (enumLiteral_1= '<' ) )
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==60) ) {
                alt65=1;
            }
            else if ( (LA65_0==61) ) {
                alt65=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 65, 0, input);

                throw nvae;
            }
            switch (alt65) {
                case 1 :
                    // InternalTmscXtext.g:3301:3: (enumLiteral_0= '>' )
                    {
                    // InternalTmscXtext.g:3301:3: (enumLiteral_0= '>' )
                    // InternalTmscXtext.g:3302:4: enumLiteral_0= '>'
                    {
                    enumLiteral_0=(Token)match(input,60,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getXEventTypeAccess().getENTRYEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getXEventTypeAccess().getENTRYEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalTmscXtext.g:3309:3: (enumLiteral_1= '<' )
                    {
                    // InternalTmscXtext.g:3309:3: (enumLiteral_1= '<' )
                    // InternalTmscXtext.g:3310:4: enumLiteral_1= '<'
                    {
                    enumLiteral_1=(Token)match(input,61,FOLLOW_2); if (state.failed) return current;
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
    // InternalTmscXtext.g:3320:1: ruleXDependencyType returns [Enumerator current=null] : ( (enumLiteral_0= 'message' ) | (enumLiteral_1= 'request' ) | (enumLiteral_2= 'reply' ) | (enumLiteral_3= 'domain-dependency' ) | (enumLiteral_4= 'lifeline-segment' ) | (enumLiteral_5= 'message-control' ) ) ;
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
            // InternalTmscXtext.g:3326:2: ( ( (enumLiteral_0= 'message' ) | (enumLiteral_1= 'request' ) | (enumLiteral_2= 'reply' ) | (enumLiteral_3= 'domain-dependency' ) | (enumLiteral_4= 'lifeline-segment' ) | (enumLiteral_5= 'message-control' ) ) )
            // InternalTmscXtext.g:3327:2: ( (enumLiteral_0= 'message' ) | (enumLiteral_1= 'request' ) | (enumLiteral_2= 'reply' ) | (enumLiteral_3= 'domain-dependency' ) | (enumLiteral_4= 'lifeline-segment' ) | (enumLiteral_5= 'message-control' ) )
            {
            // InternalTmscXtext.g:3327:2: ( (enumLiteral_0= 'message' ) | (enumLiteral_1= 'request' ) | (enumLiteral_2= 'reply' ) | (enumLiteral_3= 'domain-dependency' ) | (enumLiteral_4= 'lifeline-segment' ) | (enumLiteral_5= 'message-control' ) )
            int alt66=6;
            switch ( input.LA(1) ) {
            case 47:
                {
                alt66=1;
                }
                break;
            case 46:
                {
                alt66=2;
                }
                break;
            case 62:
                {
                alt66=3;
                }
                break;
            case 63:
                {
                alt66=4;
                }
                break;
            case 64:
                {
                alt66=5;
                }
                break;
            case 65:
                {
                alt66=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 66, 0, input);

                throw nvae;
            }

            switch (alt66) {
                case 1 :
                    // InternalTmscXtext.g:3328:3: (enumLiteral_0= 'message' )
                    {
                    // InternalTmscXtext.g:3328:3: (enumLiteral_0= 'message' )
                    // InternalTmscXtext.g:3329:4: enumLiteral_0= 'message'
                    {
                    enumLiteral_0=(Token)match(input,47,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getXDependencyTypeAccess().getMESSAGEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getXDependencyTypeAccess().getMESSAGEEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalTmscXtext.g:3336:3: (enumLiteral_1= 'request' )
                    {
                    // InternalTmscXtext.g:3336:3: (enumLiteral_1= 'request' )
                    // InternalTmscXtext.g:3337:4: enumLiteral_1= 'request'
                    {
                    enumLiteral_1=(Token)match(input,46,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getXDependencyTypeAccess().getREQUESTEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getXDependencyTypeAccess().getREQUESTEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalTmscXtext.g:3344:3: (enumLiteral_2= 'reply' )
                    {
                    // InternalTmscXtext.g:3344:3: (enumLiteral_2= 'reply' )
                    // InternalTmscXtext.g:3345:4: enumLiteral_2= 'reply'
                    {
                    enumLiteral_2=(Token)match(input,62,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getXDependencyTypeAccess().getREPLYEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getXDependencyTypeAccess().getREPLYEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalTmscXtext.g:3352:3: (enumLiteral_3= 'domain-dependency' )
                    {
                    // InternalTmscXtext.g:3352:3: (enumLiteral_3= 'domain-dependency' )
                    // InternalTmscXtext.g:3353:4: enumLiteral_3= 'domain-dependency'
                    {
                    enumLiteral_3=(Token)match(input,63,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getXDependencyTypeAccess().getDOMAINEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_3, grammarAccess.getXDependencyTypeAccess().getDOMAINEnumLiteralDeclaration_3());
                      			
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalTmscXtext.g:3360:3: (enumLiteral_4= 'lifeline-segment' )
                    {
                    // InternalTmscXtext.g:3360:3: (enumLiteral_4= 'lifeline-segment' )
                    // InternalTmscXtext.g:3361:4: enumLiteral_4= 'lifeline-segment'
                    {
                    enumLiteral_4=(Token)match(input,64,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getXDependencyTypeAccess().getLIFELINE_SEGMENTEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_4, grammarAccess.getXDependencyTypeAccess().getLIFELINE_SEGMENTEnumLiteralDeclaration_4());
                      			
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalTmscXtext.g:3368:3: (enumLiteral_5= 'message-control' )
                    {
                    // InternalTmscXtext.g:3368:3: (enumLiteral_5= 'message-control' )
                    // InternalTmscXtext.g:3369:4: enumLiteral_5= 'message-control'
                    {
                    enumLiteral_5=(Token)match(input,65,FOLLOW_2); if (state.failed) return current;
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


    protected DFA5 dfa5 = new DFA5(this);
    static final String dfa_1s = "\15\uffff";
    static final String dfa_2s = "\1\1\14\uffff";
    static final String dfa_3s = "\1\4\1\uffff\1\16\4\uffff\1\52\5\uffff";
    static final String dfa_4s = "\1\101\1\uffff\1\27\4\uffff\1\53\5\uffff";
    static final String dfa_5s = "\1\uffff\1\12\1\uffff\1\3\1\4\1\5\1\6\1\uffff\1\7\1\10\1\11\1\2\1\1";
    static final String dfa_6s = "\15\uffff}>";
    static final String[] dfa_7s = {
            "\5\12\4\uffff\1\2\16\uffff\1\4\2\uffff\1\5\3\uffff\3\6\3\uffff\1\7\1\10\1\11\2\uffff\2\3\16\uffff\4\3",
            "",
            "\1\14\10\uffff\1\13",
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

    class DFA5 extends DFA {

        public DFA5(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 5;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "()* loopback of 87:3: ( (otherlv_1= 'tmsc' otherlv_2= 'settings' otherlv_3= '{' ( (otherlv_4= 'architecture' otherlv_5= ':' ( (lv_architectureKind_6_0= ruleXArchitectureKind ) ) ) | (otherlv_7= 'time-bound' otherlv_8= ':' ( (lv_timeBound_9_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_10= 'scheduled' otherlv_11= ':' ( (lv_scheduled_12_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_13= 'start-time' otherlv_14= ':' ( ( (lv_startTime_15_1= RULE_ISO8601 | lv_startTime_15_2= RULE_ABS_EBIGDECIMAL ) ) ) ) | (otherlv_16= 'end-time' otherlv_17= ':' ( ( (lv_endTime_18_1= RULE_ISO8601 | lv_endTime_18_2= RULE_ABS_EBIGDECIMAL ) ) ) ) | ( (lv_properties_19_0= ruleXProperty ) ) )* otherlv_20= '}' ) | (otherlv_21= 'tmsc' otherlv_22= 'analyses' otherlv_23= '{' ( (lv_analyses_24_0= ruleXTmscAnalysis ) )* otherlv_25= '}' ) | ( (lv_dependencySettings_26_0= ruleXDependencySettings ) ) | ( (lv_interfaces_27_0= ruleXInterface ) ) | ( (lv_components_28_0= ruleXComponent ) ) | ( (lv_functions_29_0= ruleXFunction ) ) | ( (lv_hosts_30_0= ruleXHost ) ) | ( (lv_executors_31_0= ruleXExecutor ) ) | ( (lv_events_32_0= ruleXEvent ) ) )*";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x00000000007D0140L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x00C0000000000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0030000000000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0xC000CE38900021F2L,0x0000000000000003L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000005400000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000002400000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000008400000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000000290L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x00000000003D0140L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x00000000407D0140L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000500008002L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000600008002L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000200008002L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000014000008002L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0F00000000000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000008200000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000010000008002L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x00000A00007D0140L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0xF000CE38903D21F0L,0x0000000000000003L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000304000008002L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000300000008002L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0xC000C000003D0140L,0x0000000000000003L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000C000003D0140L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x00010000007D0140L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x00320000003D03D0L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0004000200000000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0008000000000002L});

}