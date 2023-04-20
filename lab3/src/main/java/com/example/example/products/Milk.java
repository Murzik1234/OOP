package com.example.example.products;

import com.example.example.StringSplit;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.Serializable;

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
    public Milk(String prop) {
        StringSplit stringSplit = new StringSplit();
        String[] properties = stringSplit.split(prop, ',');
        this.setName(properties[1].replace("\\", ""));
        this.setWeight(Integer.parseInt(properties[2]));
        this.setCalories(Integer.parseInt(properties[3]));
        this.setProcessType(properties[4]);
        this.setTime(Integer.parseInt(properties[5]));
        this.setCalcium(Integer.parseInt(properties[6]));
        this.setFatContent(Integer.parseInt(properties[7]));
        this.pasteurization = properties[8];
    }
    @Override
    public StringProperty getMoreProductInfo() {
        return new SimpleStringProperty(super.getMoreProductInfo().getValue()+ ", пастеризация: " + this.pasteurization);
    }
}
