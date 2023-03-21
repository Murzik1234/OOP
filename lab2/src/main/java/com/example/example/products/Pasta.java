package com.example.example.products;

import com.example.example.products.CerealsGrainsProduct;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Pasta extends CerealsGrainsProduct {
    private String wheatType;

    public String getWheatType() {
        return wheatType;
    }

    public void setWheatType(String wheatType) {
        this.wheatType = wheatType;
    }

    public Pasta(String name, int weight, int calories, String processType, int time, int carb, String productType, String wheatType) {
        super(name, weight, calories, processType, time, carb, productType);
        this.wheatType = wheatType;
    }
    @Override
    public StringProperty getMoreProductInfo() {
        return new SimpleStringProperty(super.getMoreProductInfo().getValue()+ ", сорт пшеницы: " + this.getWheatType());
    }
}
