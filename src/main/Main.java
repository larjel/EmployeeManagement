package main;

import userio.MenuHandler;
import employee.management.EmployeeManager;
import employee.Programmer;
import employee.Secretary;
import employee.Technician;

/**
 * Lab 2: Employee Management System
 */
public class Main {

    /**
     * Program entry point
     *
     * @param args Caller arguments [Not used]
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

        em.add("Anders Andersson", "660101", Secretary.ID, 30000, "Man");
        em.add("Sven Svensson", "880101", Technician.ID, 45000, "Woman");
        em.add("Arne", "880101", Technician.ID, 41000, "Woman");
        em.displayAll();
        System.out.println();

        em.update(2, null, null, Programmer.ID, null, null);
        em.displayAll();

        //em.search(null, null, Secretary.ID);
        //em.delete(1);
        //em.displayAll();        
    }

}
