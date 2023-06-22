package cim.main;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.properties.PropertiesComponent;
import org.apache.camel.impl.DefaultCamelContext;

public class Starter {

    public static void main(String[] args) throws Exception {
        CamelContext camel = new DefaultCamelContext();
        CreatorCIMXML creatorCIMXML = new CreatorCIMXML();
        camel.setPropertiesComponent(new PropertiesComponent("classpath:application.properties"));
        camel.addRoutes(new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("file:{{from}}?noop=true")
                        .routeId("File exchange")
                        .setHeader(Exchange.FILE_NAME, constant("dataToSystemB.xml"))
                        .to("file:{{to}}");
            }
        });
        camel.start();
        creatorCIMXML.start(new String[]{"KTP.6"});
        Thread.sleep(2000);
        camel.stop();
    }
}

