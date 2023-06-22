package cim.classes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashSet;
import java.util.Set;

@XmlRootElement(name = "Substation", namespace = "http://iec.ch/TC57/2013/CIM-schema-cim16#")
@XmlAccessorType(XmlAccessType.FIELD)
public class Substation extends IdentifiedObject{

    private SubGeographicalRegion subGeographicalRegion;
    private Set<VoltageLevel> voltageLevels = new HashSet<>();
    @XmlElement(name = "Substation.SubGeographicalRegion",
            namespace = "http://iec.ch/TC57/2013/CIM-schema-cim16#")
    private Resource subGeographicalRegionResource;

    public Substation(String aliasName, String description, String mRID, String name) {
        super(aliasName, description, mRID, name);
    }

    public Substation(String mRID, String name) {
        super(mRID, name);
    }

    public Substation() {
    }

    public SubGeographicalRegion getSubGeographicalRegion() {
        return subGeographicalRegion;
    }

    public void setSubGeographicalRegion(SubGeographicalRegion subGeographicalRegion) {
        this.subGeographicalRegion = subGeographicalRegion;
    }

    public void addVoltageLevel(VoltageLevel voltageLevel){
        this.voltageLevels.add(voltageLevel);
        voltageLevel.setSubstation(this);
    }

    public Set<VoltageLevel> getVoltageLevels() {
        return voltageLevels;
    }

    public void setVoltageLevels(Set<VoltageLevel> voltageLevels) {
        this.voltageLevels = voltageLevels;
    }

    public Resource getSubGeographicalRegionResource() {
        return subGeographicalRegionResource;
    }

    public void setSubGeographicalRegionResource(Resource subGeographicalRegionResource) {
        this.subGeographicalRegionResource = subGeographicalRegionResource;
    }

}

