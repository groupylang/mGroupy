package tree_builder.homo;

import java.util.ArrayList;
import java.util.List;

public class AST {
    /* member variables */
    Token token;
    List<AST> children;
    /* constructors */
    /**
     *
     */
    public AST() {}
    /**
     * @param token
     */
    public AST(Token token){
        this.token = token;
    }

    /**
     * create node from token type
     * NOTE when you want to create virtual token, you can use this function
     * @param type
     */
    public AST(int type) {
        this.token = new Token(type);
    }
    /* member functions */
    /**
     * NOTE while traversal process, outer visitor execute the same action to all nodes which returns
     * the same node type
     * @return
     */
    public int getNodeType() {
        return token.type;
    }
    /**
     * @param tree
     */
    public void addChild(AST tree) {
        if (children == null) children = new ArrayList<>();
        children.add(tree);
    }
    /**
     * @return
     */
    public boolean isNil() {
        return token == null;
    }
    /**
     * NOTE toString for single node
     * @return
     */
    @Override
    public String toString() {
        return token != null ? token.toString() : "nil";
    }
    public String toStringTree() {
        if ( children == null || children.size() == 0 ) return this.toString();
        StringBuilder buf = new StringBuilder();
        if ( !isNil() ) buf.append('(').append(this.toString()).append(' ');
        for (int i = 0; i < children.size(); i++) {
            AST tree = (AST)children.get(i);
            if ( i > 0 ) buf.append(' ');
            buf.append(tree.toStringTree());
        }
        if ( !isNil() ) buf.append(')');
        return buf.toString();
    }

}
