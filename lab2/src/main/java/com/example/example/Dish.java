package com.example.example;
import com.example.example.products.BaseProduct;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Dish {
    private String name;
    final ObservableList<BaseProduct> productsList = FXCollections.observableArrayList();

    public ObservableList<BaseProduct> getProductsList() {
        return productsList;
    }

    public Dish(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StringProperty getCookingTime(){
        Iterator<BaseProduct> iterator = productsList.iterator();
        int fullTime = 0;
        while (iterator.hasNext()) {
            fullTime = fullTime + iterator.next().getTime();
        }
        if (fullTime != 0){
            return new SimpleStringProperty(fullTime +"");
        }
        return new SimpleStringProperty("");
    }
    public StringProperty getIngredientsToString(){
        Iterator<BaseProduct> iterator = productsList.iterator();
        StringBuilder sb = new StringBuilder();
        while (iterator.hasNext()) {
            BaseProduct temp = iterator.next();
            sb.append(temp.toString()+ " " + temp.getMoreProductInfo().getValue() + '\n');
        }
        return new SimpleStringProperty(sb.toString());
    }
}
