package com.company.products;

import com.company.products.MeatProduct;

public class MinceProduct extends MeatProduct {
    private int meatPercent;

    public int getMeatPercent() {
        return meatPercent;
    }
    public void setMeatPercent(int meatPercent) {
        this.meatPercent = meatPercent;
    }

    public MinceProduct(String name, int weight, int calories, String processingType, int time, int protein, String meatType, int meatPercent) {
        super(name, weight, calories, processingType, time, protein, meatType);
        this.meatPercent = meatPercent;
    }
}
