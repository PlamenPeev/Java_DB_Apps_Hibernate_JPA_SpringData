package entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;

public class Main05 {
    public static void main(String[] args) {
        EntityManagerFactory university_db = Persistence.createEntityManagerFactory("bills_payment_system_db");
        EntityManager entityManager = university_db.createEntityManager();
        entityManager.getTransaction().begin();

//        BillingDetail bankAccount  = new BankAccount();
//        BillingDetail creditCard = new CreditCard();
//
//        entityManager.persist(bankAccount);
//        entityManager.persist(creditCard);

        entityManager.getTransaction().commit();
        entityManager.close();

    }
}