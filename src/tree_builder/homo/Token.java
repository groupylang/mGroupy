package tree_builder.homo;

import lexical_analyzer.ListLexer;

public class Token {
    /* member variables */
    public int type;
    public String text;
    /* constructors */
    /**
     * @param type
     */
    public Token(int type) {
        this.type = type;
        this.text = "virtual token";
    }
    /**
     * @param type
     * @param text
     */
    public Token(int type, String text) {
        this.type = type;
        this.text = text;
    }
    /* member functions */
    /**
     * @return
     */
    @Override
    public String toString() {
        return "['" + text + "', " + ListLexer.tokenNames[type] + "]";
    }
    /* static variables */
    public static final int PLUS = 10;
    public static final int INT = 20;
}
