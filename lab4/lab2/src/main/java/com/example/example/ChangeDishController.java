package com.example.example;


import java.net.URL;

import java.util.ResourceBundle;

import com.example.example.*;
import com.example.example.products.BaseProduct;
import com.example.example.utils.ProductInterface;
import com.example.example.utils.ProductNode;
import com.example.example.utils.Validator;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;

import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.text.Text;


public class ChangeDishController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private TreeView<ProductNode> catalogTree;

    @FXML
    private URL location;
    @FXML
    private Button deleteIngridient;

    @FXML
    private Button editIngridient;
    @FXML
    private Button addIngridient;

    @FXML
    private TextField nameField;


    @FXML
    private TableColumn<BaseProduct, String> moreColumn;
    @FXML
    private TableColumn<BaseProduct, String> processColumn;
    @FXML
    private TableColumn<BaseProduct, String> timeColumn;
    @FXML
    private TableColumn<BaseProduct, String> caloriesColumn;
    @FXML
    private TableColumn<BaseProduct, String> nameColumn;
    @FXML
    private TableColumn<BaseProduct, String> weightColumn;
    @FXML
    private TableView<BaseProduct> ingrTable;

    @FXML
    private void editClickButton() {
        ProductFactory factory = new ProductFactory();
        ProductInterface product = factory.getProductEdit(ingrTable.getSelectionModel().getSelectedItem().getClass().getName());
        product.change(ingrTable.getSelectionModel().getSelectedItem());
        ingrTable.refresh();
    }

    @FXML
    private void addClickButton() {
        ProductFactory factory = new ProductFactory();
        ProductInterface product = factory.getProduct(catalogTree.getSelectionModel().getSelectedItem().getValue().getProductTypes());
        BaseProduct tmpProduct = product.add();
        if (tmpProduct != null) {
            currentDish.getProductsList().add(tmpProduct);
        }
    }

    @FXML
    private void deleteClickButton() {
        if (ingrTable.getSelectionModel().getSelectedItem() != null) {
            currentDish.getProductsList().remove(ingrTable.getSelectionModel().getSelectedItem());
        }
    }


    private Dish currentDish;
    private BooleanProperty disableIsSelected = new SimpleBooleanProperty(true);
    private BooleanProperty isNameFieldCorrect = new SimpleBooleanProperty(false);

    public void setCurrentDish(Dish curDish) {
        this.currentDish = curDish;
        nameField.setText(currentDish.getName());
        nameField.textProperty().addListener((observable, oldValue, newValue) -> {
            currentDish.setName(nameField.getText());
        });
        ingrTable.setItems(currentDish.getProductsList());
    }


    // ImageView icon = new ImageView(new Image(getClass().getResourceAsStream("/images/meat.png")));
    //Image icon = new Image(getClass().getResourceAsStream("meat.png"));

    @FXML
    void initialize() {

        TreeItem<ProductNode> root = new TreeItem<ProductNode>(new ProductNode("Ингредиенты", ProductTypes.ING));
        TreeItem<ProductNode> nodeMeat = new TreeItem<ProductNode>(new ProductNode("Мясо", ProductTypes.MEAT));
        TreeItem<ProductNode> nodeFish = new TreeItem<ProductNode>(new ProductNode("Рыба", ProductTypes.FISH));
        TreeItem<ProductNode> nodeMilkP = new TreeItem<ProductNode>(new ProductNode("Молочные продукты", ProductTypes.MILKPRODUCTS));
        TreeItem<ProductNode> nodeCerealP = new TreeItem<ProductNode>(new ProductNode("Крупы и паста", ProductTypes.CEREALS));
        TreeItem<ProductNode> nodeVegP = new TreeItem<ProductNode>(new ProductNode("Овощи и фрукты", ProductTypes.VEGFRUITS));
        TreeItem<ProductNode> nodeSpices = new TreeItem<ProductNode>(new ProductNode("Специи", ProductTypes.SPICES));
        TreeItem<ProductNode> nodeSimpleP = new TreeItem<ProductNode>(new ProductNode("Простые продукты", ProductTypes.SIMPLE));
        TreeItem<ProductNode> nodeMince = new TreeItem<ProductNode>(new ProductNode("Фарш", ProductTypes.MINCE));
        TreeItem<ProductNode> nodePart = new TreeItem<ProductNode>(new ProductNode("Целая часть", ProductTypes.PART));
        TreeItem<ProductNode> nodeBY = new TreeItem<ProductNode>(new ProductNode("Субпродукты", ProductTypes.BY));
        TreeItem<ProductNode> nodeSFinished = new TreeItem<ProductNode>(new ProductNode("Полуфабрикаты", ProductTypes.SFINISHED));
        TreeItem<ProductNode> nodeMMilk = new TreeItem<ProductNode>(new ProductNode("Молоко", ProductTypes.MILK));
        TreeItem<ProductNode> nodePasta = new TreeItem<ProductNode>(new ProductNode("Паста", ProductTypes.PASTA));

        root.getChildren().addAll(nodeMeat, nodeFish, nodeMilkP, nodeCerealP, nodeVegP, nodeSpices, nodeSimpleP);
        nodeMeat.getChildren().addAll(nodeMince, nodePart, nodeBY);
        nodeFish.getChildren().addAll(nodeSFinished);
        nodeMilkP.getChildren().addAll(nodeMMilk);
        nodeCerealP.getChildren().addAll(nodePasta);
        //nodeMeat.setGraphic(icon);*/
        catalogTree.setRoot(root);
        catalogTree.setShowRoot(false);

        nameColumn.setCellValueFactory(
                new PropertyValueFactory<BaseProduct, String>("name")
        );
        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        weightColumn.setCellValueFactory(data -> data.getValue().getProductWeigh());
        weightColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        caloriesColumn.setCellValueFactory(data -> data.getValue().getProductCalories());
        caloriesColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        processColumn.setCellValueFactory(
                new PropertyValueFactory<BaseProduct, String>("processType")
        );
        processColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        timeColumn.setCellValueFactory(data -> data.getValue().getProductTime());
        timeColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        moreColumn.setCellValueFactory(data -> data.getValue().getMoreProductInfo());
        moreColumn.setCellFactory(tc -> {
            TableCell<BaseProduct, String> cell = new TableCell<>();
            Text text = new Text();
            text.wrappingWidthProperty().bind(moreColumn.widthProperty());
            text.textProperty().bind(cell.itemProperty());
            cell.setGraphic(new ScrollPane(text));
            cell.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
            return cell;
        });
        moreColumn.setPrefWidth(252);
        editIngridient.disableProperty().bind(disableIsSelected);
        deleteIngridient.disableProperty().bind(disableIsSelected);
        ingrTable.getSelectionModel().selectedItemProperty().addListener((obj, oldSelection, newSelection) -> {
            if (newSelection != null){
                disableIsSelected.set(false);
            }else {
                disableIsSelected.set(true);
            }
        });
        Validator validator = new Validator();
        validator.validateName(nameField, isNameFieldCorrect);
    }

}

