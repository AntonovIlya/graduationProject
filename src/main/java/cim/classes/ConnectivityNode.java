package cim.classes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ConnectivityNode", namespace = "http://iec.ch/TC57/2013/CIM-schema-cim16#")
public class ConnectivityNode extends IdentifiedObject {
    //private Set<Terminal> terminals = new HashSet<>();

    public ConnectivityNode(String aliasName, String description, String mRID, String name) {
        super(aliasName, description, mRID, name);
    }

    public ConnectivityNode() {
    }

    public ConnectivityNode(String mRID) {
        super(mRID);
    }

    public ConnectivityNode(String mRID, String name) {
        super(mRID, name);
    }

    /*public void addTerminal(Terminal terminal) {
        this.terminals.add(terminal);
    }*/
}
