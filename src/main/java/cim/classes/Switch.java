package cim.classes;

import cim.datatypes.CurrentFlow;

import javax.xml.bind.annotation.XmlElement;
import java.util.Date;

public class Switch extends ConductingEquipment{

    @XmlElement(name = "Switch.open",
            namespace = "http://iec.ch/TC57/2013/CIM-schema-cim16#", nillable = true)
    private boolean open;

    public Switch(String aliasName, String description, String mRID, String name) {
        super(aliasName, description, mRID, name);
    }

    public Switch(String mRID, String name) {
        super(mRID, name);
    }

    public Switch() {
    }


    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }
}
