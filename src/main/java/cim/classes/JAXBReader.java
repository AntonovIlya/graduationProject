package cim.classes;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class JAXBReader {

    public static RDF unmarshalling() {
        RDF rdf = null;
        try {
            JAXBContext context = JAXBContext.newInstance(JAXBWriter.classes);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            rdf = (RDF) unmarshaller.unmarshal(new File( "data.xml" ));
        } catch (JAXBException e) {
            e.getMessage();
        }
        return rdf;
    }
}
