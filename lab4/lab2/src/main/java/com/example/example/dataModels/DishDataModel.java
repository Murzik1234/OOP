package com.example.example.dataModels;

import com.example.example.Dish;
import com.example.example.products.BaseProduct;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.Serializable;

public class DishDataModel implements Serializable {
    private ObservableList<Dish> dishesList = FXCollections.observableArrayList();

    public ObservableList<Dish> getDishesList() {
        return dishesList;
    }

    public DishDataModel(ObservableList<Dish> dishesList) {
        this.dishesList = dishesList;
    }

    public DishDataModel() {

    }

    public void initData(){
        final ObservableList<BaseProduct> menuList = FXCollections.observableArrayList();
    }

}
