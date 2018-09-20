package employee.management;

import employee.*;
import java.util.ArrayList;

public class EmployeeStatistics {

    private final ArrayList<Employee> employees;

    /**
     * Constructor
     *
     * @param em The EmployeeManager to get the employee list to process
     */
    public EmployeeStatistics(EmployeeManager em) {
        this.employees = em.getEmployees();
    }

    public void displayAverageSalary() {
        int average = 0;
        if (employees.size() > 0) {
            int total = 0;
            for (Employee employee : employees) {
                total += employee.getSalary();
            }
            average = total / employees.size();
        }
        System.out.println("Average salary: " + average);
    }

    public void displayMaxSalary() {
        int max = 0;
        for (Employee employee : employees) {
            if (employee.getSalary() > max) {
                max = employee.getSalary();
            }
        }
        System.out.println("Maximum salary: " + max);
    }

    public void displayMinSalary() {
        int min = 0;
        if (employees.size() > 0) {
            min = Integer.MAX_VALUE;
            for (Employee employee : employees) {
                if (employee.getSalary() < min) {
                    min = employee.getSalary();
                }
            }
        }
        System.out.println("Minimum salary: " + min);
    }

    public void displayTotalBonus() {
        int totalBonus = 0;
        for (Employee employee : employees) {
            totalBonus += employee.calculateBonus();
        }
        System.out.println("Total bonus: " + totalBonus);
    }

    public void displayWomenStaffPercentage() {
        int nWomen = 0;
        int womenPercentage = 0;
        if (employees.size() > 0) {
            for (Employee employee : employees) {
                if (employee.getGender().equals(Employee.GENDER_WOMAN)) {
                    nWomen++;
                }
            }
            womenPercentage = 100 * nWomen / employees.size();
        }
        System.out.println("Women in the staff: " + womenPercentage + "%");
    }

    public void displayMenPercentageOfWorkRole() {
        int nSecretariesTotal = 0;
        int nTechniciansTotal = 0;
        int nProgrammersTotal = 0;
        int nSecretariesMen = 0;
        int nTechniciansMen = 0;
        int nProgrammersMen = 0;

        int secretariesMenPercentage = 0;
        int techniciansMenPercentage = 0;
        int programmersMenPercentage = 0;

        for (Employee employee : employees) {
            if (employee instanceof Secretary) {
                nSecretariesTotal++;
                if (employee.getGender().equals(Employee.GENDER_MAN)) {
                    nSecretariesMen++;
                }
            } else if (employee instanceof Technician) {
                nTechniciansTotal++;
                if (employee.getGender().equals(Employee.GENDER_MAN)) {
                    nTechniciansMen++;
                }
            } else if (employee instanceof Programmer) {
                nProgrammersTotal++;
                if (employee.getGender().equals(Employee.GENDER_MAN)) {
                    nProgrammersMen++;
                }
            }
        }

        if (nSecretariesMen > 0) {
            secretariesMenPercentage = 100 * nSecretariesMen / nSecretariesTotal;
        }
        if (nTechniciansMen > 0) {
            techniciansMenPercentage = 100 * nTechniciansMen / nTechniciansTotal;
        }
        if (nProgrammersMen > 0) {
            programmersMenPercentage = 100 * nProgrammersMen / nProgrammersTotal;
        }

        System.out.println("Men percentage of Secretaries: " + secretariesMenPercentage + "%");
        System.out.println("Men percentage of Technicians: " + techniciansMenPercentage + "%");
        System.out.println("Men percentage of Programmers: " + programmersMenPercentage + "%");
    }

}
