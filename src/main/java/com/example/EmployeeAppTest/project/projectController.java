package com.example.EmployeeAppTest.project;

import com.example.EmployeeAppTest.controller.service.ProjectService;
import com.example.EmployeeAppTest.domain.Employee;
import com.example.EmployeeAppTest.domain.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
public class projectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping("/save")
    public ResponseEntity creatProject(@RequestBody Project projectObj) {
        projectService.saveProject(projectObj);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping(value = {"/getProject", "/{projectId}"})
    public List<Project> getProject(@PathVariable(required = false) Long projectId) {
        return projectService.getProjectDetails(projectId);
    }

    @DeleteMapping("delete/{projectId}")
    public ResponseEntity removeProject(@PathVariable Long projectId) {
        projectService.deleteProject(projectId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}