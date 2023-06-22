package cim.classes;

import cim.datatypes.Seconds;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Breaker", namespace = "http://iec.ch/TC57/2013/CIM-schema-cim16#")
public class Breaker extends ProtectedSwitch{

    @XmlElement(name = "ConductingEquipment.BaseVoltage",
            namespace = "http://iec.ch/TC57/2013/CIM-schema-cim16#", nillable = true)
    private Resource baseVoltageResource;

    @XmlElement(name = "ProtectedSwitch.Switch.ConductingEquipment.Terminal",
            namespace = "http://iec.ch/TC57/2013/CIM-schema-cim16#", nillable = true)
    private Resource terminal1Resource;
    @XmlElement(name = "ProtectedSwitch.Switch.ConductingEquipment.Terminal",
            namespace = "http://iec.ch/TC57/2013/CIM-schema-cim16#", nillable = true)
    private Resource terminal2Resource;


    public Breaker(String aliasName, String description, String mRID, String name) {
        super(aliasName, description, mRID, name);
    }

    public Breaker() {
    }

    public Breaker(String mRID, String name) {
        super(mRID, name);
    }

    public Resource getBaseVoltageResource() {
        return baseVoltageResource;
    }

    public void setBaseVoltageResource(Resource baseVoltageResource) {
        this.baseVoltageResource = baseVoltageResource;
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
