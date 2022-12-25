package com.example.db_json_processing.domain.dtos.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductImportDTO {
    private String name;
    private BigDecimal price;

    public static class ProductsSoldWithCountDTO {
    }
}
