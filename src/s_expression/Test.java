package s_expression;

import static s_expression.Node.to_S_expression;

public class Test {
    public static void main(String[] args) {
        Node[] n1 = { new Node("2", null), new Node("3", null) };
        Node[] n2 = { new Node("1", null), new Node("*", n1) };
        String output = to_S_expression(new Node("+", n2));
        System.out.println(output);
    }
}
