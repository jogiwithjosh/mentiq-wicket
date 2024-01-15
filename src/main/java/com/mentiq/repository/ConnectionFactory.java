package com.mentiq.repository;

import com.mentiq.entity.Activity;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class ConnectionFactory {
    private static SessionFactory sessionFactory = null;
    private static Object mutex = new Object();

    private ConnectionFactory() {

    }

    public static SessionFactory getSessionFactory() {
        synchronized (mutex) {
            if (sessionFactory == null) {
                Configuration configuration = new Configuration();

                configuration.setProperty("connection.driver_class","org.postgresql.Driver");
                configuration.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/tests");
                configuration.setProperty("hibernate.connection.username", "postgres");
                configuration.setProperty("hibernate.connection.password", "postgres");
                configuration.setProperty("dialect", "org.hibernate.dialect.PostgreSQLDialect");
                configuration.setProperty("hibernate.hbm2ddl.auto", "update");
                configuration.setProperty("show_sql", "true");
                configuration.setProperty(" hibernate.connection.pool_size", "10");
                configuration.addAnnotatedClass(Activity.class);

                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
            }
            return sessionFactory;
        }
    }
}
