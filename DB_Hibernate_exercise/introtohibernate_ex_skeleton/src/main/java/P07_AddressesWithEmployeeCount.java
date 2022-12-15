import entities.Address;
import entities.Employee;
import net.bytebuddy.description.type.TypeDescription;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.Collections;
import java.util.List;

public class P07_AddressesWithEmployeeCount {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.createQuery(
                "SELECT a FROM Address AS a ORDER BY a.employees.size DESC", Address.class)
                .setMaxResults(10)
                .getResultList()
                .forEach(System.out::println);


        // ** another way **
//        }   List<Address> resultList = entityManager.createQuery(
//                        "SELECT a FROM Address AS a ORDER BY a.employees.size", Address.class)
//                .getResultList();
//
//        for (Address adr : resultList) {
//                System.out.printf(adr.toString());
//        }


        entityManager.close();
    }

}

