package com.example.example.products;

import com.example.example.StringSplit;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.Serializable;
import java.util.ArrayList;


public class MeatProduct extends BaseProduct  implements Serializable {
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
    public MeatProduct() {

    }

    public MeatProduct(ArrayList<String> properties) {
        this.setName(properties.get(0));
        this.setWeight(Integer.parseInt(properties.get(1)));
        this.setCalories(Integer.parseInt(properties.get(2)));
        this.setProcessType(properties.get(3));
        this.setTime(Integer.parseInt(properties.get(4)));
        this.protein = Integer.parseInt(properties.get(5));
        this.meatType = properties.get(6);
    }

    @Override
    public StringProperty getMoreProductInfo() {
         return new SimpleStringProperty(super.getMoreProductInfo().getValue()+ "Доп: " + this.getProtein()+ " г. белка, тип мяса: "+ this.getMeatType());
    }


}
