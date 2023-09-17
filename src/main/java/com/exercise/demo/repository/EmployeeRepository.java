package com.exercise.demo.repository;


import com.exercise.demo.models.Employees;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface EmployeeRepository extends CrudRepository<Employees, Integer> {
    List<Employees> findAll();
    Employees save(Employees employees);
}
