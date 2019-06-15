package s_expression;

public class Node {
    /* member variables */
    String value;
    Node[] children;
    /* constructors */
    /**
     * @param value
     * @param children
     */
    public Node(String value, Node[] children){
        this.value = value;
        this.children = children;
    }
    /* static functions */
    /**
     * @param node
     * @return
     */
    public static String to_S_expression(Node node){
        StringBuilder builder = new StringBuilder("(").append(node.value);
        for (Node child : node.children){
            if (child.children == null) builder.append(' ').append(child.value);
            else builder.append("\n\t").append(to_S_expression(child));
        }
        return builder.append(')').toString();
    }
}

