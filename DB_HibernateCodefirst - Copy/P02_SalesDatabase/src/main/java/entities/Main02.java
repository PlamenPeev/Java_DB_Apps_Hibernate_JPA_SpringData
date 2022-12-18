package entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main02 {
    public static void main(String[] args) {

        EntityManagerFactory sales_db = Persistence.createEntityManagerFactory("sales_db");
        EntityManager entityManager = sales_db.createEntityManager();
        entityManager.getTransaction().begin();
    }
}