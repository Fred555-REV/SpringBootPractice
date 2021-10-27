package com.example.practice.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    @GetMapping("/employee/{name}")
    public List<Employee> getEmployee(@PathVariable(value = "name") String name) {
        return employeeService.getEmployee(name);
    }

    @GetMapping("/employee")
    public Employee addEmployee(@RequestParam(value = "name", defaultValue = "Name") String name) {
        return employeeService.addEmployee(name);
    }

    @GetMapping("/employee/{name}/{id}")
    public Employee getEmployee(@PathVariable(value = "name") String name, @PathVariable(value = "id") Long id) {
        return employeeService.getEmployee(name, id);
    }
}
