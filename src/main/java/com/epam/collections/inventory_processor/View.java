package com.epam.collections.inventory_processor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class View {
    public static final String ORIGINAL_LIST = "Original list:";
    public static final String SORTED_LIST = "Sorted list:";
    public static final String DISTINCT_LIST = "Distinct list:";
    private static final String OUTPUT_PRODUCT_DELIMITER = " - ";
    private static final Logger LOG = LogManager.getLogger(View.class);

    public void printProductList(String message, Iterable<Product> productList) {
        LOG.info(message);
        for (Product product : productList) {
            LOG.info(String.format("%s%s%s%n", product.getCode(), OUTPUT_PRODUCT_DELIMITER, product.getTitle()));
        }
    }

}
