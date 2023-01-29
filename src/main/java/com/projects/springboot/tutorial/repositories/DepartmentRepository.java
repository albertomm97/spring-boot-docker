package com.projects.springboot.tutorial.repositories;

import com.projects.springboot.tutorial.entities.Department;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Primary
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    public Optional<Department> findByName(String name);
    public Optional<Department> findByNameIgnoreCase(String name);
}
