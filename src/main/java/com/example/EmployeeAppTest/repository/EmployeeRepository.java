package com.example.EmployeeAppTest.repository;

import com.example.EmployeeAppTest.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    List<Employee> findAllByEmployeeId(Long employeeId);
}
