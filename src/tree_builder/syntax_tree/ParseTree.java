package tree_builder.syntax_tree;

import lexical_analyzer.Token;

import java.util.ArrayList;
import java.util.List;

public abstract class ParseTree {
    /* member variables */
    public List<ParseTree> children;
    /* member functions */
    /**
     * @param value
     * @return
     */
    public RuleNode addChild(String value) {
        RuleNode node = new RuleNode(value);
        addChild(node);
        return node;
    }
    /**
     * @param value
     * @return
     */
    public TokenNode addChild(Token value) {
        TokenNode node = new TokenNode(value);
        addChild(node);
        return node;
    }
    /**
     * @param tree
     */
    public void addChild(ParseTree tree) {
        if ( children == null ) {
            children = new ArrayList<>();
        }
        children.add(tree);
    }
}
