package employee;

public class Programmer extends Employee {

    /**
     * Programmer identifier. Should be unique among Employee subclasses.
     */
    public static final int ID = 3;

    public Programmer(Employee e) {
        super(e);
    }

    public Programmer(String name, String birthday, int salary, String gender) {
        super(name, birthday, salary, gender);
    }

    @Override
    public int calculateBonus() {
        return 0;
    }

}
