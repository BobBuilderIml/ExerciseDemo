package com.exercise.demo.models;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Getter
@Setter
@Entity
@Table(name = "Projects")
public class Projects implements Serializable {

    @Column(updatable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "project_name")
    private String projectName;

    @ManyToMany(mappedBy = "projects")
    @Getter(AccessLevel.NONE)
    private final List<Employees> employees = new ArrayList<>();

    public List<String> getEmployees() {
        return employees.stream().map(Employees::toString).collect(Collectors.toList());
    }
}
