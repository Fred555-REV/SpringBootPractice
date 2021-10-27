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
        employees.add(new Employee(atomicLong.incrementAndGet(), "Freddy"));
        employees.add(new Employee(atomicLong.incrementAndGet(), "ExampleName"));
        employees.add(new Employee(atomicLong.incrementAndGet(), "Freddy"));
    }

    public EmployeeService() {
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public List<Employee> getEmployee(String name) {
        List<Employee> sameNameEmployee = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getName().equals(name)) {
                sameNameEmployee.add(employee);
            }
        }
        return sameNameEmployee;
    }

    public Employee getEmployee(String name, Long id) {
        for (Employee employee : employees) {
            if (employee.getName().equals(name) && employee.getId().equals(id)) {
                return employee;
            }
        }
        //TODO create exception handler for nulls
        return null;
    }

    public Employee addEmployee(String name) {
        Employee employee = new Employee(atomicLong.incrementAndGet(), name);
        employees.add(employee);
        return employee;
    }
}
