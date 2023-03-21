package com.company.products;

import com.company.products.BaseProduct;

public class MeatProduct extends BaseProduct {
    private int protein;
    private String meatType;

    public int getProtein() {
        return protein;
    }
    public void setProtein(int protein) {
        this.protein = protein;
    }

    public String getMeatType() {
        return meatType;
    }
    public void setMeatType(String meatType) {
        this.meatType = meatType;
    }

    public MeatProduct(String name, int weight, int calories, String processingType, int time, int protein, String meatType) {
        super(name, weight, calories, processingType, time);
        this.protein = protein;
        this.meatType = meatType;
    }
}
