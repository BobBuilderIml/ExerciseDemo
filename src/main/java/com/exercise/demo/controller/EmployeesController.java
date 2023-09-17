package com.exercise.demo.controller;


import com.exercise.demo.models.Employees;
import com.exercise.demo.requests.EmployeeRequest;
import com.exercise.demo.service.EmployeesTransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeesController {

    private final EmployeesTransactionService employeesTransactionService;

    public EmployeesController(EmployeesTransactionService employeesTransactionService) {
        this.employeesTransactionService = employeesTransactionService;
    }

    @GetMapping("/all")
    public List<Employees> getAllEmployees() {
        return employeesTransactionService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employees getEmployeeById(@PathVariable Integer id) {
        return employeesTransactionService.getEmployeeById(id);
    }

    @PostMapping("/add")
    public String addEmployees(@RequestBody EmployeeRequest employee) {
        employeesTransactionService.saveEmployee(employee);
        return "Employee was added successfully";
    }

    @PutMapping("/update")
    public String updateEmployees(@RequestBody EmployeeRequest employee) {
        employeesTransactionService.updateEmployee(employee);
        return "Employee was updated successfully";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployees(@PathVariable Integer id) {
        employeesTransactionService.deleteEmployeeById(id);
        return "Employee was deleted successfully";
    }
}
