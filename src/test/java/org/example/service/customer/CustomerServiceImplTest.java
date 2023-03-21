package org.example.service.customer;

import org.example.dao.customer.CustomerDao;
import org.example.exception.EntityNotFoundException;
import org.example.model.entity.Customer;
import org.example.model.request.CreateCustomerRequest;
import org.example.service.mapper.CustomerMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerServiceImplTest {


    @Captor
    private ArgumentCaptor<Long> idArgumentCaptor;
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
        Customer searchedCustomer = Customer.builder()
                .id(1L)
                .name("name")
                .build();

        when(customerDao.findById(any(Long.class))).thenReturn(Optional.of(searchedCustomer));

        Customer actual = subject.findById(1L);

        verify(customerDao).findById(idArgumentCaptor.capture());

        assertThat(idArgumentCaptor.getValue()).isEqualTo(1L);

        verifyNoMoreInteractions(customerMapper, customerDao);

        assertThat(actual).isEqualTo(searchedCustomer);
    }

    @Test
    void findByIdFail() {
        EntityNotFoundException thrown = assertThrows(
                EntityNotFoundException.class,
                () -> subject.findById(1L),
                "Customer with id 1 is not found"
        );

        assertThat(thrown.getMessage().contentEquals("Customer with id 1 is not found"));
    }
}