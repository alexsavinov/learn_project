package org.example.service.customer;

import org.example.dao.customer.CustomerDao;
import org.example.model.entity.Customer;
import org.example.model.request.CreateCustomerRequest;
import org.example.service.mapper.CustomerMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerServiceImplTest {

    @Mock
    private CustomerMapper customerMapper;
    @Mock
    private CustomerDao customerDao;
    @InjectMocks
    private CustomerServiceImpl subject;

    @Test
    void create() {
        CreateCustomerRequest request = CreateCustomerRequest.builder()
                .name("name")
                .build();

        Customer customer = Customer.builder()
                .name("name")
                .build();

        Customer createdCustomer = Customer.builder()
                .id(1L)
                .name("name")
                .build();

        when(customerMapper.mapToCustomer(any(CreateCustomerRequest.class))).thenReturn(customer);
        when(customerDao.save(any(Customer.class))).thenReturn(createdCustomer);

        Customer actual = subject.save(request);

        verify(customerMapper).mapToCustomer(request);
        verify(customerDao).save(customer);
        verifyNoMoreInteractions(customerMapper, customerDao);

        // additionally, there's
        // verifyNoInteractions();

        assertThat(actual).isEqualTo(createdCustomer);

    }

    @Test
    void findById() {
    }
}