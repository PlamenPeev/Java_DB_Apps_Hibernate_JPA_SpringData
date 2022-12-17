package entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory gringotts = Persistence.createEntityManagerFactory("gringotts");
        EntityManager entityManager = gringotts.createEntityManager();
        entityManager.getTransaction().begin();
    }
}