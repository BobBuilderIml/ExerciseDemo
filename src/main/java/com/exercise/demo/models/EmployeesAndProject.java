package com.exercise.demo.models;

import com.exercise.demo.models.composite.EmployeesAndProjectId;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "employees_projects")
public class EmployeesAndProject {
    @EmbeddedId
    private EmployeesAndProjectId employeesAndProjectId;
}
