package cim.classes;

import cim.datatypes.PhaseCode;
import cim.datatypes.UnitMultiplier;
import cim.datatypes.UnitSymbol;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Measurement extends IdentifiedObject{
    private String measurementType;
    @XmlElement(name = "Measurement.PhaseCode", namespace = "http://iec.ch/TC57/2013/CIM-schema-cim16#")
    private PhaseCode phases;
    @XmlElement(name = "Measurement.unitMultiplier", namespace = "http://iec.ch/TC57/2013/CIM-schema-cim16#")
    private UnitMultiplier unitMultiplier;
    @XmlElement(name = "Measurement.unitSymbol", namespace = "http://iec.ch/TC57/2013/CIM-schema-cim16#")
    private UnitSymbol unitSymbol;

    public Measurement(String aliasName, String description, String mRID, String name) {
        super(aliasName, description, mRID, name);
    }

    public Measurement(String description, String name, String mRID) {
        super(description, name, mRID);
    }

    public Measurement(String mRID) {
        super(mRID);
    }

    public Measurement() {
    }

    public Measurement(String mRID, String name) {
        super(mRID, name);
    }

    public String getMeasurementType() {
        return measurementType;
    }

    public void setMeasurementType(String measurementType) {
        this.measurementType = measurementType;
    }

    public PhaseCode getPhases() {
        return phases;
    }

    public void setPhases(PhaseCode phases) {
        this.phases = phases;
    }

    public UnitMultiplier getUnitMultiplier() {
        return unitMultiplier;
    }

    public void setUnitMultiplier(UnitMultiplier unitMultiplier) {
        this.unitMultiplier = unitMultiplier;
    }

    public UnitSymbol getUnitSymbol() {
        return unitSymbol;
    }

    public void setUnitSymbol(UnitSymbol unitSymbol) {
        this.unitSymbol = unitSymbol;
    }
}
