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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ABS_EBIGDECIMAL", "RULE_ID", "RULE_ISO8601", "RULE_POS_EBIGDECIMAL", "RULE_STRING", "RULE_NEG_EBIGDECIMAL", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "'tmsc'", "'settings'", "'{'", "'architecture'", "':'", "'time-bound'", "'scheduled'", "'}'", "'interface'", "'as'", "'operation'", "'component'", "'provides'", "','", "'requires'", "'ipc-client'", "'ipc-server'", "'function'", "'('", "')'", "'implements'", "'untraced'", "'executor'", "'!'", "'?'", "'request'", "'message'", "'prefix'", "'['", "']'", "'.'", "'true'", "'false'", "'internal'", "'external'", "'in'", "'out'", "'inout'", "'return'", "'>'", "'<'", "'reply'", "'domain-dependency'", "'lifeline-segment'", "'message-control'"
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
    // InternalTmscXtext.g:72:1: ruleTmscXtextModel returns [EObject current=null] : ( () ( (otherlv_1= 'tmsc' otherlv_2= 'settings' otherlv_3= '{' ( (otherlv_4= 'architecture' otherlv_5= ':' ( (lv_architectureKind_6_0= ruleXArchitectureKind ) ) ) | (otherlv_7= 'time-bound' otherlv_8= ':' ( (lv_timeBound_9_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_10= 'scheduled' otherlv_11= ':' ( (lv_scheduled_12_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_13_0= ruleXProperty ) ) )* otherlv_14= '}' ) | ( (lv_dependencySettings_15_0= ruleXDependencySettings ) ) | ( (lv_interfaces_16_0= ruleXInterface ) ) | ( (lv_components_17_0= ruleXComponent ) ) | ( (lv_functions_18_0= ruleXFunction ) ) | ( (lv_executors_19_0= ruleXExecutor ) ) | ( (lv_events_20_0= ruleXEvent ) ) )* ) ;
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

        EObject lv_executors_19_0 = null;

        EObject lv_events_20_0 = null;



        	enterRule();

        try {
            // InternalTmscXtext.g:78:2: ( ( () ( (otherlv_1= 'tmsc' otherlv_2= 'settings' otherlv_3= '{' ( (otherlv_4= 'architecture' otherlv_5= ':' ( (lv_architectureKind_6_0= ruleXArchitectureKind ) ) ) | (otherlv_7= 'time-bound' otherlv_8= ':' ( (lv_timeBound_9_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_10= 'scheduled' otherlv_11= ':' ( (lv_scheduled_12_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_13_0= ruleXProperty ) ) )* otherlv_14= '}' ) | ( (lv_dependencySettings_15_0= ruleXDependencySettings ) ) | ( (lv_interfaces_16_0= ruleXInterface ) ) | ( (lv_components_17_0= ruleXComponent ) ) | ( (lv_functions_18_0= ruleXFunction ) ) | ( (lv_executors_19_0= ruleXExecutor ) ) | ( (lv_events_20_0= ruleXEvent ) ) )* ) )
            // InternalTmscXtext.g:79:2: ( () ( (otherlv_1= 'tmsc' otherlv_2= 'settings' otherlv_3= '{' ( (otherlv_4= 'architecture' otherlv_5= ':' ( (lv_architectureKind_6_0= ruleXArchitectureKind ) ) ) | (otherlv_7= 'time-bound' otherlv_8= ':' ( (lv_timeBound_9_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_10= 'scheduled' otherlv_11= ':' ( (lv_scheduled_12_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_13_0= ruleXProperty ) ) )* otherlv_14= '}' ) | ( (lv_dependencySettings_15_0= ruleXDependencySettings ) ) | ( (lv_interfaces_16_0= ruleXInterface ) ) | ( (lv_components_17_0= ruleXComponent ) ) | ( (lv_functions_18_0= ruleXFunction ) ) | ( (lv_executors_19_0= ruleXExecutor ) ) | ( (lv_events_20_0= ruleXEvent ) ) )* )
            {
            // InternalTmscXtext.g:79:2: ( () ( (otherlv_1= 'tmsc' otherlv_2= 'settings' otherlv_3= '{' ( (otherlv_4= 'architecture' otherlv_5= ':' ( (lv_architectureKind_6_0= ruleXArchitectureKind ) ) ) | (otherlv_7= 'time-bound' otherlv_8= ':' ( (lv_timeBound_9_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_10= 'scheduled' otherlv_11= ':' ( (lv_scheduled_12_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_13_0= ruleXProperty ) ) )* otherlv_14= '}' ) | ( (lv_dependencySettings_15_0= ruleXDependencySettings ) ) | ( (lv_interfaces_16_0= ruleXInterface ) ) | ( (lv_components_17_0= ruleXComponent ) ) | ( (lv_functions_18_0= ruleXFunction ) ) | ( (lv_executors_19_0= ruleXExecutor ) ) | ( (lv_events_20_0= ruleXEvent ) ) )* )
            // InternalTmscXtext.g:80:3: () ( (otherlv_1= 'tmsc' otherlv_2= 'settings' otherlv_3= '{' ( (otherlv_4= 'architecture' otherlv_5= ':' ( (lv_architectureKind_6_0= ruleXArchitectureKind ) ) ) | (otherlv_7= 'time-bound' otherlv_8= ':' ( (lv_timeBound_9_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_10= 'scheduled' otherlv_11= ':' ( (lv_scheduled_12_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_13_0= ruleXProperty ) ) )* otherlv_14= '}' ) | ( (lv_dependencySettings_15_0= ruleXDependencySettings ) ) | ( (lv_interfaces_16_0= ruleXInterface ) ) | ( (lv_components_17_0= ruleXComponent ) ) | ( (lv_functions_18_0= ruleXFunction ) ) | ( (lv_executors_19_0= ruleXExecutor ) ) | ( (lv_events_20_0= ruleXEvent ) ) )*
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

            // InternalTmscXtext.g:87:3: ( (otherlv_1= 'tmsc' otherlv_2= 'settings' otherlv_3= '{' ( (otherlv_4= 'architecture' otherlv_5= ':' ( (lv_architectureKind_6_0= ruleXArchitectureKind ) ) ) | (otherlv_7= 'time-bound' otherlv_8= ':' ( (lv_timeBound_9_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_10= 'scheduled' otherlv_11= ':' ( (lv_scheduled_12_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_13_0= ruleXProperty ) ) )* otherlv_14= '}' ) | ( (lv_dependencySettings_15_0= ruleXDependencySettings ) ) | ( (lv_interfaces_16_0= ruleXInterface ) ) | ( (lv_components_17_0= ruleXComponent ) ) | ( (lv_functions_18_0= ruleXFunction ) ) | ( (lv_executors_19_0= ruleXExecutor ) ) | ( (lv_events_20_0= ruleXEvent ) ) )*
            loop2:
            do {
                int alt2=8;
                switch ( input.LA(1) ) {
                case 13:
                    {
                    alt2=1;
                    }
                    break;
                case 38:
                case 39:
                case 54:
                case 55:
                case 56:
                case 57:
                    {
                    alt2=2;
                    }
                    break;
                case 21:
                    {
                    alt2=3;
                    }
                    break;
                case 24:
                    {
                    alt2=4;
                    }
                    break;
                case 28:
                case 29:
                case 30:
                    {
                    alt2=5;
                    }
                    break;
                case 34:
                case 35:
                    {
                    alt2=6;
                    }
                    break;
                case RULE_ABS_EBIGDECIMAL:
                case RULE_ID:
                case RULE_ISO8601:
                case RULE_POS_EBIGDECIMAL:
                case RULE_STRING:
                    {
                    alt2=7;
                    }
                    break;

                }

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
            	    // InternalTmscXtext.g:297:4: ( (lv_executors_19_0= ruleXExecutor ) )
            	    {
            	    // InternalTmscXtext.g:297:4: ( (lv_executors_19_0= ruleXExecutor ) )
            	    // InternalTmscXtext.g:298:5: (lv_executors_19_0= ruleXExecutor )
            	    {
            	    // InternalTmscXtext.g:298:5: (lv_executors_19_0= ruleXExecutor )
            	    // InternalTmscXtext.g:299:6: lv_executors_19_0= ruleXExecutor
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getTmscXtextModelAccess().getExecutorsXExecutorParserRuleCall_1_5_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_10);
            	    lv_executors_19_0=ruleXExecutor();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getTmscXtextModelRule());
            	      						}
            	      						add(
            	      							current,
            	      							"executors",
            	      							lv_executors_19_0,
            	      							"nl.esi.pps.tmsc.xtext.TmscXtext.XExecutor");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 7 :
            	    // InternalTmscXtext.g:317:4: ( (lv_events_20_0= ruleXEvent ) )
            	    {
            	    // InternalTmscXtext.g:317:4: ( (lv_events_20_0= ruleXEvent ) )
            	    // InternalTmscXtext.g:318:5: (lv_events_20_0= ruleXEvent )
            	    {
            	    // InternalTmscXtext.g:318:5: (lv_events_20_0= ruleXEvent )
            	    // InternalTmscXtext.g:319:6: lv_events_20_0= ruleXEvent
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getTmscXtextModelAccess().getEventsXEventParserRuleCall_1_6_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_10);
            	    lv_events_20_0=ruleXEvent();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getTmscXtextModelRule());
            	      						}
            	      						add(
            	      							current,
            	      							"events",
            	      							lv_events_20_0,
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
    // InternalTmscXtext.g:341:1: entryRuleXInterface returns [EObject current=null] : iv_ruleXInterface= ruleXInterface EOF ;
    public final EObject entryRuleXInterface() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXInterface = null;


        try {
            // InternalTmscXtext.g:341:51: (iv_ruleXInterface= ruleXInterface EOF )
            // InternalTmscXtext.g:342:2: iv_ruleXInterface= ruleXInterface EOF
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
    // InternalTmscXtext.g:348:1: ruleXInterface returns [EObject current=null] : (otherlv_0= 'interface' ( ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as' )? ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '{' ( ( (lv_properties_5_0= ruleXProperty ) ) | ( (lv_operations_6_0= ruleXOperation ) ) )* otherlv_7= '}' )? ) ;
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
            // InternalTmscXtext.g:354:2: ( (otherlv_0= 'interface' ( ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as' )? ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '{' ( ( (lv_properties_5_0= ruleXProperty ) ) | ( (lv_operations_6_0= ruleXOperation ) ) )* otherlv_7= '}' )? ) )
            // InternalTmscXtext.g:355:2: (otherlv_0= 'interface' ( ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as' )? ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '{' ( ( (lv_properties_5_0= ruleXProperty ) ) | ( (lv_operations_6_0= ruleXOperation ) ) )* otherlv_7= '}' )? )
            {
            // InternalTmscXtext.g:355:2: (otherlv_0= 'interface' ( ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as' )? ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '{' ( ( (lv_properties_5_0= ruleXProperty ) ) | ( (lv_operations_6_0= ruleXOperation ) ) )* otherlv_7= '}' )? )
            // InternalTmscXtext.g:356:3: otherlv_0= 'interface' ( ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as' )? ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '{' ( ( (lv_properties_5_0= ruleXProperty ) ) | ( (lv_operations_6_0= ruleXOperation ) ) )* otherlv_7= '}' )?
            {
            otherlv_0=(Token)match(input,21,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getXInterfaceAccess().getInterfaceKeyword_0());
              		
            }
            // InternalTmscXtext.g:360:3: ( ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as' )?
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
                    // InternalTmscXtext.g:361:4: ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as'
                    {
                    // InternalTmscXtext.g:361:4: ( (lv_description_1_0= ruleIDString ) )
                    // InternalTmscXtext.g:362:5: (lv_description_1_0= ruleIDString )
                    {
                    // InternalTmscXtext.g:362:5: (lv_description_1_0= ruleIDString )
                    // InternalTmscXtext.g:363:6: lv_description_1_0= ruleIDString
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

            // InternalTmscXtext.g:385:3: ( (lv_name_3_0= RULE_ID ) )
            // InternalTmscXtext.g:386:4: (lv_name_3_0= RULE_ID )
            {
            // InternalTmscXtext.g:386:4: (lv_name_3_0= RULE_ID )
            // InternalTmscXtext.g:387:5: lv_name_3_0= RULE_ID
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

            // InternalTmscXtext.g:403:3: (otherlv_4= '{' ( ( (lv_properties_5_0= ruleXProperty ) ) | ( (lv_operations_6_0= ruleXOperation ) ) )* otherlv_7= '}' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==15) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalTmscXtext.g:404:4: otherlv_4= '{' ( ( (lv_properties_5_0= ruleXProperty ) ) | ( (lv_operations_6_0= ruleXOperation ) ) )* otherlv_7= '}'
                    {
                    otherlv_4=(Token)match(input,15,FOLLOW_15); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getXInterfaceAccess().getLeftCurlyBracketKeyword_3_0());
                      			
                    }
                    // InternalTmscXtext.g:408:4: ( ( (lv_properties_5_0= ruleXProperty ) ) | ( (lv_operations_6_0= ruleXOperation ) ) )*
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
                    	    // InternalTmscXtext.g:409:5: ( (lv_properties_5_0= ruleXProperty ) )
                    	    {
                    	    // InternalTmscXtext.g:409:5: ( (lv_properties_5_0= ruleXProperty ) )
                    	    // InternalTmscXtext.g:410:6: (lv_properties_5_0= ruleXProperty )
                    	    {
                    	    // InternalTmscXtext.g:410:6: (lv_properties_5_0= ruleXProperty )
                    	    // InternalTmscXtext.g:411:7: lv_properties_5_0= ruleXProperty
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
                    	    // InternalTmscXtext.g:429:5: ( (lv_operations_6_0= ruleXOperation ) )
                    	    {
                    	    // InternalTmscXtext.g:429:5: ( (lv_operations_6_0= ruleXOperation ) )
                    	    // InternalTmscXtext.g:430:6: (lv_operations_6_0= ruleXOperation )
                    	    {
                    	    // InternalTmscXtext.g:430:6: (lv_operations_6_0= ruleXOperation )
                    	    // InternalTmscXtext.g:431:7: lv_operations_6_0= ruleXOperation
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
    // InternalTmscXtext.g:458:1: entryRuleXOperation returns [EObject current=null] : iv_ruleXOperation= ruleXOperation EOF ;
    public final EObject entryRuleXOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXOperation = null;


        try {
            // InternalTmscXtext.g:458:51: (iv_ruleXOperation= ruleXOperation EOF )
            // InternalTmscXtext.g:459:2: iv_ruleXOperation= ruleXOperation EOF
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
    // InternalTmscXtext.g:465:1: ruleXOperation returns [EObject current=null] : (otherlv_0= 'operation' ( ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as' )? ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '{' ( (lv_properties_5_0= ruleXProperty ) )* otherlv_6= '}' )? ) ;
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
            // InternalTmscXtext.g:471:2: ( (otherlv_0= 'operation' ( ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as' )? ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '{' ( (lv_properties_5_0= ruleXProperty ) )* otherlv_6= '}' )? ) )
            // InternalTmscXtext.g:472:2: (otherlv_0= 'operation' ( ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as' )? ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '{' ( (lv_properties_5_0= ruleXProperty ) )* otherlv_6= '}' )? )
            {
            // InternalTmscXtext.g:472:2: (otherlv_0= 'operation' ( ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as' )? ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '{' ( (lv_properties_5_0= ruleXProperty ) )* otherlv_6= '}' )? )
            // InternalTmscXtext.g:473:3: otherlv_0= 'operation' ( ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as' )? ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '{' ( (lv_properties_5_0= ruleXProperty ) )* otherlv_6= '}' )?
            {
            otherlv_0=(Token)match(input,23,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getXOperationAccess().getOperationKeyword_0());
              		
            }
            // InternalTmscXtext.g:477:3: ( ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as' )?
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
                    // InternalTmscXtext.g:478:4: ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as'
                    {
                    // InternalTmscXtext.g:478:4: ( (lv_description_1_0= ruleIDString ) )
                    // InternalTmscXtext.g:479:5: (lv_description_1_0= ruleIDString )
                    {
                    // InternalTmscXtext.g:479:5: (lv_description_1_0= ruleIDString )
                    // InternalTmscXtext.g:480:6: lv_description_1_0= ruleIDString
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

            // InternalTmscXtext.g:502:3: ( (lv_name_3_0= RULE_ID ) )
            // InternalTmscXtext.g:503:4: (lv_name_3_0= RULE_ID )
            {
            // InternalTmscXtext.g:503:4: (lv_name_3_0= RULE_ID )
            // InternalTmscXtext.g:504:5: lv_name_3_0= RULE_ID
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

            // InternalTmscXtext.g:520:3: (otherlv_4= '{' ( (lv_properties_5_0= ruleXProperty ) )* otherlv_6= '}' )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==15) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalTmscXtext.g:521:4: otherlv_4= '{' ( (lv_properties_5_0= ruleXProperty ) )* otherlv_6= '}'
                    {
                    otherlv_4=(Token)match(input,15,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getXOperationAccess().getLeftCurlyBracketKeyword_3_0());
                      			
                    }
                    // InternalTmscXtext.g:525:4: ( (lv_properties_5_0= ruleXProperty ) )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==RULE_ID||LA7_0==RULE_STRING) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // InternalTmscXtext.g:526:5: (lv_properties_5_0= ruleXProperty )
                    	    {
                    	    // InternalTmscXtext.g:526:5: (lv_properties_5_0= ruleXProperty )
                    	    // InternalTmscXtext.g:527:6: lv_properties_5_0= ruleXProperty
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
    // InternalTmscXtext.g:553:1: entryRuleXComponent returns [EObject current=null] : iv_ruleXComponent= ruleXComponent EOF ;
    public final EObject entryRuleXComponent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXComponent = null;


        try {
            // InternalTmscXtext.g:553:51: (iv_ruleXComponent= ruleXComponent EOF )
            // InternalTmscXtext.g:554:2: iv_ruleXComponent= ruleXComponent EOF
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
    // InternalTmscXtext.g:560:1: ruleXComponent returns [EObject current=null] : (otherlv_0= 'component' ( ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as' )? ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= 'provides' ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )? (otherlv_8= 'requires' ( (otherlv_9= RULE_ID ) ) (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )* )? (otherlv_12= '{' ( (otherlv_13= 'time-bound' otherlv_14= ':' ( (lv_timeBound_15_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_16= 'scheduled' otherlv_17= ':' ( (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_19_0= ruleXProperty ) ) )* otherlv_20= '}' )? ) ;
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
            // InternalTmscXtext.g:566:2: ( (otherlv_0= 'component' ( ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as' )? ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= 'provides' ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )? (otherlv_8= 'requires' ( (otherlv_9= RULE_ID ) ) (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )* )? (otherlv_12= '{' ( (otherlv_13= 'time-bound' otherlv_14= ':' ( (lv_timeBound_15_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_16= 'scheduled' otherlv_17= ':' ( (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_19_0= ruleXProperty ) ) )* otherlv_20= '}' )? ) )
            // InternalTmscXtext.g:567:2: (otherlv_0= 'component' ( ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as' )? ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= 'provides' ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )? (otherlv_8= 'requires' ( (otherlv_9= RULE_ID ) ) (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )* )? (otherlv_12= '{' ( (otherlv_13= 'time-bound' otherlv_14= ':' ( (lv_timeBound_15_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_16= 'scheduled' otherlv_17= ':' ( (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_19_0= ruleXProperty ) ) )* otherlv_20= '}' )? )
            {
            // InternalTmscXtext.g:567:2: (otherlv_0= 'component' ( ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as' )? ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= 'provides' ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )? (otherlv_8= 'requires' ( (otherlv_9= RULE_ID ) ) (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )* )? (otherlv_12= '{' ( (otherlv_13= 'time-bound' otherlv_14= ':' ( (lv_timeBound_15_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_16= 'scheduled' otherlv_17= ':' ( (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_19_0= ruleXProperty ) ) )* otherlv_20= '}' )? )
            // InternalTmscXtext.g:568:3: otherlv_0= 'component' ( ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as' )? ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= 'provides' ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )? (otherlv_8= 'requires' ( (otherlv_9= RULE_ID ) ) (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )* )? (otherlv_12= '{' ( (otherlv_13= 'time-bound' otherlv_14= ':' ( (lv_timeBound_15_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_16= 'scheduled' otherlv_17= ':' ( (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_19_0= ruleXProperty ) ) )* otherlv_20= '}' )?
            {
            otherlv_0=(Token)match(input,24,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getXComponentAccess().getComponentKeyword_0());
              		
            }
            // InternalTmscXtext.g:572:3: ( ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as' )?
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
                    // InternalTmscXtext.g:573:4: ( (lv_description_1_0= ruleIDString ) ) otherlv_2= 'as'
                    {
                    // InternalTmscXtext.g:573:4: ( (lv_description_1_0= ruleIDString ) )
                    // InternalTmscXtext.g:574:5: (lv_description_1_0= ruleIDString )
                    {
                    // InternalTmscXtext.g:574:5: (lv_description_1_0= ruleIDString )
                    // InternalTmscXtext.g:575:6: lv_description_1_0= ruleIDString
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

            // InternalTmscXtext.g:597:3: ( (lv_name_3_0= RULE_ID ) )
            // InternalTmscXtext.g:598:4: (lv_name_3_0= RULE_ID )
            {
            // InternalTmscXtext.g:598:4: (lv_name_3_0= RULE_ID )
            // InternalTmscXtext.g:599:5: lv_name_3_0= RULE_ID
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

            // InternalTmscXtext.g:615:3: (otherlv_4= 'provides' ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==25) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalTmscXtext.g:616:4: otherlv_4= 'provides' ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )*
                    {
                    otherlv_4=(Token)match(input,25,FOLLOW_13); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getXComponentAccess().getProvidesKeyword_3_0());
                      			
                    }
                    // InternalTmscXtext.g:620:4: ( (otherlv_5= RULE_ID ) )
                    // InternalTmscXtext.g:621:5: (otherlv_5= RULE_ID )
                    {
                    // InternalTmscXtext.g:621:5: (otherlv_5= RULE_ID )
                    // InternalTmscXtext.g:622:6: otherlv_5= RULE_ID
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

                    // InternalTmscXtext.g:633:4: (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==26) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // InternalTmscXtext.g:634:5: otherlv_6= ',' ( (otherlv_7= RULE_ID ) )
                    	    {
                    	    otherlv_6=(Token)match(input,26,FOLLOW_13); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_6, grammarAccess.getXComponentAccess().getCommaKeyword_3_2_0());
                    	      				
                    	    }
                    	    // InternalTmscXtext.g:638:5: ( (otherlv_7= RULE_ID ) )
                    	    // InternalTmscXtext.g:639:6: (otherlv_7= RULE_ID )
                    	    {
                    	    // InternalTmscXtext.g:639:6: (otherlv_7= RULE_ID )
                    	    // InternalTmscXtext.g:640:7: otherlv_7= RULE_ID
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

            // InternalTmscXtext.g:653:3: (otherlv_8= 'requires' ( (otherlv_9= RULE_ID ) ) (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )* )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==27) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalTmscXtext.g:654:4: otherlv_8= 'requires' ( (otherlv_9= RULE_ID ) ) (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )*
                    {
                    otherlv_8=(Token)match(input,27,FOLLOW_13); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_8, grammarAccess.getXComponentAccess().getRequiresKeyword_4_0());
                      			
                    }
                    // InternalTmscXtext.g:658:4: ( (otherlv_9= RULE_ID ) )
                    // InternalTmscXtext.g:659:5: (otherlv_9= RULE_ID )
                    {
                    // InternalTmscXtext.g:659:5: (otherlv_9= RULE_ID )
                    // InternalTmscXtext.g:660:6: otherlv_9= RULE_ID
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

                    // InternalTmscXtext.g:671:4: (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==26) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // InternalTmscXtext.g:672:5: otherlv_10= ',' ( (otherlv_11= RULE_ID ) )
                    	    {
                    	    otherlv_10=(Token)match(input,26,FOLLOW_13); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_10, grammarAccess.getXComponentAccess().getCommaKeyword_4_2_0());
                    	      				
                    	    }
                    	    // InternalTmscXtext.g:676:5: ( (otherlv_11= RULE_ID ) )
                    	    // InternalTmscXtext.g:677:6: (otherlv_11= RULE_ID )
                    	    {
                    	    // InternalTmscXtext.g:677:6: (otherlv_11= RULE_ID )
                    	    // InternalTmscXtext.g:678:7: otherlv_11= RULE_ID
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

            // InternalTmscXtext.g:691:3: (otherlv_12= '{' ( (otherlv_13= 'time-bound' otherlv_14= ':' ( (lv_timeBound_15_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_16= 'scheduled' otherlv_17= ':' ( (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_19_0= ruleXProperty ) ) )* otherlv_20= '}' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==15) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalTmscXtext.g:692:4: otherlv_12= '{' ( (otherlv_13= 'time-bound' otherlv_14= ':' ( (lv_timeBound_15_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_16= 'scheduled' otherlv_17= ':' ( (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_19_0= ruleXProperty ) ) )* otherlv_20= '}'
                    {
                    otherlv_12=(Token)match(input,15,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_12, grammarAccess.getXComponentAccess().getLeftCurlyBracketKeyword_5_0());
                      			
                    }
                    // InternalTmscXtext.g:696:4: ( (otherlv_13= 'time-bound' otherlv_14= ':' ( (lv_timeBound_15_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_16= 'scheduled' otherlv_17= ':' ( (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_19_0= ruleXProperty ) ) )*
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
                    	    // InternalTmscXtext.g:697:5: (otherlv_13= 'time-bound' otherlv_14= ':' ( (lv_timeBound_15_0= RULE_ABS_EBIGDECIMAL ) ) )
                    	    {
                    	    // InternalTmscXtext.g:697:5: (otherlv_13= 'time-bound' otherlv_14= ':' ( (lv_timeBound_15_0= RULE_ABS_EBIGDECIMAL ) ) )
                    	    // InternalTmscXtext.g:698:6: otherlv_13= 'time-bound' otherlv_14= ':' ( (lv_timeBound_15_0= RULE_ABS_EBIGDECIMAL ) )
                    	    {
                    	    otherlv_13=(Token)match(input,18,FOLLOW_6); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_13, grammarAccess.getXComponentAccess().getTimeBoundKeyword_5_1_0_0());
                    	      					
                    	    }
                    	    otherlv_14=(Token)match(input,17,FOLLOW_8); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_14, grammarAccess.getXComponentAccess().getColonKeyword_5_1_0_1());
                    	      					
                    	    }
                    	    // InternalTmscXtext.g:706:6: ( (lv_timeBound_15_0= RULE_ABS_EBIGDECIMAL ) )
                    	    // InternalTmscXtext.g:707:7: (lv_timeBound_15_0= RULE_ABS_EBIGDECIMAL )
                    	    {
                    	    // InternalTmscXtext.g:707:7: (lv_timeBound_15_0= RULE_ABS_EBIGDECIMAL )
                    	    // InternalTmscXtext.g:708:8: lv_timeBound_15_0= RULE_ABS_EBIGDECIMAL
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
                    	    // InternalTmscXtext.g:726:5: (otherlv_16= 'scheduled' otherlv_17= ':' ( (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT ) ) )
                    	    {
                    	    // InternalTmscXtext.g:726:5: (otherlv_16= 'scheduled' otherlv_17= ':' ( (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT ) ) )
                    	    // InternalTmscXtext.g:727:6: otherlv_16= 'scheduled' otherlv_17= ':' ( (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT ) )
                    	    {
                    	    otherlv_16=(Token)match(input,19,FOLLOW_6); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_16, grammarAccess.getXComponentAccess().getScheduledKeyword_5_1_1_0());
                    	      					
                    	    }
                    	    otherlv_17=(Token)match(input,17,FOLLOW_9); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_17, grammarAccess.getXComponentAccess().getColonKeyword_5_1_1_1());
                    	      					
                    	    }
                    	    // InternalTmscXtext.g:735:6: ( (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT ) )
                    	    // InternalTmscXtext.g:736:7: (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT )
                    	    {
                    	    // InternalTmscXtext.g:736:7: (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT )
                    	    // InternalTmscXtext.g:737:8: lv_scheduled_18_0= ruleEBOOLEAN_OBJECT
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
                    	    // InternalTmscXtext.g:756:5: ( (lv_properties_19_0= ruleXProperty ) )
                    	    {
                    	    // InternalTmscXtext.g:756:5: ( (lv_properties_19_0= ruleXProperty ) )
                    	    // InternalTmscXtext.g:757:6: (lv_properties_19_0= ruleXProperty )
                    	    {
                    	    // InternalTmscXtext.g:757:6: (lv_properties_19_0= ruleXProperty )
                    	    // InternalTmscXtext.g:758:7: lv_properties_19_0= ruleXProperty
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
    // InternalTmscXtext.g:785:1: entryRuleXFunction returns [EObject current=null] : iv_ruleXFunction= ruleXFunction EOF ;
    public final EObject entryRuleXFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXFunction = null;


        try {
            // InternalTmscXtext.g:785:50: (iv_ruleXFunction= ruleXFunction EOF )
            // InternalTmscXtext.g:786:2: iv_ruleXFunction= ruleXFunction EOF
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
    // InternalTmscXtext.g:792:1: ruleXFunction returns [EObject current=null] : ( ( ( (lv_ipcClient_0_0= 'ipc-client' ) ) | ( (lv_ipcServer_1_0= 'ipc-server' ) ) )? otherlv_2= 'function' ( ( (lv_description_3_0= ruleIDString ) ) otherlv_4= 'as' )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '(' ( (lv_parameters_7_0= ruleXFunctionParameter ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleXFunctionParameter ) ) )* otherlv_10= ')' )? (otherlv_11= 'implements' ( ( ruleFQN ) ) )? (otherlv_13= '{' ( (otherlv_14= 'time-bound' otherlv_15= ':' ( (lv_timeBound_16_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_17= 'scheduled' otherlv_18= ':' ( (lv_scheduled_19_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_20_0= ruleXProperty ) ) )* otherlv_21= '}' )? ) ;
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
            // InternalTmscXtext.g:798:2: ( ( ( ( (lv_ipcClient_0_0= 'ipc-client' ) ) | ( (lv_ipcServer_1_0= 'ipc-server' ) ) )? otherlv_2= 'function' ( ( (lv_description_3_0= ruleIDString ) ) otherlv_4= 'as' )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '(' ( (lv_parameters_7_0= ruleXFunctionParameter ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleXFunctionParameter ) ) )* otherlv_10= ')' )? (otherlv_11= 'implements' ( ( ruleFQN ) ) )? (otherlv_13= '{' ( (otherlv_14= 'time-bound' otherlv_15= ':' ( (lv_timeBound_16_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_17= 'scheduled' otherlv_18= ':' ( (lv_scheduled_19_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_20_0= ruleXProperty ) ) )* otherlv_21= '}' )? ) )
            // InternalTmscXtext.g:799:2: ( ( ( (lv_ipcClient_0_0= 'ipc-client' ) ) | ( (lv_ipcServer_1_0= 'ipc-server' ) ) )? otherlv_2= 'function' ( ( (lv_description_3_0= ruleIDString ) ) otherlv_4= 'as' )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '(' ( (lv_parameters_7_0= ruleXFunctionParameter ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleXFunctionParameter ) ) )* otherlv_10= ')' )? (otherlv_11= 'implements' ( ( ruleFQN ) ) )? (otherlv_13= '{' ( (otherlv_14= 'time-bound' otherlv_15= ':' ( (lv_timeBound_16_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_17= 'scheduled' otherlv_18= ':' ( (lv_scheduled_19_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_20_0= ruleXProperty ) ) )* otherlv_21= '}' )? )
            {
            // InternalTmscXtext.g:799:2: ( ( ( (lv_ipcClient_0_0= 'ipc-client' ) ) | ( (lv_ipcServer_1_0= 'ipc-server' ) ) )? otherlv_2= 'function' ( ( (lv_description_3_0= ruleIDString ) ) otherlv_4= 'as' )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '(' ( (lv_parameters_7_0= ruleXFunctionParameter ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleXFunctionParameter ) ) )* otherlv_10= ')' )? (otherlv_11= 'implements' ( ( ruleFQN ) ) )? (otherlv_13= '{' ( (otherlv_14= 'time-bound' otherlv_15= ':' ( (lv_timeBound_16_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_17= 'scheduled' otherlv_18= ':' ( (lv_scheduled_19_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_20_0= ruleXProperty ) ) )* otherlv_21= '}' )? )
            // InternalTmscXtext.g:800:3: ( ( (lv_ipcClient_0_0= 'ipc-client' ) ) | ( (lv_ipcServer_1_0= 'ipc-server' ) ) )? otherlv_2= 'function' ( ( (lv_description_3_0= ruleIDString ) ) otherlv_4= 'as' )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '(' ( (lv_parameters_7_0= ruleXFunctionParameter ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleXFunctionParameter ) ) )* otherlv_10= ')' )? (otherlv_11= 'implements' ( ( ruleFQN ) ) )? (otherlv_13= '{' ( (otherlv_14= 'time-bound' otherlv_15= ':' ( (lv_timeBound_16_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_17= 'scheduled' otherlv_18= ':' ( (lv_scheduled_19_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_20_0= ruleXProperty ) ) )* otherlv_21= '}' )?
            {
            // InternalTmscXtext.g:800:3: ( ( (lv_ipcClient_0_0= 'ipc-client' ) ) | ( (lv_ipcServer_1_0= 'ipc-server' ) ) )?
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
                    // InternalTmscXtext.g:801:4: ( (lv_ipcClient_0_0= 'ipc-client' ) )
                    {
                    // InternalTmscXtext.g:801:4: ( (lv_ipcClient_0_0= 'ipc-client' ) )
                    // InternalTmscXtext.g:802:5: (lv_ipcClient_0_0= 'ipc-client' )
                    {
                    // InternalTmscXtext.g:802:5: (lv_ipcClient_0_0= 'ipc-client' )
                    // InternalTmscXtext.g:803:6: lv_ipcClient_0_0= 'ipc-client'
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
                    // InternalTmscXtext.g:816:4: ( (lv_ipcServer_1_0= 'ipc-server' ) )
                    {
                    // InternalTmscXtext.g:816:4: ( (lv_ipcServer_1_0= 'ipc-server' ) )
                    // InternalTmscXtext.g:817:5: (lv_ipcServer_1_0= 'ipc-server' )
                    {
                    // InternalTmscXtext.g:817:5: (lv_ipcServer_1_0= 'ipc-server' )
                    // InternalTmscXtext.g:818:6: lv_ipcServer_1_0= 'ipc-server'
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
            // InternalTmscXtext.g:835:3: ( ( (lv_description_3_0= ruleIDString ) ) otherlv_4= 'as' )?
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
                    // InternalTmscXtext.g:836:4: ( (lv_description_3_0= ruleIDString ) ) otherlv_4= 'as'
                    {
                    // InternalTmscXtext.g:836:4: ( (lv_description_3_0= ruleIDString ) )
                    // InternalTmscXtext.g:837:5: (lv_description_3_0= ruleIDString )
                    {
                    // InternalTmscXtext.g:837:5: (lv_description_3_0= ruleIDString )
                    // InternalTmscXtext.g:838:6: lv_description_3_0= ruleIDString
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

            // InternalTmscXtext.g:860:3: ( (lv_name_5_0= RULE_ID ) )
            // InternalTmscXtext.g:861:4: (lv_name_5_0= RULE_ID )
            {
            // InternalTmscXtext.g:861:4: (lv_name_5_0= RULE_ID )
            // InternalTmscXtext.g:862:5: lv_name_5_0= RULE_ID
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

            // InternalTmscXtext.g:878:3: (otherlv_6= '(' ( (lv_parameters_7_0= ruleXFunctionParameter ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleXFunctionParameter ) ) )* otherlv_10= ')' )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==31) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalTmscXtext.g:879:4: otherlv_6= '(' ( (lv_parameters_7_0= ruleXFunctionParameter ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleXFunctionParameter ) ) )* otherlv_10= ')'
                    {
                    otherlv_6=(Token)match(input,31,FOLLOW_21); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_6, grammarAccess.getXFunctionAccess().getLeftParenthesisKeyword_4_0());
                      			
                    }
                    // InternalTmscXtext.g:883:4: ( (lv_parameters_7_0= ruleXFunctionParameter ) )
                    // InternalTmscXtext.g:884:5: (lv_parameters_7_0= ruleXFunctionParameter )
                    {
                    // InternalTmscXtext.g:884:5: (lv_parameters_7_0= ruleXFunctionParameter )
                    // InternalTmscXtext.g:885:6: lv_parameters_7_0= ruleXFunctionParameter
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

                    // InternalTmscXtext.g:902:4: (otherlv_8= ',' ( (lv_parameters_9_0= ruleXFunctionParameter ) ) )*
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0==26) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // InternalTmscXtext.g:903:5: otherlv_8= ',' ( (lv_parameters_9_0= ruleXFunctionParameter ) )
                    	    {
                    	    otherlv_8=(Token)match(input,26,FOLLOW_21); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_8, grammarAccess.getXFunctionAccess().getCommaKeyword_4_2_0());
                    	      				
                    	    }
                    	    // InternalTmscXtext.g:907:5: ( (lv_parameters_9_0= ruleXFunctionParameter ) )
                    	    // InternalTmscXtext.g:908:6: (lv_parameters_9_0= ruleXFunctionParameter )
                    	    {
                    	    // InternalTmscXtext.g:908:6: (lv_parameters_9_0= ruleXFunctionParameter )
                    	    // InternalTmscXtext.g:909:7: lv_parameters_9_0= ruleXFunctionParameter
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

            // InternalTmscXtext.g:932:3: (otherlv_11= 'implements' ( ( ruleFQN ) ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==33) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalTmscXtext.g:933:4: otherlv_11= 'implements' ( ( ruleFQN ) )
                    {
                    otherlv_11=(Token)match(input,33,FOLLOW_13); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_11, grammarAccess.getXFunctionAccess().getImplementsKeyword_5_0());
                      			
                    }
                    // InternalTmscXtext.g:937:4: ( ( ruleFQN ) )
                    // InternalTmscXtext.g:938:5: ( ruleFQN )
                    {
                    // InternalTmscXtext.g:938:5: ( ruleFQN )
                    // InternalTmscXtext.g:939:6: ruleFQN
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

            // InternalTmscXtext.g:954:3: (otherlv_13= '{' ( (otherlv_14= 'time-bound' otherlv_15= ':' ( (lv_timeBound_16_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_17= 'scheduled' otherlv_18= ':' ( (lv_scheduled_19_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_20_0= ruleXProperty ) ) )* otherlv_21= '}' )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==15) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalTmscXtext.g:955:4: otherlv_13= '{' ( (otherlv_14= 'time-bound' otherlv_15= ':' ( (lv_timeBound_16_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_17= 'scheduled' otherlv_18= ':' ( (lv_scheduled_19_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_20_0= ruleXProperty ) ) )* otherlv_21= '}'
                    {
                    otherlv_13=(Token)match(input,15,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_13, grammarAccess.getXFunctionAccess().getLeftCurlyBracketKeyword_6_0());
                      			
                    }
                    // InternalTmscXtext.g:959:4: ( (otherlv_14= 'time-bound' otherlv_15= ':' ( (lv_timeBound_16_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_17= 'scheduled' otherlv_18= ':' ( (lv_scheduled_19_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_20_0= ruleXProperty ) ) )*
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
                    	    // InternalTmscXtext.g:960:5: (otherlv_14= 'time-bound' otherlv_15= ':' ( (lv_timeBound_16_0= RULE_ABS_EBIGDECIMAL ) ) )
                    	    {
                    	    // InternalTmscXtext.g:960:5: (otherlv_14= 'time-bound' otherlv_15= ':' ( (lv_timeBound_16_0= RULE_ABS_EBIGDECIMAL ) ) )
                    	    // InternalTmscXtext.g:961:6: otherlv_14= 'time-bound' otherlv_15= ':' ( (lv_timeBound_16_0= RULE_ABS_EBIGDECIMAL ) )
                    	    {
                    	    otherlv_14=(Token)match(input,18,FOLLOW_6); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_14, grammarAccess.getXFunctionAccess().getTimeBoundKeyword_6_1_0_0());
                    	      					
                    	    }
                    	    otherlv_15=(Token)match(input,17,FOLLOW_8); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_15, grammarAccess.getXFunctionAccess().getColonKeyword_6_1_0_1());
                    	      					
                    	    }
                    	    // InternalTmscXtext.g:969:6: ( (lv_timeBound_16_0= RULE_ABS_EBIGDECIMAL ) )
                    	    // InternalTmscXtext.g:970:7: (lv_timeBound_16_0= RULE_ABS_EBIGDECIMAL )
                    	    {
                    	    // InternalTmscXtext.g:970:7: (lv_timeBound_16_0= RULE_ABS_EBIGDECIMAL )
                    	    // InternalTmscXtext.g:971:8: lv_timeBound_16_0= RULE_ABS_EBIGDECIMAL
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
                    	    // InternalTmscXtext.g:989:5: (otherlv_17= 'scheduled' otherlv_18= ':' ( (lv_scheduled_19_0= ruleEBOOLEAN_OBJECT ) ) )
                    	    {
                    	    // InternalTmscXtext.g:989:5: (otherlv_17= 'scheduled' otherlv_18= ':' ( (lv_scheduled_19_0= ruleEBOOLEAN_OBJECT ) ) )
                    	    // InternalTmscXtext.g:990:6: otherlv_17= 'scheduled' otherlv_18= ':' ( (lv_scheduled_19_0= ruleEBOOLEAN_OBJECT ) )
                    	    {
                    	    otherlv_17=(Token)match(input,19,FOLLOW_6); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_17, grammarAccess.getXFunctionAccess().getScheduledKeyword_6_1_1_0());
                    	      					
                    	    }
                    	    otherlv_18=(Token)match(input,17,FOLLOW_9); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_18, grammarAccess.getXFunctionAccess().getColonKeyword_6_1_1_1());
                    	      					
                    	    }
                    	    // InternalTmscXtext.g:998:6: ( (lv_scheduled_19_0= ruleEBOOLEAN_OBJECT ) )
                    	    // InternalTmscXtext.g:999:7: (lv_scheduled_19_0= ruleEBOOLEAN_OBJECT )
                    	    {
                    	    // InternalTmscXtext.g:999:7: (lv_scheduled_19_0= ruleEBOOLEAN_OBJECT )
                    	    // InternalTmscXtext.g:1000:8: lv_scheduled_19_0= ruleEBOOLEAN_OBJECT
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
                    	    // InternalTmscXtext.g:1019:5: ( (lv_properties_20_0= ruleXProperty ) )
                    	    {
                    	    // InternalTmscXtext.g:1019:5: ( (lv_properties_20_0= ruleXProperty ) )
                    	    // InternalTmscXtext.g:1020:6: (lv_properties_20_0= ruleXProperty )
                    	    {
                    	    // InternalTmscXtext.g:1020:6: (lv_properties_20_0= ruleXProperty )
                    	    // InternalTmscXtext.g:1021:7: lv_properties_20_0= ruleXProperty
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
    // InternalTmscXtext.g:1048:1: entryRuleXFunctionParameter returns [EObject current=null] : iv_ruleXFunctionParameter= ruleXFunctionParameter EOF ;
    public final EObject entryRuleXFunctionParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXFunctionParameter = null;


        try {
            // InternalTmscXtext.g:1048:59: (iv_ruleXFunctionParameter= ruleXFunctionParameter EOF )
            // InternalTmscXtext.g:1049:2: iv_ruleXFunctionParameter= ruleXFunctionParameter EOF
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
    // InternalTmscXtext.g:1055:1: ruleXFunctionParameter returns [EObject current=null] : ( ( (lv_kind_0_0= ruleXFunctionParameterKind ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_properties_3_0= ruleXProperty ) ) (otherlv_4= ',' ( (lv_properties_5_0= ruleXProperty ) ) )* otherlv_6= ')' )? ) ;
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
            // InternalTmscXtext.g:1061:2: ( ( ( (lv_kind_0_0= ruleXFunctionParameterKind ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_properties_3_0= ruleXProperty ) ) (otherlv_4= ',' ( (lv_properties_5_0= ruleXProperty ) ) )* otherlv_6= ')' )? ) )
            // InternalTmscXtext.g:1062:2: ( ( (lv_kind_0_0= ruleXFunctionParameterKind ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_properties_3_0= ruleXProperty ) ) (otherlv_4= ',' ( (lv_properties_5_0= ruleXProperty ) ) )* otherlv_6= ')' )? )
            {
            // InternalTmscXtext.g:1062:2: ( ( (lv_kind_0_0= ruleXFunctionParameterKind ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_properties_3_0= ruleXProperty ) ) (otherlv_4= ',' ( (lv_properties_5_0= ruleXProperty ) ) )* otherlv_6= ')' )? )
            // InternalTmscXtext.g:1063:3: ( (lv_kind_0_0= ruleXFunctionParameterKind ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_properties_3_0= ruleXProperty ) ) (otherlv_4= ',' ( (lv_properties_5_0= ruleXProperty ) ) )* otherlv_6= ')' )?
            {
            // InternalTmscXtext.g:1063:3: ( (lv_kind_0_0= ruleXFunctionParameterKind ) )
            // InternalTmscXtext.g:1064:4: (lv_kind_0_0= ruleXFunctionParameterKind )
            {
            // InternalTmscXtext.g:1064:4: (lv_kind_0_0= ruleXFunctionParameterKind )
            // InternalTmscXtext.g:1065:5: lv_kind_0_0= ruleXFunctionParameterKind
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

            // InternalTmscXtext.g:1082:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalTmscXtext.g:1083:4: (lv_name_1_0= RULE_ID )
            {
            // InternalTmscXtext.g:1083:4: (lv_name_1_0= RULE_ID )
            // InternalTmscXtext.g:1084:5: lv_name_1_0= RULE_ID
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

            // InternalTmscXtext.g:1100:3: (otherlv_2= '(' ( (lv_properties_3_0= ruleXProperty ) ) (otherlv_4= ',' ( (lv_properties_5_0= ruleXProperty ) ) )* otherlv_6= ')' )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==31) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalTmscXtext.g:1101:4: otherlv_2= '(' ( (lv_properties_3_0= ruleXProperty ) ) (otherlv_4= ',' ( (lv_properties_5_0= ruleXProperty ) ) )* otherlv_6= ')'
                    {
                    otherlv_2=(Token)match(input,31,FOLLOW_11); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getXFunctionParameterAccess().getLeftParenthesisKeyword_2_0());
                      			
                    }
                    // InternalTmscXtext.g:1105:4: ( (lv_properties_3_0= ruleXProperty ) )
                    // InternalTmscXtext.g:1106:5: (lv_properties_3_0= ruleXProperty )
                    {
                    // InternalTmscXtext.g:1106:5: (lv_properties_3_0= ruleXProperty )
                    // InternalTmscXtext.g:1107:6: lv_properties_3_0= ruleXProperty
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

                    // InternalTmscXtext.g:1124:4: (otherlv_4= ',' ( (lv_properties_5_0= ruleXProperty ) ) )*
                    loop23:
                    do {
                        int alt23=2;
                        int LA23_0 = input.LA(1);

                        if ( (LA23_0==26) ) {
                            alt23=1;
                        }


                        switch (alt23) {
                    	case 1 :
                    	    // InternalTmscXtext.g:1125:5: otherlv_4= ',' ( (lv_properties_5_0= ruleXProperty ) )
                    	    {
                    	    otherlv_4=(Token)match(input,26,FOLLOW_11); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_4, grammarAccess.getXFunctionParameterAccess().getCommaKeyword_2_2_0());
                    	      				
                    	    }
                    	    // InternalTmscXtext.g:1129:5: ( (lv_properties_5_0= ruleXProperty ) )
                    	    // InternalTmscXtext.g:1130:6: (lv_properties_5_0= ruleXProperty )
                    	    {
                    	    // InternalTmscXtext.g:1130:6: (lv_properties_5_0= ruleXProperty )
                    	    // InternalTmscXtext.g:1131:7: lv_properties_5_0= ruleXProperty
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


    // $ANTLR start "entryRuleXExecutor"
    // InternalTmscXtext.g:1158:1: entryRuleXExecutor returns [EObject current=null] : iv_ruleXExecutor= ruleXExecutor EOF ;
    public final EObject entryRuleXExecutor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXExecutor = null;


        try {
            // InternalTmscXtext.g:1158:50: (iv_ruleXExecutor= ruleXExecutor EOF )
            // InternalTmscXtext.g:1159:2: iv_ruleXExecutor= ruleXExecutor EOF
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
    // InternalTmscXtext.g:1165:1: ruleXExecutor returns [EObject current=null] : ( ( (lv_untraced_0_0= 'untraced' ) )? otherlv_1= 'executor' ( ( (lv_description_2_0= ruleIDString ) ) otherlv_3= 'as' )? ( (lv_name_4_0= RULE_ID ) ) (otherlv_5= '{' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) )* otherlv_13= '}' )? ) ;
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
            // InternalTmscXtext.g:1171:2: ( ( ( (lv_untraced_0_0= 'untraced' ) )? otherlv_1= 'executor' ( ( (lv_description_2_0= ruleIDString ) ) otherlv_3= 'as' )? ( (lv_name_4_0= RULE_ID ) ) (otherlv_5= '{' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) )* otherlv_13= '}' )? ) )
            // InternalTmscXtext.g:1172:2: ( ( (lv_untraced_0_0= 'untraced' ) )? otherlv_1= 'executor' ( ( (lv_description_2_0= ruleIDString ) ) otherlv_3= 'as' )? ( (lv_name_4_0= RULE_ID ) ) (otherlv_5= '{' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) )* otherlv_13= '}' )? )
            {
            // InternalTmscXtext.g:1172:2: ( ( (lv_untraced_0_0= 'untraced' ) )? otherlv_1= 'executor' ( ( (lv_description_2_0= ruleIDString ) ) otherlv_3= 'as' )? ( (lv_name_4_0= RULE_ID ) ) (otherlv_5= '{' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) )* otherlv_13= '}' )? )
            // InternalTmscXtext.g:1173:3: ( (lv_untraced_0_0= 'untraced' ) )? otherlv_1= 'executor' ( ( (lv_description_2_0= ruleIDString ) ) otherlv_3= 'as' )? ( (lv_name_4_0= RULE_ID ) ) (otherlv_5= '{' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) )* otherlv_13= '}' )?
            {
            // InternalTmscXtext.g:1173:3: ( (lv_untraced_0_0= 'untraced' ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==34) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalTmscXtext.g:1174:4: (lv_untraced_0_0= 'untraced' )
                    {
                    // InternalTmscXtext.g:1174:4: (lv_untraced_0_0= 'untraced' )
                    // InternalTmscXtext.g:1175:5: lv_untraced_0_0= 'untraced'
                    {
                    lv_untraced_0_0=(Token)match(input,34,FOLLOW_25); if (state.failed) return current;
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

            otherlv_1=(Token)match(input,35,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getXExecutorAccess().getExecutorKeyword_1());
              		
            }
            // InternalTmscXtext.g:1191:3: ( ( (lv_description_2_0= ruleIDString ) ) otherlv_3= 'as' )?
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
                    // InternalTmscXtext.g:1192:4: ( (lv_description_2_0= ruleIDString ) ) otherlv_3= 'as'
                    {
                    // InternalTmscXtext.g:1192:4: ( (lv_description_2_0= ruleIDString ) )
                    // InternalTmscXtext.g:1193:5: (lv_description_2_0= ruleIDString )
                    {
                    // InternalTmscXtext.g:1193:5: (lv_description_2_0= ruleIDString )
                    // InternalTmscXtext.g:1194:6: lv_description_2_0= ruleIDString
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

            // InternalTmscXtext.g:1216:3: ( (lv_name_4_0= RULE_ID ) )
            // InternalTmscXtext.g:1217:4: (lv_name_4_0= RULE_ID )
            {
            // InternalTmscXtext.g:1217:4: (lv_name_4_0= RULE_ID )
            // InternalTmscXtext.g:1218:5: lv_name_4_0= RULE_ID
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

            // InternalTmscXtext.g:1234:3: (otherlv_5= '{' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) )* otherlv_13= '}' )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==15) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalTmscXtext.g:1235:4: otherlv_5= '{' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) )* otherlv_13= '}'
                    {
                    otherlv_5=(Token)match(input,15,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getXExecutorAccess().getLeftCurlyBracketKeyword_4_0());
                      			
                    }
                    // InternalTmscXtext.g:1239:4: ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) )*
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
                    	    // InternalTmscXtext.g:1240:5: (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) )
                    	    {
                    	    // InternalTmscXtext.g:1240:5: (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) )
                    	    // InternalTmscXtext.g:1241:6: otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) )
                    	    {
                    	    otherlv_6=(Token)match(input,18,FOLLOW_6); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_6, grammarAccess.getXExecutorAccess().getTimeBoundKeyword_4_1_0_0());
                    	      					
                    	    }
                    	    otherlv_7=(Token)match(input,17,FOLLOW_8); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_7, grammarAccess.getXExecutorAccess().getColonKeyword_4_1_0_1());
                    	      					
                    	    }
                    	    // InternalTmscXtext.g:1249:6: ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) )
                    	    // InternalTmscXtext.g:1250:7: (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL )
                    	    {
                    	    // InternalTmscXtext.g:1250:7: (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL )
                    	    // InternalTmscXtext.g:1251:8: lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL
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
                    	    // InternalTmscXtext.g:1269:5: (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) )
                    	    {
                    	    // InternalTmscXtext.g:1269:5: (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) )
                    	    // InternalTmscXtext.g:1270:6: otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) )
                    	    {
                    	    otherlv_9=(Token)match(input,19,FOLLOW_6); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_9, grammarAccess.getXExecutorAccess().getScheduledKeyword_4_1_1_0());
                    	      					
                    	    }
                    	    otherlv_10=(Token)match(input,17,FOLLOW_9); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_10, grammarAccess.getXExecutorAccess().getColonKeyword_4_1_1_1());
                    	      					
                    	    }
                    	    // InternalTmscXtext.g:1278:6: ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) )
                    	    // InternalTmscXtext.g:1279:7: (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT )
                    	    {
                    	    // InternalTmscXtext.g:1279:7: (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT )
                    	    // InternalTmscXtext.g:1280:8: lv_scheduled_11_0= ruleEBOOLEAN_OBJECT
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
                    	    // InternalTmscXtext.g:1299:5: ( (lv_properties_12_0= ruleXProperty ) )
                    	    {
                    	    // InternalTmscXtext.g:1299:5: ( (lv_properties_12_0= ruleXProperty ) )
                    	    // InternalTmscXtext.g:1300:6: (lv_properties_12_0= ruleXProperty )
                    	    {
                    	    // InternalTmscXtext.g:1300:6: (lv_properties_12_0= ruleXProperty )
                    	    // InternalTmscXtext.g:1301:7: lv_properties_12_0= ruleXProperty
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
                    	    break loop27;
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
    // InternalTmscXtext.g:1328:1: entryRuleXEvent returns [EObject current=null] : iv_ruleXEvent= ruleXEvent EOF ;
    public final EObject entryRuleXEvent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXEvent = null;


        try {
            // InternalTmscXtext.g:1328:47: (iv_ruleXEvent= ruleXEvent EOF )
            // InternalTmscXtext.g:1329:2: iv_ruleXEvent= ruleXEvent EOF
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
    // InternalTmscXtext.g:1335:1: ruleXEvent returns [EObject current=null] : ( ( ( (lv_timestamp_0_1= RULE_ISO8601 | lv_timestamp_0_2= RULE_ABS_EBIGDECIMAL ) ) )? ( (lv_timeBound_1_0= RULE_POS_EBIGDECIMAL ) )? ( ( ruleIDString ) ) ( ( ruleIDString ) )? ( (lv_type_4_0= ruleXEventType ) ) ( ( ruleIDString ) ) (otherlv_6= '(' ( (lv_arguments_7_0= ruleXEventArgument ) ) (otherlv_8= ',' ( (lv_arguments_9_0= ruleXEventArgument ) ) )* otherlv_10= ')' )? ( (otherlv_11= '!' ( (lv_outgoingDependencies_12_0= ruleXDependency ) ) ) | (otherlv_13= '?' ( ( ruleIDString ) ) ) )* (otherlv_15= '{' ( (otherlv_16= 'scheduled' otherlv_17= ':' ( (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_19_0= ruleXProperty ) ) )* otherlv_20= '}' )? ) ;
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
            // InternalTmscXtext.g:1341:2: ( ( ( ( (lv_timestamp_0_1= RULE_ISO8601 | lv_timestamp_0_2= RULE_ABS_EBIGDECIMAL ) ) )? ( (lv_timeBound_1_0= RULE_POS_EBIGDECIMAL ) )? ( ( ruleIDString ) ) ( ( ruleIDString ) )? ( (lv_type_4_0= ruleXEventType ) ) ( ( ruleIDString ) ) (otherlv_6= '(' ( (lv_arguments_7_0= ruleXEventArgument ) ) (otherlv_8= ',' ( (lv_arguments_9_0= ruleXEventArgument ) ) )* otherlv_10= ')' )? ( (otherlv_11= '!' ( (lv_outgoingDependencies_12_0= ruleXDependency ) ) ) | (otherlv_13= '?' ( ( ruleIDString ) ) ) )* (otherlv_15= '{' ( (otherlv_16= 'scheduled' otherlv_17= ':' ( (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_19_0= ruleXProperty ) ) )* otherlv_20= '}' )? ) )
            // InternalTmscXtext.g:1342:2: ( ( ( (lv_timestamp_0_1= RULE_ISO8601 | lv_timestamp_0_2= RULE_ABS_EBIGDECIMAL ) ) )? ( (lv_timeBound_1_0= RULE_POS_EBIGDECIMAL ) )? ( ( ruleIDString ) ) ( ( ruleIDString ) )? ( (lv_type_4_0= ruleXEventType ) ) ( ( ruleIDString ) ) (otherlv_6= '(' ( (lv_arguments_7_0= ruleXEventArgument ) ) (otherlv_8= ',' ( (lv_arguments_9_0= ruleXEventArgument ) ) )* otherlv_10= ')' )? ( (otherlv_11= '!' ( (lv_outgoingDependencies_12_0= ruleXDependency ) ) ) | (otherlv_13= '?' ( ( ruleIDString ) ) ) )* (otherlv_15= '{' ( (otherlv_16= 'scheduled' otherlv_17= ':' ( (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_19_0= ruleXProperty ) ) )* otherlv_20= '}' )? )
            {
            // InternalTmscXtext.g:1342:2: ( ( ( (lv_timestamp_0_1= RULE_ISO8601 | lv_timestamp_0_2= RULE_ABS_EBIGDECIMAL ) ) )? ( (lv_timeBound_1_0= RULE_POS_EBIGDECIMAL ) )? ( ( ruleIDString ) ) ( ( ruleIDString ) )? ( (lv_type_4_0= ruleXEventType ) ) ( ( ruleIDString ) ) (otherlv_6= '(' ( (lv_arguments_7_0= ruleXEventArgument ) ) (otherlv_8= ',' ( (lv_arguments_9_0= ruleXEventArgument ) ) )* otherlv_10= ')' )? ( (otherlv_11= '!' ( (lv_outgoingDependencies_12_0= ruleXDependency ) ) ) | (otherlv_13= '?' ( ( ruleIDString ) ) ) )* (otherlv_15= '{' ( (otherlv_16= 'scheduled' otherlv_17= ':' ( (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_19_0= ruleXProperty ) ) )* otherlv_20= '}' )? )
            // InternalTmscXtext.g:1343:3: ( ( (lv_timestamp_0_1= RULE_ISO8601 | lv_timestamp_0_2= RULE_ABS_EBIGDECIMAL ) ) )? ( (lv_timeBound_1_0= RULE_POS_EBIGDECIMAL ) )? ( ( ruleIDString ) ) ( ( ruleIDString ) )? ( (lv_type_4_0= ruleXEventType ) ) ( ( ruleIDString ) ) (otherlv_6= '(' ( (lv_arguments_7_0= ruleXEventArgument ) ) (otherlv_8= ',' ( (lv_arguments_9_0= ruleXEventArgument ) ) )* otherlv_10= ')' )? ( (otherlv_11= '!' ( (lv_outgoingDependencies_12_0= ruleXDependency ) ) ) | (otherlv_13= '?' ( ( ruleIDString ) ) ) )* (otherlv_15= '{' ( (otherlv_16= 'scheduled' otherlv_17= ':' ( (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_19_0= ruleXProperty ) ) )* otherlv_20= '}' )?
            {
            // InternalTmscXtext.g:1343:3: ( ( (lv_timestamp_0_1= RULE_ISO8601 | lv_timestamp_0_2= RULE_ABS_EBIGDECIMAL ) ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==RULE_ABS_EBIGDECIMAL||LA30_0==RULE_ISO8601) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalTmscXtext.g:1344:4: ( (lv_timestamp_0_1= RULE_ISO8601 | lv_timestamp_0_2= RULE_ABS_EBIGDECIMAL ) )
                    {
                    // InternalTmscXtext.g:1344:4: ( (lv_timestamp_0_1= RULE_ISO8601 | lv_timestamp_0_2= RULE_ABS_EBIGDECIMAL ) )
                    // InternalTmscXtext.g:1345:5: (lv_timestamp_0_1= RULE_ISO8601 | lv_timestamp_0_2= RULE_ABS_EBIGDECIMAL )
                    {
                    // InternalTmscXtext.g:1345:5: (lv_timestamp_0_1= RULE_ISO8601 | lv_timestamp_0_2= RULE_ABS_EBIGDECIMAL )
                    int alt29=2;
                    int LA29_0 = input.LA(1);

                    if ( (LA29_0==RULE_ISO8601) ) {
                        alt29=1;
                    }
                    else if ( (LA29_0==RULE_ABS_EBIGDECIMAL) ) {
                        alt29=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 29, 0, input);

                        throw nvae;
                    }
                    switch (alt29) {
                        case 1 :
                            // InternalTmscXtext.g:1346:6: lv_timestamp_0_1= RULE_ISO8601
                            {
                            lv_timestamp_0_1=(Token)match(input,RULE_ISO8601,FOLLOW_26); if (state.failed) return current;
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
                            // InternalTmscXtext.g:1361:6: lv_timestamp_0_2= RULE_ABS_EBIGDECIMAL
                            {
                            lv_timestamp_0_2=(Token)match(input,RULE_ABS_EBIGDECIMAL,FOLLOW_26); if (state.failed) return current;
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

            // InternalTmscXtext.g:1378:3: ( (lv_timeBound_1_0= RULE_POS_EBIGDECIMAL ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==RULE_POS_EBIGDECIMAL) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalTmscXtext.g:1379:4: (lv_timeBound_1_0= RULE_POS_EBIGDECIMAL )
                    {
                    // InternalTmscXtext.g:1379:4: (lv_timeBound_1_0= RULE_POS_EBIGDECIMAL )
                    // InternalTmscXtext.g:1380:5: lv_timeBound_1_0= RULE_POS_EBIGDECIMAL
                    {
                    lv_timeBound_1_0=(Token)match(input,RULE_POS_EBIGDECIMAL,FOLLOW_11); if (state.failed) return current;
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

            // InternalTmscXtext.g:1396:3: ( ( ruleIDString ) )
            // InternalTmscXtext.g:1397:4: ( ruleIDString )
            {
            // InternalTmscXtext.g:1397:4: ( ruleIDString )
            // InternalTmscXtext.g:1398:5: ruleIDString
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getXEventRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getXEventAccess().getExecutorXExecutorCrossReference_2_0());
              				
            }
            pushFollow(FOLLOW_27);
            ruleIDString();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalTmscXtext.g:1412:3: ( ( ruleIDString ) )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==RULE_ID||LA32_0==RULE_STRING) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalTmscXtext.g:1413:4: ( ruleIDString )
                    {
                    // InternalTmscXtext.g:1413:4: ( ruleIDString )
                    // InternalTmscXtext.g:1414:5: ruleIDString
                    {
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getXEventRule());
                      					}
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getXEventAccess().getComponentXComponentCrossReference_3_0());
                      				
                    }
                    pushFollow(FOLLOW_27);
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

            // InternalTmscXtext.g:1428:3: ( (lv_type_4_0= ruleXEventType ) )
            // InternalTmscXtext.g:1429:4: (lv_type_4_0= ruleXEventType )
            {
            // InternalTmscXtext.g:1429:4: (lv_type_4_0= ruleXEventType )
            // InternalTmscXtext.g:1430:5: lv_type_4_0= ruleXEventType
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

            // InternalTmscXtext.g:1447:3: ( ( ruleIDString ) )
            // InternalTmscXtext.g:1448:4: ( ruleIDString )
            {
            // InternalTmscXtext.g:1448:4: ( ruleIDString )
            // InternalTmscXtext.g:1449:5: ruleIDString
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getXEventRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getXEventAccess().getFunctionXFunctionCrossReference_5_0());
              				
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

            // InternalTmscXtext.g:1463:3: (otherlv_6= '(' ( (lv_arguments_7_0= ruleXEventArgument ) ) (otherlv_8= ',' ( (lv_arguments_9_0= ruleXEventArgument ) ) )* otherlv_10= ')' )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==31) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalTmscXtext.g:1464:4: otherlv_6= '(' ( (lv_arguments_7_0= ruleXEventArgument ) ) (otherlv_8= ',' ( (lv_arguments_9_0= ruleXEventArgument ) ) )* otherlv_10= ')'
                    {
                    otherlv_6=(Token)match(input,31,FOLLOW_13); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_6, grammarAccess.getXEventAccess().getLeftParenthesisKeyword_6_0());
                      			
                    }
                    // InternalTmscXtext.g:1468:4: ( (lv_arguments_7_0= ruleXEventArgument ) )
                    // InternalTmscXtext.g:1469:5: (lv_arguments_7_0= ruleXEventArgument )
                    {
                    // InternalTmscXtext.g:1469:5: (lv_arguments_7_0= ruleXEventArgument )
                    // InternalTmscXtext.g:1470:6: lv_arguments_7_0= ruleXEventArgument
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

                    // InternalTmscXtext.g:1487:4: (otherlv_8= ',' ( (lv_arguments_9_0= ruleXEventArgument ) ) )*
                    loop33:
                    do {
                        int alt33=2;
                        int LA33_0 = input.LA(1);

                        if ( (LA33_0==26) ) {
                            alt33=1;
                        }


                        switch (alt33) {
                    	case 1 :
                    	    // InternalTmscXtext.g:1488:5: otherlv_8= ',' ( (lv_arguments_9_0= ruleXEventArgument ) )
                    	    {
                    	    otherlv_8=(Token)match(input,26,FOLLOW_13); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_8, grammarAccess.getXEventAccess().getCommaKeyword_6_2_0());
                    	      				
                    	    }
                    	    // InternalTmscXtext.g:1492:5: ( (lv_arguments_9_0= ruleXEventArgument ) )
                    	    // InternalTmscXtext.g:1493:6: (lv_arguments_9_0= ruleXEventArgument )
                    	    {
                    	    // InternalTmscXtext.g:1493:6: (lv_arguments_9_0= ruleXEventArgument )
                    	    // InternalTmscXtext.g:1494:7: lv_arguments_9_0= ruleXEventArgument
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
                    	    break loop33;
                        }
                    } while (true);

                    otherlv_10=(Token)match(input,32,FOLLOW_29); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_10, grammarAccess.getXEventAccess().getRightParenthesisKeyword_6_3());
                      			
                    }

                    }
                    break;

            }

            // InternalTmscXtext.g:1517:3: ( (otherlv_11= '!' ( (lv_outgoingDependencies_12_0= ruleXDependency ) ) ) | (otherlv_13= '?' ( ( ruleIDString ) ) ) )*
            loop35:
            do {
                int alt35=3;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==36) ) {
                    alt35=1;
                }
                else if ( (LA35_0==37) ) {
                    alt35=2;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalTmscXtext.g:1518:4: (otherlv_11= '!' ( (lv_outgoingDependencies_12_0= ruleXDependency ) ) )
            	    {
            	    // InternalTmscXtext.g:1518:4: (otherlv_11= '!' ( (lv_outgoingDependencies_12_0= ruleXDependency ) ) )
            	    // InternalTmscXtext.g:1519:5: otherlv_11= '!' ( (lv_outgoingDependencies_12_0= ruleXDependency ) )
            	    {
            	    otherlv_11=(Token)match(input,36,FOLLOW_30); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_11, grammarAccess.getXEventAccess().getExclamationMarkKeyword_7_0_0());
            	      				
            	    }
            	    // InternalTmscXtext.g:1523:5: ( (lv_outgoingDependencies_12_0= ruleXDependency ) )
            	    // InternalTmscXtext.g:1524:6: (lv_outgoingDependencies_12_0= ruleXDependency )
            	    {
            	    // InternalTmscXtext.g:1524:6: (lv_outgoingDependencies_12_0= ruleXDependency )
            	    // InternalTmscXtext.g:1525:7: lv_outgoingDependencies_12_0= ruleXDependency
            	    {
            	    if ( state.backtracking==0 ) {

            	      							newCompositeNode(grammarAccess.getXEventAccess().getOutgoingDependenciesXDependencyParserRuleCall_7_0_1_0());
            	      						
            	    }
            	    pushFollow(FOLLOW_29);
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
            	    // InternalTmscXtext.g:1544:4: (otherlv_13= '?' ( ( ruleIDString ) ) )
            	    {
            	    // InternalTmscXtext.g:1544:4: (otherlv_13= '?' ( ( ruleIDString ) ) )
            	    // InternalTmscXtext.g:1545:5: otherlv_13= '?' ( ( ruleIDString ) )
            	    {
            	    otherlv_13=(Token)match(input,37,FOLLOW_11); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_13, grammarAccess.getXEventAccess().getQuestionMarkKeyword_7_1_0());
            	      				
            	    }
            	    // InternalTmscXtext.g:1549:5: ( ( ruleIDString ) )
            	    // InternalTmscXtext.g:1550:6: ( ruleIDString )
            	    {
            	    // InternalTmscXtext.g:1550:6: ( ruleIDString )
            	    // InternalTmscXtext.g:1551:7: ruleIDString
            	    {
            	    if ( state.backtracking==0 ) {

            	      							if (current==null) {
            	      								current = createModelElement(grammarAccess.getXEventRule());
            	      							}
            	      						
            	    }
            	    if ( state.backtracking==0 ) {

            	      							newCompositeNode(grammarAccess.getXEventAccess().getIncomingDependenciesXDependencyCrossReference_7_1_1_0());
            	      						
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

            	default :
            	    break loop35;
                }
            } while (true);

            // InternalTmscXtext.g:1567:3: (otherlv_15= '{' ( (otherlv_16= 'scheduled' otherlv_17= ':' ( (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_19_0= ruleXProperty ) ) )* otherlv_20= '}' )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==15) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalTmscXtext.g:1568:4: otherlv_15= '{' ( (otherlv_16= 'scheduled' otherlv_17= ':' ( (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_19_0= ruleXProperty ) ) )* otherlv_20= '}'
                    {
                    otherlv_15=(Token)match(input,15,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_15, grammarAccess.getXEventAccess().getLeftCurlyBracketKeyword_8_0());
                      			
                    }
                    // InternalTmscXtext.g:1572:4: ( (otherlv_16= 'scheduled' otherlv_17= ':' ( (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT ) ) ) | ( (lv_properties_19_0= ruleXProperty ) ) )*
                    loop36:
                    do {
                        int alt36=3;
                        int LA36_0 = input.LA(1);

                        if ( (LA36_0==19) ) {
                            alt36=1;
                        }
                        else if ( (LA36_0==RULE_ID||LA36_0==RULE_STRING) ) {
                            alt36=2;
                        }


                        switch (alt36) {
                    	case 1 :
                    	    // InternalTmscXtext.g:1573:5: (otherlv_16= 'scheduled' otherlv_17= ':' ( (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT ) ) )
                    	    {
                    	    // InternalTmscXtext.g:1573:5: (otherlv_16= 'scheduled' otherlv_17= ':' ( (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT ) ) )
                    	    // InternalTmscXtext.g:1574:6: otherlv_16= 'scheduled' otherlv_17= ':' ( (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT ) )
                    	    {
                    	    otherlv_16=(Token)match(input,19,FOLLOW_6); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_16, grammarAccess.getXEventAccess().getScheduledKeyword_8_1_0_0());
                    	      					
                    	    }
                    	    otherlv_17=(Token)match(input,17,FOLLOW_9); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_17, grammarAccess.getXEventAccess().getColonKeyword_8_1_0_1());
                    	      					
                    	    }
                    	    // InternalTmscXtext.g:1582:6: ( (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT ) )
                    	    // InternalTmscXtext.g:1583:7: (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT )
                    	    {
                    	    // InternalTmscXtext.g:1583:7: (lv_scheduled_18_0= ruleEBOOLEAN_OBJECT )
                    	    // InternalTmscXtext.g:1584:8: lv_scheduled_18_0= ruleEBOOLEAN_OBJECT
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
                    	    // InternalTmscXtext.g:1603:5: ( (lv_properties_19_0= ruleXProperty ) )
                    	    {
                    	    // InternalTmscXtext.g:1603:5: ( (lv_properties_19_0= ruleXProperty ) )
                    	    // InternalTmscXtext.g:1604:6: (lv_properties_19_0= ruleXProperty )
                    	    {
                    	    // InternalTmscXtext.g:1604:6: (lv_properties_19_0= ruleXProperty )
                    	    // InternalTmscXtext.g:1605:7: lv_properties_19_0= ruleXProperty
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
                    	    break loop36;
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
    // InternalTmscXtext.g:1632:1: entryRuleXEventArgument returns [EObject current=null] : iv_ruleXEventArgument= ruleXEventArgument EOF ;
    public final EObject entryRuleXEventArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXEventArgument = null;


        try {
            // InternalTmscXtext.g:1632:55: (iv_ruleXEventArgument= ruleXEventArgument EOF )
            // InternalTmscXtext.g:1633:2: iv_ruleXEventArgument= ruleXEventArgument EOF
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
    // InternalTmscXtext.g:1639:1: ruleXEventArgument returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' ( (lv_value_2_0= ruleIDString ) ) ) ;
    public final EObject ruleXEventArgument() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalTmscXtext.g:1645:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' ( (lv_value_2_0= ruleIDString ) ) ) )
            // InternalTmscXtext.g:1646:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' ( (lv_value_2_0= ruleIDString ) ) )
            {
            // InternalTmscXtext.g:1646:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' ( (lv_value_2_0= ruleIDString ) ) )
            // InternalTmscXtext.g:1647:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' ( (lv_value_2_0= ruleIDString ) )
            {
            // InternalTmscXtext.g:1647:3: ( (otherlv_0= RULE_ID ) )
            // InternalTmscXtext.g:1648:4: (otherlv_0= RULE_ID )
            {
            // InternalTmscXtext.g:1648:4: (otherlv_0= RULE_ID )
            // InternalTmscXtext.g:1649:5: otherlv_0= RULE_ID
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
            // InternalTmscXtext.g:1664:3: ( (lv_value_2_0= ruleIDString ) )
            // InternalTmscXtext.g:1665:4: (lv_value_2_0= ruleIDString )
            {
            // InternalTmscXtext.g:1665:4: (lv_value_2_0= ruleIDString )
            // InternalTmscXtext.g:1666:5: lv_value_2_0= ruleIDString
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
    // InternalTmscXtext.g:1687:1: entryRuleXDependency returns [EObject current=null] : iv_ruleXDependency= ruleXDependency EOF ;
    public final EObject entryRuleXDependency() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXDependency = null;


        try {
            // InternalTmscXtext.g:1687:52: (iv_ruleXDependency= ruleXDependency EOF )
            // InternalTmscXtext.g:1688:2: iv_ruleXDependency= ruleXDependency EOF
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
    // InternalTmscXtext.g:1694:1: ruleXDependency returns [EObject current=null] : ( ( (lv_typeObject_0_0= ruleXDependencyTypeObject ) )? ( (lv_name_1_0= ruleIDString ) ) ( (otherlv_2= '(' ( (lv_timeBound_3_0= RULE_ABS_EBIGDECIMAL ) ) otherlv_4= ')' ) | (otherlv_5= '(' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_12= 'request' otherlv_13= ':' ( ( ruleIDString ) ) ) | (otherlv_15= 'message' otherlv_16= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_18_0= ruleXProperty ) ) ) (otherlv_19= ',' ( (otherlv_20= 'time-bound' otherlv_21= ':' ( (lv_timeBound_22_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_23= 'scheduled' otherlv_24= ':' ( (lv_scheduled_25_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_26= 'request' otherlv_27= ':' ( ( ruleIDString ) ) ) | (otherlv_29= 'message' otherlv_30= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_32_0= ruleXProperty ) ) ) )* otherlv_33= ')' ) )? ) ;
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
            // InternalTmscXtext.g:1700:2: ( ( ( (lv_typeObject_0_0= ruleXDependencyTypeObject ) )? ( (lv_name_1_0= ruleIDString ) ) ( (otherlv_2= '(' ( (lv_timeBound_3_0= RULE_ABS_EBIGDECIMAL ) ) otherlv_4= ')' ) | (otherlv_5= '(' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_12= 'request' otherlv_13= ':' ( ( ruleIDString ) ) ) | (otherlv_15= 'message' otherlv_16= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_18_0= ruleXProperty ) ) ) (otherlv_19= ',' ( (otherlv_20= 'time-bound' otherlv_21= ':' ( (lv_timeBound_22_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_23= 'scheduled' otherlv_24= ':' ( (lv_scheduled_25_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_26= 'request' otherlv_27= ':' ( ( ruleIDString ) ) ) | (otherlv_29= 'message' otherlv_30= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_32_0= ruleXProperty ) ) ) )* otherlv_33= ')' ) )? ) )
            // InternalTmscXtext.g:1701:2: ( ( (lv_typeObject_0_0= ruleXDependencyTypeObject ) )? ( (lv_name_1_0= ruleIDString ) ) ( (otherlv_2= '(' ( (lv_timeBound_3_0= RULE_ABS_EBIGDECIMAL ) ) otherlv_4= ')' ) | (otherlv_5= '(' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_12= 'request' otherlv_13= ':' ( ( ruleIDString ) ) ) | (otherlv_15= 'message' otherlv_16= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_18_0= ruleXProperty ) ) ) (otherlv_19= ',' ( (otherlv_20= 'time-bound' otherlv_21= ':' ( (lv_timeBound_22_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_23= 'scheduled' otherlv_24= ':' ( (lv_scheduled_25_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_26= 'request' otherlv_27= ':' ( ( ruleIDString ) ) ) | (otherlv_29= 'message' otherlv_30= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_32_0= ruleXProperty ) ) ) )* otherlv_33= ')' ) )? )
            {
            // InternalTmscXtext.g:1701:2: ( ( (lv_typeObject_0_0= ruleXDependencyTypeObject ) )? ( (lv_name_1_0= ruleIDString ) ) ( (otherlv_2= '(' ( (lv_timeBound_3_0= RULE_ABS_EBIGDECIMAL ) ) otherlv_4= ')' ) | (otherlv_5= '(' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_12= 'request' otherlv_13= ':' ( ( ruleIDString ) ) ) | (otherlv_15= 'message' otherlv_16= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_18_0= ruleXProperty ) ) ) (otherlv_19= ',' ( (otherlv_20= 'time-bound' otherlv_21= ':' ( (lv_timeBound_22_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_23= 'scheduled' otherlv_24= ':' ( (lv_scheduled_25_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_26= 'request' otherlv_27= ':' ( ( ruleIDString ) ) ) | (otherlv_29= 'message' otherlv_30= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_32_0= ruleXProperty ) ) ) )* otherlv_33= ')' ) )? )
            // InternalTmscXtext.g:1702:3: ( (lv_typeObject_0_0= ruleXDependencyTypeObject ) )? ( (lv_name_1_0= ruleIDString ) ) ( (otherlv_2= '(' ( (lv_timeBound_3_0= RULE_ABS_EBIGDECIMAL ) ) otherlv_4= ')' ) | (otherlv_5= '(' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_12= 'request' otherlv_13= ':' ( ( ruleIDString ) ) ) | (otherlv_15= 'message' otherlv_16= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_18_0= ruleXProperty ) ) ) (otherlv_19= ',' ( (otherlv_20= 'time-bound' otherlv_21= ':' ( (lv_timeBound_22_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_23= 'scheduled' otherlv_24= ':' ( (lv_scheduled_25_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_26= 'request' otherlv_27= ':' ( ( ruleIDString ) ) ) | (otherlv_29= 'message' otherlv_30= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_32_0= ruleXProperty ) ) ) )* otherlv_33= ')' ) )?
            {
            // InternalTmscXtext.g:1702:3: ( (lv_typeObject_0_0= ruleXDependencyTypeObject ) )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( ((LA38_0>=38 && LA38_0<=39)||(LA38_0>=54 && LA38_0<=57)) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalTmscXtext.g:1703:4: (lv_typeObject_0_0= ruleXDependencyTypeObject )
                    {
                    // InternalTmscXtext.g:1703:4: (lv_typeObject_0_0= ruleXDependencyTypeObject )
                    // InternalTmscXtext.g:1704:5: lv_typeObject_0_0= ruleXDependencyTypeObject
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

            // InternalTmscXtext.g:1721:3: ( (lv_name_1_0= ruleIDString ) )
            // InternalTmscXtext.g:1722:4: (lv_name_1_0= ruleIDString )
            {
            // InternalTmscXtext.g:1722:4: (lv_name_1_0= ruleIDString )
            // InternalTmscXtext.g:1723:5: lv_name_1_0= ruleIDString
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

            // InternalTmscXtext.g:1740:3: ( (otherlv_2= '(' ( (lv_timeBound_3_0= RULE_ABS_EBIGDECIMAL ) ) otherlv_4= ')' ) | (otherlv_5= '(' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_12= 'request' otherlv_13= ':' ( ( ruleIDString ) ) ) | (otherlv_15= 'message' otherlv_16= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_18_0= ruleXProperty ) ) ) (otherlv_19= ',' ( (otherlv_20= 'time-bound' otherlv_21= ':' ( (lv_timeBound_22_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_23= 'scheduled' otherlv_24= ':' ( (lv_scheduled_25_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_26= 'request' otherlv_27= ':' ( ( ruleIDString ) ) ) | (otherlv_29= 'message' otherlv_30= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_32_0= ruleXProperty ) ) ) )* otherlv_33= ')' ) )?
            int alt42=3;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==31) ) {
                int LA42_1 = input.LA(2);

                if ( (LA42_1==RULE_ABS_EBIGDECIMAL) ) {
                    alt42=1;
                }
                else if ( (LA42_1==RULE_ID||LA42_1==RULE_STRING||(LA42_1>=18 && LA42_1<=19)||(LA42_1>=38 && LA42_1<=39)) ) {
                    alt42=2;
                }
            }
            switch (alt42) {
                case 1 :
                    // InternalTmscXtext.g:1741:4: (otherlv_2= '(' ( (lv_timeBound_3_0= RULE_ABS_EBIGDECIMAL ) ) otherlv_4= ')' )
                    {
                    // InternalTmscXtext.g:1741:4: (otherlv_2= '(' ( (lv_timeBound_3_0= RULE_ABS_EBIGDECIMAL ) ) otherlv_4= ')' )
                    // InternalTmscXtext.g:1742:5: otherlv_2= '(' ( (lv_timeBound_3_0= RULE_ABS_EBIGDECIMAL ) ) otherlv_4= ')'
                    {
                    otherlv_2=(Token)match(input,31,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_2, grammarAccess.getXDependencyAccess().getLeftParenthesisKeyword_2_0_0());
                      				
                    }
                    // InternalTmscXtext.g:1746:5: ( (lv_timeBound_3_0= RULE_ABS_EBIGDECIMAL ) )
                    // InternalTmscXtext.g:1747:6: (lv_timeBound_3_0= RULE_ABS_EBIGDECIMAL )
                    {
                    // InternalTmscXtext.g:1747:6: (lv_timeBound_3_0= RULE_ABS_EBIGDECIMAL )
                    // InternalTmscXtext.g:1748:7: lv_timeBound_3_0= RULE_ABS_EBIGDECIMAL
                    {
                    lv_timeBound_3_0=(Token)match(input,RULE_ABS_EBIGDECIMAL,FOLLOW_31); if (state.failed) return current;
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
                    // InternalTmscXtext.g:1770:4: (otherlv_5= '(' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_12= 'request' otherlv_13= ':' ( ( ruleIDString ) ) ) | (otherlv_15= 'message' otherlv_16= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_18_0= ruleXProperty ) ) ) (otherlv_19= ',' ( (otherlv_20= 'time-bound' otherlv_21= ':' ( (lv_timeBound_22_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_23= 'scheduled' otherlv_24= ':' ( (lv_scheduled_25_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_26= 'request' otherlv_27= ':' ( ( ruleIDString ) ) ) | (otherlv_29= 'message' otherlv_30= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_32_0= ruleXProperty ) ) ) )* otherlv_33= ')' )
                    {
                    // InternalTmscXtext.g:1770:4: (otherlv_5= '(' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_12= 'request' otherlv_13= ':' ( ( ruleIDString ) ) ) | (otherlv_15= 'message' otherlv_16= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_18_0= ruleXProperty ) ) ) (otherlv_19= ',' ( (otherlv_20= 'time-bound' otherlv_21= ':' ( (lv_timeBound_22_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_23= 'scheduled' otherlv_24= ':' ( (lv_scheduled_25_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_26= 'request' otherlv_27= ':' ( ( ruleIDString ) ) ) | (otherlv_29= 'message' otherlv_30= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_32_0= ruleXProperty ) ) ) )* otherlv_33= ')' )
                    // InternalTmscXtext.g:1771:5: otherlv_5= '(' ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_12= 'request' otherlv_13= ':' ( ( ruleIDString ) ) ) | (otherlv_15= 'message' otherlv_16= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_18_0= ruleXProperty ) ) ) (otherlv_19= ',' ( (otherlv_20= 'time-bound' otherlv_21= ':' ( (lv_timeBound_22_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_23= 'scheduled' otherlv_24= ':' ( (lv_scheduled_25_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_26= 'request' otherlv_27= ':' ( ( ruleIDString ) ) ) | (otherlv_29= 'message' otherlv_30= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_32_0= ruleXProperty ) ) ) )* otherlv_33= ')'
                    {
                    otherlv_5=(Token)match(input,31,FOLLOW_32); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_5, grammarAccess.getXDependencyAccess().getLeftParenthesisKeyword_2_1_0());
                      				
                    }
                    // InternalTmscXtext.g:1775:5: ( (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_12= 'request' otherlv_13= ':' ( ( ruleIDString ) ) ) | (otherlv_15= 'message' otherlv_16= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_18_0= ruleXProperty ) ) )
                    int alt39=5;
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
                    case 38:
                        {
                        alt39=3;
                        }
                        break;
                    case 39:
                        {
                        alt39=4;
                        }
                        break;
                    case RULE_ID:
                    case RULE_STRING:
                        {
                        alt39=5;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 39, 0, input);

                        throw nvae;
                    }

                    switch (alt39) {
                        case 1 :
                            // InternalTmscXtext.g:1776:6: (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) )
                            {
                            // InternalTmscXtext.g:1776:6: (otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) ) )
                            // InternalTmscXtext.g:1777:7: otherlv_6= 'time-bound' otherlv_7= ':' ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) )
                            {
                            otherlv_6=(Token)match(input,18,FOLLOW_6); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(otherlv_6, grammarAccess.getXDependencyAccess().getTimeBoundKeyword_2_1_1_0_0());
                              						
                            }
                            otherlv_7=(Token)match(input,17,FOLLOW_8); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(otherlv_7, grammarAccess.getXDependencyAccess().getColonKeyword_2_1_1_0_1());
                              						
                            }
                            // InternalTmscXtext.g:1785:7: ( (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL ) )
                            // InternalTmscXtext.g:1786:8: (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL )
                            {
                            // InternalTmscXtext.g:1786:8: (lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL )
                            // InternalTmscXtext.g:1787:9: lv_timeBound_8_0= RULE_ABS_EBIGDECIMAL
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
                            // InternalTmscXtext.g:1805:6: (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) )
                            {
                            // InternalTmscXtext.g:1805:6: (otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) ) )
                            // InternalTmscXtext.g:1806:7: otherlv_9= 'scheduled' otherlv_10= ':' ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) )
                            {
                            otherlv_9=(Token)match(input,19,FOLLOW_6); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(otherlv_9, grammarAccess.getXDependencyAccess().getScheduledKeyword_2_1_1_1_0());
                              						
                            }
                            otherlv_10=(Token)match(input,17,FOLLOW_9); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(otherlv_10, grammarAccess.getXDependencyAccess().getColonKeyword_2_1_1_1_1());
                              						
                            }
                            // InternalTmscXtext.g:1814:7: ( (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT ) )
                            // InternalTmscXtext.g:1815:8: (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT )
                            {
                            // InternalTmscXtext.g:1815:8: (lv_scheduled_11_0= ruleEBOOLEAN_OBJECT )
                            // InternalTmscXtext.g:1816:9: lv_scheduled_11_0= ruleEBOOLEAN_OBJECT
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
                            // InternalTmscXtext.g:1835:6: (otherlv_12= 'request' otherlv_13= ':' ( ( ruleIDString ) ) )
                            {
                            // InternalTmscXtext.g:1835:6: (otherlv_12= 'request' otherlv_13= ':' ( ( ruleIDString ) ) )
                            // InternalTmscXtext.g:1836:7: otherlv_12= 'request' otherlv_13= ':' ( ( ruleIDString ) )
                            {
                            otherlv_12=(Token)match(input,38,FOLLOW_6); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(otherlv_12, grammarAccess.getXDependencyAccess().getRequestKeyword_2_1_1_2_0());
                              						
                            }
                            otherlv_13=(Token)match(input,17,FOLLOW_11); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(otherlv_13, grammarAccess.getXDependencyAccess().getColonKeyword_2_1_1_2_1());
                              						
                            }
                            // InternalTmscXtext.g:1844:7: ( ( ruleIDString ) )
                            // InternalTmscXtext.g:1845:8: ( ruleIDString )
                            {
                            // InternalTmscXtext.g:1845:8: ( ruleIDString )
                            // InternalTmscXtext.g:1846:9: ruleIDString
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
                            // InternalTmscXtext.g:1862:6: (otherlv_15= 'message' otherlv_16= ':' ( ( ruleIDString ) ) )
                            {
                            // InternalTmscXtext.g:1862:6: (otherlv_15= 'message' otherlv_16= ':' ( ( ruleIDString ) ) )
                            // InternalTmscXtext.g:1863:7: otherlv_15= 'message' otherlv_16= ':' ( ( ruleIDString ) )
                            {
                            otherlv_15=(Token)match(input,39,FOLLOW_6); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(otherlv_15, grammarAccess.getXDependencyAccess().getMessageKeyword_2_1_1_3_0());
                              						
                            }
                            otherlv_16=(Token)match(input,17,FOLLOW_11); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(otherlv_16, grammarAccess.getXDependencyAccess().getColonKeyword_2_1_1_3_1());
                              						
                            }
                            // InternalTmscXtext.g:1871:7: ( ( ruleIDString ) )
                            // InternalTmscXtext.g:1872:8: ( ruleIDString )
                            {
                            // InternalTmscXtext.g:1872:8: ( ruleIDString )
                            // InternalTmscXtext.g:1873:9: ruleIDString
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
                            // InternalTmscXtext.g:1889:6: ( (lv_properties_18_0= ruleXProperty ) )
                            {
                            // InternalTmscXtext.g:1889:6: ( (lv_properties_18_0= ruleXProperty ) )
                            // InternalTmscXtext.g:1890:7: (lv_properties_18_0= ruleXProperty )
                            {
                            // InternalTmscXtext.g:1890:7: (lv_properties_18_0= ruleXProperty )
                            // InternalTmscXtext.g:1891:8: lv_properties_18_0= ruleXProperty
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

                    // InternalTmscXtext.g:1909:5: (otherlv_19= ',' ( (otherlv_20= 'time-bound' otherlv_21= ':' ( (lv_timeBound_22_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_23= 'scheduled' otherlv_24= ':' ( (lv_scheduled_25_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_26= 'request' otherlv_27= ':' ( ( ruleIDString ) ) ) | (otherlv_29= 'message' otherlv_30= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_32_0= ruleXProperty ) ) ) )*
                    loop41:
                    do {
                        int alt41=2;
                        int LA41_0 = input.LA(1);

                        if ( (LA41_0==26) ) {
                            alt41=1;
                        }


                        switch (alt41) {
                    	case 1 :
                    	    // InternalTmscXtext.g:1910:6: otherlv_19= ',' ( (otherlv_20= 'time-bound' otherlv_21= ':' ( (lv_timeBound_22_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_23= 'scheduled' otherlv_24= ':' ( (lv_scheduled_25_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_26= 'request' otherlv_27= ':' ( ( ruleIDString ) ) ) | (otherlv_29= 'message' otherlv_30= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_32_0= ruleXProperty ) ) )
                    	    {
                    	    otherlv_19=(Token)match(input,26,FOLLOW_32); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_19, grammarAccess.getXDependencyAccess().getCommaKeyword_2_1_2_0());
                    	      					
                    	    }
                    	    // InternalTmscXtext.g:1914:6: ( (otherlv_20= 'time-bound' otherlv_21= ':' ( (lv_timeBound_22_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_23= 'scheduled' otherlv_24= ':' ( (lv_scheduled_25_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_26= 'request' otherlv_27= ':' ( ( ruleIDString ) ) ) | (otherlv_29= 'message' otherlv_30= ':' ( ( ruleIDString ) ) ) | ( (lv_properties_32_0= ruleXProperty ) ) )
                    	    int alt40=5;
                    	    switch ( input.LA(1) ) {
                    	    case 18:
                    	        {
                    	        alt40=1;
                    	        }
                    	        break;
                    	    case 19:
                    	        {
                    	        alt40=2;
                    	        }
                    	        break;
                    	    case 38:
                    	        {
                    	        alt40=3;
                    	        }
                    	        break;
                    	    case 39:
                    	        {
                    	        alt40=4;
                    	        }
                    	        break;
                    	    case RULE_ID:
                    	    case RULE_STRING:
                    	        {
                    	        alt40=5;
                    	        }
                    	        break;
                    	    default:
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        NoViableAltException nvae =
                    	            new NoViableAltException("", 40, 0, input);

                    	        throw nvae;
                    	    }

                    	    switch (alt40) {
                    	        case 1 :
                    	            // InternalTmscXtext.g:1915:7: (otherlv_20= 'time-bound' otherlv_21= ':' ( (lv_timeBound_22_0= RULE_ABS_EBIGDECIMAL ) ) )
                    	            {
                    	            // InternalTmscXtext.g:1915:7: (otherlv_20= 'time-bound' otherlv_21= ':' ( (lv_timeBound_22_0= RULE_ABS_EBIGDECIMAL ) ) )
                    	            // InternalTmscXtext.g:1916:8: otherlv_20= 'time-bound' otherlv_21= ':' ( (lv_timeBound_22_0= RULE_ABS_EBIGDECIMAL ) )
                    	            {
                    	            otherlv_20=(Token)match(input,18,FOLLOW_6); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              								newLeafNode(otherlv_20, grammarAccess.getXDependencyAccess().getTimeBoundKeyword_2_1_2_1_0_0());
                    	              							
                    	            }
                    	            otherlv_21=(Token)match(input,17,FOLLOW_8); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              								newLeafNode(otherlv_21, grammarAccess.getXDependencyAccess().getColonKeyword_2_1_2_1_0_1());
                    	              							
                    	            }
                    	            // InternalTmscXtext.g:1924:8: ( (lv_timeBound_22_0= RULE_ABS_EBIGDECIMAL ) )
                    	            // InternalTmscXtext.g:1925:9: (lv_timeBound_22_0= RULE_ABS_EBIGDECIMAL )
                    	            {
                    	            // InternalTmscXtext.g:1925:9: (lv_timeBound_22_0= RULE_ABS_EBIGDECIMAL )
                    	            // InternalTmscXtext.g:1926:10: lv_timeBound_22_0= RULE_ABS_EBIGDECIMAL
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
                    	            // InternalTmscXtext.g:1944:7: (otherlv_23= 'scheduled' otherlv_24= ':' ( (lv_scheduled_25_0= ruleEBOOLEAN_OBJECT ) ) )
                    	            {
                    	            // InternalTmscXtext.g:1944:7: (otherlv_23= 'scheduled' otherlv_24= ':' ( (lv_scheduled_25_0= ruleEBOOLEAN_OBJECT ) ) )
                    	            // InternalTmscXtext.g:1945:8: otherlv_23= 'scheduled' otherlv_24= ':' ( (lv_scheduled_25_0= ruleEBOOLEAN_OBJECT ) )
                    	            {
                    	            otherlv_23=(Token)match(input,19,FOLLOW_6); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              								newLeafNode(otherlv_23, grammarAccess.getXDependencyAccess().getScheduledKeyword_2_1_2_1_1_0());
                    	              							
                    	            }
                    	            otherlv_24=(Token)match(input,17,FOLLOW_9); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              								newLeafNode(otherlv_24, grammarAccess.getXDependencyAccess().getColonKeyword_2_1_2_1_1_1());
                    	              							
                    	            }
                    	            // InternalTmscXtext.g:1953:8: ( (lv_scheduled_25_0= ruleEBOOLEAN_OBJECT ) )
                    	            // InternalTmscXtext.g:1954:9: (lv_scheduled_25_0= ruleEBOOLEAN_OBJECT )
                    	            {
                    	            // InternalTmscXtext.g:1954:9: (lv_scheduled_25_0= ruleEBOOLEAN_OBJECT )
                    	            // InternalTmscXtext.g:1955:10: lv_scheduled_25_0= ruleEBOOLEAN_OBJECT
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
                    	            // InternalTmscXtext.g:1974:7: (otherlv_26= 'request' otherlv_27= ':' ( ( ruleIDString ) ) )
                    	            {
                    	            // InternalTmscXtext.g:1974:7: (otherlv_26= 'request' otherlv_27= ':' ( ( ruleIDString ) ) )
                    	            // InternalTmscXtext.g:1975:8: otherlv_26= 'request' otherlv_27= ':' ( ( ruleIDString ) )
                    	            {
                    	            otherlv_26=(Token)match(input,38,FOLLOW_6); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              								newLeafNode(otherlv_26, grammarAccess.getXDependencyAccess().getRequestKeyword_2_1_2_1_2_0());
                    	              							
                    	            }
                    	            otherlv_27=(Token)match(input,17,FOLLOW_11); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              								newLeafNode(otherlv_27, grammarAccess.getXDependencyAccess().getColonKeyword_2_1_2_1_2_1());
                    	              							
                    	            }
                    	            // InternalTmscXtext.g:1983:8: ( ( ruleIDString ) )
                    	            // InternalTmscXtext.g:1984:9: ( ruleIDString )
                    	            {
                    	            // InternalTmscXtext.g:1984:9: ( ruleIDString )
                    	            // InternalTmscXtext.g:1985:10: ruleIDString
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
                    	            // InternalTmscXtext.g:2001:7: (otherlv_29= 'message' otherlv_30= ':' ( ( ruleIDString ) ) )
                    	            {
                    	            // InternalTmscXtext.g:2001:7: (otherlv_29= 'message' otherlv_30= ':' ( ( ruleIDString ) ) )
                    	            // InternalTmscXtext.g:2002:8: otherlv_29= 'message' otherlv_30= ':' ( ( ruleIDString ) )
                    	            {
                    	            otherlv_29=(Token)match(input,39,FOLLOW_6); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              								newLeafNode(otherlv_29, grammarAccess.getXDependencyAccess().getMessageKeyword_2_1_2_1_3_0());
                    	              							
                    	            }
                    	            otherlv_30=(Token)match(input,17,FOLLOW_11); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              								newLeafNode(otherlv_30, grammarAccess.getXDependencyAccess().getColonKeyword_2_1_2_1_3_1());
                    	              							
                    	            }
                    	            // InternalTmscXtext.g:2010:8: ( ( ruleIDString ) )
                    	            // InternalTmscXtext.g:2011:9: ( ruleIDString )
                    	            {
                    	            // InternalTmscXtext.g:2011:9: ( ruleIDString )
                    	            // InternalTmscXtext.g:2012:10: ruleIDString
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
                    	            // InternalTmscXtext.g:2028:7: ( (lv_properties_32_0= ruleXProperty ) )
                    	            {
                    	            // InternalTmscXtext.g:2028:7: ( (lv_properties_32_0= ruleXProperty ) )
                    	            // InternalTmscXtext.g:2029:8: (lv_properties_32_0= ruleXProperty )
                    	            {
                    	            // InternalTmscXtext.g:2029:8: (lv_properties_32_0= ruleXProperty )
                    	            // InternalTmscXtext.g:2030:9: lv_properties_32_0= ruleXProperty
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
                    	    break loop41;
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
    // InternalTmscXtext.g:2059:1: entryRuleXDependencyTypeObject returns [EObject current=null] : iv_ruleXDependencyTypeObject= ruleXDependencyTypeObject EOF ;
    public final EObject entryRuleXDependencyTypeObject() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXDependencyTypeObject = null;


        try {
            // InternalTmscXtext.g:2059:62: (iv_ruleXDependencyTypeObject= ruleXDependencyTypeObject EOF )
            // InternalTmscXtext.g:2060:2: iv_ruleXDependencyTypeObject= ruleXDependencyTypeObject EOF
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
    // InternalTmscXtext.g:2066:1: ruleXDependencyTypeObject returns [EObject current=null] : ( (lv_value_0_0= ruleXDependencyType ) ) ;
    public final EObject ruleXDependencyTypeObject() throws RecognitionException {
        EObject current = null;

        Enumerator lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalTmscXtext.g:2072:2: ( ( (lv_value_0_0= ruleXDependencyType ) ) )
            // InternalTmscXtext.g:2073:2: ( (lv_value_0_0= ruleXDependencyType ) )
            {
            // InternalTmscXtext.g:2073:2: ( (lv_value_0_0= ruleXDependencyType ) )
            // InternalTmscXtext.g:2074:3: (lv_value_0_0= ruleXDependencyType )
            {
            // InternalTmscXtext.g:2074:3: (lv_value_0_0= ruleXDependencyType )
            // InternalTmscXtext.g:2075:4: lv_value_0_0= ruleXDependencyType
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
    // InternalTmscXtext.g:2095:1: entryRuleXDependencySettings returns [EObject current=null] : iv_ruleXDependencySettings= ruleXDependencySettings EOF ;
    public final EObject entryRuleXDependencySettings() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXDependencySettings = null;


        try {
            // InternalTmscXtext.g:2095:60: (iv_ruleXDependencySettings= ruleXDependencySettings EOF )
            // InternalTmscXtext.g:2096:2: iv_ruleXDependencySettings= ruleXDependencySettings EOF
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
    // InternalTmscXtext.g:2102:1: ruleXDependencySettings returns [EObject current=null] : ( ( (lv_type_0_0= ruleXDependencyType ) ) otherlv_1= 'settings' otherlv_2= '{' ( (otherlv_3= 'time-bound' otherlv_4= ':' ( (lv_timeBound_5_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_6= 'scheduled' otherlv_7= ':' ( (lv_scheduled_8_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_9= 'prefix' otherlv_10= ':' ( (lv_prefix_11_0= ruleIDString ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) )* otherlv_13= '}' ) ;
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
            // InternalTmscXtext.g:2108:2: ( ( ( (lv_type_0_0= ruleXDependencyType ) ) otherlv_1= 'settings' otherlv_2= '{' ( (otherlv_3= 'time-bound' otherlv_4= ':' ( (lv_timeBound_5_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_6= 'scheduled' otherlv_7= ':' ( (lv_scheduled_8_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_9= 'prefix' otherlv_10= ':' ( (lv_prefix_11_0= ruleIDString ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) )* otherlv_13= '}' ) )
            // InternalTmscXtext.g:2109:2: ( ( (lv_type_0_0= ruleXDependencyType ) ) otherlv_1= 'settings' otherlv_2= '{' ( (otherlv_3= 'time-bound' otherlv_4= ':' ( (lv_timeBound_5_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_6= 'scheduled' otherlv_7= ':' ( (lv_scheduled_8_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_9= 'prefix' otherlv_10= ':' ( (lv_prefix_11_0= ruleIDString ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) )* otherlv_13= '}' )
            {
            // InternalTmscXtext.g:2109:2: ( ( (lv_type_0_0= ruleXDependencyType ) ) otherlv_1= 'settings' otherlv_2= '{' ( (otherlv_3= 'time-bound' otherlv_4= ':' ( (lv_timeBound_5_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_6= 'scheduled' otherlv_7= ':' ( (lv_scheduled_8_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_9= 'prefix' otherlv_10= ':' ( (lv_prefix_11_0= ruleIDString ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) )* otherlv_13= '}' )
            // InternalTmscXtext.g:2110:3: ( (lv_type_0_0= ruleXDependencyType ) ) otherlv_1= 'settings' otherlv_2= '{' ( (otherlv_3= 'time-bound' otherlv_4= ':' ( (lv_timeBound_5_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_6= 'scheduled' otherlv_7= ':' ( (lv_scheduled_8_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_9= 'prefix' otherlv_10= ':' ( (lv_prefix_11_0= ruleIDString ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) )* otherlv_13= '}'
            {
            // InternalTmscXtext.g:2110:3: ( (lv_type_0_0= ruleXDependencyType ) )
            // InternalTmscXtext.g:2111:4: (lv_type_0_0= ruleXDependencyType )
            {
            // InternalTmscXtext.g:2111:4: (lv_type_0_0= ruleXDependencyType )
            // InternalTmscXtext.g:2112:5: lv_type_0_0= ruleXDependencyType
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
            otherlv_2=(Token)match(input,15,FOLLOW_33); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getXDependencySettingsAccess().getLeftCurlyBracketKeyword_2());
              		
            }
            // InternalTmscXtext.g:2137:3: ( (otherlv_3= 'time-bound' otherlv_4= ':' ( (lv_timeBound_5_0= RULE_ABS_EBIGDECIMAL ) ) ) | (otherlv_6= 'scheduled' otherlv_7= ':' ( (lv_scheduled_8_0= ruleEBOOLEAN_OBJECT ) ) ) | (otherlv_9= 'prefix' otherlv_10= ':' ( (lv_prefix_11_0= ruleIDString ) ) ) | ( (lv_properties_12_0= ruleXProperty ) ) )*
            loop43:
            do {
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
                case 40:
                    {
                    alt43=3;
                    }
                    break;
                case RULE_ID:
                case RULE_STRING:
                    {
                    alt43=4;
                    }
                    break;

                }

                switch (alt43) {
            	case 1 :
            	    // InternalTmscXtext.g:2138:4: (otherlv_3= 'time-bound' otherlv_4= ':' ( (lv_timeBound_5_0= RULE_ABS_EBIGDECIMAL ) ) )
            	    {
            	    // InternalTmscXtext.g:2138:4: (otherlv_3= 'time-bound' otherlv_4= ':' ( (lv_timeBound_5_0= RULE_ABS_EBIGDECIMAL ) ) )
            	    // InternalTmscXtext.g:2139:5: otherlv_3= 'time-bound' otherlv_4= ':' ( (lv_timeBound_5_0= RULE_ABS_EBIGDECIMAL ) )
            	    {
            	    otherlv_3=(Token)match(input,18,FOLLOW_6); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_3, grammarAccess.getXDependencySettingsAccess().getTimeBoundKeyword_3_0_0());
            	      				
            	    }
            	    otherlv_4=(Token)match(input,17,FOLLOW_8); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_4, grammarAccess.getXDependencySettingsAccess().getColonKeyword_3_0_1());
            	      				
            	    }
            	    // InternalTmscXtext.g:2147:5: ( (lv_timeBound_5_0= RULE_ABS_EBIGDECIMAL ) )
            	    // InternalTmscXtext.g:2148:6: (lv_timeBound_5_0= RULE_ABS_EBIGDECIMAL )
            	    {
            	    // InternalTmscXtext.g:2148:6: (lv_timeBound_5_0= RULE_ABS_EBIGDECIMAL )
            	    // InternalTmscXtext.g:2149:7: lv_timeBound_5_0= RULE_ABS_EBIGDECIMAL
            	    {
            	    lv_timeBound_5_0=(Token)match(input,RULE_ABS_EBIGDECIMAL,FOLLOW_33); if (state.failed) return current;
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
            	    // InternalTmscXtext.g:2167:4: (otherlv_6= 'scheduled' otherlv_7= ':' ( (lv_scheduled_8_0= ruleEBOOLEAN_OBJECT ) ) )
            	    {
            	    // InternalTmscXtext.g:2167:4: (otherlv_6= 'scheduled' otherlv_7= ':' ( (lv_scheduled_8_0= ruleEBOOLEAN_OBJECT ) ) )
            	    // InternalTmscXtext.g:2168:5: otherlv_6= 'scheduled' otherlv_7= ':' ( (lv_scheduled_8_0= ruleEBOOLEAN_OBJECT ) )
            	    {
            	    otherlv_6=(Token)match(input,19,FOLLOW_6); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_6, grammarAccess.getXDependencySettingsAccess().getScheduledKeyword_3_1_0());
            	      				
            	    }
            	    otherlv_7=(Token)match(input,17,FOLLOW_9); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_7, grammarAccess.getXDependencySettingsAccess().getColonKeyword_3_1_1());
            	      				
            	    }
            	    // InternalTmscXtext.g:2176:5: ( (lv_scheduled_8_0= ruleEBOOLEAN_OBJECT ) )
            	    // InternalTmscXtext.g:2177:6: (lv_scheduled_8_0= ruleEBOOLEAN_OBJECT )
            	    {
            	    // InternalTmscXtext.g:2177:6: (lv_scheduled_8_0= ruleEBOOLEAN_OBJECT )
            	    // InternalTmscXtext.g:2178:7: lv_scheduled_8_0= ruleEBOOLEAN_OBJECT
            	    {
            	    if ( state.backtracking==0 ) {

            	      							newCompositeNode(grammarAccess.getXDependencySettingsAccess().getScheduledEBOOLEAN_OBJECTParserRuleCall_3_1_2_0());
            	      						
            	    }
            	    pushFollow(FOLLOW_33);
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
            	    // InternalTmscXtext.g:2197:4: (otherlv_9= 'prefix' otherlv_10= ':' ( (lv_prefix_11_0= ruleIDString ) ) )
            	    {
            	    // InternalTmscXtext.g:2197:4: (otherlv_9= 'prefix' otherlv_10= ':' ( (lv_prefix_11_0= ruleIDString ) ) )
            	    // InternalTmscXtext.g:2198:5: otherlv_9= 'prefix' otherlv_10= ':' ( (lv_prefix_11_0= ruleIDString ) )
            	    {
            	    otherlv_9=(Token)match(input,40,FOLLOW_6); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_9, grammarAccess.getXDependencySettingsAccess().getPrefixKeyword_3_2_0());
            	      				
            	    }
            	    otherlv_10=(Token)match(input,17,FOLLOW_11); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_10, grammarAccess.getXDependencySettingsAccess().getColonKeyword_3_2_1());
            	      				
            	    }
            	    // InternalTmscXtext.g:2206:5: ( (lv_prefix_11_0= ruleIDString ) )
            	    // InternalTmscXtext.g:2207:6: (lv_prefix_11_0= ruleIDString )
            	    {
            	    // InternalTmscXtext.g:2207:6: (lv_prefix_11_0= ruleIDString )
            	    // InternalTmscXtext.g:2208:7: lv_prefix_11_0= ruleIDString
            	    {
            	    if ( state.backtracking==0 ) {

            	      							newCompositeNode(grammarAccess.getXDependencySettingsAccess().getPrefixIDStringParserRuleCall_3_2_2_0());
            	      						
            	    }
            	    pushFollow(FOLLOW_33);
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
            	    // InternalTmscXtext.g:2227:4: ( (lv_properties_12_0= ruleXProperty ) )
            	    {
            	    // InternalTmscXtext.g:2227:4: ( (lv_properties_12_0= ruleXProperty ) )
            	    // InternalTmscXtext.g:2228:5: (lv_properties_12_0= ruleXProperty )
            	    {
            	    // InternalTmscXtext.g:2228:5: (lv_properties_12_0= ruleXProperty )
            	    // InternalTmscXtext.g:2229:6: lv_properties_12_0= ruleXProperty
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getXDependencySettingsAccess().getPropertiesXPropertyParserRuleCall_3_3_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_33);
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
            	    break loop43;
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
    // InternalTmscXtext.g:2255:1: entryRuleXProperty returns [EObject current=null] : iv_ruleXProperty= ruleXProperty EOF ;
    public final EObject entryRuleXProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXProperty = null;


        try {
            // InternalTmscXtext.g:2255:50: (iv_ruleXProperty= ruleXProperty EOF )
            // InternalTmscXtext.g:2256:2: iv_ruleXProperty= ruleXProperty EOF
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
    // InternalTmscXtext.g:2262:1: ruleXProperty returns [EObject current=null] : ( ( (lv_name_0_0= ruleIDString ) ) otherlv_1= ':' ( (lv_value_2_0= ruleXPropertyValue ) ) ) ;
    public final EObject ruleXProperty() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalTmscXtext.g:2268:2: ( ( ( (lv_name_0_0= ruleIDString ) ) otherlv_1= ':' ( (lv_value_2_0= ruleXPropertyValue ) ) ) )
            // InternalTmscXtext.g:2269:2: ( ( (lv_name_0_0= ruleIDString ) ) otherlv_1= ':' ( (lv_value_2_0= ruleXPropertyValue ) ) )
            {
            // InternalTmscXtext.g:2269:2: ( ( (lv_name_0_0= ruleIDString ) ) otherlv_1= ':' ( (lv_value_2_0= ruleXPropertyValue ) ) )
            // InternalTmscXtext.g:2270:3: ( (lv_name_0_0= ruleIDString ) ) otherlv_1= ':' ( (lv_value_2_0= ruleXPropertyValue ) )
            {
            // InternalTmscXtext.g:2270:3: ( (lv_name_0_0= ruleIDString ) )
            // InternalTmscXtext.g:2271:4: (lv_name_0_0= ruleIDString )
            {
            // InternalTmscXtext.g:2271:4: (lv_name_0_0= ruleIDString )
            // InternalTmscXtext.g:2272:5: lv_name_0_0= ruleIDString
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

            otherlv_1=(Token)match(input,17,FOLLOW_34); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getXPropertyAccess().getColonKeyword_1());
              		
            }
            // InternalTmscXtext.g:2293:3: ( (lv_value_2_0= ruleXPropertyValue ) )
            // InternalTmscXtext.g:2294:4: (lv_value_2_0= ruleXPropertyValue )
            {
            // InternalTmscXtext.g:2294:4: (lv_value_2_0= ruleXPropertyValue )
            // InternalTmscXtext.g:2295:5: lv_value_2_0= ruleXPropertyValue
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
    // InternalTmscXtext.g:2316:1: entryRuleXPropertyValue returns [EObject current=null] : iv_ruleXPropertyValue= ruleXPropertyValue EOF ;
    public final EObject entryRuleXPropertyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXPropertyValue = null;


        try {
            // InternalTmscXtext.g:2316:55: (iv_ruleXPropertyValue= ruleXPropertyValue EOF )
            // InternalTmscXtext.g:2317:2: iv_ruleXPropertyValue= ruleXPropertyValue EOF
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
    // InternalTmscXtext.g:2323:1: ruleXPropertyValue returns [EObject current=null] : ( ( () ( ( ( ruleIDString ) )=> (lv_value_1_0= ruleIDString ) ) ) | ( () ( ( ( ruleEBIGDECIMAL ) )=> (lv_value_3_0= ruleEBIGDECIMAL ) ) ) | ( () ( ( ( ruleEBOOLEAN_OBJECT ) )=> (lv_value_5_0= ruleEBOOLEAN_OBJECT ) ) ) | ( () ( ( '[' )=>otherlv_7= '[' ) ( (lv_values_8_0= ruleXPropertyValue ) ) (otherlv_9= ',' ( (lv_values_10_0= ruleXPropertyValue ) ) )* otherlv_11= ']' ) ) ;
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
            // InternalTmscXtext.g:2329:2: ( ( ( () ( ( ( ruleIDString ) )=> (lv_value_1_0= ruleIDString ) ) ) | ( () ( ( ( ruleEBIGDECIMAL ) )=> (lv_value_3_0= ruleEBIGDECIMAL ) ) ) | ( () ( ( ( ruleEBOOLEAN_OBJECT ) )=> (lv_value_5_0= ruleEBOOLEAN_OBJECT ) ) ) | ( () ( ( '[' )=>otherlv_7= '[' ) ( (lv_values_8_0= ruleXPropertyValue ) ) (otherlv_9= ',' ( (lv_values_10_0= ruleXPropertyValue ) ) )* otherlv_11= ']' ) ) )
            // InternalTmscXtext.g:2330:2: ( ( () ( ( ( ruleIDString ) )=> (lv_value_1_0= ruleIDString ) ) ) | ( () ( ( ( ruleEBIGDECIMAL ) )=> (lv_value_3_0= ruleEBIGDECIMAL ) ) ) | ( () ( ( ( ruleEBOOLEAN_OBJECT ) )=> (lv_value_5_0= ruleEBOOLEAN_OBJECT ) ) ) | ( () ( ( '[' )=>otherlv_7= '[' ) ( (lv_values_8_0= ruleXPropertyValue ) ) (otherlv_9= ',' ( (lv_values_10_0= ruleXPropertyValue ) ) )* otherlv_11= ']' ) )
            {
            // InternalTmscXtext.g:2330:2: ( ( () ( ( ( ruleIDString ) )=> (lv_value_1_0= ruleIDString ) ) ) | ( () ( ( ( ruleEBIGDECIMAL ) )=> (lv_value_3_0= ruleEBIGDECIMAL ) ) ) | ( () ( ( ( ruleEBOOLEAN_OBJECT ) )=> (lv_value_5_0= ruleEBOOLEAN_OBJECT ) ) ) | ( () ( ( '[' )=>otherlv_7= '[' ) ( (lv_values_8_0= ruleXPropertyValue ) ) (otherlv_9= ',' ( (lv_values_10_0= ruleXPropertyValue ) ) )* otherlv_11= ']' ) )
            int alt45=4;
            switch ( input.LA(1) ) {
            case RULE_ID:
            case RULE_STRING:
                {
                alt45=1;
                }
                break;
            case RULE_ABS_EBIGDECIMAL:
            case RULE_POS_EBIGDECIMAL:
            case RULE_NEG_EBIGDECIMAL:
                {
                alt45=2;
                }
                break;
            case 44:
            case 45:
                {
                alt45=3;
                }
                break;
            case 41:
                {
                alt45=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;
            }

            switch (alt45) {
                case 1 :
                    // InternalTmscXtext.g:2331:3: ( () ( ( ( ruleIDString ) )=> (lv_value_1_0= ruleIDString ) ) )
                    {
                    // InternalTmscXtext.g:2331:3: ( () ( ( ( ruleIDString ) )=> (lv_value_1_0= ruleIDString ) ) )
                    // InternalTmscXtext.g:2332:4: () ( ( ( ruleIDString ) )=> (lv_value_1_0= ruleIDString ) )
                    {
                    // InternalTmscXtext.g:2332:4: ()
                    // InternalTmscXtext.g:2333:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getXPropertyValueAccess().getXPropertyStringValueAction_0_0(),
                      						current);
                      				
                    }

                    }

                    // InternalTmscXtext.g:2339:4: ( ( ( ruleIDString ) )=> (lv_value_1_0= ruleIDString ) )
                    // InternalTmscXtext.g:2340:5: ( ( ruleIDString ) )=> (lv_value_1_0= ruleIDString )
                    {
                    // InternalTmscXtext.g:2344:5: (lv_value_1_0= ruleIDString )
                    // InternalTmscXtext.g:2345:6: lv_value_1_0= ruleIDString
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
                    // InternalTmscXtext.g:2364:3: ( () ( ( ( ruleEBIGDECIMAL ) )=> (lv_value_3_0= ruleEBIGDECIMAL ) ) )
                    {
                    // InternalTmscXtext.g:2364:3: ( () ( ( ( ruleEBIGDECIMAL ) )=> (lv_value_3_0= ruleEBIGDECIMAL ) ) )
                    // InternalTmscXtext.g:2365:4: () ( ( ( ruleEBIGDECIMAL ) )=> (lv_value_3_0= ruleEBIGDECIMAL ) )
                    {
                    // InternalTmscXtext.g:2365:4: ()
                    // InternalTmscXtext.g:2366:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getXPropertyValueAccess().getXPropertyNumberValueAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalTmscXtext.g:2372:4: ( ( ( ruleEBIGDECIMAL ) )=> (lv_value_3_0= ruleEBIGDECIMAL ) )
                    // InternalTmscXtext.g:2373:5: ( ( ruleEBIGDECIMAL ) )=> (lv_value_3_0= ruleEBIGDECIMAL )
                    {
                    // InternalTmscXtext.g:2377:5: (lv_value_3_0= ruleEBIGDECIMAL )
                    // InternalTmscXtext.g:2378:6: lv_value_3_0= ruleEBIGDECIMAL
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
                    // InternalTmscXtext.g:2397:3: ( () ( ( ( ruleEBOOLEAN_OBJECT ) )=> (lv_value_5_0= ruleEBOOLEAN_OBJECT ) ) )
                    {
                    // InternalTmscXtext.g:2397:3: ( () ( ( ( ruleEBOOLEAN_OBJECT ) )=> (lv_value_5_0= ruleEBOOLEAN_OBJECT ) ) )
                    // InternalTmscXtext.g:2398:4: () ( ( ( ruleEBOOLEAN_OBJECT ) )=> (lv_value_5_0= ruleEBOOLEAN_OBJECT ) )
                    {
                    // InternalTmscXtext.g:2398:4: ()
                    // InternalTmscXtext.g:2399:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getXPropertyValueAccess().getXPropertyBooleanValueAction_2_0(),
                      						current);
                      				
                    }

                    }

                    // InternalTmscXtext.g:2405:4: ( ( ( ruleEBOOLEAN_OBJECT ) )=> (lv_value_5_0= ruleEBOOLEAN_OBJECT ) )
                    // InternalTmscXtext.g:2406:5: ( ( ruleEBOOLEAN_OBJECT ) )=> (lv_value_5_0= ruleEBOOLEAN_OBJECT )
                    {
                    // InternalTmscXtext.g:2410:5: (lv_value_5_0= ruleEBOOLEAN_OBJECT )
                    // InternalTmscXtext.g:2411:6: lv_value_5_0= ruleEBOOLEAN_OBJECT
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
                    // InternalTmscXtext.g:2430:3: ( () ( ( '[' )=>otherlv_7= '[' ) ( (lv_values_8_0= ruleXPropertyValue ) ) (otherlv_9= ',' ( (lv_values_10_0= ruleXPropertyValue ) ) )* otherlv_11= ']' )
                    {
                    // InternalTmscXtext.g:2430:3: ( () ( ( '[' )=>otherlv_7= '[' ) ( (lv_values_8_0= ruleXPropertyValue ) ) (otherlv_9= ',' ( (lv_values_10_0= ruleXPropertyValue ) ) )* otherlv_11= ']' )
                    // InternalTmscXtext.g:2431:4: () ( ( '[' )=>otherlv_7= '[' ) ( (lv_values_8_0= ruleXPropertyValue ) ) (otherlv_9= ',' ( (lv_values_10_0= ruleXPropertyValue ) ) )* otherlv_11= ']'
                    {
                    // InternalTmscXtext.g:2431:4: ()
                    // InternalTmscXtext.g:2432:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getXPropertyValueAccess().getXPropertyMutliValueAction_3_0(),
                      						current);
                      				
                    }

                    }

                    // InternalTmscXtext.g:2438:4: ( ( '[' )=>otherlv_7= '[' )
                    // InternalTmscXtext.g:2439:5: ( '[' )=>otherlv_7= '['
                    {
                    otherlv_7=(Token)match(input,41,FOLLOW_34); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_7, grammarAccess.getXPropertyValueAccess().getLeftSquareBracketKeyword_3_1());
                      				
                    }

                    }

                    // InternalTmscXtext.g:2445:4: ( (lv_values_8_0= ruleXPropertyValue ) )
                    // InternalTmscXtext.g:2446:5: (lv_values_8_0= ruleXPropertyValue )
                    {
                    // InternalTmscXtext.g:2446:5: (lv_values_8_0= ruleXPropertyValue )
                    // InternalTmscXtext.g:2447:6: lv_values_8_0= ruleXPropertyValue
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getXPropertyValueAccess().getValuesXPropertyValueParserRuleCall_3_2_0());
                      					
                    }
                    pushFollow(FOLLOW_35);
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

                    // InternalTmscXtext.g:2464:4: (otherlv_9= ',' ( (lv_values_10_0= ruleXPropertyValue ) ) )*
                    loop44:
                    do {
                        int alt44=2;
                        int LA44_0 = input.LA(1);

                        if ( (LA44_0==26) ) {
                            alt44=1;
                        }


                        switch (alt44) {
                    	case 1 :
                    	    // InternalTmscXtext.g:2465:5: otherlv_9= ',' ( (lv_values_10_0= ruleXPropertyValue ) )
                    	    {
                    	    otherlv_9=(Token)match(input,26,FOLLOW_34); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_9, grammarAccess.getXPropertyValueAccess().getCommaKeyword_3_3_0());
                    	      				
                    	    }
                    	    // InternalTmscXtext.g:2469:5: ( (lv_values_10_0= ruleXPropertyValue ) )
                    	    // InternalTmscXtext.g:2470:6: (lv_values_10_0= ruleXPropertyValue )
                    	    {
                    	    // InternalTmscXtext.g:2470:6: (lv_values_10_0= ruleXPropertyValue )
                    	    // InternalTmscXtext.g:2471:7: lv_values_10_0= ruleXPropertyValue
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getXPropertyValueAccess().getValuesXPropertyValueParserRuleCall_3_3_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_35);
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
                    	    break loop44;
                        }
                    } while (true);

                    otherlv_11=(Token)match(input,42,FOLLOW_2); if (state.failed) return current;
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


    // $ANTLR start "entryRuleIDString"
    // InternalTmscXtext.g:2498:1: entryRuleIDString returns [String current=null] : iv_ruleIDString= ruleIDString EOF ;
    public final String entryRuleIDString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIDString = null;


        try {
            // InternalTmscXtext.g:2498:48: (iv_ruleIDString= ruleIDString EOF )
            // InternalTmscXtext.g:2499:2: iv_ruleIDString= ruleIDString EOF
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
    // InternalTmscXtext.g:2505:1: ruleIDString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | this_STRING_1= RULE_STRING ) ;
    public final AntlrDatatypeRuleToken ruleIDString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token this_STRING_1=null;


        	enterRule();

        try {
            // InternalTmscXtext.g:2511:2: ( (this_ID_0= RULE_ID | this_STRING_1= RULE_STRING ) )
            // InternalTmscXtext.g:2512:2: (this_ID_0= RULE_ID | this_STRING_1= RULE_STRING )
            {
            // InternalTmscXtext.g:2512:2: (this_ID_0= RULE_ID | this_STRING_1= RULE_STRING )
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==RULE_ID) ) {
                alt46=1;
            }
            else if ( (LA46_0==RULE_STRING) ) {
                alt46=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;
            }
            switch (alt46) {
                case 1 :
                    // InternalTmscXtext.g:2513:3: this_ID_0= RULE_ID
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
                    // InternalTmscXtext.g:2521:3: this_STRING_1= RULE_STRING
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
    // InternalTmscXtext.g:2532:1: entryRuleFQN returns [String current=null] : iv_ruleFQN= ruleFQN EOF ;
    public final String entryRuleFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQN = null;


        try {
            // InternalTmscXtext.g:2532:43: (iv_ruleFQN= ruleFQN EOF )
            // InternalTmscXtext.g:2533:2: iv_ruleFQN= ruleFQN EOF
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
    // InternalTmscXtext.g:2539:1: ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalTmscXtext.g:2545:2: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalTmscXtext.g:2546:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalTmscXtext.g:2546:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalTmscXtext.g:2547:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_36); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_ID_0);
              		
            }
            if ( state.backtracking==0 ) {

              			newLeafNode(this_ID_0, grammarAccess.getFQNAccess().getIDTerminalRuleCall_0());
              		
            }
            // InternalTmscXtext.g:2554:3: (kw= '.' this_ID_2= RULE_ID )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==43) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // InternalTmscXtext.g:2555:4: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,43,FOLLOW_13); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				current.merge(kw);
            	      				newLeafNode(kw, grammarAccess.getFQNAccess().getFullStopKeyword_1_0());
            	      			
            	    }
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_36); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				current.merge(this_ID_2);
            	      			
            	    }
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(this_ID_2, grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1());
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop47;
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
    // InternalTmscXtext.g:2572:1: entryRuleEBOOLEAN_OBJECT returns [String current=null] : iv_ruleEBOOLEAN_OBJECT= ruleEBOOLEAN_OBJECT EOF ;
    public final String entryRuleEBOOLEAN_OBJECT() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEBOOLEAN_OBJECT = null;


        try {
            // InternalTmscXtext.g:2572:55: (iv_ruleEBOOLEAN_OBJECT= ruleEBOOLEAN_OBJECT EOF )
            // InternalTmscXtext.g:2573:2: iv_ruleEBOOLEAN_OBJECT= ruleEBOOLEAN_OBJECT EOF
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
    // InternalTmscXtext.g:2579:1: ruleEBOOLEAN_OBJECT returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'true' | kw= 'false' ) ;
    public final AntlrDatatypeRuleToken ruleEBOOLEAN_OBJECT() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalTmscXtext.g:2585:2: ( (kw= 'true' | kw= 'false' ) )
            // InternalTmscXtext.g:2586:2: (kw= 'true' | kw= 'false' )
            {
            // InternalTmscXtext.g:2586:2: (kw= 'true' | kw= 'false' )
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==44) ) {
                alt48=1;
            }
            else if ( (LA48_0==45) ) {
                alt48=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;
            }
            switch (alt48) {
                case 1 :
                    // InternalTmscXtext.g:2587:3: kw= 'true'
                    {
                    kw=(Token)match(input,44,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getEBOOLEAN_OBJECTAccess().getTrueKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalTmscXtext.g:2593:3: kw= 'false'
                    {
                    kw=(Token)match(input,45,FOLLOW_2); if (state.failed) return current;
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
    // InternalTmscXtext.g:2602:1: entryRuleEBIGDECIMAL returns [String current=null] : iv_ruleEBIGDECIMAL= ruleEBIGDECIMAL EOF ;
    public final String entryRuleEBIGDECIMAL() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEBIGDECIMAL = null;


        try {
            // InternalTmscXtext.g:2602:51: (iv_ruleEBIGDECIMAL= ruleEBIGDECIMAL EOF )
            // InternalTmscXtext.g:2603:2: iv_ruleEBIGDECIMAL= ruleEBIGDECIMAL EOF
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
    // InternalTmscXtext.g:2609:1: ruleEBIGDECIMAL returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ABS_EBIGDECIMAL_0= RULE_ABS_EBIGDECIMAL | this_POS_EBIGDECIMAL_1= RULE_POS_EBIGDECIMAL | this_NEG_EBIGDECIMAL_2= RULE_NEG_EBIGDECIMAL ) ;
    public final AntlrDatatypeRuleToken ruleEBIGDECIMAL() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ABS_EBIGDECIMAL_0=null;
        Token this_POS_EBIGDECIMAL_1=null;
        Token this_NEG_EBIGDECIMAL_2=null;


        	enterRule();

        try {
            // InternalTmscXtext.g:2615:2: ( (this_ABS_EBIGDECIMAL_0= RULE_ABS_EBIGDECIMAL | this_POS_EBIGDECIMAL_1= RULE_POS_EBIGDECIMAL | this_NEG_EBIGDECIMAL_2= RULE_NEG_EBIGDECIMAL ) )
            // InternalTmscXtext.g:2616:2: (this_ABS_EBIGDECIMAL_0= RULE_ABS_EBIGDECIMAL | this_POS_EBIGDECIMAL_1= RULE_POS_EBIGDECIMAL | this_NEG_EBIGDECIMAL_2= RULE_NEG_EBIGDECIMAL )
            {
            // InternalTmscXtext.g:2616:2: (this_ABS_EBIGDECIMAL_0= RULE_ABS_EBIGDECIMAL | this_POS_EBIGDECIMAL_1= RULE_POS_EBIGDECIMAL | this_NEG_EBIGDECIMAL_2= RULE_NEG_EBIGDECIMAL )
            int alt49=3;
            switch ( input.LA(1) ) {
            case RULE_ABS_EBIGDECIMAL:
                {
                alt49=1;
                }
                break;
            case RULE_POS_EBIGDECIMAL:
                {
                alt49=2;
                }
                break;
            case RULE_NEG_EBIGDECIMAL:
                {
                alt49=3;
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
                    // InternalTmscXtext.g:2617:3: this_ABS_EBIGDECIMAL_0= RULE_ABS_EBIGDECIMAL
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
                    // InternalTmscXtext.g:2625:3: this_POS_EBIGDECIMAL_1= RULE_POS_EBIGDECIMAL
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
                    // InternalTmscXtext.g:2633:3: this_NEG_EBIGDECIMAL_2= RULE_NEG_EBIGDECIMAL
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
    // InternalTmscXtext.g:2644:1: ruleXArchitectureKind returns [Enumerator current=null] : ( (enumLiteral_0= 'internal' ) | (enumLiteral_1= 'external' ) ) ;
    public final Enumerator ruleXArchitectureKind() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalTmscXtext.g:2650:2: ( ( (enumLiteral_0= 'internal' ) | (enumLiteral_1= 'external' ) ) )
            // InternalTmscXtext.g:2651:2: ( (enumLiteral_0= 'internal' ) | (enumLiteral_1= 'external' ) )
            {
            // InternalTmscXtext.g:2651:2: ( (enumLiteral_0= 'internal' ) | (enumLiteral_1= 'external' ) )
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==46) ) {
                alt50=1;
            }
            else if ( (LA50_0==47) ) {
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
                    // InternalTmscXtext.g:2652:3: (enumLiteral_0= 'internal' )
                    {
                    // InternalTmscXtext.g:2652:3: (enumLiteral_0= 'internal' )
                    // InternalTmscXtext.g:2653:4: enumLiteral_0= 'internal'
                    {
                    enumLiteral_0=(Token)match(input,46,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getXArchitectureKindAccess().getINTERNALEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getXArchitectureKindAccess().getINTERNALEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalTmscXtext.g:2660:3: (enumLiteral_1= 'external' )
                    {
                    // InternalTmscXtext.g:2660:3: (enumLiteral_1= 'external' )
                    // InternalTmscXtext.g:2661:4: enumLiteral_1= 'external'
                    {
                    enumLiteral_1=(Token)match(input,47,FOLLOW_2); if (state.failed) return current;
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
    // InternalTmscXtext.g:2671:1: ruleXFunctionParameterKind returns [Enumerator current=null] : ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'out' ) | (enumLiteral_2= 'inout' ) | (enumLiteral_3= 'return' ) ) ;
    public final Enumerator ruleXFunctionParameterKind() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalTmscXtext.g:2677:2: ( ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'out' ) | (enumLiteral_2= 'inout' ) | (enumLiteral_3= 'return' ) ) )
            // InternalTmscXtext.g:2678:2: ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'out' ) | (enumLiteral_2= 'inout' ) | (enumLiteral_3= 'return' ) )
            {
            // InternalTmscXtext.g:2678:2: ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'out' ) | (enumLiteral_2= 'inout' ) | (enumLiteral_3= 'return' ) )
            int alt51=4;
            switch ( input.LA(1) ) {
            case 48:
                {
                alt51=1;
                }
                break;
            case 49:
                {
                alt51=2;
                }
                break;
            case 50:
                {
                alt51=3;
                }
                break;
            case 51:
                {
                alt51=4;
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
                    // InternalTmscXtext.g:2679:3: (enumLiteral_0= 'in' )
                    {
                    // InternalTmscXtext.g:2679:3: (enumLiteral_0= 'in' )
                    // InternalTmscXtext.g:2680:4: enumLiteral_0= 'in'
                    {
                    enumLiteral_0=(Token)match(input,48,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getXFunctionParameterKindAccess().getINEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getXFunctionParameterKindAccess().getINEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalTmscXtext.g:2687:3: (enumLiteral_1= 'out' )
                    {
                    // InternalTmscXtext.g:2687:3: (enumLiteral_1= 'out' )
                    // InternalTmscXtext.g:2688:4: enumLiteral_1= 'out'
                    {
                    enumLiteral_1=(Token)match(input,49,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getXFunctionParameterKindAccess().getOUTEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getXFunctionParameterKindAccess().getOUTEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalTmscXtext.g:2695:3: (enumLiteral_2= 'inout' )
                    {
                    // InternalTmscXtext.g:2695:3: (enumLiteral_2= 'inout' )
                    // InternalTmscXtext.g:2696:4: enumLiteral_2= 'inout'
                    {
                    enumLiteral_2=(Token)match(input,50,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getXFunctionParameterKindAccess().getIN_OUTEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getXFunctionParameterKindAccess().getIN_OUTEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalTmscXtext.g:2703:3: (enumLiteral_3= 'return' )
                    {
                    // InternalTmscXtext.g:2703:3: (enumLiteral_3= 'return' )
                    // InternalTmscXtext.g:2704:4: enumLiteral_3= 'return'
                    {
                    enumLiteral_3=(Token)match(input,51,FOLLOW_2); if (state.failed) return current;
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
    // InternalTmscXtext.g:2714:1: ruleXEventType returns [Enumerator current=null] : ( (enumLiteral_0= '>' ) | (enumLiteral_1= '<' ) ) ;
    public final Enumerator ruleXEventType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalTmscXtext.g:2720:2: ( ( (enumLiteral_0= '>' ) | (enumLiteral_1= '<' ) ) )
            // InternalTmscXtext.g:2721:2: ( (enumLiteral_0= '>' ) | (enumLiteral_1= '<' ) )
            {
            // InternalTmscXtext.g:2721:2: ( (enumLiteral_0= '>' ) | (enumLiteral_1= '<' ) )
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==52) ) {
                alt52=1;
            }
            else if ( (LA52_0==53) ) {
                alt52=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;
            }
            switch (alt52) {
                case 1 :
                    // InternalTmscXtext.g:2722:3: (enumLiteral_0= '>' )
                    {
                    // InternalTmscXtext.g:2722:3: (enumLiteral_0= '>' )
                    // InternalTmscXtext.g:2723:4: enumLiteral_0= '>'
                    {
                    enumLiteral_0=(Token)match(input,52,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getXEventTypeAccess().getENTRYEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getXEventTypeAccess().getENTRYEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalTmscXtext.g:2730:3: (enumLiteral_1= '<' )
                    {
                    // InternalTmscXtext.g:2730:3: (enumLiteral_1= '<' )
                    // InternalTmscXtext.g:2731:4: enumLiteral_1= '<'
                    {
                    enumLiteral_1=(Token)match(input,53,FOLLOW_2); if (state.failed) return current;
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
    // InternalTmscXtext.g:2741:1: ruleXDependencyType returns [Enumerator current=null] : ( (enumLiteral_0= 'message' ) | (enumLiteral_1= 'request' ) | (enumLiteral_2= 'reply' ) | (enumLiteral_3= 'domain-dependency' ) | (enumLiteral_4= 'lifeline-segment' ) | (enumLiteral_5= 'message-control' ) ) ;
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
            // InternalTmscXtext.g:2747:2: ( ( (enumLiteral_0= 'message' ) | (enumLiteral_1= 'request' ) | (enumLiteral_2= 'reply' ) | (enumLiteral_3= 'domain-dependency' ) | (enumLiteral_4= 'lifeline-segment' ) | (enumLiteral_5= 'message-control' ) ) )
            // InternalTmscXtext.g:2748:2: ( (enumLiteral_0= 'message' ) | (enumLiteral_1= 'request' ) | (enumLiteral_2= 'reply' ) | (enumLiteral_3= 'domain-dependency' ) | (enumLiteral_4= 'lifeline-segment' ) | (enumLiteral_5= 'message-control' ) )
            {
            // InternalTmscXtext.g:2748:2: ( (enumLiteral_0= 'message' ) | (enumLiteral_1= 'request' ) | (enumLiteral_2= 'reply' ) | (enumLiteral_3= 'domain-dependency' ) | (enumLiteral_4= 'lifeline-segment' ) | (enumLiteral_5= 'message-control' ) )
            int alt53=6;
            switch ( input.LA(1) ) {
            case 39:
                {
                alt53=1;
                }
                break;
            case 38:
                {
                alt53=2;
                }
                break;
            case 54:
                {
                alt53=3;
                }
                break;
            case 55:
                {
                alt53=4;
                }
                break;
            case 56:
                {
                alt53=5;
                }
                break;
            case 57:
                {
                alt53=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 53, 0, input);

                throw nvae;
            }

            switch (alt53) {
                case 1 :
                    // InternalTmscXtext.g:2749:3: (enumLiteral_0= 'message' )
                    {
                    // InternalTmscXtext.g:2749:3: (enumLiteral_0= 'message' )
                    // InternalTmscXtext.g:2750:4: enumLiteral_0= 'message'
                    {
                    enumLiteral_0=(Token)match(input,39,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getXDependencyTypeAccess().getMESSAGEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getXDependencyTypeAccess().getMESSAGEEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalTmscXtext.g:2757:3: (enumLiteral_1= 'request' )
                    {
                    // InternalTmscXtext.g:2757:3: (enumLiteral_1= 'request' )
                    // InternalTmscXtext.g:2758:4: enumLiteral_1= 'request'
                    {
                    enumLiteral_1=(Token)match(input,38,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getXDependencyTypeAccess().getREQUESTEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getXDependencyTypeAccess().getREQUESTEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalTmscXtext.g:2765:3: (enumLiteral_2= 'reply' )
                    {
                    // InternalTmscXtext.g:2765:3: (enumLiteral_2= 'reply' )
                    // InternalTmscXtext.g:2766:4: enumLiteral_2= 'reply'
                    {
                    enumLiteral_2=(Token)match(input,54,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getXDependencyTypeAccess().getREPLYEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getXDependencyTypeAccess().getREPLYEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalTmscXtext.g:2773:3: (enumLiteral_3= 'domain-dependency' )
                    {
                    // InternalTmscXtext.g:2773:3: (enumLiteral_3= 'domain-dependency' )
                    // InternalTmscXtext.g:2774:4: enumLiteral_3= 'domain-dependency'
                    {
                    enumLiteral_3=(Token)match(input,55,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getXDependencyTypeAccess().getDOMAINEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_3, grammarAccess.getXDependencyTypeAccess().getDOMAINEnumLiteralDeclaration_3());
                      			
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalTmscXtext.g:2781:3: (enumLiteral_4= 'lifeline-segment' )
                    {
                    // InternalTmscXtext.g:2781:3: (enumLiteral_4= 'lifeline-segment' )
                    // InternalTmscXtext.g:2782:4: enumLiteral_4= 'lifeline-segment'
                    {
                    enumLiteral_4=(Token)match(input,56,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getXDependencyTypeAccess().getLIFELINE_SEGMENTEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_4, grammarAccess.getXDependencyTypeAccess().getLIFELINE_SEGMENTEnumLiteralDeclaration_4());
                      			
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalTmscXtext.g:2789:3: (enumLiteral_5= 'message-control' )
                    {
                    // InternalTmscXtext.g:2789:3: (enumLiteral_5= 'message-control' )
                    // InternalTmscXtext.g:2790:4: enumLiteral_5= 'message-control'
                    {
                    enumLiteral_5=(Token)match(input,57,FOLLOW_2); if (state.failed) return current;
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


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x00000000001D0120L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000C00000000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000300000000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x03C000CC712D21F2L});
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
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x000F000000000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000104000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000200008002L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x00000000000D01A0L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x00300000000D0120L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000003080008002L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000003000008002L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x03C000C0000D0120L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x000000C0000D0120L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x00000100001D0120L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x00003200000D03B0L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000040004000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000080000000002L});

}