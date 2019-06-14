package syntax_analyzer.ll_1;

import lexical_analyzer.ListLexer;

public class Test {
    public static void main(String[] args) {
        ListParser parser = new ListParser(new ListLexer(args[0]));
        parser.list();
    }
}
