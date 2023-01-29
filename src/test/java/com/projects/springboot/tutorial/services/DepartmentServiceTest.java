package com.projects.springboot.tutorial.services;

import com.projects.springboot.tutorial.entities.Department;
import com.projects.springboot.tutorial.repositories.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department =
                Department.builder()
                        .id(1L)
                        .name("test")
                        .code("1234567")
                        .address("Antonio Brotons")
                        .build();

        Mockito.when(departmentRepository.findByNameIgnoreCase("test"))
                .thenReturn(Optional.ofNullable(department));
    }

    @Test
    @DisplayName("Get Department by Name")
    public void whenValidDepartmentName_thenDepartmentShouldFound() {
        String departmentName = "test";
        Department found = departmentService.findByName(departmentName);

        assertEquals(departmentName, found.getName());
    }
}