package com.epam.collections.inventory_processor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * 06_Generic_Collections - Vladimir Vasyukov
 * Class for working with inventory
 */
public class InventoryProcessor {

    public static void main(String[] args) {
        Controller controller = new Controller(new View(), new InventoryProcessor(), args[0]);
        controller.setProductsListFromFile();
        controller.printOriginalList();
        controller.printSortedList();
        controller.printDistinctList();

    }

    public List<Product> sort(List<Product> products) {
        Set<Product> sortedProductSet = new TreeSet<>(products);
        return new LinkedList<>(sortedProductSet);
    }

    public List<Product> distinct(List<Product> products) {
        Map<Integer, Product> productMap = new HashMap<>();
        for (Product product : products) {
            if (!productMap.containsKey(product.getCode())) {
                productMap.put(product.getCode(), product);
            }
        }
        return new ArrayList<>(productMap.values());
    }

}
