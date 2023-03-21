package com.example.example.controllers;

import com.example.example.utils.Validator;
import com.example.example.products.SFinishedProduct;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class SFinishedController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addButton;



    @FXML
    private TextField caloriesField;

    @FXML
    private TextField dataField;


    @FXML
    private TextField nameField;

    @FXML
    private TextField omegaField;

    @FXML
    private ComboBox<String> areaBox;
    @FXML
    private ComboBox<String> processBox;

    @FXML
    private TextField timeField;

    @FXML
    private TextField weighField;

    private SFinishedProduct currentSFinished;

    private BooleanProperty isNameFieldCorrect = new SimpleBooleanProperty(false);
    private BooleanProperty isWeighFieldCorrect = new SimpleBooleanProperty(false);
    private BooleanProperty isCaloriesFieldCorrect = new SimpleBooleanProperty(false);
    private BooleanProperty isTimeFieldCorrect = new SimpleBooleanProperty(false);
    private BooleanProperty isOmegaFieldCorrect = new SimpleBooleanProperty(false);
    private BooleanProperty isProcessBoxCorrect = new SimpleBooleanProperty(false);
    private BooleanProperty isDataFieldCorrect = new SimpleBooleanProperty(false);
    private BooleanProperty isAreaBoxCorrect = new SimpleBooleanProperty(false);

    public void setIngredient(SFinishedProduct newMilkProduct) {
        this.currentSFinished = newMilkProduct;
        nameField.setText(currentSFinished.getName());
        weighField.setText(currentSFinished.getWeight() + "");
        caloriesField.setText(currentSFinished.getCalories() + "");
        processBox.getSelectionModel().select(currentSFinished.getProcessType());
        timeField.setText(currentSFinished.getTime() + "");
        omegaField.setText(currentSFinished.getOmega3() + "");
        dataField.setText(currentSFinished.getData() + "");
        areaBox.getSelectionModel().select(currentSFinished.getFishArea());
    }

    public SFinishedProduct getIngredient() {
        return this.currentSFinished;
    }

    private boolean isFormCorrect() {
        if (isNameFieldCorrect.get() && isWeighFieldCorrect.get() &&
                isCaloriesFieldCorrect.get() && isTimeFieldCorrect.get()  && isProcessBoxCorrect.get() && isOmegaFieldCorrect.get() && isAreaBoxCorrect.get() && isDataFieldCorrect.get()){
            return true;
        }
        return false;
    }

    @FXML
    private void addClickButton() {
        if (isFormCorrect()) {
            if (currentSFinished != null) {
                this.currentSFinished.setName(nameField.getText());
                this.currentSFinished.setWeight(Integer.parseInt(weighField.getText()));
                this.currentSFinished.setCalories(Integer.parseInt(caloriesField.getText()));
                this.currentSFinished.setProcessType(processBox.getSelectionModel().getSelectedItem());
                this.currentSFinished.setTime(Integer.parseInt(timeField.getText()));
                this.currentSFinished.setOmega3(Integer.parseInt(omegaField.getText()));
                this.currentSFinished.setFishArea(areaBox.getSelectionModel().getSelectedItem());
                this.currentSFinished.setData(Integer.parseInt(dataField.getText()));
            } else {
                this.currentSFinished = new SFinishedProduct(nameField.getText(), Integer.parseInt(weighField.getText()), Integer.parseInt(caloriesField.getText()), processBox.getSelectionModel().getSelectedItem(), Integer.parseInt(timeField.getText()), Integer.parseInt(omegaField.getText()), areaBox.getSelectionModel().getSelectedItem(), Integer.parseInt(dataField.getText()));
            }
            Stage stage = (Stage) addButton.getScene().getWindow();
            stage.close();
        }
    }

    @FXML
    void initialize() {
        processBox.getItems().addAll("Варить", "Жарить", "Запекать", "Взбивать", "Мешать", "Резать", "Чистить");
        areaBox.getItems().addAll("Река", "Озеро", "Море", "Океан");
        Validator validator = new Validator();
        validator.validateName(nameField, isNameFieldCorrect);
        validator.validateInt(weighField, isWeighFieldCorrect);
        validator.validateInt(caloriesField, isCaloriesFieldCorrect);
        validator.validateInt(timeField, isTimeFieldCorrect);
        validator.validateComboBox(processBox, isProcessBoxCorrect);
        validator.validateComboBox(areaBox, isAreaBoxCorrect);
        validator.validateInt(omegaField, isOmegaFieldCorrect);
        validator.validateInt(dataField, isDataFieldCorrect);
    }

}


