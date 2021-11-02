package com.example.practice.customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository repository;

    public Customer getCustomer(Long id) {
        return repository.getById(id);
    }

    public List<Customer> getCustomers() {
        return repository.findAll();
    }

    public Boolean deleteCustomer(Long id) {
        repository.deleteById(id);
        return repository.findById(id).isPresent();
    }

    public Customer addCustomer(Customer customer) {
        repository.save(customer);
        return customer;
    }

    public Customer updateCustomer(Customer newCustomer, Long id) {
        return repository.findById(id).map(customer -> {
            if (newCustomer.getFirstName() != null)
                customer.setFirstName(newCustomer.getFirstName());
            if (newCustomer.getLastName() != null)
                customer.setLastName(newCustomer.getLastName());
            return repository.save(customer);
        }).orElseGet(() -> repository.save(newCustomer));
    }

}
