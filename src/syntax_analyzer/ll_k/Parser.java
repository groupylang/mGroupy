package syntax_analyzer.ll_k;

import java.util.ArrayList;
import java.util.List;
// import java.util.Map; // for memoization

public abstract class Parser {
    /* member variables */
    Lexer input;
    List<Integer> markers;
    List<Token> lookahead;
    int p = 0;
    /* constructors */
    /**
     * @param input
     */
    public Parser(Lexer input) {
        this.input = input;
        this.markers = new ArrayList<>();
        this.lookahead = new ArrayList<>();
        sync(1);
    }
    /* member functions */
    /**
     * @param index
     * @return
     */
    public Token LT(int index) {
        sync(index);
        return lookahead.get(p + index - 1);
    }
    /**
     * @param index
     * @return
     */
    public int LA(int index) {
        return LT(index).type;
    }
    /**
     * check whether type of a character looked ahead equals 1st argument
     * @param type
     * @throws MismatchedTokenException
     */
    public void match(int type) throws MismatchedTokenException {
        if ( LA(1) == type ) consume();
        else throw new MismatchedTokenException("expecting "
                + input.getTokenName(type) + "; found " + LT(1));
    }
    /**
     * make sure {@code lookahead} has {@code size} elements from {@code p} to the end
     * @param size
     */
    public void sync(int size) {
        if ( p + size - 1 > lookahead.size() - 1) {
            fill((p + size - 1) - (lookahead.size() - 1));
        }
    }
    /**
     * @param size
     */
    public void fill(int size) {
        for (int i = 0; i < size; i++) {
            lookahead.add(input.nextToken());
        }
    }
    /**
     */
    public void consume() {
        p++;
        if ( p == lookahead.size() && !isSpeculating() ) {
            p = 0;
            lookahead.clear();
            // clearMemo(); // for memoization
        }
        sync(1);
    }
    /**
     * @return
     */
    public int mark() {
        markers.add(p);
        return p;
    }
    /**
     */
    public void release(){
        int marker = markers.get(markers.size() - 1);
        markers.remove(markers.size() - 1);
        seek(marker);
    }
    /**
     * @param index
     */
    public void seek(int index) {
        p = index;
    }
    /**
     * @return
     */
    public boolean isSpeculating() {
        return markers.size() > 0;
    }
    // FIXME implement PreviousParseFailedException and what it needs
    // for memoization
    // /**
    //  * @param memoization
    //  * @return
    //  * @throws PreviousParseFailedException
    //  */
    // public boolean alreadyParsedRule(Map<Integer, Integer> memoization)
    //         throws PreviousParseFailedException {
    //     Integer memo = memoization.get(index());
    //     if ( memo == null ) return false;
    //     System.out.println("parsed list before at index " + index()
    //             + "; skip ahead to token index " + memo + ": " + lookahead.get(memo).text);
    //     if ( memo == FAILED ) throw new PreviousParseFailedException();
    //     seek(memo);
    //     return true;
    // }
    // /**
    //  * @param memoization
    //  * @param startTokenIndex
    //  * @param failed
    //  */
    // public void memoize(Map<Integer, Integer> memoization, int startTokenIndex, boolean failed) {
    //     int stopTokenIndex = failed ? FAILED : index();
    //     memoization.put(startTokenIndex, stopTokenIndex);
    // }
    // /**
    //  * @return
    //  */
    // public int index() {
    //     return p;
    // }
    // /**
    //  *
    //  */
    // public void clearMemo() {}
    // /* static variables */
    // public static final int FAILED = -1;
}
