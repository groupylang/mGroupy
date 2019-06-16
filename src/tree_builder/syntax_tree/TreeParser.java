package tree_builder.syntax_tree;

import lexical_analyzer.Lexer;
import lexical_analyzer.ListLexer;

public class TreeParser extends Parser { //TODO
    /* member variables */
    ParseTree root;
    ParseTree current;
    /* constructors */
    /**
     * @param input
     * @param k
     */
    public TreeParser(Lexer input, int k) {
        super(input, k);
    }
    /* member functions */
    /**
     * @param type
     */
    @Override
    public void match(int type) {
        current.addChild(LT(1));
        super.match(type);
    }
    /**
     * list : '[' elements ']' ;
     */
    public void list() {
        RuleNode node = new RuleNode("list");
        if ( root == null ) root = node;
        else current.addChild(node);
        ParseTree original = current;
        current = node;

        match(ListLexer.LBRACK);
        elements();
        match(ListLexer.RBRACK);

        current = original;
    }
    /**
     * elements : element (',' element)* ;
     */
    void elements(){
        RuleNode node = new RuleNode("elements");
        if ( root == null ) root = node;
        else current.addChild(node);
        ParseTree original = current;
        current = node;

        element();
        while ( LA(1) == ListLexer.COMMA ){
            match(ListLexer.COMMA); elements();
        }

        current = original;
    }
    /**
     * element : NAME '=' NAME | NAME | list ;
     */
    void element(){
        RuleNode node = new RuleNode("element");
        if ( root == null ) root = node;
        else current.addChild(node);
        ParseTree original = current;
        current = node;

        if ( LA(1) == ListLexer.NAME && LA(2) == ListLexer.EQUALS) {
            match(ListLexer.NAME);
            match(ListLexer.EQUALS);
            match(ListLexer.NAME);
        }
        else if ( LA(1) == ListLexer.NAME ) match(ListLexer.NAME);
        else if ( LA(1) == ListLexer.LBRACK ) list();
        else throw new Error("expecting name or list; found " + LT(1));

        current = original;
    }
}
