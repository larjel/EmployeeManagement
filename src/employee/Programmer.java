package employee;

public class Programmer extends Employee {

    public static final int ID = 3;
    
    public Programmer(String name, String birthDate, int salary, String gender) {
        super(name, birthDate, salary, gender, "Programmer");
    }

    @Override
    public int calculateBonus() {
        return 0;
    }
    
}
