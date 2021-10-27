package com.example.practice.employees;

import java.util.concurrent.atomic.AtomicLong;

public class Employee {
    private final Long id;
    private final String firstName;
    private final String lastName;

    public Employee(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Long getId() {
        return id;
    }
}
