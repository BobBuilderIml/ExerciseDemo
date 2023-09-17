package com.exercise.demo.repository;


import com.exercise.demo.models.Projects;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface ProjectRepository extends CrudRepository<Projects, Integer> {
    List<Projects> findAll();
}
