package cim.classes;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.HashSet;
import java.util.Set;

@XmlRootElement(name = "GeographicalRegion", namespace = "http://iec.ch/TC57/2013/CIM-schema-cim16#")
public class GeographicalRegion extends IdentifiedObject {

    private Set<SubGeographicalRegion> subGeographicalRegion = new HashSet<>();

    public GeographicalRegion(String aliasName, String description, String mRID, String name) {
        super(aliasName, description, mRID, name);
    }

    public GeographicalRegion() {
    }

    public GeographicalRegion(String mRID, String name) {
        super(mRID, name);
    }

    public void addSubGeographicalRegion(SubGeographicalRegion subGeographicalRegion) {
        this.subGeographicalRegion.add(subGeographicalRegion);
        subGeographicalRegion.setGeographicalRegion(this);

    }

    public Set<SubGeographicalRegion> getSubGeographicalRegion() {
        return subGeographicalRegion;
    }

    public void setSubGeographicalRegion(Set<SubGeographicalRegion> subGeographicalRegion) {
        this.subGeographicalRegion = subGeographicalRegion;
    }

    @Override
    public String toString() {
        return "GeographicalRegion{" +
                "subGeographicalRegion=" + subGeographicalRegion +
                '}';
    }
}
