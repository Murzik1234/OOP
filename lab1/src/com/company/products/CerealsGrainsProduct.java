package com.company.products;

import com.company.products.BaseProduct;

public class CerealsGrainsProduct extends BaseProduct {
    private int carb;
    private String productType;

    public int getCarb() {
        return carb;
    }
    public void setCarb(int carb) {
        this.carb = carb;
    }
    public String getProductType() {
        return productType;
    }
    public void setProductType(String productType) {
        this.productType = productType;
    }

    public CerealsGrainsProduct(String name, int weight, int calories, String processingType, int time, int carb, String productType) {
        super(name, weight, calories, processingType, time);
        this.carb = carb;
        this.productType = productType;
    }
}
