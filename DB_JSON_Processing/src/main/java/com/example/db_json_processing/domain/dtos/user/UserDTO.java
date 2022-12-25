package com.example.db_json_processing.domain.dtos.user;

import com.example.db_json_processing.domain.dtos.product.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

import static com.example.db_json_processing.domain.dtos.product.ProductDTO.toProductsSoldWithCountDTO;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private String firstName;

    private String lastName;

    private int age;

    private Set<ProductDTO> sellingProducts;

    private Set<ProductDTO> boughtProducts;

    private Set<UserDTO> friends;

    public String getFullName()
    {
        return firstName + " " + lastName;
    }

//    public UsersWithProductsWrapperDTO toUsersWithProductsWrapperDTO(){
//        return new UsersWithProductsWrapperDTO();
//    }

    public UsersWithProductsDTO toUsersWithProductsDTO(){
        return new UsersWithProductsDTO(firstName, lastName, age, toProductsSoldWithCountDTO(sellingProducts));
    }



}
