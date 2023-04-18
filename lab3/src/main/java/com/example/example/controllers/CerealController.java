package com.example.example.controllers;

import com.example.example.utils.Validator;
import com.example.example.products.CerealsGrainsProduct;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class CerealController {

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
    private ComboBox<String> typeBox;

    @FXML
    private TextField carbField;

    @FXML
    private TextField timeField;

    @FXML
    private TextField weighField;

    private CerealsGrainsProduct currentCereal;
    private BooleanProperty isNameFieldCorrect = new SimpleBooleanProperty(false);
    private BooleanProperty isWeighFieldCorrect = new SimpleBooleanProperty(false);
    private BooleanProperty isCaloriesFieldCorrect = new SimpleBooleanProperty(false);
    private BooleanProperty isTimeFieldCorrect = new SimpleBooleanProperty(false);
    private BooleanProperty isCarbFieldCorrect = new SimpleBooleanProperty(false);
    private BooleanProperty isProcessBoxCorrect = new SimpleBooleanProperty(false);
    private BooleanProperty isTypeBoxCorrect = new SimpleBooleanProperty(false);


    public void setIngredient(CerealsGrainsProduct newCerealProduct) {
        this.currentCereal = newCerealProduct;
        nameField.setText(currentCereal.getName());
        weighField.setText(currentCereal.getWeight() + "");
        caloriesField.setText(currentCereal.getCalories() + "");
        processBox.getSelectionModel().select(currentCereal.getProcessType());
        timeField.setText(currentCereal.getTime() + "");
        carbField.setText(currentCereal.getCarb() + "");
        typeBox.getSelectionModel().select(currentCereal.getProductType());
    }

    public CerealsGrainsProduct getIngredient() {
        return this.currentCereal;
    }

    private boolean isFormCorrect() {
        if (isNameFieldCorrect.get() && isWeighFieldCorrect.get() &&
                isCaloriesFieldCorrect.get() && isTimeFieldCorrect.get()  && isProcessBoxCorrect.get() && isCarbFieldCorrect.get() && isTypeBoxCorrect.get() ){
            return true;
        }
        return false;
    }

    @FXML
    private void addClickButton() {
        if (isFormCorrect()) {
            if (currentCereal != null) {
                this.currentCereal.setName(nameField.getText());
                this.currentCereal.setWeight(Integer.parseInt(weighField.getText()));
                this.currentCereal.setCalories(Integer.parseInt(caloriesField.getText()));
                this.currentCereal.setProcessType(processBox.getSelectionModel().getSelectedItem());
                this.currentCereal.setTime(Integer.parseInt(timeField.getText()));
                this.currentCereal.setCarb(Integer.parseInt(carbField.getText()));
                this.currentCereal.setProductType(typeBox.getSelectionModel().getSelectedItem());
            } else {
                this.currentCereal = new CerealsGrainsProduct(nameField.getText(), Integer.parseInt(weighField.getText()), Integer.parseInt(caloriesField.getText()), processBox.getSelectionModel().getSelectedItem(), Integer.parseInt(timeField.getText()), Integer.parseInt(carbField.getText()), typeBox.getSelectionModel().getSelectedItem());
            }
            Stage stage = (Stage) addButton.getScene().getWindow();
            stage.close();
        }
    }

    @FXML
    void initialize() {
        processBox.getItems().addAll("Варить", "Жарить", "Запекать", "Мешать");
        typeBox.getItems().addAll("Рис", "Гречка", "Булгур", "Кускус", "Палента");
        Validator validator = new Validator();
        validator.validateName(nameField, isNameFieldCorrect);
        validator.validateInt(weighField, isWeighFieldCorrect);
        validator.validateInt(caloriesField, isCaloriesFieldCorrect);
        validator.validateInt(timeField, isTimeFieldCorrect);
        validator.validateComboBox(processBox, isProcessBoxCorrect);
        validator.validateComboBox(typeBox, isTypeBoxCorrect);
        validator.validateInt(carbField, isCarbFieldCorrect);


    }

}


