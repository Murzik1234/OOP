package com.example.example.products;

import com.example.example.StringSplit;
import com.example.example.products.BaseProduct;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.Serializable;
import java.util.ArrayList;

public class FishProduct extends BaseProduct implements Serializable {
    private int omega3;
    private String fishArea;


    public int getOmega3() {
        return omega3;
    }
    public void setOmega3(int omega3) {
        this.omega3 = omega3;
    }

    public String getFishArea() {
        return fishArea;
    }
    public void setFishArea(String fishArea) {
        this.fishArea = fishArea;
    }

    public FishProduct(String name, int weight, int calories, String processType, int time, int omega3, String fishArea) {
        super(name, weight, calories, processType, time);
        this.omega3 = omega3;
        this.fishArea = fishArea;
    }
    public FishProduct() {

    }
    public FishProduct(ArrayList<String> properties) {
        this.setName(properties.get(0));
        this.setWeight(Integer.parseInt(properties.get(1)));
        this.setCalories(Integer.parseInt(properties.get(2)));
        this.setProcessType(properties.get(3));
        this.setTime(Integer.parseInt(properties.get(4)));
        this.omega3 = Integer.parseInt(properties.get(5));
        this.fishArea = properties.get(6);
    }

    @Override
    public StringProperty getMoreProductInfo() {
        return new SimpleStringProperty(super.getMoreProductInfo().getValue()+ "Доп: омега3: " + this.getOmega3()+ " , среда обитания: "+ this.getFishArea());
    }
}
