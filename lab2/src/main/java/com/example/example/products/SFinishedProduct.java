package com.example.example.products;

import com.example.example.products.FishProduct;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SFinishedProduct extends FishProduct {
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

    @Override
    public StringProperty getMoreProductInfo() {
        return new SimpleStringProperty(super.getMoreProductInfo().getValue()+ " , срок годности: " + this.getData()+ " дней");
    }
}
