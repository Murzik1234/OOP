package com.example.example.products;

import com.example.example.StringSplit;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.Serializable;
import java.util.ArrayList;

public class Milk extends MilkProduct implements Serializable {
    private String pasteurization;

    public String getPasteurization() {
        return pasteurization;
    }

    public void setPasteurization(String pasteurization) {
        this.pasteurization = pasteurization;
    }

    public Milk(String name, int weight, int calories, String processType, int time, int calcium, int fatContent, String pasteurization) {
        super(name, weight, calories, processType, time, calcium, fatContent);
        this.pasteurization = pasteurization;
    }
    public Milk(ArrayList<String> properties) {
        this.setName(properties.get(0));
        this.setWeight(Integer.parseInt(properties.get(1)));
        this.setCalories(Integer.parseInt(properties.get(2)));
        this.setProcessType(properties.get(3));
        this.setTime(Integer.parseInt(properties.get(4)));
        this.setCalcium(Integer.parseInt(properties.get(5)));
        this.setFatContent(Integer.parseInt(properties.get(6)));
        this.pasteurization = properties.get(7);
    }
    @Override
    public StringProperty getMoreProductInfo() {
        return new SimpleStringProperty(super.getMoreProductInfo().getValue()+ ", пастеризация: " + this.pasteurization);
    }
}
