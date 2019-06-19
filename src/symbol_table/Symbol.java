package symbol_table;

public class Symbol {
    /* member variables */
    String name;
    Type type;
    /** all symbols know what scope includes them */
    Scope scope;
    CymbolAST def;
    /* constructors */
    /**
     * @param name
     */
    public Symbol(String name) {
        this.name = name;
    }
    /**
     * @param name
     * @param type
     */
    public Symbol(String name, Type type) {
        this(name);
        this.type = type;
    }
    /* member functions */
    /**
     * @return
     */
    public String getName() {
        return name;
    }
    /**
     * @return
     */
    @Override
    public String toString() {
        String scope_name = "";
        if (scope != null) {
            scope_name = scope.getScopeName();
        }
        if (type != null) {
            return '[' + scope_name + getName() + ":" + type + ']';
        }
        return scope_name + getName();
    }
    /* static functions */
    /**
     * @param string
     * @return
     */
    public static String stripBrackets(String string) {
        return string.substring(1, string.length() - 1);
    }
}
