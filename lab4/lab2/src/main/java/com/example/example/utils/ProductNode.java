package com.example.example.utils;

import com.example.example.ProductTypes;

public class ProductNode {
    private String typeName;
    private ProductTypes productTypes;

    public ProductTypes getProductTypes() {
        return productTypes;
    }

    public ProductNode(String typeName, ProductTypes productTypes) {
        this.typeName = typeName;
        this.productTypes = productTypes;
    }

    @Override
    public String toString() {
        return typeName;
    }
}
