package com.example.example.products;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class VegFruitProduct extends BaseProduct{
    private int fiber;

    public int getFiber() {
        return fiber;
    }

    public void setFiber(int fiber) {
        this.fiber = fiber;
    }

    public VegFruitProduct(String name, int weight, int calories, String processType, int time, int fiber) {
        super(name, weight, calories, processType, time);
        this.fiber = fiber;
    }
    @Override
    public StringProperty getMoreProductInfo() {
        return new SimpleStringProperty(super.getMoreProductInfo().getValue()+ "Доп: клетчатка: " + this.fiber + " г. " );
    }
}
