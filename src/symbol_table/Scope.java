package symbol_table;

public interface Scope {
    /* member functions */
    /**
     * @return
     */
    /* public */ String getScopeName();
    /**
     * @return
     */
    /* public */ Scope getParentScope();
    /**
     * @return
     */
    /* public */ Scope getEnclosingScope();
    /**
     * @param symbol
     */
    /* public */ void define(Symbol symbol);
    /**
     * @param name
     * @return
     */
    /* public */ Symbol resolve(String name);
}
