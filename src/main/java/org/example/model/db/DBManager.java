package org.example.model.db;

import org.example.model.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class DBManager {
    private static DBManager instance;
    protected static SessionFactory sessionFactory;

    private DBManager() {
        StandardServiceRegistry serviceRegistry =
                new StandardServiceRegistryBuilder()
                        .configure("hibernate.cfg.xml")
                        .build();

        Metadata metadata =
                new MetadataSources(serviceRegistry)
                        .addAnnotatedClass(Customer.class)
                        .getMetadataBuilder()
                        .build();

        sessionFactory = metadata.getSessionFactoryBuilder().build();
    }

    /**
     * Returns an instance of DB Manager.
     *
     * @return DBManager
     */
    public static synchronized DBManager getInstance() {
        if (instance == null) {
            instance = new DBManager();
        }
        return instance;
    }

    public SessionFactory getConnection() {
        return sessionFactory;
    }

    public Session getSession() {
        return getConnection().openSession();
    }

    public void closeSession(Session session) {
        if (session != null) {
            session.close();
        }
    }

    public void beginTransaction(Session session) {
        if (session != null) {
            session.beginTransaction();
        }
    }

    public void commitTransaction(Session session) {
        if (session != null) {
            Transaction transaction = session.getTransaction();
            if (transaction != null) {
                transaction.commit();
            }
        }
    }

}
