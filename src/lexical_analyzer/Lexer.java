package lexical_analyzer;

public abstract class Lexer {
    /* member variables */
    String input;
    int p = 0;
    char c;
    /* constructors */
    /**
     * @param input
     */
    public Lexer(String input){
        this.input = input;
        c = input.charAt(p);
    }
    /* member functions */
    /**
     * consume a letter or find EOF
     */
    public void consume() {
        p++;
        if ( p >= input.length() ) c = EOF;
        else c = input.charAt(p);
    }
    /**
     * check whether a character looked ahead equals 1st argument or not
     * @param pattern
     */
    public void match(char pattern) {
        if ( c == pattern ) consume();
        else throw new Error("expecting " + pattern + "; found " + c);
    }
    /* abstract functions */
    /**
     * @return
     */
    public abstract Token nextToken();
    /**
     * @param index
     * @return
     */
    public abstract String getTokenName(int index);
    /* static variables */
    public static final char EOF = (char) -1;
    public static int EOF_TYPE = 1;
    // public static int INVALID_TOKEN = 0;
}
