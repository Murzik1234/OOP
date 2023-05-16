package com.example.example.controllers;

import com.example.example.utils.Validator;
import com.example.example.products.MeatPartProduct;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MeatPartController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addButton;

    @FXML
    private ComboBox<String> bodyBox;
    @FXML
    private ComboBox<String> processBox;
    @FXML
    private ComboBox<String> typeBox;

    @FXML
    private TextField caloriesField;



    @FXML
    private TextField nameField;

    @FXML
    private TextField proteinField;


    @FXML
    private TextField timeField;

    @FXML
    private TextField weighField;


    private MeatPartProduct currentPart;

    private BooleanProperty isNameFieldCorrect = new SimpleBooleanProperty(false);
    private BooleanProperty isWeighFieldCorrect = new SimpleBooleanProperty(false);
    private BooleanProperty isCaloriesFieldCorrect = new SimpleBooleanProperty(false);
    private BooleanProperty isTimeFieldCorrect = new SimpleBooleanProperty(false);
    private BooleanProperty isProteinFieldCorrect = new SimpleBooleanProperty(false);
    private BooleanProperty isProcessBoxCorrect = new SimpleBooleanProperty(false);
    private BooleanProperty isTypeBoxCorrect = new SimpleBooleanProperty(false);
    private BooleanProperty isBodyBoxCorrect = new SimpleBooleanProperty(false);

    public void setIngredient(MeatPartProduct newPart) {
        this.currentPart = newPart;
        nameField.setText(currentPart.getName());
        weighField.setText(currentPart.getWeight() + "");
        caloriesField.setText(currentPart.getCalories() + "");
        proteinField.setText(currentPart.getProtein() + "");
        processBox.getSelectionModel().select(currentPart.getProcessType());
        timeField.setText(currentPart.getTime() + "");
        typeBox.getSelectionModel().select(currentPart.getMeatType());
        bodyBox.getSelectionModel().select(currentPart.getBodyPart());
    }

    public MeatPartProduct getIngredient() {
        return this.currentPart;
    }

    private boolean isFormCorrect() {
        if (isNameFieldCorrect.get() && isWeighFieldCorrect.get() &&
                isCaloriesFieldCorrect.get() && isTimeFieldCorrect.get() && isProteinFieldCorrect.get() && isProcessBoxCorrect.get() && isTypeBoxCorrect.get() && isBodyBoxCorrect.get()){
            return true;
        }
        return false;
    }

    @FXML
    private void addClickButton() {
        if (isFormCorrect()) {
            if (currentPart != null) {
                this.currentPart.setName(nameField.getText());
                this.currentPart.setWeight(Integer.parseInt(weighField.getText()));
                this.currentPart.setCalories(Integer.parseInt(caloriesField.getText()));
                this.currentPart.setProcessType(processBox.getSelectionModel().getSelectedItem());
                this.currentPart.setTime(Integer.parseInt(timeField.getText()));
                this.currentPart.setProtein(Integer.parseInt(proteinField.getText()));
                this.currentPart.setMeatType(typeBox.getSelectionModel().getSelectedItem());
                this.currentPart.setBodyPart(bodyBox.getSelectionModel().getSelectedItem());
            } else {
                this.currentPart = new MeatPartProduct(nameField.getText(), Integer.parseInt(weighField.getText()), Integer.parseInt(caloriesField.getText()), processBox.getSelectionModel().getSelectedItem(), Integer.parseInt(timeField.getText()), Integer.parseInt(proteinField.getText()), typeBox.getSelectionModel().getSelectedItem(), bodyBox.getSelectionModel().getSelectedItem());
            }
            Stage stage = (Stage) addButton.getScene().getWindow();
            stage.close();
        }
    }

    @FXML
    void initialize() {
        processBox.getItems().addAll("Варить", "Жарить", "Запекать", "Измельчить", "Мешать", "Резать", "Чистить");
        typeBox.getItems().addAll("Курица", "Свинина", "Говядина", "Баранина", "Крольчатина", "Утка");
        bodyBox.getItems().addAll("Грудка", "Голень", "Спинка", "Вырезка", "Стейк", "Медальон");
        Validator validator = new Validator();
        validator.validateName(nameField, isNameFieldCorrect);
        validator.validateInt(weighField, isWeighFieldCorrect);
        validator.validateInt(caloriesField, isCaloriesFieldCorrect);
        validator.validateInt(timeField, isTimeFieldCorrect);
        validator.validateInt(proteinField, isProteinFieldCorrect);
        validator.validateComboBox(processBox, isProcessBoxCorrect);
        validator.validateComboBox(typeBox, isTypeBoxCorrect);
        validator.validateComboBox(bodyBox, isBodyBoxCorrect);
    }

}


