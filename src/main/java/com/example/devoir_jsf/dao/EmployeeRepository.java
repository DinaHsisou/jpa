package com.example.devoir_jsf.dao;

import com.example.devoir_jsf.model.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

public class EmployeeRepository {
    private EntityManager entityManager;
    private EntityManagerFactory entityManagerFactory;

    public EmployeeRepository() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("eclipse-link");
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    public List<Employee> getAllEmployees() {
        Query query = entityManager.createQuery("SELECT e FROM Employee e");
        return query.getResultList();
    }

    public void AjouterUtilisateur(Employee employee) {
        entityManager.getTransaction().begin();
        entityManager.persist(employee);
        entityManager.getTransaction().commit();
    }

    public void deleteEmployee(int id) {
        Employee employee = entityManager.find(Employee.class, id);
        if (employee != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(employee);
            entityManager.getTransaction().commit();
        }
    }

    public boolean updateEmployee(Employee employee) {
        Employee existingEmployee = entityManager.find(Employee.class, employee.getId());
        if (existingEmployee != null) {
            entityManager.getTransaction().begin();
            existingEmployee.setName(employee.getName());
            existingEmployee.setEmail(employee.getEmail());
            existingEmployee.setDob(employee.getDob());
            existingEmployee.setDepartment(employee.getDepartment());
            entityManager.getTransaction().commit();
            return true;
        }
        return false;
    }

    public void close() {
        entityManager.close();
        entityManagerFactory.close();
    }

    // Custom queries
    public Employee findByNom(String nom) {
        return entityManager.createQuery("SELECT e FROM Employee e WHERE e.name = :nom", Employee.class)
                .setParameter("nom", nom)
                .getSingleResult();
    }
}
