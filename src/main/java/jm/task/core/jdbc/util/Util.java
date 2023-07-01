package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import jm.task.core.jdbc.model.User;

import javax.persistence.Transient;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Driver;

public class Util {
    private static final String URL = "jdbc:mysql://localhost:3306/db_new?autoReconnect=true&useSSL=false";
    private static final String USERNAME = "root";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String PASSWORD = "lipa89045902465";

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
