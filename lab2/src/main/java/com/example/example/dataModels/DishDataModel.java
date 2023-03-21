package com.example.example.dataModels;

import com.example.example.Dish;
import com.example.example.products.BaseProduct;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DishDataModel {
    final ObservableList<Dish> dishesList = FXCollections.observableArrayList();

    public ObservableList<Dish> getDishesList() {
        return dishesList;
    }

    public void initData(){
        final ObservableList<BaseProduct> menuList = FXCollections.observableArrayList();
    }




}
