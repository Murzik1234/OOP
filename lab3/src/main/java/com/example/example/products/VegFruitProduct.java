package com.example.example.products;

import com.example.example.StringSplit;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.Serializable;
import java.util.ArrayList;

public class VegFruitProduct extends BaseProduct implements Serializable {
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
    public VegFruitProduct() {

    }
    public VegFruitProduct(ArrayList<String> properties) {
        this.setName(properties.get(0));
        this.setWeight(Integer.parseInt(properties.get(1)));
        this.setCalories(Integer.parseInt(properties.get(2)));
        this.setProcessType(properties.get(3));
        this.setTime(Integer.parseInt(properties.get(4)));
        this.fiber = Integer.parseInt(properties.get(5));
    }


    @Override
    public StringProperty getMoreProductInfo() {
        return new SimpleStringProperty(super.getMoreProductInfo().getValue()+ "Доп: клетчатка: " + this.fiber + " г. " );
    }
}
