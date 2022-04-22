package sample;

import java.sql.*;

public class WeatherDAO {
    public static Connection getConnection(String nameDB) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/" + nameDB;
        String user = "root";
        String password = "root";

        Connection connection = DriverManager.getConnection(url, user, password);
        return connection;
    }

    public static ResultSet query(Connection connection, String sql) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        return resultSet;
    }
}
