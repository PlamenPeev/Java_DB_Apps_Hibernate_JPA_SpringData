import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class P04_EmployeesWithSalaryOver50000 {
    private static final String SELECT_FIST_NAME_EMPLOYEE_WHIT_SALARY_OVER_50000 =
            "SELECT e FROM Employee e WHERE e.salary > 50000";
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        // ** another way **
//        entityManager.createQuery(
//        "SELECT e.firstName FROM Employee e WHERE e.salary > 50000", String.class)
//                .getResultList()
//                .forEach(System.out::println);


        TypedQuery<Employee> query =
                entityManager.createQuery(SELECT_FIST_NAME_EMPLOYEE_WHIT_SALARY_OVER_50000, Employee.class);

        List<Employee> resultList = query.getResultList();

        for (Employee emp : resultList) {
            String firstName = emp.getFirstName();
            System.out.println(firstName);
        }

        entityManager.getTransaction().commit();
        entityManager.close();

    }
}

