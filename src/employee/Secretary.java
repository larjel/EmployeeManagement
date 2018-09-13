package employee;

public class Secretary extends Employee {
    
    public static final int ID = 1;

    public Secretary(String name, String birthDate, int salary, String gender) {
        super(name, birthDate, salary, gender, "Secretary");
    }

    @Override
    public int calculateBonus() {
        return 0;
    }
    
}
