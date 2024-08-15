package com.Ecommerce.Customer.Model.Response;

import com.Ecommerce.Customer.Model.Address;

public record CustomerRsponse(
        String id,
        String firstName,
        String lastName,

        String email,
        Address address) {
}
