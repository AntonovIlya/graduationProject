package cim.classes;

import cim.datatypes.PhaseCode;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Terminal", namespace = "http://iec.ch/TC57/2013/CIM-schema-cim16#")
@XmlAccessorType(XmlAccessType.FIELD)
public class Terminal extends ACDCTerminal {

    @XmlElement(name = "Terminal.phases", namespace = "http://iec.ch/TC57/2013/CIM-schema-cim16#")
    private PhaseCode phases;

    @XmlElement(name = "Terminal.ConnectivityNode",
            namespace = "http://iec.ch/TC57/2013/CIM-schema-cim16#", nillable = true)
    private Resource connectivityNodeResource;

    public Terminal(String aliasName, String description, String mRID, String name) {
        super(aliasName, description, mRID, name);
    }

    public Terminal() {
    }

    public Terminal(PhaseCode phases) {
        this.phases = phases;
    }

    public Terminal(String mRID, PhaseCode phases) {
        super(mRID);
        this.phases = phases;
    }

    public Terminal(String mRID, String name) {
        super(mRID, name);
    }

    public PhaseCode getPhases() {
        return phases;
    }

    public void setPhases(PhaseCode phases) {
        this.phases = phases;
    }

    public Resource getConnectivityNodeResource() {
        return connectivityNodeResource;
    }

    public void setConnectivityNodeResource(Resource connectivityNodeResource) {
        this.connectivityNodeResource = connectivityNodeResource;
    }
}
