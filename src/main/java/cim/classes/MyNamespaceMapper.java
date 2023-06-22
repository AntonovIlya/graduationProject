package cim.classes;

import com.sun.xml.bind.marshaller.NamespacePrefixMapper;

public class MyNamespaceMapper extends NamespacePrefixMapper {

    private static final String RDF_PREFIX = "rdf";
    private static final String RDF_URI = "http://www.w3.org/1999/02/22-rdf-syntax-ns#";

    private static final String CIM_PREFIX = "cim";
    private static final String CIM_URI = "http://iec.ch/TC57/2013/CIM-schema-cim16#";

    @Override
    public String getPreferredPrefix(String namespaceUri, String suggestion, boolean requirePrefix) {
        if(RDF_URI.equals(namespaceUri)) {
            return RDF_PREFIX;
        } else if(CIM_URI.equals(namespaceUri)) {
            return CIM_PREFIX;
        }
        return suggestion;
    }

    @Override
    public String[] getPreDeclaredNamespaceUris() {
        return new String[] {RDF_URI, CIM_URI};
    }

}
