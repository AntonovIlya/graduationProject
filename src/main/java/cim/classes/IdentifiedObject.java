package cim.classes;

import javax.xml.bind.annotation.*;
import java.util.Random;

@XmlAccessorType(XmlAccessType.FIELD)
public class IdentifiedObject {

    @XmlElement(name = "IdentifiedObject.aliasName", namespace = "http://iec.ch/TC57/2013/CIM-schema-cim16#")
    private String aliasName;
    @XmlElement(name = "IdentifiedObject.description", namespace = "http://iec.ch/TC57/2013/CIM-schema-cim16#")
    private String description;
    @XmlElement(name = "IdentifiedObject.name", namespace = "http://iec.ch/TC57/2013/CIM-schema-cim16#")
    private String name;
    @XmlElement(name = "IdentifiedObject.mRID", namespace = "http://iec.ch/TC57/2013/CIM-schema-cim16#")
    private String mRID;
    @XmlAttribute(name = "ID", namespace = "http://www.w3.org/1999/02/22-rdf-syntax-ns#")
    private String attribute;

    public IdentifiedObject(String aliasName, String description, String mRID, String name) {
        this.aliasName = aliasName;
        this.description = description;
        this.mRID = mRID;
        this.name = name;
        this.attribute = "_" + this.mRID;
    }

    public IdentifiedObject(String mRID, String name) {
        this.mRID = mRID;
        this.name = name;
        this.attribute = "_" + this.mRID;
    }

    public IdentifiedObject(String mRID) {
        this.mRID = mRID;
        this.attribute = "_" + this.mRID;
    }

    public IdentifiedObject(String description, String name, String mRID) {
        this.description = description;
        this.name = name;
        this.mRID = mRID;
        this.attribute = "_" + this.mRID;
    }

    public IdentifiedObject() {
        this.attribute = "_" + generateMRID();
    }


    public String getAliasName() {
        return aliasName;
    }

    public void setAliasName(String aliasName) {
        this.aliasName = aliasName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getmRID() {
        return mRID;
    }

    public void setmRID(String mRID) {
        this.mRID = mRID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    private String generateMRID() {
        Random sRandom = new Random();
        char[] sAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        int sLength = sAlphabet.length;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 31; i++) {
            if (Math.random() > 0.5) {
                stringBuilder.append((int) (Math.random() * 10));
            } else {
                stringBuilder.append(sAlphabet[sRandom.nextInt(sLength)]);
            }
        }
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return "IdentifiedObject{" +
                "aliasName='" + aliasName + '\'' +
                ", description='" + description + '\'' +
                ", mRID='" + mRID + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
