package com.example.db_json_processing.services;

import com.example.db_json_processing.domain.dtos.user.UserWithSoldProductsDTO;
import com.example.db_json_processing.domain.dtos.user.UsersWithProductsWrapperDTO;
import com.example.db_json_processing.domain.entities.User;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserWithSoldProductsDTO>
    findAllBySellingProductsBuyerIsNotNullOrderBySellingProductsBuyerLastName() throws IOException;

    UsersWithProductsWrapperDTO usersAndProducts() throws IOException;
}
