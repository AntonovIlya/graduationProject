package cim.classes;

public class Connector extends ConductingEquipment{

    public Connector(String aliasName, String description, String mRID, String name) {
        super(aliasName, description, mRID, name);
    }

    public Connector(String mRID, String name) {
        super(mRID, name);
    }

    public Connector() {
    }
}
