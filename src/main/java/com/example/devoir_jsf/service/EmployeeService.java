package com.example.devoir_jsf.service;

import com.example.devoir_jsf.dao.EmployeeRepository;
import com.example.devoir_jsf.model.Employee;

import java.sql.SQLException;
import java.util.List;

public class EmployeeService {
    private Employee employee;
    private EmployeeRepository employeeRepository;

    public EmployeeService() {
        this.employeeRepository = new EmployeeRepository();
    }

    public List<Employee> getAllEmployees() throws SQLException {
        return employeeRepository.getAllEmployees();
    }
    public void ajouterEmploye(Employee employee) throws SQLException {
        employeeRepository.AjouterUtilisateur(employee);
    }

    public void deleteEmployee(int id) throws SQLException {
        System.out.println("dkhl l  employee dyal service");

        employeeRepository.deleteEmployee(employee.getId());
        System.out.println("khrj l  employee dyal service");

    }

    public void updateEmployee(Employee employee) throws SQLException {
        employeeRepository.updateEmployee(employee);
    }


}
