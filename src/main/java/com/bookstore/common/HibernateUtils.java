package com.bookstore.common;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.Map;

public class HibernateUtils {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            return configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static Object[] buildNameQuery(Map<String, Object> property, Boolean exact) {
        StringBuilder nameQuery = new StringBuilder();
        if (property != null && property.size() > 0) {
            String[] params = new String[property.size()];
            Object[] values = new Object[property.size()];
            int i = 0;
            for (Map.Entry item : property.entrySet()) {
                params[i] = (String) item.getKey();
                values[i] = item.getValue();
                i++;
            }
            if(exact){
                for (String param : params) {
                    nameQuery.append(" AND ").append(" str(").append(param).append(") LIKE :").append(param).append(" ");
                }
            }else {
                for (String param : params) {
                    nameQuery.append(" AND ").append(" LOWER(").append(param).append(") LIKE '%' || :").append(param).append(" || '%' ");
                }
            }
            return new Object[]{nameQuery, params, values};
        }
        return new Object[]{nameQuery.toString()};
    }
}
