package syntax_analyzer.ll_1;

import lexical_analyzer.Lexer;
import lexical_analyzer.Token;

public abstract class Parser {
    /* member variables */
    Lexer input;
    Token lookahead;
    /* constructors */
    /**
     * @param input
     */
    public Parser(Lexer input) { //TODO
        this.input = input;
        this.lookahead = input.nextToken();
    }
    /* member functions */
    /**
     * check whether type of a character looked ahead equals 1st argument
     * @param type
     */
    public void match(int type) {
        if ( lookahead.type == type ) consume();
        else throw new Error("expecting " + input.getTokenName(type) + "; found " + lookahead);
    }
    /**
     *
     */
    public void consume() {
        lookahead = input.nextToken();
    }
}
