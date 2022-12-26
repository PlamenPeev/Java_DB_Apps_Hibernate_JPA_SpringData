package com.example.db_json_processing.services;

import com.example.db_json_processing.domain.dtos.product.ProductInRangeWithNoBuyerDTO;
import com.example.db_json_processing.domain.entities.Product;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ProductInRangeWithNoBuyerDTO> findAllByPriceBetweenAndBuyerIsNullOrderByPrice(BigDecimal low, BigDecimal high) throws IOException, JAXBException;
}
