package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        Statement statement = null;

        try  {
            Connection connection = Util.getConnection();
            System.out.println("Connected database successfully...");
            statement = connection.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS UsersTable" +
                    "(id INTEGER NOT NULL PRIMARY KEY  AUTO_INCREMENT, " +
                    " name VARCHAR(255), " +
                    " lastname VARCHAR(255), " +
                    " age INTEGER " +
                    " )";
            statement.executeUpdate(sql);
            System.out.println("DataBase is created!");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error create!");
        }

    }

    public void dropUsersTable() {
        Statement statement = null;
        try {
            Connection connection = Util.getConnection();
            System.out.println("Connected database successfully...");
            statement = connection.createStatement();
            String sqlDrop = "DROP TABLE UsersTable";
            statement.executeUpdate(sqlDrop);
            System.out.println("DataBase is delete!");
        } catch (SQLException e) {
            System.out.println("Error drop");
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {

        //Statement statement = null;
        //String name1 = null;
        try  {
            Connection connection = Util.getConnection();
            System.out.println("Connected database successfully...");
            User user = new User(name, lastName, age);
            String sqlSaveUser = "INSERT INTO UsersTable (name, lastname, age) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sqlSaveUser);
            statement.setString(1, user.getName());
            statement.setString(2, user.getLastName());
            statement.setByte(3, user.getAge());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new user was inserted successfully!");
            }
            System.out.println("User is added!");
        } catch (SQLException e) {
            System.out.println("Error save");
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        String sql = "DELETE FROM  UsersTable WHERE id = ?";

        User user = new User();
        user.setId(id);
        String strId = Long.toString(user.getId());

        try {
            Connection connection = Util.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, strId);

            preparedStatement.executeUpdate();
            System.out.println("User is remove!");
        } catch (SQLException e) {
            System.out.println("Error remove");
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        String sql = "SELECT id, name, lastname, age FROM UsersTable";

        List<User> userList = new ArrayList<>();

        Statement statement = null;

        try (Connection connection = Util.getConnection()) {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastname"));
                user.setAge(resultSet.getByte("age"));

                userList.add(user);
            }
            System.out.println("Get all!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error get all!");
        }
        userList.toString();
        return userList;
    }

    public void cleanUsersTable() {
        String sql = "DELETE FROM  UsersTable";


        try (Connection connection = Util.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
            System.out.println("Table is clean!");
        } catch (SQLException e) {
            System.out.println("Error clean");
            e.printStackTrace();
        }
    }
}
