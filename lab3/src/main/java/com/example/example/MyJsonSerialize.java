package com.example.example;
import com.example.example.products.*;
import com.google.gson.reflect.TypeToken;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.typeadapters.*;


public class MyJsonSerialize implements MySerializer {
    private Logger logger = LoggerFactory.getLogger(MyJsonSerialize.class);

    private final RuntimeTypeAdapterFactory<BaseProduct> typeAdapterFactory = RuntimeTypeAdapterFactory.of(BaseProduct.class, "type")
            .registerSubtype(MeatProduct.class, "meat").registerSubtype(FishProduct.class, "fish")
            .registerSubtype(MilkProduct.class, "milk products").registerSubtype(CerealsGrainsProduct.class, "cereals")
            .registerSubtype(Pasta.class, "pasta").registerSubtype(MeatPartProduct.class, "meat part")
            .registerSubtype(MinceProduct.class, "mince meat").registerSubtype(ByProduct.class, "by product")
            .registerSubtype(SFinishedProduct.class, "semi finished fish").registerSubtype(Milk.class, "milk")
            .registerSubtype(VegFruitProduct.class, "vegetables").registerSubtype(SpicesProduct.class, "spices")
            .registerSubtype(SimpleProduct.class, "simple");

    public MyJsonSerialize() {

    }
    public static void createAlert(final Alert.AlertType type, final String title, final String header, final String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

    @Override
    public void serialize(String filePath, ArrayList<Dish> dishes) {
        ArrayList<DishSerialize> dishSerializes = new ArrayList<>();
        for (Dish dish : dishes){
            DishSerialize newDish = new DishSerialize(dish.getName(), new ArrayList<BaseProduct>(dish.getProductsList()));
            dishSerializes.add(newDish);
        }
        Gson gson = new Gson().newBuilder().registerTypeAdapterFactory(typeAdapterFactory).create();
        Type type = new TypeToken<ArrayList<DishSerialize>>(){}.getType();
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
            bufferedWriter.write(gson.toJson(dishSerializes, type));
        } catch (IOException e) {
            createAlert(Alert.AlertType.ERROR, "File error", "Error while JSON file serialization!", "Check file info");
        }
    }

    @Override
    public Object deserialize(String filePath) {
        Gson gson = new Gson().newBuilder().registerTypeAdapterFactory(typeAdapterFactory).create();
        Type type = new TypeToken<ArrayList<DishSerialize>>(){}.getType();
        String json = "";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            json = bufferedReader.readLine();
        } catch (IOException e) {
            createAlert(Alert.AlertType.ERROR, "File error", "Error while JSON file deserialization!", "Check file info");
        }
        ArrayList<DishSerialize> dishes = gson.fromJson(json, type);
        ArrayList<Dish> dishR = new ArrayList<>();
        for (DishSerialize newDish : dishes ){
            ObservableList<BaseProduct> tmpProductsList = FXCollections.observableArrayList();
            tmpProductsList.setAll((ArrayList<BaseProduct>)newDish.getProductsList());
            Dish dish = new Dish(newDish.getName(), tmpProductsList);
            dishR.add(dish);
        }
        return dishR;
    }
}


