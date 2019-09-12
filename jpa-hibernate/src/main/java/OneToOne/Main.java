package OneToOne;

import OneToOne.domain.Address1to1;
import OneToOne.domain.Employee1to1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory eMF = Persistence
                .createEntityManagerFactory("myDatabase");
        EntityManager eM = eMF.createEntityManager();


        Address1to1 address = new Address1to1();
        Employee1to1 employee = new Employee1to1();
        employee.setFirstName("Jan");
        employee.setLastName("Nowak");
        employee.setSalary(3333.3);
        employee.setAddress(address);
        address.setLocality("Rzeszow");
        address.setZipcode("33-333");
        address.setStreet("Dluga");
        address.setStreetNumber(2);


        eM.getTransaction().begin();
        // in the case of OneToOne we need to add both objects to the DB
        eM.persist(employee);
        eM.persist(address);
        eM.getTransaction().commit();



        eM.close();
        eMF.close();
    }
}
