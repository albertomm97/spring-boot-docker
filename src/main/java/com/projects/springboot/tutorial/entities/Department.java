package com.projects.springboot.tutorial.entities;

import lombok.Builder;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.xml.transform.Source;

@Entity
@Table(name = "departments")
@Builder
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Please Add Department Name")
    @Size(min = 3, max = 20, message = "Name should have between 3 and 20 chars")
    private String name;

    @NotBlank(message = "Please Add Address")
    @Size(min = 3, max = 20, message = "Address should have between 3 and 20 chars")
    private String address;

    @NotBlank(message = "Please Add Department Code")
    @Size(min = 7, max = 7, message = "Code Department should have 7 chars")
    private String code;

    public Department() {}

    public Department(Long id, String name, String address, String code) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.code = code;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
