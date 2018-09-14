package employee;

public class Technician extends Employee {

    /**
     * Technician identifier. Should be unique among Employee subclasses.
     */
    public static final int ID = 2;
    // Multiplier for calculating the bonus
    private static final double BONUS_MULTIPLIER = 1.7;

    public Technician(Employee e) {
        super(e);
    }

    public Technician(String name, String birthday, int salary, String gender) {
        super(name, birthday, salary, gender);
    }

    @Override
    public int calculateBonus() {
        return (int) (this.getSalary() * BONUS_MULTIPLIER);
    }

}
