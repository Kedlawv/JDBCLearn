import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory eMF = Persistence.createEntityManagerFactory("myDatabase");
        EntityManager eM = eMF.createEntityManager();

        eM.close();
        eMF.close();
    }
}
