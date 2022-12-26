package com.example.db_json_processing.domain.dtos.user;

import com.example.db_json_processing.domain.dtos.product.ProductBasicInfo;
import com.example.db_json_processing.domain.dtos.product.ProductImportDTO;
import com.example.db_json_processing.domain.dtos.product.ProductSoldDTO;
import com.example.db_json_processing.domain.dtos.product.ProductsSoldWithCountDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsersWithProductsDTO {
    private String firstName;
    private String lastName;
    private Integer age;
    private ProductsSoldWithCountDTO products;
}
