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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ABS_EBIGDECIMAL", "RULE_ID", "RULE_ISO8601", "RULE_POS_EBIGDECIMAL", "RULE_STRING", "RULE_NEG_EBIGDECIMAL", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "'tmsc'", "'settings'", "'{'", "'architecture'", "':'", "'time-bound'", "'scheduled'", "'}'", "'interface'", "'as'", "'operation'", "'component'", "'provides'", "','", "'requires'", "'ipc-client'", "'ipc-server'", "'function'", "'('", "')'", "'implements'", "'untraced'", "'host'", "'executor'", "'!'", "'?'", "'request'", "'message'", "'prefix'", "'['", "']'", "'.'", "'true'", "'false'", "'internal'", "'external'", "'in'", "'out'", "'inout'", "'return'", "'>'", "'<'", "'reply'", "'domain-dependency'", "'lifeline-segment'", "'message-control'"
    };
    public static final int T__50=50;
    public static final int RULE_NEG_EBIGDECIMAL=9;
    public static final int T__19=19;
    public static final int T__15=15;
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
    // InternalTmscXtext.g:72:1: ruleTmscXtextModel returns [EObject current=null] : ( () ( (otherlv_1= 'tmsc' otherlv_2= 'settings' otherlv_3= '{' ( (otherlv_4= 'architecture' otherlv_5= ':' ( (lv_architectureKind_6_0= ruleXArchitectureKind ) ) ) | (otherlv_7= 'time-bound' otherlv_8= ':' ( (lv_timeBound_9_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_10= 'scheduled' otherlv_11= ':' ( (lv_scheduled_12_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_13_0= ruleXProperty ) ) )* otherlv_14= '}' ) | ( (lv_dependencySettings_15_0= ruleXDependencySettings ) ) | ( (lv_interfaces_16_0= ruleXInterface ) ) | ( (lv_components_17_0= ruleXComponent ) ) | ( (lv_functions_18_0= ruleXFunction ) ) | ( (lv_hosts_19_0= ruleXHost ) ) | ( (lv_executors_20_0= ruleXExecutor ) ) | ( (lv_events_21_0= ruleXEvent ) ) )* ) ;
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
        Enumerator lv_architectureKind_6_0 = null;

        AntlrDatatypeRuleToken lv_scheduled_12_0 = null;

        EObject lv_properties_13_0 = null;

        EObject lv_dependencySettings_15_0 = null;

        EObject lv_interfaces_16_0 = null;

        EObject lv_components_17_0 = null;

        EObject lv_functions_18_0 = null;

        EObject lv_hosts_19_0 = null;

        EObject lv_executors_20_0 = null;

        EObject lv_events_21_0 = null;



        	enterRule();

        try {
            // InternalTmscXtext.g:78:2: ( ( () ( (otherlv_1= 'tmsc' otherlv_2= 'settings' otherlv_3= '{' ( (otherlv_4= 'architecture' otherlv_5= ':' ( (lv_architectureKind_6_0= ruleXArchitectureKind ) ) ) | (otherlv_7= 'time-bound' otherlv_8= ':' ( (lv_timeBound_9_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_10= 'scheduled' otherlv_11= ':' ( (lv_scheduled_12_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_13_0= ruleXProperty ) ) )* otherlv_14= '}' ) | ( (lv_dependencySettings_15_0= ruleXDependencySettings ) ) | ( (lv_interfaces_16_0= ruleXInterface ) ) | ( (lv_components_17_0= ruleXComponent ) ) | ( (lv_functions_18_0= ruleXFunction ) ) | ( (lv_hosts_19_0= ruleXHost ) ) | ( (lv_executors_20_0= ruleXExecutor ) ) | ( (lv_events_21_0= ruleXEvent ) ) )* ) )
            // InternalTmscXtext.g:79:2: ( () ( (otherlv_1= 'tmsc' otherlv_2= 'settings' otherlv_3= '{' ( (otherlv_4= 'architecture' otherlv_5= ':' ( (lv_architectureKind_6_0= ruleXArchitectureKind ) ) ) | (otherlv_7= 'time-bound' otherlv_8= ':' ( (lv_timeBound_9_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_10= 'scheduled' otherlv_11= ':' ( (lv_scheduled_12_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_13_0= ruleXProperty ) ) )* otherlv_14= '}' ) | ( (lv_dependencySettings_15_0= ruleXDependencySettings ) ) | ( (lv_interfaces_16_0= ruleXInterface ) ) | ( (lv_components_17_0= ruleXComponent ) ) | ( (lv_functions_18_0= ruleXFunction ) ) | ( (lv_hosts_19_0= ruleXHost ) ) | ( (lv_executors_20_0= ruleXExecutor ) ) | ( (lv_events_21_0= ruleXEvent ) ) )* )
            {
            // InternalTmscXtext.g:79:2: ( () ( (otherlv_1= 'tmsc' otherlv_2= 'settings' otherlv_3= '{' ( (otherlv_4= 'architecture' otherlv_5= ':' ( (lv_architectureKind_6_0= ruleXArchitectureKind ) ) ) | (otherlv_7= 'time-bound' otherlv_8= ':' ( (lv_timeBound_9_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_10= 'scheduled' otherlv_11= ':' ( (lv_scheduled_12_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_13_0= ruleXProperty ) ) )* otherlv_14= '}' ) | ( (lv_dependencySettings_15_0= ruleXDependencySettings ) ) | ( (lv_interfaces_16_0= ruleXInterface ) ) | ( (lv_components_17_0= ruleXComponent ) ) | ( (lv_functions_18_0= ruleXFunction ) ) | ( (lv_hosts_19_0= ruleXHost ) ) | ( (lv_executors_20_0= ruleXExecutor ) ) | ( (lv_events_21_0= ruleXEvent ) ) )* )
            // InternalTmscXtext.g:80:3: () ( (otherlv_1= 'tmsc' otherlv_2= 'settings' otherlv_3= '{' ( (otherlv_4= 'architecture' otherlv_5= ':' ( (lv_architectureKind_6_0= ruleXArchitectureKind ) ) ) | (otherlv_7= 'time-bound' otherlv_8= ':' ( (lv_timeBound_9_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_10= 'scheduled' otherlv_11= ':' ( (lv_scheduled_12_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_13_0= ruleXProperty ) ) )* otherlv_14= '}' ) | ( (lv_dependencySettings_15_0= ruleXDependencySettings ) ) | ( (lv_interfaces_16_0= ruleXInterface ) ) | ( (lv_components_17_0= ruleXComponent ) ) | ( (lv_functions_18_0= ruleXFunction ) ) | ( (lv_hosts_19_0= ruleXHost ) ) | ( (lv_executors_20_0= ruleXExecutor ) ) | ( (lv_events_21_0= ruleXEvent ) ) )*
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

            // InternalTmscXtext.g:87:3: ( (otherlv_1= 'tmsc' otherlv_2= 'settings' otherlv_3= '{' ( (otherlv_4= 'architecture' otherlv_5= ':' ( (lv_architectureKind_6_0= ruleXArchitectureKind ) ) ) | (otherlv_7= 'time-bound' otherlv_8= ':' ( (lv_timeBound_9_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_10= 'scheduled' otherlv_11= ':' ( (lv_scheduled_12_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_13_0= ruleXProperty ) ) )* otherlv_14= '}' ) | ( (lv_dependencySettings_15_0= ruleXDependencySettings ) ) | ( (lv_interfaces_16_0= ruleXInterface ) ) | ( (lv_components_17_0= ruleXComponent ) ) | ( (lv_functions_18_0= ruleXFunction ) ) | ( (lv_hosts_19_0= ruleXHost ) ) | ( (lv_executors_20_0= ruleXExecutor ) ) | ( (lv_events_21_0= ruleXEvent ) ) )*
            loop2:
            do {
                int alt2=9;
                alt2 = dfa2.predict(input);
                switch (alt2) {
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
            	    // InternalTmscXtext.g:217:4: ( (lv_dependencySettings_15_0= ruleXDependencySettings ) )
            	    {
            	    // InternalTmscXtext.g:217:4: ( (lv_dependencySettings_15_0= ruleXDependencySettings ) )
            	    // InternalTmscXtext.g:218:5: (lv_dependencySettings_15_0= ruleXDependencySettings )
            	    {
            	    // InternalTmscXtext.g:218:5: (lv_dependencySettings_15_0= ruleXDependencySettings )
            	    // InternalTmscXtext.g:219:6: lv_dependencySettings_15_0= ruleXDependencySettings
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getTmscXtextModelAccess().getDependencySettingsXDependencySettingsParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_10);
            	    lv_dependencySettings_15_0=ruleXDependencySettings();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getTmscXtextModelRule());
            	      						}
            	      						add(
            	      							current,
            	      							"dependencySettings",
            	      							lv_dependencySettings_15_0,
            	      							"nl.esi.pps.tmsc.xtext.TmscXtext.XDependencySettings");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalTmscXtext.g:237:4: ( (lv_interfaces_16_0= ruleXInterface ) )
            	    {
            	    // InternalTmscXtext.g:237:4: ( (lv_interfaces_16_0= ruleXInterface ) )
            	    // InternalTmscXtext.g:238:5: (lv_interfaces_16_0= ruleXInterface )
            	    {
            	    // InternalTmscXtext.g:238:5: (lv_interfaces_16_0= ruleXInterface )
            	    // InternalTmscXtext.g:239:6: lv_interfaces_16_0= ruleXInterface
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getTmscXtextModelAccess().getInterfacesXInterfaceParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_10);
            	    lv_interfaces_16_0=ruleXInterface();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getTmscXtextModelRule());
            	      						}
            	      						add(
            	      							current,
            	      							"interfaces",
            	      							lv_interfaces_16_0,
            	      							"nl.esi.pps.tmsc.xtext.TmscXtext.XInterface");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalTmscXtext.g:257:4: ( (lv_components_17_0= ruleXComponent ) )
            	    {
            	    // InternalTmscXtext.g:257:4: ( (lv_components_17_0= ruleXComponent ) )
            	    // InternalTmscXtext.g:258:5: (lv_components_17_0= ruleXComponent )
            	    {
            	    // InternalTmscXtext.g:258:5: (lv_components_17_0= ruleXComponent )
            	    // InternalTmscXtext.g:259:6: lv_components_17_0= ruleXComponent
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getTmscXtextModelAccess().getComponentsXComponentParserRuleCall_1_3_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_10);
            	    lv_components_17_0=ruleXComponent();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getTmscXtextModelRule());
            	      						}
            	      						add(
            	      							current,
            	      							"components",
            	      							lv_components_17_0,
            	      							"nl.esi.pps.tmsc.xtext.TmscXtext.XComponent");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // InternalTmscXtext.g:277:4: ( (lv_functions_18_0= ruleXFunction ) )
            	    {
            	    // InternalTmscXtext.g:277:4: ( (lv_functions_18_0= ruleXFunction ) )
            	    // InternalTmscXtext.g:278:5: (lv_functions_18_0= ruleXFunction )
            	    {
            	    // InternalTmscXtext.g:278:5: (lv_functions_18_0= ruleXFunction )
            	    // InternalTmscXtext.g:279:6: lv_functions_18_0= ruleXFunction
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getTmscXtextModelAccess().getFunctionsXFunctionParserRuleCall_1_4_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_10);
            	    lv_functions_18_0=ruleXFunction();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getTmscXtextModelRule());
            	      						}
            	      						add(
            	      							current,
            	      							"functions",
            	      							lv_functions_18_0,
            	      							"nl.esi.pps.tmsc.xtext.TmscXtext.XFunction");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 6 :
            	    // InternalTmscXtext.g:297:4: ( (lv_hosts_19_0= ruleXHost ) )
            	    {
            	    // InternalTmscXtext.g:297:4: ( (lv_hosts_19_0= ruleXHost ) )
            	    // InternalTmscXtext.g:298:5: (lv_hosts_19_0= ruleXHost )
            	    {
            	    // InternalTmscXtext.g:298:5: (lv_hosts_19_0= ruleXHost )
            	    // InternalTmscXtext.g:299:6: lv_hosts_19_0= ruleXHost
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getTmscXtextModelAccess().getHostsXHostParserRuleCall_1_5_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_10);
            	    lv_hosts_19_0=ruleXHost();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getTmscXtextModelRule());
            	      						}
            	      						add(
            	      							current,
            	      							"hosts",
            	      							lv_hosts_19_0,
            	      							"nl.esi.pps.tmsc.xtext.TmscXtext.XHost");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 7 :
            	    // InternalTmscXtext.g:317:4: ( (lv_executors_20_0= ruleXExecutor ) )
            	    {
            	    // InternalTmscXtext.g:317:4: ( (lv_executors_20_0= ruleXExecutor ) )
            	    // InternalTmscXtext.g:318:5: (lv_executors_20_0= ruleXExecutor )
            	    {
            	    // InternalTmscXtext.g:318:5: (lv_executors_20_0= ruleXExecutor )
            	    // InternalTmscXtext.g:319:6: lv_executors_20_0= ruleXExecutor
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getTmscXtextModelAccess().getExecutorsXExecutorParserRuleCall_1_6_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_10);
            	    lv_executors_20_0=ruleXExecutor();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getTmscXtextModelRule());
            	      						}
            	      						add(
            	      							current,
            	      							"executors",
            	      							lv_executors_20_0,
            	      							"nl.esi.pps.tmsc.xtext.TmscXtext.XExecutor");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 8 :
            	    // InternalTmscXtext.g:337:4: ( (lv_events_21_0= ruleXEvent ) )
            	    {
            	    // InternalTmscXtext.g:337:4: ( (lv_events_21_0= ruleXEvent ) )
            	    // InternalTmscXtext.g:338:5: (lv_events_21_0= ruleXEvent )
            	    {
            	    // InternalTmscXtext.g:338:5: (lv_events_21_0= ruleXEvent )
            	    // InternalTmscXtext.g:339:6: lv_events_21_0= ruleXEvent
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getTmscXtextModelAccess().getEventsXEventParserRuleCall_1_7_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_10);
            	    lv_events_21_0=ruleXEvent();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getTmscXtextModelRule());
            	      						}
            	      						add(
            	      							current,
            	      							"events",
            	      							lv_events_21_0,
            	      							"nl.esi.pps.tmsc.xtext.TmscXtext.XEvent");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
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


    // $ANTLR start "entryRuleXInterface"
    // InternalTmscXtext.g:361:1: entryRuleXInterface returns [EObject current=null] : iv_ruleXInterface= ruleXInterface EOF ;
    public final EObject entryRuleXInterface() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXInterface = null;


        try {
            // InternalTmscXtext.g:361:51: (iv_ruleXInterface= ruleXInterface EOF )
            // InternalTmscXtext.g:362:2: iv_ruleXInterface= ruleXInterface EOF
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
    // InternalTmscXtext.g:368:1: ruleXInterface returns [EObject current=null] : (otherlv_0= 'interface' ( ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as' )? ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '{' ( ( (lv_properties_5_0= ruleXProperty ) ) | ( (lv_operations_6_0= ruleXOperation ) ) )* otherlv_7= '}' )? ) ;
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
            // InternalTmscXtext.g:374:2: ( (otherlv_0= 'interface' ( ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as' )? ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '{' ( ( (lv_properties_5_0= ruleXProperty ) ) | ( (lv_operations_6_0= ruleXOperation ) ) )* otherlv_7= '}' )? ) )
            // InternalTmscXtext.g:375:2: (otherlv_0= 'interface' ( ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as' )? ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '{' ( ( (lv_properties_5_0= ruleXProperty ) ) | ( (lv_operations_6_0= ruleXOperation ) ) )* otherlv_7= '}' )? )
            {
            // InternalTmscXtext.g:375:2: (otherlv_0= 'interface' ( ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as' )? ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '{' ( ( (lv_properties_5_0= ruleXProperty ) ) | ( (lv_operations_6_0= ruleXOperation ) ) )* otherlv_7= '}' )? )
            // InternalTmscXtext.g:376:3: otherlv_0= 'interface' ( ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as' )? ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '{' ( ( (lv_properties_5_0= ruleXProperty ) ) | ( (lv_operations_6_0= ruleXOperation ) ) )* otherlv_7= '}' )?
            {
            otherlv_0=(Token)match(input,21,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getXInterfaceAccess().getInterfaceKeyword_0());
              		
            }
            // InternalTmscXtext.g:380:3: ( ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_ID) ) {
                int LA3_1 = input.LA(2);

                if ( (LA3_1==22) ) {
                    alt3=1;
                }
            }
            else if ( (LA3_0==RULE_STRING) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalTmscXtext.g:381:4: ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as'
                    {
                    // InternalTmscXtext.g:381:4: ( (lv_description_1_0= ruleIDString ) )
                    // InternalTmscXtext.g:382:5: (lv_description_1_0= ruleIDString )
                    {
                    // InternalTmscXtext.g:382:5: (lv_description_1_0= ruleIDString )
                    // InternalTmscXtext.g:383:6: lv_description_1_0= ruleIDString
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getXInterfaceAccess().getDescriptionIDStringParserRuleCall_1_0_0());
                      					
                    }
                    pushFollow(FOLLOW_12);
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

                    otherlv_2=(Token)match(input,22,FOLLOW_13); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getXInterfaceAccess().getAsKeyword_1_1());
                      			
                    }

                    }
                    break;

            }

            // InternalTmscXtext.g:405:3: ( (lv_name_3_0= RULE_ID ) )
            // InternalTmscXtext.g:406:4: (lv_name_3_0= RULE_ID )
            {
            // InternalTmscXtext.g:406:4: (lv_name_3_0= RULE_ID )
            // InternalTmscXtext.g:407:5: lv_name_3_0= RULE_ID
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

            // InternalTmscXtext.g:423:3: (otherlv_4= '{' ( ( (lv_properties_5_0= ruleXProperty ) ) | ( (lv_operations_6_0= ruleXOperation ) ) )* otherlv_7= '}' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==15) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalTmscXtext.g:424:4: otherlv_4= '{' ( ( (lv_properties_5_0= ruleXProperty ) ) | ( (lv_operations_6_0= ruleXOperation ) ) )* otherlv_7= '}'
                    {
                    otherlv_4=(Token)match(input,15,FOLLOW_15); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getXInterfaceAccess().getLeftCurlyBracketKeyword_3_0());
                      			
                    }
                    // InternalTmscXtext.g:428:4: ( ( (lv_properties_5_0= ruleXProperty ) ) | ( (lv_operations_6_0= ruleXOperation ) ) )*
                    loop4:
                    do {
                        int alt4=3;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==RULE_ID||LA4_0==RULE_STRING) ) {
                            alt4=1;
                        }
                        else if ( (LA4_0==23) ) {
                            alt4=2;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // InternalTmscXtext.g:429:5: ( (lv_properties_5_0= ruleXProperty ) )
                    	    {
                    	    // InternalTmscXtext.g:429:5: ( (lv_properties_5_0= ruleXProperty ) )
                    	    // InternalTmscXtext.g:430:6: (lv_properties_5_0= ruleXProperty )
                    	    {
                    	    // InternalTmscXtext.g:430:6: (lv_properties_5_0= ruleXProperty )
                    	    // InternalTmscXtext.g:431:7: lv_properties_5_0= ruleXProperty
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getXInterfaceAccess().getPropertiesXPropertyParserRuleCall_3_1_0_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_15);
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
                    	    // InternalTmscXtext.g:449:5: ( (lv_operations_6_0= ruleXOperation ) )
                    	    {
                    	    // InternalTmscXtext.g:449:5: ( (lv_operations_6_0= ruleXOperation ) )
                    	    // InternalTmscXtext.g:450:6: (lv_operations_6_0= ruleXOperation )
                    	    {
                    	    // InternalTmscXtext.g:450:6: (lv_operations_6_0= ruleXOperation )
                    	    // InternalTmscXtext.g:451:7: lv_operations_6_0= ruleXOperation
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getXInterfaceAccess().getOperationsXOperationParserRuleCall_3_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_15);
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
                    	    break loop4;
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
    // InternalTmscXtext.g:478:1: entryRuleXOperation returns [EObject current=null] : iv_ruleXOperation= ruleXOperation EOF ;
    public final EObject entryRuleXOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXOperation = null;


        try {
            // InternalTmscXtext.g:478:51: (iv_ruleXOperation= ruleXOperation EOF )
            // InternalTmscXtext.g:479:2: iv_ruleXOperation= ruleXOperation EOF
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
    // InternalTmscXtext.g:485:1: ruleXOperation returns [EObject current=null] : (otherlv_0= 'operation' ( ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as' )? ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '{' ( (lv_properties_5_0= ruleXProperty ) )* otherlv_6= '}' )? ) ;
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
            // InternalTmscXtext.g:491:2: ( (otherlv_0= 'operation' ( ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as' )? ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '{' ( (lv_properties_5_0= ruleXProperty ) )* otherlv_6= '}' )? ) )
            // InternalTmscXtext.g:492:2: (otherlv_0= 'operation' ( ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as' )? ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '{' ( (lv_properties_5_0= ruleXProperty ) )* otherlv_6= '}' )? )
            {
            // InternalTmscXtext.g:492:2: (otherlv_0= 'operation' ( ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as' )? ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '{' ( (lv_properties_5_0= ruleXProperty ) )* otherlv_6= '}' )? )
            // InternalTmscXtext.g:493:3: otherlv_0= 'operation' ( ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as' )? ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '{' ( (lv_properties_5_0= ruleXProperty ) )* otherlv_6= '}' )?
            {
            otherlv_0=(Token)match(input,23,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getXOperationAccess().getOperationKeyword_0());
              		
            }
            // InternalTmscXtext.g:497:3: ( ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_ID) ) {
                int LA6_1 = input.LA(2);

                if ( (LA6_1==22) ) {
                    alt6=1;
                }
            }
            else if ( (LA6_0==RULE_STRING) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalTmscXtext.g:498:4: ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as'
                    {
                    // InternalTmscXtext.g:498:4: ( (lv_description_1_0= ruleIDString ) )
                    // InternalTmscXtext.g:499:5: (lv_description_1_0= ruleIDString )
                    {
                    // InternalTmscXtext.g:499:5: (lv_description_1_0= ruleIDString )
                    // InternalTmscXtext.g:500:6: lv_description_1_0= ruleIDString
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getXOperationAccess().getDescriptionIDStringParserRuleCall_1_0_0());
                      					
                    }
                    pushFollow(FOLLOW_12);
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

                    otherlv_2=(Token)match(input,22,FOLLOW_13); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getXOperationAccess().getAsKeyword_1_1());
                      			
                    }

                    }
                    break;

            }

            // InternalTmscXtext.g:522:3: ( (lv_name_3_0= RULE_ID ) )
            // InternalTmscXtext.g:523:4: (lv_name_3_0= RULE_ID )
            {
            // InternalTmscXtext.g:523:4: (lv_name_3_0= RULE_ID )
            // InternalTmscXtext.g:524:5: lv_name_3_0= RULE_ID
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

            // InternalTmscXtext.g:540:3: (otherlv_4= '{' ( (lv_properties_5_0= ruleXProperty ) )* otherlv_6= '}' )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==15) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalTmscXtext.g:541:4: otherlv_4= '{' ( (lv_properties_5_0= ruleXProperty ) )* otherlv_6= '}'
                    {
                    otherlv_4=(Token)match(input,15,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getXOperationAccess().getLeftCurlyBracketKeyword_3_0());
                      			
                    }
                    // InternalTmscXtext.g:545:4: ( (lv_properties_5_0= ruleXProperty ) )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==RULE_ID||LA7_0==RULE_STRING) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // InternalTmscXtext.g:546:5: (lv_properties_5_0= ruleXProperty )
                    	    {
                    	    // InternalTmscXtext.g:546:5: (lv_properties_5_0= ruleXProperty )
                    	    // InternalTmscXtext.g:547:6: lv_properties_5_0= ruleXProperty
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
                    	    break loop7;
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
    // InternalTmscXtext.g:573:1: entryRuleXComponent returns [EObject current=null] : iv_ruleXComponent= ruleXComponent EOF ;
    public final EObject entryRuleXComponent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXComponent = null;


        try {
            // InternalTmscXtext.g:573:51: (iv_ruleXComponent= ruleXComponent EOF )
            // InternalTmscXtext.g:574:2: iv_ruleXComponent= ruleXComponent EOF
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
    // InternalTmscXtext.g:580:1: ruleXComponent returns [EObject current=null] : (otherlv_0= 'component' ( ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as' )? ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= 'provides' ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )? (otherlv_8= 'requires' ( (otherlv_9= RULE_ID ) ) (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )* )? (otherlv_12= '{' ( (otherlv_13= 'time-bound' otherlv_14= ':' ( (lv_timeBound_15_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_16= 'scheduled' otherlv_17= ':' ( (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_19_0= ruleXProperty ) ) )* otherlv_20= '}' )? ) ;
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
            // InternalTmscXtext.g:586:2: ( (otherlv_0= 'component' ( ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as' )? ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= 'provides' ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )? (otherlv_8= 'requires' ( (otherlv_9= RULE_ID ) ) (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )* )? (otherlv_12= '{' ( (otherlv_13= 'time-bound' otherlv_14= ':' ( (lv_timeBound_15_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_16= 'scheduled' otherlv_17= ':' ( (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_19_0= ruleXProperty ) ) )* otherlv_20= '}' )? ) )
            // InternalTmscXtext.g:587:2: (otherlv_0= 'component' ( ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as' )? ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= 'provides' ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )? (otherlv_8= 'requires' ( (otherlv_9= RULE_ID ) ) (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )* )? (otherlv_12= '{' ( (otherlv_13= 'time-bound' otherlv_14= ':' ( (lv_timeBound_15_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_16= 'scheduled' otherlv_17= ':' ( (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_19_0= ruleXProperty ) ) )* otherlv_20= '}' )? )
            {
            // InternalTmscXtext.g:587:2: (otherlv_0= 'component' ( ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as' )? ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= 'provides' ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )? (otherlv_8= 'requires' ( (otherlv_9= RULE_ID ) ) (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )* )? (otherlv_12= '{' ( (otherlv_13= 'time-bound' otherlv_14= ':' ( (lv_timeBound_15_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_16= 'scheduled' otherlv_17= ':' ( (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_19_0= ruleXProperty ) ) )* otherlv_20= '}' )? )
            // InternalTmscXtext.g:588:3: otherlv_0= 'component' ( ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as' )? ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= 'provides' ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )? (otherlv_8= 'requires' ( (otherlv_9= RULE_ID ) ) (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )* )? (otherlv_12= '{' ( (otherlv_13= 'time-bound' otherlv_14= ':' ( (lv_timeBound_15_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_16= 'scheduled' otherlv_17= ':' ( (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_19_0= ruleXProperty ) ) )* otherlv_20= '}' )?
            {
            otherlv_0=(Token)match(input,24,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getXComponentAccess().getComponentKeyword_0());
              		
            }
            // InternalTmscXtext.g:592:3: ( ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_ID) ) {
                int LA9_1 = input.LA(2);

                if ( (LA9_1==22) ) {
                    alt9=1;
                }
            }
            else if ( (LA9_0==RULE_STRING) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalTmscXtext.g:593:4: ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as'
                    {
                    // InternalTmscXtext.g:593:4: ( (lv_description_1_0= ruleIDString ) )
                    // InternalTmscXtext.g:594:5: (lv_description_1_0= ruleIDString )
                    {
                    // InternalTmscXtext.g:594:5: (lv_description_1_0= ruleIDString )
                    // InternalTmscXtext.g:595:6: lv_description_1_0= ruleIDString
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getXComponentAccess().getDescriptionIDStringParserRuleCall_1_0_0());
                      					
                    }
                    pushFollow(FOLLOW_12);
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

                    otherlv_2=(Token)match(input,22,FOLLOW_13); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getXComponentAccess().getAsKeyword_1_1());
                      			
                    }

                    }
                    break;

            }

            // InternalTmscXtext.g:617:3: ( (lv_name_3_0= RULE_ID ) )
            // InternalTmscXtext.g:618:4: (lv_name_3_0= RULE_ID )
            {
            // InternalTmscXtext.g:618:4: (lv_name_3_0= RULE_ID )
            // InternalTmscXtext.g:619:5: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_16); if (state.failed) return current;
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

            // InternalTmscXtext.g:635:3: (otherlv_4= 'provides' ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==25) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalTmscXtext.g:636:4: otherlv_4= 'provides' ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )*
                    {
                    otherlv_4=(Token)match(input,25,FOLLOW_13); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getXComponentAccess().getProvidesKeyword_3_0());
                      			
                    }
                    // InternalTmscXtext.g:640:4: ( (otherlv_5= RULE_ID ) )
                    // InternalTmscXtext.g:641:5: (otherlv_5= RULE_ID )
                    {
                    // InternalTmscXtext.g:641:5: (otherlv_5= RULE_ID )
                    // InternalTmscXtext.g:642:6: otherlv_5= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getXComponentRule());
                      						}
                      					
                    }
                    otherlv_5=(Token)match(input,RULE_ID,FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_5, grammarAccess.getXComponentAccess().getProvidesXInterfaceCrossReference_3_1_0());
                      					
                    }

                    }


                    }

                    // InternalTmscXtext.g:653:4: (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==26) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // InternalTmscXtext.g:654:5: otherlv_6= ',' ( (otherlv_7= RULE_ID ) )
                    	    {
                    	    otherlv_6=(Token)match(input,26,FOLLOW_13); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_6, grammarAccess.getXComponentAccess().getCommaKeyword_3_2_0());
                    	      				
                    	    }
                    	    // InternalTmscXtext.g:658:5: ( (otherlv_7= RULE_ID ) )
                    	    // InternalTmscXtext.g:659:6: (otherlv_7= RULE_ID )
                    	    {
                    	    // InternalTmscXtext.g:659:6: (otherlv_7= RULE_ID )
                    	    // InternalTmscXtext.g:660:7: otherlv_7= RULE_ID
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElement(grammarAccess.getXComponentRule());
                    	      							}
                    	      						
                    	    }
                    	    otherlv_7=(Token)match(input,RULE_ID,FOLLOW_17); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							newLeafNode(otherlv_7, grammarAccess.getXComponentAccess().getProvidesXInterfaceCrossReference_3_2_1_0());
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalTmscXtext.g:673:3: (otherlv_8= 'requires' ( (otherlv_9= RULE_ID ) ) (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )* )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==27) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalTmscXtext.g:674:4: otherlv_8= 'requires' ( (otherlv_9= RULE_ID ) ) (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )*
                    {
                    otherlv_8=(Token)match(input,27,FOLLOW_13); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_8, grammarAccess.getXComponentAccess().getRequiresKeyword_4_0());
                      			
                    }
                    // InternalTmscXtext.g:678:4: ( (otherlv_9= RULE_ID ) )
                    // InternalTmscXtext.g:679:5: (otherlv_9= RULE_ID )
                    {
                    // InternalTmscXtext.g:679:5: (otherlv_9= RULE_ID )
                    // InternalTmscXtext.g:680:6: otherlv_9= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getXComponentRule());
                      						}
                      					
                    }
                    otherlv_9=(Token)match(input,RULE_ID,FOLLOW_18); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_9, grammarAccess.getXComponentAccess().getRequiresXInterfaceCrossReference_4_1_0());
                      					
                    }

                    }


                    }

                    // InternalTmscXtext.g:691:4: (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==26) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // InternalTmscXtext.g:692:5: otherlv_10= ',' ( (otherlv_11= RULE_ID ) )
                    	    {
                    	    otherlv_10=(Token)match(input,26,FOLLOW_13); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_10, grammarAccess.getXComponentAccess().getCommaKeyword_4_2_0());
                    	      				
                    	    }
                    	    // InternalTmscXtext.g:696:5: ( (otherlv_11= RULE_ID ) )
                    	    // InternalTmscXtext.g:697:6: (otherlv_11= RULE_ID )
                    	    {
                    	    // InternalTmscXtext.g:697:6: (otherlv_11= RULE_ID )
                    	    // InternalTmscXtext.g:698:7: otherlv_11= RULE_ID
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElement(grammarAccess.getXComponentRule());
                    	      							}
                    	      						
                    	    }
                    	    otherlv_11=(Token)match(input,RULE_ID,FOLLOW_18); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							newLeafNode(otherlv_11, grammarAccess.getXComponentAccess().getRequiresXInterfaceCrossReference_4_2_1_0());
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalTmscXtext.g:711:3: (otherlv_12= '{' ( (otherlv_13= 'time-bound' otherlv_14= ':' ( (lv_timeBound_15_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_16= 'scheduled' otherlv_17= ':' ( (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_19_0= ruleXProperty ) ) )* otherlv_20= '}' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==15) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalTmscXtext.g:712:4: otherlv_12= '{' ( (otherlv_13= 'time-bound' otherlv_14= ':' ( (lv_timeBound_15_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_16= 'scheduled' otherlv_17= ':' ( (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_19_0= ruleXProperty ) ) )* otherlv_20= '}'
                    {
                    otherlv_12=(Token)match(input,15,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_12, grammarAccess.getXComponentAccess().getLeftCurlyBracketKeyword_5_0());
                      			
                    }
                    // InternalTmscXtext.g:716:4: ( (otherlv_13= 'time-bound' otherlv_14= ':' ( (lv_timeBound_15_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_16= 'scheduled' otherlv_17= ':' ( (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_19_0= ruleXProperty ) ) )*
                    loop14:
                    do {
                        int alt14=4;
                        switch ( input.LA(1) ) {
                        case 18:
                            {
                            alt14=1;
                            }
                            break;
                        case 19:
                            {
                            alt14=2;
                            }
                            break;
                        case RULE_ID:
                        case RULE_STRING:
                            {
                            alt14=3;
                            }
                            break;

                        }

                        switch (alt14) {
                    	case 1 :
                    	    // InternalTmscXtext.g:717:5: (otherlv_13= 'time-bound' otherlv_14= ':' ( (lv_timeBound_15_0= RULE_ABS_EBIGDECIMAL ) ) )
                    	    {
                    	    // InternalTmscXtext.g:717:5: (otherlv_13= 'time-bound' otherlv_14= ':' ( (lv_timeBound_15_0= RULE_ABS_EBIGDECIMAL ) ) )
                    	    // InternalTmscXtext.g:718:6: otherlv_13= 'time-bound' otherlv_14= ':' ( (lv_timeBound_15_0= RULE_ABS_EBIGDECIMAL ) )
                    	    {
                    	    otherlv_13=(Token)match(input,18,FOLLOW_6); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_13, grammarAccess.getXComponentAccess().getTimeBoundKeyword_5_1_0_0());
                    	      					
                    	    }
                    	    otherlv_14=(Token)match(input,17,FOLLOW_8); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_14, grammarAccess.getXComponentAccess().getColonKeyword_5_1_0_1());
                    	      					
                    	    }
                    	    // InternalTmscXtext.g:726:6: ( (lv_timeBound_15_0= RULE_ABS_EBIGDECIMAL ) )
                    	    // InternalTmscXtext.g:727:7: (lv_timeBound_15_0= RULE_ABS_EBIGDECIMAL )
                    	    {
                    	    // InternalTmscXtext.g:727:7: (lv_timeBound_15_0= RULE_ABS_EBIGDECIMAL )
                    	    // InternalTmscXtext.g:728:8: lv_timeBound_15_0= RULE_ABS_EBIGDECIMAL
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
                    	    // InternalTmscXtext.g:746:5: (otherlv_16= 'scheduled' otherlv_17= ':' ( (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT ) ) )
                    	    {
                    	    // InternalTmscXtext.g:746:5: (otherlv_16= 'scheduled' otherlv_17= ':' ( (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT ) ) )
                    	    // InternalTmscXtext.g:747:6: otherlv_16= 'scheduled' otherlv_17= ':' ( (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT ) )
                    	    {
                    	    otherlv_16=(Token)match(input,19,FOLLOW_6); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_16, grammarAccess.getXComponentAccess().getScheduledKeyword_5_1_1_0());
                    	      					
                    	    }
                    	    otherlv_17=(Token)match(input,17,FOLLOW_9); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_17, grammarAccess.getXComponentAccess().getColonKeyword_5_1_1_1());
                    	      					
                    	    }
                    	    // InternalTmscXtext.g:755:6: ( (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT ) )
                    	    // InternalTmscXtext.g:756:7: (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT )
                    	    {
                    	    // InternalTmscXtext.g:756:7: (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT )
                    	    // InternalTmscXtext.g:757:8: lv_scheduled_18_0= ruleEBOOLEAN_OBJECT
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
                    	    // InternalTmscXtext.g:776:5: ( (lv_properties_19_0= ruleXProperty ) )
                    	    {
                    	    // InternalTmscXtext.g:776:5: ( (lv_properties_19_0= ruleXProperty ) )
                    	    // InternalTmscXtext.g:777:6: (lv_properties_19_0= ruleXProperty )
                    	    {
                    	    // InternalTmscXtext.g:777:6: (lv_properties_19_0= ruleXProperty )
                    	    // InternalTmscXtext.g:778:7: lv_properties_19_0= ruleXProperty
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
                    	    break loop14;
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
    // InternalTmscXtext.g:805:1: entryRuleXFunction returns [EObject current=null] : iv_ruleXFunction= ruleXFunction EOF ;
    public final EObject entryRuleXFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXFunction = null;


        try {
            // InternalTmscXtext.g:805:50: (iv_ruleXFunction= ruleXFunction EOF )
            // InternalTmscXtext.g:806:2: iv_ruleXFunction= ruleXFunction EOF
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
    // InternalTmscXtext.g:812:1: ruleXFunction returns [EObject current=null] : ( ( ( (lv_ipcClient_0_0= 'ipc-client' ) ) | ( (lv_ipcServer_1_0= 'ipc-server' ) ) )? otherlv_2= 'function' ( ( (lv_description_3_0= ruleIDString ) ) otherlv_4= 'as' )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '(' ( (lv_parameters_7_0= ruleXFunctionParameter ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleXFunctionParameter ) ) )* otherlv_10= ')' )? (otherlv_11= 'implements' ( ( ruleFQN ) ) )? (otherlv_13= '{' ( (otherlv_14= 'time-bound' otherlv_15= ':' ( (lv_timeBound_16_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_17= 'scheduled' otherlv_18= ':' ( (lv_scheduled_19_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_20_0= ruleXProperty ) ) )* otherlv_21= '}' )? ) ;
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
            // InternalTmscXtext.g:818:2: ( ( ( ( (lv_ipcClient_0_0= 'ipc-client' ) ) | ( (lv_ipcServer_1_0= 'ipc-server' ) ) )? otherlv_2= 'function' ( ( (lv_description_3_0= ruleIDString ) ) otherlv_4= 'as' )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '(' ( (lv_parameters_7_0= ruleXFunctionParameter ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleXFunctionParameter ) ) )* otherlv_10= ')' )? (otherlv_11= 'implements' ( ( ruleFQN ) ) )? (otherlv_13= '{' ( (otherlv_14= 'time-bound' otherlv_15= ':' ( (lv_timeBound_16_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_17= 'scheduled' otherlv_18= ':' ( (lv_scheduled_19_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_20_0= ruleXProperty ) ) )* otherlv_21= '}' )? ) )
            // InternalTmscXtext.g:819:2: ( ( ( (lv_ipcClient_0_0= 'ipc-client' ) ) | ( (lv_ipcServer_1_0= 'ipc-server' ) ) )? otherlv_2= 'function' ( ( (lv_description_3_0= ruleIDString ) ) otherlv_4= 'as' )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '(' ( (lv_parameters_7_0= ruleXFunctionParameter ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleXFunctionParameter ) ) )* otherlv_10= ')' )? (otherlv_11= 'implements' ( ( ruleFQN ) ) )? (otherlv_13= '{' ( (otherlv_14= 'time-bound' otherlv_15= ':' ( (lv_timeBound_16_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_17= 'scheduled' otherlv_18= ':' ( (lv_scheduled_19_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_20_0= ruleXProperty ) ) )* otherlv_21= '}' )? )
            {
            // InternalTmscXtext.g:819:2: ( ( ( (lv_ipcClient_0_0= 'ipc-client' ) ) | ( (lv_ipcServer_1_0= 'ipc-server' ) ) )? otherlv_2= 'function' ( ( (lv_description_3_0= ruleIDString ) ) otherlv_4= 'as' )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '(' ( (lv_parameters_7_0= ruleXFunctionParameter ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleXFunctionParameter ) ) )* otherlv_10= ')' )? (otherlv_11= 'implements' ( ( ruleFQN ) ) )? (otherlv_13= '{' ( (otherlv_14= 'time-bound' otherlv_15= ':' ( (lv_timeBound_16_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_17= 'scheduled' otherlv_18= ':' ( (lv_scheduled_19_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_20_0= ruleXProperty ) ) )* otherlv_21= '}' )? )
            // InternalTmscXtext.g:820:3: ( ( (lv_ipcClient_0_0= 'ipc-client' ) ) | ( (lv_ipcServer_1_0= 'ipc-server' ) ) )? otherlv_2= 'function' ( ( (lv_description_3_0= ruleIDString ) ) otherlv_4= 'as' )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '(' ( (lv_parameters_7_0= ruleXFunctionParameter ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleXFunctionParameter ) ) )* otherlv_10= ')' )? (otherlv_11= 'implements' ( ( ruleFQN ) ) )? (otherlv_13= '{' ( (otherlv_14= 'time-bound' otherlv_15= ':' ( (lv_timeBound_16_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_17= 'scheduled' otherlv_18= ':' ( (lv_scheduled_19_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_20_0= ruleXProperty ) ) )* otherlv_21= '}' )?
            {
            // InternalTmscXtext.g:820:3: ( ( (lv_ipcClient_0_0= 'ipc-client' ) ) | ( (lv_ipcServer_1_0= 'ipc-server' ) ) )?
            int alt16=3;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==28) ) {
                alt16=1;
            }
            else if ( (LA16_0==29) ) {
                alt16=2;
            }
            switch (alt16) {
                case 1 :
                    // InternalTmscXtext.g:821:4: ( (lv_ipcClient_0_0= 'ipc-client' ) )
                    {
                    // InternalTmscXtext.g:821:4: ( (lv_ipcClient_0_0= 'ipc-client' ) )
                    // InternalTmscXtext.g:822:5: (lv_ipcClient_0_0= 'ipc-client' )
                    {
                    // InternalTmscXtext.g:822:5: (lv_ipcClient_0_0= 'ipc-client' )
                    // InternalTmscXtext.g:823:6: lv_ipcClient_0_0= 'ipc-client'
                    {
                    lv_ipcClient_0_0=(Token)match(input,28,FOLLOW_19); if (state.failed) return current;
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
                    // InternalTmscXtext.g:836:4: ( (lv_ipcServer_1_0= 'ipc-server' ) )
                    {
                    // InternalTmscXtext.g:836:4: ( (lv_ipcServer_1_0= 'ipc-server' ) )
                    // InternalTmscXtext.g:837:5: (lv_ipcServer_1_0= 'ipc-server' )
                    {
                    // InternalTmscXtext.g:837:5: (lv_ipcServer_1_0= 'ipc-server' )
                    // InternalTmscXtext.g:838:6: lv_ipcServer_1_0= 'ipc-server'
                    {
                    lv_ipcServer_1_0=(Token)match(input,29,FOLLOW_19); if (state.failed) return current;
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

            otherlv_2=(Token)match(input,30,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getXFunctionAccess().getFunctionKeyword_1());
              		
            }
            // InternalTmscXtext.g:855:3: ( ( (lv_description_3_0= ruleIDString ) ) otherlv_4= 'as' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_ID) ) {
                int LA17_1 = input.LA(2);

                if ( (LA17_1==22) ) {
                    alt17=1;
                }
            }
            else if ( (LA17_0==RULE_STRING) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalTmscXtext.g:856:4: ( (lv_description_3_0= ruleIDString ) ) otherlv_4= 'as'
                    {
                    // InternalTmscXtext.g:856:4: ( (lv_description_3_0= ruleIDString ) )
                    // InternalTmscXtext.g:857:5: (lv_description_3_0= ruleIDString )
                    {
                    // InternalTmscXtext.g:857:5: (lv_description_3_0= ruleIDString )
                    // InternalTmscXtext.g:858:6: lv_description_3_0= ruleIDString
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getXFunctionAccess().getDescriptionIDStringParserRuleCall_2_0_0());
                      					
                    }
                    pushFollow(FOLLOW_12);
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

                    otherlv_4=(Token)match(input,22,FOLLOW_13); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getXFunctionAccess().getAsKeyword_2_1());
                      			
                    }

                    }
                    break;

            }

            // InternalTmscXtext.g:880:3: ( (lv_name_5_0= RULE_ID ) )
            // InternalTmscXtext.g:881:4: (lv_name_5_0= RULE_ID )
            {
            // InternalTmscXtext.g:881:4: (lv_name_5_0= RULE_ID )
            // InternalTmscXtext.g:882:5: lv_name_5_0= RULE_ID
            {
            lv_name_5_0=(Token)match(input,RULE_ID,FOLLOW_20); if (state.failed) return current;
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

            // InternalTmscXtext.g:898:3: (otherlv_6= '(' ( (lv_parameters_7_0= ruleXFunctionParameter ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleXFunctionParameter ) ) )* otherlv_10= ')' )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==31) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalTmscXtext.g:899:4: otherlv_6= '(' ( (lv_parameters_7_0= ruleXFunctionParameter ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleXFunctionParameter ) ) )* otherlv_10= ')'
                    {
                    otherlv_6=(Token)match(input,31,FOLLOW_21); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_6, grammarAccess.getXFunctionAccess().getLeftParenthesisKeyword_4_0());
                      			
                    }
                    // InternalTmscXtext.g:903:4: ( (lv_parameters_7_0= ruleXFunctionParameter ) )
                    // InternalTmscXtext.g:904:5: (lv_parameters_7_0= ruleXFunctionParameter )
                    {
                    // InternalTmscXtext.g:904:5: (lv_parameters_7_0= ruleXFunctionParameter )
                    // InternalTmscXtext.g:905:6: lv_parameters_7_0= ruleXFunctionParameter
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getXFunctionAccess().getParametersXFunctionParameterParserRuleCall_4_1_0());
                      					
                    }
                    pushFollow(FOLLOW_22);
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

                    // InternalTmscXtext.g:922:4: (otherlv_8= ',' ( (lv_parameters_9_0= ruleXFunctionParameter ) ) )*
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0==26) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // InternalTmscXtext.g:923:5: otherlv_8= ',' ( (lv_parameters_9_0= ruleXFunctionParameter ) )
                    	    {
                    	    otherlv_8=(Token)match(input,26,FOLLOW_21); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_8, grammarAccess.getXFunctionAccess().getCommaKeyword_4_2_0());
                    	      				
                    	    }
                    	    // InternalTmscXtext.g:927:5: ( (lv_parameters_9_0= ruleXFunctionParameter ) )
                    	    // InternalTmscXtext.g:928:6: (lv_parameters_9_0= ruleXFunctionParameter )
                    	    {
                    	    // InternalTmscXtext.g:928:6: (lv_parameters_9_0= ruleXFunctionParameter )
                    	    // InternalTmscXtext.g:929:7: lv_parameters_9_0= ruleXFunctionParameter
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getXFunctionAccess().getParametersXFunctionParameterParserRuleCall_4_2_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_22);
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
                    	    break loop18;
                        }
                    } while (true);

                    otherlv_10=(Token)match(input,32,FOLLOW_23); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_10, grammarAccess.getXFunctionAccess().getRightParenthesisKeyword_4_3());
                      			
                    }

                    }
                    break;

            }

            // InternalTmscXtext.g:952:3: (otherlv_11= 'implements' ( ( ruleFQN ) ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==33) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalTmscXtext.g:953:4: otherlv_11= 'implements' ( ( ruleFQN ) )
                    {
                    otherlv_11=(Token)match(input,33,FOLLOW_13); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_11, grammarAccess.getXFunctionAccess().getImplementsKeyword_5_0());
                      			
                    }
                    // InternalTmscXtext.g:957:4: ( ( ruleFQN ) )
                    // InternalTmscXtext.g:958:5: ( ruleFQN )
                    {
                    // InternalTmscXtext.g:958:5: ( ruleFQN )
                    // InternalTmscXtext.g:959:6: ruleFQN
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

            // InternalTmscXtext.g:974:3: (otherlv_13= '{' ( (otherlv_14= 'time-bound' otherlv_15= ':' ( (lv_timeBound_16_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_17= 'scheduled' otherlv_18= ':' ( (lv_scheduled_19_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_20_0= ruleXProperty ) ) )* otherlv_21= '}' )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==15) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalTmscXtext.g:975:4: otherlv_13= '{' ( (otherlv_14= 'time-bound' otherlv_15= ':' ( (lv_timeBound_16_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_17= 'scheduled' otherlv_18= ':' ( (lv_scheduled_19_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_20_0= ruleXProperty ) ) )* otherlv_21= '}'
                    {
                    otherlv_13=(Token)match(input,15,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_13, grammarAccess.getXFunctionAccess().getLeftCurlyBracketKeyword_6_0());
                      			
                    }
                    // InternalTmscXtext.g:979:4: ( (otherlv_14= 'time-bound' otherlv_15= ':' ( (lv_timeBound_16_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_17= 'scheduled' otherlv_18= ':' ( (lv_scheduled_19_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_20_0= ruleXProperty ) ) )*
                    loop21:
                    do {
                        int alt21=4;
                        switch ( input.LA(1) ) {
                        case 18:
                            {
                            alt21=1;
                            }
                            break;
                        case 19:
                            {
                            alt21=2;
                            }
                            break;
                        case RULE_ID:
                        case RULE_STRING:
                            {
                            alt21=3;
                            }
                            break;

                        }

                        switch (alt21) {
                    	case 1 :
                    	    // InternalTmscXtext.g:980:5: (otherlv_14= 'time-bound' otherlv_15= ':' ( (lv_timeBound_16_0= RULE_ABS_EBIGDECIMAL ) ) )
                    	    {
                    	    // InternalTmscXtext.g:980:5: (otherlv_14= 'time-bound' otherlv_15= ':' ( (lv_timeBound_16_0= RULE_ABS_EBIGDECIMAL ) ) )
                    	    // InternalTmscXtext.g:981:6: otherlv_14= 'time-bound' otherlv_15= ':' ( (lv_timeBound_16_0= RULE_ABS_EBIGDECIMAL ) )
                    	    {
                    	    otherlv_14=(Token)match(input,18,FOLLOW_6); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_14, grammarAccess.getXFunctionAccess().getTimeBoundKeyword_6_1_0_0());
                    	      					
                    	    }
                    	    otherlv_15=(Token)match(input,17,FOLLOW_8); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_15, grammarAccess.getXFunctionAccess().getColonKeyword_6_1_0_1());
                    	      					
                    	    }
                    	    // InternalTmscXtext.g:989:6: ( (lv_timeBound_16_0= RULE_ABS_EBIGDECIMAL ) )
                    	    // InternalTmscXtext.g:990:7: (lv_timeBound_16_0= RULE_ABS_EBIGDECIMAL )
                    	    {
                    	    // InternalTmscXtext.g:990:7: (lv_timeBound_16_0= RULE_ABS_EBIGDECIMAL )
                    	    // InternalTmscXtext.g:991:8: lv_timeBound_16_0= RULE_ABS_EBIGDECIMAL
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
                    	    // InternalTmscXtext.g:1009:5: (otherlv_17= 'scheduled' otherlv_18= ':' ( (lv_scheduled_19_0= ruleEBOOLEAN_OBJECT ) ) )
                    	    {
                    	    // InternalTmscXtext.g:1009:5: (otherlv_17= 'scheduled' otherlv_18= ':' ( (lv_scheduled_19_0= ruleEBOOLEAN_OBJECT ) ) )
                    	    // InternalTmscXtext.g:1010:6: otherlv_17= 'scheduled' otherlv_18= ':' ( (lv_scheduled_19_0= ruleEBOOLEAN_OBJECT ) )
                    	    {
                    	    otherlv_17=(Token)match(input,19,FOLLOW_6); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_17, grammarAccess.getXFunctionAccess().getScheduledKeyword_6_1_1_0());
                    	      					
                    	    }
                    	    otherlv_18=(Token)match(input,17,FOLLOW_9); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_18, grammarAccess.getXFunctionAccess().getColonKeyword_6_1_1_1());
                    	      					
                    	    }
                    	    // InternalTmscXtext.g:1018:6: ( (lv_scheduled_19_0= ruleEBOOLEAN_OBJECT ) )
                    	    // InternalTmscXtext.g:1019:7: (lv_scheduled_19_0= ruleEBOOLEAN_OBJECT )
                    	    {
                    	    // InternalTmscXtext.g:1019:7: (lv_scheduled_19_0= ruleEBOOLEAN_OBJECT )
                    	    // InternalTmscXtext.g:1020:8: lv_scheduled_19_0= ruleEBOOLEAN_OBJECT
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
                    	    // InternalTmscXtext.g:1039:5: ( (lv_properties_20_0= ruleXProperty ) )
                    	    {
                    	    // InternalTmscXtext.g:1039:5: ( (lv_properties_20_0= ruleXProperty ) )
                    	    // InternalTmscXtext.g:1040:6: (lv_properties_20_0= ruleXProperty )
                    	    {
                    	    // InternalTmscXtext.g:1040:6: (lv_properties_20_0= ruleXProperty )
                    	    // InternalTmscXtext.g:1041:7: lv_properties_20_0= ruleXProperty
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
                    	    break loop21;
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
    // InternalTmscXtext.g:1068:1: entryRuleXFunctionParameter returns [EObject current=null] : iv_ruleXFunctionParameter= ruleXFunctionParameter EOF ;
    public final EObject entryRuleXFunctionParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXFunctionParameter = null;


        try {
            // InternalTmscXtext.g:1068:59: (iv_ruleXFunctionParameter= ruleXFunctionParameter EOF )
            // InternalTmscXtext.g:1069:2: iv_ruleXFunctionParameter= ruleXFunctionParameter EOF
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
    // InternalTmscXtext.g:1075:1: ruleXFunctionParameter returns [EObject current=null] : ( ( (lv_kind_0_0= ruleXFunctionParameterKind ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_properties_3_0= ruleXProperty ) ) (otherlv_4= ',' ( (lv_properties_5_0= ruleXProperty ) ) )* otherlv_6= ')' )? ) ;
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
            // InternalTmscXtext.g:1081:2: ( ( ( (lv_kind_0_0= ruleXFunctionParameterKind ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_properties_3_0= ruleXProperty ) ) (otherlv_4= ',' ( (lv_properties_5_0= ruleXProperty ) ) )* otherlv_6= ')' )? ) )
            // InternalTmscXtext.g:1082:2: ( ( (lv_kind_0_0= ruleXFunctionParameterKind ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_properties_3_0= ruleXProperty ) ) (otherlv_4= ',' ( (lv_properties_5_0= ruleXProperty ) ) )* otherlv_6= ')' )? )
            {
            // InternalTmscXtext.g:1082:2: ( ( (lv_kind_0_0= ruleXFunctionParameterKind ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_properties_3_0= ruleXProperty ) ) (otherlv_4= ',' ( (lv_properties_5_0= ruleXProperty ) ) )* otherlv_6= ')' )? )
            // InternalTmscXtext.g:1083:3: ( (lv_kind_0_0= ruleXFunctionParameterKind ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_properties_3_0= ruleXProperty ) ) (otherlv_4= ',' ( (lv_properties_5_0= ruleXProperty ) ) )* otherlv_6= ')' )?
            {
            // InternalTmscXtext.g:1083:3: ( (lv_kind_0_0= ruleXFunctionParameterKind ) )
            // InternalTmscXtext.g:1084:4: (lv_kind_0_0= ruleXFunctionParameterKind )
            {
            // InternalTmscXtext.g:1084:4: (lv_kind_0_0= ruleXFunctionParameterKind )
            // InternalTmscXtext.g:1085:5: lv_kind_0_0= ruleXFunctionParameterKind
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getXFunctionParameterAccess().getKindXFunctionParameterKindEnumRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_13);
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

            // InternalTmscXtext.g:1102:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalTmscXtext.g:1103:4: (lv_name_1_0= RULE_ID )
            {
            // InternalTmscXtext.g:1103:4: (lv_name_1_0= RULE_ID )
            // InternalTmscXtext.g:1104:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_24); if (state.failed) return current;
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

            // InternalTmscXtext.g:1120:3: (otherlv_2= '(' ( (lv_properties_3_0= ruleXProperty ) ) (otherlv_4= ',' ( (lv_properties_5_0= ruleXProperty ) ) )* otherlv_6= ')' )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==31) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalTmscXtext.g:1121:4: otherlv_2= '(' ( (lv_properties_3_0= ruleXProperty ) ) (otherlv_4= ',' ( (lv_properties_5_0= ruleXProperty ) ) )* otherlv_6= ')'
                    {
                    otherlv_2=(Token)match(input,31,FOLLOW_11); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getXFunctionParameterAccess().getLeftParenthesisKeyword_2_0());
                      			
                    }
                    // InternalTmscXtext.g:1125:4: ( (lv_properties_3_0= ruleXProperty ) )
                    // InternalTmscXtext.g:1126:5: (lv_properties_3_0= ruleXProperty )
                    {
                    // InternalTmscXtext.g:1126:5: (lv_properties_3_0= ruleXProperty )
                    // InternalTmscXtext.g:1127:6: lv_properties_3_0= ruleXProperty
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getXFunctionParameterAccess().getPropertiesXPropertyParserRuleCall_2_1_0());
                      					
                    }
                    pushFollow(FOLLOW_22);
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

                    // InternalTmscXtext.g:1144:4: (otherlv_4= ',' ( (lv_properties_5_0= ruleXProperty ) ) )*
                    loop23:
                    do {
                        int alt23=2;
                        int LA23_0 = input.LA(1);

                        if ( (LA23_0==26) ) {
                            alt23=1;
                        }


                        switch (alt23) {
                    	case 1 :
                    	    // InternalTmscXtext.g:1145:5: otherlv_4= ',' ( (lv_properties_5_0= ruleXProperty ) )
                    	    {
                    	    otherlv_4=(Token)match(input,26,FOLLOW_11); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_4, grammarAccess.getXFunctionParameterAccess().getCommaKeyword_2_2_0());
                    	      				
                    	    }
                    	    // InternalTmscXtext.g:1149:5: ( (lv_properties_5_0= ruleXProperty ) )
                    	    // InternalTmscXtext.g:1150:6: (lv_properties_5_0= ruleXProperty )
                    	    {
                    	    // InternalTmscXtext.g:1150:6: (lv_properties_5_0= ruleXProperty )
                    	    // InternalTmscXtext.g:1151:7: lv_properties_5_0= ruleXProperty
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getXFunctionParameterAccess().getPropertiesXPropertyParserRuleCall_2_2_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_22);
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
                    	    break loop23;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,32,FOLLOW_2); if (state.failed) return current;
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
    // InternalTmscXtext.g:1178:1: entryRuleXHost returns [EObject current=null] : iv_ruleXHost= ruleXHost EOF ;
    public final EObject entryRuleXHost() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXHost = null;


        try {
            // InternalTmscXtext.g:1178:46: (iv_ruleXHost= ruleXHost EOF )
            // InternalTmscXtext.g:1179:2: iv_ruleXHost= ruleXHost EOF
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
    // InternalTmscXtext.g:1185:1: ruleXHost returns [EObject current=null] : ( ( (lv_untraced_0_0= 'untraced' ) )? otherlv_1= 'host' ( ( (lv_description_2_0= ruleIDString ) ) otherlv_3= 'as' )? ( (lv_name_4_0= RULE_ID ) ) (otherlv_5= '{' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) | ( (lv_executors_13_0= ruleXExecutor ) ) )* otherlv_14= '}' )? ) ;
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
            // InternalTmscXtext.g:1191:2: ( ( ( (lv_untraced_0_0= 'untraced' ) )? otherlv_1= 'host' ( ( (lv_description_2_0= ruleIDString ) ) otherlv_3= 'as' )? ( (lv_name_4_0= RULE_ID ) ) (otherlv_5= '{' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) | ( (lv_executors_13_0= ruleXExecutor ) ) )* otherlv_14= '}' )? ) )
            // InternalTmscXtext.g:1192:2: ( ( (lv_untraced_0_0= 'untraced' ) )? otherlv_1= 'host' ( ( (lv_description_2_0= ruleIDString ) ) otherlv_3= 'as' )? ( (lv_name_4_0= RULE_ID ) ) (otherlv_5= '{' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) | ( (lv_executors_13_0= ruleXExecutor ) ) )* otherlv_14= '}' )? )
            {
            // InternalTmscXtext.g:1192:2: ( ( (lv_untraced_0_0= 'untraced' ) )? otherlv_1= 'host' ( ( (lv_description_2_0= ruleIDString ) ) otherlv_3= 'as' )? ( (lv_name_4_0= RULE_ID ) ) (otherlv_5= '{' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) | ( (lv_executors_13_0= ruleXExecutor ) ) )* otherlv_14= '}' )? )
            // InternalTmscXtext.g:1193:3: ( (lv_untraced_0_0= 'untraced' ) )? otherlv_1= 'host' ( ( (lv_description_2_0= ruleIDString ) ) otherlv_3= 'as' )? ( (lv_name_4_0= RULE_ID ) ) (otherlv_5= '{' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) | ( (lv_executors_13_0= ruleXExecutor ) ) )* otherlv_14= '}' )?
            {
            // InternalTmscXtext.g:1193:3: ( (lv_untraced_0_0= 'untraced' ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==34) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalTmscXtext.g:1194:4: (lv_untraced_0_0= 'untraced' )
                    {
                    // InternalTmscXtext.g:1194:4: (lv_untraced_0_0= 'untraced' )
                    // InternalTmscXtext.g:1195:5: lv_untraced_0_0= 'untraced'
                    {
                    lv_untraced_0_0=(Token)match(input,34,FOLLOW_25); if (state.failed) return current;
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

            otherlv_1=(Token)match(input,35,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getXHostAccess().getHostKeyword_1());
              		
            }
            // InternalTmscXtext.g:1211:3: ( ( (lv_description_2_0= ruleIDString ) ) otherlv_3= 'as' )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==RULE_ID) ) {
                int LA26_1 = input.LA(2);

                if ( (LA26_1==22) ) {
                    alt26=1;
                }
            }
            else if ( (LA26_0==RULE_STRING) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalTmscXtext.g:1212:4: ( (lv_description_2_0= ruleIDString ) ) otherlv_3= 'as'
                    {
                    // InternalTmscXtext.g:1212:4: ( (lv_description_2_0= ruleIDString ) )
                    // InternalTmscXtext.g:1213:5: (lv_description_2_0= ruleIDString )
                    {
                    // InternalTmscXtext.g:1213:5: (lv_description_2_0= ruleIDString )
                    // InternalTmscXtext.g:1214:6: lv_description_2_0= ruleIDString
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getXHostAccess().getDescriptionIDStringParserRuleCall_2_0_0());
                      					
                    }
                    pushFollow(FOLLOW_12);
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

                    otherlv_3=(Token)match(input,22,FOLLOW_13); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getXHostAccess().getAsKeyword_2_1());
                      			
                    }

                    }
                    break;

            }

            // InternalTmscXtext.g:1236:3: ( (lv_name_4_0= RULE_ID ) )
            // InternalTmscXtext.g:1237:4: (lv_name_4_0= RULE_ID )
            {
            // InternalTmscXtext.g:1237:4: (lv_name_4_0= RULE_ID )
            // InternalTmscXtext.g:1238:5: lv_name_4_0= RULE_ID
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

            // InternalTmscXtext.g:1254:3: (otherlv_5= '{' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) | ( (lv_executors_13_0= ruleXExecutor ) ) )* otherlv_14= '}' )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==15) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalTmscXtext.g:1255:4: otherlv_5= '{' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) | ( (lv_executors_13_0= ruleXExecutor ) ) )* otherlv_14= '}'
                    {
                    otherlv_5=(Token)match(input,15,FOLLOW_26); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getXHostAccess().getLeftCurlyBracketKeyword_4_0());
                      			
                    }
                    // InternalTmscXtext.g:1259:4: ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) | ( (lv_executors_13_0= ruleXExecutor ) ) )*
                    loop27:
                    do {
                        int alt27=5;
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
                        case 34:
                        case 36:
                            {
                            alt27=4;
                            }
                            break;

                        }

                        switch (alt27) {
                    	case 1 :
                    	    // InternalTmscXtext.g:1260:5: (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) )
                    	    {
                    	    // InternalTmscXtext.g:1260:5: (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) )
                    	    // InternalTmscXtext.g:1261:6: otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) )
                    	    {
                    	    otherlv_6=(Token)match(input,18,FOLLOW_6); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_6, grammarAccess.getXHostAccess().getTimeBoundKeyword_4_1_0_0());
                    	      					
                    	    }
                    	    otherlv_7=(Token)match(input,17,FOLLOW_8); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_7, grammarAccess.getXHostAccess().getColonKeyword_4_1_0_1());
                    	      					
                    	    }
                    	    // InternalTmscXtext.g:1269:6: ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) )
                    	    // InternalTmscXtext.g:1270:7: (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL )
                    	    {
                    	    // InternalTmscXtext.g:1270:7: (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL )
                    	    // InternalTmscXtext.g:1271:8: lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL
                    	    {
                    	    lv_timeBound_8_0=(Token)match(input,RULE_ABS_EBIGDECIMAL,FOLLOW_26); if (state.failed) return current;
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
                    	    // InternalTmscXtext.g:1289:5: (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) )
                    	    {
                    	    // InternalTmscXtext.g:1289:5: (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) )
                    	    // InternalTmscXtext.g:1290:6: otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) )
                    	    {
                    	    otherlv_9=(Token)match(input,19,FOLLOW_6); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_9, grammarAccess.getXHostAccess().getScheduledKeyword_4_1_1_0());
                    	      					
                    	    }
                    	    otherlv_10=(Token)match(input,17,FOLLOW_9); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_10, grammarAccess.getXHostAccess().getColonKeyword_4_1_1_1());
                    	      					
                    	    }
                    	    // InternalTmscXtext.g:1298:6: ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) )
                    	    // InternalTmscXtext.g:1299:7: (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT )
                    	    {
                    	    // InternalTmscXtext.g:1299:7: (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT )
                    	    // InternalTmscXtext.g:1300:8: lv_scheduled_11_0= ruleEBOOLEAN_OBJECT
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      								newCompositeNode(grammarAccess.getXHostAccess().getScheduledEBOOLEAN_OBJECTParserRuleCall_4_1_1_2_0());
                    	      							
                    	    }
                    	    pushFollow(FOLLOW_26);
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
                    	    // InternalTmscXtext.g:1319:5: ( (lv_properties_12_0= ruleXProperty ) )
                    	    {
                    	    // InternalTmscXtext.g:1319:5: ( (lv_properties_12_0= ruleXProperty ) )
                    	    // InternalTmscXtext.g:1320:6: (lv_properties_12_0= ruleXProperty )
                    	    {
                    	    // InternalTmscXtext.g:1320:6: (lv_properties_12_0= ruleXProperty )
                    	    // InternalTmscXtext.g:1321:7: lv_properties_12_0= ruleXProperty
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getXHostAccess().getPropertiesXPropertyParserRuleCall_4_1_2_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_26);
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
                    	    // InternalTmscXtext.g:1339:5: ( (lv_executors_13_0= ruleXExecutor ) )
                    	    {
                    	    // InternalTmscXtext.g:1339:5: ( (lv_executors_13_0= ruleXExecutor ) )
                    	    // InternalTmscXtext.g:1340:6: (lv_executors_13_0= ruleXExecutor )
                    	    {
                    	    // InternalTmscXtext.g:1340:6: (lv_executors_13_0= ruleXExecutor )
                    	    // InternalTmscXtext.g:1341:7: lv_executors_13_0= ruleXExecutor
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getXHostAccess().getExecutorsXExecutorParserRuleCall_4_1_3_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_26);
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
                    	    break loop27;
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
    // InternalTmscXtext.g:1368:1: entryRuleXExecutor returns [EObject current=null] : iv_ruleXExecutor= ruleXExecutor EOF ;
    public final EObject entryRuleXExecutor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXExecutor = null;


        try {
            // InternalTmscXtext.g:1368:50: (iv_ruleXExecutor= ruleXExecutor EOF )
            // InternalTmscXtext.g:1369:2: iv_ruleXExecutor= ruleXExecutor EOF
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
    // InternalTmscXtext.g:1375:1: ruleXExecutor returns [EObject current=null] : ( ( (lv_untraced_0_0= 'untraced' ) )? otherlv_1= 'executor' ( ( (lv_description_2_0= ruleIDString ) ) otherlv_3= 'as' )? ( (lv_name_4_0= RULE_ID ) ) (otherlv_5= '{' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) )* otherlv_13= '}' )? ) ;
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
            // InternalTmscXtext.g:1381:2: ( ( ( (lv_untraced_0_0= 'untraced' ) )? otherlv_1= 'executor' ( ( (lv_description_2_0= ruleIDString ) ) otherlv_3= 'as' )? ( (lv_name_4_0= RULE_ID ) ) (otherlv_5= '{' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) )* otherlv_13= '}' )? ) )
            // InternalTmscXtext.g:1382:2: ( ( (lv_untraced_0_0= 'untraced' ) )? otherlv_1= 'executor' ( ( (lv_description_2_0= ruleIDString ) ) otherlv_3= 'as' )? ( (lv_name_4_0= RULE_ID ) ) (otherlv_5= '{' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) )* otherlv_13= '}' )? )
            {
            // InternalTmscXtext.g:1382:2: ( ( (lv_untraced_0_0= 'untraced' ) )? otherlv_1= 'executor' ( ( (lv_description_2_0= ruleIDString ) ) otherlv_3= 'as' )? ( (lv_name_4_0= RULE_ID ) ) (otherlv_5= '{' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) )* otherlv_13= '}' )? )
            // InternalTmscXtext.g:1383:3: ( (lv_untraced_0_0= 'untraced' ) )? otherlv_1= 'executor' ( ( (lv_description_2_0= ruleIDString ) ) otherlv_3= 'as' )? ( (lv_name_4_0= RULE_ID ) ) (otherlv_5= '{' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) )* otherlv_13= '}' )?
            {
            // InternalTmscXtext.g:1383:3: ( (lv_untraced_0_0= 'untraced' ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==34) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalTmscXtext.g:1384:4: (lv_untraced_0_0= 'untraced' )
                    {
                    // InternalTmscXtext.g:1384:4: (lv_untraced_0_0= 'untraced' )
                    // InternalTmscXtext.g:1385:5: lv_untraced_0_0= 'untraced'
                    {
                    lv_untraced_0_0=(Token)match(input,34,FOLLOW_27); if (state.failed) return current;
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

            otherlv_1=(Token)match(input,36,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getXExecutorAccess().getExecutorKeyword_1());
              		
            }
            // InternalTmscXtext.g:1401:3: ( ( (lv_description_2_0= ruleIDString ) ) otherlv_3= 'as' )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==RULE_ID) ) {
                int LA30_1 = input.LA(2);

                if ( (LA30_1==22) ) {
                    alt30=1;
                }
            }
            else if ( (LA30_0==RULE_STRING) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalTmscXtext.g:1402:4: ( (lv_description_2_0= ruleIDString ) ) otherlv_3= 'as'
                    {
                    // InternalTmscXtext.g:1402:4: ( (lv_description_2_0= ruleIDString ) )
                    // InternalTmscXtext.g:1403:5: (lv_description_2_0= ruleIDString )
                    {
                    // InternalTmscXtext.g:1403:5: (lv_description_2_0= ruleIDString )
                    // InternalTmscXtext.g:1404:6: lv_description_2_0= ruleIDString
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getXExecutorAccess().getDescriptionIDStringParserRuleCall_2_0_0());
                      					
                    }
                    pushFollow(FOLLOW_12);
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

                    otherlv_3=(Token)match(input,22,FOLLOW_13); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getXExecutorAccess().getAsKeyword_2_1());
                      			
                    }

                    }
                    break;

            }

            // InternalTmscXtext.g:1426:3: ( (lv_name_4_0= RULE_ID ) )
            // InternalTmscXtext.g:1427:4: (lv_name_4_0= RULE_ID )
            {
            // InternalTmscXtext.g:1427:4: (lv_name_4_0= RULE_ID )
            // InternalTmscXtext.g:1428:5: lv_name_4_0= RULE_ID
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

            // InternalTmscXtext.g:1444:3: (otherlv_5= '{' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) )* otherlv_13= '}' )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==15) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalTmscXtext.g:1445:4: otherlv_5= '{' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) )* otherlv_13= '}'
                    {
                    otherlv_5=(Token)match(input,15,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getXExecutorAccess().getLeftCurlyBracketKeyword_4_0());
                      			
                    }
                    // InternalTmscXtext.g:1449:4: ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) )*
                    loop31:
                    do {
                        int alt31=4;
                        switch ( input.LA(1) ) {
                        case 18:
                            {
                            alt31=1;
                            }
                            break;
                        case 19:
                            {
                            alt31=2;
                            }
                            break;
                        case RULE_ID:
                        case RULE_STRING:
                            {
                            alt31=3;
                            }
                            break;

                        }

                        switch (alt31) {
                    	case 1 :
                    	    // InternalTmscXtext.g:1450:5: (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) )
                    	    {
                    	    // InternalTmscXtext.g:1450:5: (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) )
                    	    // InternalTmscXtext.g:1451:6: otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) )
                    	    {
                    	    otherlv_6=(Token)match(input,18,FOLLOW_6); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_6, grammarAccess.getXExecutorAccess().getTimeBoundKeyword_4_1_0_0());
                    	      					
                    	    }
                    	    otherlv_7=(Token)match(input,17,FOLLOW_8); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_7, grammarAccess.getXExecutorAccess().getColonKeyword_4_1_0_1());
                    	      					
                    	    }
                    	    // InternalTmscXtext.g:1459:6: ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) )
                    	    // InternalTmscXtext.g:1460:7: (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL )
                    	    {
                    	    // InternalTmscXtext.g:1460:7: (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL )
                    	    // InternalTmscXtext.g:1461:8: lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL
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
                    	    // InternalTmscXtext.g:1479:5: (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) )
                    	    {
                    	    // InternalTmscXtext.g:1479:5: (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) )
                    	    // InternalTmscXtext.g:1480:6: otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) )
                    	    {
                    	    otherlv_9=(Token)match(input,19,FOLLOW_6); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_9, grammarAccess.getXExecutorAccess().getScheduledKeyword_4_1_1_0());
                    	      					
                    	    }
                    	    otherlv_10=(Token)match(input,17,FOLLOW_9); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_10, grammarAccess.getXExecutorAccess().getColonKeyword_4_1_1_1());
                    	      					
                    	    }
                    	    // InternalTmscXtext.g:1488:6: ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) )
                    	    // InternalTmscXtext.g:1489:7: (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT )
                    	    {
                    	    // InternalTmscXtext.g:1489:7: (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT )
                    	    // InternalTmscXtext.g:1490:8: lv_scheduled_11_0= ruleEBOOLEAN_OBJECT
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
                    	    // InternalTmscXtext.g:1509:5: ( (lv_properties_12_0= ruleXProperty ) )
                    	    {
                    	    // InternalTmscXtext.g:1509:5: ( (lv_properties_12_0= ruleXProperty ) )
                    	    // InternalTmscXtext.g:1510:6: (lv_properties_12_0= ruleXProperty )
                    	    {
                    	    // InternalTmscXtext.g:1510:6: (lv_properties_12_0= ruleXProperty )
                    	    // InternalTmscXtext.g:1511:7: lv_properties_12_0= ruleXProperty
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
                    	    break loop31;
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
    // InternalTmscXtext.g:1538:1: entryRuleXEvent returns [EObject current=null] : iv_ruleXEvent= ruleXEvent EOF ;
    public final EObject entryRuleXEvent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXEvent = null;


        try {
            // InternalTmscXtext.g:1538:47: (iv_ruleXEvent= ruleXEvent EOF )
            // InternalTmscXtext.g:1539:2: iv_ruleXEvent= ruleXEvent EOF
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
    // InternalTmscXtext.g:1545:1: ruleXEvent returns [EObject current=null] : ( ( ( (lv_timestamp_0_1= RULE_ISO8601 | lv_timestamp_0_2= RULE_ABS_EBIGDECIMAL ) ) )? ( (lv_timeBound_1_0= RULE_POS_EBIGDECIMAL ) )? ( ( ruleFQNString ) ) ( ( ruleIDString ) )? ( (lv_type_4_0= ruleXEventType ) ) ( ( ruleIDString ) ) (otherlv_6= '(' ( (lv_arguments_7_0= ruleXEventArgument ) ) (otherlv_8= ',' ( (lv_arguments_9_0= ruleXEventArgument ) ) )* otherlv_10= ')' )? ( (otherlv_11= '!' ( (lv_outgoingDependencies_12_0= ruleXDependency ) ) ) | (otherlv_13= '?' ( ( ruleIDString ) ) ) )* (otherlv_15= '{' ( (otherlv_16= 'scheduled' otherlv_17= ':' ( (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_19_0= ruleXProperty ) ) )* otherlv_20= '}' )? ) ;
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
        Token otherlv_20=null;
        Enumerator lv_type_4_0 = null;

        EObject lv_arguments_7_0 = null;

        EObject lv_arguments_9_0 = null;

        EObject lv_outgoingDependencies_12_0 = null;

        AntlrDatatypeRuleToken lv_scheduled_18_0 = null;

        EObject lv_properties_19_0 = null;



        	enterRule();

        try {
            // InternalTmscXtext.g:1551:2: ( ( ( ( (lv_timestamp_0_1= RULE_ISO8601 | lv_timestamp_0_2= RULE_ABS_EBIGDECIMAL ) ) )? ( (lv_timeBound_1_0= RULE_POS_EBIGDECIMAL ) )? ( ( ruleFQNString ) ) ( ( ruleIDString ) )? ( (lv_type_4_0= ruleXEventType ) ) ( ( ruleIDString ) ) (otherlv_6= '(' ( (lv_arguments_7_0= ruleXEventArgument ) ) (otherlv_8= ',' ( (lv_arguments_9_0= ruleXEventArgument ) ) )* otherlv_10= ')' )? ( (otherlv_11= '!' ( (lv_outgoingDependencies_12_0= ruleXDependency ) ) ) | (otherlv_13= '?' ( ( ruleIDString ) ) ) )* (otherlv_15= '{' ( (otherlv_16= 'scheduled' otherlv_17= ':' ( (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_19_0= ruleXProperty ) ) )* otherlv_20= '}' )? ) )
            // InternalTmscXtext.g:1552:2: ( ( ( (lv_timestamp_0_1= RULE_ISO8601 | lv_timestamp_0_2= RULE_ABS_EBIGDECIMAL ) ) )? ( (lv_timeBound_1_0= RULE_POS_EBIGDECIMAL ) )? ( ( ruleFQNString ) ) ( ( ruleIDString ) )? ( (lv_type_4_0= ruleXEventType ) ) ( ( ruleIDString ) ) (otherlv_6= '(' ( (lv_arguments_7_0= ruleXEventArgument ) ) (otherlv_8= ',' ( (lv_arguments_9_0= ruleXEventArgument ) ) )* otherlv_10= ')' )? ( (otherlv_11= '!' ( (lv_outgoingDependencies_12_0= ruleXDependency ) ) ) | (otherlv_13= '?' ( ( ruleIDString ) ) ) )* (otherlv_15= '{' ( (otherlv_16= 'scheduled' otherlv_17= ':' ( (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_19_0= ruleXProperty ) ) )* otherlv_20= '}' )? )
            {
            // InternalTmscXtext.g:1552:2: ( ( ( (lv_timestamp_0_1= RULE_ISO8601 | lv_timestamp_0_2= RULE_ABS_EBIGDECIMAL ) ) )? ( (lv_timeBound_1_0= RULE_POS_EBIGDECIMAL ) )? ( ( ruleFQNString ) ) ( ( ruleIDString ) )? ( (lv_type_4_0= ruleXEventType ) ) ( ( ruleIDString ) ) (otherlv_6= '(' ( (lv_arguments_7_0= ruleXEventArgument ) ) (otherlv_8= ',' ( (lv_arguments_9_0= ruleXEventArgument ) ) )* otherlv_10= ')' )? ( (otherlv_11= '!' ( (lv_outgoingDependencies_12_0= ruleXDependency ) ) ) | (otherlv_13= '?' ( ( ruleIDString ) ) ) )* (otherlv_15= '{' ( (otherlv_16= 'scheduled' otherlv_17= ':' ( (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_19_0= ruleXProperty ) ) )* otherlv_20= '}' )? )
            // InternalTmscXtext.g:1553:3: ( ( (lv_timestamp_0_1= RULE_ISO8601 | lv_timestamp_0_2= RULE_ABS_EBIGDECIMAL ) ) )? ( (lv_timeBound_1_0= RULE_POS_EBIGDECIMAL ) )? ( ( ruleFQNString ) ) ( ( ruleIDString ) )? ( (lv_type_4_0= ruleXEventType ) ) ( ( ruleIDString ) ) (otherlv_6= '(' ( (lv_arguments_7_0= ruleXEventArgument ) ) (otherlv_8= ',' ( (lv_arguments_9_0= ruleXEventArgument ) ) )* otherlv_10= ')' )? ( (otherlv_11= '!' ( (lv_outgoingDependencies_12_0= ruleXDependency ) ) ) | (otherlv_13= '?' ( ( ruleIDString ) ) ) )* (otherlv_15= '{' ( (otherlv_16= 'scheduled' otherlv_17= ':' ( (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_19_0= ruleXProperty ) ) )* otherlv_20= '}' )?
            {
            // InternalTmscXtext.g:1553:3: ( ( (lv_timestamp_0_1= RULE_ISO8601 | lv_timestamp_0_2= RULE_ABS_EBIGDECIMAL ) ) )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==RULE_ABS_EBIGDECIMAL||LA34_0==RULE_ISO8601) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalTmscXtext.g:1554:4: ( (lv_timestamp_0_1= RULE_ISO8601 | lv_timestamp_0_2= RULE_ABS_EBIGDECIMAL ) )
                    {
                    // InternalTmscXtext.g:1554:4: ( (lv_timestamp_0_1= RULE_ISO8601 | lv_timestamp_0_2= RULE_ABS_EBIGDECIMAL ) )
                    // InternalTmscXtext.g:1555:5: (lv_timestamp_0_1= RULE_ISO8601 | lv_timestamp_0_2= RULE_ABS_EBIGDECIMAL )
                    {
                    // InternalTmscXtext.g:1555:5: (lv_timestamp_0_1= RULE_ISO8601 | lv_timestamp_0_2= RULE_ABS_EBIGDECIMAL )
                    int alt33=2;
                    int LA33_0 = input.LA(1);

                    if ( (LA33_0==RULE_ISO8601) ) {
                        alt33=1;
                    }
                    else if ( (LA33_0==RULE_ABS_EBIGDECIMAL) ) {
                        alt33=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 33, 0, input);

                        throw nvae;
                    }
                    switch (alt33) {
                        case 1 :
                            // InternalTmscXtext.g:1556:6: lv_timestamp_0_1= RULE_ISO8601
                            {
                            lv_timestamp_0_1=(Token)match(input,RULE_ISO8601,FOLLOW_28); if (state.failed) return current;
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
                            // InternalTmscXtext.g:1571:6: lv_timestamp_0_2= RULE_ABS_EBIGDECIMAL
                            {
                            lv_timestamp_0_2=(Token)match(input,RULE_ABS_EBIGDECIMAL,FOLLOW_28); if (state.failed) return current;
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

            // InternalTmscXtext.g:1588:3: ( (lv_timeBound_1_0= RULE_POS_EBIGDECIMAL ) )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==RULE_POS_EBIGDECIMAL) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalTmscXtext.g:1589:4: (lv_timeBound_1_0= RULE_POS_EBIGDECIMAL )
                    {
                    // InternalTmscXtext.g:1589:4: (lv_timeBound_1_0= RULE_POS_EBIGDECIMAL )
                    // InternalTmscXtext.g:1590:5: lv_timeBound_1_0= RULE_POS_EBIGDECIMAL
                    {
                    lv_timeBound_1_0=(Token)match(input,RULE_POS_EBIGDECIMAL,FOLLOW_28); if (state.failed) return current;
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

            // InternalTmscXtext.g:1606:3: ( ( ruleFQNString ) )
            // InternalTmscXtext.g:1607:4: ( ruleFQNString )
            {
            // InternalTmscXtext.g:1607:4: ( ruleFQNString )
            // InternalTmscXtext.g:1608:5: ruleFQNString
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getXEventRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getXEventAccess().getExecutorXExecutorCrossReference_2_0());
              				
            }
            pushFollow(FOLLOW_28);
            ruleFQNString();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalTmscXtext.g:1622:3: ( ( ruleIDString ) )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==RULE_ID||LA36_0==RULE_STRING) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalTmscXtext.g:1623:4: ( ruleIDString )
                    {
                    // InternalTmscXtext.g:1623:4: ( ruleIDString )
                    // InternalTmscXtext.g:1624:5: ruleIDString
                    {
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getXEventRule());
                      					}
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getXEventAccess().getComponentXComponentCrossReference_3_0());
                      				
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
                    break;

            }

            // InternalTmscXtext.g:1638:3: ( (lv_type_4_0= ruleXEventType ) )
            // InternalTmscXtext.g:1639:4: (lv_type_4_0= ruleXEventType )
            {
            // InternalTmscXtext.g:1639:4: (lv_type_4_0= ruleXEventType )
            // InternalTmscXtext.g:1640:5: lv_type_4_0= ruleXEventType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getXEventAccess().getTypeXEventTypeEnumRuleCall_4_0());
              				
            }
            pushFollow(FOLLOW_11);
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

            // InternalTmscXtext.g:1657:3: ( ( ruleIDString ) )
            // InternalTmscXtext.g:1658:4: ( ruleIDString )
            {
            // InternalTmscXtext.g:1658:4: ( ruleIDString )
            // InternalTmscXtext.g:1659:5: ruleIDString
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getXEventRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getXEventAccess().getFunctionXFunctionCrossReference_5_0());
              				
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

            // InternalTmscXtext.g:1673:3: (otherlv_6= '(' ( (lv_arguments_7_0= ruleXEventArgument ) ) (otherlv_8= ',' ( (lv_arguments_9_0= ruleXEventArgument ) ) )* otherlv_10= ')' )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==31) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalTmscXtext.g:1674:4: otherlv_6= '(' ( (lv_arguments_7_0= ruleXEventArgument ) ) (otherlv_8= ',' ( (lv_arguments_9_0= ruleXEventArgument ) ) )* otherlv_10= ')'
                    {
                    otherlv_6=(Token)match(input,31,FOLLOW_13); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_6, grammarAccess.getXEventAccess().getLeftParenthesisKeyword_6_0());
                      			
                    }
                    // InternalTmscXtext.g:1678:4: ( (lv_arguments_7_0= ruleXEventArgument ) )
                    // InternalTmscXtext.g:1679:5: (lv_arguments_7_0= ruleXEventArgument )
                    {
                    // InternalTmscXtext.g:1679:5: (lv_arguments_7_0= ruleXEventArgument )
                    // InternalTmscXtext.g:1680:6: lv_arguments_7_0= ruleXEventArgument
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getXEventAccess().getArgumentsXEventArgumentParserRuleCall_6_1_0());
                      					
                    }
                    pushFollow(FOLLOW_22);
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

                    // InternalTmscXtext.g:1697:4: (otherlv_8= ',' ( (lv_arguments_9_0= ruleXEventArgument ) ) )*
                    loop37:
                    do {
                        int alt37=2;
                        int LA37_0 = input.LA(1);

                        if ( (LA37_0==26) ) {
                            alt37=1;
                        }


                        switch (alt37) {
                    	case 1 :
                    	    // InternalTmscXtext.g:1698:5: otherlv_8= ',' ( (lv_arguments_9_0= ruleXEventArgument ) )
                    	    {
                    	    otherlv_8=(Token)match(input,26,FOLLOW_13); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_8, grammarAccess.getXEventAccess().getCommaKeyword_6_2_0());
                    	      				
                    	    }
                    	    // InternalTmscXtext.g:1702:5: ( (lv_arguments_9_0= ruleXEventArgument ) )
                    	    // InternalTmscXtext.g:1703:6: (lv_arguments_9_0= ruleXEventArgument )
                    	    {
                    	    // InternalTmscXtext.g:1703:6: (lv_arguments_9_0= ruleXEventArgument )
                    	    // InternalTmscXtext.g:1704:7: lv_arguments_9_0= ruleXEventArgument
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getXEventAccess().getArgumentsXEventArgumentParserRuleCall_6_2_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_22);
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
                    	    break loop37;
                        }
                    } while (true);

                    otherlv_10=(Token)match(input,32,FOLLOW_30); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_10, grammarAccess.getXEventAccess().getRightParenthesisKeyword_6_3());
                      			
                    }

                    }
                    break;

            }

            // InternalTmscXtext.g:1727:3: ( (otherlv_11= '!' ( (lv_outgoingDependencies_12_0= ruleXDependency ) ) ) | (otherlv_13= '?' ( ( ruleIDString ) ) ) )*
            loop39:
            do {
                int alt39=3;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==37) ) {
                    alt39=1;
                }
                else if ( (LA39_0==38) ) {
                    alt39=2;
                }


                switch (alt39) {
            	case 1 :
            	    // InternalTmscXtext.g:1728:4: (otherlv_11= '!' ( (lv_outgoingDependencies_12_0= ruleXDependency ) ) )
            	    {
            	    // InternalTmscXtext.g:1728:4: (otherlv_11= '!' ( (lv_outgoingDependencies_12_0= ruleXDependency ) ) )
            	    // InternalTmscXtext.g:1729:5: otherlv_11= '!' ( (lv_outgoingDependencies_12_0= ruleXDependency ) )
            	    {
            	    otherlv_11=(Token)match(input,37,FOLLOW_31); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_11, grammarAccess.getXEventAccess().getExclamationMarkKeyword_7_0_0());
            	      				
            	    }
            	    // InternalTmscXtext.g:1733:5: ( (lv_outgoingDependencies_12_0= ruleXDependency ) )
            	    // InternalTmscXtext.g:1734:6: (lv_outgoingDependencies_12_0= ruleXDependency )
            	    {
            	    // InternalTmscXtext.g:1734:6: (lv_outgoingDependencies_12_0= ruleXDependency )
            	    // InternalTmscXtext.g:1735:7: lv_outgoingDependencies_12_0= ruleXDependency
            	    {
            	    if ( state.backtracking==0 ) {

            	      							newCompositeNode(grammarAccess.getXEventAccess().getOutgoingDependenciesXDependencyParserRuleCall_7_0_1_0());
            	      						
            	    }
            	    pushFollow(FOLLOW_30);
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
            	    // InternalTmscXtext.g:1754:4: (otherlv_13= '?' ( ( ruleIDString ) ) )
            	    {
            	    // InternalTmscXtext.g:1754:4: (otherlv_13= '?' ( ( ruleIDString ) ) )
            	    // InternalTmscXtext.g:1755:5: otherlv_13= '?' ( ( ruleIDString ) )
            	    {
            	    otherlv_13=(Token)match(input,38,FOLLOW_11); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_13, grammarAccess.getXEventAccess().getQuestionMarkKeyword_7_1_0());
            	      				
            	    }
            	    // InternalTmscXtext.g:1759:5: ( ( ruleIDString ) )
            	    // InternalTmscXtext.g:1760:6: ( ruleIDString )
            	    {
            	    // InternalTmscXtext.g:1760:6: ( ruleIDString )
            	    // InternalTmscXtext.g:1761:7: ruleIDString
            	    {
            	    if ( state.backtracking==0 ) {

            	      							if (current==null) {
            	      								current = createModelElement(grammarAccess.getXEventRule());
            	      							}
            	      						
            	    }
            	    if ( state.backtracking==0 ) {

            	      							newCompositeNode(grammarAccess.getXEventAccess().getIncomingDependenciesXDependencyCrossReference_7_1_1_0());
            	      						
            	    }
            	    pushFollow(FOLLOW_30);
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
            	    break loop39;
                }
            } while (true);

            // InternalTmscXtext.g:1777:3: (otherlv_15= '{' ( (otherlv_16= 'scheduled' otherlv_17= ':' ( (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_19_0= ruleXProperty ) ) )* otherlv_20= '}' )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==15) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalTmscXtext.g:1778:4: otherlv_15= '{' ( (otherlv_16= 'scheduled' otherlv_17= ':' ( (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_19_0= ruleXProperty ) ) )* otherlv_20= '}'
                    {
                    otherlv_15=(Token)match(input,15,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_15, grammarAccess.getXEventAccess().getLeftCurlyBracketKeyword_8_0());
                      			
                    }
                    // InternalTmscXtext.g:1782:4: ( (otherlv_16= 'scheduled' otherlv_17= ':' ( (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_19_0= ruleXProperty ) ) )*
                    loop40:
                    do {
                        int alt40=3;
                        int LA40_0 = input.LA(1);

                        if ( (LA40_0==19) ) {
                            alt40=1;
                        }
                        else if ( (LA40_0==RULE_ID||LA40_0==RULE_STRING) ) {
                            alt40=2;
                        }


                        switch (alt40) {
                    	case 1 :
                    	    // InternalTmscXtext.g:1783:5: (otherlv_16= 'scheduled' otherlv_17= ':' ( (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT ) ) )
                    	    {
                    	    // InternalTmscXtext.g:1783:5: (otherlv_16= 'scheduled' otherlv_17= ':' ( (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT ) ) )
                    	    // InternalTmscXtext.g:1784:6: otherlv_16= 'scheduled' otherlv_17= ':' ( (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT ) )
                    	    {
                    	    otherlv_16=(Token)match(input,19,FOLLOW_6); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_16, grammarAccess.getXEventAccess().getScheduledKeyword_8_1_0_0());
                    	      					
                    	    }
                    	    otherlv_17=(Token)match(input,17,FOLLOW_9); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_17, grammarAccess.getXEventAccess().getColonKeyword_8_1_0_1());
                    	      					
                    	    }
                    	    // InternalTmscXtext.g:1792:6: ( (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT ) )
                    	    // InternalTmscXtext.g:1793:7: (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT )
                    	    {
                    	    // InternalTmscXtext.g:1793:7: (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT )
                    	    // InternalTmscXtext.g:1794:8: lv_scheduled_18_0= ruleEBOOLEAN_OBJECT
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      								newCompositeNode(grammarAccess.getXEventAccess().getScheduledEBOOLEAN_OBJECTParserRuleCall_8_1_0_2_0());
                    	      							
                    	    }
                    	    pushFollow(FOLLOW_5);
                    	    lv_scheduled_18_0=ruleEBOOLEAN_OBJECT();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      								if (current==null) {
                    	      									current = createModelElementForParent(grammarAccess.getXEventRule());
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
                    	case 2 :
                    	    // InternalTmscXtext.g:1813:5: ( (lv_properties_19_0= ruleXProperty ) )
                    	    {
                    	    // InternalTmscXtext.g:1813:5: ( (lv_properties_19_0= ruleXProperty ) )
                    	    // InternalTmscXtext.g:1814:6: (lv_properties_19_0= ruleXProperty )
                    	    {
                    	    // InternalTmscXtext.g:1814:6: (lv_properties_19_0= ruleXProperty )
                    	    // InternalTmscXtext.g:1815:7: lv_properties_19_0= ruleXProperty
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getXEventAccess().getPropertiesXPropertyParserRuleCall_8_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_5);
                    	    lv_properties_19_0=ruleXProperty();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getXEventRule());
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
                    	    break loop40;
                        }
                    } while (true);

                    otherlv_20=(Token)match(input,20,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_20, grammarAccess.getXEventAccess().getRightCurlyBracketKeyword_8_2());
                      			
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
    // InternalTmscXtext.g:1842:1: entryRuleXEventArgument returns [EObject current=null] : iv_ruleXEventArgument= ruleXEventArgument EOF ;
    public final EObject entryRuleXEventArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXEventArgument = null;


        try {
            // InternalTmscXtext.g:1842:55: (iv_ruleXEventArgument= ruleXEventArgument EOF )
            // InternalTmscXtext.g:1843:2: iv_ruleXEventArgument= ruleXEventArgument EOF
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
    // InternalTmscXtext.g:1849:1: ruleXEventArgument returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' ( (lv_value_2_0= ruleIDString ) ) ) ;
    public final EObject ruleXEventArgument() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalTmscXtext.g:1855:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' ( (lv_value_2_0= ruleIDString ) ) ) )
            // InternalTmscXtext.g:1856:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' ( (lv_value_2_0= ruleIDString ) ) )
            {
            // InternalTmscXtext.g:1856:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' ( (lv_value_2_0= ruleIDString ) ) )
            // InternalTmscXtext.g:1857:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' ( (lv_value_2_0= ruleIDString ) )
            {
            // InternalTmscXtext.g:1857:3: ( (otherlv_0= RULE_ID ) )
            // InternalTmscXtext.g:1858:4: (otherlv_0= RULE_ID )
            {
            // InternalTmscXtext.g:1858:4: (otherlv_0= RULE_ID )
            // InternalTmscXtext.g:1859:5: otherlv_0= RULE_ID
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

            otherlv_1=(Token)match(input,17,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getXEventArgumentAccess().getColonKeyword_1());
              		
            }
            // InternalTmscXtext.g:1874:3: ( (lv_value_2_0= ruleIDString ) )
            // InternalTmscXtext.g:1875:4: (lv_value_2_0= ruleIDString )
            {
            // InternalTmscXtext.g:1875:4: (lv_value_2_0= ruleIDString )
            // InternalTmscXtext.g:1876:5: lv_value_2_0= ruleIDString
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
    // InternalTmscXtext.g:1897:1: entryRuleXDependency returns [EObject current=null] : iv_ruleXDependency= ruleXDependency EOF ;
    public final EObject entryRuleXDependency() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXDependency = null;


        try {
            // InternalTmscXtext.g:1897:52: (iv_ruleXDependency= ruleXDependency EOF )
            // InternalTmscXtext.g:1898:2: iv_ruleXDependency= ruleXDependency EOF
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
    // InternalTmscXtext.g:1904:1: ruleXDependency returns [EObject current=null] : ( ( (lv_typeObject_0_0= ruleXDependencyTypeObject ) )? ( (lv_name_1_0= ruleIDString ) ) ( (otherlv_2= '(' ( (lv_timeBound_3_0= RULE_ABS_EBIGDECIMAL ) ) otherlv_4= ')' ) | (otherlv_5= '(' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_12= 'request' otherlv_13= ':' ( ( ruleIDString ) ) ) | (otherlv_15= 'message' otherlv_16= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_18_0= ruleXProperty ) ) ) (otherlv_19= ',' ( (otherlv_20= 'time-bound' otherlv_21= ':' ( (lv_timeBound_22_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_23= 'scheduled' otherlv_24= ':' ( (lv_scheduled_25_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_26= 'request' otherlv_27= ':' ( ( ruleIDString ) ) ) | (otherlv_29= 'message' otherlv_30= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_32_0= ruleXProperty ) ) ) )* otherlv_33= ')' ) )? ) ;
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
            // InternalTmscXtext.g:1910:2: ( ( ( (lv_typeObject_0_0= ruleXDependencyTypeObject ) )? ( (lv_name_1_0= ruleIDString ) ) ( (otherlv_2= '(' ( (lv_timeBound_3_0= RULE_ABS_EBIGDECIMAL ) ) otherlv_4= ')' ) | (otherlv_5= '(' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_12= 'request' otherlv_13= ':' ( ( ruleIDString ) ) ) | (otherlv_15= 'message' otherlv_16= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_18_0= ruleXProperty ) ) ) (otherlv_19= ',' ( (otherlv_20= 'time-bound' otherlv_21= ':' ( (lv_timeBound_22_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_23= 'scheduled' otherlv_24= ':' ( (lv_scheduled_25_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_26= 'request' otherlv_27= ':' ( ( ruleIDString ) ) ) | (otherlv_29= 'message' otherlv_30= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_32_0= ruleXProperty ) ) ) )* otherlv_33= ')' ) )? ) )
            // InternalTmscXtext.g:1911:2: ( ( (lv_typeObject_0_0= ruleXDependencyTypeObject ) )? ( (lv_name_1_0= ruleIDString ) ) ( (otherlv_2= '(' ( (lv_timeBound_3_0= RULE_ABS_EBIGDECIMAL ) ) otherlv_4= ')' ) | (otherlv_5= '(' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_12= 'request' otherlv_13= ':' ( ( ruleIDString ) ) ) | (otherlv_15= 'message' otherlv_16= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_18_0= ruleXProperty ) ) ) (otherlv_19= ',' ( (otherlv_20= 'time-bound' otherlv_21= ':' ( (lv_timeBound_22_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_23= 'scheduled' otherlv_24= ':' ( (lv_scheduled_25_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_26= 'request' otherlv_27= ':' ( ( ruleIDString ) ) ) | (otherlv_29= 'message' otherlv_30= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_32_0= ruleXProperty ) ) ) )* otherlv_33= ')' ) )? )
            {
            // InternalTmscXtext.g:1911:2: ( ( (lv_typeObject_0_0= ruleXDependencyTypeObject ) )? ( (lv_name_1_0= ruleIDString ) ) ( (otherlv_2= '(' ( (lv_timeBound_3_0= RULE_ABS_EBIGDECIMAL ) ) otherlv_4= ')' ) | (otherlv_5= '(' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_12= 'request' otherlv_13= ':' ( ( ruleIDString ) ) ) | (otherlv_15= 'message' otherlv_16= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_18_0= ruleXProperty ) ) ) (otherlv_19= ',' ( (otherlv_20= 'time-bound' otherlv_21= ':' ( (lv_timeBound_22_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_23= 'scheduled' otherlv_24= ':' ( (lv_scheduled_25_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_26= 'request' otherlv_27= ':' ( ( ruleIDString ) ) ) | (otherlv_29= 'message' otherlv_30= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_32_0= ruleXProperty ) ) ) )* otherlv_33= ')' ) )? )
            // InternalTmscXtext.g:1912:3: ( (lv_typeObject_0_0= ruleXDependencyTypeObject ) )? ( (lv_name_1_0= ruleIDString ) ) ( (otherlv_2= '(' ( (lv_timeBound_3_0= RULE_ABS_EBIGDECIMAL ) ) otherlv_4= ')' ) | (otherlv_5= '(' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_12= 'request' otherlv_13= ':' ( ( ruleIDString ) ) ) | (otherlv_15= 'message' otherlv_16= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_18_0= ruleXProperty ) ) ) (otherlv_19= ',' ( (otherlv_20= 'time-bound' otherlv_21= ':' ( (lv_timeBound_22_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_23= 'scheduled' otherlv_24= ':' ( (lv_scheduled_25_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_26= 'request' otherlv_27= ':' ( ( ruleIDString ) ) ) | (otherlv_29= 'message' otherlv_30= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_32_0= ruleXProperty ) ) ) )* otherlv_33= ')' ) )?
            {
            // InternalTmscXtext.g:1912:3: ( (lv_typeObject_0_0= ruleXDependencyTypeObject ) )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( ((LA42_0>=39 && LA42_0<=40)||(LA42_0>=55 && LA42_0<=58)) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // InternalTmscXtext.g:1913:4: (lv_typeObject_0_0= ruleXDependencyTypeObject )
                    {
                    // InternalTmscXtext.g:1913:4: (lv_typeObject_0_0= ruleXDependencyTypeObject )
                    // InternalTmscXtext.g:1914:5: lv_typeObject_0_0= ruleXDependencyTypeObject
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getXDependencyAccess().getTypeObjectXDependencyTypeObjectParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_11);
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

            // InternalTmscXtext.g:1931:3: ( (lv_name_1_0= ruleIDString ) )
            // InternalTmscXtext.g:1932:4: (lv_name_1_0= ruleIDString )
            {
            // InternalTmscXtext.g:1932:4: (lv_name_1_0= ruleIDString )
            // InternalTmscXtext.g:1933:5: lv_name_1_0= ruleIDString
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getXDependencyAccess().getNameIDStringParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_24);
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

            // InternalTmscXtext.g:1950:3: ( (otherlv_2= '(' ( (lv_timeBound_3_0= RULE_ABS_EBIGDECIMAL ) ) otherlv_4= ')' ) | (otherlv_5= '(' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_12= 'request' otherlv_13= ':' ( ( ruleIDString ) ) ) | (otherlv_15= 'message' otherlv_16= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_18_0= ruleXProperty ) ) ) (otherlv_19= ',' ( (otherlv_20= 'time-bound' otherlv_21= ':' ( (lv_timeBound_22_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_23= 'scheduled' otherlv_24= ':' ( (lv_scheduled_25_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_26= 'request' otherlv_27= ':' ( ( ruleIDString ) ) ) | (otherlv_29= 'message' otherlv_30= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_32_0= ruleXProperty ) ) ) )* otherlv_33= ')' ) )?
            int alt46=3;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==31) ) {
                int LA46_1 = input.LA(2);

                if ( (LA46_1==RULE_ABS_EBIGDECIMAL) ) {
                    alt46=1;
                }
                else if ( (LA46_1==RULE_ID||LA46_1==RULE_STRING||(LA46_1>=18 && LA46_1<=19)||(LA46_1>=39 && LA46_1<=40)) ) {
                    alt46=2;
                }
            }
            switch (alt46) {
                case 1 :
                    // InternalTmscXtext.g:1951:4: (otherlv_2= '(' ( (lv_timeBound_3_0= RULE_ABS_EBIGDECIMAL ) ) otherlv_4= ')' )
                    {
                    // InternalTmscXtext.g:1951:4: (otherlv_2= '(' ( (lv_timeBound_3_0= RULE_ABS_EBIGDECIMAL ) ) otherlv_4= ')' )
                    // InternalTmscXtext.g:1952:5: otherlv_2= '(' ( (lv_timeBound_3_0= RULE_ABS_EBIGDECIMAL ) ) otherlv_4= ')'
                    {
                    otherlv_2=(Token)match(input,31,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_2, grammarAccess.getXDependencyAccess().getLeftParenthesisKeyword_2_0_0());
                      				
                    }
                    // InternalTmscXtext.g:1956:5: ( (lv_timeBound_3_0= RULE_ABS_EBIGDECIMAL ) )
                    // InternalTmscXtext.g:1957:6: (lv_timeBound_3_0= RULE_ABS_EBIGDECIMAL )
                    {
                    // InternalTmscXtext.g:1957:6: (lv_timeBound_3_0= RULE_ABS_EBIGDECIMAL )
                    // InternalTmscXtext.g:1958:7: lv_timeBound_3_0= RULE_ABS_EBIGDECIMAL
                    {
                    lv_timeBound_3_0=(Token)match(input,RULE_ABS_EBIGDECIMAL,FOLLOW_32); if (state.failed) return current;
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

                    otherlv_4=(Token)match(input,32,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_4, grammarAccess.getXDependencyAccess().getRightParenthesisKeyword_2_0_2());
                      				
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalTmscXtext.g:1980:4: (otherlv_5= '(' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_12= 'request' otherlv_13= ':' ( ( ruleIDString ) ) ) | (otherlv_15= 'message' otherlv_16= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_18_0= ruleXProperty ) ) ) (otherlv_19= ',' ( (otherlv_20= 'time-bound' otherlv_21= ':' ( (lv_timeBound_22_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_23= 'scheduled' otherlv_24= ':' ( (lv_scheduled_25_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_26= 'request' otherlv_27= ':' ( ( ruleIDString ) ) ) | (otherlv_29= 'message' otherlv_30= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_32_0= ruleXProperty ) ) ) )* otherlv_33= ')' )
                    {
                    // InternalTmscXtext.g:1980:4: (otherlv_5= '(' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_12= 'request' otherlv_13= ':' ( ( ruleIDString ) ) ) | (otherlv_15= 'message' otherlv_16= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_18_0= ruleXProperty ) ) ) (otherlv_19= ',' ( (otherlv_20= 'time-bound' otherlv_21= ':' ( (lv_timeBound_22_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_23= 'scheduled' otherlv_24= ':' ( (lv_scheduled_25_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_26= 'request' otherlv_27= ':' ( ( ruleIDString ) ) ) | (otherlv_29= 'message' otherlv_30= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_32_0= ruleXProperty ) ) ) )* otherlv_33= ')' )
                    // InternalTmscXtext.g:1981:5: otherlv_5= '(' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_12= 'request' otherlv_13= ':' ( ( ruleIDString ) ) ) | (otherlv_15= 'message' otherlv_16= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_18_0= ruleXProperty ) ) ) (otherlv_19= ',' ( (otherlv_20= 'time-bound' otherlv_21= ':' ( (lv_timeBound_22_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_23= 'scheduled' otherlv_24= ':' ( (lv_scheduled_25_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_26= 'request' otherlv_27= ':' ( ( ruleIDString ) ) ) | (otherlv_29= 'message' otherlv_30= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_32_0= ruleXProperty ) ) ) )* otherlv_33= ')'
                    {
                    otherlv_5=(Token)match(input,31,FOLLOW_33); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_5, grammarAccess.getXDependencyAccess().getLeftParenthesisKeyword_2_1_0());
                      				
                    }
                    // InternalTmscXtext.g:1985:5: ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_12= 'request' otherlv_13= ':' ( ( ruleIDString ) ) ) | (otherlv_15= 'message' otherlv_16= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_18_0= ruleXProperty ) ) )
                    int alt43=5;
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
                    case 39:
                        {
                        alt43=3;
                        }
                        break;
                    case 40:
                        {
                        alt43=4;
                        }
                        break;
                    case RULE_ID:
                    case RULE_STRING:
                        {
                        alt43=5;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 43, 0, input);

                        throw nvae;
                    }

                    switch (alt43) {
                        case 1 :
                            // InternalTmscXtext.g:1986:6: (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) )
                            {
                            // InternalTmscXtext.g:1986:6: (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) )
                            // InternalTmscXtext.g:1987:7: otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) )
                            {
                            otherlv_6=(Token)match(input,18,FOLLOW_6); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(otherlv_6, grammarAccess.getXDependencyAccess().getTimeBoundKeyword_2_1_1_0_0());
                              						
                            }
                            otherlv_7=(Token)match(input,17,FOLLOW_8); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(otherlv_7, grammarAccess.getXDependencyAccess().getColonKeyword_2_1_1_0_1());
                              						
                            }
                            // InternalTmscXtext.g:1995:7: ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) )
                            // InternalTmscXtext.g:1996:8: (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL )
                            {
                            // InternalTmscXtext.g:1996:8: (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL )
                            // InternalTmscXtext.g:1997:9: lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL
                            {
                            lv_timeBound_8_0=(Token)match(input,RULE_ABS_EBIGDECIMAL,FOLLOW_22); if (state.failed) return current;
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
                            // InternalTmscXtext.g:2015:6: (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) )
                            {
                            // InternalTmscXtext.g:2015:6: (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) )
                            // InternalTmscXtext.g:2016:7: otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) )
                            {
                            otherlv_9=(Token)match(input,19,FOLLOW_6); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(otherlv_9, grammarAccess.getXDependencyAccess().getScheduledKeyword_2_1_1_1_0());
                              						
                            }
                            otherlv_10=(Token)match(input,17,FOLLOW_9); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(otherlv_10, grammarAccess.getXDependencyAccess().getColonKeyword_2_1_1_1_1());
                              						
                            }
                            // InternalTmscXtext.g:2024:7: ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) )
                            // InternalTmscXtext.g:2025:8: (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT )
                            {
                            // InternalTmscXtext.g:2025:8: (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT )
                            // InternalTmscXtext.g:2026:9: lv_scheduled_11_0= ruleEBOOLEAN_OBJECT
                            {
                            if ( state.backtracking==0 ) {

                              									newCompositeNode(grammarAccess.getXDependencyAccess().getScheduledEBOOLEAN_OBJECTParserRuleCall_2_1_1_1_2_0());
                              								
                            }
                            pushFollow(FOLLOW_22);
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
                            // InternalTmscXtext.g:2045:6: (otherlv_12= 'request' otherlv_13= ':' ( ( ruleIDString ) ) )
                            {
                            // InternalTmscXtext.g:2045:6: (otherlv_12= 'request' otherlv_13= ':' ( ( ruleIDString ) ) )
                            // InternalTmscXtext.g:2046:7: otherlv_12= 'request' otherlv_13= ':' ( ( ruleIDString ) )
                            {
                            otherlv_12=(Token)match(input,39,FOLLOW_6); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(otherlv_12, grammarAccess.getXDependencyAccess().getRequestKeyword_2_1_1_2_0());
                              						
                            }
                            otherlv_13=(Token)match(input,17,FOLLOW_11); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(otherlv_13, grammarAccess.getXDependencyAccess().getColonKeyword_2_1_1_2_1());
                              						
                            }
                            // InternalTmscXtext.g:2054:7: ( ( ruleIDString ) )
                            // InternalTmscXtext.g:2055:8: ( ruleIDString )
                            {
                            // InternalTmscXtext.g:2055:8: ( ruleIDString )
                            // InternalTmscXtext.g:2056:9: ruleIDString
                            {
                            if ( state.backtracking==0 ) {

                              									if (current==null) {
                              										current = createModelElement(grammarAccess.getXDependencyRule());
                              									}
                              								
                            }
                            if ( state.backtracking==0 ) {

                              									newCompositeNode(grammarAccess.getXDependencyAccess().getRequestXDependencyCrossReference_2_1_1_2_2_0());
                              								
                            }
                            pushFollow(FOLLOW_22);
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
                            // InternalTmscXtext.g:2072:6: (otherlv_15= 'message' otherlv_16= ':' ( ( ruleIDString ) ) )
                            {
                            // InternalTmscXtext.g:2072:6: (otherlv_15= 'message' otherlv_16= ':' ( ( ruleIDString ) ) )
                            // InternalTmscXtext.g:2073:7: otherlv_15= 'message' otherlv_16= ':' ( ( ruleIDString ) )
                            {
                            otherlv_15=(Token)match(input,40,FOLLOW_6); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(otherlv_15, grammarAccess.getXDependencyAccess().getMessageKeyword_2_1_1_3_0());
                              						
                            }
                            otherlv_16=(Token)match(input,17,FOLLOW_11); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(otherlv_16, grammarAccess.getXDependencyAccess().getColonKeyword_2_1_1_3_1());
                              						
                            }
                            // InternalTmscXtext.g:2081:7: ( ( ruleIDString ) )
                            // InternalTmscXtext.g:2082:8: ( ruleIDString )
                            {
                            // InternalTmscXtext.g:2082:8: ( ruleIDString )
                            // InternalTmscXtext.g:2083:9: ruleIDString
                            {
                            if ( state.backtracking==0 ) {

                              									if (current==null) {
                              										current = createModelElement(grammarAccess.getXDependencyRule());
                              									}
                              								
                            }
                            if ( state.backtracking==0 ) {

                              									newCompositeNode(grammarAccess.getXDependencyAccess().getMessageXDependencyCrossReference_2_1_1_3_2_0());
                              								
                            }
                            pushFollow(FOLLOW_22);
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
                            // InternalTmscXtext.g:2099:6: ( (lv_properties_18_0= ruleXProperty ) )
                            {
                            // InternalTmscXtext.g:2099:6: ( (lv_properties_18_0= ruleXProperty ) )
                            // InternalTmscXtext.g:2100:7: (lv_properties_18_0= ruleXProperty )
                            {
                            // InternalTmscXtext.g:2100:7: (lv_properties_18_0= ruleXProperty )
                            // InternalTmscXtext.g:2101:8: lv_properties_18_0= ruleXProperty
                            {
                            if ( state.backtracking==0 ) {

                              								newCompositeNode(grammarAccess.getXDependencyAccess().getPropertiesXPropertyParserRuleCall_2_1_1_4_0());
                              							
                            }
                            pushFollow(FOLLOW_22);
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

                    // InternalTmscXtext.g:2119:5: (otherlv_19= ',' ( (otherlv_20= 'time-bound' otherlv_21= ':' ( (lv_timeBound_22_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_23= 'scheduled' otherlv_24= ':' ( (lv_scheduled_25_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_26= 'request' otherlv_27= ':' ( ( ruleIDString ) ) ) | (otherlv_29= 'message' otherlv_30= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_32_0= ruleXProperty ) ) ) )*
                    loop45:
                    do {
                        int alt45=2;
                        int LA45_0 = input.LA(1);

                        if ( (LA45_0==26) ) {
                            alt45=1;
                        }


                        switch (alt45) {
                    	case 1 :
                    	    // InternalTmscXtext.g:2120:6: otherlv_19= ',' ( (otherlv_20= 'time-bound' otherlv_21= ':' ( (lv_timeBound_22_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_23= 'scheduled' otherlv_24= ':' ( (lv_scheduled_25_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_26= 'request' otherlv_27= ':' ( ( ruleIDString ) ) ) | (otherlv_29= 'message' otherlv_30= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_32_0= ruleXProperty ) ) )
                    	    {
                    	    otherlv_19=(Token)match(input,26,FOLLOW_33); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_19, grammarAccess.getXDependencyAccess().getCommaKeyword_2_1_2_0());
                    	      					
                    	    }
                    	    // InternalTmscXtext.g:2124:6: ( (otherlv_20= 'time-bound' otherlv_21= ':' ( (lv_timeBound_22_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_23= 'scheduled' otherlv_24= ':' ( (lv_scheduled_25_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_26= 'request' otherlv_27= ':' ( ( ruleIDString ) ) ) | (otherlv_29= 'message' otherlv_30= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_32_0= ruleXProperty ) ) )
                    	    int alt44=5;
                    	    switch ( input.LA(1) ) {
                    	    case 18:
                    	        {
                    	        alt44=1;
                    	        }
                    	        break;
                    	    case 19:
                    	        {
                    	        alt44=2;
                    	        }
                    	        break;
                    	    case 39:
                    	        {
                    	        alt44=3;
                    	        }
                    	        break;
                    	    case 40:
                    	        {
                    	        alt44=4;
                    	        }
                    	        break;
                    	    case RULE_ID:
                    	    case RULE_STRING:
                    	        {
                    	        alt44=5;
                    	        }
                    	        break;
                    	    default:
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        NoViableAltException nvae =
                    	            new NoViableAltException("", 44, 0, input);

                    	        throw nvae;
                    	    }

                    	    switch (alt44) {
                    	        case 1 :
                    	            // InternalTmscXtext.g:2125:7: (otherlv_20= 'time-bound' otherlv_21= ':' ( (lv_timeBound_22_0= RULE_ABS_EBIGDECIMAL ) ) )
                    	            {
                    	            // InternalTmscXtext.g:2125:7: (otherlv_20= 'time-bound' otherlv_21= ':' ( (lv_timeBound_22_0= RULE_ABS_EBIGDECIMAL ) ) )
                    	            // InternalTmscXtext.g:2126:8: otherlv_20= 'time-bound' otherlv_21= ':' ( (lv_timeBound_22_0= RULE_ABS_EBIGDECIMAL ) )
                    	            {
                    	            otherlv_20=(Token)match(input,18,FOLLOW_6); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              								newLeafNode(otherlv_20, grammarAccess.getXDependencyAccess().getTimeBoundKeyword_2_1_2_1_0_0());
                    	              							
                    	            }
                    	            otherlv_21=(Token)match(input,17,FOLLOW_8); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              								newLeafNode(otherlv_21, grammarAccess.getXDependencyAccess().getColonKeyword_2_1_2_1_0_1());
                    	              							
                    	            }
                    	            // InternalTmscXtext.g:2134:8: ( (lv_timeBound_22_0= RULE_ABS_EBIGDECIMAL ) )
                    	            // InternalTmscXtext.g:2135:9: (lv_timeBound_22_0= RULE_ABS_EBIGDECIMAL )
                    	            {
                    	            // InternalTmscXtext.g:2135:9: (lv_timeBound_22_0= RULE_ABS_EBIGDECIMAL )
                    	            // InternalTmscXtext.g:2136:10: lv_timeBound_22_0= RULE_ABS_EBIGDECIMAL
                    	            {
                    	            lv_timeBound_22_0=(Token)match(input,RULE_ABS_EBIGDECIMAL,FOLLOW_22); if (state.failed) return current;
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
                    	            // InternalTmscXtext.g:2154:7: (otherlv_23= 'scheduled' otherlv_24= ':' ( (lv_scheduled_25_0= ruleEBOOLEAN_OBJECT ) ) )
                    	            {
                    	            // InternalTmscXtext.g:2154:7: (otherlv_23= 'scheduled' otherlv_24= ':' ( (lv_scheduled_25_0= ruleEBOOLEAN_OBJECT ) ) )
                    	            // InternalTmscXtext.g:2155:8: otherlv_23= 'scheduled' otherlv_24= ':' ( (lv_scheduled_25_0= ruleEBOOLEAN_OBJECT ) )
                    	            {
                    	            otherlv_23=(Token)match(input,19,FOLLOW_6); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              								newLeafNode(otherlv_23, grammarAccess.getXDependencyAccess().getScheduledKeyword_2_1_2_1_1_0());
                    	              							
                    	            }
                    	            otherlv_24=(Token)match(input,17,FOLLOW_9); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              								newLeafNode(otherlv_24, grammarAccess.getXDependencyAccess().getColonKeyword_2_1_2_1_1_1());
                    	              							
                    	            }
                    	            // InternalTmscXtext.g:2163:8: ( (lv_scheduled_25_0= ruleEBOOLEAN_OBJECT ) )
                    	            // InternalTmscXtext.g:2164:9: (lv_scheduled_25_0= ruleEBOOLEAN_OBJECT )
                    	            {
                    	            // InternalTmscXtext.g:2164:9: (lv_scheduled_25_0= ruleEBOOLEAN_OBJECT )
                    	            // InternalTmscXtext.g:2165:10: lv_scheduled_25_0= ruleEBOOLEAN_OBJECT
                    	            {
                    	            if ( state.backtracking==0 ) {

                    	              										newCompositeNode(grammarAccess.getXDependencyAccess().getScheduledEBOOLEAN_OBJECTParserRuleCall_2_1_2_1_1_2_0());
                    	              									
                    	            }
                    	            pushFollow(FOLLOW_22);
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
                    	            // InternalTmscXtext.g:2184:7: (otherlv_26= 'request' otherlv_27= ':' ( ( ruleIDString ) ) )
                    	            {
                    	            // InternalTmscXtext.g:2184:7: (otherlv_26= 'request' otherlv_27= ':' ( ( ruleIDString ) ) )
                    	            // InternalTmscXtext.g:2185:8: otherlv_26= 'request' otherlv_27= ':' ( ( ruleIDString ) )
                    	            {
                    	            otherlv_26=(Token)match(input,39,FOLLOW_6); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              								newLeafNode(otherlv_26, grammarAccess.getXDependencyAccess().getRequestKeyword_2_1_2_1_2_0());
                    	              							
                    	            }
                    	            otherlv_27=(Token)match(input,17,FOLLOW_11); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              								newLeafNode(otherlv_27, grammarAccess.getXDependencyAccess().getColonKeyword_2_1_2_1_2_1());
                    	              							
                    	            }
                    	            // InternalTmscXtext.g:2193:8: ( ( ruleIDString ) )
                    	            // InternalTmscXtext.g:2194:9: ( ruleIDString )
                    	            {
                    	            // InternalTmscXtext.g:2194:9: ( ruleIDString )
                    	            // InternalTmscXtext.g:2195:10: ruleIDString
                    	            {
                    	            if ( state.backtracking==0 ) {

                    	              										if (current==null) {
                    	              											current = createModelElement(grammarAccess.getXDependencyRule());
                    	              										}
                    	              									
                    	            }
                    	            if ( state.backtracking==0 ) {

                    	              										newCompositeNode(grammarAccess.getXDependencyAccess().getRequestXDependencyCrossReference_2_1_2_1_2_2_0());
                    	              									
                    	            }
                    	            pushFollow(FOLLOW_22);
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
                    	            // InternalTmscXtext.g:2211:7: (otherlv_29= 'message' otherlv_30= ':' ( ( ruleIDString ) ) )
                    	            {
                    	            // InternalTmscXtext.g:2211:7: (otherlv_29= 'message' otherlv_30= ':' ( ( ruleIDString ) ) )
                    	            // InternalTmscXtext.g:2212:8: otherlv_29= 'message' otherlv_30= ':' ( ( ruleIDString ) )
                    	            {
                    	            otherlv_29=(Token)match(input,40,FOLLOW_6); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              								newLeafNode(otherlv_29, grammarAccess.getXDependencyAccess().getMessageKeyword_2_1_2_1_3_0());
                    	              							
                    	            }
                    	            otherlv_30=(Token)match(input,17,FOLLOW_11); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              								newLeafNode(otherlv_30, grammarAccess.getXDependencyAccess().getColonKeyword_2_1_2_1_3_1());
                    	              							
                    	            }
                    	            // InternalTmscXtext.g:2220:8: ( ( ruleIDString ) )
                    	            // InternalTmscXtext.g:2221:9: ( ruleIDString )
                    	            {
                    	            // InternalTmscXtext.g:2221:9: ( ruleIDString )
                    	            // InternalTmscXtext.g:2222:10: ruleIDString
                    	            {
                    	            if ( state.backtracking==0 ) {

                    	              										if (current==null) {
                    	              											current = createModelElement(grammarAccess.getXDependencyRule());
                    	              										}
                    	              									
                    	            }
                    	            if ( state.backtracking==0 ) {

                    	              										newCompositeNode(grammarAccess.getXDependencyAccess().getMessageXDependencyCrossReference_2_1_2_1_3_2_0());
                    	              									
                    	            }
                    	            pushFollow(FOLLOW_22);
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
                    	            // InternalTmscXtext.g:2238:7: ( (lv_properties_32_0= ruleXProperty ) )
                    	            {
                    	            // InternalTmscXtext.g:2238:7: ( (lv_properties_32_0= ruleXProperty ) )
                    	            // InternalTmscXtext.g:2239:8: (lv_properties_32_0= ruleXProperty )
                    	            {
                    	            // InternalTmscXtext.g:2239:8: (lv_properties_32_0= ruleXProperty )
                    	            // InternalTmscXtext.g:2240:9: lv_properties_32_0= ruleXProperty
                    	            {
                    	            if ( state.backtracking==0 ) {

                    	              									newCompositeNode(grammarAccess.getXDependencyAccess().getPropertiesXPropertyParserRuleCall_2_1_2_1_4_0());
                    	              								
                    	            }
                    	            pushFollow(FOLLOW_22);
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
                    	    break loop45;
                        }
                    } while (true);

                    otherlv_33=(Token)match(input,32,FOLLOW_2); if (state.failed) return current;
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
    // InternalTmscXtext.g:2269:1: entryRuleXDependencyTypeObject returns [EObject current=null] : iv_ruleXDependencyTypeObject= ruleXDependencyTypeObject EOF ;
    public final EObject entryRuleXDependencyTypeObject() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXDependencyTypeObject = null;


        try {
            // InternalTmscXtext.g:2269:62: (iv_ruleXDependencyTypeObject= ruleXDependencyTypeObject EOF )
            // InternalTmscXtext.g:2270:2: iv_ruleXDependencyTypeObject= ruleXDependencyTypeObject EOF
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
    // InternalTmscXtext.g:2276:1: ruleXDependencyTypeObject returns [EObject current=null] : ( (lv_value_0_0= ruleXDependencyType ) ) ;
    public final EObject ruleXDependencyTypeObject() throws RecognitionException {
        EObject current = null;

        Enumerator lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalTmscXtext.g:2282:2: ( ( (lv_value_0_0= ruleXDependencyType ) ) )
            // InternalTmscXtext.g:2283:2: ( (lv_value_0_0= ruleXDependencyType ) )
            {
            // InternalTmscXtext.g:2283:2: ( (lv_value_0_0= ruleXDependencyType ) )
            // InternalTmscXtext.g:2284:3: (lv_value_0_0= ruleXDependencyType )
            {
            // InternalTmscXtext.g:2284:3: (lv_value_0_0= ruleXDependencyType )
            // InternalTmscXtext.g:2285:4: lv_value_0_0= ruleXDependencyType
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
    // InternalTmscXtext.g:2305:1: entryRuleXDependencySettings returns [EObject current=null] : iv_ruleXDependencySettings= ruleXDependencySettings EOF ;
    public final EObject entryRuleXDependencySettings() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXDependencySettings = null;


        try {
            // InternalTmscXtext.g:2305:60: (iv_ruleXDependencySettings= ruleXDependencySettings EOF )
            // InternalTmscXtext.g:2306:2: iv_ruleXDependencySettings= ruleXDependencySettings EOF
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
    // InternalTmscXtext.g:2312:1: ruleXDependencySettings returns [EObject current=null] : ( ( (lv_type_0_0= ruleXDependencyType ) ) otherlv_1= 'settings' otherlv_2= '{' ( (otherlv_3= 'time-bound' otherlv_4= ':' ( (lv_timeBound_5_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_6= 'scheduled' otherlv_7= ':' ( (lv_scheduled_8_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_9= 'prefix' otherlv_10= ':' ( (lv_prefix_11_0= ruleIDString ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) )* otherlv_13= '}' ) ;
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
            // InternalTmscXtext.g:2318:2: ( ( ( (lv_type_0_0= ruleXDependencyType ) ) otherlv_1= 'settings' otherlv_2= '{' ( (otherlv_3= 'time-bound' otherlv_4= ':' ( (lv_timeBound_5_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_6= 'scheduled' otherlv_7= ':' ( (lv_scheduled_8_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_9= 'prefix' otherlv_10= ':' ( (lv_prefix_11_0= ruleIDString ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) )* otherlv_13= '}' ) )
            // InternalTmscXtext.g:2319:2: ( ( (lv_type_0_0= ruleXDependencyType ) ) otherlv_1= 'settings' otherlv_2= '{' ( (otherlv_3= 'time-bound' otherlv_4= ':' ( (lv_timeBound_5_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_6= 'scheduled' otherlv_7= ':' ( (lv_scheduled_8_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_9= 'prefix' otherlv_10= ':' ( (lv_prefix_11_0= ruleIDString ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) )* otherlv_13= '}' )
            {
            // InternalTmscXtext.g:2319:2: ( ( (lv_type_0_0= ruleXDependencyType ) ) otherlv_1= 'settings' otherlv_2= '{' ( (otherlv_3= 'time-bound' otherlv_4= ':' ( (lv_timeBound_5_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_6= 'scheduled' otherlv_7= ':' ( (lv_scheduled_8_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_9= 'prefix' otherlv_10= ':' ( (lv_prefix_11_0= ruleIDString ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) )* otherlv_13= '}' )
            // InternalTmscXtext.g:2320:3: ( (lv_type_0_0= ruleXDependencyType ) ) otherlv_1= 'settings' otherlv_2= '{' ( (otherlv_3= 'time-bound' otherlv_4= ':' ( (lv_timeBound_5_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_6= 'scheduled' otherlv_7= ':' ( (lv_scheduled_8_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_9= 'prefix' otherlv_10= ':' ( (lv_prefix_11_0= ruleIDString ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) )* otherlv_13= '}'
            {
            // InternalTmscXtext.g:2320:3: ( (lv_type_0_0= ruleXDependencyType ) )
            // InternalTmscXtext.g:2321:4: (lv_type_0_0= ruleXDependencyType )
            {
            // InternalTmscXtext.g:2321:4: (lv_type_0_0= ruleXDependencyType )
            // InternalTmscXtext.g:2322:5: lv_type_0_0= ruleXDependencyType
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
            otherlv_2=(Token)match(input,15,FOLLOW_34); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getXDependencySettingsAccess().getLeftCurlyBracketKeyword_2());
              		
            }
            // InternalTmscXtext.g:2347:3: ( (otherlv_3= 'time-bound' otherlv_4= ':' ( (lv_timeBound_5_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_6= 'scheduled' otherlv_7= ':' ( (lv_scheduled_8_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_9= 'prefix' otherlv_10= ':' ( (lv_prefix_11_0= ruleIDString ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) )*
            loop47:
            do {
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
                case 41:
                    {
                    alt47=3;
                    }
                    break;
                case RULE_ID:
                case RULE_STRING:
                    {
                    alt47=4;
                    }
                    break;

                }

                switch (alt47) {
            	case 1 :
            	    // InternalTmscXtext.g:2348:4: (otherlv_3= 'time-bound' otherlv_4= ':' ( (lv_timeBound_5_0= RULE_ABS_EBIGDECIMAL ) ) )
            	    {
            	    // InternalTmscXtext.g:2348:4: (otherlv_3= 'time-bound' otherlv_4= ':' ( (lv_timeBound_5_0= RULE_ABS_EBIGDECIMAL ) ) )
            	    // InternalTmscXtext.g:2349:5: otherlv_3= 'time-bound' otherlv_4= ':' ( (lv_timeBound_5_0= RULE_ABS_EBIGDECIMAL ) )
            	    {
            	    otherlv_3=(Token)match(input,18,FOLLOW_6); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_3, grammarAccess.getXDependencySettingsAccess().getTimeBoundKeyword_3_0_0());
            	      				
            	    }
            	    otherlv_4=(Token)match(input,17,FOLLOW_8); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_4, grammarAccess.getXDependencySettingsAccess().getColonKeyword_3_0_1());
            	      				
            	    }
            	    // InternalTmscXtext.g:2357:5: ( (lv_timeBound_5_0= RULE_ABS_EBIGDECIMAL ) )
            	    // InternalTmscXtext.g:2358:6: (lv_timeBound_5_0= RULE_ABS_EBIGDECIMAL )
            	    {
            	    // InternalTmscXtext.g:2358:6: (lv_timeBound_5_0= RULE_ABS_EBIGDECIMAL )
            	    // InternalTmscXtext.g:2359:7: lv_timeBound_5_0= RULE_ABS_EBIGDECIMAL
            	    {
            	    lv_timeBound_5_0=(Token)match(input,RULE_ABS_EBIGDECIMAL,FOLLOW_34); if (state.failed) return current;
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
            	    // InternalTmscXtext.g:2377:4: (otherlv_6= 'scheduled' otherlv_7= ':' ( (lv_scheduled_8_0= ruleEBOOLEAN_OBJECT ) ) )
            	    {
            	    // InternalTmscXtext.g:2377:4: (otherlv_6= 'scheduled' otherlv_7= ':' ( (lv_scheduled_8_0= ruleEBOOLEAN_OBJECT ) ) )
            	    // InternalTmscXtext.g:2378:5: otherlv_6= 'scheduled' otherlv_7= ':' ( (lv_scheduled_8_0= ruleEBOOLEAN_OBJECT ) )
            	    {
            	    otherlv_6=(Token)match(input,19,FOLLOW_6); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_6, grammarAccess.getXDependencySettingsAccess().getScheduledKeyword_3_1_0());
            	      				
            	    }
            	    otherlv_7=(Token)match(input,17,FOLLOW_9); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_7, grammarAccess.getXDependencySettingsAccess().getColonKeyword_3_1_1());
            	      				
            	    }
            	    // InternalTmscXtext.g:2386:5: ( (lv_scheduled_8_0= ruleEBOOLEAN_OBJECT ) )
            	    // InternalTmscXtext.g:2387:6: (lv_scheduled_8_0= ruleEBOOLEAN_OBJECT )
            	    {
            	    // InternalTmscXtext.g:2387:6: (lv_scheduled_8_0= ruleEBOOLEAN_OBJECT )
            	    // InternalTmscXtext.g:2388:7: lv_scheduled_8_0= ruleEBOOLEAN_OBJECT
            	    {
            	    if ( state.backtracking==0 ) {

            	      							newCompositeNode(grammarAccess.getXDependencySettingsAccess().getScheduledEBOOLEAN_OBJECTParserRuleCall_3_1_2_0());
            	      						
            	    }
            	    pushFollow(FOLLOW_34);
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
            	    // InternalTmscXtext.g:2407:4: (otherlv_9= 'prefix' otherlv_10= ':' ( (lv_prefix_11_0= ruleIDString ) ) )
            	    {
            	    // InternalTmscXtext.g:2407:4: (otherlv_9= 'prefix' otherlv_10= ':' ( (lv_prefix_11_0= ruleIDString ) ) )
            	    // InternalTmscXtext.g:2408:5: otherlv_9= 'prefix' otherlv_10= ':' ( (lv_prefix_11_0= ruleIDString ) )
            	    {
            	    otherlv_9=(Token)match(input,41,FOLLOW_6); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_9, grammarAccess.getXDependencySettingsAccess().getPrefixKeyword_3_2_0());
            	      				
            	    }
            	    otherlv_10=(Token)match(input,17,FOLLOW_11); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_10, grammarAccess.getXDependencySettingsAccess().getColonKeyword_3_2_1());
            	      				
            	    }
            	    // InternalTmscXtext.g:2416:5: ( (lv_prefix_11_0= ruleIDString ) )
            	    // InternalTmscXtext.g:2417:6: (lv_prefix_11_0= ruleIDString )
            	    {
            	    // InternalTmscXtext.g:2417:6: (lv_prefix_11_0= ruleIDString )
            	    // InternalTmscXtext.g:2418:7: lv_prefix_11_0= ruleIDString
            	    {
            	    if ( state.backtracking==0 ) {

            	      							newCompositeNode(grammarAccess.getXDependencySettingsAccess().getPrefixIDStringParserRuleCall_3_2_2_0());
            	      						
            	    }
            	    pushFollow(FOLLOW_34);
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
            	    // InternalTmscXtext.g:2437:4: ( (lv_properties_12_0= ruleXProperty ) )
            	    {
            	    // InternalTmscXtext.g:2437:4: ( (lv_properties_12_0= ruleXProperty ) )
            	    // InternalTmscXtext.g:2438:5: (lv_properties_12_0= ruleXProperty )
            	    {
            	    // InternalTmscXtext.g:2438:5: (lv_properties_12_0= ruleXProperty )
            	    // InternalTmscXtext.g:2439:6: lv_properties_12_0= ruleXProperty
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getXDependencySettingsAccess().getPropertiesXPropertyParserRuleCall_3_3_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_34);
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
            	    break loop47;
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
    // InternalTmscXtext.g:2465:1: entryRuleXProperty returns [EObject current=null] : iv_ruleXProperty= ruleXProperty EOF ;
    public final EObject entryRuleXProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXProperty = null;


        try {
            // InternalTmscXtext.g:2465:50: (iv_ruleXProperty= ruleXProperty EOF )
            // InternalTmscXtext.g:2466:2: iv_ruleXProperty= ruleXProperty EOF
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
    // InternalTmscXtext.g:2472:1: ruleXProperty returns [EObject current=null] : ( ( (lv_name_0_0= ruleIDString ) ) otherlv_1= ':' ( (lv_value_2_0= ruleXPropertyValue ) ) ) ;
    public final EObject ruleXProperty() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalTmscXtext.g:2478:2: ( ( ( (lv_name_0_0= ruleIDString ) ) otherlv_1= ':' ( (lv_value_2_0= ruleXPropertyValue ) ) ) )
            // InternalTmscXtext.g:2479:2: ( ( (lv_name_0_0= ruleIDString ) ) otherlv_1= ':' ( (lv_value_2_0= ruleXPropertyValue ) ) )
            {
            // InternalTmscXtext.g:2479:2: ( ( (lv_name_0_0= ruleIDString ) ) otherlv_1= ':' ( (lv_value_2_0= ruleXPropertyValue ) ) )
            // InternalTmscXtext.g:2480:3: ( (lv_name_0_0= ruleIDString ) ) otherlv_1= ':' ( (lv_value_2_0= ruleXPropertyValue ) )
            {
            // InternalTmscXtext.g:2480:3: ( (lv_name_0_0= ruleIDString ) )
            // InternalTmscXtext.g:2481:4: (lv_name_0_0= ruleIDString )
            {
            // InternalTmscXtext.g:2481:4: (lv_name_0_0= ruleIDString )
            // InternalTmscXtext.g:2482:5: lv_name_0_0= ruleIDString
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

            otherlv_1=(Token)match(input,17,FOLLOW_35); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getXPropertyAccess().getColonKeyword_1());
              		
            }
            // InternalTmscXtext.g:2503:3: ( (lv_value_2_0= ruleXPropertyValue ) )
            // InternalTmscXtext.g:2504:4: (lv_value_2_0= ruleXPropertyValue )
            {
            // InternalTmscXtext.g:2504:4: (lv_value_2_0= ruleXPropertyValue )
            // InternalTmscXtext.g:2505:5: lv_value_2_0= ruleXPropertyValue
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
    // InternalTmscXtext.g:2526:1: entryRuleXPropertyValue returns [EObject current=null] : iv_ruleXPropertyValue= ruleXPropertyValue EOF ;
    public final EObject entryRuleXPropertyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXPropertyValue = null;


        try {
            // InternalTmscXtext.g:2526:55: (iv_ruleXPropertyValue= ruleXPropertyValue EOF )
            // InternalTmscXtext.g:2527:2: iv_ruleXPropertyValue= ruleXPropertyValue EOF
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
    // InternalTmscXtext.g:2533:1: ruleXPropertyValue returns [EObject current=null] : ( ( () ( ( ( ruleIDString ) )=> (lv_value_1_0= ruleIDString ) ) ) | ( () ( ( ( ruleEBIGDECIMAL ) )=> (lv_value_3_0= ruleEBIGDECIMAL ) ) ) | ( () ( ( ( ruleEBOOLEAN_OBJECT ) )=> (lv_value_5_0= ruleEBOOLEAN_OBJECT ) ) ) | ( () ( ( '[' )=>otherlv_7= '[' ) ( (lv_values_8_0= ruleXPropertyValue ) ) (otherlv_9= ',' ( (lv_values_10_0= ruleXPropertyValue ) ) )* otherlv_11= ']' ) ) ;
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
            // InternalTmscXtext.g:2539:2: ( ( ( () ( ( ( ruleIDString ) )=> (lv_value_1_0= ruleIDString ) ) ) | ( () ( ( ( ruleEBIGDECIMAL ) )=> (lv_value_3_0= ruleEBIGDECIMAL ) ) ) | ( () ( ( ( ruleEBOOLEAN_OBJECT ) )=> (lv_value_5_0= ruleEBOOLEAN_OBJECT ) ) ) | ( () ( ( '[' )=>otherlv_7= '[' ) ( (lv_values_8_0= ruleXPropertyValue ) ) (otherlv_9= ',' ( (lv_values_10_0= ruleXPropertyValue ) ) )* otherlv_11= ']' ) ) )
            // InternalTmscXtext.g:2540:2: ( ( () ( ( ( ruleIDString ) )=> (lv_value_1_0= ruleIDString ) ) ) | ( () ( ( ( ruleEBIGDECIMAL ) )=> (lv_value_3_0= ruleEBIGDECIMAL ) ) ) | ( () ( ( ( ruleEBOOLEAN_OBJECT ) )=> (lv_value_5_0= ruleEBOOLEAN_OBJECT ) ) ) | ( () ( ( '[' )=>otherlv_7= '[' ) ( (lv_values_8_0= ruleXPropertyValue ) ) (otherlv_9= ',' ( (lv_values_10_0= ruleXPropertyValue ) ) )* otherlv_11= ']' ) )
            {
            // InternalTmscXtext.g:2540:2: ( ( () ( ( ( ruleIDString ) )=> (lv_value_1_0= ruleIDString ) ) ) | ( () ( ( ( ruleEBIGDECIMAL ) )=> (lv_value_3_0= ruleEBIGDECIMAL ) ) ) | ( () ( ( ( ruleEBOOLEAN_OBJECT ) )=> (lv_value_5_0= ruleEBOOLEAN_OBJECT ) ) ) | ( () ( ( '[' )=>otherlv_7= '[' ) ( (lv_values_8_0= ruleXPropertyValue ) ) (otherlv_9= ',' ( (lv_values_10_0= ruleXPropertyValue ) ) )* otherlv_11= ']' ) )
            int alt49=4;
            switch ( input.LA(1) ) {
            case RULE_ID:
            case RULE_STRING:
                {
                alt49=1;
                }
                break;
            case RULE_ABS_EBIGDECIMAL:
            case RULE_POS_EBIGDECIMAL:
            case RULE_NEG_EBIGDECIMAL:
                {
                alt49=2;
                }
                break;
            case 45:
            case 46:
                {
                alt49=3;
                }
                break;
            case 42:
                {
                alt49=4;
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
                    // InternalTmscXtext.g:2541:3: ( () ( ( ( ruleIDString ) )=> (lv_value_1_0= ruleIDString ) ) )
                    {
                    // InternalTmscXtext.g:2541:3: ( () ( ( ( ruleIDString ) )=> (lv_value_1_0= ruleIDString ) ) )
                    // InternalTmscXtext.g:2542:4: () ( ( ( ruleIDString ) )=> (lv_value_1_0= ruleIDString ) )
                    {
                    // InternalTmscXtext.g:2542:4: ()
                    // InternalTmscXtext.g:2543:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getXPropertyValueAccess().getXPropertyStringValueAction_0_0(),
                      						current);
                      				
                    }

                    }

                    // InternalTmscXtext.g:2549:4: ( ( ( ruleIDString ) )=> (lv_value_1_0= ruleIDString ) )
                    // InternalTmscXtext.g:2550:5: ( ( ruleIDString ) )=> (lv_value_1_0= ruleIDString )
                    {
                    // InternalTmscXtext.g:2554:5: (lv_value_1_0= ruleIDString )
                    // InternalTmscXtext.g:2555:6: lv_value_1_0= ruleIDString
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
                    // InternalTmscXtext.g:2574:3: ( () ( ( ( ruleEBIGDECIMAL ) )=> (lv_value_3_0= ruleEBIGDECIMAL ) ) )
                    {
                    // InternalTmscXtext.g:2574:3: ( () ( ( ( ruleEBIGDECIMAL ) )=> (lv_value_3_0= ruleEBIGDECIMAL ) ) )
                    // InternalTmscXtext.g:2575:4: () ( ( ( ruleEBIGDECIMAL ) )=> (lv_value_3_0= ruleEBIGDECIMAL ) )
                    {
                    // InternalTmscXtext.g:2575:4: ()
                    // InternalTmscXtext.g:2576:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getXPropertyValueAccess().getXPropertyNumberValueAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalTmscXtext.g:2582:4: ( ( ( ruleEBIGDECIMAL ) )=> (lv_value_3_0= ruleEBIGDECIMAL ) )
                    // InternalTmscXtext.g:2583:5: ( ( ruleEBIGDECIMAL ) )=> (lv_value_3_0= ruleEBIGDECIMAL )
                    {
                    // InternalTmscXtext.g:2587:5: (lv_value_3_0= ruleEBIGDECIMAL )
                    // InternalTmscXtext.g:2588:6: lv_value_3_0= ruleEBIGDECIMAL
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
                    // InternalTmscXtext.g:2607:3: ( () ( ( ( ruleEBOOLEAN_OBJECT ) )=> (lv_value_5_0= ruleEBOOLEAN_OBJECT ) ) )
                    {
                    // InternalTmscXtext.g:2607:3: ( () ( ( ( ruleEBOOLEAN_OBJECT ) )=> (lv_value_5_0= ruleEBOOLEAN_OBJECT ) ) )
                    // InternalTmscXtext.g:2608:4: () ( ( ( ruleEBOOLEAN_OBJECT ) )=> (lv_value_5_0= ruleEBOOLEAN_OBJECT ) )
                    {
                    // InternalTmscXtext.g:2608:4: ()
                    // InternalTmscXtext.g:2609:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getXPropertyValueAccess().getXPropertyBooleanValueAction_2_0(),
                      						current);
                      				
                    }

                    }

                    // InternalTmscXtext.g:2615:4: ( ( ( ruleEBOOLEAN_OBJECT ) )=> (lv_value_5_0= ruleEBOOLEAN_OBJECT ) )
                    // InternalTmscXtext.g:2616:5: ( ( ruleEBOOLEAN_OBJECT ) )=> (lv_value_5_0= ruleEBOOLEAN_OBJECT )
                    {
                    // InternalTmscXtext.g:2620:5: (lv_value_5_0= ruleEBOOLEAN_OBJECT )
                    // InternalTmscXtext.g:2621:6: lv_value_5_0= ruleEBOOLEAN_OBJECT
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
                    // InternalTmscXtext.g:2640:3: ( () ( ( '[' )=>otherlv_7= '[' ) ( (lv_values_8_0= ruleXPropertyValue ) ) (otherlv_9= ',' ( (lv_values_10_0= ruleXPropertyValue ) ) )* otherlv_11= ']' )
                    {
                    // InternalTmscXtext.g:2640:3: ( () ( ( '[' )=>otherlv_7= '[' ) ( (lv_values_8_0= ruleXPropertyValue ) ) (otherlv_9= ',' ( (lv_values_10_0= ruleXPropertyValue ) ) )* otherlv_11= ']' )
                    // InternalTmscXtext.g:2641:4: () ( ( '[' )=>otherlv_7= '[' ) ( (lv_values_8_0= ruleXPropertyValue ) ) (otherlv_9= ',' ( (lv_values_10_0= ruleXPropertyValue ) ) )* otherlv_11= ']'
                    {
                    // InternalTmscXtext.g:2641:4: ()
                    // InternalTmscXtext.g:2642:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getXPropertyValueAccess().getXPropertyMutliValueAction_3_0(),
                      						current);
                      				
                    }

                    }

                    // InternalTmscXtext.g:2648:4: ( ( '[' )=>otherlv_7= '[' )
                    // InternalTmscXtext.g:2649:5: ( '[' )=>otherlv_7= '['
                    {
                    otherlv_7=(Token)match(input,42,FOLLOW_35); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_7, grammarAccess.getXPropertyValueAccess().getLeftSquareBracketKeyword_3_1());
                      				
                    }

                    }

                    // InternalTmscXtext.g:2655:4: ( (lv_values_8_0= ruleXPropertyValue ) )
                    // InternalTmscXtext.g:2656:5: (lv_values_8_0= ruleXPropertyValue )
                    {
                    // InternalTmscXtext.g:2656:5: (lv_values_8_0= ruleXPropertyValue )
                    // InternalTmscXtext.g:2657:6: lv_values_8_0= ruleXPropertyValue
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getXPropertyValueAccess().getValuesXPropertyValueParserRuleCall_3_2_0());
                      					
                    }
                    pushFollow(FOLLOW_36);
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

                    // InternalTmscXtext.g:2674:4: (otherlv_9= ',' ( (lv_values_10_0= ruleXPropertyValue ) ) )*
                    loop48:
                    do {
                        int alt48=2;
                        int LA48_0 = input.LA(1);

                        if ( (LA48_0==26) ) {
                            alt48=1;
                        }


                        switch (alt48) {
                    	case 1 :
                    	    // InternalTmscXtext.g:2675:5: otherlv_9= ',' ( (lv_values_10_0= ruleXPropertyValue ) )
                    	    {
                    	    otherlv_9=(Token)match(input,26,FOLLOW_35); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_9, grammarAccess.getXPropertyValueAccess().getCommaKeyword_3_3_0());
                    	      				
                    	    }
                    	    // InternalTmscXtext.g:2679:5: ( (lv_values_10_0= ruleXPropertyValue ) )
                    	    // InternalTmscXtext.g:2680:6: (lv_values_10_0= ruleXPropertyValue )
                    	    {
                    	    // InternalTmscXtext.g:2680:6: (lv_values_10_0= ruleXPropertyValue )
                    	    // InternalTmscXtext.g:2681:7: lv_values_10_0= ruleXPropertyValue
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getXPropertyValueAccess().getValuesXPropertyValueParserRuleCall_3_3_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_36);
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
                    	    break loop48;
                        }
                    } while (true);

                    otherlv_11=(Token)match(input,43,FOLLOW_2); if (state.failed) return current;
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
    // InternalTmscXtext.g:2708:1: entryRuleFQNString returns [String current=null] : iv_ruleFQNString= ruleFQNString EOF ;
    public final String entryRuleFQNString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQNString = null;


        try {
            // InternalTmscXtext.g:2708:49: (iv_ruleFQNString= ruleFQNString EOF )
            // InternalTmscXtext.g:2709:2: iv_ruleFQNString= ruleFQNString EOF
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
    // InternalTmscXtext.g:2715:1: ruleFQNString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_FQN_0= ruleFQN | this_STRING_1= RULE_STRING ) ;
    public final AntlrDatatypeRuleToken ruleFQNString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_1=null;
        AntlrDatatypeRuleToken this_FQN_0 = null;



        	enterRule();

        try {
            // InternalTmscXtext.g:2721:2: ( (this_FQN_0= ruleFQN | this_STRING_1= RULE_STRING ) )
            // InternalTmscXtext.g:2722:2: (this_FQN_0= ruleFQN | this_STRING_1= RULE_STRING )
            {
            // InternalTmscXtext.g:2722:2: (this_FQN_0= ruleFQN | this_STRING_1= RULE_STRING )
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==RULE_ID) ) {
                alt50=1;
            }
            else if ( (LA50_0==RULE_STRING) ) {
                alt50=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;
            }
            switch (alt50) {
                case 1 :
                    // InternalTmscXtext.g:2723:3: this_FQN_0= ruleFQN
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
                    // InternalTmscXtext.g:2734:3: this_STRING_1= RULE_STRING
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
    // InternalTmscXtext.g:2745:1: entryRuleIDString returns [String current=null] : iv_ruleIDString= ruleIDString EOF ;
    public final String entryRuleIDString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIDString = null;


        try {
            // InternalTmscXtext.g:2745:48: (iv_ruleIDString= ruleIDString EOF )
            // InternalTmscXtext.g:2746:2: iv_ruleIDString= ruleIDString EOF
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
    // InternalTmscXtext.g:2752:1: ruleIDString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | this_STRING_1= RULE_STRING ) ;
    public final AntlrDatatypeRuleToken ruleIDString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token this_STRING_1=null;


        	enterRule();

        try {
            // InternalTmscXtext.g:2758:2: ( (this_ID_0= RULE_ID | this_STRING_1= RULE_STRING ) )
            // InternalTmscXtext.g:2759:2: (this_ID_0= RULE_ID | this_STRING_1= RULE_STRING )
            {
            // InternalTmscXtext.g:2759:2: (this_ID_0= RULE_ID | this_STRING_1= RULE_STRING )
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==RULE_ID) ) {
                alt51=1;
            }
            else if ( (LA51_0==RULE_STRING) ) {
                alt51=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;
            }
            switch (alt51) {
                case 1 :
                    // InternalTmscXtext.g:2760:3: this_ID_0= RULE_ID
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
                    // InternalTmscXtext.g:2768:3: this_STRING_1= RULE_STRING
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
    // InternalTmscXtext.g:2779:1: entryRuleFQN returns [String current=null] : iv_ruleFQN= ruleFQN EOF ;
    public final String entryRuleFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQN = null;


        try {
            // InternalTmscXtext.g:2779:43: (iv_ruleFQN= ruleFQN EOF )
            // InternalTmscXtext.g:2780:2: iv_ruleFQN= ruleFQN EOF
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
    // InternalTmscXtext.g:2786:1: ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalTmscXtext.g:2792:2: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalTmscXtext.g:2793:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalTmscXtext.g:2793:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalTmscXtext.g:2794:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_37); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_ID_0);
              		
            }
            if ( state.backtracking==0 ) {

              			newLeafNode(this_ID_0, grammarAccess.getFQNAccess().getIDTerminalRuleCall_0());
              		
            }
            // InternalTmscXtext.g:2801:3: (kw= '.' this_ID_2= RULE_ID )*
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( (LA52_0==44) ) {
                    alt52=1;
                }


                switch (alt52) {
            	case 1 :
            	    // InternalTmscXtext.g:2802:4: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,44,FOLLOW_13); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				current.merge(kw);
            	      				newLeafNode(kw, grammarAccess.getFQNAccess().getFullStopKeyword_1_0());
            	      			
            	    }
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_37); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				current.merge(this_ID_2);
            	      			
            	    }
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(this_ID_2, grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1());
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop52;
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
    // InternalTmscXtext.g:2819:1: entryRuleEBOOLEAN_OBJECT returns [String current=null] : iv_ruleEBOOLEAN_OBJECT= ruleEBOOLEAN_OBJECT EOF ;
    public final String entryRuleEBOOLEAN_OBJECT() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEBOOLEAN_OBJECT = null;


        try {
            // InternalTmscXtext.g:2819:55: (iv_ruleEBOOLEAN_OBJECT= ruleEBOOLEAN_OBJECT EOF )
            // InternalTmscXtext.g:2820:2: iv_ruleEBOOLEAN_OBJECT= ruleEBOOLEAN_OBJECT EOF
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
    // InternalTmscXtext.g:2826:1: ruleEBOOLEAN_OBJECT returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'true' | kw= 'false' ) ;
    public final AntlrDatatypeRuleToken ruleEBOOLEAN_OBJECT() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalTmscXtext.g:2832:2: ( (kw= 'true' | kw= 'false' ) )
            // InternalTmscXtext.g:2833:2: (kw= 'true' | kw= 'false' )
            {
            // InternalTmscXtext.g:2833:2: (kw= 'true' | kw= 'false' )
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==45) ) {
                alt53=1;
            }
            else if ( (LA53_0==46) ) {
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
                    // InternalTmscXtext.g:2834:3: kw= 'true'
                    {
                    kw=(Token)match(input,45,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getEBOOLEAN_OBJECTAccess().getTrueKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalTmscXtext.g:2840:3: kw= 'false'
                    {
                    kw=(Token)match(input,46,FOLLOW_2); if (state.failed) return current;
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
    // InternalTmscXtext.g:2849:1: entryRuleEBIGDECIMAL returns [String current=null] : iv_ruleEBIGDECIMAL= ruleEBIGDECIMAL EOF ;
    public final String entryRuleEBIGDECIMAL() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEBIGDECIMAL = null;


        try {
            // InternalTmscXtext.g:2849:51: (iv_ruleEBIGDECIMAL= ruleEBIGDECIMAL EOF )
            // InternalTmscXtext.g:2850:2: iv_ruleEBIGDECIMAL= ruleEBIGDECIMAL EOF
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
    // InternalTmscXtext.g:2856:1: ruleEBIGDECIMAL returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ABS_EBIGDECIMAL_0= RULE_ABS_EBIGDECIMAL | this_POS_EBIGDECIMAL_1= RULE_POS_EBIGDECIMAL | this_NEG_EBIGDECIMAL_2= RULE_NEG_EBIGDECIMAL ) ;
    public final AntlrDatatypeRuleToken ruleEBIGDECIMAL() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ABS_EBIGDECIMAL_0=null;
        Token this_POS_EBIGDECIMAL_1=null;
        Token this_NEG_EBIGDECIMAL_2=null;


        	enterRule();

        try {
            // InternalTmscXtext.g:2862:2: ( (this_ABS_EBIGDECIMAL_0= RULE_ABS_EBIGDECIMAL | this_POS_EBIGDECIMAL_1= RULE_POS_EBIGDECIMAL | this_NEG_EBIGDECIMAL_2= RULE_NEG_EBIGDECIMAL ) )
            // InternalTmscXtext.g:2863:2: (this_ABS_EBIGDECIMAL_0= RULE_ABS_EBIGDECIMAL | this_POS_EBIGDECIMAL_1= RULE_POS_EBIGDECIMAL | this_NEG_EBIGDECIMAL_2= RULE_NEG_EBIGDECIMAL )
            {
            // InternalTmscXtext.g:2863:2: (this_ABS_EBIGDECIMAL_0= RULE_ABS_EBIGDECIMAL | this_POS_EBIGDECIMAL_1= RULE_POS_EBIGDECIMAL | this_NEG_EBIGDECIMAL_2= RULE_NEG_EBIGDECIMAL )
            int alt54=3;
            switch ( input.LA(1) ) {
            case RULE_ABS_EBIGDECIMAL:
                {
                alt54=1;
                }
                break;
            case RULE_POS_EBIGDECIMAL:
                {
                alt54=2;
                }
                break;
            case RULE_NEG_EBIGDECIMAL:
                {
                alt54=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 54, 0, input);

                throw nvae;
            }

            switch (alt54) {
                case 1 :
                    // InternalTmscXtext.g:2864:3: this_ABS_EBIGDECIMAL_0= RULE_ABS_EBIGDECIMAL
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
                    // InternalTmscXtext.g:2872:3: this_POS_EBIGDECIMAL_1= RULE_POS_EBIGDECIMAL
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
                    // InternalTmscXtext.g:2880:3: this_NEG_EBIGDECIMAL_2= RULE_NEG_EBIGDECIMAL
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
    // InternalTmscXtext.g:2891:1: ruleXArchitectureKind returns [Enumerator current=null] : ( (enumLiteral_0= 'internal' ) | (enumLiteral_1= 'external' ) ) ;
    public final Enumerator ruleXArchitectureKind() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalTmscXtext.g:2897:2: ( ( (enumLiteral_0= 'internal' ) | (enumLiteral_1= 'external' ) ) )
            // InternalTmscXtext.g:2898:2: ( (enumLiteral_0= 'internal' ) | (enumLiteral_1= 'external' ) )
            {
            // InternalTmscXtext.g:2898:2: ( (enumLiteral_0= 'internal' ) | (enumLiteral_1= 'external' ) )
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==47) ) {
                alt55=1;
            }
            else if ( (LA55_0==48) ) {
                alt55=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 55, 0, input);

                throw nvae;
            }
            switch (alt55) {
                case 1 :
                    // InternalTmscXtext.g:2899:3: (enumLiteral_0= 'internal' )
                    {
                    // InternalTmscXtext.g:2899:3: (enumLiteral_0= 'internal' )
                    // InternalTmscXtext.g:2900:4: enumLiteral_0= 'internal'
                    {
                    enumLiteral_0=(Token)match(input,47,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getXArchitectureKindAccess().getINTERNALEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getXArchitectureKindAccess().getINTERNALEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalTmscXtext.g:2907:3: (enumLiteral_1= 'external' )
                    {
                    // InternalTmscXtext.g:2907:3: (enumLiteral_1= 'external' )
                    // InternalTmscXtext.g:2908:4: enumLiteral_1= 'external'
                    {
                    enumLiteral_1=(Token)match(input,48,FOLLOW_2); if (state.failed) return current;
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
    // InternalTmscXtext.g:2918:1: ruleXFunctionParameterKind returns [Enumerator current=null] : ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'out' ) | (enumLiteral_2= 'inout' ) | (enumLiteral_3= 'return' ) ) ;
    public final Enumerator ruleXFunctionParameterKind() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalTmscXtext.g:2924:2: ( ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'out' ) | (enumLiteral_2= 'inout' ) | (enumLiteral_3= 'return' ) ) )
            // InternalTmscXtext.g:2925:2: ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'out' ) | (enumLiteral_2= 'inout' ) | (enumLiteral_3= 'return' ) )
            {
            // InternalTmscXtext.g:2925:2: ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'out' ) | (enumLiteral_2= 'inout' ) | (enumLiteral_3= 'return' ) )
            int alt56=4;
            switch ( input.LA(1) ) {
            case 49:
                {
                alt56=1;
                }
                break;
            case 50:
                {
                alt56=2;
                }
                break;
            case 51:
                {
                alt56=3;
                }
                break;
            case 52:
                {
                alt56=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 56, 0, input);

                throw nvae;
            }

            switch (alt56) {
                case 1 :
                    // InternalTmscXtext.g:2926:3: (enumLiteral_0= 'in' )
                    {
                    // InternalTmscXtext.g:2926:3: (enumLiteral_0= 'in' )
                    // InternalTmscXtext.g:2927:4: enumLiteral_0= 'in'
                    {
                    enumLiteral_0=(Token)match(input,49,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getXFunctionParameterKindAccess().getINEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getXFunctionParameterKindAccess().getINEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalTmscXtext.g:2934:3: (enumLiteral_1= 'out' )
                    {
                    // InternalTmscXtext.g:2934:3: (enumLiteral_1= 'out' )
                    // InternalTmscXtext.g:2935:4: enumLiteral_1= 'out'
                    {
                    enumLiteral_1=(Token)match(input,50,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getXFunctionParameterKindAccess().getOUTEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getXFunctionParameterKindAccess().getOUTEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalTmscXtext.g:2942:3: (enumLiteral_2= 'inout' )
                    {
                    // InternalTmscXtext.g:2942:3: (enumLiteral_2= 'inout' )
                    // InternalTmscXtext.g:2943:4: enumLiteral_2= 'inout'
                    {
                    enumLiteral_2=(Token)match(input,51,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getXFunctionParameterKindAccess().getIN_OUTEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getXFunctionParameterKindAccess().getIN_OUTEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalTmscXtext.g:2950:3: (enumLiteral_3= 'return' )
                    {
                    // InternalTmscXtext.g:2950:3: (enumLiteral_3= 'return' )
                    // InternalTmscXtext.g:2951:4: enumLiteral_3= 'return'
                    {
                    enumLiteral_3=(Token)match(input,52,FOLLOW_2); if (state.failed) return current;
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
    // InternalTmscXtext.g:2961:1: ruleXEventType returns [Enumerator current=null] : ( (enumLiteral_0= '>' ) | (enumLiteral_1= '<' ) ) ;
    public final Enumerator ruleXEventType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalTmscXtext.g:2967:2: ( ( (enumLiteral_0= '>' ) | (enumLiteral_1= '<' ) ) )
            // InternalTmscXtext.g:2968:2: ( (enumLiteral_0= '>' ) | (enumLiteral_1= '<' ) )
            {
            // InternalTmscXtext.g:2968:2: ( (enumLiteral_0= '>' ) | (enumLiteral_1= '<' ) )
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==53) ) {
                alt57=1;
            }
            else if ( (LA57_0==54) ) {
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
                    // InternalTmscXtext.g:2969:3: (enumLiteral_0= '>' )
                    {
                    // InternalTmscXtext.g:2969:3: (enumLiteral_0= '>' )
                    // InternalTmscXtext.g:2970:4: enumLiteral_0= '>'
                    {
                    enumLiteral_0=(Token)match(input,53,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getXEventTypeAccess().getENTRYEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getXEventTypeAccess().getENTRYEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalTmscXtext.g:2977:3: (enumLiteral_1= '<' )
                    {
                    // InternalTmscXtext.g:2977:3: (enumLiteral_1= '<' )
                    // InternalTmscXtext.g:2978:4: enumLiteral_1= '<'
                    {
                    enumLiteral_1=(Token)match(input,54,FOLLOW_2); if (state.failed) return current;
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
    // InternalTmscXtext.g:2988:1: ruleXDependencyType returns [Enumerator current=null] : ( (enumLiteral_0= 'message' ) | (enumLiteral_1= 'request' ) | (enumLiteral_2= 'reply' ) | (enumLiteral_3= 'domain-dependency' ) | (enumLiteral_4= 'lifeline-segment' ) | (enumLiteral_5= 'message-control' ) ) ;
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
            // InternalTmscXtext.g:2994:2: ( ( (enumLiteral_0= 'message' ) | (enumLiteral_1= 'request' ) | (enumLiteral_2= 'reply' ) | (enumLiteral_3= 'domain-dependency' ) | (enumLiteral_4= 'lifeline-segment' ) | (enumLiteral_5= 'message-control' ) ) )
            // InternalTmscXtext.g:2995:2: ( (enumLiteral_0= 'message' ) | (enumLiteral_1= 'request' ) | (enumLiteral_2= 'reply' ) | (enumLiteral_3= 'domain-dependency' ) | (enumLiteral_4= 'lifeline-segment' ) | (enumLiteral_5= 'message-control' ) )
            {
            // InternalTmscXtext.g:2995:2: ( (enumLiteral_0= 'message' ) | (enumLiteral_1= 'request' ) | (enumLiteral_2= 'reply' ) | (enumLiteral_3= 'domain-dependency' ) | (enumLiteral_4= 'lifeline-segment' ) | (enumLiteral_5= 'message-control' ) )
            int alt58=6;
            switch ( input.LA(1) ) {
            case 40:
                {
                alt58=1;
                }
                break;
            case 39:
                {
                alt58=2;
                }
                break;
            case 55:
                {
                alt58=3;
                }
                break;
            case 56:
                {
                alt58=4;
                }
                break;
            case 57:
                {
                alt58=5;
                }
                break;
            case 58:
                {
                alt58=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 58, 0, input);

                throw nvae;
            }

            switch (alt58) {
                case 1 :
                    // InternalTmscXtext.g:2996:3: (enumLiteral_0= 'message' )
                    {
                    // InternalTmscXtext.g:2996:3: (enumLiteral_0= 'message' )
                    // InternalTmscXtext.g:2997:4: enumLiteral_0= 'message'
                    {
                    enumLiteral_0=(Token)match(input,40,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getXDependencyTypeAccess().getMESSAGEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getXDependencyTypeAccess().getMESSAGEEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalTmscXtext.g:3004:3: (enumLiteral_1= 'request' )
                    {
                    // InternalTmscXtext.g:3004:3: (enumLiteral_1= 'request' )
                    // InternalTmscXtext.g:3005:4: enumLiteral_1= 'request'
                    {
                    enumLiteral_1=(Token)match(input,39,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getXDependencyTypeAccess().getREQUESTEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getXDependencyTypeAccess().getREQUESTEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalTmscXtext.g:3012:3: (enumLiteral_2= 'reply' )
                    {
                    // InternalTmscXtext.g:3012:3: (enumLiteral_2= 'reply' )
                    // InternalTmscXtext.g:3013:4: enumLiteral_2= 'reply'
                    {
                    enumLiteral_2=(Token)match(input,55,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getXDependencyTypeAccess().getREPLYEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getXDependencyTypeAccess().getREPLYEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalTmscXtext.g:3020:3: (enumLiteral_3= 'domain-dependency' )
                    {
                    // InternalTmscXtext.g:3020:3: (enumLiteral_3= 'domain-dependency' )
                    // InternalTmscXtext.g:3021:4: enumLiteral_3= 'domain-dependency'
                    {
                    enumLiteral_3=(Token)match(input,56,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getXDependencyTypeAccess().getDOMAINEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_3, grammarAccess.getXDependencyTypeAccess().getDOMAINEnumLiteralDeclaration_3());
                      			
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalTmscXtext.g:3028:3: (enumLiteral_4= 'lifeline-segment' )
                    {
                    // InternalTmscXtext.g:3028:3: (enumLiteral_4= 'lifeline-segment' )
                    // InternalTmscXtext.g:3029:4: enumLiteral_4= 'lifeline-segment'
                    {
                    enumLiteral_4=(Token)match(input,57,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getXDependencyTypeAccess().getLIFELINE_SEGMENTEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_4, grammarAccess.getXDependencyTypeAccess().getLIFELINE_SEGMENTEnumLiteralDeclaration_4());
                      			
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalTmscXtext.g:3036:3: (enumLiteral_5= 'message-control' )
                    {
                    // InternalTmscXtext.g:3036:3: (enumLiteral_5= 'message-control' )
                    // InternalTmscXtext.g:3037:4: enumLiteral_5= 'message-control'
                    {
                    enumLiteral_5=(Token)match(input,58,FOLLOW_2); if (state.failed) return current;
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


    protected DFA2 dfa2 = new DFA2(this);
    static final String dfa_1s = "\13\uffff";
    static final String dfa_2s = "\1\1\12\uffff";
    static final String dfa_3s = "\1\4\6\uffff\1\43\3\uffff";
    static final String dfa_4s = "\1\72\6\uffff\1\44\3\uffff";
    static final String dfa_5s = "\1\uffff\1\11\1\1\1\2\1\3\1\4\1\5\1\uffff\1\6\1\7\1\10";
    static final String dfa_6s = "\13\uffff}>";
    static final String[] dfa_7s = {
            "\5\12\4\uffff\1\2\7\uffff\1\4\2\uffff\1\5\3\uffff\3\6\3\uffff\1\7\1\10\1\11\2\uffff\2\3\16\uffff\4\3",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\10\1\11",
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

    class DFA2 extends DFA {

        public DFA2(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 2;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "()* loopback of 87:3: ( (otherlv_1= 'tmsc' otherlv_2= 'settings' otherlv_3= '{' ( (otherlv_4= 'architecture' otherlv_5= ':' ( (lv_architectureKind_6_0= ruleXArchitectureKind ) ) ) | (otherlv_7= 'time-bound' otherlv_8= ':' ( (lv_timeBound_9_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_10= 'scheduled' otherlv_11= ':' ( (lv_scheduled_12_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_13_0= ruleXProperty ) ) )* otherlv_14= '}' ) | ( (lv_dependencySettings_15_0= ruleXDependencySettings ) ) | ( (lv_interfaces_16_0= ruleXInterface ) ) | ( (lv_components_17_0= ruleXComponent ) ) | ( (lv_functions_18_0= ruleXFunction ) ) | ( (lv_hosts_19_0= ruleXHost ) ) | ( (lv_executors_20_0= ruleXExecutor ) ) | ( (lv_events_21_0= ruleXEvent ) ) )*";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x00000000001D0120L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0001800000000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000600000000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0780019C712021F2L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x00000000000D0120L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x00000000009D0120L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x000000000A008002L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x000000000C008002L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000004008002L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000280008002L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x001E000000000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000104000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000200008002L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x00000014001D0120L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x07E0019C712D21F0L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000006080008002L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000006000008002L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x07800180000D0120L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x00000180000D0120L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x00000200001D0120L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x00006400000D03B0L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000080004000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000100000000002L});

}