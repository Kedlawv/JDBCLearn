import domain.Address;
import domain.Employee2Tables;
import domain.EmployeeEmbeded;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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

        Address address = new Address();
        EmployeeEmbeded employeeEmbeded = new EmployeeEmbeded();
        employeeEmbeded.setFirstName("Jan");
        employeeEmbeded.setLastName("Nowak");
        employeeEmbeded.setSalary(3333.3);
        address.setLocality("Rzeszow");
        address.setZipcode("33-333");
        address.setStreet("Dluga");
        address.setStreetNumber(2);
        employeeEmbeded.setAddress(address);


        eM.getTransaction().begin(); // all operations on the DB must be inside a Transaction
        eM.persist(employee);// a method of the EntityManager setting object to commit to the DB
        eM.persist(employeeEmbeded);
        eM.getTransaction().commit();


        eM.close();
        eMF.close();
    }
}
