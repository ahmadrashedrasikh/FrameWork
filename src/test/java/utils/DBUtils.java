package utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DBUtils {

    static Connection connection;
    static ResultSet resultSet;

    public static Connection setConnections() {
        try {
            connection = DriverManager.getConnection(ConfigReader.getPropValue("dbUrl"),
                    ConfigReader.getPropValue("dbUsername"), ConfigReader.getPropValue("dbPassword"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static ResultSet getResultSet(String sqlQuery) {

        try {
            resultSet = setConnections().createStatement().executeQuery(sqlQuery);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public static List<Map<String, String>> getListOfMaps(String sqlQuery) {

        List<Map<String, String>> listMap = new ArrayList<>();
        Map<String, String> rowMap;

        try {
            ResultSetMetaData metaData = resultSet.getMetaData();

            while (resultSet.next()) {
                rowMap = new LinkedHashMap<>();

                for (int i = 1; i <= metaData.getColumnCount(); i++) {

                    rowMap.put(metaData.getColumnName(i), resultSet.getString(i));
                }
                listMap.add(rowMap);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listMap;
    }

    public static Map<String, String> getMapFromDB(String sqlQuery) {

        Map<String, String> rowMap = new LinkedHashMap<>();

        try {
            resultSet = getResultSet(sqlQuery);
            ResultSetMetaData metaData = resultSet.getMetaData();


            while (resultSet.next()) {

                for (int i = 1; i <= metaData.getColumnCount(); i++) {

                    rowMap.put(metaData.getColumnName(i), resultSet.getString(i));
                }
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowMap;
    }
}
