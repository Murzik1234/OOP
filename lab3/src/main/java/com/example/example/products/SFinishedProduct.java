package com.example.example.products;

import com.example.example.StringSplit;
import com.example.example.products.FishProduct;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.Serializable;

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
    public SFinishedProduct(String prop) {
        StringSplit stringSplit = new StringSplit();
        String[] properties = stringSplit.split(prop, ',');
        this.setName(stringSplit.removeSingleBackslashes(properties[1]));
        this.setWeight(Integer.parseInt(properties[2]));
        this.setCalories(Integer.parseInt(properties[3]));
        this.setProcessType(properties[4]);
        this.setTime(Integer.parseInt(properties[5]));
        this.setOmega3(Integer.parseInt(properties[6]));
        this.setFishArea(properties[7]);
        this.data = Integer.parseInt(properties[8]);
    }

    @Override
    public StringProperty getMoreProductInfo() {
        return new SimpleStringProperty(super.getMoreProductInfo().getValue()+ " , срок годности: " + this.getData()+ " дней");
    }
}
