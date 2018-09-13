package employee;

public abstract class Employee {
    
    public static final String GENDER_MAN = "Man";
    public static final String GENDER_WOMAN = "Woman";
    public static final String GENDER_UNDEFINED = "Undefined";

    private String name;
    private String birthDate;
    private int salary;
    private String gender;
    private final int employeeId;

    static int idGenerator = 1;

    /**
     * Copy constructor
     * @param e Employee instance to copy fields from
     */
    public Employee(Employee e) {
        name = e.name;
        birthDate = e.birthDate;
        salary = e.salary;
        gender = e.gender;
        employeeId = e.employeeId;
    }

    /**
     * Constructor
     * @param name
     * @param birthDate
     * @param salary
     * @param gender 
     */
    public Employee(String name, String birthDate, int salary, String gender) {
        this.employeeId = idGenerator++;
        this.name = name;
        this.birthDate = birthDate;
        this.salary = salary;
        this.gender = gender;
    }

    /**
     * Calculate bonus
     * @return Calculated bonus
     */
    public abstract int calculateBonus();

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
