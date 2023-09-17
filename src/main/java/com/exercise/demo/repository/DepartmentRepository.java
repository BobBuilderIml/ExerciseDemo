package com.exercise.demo.repository;



import com.exercise.demo.models.Departments;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface DepartmentRepository extends CrudRepository<Departments, Integer> {
    List<Departments> findAll();
}
