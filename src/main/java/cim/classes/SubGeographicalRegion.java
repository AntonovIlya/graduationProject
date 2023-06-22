package cim.classes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashSet;
import java.util.Set;

@XmlRootElement(name = "SubGeographicalRegion", namespace = "http://iec.ch/TC57/2013/CIM-schema-cim16#")
@XmlAccessorType(XmlAccessType.FIELD)
public class SubGeographicalRegion extends IdentifiedObject {

    private GeographicalRegion geographicalRegion;

    @XmlElement(name = "SubGeographicalRegion.GeographicalRegion",
            namespace = "http://iec.ch/TC57/2013/CIM-schema-cim16#", nillable = true)
    private Resource geographicalRegionResource;

    private Set<Substation> substations = new HashSet<>();

    public SubGeographicalRegion(String aliasName, String description, String mRID, String name) {
        super(aliasName, description, mRID, name);
    }

    public SubGeographicalRegion() {
    }

    public SubGeographicalRegion(String mRID, String name) {
        super(mRID, name);
    }

    public GeographicalRegion getGeographicalRegion() {
        return geographicalRegion;
    }

    public void setGeographicalRegion(GeographicalRegion geographicalRegion) {
        this.geographicalRegion = geographicalRegion;
    }

    public Set<Substation> getSubstations() {
        return substations;
    }

    public void setSubstations(Set<Substation> substations) {
        this.substations = substations;
    }

    public void addSubstation(Substation substation){
        this.substations.add(substation);
        substation.setSubGeographicalRegion(this);
    }

    public Resource getGeographicalRegionResource() {
        return geographicalRegionResource;
    }

    public void setGeographicalRegionResource(Resource geographicalRegionResource) {
        this.geographicalRegionResource = geographicalRegionResource;
    }

}
