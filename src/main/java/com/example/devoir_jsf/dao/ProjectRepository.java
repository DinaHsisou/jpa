package com.example.devoir_jsf.dao;

import com.example.devoir_jsf.model.Project;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import java.util.List;

public class ProjectRepository {
    private final EntityManagerFactory entityManagerFactory;
    private final EntityManager entityManager;

    public ProjectRepository() {
        entityManagerFactory = Persistence.createEntityManagerFactory("eclipse-link");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public List<Project> getAllProjects() {
        Query query = entityManager.createQuery("SELECT p FROM Project p");
        return query.getResultList();
    }

    public void addProject(Project project) {
        entityManager.getTransaction().begin();
        entityManager.persist(project);
        entityManager.getTransaction().commit();
    }

    public void deleteProject(long id) {
        Project project = entityManager.find(Project.class, id);
        if (project != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(project);
            entityManager.getTransaction().commit();
        }
    }

    public boolean updateProject(Project project) {
        Project existingProject = entityManager.find(Project.class, project.getId());
        if (existingProject != null) {
            entityManager.getTransaction().begin();
            existingProject.setName(project.getName());
            existingProject.setBudget(project.getBudget());
            // Ajoutez d'autres attributs si nécessaire
            entityManager.getTransaction().commit();
            return true;
        }
        return false;
    }

    public void close() {
        entityManager.close();
        entityManagerFactory.close();
    }
}

