package com.example.db_json_processing.repositories;

import com.example.db_json_processing.domain.dtos.category.CategoryProductSummaryDTO;
import com.example.db_json_processing.domain.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query(value = "SELECT * FROM product_shop.categories ORDER BY RAND () LIMIT 1", nativeQuery = true)
    Optional<Category> getRandomEntity();

    @Query("SELECT new com.example.db_json_processing.domain.dtos.category.CategoryProductSummaryDTO" +
            "(c.name, count(p.id), AVG(p.price), SUM(p.price)) " +
            "FROM Product  AS p JOIN p.categories AS c " +
            "GROUP BY c.id " +
            "ORDER BY count(p.id)")
    Optional<List<CategoryProductSummaryDTO>> getCategorySummary();
}
