package employee;

public class Secretary extends Employee {

    /**
     * Secretary identifier. Should be unique among Employee subclasses.
     */
    public static final int ID = 1;

    public Secretary(Employee e) {
        super(e);
    }

    public Secretary(String name, String birthDate, int salary, String gender) {
        super(name, birthDate, salary, gender);
    }

    @Override
    public int calculateBonus() {
        return 0;
    }

}
