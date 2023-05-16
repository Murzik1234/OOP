package com.example.example.factories;

import com.example.example.controllers.SpicesController;
import com.example.example.products.BaseProduct;
import com.example.example.products.SpicesProduct;
import com.example.example.utils.ProductInterface;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SpicesFactory implements ProductInterface {
    @Override
    public BaseProduct add() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("spicesAdd.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        SpicesController controller = loader.getController();
        stage.showAndWait();
        return controller.getIngredient();
    }

    @Override
    public  void change(BaseProduct baseProduct) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("spicesAdd.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        SpicesController controller = loader.getController();
        controller.setIngredient((SpicesProduct) baseProduct);
        stage.showAndWait();
    }
}
