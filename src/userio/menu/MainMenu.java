package userio.menu;

import employee.management.EmployeeManager;
import userio.SystemInput;

public class MainMenu {

    // Wrapper class for Scanner. Handles exceptions & buffer flushing.
    private final SystemInput systemInput;
    // Handles Employee list and operations on the list
    private final EmployeeManager employeeManager;
    // Sub-menu for employee management
    private final ManagementMenu managementMenu;
    // Sub-menu for employee statistics
    private final StatisticsMenu statisticsMenu;

    // Default message if menu selection number is invalid
    public static final String INVALID_MENU_CHOICE = ">>> Invalid menu choice! Try again.";

    /**
     * Constructor
     */
    public MainMenu() {
        employeeManager = new EmployeeManager();
        systemInput = new SystemInput();
        managementMenu = new ManagementMenu(employeeManager, systemInput);
        statisticsMenu = new StatisticsMenu(employeeManager, systemInput);
    }

    /**
     * Main menu handler
     *
     * @return true if to continue, false if to exit
     */
    public boolean showMainMenu() {
        System.out.println("================ MAIN MENU =================");
        System.out.println("1. Employee management (add, update, delete)");
        System.out.println("2. Employee statistics");
        System.out.println("3. Exit");
        System.out.println("--------------------------------------------");
        System.out.print("> ");

        final int choice = systemInput.getInt();
        switch (choice) {
            case 1: // Employee management
                while (managementMenu.showManagementMenu()) {
                }
                break;
            case 2: // Employee statistics
                while (statisticsMenu.showStatisticsMenu()) {
                }
                break;
            case 3: // Exit
                return false;
            default:
                System.out.println(INVALID_MENU_CHOICE);
                break;
        }
        return true;
    }

    /**
     * Get the Employee Manager used by the instance (may be used for testing)
     *
     * @return Employee manager
     */
    public EmployeeManager getEmployeeManager() {
        return employeeManager;
    }

}
