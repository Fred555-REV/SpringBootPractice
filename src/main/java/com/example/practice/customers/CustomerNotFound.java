package com.example.practice.customers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomerNotFound extends RuntimeException {
    public CustomerNotFound() {
        super("Customer Not Found");
    }

    public CustomerNotFound(String message) {
        super(message);
    }
}
