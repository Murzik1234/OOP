package com.example.example.products;

import com.example.example.StringSplit;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.Serializable;
import java.util.ArrayList;

public class MeatPartProduct extends MeatProduct implements Serializable {
    private String bodyPart;

    public String getBodyPart() {
        return bodyPart;
    }

    public void setBodyPart(String bodyPart) {
        this.bodyPart = bodyPart;
    }

    public MeatPartProduct(String name, int weight, int calories, String processType, int time, int protein, String meatType, String bodyPart) {
        super(name, weight, calories, processType, time, protein, meatType);
        this.bodyPart = bodyPart;
    }
    public MeatPartProduct(ArrayList<String> properties) {
        this.setName(properties.get(0));
        this.setWeight(Integer.parseInt(properties.get(1)));
        this.setCalories(Integer.parseInt(properties.get(2)));
        this.setProcessType(properties.get(3));
        this.setTime(Integer.parseInt(properties.get(4)));
        this.setProtein(Integer.parseInt(properties.get(5)));
        this.setMeatType(properties.get(6));
        this.bodyPart = properties.get(7);
    }
    @Override
    public StringProperty getMoreProductInfo() {
        return new SimpleStringProperty(super.getMoreProductInfo().getValue()+ ", часть тела: " + this.bodyPart);
    }
}
