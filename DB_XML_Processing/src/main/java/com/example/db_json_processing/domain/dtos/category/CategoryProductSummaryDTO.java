package com.example.db_json_processing.domain.dtos.category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "category")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategoryProductSummaryDTO {

    @XmlAttribute(name = "name")
private String category;

    @XmlElement(name = "products-count")
private Long productsCount;

    @XmlElement(name = "average-price")
private Double averagePrice;

    @XmlElement(name = " total-revenue")
private BigDecimal totalRevenue;

}
