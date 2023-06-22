package cim.classes;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class JAXBWriter {

    public static Class<?>[] classes = new Class[]{RDF.class,
            GeographicalRegion.class,
            SubGeographicalRegion.class,
            VoltageLevel.class,
            BaseVoltage.class,
            ConnectivityNode.class,
            Terminal.class,
            PowerTransformer.class,
            Disconnector.class,
            Breaker.class,
            BusBarSection.class,
            Fuse.class,
            EnergyConsumer.class,
            Analog.class,
            AnalogValue.class};

    public static void marshalling(Object o) {
        try {
            JAXBContext context = JAXBContext.newInstance(classes);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.setProperty("com.sun.xml.bind.namespacePrefixMapper", new MyNamespaceMapper());
            m.marshal(o, new FileOutputStream("SystemA/dataToSystemB.xml"));
            System.out.println("XML файл создан");
        } catch (JAXBException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
