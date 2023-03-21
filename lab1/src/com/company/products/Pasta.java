package com.company.products;

import com.company.products.CerealsGrainsProduct;

public class Pasta extends CerealsGrainsProduct {
    private String wheatType;

    public String getWheatType() {
        return wheatType;
    }

    public void setWheatType(String wheatType) {
        this.wheatType = wheatType;
    }

    public Pasta(String name, int weight, int calories, String processingType, int time, int carb, String productType, String wheatType) {
        super(name, weight, calories, processingType, time, carb, productType);
        this.wheatType = wheatType;
    }
}
