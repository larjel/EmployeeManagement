package userio.menu;

import employee.management.EmployeeManager;
import employee.management.EmployeeStatistics;
import userio.SystemInput;

class StatisticsMenu {

    // Wrapper class for Scanner. Handles exceptions & buffer flushing.
    private final SystemInput systemInput;
    // Handles calculation and displaying of employee statistics
    private final EmployeeStatistics employeeStatistics;

    // Menu option constants for employee statistics
    private static final int OPT_AVERAGE_SALARY = 1;
    private static final int OPT_MAX_SALARY = 2;
    private static final int OPT_MIN_SALARY = 3;
    private static final int OPT_TOTAL_BONUS = 4;
    private static final int OPT_WOMEN_PERCENTAGE = 5;
    private static final int OPT_MEN_PERCENTAGE_OF_WORK_ROLE = 6;
    private static final int OPT_EXIT = 0;

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
        System.out.println(OPT_AVERAGE_SALARY + ". Average salary at the company");
        System.out.println(OPT_MAX_SALARY + ". Maximum salary in the company");
        System.out.println(OPT_MIN_SALARY + ". Minimum salary in the company");
        System.out.println(OPT_TOTAL_BONUS + ". Total bonus");
        System.out.println(OPT_WOMEN_PERCENTAGE + ". Women in percentage in the company");
        System.out.println(OPT_MEN_PERCENTAGE_OF_WORK_ROLE + ". Men percentage of the various work role categories");
        System.out.println(OPT_EXIT + ". Back to Main Menu");
        System.out.println("--------------------------------------------");
        System.out.print("> ");

        final int option = systemInput.getInt();
        switch (option) {
            case OPT_EXIT:
                return false;
            case OPT_AVERAGE_SALARY:
                employeeStatistics.displayAverageSalary();
                break;
            case OPT_MAX_SALARY:
                employeeStatistics.displayMaxSalary();
                break;
            case OPT_MIN_SALARY:
                employeeStatistics.displayMinSalary();
                break;
            case OPT_TOTAL_BONUS:
                employeeStatistics.displayTotalBonus();
                break;
            case OPT_WOMEN_PERCENTAGE:
                employeeStatistics.displayWomenStaffPercentage();
                break;
            case OPT_MEN_PERCENTAGE_OF_WORK_ROLE:
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
