package employee;

public class Programmer extends Employee {

    public static final int ID = 3;

    public Programmer(Employee e) {
        super(e);
    }

    public Programmer(String name, String birthDate, int salary, String gender) {
        super(name, birthDate, salary, gender);
    }

    @Override
    public int calculateBonus() {
        return 0;
    }

}
