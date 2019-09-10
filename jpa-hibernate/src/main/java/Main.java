import domain.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

// https://www.youtube.com/watch?v=_ZKhPv3VqT8&list=PLU2dl_1LV_SQWZI2R_RSEeYm1tfueszOc&index=7

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory eMF = Persistence.createEntityManagerFactory("myDatabase");
        EntityManager eM = eMF.createEntityManager();

        Employee employee = new Employee();
        //employee.setId(1L);
        employee.setFirstName("Jan");
        employee.setLastName("Nowak");
        employee.setSalary(3333.3);
        employee.setSalary2(new BigDecimal(12345.6));

        Employee employee2 = new Employee();
        //employee2.setId(1L);
        employee2.setFirstName("Robert");
        employee2.setLastName("Bednarek");
        employee2.setSalary(4444.4);

        eM.getTransaction().begin(); // all operations on the DB must be inside a Transaction
        eM.persist(employee);// a method of the EntityManager committing an object to the DB
        eM.persist(employee2);
        eM.getTransaction().commit();


        eM.close();
        eMF.close();
    }
}
