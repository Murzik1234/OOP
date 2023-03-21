package com.example.example;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.example.ChangeDishController;
import com.example.example.Dish;
import com.example.example.dataModels.DishDataModel;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class MenuController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addButton;

    @FXML
    private Button addDishes;

    @FXML
    private Button deleteDishes;

    @FXML
    private Button editDishes;

    @FXML
    private TableColumn<Dish, String> ingredColumn;

    @FXML
    private TableView<Dish> menuTable;

    @FXML
    private TableColumn<Dish, String> nameColumn;

    @FXML
    private TableColumn<Dish, String> timeColumn;

    private DishDataModel dishData;


    private BooleanProperty disableIsSelected = new SimpleBooleanProperty(true);

    public void setDishData(DishDataModel curDishData) {
        this.dishData = curDishData;
        menuTable.setItems(dishData.getDishesList());
    }

    @FXML
    private void deleteClickButton() {
        if (menuTable.getSelectionModel().getSelectedItem() != null) {
            dishData.getDishesList().remove(menuTable.getSelectionModel().getSelectedItem());
        }
    }

    @FXML
    private void editClickButton() {
        if (menuTable.getSelectionModel().getSelectedItem() != null) {
            //((Stage)editDishes.getScene().getWindow()).hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("changeDish.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            ChangeDishController controller = loader.getController();
            controller.setCurrentDish(menuTable.getSelectionModel().getSelectedItem());
            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent windowEvent) {
                    menuTable.refresh();
                }
            });
            stage.showAndWait();
            menuTable.getSelectionModel().clearSelection();
            //((Stage)editDishes.getScene().getWindow()).show();
        } else {
            dishData.getDishesList().add(new Dish(""));
            FXMLLoader loader = new FXMLLoader();
            //((Stage)editDishes.getScene().getWindow()).hide();
            loader.setLocation(getClass().getResource("changeDish.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            ChangeDishController controller = loader.getController();
            controller.setCurrentDish(dishData.getDishesList().get(dishData.getDishesList().size() - 1));
            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent windowEvent) {
                    menuTable.refresh();
                }
            });
            stage.showAndWait();
            menuTable.getSelectionModel().clearSelection();
            //((Stage)editDishes.getScene().getWindow()).show();
        }
    }

    @FXML
    void initialize(MouseEvent event) {

    }

    @FXML
    void initialize() {
        nameColumn.setCellValueFactory(
                new PropertyValueFactory("name")
        );
        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        timeColumn.setCellValueFactory(data -> data.getValue().getCookingTime());
        ingredColumn.setCellValueFactory(data -> data.getValue().getIngredientsToString());
        ingredColumn.setCellFactory(tc -> {
            TableCell<Dish, String> cell = new TableCell<>();
            Text text = new Text();
            text.wrappingWidthProperty().bind(ingredColumn.widthProperty());
            text.textProperty().bind(cell.itemProperty());
            cell.setGraphic(new ScrollPane(text));
            cell.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
            return cell;
        });
        ingredColumn.setPrefWidth(519);
        deleteDishes.disableProperty().bind(disableIsSelected);
        menuTable.getSelectionModel().selectedItemProperty().addListener((obj, oldSelection, newSelection) -> {
            if (newSelection != null){
                disableIsSelected.set(false);
            }else {
                disableIsSelected.set(true);
            }
        });


    }


}