package syntax_analyzer.ll_2;

import lexical_analyzer.Lexer;
import lexical_analyzer.Token;

public abstract class Parser {
    /* member variables */
    Lexer input;
    Token[] lookahead;
    int k;
    int p = 0;
    /* constructors */
    public Parser(Lexer input, int k) {
        this.input = input;
        this.lookahead = new Token[k];
        this.k = k;
        for (int i = 1; i <= k; i++) consume();
    }
    /* member functions */
    public Token LT(int index) { return lookahead[(p + index - 1) % k]; }
    public int LA(int index) { return LT(index).type; }
    /** check whether type of a character looked ahead equals 1st argument */
    public void match(int type) {
        if ( LA(1) == type ) consume();
        else throw new Error("expecting " + input.getTokenName(type) + "; found " + LT(1));
    }
    public void consume() {
        lookahead[p] = input.nextToken();
        p = (p + 1) % k;
    }
}
