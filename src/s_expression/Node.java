package s_expression;

public class Node {
    String value;
    Node[] children;
    Node(String value, Node[] children){
        this.value = value;
        this.children = children;
    }
    public static String to_S_expression(Node node){
        StringBuilder builder = new StringBuilder("(").append(node.value);
        for (Node child : node.children){
            if (child.children == null) builder.append(' ').append(child.value);
            else builder.append("\n\t").append(to_S_expression(child));
        }
        return builder.append(')').toString();
    }
    public static void main(String[] args) {
        Node[] n1 = { new Node("2", null), new Node("3", null) };
        Node[] n2 = { new Node("1", null), new Node("*", n1) };
        String output = to_S_expression(new Node("+", n2));
        System.out.println(output);
    }
}

