package syntax_analyzer.ll_k;

public class Token {
    /* member variablwa */
    public int type;
    public String text;
    /* constructors */
    /**
     * @param type
     * @param text
     */
    public Token(int type, String text) {
        this.type = type;
        this.text = text;
    }
    /**
     * @return
     */
    @Override
    public String toString() {
        String name = BacktrackLexer.tokenNames[type];
        return "['" + text + "'," + name + "]";
    }
}
