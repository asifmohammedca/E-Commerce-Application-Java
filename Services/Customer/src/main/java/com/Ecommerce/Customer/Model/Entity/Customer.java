package com.Ecommerce.Customer.Model.Entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Document
public class Customer {
    @Id
    private String id;
    @NotNull
    private String firstName;
    private String lastName;
    @Email
    @Indexed(unique=true)
    private String email;
    private Address address;
}
