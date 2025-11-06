package nl.esi.pps.tmsc.xtext.ide.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalTmscXtextLexer extends Lexer {
    public static final int T__50=50;
    public static final int RULE_NEG_EBIGDECIMAL=9;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__59=59;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int RULE_ABS_EBIGDECIMAL=5;
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
    public static final int RULE_ID=7;
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
    public static final int RULE_ISO8601=4;
    public static final int RULE_POS_EBIGDECIMAL=8;
    public static final int RULE_STRING=6;
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

    public InternalTmscXtextLexer() {;} 
    public InternalTmscXtextLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalTmscXtextLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalTmscXtext.g"; }

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTmscXtext.g:11:7: ( 'true' )
            // InternalTmscXtext.g:11:9: 'true'
            {
            match("true"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTmscXtext.g:12:7: ( 'false' )
            // InternalTmscXtext.g:12:9: 'false'
            {
            match("false"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTmscXtext.g:13:7: ( 'internal' )
            // InternalTmscXtext.g:13:9: 'internal'
            {
            match("internal"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTmscXtext.g:14:7: ( 'external' )
            // InternalTmscXtext.g:14:9: 'external'
            {
            match("external"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTmscXtext.g:15:7: ( 'in' )
            // InternalTmscXtext.g:15:9: 'in'
            {
            match("in"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTmscXtext.g:16:7: ( 'out' )
            // InternalTmscXtext.g:16:9: 'out'
            {
            match("out"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTmscXtext.g:17:7: ( 'inout' )
            // InternalTmscXtext.g:17:9: 'inout'
            {
            match("inout"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTmscXtext.g:18:7: ( 'return' )
            // InternalTmscXtext.g:18:9: 'return'
            {
            match("return"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTmscXtext.g:19:7: ( '>' )
            // InternalTmscXtext.g:19:9: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTmscXtext.g:20:7: ( '<' )
            // InternalTmscXtext.g:20:9: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTmscXtext.g:21:7: ( 'message' )
            // InternalTmscXtext.g:21:9: 'message'
            {
            match("message"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTmscXtext.g:22:7: ( 'request' )
            // InternalTmscXtext.g:22:9: 'request'
            {
            match("request"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTmscXtext.g:23:7: ( 'reply' )
            // InternalTmscXtext.g:23:9: 'reply'
            {
            match("reply"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTmscXtext.g:24:7: ( 'domain-dependency' )
            // InternalTmscXtext.g:24:9: 'domain-dependency'
            {
            match("domain-dependency"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTmscXtext.g:25:7: ( 'lifeline-segment' )
            // InternalTmscXtext.g:25:9: 'lifeline-segment'
            {
            match("lifeline-segment"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTmscXtext.g:26:7: ( 'message-control' )
            // InternalTmscXtext.g:26:9: 'message-control'
            {
            match("message-control"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTmscXtext.g:27:7: ( 'tmsc' )
            // InternalTmscXtext.g:27:9: 'tmsc'
            {
            match("tmsc"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTmscXtext.g:28:7: ( 'settings' )
            // InternalTmscXtext.g:28:9: 'settings'
            {
            match("settings"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTmscXtext.g:29:7: ( '{' )
            // InternalTmscXtext.g:29:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTmscXtext.g:30:7: ( '}' )
            // InternalTmscXtext.g:30:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTmscXtext.g:31:7: ( 'architecture' )
            // InternalTmscXtext.g:31:9: 'architecture'
            {
            match("architecture"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTmscXtext.g:32:7: ( ':' )
            // InternalTmscXtext.g:32:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTmscXtext.g:33:7: ( 'time-bound' )
            // InternalTmscXtext.g:33:9: 'time-bound'
            {
            match("time-bound"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTmscXtext.g:34:7: ( 'scheduled' )
            // InternalTmscXtext.g:34:9: 'scheduled'
            {
            match("scheduled"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTmscXtext.g:35:7: ( 'analyses' )
            // InternalTmscXtext.g:35:9: 'analyses'
            {
            match("analyses"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTmscXtext.g:36:7: ( 'time-bound-analysis' )
            // InternalTmscXtext.g:36:9: 'time-bound-analysis'
            {
            match("time-bound-analysis"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTmscXtext.g:37:7: ( 'defaultTimeBound' )
            // InternalTmscXtext.g:37:9: 'defaultTimeBound'
            {
            match("defaultTimeBound"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTmscXtext.g:38:7: ( 'interface' )
            // InternalTmscXtext.g:38:9: 'interface'
            {
            match("interface"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTmscXtext.g:39:7: ( 'as' )
            // InternalTmscXtext.g:39:9: 'as'
            {
            match("as"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__41"

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTmscXtext.g:40:7: ( 'operation' )
            // InternalTmscXtext.g:40:9: 'operation'
            {
            match("operation"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTmscXtext.g:41:7: ( 'component' )
            // InternalTmscXtext.g:41:9: 'component'
            {
            match("component"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__43"

    // $ANTLR start "T__44"
    public final void mT__44() throws RecognitionException {
        try {
            int _type = T__44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTmscXtext.g:42:7: ( 'provides' )
            // InternalTmscXtext.g:42:9: 'provides'
            {
            match("provides"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__44"

    // $ANTLR start "T__45"
    public final void mT__45() throws RecognitionException {
        try {
            int _type = T__45;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTmscXtext.g:43:7: ( ',' )
            // InternalTmscXtext.g:43:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__45"

    // $ANTLR start "T__46"
    public final void mT__46() throws RecognitionException {
        try {
            int _type = T__46;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTmscXtext.g:44:7: ( 'requires' )
            // InternalTmscXtext.g:44:9: 'requires'
            {
            match("requires"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__46"

    // $ANTLR start "T__47"
    public final void mT__47() throws RecognitionException {
        try {
            int _type = T__47;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTmscXtext.g:45:7: ( 'function' )
            // InternalTmscXtext.g:45:9: 'function'
            {
            match("function"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__47"

    // $ANTLR start "T__48"
    public final void mT__48() throws RecognitionException {
        try {
            int _type = T__48;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTmscXtext.g:46:7: ( '(' )
            // InternalTmscXtext.g:46:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__48"

    // $ANTLR start "T__49"
    public final void mT__49() throws RecognitionException {
        try {
            int _type = T__49;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTmscXtext.g:47:7: ( ')' )
            // InternalTmscXtext.g:47:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__49"

    // $ANTLR start "T__50"
    public final void mT__50() throws RecognitionException {
        try {
            int _type = T__50;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTmscXtext.g:48:7: ( 'implements' )
            // InternalTmscXtext.g:48:9: 'implements'
            {
            match("implements"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__50"

    // $ANTLR start "T__51"
    public final void mT__51() throws RecognitionException {
        try {
            int _type = T__51;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTmscXtext.g:49:7: ( 'host' )
            // InternalTmscXtext.g:49:9: 'host'
            {
            match("host"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__51"

    // $ANTLR start "T__52"
    public final void mT__52() throws RecognitionException {
        try {
            int _type = T__52;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTmscXtext.g:50:7: ( 'executor' )
            // InternalTmscXtext.g:50:9: 'executor'
            {
            match("executor"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__52"

    // $ANTLR start "T__53"
    public final void mT__53() throws RecognitionException {
        try {
            int _type = T__53;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTmscXtext.g:51:7: ( '!' )
            // InternalTmscXtext.g:51:9: '!'
            {
            match('!'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__53"

    // $ANTLR start "T__54"
    public final void mT__54() throws RecognitionException {
        try {
            int _type = T__54;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTmscXtext.g:52:7: ( '?' )
            // InternalTmscXtext.g:52:9: '?'
            {
            match('?'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__54"

    // $ANTLR start "T__55"
    public final void mT__55() throws RecognitionException {
        try {
            int _type = T__55;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTmscXtext.g:53:7: ( 'prefix' )
            // InternalTmscXtext.g:53:9: 'prefix'
            {
            match("prefix"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__55"

    // $ANTLR start "T__56"
    public final void mT__56() throws RecognitionException {
        try {
            int _type = T__56;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTmscXtext.g:54:7: ( '[' )
            // InternalTmscXtext.g:54:9: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__56"

    // $ANTLR start "T__57"
    public final void mT__57() throws RecognitionException {
        try {
            int _type = T__57;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTmscXtext.g:55:7: ( ']' )
            // InternalTmscXtext.g:55:9: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__57"

    // $ANTLR start "T__58"
    public final void mT__58() throws RecognitionException {
        try {
            int _type = T__58;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTmscXtext.g:56:7: ( '.' )
            // InternalTmscXtext.g:56:9: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__58"

    // $ANTLR start "T__59"
    public final void mT__59() throws RecognitionException {
        try {
            int _type = T__59;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTmscXtext.g:57:7: ( 'ipc-client' )
            // InternalTmscXtext.g:57:9: 'ipc-client'
            {
            match("ipc-client"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__59"

    // $ANTLR start "T__60"
    public final void mT__60() throws RecognitionException {
        try {
            int _type = T__60;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTmscXtext.g:58:7: ( 'ipc-server' )
            // InternalTmscXtext.g:58:9: 'ipc-server'
            {
            match("ipc-server"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__60"

    // $ANTLR start "T__61"
    public final void mT__61() throws RecognitionException {
        try {
            int _type = T__61;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTmscXtext.g:59:7: ( 'untraced' )
            // InternalTmscXtext.g:59:9: 'untraced'
            {
            match("untraced"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__61"

    // $ANTLR start "RULE_POS_EBIGDECIMAL"
    public final void mRULE_POS_EBIGDECIMAL() throws RecognitionException {
        try {
            int _type = RULE_POS_EBIGDECIMAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTmscXtext.g:9451:22: ( '+' ( '0' .. '9' )+ ( '.' ( '0' .. '9' )+ )? ( 'e' ( '+' | '-' ) ( '0' .. '9' )+ )? )
            // InternalTmscXtext.g:9451:24: '+' ( '0' .. '9' )+ ( '.' ( '0' .. '9' )+ )? ( 'e' ( '+' | '-' ) ( '0' .. '9' )+ )?
            {
            match('+'); 
            // InternalTmscXtext.g:9451:28: ( '0' .. '9' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='0' && LA1_0<='9')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalTmscXtext.g:9451:29: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);

            // InternalTmscXtext.g:9451:40: ( '.' ( '0' .. '9' )+ )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='.') ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalTmscXtext.g:9451:41: '.' ( '0' .. '9' )+
                    {
                    match('.'); 
                    // InternalTmscXtext.g:9451:45: ( '0' .. '9' )+
                    int cnt2=0;
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( ((LA2_0>='0' && LA2_0<='9')) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // InternalTmscXtext.g:9451:46: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt2 >= 1 ) break loop2;
                                EarlyExitException eee =
                                    new EarlyExitException(2, input);
                                throw eee;
                        }
                        cnt2++;
                    } while (true);


                    }
                    break;

            }

            // InternalTmscXtext.g:9451:59: ( 'e' ( '+' | '-' ) ( '0' .. '9' )+ )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='e') ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalTmscXtext.g:9451:60: 'e' ( '+' | '-' ) ( '0' .. '9' )+
                    {
                    match('e'); 
                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}

                    // InternalTmscXtext.g:9451:74: ( '0' .. '9' )+
                    int cnt4=0;
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( ((LA4_0>='0' && LA4_0<='9')) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // InternalTmscXtext.g:9451:75: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

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


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_POS_EBIGDECIMAL"

    // $ANTLR start "RULE_NEG_EBIGDECIMAL"
    public final void mRULE_NEG_EBIGDECIMAL() throws RecognitionException {
        try {
            int _type = RULE_NEG_EBIGDECIMAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTmscXtext.g:9453:22: ( '-' ( '0' .. '9' )+ ( '.' ( '0' .. '9' )+ )? ( 'e' ( '+' | '-' ) ( '0' .. '9' )+ )? )
            // InternalTmscXtext.g:9453:24: '-' ( '0' .. '9' )+ ( '.' ( '0' .. '9' )+ )? ( 'e' ( '+' | '-' ) ( '0' .. '9' )+ )?
            {
            match('-'); 
            // InternalTmscXtext.g:9453:28: ( '0' .. '9' )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='0' && LA6_0<='9')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalTmscXtext.g:9453:29: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);

            // InternalTmscXtext.g:9453:40: ( '.' ( '0' .. '9' )+ )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0=='.') ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalTmscXtext.g:9453:41: '.' ( '0' .. '9' )+
                    {
                    match('.'); 
                    // InternalTmscXtext.g:9453:45: ( '0' .. '9' )+
                    int cnt7=0;
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( ((LA7_0>='0' && LA7_0<='9')) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // InternalTmscXtext.g:9453:46: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt7 >= 1 ) break loop7;
                                EarlyExitException eee =
                                    new EarlyExitException(7, input);
                                throw eee;
                        }
                        cnt7++;
                    } while (true);


                    }
                    break;

            }

            // InternalTmscXtext.g:9453:59: ( 'e' ( '+' | '-' ) ( '0' .. '9' )+ )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='e') ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalTmscXtext.g:9453:60: 'e' ( '+' | '-' ) ( '0' .. '9' )+
                    {
                    match('e'); 
                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}

                    // InternalTmscXtext.g:9453:74: ( '0' .. '9' )+
                    int cnt9=0;
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( ((LA9_0>='0' && LA9_0<='9')) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // InternalTmscXtext.g:9453:75: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt9 >= 1 ) break loop9;
                                EarlyExitException eee =
                                    new EarlyExitException(9, input);
                                throw eee;
                        }
                        cnt9++;
                    } while (true);


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_NEG_EBIGDECIMAL"

    // $ANTLR start "RULE_ABS_EBIGDECIMAL"
    public final void mRULE_ABS_EBIGDECIMAL() throws RecognitionException {
        try {
            int _type = RULE_ABS_EBIGDECIMAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTmscXtext.g:9455:22: ( ( '0' .. '9' )+ ( '.' ( '0' .. '9' )+ )? ( 'e' ( '+' | '-' ) ( '0' .. '9' )+ )? )
            // InternalTmscXtext.g:9455:24: ( '0' .. '9' )+ ( '.' ( '0' .. '9' )+ )? ( 'e' ( '+' | '-' ) ( '0' .. '9' )+ )?
            {
            // InternalTmscXtext.g:9455:24: ( '0' .. '9' )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>='0' && LA11_0<='9')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalTmscXtext.g:9455:25: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt11 >= 1 ) break loop11;
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
            } while (true);

            // InternalTmscXtext.g:9455:36: ( '.' ( '0' .. '9' )+ )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0=='.') ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalTmscXtext.g:9455:37: '.' ( '0' .. '9' )+
                    {
                    match('.'); 
                    // InternalTmscXtext.g:9455:41: ( '0' .. '9' )+
                    int cnt12=0;
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( ((LA12_0>='0' && LA12_0<='9')) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // InternalTmscXtext.g:9455:42: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt12 >= 1 ) break loop12;
                                EarlyExitException eee =
                                    new EarlyExitException(12, input);
                                throw eee;
                        }
                        cnt12++;
                    } while (true);


                    }
                    break;

            }

            // InternalTmscXtext.g:9455:55: ( 'e' ( '+' | '-' ) ( '0' .. '9' )+ )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0=='e') ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalTmscXtext.g:9455:56: 'e' ( '+' | '-' ) ( '0' .. '9' )+
                    {
                    match('e'); 
                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}

                    // InternalTmscXtext.g:9455:70: ( '0' .. '9' )+
                    int cnt14=0;
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( ((LA14_0>='0' && LA14_0<='9')) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // InternalTmscXtext.g:9455:71: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt14 >= 1 ) break loop14;
                                EarlyExitException eee =
                                    new EarlyExitException(14, input);
                                throw eee;
                        }
                        cnt14++;
                    } while (true);


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ABS_EBIGDECIMAL"

    // $ANTLR start "RULE_ISO8601"
    public final void mRULE_ISO8601() throws RecognitionException {
        try {
            int _type = RULE_ISO8601;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTmscXtext.g:9457:14: ( '0' .. '9' '0' .. '9' '0' .. '9' '0' .. '9' ( '-' )? '0' .. '9' '0' .. '9' ( '-' )? '0' .. '9' '0' .. '9' 'T' '0' .. '9' '0' .. '9' ( ':' )? '0' .. '9' '0' .. '9' ( ':' )? '0' .. '9' '0' .. '9' ( '.' ( '0' .. '9' )+ )? ( 'Z' | ( '+' | '-' ) '0' .. '9' '0' .. '9' ( ':' )? '0' .. '9' '0' .. '9' ) )
            // InternalTmscXtext.g:9457:16: '0' .. '9' '0' .. '9' '0' .. '9' '0' .. '9' ( '-' )? '0' .. '9' '0' .. '9' ( '-' )? '0' .. '9' '0' .. '9' 'T' '0' .. '9' '0' .. '9' ( ':' )? '0' .. '9' '0' .. '9' ( ':' )? '0' .. '9' '0' .. '9' ( '.' ( '0' .. '9' )+ )? ( 'Z' | ( '+' | '-' ) '0' .. '9' '0' .. '9' ( ':' )? '0' .. '9' '0' .. '9' )
            {
            matchRange('0','9'); 
            matchRange('0','9'); 
            matchRange('0','9'); 
            matchRange('0','9'); 
            // InternalTmscXtext.g:9457:52: ( '-' )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0=='-') ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalTmscXtext.g:9457:52: '-'
                    {
                    match('-'); 

                    }
                    break;

            }

            matchRange('0','9'); 
            matchRange('0','9'); 
            // InternalTmscXtext.g:9457:75: ( '-' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0=='-') ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalTmscXtext.g:9457:75: '-'
                    {
                    match('-'); 

                    }
                    break;

            }

            matchRange('0','9'); 
            matchRange('0','9'); 
            match('T'); 
            matchRange('0','9'); 
            matchRange('0','9'); 
            // InternalTmscXtext.g:9457:120: ( ':' )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==':') ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalTmscXtext.g:9457:120: ':'
                    {
                    match(':'); 

                    }
                    break;

            }

            matchRange('0','9'); 
            matchRange('0','9'); 
            // InternalTmscXtext.g:9457:143: ( ':' )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==':') ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalTmscXtext.g:9457:143: ':'
                    {
                    match(':'); 

                    }
                    break;

            }

            matchRange('0','9'); 
            matchRange('0','9'); 
            // InternalTmscXtext.g:9457:166: ( '.' ( '0' .. '9' )+ )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0=='.') ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalTmscXtext.g:9457:167: '.' ( '0' .. '9' )+
                    {
                    match('.'); 
                    // InternalTmscXtext.g:9457:171: ( '0' .. '9' )+
                    int cnt20=0;
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( ((LA20_0>='0' && LA20_0<='9')) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // InternalTmscXtext.g:9457:172: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt20 >= 1 ) break loop20;
                                EarlyExitException eee =
                                    new EarlyExitException(20, input);
                                throw eee;
                        }
                        cnt20++;
                    } while (true);


                    }
                    break;

            }

            // InternalTmscXtext.g:9457:185: ( 'Z' | ( '+' | '-' ) '0' .. '9' '0' .. '9' ( ':' )? '0' .. '9' '0' .. '9' )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0=='Z') ) {
                alt23=1;
            }
            else if ( (LA23_0=='+'||LA23_0=='-') ) {
                alt23=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // InternalTmscXtext.g:9457:186: 'Z'
                    {
                    match('Z'); 

                    }
                    break;
                case 2 :
                    // InternalTmscXtext.g:9457:190: ( '+' | '-' ) '0' .. '9' '0' .. '9' ( ':' )? '0' .. '9' '0' .. '9'
                    {
                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}

                    matchRange('0','9'); 
                    matchRange('0','9'); 
                    // InternalTmscXtext.g:9457:218: ( ':' )?
                    int alt22=2;
                    int LA22_0 = input.LA(1);

                    if ( (LA22_0==':') ) {
                        alt22=1;
                    }
                    switch (alt22) {
                        case 1 :
                            // InternalTmscXtext.g:9457:218: ':'
                            {
                            match(':'); 

                            }
                            break;

                    }

                    matchRange('0','9'); 
                    matchRange('0','9'); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ISO8601"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTmscXtext.g:9459:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // InternalTmscXtext.g:9459:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // InternalTmscXtext.g:9459:11: ( '^' )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0=='^') ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalTmscXtext.g:9459:11: '^'
                    {
                    match('^'); 

                    }
                    break;

            }

            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // InternalTmscXtext.g:9459:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( ((LA25_0>='0' && LA25_0<='9')||(LA25_0>='A' && LA25_0<='Z')||LA25_0=='_'||(LA25_0>='a' && LA25_0<='z')) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalTmscXtext.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ID"

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTmscXtext.g:9461:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // InternalTmscXtext.g:9461:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // InternalTmscXtext.g:9461:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0=='\"') ) {
                alt28=1;
            }
            else if ( (LA28_0=='\'') ) {
                alt28=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // InternalTmscXtext.g:9461:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // InternalTmscXtext.g:9461:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop26:
                    do {
                        int alt26=3;
                        int LA26_0 = input.LA(1);

                        if ( (LA26_0=='\\') ) {
                            alt26=1;
                        }
                        else if ( ((LA26_0>='\u0000' && LA26_0<='!')||(LA26_0>='#' && LA26_0<='[')||(LA26_0>=']' && LA26_0<='\uFFFF')) ) {
                            alt26=2;
                        }


                        switch (alt26) {
                    	case 1 :
                    	    // InternalTmscXtext.g:9461:21: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalTmscXtext.g:9461:28: ~ ( ( '\\\\' | '\"' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop26;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // InternalTmscXtext.g:9461:48: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // InternalTmscXtext.g:9461:53: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop27:
                    do {
                        int alt27=3;
                        int LA27_0 = input.LA(1);

                        if ( (LA27_0=='\\') ) {
                            alt27=1;
                        }
                        else if ( ((LA27_0>='\u0000' && LA27_0<='&')||(LA27_0>='(' && LA27_0<='[')||(LA27_0>=']' && LA27_0<='\uFFFF')) ) {
                            alt27=2;
                        }


                        switch (alt27) {
                    	case 1 :
                    	    // InternalTmscXtext.g:9461:54: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalTmscXtext.g:9461:61: ~ ( ( '\\\\' | '\\'' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop27;
                        }
                    } while (true);

                    match('\''); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_STRING"

    // $ANTLR start "RULE_ML_COMMENT"
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTmscXtext.g:9463:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // InternalTmscXtext.g:9463:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // InternalTmscXtext.g:9463:24: ( options {greedy=false; } : . )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0=='*') ) {
                    int LA29_1 = input.LA(2);

                    if ( (LA29_1=='/') ) {
                        alt29=2;
                    }
                    else if ( ((LA29_1>='\u0000' && LA29_1<='.')||(LA29_1>='0' && LA29_1<='\uFFFF')) ) {
                        alt29=1;
                    }


                }
                else if ( ((LA29_0>='\u0000' && LA29_0<=')')||(LA29_0>='+' && LA29_0<='\uFFFF')) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // InternalTmscXtext.g:9463:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);

            match("*/"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ML_COMMENT"

    // $ANTLR start "RULE_SL_COMMENT"
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTmscXtext.g:9465:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // InternalTmscXtext.g:9465:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // InternalTmscXtext.g:9465:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( ((LA30_0>='\u0000' && LA30_0<='\t')||(LA30_0>='\u000B' && LA30_0<='\f')||(LA30_0>='\u000E' && LA30_0<='\uFFFF')) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalTmscXtext.g:9465:24: ~ ( ( '\\n' | '\\r' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);

            // InternalTmscXtext.g:9465:40: ( ( '\\r' )? '\\n' )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0=='\n'||LA32_0=='\r') ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalTmscXtext.g:9465:41: ( '\\r' )? '\\n'
                    {
                    // InternalTmscXtext.g:9465:41: ( '\\r' )?
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( (LA31_0=='\r') ) {
                        alt31=1;
                    }
                    switch (alt31) {
                        case 1 :
                            // InternalTmscXtext.g:9465:41: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }

                    match('\n'); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SL_COMMENT"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTmscXtext.g:9467:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // InternalTmscXtext.g:9467:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // InternalTmscXtext.g:9467:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt33=0;
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( ((LA33_0>='\t' && LA33_0<='\n')||LA33_0=='\r'||LA33_0==' ') ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // InternalTmscXtext.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt33 >= 1 ) break loop33;
                        EarlyExitException eee =
                            new EarlyExitException(33, input);
                        throw eee;
                }
                cnt33++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WS"

    public void mTokens() throws RecognitionException {
        // InternalTmscXtext.g:1:8: ( T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | RULE_POS_EBIGDECIMAL | RULE_NEG_EBIGDECIMAL | RULE_ABS_EBIGDECIMAL | RULE_ISO8601 | RULE_ID | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS )
        int alt34=58;
        alt34 = dfa34.predict(input);
        switch (alt34) {
            case 1 :
                // InternalTmscXtext.g:1:10: T__13
                {
                mT__13(); 

                }
                break;
            case 2 :
                // InternalTmscXtext.g:1:16: T__14
                {
                mT__14(); 

                }
                break;
            case 3 :
                // InternalTmscXtext.g:1:22: T__15
                {
                mT__15(); 

                }
                break;
            case 4 :
                // InternalTmscXtext.g:1:28: T__16
                {
                mT__16(); 

                }
                break;
            case 5 :
                // InternalTmscXtext.g:1:34: T__17
                {
                mT__17(); 

                }
                break;
            case 6 :
                // InternalTmscXtext.g:1:40: T__18
                {
                mT__18(); 

                }
                break;
            case 7 :
                // InternalTmscXtext.g:1:46: T__19
                {
                mT__19(); 

                }
                break;
            case 8 :
                // InternalTmscXtext.g:1:52: T__20
                {
                mT__20(); 

                }
                break;
            case 9 :
                // InternalTmscXtext.g:1:58: T__21
                {
                mT__21(); 

                }
                break;
            case 10 :
                // InternalTmscXtext.g:1:64: T__22
                {
                mT__22(); 

                }
                break;
            case 11 :
                // InternalTmscXtext.g:1:70: T__23
                {
                mT__23(); 

                }
                break;
            case 12 :
                // InternalTmscXtext.g:1:76: T__24
                {
                mT__24(); 

                }
                break;
            case 13 :
                // InternalTmscXtext.g:1:82: T__25
                {
                mT__25(); 

                }
                break;
            case 14 :
                // InternalTmscXtext.g:1:88: T__26
                {
                mT__26(); 

                }
                break;
            case 15 :
                // InternalTmscXtext.g:1:94: T__27
                {
                mT__27(); 

                }
                break;
            case 16 :
                // InternalTmscXtext.g:1:100: T__28
                {
                mT__28(); 

                }
                break;
            case 17 :
                // InternalTmscXtext.g:1:106: T__29
                {
                mT__29(); 

                }
                break;
            case 18 :
                // InternalTmscXtext.g:1:112: T__30
                {
                mT__30(); 

                }
                break;
            case 19 :
                // InternalTmscXtext.g:1:118: T__31
                {
                mT__31(); 

                }
                break;
            case 20 :
                // InternalTmscXtext.g:1:124: T__32
                {
                mT__32(); 

                }
                break;
            case 21 :
                // InternalTmscXtext.g:1:130: T__33
                {
                mT__33(); 

                }
                break;
            case 22 :
                // InternalTmscXtext.g:1:136: T__34
                {
                mT__34(); 

                }
                break;
            case 23 :
                // InternalTmscXtext.g:1:142: T__35
                {
                mT__35(); 

                }
                break;
            case 24 :
                // InternalTmscXtext.g:1:148: T__36
                {
                mT__36(); 

                }
                break;
            case 25 :
                // InternalTmscXtext.g:1:154: T__37
                {
                mT__37(); 

                }
                break;
            case 26 :
                // InternalTmscXtext.g:1:160: T__38
                {
                mT__38(); 

                }
                break;
            case 27 :
                // InternalTmscXtext.g:1:166: T__39
                {
                mT__39(); 

                }
                break;
            case 28 :
                // InternalTmscXtext.g:1:172: T__40
                {
                mT__40(); 

                }
                break;
            case 29 :
                // InternalTmscXtext.g:1:178: T__41
                {
                mT__41(); 

                }
                break;
            case 30 :
                // InternalTmscXtext.g:1:184: T__42
                {
                mT__42(); 

                }
                break;
            case 31 :
                // InternalTmscXtext.g:1:190: T__43
                {
                mT__43(); 

                }
                break;
            case 32 :
                // InternalTmscXtext.g:1:196: T__44
                {
                mT__44(); 

                }
                break;
            case 33 :
                // InternalTmscXtext.g:1:202: T__45
                {
                mT__45(); 

                }
                break;
            case 34 :
                // InternalTmscXtext.g:1:208: T__46
                {
                mT__46(); 

                }
                break;
            case 35 :
                // InternalTmscXtext.g:1:214: T__47
                {
                mT__47(); 

                }
                break;
            case 36 :
                // InternalTmscXtext.g:1:220: T__48
                {
                mT__48(); 

                }
                break;
            case 37 :
                // InternalTmscXtext.g:1:226: T__49
                {
                mT__49(); 

                }
                break;
            case 38 :
                // InternalTmscXtext.g:1:232: T__50
                {
                mT__50(); 

                }
                break;
            case 39 :
                // InternalTmscXtext.g:1:238: T__51
                {
                mT__51(); 

                }
                break;
            case 40 :
                // InternalTmscXtext.g:1:244: T__52
                {
                mT__52(); 

                }
                break;
            case 41 :
                // InternalTmscXtext.g:1:250: T__53
                {
                mT__53(); 

                }
                break;
            case 42 :
                // InternalTmscXtext.g:1:256: T__54
                {
                mT__54(); 

                }
                break;
            case 43 :
                // InternalTmscXtext.g:1:262: T__55
                {
                mT__55(); 

                }
                break;
            case 44 :
                // InternalTmscXtext.g:1:268: T__56
                {
                mT__56(); 

                }
                break;
            case 45 :
                // InternalTmscXtext.g:1:274: T__57
                {
                mT__57(); 

                }
                break;
            case 46 :
                // InternalTmscXtext.g:1:280: T__58
                {
                mT__58(); 

                }
                break;
            case 47 :
                // InternalTmscXtext.g:1:286: T__59
                {
                mT__59(); 

                }
                break;
            case 48 :
                // InternalTmscXtext.g:1:292: T__60
                {
                mT__60(); 

                }
                break;
            case 49 :
                // InternalTmscXtext.g:1:298: T__61
                {
                mT__61(); 

                }
                break;
            case 50 :
                // InternalTmscXtext.g:1:304: RULE_POS_EBIGDECIMAL
                {
                mRULE_POS_EBIGDECIMAL(); 

                }
                break;
            case 51 :
                // InternalTmscXtext.g:1:325: RULE_NEG_EBIGDECIMAL
                {
                mRULE_NEG_EBIGDECIMAL(); 

                }
                break;
            case 52 :
                // InternalTmscXtext.g:1:346: RULE_ABS_EBIGDECIMAL
                {
                mRULE_ABS_EBIGDECIMAL(); 

                }
                break;
            case 53 :
                // InternalTmscXtext.g:1:367: RULE_ISO8601
                {
                mRULE_ISO8601(); 

                }
                break;
            case 54 :
                // InternalTmscXtext.g:1:380: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 55 :
                // InternalTmscXtext.g:1:388: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 56 :
                // InternalTmscXtext.g:1:400: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 57 :
                // InternalTmscXtext.g:1:416: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 58 :
                // InternalTmscXtext.g:1:432: RULE_WS
                {
                mRULE_WS(); 

                }
                break;

        }

    }


    protected DFA34 dfa34 = new DFA34(this);
    static final String DFA34_eotS =
        "\1\uffff\6\40\2\uffff\4\40\2\uffff\1\40\1\uffff\2\40\3\uffff\1\40\5\uffff\1\40\2\uffff\1\76\4\uffff\5\40\1\110\16\40\1\132\4\40\1\76\3\uffff\7\40\1\uffff\4\40\1\154\14\40\1\uffff\5\40\1\76\1\177\1\u0080\6\40\1\uffff\2\40\1\uffff\17\40\1\u009b\1\40\1\76\3\uffff\1\u00a0\2\40\1\u00a4\1\40\2\uffff\6\40\1\u00ac\13\40\1\uffff\1\40\1\uffff\1\76\2\uffff\3\40\1\uffff\4\40\1\u00c2\2\40\1\uffff\12\40\1\u00cf\1\40\1\76\1\uffff\7\40\1\uffff\1\u00da\1\40\1\u00dd\1\uffff\10\40\1\uffff\1\40\1\76\1\uffff\1\u00e9\1\u00ea\2\40\1\u00ed\1\u00ee\1\40\1\uffff\1\u00f0\2\uffff\2\40\1\u00f3\2\40\1\u00f6\1\40\1\u00f8\1\u00f9\1\76\3\uffff\1\u00fb\1\40\2\uffff\1\u00fd\1\uffff\1\40\2\uffff\1\u00ff\1\40\1\uffff\1\u0101\2\uffff\1\u0103\1\uffff\1\u0104\1\uffff\1\40\1\uffff\1\40\4\uffff\3\40\1\u010a\1\40\1\uffff\2\40\1\u010e\1\uffff";
    static final String DFA34_eofS =
        "\u010f\uffff";
    static final String DFA34_minS =
        "\1\11\1\151\1\141\1\155\1\170\1\160\1\145\2\uffff\2\145\1\151\1\143\2\uffff\1\156\1\uffff\1\157\1\162\3\uffff\1\157\5\uffff\1\156\2\uffff\1\60\2\uffff\1\52\1\uffff\1\165\1\163\1\155\1\154\1\156\1\60\1\160\1\143\1\145\1\164\1\145\1\160\1\163\1\155\2\146\1\164\1\150\1\143\1\141\1\60\1\155\1\145\1\163\1\164\1\60\3\uffff\1\145\1\143\1\145\1\163\1\143\1\145\1\165\1\uffff\1\154\1\55\1\145\1\143\1\60\1\162\2\165\1\154\1\163\2\141\1\145\1\164\1\145\1\150\1\154\1\uffff\1\160\1\166\1\146\1\164\1\162\3\60\1\55\1\145\1\164\1\162\1\164\1\145\1\143\1\162\1\165\1\uffff\1\141\1\162\1\145\1\171\1\141\1\151\1\165\1\154\1\151\1\144\1\151\1\171\1\157\2\151\1\60\1\141\1\55\2\uffff\1\142\1\60\1\151\1\146\1\60\1\155\2\uffff\1\156\2\164\1\156\1\163\1\162\1\60\1\147\1\156\1\154\1\151\1\156\1\165\1\164\1\163\1\156\1\144\1\170\1\uffff\1\143\1\uffff\1\60\1\157\1\uffff\1\157\2\141\1\uffff\1\145\1\141\1\157\1\151\1\60\1\164\1\145\1\uffff\1\145\1\55\1\164\1\156\1\147\1\154\4\145\1\60\1\145\1\55\1\165\1\156\1\154\1\143\1\156\1\154\1\162\1\157\1\uffff\1\60\1\163\1\55\1\uffff\1\124\1\145\1\163\1\145\1\143\1\163\1\156\1\163\1\uffff\1\144\1\60\1\156\2\60\1\145\1\164\2\60\1\156\1\uffff\1\60\2\uffff\1\151\1\55\1\60\1\144\1\164\1\60\1\164\2\60\1\124\1\144\2\uffff\1\60\1\163\2\uffff\1\60\1\uffff\1\155\2\uffff\1\60\1\165\1\uffff\1\60\2\uffff\1\55\1\uffff\1\60\1\uffff\1\145\1\uffff\1\162\4\uffff\1\102\1\145\1\157\1\60\1\165\1\uffff\1\156\1\144\1\60\1\uffff";
    static final String DFA34_maxS =
        "\1\175\1\162\1\165\1\160\1\170\1\165\1\145\2\uffff\1\145\1\157\1\151\1\145\2\uffff\1\163\1\uffff\1\157\1\162\3\uffff\1\157\5\uffff\1\156\2\uffff\1\71\2\uffff\1\57\1\uffff\1\165\1\163\1\155\1\154\1\156\1\172\1\160\1\143\2\164\1\145\1\164\1\163\1\155\2\146\1\164\1\150\1\143\1\141\1\172\1\155\1\157\1\163\1\164\1\71\3\uffff\1\145\1\143\1\145\1\163\1\143\1\145\1\165\1\uffff\1\154\1\55\1\145\1\143\1\172\1\162\2\165\1\154\1\163\2\141\1\145\1\164\1\145\1\150\1\154\1\uffff\1\160\1\166\1\146\1\164\1\162\1\71\2\172\1\55\1\145\1\164\1\162\1\164\1\145\1\163\1\162\1\165\1\uffff\1\141\1\162\1\151\1\171\1\141\1\151\1\165\1\154\1\151\1\144\1\151\1\171\1\157\2\151\1\172\1\141\1\71\2\uffff\1\142\1\172\1\151\1\156\1\172\1\155\2\uffff\1\156\2\164\1\156\1\163\1\162\1\172\1\147\1\156\1\154\1\151\1\156\1\165\1\164\1\163\1\156\1\144\1\170\1\uffff\1\143\1\uffff\1\71\1\157\1\uffff\1\157\2\141\1\uffff\1\145\1\141\1\157\1\151\1\172\1\164\1\145\1\uffff\1\145\1\55\1\164\1\156\1\147\1\154\4\145\1\172\1\145\1\71\1\165\1\156\1\154\1\143\1\156\1\154\1\162\1\157\1\uffff\1\172\1\163\1\172\1\uffff\1\124\1\145\1\163\1\145\1\143\1\163\1\156\1\163\1\uffff\1\144\1\71\1\156\2\172\1\145\1\164\2\172\1\156\1\uffff\1\172\2\uffff\1\151\1\55\1\172\1\144\1\164\1\172\1\164\2\172\1\124\1\144\2\uffff\1\172\1\163\2\uffff\1\172\1\uffff\1\155\2\uffff\1\172\1\165\1\uffff\1\172\2\uffff\1\55\1\uffff\1\172\1\uffff\1\145\1\uffff\1\162\4\uffff\1\102\1\145\1\157\1\172\1\165\1\uffff\1\156\1\144\1\172\1\uffff";
    static final String DFA34_acceptS =
        "\7\uffff\1\11\1\12\4\uffff\1\23\1\24\1\uffff\1\26\2\uffff\1\41\1\44\1\45\1\uffff\1\51\1\52\1\54\1\55\1\56\1\uffff\1\62\1\63\1\uffff\1\66\1\67\1\uffff\1\72\32\uffff\1\64\1\70\1\71\7\uffff\1\5\21\uffff\1\35\21\uffff\1\6\22\uffff\1\1\1\21\6\uffff\1\57\1\60\22\uffff\1\47\1\uffff\1\65\2\uffff\1\2\3\uffff\1\7\7\uffff\1\15\25\uffff\1\10\3\uffff\1\16\10\uffff\1\53\12\uffff\1\14\1\uffff\1\20\1\13\13\uffff\1\43\1\3\2\uffff\1\4\1\50\1\uffff\1\42\1\uffff\1\17\1\22\2\uffff\1\31\1\uffff\1\40\1\61\1\uffff\1\34\1\uffff\1\36\1\uffff\1\30\1\uffff\1\37\1\32\1\27\1\46\5\uffff\1\25\3\uffff\1\33";
    static final String DFA34_specialS =
        "\u010f\uffff}>";
    static final String[] DFA34_transitionS = {
            "\2\43\2\uffff\1\43\22\uffff\1\43\1\27\1\41\4\uffff\1\41\1\24\1\25\1\uffff\1\35\1\23\1\36\1\33\1\42\12\37\1\20\1\uffff\1\10\1\uffff\1\7\1\30\1\uffff\32\40\1\31\1\uffff\1\32\2\40\1\uffff\1\17\1\40\1\21\1\12\1\4\1\2\1\40\1\26\1\3\2\40\1\13\1\11\1\40\1\5\1\22\1\40\1\6\1\14\1\1\1\34\5\40\1\15\1\uffff\1\16",
            "\1\46\3\uffff\1\45\4\uffff\1\44",
            "\1\47\23\uffff\1\50",
            "\1\52\1\51\1\uffff\1\53",
            "\1\54",
            "\1\56\4\uffff\1\55",
            "\1\57",
            "",
            "",
            "\1\60",
            "\1\62\11\uffff\1\61",
            "\1\63",
            "\1\65\1\uffff\1\64",
            "",
            "",
            "\1\67\3\uffff\1\66\1\70",
            "",
            "\1\71",
            "\1\72",
            "",
            "",
            "",
            "\1\73",
            "",
            "",
            "",
            "",
            "",
            "\1\74",
            "",
            "",
            "\12\75",
            "",
            "",
            "\1\77\4\uffff\1\100",
            "",
            "\1\101",
            "\1\102",
            "\1\103",
            "\1\104",
            "\1\105",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\16\40\1\107\4\40\1\106\6\40",
            "\1\111",
            "\1\112",
            "\1\114\16\uffff\1\113",
            "\1\115",
            "\1\116",
            "\1\121\1\120\2\uffff\1\117",
            "\1\122",
            "\1\123",
            "\1\124",
            "\1\125",
            "\1\126",
            "\1\127",
            "\1\130",
            "\1\131",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\1\133",
            "\1\135\11\uffff\1\134",
            "\1\136",
            "\1\137",
            "\12\140",
            "",
            "",
            "",
            "\1\141",
            "\1\142",
            "\1\143",
            "\1\144",
            "\1\145",
            "\1\146",
            "\1\147",
            "",
            "\1\150",
            "\1\151",
            "\1\152",
            "\1\153",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\1\155",
            "\1\156",
            "\1\157",
            "\1\160",
            "\1\161",
            "\1\162",
            "\1\163",
            "\1\164",
            "\1\165",
            "\1\166",
            "\1\167",
            "\1\170",
            "",
            "\1\171",
            "\1\172",
            "\1\173",
            "\1\174",
            "\1\175",
            "\12\176",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\1\u0081",
            "\1\u0082",
            "\1\u0083",
            "\1\u0084",
            "\1\u0085",
            "\1\u0086",
            "\1\u0087\17\uffff\1\u0088",
            "\1\u0089",
            "\1\u008a",
            "",
            "\1\u008b",
            "\1\u008c",
            "\1\u008d\3\uffff\1\u008e",
            "\1\u008f",
            "\1\u0090",
            "\1\u0091",
            "\1\u0092",
            "\1\u0093",
            "\1\u0094",
            "\1\u0095",
            "\1\u0096",
            "\1\u0097",
            "\1\u0098",
            "\1\u0099",
            "\1\u009a",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\1\u009c",
            "\1\u009d\2\uffff\12\u009e",
            "",
            "",
            "\1\u009f",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\1\u00a1",
            "\1\u00a3\7\uffff\1\u00a2",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\1\u00a5",
            "",
            "",
            "\1\u00a6",
            "\1\u00a7",
            "\1\u00a8",
            "\1\u00a9",
            "\1\u00aa",
            "\1\u00ab",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\1\u00ad",
            "\1\u00ae",
            "\1\u00af",
            "\1\u00b0",
            "\1\u00b1",
            "\1\u00b2",
            "\1\u00b3",
            "\1\u00b4",
            "\1\u00b5",
            "\1\u00b6",
            "\1\u00b7",
            "",
            "\1\u00b8",
            "",
            "\12\u00b9",
            "\1\u00ba",
            "",
            "\1\u00bb",
            "\1\u00bc",
            "\1\u00bd",
            "",
            "\1\u00be",
            "\1\u00bf",
            "\1\u00c0",
            "\1\u00c1",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\1\u00c3",
            "\1\u00c4",
            "",
            "\1\u00c5",
            "\1\u00c6",
            "\1\u00c7",
            "\1\u00c8",
            "\1\u00c9",
            "\1\u00ca",
            "\1\u00cb",
            "\1\u00cc",
            "\1\u00cd",
            "\1\u00ce",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\1\u00d0",
            "\1\u009d\2\uffff\12\u00d1",
            "\1\u00d2",
            "\1\u00d3",
            "\1\u00d4",
            "\1\u00d5",
            "\1\u00d6",
            "\1\u00d7",
            "\1\u00d8",
            "\1\u00d9",
            "",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\1\u00db",
            "\1\u00dc\2\uffff\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "",
            "\1\u00de",
            "\1\u00df",
            "\1\u00e0",
            "\1\u00e1",
            "\1\u00e2",
            "\1\u00e3",
            "\1\u00e4",
            "\1\u00e5",
            "",
            "\1\u00e6",
            "\12\u00e7",
            "\1\u00e8",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\1\u00eb",
            "\1\u00ec",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\1\u00ef",
            "",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "",
            "",
            "\1\u00f1",
            "\1\u00f2",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\1\u00f4",
            "\1\u00f5",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\1\u00f7",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\1\u009d",
            "\1\u00fa",
            "",
            "",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\1\u00fc",
            "",
            "",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "",
            "\1\u00fe",
            "",
            "",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\1\u0100",
            "",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "",
            "",
            "\1\u0102",
            "",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "",
            "\1\u0105",
            "",
            "\1\u0106",
            "",
            "",
            "",
            "",
            "\1\u0107",
            "\1\u0108",
            "\1\u0109",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\1\u010b",
            "",
            "\1\u010c",
            "\1\u010d",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            ""
    };

    static final short[] DFA34_eot = DFA.unpackEncodedString(DFA34_eotS);
    static final short[] DFA34_eof = DFA.unpackEncodedString(DFA34_eofS);
    static final char[] DFA34_min = DFA.unpackEncodedStringToUnsignedChars(DFA34_minS);
    static final char[] DFA34_max = DFA.unpackEncodedStringToUnsignedChars(DFA34_maxS);
    static final short[] DFA34_accept = DFA.unpackEncodedString(DFA34_acceptS);
    static final short[] DFA34_special = DFA.unpackEncodedString(DFA34_specialS);
    static final short[][] DFA34_transition;

    static {
        int numStates = DFA34_transitionS.length;
        DFA34_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA34_transition[i] = DFA.unpackEncodedString(DFA34_transitionS[i]);
        }
    }

    class DFA34 extends DFA {

        public DFA34(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 34;
            this.eot = DFA34_eot;
            this.eof = DFA34_eof;
            this.min = DFA34_min;
            this.max = DFA34_max;
            this.accept = DFA34_accept;
            this.special = DFA34_special;
            this.transition = DFA34_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | RULE_POS_EBIGDECIMAL | RULE_NEG_EBIGDECIMAL | RULE_ABS_EBIGDECIMAL | RULE_ISO8601 | RULE_ID | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS );";
        }
    }
 

}