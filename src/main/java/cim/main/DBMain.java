package cim.main;

import cim.classes.EquipmentDB;
import cim.classes.Meas;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBMain {

    private Connection connection;
    private final String MSSQL_DB_URL = "jdbc:sqlserver://DESKTOP-CO2EB4T;" +
            "databaseName=MeasurementsDB;" +
            "integratedSecurity=true;" +
            "encrypt=true;trustServerCertificate=true;";
    private final String PGSQL_DB_URL = "jdbc:postgresql://localhost:5432/MeasurementsDB";

    public void connectionDB() {
        try {
            connection = DriverManager.getConnection(PGSQL_DB_URL, "postgres", "admin");//соединениесБД
            System.out.println("Соединение с СУБД выполнено.");
            DatabaseMetaData dm = connection.getMetaData();
            System.out.println("Driver name: " + dm.getDriverName());
            System.out.println("Driver version: " + dm.getDriverVersion());
            System.out.println("Product name: " + dm.getDatabaseProductName());
            System.out.println("Product version: " + dm.getDatabaseProductVersion());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Meas> queryMeas(String measuringPoint)  {
        List<Meas> list = new ArrayList<>();
        System.out.println("Получение данных из СУБД");
        String query = "SELECT * FROM measurements";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                if (measuringPoint.equals(resultSet.getString("MeasuringPoint"))) {
                    list.add(new Meas(
                            resultSet.getInt("id"),
                            resultSet.getString("UnitSymbol"),
                            resultSet.getString("UnitMultiplier"),
                            resultSet.getDouble("NormalValue"),
                            resultSet.getDouble("Value"),
                            resultSet.getTimestamp("RegisterDateTime"),
                            resultSet.getString("EquipmentName"),
                            resultSet.getString("MeasuringPoint"),
                            resultSet.getString("PhaseCode"),
                            resultSet.getString("SmartMeterID")
                    ));
                }
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<EquipmentDB> queryEquip(String measuringPoint) {
        List<EquipmentDB> list = new ArrayList<>();
        System.out.println("Получение данных из СУБД");
        String query = "SELECT * FROM equipments";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                if (measuringPoint.equals(resultSet.getString("SubstationName"))) {
                    list.add(new EquipmentDB(
                            resultSet.getInt("id"),
                            resultSet.getString("EquipmentName"),
                            resultSet.getString("EquipmentID"),
                            resultSet.getString("substationName"),
                            resultSet.getString("description"),
                            resultSet.getString("baseVoltage")
                    ));
                }
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void disconnectionDB() {
        try {
            connection.close();
            System.out.println("Отключение от СУБД выполнено.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

