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

    @GetMapping("/")
    public String root(){
        String output = "Hello, the possible routes are:\n" +
                "/employees\t- to get all employees\n" +
                "/employee?firstname=(enter first name here)&lastName=(enter last name here)\t - to create and add an employee\n" +
                "/employee/{name}\t- to get an employee with that name or a list of employees with the same name\n" +
                "/employee/{name}/{id}\t - to get a specific employee with that name and id";
        String html = output.replaceAll("(\n)","<br>");
        return html;
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
    public Employee addEmployee(@RequestParam(value = "firstName", defaultValue = "firstName") String firstName, @RequestParam(value = "lastName", defaultValue = "lastName") String lastName) {
        return employeeService.addEmployee(firstName, lastName);
    }

    @GetMapping("/employee/{name}/{id}")
    public Employee getEmployee(@PathVariable(value = "name") String name, @PathVariable(value = "id") Long id) {
        return employeeService.getEmployee(name, id);
    }
}
