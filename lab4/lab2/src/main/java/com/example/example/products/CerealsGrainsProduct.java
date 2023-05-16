package com.example.example.products;

import com.example.example.StringSplit;
import com.example.example.products.BaseProduct;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.Serializable;
import java.util.ArrayList;

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

    public CerealsGrainsProduct(ArrayList<String> properties) {
        this.setName(properties.get(0));
        this.setWeight(Integer.parseInt(properties.get(0)));
        this.setCalories(Integer.parseInt(properties.get(0)));
        this.setProcessType(properties.get(0));
        this.setTime(Integer.parseInt(properties.get(0)));
        this.carb = Integer.parseInt(properties.get(0));
        this.productType = properties.get(0);
    }

    @Override
    public StringProperty getMoreProductInfo() {
        return new SimpleStringProperty(super.getMoreProductInfo().getValue()+ "Доп: углеводы: " + this.getCarb()+ " , тип: "+ this.getProductType());
    }
}
