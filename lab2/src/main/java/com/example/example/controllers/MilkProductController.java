package com.example.example.controllers;

import com.example.example.utils.Validator;
import com.example.example.products.MilkProduct;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MilkProductController {

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
    private ComboBox<String> processBox;

    @FXML
    private TextField timeField;

    @FXML
    private TextField weighField;

    private MilkProduct currentMilkProduct;

    private BooleanProperty isNameFieldCorrect = new SimpleBooleanProperty(false);
    private BooleanProperty isWeighFieldCorrect = new SimpleBooleanProperty(false);
    private BooleanProperty isCaloriesFieldCorrect = new SimpleBooleanProperty(false);
    private BooleanProperty isTimeFieldCorrect = new SimpleBooleanProperty(false);
    private BooleanProperty isCalciumFieldCorrect = new SimpleBooleanProperty(false);
    private BooleanProperty isProcessBoxCorrect = new SimpleBooleanProperty(false);
    private BooleanProperty isFatFieldCorrect = new SimpleBooleanProperty(false);

    public MilkProduct getIngredient() {
        return this.currentMilkProduct;
    }

    public void setIngredient(MilkProduct newMilkProduct) {
        this.currentMilkProduct = newMilkProduct;
        nameField.setText(currentMilkProduct.getName());
        weighField.setText(currentMilkProduct.getWeight() + "");
        caloriesField.setText(currentMilkProduct.getCalories() + "");
        processBox.getSelectionModel().select(currentMilkProduct.getProcessType());
        timeField.setText(currentMilkProduct.getTime() + "");
        calciumField.setText(currentMilkProduct.getCalcium() + "");
        fatField.setText(currentMilkProduct.getFatContent() + "");
    }
    private boolean isFormCorrect() {
        if (isNameFieldCorrect.get() && isWeighFieldCorrect.get() &&
                isCaloriesFieldCorrect.get() && isTimeFieldCorrect.get()  && isProcessBoxCorrect.get() && isCalciumFieldCorrect.get() && isFatFieldCorrect.get() ){
            return true;
        }
        return false;
    }

    @FXML
    private void addClickButton() {
        if (isFormCorrect()) {
            if (currentMilkProduct != null) {
                this.currentMilkProduct.setName(nameField.getText());
                this.currentMilkProduct.setWeight(Integer.parseInt(weighField.getText()));
                this.currentMilkProduct.setCalories(Integer.parseInt(caloriesField.getText()));
                this.currentMilkProduct.setProcessType(processBox.getSelectionModel().getSelectedItem());
                this.currentMilkProduct.setTime(Integer.parseInt(timeField.getText()));
                this.currentMilkProduct.setCalcium(Integer.parseInt(calciumField.getText()));
                this.currentMilkProduct.setFatContent(Integer.parseInt(fatField.getText()));
            } else {
                this.currentMilkProduct = new MilkProduct(nameField.getText(), Integer.parseInt(weighField.getText()), Integer.parseInt(caloriesField.getText()), processBox.getSelectionModel().getSelectedItem(), Integer.parseInt(timeField.getText()), Integer.parseInt(calciumField.getText()), Integer.parseInt(fatField.getText()));
            }
            Stage stage = (Stage) addButton.getScene().getWindow();
            stage.close();
        }
    }


    @FXML
    void initialize() {
        addButton.setDisable(false);
        processBox.getItems().addAll("Нагреть", "Жарить", "Запекать", "Взбивать", "Мешать", "Резать", "Вскипятить");
        Validator validator = new Validator();
        validator.validateName(nameField, isNameFieldCorrect);
        validator.validateInt(weighField, isWeighFieldCorrect);
        validator.validateInt(caloriesField, isCaloriesFieldCorrect);
        validator.validateInt(timeField, isTimeFieldCorrect);
        validator.validateComboBox(processBox, isProcessBoxCorrect);
        validator.validateInt(calciumField, isCalciumFieldCorrect);
        validator.validateInt(fatField, isFatFieldCorrect);
    }

}


