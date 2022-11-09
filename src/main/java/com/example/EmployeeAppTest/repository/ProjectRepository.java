package com.example.EmployeeAppTest.repository;

import com.example.EmployeeAppTest.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project,Long> {

    List<Project> findAllByProjectId(Long projectId);
}
