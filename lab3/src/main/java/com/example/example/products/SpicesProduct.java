package com.example.example.products;

import com.example.example.StringSplit;
import com.example.example.products.BaseProduct;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.Serializable;

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
    public SpicesProduct(String prop) {
        StringSplit stringSplit = new StringSplit();
        String[] properties = stringSplit.split(prop, ',');
        this.setName(properties[1]);
        this.setWeight(Integer.parseInt(properties[2]));
        this.setCalories(Integer.parseInt(properties[3]));
        this.setProcessType(properties[4]);
        this.setTime(Integer.parseInt(properties[5]));
        this.sharpness = properties[6];
        this.country = properties[7];
    }
    @Override
    public StringProperty getMoreProductInfo() {
        return new SimpleStringProperty(super.getMoreProductInfo().getValue()+ "Доп: острота: " + this.getSharpness()+ " , страна: "+ this.getCountry());
    }
}
