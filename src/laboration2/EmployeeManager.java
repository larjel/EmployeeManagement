package laboration2;

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
     * @param birthDate Birthday on format YYMMDD
     * @param department Secretary.ID, Technician.ID or Programmer.ID
     * @param salary Salary
     * @param gender Employee.GENDER_MAN, Employee.GENDER_WOMAN or
     */
    public void add(String name, String birthDate, int department, int salary, String gender) {
        Employee employee;
        switch (department) {
            case Secretary.ID:
                employee = new Secretary(name, birthDate, salary, gender);
                break;
            case Technician.ID:
                employee = new Technician(name, birthDate, salary, gender);
                break;
            case Programmer.ID:
                employee = new Programmer(name, birthDate, salary, gender);
                break;
            default:
                employee = null;
                break;
        }

        if (employee != null) {
            employees.add(employee);
        }
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
     */
    public void delete(int employeeId) {
        int indexOfEmployee = getIndexOfEmployee(employeeId);
        if (indexOfEmployee != -1) {
            employees.remove(indexOfEmployee);
        }
    }

    /**
     * Update employee. Fields NOT to set should be passed as 'null'.
     *
     * @param employeeId Mandatory identifier of employee to update.
     * @param name Name on format "[First name] [Last name]"
     * @param birthDate Birthday on format YYMMDD
     * @param department Secretary.ID, Technician.ID or Programmer.ID
     * @param salary Salary
     * @param gender Employee.GENDER_MAN, Employee.GENDER_WOMAN or
     * Employee.GENDER_UNDEFINED
     */
    public void update(int employeeId, String name, String birthDate, Integer department, Integer salary, String gender) {
        int indexOfEmployee = getIndexOfEmployee(employeeId);
        if (indexOfEmployee != -1) {
            Employee employee = employees.get(indexOfEmployee);
            if (name != null) {
                employee.setName(name);
            }
            if (birthDate != null) {
                employee.setBirthDate(birthDate);
            }
            if (salary != null) {
                employee.setSalary(salary);
            }
            if (gender != null) {
                employee.setGender(gender);
            }
            if (department != null) {
                switch (department) {
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
                        // Faulty department
                        break;
                }
            }
        }
    }

    /**
     * Display information about one employee
     *
     * @param employee
     */
    private void displayEmployee(Employee employee) {
        System.out.print("Name: " + employee.getName());
        System.out.print(", Birthdate: " + employee.getBirthDate());
        System.out.print(", Salary: " + employee.getSalary());
        System.out.print(", Gender: " + employee.getGender());
        System.out.print(", ID: " + employee.getEmployeeId());

        if (employee instanceof Secretary) {
            System.out.println(", Dep: Secretary");
        } else if (employee instanceof Technician) {
            System.out.println(", Dep: Technician");
        } else if (employee instanceof Programmer) {
            System.out.println(", Dep: Programmer");
        }
    }

    /**
     * Search and display an employee based on given arguments. Fields NOT to
     * search for should be passed as 'null'.
     *
     * @param employeeId
     * @param name
     * @param department
     */
    public void search(Integer employeeId, String name, Integer department) {
        for (Employee employee : employees) {
            boolean show = false;
            if (employeeId != null && employeeId.equals(employee.getEmployeeId())) {
                show = true;
            }
            if (name != null && name.equals(employee.getName())) {
                show = true;
            }
            if (department != null) {
                switch (department) {
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
                displayEmployee(employee);
            }
        }
    }

    /**
     * Display all employees
     */
    public void displayAll() {
        for (Employee employee : employees) {
            displayEmployee(employee);
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
