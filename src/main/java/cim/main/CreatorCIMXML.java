package cim.main;

import cim.classes.*;
import cim.datatypes.*;

import java.util.*;
import java.util.function.Function;

public class CreatorCIMXML {

    private List<Object> list = new ArrayList<>();
    private boolean cycle = false;
    private Terminal terminalBus;
    private ConnectivityNode CNBus;
    private BaseVoltage baseVoltage10;
    private BaseVoltage baseVoltage0_4;

    public void start(String[] request) {

        String[] KTP = request;
        createStaticPath();
        DBMain dbMain = new DBMain();
        dbMain.connectionDB();
        for (String s : KTP) {
            createTopologyPath(dbMain, s);
            createMeasPath(dbMain, s);
        }
        dbMain.disconnectionDB();
        list.sort(Comparator.comparing(CreatorCIMXML::retIDtoCompare));
        generateCIMXMLRDF(list);

        /*RDF rdf = JAXBReader.unmarshalling();
        List<Object> list1 = rdf.getObjects();*/
    }


    private static int retIDtoCompare(Object o) {
        return switch (o.getClass().getSimpleName()) {
            case ("AnalogValue") -> 1;
            case ("Analog") -> 2;
            case ("EnergyConsumer") -> 3;
            case ("Breaker") -> 4;
            case ("Disconnector") -> 5;
            case ("Fuse") -> 6;
            case ("BusBarSection") -> 7;
            case ("PowerTransformer") -> 8;
            case ("VoltageLevel") -> 9;
            case ("Substation") -> 10;
            case ("SubGeographicalRegion") -> 11;
            case ("GeographicalRegion") -> 12;
            case ("Terminal") -> 13;
            case ("ConnectivityNode") -> 14;
            case ("BaseVoltage") -> 15;
            default -> 0;
        };
    }

