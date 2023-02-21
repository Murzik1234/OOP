package com.company.products;

public class ByProduct extends MeatProduct {
    private int category;

    public int getCategory() {
        return category;
    }
    public void setCategory(int category) {
        this.category = category;
    }

    public ByProduct(String name, int weight, int calories, String processingType, int time, int protein, String meatType, int category) {
        super(name, weight, calories, processingType, time, protein, meatType);
        this.category = category;
    }
}
