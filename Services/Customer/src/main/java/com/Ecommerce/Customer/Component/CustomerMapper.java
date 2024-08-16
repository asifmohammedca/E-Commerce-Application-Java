package com.Ecommerce.Customer.Component;

import com.Ecommerce.Customer.Model.Entity.Customer;
import com.Ecommerce.Customer.Model.Request.CustomerRequest;
import com.Ecommerce.Customer.Model.Response.CustomerRsponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CustomerMapper {
    public Customer toCustomer(CustomerRequest customerRequest) {
        if (customerRequest == null) {
            log.warn("Customer request is Empty");
            return Customer.builder().build();
        }
        return Customer.builder()
                .id(customerRequest.id())
                .firstName(customerRequest.firstName())
                .lastName(customerRequest.lastName())
                .email(customerRequest.email())
                .address(customerRequest.address())
                .build();

    }

    public CustomerRsponse fromCustomerEntity(Customer customer) {
        return new CustomerRsponse(
                customer.getId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail(),
                customer.getAddress()
        );
    }
}
