package com.example.db_json_processing.services;

import com.example.db_json_processing.domain.dtos.category.CategoryProductSummaryDTO;

import java.io.IOException;
import java.util.List;

public interface CategoryService {

    List<CategoryProductSummaryDTO> getCategorySummary() throws IOException;
}

