package com.company.products;

public class Milk extends MilkProduct {
    private String pasteurization;

    public String getPasteurization() {
        return pasteurization;
    }

    public void setPasteurization(String pasteurization) {
        this.pasteurization = pasteurization;
    }

    public Milk(String name, int weight, int calories, String processingType, int time, int calcium, String productType, int fatContent, String pasteurization) {
        super(name, weight, calories, processingType, time, calcium, productType, fatContent);
        this.pasteurization = pasteurization;
    }
}
