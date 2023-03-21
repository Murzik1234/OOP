package com.example.example.controllers;

import com.example.example.utils.Validator;
import com.example.example.products.FishProduct;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class FishController {

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
    private TextField omegaField;

    @FXML
    private ComboBox<String> areaBox;

    @FXML
    private TextField timeField;

    @FXML
    private TextField weighField;

    private FishProduct currentFish;
    private BooleanProperty isNameFieldCorrect = new SimpleBooleanProperty(false);
    private BooleanProperty isWeighFieldCorrect = new SimpleBooleanProperty(false);
    private BooleanProperty isCaloriesFieldCorrect = new SimpleBooleanProperty(false);
    private BooleanProperty isTimeFieldCorrect = new SimpleBooleanProperty(false);
    private BooleanProperty isOmegaFieldCorrect = new SimpleBooleanProperty(false);
    private BooleanProperty isProcessBoxCorrect = new SimpleBooleanProperty(false);
    private BooleanProperty isAreaBoxCorrect = new SimpleBooleanProperty(false);

    public void setIngredient(FishProduct newFish) {
        this.currentFish = newFish;
        nameField.setText(currentFish.getName());
        weighField.setText(currentFish.getWeight() + "");
        caloriesField.setText(currentFish.getCalories() + "");
        processBox.getSelectionModel().select(currentFish.getProcessType());
        timeField.setText(currentFish.getTime() + "");
        omegaField.setText(currentFish.getOmega3() + "");
        areaBox.getSelectionModel().select(currentFish.getFishArea());
    }

    public FishProduct getIngredient() {
        return this.currentFish;
    }


    private boolean isFormCorrect() {
        if (isNameFieldCorrect.get() && isWeighFieldCorrect.get() &&
                isCaloriesFieldCorrect.get() && isTimeFieldCorrect.get()  && isProcessBoxCorrect.get() && isOmegaFieldCorrect.get() && isAreaBoxCorrect.get()){
            return true;
        }
        return false;
    }

    @FXML
    private void addClickButton() {
        if(isFormCorrect()) {
            if (currentFish != null) {
                this.currentFish.setName(nameField.getText());
                this.currentFish.setWeight(Integer.parseInt(weighField.getText()));
                this.currentFish.setCalories(Integer.parseInt(caloriesField.getText()));
                this.currentFish.setProcessType(processBox.getSelectionModel().getSelectedItem());
                this.currentFish.setTime(Integer.parseInt(timeField.getText()));
                this.currentFish.setOmega3(Integer.parseInt(omegaField.getText()));
                this.currentFish.setFishArea(areaBox.getSelectionModel().getSelectedItem());
            } else {
                this.currentFish = new FishProduct(nameField.getText(), Integer.parseInt(weighField.getText()), Integer.parseInt(caloriesField.getText()), processBox.getSelectionModel().getSelectedItem(), Integer.parseInt(timeField.getText()), Integer.parseInt(omegaField.getText()), areaBox.getSelectionModel().getSelectedItem());
            }
            Stage stage = (Stage) addButton.getScene().getWindow();
            stage.close();
        }
    }

    @FXML
    void initialize() {
        processBox.getItems().addAll("Варить", "Жарить", "Запекать", "Измельчить", "Мешать", "Резать", "Чистить");
        areaBox.getItems().addAll("Река", "Озеро", "Море", "Океан");
        Validator validator = new Validator();
        validator.validateName(nameField, isNameFieldCorrect);
        validator.validateInt(weighField, isWeighFieldCorrect);
        validator.validateInt(caloriesField, isCaloriesFieldCorrect);
        validator.validateInt(timeField, isTimeFieldCorrect);
        validator.validateComboBox(processBox, isProcessBoxCorrect);
        validator.validateComboBox(areaBox, isAreaBoxCorrect);
        validator.validateInt(omegaField, isOmegaFieldCorrect);
    }

}


