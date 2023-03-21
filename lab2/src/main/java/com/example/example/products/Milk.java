package com.example.example.products;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Milk extends MilkProduct {
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
    @Override
    public StringProperty getMoreProductInfo() {
        return new SimpleStringProperty(super.getMoreProductInfo().getValue()+ ", пастеризация: " + this.pasteurization);
    }
}
