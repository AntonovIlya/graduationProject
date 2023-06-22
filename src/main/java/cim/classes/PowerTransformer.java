package cim.classes;

import cim.datatypes.AngleDegress;
import cim.datatypes.CurrentFlow;
import cim.datatypes.Voltage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "PowerTransformer", namespace = "http://iec.ch/TC57/2013/CIM-schema-cim16#")
@XmlAccessorType(XmlAccessType.FIELD)
public class PowerTransformer extends ConductingEquipment{

    @XmlElement(name = "ConductingEquipment.Terminal",
            namespace = "http://iec.ch/TC57/2013/CIM-schema-cim16#", nillable = true)
    private Resource terminal1Resource;
    @XmlElement(name = "ConductingEquipment.Terminal",
            namespace = "http://iec.ch/TC57/2013/CIM-schema-cim16#", nillable = true)
    private Resource terminal2Resource;

    public PowerTransformer(String aliasName, String description, String mRID, String name) {
        super(aliasName, description, mRID, name);
    }

    public PowerTransformer() {
    }

    public PowerTransformer(String mRID, String name) {
        super(mRID, name);
    }

    public Resource getTerminal1Resource() {
        return terminal1Resource;
    }

    public void setTerminal1Resource(Resource terminal1Resource) {
        this.terminal1Resource = terminal1Resource;
    }

    public Resource getTerminal2Resource() {
        return terminal2Resource;
    }

    public void setTerminal2Resource(Resource terminal2Resource) {
        this.terminal2Resource = terminal2Resource;
    }
}
