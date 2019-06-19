package syntax_analyzer.ll_k;

public class MismatchedTokenException extends RecognitionException {
    /* constructors */
    /**
     * @param massage
     */
    public MismatchedTokenException(String massage) {
        super(massage);
    }
}
