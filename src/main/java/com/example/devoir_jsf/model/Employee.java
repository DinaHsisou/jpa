package com.example.devoir_jsf.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private LocalDate dob;
    private String department;
    @Transient
    private boolean editable;

    public Employee(int id, String name, String email, LocalDate dob, String department) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.department = department;
    }
    public Employee(String name, String email, LocalDate dob, String department) {
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.department = department;
    }
    public Employee() {
    }

    // Getters and setters

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", department='" + department + '\'' +
                ", editable=" + editable +
                '}';
    }
}
