package com.example.example.products;

import com.example.example.StringSplit;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.Serializable;

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
    public VegFruitProduct(String prop) {
        StringSplit stringSplit = new StringSplit();
        String[] properties = stringSplit.split(prop, ',');
        this.setName(stringSplit.removeSingleBackslashes(properties[1]));
        this.setWeight(Integer.parseInt(properties[2]));
        this.setCalories(Integer.parseInt(properties[3]));
        this.setProcessType(properties[4]);
        this.setTime(Integer.parseInt(properties[5]));
        this.fiber = Integer.parseInt(properties[6]);
    }


    @Override
    public StringProperty getMoreProductInfo() {
        return new SimpleStringProperty(super.getMoreProductInfo().getValue()+ "Доп: клетчатка: " + this.fiber + " г. " );
    }
}
