package com.example.example.products;

import com.example.example.products.BaseProduct;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SpicesProduct extends BaseProduct {
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
    @Override
    public StringProperty getMoreProductInfo() {
        return new SimpleStringProperty(super.getMoreProductInfo().getValue()+ "Доп: острота: " + this.getSharpness()+ " , страна: "+ this.getCountry());
    }
}
