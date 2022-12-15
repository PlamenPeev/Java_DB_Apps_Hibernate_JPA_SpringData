import entities.Town;

import javax.persistence.*;
import java.util.List;

public class P02_ChangeCasing {
    private static final String UPDATE_NAMES_OF_TOWNS_WITH_FIVE_SYMBOLS_TO_UPPERCASE =
            "UPDATE Town SET name = UPPER(name) WHERE LENGTH(name) <= 5";

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

       entityManager.createQuery(UPDATE_NAMES_OF_TOWNS_WITH_FIVE_SYMBOLS_TO_UPPERCASE).executeUpdate();

       // ** another way **
//        TypedQuery<Town> query = entityManager.createQuery("SELECT t FROM Town AS t", Town.class);
//        List<Town> resultList = query.getResultList();
//
//        for (Town town : resultList) {
//            String townName = town.getName();
//
//            if (townName.length() <= 5){
//                town.setName(townName.toUpperCase());
//                entityManager.persist(town);
//            }
//        }

        entityManager.getTransaction().commit();
        entityManager.close();

    }
}

