package employee;

public class Technician extends Employee {

    // Multiplier for calculating the bonus
    private static final double BONUS_MULTIPLIER = 1.7;

    public Technician(Employee e) {
        super(e);
    }

    public Technician(String name, String birthday, int salary, Gender gender) {
        super(name, birthday, salary, gender);
    }

    @Override
    public int calculateBonus() {
        return (int) (this.getSalary() * BONUS_MULTIPLIER);
    }

}
