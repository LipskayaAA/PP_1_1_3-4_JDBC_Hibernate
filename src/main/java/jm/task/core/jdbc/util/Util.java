package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Driver;

public class Util {
//    private final String URL = "jdbc:mysql://localhost:3306/db_new";
//    private final String USERNAME = "root";
//    private final String PASSWORD = "lipa89045902465";

    public static Connection getConnection() {

         final String URL = "jdbc:mysql://localhost:3306/db_new";
         final String USERNAME = "root";
         final String PASSWORD = "lipa89045902465";
        Connection connection = null;

        try {
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Connection OK!");

        } catch (SQLException e) {
            System.out.println("Connection ERROR!");
        }
        return connection;
    }
}
