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
    public String root() {
        String output = "Hello, the possible routes are:\n" +
                "/employees\t- to get all employees\n" +
                "/employee?firstname=(enter first name here)&lastName=(enter last name here)\t - to create and add an employee\n" +
                "/employee/{name}\t- to get an employee with that name or a list of employees with the same name\n" +
                "/employee/{name}/{id}\t - to get a specific employee with that name and id\n" +
                "/vehicles - to get all vehicles\n" +
                "/vehicles/sort - to sort by make and ?make={make} to search by make\n" +
                "/vehicles/sort/{year} - to get vehicles by year\n" +
                "/vehicles/{id} - to get vehicle by id\n" +
                "/vehicles POST - using body to create vehicle\n" +
                "/vehicles/{id} PUT - using body to update vehicle by id\n" +
                "/vehicles/{id} DELETE - to delete a certain vehicle\n" +
                "/customers - to get all employees\n" +
                "/customers/{id} - to get a customer by id\n" +
                "/customers/{id} POST - to create a customer using the body\n" +
                "/customers/{id} PUT - to update a customer using the body\n" +
                "/customers/{id} DELETE - to delete a character with given id";
        String html = output.replaceAll("(\n)", "<br>");
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
    public Employee addEmployee(@RequestParam(name = "firstName", defaultValue = "firstName") String firstName, @RequestParam(value = "lastName", defaultValue = "lastName") String lastName) {
        return employeeService.addEmployee(firstName, lastName);
    }

    @GetMapping("/employee/{name}/{id}")
    public Employee getEmployee(@PathVariable(value = "name") String name, @PathVariable(value = "id") Long id) {
        return employeeService.getEmployee(name, id);
    }
}
