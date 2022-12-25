package com.example.db_json_processing.services;

import com.example.db_json_processing.domain.dtos.category.CategoryProductSummaryDTO;
import com.example.db_json_processing.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import static com.example.db_json_processing.constants.Paths.CATEGORIES_BY_PRODUCTS_JSON_PATH;
import static com.example.db_json_processing.constants.Utils.writeJsonIntoFile;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

@Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryProductSummaryDTO> getCategorySummary() throws IOException {
      final  List<CategoryProductSummaryDTO> categoryProductSummaryDTOS = this.categoryRepository.getCategorySummary().orElseThrow(NoSuchElementException::new);

      writeJsonIntoFile(categoryProductSummaryDTOS, CATEGORIES_BY_PRODUCTS_JSON_PATH);

        return categoryProductSummaryDTOS;

    }
}
