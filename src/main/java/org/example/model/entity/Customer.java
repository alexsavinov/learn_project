package org.example.model.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Customer {

    private Long id;
    private String name;

}
