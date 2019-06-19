package syntax_analyzer.ll_k;

public abstract class Lexer {
    /* member variables */
    String input;
    int index = 0; // index into input of current character
    char current;
    /* constructors */
    /**
     * @param input
     */
    public Lexer(String input) {
        this.input = input;
        current = input.charAt(index); // prime lookahead
    }
    /* member functions */
    /**
     * Move to next non-whitespace character
     */
    public void consume() {
        advance();
    }
    /**
     * Move one character; detect "end of file"
     */
    public void advance() {
        index++;
        if (index >= input.length() ) current = EOF;
        else current = input.charAt(index);
    }
    /**
     * Ensure {@code next} is next character on the input stream
     * @param next
     */
    public void match(char next) {
        if (current == next) consume();
        else throw new Error("expecting " + next + "; found " + current);
    }
    /**
     * @return
     */
    public abstract Token nextToken();
    /**
     *
     */
    abstract  void WS();
    /**
     * @param index
     * @return
     */
    public abstract String getTokenName(int index);
    /* static variables */
    /** represent end of file char */
    public static final char EOF = (char) -1;
    /** represent EOF token type */
    public static final int EOF_TYPE = 1;
}
