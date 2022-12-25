package com.example.db_json_processing.domain.dtos.category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryProductSummaryDTO {
private String category;
private Long productsCount;
private Double averagePrice;
private BigDecimal totalRevenue;

}
