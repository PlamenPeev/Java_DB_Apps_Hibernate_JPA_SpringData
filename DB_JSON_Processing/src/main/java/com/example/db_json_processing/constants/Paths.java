package com.example.db_json_processing.constants;


import java.nio.file.Path;

public enum Paths {
    ;
    public static final Path USER_JSON_PATH = Path.of("src/main/resources/DbContent/users.json");
    public static final Path CATEGORY_JSON_PATH = Path.of("src/main/resources/DbContent/categories.json");
    public static final Path PRODUCT_JSON_PATH = Path.of("src/main/resources/DbContent/products.json");
    public static final Path PRODUCTS_WITH_NO_BUYERS_IN_RANGE_JSON_PATH =
            Path.of("src/main/resources/outputs/product-in-range.json");

    public static final Path USERS_WITH_SOLD_PRODUCTS_JSON_PATH =
            Path.of("src/main/resources/outputs/users-sold-products.json");

    public static final Path CATEGORIES_BY_PRODUCTS_JSON_PATH =
            Path.of("src/main/resources/outputs/categories-by-products.json");

    public static final Path USERS_AND_PRODUCTS_JSON_PATH =
            Path.of("src/main/resources/outputs/users-and-products.json");
}
