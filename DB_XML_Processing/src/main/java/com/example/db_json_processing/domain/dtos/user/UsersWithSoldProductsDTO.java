package com.example.db_json_processing.domain.dtos.user;

import com.example.db_json_processing.domain.dtos.product.ProductSoldDTO;
import com.example.db_json_processing.domain.dtos.product.ProductsSoldWrapperDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class UsersWithSoldProductsDTO {


    private String firstName;


    private String lastName;


    private List<ProductSoldDTO> boughtProducts;

    public static List<UserWithSoldProductsXmlDTO> toUsersWithSoldProductsDTO(List<UsersWithSoldProductsDTO> input){
      return   input.stream()
                .map(user -> new UserWithSoldProductsXmlDTO(
                        user.getFirstName(),
                        user.getLastName(),
                        new ProductsSoldWrapperDTO(user.getBoughtProducts())))
              .toList();
    }
}



