package com.example.example.controllers;

import com.example.example.utils.Validator;
import com.example.example.products.MeatProduct;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MeatController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addButton;

    @FXML
    private TextField caloriesField;

    @FXML
    private ComboBox<String> processBox;

    @FXML
    private TextField nameField;

    @FXML
    private TextField proteinField;

    @FXML
    private ComboBox<String> typeBox;

    @FXML
    private TextField timeField;

    @FXML
    private TextField weighField;


    private MeatProduct currentMeat;
    private BooleanProperty isNameFieldCorrect = new SimpleBooleanProperty(false);
    private BooleanProperty isWeighFieldCorrect = new SimpleBooleanProperty(false);
    private BooleanProperty isCaloriesFieldCorrect = new SimpleBooleanProperty(false);
    private BooleanProperty isTimeFieldCorrect = new SimpleBooleanProperty(false);
    private BooleanProperty isProteinFieldCorrect = new SimpleBooleanProperty(false);
    private BooleanProperty isProcessBoxCorrect = new SimpleBooleanProperty(false);
    private BooleanProperty isTypeBoxCorrect = new SimpleBooleanProperty(false);

    public MeatProduct getIngredient() {
        return this.currentMeat;
    }

    public void setIngredient(MeatProduct newMeat) {
        this.currentMeat = newMeat;
        nameField.setText(currentMeat.getName());
        weighField.setText(currentMeat.getWeight() + "");
        caloriesField.setText(currentMeat.getCalories() + "");
        processBox.getSelectionModel().select(currentMeat.getProcessType());
        timeField.setText(currentMeat.getTime() + "");
        proteinField.setText(currentMeat.getProtein() + "");
        typeBox.getSelectionModel().select(currentMeat.getMeatType());
    }

    private boolean isFormCorrect() {
        if (isNameFieldCorrect.get() && isWeighFieldCorrect.get() &&
                isCaloriesFieldCorrect.get() && isTimeFieldCorrect.get() && isProteinFieldCorrect.get() && isProcessBoxCorrect.get() && isTypeBoxCorrect.get()){
            return true;
        }
        return false;
    }


    @FXML
    private void addClickButton() {
        if (isFormCorrect()) {
            if (currentMeat != null) {
                this.currentMeat.setName(nameField.getText());
                this.currentMeat.setWeight(Integer.parseInt(weighField.getText()));
                this.currentMeat.setCalories(Integer.parseInt(caloriesField.getText()));
                this.currentMeat.setProcessType(processBox.getSelectionModel().getSelectedItem());
                this.currentMeat.setTime(Integer.parseInt(timeField.getText()));
                this.currentMeat.setProtein(Integer.parseInt(proteinField.getText()));
                this.currentMeat.setMeatType(typeBox.getSelectionModel().getSelectedItem());
            } else {
                this.currentMeat = new MeatProduct(nameField.getText(), Integer.parseInt(weighField.getText()), Integer.parseInt(caloriesField.getText()), processBox.getSelectionModel().getSelectedItem(), Integer.parseInt(timeField.getText()), Integer.parseInt(proteinField.getText()), typeBox.getSelectionModel().getSelectedItem());
            }
            Stage stage = (Stage) addButton.getScene().getWindow();
            stage.close();
        }
    }

    @FXML
    void initialize() {
        processBox.getItems().addAll("Варить", "Жарить", "Запекать", "Измельчить", "Мешать", "Резать", "Чистить");
        typeBox.getItems().addAll("Курица", "Свинина", "Говядина", "Баранина", "Крольчатина", "Утка");
        Validator validator = new Validator();
        validator.validateName(nameField, isNameFieldCorrect);
        validator.validateInt(weighField, isWeighFieldCorrect);
        validator.validateInt(caloriesField, isCaloriesFieldCorrect);
        validator.validateInt(timeField, isTimeFieldCorrect);
        validator.validateComboBox(processBox, isProcessBoxCorrect);
        validator.validateInt(proteinField, isProteinFieldCorrect);
        validator.validateComboBox(typeBox, isTypeBoxCorrect);
    }

}


