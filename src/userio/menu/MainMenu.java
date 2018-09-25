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

    // Menu option constants
    private static final int OPT_EMPLOYEE_MANAGEMENT = 1;
    private static final int OPT_EMPLOYEE_STATISTICS = 2;
    private static final int OPT_EXIT = 3;

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
        System.out.println(OPT_EMPLOYEE_MANAGEMENT + ". Employee management (add, update, delete)");
        System.out.println(OPT_EMPLOYEE_STATISTICS + ". Employee statistics");
        System.out.println(OPT_EXIT + ". Exit");
        System.out.println("--------------------------------------------");
        System.out.print("> ");

        final int option = systemInput.getInt();
        switch (option) {
            case OPT_EMPLOYEE_MANAGEMENT:
                while (managementMenu.showManagementMenu()) {
                }
                break;
            case OPT_EMPLOYEE_STATISTICS:
                while (statisticsMenu.showStatisticsMenu()) {
                }
                break;
            case OPT_EXIT:
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
