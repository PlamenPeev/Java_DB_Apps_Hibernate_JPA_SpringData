package entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main03 {
    public static void main(String[] args) {

        EntityManagerFactory university_db = Persistence.createEntityManagerFactory("university_db");
        EntityManager entityManager = university_db.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}