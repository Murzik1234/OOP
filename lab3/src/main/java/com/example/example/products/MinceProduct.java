package com.example.example.products;

import com.example.example.StringSplit;
import com.example.example.products.MeatProduct;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.Serializable;

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
    public MinceProduct(String prop) {
        StringSplit stringSplit = new StringSplit();
        String[] properties = stringSplit.split(prop, ',');
        this.setName(properties[1].replace("\\", ""));
        this.setWeight(Integer.parseInt(properties[2]));
        this.setCalories(Integer.parseInt(properties[3]));
        this.setProcessType(properties[4]);
        this.setTime(Integer.parseInt(properties[5]));
        this.setProtein(Integer.parseInt(properties[6]));
        this.setMeatType(properties[7]);
        this.meatPercent = Integer.parseInt(properties[8]);
    }

    @Override
    public StringProperty getMoreProductInfo() {
        return new SimpleStringProperty(super.getMoreProductInfo().getValue()+ ", % мяса: " + this.meatPercent);
    }
}
