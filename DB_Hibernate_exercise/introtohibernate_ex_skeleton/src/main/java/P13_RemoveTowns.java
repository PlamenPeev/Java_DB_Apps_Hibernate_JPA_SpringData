import entities.Address;
import entities.Employee;
import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.Scanner;

import static javax.swing.text.html.HTML.Tag.SELECT;

public class P13_RemoveTowns {
    private final static String COUNT_DELETED_ADDRESSES = "%d address in %s deleted.";
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager entityManager = factory.createEntityManager();

        Scanner scanner = new Scanner(System.in);
        String townInput = scanner.nextLine();


        Town town = entityManager.createQuery(
                "SELECT t FROM Town AS t WHERE t.name = :tn", Town.class)
                .setParameter("tn", townInput)
                .getSingleResult();

        List<Address> addresses = entityManager
                .createQuery("SELECT a FROM Address AS a WHERE a.town.name = :tn", Address.class)
                .setParameter("tn", townInput)
                .getResultList();

        entityManager.getTransaction().begin();

        addresses.forEach(address -> {
            for (Employee employee : address.getEmployees()) {
                employee.setAddress(null);
            }
            address.setTown(null);
            entityManager.remove(address);
        });

        entityManager.remove(town);

        entityManager.getTransaction().commit();

        System.out.printf(COUNT_DELETED_ADDRESSES,
                addresses.size(),
                town.getName());


        entityManager.close();
    }
}


