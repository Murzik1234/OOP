package com.example.example.products;

import com.example.example.StringSplit;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.Serializable;

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
    public MeatPartProduct(String prop) {
        StringSplit stringSplit = new StringSplit();
        String[] properties = stringSplit.split(prop, ',');
        this.setName(properties[1].replace("\\", ""));
        this.setWeight(Integer.parseInt(properties[2]));
        this.setCalories(Integer.parseInt(properties[3]));
        this.setProcessType(properties[4]);
        this.setTime(Integer.parseInt(properties[5]));
        this.setProtein(Integer.parseInt(properties[6]));
        this.setMeatType(properties[7]);
        this.bodyPart = properties[8];
    }
    @Override
    public StringProperty getMoreProductInfo() {
        return new SimpleStringProperty(super.getMoreProductInfo().getValue()+ ", часть тела: " + this.bodyPart);
    }
}
