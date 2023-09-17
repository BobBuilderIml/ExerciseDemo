package com.exercise.demo.service;

import com.exercise.demo.models.Employees;
import com.exercise.demo.repository.EmployeeRepository;
import com.exercise.demo.repository.EmployeesAndProjectsRepository;
import com.exercise.demo.requests.EmployeeRequest;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.exercise.demo.utility.EmployeeTransactionServiceUtil.*;

@Service
public class EmployeesTransactionService {

    private final EmployeeRepository employeeRepository;

    private final EmployeesAndProjectsRepository employeesAndProjectsRepository;

    public EmployeesTransactionService(EmployeeRepository employeeRepository, EmployeesAndProjectsRepository employeesAndProjectsRepository) {
        this.employeeRepository = employeeRepository;
        this.employeesAndProjectsRepository = employeesAndProjectsRepository;
    }

    public List<Employees> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employees getEmployeeById(Integer id) {
        return employeeRepository.findById(id).orElseThrow();
    }

    public void deleteEmployeeById(Integer id) {
        employeeRepository.deleteById(id);
    }

    public void saveEmployee(EmployeeRequest employeeRequest) {
        if (employeeRequest.getProjectId() != null) {
            Integer employeeId = employeeRepository.save(buildEmployeesEntitySave(employeeRequest)).getId();
            employeesAndProjectsRepository.save(buildEmployeeAndProject(employeeId, employeeRequest.getProjectId()));
        } else {
            employeeRepository.save(buildEmployeesEntitySave(employeeRequest));
        }
    }

    public void updateEmployee(EmployeeRequest employeeRequest) {
        Employees dbEmployees = employeeRepository.findById(employeeRequest.getId()).orElseThrow();
        if(employeeRequest.getProjectId() != null) {
            Integer employeeId = employeeRepository.save(buildEmployeesEntityUpdate(employeeRequest, dbEmployees)).getId();
            employeesAndProjectsRepository.save(buildEmployeeAndProject(employeeId, employeeRequest.getProjectId()));
        } else {
            employeeRepository.save(buildEmployeesEntityUpdate(employeeRequest, dbEmployees));
        }

    }

}
