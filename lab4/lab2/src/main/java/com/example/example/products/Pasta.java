package com.example.example.products;

import com.example.example.StringSplit;
import com.example.example.products.CerealsGrainsProduct;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.Serializable;
import java.util.ArrayList;

public class Pasta extends CerealsGrainsProduct implements Serializable {
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
    public Pasta(ArrayList<String> properties) {
        this.setName(properties.get(0));
        this.setWeight(Integer.parseInt(properties.get(1)));
        this.setCalories(Integer.parseInt(properties.get(2)));
        this.setProcessType(properties.get(3));
        this.setTime(Integer.parseInt(properties.get(4)));
        this.setCarb(Integer.parseInt(properties.get(5)));
        this.setProductType(properties.get(6));
        this.wheatType = properties.get(7);
    }
    public Pasta(String[] prop){

    }
    @Override
    public StringProperty getMoreProductInfo() {
        return new SimpleStringProperty(super.getMoreProductInfo().getValue()+ ", сорт пшеницы: " + this.getWheatType());
    }
}
