package cim.classes;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashSet;
import java.util.Set;

public class ACDCTerminal extends IdentifiedObject{

    private Set<Measurement> acdcMeasurements = new HashSet<>();

    public ACDCTerminal(String aliasName, String description, String mRID, String name) {
        super(aliasName, description, mRID, name);
    }

    public ACDCTerminal() {
    }

    public ACDCTerminal(String mRID) {
        super(mRID);
    }

    public ACDCTerminal(String mRID, String name) {
        super(mRID, name);
    }

    public void addMeasurement(Measurement measurement){
        this.acdcMeasurements.add(measurement);
    }
}
