package cim.classes;

import cim.datatypes.Voltage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "VoltageLevel", namespace = "http://iec.ch/TC57/2013/CIM-schema-cim16#")
@XmlAccessorType(XmlAccessType.FIELD)
public class VoltageLevel extends IdentifiedObject{

    @XmlElement(name = "VoltageLevel.highVoltageLimit", namespace = "http://iec.ch/TC57/2013/CIM-schema-cim16#")
    private Voltage highVoltageLimit;
    @XmlElement(name = "VoltageLevel.lowVoltageLimit", namespace = "http://iec.ch/TC57/2013/CIM-schema-cim16#")
    private Voltage lowVoltageLimit;
    @XmlElement(name = "VoltageLevel.highVoltageLimit", namespace = "http://iec.ch/TC57/2013/CIM-schema-cim16#")
    private String highVoltageLimitString;
    @XmlElement(name = "VoltageLevel.lowVoltageLimit", namespace = "http://iec.ch/TC57/2013/CIM-schema-cim16#")
    private String lowVoltageLimitString;
    private Substation substation;
    @XmlElement(name = "VoltageLevel.BaseVoltage", namespace = "http://iec.ch/TC57/2013/CIM-schema-cim16#", nillable = true)
    private Resource baseVoltageResource;
    @XmlElement(name = "VoltageLevel.Substation", namespace = "http://iec.ch/TC57/2013/CIM-schema-cim16#", nillable = true)
    private Resource substationResource;

    public VoltageLevel(String aliasName, String description, String mRID, String name) {
        super(aliasName, description, mRID, name);
    }

    public VoltageLevel(Voltage highVoltageLimit, Voltage lowVoltageLimit) {
        this.highVoltageLimit = highVoltageLimit;
        this.lowVoltageLimit = lowVoltageLimit;
    }

    public VoltageLevel() {
    }

    public VoltageLevel(String mRID, String name) {
        super(mRID, name);
    }

    public Voltage getHighVoltageLimit() {
        return highVoltageLimit;
    }


    public void setHighVoltageLimit(Voltage highVoltageLimit) {
        this.highVoltageLimit = highVoltageLimit;
    }

    public Voltage getLowVoltageLimit() {
        return lowVoltageLimit;
    }

    public void setLowVoltageLimit(Voltage lowVoltageLimit) {
        this.lowVoltageLimit = lowVoltageLimit;
    }

    public Substation getSubstation() {
        return substation;
    }

    public void setSubstation(Substation substation) {
        this.substation = substation;
    }

    public String getHighVoltageLimitString() {
        return highVoltageLimitString;
    }

    public void setHighVoltageLimitString(String highVoltageLimitString) {
        this.highVoltageLimitString = highVoltageLimitString;
    }

    public String getLowVoltageLimitString() {
        return lowVoltageLimitString;
    }

    public void setLowVoltageLimitString(String lowVoltageLimitString) {
        this.lowVoltageLimitString = lowVoltageLimitString;
    }

    public Resource getBaseVoltageResource() {
        return baseVoltageResource;
    }

    public void setBaseVoltageResource(Resource baseVoltageResource) {
        this.baseVoltageResource = baseVoltageResource;
    }

    public Resource getSubstationResource() {
        return substationResource;
    }

    public void setSubstationResource(Resource substationResource) {
        this.substationResource = substationResource;
    }
}
