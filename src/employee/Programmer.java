package employee;

public class Programmer extends Employee {

    // Multiplier for calculating the bonus
    private static final double BONUS_MULTIPLIER = 2.3;

    public Programmer(Employee e) {
        super(e);
    }

    public Programmer(String name, String birthday, int salary, Gender gender) {
        super(name, birthday, salary, gender);
    }

    @Override
    public int calculateBonus() {
        return (int) (this.getSalary() * BONUS_MULTIPLIER);
    }

}
