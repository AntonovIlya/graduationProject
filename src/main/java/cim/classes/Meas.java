package cim.classes;

import java.sql.Timestamp;

public class Meas {

    private int id;
    private String symbol;
    private String multiplier;
    private double normalValue;
    private double value;
    private Timestamp registerDateTime;
    private String equipmentName;
    private String measuringPoint;
    private String phaseCode;
    private String smartMeterID;

    public Meas(int id,
                String symbol,
                String multiplier,
                double normalValue,
                double value,
                Timestamp registerDateTime,
                String equipmentName,
                String measuringPoint,
                String phaseCode,
                String smartMeterID) {
        this.id = id;
        this.symbol = symbol;
        this.multiplier = multiplier;
        this.normalValue = normalValue;
        this.value = value;
        this.registerDateTime = registerDateTime;
        this.equipmentName = equipmentName;
        this.measuringPoint = measuringPoint;
        this.phaseCode = phaseCode;
        this.smartMeterID = smartMeterID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(String multiplier) {
        this.multiplier = multiplier;
    }

    public double getNormalValue() {
        return normalValue;
    }

    public void setNormalValue(double normalValue) {
        this.normalValue = normalValue;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Timestamp getRegisterDateTime() {
        return registerDateTime;
    }

    public void setRegisterDateTime(Timestamp registerDateTime) {
        this.registerDateTime = registerDateTime;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public String getMeasuringPoint() {
        return measuringPoint;
    }

    public void setMeasuringPoint(String measuringPoint) {
        this.measuringPoint = measuringPoint;
    }

    public String getPhaseCode() {
        return phaseCode;
    }

    public void setPhaseCode(String phaseCode) {
        this.phaseCode = phaseCode;
    }

    public String getSmartMeterID() {
        return smartMeterID;
    }

    public void setSmartMeterID(String smartMeterID) {
        this.smartMeterID = smartMeterID;
    }

    @Override
    public String toString() {
        return "Meas{" +
                "id=" + id +
                ", symbol=" + symbol +
                ", multiplier=" + multiplier +
                ", normalValue=" + normalValue +
                ", value=" + value +
                ", registerDateTime=" + registerDateTime +
                ", equipmentName='" + equipmentName + '\'' +
                ", measuringPoint='" + measuringPoint + '\'' +
                ", phaseCode='" + phaseCode + '\'' +
                ", smartMeterID='" + smartMeterID + '\'' +
                '}';
    }
}
