package main;

import userio.MenuHandler;
import employee.management.EmployeeManager;
import employee.Programmer;
import employee.Secretary;
import employee.Technician;
import employee.Employee;

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
        MenuHandler mh = new MenuHandler();
        //addTestPersons(mh.getEmployeeManager());
        while (mh.mainMenu()) {
        }
    }

    private static void addTestPersons(EmployeeManager em) {
        em.add("Anders Andersson", "19660101", Secretary.ID, 30000, Employee.GENDER_MAN);
        em.add("Sven Svensson", "19880101", Technician.ID, 45000, Employee.GENDER_MAN);
        em.add("Lisa Lissabon", "19910201", Technician.ID, 41000, Employee.GENDER_WOMAN);
        em.add("Mary Martin", "19431109", Programmer.ID, 47000, Employee.GENDER_WOMAN);
    }
}
