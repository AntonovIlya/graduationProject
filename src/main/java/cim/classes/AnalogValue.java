package cim.classes;

import cim.datatypes.PerCent;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.sql.Timestamp;
import java.util.Date;

@XmlRootElement(name = "AnalogValue", namespace = "http://iec.ch/TC57/2013/CIM-schema-cim16#")
@XmlAccessorType(XmlAccessType.FIELD)
public class AnalogValue extends IdentifiedObject {
    @XmlElement(name = "AnalogValue.value", namespace = "http://iec.ch/TC57/2013/CIM-schema-cim16#")
    private float value;
    @XmlElement(name = "Analog", namespace = "http://iec.ch/TC57/2013/CIM-schema-cim16#")
    private Resource analogRecourse;
    @XmlElement(name = "AnalogValue.timestamp", namespace = "http://iec.ch/TC57/2013/CIM-schema-cim16#")
    private String timestamp;

    public AnalogValue(String aliasName, String description, String mRID, String name) {
        super(aliasName, description, mRID, name);
    }

    public AnalogValue() {
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public Resource getAnalogRecourse() {
        return analogRecourse;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public void setAnalogRecourse(Resource analogRecourse) {
        this.analogRecourse = analogRecourse;
    }
}