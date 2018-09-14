package employee.management;

import employee.Employee;
import employee.Programmer;
import employee.Secretary;
import employee.Technician;
import java.util.ArrayList;

public class EmployeeManager {

    /**
     * Holds all Employees
     */
    private final ArrayList<Employee> employees = new ArrayList<>();

    /**
     * Add a new Employee
     *
     * @param name Name on format "[First name] [Last name]"
     * @param birthday Birthday on format YYMMDD
     * @param profession Secretary.ID, Technician.ID or Programmer.ID
     * @param salary Salary
     * @param gender Employee.GENDER_MAN, Employee.GENDER_WOMAN or
     * Employee.GENDER_UNDEFINED
     * @return 'true' if employee was successfully added or 'false' if failure
     */
    public boolean add(String name, String birthday, int profession, int salary, String gender) {
        Employee employee;
        switch (profession) {
            case Secretary.ID:
                employee = new Secretary(name, birthday, salary, gender);
                break;
            case Technician.ID:
                employee = new Technician(name, birthday, salary, gender);
                break;
            case Programmer.ID:
                employee = new Programmer(name, birthday, salary, gender);
                break;
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
     * @return 'true' if delete successful, else 'false'
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
     * @param birthday Birthday on format YYMMDD
     * @param profession Secretary.ID, Technician.ID or Programmer.ID
     * @param salary Salary
     * @param gender Employee.GENDER_MAN, Employee.GENDER_WOMAN or
     * @return 'true' if update successful, else 'false'
     */
    public boolean update(int employeeId, String name, String birthday, Integer profession, Integer salary, String gender) {
        int indexOfEmployee = getIndexOfEmployee(employeeId);
        if (indexOfEmployee != -1) {
            Employee employee = employees.get(indexOfEmployee);
            if (name != null) {
                employee.setName(name);
            }
            if (birthday != null) {
                employee.setBirthday(birthday);
            }
            if (salary != null) {
                employee.setSalary(salary);
            }
            if (gender != null) {
                employee.setGender(gender);
            }
            if (profession != null) {
                switch (profession) {
                    case Secretary.ID: {
                        Secretary secretary = new Secretary(employee);
                        employees.set(indexOfEmployee, secretary);
                        break;
                    }
                    case Technician.ID: {
                        Technician technician = new Technician(employee);
                        employees.set(indexOfEmployee, technician);
                        break;
                    }
                    case Programmer.ID: {
                        Programmer programmer = new Programmer(employee);
                        employees.set(indexOfEmployee, programmer);
                        break;
                    }
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
        System.out.print(", Birthday=" + employee.getBirthday());
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
     * @param employeeId Mandatory identifier of employee to update.
     * @param name Name on format "[First name] [Last name]" (case insensitive)
     * @param profession Secretary.ID, Technician.ID or Programmer.ID
     */
    public void search(Integer employeeId, String name, Integer profession) {
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
                    case Secretary.ID:
                        if (employee instanceof Secretary) {
                            show = true;
                        }
                        break;
                    case Technician.ID:
                        if (employee instanceof Technician) {
                            show = true;
                        }
                        break;
                    case Programmer.ID:
                        if (employee instanceof Programmer) {
                            show = true;
                        }
                        break;
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
        if (employees.size() > 0) {
            System.out.println("=== Displaying all " + employees.size() + " employees ===");
            for (Employee employee : employees) {
                displayEmployee(employee);
            }
        } else {
            System.out.println("[No employees registered]");
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
