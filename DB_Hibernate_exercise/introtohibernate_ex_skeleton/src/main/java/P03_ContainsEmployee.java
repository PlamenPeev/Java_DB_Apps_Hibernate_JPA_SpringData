import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Scanner;

public class P03_ContainsEmployee {
    private static final String SEARCH_FOR_GIVING_NAME = "SELECT e FROM Employee e";
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        // ** another way **
//        Scanner scanner = new Scanner(System.in);
//        String[] inputName = scanner.nextLine().split(" ");
//        String firstName = inputName[0];
//        String lastName = inputName[1];
//
//        Long count = entityManager.createQuery(
//                        "SELECT count(e) FROM Employee e WHERE e.firstName = :fn AND e.lastName = :ln",
//                        Long.class)
//                .setParameter("fn", firstName)
//                .setParameter("ln", lastName)
//                .getSingleResult();

        TypedQuery<Employee> query =
                entityManager.createQuery(SEARCH_FOR_GIVING_NAME, Employee.class);
        List<Employee> resultList = query.getResultList();

        Scanner scanner = new Scanner(System.in);
        String inputName = scanner.nextLine();

        int count = 0;
        for (Employee emp : resultList) {
            // I made in Employee.class a new method ->
            // public String toString() {return firstName + " " + lastName;}
            String employeeName = emp.toString();

            if (inputName.equals(employeeName)) {
                count++;
            }
        }

        if (count == 0){
            System.out.println("No");
        }else{
            System.out.println("Yes");
        }

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}

