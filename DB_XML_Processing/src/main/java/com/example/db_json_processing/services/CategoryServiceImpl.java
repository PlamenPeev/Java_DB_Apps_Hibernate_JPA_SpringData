package com.example.db_json_processing.services;

import com.example.db_json_processing.domain.dtos.category.CategoriesProductSummaryWrapperDTO;
import com.example.db_json_processing.domain.dtos.category.CategoryProductSummaryDTO;
import com.example.db_json_processing.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import static com.example.db_json_processing.constants.Paths.CATEGORIES_BY_PRODUCTS_JSON_PATH;
import static com.example.db_json_processing.constants.Paths.CATEGORIES_BY_PRODUCTS_XML_PATH;
import static com.example.db_json_processing.constants.Utils.writeJsonIntoFile;
import static com.example.db_json_processing.constants.Utils.writeXmlIntoFile;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

@Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryProductSummaryDTO> getCategorySummary() throws IOException, JAXBException {
      final  List<CategoryProductSummaryDTO> categories =
              this.categoryRepository.getCategorySummary().orElseThrow(NoSuchElementException::new);

       final CategoriesProductSummaryWrapperDTO categoriesWrapper =
                new CategoriesProductSummaryWrapperDTO(categories);

        writeJsonIntoFile(categories, CATEGORIES_BY_PRODUCTS_JSON_PATH);
        writeXmlIntoFile(categoriesWrapper, CATEGORIES_BY_PRODUCTS_XML_PATH);

        return categories;

    }
}
