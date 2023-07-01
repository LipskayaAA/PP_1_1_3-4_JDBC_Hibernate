package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

public class Main {
    public static void main(String[] args) {
       UserServiceImpl usi = new UserServiceImpl();
        usi.createUsersTable();
        usi.saveUser("BB", "VV", (byte) 38);
        usi.saveUser("XX", "CC", (byte) 35);
        usi.saveUser("ZZ", "NN", (byte) 41);
        usi.saveUser("HH", "LL", (byte) 29);
        usi.removeUserById(4);
        usi.getAllUsers();
        usi.cleanUsersTable();
        usi.dropUsersTable();

    }
}
