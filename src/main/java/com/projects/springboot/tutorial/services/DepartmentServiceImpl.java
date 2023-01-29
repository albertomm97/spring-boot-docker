package com.projects.springboot.tutorial.services;

import com.projects.springboot.tutorial.entities.Department;
import com.projects.springboot.tutorial.errors.exceptions.ResourceNotFoundException;
import com.projects.springboot.tutorial.repositories.DepartmentRepository;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private Validator validator;
    private DepartmentRepository departmentRepository;


    public DepartmentServiceImpl(DepartmentRepository departmentRepository, Validator validator) {
        this.validator = validator;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    @Override
    public Department findById(Long id) throws ResourceNotFoundException {
        return departmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Department not found"));
    }

    @Override
    public Department findByName(String name) throws ResourceNotFoundException {
        return departmentRepository.findByNameIgnoreCase(name).orElseThrow(() -> new ResourceNotFoundException("Department not found"));
    }

    @Override
    public Department save(Department department) {
        validateConstraints(department);

        return departmentRepository.save(department);
    }

    @Override
    public void deleteById(Long id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public Department updateDepartment(Long id, Department department) throws ResourceNotFoundException {
        Department departmentDB = findById(id);

        validateConstraints(department);

        departmentDB.setName(department.getName());
        departmentDB.setAddress(department.getAddress());
        departmentDB.setCode(department.getCode());

        return departmentRepository.save(departmentDB);
    }

    private void validateConstraints(Department department) {
        Set<ConstraintViolation<Department>> violations = validator.validate(department);
        if(!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }
}
