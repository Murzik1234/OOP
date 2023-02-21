package com.company.products;

public class BaseProduct {
    private String name;
    private int weight;
    private int calories;
    private String  processingType;
    private int time;

    public String getProcessingType() {
        return processingType;
    }

    public void setProcessingType(String processingType) {
        this.processingType = processingType;
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

    public BaseProduct(String name, int weight, int calories, String processingType, int time) {
        this.name = name;
        this.weight = weight;
        this.calories = calories;
        this.processingType = processingType;
        this.time = time;
    }

}




