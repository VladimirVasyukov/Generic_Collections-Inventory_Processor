package com.epam.collections.inventory_processor;

import java.util.Objects;

/**
 * Class that stores data about product
 */
public class Product implements Comparable<Product> {
    private final int code;
    private final String title;

    public Product(int code, String title) {
        this.code = code;
        this.title = title;
    }

    public int getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Product product = (Product) o;
        return code == product.code && Objects.equals(title, product.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, title);
    }

    @Override
    public int compareTo(Product otherProduct) {
        int compareResult;
        if (this.title.equalsIgnoreCase(otherProduct.title)) {
            compareResult = Integer.compare(this.code, otherProduct.code);
        } else {
            compareResult = this.title.compareToIgnoreCase(otherProduct.title);
        }
        return compareResult;
    }

}
