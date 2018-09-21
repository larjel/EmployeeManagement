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
    }
}
