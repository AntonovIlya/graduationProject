package cim.classes;

import cim.datatypes.CurrentFlow;

public class ProtectedSwitch extends Switch{

    public ProtectedSwitch(String aliasName, String description, String mRID, String name) {
        super(aliasName, description, mRID, name);
    }

    public ProtectedSwitch() {
    }

    public ProtectedSwitch(String mRID, String name) {
        super(mRID, name);
    }
}
