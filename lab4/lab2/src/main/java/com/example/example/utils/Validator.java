package com.example.example.utils;

import javafx.beans.property.BooleanProperty;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class Validator {
    public void validateComboBox(ComboBox<String> comBox, BooleanProperty isFormUncorrect) {

        comBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == null) {
                comBox.setStyle("-fx-background-color: #FFCCCC;");
                isFormUncorrect.set(false);
            } else {
                comBox.setStyle("-fx-background-color: white;");
                isFormUncorrect.set(true);
            }
        });
    }

    public void validateName(TextField txtField, BooleanProperty isFormUncorrect) {
        txtField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.isEmpty()) {
                txtField.setStyle("-fx-background-color: #FFCCCC;");
                isFormUncorrect.set(false);
            } else {
                txtField.setStyle("-fx-background-color: white;");
                isFormUncorrect.set(true);
            }
        });

    }

    public void validateInt(TextField txtField, BooleanProperty isFormUncorrect) {
        txtField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*") || newValue.isEmpty()) {
                txtField.setStyle("-fx-background-color: #FFCCCC;");
                isFormUncorrect.set(false);
            } else {
                txtField.setStyle("-fx-background-color: white;");
                isFormUncorrect.set(true);
            }
        });

    }

    public Validator() {
    }
}
