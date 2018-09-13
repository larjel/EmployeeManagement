package laboration2;

import employee.Employee;
import employee.Programmer;
import employee.Secretary;
import employee.Technician;

public class Laboration2 {

    // Wrapper class for Scanner. Handles exceptions & buffer flushing.
    private final static SystemInput SI = new SystemInput();
    // Handles Employee list and operations on the list
    private final static EmployeeManager EM = new EmployeeManager();

    public static void main(String[] args) {
        while (mainMenu()) {
        }
    }

    /**
     * Main menu handler
     *
     * @return true if to continue, false if to exit
     */
    private static boolean mainMenu() {
        System.out.println("1. Employee management (add, update, delete)");
        System.out.println("2. Employee statistics");
        System.out.println("3. Exit");

        switch (SI.getInt()) {
            case 1:
                while (employeeManagementMenu()) {
                }
                break;
            case 2:
                while (employeeStatisticsMenu()) {
                }
                break;
            case 3:
                return false;
            default:
                System.out.println("Invalid menu choice! Try again.");
                break;
        }
        return true;
    }

    /**
     * Employee management menu
     *
     * @return true if to continue, false if to exit
     */
    private static boolean employeeManagementMenu() {
        System.out.println("1. Register employee");
        System.out.println("2. Delete employee");
        System.out.println("3. Update name of employee");
        System.out.println("4. Update the birthdate of employee");
        System.out.println("5. Update the department of employee");
        System.out.println("6. Update Salary of employee");
        System.out.println("7. Search employee by name");
        System.out.println("8. Search employee number");
        System.out.println("9. Search employee by department");
        System.out.println("10. Display all employees");
        System.out.println("0. Back to main menu");

        switch (SI.getInt()) {
            case 0:
                return false;
            case 1:
                registerEmployee();
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
            case 10:
                EM.displayAll();
                break;
            default:
                System.out.println("Invalid menu choice! Try again.");
                break;
        }
        return true;
    }

    private static void registerEmployee() {
        System.out.print("First name: ");
        String fname = SI.getString().trim();
        System.out.print("Last name: ");
        String lname = SI.getString().trim();
        System.out.print("Birthday (YYMMDD): ");
        String birthday = SI.getString().trim();
        System.out.print("Salary: ");
        int salary = SI.getInt();
        System.out.print("Profession/department (");
        System.out.print(Secretary.ID + "=Secretary, " + Technician.ID + "=Technician, " + Programmer.ID + "=Programmer): ");
        int profession = SI.getInt();
        System.out.print("Gender (1=Man, 2=Woman, 3=Undefined): ");
        int gender = SI.getInt();
        String genderString = Employee.GENDER_UNDEFINED;
        if (gender == 1) {
            genderString = Employee.GENDER_MAN;
        } else if (gender == 2) {
            genderString = Employee.GENDER_WOMAN;
        }
        if (EM.add(fname + " " + lname, birthday, profession, salary, genderString)) {
            System.out.println("Employee successfully registered!");
        } else {
            System.out.println("Error! Failure to register employee.");
        }
    }

    /**
     * Employee statistics menu
     *
     * @return true if to continue, false if to exit
     */
    private static boolean employeeStatisticsMenu() {
        System.out.println("1. Average wage at the company");
        System.out.println("2. Maximum salary in the company");
        System.out.println("3. Minimum salary in the company");
        System.out.println("4. Total bonus");
        System.out.println("5. Women in percentage in the company");
        System.out.println("6. Men percentage of the various work role categories");
        System.out.println("0. Back to Main Menu");

        switch (SI.getInt()) {
            case 0:
                return false;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            default:
                System.out.println("Invalid menu choice! Try again.");
                break;
        }
        return true;
    }

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
