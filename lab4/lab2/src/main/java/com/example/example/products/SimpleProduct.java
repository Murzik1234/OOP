package com.example.example.products;

import com.example.example.StringSplit;

import java.io.Serializable;
import java.util.ArrayList;

public class SimpleProduct extends BaseProduct implements Serializable {
    public SimpleProduct(String name, int weight, int calories, String processType, int time) {
        super(name, weight, calories, processType, time);
    }

    public SimpleProduct(ArrayList<String> properties) {
        this.setName(properties.get(0));
        this.setWeight(Integer.parseInt(properties.get(1)));
        this.setCalories(Integer.parseInt(properties.get(2)));
        this.setProcessType(properties.get(3));
        this.setTime(Integer.parseInt(properties.get(4)));
    }
}
