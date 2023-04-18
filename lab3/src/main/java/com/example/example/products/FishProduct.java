package com.example.example.products;

import com.example.example.StringSplit;
import com.example.example.products.BaseProduct;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.Serializable;

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
    public FishProduct(String prop) {
        StringSplit stringSplit = new StringSplit();
        String[] properties = stringSplit.split(prop, ',');
        this.setName(properties[1]);
        this.setWeight(Integer.parseInt(properties[2]));
        this.setCalories(Integer.parseInt(properties[3]));
        this.setProcessType(properties[4]);
        this.setTime(Integer.parseInt(properties[5]));
        this.omega3 = Integer.parseInt(properties[6]);
        this.fishArea = properties[7];
    }

    @Override
    public StringProperty getMoreProductInfo() {
        return new SimpleStringProperty(super.getMoreProductInfo().getValue()+ "Доп: омега3: " + this.getOmega3()+ " , среда обитания: "+ this.getFishArea());
    }
}
