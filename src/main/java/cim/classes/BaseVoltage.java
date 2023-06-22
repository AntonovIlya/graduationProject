package cim.classes;

import cim.datatypes.Voltage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashSet;
import java.util.Set;

@XmlRootElement(name = "BaseVoltage", namespace = "http://iec.ch/TC57/2013/CIM-schema-cim16#")
@XmlAccessorType(XmlAccessType.FIELD)
public class BaseVoltage extends IdentifiedObject {

    @XmlElement(name = "BaseVoltage.nominalVoltage", namespace = "http://iec.ch/TC57/2013/CIM-schema-cim16#")
    private Voltage nominalVoltage;
    private Set<VoltageLevel> voltageLevels = new HashSet<>();
    private Set<ConductingEquipment> conductingEquipments = new HashSet<>();

    public BaseVoltage(String aliasName, String description, String mRID, String name) {
        super(aliasName, description, mRID, name);
    }

    public BaseVoltage(String mRID, Voltage nominalVoltage) {
        super(mRID);
        this.nominalVoltage = nominalVoltage;
    }

    public BaseVoltage() {
    }

    public BaseVoltage(String mRID, String name) {
        super(mRID, name);
    }

    public Voltage getNominalVoltage() {
        return nominalVoltage;
    }

    public void setNominalVoltage(Voltage nominalVoltage) {
        this.nominalVoltage = nominalVoltage;
    }

    public Set<VoltageLevel> getVoltageLevels() {
        return voltageLevels;
    }

    public void setVoltageLevels(Set<VoltageLevel> voltageLevels) {
        this.voltageLevels = voltageLevels;
    }

    public Set<ConductingEquipment> getConductingEquipments() {
        return conductingEquipments;
    }

    public void setConductingEquipments(Set<ConductingEquipment> conductingEquipments) {
        this.conductingEquipments = conductingEquipments;
    }

    public void addConductingEquipment(ConductingEquipment conductingEquipment){
        this.conductingEquipments.add(conductingEquipment);
    }

    public void addVoltageLevels(VoltageLevel voltageLevel){
        this.voltageLevels.add(voltageLevel);

    }
}
