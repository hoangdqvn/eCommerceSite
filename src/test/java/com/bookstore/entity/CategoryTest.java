package com.bookstore.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class CategoryTest {

    public static void main(String[] args) {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setName("Programming");

        Configuration configuration = new Configuration().configure();
        configuration.addAnnotatedClass(CategoryEntity.class);
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
        Session session = sessionFactory.openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(categoryEntity);
        tx1.commit();
        session.close();
    }
}
