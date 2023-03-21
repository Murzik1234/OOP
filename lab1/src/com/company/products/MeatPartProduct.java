package com.company.products;

public class MeatPartProduct extends MeatProduct {
    private String bodyPart;

    public String getBodyPart() {
        return bodyPart;
    }

    public void setBodyPart(String bodyPart) {
        this.bodyPart = bodyPart;
    }

    public MeatPartProduct(String name, int weight, int calories, String processingType, int time, int protein, String meatType, String bodyPart) {
        super(name, weight, calories, processingType, time, protein, meatType);
        this.bodyPart = bodyPart;
    }
}
