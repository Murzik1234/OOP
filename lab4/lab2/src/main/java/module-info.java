module com.example.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires fastjson;
    requires com.google.gson;
    requires slf4j.api;
    requires gson.extras;
    requires junit;


    opens com.example.example to fastjson, javafx.fxml, com.google.gson;

    exports com.example.example;
    exports com.example.example.products;
    exports com.example.example.controllers;
    opens com.example.example.controllers to fastjson, javafx.fxml, com.google.gson;
    exports com.example.example.dataModels;
    opens com.example.example.dataModels to fastjson, javafx.fxml, com.google.gson;
    exports com.example.example.utils;
    opens com.example.example.utils to fastjson, javafx.fxml, com.google.gson;
    exports com.example.example.factories;
    opens com.example.example.factories to fastjson, javafx.fxml, com.google.gson;
    opens com.example.example.products to fastjson, javafx.fxml, com.google.gson;


}