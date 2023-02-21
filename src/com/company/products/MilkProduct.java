package com.company.products;

public class MilkProduct extends BaseProduct {
    private int calcium;
    private String productType;
    private int fatContent;

    public int getFatContent() {
        return fatContent;
    }
    public void setFatContent(int fatContent) {
        this.fatContent = fatContent;
    }

    public int getCalcium() {
        return calcium;
    }
    public void setCalcium(int calcium) {
        this.calcium = calcium;
    }

    public String getProductType() {
        return productType;
    }
    public void setProductType(String productType) {
        this.productType = productType;
    }

    public MilkProduct(String name, int weight, int calories, String processingType, int time, int calcium, String productType, int fatContent) {
        super(name, weight, calories, processingType, time);
        this.calcium = calcium;
        this.productType = productType;
        this.fatContent = fatContent;
    }
}
