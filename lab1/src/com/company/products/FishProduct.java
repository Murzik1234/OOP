package com.company.products;

import com.company.products.BaseProduct;

public class FishProduct extends BaseProduct {
    private int omega3;
    private String fishArea;

    public int getOmega3() {
        return omega3;
    }
    public void setOmega3(int omega3) {
        this.omega3 = omega3;
    }

    public String getFishArea() {
        return fishArea;
    }
    public void setFishArea(String fishArea) {
        this.fishArea = fishArea;
    }

    public FishProduct(String name, int weight, int calories, String processingType, int time, int omega3, String fishArea) {
        super(name, weight, calories, processingType, time);
        this.omega3 = omega3;
        this.fishArea = fishArea;
    }
}
