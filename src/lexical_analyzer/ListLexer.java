package lexical_analyzer;

public class ListLexer extends Lexer {
    /* constructors */
    public ListLexer(String input){
        super(input);
    }
    /* member functions */
    @Override
    public String getTokenName(int index){
        return tokenNames[index];
    }
    boolean isLETTER() {
        return c >= 'a' && c <= 'z'|| c >= 'A' && c <= 'Z';
    }
    @Override
    public Token nextToken() {
        while ( c !=  EOF ) {
            switch (c) {
                case ' ':
                case '\t':
                case '\n':
                case '\r':
                    WS(); continue;
                case ',': consume(); return new Token(COMMA, ",");
                case '[': consume(); return new Token(LBRACK, "[");
                case ']': consume(); return new Token(RBRACK, "]");
                /* ll_2 only */case '=': consume(); return new Token(EQUALS, "=");
                default:
                    if (isLETTER()) return NAME();
                    throw new Error("invalid character: " + c);
            }
        }
        return new Token(EOF_TYPE, "EOF");
    }
    /** NAME : ('a'..'z'|'A'..'Z')+ ; */
    Token NAME() {
        StringBuilder buf = new StringBuilder();
        do { buf.append(c); consume(); } while ( isLETTER() );
        return new Token(NAME, buf.toString());
    }
    /** WS : (' '|'\t'|'\n'|'\r')* ; */
    void WS() {
        while ( c == ' ' || c == '\t' || c == '\n' || c == '\r' ) { consume(); }
    }
    /* static variables */
    public static int NAME = 2;
    public static int COMMA = 3;
    public static int LBRACK = 4;
    public static int RBRACK = 5;
    /* ll_2 only */ public static int EQUALS = 6;
    public static String[] tokenNames
            = { "n/a", "EOF", "NAME", "COMMA", "LBRACK", "RBRACK", /* ll_2 only */ "EQUALS" };
}
