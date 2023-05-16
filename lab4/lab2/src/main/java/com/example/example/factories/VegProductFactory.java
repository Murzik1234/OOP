package com.example.example.factories;

import com.example.example.controllers.VegController;
import com.example.example.products.BaseProduct;
import com.example.example.products.VegFruitProduct;
import com.example.example.utils.ProductInterface;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class VegProductFactory implements ProductInterface {
    @Override
    public BaseProduct add() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("vegAdd.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        VegController controller = loader.getController();
        stage.showAndWait();
        return controller.getIngredient();
    }

    @Override
    public  void change(BaseProduct baseProduct) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("vegAdd.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        VegController controller = loader.getController();
        controller.setIngredient((VegFruitProduct) baseProduct);
        stage.showAndWait();

    }
}
