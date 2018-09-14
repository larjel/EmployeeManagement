package employee;

public class Programmer extends Employee {

    /**
     * Programmer identifier. Should be unique among Employee subclasses.
     */
    public static final int ID = 3;
    // Multiplier for calculating the bonus
    private static final double BONUS_MULTIPLIER = 2.3;

    public Programmer(Employee e) {
        super(e);
    }

    public Programmer(String name, String birthday, int salary, String gender) {
        super(name, birthday, salary, gender);
    }

    @Override
    public int calculateBonus() {
        return (int) (this.getSalary() * BONUS_MULTIPLIER);
    }

}
