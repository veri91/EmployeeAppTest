package com.example.EmployeeAppTest.controller;

import com.example.EmployeeAppTest.controller.service.EmployeeService;
import com.example.EmployeeAppTest.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/save")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee empObj) {
        employeeService.saveEmployee(empObj);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = {"/getEmployees", "/{employeeId}"})
    public List<Employee> getEmployee(@PathVariable(required = false) Long employeeId) {
        return employeeService.getEmployeeDetails(employeeId);
    }

    @DeleteMapping("delete/{employeeId}")
    public ResponseEntity removeEmployee(@PathVariable Long employeeId) {
        employeeService.deleteEmployee(employeeId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{employeeId}/project/{projectId}")
    public Employee assignProjectToEmployee(
            @PathVariable Long employeeId,
            @PathVariable Long projectId
    ) {
        return employeeService.assignProjectToEmployee(employeeId, projectId);
    }



}
