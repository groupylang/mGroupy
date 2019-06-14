package lexical_analyzer;

public class Token {
    /* member variables */
    public int type;
    public String text;
    /* constructors */
    public Token(int type, String text){
        this.type = type;
        this.text = text;
    }
    /* member functions */
    @Override
    public String toString() {
        return "['" + text + "', " + ListLexer.tokenNames[type] + "]";
    }
}
