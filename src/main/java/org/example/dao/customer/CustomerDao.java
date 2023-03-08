package org.example.dao.customer;

import org.example.dao.CRUDDao;
import org.example.model.entity.Customer;

import java.util.Optional;

public class CustomerDao implements CRUDDao<Customer, Long> {
    public Optional<Customer> findById(Long id) {
        return Optional.empty();
    }

    public Customer save(Customer entity) {
        return null;
    }

    public Customer update(Customer entity) {
        return null;
    }

    public Customer delete(Customer entity) {
        return null;
    }
}
