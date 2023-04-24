package com.example.example.products;

import com.example.example.StringSplit;
import com.example.example.products.FishProduct;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.Serializable;
import java.util.ArrayList;

public class SFinishedProduct extends FishProduct implements Serializable {
    private  int data;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public SFinishedProduct(String name, int weight, int calories, String processType, int time, int omega3, String fishArea, int data) {
        super(name, weight, calories, processType, time, omega3, fishArea);
        this.data = data;
    }
    public SFinishedProduct(ArrayList<String> properties) {
        this.setName(properties.get(0));
        this.setWeight(Integer.parseInt(properties.get(1)));
        this.setCalories(Integer.parseInt(properties.get(2)));
        this.setProcessType(properties.get(3));
        this.setTime(Integer.parseInt(properties.get(4)));
        this.setOmega3(Integer.parseInt(properties.get(5)));
        this.setFishArea(properties.get(6));
        this.data = Integer.parseInt(properties.get(7));
    }

    @Override
    public StringProperty getMoreProductInfo() {
        return new SimpleStringProperty(super.getMoreProductInfo().getValue()+ " , срок годности: " + this.getData()+ " дней");
    }
}
