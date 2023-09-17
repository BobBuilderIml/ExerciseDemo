package com.exercise.demo.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Departments")
public class Departments implements Serializable {

    @Column(updatable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "department_name")
    private String name;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    @Getter(AccessLevel.NONE)
    private List<Employees> employees = new ArrayList<>();

    @JsonProperty("averageSalary")
    public Double getEmployees() {
        return employees.parallelStream().mapToDouble(employee -> employee.getSalary().doubleValue()).average().orElse(-1);
    }
}
