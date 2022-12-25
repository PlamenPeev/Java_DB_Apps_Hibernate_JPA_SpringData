package com.example.db_json_processing.services;

import com.example.db_json_processing.domain.dtos.user.UserDTO;
import com.example.db_json_processing.domain.dtos.user.UserWithSoldProductsDTO;
import com.example.db_json_processing.domain.dtos.user.UsersWithProductsDTO;
import com.example.db_json_processing.domain.dtos.user.UsersWithProductsWrapperDTO;
import com.example.db_json_processing.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.db_json_processing.constants.Paths.USERS_AND_PRODUCTS_JSON_PATH;
import static com.example.db_json_processing.constants.Paths.USERS_WITH_SOLD_PRODUCTS_JSON_PATH;
import static com.example.db_json_processing.constants.Utils.MODEL_MAPPER;
import static com.example.db_json_processing.constants.Utils.writeJsonIntoFile;

@Service
public class UserServiceImpl implements UserService{


    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserWithSoldProductsDTO> findAllBySellingProductsBuyerIsNotNullOrderBySellingProductsBuyerLastName() throws IOException {
       final List<UserWithSoldProductsDTO> userWithSoldProductsDTOList = this.userRepository.findAllBySellingProductsBuyerIsNotNullOrderBySellingProductsBuyerLastName()
                .orElseThrow(NoSuchMethodError::new)
                .stream().map(user -> MODEL_MAPPER.map(user, UserWithSoldProductsDTO.class))
                .collect(Collectors.toList());

       writeJsonIntoFile(userWithSoldProductsDTOList, USERS_WITH_SOLD_PRODUCTS_JSON_PATH);
        return userWithSoldProductsDTOList;

    }

    @Override
    public UsersWithProductsWrapperDTO usersAndProducts() throws IOException {
       final List<UsersWithProductsDTO> usersAndProducts = this.userRepository
                .findAllBySellingProductsBuyerIsNotNullOrderBySellingProductsBuyerLastName()
                .orElseThrow(NoSuchMethodError::new)
                .stream()
                .map(user -> MODEL_MAPPER.map(user, UserDTO.class))
                .map(UserDTO::toUsersWithProductsDTO)
                .collect(Collectors.toList());

      final  UsersWithProductsWrapperDTO usersWithProductsWrapperDTO =
              new UsersWithProductsWrapperDTO(usersAndProducts);

        writeJsonIntoFile(usersWithProductsWrapperDTO, USERS_AND_PRODUCTS_JSON_PATH);
        UsersWithProductsWrapperDTO UsersWithProductsWrapperDTO;
        UsersWithProductsWrapperDTO = null;
        return null;

    }
}
