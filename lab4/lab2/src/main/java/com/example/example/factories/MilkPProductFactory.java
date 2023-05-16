package com.example.example.factories;

import com.example.example.controllers.MilkProductController;
import com.example.example.products.BaseProduct;
import com.example.example.products.MilkProduct;
import com.example.example.utils.ProductInterface;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MilkPProductFactory implements ProductInterface {
    @Override
    public BaseProduct add() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("milkProductAdd.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        MilkProductController controller = loader.getController();
        stage.showAndWait();
        return controller.getIngredient();
    }

    @Override
    public  void change(BaseProduct baseProduct) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("milkProductAdd.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        MilkProductController controller = loader.getController();
        controller.setIngredient((MilkProduct) baseProduct);
        stage.showAndWait();
    }
}
