package org.example;

import lombok.extern.slf4j.Slf4j;
import org.example.dao.customer.CustomerDao;
import org.example.model.entity.Customer;
import org.example.model.request.CreateCustomerRequest;
import org.example.service.customer.CustomerService;
import org.example.service.customer.CustomerServiceImpl;
import org.example.service.mapper.CustomerMapper;

/**
 * Hello world!
 */
@Slf4j
public class App {
    public static void main(String[] args) {
        CustomerMapper customerMapper = new CustomerMapper();
        CustomerDao customerDao = new CustomerDao();
        CustomerService customerService = new CustomerServiceImpl(customerDao, customerMapper);

        // do the logic
        Customer customer = customerService.save(CreateCustomerRequest.builder().name("uuuuu1").build());
        log.info(customer.toString());

        Customer customer1 = customerService.findById(1L);
        log.info(customer1.toString());
    }
}
