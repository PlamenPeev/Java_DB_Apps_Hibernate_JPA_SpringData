import entities.Department;
import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class P12EmployeesMaximumSalaries {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.createQuery("SELECT e.department.name ,MAX(e.salary) AS max FROM Employee e" +
                        " GROUP BY e.department.id" +
                        " HAVING MAX(e.salary) NOT BETWEEN 30000 AND 70000", Object[].class)
                .getResultStream()
                .forEach(object ->
                        System.out.printf("%s %.2f%n", object[0], object[1]));


        entityManager.close();
}
}
