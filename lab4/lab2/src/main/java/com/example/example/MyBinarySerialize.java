package com.example.example;

import com.example.example.products.BaseProduct;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

import java.io.*;
import java.util.ArrayList;

public class MyBinarySerialize implements MySerializer{
    @Override
    public void serialize(String filePath, ArrayList<Dish> dishes) throws IOException {
        ArrayList<DishSerialize> dishSerializes = new ArrayList<>();
        for (Dish dish : dishes){
            DishSerialize newDish = new DishSerialize(dish.getName(), new ArrayList<BaseProduct>(dish.getProductsList()));
            dishSerializes.add(newDish);
        }
        FileOutputStream os = new FileOutputStream(filePath);
        ObjectOutputStream output = new ObjectOutputStream(os);
        output.writeObject(dishSerializes);
        output.close();
    }

    public static void createAlert(final Alert.AlertType type, final String title, final String header, final String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

    @Override
    public Object deserialize(String filePath) throws IOException {
        FileInputStream os = new FileInputStream(filePath);
        ObjectInputStream input = new ObjectInputStream(os);
        ArrayList<Dish> dishR = new ArrayList<>();
        ArrayList<DishSerialize> dishes = null;
        try {
            dishes = (ArrayList<DishSerialize>)input.readObject();
            for (DishSerialize newDish : dishes ){
                ObservableList<BaseProduct> tmpProductsList = FXCollections.observableArrayList();
                tmpProductsList.setAll((ArrayList<BaseProduct>)newDish.getProductsList());
                Dish dish = new Dish(newDish.getName(), tmpProductsList);
                dishR.add(dish);

            }
        } catch (ClassNotFoundException e) {
            dishR.clear();
            createAlert(Alert.AlertType.ERROR, "Error", "Error BINARY file serialization!", "Check file info");
        }
        return dishR;
    }
}
