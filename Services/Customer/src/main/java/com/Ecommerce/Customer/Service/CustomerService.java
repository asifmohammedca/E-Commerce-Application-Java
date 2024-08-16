package com.Ecommerce.Customer.Service;

import com.Ecommerce.Customer.Component.CustomerMapper;
import com.Ecommerce.Customer.Exception.CustomerNotFoundException;
import com.Ecommerce.Customer.Model.Entity.Customer;
import com.Ecommerce.Customer.Model.Request.CustomerRequest;
import com.Ecommerce.Customer.Model.Response.CustomerRsponse;
import com.Ecommerce.Customer.Repository.CustomerRepository;
import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public String createCustomer(CustomerRequest customerRequest) {
        var customer = customerRepository.save(customerMapper.toCustomer(customerRequest));
        return customer.getId();
    }

    public void updateCustomer(CustomerRequest customerRequest) {
        var customer = customerRepository.findById(customerRequest.id())
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found"));
        customerUpdate(customer, customerRequest);
        customerRepository.save(customer);
    }

    private void customerUpdate(Customer customer, CustomerRequest customerRequest) {
        if (StringUtils.isNotBlank(customerRequest.firstName())) {
            customer.setFirstName(customerRequest.firstName());
        }
        if (StringUtils.isNotBlank(customerRequest.lastName())) {
            customer.setLastName(customerRequest.lastName());
        }
        if (StringUtils.isNotBlank(customerRequest.email())) {
            customer.setEmail(customerRequest.email());
        }
        if (customerRequest.address() != null) {
            customer.setAddress(customerRequest.address());
        }

    }

    public List<CustomerRsponse> getAllCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(customerMapper::fromCustomerEntity)
                .collect(Collectors.toList());
    }

    public Boolean existsById(String id) {
        return customerRepository.existsById(id);
    }

    public CustomerRsponse findByCustomerId(String id) {
        return customerRepository.findById(id)
                .map(customerMapper::fromCustomerEntity)
                .orElseThrow(() -> new CustomerNotFoundException(("Customer not found")));
    }

    public void deleteCustomerById(String id) {
        customerRepository.deleteById(id);
    }
}
