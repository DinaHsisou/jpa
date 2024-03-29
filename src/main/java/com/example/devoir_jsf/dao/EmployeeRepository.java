package com.example.devoir_jsf.dao;

import com.example.devoir_jsf.bean.EmployeeBean;

import com.example.devoir_jsf.model.Employe;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import java.util.List;

public class EmployeeRepository {
    private final EntityManagerFactory entityManagerFactory;
    private final EntityManager entityManager;

    public EmployeeRepository() {
        entityManagerFactory = Persistence.createEntityManagerFactory("eclipse-link");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public List<Employe> getAllEmployees() {
        Query query = entityManager.createQuery("SELECT e FROM Employe e");
        return query.getResultList();
    }

    public void addEmployee(Employe employee) {
        entityManager.getTransaction().begin();
        entityManager.persist(employee);
        entityManager.getTransaction().commit();
    }

    public void deleteEmployee(long id) {
        Employe employee = entityManager.find(Employe.class, id);
        if (employee != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(employee);
            entityManager.getTransaction().commit();
        }
    }

    public boolean updateEmployee(Employe employee) {
        Employe existingEmployee = entityManager.find(Employe.class, employee.getId());
        if (existingEmployee != null) {
            entityManager.getTransaction().begin();
            existingEmployee.setName(employee.getName());
            existingEmployee.setEmail(employee.getEmail());
            existingEmployee.setSkills(employee.getSkills());
            existingEmployee.setProjects(employee.getProjects());
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
    public Employe findByName(String name) {
        return entityManager.createQuery("SELECT e FROM Employe e WHERE e.name = :name", Employe.class)
                .setParameter("name", name)
                .getSingleResult();
    }
}
