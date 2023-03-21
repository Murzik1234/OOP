package com.example.example.products;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class MilkProduct extends BaseProduct {
    private int calcium;
    private int fatContent;


    public int getFatContent() {
        return fatContent;
    }
    public void setFatContent(int fatContent) {
        this.fatContent = fatContent;
    }

    public int getCalcium() {
        return calcium;
    }
    public void setCalcium(int calcium) {
        this.calcium = calcium;
    }

    public MilkProduct(String name, int weight, int calories, String processType, int time, int calcium, int fatContent) {
        super(name, weight, calories, processType, time);
        this.calcium = calcium;
        this.fatContent = fatContent;
    }
    @Override
    public StringProperty getMoreProductInfo() {
        return new SimpleStringProperty(super.getMoreProductInfo().getValue()+ "Доп: Ca: " + this.calcium + ", % жирности: " + this.fatContent);
    }
}
