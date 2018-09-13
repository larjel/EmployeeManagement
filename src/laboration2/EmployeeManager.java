package laboration2;

import employee.Employee;
import employee.Programmer;
import employee.Secretary;
import employee.Technician;
import java.util.ArrayList;

public class EmployeeManager {

    ArrayList<Employee> employees = new ArrayList<>();

    public void add(String name, String birthDate, int department, int salary, String gender) {
        Employee e;
        switch (department) {
            case 1: // Secretary
                e = new Secretary(name, birthDate, salary, gender);
                break;
            case 2: // Technician
                e = new Technician(name, birthDate, salary, gender);
                break;
            case 3: // Programmer
                e = new Programmer(name, birthDate, salary, gender);
                break;
            default:
                e = null;
                break;
        }
        if (e != null) {
            employees.add(e);
        }
    }

    private int getIndexOfEmployee(int employeeId) {
        for (int i = 0; i < employees.size(); i++) {
            Employee e = employees.get(i);
            if (e.getEmployeeId() == employeeId) {
                return i;
            }
        }
        return -1; // Not found
    }

    public void delete(int employeeId) {
        int i = getIndexOfEmployee(employeeId);
        if (i != -1) {
            employees.remove(i);
        }
    }

    public void update(int employeeId, String name, String birthDate, Integer department, Integer salary, String gender) {
        int i = getIndexOfEmployee(employeeId);
        if (i != -1) {
            Employee e = employees.get(i);
            if (name != null) {
                e.setName(name);
            }
            if (birthDate != null) {
                e.setBirthDate(birthDate);
            }
            if (department != null) {

            }
            if (salary != null) {
                e.setSalary(salary);
            }
            if (gender != null) {
                e.setGender(gender);
            }
        }
    }

    public void displayAll() {
        for (Employee employee : employees) {
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
    }

    @Override
    public String toString() {
        return "EmployeeManager{" + "employees=" + employees + '}';
    }
}
