package com.example.practice.employees;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class EmployeeService {
    private final AtomicLong atomicLong = new AtomicLong();
    public List<Employee> employees = new ArrayList<>();

    {
        //When you get an employee by name it gets the first one with that name
        //TODO add something to get the correct person
        // maybe getEmployee(name) returns a list of ppl with same name then you choose the one with your ID number
        employees.add(new Employee(atomicLong.incrementAndGet(), "Freddy"));
        employees.add(new Employee(atomicLong.incrementAndGet(), "ExampleName"));
        employees.add(new Employee(atomicLong.incrementAndGet(), "Freddy"));
    }

    public EmployeeService() {
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public Employee getEmployee(String name) {
        for (Employee employee : employees) {
            if (employee.getName().equals(name)) {
                return employee;
            }
        }
        //TODO create exception handler for nulls
        return null;
    }
}
