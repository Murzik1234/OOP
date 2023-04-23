package com.example.example;

import com.example.example.products.BaseProduct;
import javafx.scene.control.Alert;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.lang.reflect.Field;
import java.util.List;

public class MyTxtSerialize implements MySerializer {

    public String escapeSpecialCharacters(String input) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == ':' || c == ',' || c == '{' || c == '}' || c == '\\') {
                sb.append('\\');
            }
            sb.append(c);
        }
        return sb.toString();
    }

    @Override
    public void serialize(String filePath, ArrayList<Dish> dishes) throws IOException {
        FileWriter writer = new FileWriter(filePath);
        for (Dish dish : dishes) {
            writer.write(escapeSpecialCharacters(dish.getName()));
            if (dish.getProductsList().size() != 0) {
                writer.write(":[");
                for (int i = 0; i < dish.getProductsList().size(); i++) {
                    Class<?> clazz = dish.getProductsList().get(i).getClass();
                    writer.write("{" + clazz.getName());
                    if (clazz.getSuperclass() != null) {
                        if (clazz.getSuperclass().getSuperclass() != null) {
                            Field[] parentFields = clazz.getSuperclass().getSuperclass().getDeclaredFields();
                            for (Field field : parentFields) {
                                field.setAccessible(true);
                                try {
                                    writer.write("," + escapeSpecialCharacters(field.get(dish.getProductsList().get(i)).toString()));
                                } catch (IllegalAccessException e) {
                                }
                            }
                        }
                        Field[] parentFields = clazz.getSuperclass().getDeclaredFields();
                        for (Field field : parentFields) {
                            field.setAccessible(true);
                            try {
                                writer.write("," + escapeSpecialCharacters(field.get(dish.getProductsList().get(i)).toString()));
                            } catch (IllegalAccessException e) {
                            }
                        }
                        Field[] fields = clazz.getDeclaredFields();
                        for (Field field : fields) {
                            field.setAccessible(true);
                            try {
                                writer.write("," + escapeSpecialCharacters(field.get(dish.getProductsList().get(i)).toString()));
                            } catch (IllegalAccessException e) {
                            }
                        }
                        writer.write("}");
                    }
                }
                writer.write("]\n");
            }
        }
        writer.close();
    }

    public ArrayList<String> objects(String str) {
        ArrayList<String> objectsList = new ArrayList<>();
        String openBracket = "{";
        String closeBracket = "}";
        int startIndex = 0;
        int endIndex = 0;
        while (true) {
            startIndex = str.indexOf(openBracket, endIndex);
            while (startIndex > 0 && str.charAt(startIndex - 1) == '\\') {
                startIndex = str.indexOf(openBracket, endIndex + 1);
            }
            if (startIndex == -1) {
                break;
            }
            endIndex = str.indexOf(closeBracket, startIndex);
            while (endIndex > 0 && str.charAt(endIndex - 1) == '\\') {
                endIndex = str.indexOf(closeBracket, endIndex + 1);
            }
            if (endIndex == -1) {
                break;
            }
            String match = str.substring(startIndex + 1, endIndex);
            objectsList.add(match);
        }
        return objectsList;
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
        StringSplit stringSplit = new StringSplit();
        ArrayList<Dish> dishes = new ArrayList<>();
        ArrayList<String> objectsList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = stringSplit.split(line, ':');
                Dish dish = new Dish(stringSplit.removeSingleBackslashes(tokens[0]));
                dishes.add(dish);
                objectsList = objects(tokens[1]);
                for (String obj : objectsList) {
                    String[] properties = stringSplit.split(obj, ',');
                    Class myClass = Class.forName(properties[0]);
                    Constructor<?> cons = myClass.getDeclaredConstructor(String.class);
                    System.out.println(cons);
                    Object o = cons.newInstance(obj);
                    dish.getProductsList().add((BaseProduct) o);
                }
            }
        } catch (IOException | NoSuchMethodException | ClassNotFoundException e) {
            dishes.clear();
            createAlert(Alert.AlertType.ERROR, "Error", "Error TXT file serialization!", "Check file info");
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return dishes;
    }
}