    private void generateCIMXMLRDF(List<Object> list) {
        RDF rdf = new RDF(list);
        JAXBWriter.marshalling(rdf);
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

    private void createStaticPath() {
        baseVoltage10 = new BaseVoltage("_$BaseVoltage_10", new Voltage(10));
        baseVoltage0_4 = new BaseVoltage("_$BaseVoltage_0_4", new Voltage(0.4f));
        list.add(baseVoltage10);
        list.add(baseVoltage0_4);
    }

    private void createTopologyPath(DBMain db, String measuringPoint) {
        Substation KTP = new Substation(generateMRID(), measuringPoint);
        VoltageLevel voltageLevel_10kV = new VoltageLevel(new Voltage(11), new Voltage(9));
        voltageLevel_10kV.setSubstationResource(new Resource("#" + KTP.getAttribute()));
        voltageLevel_10kV.setBaseVoltageResource(new Resource("#" + baseVoltage10.getmRID()));
        VoltageLevel voltageLevel_400V = new VoltageLevel(new Voltage(0.42f), new Voltage(0.36f));
        voltageLevel_400V.setSubstationResource(new Resource("#" + KTP.getAttribute()));
        voltageLevel_400V.setBaseVoltageResource(new Resource("#" + baseVoltage0_4.getmRID()));
        list.add(voltageLevel_10kV);
        list.add(voltageLevel_400V);
        list.add(KTP);
        List<EquipmentDB> listEquip = db.queryEquip(measuringPoint);
        listEquip.sort(Comparator.comparing(EquipmentDB::getId));
        List<String[]> equipmentsNames = new ArrayList<>();
        Terminal terminal = new Terminal(generateMRID(), PhaseCode.ABC);
        for (EquipmentDB equipmentDB : listEquip) {
            equipmentsNames.add(new String[]{equipmentDB.getEquipmentName(), equipmentDB.getBaseVoltage()});
        }
        createCoupleEquip(equipmentsNames, terminal);
        BusBarSection busBarSection = new BusBarSection(generateMRID(), "BUS");
        Terminal terminal1 = new Terminal(generateMRID(), PhaseCode.ABC);
        terminal1.setConnectivityNodeResource(new Resource("#" + CNBus.getAttribute()));
        busBarSection.setTerminalResource(new Resource("#" + terminal1.getAttribute()));
        list.add(terminal1);
        list.add(busBarSection);
        list.add(CNBus);
        list.add(terminalBus);
    }

    private void createMeasPath(DBMain db, String measuringPoint) {
        List<Meas> listMeas = db.queryMeas(measuringPoint);
        for (Meas meas : listMeas) {
            Analog analog = new Analog(meas.getSmartMeterID());
            analog.setNormalValue((float) meas.getNormalValue());
            analog.setUnitMultiplier(UnitMultiplier.valueOf(meas.getMultiplier()));
            analog.setUnitSymbol(UnitSymbol.valueOf(meas.getSymbol()));
            analog.setPhases(PhaseCode.valueOf(meas.getPhaseCode()));
            analog.setTerminalResource(new Resource(getResourceEquip(meas.getEquipmentName())));
            AnalogValue analogValue = new AnalogValue();
            analogValue.setValue((float) meas.getValue());
            analogValue.setTimestamp(meas.getRegisterDateTime().toString());
            analogValue.setAnalogRecourse(new Resource("#" + analog.getAttribute()));
            list.add(analog);
            list.add(analogValue);
        }
    }

    private void createCoupleEquip(List<String[]> equipmentNames, Terminal t1) {
        String equipmentName = equipmentNames.get(0)[0];
        String baseVoltage = equipmentNames.get(0)[1];
        ConnectivityNode CN = new ConnectivityNode(generateMRID());
        if (!cycle && equipmentNames.get(1)[0].contains("W")) {
            cycle = true;
            CNBus = CN;
            terminalBus = t1;
        }
        Terminal t2 = new Terminal(generateMRID(), PhaseCode.ABC);
        Terminal t3 = new Terminal(generateMRID(), PhaseCode.ABC);
        t1.setConnectivityNodeResource(new Resource("#" + CN.getAttribute()));
        if (equipmentName.contains("S")) {
            t2.setConnectivityNodeResource(new Resource("#" + (cycle ? CNBus.getAttribute() : CN.getAttribute())));
        } else {
            t2.setConnectivityNodeResource(new Resource("#" + CN.getAttribute()));
        }
        switch (equipmentName.substring(0, 2)) {
            case ("QS"), ("SA") -> {
                Disconnector disconnector = createDisconnector(equipmentName, baseVoltage, t2, t3);
                if (cycle) {
                    addObjects(t2, disconnector);
                } else {
                    addObjects(CN, t1, t2, disconnector);
                }
            }
            case ("FU") -> {
                Fuse fuse = createFuse(equipmentName, baseVoltage, t2, t3);
                addObjects(CN, t1, t2, fuse);
            }
            case ("T1") -> {
                PowerTransformer powerTransformer = createPowerTransformer(equipmentName, t2, t3);
                addObjects(CN, t1, t2, powerTransformer);
            }
            case ("SF") -> {
                Breaker breaker = createBreaker(equipmentName, baseVoltage, t2, t3);
                if (cycle) {
                    addObjects(t2, breaker);
                } else {
                    addObjects(CN, t1, t2, breaker);
                }
            }
            case ("W1"), ("W2"), ("W3"), ("W4"), ("W5") -> {
                EnergyConsumer energyConsumer = createEnergyConsumer(equipmentName, baseVoltage, t2);
                addObjects(CN, t1, t2, energyConsumer);
            }
        }
        equipmentNames.remove(0);
        if (!equipmentNames.isEmpty()) {
            createCoupleEquip(equipmentNames, t3);
        }
    }

    private Disconnector createDisconnector(String equipmentName, String baseVoltage, Terminal t1, Terminal t2) {
        Disconnector disconnector = new Disconnector(generateMRID(), equipmentName);
        disconnector.setBaseVoltageResource(new Resource("#" + baseVoltage));
        disconnector.setTerminal1Resource(new Resource("#" + t1.getAttribute()));
        disconnector.setTerminal2Resource(new Resource("#" + t2.getAttribute()));
        return disconnector;
    }

    private Breaker createBreaker(String equipmentName, String baseVoltage, Terminal t1, Terminal t2) {
        Breaker breaker = new Breaker(generateMRID(), equipmentName);
        breaker.setBaseVoltageResource(new Resource("#" + baseVoltage));
        breaker.setTerminal1Resource(new Resource("#" + t1.getAttribute()));
        breaker.setTerminal2Resource(new Resource("#" + t2.getAttribute()));
        return breaker;
    }

    private Fuse createFuse(String equipmentName, String baseVoltage, Terminal t1, Terminal t2) {
        Fuse fuse = new Fuse(generateMRID(), equipmentName);
        fuse.setBaseVoltageResource(new Resource("#" + baseVoltage));
        fuse.setTerminal1Resource(new Resource("#" + t1.getAttribute()));
        fuse.setTerminal2Resource(new Resource("#" + t2.getAttribute()));
        return fuse;
    }

    private EnergyConsumer createEnergyConsumer(String equipmentName, String baseVoltage, Terminal terminal) {
        EnergyConsumer energyConsumer = new EnergyConsumer(generateMRID(), equipmentName);
        energyConsumer.setBaseVoltageResource(new Resource("#" + baseVoltage));
        energyConsumer.setTerminalResource(new Resource("#" + terminal.getAttribute()));
        return energyConsumer;
    }

    private PowerTransformer createPowerTransformer(String equipmentName, Terminal t1, Terminal t2) {
        PowerTransformer PowerTransformer = new PowerTransformer(generateMRID(), equipmentName);
        PowerTransformer.setTerminal1Resource(new Resource("#" + t1.getAttribute()));
        PowerTransformer.setTerminal2Resource(new Resource("#" + t2.getAttribute()));
        return PowerTransformer;
    }

    private void addObjects(ConnectivityNode connectivityNode, Terminal t1, Terminal t2, Object equipment) {
        list.add(connectivityNode);
        list.add(t1);
        list.add(t2);
        list.add(equipment);
    }

    private void addObjects(Terminal t2, Object equipment) {
        list.add(t2);
        list.add(equipment);
    }

    private String getResourceEquip(String equipmentName) {
        for (Object o : list) {
            switch (o.getClass().getSimpleName()) {
                case ("BusBarSection") -> {
                    assert o instanceof BusBarSection;
                    if (equipmentName.equals(((BusBarSection) o).getName())) {
                        BusBarSection busBarSection = (BusBarSection) o;
                        return busBarSection.getTerminalResource().getAttribute();
                    }
                }
                case ("Breaker") -> {
                    assert o instanceof Breaker;
                    if (equipmentName.equals(((Breaker) o).getName())) {
                        return ((Breaker) o).getTerminal1Resource().getAttribute();
                    }
                }
                case ("Disconnector") -> {
                    assert o instanceof Disconnector;
                    if (equipmentName.equals(((Disconnector) o).getName())) {
                        return ((Disconnector) o).getTerminal1Resource().getAttribute();
                    }
                }
                case ("EnergyConsumer") -> {
                    assert o instanceof EnergyConsumer;
                    if (equipmentName.equals(((EnergyConsumer) o).getName())) {
                        return ((EnergyConsumer) o).getTerminalResource().getAttribute();
                    }
                }
            }
        }
        return null;
    }
}
