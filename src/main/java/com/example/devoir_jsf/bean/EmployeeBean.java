package com.example.devoir_jsf.bean;


import com.example.devoir_jsf.model.Employe;
import com.example.devoir_jsf.service.EmployeeService;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.bean.RequestScoped;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.ValidatorException;
import jakarta.faces.view.ViewScoped;
import jakarta.annotation.ManagedBean;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ManagedBean
@ViewScoped
public class EmployeeBean implements Serializable {

    private Integer id;
    private String name;
    private String email;
    private String searchQuery;
    private boolean fieldsVisible = false;
    private List<Employe> employees = new ArrayList<>();
    private EmployeeService employeeService = new EmployeeService();

    // Getters and setters

    public String getSearchQuery() {
        return searchQuery;
    }

    public void setSearchQuery(String searchQuery) {
        this.searchQuery = searchQuery;
    }

    public boolean isFieldsVisible() {
        return fieldsVisible;
    }

    public void toggleFields() {
        fieldsVisible = !fieldsVisible;
    }

    public List<Employe> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employe> employees) {
        this.employees = employees;
    }

    public void validateEmail(FacesContext context, UIComponent toValidate, Object value) throws ValidatorException {
        String emailStr = (String) value;
        if (!emailStr.contains("@")) {
            FacesMessage message = new FacesMessage("Invalid Email Address");
            throw new ValidatorException(message);
        }
    }

    public void saveEmployee() {
        try {
            Employe newEmployee = new Employe(name, email);
            employeeService.addEmployee(newEmployee);
            employees = employeeService.getAllEmployees();
            resetFields();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Employee added successfully!", null));
        } catch (SQLException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error adding employee!", e.getMessage()));
            e.printStackTrace();
        }
    }

    public void deleteEmployee(Employe employee) {
        try {
            employeeService.deleteEmployee(employee.getId());
            employees.remove(employee);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Employee deleted successfully!", null));
        } catch (SQLException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error deleting employee!", e.getMessage()));
            e.printStackTrace();
        }
    }

    public void searchEmployees() {
        try {
            if (searchQuery == null || searchQuery.trim().isEmpty()) {
                employees = employeeService.getAllEmployees();
            } else {
                employees = employeeService.getAllEmployees().stream()
                        .filter(e -> e.getName().toLowerCase().contains(searchQuery.toLowerCase()))
                        .collect(Collectors.toList());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to reset input fields after adding an employee
    private void resetFields() {
        name = null;
        email = null;
    }
}
