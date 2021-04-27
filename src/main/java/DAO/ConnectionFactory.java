package DAO;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {

    public static final String URL = "jdbc:mysql://localhost:3306/db_kinorate";
    public static final String USER = "root";
    public static final String PASSWORD = "root";

    public static Connection getConnection() throws ClassNotFoundException {
        try {
            //DriverManager.registerDriver();
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
        }
        return null;
    }
}
