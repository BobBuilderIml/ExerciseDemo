package com.exercise.demo.controller;

import com.exercise.demo.models.Departments;
import com.exercise.demo.repository.DepartmentRepository;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentsController {

    private final DepartmentRepository departmentRepository;

    public DepartmentsController(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @GetMapping("/all")
    @Transactional
    public List<Departments> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Departments getDepartmentById(@PathVariable Integer id) {
        return departmentRepository.findById(id).orElseThrow();
    }

    @PostMapping("/add")
    public String addDepartment(@RequestBody Departments department) {
        departmentRepository.save(department);
        return "Department was added successfully";
    }

    @PutMapping("/update")
    public String updateDepartment(@RequestBody Departments department) {
        departmentRepository.save(department);
        return "Department was added successfully";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteDepartment(@PathVariable Integer id) {
        departmentRepository.deleteById(id);
        return "Department was deleted successfully";
    }


}
