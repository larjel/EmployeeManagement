package employee;

public class Technician extends Employee {

    public static final int ID = 2;

    public Technician(Employee e) {
        super(e);
    }

    public Technician(String name, String birthDate, int salary, String gender) {
        super(name, birthDate, salary, gender);
    }

    @Override
    public int calculateBonus() {
        return 0;
    }

}
