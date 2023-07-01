package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

public class Main {
    public static void main(String[] args) {
//       UserDaoJDBCImpl usd = new UserDaoJDBCImpl();
//        usd.createUsersTable();
//        usd.saveUser("BB", "VV", (byte) 38);
//        usd.saveUser("XX", "CC", (byte) 35);
//        usd.saveUser("ZZ", "NN", (byte) 41);
//        usd.saveUser("HH", "LL", (byte) 29);
//        usd.removeUserById(4);
//        usd.getAllUsers();
 //       usi.cleanUsersTable();
  //      usi.dropUsersTable();

        UserServiceImpl usi = new UserServiceImpl();
        usi.createUsersTable();
        usi.saveUser("vv", "rr", (byte) 38);
        usi.saveUser("nn", "tt", (byte) 35);
        usi.saveUser("mm", "yy", (byte) 41);
        usi.saveUser("kk", "uu", (byte) 29);
        usi.removeUserById(4);
        System.out.println(usi.getAllUsers());
        usi.cleanUsersTable();
        usi.dropUsersTable();


    }
}
