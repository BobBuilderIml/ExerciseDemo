package com.exercise.demo.repository;

import com.exercise.demo.models.EmployeesAndProject;
import org.springframework.data.repository.CrudRepository;

public interface EmployeesAndProjectsRepository extends CrudRepository<EmployeesAndProject, Integer> {
}
