package laboration2;

import employee.Programmer;
import employee.Secretary;
import employee.Technician;

public class Laboration2 {

    public static void main(String[] args) {
        EmployeeManager em = new EmployeeManager();
        
        em.add("Anders Andersson", "660101", Secretary.ID, 30000, "Man");
        em.add("Sven Svensson", "880101", Technician.ID, 45000, "Woman");
        em.add("Arne", "880101", Technician.ID, 41000, "Woman");
        em.displayAll();
        System.out.println();
        
        em.update(2, null, null, Programmer.ID, null, null);
        em.displayAll();
        
        //em.search(null, null, Secretary.ID);
        
        //em.delete(1);
        //em.displayAll();
    }
    
}
