package com.example.example.products;

import com.example.example.StringSplit;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.Serializable;
import java.util.ArrayList;

public class MilkProduct extends BaseProduct implements Serializable {
    private int calcium;
    private int fatContent;

    public int getFatContent() {
        return fatContent;
    }
    public void setFatContent(int fatContent) {
        this.fatContent = fatContent;
    }

    public int getCalcium() {
        return calcium;
    }
    public void setCalcium(int calcium) {
        this.calcium = calcium;
    }

    public MilkProduct(String name, int weight, int calories, String processType, int time, int calcium, int fatContent) {
        super(name, weight, calories, processType, time);
        this.calcium = calcium;
        this.fatContent = fatContent;
    }

    public MilkProduct() {

    }

    public MilkProduct(ArrayList<String> properties) {
        this.setName(properties.get(0));
        this.setWeight(Integer.parseInt(properties.get(1)));
        this.setCalories(Integer.parseInt(properties.get(2)));
        this.setProcessType(properties.get(3));
        this.setTime(Integer.parseInt(properties.get(4)));
        this.calcium = Integer.parseInt(properties.get(5));
        this.fatContent = Integer.parseInt(properties.get(6));
    }

    @Override
    public StringProperty getMoreProductInfo() {
        return new SimpleStringProperty(super.getMoreProductInfo().getValue()+ "Доп: Ca: " + this.calcium + ", % жирности: " + this.fatContent);
    }
}
