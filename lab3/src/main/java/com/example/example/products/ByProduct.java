package com.example.example.products;

import com.example.example.StringSplit;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.Serializable;

public class ByProduct extends MeatProduct implements Serializable {
    private String category;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public ByProduct(String name, int weight, int calories, String processType, int time, int protein, String meatType, String category) {
        super(name, weight, calories, processType, time, protein, meatType);
        this.category = category;
    }
    public ByProduct(String prop) {
        StringSplit stringSplit = new StringSplit();
        String[] properties = stringSplit.split(prop, ',');
        this.setName(properties[1].replace("\\", ""));
        this.setWeight(Integer.parseInt(properties[2]));
        this.setCalories(Integer.parseInt(properties[3]));
        this.setProcessType(properties[4]);
        this.setTime(Integer.parseInt(properties[5]));
        this.setProtein(Integer.parseInt(properties[6]));
        this.setMeatType(properties[7]);
        this.category = properties[8];
    }

    @Override
    public StringProperty getMoreProductInfo() {
        return new SimpleStringProperty(super.getMoreProductInfo().getValue()+ ", категория: " + this.getCategory());
    }
}
