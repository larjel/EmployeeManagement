package userio.menu;

import employee.Employee;
import employee.Profession;
import employee.management.EmployeeManager;
import userio.SystemInput;

class ManagementMenu {

    // Wrapper class for Scanner. Handles exceptions & buffer flushing.
    private final SystemInput systemInput;
    // Handles Employee list and operations on the list
    private final EmployeeManager employeeManager;

    // Menu option constants for actions on employee(s)
    private static final int OPT_REGISTER = 1;
    private static final int OPT_DELETE = 2;
    private static final int OPT_UPDATE_NAME = 3;
    private static final int OPT_UPDATE_BIRTHDAY = 4;
    private static final int OPT_UPDATE_PROFESSION = 5;
    private static final int OPT_UPDATE_SALARY = 6;
    private static final int OPT_SEARCH_BY_NAME = 7;
    private static final int OPT_SEARCH_BY_ID_NUMBER = 8;
    private static final int OPT_SEARCH_BY_PROFESSION = 9;
    private static final int OPT_DISPLAY_ALL = 10;
    private static final int OPT_EXIT = 0;

    /**
     * Constructor
     *
     * @param employeeManager
     * @param systemInput
     */
    protected ManagementMenu(EmployeeManager employeeManager, SystemInput systemInput) {
        this.employeeManager = employeeManager;
        this.systemInput = systemInput;
    }

    /**
     * Employee management menu
     *
     * @return true if to continue, false if to exit
     */
    protected boolean showManagementMenu() {
        System.out.println("============ EMPLOYEE MANAGEMENT =============");
        System.out.println(OPT_REGISTER + ". Register employee");
        System.out.println(OPT_DELETE + ". Delete employee");
        System.out.println(OPT_UPDATE_NAME + ". Update name of employee");
        System.out.println(OPT_UPDATE_BIRTHDAY + ". Update the birthdate of employee");
        System.out.println(OPT_UPDATE_PROFESSION + ". Update the profession/department of employee");
        System.out.println(OPT_UPDATE_SALARY + ". Update salary of employee");
        System.out.println(OPT_SEARCH_BY_NAME + ". Search employee by name");
        System.out.println(OPT_SEARCH_BY_ID_NUMBER + ". Search employee ID number");
        System.out.println(OPT_SEARCH_BY_PROFESSION + ". Search employee by profession/department");
        System.out.println(OPT_DISPLAY_ALL + ". Display all employees");
        System.out.println(OPT_EXIT + ". Back to main menu");
        System.out.println("----------------------------------------------");
        System.out.print("> ");

        final int option = systemInput.getInt();
        switch (option) {
            case OPT_EXIT:
                return false;
            case OPT_REGISTER:
                registerEmployee();
                break;
            case OPT_DELETE: {
                deleteEmployee();
                break;
            }
            case OPT_UPDATE_NAME:
            case OPT_UPDATE_BIRTHDAY:
            case OPT_UPDATE_PROFESSION:
            case OPT_UPDATE_SALARY:
                updateEmployee(option);
                break;
            case OPT_SEARCH_BY_NAME:
            case OPT_SEARCH_BY_ID_NUMBER:
            case OPT_SEARCH_BY_PROFESSION:
                searchEmployee(option);
                break;
            case OPT_DISPLAY_ALL:
                employeeManager.displayAll();
                break;
            default:
                System.out.println(MainMenu.INVALID_MENU_CHOICE);
                break;
        }

        System.out.println("Press Enter to continue...");
        systemInput.getString();

        return true;
    }

    private void deleteEmployee() {
        System.out.print("ID of employee to delete: ");
        int employeeId = systemInput.getInt();
        if (employeeManager.delete(employeeId)) {
            System.out.println(">>> Employee successfully deleted.");
        } else {
            System.out.println(">>> Error! Employee deletion failed.");
        }
    }

    /**
     * Get user input for profession and map to enumeration.
     *
     * @return Profession enumeration or null if bad input
     */
    private Profession getProfession() {
        System.out.print("Profession/department (1=Secretary, 2=Technician, 3=Programmer): ");
        Profession profession;
        switch (systemInput.getInt()) {
            case 1:
                profession = Profession.SECRETARY;
                break;
            case 2:
                profession = Profession.TECHNICIAN;
                break;
            case 3:
                profession = Profession.PROGRAMMER;
                break;
            default:
                profession = Profession.INVALID;
                break;
        }
        return profession;
    }

    /**
     * Search for an employee
     *
     * @param option What field to use for search
     */
    private void searchEmployee(int option) {
        switch (option) {
            case OPT_SEARCH_BY_NAME: {
                System.out.print("First name: ");
                String fname = systemInput.getString().trim();
                System.out.print("Last name: ");
                String lname = systemInput.getString().trim();
                employeeManager.search(null, fname + " " + lname, null);
                break;
            }
            case OPT_SEARCH_BY_ID_NUMBER: {
                System.out.print("Employee ID number: ");
                int employeeId = systemInput.getInt();
                employeeManager.search(employeeId, null, null);
                break;
            }
            case OPT_SEARCH_BY_PROFESSION: {
                Profession profession = getProfession();
                employeeManager.search(null, null, profession);
                break;
            }
            default:
                break;
        }
    }

    /**
     * Update employee information
     *
     * @param option What field to update
     */
    private void updateEmployee(int option) {
        System.out.print("ID of employee to update: ");
        int employeeId = systemInput.getInt();

        boolean success;
        switch (option) {
            case OPT_UPDATE_NAME: {
                System.out.print("New first name: ");
                String fname = systemInput.getString().trim();
                System.out.print("New last name: ");
                String lname = systemInput.getString().trim();
                success = employeeManager.update(employeeId, fname + " " + lname, null, null, null, null);
                break;
            }
            case OPT_UPDATE_BIRTHDAY: {
                System.out.print("New (corrected) birthday (YYYYMMDD): ");
                String birthday = systemInput.getString().trim();
                success = employeeManager.update(employeeId, null, birthday, null, null, null);
                break;
            }
            case OPT_UPDATE_PROFESSION: {
                Profession profession = getProfession();
                success = employeeManager.update(employeeId, null, null, profession, null, null);
                break;
            }
            case OPT_UPDATE_SALARY: {
                System.out.print("New salary: ");
                int salary = systemInput.getInt();
                success = employeeManager.update(employeeId, null, null, null, salary, null);
                break;
            }
            default:
                success = false;
                break;
        }

        if (success) {
            System.out.println(">>> Employee successfully updated.");
        } else {
            System.out.println(">>> Error! Employee update failed. Bad input?");
        }
    }

    /**
     * Register employee
     */
    private void registerEmployee() {
        System.out.print("First name: ");
        String fname = systemInput.getString().trim();
        System.out.print("Last name: ");
        String lname = systemInput.getString().trim();
        System.out.print("Birthday (YYYYMMDD): ");
        String birthday = systemInput.getString().trim();
        System.out.print("Salary: ");
        int salary = systemInput.getInt();
        Profession profession = getProfession();
        System.out.print("Gender (1=Man, 2=Woman, 3=Undefined): ");
        int gender = systemInput.getInt();
        String genderString = Employee.GENDER_UNDEFINED;
        if (gender == 1) {
            genderString = Employee.GENDER_MAN;
        } else if (gender == 2) {
            genderString = Employee.GENDER_WOMAN;
        }
        if (employeeManager.add(fname + " " + lname, birthday, profession, salary, genderString)) {
            System.out.println(">>> Employee successfully registered!");
        } else {
            System.out.println(">>> Error! Failure to register employee. Bad input?");
        }
    }

}
