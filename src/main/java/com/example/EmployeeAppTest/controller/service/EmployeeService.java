package com.example.EmployeeAppTest.controller.service;

import com.example.EmployeeAppTest.domain.Employee;
import com.example.EmployeeAppTest.domain.Project;
import com.example.EmployeeAppTest.repository.EmployeeRepository;
import com.example.EmployeeAppTest.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ProjectRepository projectRepository;
    public void saveEmployee(Employee empObj) { employeeRepository.save(empObj); }

    public List<Employee> getEmployeeDetails(Long employeeId) {
        if(null != employeeId) {
            return employeeRepository.findAllByEmployeeId(employeeId);
        } else {
            return employeeRepository.findAll();
        }
    }

    public void deleteEmployee(Long employeeId){
        employeeRepository.deleteById(employeeId);
    }

    public Employee assignProjectToEmployee(Long employeeId, Long projectId) {
        Set<Project> projectSet = null;
        UUID.randomUUID().toString();
        Employee employee = employeeRepository.findById(employeeId).get();
        Project project = projectRepository.findById(projectId).get();
        projectSet =  employee.getAssignedProjects();
        projectSet.add(project);
        employee.setAssignedProjects(projectSet);
        return employeeRepository.save(employee);
    }

    }

