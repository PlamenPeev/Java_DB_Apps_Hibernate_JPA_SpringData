import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class P08_GetEmployeeWithProject {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        Scanner scanner = new Scanner(System.in);
        int employeeID = scanner.nextInt();

        String result = entityManager.createQuery(
                        "SELECT e FROM Employee e" +
                            " WHERE e.id = :id",
                        Employee.class)
                .setParameter("id", employeeID)
                .getSingleResult()
                .printEmployeeProjects(); // I made a new method in Employee.class//

        System.out.println(result);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

}

