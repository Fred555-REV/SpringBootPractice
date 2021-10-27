package com.example.practice.employees;

import java.util.concurrent.atomic.AtomicLong;

public class Employee {
    private final Long id;
    private final String name;

    public Employee(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }
}
