package com.example.db_json_processing;

import com.example.db_json_processing.services.CategoryService;
import com.example.db_json_processing.services.ProductService;
import com.example.db_json_processing.services.SeedService;
import com.example.db_json_processing.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.math.BigDecimal;

@Component
public class CommandRunner implements CommandLineRunner {

    private final SeedService seedService;
    private final ProductService productService;
    private final UserService userService;
    private final CategoryService categoryService;

    public CommandRunner(SeedService seedService, ProductService productService, UserService userService, CategoryService categoryService) {
        this.seedService = seedService;
        this.productService = productService;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
          this.seedService.seedAll();
          this.productService.findAllByPriceBetweenAndBuyerIsNullOrderByPrice(
                  BigDecimal.valueOf(500),
                  BigDecimal.valueOf(1000));
          this.userService.
                  findAllBySellingProductsBuyerIsNotNullOrderBySellingProductsBuyerLastName();
       this.categoryService.getCategorySummary();
  //      this.userService.usersAndProducts();
    }
}
