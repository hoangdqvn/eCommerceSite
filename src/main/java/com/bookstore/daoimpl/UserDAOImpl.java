package com.bookstore.daoimpl;

import com.bookstore.common.HibernateUtils;
import com.bookstore.dao.UserDAO;
import com.bookstore.entity.UserEntity;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserDAOImpl extends AbstractDAO<Integer, UserEntity> implements UserDAO {
    public UserEntity isUserExist(String email, String password) {
        UserEntity entity = new UserEntity();
        Transaction transaction;
        Session session = HibernateUtils.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        try {
            Query query = session.createQuery("FROM UserEntity WHERE email= :email AND password= :password");
            query.setParameter("email", email);
            query.setParameter("password", password);
            entity = (UserEntity) query.uniqueResult();
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return entity;
    }
}
