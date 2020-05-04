package com.bookstore.daoimpl;

import com.bookstore.common.HibernateUtils;
import com.bookstore.dao.GenericDAO;
import org.hibernate.*;

import java.awt.*;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

public class AbstractDAO<ID extends Serializable, T> implements GenericDAO<ID, T> {
    private Class<T> persistenceClass;

    public AbstractDAO() {
        this.persistenceClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    private String getPersistenceClassName() {
        return persistenceClass.getSimpleName();
    }


    public List<T> findAll() {
        List<T> list;
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Query query = session.createQuery("from " + this.getPersistenceClassName());
            list = query.list();
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
        return list;
    }

    public T update(T entity) {
        T results;
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Object obj = session.merge(entity);
            results = (T) obj;
            transaction.commit();
        } catch (HeadlessException e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
        return results;
    }

    public T save(T entity) {
        T results;
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {

            session.persist(entity);
            transaction.commit();
            results = (T) entity;

        } catch (HeadlessException e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
        return results;
    }

    public T findByID(ID id) {
        T results;
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            results = (T) session.get(persistenceClass, id);
            if (results == null) {
                throw new ObjectNotFoundException("NOT FUOND " + id, null);
            }
            transaction.commit();
        } catch (HeadlessException e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
        return results;
    }

    public Object[] findByProperty(Map<String, Object> property, Boolean exact, String whereClause) {
        List<T> list;
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Object totalItem = 0;
        Object[] nameQuery = HibernateUtils.buildNameQuery(property, exact);
        try {
            StringBuilder sql = new StringBuilder("FROM ");
            sql.append(getPersistenceClassName()).append(" WHERE 1=1 ").append(nameQuery[0]);
            if (whereClause != null) {
                sql.append(whereClause);
            }
            Query query = session.createQuery(sql.toString());
            query = setParameterToQuery(nameQuery, query, exact);

            list = query.list();
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
        return new Object[]{totalItem, list};
    }

    private Query setParameterToQuery(Object[] nameQuery, Query query, Boolean exact) {
        if (nameQuery.length == 3) {
            String[] params = (String[]) nameQuery[1];
            Object[] values = (Object[]) nameQuery[2];
            if(exact){
                for (int i = 0; i < params.length ; i++) {
                    query.setParameter(params[i], values[i].toString());
                }
            }else {
                for (int i = 0; i < params.length ; i++) {
                    query.setParameter(params[i], values[i]);
                }
            }
        }
        return query;
    }

    public Integer delete(List<ID> ids) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Integer count = 0;
        try {
            for (ID item : ids) {
                T t = (T) session.get(persistenceClass, item);
                session.delete(t);
                count++;
            }
            transaction.commit();
        } catch (HeadlessException e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
        return count;
    }

//    public T findEqualUnique(String property, Object value) {
//        return null;
//    }
}
