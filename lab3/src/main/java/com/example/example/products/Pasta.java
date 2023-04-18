package com.example.example.products;

import com.example.example.StringSplit;
import com.example.example.products.CerealsGrainsProduct;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.Serializable;

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
    public Pasta(String prop) {
        StringSplit stringSplit = new StringSplit();
        String[] properties = stringSplit.split(prop, ',');
        this.setName(properties[1]);
        this.setWeight(Integer.parseInt(properties[2]));
        this.setCalories(Integer.parseInt(properties[3]));
        this.setProcessType(properties[4]);
        this.setTime(Integer.parseInt(properties[5]));
        this.setCarb(Integer.parseInt(properties[6]));
        this.setProductType(properties[7]);
        this.wheatType = properties[8];
    }
    @Override
    public StringProperty getMoreProductInfo() {
        return new SimpleStringProperty(super.getMoreProductInfo().getValue()+ ", сорт пшеницы: " + this.getWheatType());
    }
}
