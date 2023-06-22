package cim.classes;

import java.util.HashSet;
import java.util.Set;

public class ConductingEquipment extends IdentifiedObject {

    private Set<Terminal> terminals = new HashSet<>();

    public ConductingEquipment(String aliasName, String description, String mRID, String name) {
        super(aliasName, description, mRID, name);
    }

    public ConductingEquipment() {
    }

    public ConductingEquipment(String mRID, String name) {
        super(mRID, name);
    }

    public void addTerminal(Terminal terminal) {
        this.terminals.add(terminal);
    }
}
