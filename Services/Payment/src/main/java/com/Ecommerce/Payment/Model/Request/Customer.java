package com.Ecommerce.Payment.Model.Request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

@Validated
public record Customer(
        String id,
        @NotNull(message = "FirstName is required")
        String firstName,
        @NotNull(message = "LastName is required")
        String lastName,
        @NotNull(message = "Email is required")
        @Email(message = "Enter valid Email address")
        String email
) {
}
