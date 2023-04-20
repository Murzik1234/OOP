package com.example.example.products;

import com.example.example.StringSplit;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.Serializable;

public class MilkProduct extends BaseProduct implements Serializable {
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

    public MilkProduct() {

    }

    public MilkProduct(String prop) {
        StringSplit stringSplit = new StringSplit();
        String[] properties = stringSplit.split(prop, ',');
        this.setName(properties[1].replace("\\", ""));
        this.setWeight(Integer.parseInt(properties[2]));
        this.setCalories(Integer.parseInt(properties[3]));
        this.setProcessType(properties[4]);
        this.setTime(Integer.parseInt(properties[5]));
        this.calcium = Integer.parseInt(properties[6]);
        this.fatContent = Integer.parseInt(properties[7]);
    }

    @Override
    public StringProperty getMoreProductInfo() {
        return new SimpleStringProperty(super.getMoreProductInfo().getValue()+ "Доп: Ca: " + this.calcium + ", % жирности: " + this.fatContent);
    }
}
