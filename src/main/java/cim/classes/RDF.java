package cim.classes;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "RDF", namespace = "http://www.w3.org/1999/02/22-rdf-syntax-ns#")
@XmlAccessorType(XmlAccessType.FIELD)
public class RDF {

    @XmlAnyElement(lax = true)
    private List<Object> objects;

    public RDF() {
    }

    public RDF(List<Object> objects) {
        this.objects = objects;
    }

    public List<Object> getObjects() {
        return objects;
    }

    public void setObjects(List<Object> objects) {
        this.objects = objects;
    }

}
