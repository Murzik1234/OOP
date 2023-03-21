package com.example.example.products;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ByProduct extends MeatProduct {
    private String category;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public ByProduct(String name, int weight, int calories, String processType, int time, int protein, String meatType, String category) {
        super(name, weight, calories, processType, time, protein, meatType);
        this.category = category;
    }

    @Override
    public StringProperty getMoreProductInfo() {
        return new SimpleStringProperty(super.getMoreProductInfo().getValue()+ ", категория: " + this.getCategory());
    }
}
