package syntax_analyzer.ll_k;

public class BacktrackLexer extends Lexer {
    /* constructors */
    /**
     * @param input
     */
    public BacktrackLexer(String input) {
        super(input);
    }
    /* member functions */
    /**
     * @return
     */
    boolean isLETTER() {
        return current >='a' && current <= 'z' || current >= 'A' && current <= 'Z';
    }
    /**
     * @return
     */
    @Override
    public Token nextToken() {
        while ( current != EOF ) {
            switch ( current ) {
                case ' ': case '\t': case '\n': case '\r': WS(); continue;
                case ',' : consume(); return new Token(COMMA, ",");
                case '[' : consume(); return new Token(LBRACK, "[");
                case ']' : consume(); return new Token(RBRACK, "]");
                case '=' : consume(); return new Token(EQUALS, "=");
                default:
                    if ( isLETTER() ) return name();
                    throw new Error("invalid character: " + current);
            }
        }
        return new Token(EOF_TYPE,"<EOF>");
    }
    /**
     * name : LETTER+ ; // name is sequence of >=1 letter
     */
    Token name() {
        StringBuilder builder = new StringBuilder();
        while ( isLETTER() ) {
            builder.append(current);
            LETTER();
        }
        return new Token(NAME, builder.toString());
    }
    /**
     * LETTER   : 'a'..'z'|'A'..'Z'; // define what a letter is (\w)
     */
    void LETTER() {
        if ( isLETTER() ) consume();
        else throw new Error("expecting LETTER; found " + current);
    }
    /**
     * @param index
     * @return
     */
    @Override
    public String getTokenName(int index) {
        return BacktrackLexer.tokenNames[index];
    }
    /**
     * WS : (' '|'\t'|'\n'|'\r')* ; // ignore any whitespace
     */
    @Override
    void WS() {
        while ( current == ' ' || current == '\t' || current == '\n' || current == '\r' ) {
            advance();
        }
    }

    /* static variables */
    public static int NAME = 2;
    public static int COMMA = 3;
    public static int LBRACK = 4;
    public static int RBRACK = 5;
    public static int EQUALS = 6;
    public static String[] tokenNames = { "n/a", "<EOF>", "NAME", ",", "[", "]", "=" };
}
