package com.example.example.products;

import com.example.example.products.MeatProduct;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class MinceProduct extends MeatProduct {
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

    @Override
    public StringProperty getMoreProductInfo() {
        return new SimpleStringProperty(super.getMoreProductInfo().getValue()+ ", % мяса: " + this.meatPercent);
    }
}
