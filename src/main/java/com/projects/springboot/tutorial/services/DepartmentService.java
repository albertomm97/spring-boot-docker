package com.projects.springboot.tutorial.services;

import com.projects.springboot.tutorial.entities.Department;
import com.projects.springboot.tutorial.errors.exceptions.ResourceNotFoundException;
import com.projects.springboot.tutorial.errors.exceptions.ValidationFieldsException;

import java.util.List;

public interface DepartmentService {

    public List<Department> findAll();
    public Department findById(Long id) throws ResourceNotFoundException;
    public Department findByName(String name) throws ResourceNotFoundException;
    public Department save(Department department);
    public void deleteById(Long id);
    public Department updateDepartment(Long id, Department department) throws ResourceNotFoundException;
}
