package JPQL;

import Trigger_Refresh_Remove.domain.EmployeeTR;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class Main_JPQL {
    public static void main(String[] args) {
        EntityManagerFactory eMF= Persistence
                .createEntityManagerFactory("myDatabase");
        EntityManager eM = eMF.createEntityManager();

        TypedQuery<EmployeeTR> query = eM.createQuery(
                "select e from EmployeeTR e where e.lastName = 'Mak'",EmployeeTR.class);
        EmployeeTR employee = query.getSingleResult();

        System.out.println("FN: " + employee.getFirstName());
        System.out.println("LN: " + employee.getLastName());


        eM.close();
        eMF.close();

    }
}
