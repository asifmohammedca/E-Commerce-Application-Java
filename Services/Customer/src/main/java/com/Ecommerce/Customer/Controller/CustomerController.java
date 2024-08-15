package com.Ecommerce.Customer.Controller;

import com.Ecommerce.Customer.Model.Request.CustomerRequest;
import com.Ecommerce.Customer.Service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.Ecommerce.Customer.Model.Response.CustomerRsponse;

import java.util.List;

@RestController
@RequestMapping(value = "api/customer")
@RequiredArgsConstructor
@Slf4j
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<String> createCustomer(@RequestBody @Valid CustomerRequest customerRequest) {
        return ResponseEntity.ok(customerService.createCustomer(customerRequest));
    }

    @PutMapping
    public ResponseEntity<Void> updateCustomer(@RequestBody @Valid CustomerRequest customerRequest) {
        customerService.updateCustomer(customerRequest);
        return ResponseEntity.accepted().build();
    }

    @GetMapping
    public ResponseEntity<List<CustomerRsponse>> getAllCustomers() {
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    @GetMapping("/exists/{customerId}")
    public ResponseEntity<Boolean> existsById(@PathVariable("customerId") String id) {
        return ResponseEntity.ok(customerService.existsById(id));
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerRsponse> findCustomerById(@PathVariable("customerId") String id) {
        return ResponseEntity.ok(customerService.findByCustomerId(id));
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<Void> deleteCustomerById(@PathVariable("customerId") String id) {
        customerService.deleteCustomerById(id);
        return ResponseEntity.accepted().build();
    }

}
