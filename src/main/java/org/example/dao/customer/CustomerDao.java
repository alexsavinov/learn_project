package org.example.dao.customer;

import org.example.dao.CRUDDao;
import org.example.model.db.DBManager;
import org.example.model.entity.Customer;
import org.hibernate.Session;

import java.util.Optional;

public class CustomerDao implements CRUDDao<Customer, Long> {

    private static DBManager dbManager;

    public CustomerDao() {
        dbManager = DBManager.getInstance();
    }

    public Optional<Customer> findById(Long id) {
        Session session = dbManager.getSession();
        Customer customer = session.byId(Customer.class).load(id);
        dbManager.closeSession(session);

        return Optional.ofNullable(customer);
    }

    public Customer save(Customer entity) {
        Session session = dbManager.getSession();
        Long id = (Long) session.save(entity);
        entity.setId(id);
        dbManager.closeSession(session);

        return entity;
    }

    public Customer update(Customer entity) {
        Session session = dbManager.getSession();
        session.update(entity);
        dbManager.closeSession(session);

        return entity;
    }

    public Customer delete(Customer entity) {
        Session session = dbManager.getSession();
        session.delete(entity);
        dbManager.closeSession(session);

        return entity;
    }
}
