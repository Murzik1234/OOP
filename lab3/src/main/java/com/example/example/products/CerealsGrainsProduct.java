package com.example.example.products;

import com.example.example.StringSplit;
import com.example.example.products.BaseProduct;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.Serializable;

public class CerealsGrainsProduct extends BaseProduct implements Serializable {
    private int carb;
    private String productType;

    public int getCarb() {
        return carb;
    }
    public void setCarb(int carb) {
        this.carb = carb;
    }
    public String getProductType() {
        return productType;
    }
    public void setProductType(String productType) {
        this.productType = productType;
    }

    public CerealsGrainsProduct(String name, int weight, int calories, String processType, int time, int carb, String productType) {
        super(name, weight, calories, processType, time);
        this.carb = carb;
        this.productType = productType;
    }
    public CerealsGrainsProduct() {

    }

    public CerealsGrainsProduct(String prop) {
        StringSplit stringSplit = new StringSplit();
        String[] properties = stringSplit.split(prop, ',');
        this.setName(properties[1]);
        this.setWeight(Integer.parseInt(properties[2]));
        this.setCalories(Integer.parseInt(properties[3]));
        this.setProcessType(properties[4]);
        this.setTime(Integer.parseInt(properties[5]));
        this.carb = Integer.parseInt(properties[6]);
        this.productType = properties[7];
    }

    @Override
    public StringProperty getMoreProductInfo() {
        return new SimpleStringProperty(super.getMoreProductInfo().getValue()+ "Доп: углеводы: " + this.getCarb()+ " , тип: "+ this.getProductType());
    }
}
