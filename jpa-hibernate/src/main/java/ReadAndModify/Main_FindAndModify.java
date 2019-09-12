package ReadAndModify;

import tutUpTo12.domain.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main_FindAndModify {
    public static void main(String[] args) {
        EntityManagerFactory eMF = Persistence
                .createEntityManagerFactory("myDatabase");
        EntityManager eM = eMF.createEntityManager();
        Employee newEmployee = new Employee();
        newEmployee.setFirstName("Jan");
        newEmployee.setLastName("Nowak");
        newEmployee.setSalary(3333.3);

        eM.getTransaction().begin();
        eM.persist(newEmployee);
        eM.getTransaction().commit();

        eM.getTransaction().begin();
        Employee employee = eM.find(Employee.class, 3L);
        System.out.println("First name: " + employee.getFirstName());
        System.out.println("Last name: " + employee.getLastName());
        System.out.println("Salary name: " + employee.getSalary());
        employee.setSalary(2000.00);
        eM.getTransaction().commit();

        eM.close();
        eMF.close();
    }

}
