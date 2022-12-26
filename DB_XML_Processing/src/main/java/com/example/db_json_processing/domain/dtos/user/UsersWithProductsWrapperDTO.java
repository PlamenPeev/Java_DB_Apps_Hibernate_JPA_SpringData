package com.example.db_json_processing.domain.dtos.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UsersWithProductsWrapperDTO {
    private Integer usersCount;
    private List<UsersWithProductsDTO> users;

    //UsersWithSoldProductsDTO
    public UsersWithProductsWrapperDTO(List<UsersWithProductsDTO> users){
        this.users = users;
        this.usersCount = users.size();
    }


}
