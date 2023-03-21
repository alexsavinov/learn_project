package org.example.service.mapper;

import org.example.model.entity.Customer;
import org.example.model.request.CreateCustomerRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class CustomerMapperTest {

    private CustomerMapper subject;

    @BeforeEach
    void setUp() {
        subject = new CustomerMapper();
    }

    @Test
    void mapToCustomer() {
        CreateCustomerRequest request = CreateCustomerRequest.builder().build();
        request.setName("name");

        Customer customer = Customer.builder()
                .name("name")
                .build();

        Customer actual = subject.mapToCustomer(request);

        assertThat(actual).isEqualTo(customer);
    }

}
