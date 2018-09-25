package employee;

import java.time.LocalDate;

public class Secretary extends Employee {

    // Multiplier for calculating the bonus
    private static final double BONUS_MULTIPLIER = 1.4;

    public Secretary(Employee e) {
        super(e);
    }

    public Secretary(String name, LocalDate birthday, int salary, Gender gender) {
        super(name, birthday, salary, gender);
    }

    @Override
    public int calculateBonus() {
        return (int) (this.getSalary() * BONUS_MULTIPLIER);
    }

}
