package syntax_analyzer.ll_k;

public class Test {
    public static void main(String[] args) throws RecognitionException{
        BacktrackParser parser = new BacktrackParser(new BacktrackLexer(args[0]));
        parser.stat();
    }
}
