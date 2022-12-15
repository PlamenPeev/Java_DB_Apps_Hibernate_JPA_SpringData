import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class P10_IncreaseSalaries {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.createQuery("UPDATE Employee e SET e.salary = e.salary * 1.12" +
                                " WHERE e.department.id IN (1,2,14,3)")
                .executeUpdate();

        entityManager.getTransaction().commit();

        entityManager.createQuery("SELECT e FROM Employee AS e" +
                        " WHERE e.department.name IN" +
                        "('Engineering', 'Tool Design', 'Marketing', 'Information Services')", Employee.class)
                .getResultList()
                .forEach(employee -> System.out.printf("%s %s ($%.2f)%n",
                                employee.getFirstName(),
                                employee.getLastName(),
                                employee.getSalary()));


        entityManager.close();

    }
}

