package com.example.example.products;

import com.example.example.StringSplit;

import java.io.Serializable;

public class SimpleProduct extends BaseProduct implements Serializable {
    public SimpleProduct(String name, int weight, int calories, String processType, int time) {
        super(name, weight, calories, processType, time);
    }
    public SimpleProduct(String prop) {
        StringSplit stringSplit = new StringSplit();
        String[] properties = stringSplit.split(prop, ',');
        this.setName(properties[1].replace("\\", ""));
        this.setWeight(Integer.parseInt(properties[2]));
        this.setCalories(Integer.parseInt(properties[3]));
        this.setProcessType(properties[4]);
        this.setTime(Integer.parseInt(properties[5]));
    }
}
