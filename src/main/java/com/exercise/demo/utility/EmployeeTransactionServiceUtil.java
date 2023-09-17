package com.exercise.demo.utility;

import com.exercise.demo.models.Employees;
import com.exercise.demo.models.EmployeesAndProject;
import com.exercise.demo.models.composite.EmployeesAndProjectId;
import com.exercise.demo.requests.EmployeeRequest;

import java.math.BigDecimal;

public class EmployeeTransactionServiceUtil {

    public static Employees buildEmployeesEntitySave(EmployeeRequest employeeRequest) {
        Employees employees = new Employees();
        employees.setDepartmentId(employeeRequest.getDepartmentId());
        employees.setName(employeeRequest.getName());
        employees.setEmail(employeeRequest.getEmail());
        employees.setSalary(employeeRequest.getSalary());
        return employees;
    }

    public static Employees buildEmployeesEntityUpdate(EmployeeRequest employeeRequest, Employees employeeDb) {
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

    public static EmployeesAndProject buildEmployeeAndProject(Integer employeeId, Integer projectId) {
        EmployeesAndProjectId employeesAndProjectId = new EmployeesAndProjectId();
        employeesAndProjectId.setEmployeeId(employeeId);
        employeesAndProjectId.setProjectId(projectId);

        EmployeesAndProject employeesAndProject = new EmployeesAndProject();
        employeesAndProject.setEmployeesAndProjectId(employeesAndProjectId);
        return employeesAndProject;
    }
}
