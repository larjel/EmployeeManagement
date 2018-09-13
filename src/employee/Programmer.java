package employee;

public class Programmer extends Employee {

    public Programmer(String name, String birthDate, int salary, String gender) {
        super(name, birthDate, salary, gender);
    }

    @Override
    public int calculateBonus() {
        return 0;
    }
    
}
