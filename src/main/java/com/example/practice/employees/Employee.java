package com.example.practice.employees;

import java.util.concurrent.atomic.AtomicLong;

public class Employee {
    private final AtomicLong id;
    private final String name;

    public Employee(AtomicLong id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public AtomicLong getId() {
        return id;
    }
}
