package com.Ecommerce.Customer.Model.Entity;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Validated
public class Address {
    private String street;
    private String hauseNumber;
    private String zipCode;
}
