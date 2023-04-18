package com.example.example.controllers;

import com.example.example.utils.Validator;
import com.example.example.products.SpicesProduct;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class SpicesController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addButton;

    @FXML
    private TextField caloriesField;
    @FXML
    private TextField countryField;

    @FXML
    private TextField nameField;

    @FXML
    private ComboBox<String> processBox;

    @FXML
    private ComboBox<String> sharpBox;

    @FXML
    private TextField timeField;

    @FXML
    private TextField weighField;

    private SpicesProduct currentSpice;

    private BooleanProperty isNameFieldCorrect = new SimpleBooleanProperty(false);
    private BooleanProperty isWeighFieldCorrect = new SimpleBooleanProperty(false);
    private BooleanProperty isCaloriesFieldCorrect = new SimpleBooleanProperty(false);
    private BooleanProperty isTimeFieldCorrect = new SimpleBooleanProperty(false);
    private BooleanProperty isCountryFieldCorrect = new SimpleBooleanProperty(false);
    private BooleanProperty isProcessBoxCorrect = new SimpleBooleanProperty(false);
    private BooleanProperty isSharpBoxCorrect = new SimpleBooleanProperty(false);

    public void setIngredient(SpicesProduct newSpice) {
        this.currentSpice = newSpice;
        nameField.setText(currentSpice.getName());
        weighField.setText(currentSpice.getWeight() + "");
        caloriesField.setText(currentSpice.getCalories() + "");
        processBox.getSelectionModel().select(currentSpice.getProcessType());
        timeField.setText(currentSpice.getTime() + "");
        sharpBox.getSelectionModel().select(currentSpice.getSharpness());
        countryField.setText(currentSpice.getCountry());

    }

    public SpicesProduct getIngredient() {
        return this.currentSpice;
    }
    private boolean isFormCorrect() {
        if (isNameFieldCorrect.get() && isWeighFieldCorrect.get() &&
                isCaloriesFieldCorrect.get() && isTimeFieldCorrect.get()  && isProcessBoxCorrect.get() && isCountryFieldCorrect.get() && isSharpBoxCorrect.get()){
            return true;
        }
        return false;
    }

    @FXML
    private void addClickButton() {
        if (isFormCorrect()) {
            if (currentSpice != null) {
                this.currentSpice.setName(nameField.getText());
                this.currentSpice.setWeight(Integer.parseInt(weighField.getText()));
                this.currentSpice.setCalories(Integer.parseInt(caloriesField.getText()));
                this.currentSpice.setProcessType(processBox.getSelectionModel().getSelectedItem());
                this.currentSpice.setTime(Integer.parseInt(timeField.getText()));
                this.currentSpice.setSharpness(sharpBox.getSelectionModel().getSelectedItem());
                this.currentSpice.setCountry(countryField.getText());
            } else {
                this.currentSpice = new SpicesProduct(nameField.getText(), Integer.parseInt(weighField.getText()), Integer.parseInt(caloriesField.getText()), processBox.getSelectionModel().getSelectedItem(), Integer.parseInt(timeField.getText()), sharpBox.getSelectionModel().getSelectedItem(), countryField.getText());
            }
            Stage stage = (Stage) addButton.getScene().getWindow();
            stage.close();
        }
    }

    @FXML
    void initialize() {
        processBox.getItems().addAll("Добавить", "Перемешать", "Чистить");
        sharpBox.getItems().addAll("Неострая", "Острая", "Очень острая");
        Validator validator = new Validator();
        validator.validateName(nameField, isNameFieldCorrect);
        validator.validateInt(weighField, isWeighFieldCorrect);
        validator.validateInt(caloriesField, isCaloriesFieldCorrect);
        validator.validateInt(timeField, isTimeFieldCorrect);
        validator.validateComboBox(processBox, isProcessBoxCorrect);
        validator.validateName(countryField, isCountryFieldCorrect);
        validator.validateComboBox(sharpBox, isSharpBoxCorrect);

    }

}


