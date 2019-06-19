package symbol_table;

/**
 * symbol which represents build-in type like {@code int} or {@code float}
 */
public class BuiltInTypeSymbol extends Symbol implements Type {
    /* constructors */
    /**
     * @param name
     */
    public BuiltInTypeSymbol(String name) {
        super(name);
    }
}
