package com.example.cateringfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private CheckBox radioMilk;
    @FXML
    private CheckBox radioNuts;
    @FXML
    private CheckBox radioEgg;
    @FXML
    private CheckBox radioGluten;
    @FXML
    private TableView tbElement;
    @FXML
    private TableColumn colName;
    @FXML
    private TableColumn colCal;
    @FXML
    private TableColumn colCarb;
    @FXML
    private TableColumn colFat;
    @FXML
    private TableView tbMenu;
    @FXML
    private TableColumn colName2;
    @FXML
    private TableColumn colDescription;
    @FXML
    private TextField tbSearch;
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    public void addAliment(ActionEvent actionEvent) {
    }

    public void search(KeyEvent keyEvent) {
    }

    public void removeAliment(ActionEvent actionEvent) {
    }

    public void newAliment(ActionEvent actionEvent) {
    }

    public void newDish(ActionEvent actionEvent) {
    }

    public void saveMenu(ActionEvent actionEvent) {
    }

    public void setLimits(ActionEvent actionEvent) {
    }


}