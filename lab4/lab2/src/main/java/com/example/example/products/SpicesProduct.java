package com.example.example.products;

import com.example.example.StringSplit;
import com.example.example.products.BaseProduct;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.Serializable;
import java.util.ArrayList;

public class SpicesProduct extends BaseProduct implements Serializable {
    private String sharpness;
    private String country;

    public String getSharpness() {
        return sharpness;
    }
    public void setSharpness(String sharpness) {
        this.sharpness = sharpness;
    }

    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    public SpicesProduct(String name, int weight, int calories, String processType, int time, String sharpness, String country) {
        super(name, weight, calories, processType, time);
        this.sharpness = sharpness;
        this.country = country;
    }
    public SpicesProduct(ArrayList<String> properties) {
        this.setName(properties.get(0));
        this.setWeight(Integer.parseInt(properties.get(1)));
        this.setCalories(Integer.parseInt(properties.get(2)));
        this.setProcessType(properties.get(3));
        this.setTime(Integer.parseInt(properties.get(4)));
        this.sharpness = properties.get(5);
        this.country = properties.get(6);
    }
    @Override
    public StringProperty getMoreProductInfo() {
        return new SimpleStringProperty(super.getMoreProductInfo().getValue()+ "Доп: острота: " + this.getSharpness()+ " , страна: "+ this.getCountry());
    }
}
