package ua.nure.kibkalo.database;

import java.sql.*;

public class ConnectionDB {

    /*Метод для получение соединения с базой данных, возвращает объект-соединение Connection*/
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/autoproject", "root", "root");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
