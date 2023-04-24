package com.example.example.products;

import com.example.example.StringSplit;
import com.example.example.products.MeatProduct;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.Serializable;
import java.util.ArrayList;

public class MinceProduct extends MeatProduct implements Serializable {
    private int meatPercent;

    public int getMeatPercent() {
        return meatPercent;
    }
    public void setMeatPercent(int meatPercent) {
        this.meatPercent = meatPercent;
    }

    public MinceProduct(String name, int weight, int calories, String processType, int time, int protein, String meatType, int meatPercent) {
        super(name, weight, calories, processType, time, protein, meatType);
        this.meatPercent = meatPercent;
    }
    public MinceProduct(ArrayList<String> properties) {
        this.setName(properties.get(0));
        this.setWeight(Integer.parseInt(properties.get(1)));
        this.setCalories(Integer.parseInt(properties.get(2)));
        this.setProcessType(properties.get(3));
        this.setTime(Integer.parseInt(properties.get(4)));
        this.setProtein(Integer.parseInt(properties.get(5)));
        this.setMeatType(properties.get(6));
        this.meatPercent = Integer.parseInt(properties.get(7));
    }

    @Override
    public StringProperty getMoreProductInfo() {
        return new SimpleStringProperty(super.getMoreProductInfo().getValue()+ ", % мяса: " + this.meatPercent);
    }
}
