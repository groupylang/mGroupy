package tree_builder.test;

public class Test {
    public static void main(String[] args) throws Exception {
        CharStream input = null;
        if ( args.length > 0 ) input = new ANTLRFileStream(args[0]);
        else input = ANTLRInputStream(args[0]);
        new GraphicsParser(new CommonTokenStream(new GraphicsLexer(input))).file();
    }
}
