package com.example.db_json_processing.constants;


import java.nio.file.Path;

public enum Paths {
    ;

    /////JSON/////
    public static final Path USER_JSON_PATH = Path.of("src/main/resources/DbContent/jsons/users.json");
    public static final Path CATEGORY_JSON_PATH = Path.of("src/main/resources/DbContent/jsons/categories.json");
    public static final Path PRODUCT_JSON_PATH = Path.of("src/main/resources/DbContent/jsons/products.json");
    public static final Path PRODUCTS_WITH_NO_BUYERS_IN_RANGE_JSON_PATH =
            Path.of("src/main/resources/outputs/jsons/product-in-range.json");

    public static final Path USERS_WITH_SOLD_PRODUCTS_JSON_PATH =
            Path.of("src/main/resources/outputs/jsons/users-sold-products.json");

    public static final Path CATEGORIES_BY_PRODUCTS_JSON_PATH =
            Path.of("src/main/resources/outputs/jsons/categories-by-products.json");

    public static final Path USERS_AND_PRODUCTS_JSON_PATH =
            Path.of("src/main/resources/outputs/jsons/users-and-products.json");

    /////XML/////
    public static final Path USER_XML_PATH = Path.of("src/main/resources/DbContent/xmls/users.xml");
    public static final Path CATEGORY_XML_PATH = Path.of("src/main/resources/DbContent/xmls/categories.xml");
    public static final Path PRODUCT_XML_PATH = Path.of("src/main/resources/DbContent/xmls/products.xml");
    public static final Path PRODUCTS_WITH_NO_BUYERS_IN_RANGE_XML_PATH =
            Path.of("src/main/resources/outputs/xmls/product-in-range.xml");

    public static final Path USERS_WITH_SOLD_PRODUCTS_XML_PATH =
            Path.of("src/main/resources/outputs/xmls/users-sold-products.xml");

    public static final Path CATEGORIES_BY_PRODUCTS_XML_PATH =
            Path.of("src/main/resources/outputs/xmls/categories-by-products.xml");

    public static final Path USERS_AND_PRODUCTS_XML_PATH =
            Path.of("src/main/resources/outputs/xmls/users-and-products.xml");
}
