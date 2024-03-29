package com.example.devoir_jsf.bean;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.bean.RequestScoped;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.ValidatorException;
import jakarta.faces.view.ViewScoped;
import jakarta.annotation.ManagedBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@ViewScoped
public class AffectationBean implements Serializable {

    private String selectedEmployee;
    private String projectName;
    private String selectedImplication;
    private List<String> employeeNames;
    private List<String> implications;

    // Injectez ici vos services ou repositories nécessaires pour récupérer les données de la base de données

    @PostConstruct
    public void init() {
        // Initialisez les données nécessaires, par exemple les noms des employés et les implications possibles
        employeeNames = new ArrayList<>();
        // Récupérez les noms des employés à partir de la base de données et ajoutez-les à la liste
        // Répétez le même processus pour les implications possibles
        implications = new ArrayList<>();
        implications.add("Faible");
        implications.add("Moyenne");
        implications.add("Forte");
    }

    // Implémentez ici les getters et setters pour les propriétés

    public void affecterProjet() {
        // Implémentez la logique pour affecter le projet à l'employé sélectionné
        System.out.println("Employee selected: " + selectedEmployee);
        System.out.println("Project name: " + projectName);
        System.out.println("Implication selected: " + selectedImplication);
    }
}

