package com.company.products;

import com.company.products.BaseProduct;

public class SpicesProduct extends BaseProduct {
    private String sharpness;
    private String country;

    public String getSharpness() {
        return sharpness;
    }
    public void setSharpness(String sharpness) {
        this.sharpness = sharpness;
    }

    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    public SpicesProduct(String name, int weight, int calories, String processingType, int time, String sharpness, String country) {
        super(name, weight, calories, processingType, time);
        this.sharpness = sharpness;
        this.country = country;
    }
}
