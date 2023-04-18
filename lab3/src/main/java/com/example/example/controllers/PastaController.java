package com.example.example.controllers;

import com.example.example.utils.Validator;
import com.example.example.products.Pasta;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class PastaController {

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
    private ComboBox<String> wheatBox;

    @FXML
    private TextField carbField;

    @FXML
    private TextField timeField;

    @FXML
    private TextField weighField;

    private Pasta currentPasta;
    private BooleanProperty isNameFieldCorrect = new SimpleBooleanProperty(false);
    private BooleanProperty isWeighFieldCorrect = new SimpleBooleanProperty(false);
    private BooleanProperty isCaloriesFieldCorrect = new SimpleBooleanProperty(false);
    private BooleanProperty isTimeFieldCorrect = new SimpleBooleanProperty(false);
    private BooleanProperty isCarbFieldCorrect = new SimpleBooleanProperty(false);
    private BooleanProperty isProcessBoxCorrect = new SimpleBooleanProperty(false);
    private BooleanProperty isTypeBoxCorrect = new SimpleBooleanProperty(false);
    private BooleanProperty isWheatBoxCorrect = new SimpleBooleanProperty(false);

    public void setIngredient(Pasta newPasta) {
        this.currentPasta = newPasta;
        nameField.setText(currentPasta.getName());
        weighField.setText(currentPasta.getWeight() + "");
        caloriesField.setText(currentPasta.getCalories() + "");
        processBox.getSelectionModel().select(currentPasta.getProcessType());
        timeField.setText(currentPasta.getTime() + "");
        carbField.setText(currentPasta.getCarb() + "");
        typeBox.getSelectionModel().select(currentPasta.getProductType());
        wheatBox.getSelectionModel().select(currentPasta.getWheatType());
    }

    public Pasta getIngredient() {
        return this.currentPasta;
    }

    private boolean isFormCorrect() {
        if (isNameFieldCorrect.get() && isWeighFieldCorrect.get() &&
                isCaloriesFieldCorrect.get() && isTimeFieldCorrect.get()  && isProcessBoxCorrect.get() && isCarbFieldCorrect.get() && isTypeBoxCorrect.get() && isWheatBoxCorrect.get()){
            return true;
        }
        return false;
    }

    @FXML
    private void addClickButton() {
        if (isFormCorrect()) {
            if (currentPasta != null) {
                this.currentPasta.setName(nameField.getText());
                this.currentPasta.setWeight(Integer.parseInt(weighField.getText()));
                this.currentPasta.setCalories(Integer.parseInt(caloriesField.getText()));
                this.currentPasta.setProcessType(processBox.getSelectionModel().getSelectedItem());
                this.currentPasta.setTime(Integer.parseInt(timeField.getText()));
                this.currentPasta.setCarb(Integer.parseInt(carbField.getText()));
                this.currentPasta.setProductType(typeBox.getSelectionModel().getSelectedItem());
                this.currentPasta.setWheatType(wheatBox.getSelectionModel().getSelectedItem());
            } else {
                this.currentPasta = new Pasta(nameField.getText(), Integer.parseInt(weighField.getText()), Integer.parseInt(caloriesField.getText()), processBox.getSelectionModel().getSelectedItem(), Integer.parseInt(timeField.getText()), Integer.parseInt(carbField.getText()), typeBox.getSelectionModel().getSelectedItem(), wheatBox.getSelectionModel().getSelectedItem());
            }
            Stage stage = (Stage) addButton.getScene().getWindow();
            stage.close();
        }
    }

    @FXML
    void initialize() {
        processBox.getItems().addAll("Варить", "Жарить", "Запекать", "Мешать", "Резать");
        typeBox.getItems().addAll("Паста");
        wheatBox.getItems().addAll("Твёрдый сорт", "Высший сорт", "Первый сорт");
        Validator validator = new Validator();
        validator.validateName(nameField, isNameFieldCorrect);
        validator.validateInt(weighField, isWeighFieldCorrect);
        validator.validateInt(caloriesField, isCaloriesFieldCorrect);
        validator.validateInt(timeField, isTimeFieldCorrect);
        validator.validateComboBox(processBox, isProcessBoxCorrect);
        validator.validateComboBox(typeBox, isTypeBoxCorrect);
        validator.validateComboBox(wheatBox, isWheatBoxCorrect);
        validator.validateInt(carbField, isCarbFieldCorrect);
    }

}


