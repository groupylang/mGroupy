package syntax_analyzer.ll_k;

public class BacktrackParser extends Parser{
    /* constructors */
    /**
     * @param input
     */
    public BacktrackParser(Lexer input) {
        super(input);
    }
    /* member functions */
    /**
     * assign : NAME '=' NAME ;
     */
    public void assign() throws RecognitionException {
        list(); match(BacktrackLexer.EQUALS); list();
    }
    // /**
    //  * list : '[' elements ']' ;
    //  */
    // public void list() {
    //     boolean failed = false;
    //     int startTokenIndex = index();
    //     if ( isSpeculating() && alreadyParsedRule(list_memo) ) return;
    //     try {
    //         _list();
    //     } catch (RecognitionException e) {
    //         failed = true;
    //         throw e;
    //     } finally {
    //         if (isSpeculating()) memoize(list_memo, startTokenIndex, failed);
    //     }
    // }
    // /**
    //  * @throws RecognitionException
    //  */
    // public void _list() throws RecognitionException {
    //     System.out.println("parse list rule at token index: " + index());
    //     match(BacktrackLexer.LBRACK);
    //     elements();
    //     match(BacktrackLexer.RBRACK);
    // }
    /**
     * list: '[' elements ']' ;  // match bracketed list
     */
    public void list() throws RecognitionException {
        match(BacktrackLexer.LBRACK);
        elements();
        match(BacktrackLexer.RBRACK);
    }
    /**
     * elements : element (',' element)* ;
     */
    void elements() throws RecognitionException {
        element();
        while ( LA(1) == BacktrackLexer.COMMA ){
            match(BacktrackLexer.COMMA); elements();
        }
    }
    /**
     * element : NAME '=' NAME | NAME | list ;
     */
    void element() throws RecognitionException {
        if ( LA(1) == BacktrackLexer.NAME && LA(2) == BacktrackLexer.EQUALS) {
            match(BacktrackLexer.NAME);
            match(BacktrackLexer.EQUALS);
            match(BacktrackLexer.NAME);
        }
        else if ( LA(1) == BacktrackLexer.NAME ) match(BacktrackLexer.NAME);
        else if ( LA(1) == BacktrackLexer.LBRACK ) list();
        else throw new NoViableAltException("expecting name or list; found " + LT(1));
    }
    /**
     * stat : list EOF | assign EOF ;
     * @throws RecognitionException
     */
    public void stat() throws RecognitionException {
        if ( speculate_stat_alt1() ) {
            /* try `list EOF` */
            list(); match(Lexer.EOF_TYPE);
        } else if ( speculate_stat_alt2() ) {
            /* try `assign EOF` */
            assign(); match(Lexer.EOF_TYPE);
        } else {
            throw new NoViableAltException("expecting stat found " + LT(1));
        }
    }
    /**
     * @return
     */
    public boolean speculate_stat_alt1() {
        boolean success = true;
        mark();
        try { list(); match(Lexer.EOF_TYPE); }
        catch (RecognitionException e) { success = false; }
        release();
        return success;
    }
    /**
     * @return
     */
    public boolean speculate_stat_alt2() {
        boolean success = true;
        mark();
        try { assign(); match(Lexer.EOF_TYPE); }
        catch (RecognitionException e) { success = false; }
        release();
        return success;
    }
}
