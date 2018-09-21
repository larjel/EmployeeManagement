package userio.menu;

import employee.management.EmployeeManager;
import employee.management.EmployeeStatistics;
import userio.SystemInput;

class StatisticsMenu {

    // Wrapper class for Scanner. Handles exceptions & buffer flushing.
    private final SystemInput systemInput;
    // Handles calculation and displaying of employee statistics
    private final EmployeeStatistics employeeStatistics;

    /**
     * Constructor
     *
     * @param employeeManager
     * @param systemInput
     */
    protected StatisticsMenu(EmployeeManager employeeManager, SystemInput systemInput) {
        this.systemInput = systemInput;
        this.employeeStatistics = new EmployeeStatistics(employeeManager);
    }

    /**
     * Employee statistics menu
     *
     * @return true if to continue, false if to exit
     */
    protected boolean showStatisticsMenu() {
        System.out.println("=========== EMPLOYEE STATISTICS ============");
        System.out.println("1. Average salary at the company");
        System.out.println("2. Maximum salary in the company");
        System.out.println("3. Minimum salary in the company");
        System.out.println("4. Total bonus");
        System.out.println("5. Women in percentage in the company");
        System.out.println("6. Men percentage of the various work role categories");
        System.out.println("0. Back to Main Menu");
        System.out.println("--------------------------------------------");
        System.out.print("> ");

        final int choice = systemInput.getInt();
        switch (choice) {
            case 0: // Back to Main Menu
                return false;
            case 1: // Average salary at the company
                employeeStatistics.displayAverageSalary();
                break;
            case 2: // Maximum salary in the company
                employeeStatistics.displayMaxSalary();
                break;
            case 3: // Minimum salary in the company
                employeeStatistics.displayMinSalary();
                break;
            case 4: // Total bonus
                employeeStatistics.displayTotalBonus();
                break;
            case 5: // Women in percentage in the company
                employeeStatistics.displayWomenStaffPercentage();
                break;
            case 6: // Men percentage of the various work role categories
                employeeStatistics.displayMenPercentageOfWorkRole();
                break;
            default:
                System.out.println(MainMenu.INVALID_MENU_CHOICE);
                break;
        }

        System.out.println("Press Enter to continue...");
        systemInput.getString();

        return true;
    }

}
