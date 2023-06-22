package cim.classes;

public class EquipmentDB{

    private int id;
    private String equipmentName;
    private String equipmentID;
    private String substationName;
    private String description;
    private String baseVoltage;

    public EquipmentDB() {
    }

    public EquipmentDB(int id, String equipmentName, String equipmentID, String substationName, String description, String baseVoltage) {
        this.id = id;
        this.equipmentName = equipmentName;
        this.equipmentID = equipmentID;
        this.substationName = substationName;
        this.description = description;
        this.baseVoltage = baseVoltage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public String getEquipmentID() {
        return equipmentID;
    }

    public void setEquipmentID(String equipmentID) {
        this.equipmentID = equipmentID;
    }

    public String getSubstationName() {
        return substationName;
    }

    public void setSubstationName(String substationName) {
        this.substationName = substationName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBaseVoltage() {
        return baseVoltage;
    }

    public void setBaseVoltage(String baseVoltage) {
        this.baseVoltage = baseVoltage;
    }

    @Override
    public String toString() {
        return "EquipmentDB{" +
                "id=" + id +
                ", equipmentName='" + equipmentName + '\'' +
                ", equipmentID='" + equipmentID + '\'' +
                ", substationName='" + substationName + '\'' +
                ", description='" + description + '\'' +
                ", baseVoltage='" + baseVoltage + '\'' +
                '}';
    }

}
