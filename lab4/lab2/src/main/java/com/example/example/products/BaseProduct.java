package com.example.example.products;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.Serializable;


public class BaseProduct implements Serializable {

    private String name;
    private int weight;
    private int calories;
    private String processType;
    private int time;

    public void edit(){

    }
    public BaseProduct(String name, int weight, int calories, String processType, int time) {
        this.name = name;
        this.weight = weight;
        this.calories = calories;
        this.processType = processType;
        this.time = time;
    }

    @Override
    public String toString() {
        return  name + " : "+weight+" г, " + calories +" Ккал, "+processType+" "+time+" мин ";

    }

    public String getProcessType() {
        return processType;
    }

    public void setProcessType(String processType) {
        this.processType = processType;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getName(){
        return name;
    };
    public void setName(String name){
        this.name = name;
    };

    public int getWeight(){
        return weight;
    };
    public void setWeight(int weight){
        this.weight = weight;
    };

    public int getCalories(){
        return calories;
    };
    public void setCalories(int calories){
        this.calories = calories;
    };

    public BaseProduct(String name, int weight, int calories) {
        this.name = name;
        this.weight = weight;
        this.calories = calories;
    }

    public BaseProduct() {

    }
    public BaseProduct(String[] properties) {

    }
    public BaseProduct(String name) {
        this.name = name;
    }

    public StringProperty getProductWeigh(){
        return new SimpleStringProperty( weight+"");
    }
    public StringProperty getProductCalories(){
        return new SimpleStringProperty( calories+"");
    }
    public StringProperty getProductTime(){
        return new SimpleStringProperty( time+"");
    }
    public StringProperty getMoreProductInfo(){
        return new SimpleStringProperty( "");
    }

}




