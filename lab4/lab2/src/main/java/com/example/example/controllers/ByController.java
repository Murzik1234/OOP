package com.example.example.controllers;

import com.example.example.utils.Validator;
import com.example.example.products.ByProduct;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ByController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addButton;
    @FXML
    private ComboBox<String> categoryBox;
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


    private ByProduct currentBy;
    private BooleanProperty isNameFieldCorrect = new SimpleBooleanProperty(false);
    private BooleanProperty isWeighFieldCorrect = new SimpleBooleanProperty(false);
    private BooleanProperty isCaloriesFieldCorrect = new SimpleBooleanProperty(false);
    private BooleanProperty isTimeFieldCorrect = new SimpleBooleanProperty(false);
    private BooleanProperty isTypeBoxCorrect = new SimpleBooleanProperty(false);
    private BooleanProperty isProcessBoxCorrect = new SimpleBooleanProperty(false);
    private BooleanProperty isProteinFieldCorrect = new SimpleBooleanProperty(false);
    private BooleanProperty isCategoryBoxCorrect = new SimpleBooleanProperty(false);


    public void setIngredient(ByProduct newByProduct) {
        this.currentBy = newByProduct;
        nameField.setText(currentBy.getName());
        weighField.setText(currentBy.getWeight() + "");
        caloriesField.setText(currentBy.getCalories() + "");
        processBox.getSelectionModel().select(currentBy.getProcessType());
        proteinField.setText(currentBy.getProtein() + "");
        timeField.setText(currentBy.getTime() + "");
        typeBox.getSelectionModel().select(currentBy.getMeatType());
        categoryBox.getSelectionModel().select(currentBy.getCategory());
    }

    public ByProduct getIngredient() {
        return this.currentBy;
    }

    private boolean isFormCorrect() {
        if (isNameFieldCorrect.get() && isWeighFieldCorrect.get() &&
                isCaloriesFieldCorrect.get() && isTimeFieldCorrect.get() && isProteinFieldCorrect.get() && isProcessBoxCorrect.get() && isTypeBoxCorrect.get() && isCategoryBoxCorrect.get()){
            return true;
        }
        return false;
    }

    @FXML
    private void addClickButton() {
        if(isFormCorrect()) {
            if (currentBy != null) {
                this.currentBy.setName(nameField.getText());
                this.currentBy.setWeight(Integer.parseInt(weighField.getText()));
                this.currentBy.setCalories(Integer.parseInt(caloriesField.getText()));
                this.currentBy.setProcessType(processBox.getSelectionModel().getSelectedItem());
                this.currentBy.setTime(Integer.parseInt(timeField.getText()));
                this.currentBy.setProtein(Integer.parseInt(proteinField.getText()));
                this.currentBy.setMeatType(typeBox.getSelectionModel().getSelectedItem());
                this.currentBy.setCategory(categoryBox.getSelectionModel().getSelectedItem());
            } else {
                this.currentBy = new ByProduct(nameField.getText(), Integer.parseInt(weighField.getText()), Integer.parseInt(caloriesField.getText()), processBox.getSelectionModel().getSelectedItem(), Integer.parseInt(timeField.getText()), Integer.parseInt(proteinField.getText()), typeBox.getSelectionModel().getSelectedItem(), categoryBox.getSelectionModel().getSelectedItem());
            }
            Stage stage = (Stage) addButton.getScene().getWindow();
            stage.close();
        }
    }

    @FXML
    void initialize() {
        processBox.getItems().addAll("Варить", "Жарить", "Запекать", "Измельчить", "Мешать", "Резать", "Чистить");
        typeBox.getItems().addAll("Курица", "Свинина", "Говядина", "Баранина", "Крольчатина", "Утка");
        categoryBox.getItems().addAll("Первая категория", "Вторая категория", "Третья категория");
        Validator validator = new Validator();
        validator.validateName(nameField, isNameFieldCorrect);
        validator.validateInt(weighField, isWeighFieldCorrect);
        validator.validateInt(caloriesField, isCaloriesFieldCorrect);
        validator.validateInt(timeField, isTimeFieldCorrect);
        validator.validateInt(proteinField, isProteinFieldCorrect);
        validator.validateComboBox(processBox, isProcessBoxCorrect);
        validator.validateComboBox(typeBox, isTypeBoxCorrect);
        validator.validateComboBox(categoryBox, isCategoryBoxCorrect);

    }

}


