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
        while (mh.mainMenu()) {
        }
    }

    /**
     * For testing employee management
     */
    private void testMethod() {
        EmployeeManager em = new EmployeeManager();

        em.add("Anders Andersson", "660101", Secretary.ID, 30000, Employee.GENDER_MAN);
        em.add("Sven Svensson", "880101", Technician.ID, 45000, Employee.GENDER_MAN);
        em.add("Lisa Lissabon", "910201", Technician.ID, 41000, Employee.GENDER_WOMAN);
        em.add("Mary Martin", "431109", Programmer.ID, 47000, Employee.GENDER_WOMAN);
        em.displayAll();
        System.out.println();

        em.update(2, null, null, Programmer.ID, null, null);
        em.displayAll();

        //em.search(null, null, Secretary.ID);
        //em.delete(1);
        //em.displayAll();        
    }

}
