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
            case Secretary.ID: // Secretary
                e = new Secretary(name, birthDate, salary, gender);
                break;
            case Technician.ID: // Technician
                e = new Technician(name, birthDate, salary, gender);
                break;
            case Programmer.ID: // Programmer
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
                //TODO: Fix!
            }
            if (salary != null) {
                e.setSalary(salary);
            }
            if (gender != null) {
                e.setGender(gender);
            }
        }
    }

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

    public void displayAll() {
        for (Employee employee : employees) {
            displayEmployee(employee);
        }
    }

    @Override
    public String toString() {
        return "EmployeeManager{" + "employees=" + employees + '}';
    }
}
