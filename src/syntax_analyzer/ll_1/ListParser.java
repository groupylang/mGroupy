package syntax_analyzer.ll_1;

import lexical_analyzer.Lexer;
import lexical_analyzer.ListLexer;

public class ListParser extends Parser {
    /* constructors */
    public ListParser(Lexer input) {
        super(input);
    }
    /* member functions */
    /** list : '[' elements ']' ; */
    public void list() {
        match(ListLexer.LBRACK); elements(); match(ListLexer.RBRACK);
    }
    /** elements : element (',' element)* ; */
    void elements(){
        element();
        while ( lookahead.type == ListLexer.COMMA ){
            match(ListLexer.COMMA); elements();
        }
    }
    /** element : NAME | list ; */
    void element(){
        if ( lookahead.type == ListLexer.NAME ) match(ListLexer.NAME);
        else if ( lookahead.type == ListLexer.LBRACK ) list();
        else throw new Error("expecting name or list; found " + lookahead);
    }
}
