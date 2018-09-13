package employee;

public abstract class Employee {

    private String name;
    private String birthDate;
    private int salary;
    private String gender;
    private final int employeeId;

    static int idGenerator = 1;

    public Employee(String name, String birthDate, int salary, String gender) {
        this.employeeId = idGenerator++;
        this.name = name;
        this.birthDate = birthDate;
        this.salary = salary;
        this.gender = gender;
    }

    public abstract int calculateBonus();

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Employee other = (Employee) obj;
        if (this.employeeId != other.employeeId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return System.lineSeparator() + "Employee{" + "name=" + name + ", birthDate=" + birthDate + ", salary=" + salary + ", gender=" + gender + ", employeeId=" + employeeId + '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getEmployeeId() {
        return employeeId;
    }

}
