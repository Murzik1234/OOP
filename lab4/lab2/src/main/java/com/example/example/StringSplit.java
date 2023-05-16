package com.example.example;
import com.example.example.products.BaseProduct;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class StringSplit {

    public StringSplit() {

    }

    public Dish parse(String line) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Dish dish = new Dish();
        StringBuilder str = new StringBuilder(line);
        int state = 1;
        ArrayList<String> prop = new ArrayList<>();
        String className = "";
        int productClassStartIndex = 0;
        int productClassEndIndex = 0;
        int oldState = 1;
        if (line.charAt(0) == '\\') {
            state = 4;
        }
        for (int i = 1; i < str.length() ; i++) {
            char c = str.charAt(i);
            switch (state) {
                case 1:
                    if (c == '\\') {
                        state = 4;
                    }
                    if (c == ':') {
                        dish.setName(str.substring(0, i));
                        state = 2;
                    }
                    oldState = 1;
                    break;
                case 2:
                    if (c == '{') {
                        productClassStartIndex = i + 1;
                        state = 3;
                        prop = new ArrayList<>();
                    }
                    break;
                case 3:
                    if (c == '\\') {
                        state = 4;
                    }
                    if (c == ',' && className == "") {
                        className = str.substring(productClassStartIndex, i);
                        productClassEndIndex = i;

                    } else{
                        if(c == ',' && str.charAt(i - 1) != '\\') {
                            prop.add(str.substring(productClassEndIndex + 1, i));
                            productClassEndIndex = i;
                        }
                    }
                    if (c == '}') {
                        prop.add(str.substring(productClassEndIndex + 1, i));
                        Class myClass = Class.forName(className);
                        Constructor<?> cons = myClass.getDeclaredConstructor(ArrayList.class);
                        Object o = cons.newInstance(prop);
                        dish.getProductsList().add((BaseProduct) o);
                        System.out.println(o);
                        className = "";
                        state = 2;
                    }
                    oldState = 3;
                    break;
                case 4:
                    str.deleteCharAt(i - 1);
                    i--;
                    state = oldState;
                    break;
            }
        }
        return dish;
    }

}




