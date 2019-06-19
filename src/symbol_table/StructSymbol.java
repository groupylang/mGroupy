package symbol_table;

import java.util.LinkedHashMap;
import java.util.Map;

public class StructSymbol extends ScopedSymbol implements Type, Scope {
    /* member variables */
    Map<String, Symbol> fields = new LinkedHashMap<>();
    /* constructors */
    /**
     * @param name
     * @param parent
     */
    public StructSymbol(String name, Scope parent) {
        super(name, parent);
    }
    /* member functions */
    /**
     * search only range of fields without climbing up tree when resolving {@code b} in {@code a.b}
     * @param name
     * @return
     */
    public Symbol resolveMember(String name) {
        return fields.get(name);
    }
    /**
     * @return
     */
    public Map<String, Symbol> getMembers() {
        return fields;
    }
    /**
     * @return
     */
    @Override
    public String toString() {
        return "struct " + name + ":{" + stripBrackets(fields.keySet().toString()) + "}";
    }
}
