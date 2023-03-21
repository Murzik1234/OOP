package com.example.example.products;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class MeatPartProduct extends MeatProduct {
    private String bodyPart;

    public String getBodyPart() {
        return bodyPart;
    }

    public void setBodyPart(String bodyPart) {
        this.bodyPart = bodyPart;
    }

    public MeatPartProduct(String name, int weight, int calories, String processType, int time, int protein, String meatType, String bodyPart) {
        super(name, weight, calories, processType, time, protein, meatType);
        this.bodyPart = bodyPart;
    }
    @Override
    public StringProperty getMoreProductInfo() {
        return new SimpleStringProperty(super.getMoreProductInfo().getValue()+ ", часть тела: " + this.bodyPart);
    }
}
