package tree_builder.syntax_tree;

import lexical_analyzer.Token;

public class TokenNode extends ParseTree { //TODO
    /* member variables */
    Token value;
    /* constructors */
    /**
     * @param value
     */
    public TokenNode(Token value) {
        this.value = value;
    }
}
