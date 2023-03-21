package com.example.example;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.example.dataModels.DishDataModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button enterButton;

    @FXML
    void initialize(MouseEvent event) {

    }

    @FXML
    private void enterClickButton() {
        DishDataModel dishesData = new DishDataModel();
        dishesData.initData();
        enterButton.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("menu.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        MenuController controller = loader.getController();
        controller.setDishData(dishesData);
        stage.showAndWait();
    }

    @FXML
    void initialize() {

    }

}