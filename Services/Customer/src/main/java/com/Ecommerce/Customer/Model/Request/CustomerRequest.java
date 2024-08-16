package com.Ecommerce.Customer.Model.Request;

import com.Ecommerce.Customer.Model.Entity.Address;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record CustomerRequest(
        String id,
        @NotNull(message = "First Name is required")
        String firstName,
        String lastName,
        @NotNull(message = "Email is required")

        @Email(message = "Email is not valid")
        String email,
        Address address) {
}
