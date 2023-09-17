package com.exercise.demo.requests;

import com.exercise.demo.models.Employees;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeRequest extends Employees {
    private Integer departmentId;
    private Integer projectId;
}
