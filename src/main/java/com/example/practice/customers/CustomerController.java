package com.example.practice.customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService service;

    @GetMapping
    public List<Customer> getCustomers() {
        return service.getCustomers();
    }

    @GetMapping("/search/{firstName}")
    public List<Customer> getCustomersByFirstName(@PathVariable String firstName) {
        return service.getCustomersByFirstName(firstName);
    }

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable Long id) {
        return service.getCustomer(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        service.deleteCustomer(id);
    }

    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer) {
        return service.addCustomer(customer);
    }

    @PutMapping("/{id}")
    public Customer updateCustomer(@RequestBody Customer newCustomer, @PathVariable Long id) {
        return service.updateCustomer(newCustomer, id);
    }
}
