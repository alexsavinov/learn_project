package org.example.service.customer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.dao.customer.CustomerDao;
import org.example.exception.EntityNotFoundException;
import org.example.model.entity.Customer;
import org.example.model.request.CreateCustomerRequest;
import org.example.service.mapper.CustomerMapper;


/**
 * A service to work with {@link Customer}.
 */
@Slf4j
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerDao customerDao;
    private final CustomerMapper customerMapper;

    /**
     * Saves a customer.
     *
     * @param createRequest {@link CreateCustomerRequest} create request
     * @return {@link Customer} created customer
     */
    public Customer save(CreateCustomerRequest createRequest) {
        Customer customer = customerMapper.mapToCustomer(createRequest);
        return customerDao.save(customer);
    }

    /**
     * Finds a {@link Customer} by its id.
     *
     * @param id customer id
     * @return {@link Customer} customer
     * @throws EntityNotFoundException if a customer with a given id doesn't exist
     */
    public Customer findById(Long id) {
        log.info("Looking for a customer with id {}", id);

        return customerDao.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Customer with id " + id + " is not found"));
    }
}
