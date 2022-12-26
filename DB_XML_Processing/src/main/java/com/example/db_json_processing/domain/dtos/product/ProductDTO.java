package com.example.db_json_processing.domain.dtos.product;

import com.example.db_json_processing.domain.dtos.category.CategoryDTO;
import com.example.db_json_processing.domain.dtos.user.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    private String name;

    private BigDecimal price;

    private UserDTO buyer;
    private UserDTO seller;

    private Set<CategoryDTO> categories;

    public ProductInRangeWithNoBuyerDTO toProductInRangeWithNoBuyerDTO(){
        return new ProductInRangeWithNoBuyerDTO(name, price, seller.getFullName());
    }

    public static ProductsSoldWithCountDTO toProductsSoldWithCountDTO(Set<ProductDTO> sellingProducts){
        return new ProductsSoldWithCountDTO(sellingProducts
                .stream().map(ProductDTO::toProductBasicInfo)
                .collect(Collectors.toList()));
    }

    public static ProductBasicInfo toProductBasicInfo(ProductDTO productDTO){
        return new ProductBasicInfo(productDTO.getName(), productDTO.getPrice());
    }


}
