package com.exercise.demo.service;

import com.exercise.demo.models.Employees;
import com.exercise.demo.models.EmployeesAndProject;
import com.exercise.demo.models.composite.EmployeesAndProjectId;
import com.exercise.demo.repository.EmployeeRepository;
import com.exercise.demo.repository.EmployeesAndProjectsRepository;
import com.exercise.demo.requests.EmployeeRequest;
import org.springframework.stereotype.Service;

@Service
public class EmployeesTransactionService {

    private final EmployeeRepository employeeRepository;

    private final EmployeesAndProjectsRepository employeesAndProjectsRepository;

    public EmployeesTransactionService(EmployeeRepository employeeRepository, EmployeesAndProjectsRepository employeesAndProjectsRepository) {
        this.employeeRepository = employeeRepository;
        this.employeesAndProjectsRepository = employeesAndProjectsRepository;
    }

    public void saveEmployees(EmployeeRequest employeeRequest) {
        saveOrUpdate(employeeRequest);
    }

    public void updateEmployees(EmployeeRequest employeeRequest) {
        saveOrUpdate(employeeRequest);
    }

    private void saveOrUpdate(EmployeeRequest employeeRequest) {
        if(employeeRequest.getProjectId() != null) {
            Integer employeeId = employeeRepository.save(buildEmployeesEntity(employeeRequest)).getId();
            employeesAndProjectsRepository.save(buildEmployeeAndProject(employeeId, employeeRequest.getProjectId()));
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

    private Employees buildEmployeesEntity(EmployeeRequest employeeRequest) {
        Employees employees = new Employees();
        employees.setDepartmentId(employeeRequest.getDepartmentId());
        employees.setName(employeeRequest.getName());
        employees.setEmail(employeeRequest.getEmail());
        employees.setSalary(employeeRequest.getSalary());

        return employees;
    }

}
