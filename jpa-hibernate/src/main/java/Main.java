import domain.Employee;
import domain.Employee2Tables;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

// https://www.youtube.com/watch?v=_ZKhPv3VqT8&list=PLU2dl_1LV_SQWZI2R_RSEeYm1tfueszOc&index=7

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory eMF = Persistence
                .createEntityManagerFactory("myDatabase");
        EntityManager eM = eMF.createEntityManager();

        Employee2Tables employee = new Employee2Tables();

        employee.setFirstName("Jan");
        employee.setLastName("Nowak");
        employee.setSalary(3333.3);
        employee.setLocality("Warszawa");
        employee.setZipcode("11-111");
        employee.setStreet("Koszykowa");
        employee.setStreetNumber(111);

        eM.getTransaction().begin(); // all operations on the DB must be inside a Transaction
        eM.persist(employee);// a method of the EntityManager setting an object to commit to the DB
        eM.getTransaction().commit();


        eM.close();
        eMF.close();
    }
}
