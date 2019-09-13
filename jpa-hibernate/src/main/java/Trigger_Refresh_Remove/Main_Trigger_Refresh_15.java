package Trigger_Refresh_Remove;

import Trigger_Refresh_Remove.domain.EmployeeTR;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main_Trigger_Refresh_15 {
    public static void main(String[] args) {
        EntityManagerFactory eMF = Persistence
                .createEntityManagerFactory("myDatabase");
        EntityManager eM = eMF.createEntityManager();

        EmployeeTR employeeTR = new EmployeeTR();
        employeeTR.setFirstName("Damian");
        employeeTR.setLastName("Skasuj");
        employeeTR.setSalary(2020);

        eM.getTransaction().begin();
        eM.persist(employeeTR);
        eM.getTransaction().commit();

        System.out.println("FN: " + employeeTR.getFirstName());
        System.out.println("LN: " + employeeTR.getLastName());
        System.out.println("S: " + employeeTR.getSalary());
        System.out.println("Tx: " + employeeTR.getTax());

        eM.refresh(employeeTR);

        System.out.println("FN: " + employeeTR.getFirstName());
        System.out.println("LN: " + employeeTR.getLastName());
        System.out.println("S: " + employeeTR.getSalary());
        System.out.println("Tx: " + employeeTR.getTax());

        eM.getTransaction().begin();
        eM.remove(employeeTR);
        eM.getTransaction().commit();

        eM.close();
        eMF.close();
    }

}
