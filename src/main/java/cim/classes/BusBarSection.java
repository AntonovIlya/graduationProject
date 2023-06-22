package cim.classes;

import cim.datatypes.CurrentFlow;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "BusBarSection", namespace = "http://iec.ch/TC57/2013/CIM-schema-cim16#")
@XmlAccessorType(XmlAccessType.FIELD)
public class BusBarSection extends Connector{

    @XmlElement(name = "BusbarSection.ipMax", namespace = "http://iec.ch/TC57/2013/CIM-schema-cim16#")
    private CurrentFlow ipMax;

    @XmlElement(name = "ConductingEquipment.BaseVoltage", namespace = "http://iec.ch/TC57/2013/CIM-schema-cim16#")
    private Resource baseVoltageResource = new Resource("#_$BaseVoltage_0_4");
    @XmlElement(name = "Connector.ConductingEquipment.Terminal", namespace = "http://iec.ch/TC57/2013/CIM-schema-cim16#")
    private Resource terminalResource;

    public BusBarSection(String aliasName, String description, String mRID, String name) {
        super(aliasName, description, mRID, name);
    }

    public BusBarSection() {
    }

    public BusBarSection(String mRID, String name) {
        super(mRID, name);
    }

    public CurrentFlow getIpMax() {
        return ipMax;
    }

    public void setIpMax(CurrentFlow ipMax) {
        this.ipMax = ipMax;
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
