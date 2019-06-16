package tree_builder.syntax_tree;

import lexical_analyzer.Lexer;
import lexical_analyzer.Token;

public abstract class Parser { //TODO
    /* member variables */
    Lexer input;
    Token[] lookahead;
    int k;
    int p = 0;
    /* constructors */
    /**
     * @param input
     * @param k
     */
    public Parser(Lexer input, int k) {
        this.input = input;
        this.lookahead = new Token[k];
        this.k = k;
        for (int i = 1; i <= k; i++) consume();
    }
    /* member functions */
    /**
     * @param index
     * @return
     */
    public Token LT(int index) {
        return lookahead[(p + index - 1) % k];
    }
    /**
     * @param index
     * @return
     */
    public int LA(int index) {
        return LT(index).type;
    }
    /**
     * check whether type of a character looked ahead equals 1st argument
     * @param type
     */
    public void match(int type) {
        if ( LA(1) == type ) consume();
        else throw new Error("expecting " + input.getTokenName(type) + "; found " + LT(1));
    }
    /**
     *
     */
    public void consume() {
        lookahead[p] = input.nextToken();
        p = (p + 1) % k;
    }
}
