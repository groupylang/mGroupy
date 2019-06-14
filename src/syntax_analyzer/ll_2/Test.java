package syntax_analyzer.ll_2;

import lexical_analyzer.ListLexer;

public class Test {
    public static void main(String[] args) {
        LookaheadParser parser = new LookaheadParser(new ListLexer(args[0]), 2);
        parser.list();
    }
}
