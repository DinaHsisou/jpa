package com.example.devoir_jsf.service;

import com.example.devoir_jsf.dao.EmployeeRepository;
import com.example.devoir_jsf.model.Employe;

import java.sql.SQLException;
import java.util.List;

public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService() {
        this.employeeRepository = new EmployeeRepository();
    }

    public List<Employe> getAllEmployees() throws SQLException {
        return employeeRepository.getAllEmployees();
    }

    public void addEmployee(Employe employee) throws SQLException {
        employeeRepository.addEmployee(employee);
    }

    public void deleteEmployee(long id) throws SQLException {
        employeeRepository.deleteEmployee(id);
    }

    public boolean updateEmployee(Employe employee) throws SQLException {
        return employeeRepository.updateEmployee(employee);
    }

    public void close() {
        employeeRepository.close();
    }
}
