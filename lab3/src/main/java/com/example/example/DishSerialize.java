package com.example.example;

import com.example.example.products.BaseProduct;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class DishSerialize implements Serializable {
    private String name;
    private ArrayList<BaseProduct> productsList;

    public DishSerialize() {

    }

    public ArrayList<BaseProduct> getProductsList() {
        return productsList;
    }

    public void setProductsList(ArrayList<BaseProduct> productsList) {
        this.productsList = productsList;
    }

    public DishSerialize(String name, ArrayList<BaseProduct> productsList) {
        this.name = name;
        this.productsList = productsList;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}

