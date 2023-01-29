package com.projects.springboot.tutorial.repositories;

import com.projects.springboot.tutorial.entities.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        Department department =
                Department.builder()
                        .name("test")
                        .code("1234567")
                        .address("Antonio Brotons")
                        .build();

        entityManager.persist(department);
    }

    @Test
    @DisplayName("Get Department By Id")
    public void whenFindById_thenReturnDepartment() {
        Department department = departmentRepository.findById(1L).get();

        assertEquals(department.getName(), "test");
    }
}