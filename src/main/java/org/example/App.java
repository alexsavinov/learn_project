package org.example;

import org.example.dao.customer.CustomerDao;
import org.example.service.customer.CustomerService;
import org.example.service.customer.CustomerServiceImpl;
import org.example.service.mapper.CustomerMapper;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        CustomerMapper customerMapper = new CustomerMapper();
        CustomerDao customerDao = new CustomerDao();
        CustomerService customerService = new CustomerServiceImpl(customerDao, customerMapper);

        // do the logic
    }
}
