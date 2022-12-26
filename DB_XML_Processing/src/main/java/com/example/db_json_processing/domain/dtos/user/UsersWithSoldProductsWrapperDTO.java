package com.example.db_json_processing.domain.dtos.user;


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
@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UsersWithSoldProductsWrapperDTO {
    @XmlElement(name = "user")
    private List<UserWithSoldProductsXmlDTO> users;

    public UsersWithSoldProductsWrapperDTO ofListOfUsersWithSoldProductsDTO(List<UsersWithSoldProductsDTO> input){
    users = UsersWithSoldProductsDTO.toUsersWithSoldProductsDTO(input);
    return this;
    }
}
