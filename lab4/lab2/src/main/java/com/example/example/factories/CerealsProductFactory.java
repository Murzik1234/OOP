package com.example.example.factories;

import com.example.example.controllers.CerealController;
import com.example.example.products.BaseProduct;
import com.example.example.products.CerealsGrainsProduct;
import com.example.example.utils.ProductInterface;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CerealsProductFactory implements ProductInterface {
    @Override
    public BaseProduct add() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("cerealsAdd.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        CerealController controller = loader.getController();

       ////
        //stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
        // @Override
        // public void handle(WindowEvent windowEvent) {
        //     menuTable.refresh();
        //  }
        //});
        stage.showAndWait();
        return controller.getIngredient();
    }

    @Override
    public  void change(BaseProduct baseProduct) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("cerealsAdd.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        CerealController controller = loader.getController();
        controller.setIngredient((CerealsGrainsProduct) baseProduct);
        stage.showAndWait();

    }
}
