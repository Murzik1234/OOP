package com.example.example.controllers;

import com.example.example.utils.Validator;
import com.example.example.products.SimpleProduct;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class SimpleController {

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
    private ComboBox<String> processBox;

    @FXML
    private TextField timeField;

    @FXML
    private TextField weighField;

    private SimpleProduct currentSimple;

    private BooleanProperty isNameFieldCorrect = new SimpleBooleanProperty(false);
    private BooleanProperty isWeighFieldCorrect = new SimpleBooleanProperty(false);
    private BooleanProperty isCaloriesFieldCorrect = new SimpleBooleanProperty(false);
    private BooleanProperty isTimeFieldCorrect = new SimpleBooleanProperty(false);
    private BooleanProperty isProcessBoxCorrect = new SimpleBooleanProperty(false);

    public void setIngredient(SimpleProduct newSimple) {
        this.currentSimple = newSimple;
        nameField.setText(currentSimple.getName());
        weighField.setText(currentSimple.getWeight() + "");
        caloriesField.setText(currentSimple.getCalories() + "");
        processBox.getSelectionModel().select(currentSimple.getProcessType());
        timeField.setText(currentSimple.getTime() + "");
    }

    public SimpleProduct getIngredient() {
        return this.currentSimple;
    }

    private boolean isFormCorrect() {
        if (isNameFieldCorrect.get() && isWeighFieldCorrect.get() &&
                isCaloriesFieldCorrect.get() && isTimeFieldCorrect.get()  && isProcessBoxCorrect.get()){
            return true;
        }
        return false;
    }

    @FXML
    private void addClickButton() {
        if (isFormCorrect()) {
            if (currentSimple != null) {
                this.currentSimple.setName(nameField.getText());
                this.currentSimple.setWeight(Integer.parseInt(weighField.getText()));
                this.currentSimple.setCalories(Integer.parseInt(caloriesField.getText()));
                this.currentSimple.setProcessType(processBox.getSelectionModel().getSelectedItem());
                this.currentSimple.setTime(Integer.parseInt(timeField.getText()));

            } else {
                this.currentSimple = new SimpleProduct(nameField.getText(), Integer.parseInt(weighField.getText()), Integer.parseInt(caloriesField.getText()), processBox.getSelectionModel().getSelectedItem(), Integer.parseInt(timeField.getText()));
            }
            Stage stage = (Stage) addButton.getScene().getWindow();
            stage.close();
        }
    }

    @FXML
    void initialize() {
        addButton.setDisable(false);
        processBox.getItems().addAll("Добавить", "Нагреть", "Жарить", "Взбивать", "Мешать", "Резать", "Чистить");
        Validator validator = new Validator();
        validator.validateName(nameField, isNameFieldCorrect);
        validator.validateInt(weighField, isWeighFieldCorrect);
        validator.validateInt(caloriesField, isCaloriesFieldCorrect);
        validator.validateInt(timeField, isTimeFieldCorrect);
        validator.validateComboBox(processBox, isProcessBoxCorrect);
    }

}


