package laboration2;

public class Laboration2 {

    public static void main(String[] args) {
        EmployeeManager em = new EmployeeManager();
        
        em.add("Anders Andersson", "660101", 1, 30000, "Man");
        em.add("Sven Svensson", "880101", 2, 45000, "Woman");
        em.displayAll();
        
        em.delete(1);
        em.displayAll();
    }
    
}
