package org.example.service.customer;

import org.example.model.entity.Customer;
import org.example.model.request.CreateCustomerRequest;

public interface CustomerService {
    Customer save(CreateCustomerRequest createRequest);
    Customer findById(Long id);
}
