package com.company.products;

public class VegFruitProduct extends BaseProduct{
    private String vfType;
    private int fiber;

    public String getVfType() {
        return vfType;
    }

    public void setVfType(String vfType) {
        this.vfType = vfType;
    }

    public int getFiber() {
        return fiber;
    }

    public void setFiber(int fiber) {
        this.fiber = fiber;
    }

    public VegFruitProduct(String name, int weight, int calories, String processingType, int time, String vfType, int fiber) {
        super(name, weight, calories, processingType, time);
        this.vfType = vfType;
        this.fiber = fiber;
    }
}
