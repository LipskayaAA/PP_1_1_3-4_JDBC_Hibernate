package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserDaoHibernateImpl implements UserDao {
    private EntityManager entityManager;
    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable() {
       
    }

    @Override
    public void dropUsersTable() {
      

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        

    }

    @Override
    public void removeUserById(long id) {
        
    }



    @Override
    public List<User> getAllUsers() {
       
    }

    @Override
    public void cleanUsersTable() {
        
    }
}
