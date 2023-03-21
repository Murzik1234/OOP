package com.example.example.controllers;

import com.example.example.utils.Validator;
import com.example.example.products.MinceProduct;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MinceController {

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

    @FXML
    private TextField meatPercentField;

    private MinceProduct currentMince;

    private BooleanProperty isNameFieldCorrect = new SimpleBooleanProperty(false);
    private BooleanProperty isWeighFieldCorrect = new SimpleBooleanProperty(false);
    private BooleanProperty isCaloriesFieldCorrect = new SimpleBooleanProperty(false);
    private BooleanProperty isTimeFieldCorrect = new SimpleBooleanProperty(false);
    private BooleanProperty isProteinFieldCorrect = new SimpleBooleanProperty(false);
    private BooleanProperty isProcessBoxCorrect = new SimpleBooleanProperty(false);
    private BooleanProperty isTypeBoxCorrect = new SimpleBooleanProperty(false);
    private BooleanProperty isMeatPercentFieldCorrect = new SimpleBooleanProperty(false);

    public void setIngredient(MinceProduct newMince) {
        this.currentMince = newMince;
        nameField.setText(currentMince.getName());
        weighField.setText(currentMince.getWeight() + "");
        caloriesField.setText(currentMince.getCalories() + "");
        processBox.getSelectionModel().select(currentMince.getProcessType());
        timeField.setText(currentMince.getTime() + "");
        proteinField.setText(currentMince.getProtein() + "");
        typeBox.getSelectionModel().select(currentMince.getMeatType());
        meatPercentField.setText(currentMince.getMeatPercent() + "");
    }

    public MinceProduct getIngredient() {
        return this.currentMince;
    }

    private boolean isFormCorrect() {
        if (isNameFieldCorrect.get() && isWeighFieldCorrect.get() &&
                isCaloriesFieldCorrect.get() && isTimeFieldCorrect.get() && isProteinFieldCorrect.get() && isProcessBoxCorrect.get() && isTypeBoxCorrect.get() && isMeatPercentFieldCorrect.get()){
            return true;
        }
        return false;
    }

    @FXML
    private void addClickButton() {
        if (isFormCorrect()) {
            if (currentMince != null) {
                this.currentMince.setName(nameField.getText());
                this.currentMince.setWeight(Integer.parseInt(weighField.getText()));
                this.currentMince.setCalories(Integer.parseInt(caloriesField.getText()));
                this.currentMince.setProcessType(processBox.getSelectionModel().getSelectedItem());
                this.currentMince.setTime(Integer.parseInt(timeField.getText()));
                this.currentMince.setProtein(Integer.parseInt(proteinField.getText()));
                this.currentMince.setMeatType(typeBox.getSelectionModel().getSelectedItem());
                this.currentMince.setMeatPercent(Integer.parseInt(meatPercentField.getText()));
            } else {
                this.currentMince = new MinceProduct(nameField.getText(), Integer.parseInt(weighField.getText()), Integer.parseInt(caloriesField.getText()), processBox.getSelectionModel().getSelectedItem(), Integer.parseInt(timeField.getText()), Integer.parseInt(proteinField.getText()), typeBox.getSelectionModel().getSelectedItem(), Integer.parseInt(meatPercentField.getText()));
            }
            Stage stage = (Stage) addButton.getScene().getWindow();
            stage.close();
        }
    }

    @FXML
    void initialize() {
        processBox.getItems().addAll("Жарить", "Запекать", "Перемешать");
        typeBox.getItems().addAll("Курица", "Свинина", "Говядина", "Баранина", "Крольчатина", "Утка");
        Validator validator = new Validator();
        validator.validateName(nameField, isNameFieldCorrect);
        validator.validateInt(weighField, isWeighFieldCorrect);
        validator.validateInt(caloriesField, isCaloriesFieldCorrect);
        validator.validateInt(timeField, isTimeFieldCorrect);
        validator.validateInt(proteinField, isProteinFieldCorrect);
        validator.validateComboBox(processBox, isProcessBoxCorrect);
        validator.validateComboBox(typeBox, isTypeBoxCorrect);
        validator.validateInt(meatPercentField, isMeatPercentFieldCorrect);
    }

}


