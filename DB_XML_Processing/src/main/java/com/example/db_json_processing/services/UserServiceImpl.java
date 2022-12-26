package com.example.db_json_processing.services;

import com.example.db_json_processing.domain.dtos.user.*;
import com.example.db_json_processing.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.db_json_processing.constants.Paths.*;
import static com.example.db_json_processing.constants.Utils.*;

@Service
public class UserServiceImpl implements UserService{


    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UsersWithSoldProductsDTO> findAllBySellingProductsBuyerIsNotNullOrderBySellingProductsBuyerLastName() throws IOException, JAXBException {
       final List<UsersWithSoldProductsDTO> userWithSoldProductsDTOList = this.userRepository.findAllBySellingProductsBuyerIsNotNullOrderBySellingProductsBuyerLastName()
                .orElseThrow(NoSuchMethodError::new)
                .stream().map(user -> MODEL_MAPPER.map(user, UsersWithSoldProductsDTO.class))
                .collect(Collectors.toList());

      final  UsersWithSoldProductsWrapperDTO usersWithSoldProductsWrapperDTO =
             new UsersWithSoldProductsWrapperDTO().ofListOfUsersWithSoldProductsDTO(
                userWithSoldProductsDTOList);

        writeJsonIntoFile(userWithSoldProductsDTOList, USERS_WITH_SOLD_PRODUCTS_JSON_PATH);
        writeXmlIntoFile(usersWithSoldProductsWrapperDTO, USERS_WITH_SOLD_PRODUCTS_XML_PATH);

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
