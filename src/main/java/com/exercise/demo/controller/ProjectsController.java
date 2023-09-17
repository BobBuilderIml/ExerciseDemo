package com.exercise.demo.controller;

import com.exercise.demo.models.Projects;
import com.exercise.demo.repository.ProjectRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectsController {

    private final ProjectRepository projectRepository;

    public ProjectsController(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @GetMapping("/all")
    public List<Projects> getAllDepartments() {
        return projectRepository.findAll();
    }

    @GetMapping("/{id}")
    public Projects getDepartmentById(@PathVariable Integer id) {
        return projectRepository.findById(id).orElseThrow();
    }

    @PostMapping("/add")
    public String addProjects(@RequestBody Projects project) {
        projectRepository.save(project);
        return "Projects was added successfully";
    }

    @PutMapping("/update")
    public String updateProject(@RequestBody Projects project) {
        projectRepository.save(project);
        return "Project was updated successfully";
    }

    @PutMapping("/delete/{id}")
    public String deleteProject(@RequestBody Integer id) {
        projectRepository.deleteById(id);
        return "Project was deleted successfully";
    }
}
