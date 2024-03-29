package com.example.devoir_jsf.model;

import com.example.devoir_jsf.model.Employe;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private double budget;

    @ManyToMany(mappedBy = "projects")
    private List<Employe> employees = new ArrayList<>();
}
