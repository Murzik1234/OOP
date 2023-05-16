package com.example.example;
import com.example.example.products.BaseProduct;
import java.io.Serializable;
import java.util.ArrayList;

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

