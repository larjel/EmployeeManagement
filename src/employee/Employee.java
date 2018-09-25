package employee;

public abstract class Employee {

    private String name;
    private String birthday;
    private int salary;
    private Gender gender;
    private final int employeeId;

    static int idGenerator = 1;

    /**
     * Copy constructor
     *
     * @param e Employee instance to copy fields from
     */
    protected Employee(Employee e) {
        name = e.name;
        birthday = e.birthday;
        salary = e.salary;
        gender = e.gender;
        employeeId = e.employeeId;
    }

    /**
     * Constructor
     *
     * @param name Name on format "[First name] [Last name]"
     * @param birthday Birthday on format YYYYMMDD
     * @param salary Salary
     * @param gender Gender.MAN, Gender.WOMAN or Gender.UNDEFINED
     */
    protected Employee(String name, String birthday, int salary, Gender gender) {
        this.employeeId = idGenerator++;
        this.name = name;
        this.birthday = birthday;
        this.salary = salary;
        this.gender = gender;
    }

    /**
     * Calculate bonus
     *
     * @return Calculated bonus
     */
    public abstract int calculateBonus();

    @Override
    public String toString() {
        return System.lineSeparator() + "Employee{" + "name=" + name
                + ", birthday=" + birthday + ", salary=" + salary
                + ", gender=" + gender + ", employeeId=" + employeeId + '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getEmployeeId() {
        return employeeId;
    }

}
