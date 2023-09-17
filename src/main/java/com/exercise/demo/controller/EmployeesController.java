package com.exercise.demo.controller;


import com.exercise.demo.models.Employees;
import com.exercise.demo.repository.EmployeeRepository;
import com.exercise.demo.requests.EmployeeRequest;
import com.exercise.demo.service.EmployeesTransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeesController {

    private final EmployeeRepository employeeRepository;

    private final EmployeesTransactionService employeesTransactionService;
    public EmployeesController(EmployeeRepository employeeRepository, EmployeesTransactionService employeesTransactionService) {
        this.employeeRepository = employeeRepository;
        this.employeesTransactionService = employeesTransactionService;
    }

    @GetMapping("/employees/all")
    public List<Employees> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employees getEmployeeById(@PathVariable Integer id) {
        return employeeRepository.findById(id).orElseThrow();
    }

    @PostMapping("/employees/add")
    public String addEmployees(@RequestBody EmployeeRequest employee) {
        employeesTransactionService.saveEmployees(employee);
        return "Employee was added successfully";
    }

    @PutMapping("/employees/update")
    public String updateEmployees(@RequestBody EmployeeRequest employee) {
        employeeRepository.save(employee);
        return "Employee was updated successfully";
    }

    @DeleteMapping("/employees/delete/{id}")
    public String deleteEmployees(@PathVariable Integer id) {
        employeeRepository.deleteById(id);
        return "Employee was deleted successfully";
    }
}
