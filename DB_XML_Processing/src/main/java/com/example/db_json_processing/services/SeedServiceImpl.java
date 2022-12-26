package com.example.db_json_processing.services;

import com.example.db_json_processing.domain.dtos.category.CategoriesImportWrapperDTO;
import com.example.db_json_processing.domain.dtos.category.CategoryImportDTO;
import com.example.db_json_processing.domain.dtos.product.ProductImportDTO;
import com.example.db_json_processing.domain.dtos.product.ProductsImportWrapperDTO;
import com.example.db_json_processing.domain.dtos.user.UserImportDTO;
import com.example.db_json_processing.domain.dtos.user.UsersImportWrapperDTO;
import com.example.db_json_processing.domain.entities.Category;
import com.example.db_json_processing.domain.entities.Product;
import com.example.db_json_processing.domain.entities.User;
import com.example.db_json_processing.repositories.CategoryRepository;
import com.example.db_json_processing.repositories.ProductRepository;
import com.example.db_json_processing.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.module.ModuleDescriptor;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.example.db_json_processing.constants.Paths.*;
import static com.example.db_json_processing.constants.Utils.GSON;
import static com.example.db_json_processing.constants.Utils.MODEL_MAPPER;

@Service
public class SeedServiceImpl implements SeedService {

    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    @Autowired
    public SeedServiceImpl(UserRepository userRepository, CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void seedUsers() throws IOException, JAXBException {
        if (this.userRepository.count() == 0) {
 //           final FileReader fileReader = new FileReader(USER_JSON_PATH.toFile());
//            final List<User> users =
//                    Arrays.stream(GSON.fromJson(fileReader, UserImportDTO[].class))
//                            .map(userImportDTO -> MODEL_MAPPER.map(userImportDTO, User.class))
//                            .collect(Collectors.toList());

            final FileReader fileReader = new FileReader(USER_XML_PATH.toFile());
           final  JAXBContext context = JAXBContext.newInstance(UsersImportWrapperDTO.class);
           final Unmarshaller unmarshaller = context.createUnmarshaller();
           final UsersImportWrapperDTO usersDto = (UsersImportWrapperDTO) unmarshaller.unmarshal(fileReader);
           final  List<User> users = usersDto.getUsers()
                    .stream()
                    .map(userDto -> MODEL_MAPPER.map(userDto, User.class))
                    .toList();

                     this.userRepository.saveAllAndFlush(users);

            fileReader.close();
        }
    }

    @Override
    public void seedCategories() throws IOException, JAXBException {
       if (this.categoryRepository.count() == 0) {
//            final FileReader fileReader = new FileReader(CATEGORY_JSON_PATH.toFile());
//            List<Category> categories = Arrays.stream(GSON.fromJson(fileReader, CategoryImportDTO[].class))
//                    .map(categoryImportDTO -> MODEL_MAPPER.map(categoryImportDTO, Category.class))
//                    .collect(Collectors.toList());
//
           final FileReader fileReader = new FileReader(CATEGORY_XML_PATH.toFile());

           final  JAXBContext context = JAXBContext.newInstance(CategoriesImportWrapperDTO.class);
           final Unmarshaller unmarshaller = context.createUnmarshaller();
           final CategoriesImportWrapperDTO categoriesDto = (CategoriesImportWrapperDTO) unmarshaller.unmarshal(fileReader);
           final  List<Category> categories = categoriesDto.getCategories()
                   .stream()
                   .map(categoryDto -> MODEL_MAPPER.map(categoryDto, Category.class))
                   .toList();

            this.categoryRepository.saveAllAndFlush(categories);
            fileReader.close();
        }

    }

    @Override
    public void seedProducts() throws IOException, JAXBException {
      if (this.productRepository.count() == 0) {
//            final FileReader fileReader = new FileReader(PRODUCT_JSON_PATH.toFile());
//             List<Product> products = Arrays.stream(GSON.fromJson(fileReader, ProductImportDTO[].class))
//                    .map(productImportDTO -> MODEL_MAPPER.map(productImportDTO, Product.class))
//                    .map(this::setRandomSeller)
//                    .map(this::setRandomBuyer)
//                    .map(this::setCategories)
//                    .collect(Collectors.toList());
//

        final FileReader fileReader = new FileReader(PRODUCT_XML_PATH.toFile());

          final JAXBContext context = JAXBContext.newInstance(ProductsImportWrapperDTO.class);
          final Unmarshaller unmarshaller = context.createUnmarshaller();

          final ProductsImportWrapperDTO productsImportWrapperDTO =
                  (ProductsImportWrapperDTO) unmarshaller.unmarshal(fileReader);

          final List<Product> products = productsImportWrapperDTO.getProducts()
                  .stream()
                  .map(productImportDto -> MODEL_MAPPER.map(productImportDto, Product.class))
                  .map(this::setRandomSeller)
                  .map(this::setRandomBuyer)
                  .map(this::setCategories)
                  .toList();
        this.productRepository.saveAllAndFlush(products);
           fileReader.close();
        }
    }

    private Product  setCategories(Product product) {
        final Random random = new Random();
        long high = this.categoryRepository.count();
       final int numberOfCategories = random.nextInt((int) this.categoryRepository.count());

       Set<Category> categories = new HashSet<>();

        IntStream.range(0,numberOfCategories)
                .forEach(number ->{
                    Category category = this.categoryRepository.getRandomEntity()
                            .orElseThrow(NoSuchElementException::new);
                    categories.add(category);
                });
        product.setCategories(categories);
        return product;
    }

    private Product setRandomBuyer(Product product) {
        if(product.getPrice().compareTo(BigDecimal.valueOf(700L)) > 0){
            User buyer = this.userRepository.getRandomEntity().orElseThrow(NoSuchElementException::new);
            while(buyer.equals(product.getSeller())){
                buyer = this.userRepository.getRandomEntity().orElseThrow(NoSuchElementException::new);
            }

            product.setBuyer(buyer);
        }

        return product;
    }

    private Product setRandomSeller(Product product) {
        final User seller = this.userRepository.getRandomEntity().orElseThrow(NoSuchElementException::new);
        product.setSeller(seller);
        return product;
    }
}
