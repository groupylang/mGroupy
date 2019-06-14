package syntax_analyzer.ll_2;

import lexical_analyzer.Lexer;
import lexical_analyzer.ListLexer;

public class LookaheadParser extends Parser {
    /* constructors */
    public LookaheadParser(Lexer input, int k) {
        super(input, k);
    }
    /* member functions */
    /** list : '[' elements ']' ; */
    public void list() {
        match(ListLexer.LBRACK); elements(); match(ListLexer.RBRACK);
    }
    /** elements : element (',' element)* ; */
    void elements(){
        element();
        while ( LA(1) == ListLexer.COMMA ){
            match(ListLexer.COMMA); elements();
        }
    }
    /** element : NAME '=' NAME | NAME | list ; */
    void element(){
        if ( LA(1) == ListLexer.NAME && LA(2) == ListLexer.EQUALS) {
            match(ListLexer.NAME);
            match(ListLexer.EQUALS);
            match(ListLexer.NAME);
        }
        else if ( LA(1) == ListLexer.NAME ) match(ListLexer.NAME);
        else if ( LA(1) == ListLexer.LBRACK ) list();
        else throw new Error("expecting name or list; found " + LT(1));
    }
}
