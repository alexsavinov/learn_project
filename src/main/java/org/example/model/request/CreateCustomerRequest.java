package org.example.model.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateCustomerRequest {
    private String name;
}
