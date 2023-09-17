package com.exercise.demo.models.composite;


import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class EmployeesAndProjectId implements Serializable {

    @Column(name = "employee_id")
    private Integer employeeId;

    @Column(name = "project_id")
    private Integer projectId;
}
