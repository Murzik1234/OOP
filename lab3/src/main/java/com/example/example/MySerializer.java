package com.example.example;

import com.example.example.dataModels.DishDataModel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public interface MySerializer {
     void serialize(String filePath, ArrayList<Dish> dishes) throws IOException;
     Object deserialize(String filePath) throws IOException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException;
}
