package com.example.db_json_processing.domain.dtos.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;


    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @XmlRootElement(name = "products")
    @XmlAccessorType(XmlAccessType.FIELD)
    public class ProductsInRangeWithNoBuyerWrapperDTO {

        @XmlElement(name = "product")
        private List<ProductInRangeWithNoBuyerDTO> products;

}
