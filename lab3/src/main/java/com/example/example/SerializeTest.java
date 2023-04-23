package com.example.example;

import com.example.example.dataModels.DishDataModel;
import com.example.example.products.BaseProduct;
import com.example.example.products.SimpleProduct;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import junit.framework.TestCase;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

public class SerializeTest extends junit.framework.TestCase {

    @Test
    public void testTxtSerialize() throws IOException {
        ObservableList<Dish> mainDishesList = FXCollections.observableArrayList();
        ObservableList<Dish> dishesList = FXCollections.observableArrayList();
        ObservableList<BaseProduct> productsList = FXCollections.observableArrayList();
        productsList.setAll(new SimpleProduct("\\:,\\\\,С:о,\\\\{ль}}", 12, 12, "Варить", 6));
        Dish dish = new Dish("С,,\\\\у{}п", productsList);
        mainDishesList.setAll(dish);
        MyTxtSerialize myTxtSerialize = new MyTxtSerialize();
        myTxtSerialize.serialize("test.txt", new ArrayList<Dish>(mainDishesList));
        dishesList.setAll((ArrayList<Dish>)myTxtSerialize.deserialize("test.txt"));
        assertEquals("Error serialization : wrong size",mainDishesList.size(), 1);
        assertEquals("Error serialization : wrong dish name",mainDishesList.get(0).getName(), "С,,\\\\у{}п");
        assertEquals("Error serialization : wrong product list size",mainDishesList.get(0).getProductsList().size(), 1);
        assertEquals("Error serialization : wrong product name",mainDishesList.get(0).getProductsList().get(0).getName(), "\\:,\\\\,С:о,\\\\{ль}}");
        assertEquals("Error serialization : wrong product weight",mainDishesList.get(0).getProductsList().get(0).getWeight(), 12);
        assertEquals("Error serialization : wrong product calories",mainDishesList.get(0).getProductsList().get(0).getCalories(), 12);
        assertEquals("Error serialization : wrong product process type",mainDishesList.get(0).getProductsList().get(0).getProcessType(), "Варить");
        assertEquals("Error serialization : wrong product time",mainDishesList.get(0).getProductsList().get(0).getTime(), 6);
    }
}
