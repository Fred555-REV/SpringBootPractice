package com.example.practice.customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService service;

    @GetMapping
    public List<Customer> getCustomers() {
        return service.getCustomers();
    }

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable Long id) {
        Customer customer = service.getCustomer(id);
        if (customer == null)
            throw new CustomerNotFound("Customer with given id not found");
        return customer;
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        if (!service.deleteCustomer(id))
            throw new CustomerNotFound("Customer with given id not found");
    }

    @PostMapping("/{id}")
    public Customer addCustomer(@RequestBody Customer customer) {
        return addCustomer(customer);
    }

    @PutMapping("/{id}")
    public Customer updateCustomer(@RequestBody Customer newCustomer, @PathVariable Long id) {
        return updateCustomer(newCustomer, id);
    }
}
