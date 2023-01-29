package com.projects.springboot.tutorial.controllers;

import com.projects.springboot.tutorial.entities.Department;
import com.projects.springboot.tutorial.errors.exceptions.ResourceNotFoundException;
import com.projects.springboot.tutorial.errors.exceptions.ValidationFieldsException;
import com.projects.springboot.tutorial.services.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("")
    public ResponseEntity<List<Department>> getDepartments() {
        return ResponseEntity.status(HttpStatus.OK).body(departmentService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartment(@PathVariable(name = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(departmentService.findById(id));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Department> getDepartmentByName(@PathVariable(name = "name") String name) {
        return ResponseEntity.status(HttpStatus.OK).body(departmentService.findByName(name));
    }

    @PostMapping("")
    public ResponseEntity<Department> saveDepartment(@RequestBody Department department) {
        return ResponseEntity.status(HttpStatus.CREATED).body(departmentService.save(department));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Department> deleteDepartment(@PathVariable(name = "id") Long id) {

        Department department = departmentService.findById(id);

        departmentService.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).body(department);
    }

    @PutMapping("{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable(name = "id") Long id,
                                                       @RequestBody Department department) {

        return ResponseEntity.status(HttpStatus.OK).body(departmentService.updateDepartment(id, department));
    }
}
