package userio.menu;

import employee.Employee;
import employee.Profession;
import employee.management.EmployeeManager;
import userio.SystemInput;

public class ManagementMenu {

    // Wrapper class for Scanner. Handles exceptions & buffer flushing.
    private final SystemInput systemInput;
    // Handles Employee list and operations on the list
    private final EmployeeManager employeeManager;

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
        System.out.println("1. Register employee");
        System.out.println("2. Delete employee");
        System.out.println("3. Update name of employee");
        System.out.println("4. Update the birthdate of employee");
        System.out.println("5. Update the profession/department of employee");
        System.out.println("6. Update salary of employee");
        System.out.println("7. Search employee by name");
        System.out.println("8. Search employee ID number");
        System.out.println("9. Search employee by profession/department");
        System.out.println("10. Display all employees");
        System.out.println("0. Back to main menu");
        System.out.println("----------------------------------------------");
        System.out.print("> ");

        int choice = systemInput.getInt();
        switch (choice) {
            case 0: // Exit
                return false;
            case 1: // Register employee
                registerEmployee();
                break;
            case 2: { // Delete employee
                deleteEmployee();
                break;
            }
            case 3: // Update name of employee
            case 4: // Update the birthdate of employee
            case 5: // Update the profession/department of employee
            case 6: // Update Salary of employee
                updateEmployee(choice);
                break;
            case 7: // Search employee by name
            case 8: // Search employee ID number
            case 9: // Search employee by profession/department
                searchEmployee(choice);
                break;
            case 10: // Display all employees
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
     * @param searchAction What field to use for search
     */
    private void searchEmployee(int searchAction) {
        switch (searchAction) {
            case 7: { // Search employee by name
                System.out.print("First name: ");
                String fname = systemInput.getString().trim();
                System.out.print("Last name: ");
                String lname = systemInput.getString().trim();
                employeeManager.search(null, fname + " " + lname, null);
                break;
            }
            case 8: { // Search employee by ID number
                System.out.print("Employee ID number: ");
                int employeeId = systemInput.getInt();
                employeeManager.search(employeeId, null, null);
                break;
            }
            case 9: { // Search employee by department
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
     * @param updateAction What field to update
     */
    private void updateEmployee(int updateAction) {
        System.out.print("ID of employee to update: ");
        int employeeId = systemInput.getInt();

        boolean success;
        switch (updateAction) {
            case 3: { // Update name of employee
                System.out.print("New first name: ");
                String fname = systemInput.getString().trim();
                System.out.print("New last name: ");
                String lname = systemInput.getString().trim();
                success = employeeManager.update(employeeId, fname + " " + lname, null, null, null, null);
                break;
            }
            case 4: { // Update the birthdate of employee
                System.out.print("New (corrected) birthday (YYYYMMDD): ");
                String birthday = systemInput.getString().trim();
                success = employeeManager.update(employeeId, null, birthday, null, null, null);
                break;
            }
            case 5: { // Update the profession/department of employee
                Profession profession = getProfession();
                success = employeeManager.update(employeeId, null, null, profession, null, null);
                break;
            }
            case 6: { // Update Salary of employee
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
