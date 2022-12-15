import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Comparator;

public class P09_FindLatest10Projects {
        public static void main(String[] args) {
                EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
                EntityManager entityManager = factory.createEntityManager();
                entityManager.getTransaction().begin();

                entityManager.createQuery("SELECT p FROM Project p ORDER BY p.startDate DESC", Project.class)
                        .setMaxResults(10)
                        .getResultStream()
                        .forEach(project ->
                                System.out.printf(
                                "Project name: %s%n" +
                                        "       Project Description: %s%n" +
                                        "       Project Start Date:%s%n" +
                                        "       Project End Date: %s%n",
                                project.getName(),
                                project.getDescription(),
                                project.getStartDate(),
                                project.getEndDate()
                                ));

                entityManager.getTransaction().commit();
                entityManager.close();


        }
}
