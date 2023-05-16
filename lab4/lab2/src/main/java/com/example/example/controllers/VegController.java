package com.example.example.controllers;

import com.example.example.utils.Validator;
import com.example.example.products.VegFruitProduct;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class VegController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addButton;

    @FXML
    private TextField caloriesField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField timeField;

    @FXML
    private TextField weighField;
    @FXML
    private TextField fiberField;
    @FXML
    private ComboBox<String> processBox;

    private VegFruitProduct currentVeg;

    private BooleanProperty isNameFieldCorrect = new SimpleBooleanProperty(false);
    private BooleanProperty isWeighFieldCorrect = new SimpleBooleanProperty(false);
    private BooleanProperty isCaloriesFieldCorrect = new SimpleBooleanProperty(false);
    private BooleanProperty isTimeFieldCorrect = new SimpleBooleanProperty(false);
    private BooleanProperty isFiberFieldCorrect = new SimpleBooleanProperty(false);
    private BooleanProperty isProcessBoxCorrect = new SimpleBooleanProperty(false);

    public void setIngredient(VegFruitProduct newVeg) {
        this.currentVeg = newVeg;
        nameField.setText(currentVeg.getName());
        weighField.setText(currentVeg.getWeight() + "");
        caloriesField.setText(currentVeg.getCalories() + "");
        processBox.getSelectionModel().select(currentVeg.getProcessType());
        timeField.setText(currentVeg.getTime() + "");
        fiberField.setText(currentVeg.getFiber() + "");

    }

    public VegFruitProduct getIngredient() {
        return this.currentVeg;
    }

    private boolean isFormCorrect() {
        if (isNameFieldCorrect.get() && isWeighFieldCorrect.get() &&
                isCaloriesFieldCorrect.get() && isTimeFieldCorrect.get()  && isProcessBoxCorrect.get() && isFiberFieldCorrect.get()){
            return true;
        }
        return false;
    }

    @FXML
    private void addClickButton() {
        if (isFormCorrect()) {
            if (currentVeg != null) {
                this.currentVeg.setName(nameField.getText());
                this.currentVeg.setWeight(Integer.parseInt(weighField.getText()));
                this.currentVeg.setCalories(Integer.parseInt(caloriesField.getText()));
                this.currentVeg.setProcessType(processBox.getSelectionModel().getSelectedItem());
                this.currentVeg.setTime(Integer.parseInt(timeField.getText()));
                this.currentVeg.setFiber(Integer.parseInt(fiberField.getText()));
            } else {
                this.currentVeg = new VegFruitProduct(nameField.getText(), Integer.parseInt(weighField.getText()), Integer.parseInt(caloriesField.getText()), processBox.getSelectionModel().getSelectedItem(), Integer.parseInt(timeField.getText()), Integer.parseInt(fiberField.getText()));
            }
            Stage stage = (Stage) addButton.getScene().getWindow();
            stage.close();
        }
    }

    @FXML
    void initialize() {
        addButton.setDisable(false);
        processBox.getItems().addAll("Варить", "Жарить", "Запекать", "Измельчить", "Мешать", "Резать", "Чистить");
        Validator validator = new Validator();
        validator.validateName(nameField, isNameFieldCorrect);
        validator.validateInt(weighField, isWeighFieldCorrect);
        validator.validateInt(caloriesField, isCaloriesFieldCorrect);
        validator.validateInt(timeField, isTimeFieldCorrect);
        validator.validateComboBox(processBox, isProcessBoxCorrect);
        validator.validateInt(fiberField, isFiberFieldCorrect);
    }

}


