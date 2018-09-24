package main;

import employee.management.EmployeeManager;
import employee.*;
import userio.menu.MainMenu;

/**
 * Lab 2: Employee Management System
 */
public class Main {

    /**
     * Program entry point
     *
     * @param args The command line arguments [Not used]
     */
    public static void main(String[] args) {
        MainMenu mainMenu = new MainMenu();
        //addTestPersons(mainMenu.getEmployeeManager());
        while (mainMenu.showMainMenu()) {
        }
    }

    private static void addTestPersons(EmployeeManager em) {
        em.add("Anders Andersson", "19660101", Profession.SECRETARY, 30000, Employee.GENDER_MAN);
        em.add("Sven Svensson", "19880101", Profession.TECHNICIAN, 45000, Employee.GENDER_MAN);
        em.add("Lisa Lissabon", "19910201", Profession.TECHNICIAN, 41000, Employee.GENDER_WOMAN);
        em.add("Mary Martin", "19431109", Profession.PROGRAMMER, 47000, Employee.GENDER_WOMAN);
        em.add("Ture Turesson", "19801112", Profession.PROGRAMMER, 37000, Employee.GENDER_MAN);
        em.add("Sofia Software", "19980103", Profession.SECRETARY, 27000, Employee.GENDER_WOMAN);
        em.add("Lars Larsson", "19230405", Profession.TECHNICIAN, 32000, Employee.GENDER_MAN);
        em.add("Sten Stensson", "19780304", Profession.PROGRAMMER, 34000, Employee.GENDER_MAN);
        em.add("Willy Wonka", "19800708", Profession.SECRETARY, 56000, Employee.GENDER_MAN);
        em.add("Maria Svensson", "19751205", Profession.TECHNICIAN, 78000, Employee.GENDER_WOMAN);
        em.add("Anna Efternamn", "20000607", Profession.SECRETARY, 18000, Employee.GENDER_WOMAN);
        em.add("Daniel Danielsson", "19680403", Profession.PROGRAMMER, 23000, Employee.GENDER_MAN);
        em.add("Börje Börjesson", "19690212", Profession.TECHNICIAN, 36000, Employee.GENDER_MAN);
        em.add("Mikael Mikaelsson", "19711106", Profession.PROGRAMMER, 32500, Employee.GENDER_MAN);
        em.add("Arne Anka", "19450506", Profession.PROGRAMMER, 34000, Employee.GENDER_MAN);
        em.add("Kajsa Anka", "19341105", Profession.PROGRAMMER, 46500, Employee.GENDER_WOMAN);
        em.add("Rita Rotmos", "19560504", Profession.TECHNICIAN, 27900, Employee.GENDER_WOMAN);
        em.add("Sara Larsson", "19660807", Profession.SECRETARY, 33700, Employee.GENDER_WOMAN);
        em.add("Alexander Lukas", "19491204", Profession.TECHNICIAN, 23000, Employee.GENDER_MAN);
        em.add("Mårten Gås", "19701130", Profession.SECRETARY, 56000, Employee.GENDER_MAN);
    }
}
