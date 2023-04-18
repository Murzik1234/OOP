package com.example.example.products;

import com.example.example.StringSplit;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.Serializable;


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

    public MeatProduct(String prop) {
        StringSplit stringSplit = new StringSplit();
        String[] properties = stringSplit.split(prop, ',');
        this.setName(properties[1]);
        this.setWeight(Integer.parseInt(properties[2]));
        this.setCalories(Integer.parseInt(properties[3]));
        this.setProcessType(properties[4]);
        this.setTime(Integer.parseInt(properties[5]));
        this.protein = Integer.parseInt(properties[6]);
        this.meatType = properties[7];
    }

    @Override
    public StringProperty getMoreProductInfo() {
         return new SimpleStringProperty(super.getMoreProductInfo().getValue()+ "Доп: " + this.getProtein()+ " г. белка, тип мяса: "+ this.getMeatType());
    }


}
