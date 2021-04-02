package com.epam.collections.inventory_processor;

import java.io.File;
import java.util.List;

public class Controller {
    private final View view;
    private final InventoryProcessor inventoryProcessor;
    private final String originFilePath;
    private List<Product> productList;

    public Controller(View view, InventoryProcessor inventoryProcessor, String originFilePath) {
        this.view = view;
        this.inventoryProcessor = inventoryProcessor;
        this.originFilePath = originFilePath;
    }

    public void setProductsListFromFile() {
        this.productList = new ProductsReader().getProductsFromFile(new File(originFilePath));
    }

    public void printOriginalList() {
        view.printProductList(View.ORIGINAL_LIST, productList);
    }

    public void printSortedList() {
        view.printProductList(View.SORTED_LIST, inventoryProcessor.sort(productList));
    }

    public void printDistinctList() {
        view.printProductList(View.DISTINCT_LIST, inventoryProcessor.distinct(productList));
    }

}
