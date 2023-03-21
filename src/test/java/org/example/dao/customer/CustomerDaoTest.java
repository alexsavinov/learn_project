package org.example.dao.customer;

import org.example.model.db.DBManager;
import org.example.model.entity.Customer;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

// TODO: for testing DAO, use in-memory H2 database or a separate DB instance for testing.
class CustomerDaoTest {

    protected static DBManager dbManager;
    protected static Session session;
    private static Customer customerTest;

    @BeforeEach
    void setUp() {
        dbManager = DBManager.getInstance();
        customerTest = Customer.builder().name("Customer Test").build();

        session = dbManager.getSession();
        session.save(customerTest);
        dbManager.closeSession(session);
    }

    @Test
    void findById() {
        session = dbManager.getSession();
        Query query = session.createQuery("select c from Customer c where name = :name");
        query.setParameter("name", customerTest.getName());
        Customer customerSearch = (Customer) query.list().get(0);
        dbManager.closeSession(session);

        CustomerDao customerDao = new CustomerDao();
        Customer customer = customerDao.findById(customerSearch.getId()).get();

        assertNotNull(customer);
        assertThat(customer).hasSameClassAs(customerTest);
    }

    @Test
    void save() {
        String nameNew = "New name";
        Customer customerNew = Customer.builder().name(nameNew).build();

        CustomerDao customerDao = new CustomerDao();
        Customer customer = customerDao.save(customerNew);

        assertNotNull(customer);
        assertThat(customer).hasSameClassAs(customerTest);
        assertThat(customer.getId()).isPositive();
        assertThat(customer.getName()).isEqualTo(nameNew);
    }

    @Test
    void update() {
        session = dbManager.getSession();
        Query query = session.createQuery("select c from Customer c where name = :name");
        query.setParameter("name", customerTest.getName());
        Customer customerSearch = (Customer) query.list().get(0);
        dbManager.closeSession(session);

        String nameNew = "New name";
        customerSearch.setName(nameNew);

        CustomerDao customerDao = new CustomerDao();
        Customer customer = customerDao.update(customerSearch);

        assertNotNull(customer);
        assertThat(customer).hasSameClassAs(customerTest);
        assertThat(customer.getName()).isEqualTo(nameNew);
    }

    @Test
    void delete() {
        session = dbManager.getSession();
        Query query = session.createQuery("select c from Customer c where name = :name");
        query.setParameter("name", customerTest.getName());
        Customer customerSearch = (Customer) query.list().get(0);
        dbManager.closeSession(session);

        CustomerDao customerDao = new CustomerDao();
        Customer customer = customerDao.delete(customerSearch);

        assertNotNull(customer);
        assertThat(customer).hasSameClassAs(customerTest);
        assertThat(customer.getName()).isEqualTo(customerTest.getName());
    }

    @AfterEach
    void cleanUp() {
        session = dbManager.getSession();
        dbManager.beginTransaction(session);
        session.createQuery("delete from Customer").executeUpdate();
        dbManager.commitTransaction(session);
        dbManager.closeSession(session);
    }

}