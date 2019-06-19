package symbol_table;

/**
 * symbol which represents variable definitions (name and type)
 */
public class VariableSymbol extends Symbol {
    /* constructors */
    /**
     * @param name
     * @param type
     */
    public VariableSymbol(String name, Type type) {
        super(name, type);
    }
}
