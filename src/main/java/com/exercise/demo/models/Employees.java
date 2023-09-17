package com.exercise.demo.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name = "Employees")
public class Employees implements Serializable {

    @Column(updatable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    private String name;

    @Column
    private String email;

    @Column
    private BigDecimal salary;

    @Column(name = "department_id")
    private Integer departmentId;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "employees_projects",
            joinColumns = {@JoinColumn(name = "employee_id")},
            inverseJoinColumns = {@JoinColumn(name = "project_id")}
    )
    @Getter(AccessLevel.NONE)
    @ToString.Exclude
    private List<Projects> projects;

}
