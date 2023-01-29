package com.projects.springboot.tutorial.controllers;

import com.projects.springboot.tutorial.entities.Department;
import com.projects.springboot.tutorial.services.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    private Department outDeparment;

    @BeforeEach
    void setUp() {
        outDeparment = Department.builder()
                .id(1L)
                .name("test")
                .address("hola")
                .code("1234567")
                .build();
    }

    @Test
    void getDepartment() throws Exception {
        Mockito.when(departmentService.findById(1L)).thenReturn(outDeparment);

        mockMvc.perform(get("/api/departments/1")).andExpect(status().isOk());
    }

    @Test
    void saveDepartment() throws Exception {
        Department input = Department.builder()
                .name("test")
                .address("hola")
                .code("1234567")
                .build();

        Mockito.when(departmentService.save(input)).thenReturn(outDeparment);

        mockMvc.perform(post("/api/departments")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"test\",\"code\":\"1234567\",\"address\":\"hola\"}"))
                .andExpect(status().isCreated());
    }
}