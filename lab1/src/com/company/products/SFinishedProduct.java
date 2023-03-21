package com.company.products;

import com.company.products.FishProduct;

public class SFinishedProduct extends FishProduct {
    private  int sfType;

    public int getSfType() {
        return sfType;
    }

    public void setSfType(int sfType) {
        this.sfType = sfType;
    }

    public SFinishedProduct(String name, int weight, int calories, String processingType, int time, int omega3, String fishArea, int sfType) {
        super(name, weight, calories, processingType, time, omega3, fishArea);
        this.sfType = sfType;
    }
}
