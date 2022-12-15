import entities.Address;
import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.Scanner;

public class P06_AddingANewAddressAndUpdatingEmployee {
      public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        Scanner scanner = new Scanner(System.in);
        String lastName = scanner.nextLine();

          Address newAddress = new Address();
          newAddress.setText("Vitoshka 15");
          entityManager.persist(newAddress);


          entityManager.createQuery("UPDATE Employee AS e" +
                          " SET e.address = :newAddress" +
                          " WHERE e.lastName = :ln")
                  .setParameter("newAddress", newAddress)
                  .setParameter("ln", lastName)
                  .executeUpdate();


          entityManager.getTransaction().commit();
        entityManager.close();
    }
}

