package com.exercise.demo.service;

import com.exercise.demo.models.Employees;
import com.exercise.demo.models.EmployeesAndProject;
import com.exercise.demo.models.composite.EmployeesAndProjectId;
import com.exercise.demo.repository.EmployeeRepository;
import com.exercise.demo.repository.EmployeesAndProjectsRepository;
import com.exercise.demo.requests.EmployeeRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

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

    private EmployeesAndProject buildEmployeeAndProject(Integer employeeId, Integer projectId) {
        EmployeesAndProjectId employeesAndProjectId = new EmployeesAndProjectId();
        employeesAndProjectId.setEmployeeId(employeeId);
        employeesAndProjectId.setProjectId(projectId);

        EmployeesAndProject employeesAndProject = new EmployeesAndProject();
        employeesAndProject.setEmployeesAndProjectId(employeesAndProjectId);
        return employeesAndProject;
    }

    private Employees buildEmployeesEntitySave(EmployeeRequest employeeRequest) {
        Employees employees = new Employees();
        employees.setDepartmentId(employeeRequest.getDepartmentId());
        employees.setName(employeeRequest.getName());
        employees.setEmail(employeeRequest.getEmail());
        employees.setSalary(employeeRequest.getSalary());
        return employees;
    }

    private Employees buildEmployeesEntityUpdate(EmployeeRequest employeeRequest, Employees employeeDb) {
        Integer updatedId = employeeRequest.getId() != null ? employeeRequest.getId() : employeeDb.getId();
        Integer updatedDepartmentId = employeeRequest.getDepartmentId() != null ? employeeRequest.getDepartmentId() : employeeDb.getDepartmentId();
        String updatedName = employeeRequest.getName() != null ? employeeRequest.getName() : employeeDb.getName();
        String updatedEmail = employeeRequest.getEmail() != null ? employeeRequest.getEmail() : employeeDb.getEmail();
        BigDecimal updatedSalary = employeeRequest.getSalary() != null ? employeeRequest.getSalary() : employeeDb.getSalary();
        Employees employees = new Employees();
        employees.setId(updatedId);
        employees.setDepartmentId(updatedDepartmentId);
        employees.setName(updatedName);
        employees.setEmail(updatedEmail);
        employees.setSalary(updatedSalary);
        return employees;
    }

}
