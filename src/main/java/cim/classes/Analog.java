package cim.classes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Analog", namespace = "http://iec.ch/TC57/2013/CIM-schema-cim16#")
@XmlAccessorType(XmlAccessType.FIELD)
public class Analog extends Measurement {
    @XmlElement(name = "Measurement.normalValue", namespace = "http://iec.ch/TC57/2013/CIM-schema-cim16#")
    private float normalValue;
    @XmlElement(name = "Measurement.positiveFlowIn", namespace = "http://iec.ch/TC57/2013/CIM-schema-cim16#")
    private boolean positiveFlow = true;
    @XmlElement(name = "Measurement.Terminal",
            namespace = "http://iec.ch/TC57/2013/CIM-schema-cim16#", nillable = true)
    private Resource terminalResource;

    //private Set<AnalogValue> analogValues = new HashSet<>();

    public Analog(String aliasName, String description, String mRID, String name) {
        super(aliasName, description, mRID, name);
    }

    public Analog(String description, String name, String mRID) {
        super(description, name, mRID);
    }

    public Analog() {
    }

    public Analog(String mRID, String name) {
        super(mRID, name);
    }

    public Analog(String mRID) {
        super(mRID);
    }

    public float getNormalValue() {
        return normalValue;
    }

    public void setNormalValue(float normalValue) {
        this.normalValue = normalValue;
    }

    public boolean isPositiveFlow() {
        return positiveFlow;
    }

    public void setPositiveFlow(boolean positiveFlow) {
        this.positiveFlow = positiveFlow;
    }

    public Resource getTerminalResource() {
        return terminalResource;
    }

    public void setTerminalResource(Resource terminalResource) {
        this.terminalResource = terminalResource;
    }

    /*public void addAnalogValue(AnalogValue analogValue){
        this.analogValues.add(analogValue);
    }*/
}
