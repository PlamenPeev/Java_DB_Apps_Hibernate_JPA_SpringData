package com.example.db_json_processing.services;

import com.example.db_json_processing.domain.dtos.user.UsersWithSoldProductsDTO;
import com.example.db_json_processing.domain.dtos.user.UsersWithProductsWrapperDTO;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

public interface UserService {
    List<UsersWithSoldProductsDTO>
    findAllBySellingProductsBuyerIsNotNullOrderBySellingProductsBuyerLastName() throws IOException, JAXBException;

    UsersWithProductsWrapperDTO usersAndProducts() throws IOException;
}
