package cim.classes;

import cim.datatypes.ActivePower;
import cim.datatypes.PerCent;
import cim.datatypes.ReactivePower;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "EnergyConsumer", namespace = "http://iec.ch/TC57/2013/CIM-schema-cim16#")
public class EnergyConsumer extends ConductingEquipment {

    @XmlElement(name = "EnergyConsumer.customerCount",
            namespace = "http://iec.ch/TC57/2013/CIM-schema-cim16#", nillable = true)
    private int customerCount = 375682;
    @XmlElement(name = "EnergyConsumer.grounded",
            namespace = "http://iec.ch/TC57/2013/CIM-schema-cim16#", nillable = true)
    private boolean grounded = true;

    @XmlElement(name = "ConductingEquipment.BaseVoltage",
            namespace = "http://iec.ch/TC57/2013/CIM-schema-cim16#", nillable = true)
    private Resource baseVoltageResource;

    @XmlElement(name = "ProtectedSwitch.Switch.ConductingEquipment.Terminal",
            namespace = "http://iec.ch/TC57/2013/CIM-schema-cim16#", nillable = true)
    private Resource terminalResource;

    public EnergyConsumer(String aliasName, String description, String mRID, String name) {
        super(aliasName, description, mRID, name);
    }

    public EnergyConsumer() {
    }

    public EnergyConsumer(String mRID, String name) {
        super(mRID, name);
    }

    public int getCustomerCount() {
        return customerCount;
    }

    public void setCustomerCount(int customerCount) {
        this.customerCount = customerCount;
    }

    public boolean isGrounded() {
        return grounded;
    }

    public void setGrounded(boolean grounded) {
        this.grounded = grounded;
    }

    public Resource getBaseVoltageResource() {
        return baseVoltageResource;
    }

    public void setBaseVoltageResource(Resource baseVoltageResource) {
        this.baseVoltageResource = baseVoltageResource;
    }

    public Resource getTerminalResource() {
        return terminalResource;
    }

    public void setTerminalResource(Resource terminalResource) {
        this.terminalResource = terminalResource;
    }
}
