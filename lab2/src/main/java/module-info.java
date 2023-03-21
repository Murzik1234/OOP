module com.example.example {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.example to javafx.fxml;

    exports com.example.example;
    exports com.example.example.products;
    exports com.example.example.controllers;
    opens com.example.example.controllers to javafx.fxml;
    exports com.example.example.dataModels;
    opens com.example.example.dataModels to javafx.fxml;
    exports com.example.example.utils;
    opens com.example.example.utils to javafx.fxml;
    exports com.example.example.factories;
    opens com.example.example.factories to javafx.fxml;


}