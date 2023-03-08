package org.example.service.mapper;

import org.example.model.entity.Customer;
import org.example.model.request.CreateCustomerRequest;

public class CustomerMapper {
    public Customer mapToCustomer(CreateCustomerRequest request) {
        return Customer.builder()
                .name(request.getName())
                .build();
    }
}
