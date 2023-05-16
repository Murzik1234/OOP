package com.example.example;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public interface MySerializer {
     void serialize(String filePath, ArrayList<Dish> dishes) throws IOException, IllegalAccessException;
     Object deserialize(String filePath) throws IOException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException;
}
