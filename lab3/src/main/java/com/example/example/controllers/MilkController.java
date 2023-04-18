package com.example.example.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.example.utils.Validator;
import com.example.example.products.Milk;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MilkController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addButton;

    @FXML
    private TextField calciumField;

    @FXML
    private TextField caloriesField;

    @FXML
    private TextField fatField;

    @FXML
    private TextField nameField;

    @FXML
    private ComboBox<String> pastBox;

    @FXML
    private ComboBox<String> processBox;
    @FXML
    private TextField timeField;

    @FXML
    private TextField weighField;

    private Milk currentMilk;
    private BooleanProperty isNameFieldCorrect = new SimpleBooleanProperty(false);
    private BooleanProperty isWeighFieldCorrect = new SimpleBooleanProperty(false);
    private BooleanProperty isCaloriesFieldCorrect = new SimpleBooleanProperty(false);
    private BooleanProperty isTimeFieldCorrect = new SimpleBooleanProperty(false);
    private BooleanProperty isCalciumFieldCorrect = new SimpleBooleanProperty(false);
    private BooleanProperty isProcessBoxCorrect = new SimpleBooleanProperty(false);
    private BooleanProperty isPastBoxCorrect = new SimpleBooleanProperty(false);
    private BooleanProperty isFatFieldCorrect = new SimpleBooleanProperty(false);

    public void setIngredient(Milk newMilk) {
        this.currentMilk = newMilk;
        nameField.setText(currentMilk.getName());
        weighField.setText(currentMilk.getWeight() + "");
        caloriesField.setText(currentMilk.getCalories() + "");
        processBox.getSelectionModel().select(currentMilk.getProcessType());
        timeField.setText(currentMilk.getTime() + "");
        calciumField.setText(currentMilk.getCalcium() + "");
        fatField.setText(currentMilk.getFatContent() + "");
        pastBox.getSelectionModel().select(currentMilk.getPasteurization());
    }

    public Milk getIngredient() {
        return this.currentMilk;
    }

    private boolean isFormCorrect() {
        if (isNameFieldCorrect.get() && isWeighFieldCorrect.get() &&
                isCaloriesFieldCorrect.get() && isTimeFieldCorrect.get()  && isProcessBoxCorrect.get() && isCalciumFieldCorrect.get() && isFatFieldCorrect.get() && isPastBoxCorrect.get()){
            return true;
        }
        return false;
    }

    @FXML
    private void addClickButton() {
        if (isFormCorrect()) {
            if (currentMilk != null) {
                this.currentMilk.setName(nameField.getText());
                this.currentMilk.setWeight(Integer.parseInt(weighField.getText()));
                this.currentMilk.setCalories(Integer.parseInt(caloriesField.getText()));
                this.currentMilk.setProcessType(processBox.getSelectionModel().getSelectedItem());
                this.currentMilk.setTime(Integer.parseInt(timeField.getText()));
                this.currentMilk.setCalcium(Integer.parseInt(calciumField.getText()));
                this.currentMilk.setFatContent(Integer.parseInt(fatField.getText()));
                this.currentMilk.setPasteurization(pastBox.getSelectionModel().getSelectedItem());
            } else {
                this.currentMilk = new Milk(nameField.getText(), Integer.parseInt(weighField.getText()), Integer.parseInt(caloriesField.getText()), processBox.getSelectionModel().getSelectedItem(), Integer.parseInt(timeField.getText()), Integer.parseInt(calciumField.getText()), Integer.parseInt(fatField.getText()), pastBox.getSelectionModel().getSelectedItem());
            }
            Stage stage = (Stage) addButton.getScene().getWindow();
            stage.close();
        }
    }

    @FXML
    void initialize() {
        addButton.setDisable(false);
        processBox.getItems().addAll("Нагреть", "Взбивать", "Мешать", "Вскипятить");
        pastBox.getItems().addAll("Пастеризация", "Стерилизация", "Ультрапастеризация");
        Validator validator = new Validator();
        validator.validateName(nameField, isNameFieldCorrect);
        validator.validateInt(weighField, isWeighFieldCorrect);
        validator.validateInt(caloriesField, isCaloriesFieldCorrect);
        validator.validateInt(timeField, isTimeFieldCorrect);
        validator.validateComboBox(processBox, isProcessBoxCorrect);
        validator.validateComboBox(pastBox, isPastBoxCorrect);
        validator.validateInt(calciumField, isCalciumFieldCorrect);
        validator.validateInt(fatField, isFatFieldCorrect);
    }

}


