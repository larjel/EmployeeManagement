package employee.management;

import employee.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

public class EmployeeManager {

    /**
     * Holds all Employees
     */
    private final ArrayList<Employee> employees = new ArrayList<>();
    /**
     * Used date format: YYYYMMDD
     */
    private final static DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyyMMdd");

    /**
     * Verify that the user birthday input is a proper date. If so, return it as
     * a LocalDate instance.
     *
     * @param birthday User input date (should be on format YYYYMMDD)
     * @return LocalDate instance if successful, else null
     */
    private LocalDate verifyBirthdayInput(String birthday) {
        try {
            return LocalDate.parse(birthday, DATE_FORMAT);
        } catch (DateTimeParseException e) {
            return null; // Bad format
        }
    }

    /**
     * Add a new Employee
     *
     * @param name Name on format "[First name] [Last name]"
     * @param birthday Birthday on format YYYYMMDD
     * @param profession SECRETARY, TECHNICIAN or PROGRAMMER
     * @param salary Salary
     * @param gender Gender.MAN, Gender.WOMAN or Gender.UNDEFINED
     * @return true if employee was successfully added or false if failure
     */
    public boolean add(String name, String birthday, Profession profession, int salary, Gender gender) {
        LocalDate localDateBirthday = verifyBirthdayInput(birthday);
        if (localDateBirthday == null) {
            return false;
        }
        Employee employee;
        switch (profession) {
            case SECRETARY:
                employee = new Secretary(name, localDateBirthday, salary, gender);
                break;
            case TECHNICIAN:
                employee = new Technician(name, localDateBirthday, salary, gender);
                break;
            case PROGRAMMER:
                employee = new Programmer(name, localDateBirthday, salary, gender);
                break;
            case INVALID:
            default:
                employee = null;
                break;
        }

        if (employee != null) {
            employees.add(employee);
            return true;
        }
        return false;
    }

    /**
     * Get the array list index of Employee with given employee ID
     *
     * @param employeeId Unique ID of employee to find
     * @return Index of Employee in array list or -1 if no Employee found
     */
    private int getIndexOfEmployee(int employeeId) {
        for (int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);
            if (employee.getEmployeeId() == employeeId) {
                return i;
            }
        }
        return -1; // Not found
    }

    /**
     * Delete one employee
     *
     * @param employeeId Unique ID of employee to delete
     * @return true if delete successful, else false
     */
    public boolean delete(int employeeId) {
        int indexOfEmployee = getIndexOfEmployee(employeeId);
        if (indexOfEmployee != -1) {
            employees.remove(indexOfEmployee);
            return true;
        }
        return false;
    }

    /**
     * Update employee. Fields NOT to update should be passed as 'null'.
     *
     * @param employeeId Mandatory identifier of employee to update.
     * @param name Name on format "[First name] [Last name]"
     * @param birthday Birthday on format YYYYMMDD
     * @param profession SECRETARY, TECHNICIAN or PROGRAMMER
     * @param salary Salary
     * @param gender Gender.MAN, Gender.WOMAN or Gender.UNDEFINED
     * @return true if update successful, else false
     */
    public boolean update(int employeeId, String name, String birthday, Profession profession, Integer salary, Gender gender) {
        int indexOfEmployee = getIndexOfEmployee(employeeId);
        if (indexOfEmployee != -1) {
            Employee employee = employees.get(indexOfEmployee);
            if (name != null) {
                employee.setName(name);
            }
            if (birthday != null) {
                LocalDate localDateBirthday = verifyBirthdayInput(birthday);
                if (localDateBirthday == null) {
                    return false;
                }
                employee.setBirthday(localDateBirthday);
            }
            if (salary != null) {
                employee.setSalary(salary);
            }
            if (gender != null) {
                employee.setGender(gender);
            }
            if (profession != null) {
                switch (profession) {
                    case SECRETARY:
                        Secretary secretary = new Secretary(employee);
                        employees.set(indexOfEmployee, secretary);
                        break;
                    case TECHNICIAN:
                        Technician technician = new Technician(employee);
                        employees.set(indexOfEmployee, technician);
                        break;
                    case PROGRAMMER:
                        Programmer programmer = new Programmer(employee);
                        employees.set(indexOfEmployee, programmer);
                        break;
                    case INVALID:
                    default:
                        // Faulty profession
                        return false;
                }
            }
            return true; // Success!
        }
        return false; // Error. Employee not found.
    }

    /**
     * Display information about one employee
     *
     * @param employee
     */
    private void displayEmployee(Employee employee) {
        System.out.print("ID=" + employee.getEmployeeId());
        System.out.print(", Name=" + employee.getName());
        System.out.print(", Gender=" + employee.getGender());
        System.out.print(", Birthday=" + employee.getBirthday().format(DATE_FORMAT));
        System.out.print(", Salary=" + employee.getSalary());
        System.out.print(", Bonus=" + employee.calculateBonus());

        System.out.print(", Profession=");
        if (employee instanceof Secretary) {
            System.out.println("Secretary");
        } else if (employee instanceof Technician) {
            System.out.println("Technician");
        } else if (employee instanceof Programmer) {
            System.out.println("Programmer");
        } else {
            System.out.println("Unspecified");
        }
    }

    /**
     * Search and display an employee based on given arguments. Fields NOT to
     * search for should be passed as 'null'.
     *
     * @param employeeId Identifier of employee to search for
     * @param name Name on format "[First name] [Last name]" (case insensitive)
     * to search for
     * @param profession Profession SECRETARY, TECHNICIAN or PROGRAMMER to
     * search for
     */
    public void search(Integer employeeId, String name, Profession profession) {
        boolean found = false;
        for (Employee employee : employees) {
            boolean show = false;
            if (employeeId != null && employeeId.equals(employee.getEmployeeId())) {
                show = true;
            }
            if (name != null && name.equalsIgnoreCase(employee.getName())) {
                show = true;
            }
            if (profession != null) {
                switch (profession) {
                    case SECRETARY:
                        if (employee instanceof Secretary) {
                            show = true;
                        }
                        break;
                    case TECHNICIAN:
                        if (employee instanceof Technician) {
                            show = true;
                        }
                        break;
                    case PROGRAMMER:
                        if (employee instanceof Programmer) {
                            show = true;
                        }
                        break;
                    case INVALID:
                    default:
                        break;
                }
            }
            if (show) {
                if (!found) {
                    found = true;
                    System.out.println(">>> Employee(s) found:");
                }
                displayEmployee(employee);
            }
        }
        if (!found) {
            System.out.println(">>> Employee(s) not found!");
        }
    }

    /**
     * Display all employees
     */
    public void displayAll() {
        if (employees.isEmpty()) {
            System.out.println("[No employees registered]");
        } else {
            System.out.println("=== Displaying all " + employees.size() + " employees ===");
            for (Employee employee : employees) {
                displayEmployee(employee);
            }
        }
    }

    @Override
    public String toString() {
        return "EmployeeManager{" + "employees=" + employees + '}';
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

}
