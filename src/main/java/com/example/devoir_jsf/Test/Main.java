package com.example.devoir_jsf.Test;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Main {
    public static <User> void main(String[] args) throws SQLException {
    /*   String email = "maryam@gmail.com";
       UserDAO connBD = new UserDAO();
       int id=connBD.GetIDUtilisateur(email);
       System.out.println(id);*/
        System.out.println("Started");
        /*UserBean userbean= new UserBean();
        List<User> listusers =userbean.GetUsers();*/
        /*UserService userService = new UserService();
        List<User> listusers =userService.GetUsers();*/
        /*EmployeeDAO employeeDAO = new EmployeeDAO();
        List<Employee> listemployees = employeeDAO.getAllEmployees();
        for (Employee employee : listemployees) {

            System.out.println(employee);
        }
        System.out.println("fineshed");

         */
        String birthdayString = "2024-03-20";

        // Définir le formatteur de date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Parser la chaîne de date en LocalDate
        LocalDate birthday = LocalDate.parse(birthdayString, formatter);

        // Convertir LocalDate en java.util.Date
        Date date = java.sql.Date.valueOf(birthday);



        // Utiliser votre utilisateur comme nécessaire



    }
}
