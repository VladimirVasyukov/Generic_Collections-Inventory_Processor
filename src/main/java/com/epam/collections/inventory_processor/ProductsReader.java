package com.epam.collections.inventory_processor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ProductsReader {
    private static final String PRODUCT_DELIMITER = "=";
    private static final Logger LOG = LogManager.getLogger(ProductsReader.class);

    public List<Product> getProductsFromFile(File file) {
        List<Product> productList = new ArrayList<>();
        try (
            BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))
        ) {
            while (reader.ready()) {
                String line = reader.readLine();
                int code = Integer.parseInt(line.substring(0, line.indexOf(PRODUCT_DELIMITER)));
                String title = line.substring(line.indexOf(PRODUCT_DELIMITER) + 1);
                productList.add(new Product(code, title));
            }
        } catch (IOException ioException) {
            LOG.error("Unexpected IOException in the getProductsFromFile method!", ioException);
        }
        return productList;
    }

}
