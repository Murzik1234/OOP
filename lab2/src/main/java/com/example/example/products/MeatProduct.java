package com.example.example.products;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class MeatProduct extends BaseProduct  {
    private int protein;
    private String meatType;


    public int getProtein() {
        return protein;
    }
    public void setProtein(int protein) {
        this.protein = protein;
    }

    public String getMeatType() {
        return meatType;
    }
    public void setMeatType(String meatType) {
        this.meatType = meatType;
    }

    public MeatProduct(String name, int weight, int calories, String processType, int time, int protein, String meatType) {
        super(name, weight, calories, processType, time);
        this.protein = protein;
        this.meatType = meatType;
    }

    @Override
    public StringProperty getMoreProductInfo() {
         return new SimpleStringProperty(super.getMoreProductInfo().getValue()+ "Доп: " + this.getProtein()+ " г. белка, тип мяса: "+ this.getMeatType());
    }


}
