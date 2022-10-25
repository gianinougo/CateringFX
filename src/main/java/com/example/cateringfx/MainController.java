package com.example.cateringfx;

import com.example.cateringfx.model.MenuElement;
import com.example.cateringfx.model.Nameable;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;

import static com.example.cateringfx.utils.FilUtils.loadelements;

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
    private TextField txtSearch;
    @FXML
    private Label welcomeText;

    private List<MenuElement> elements;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        elements = loadelements();
        System.out.println(elements.size());
        colName.setCellValueFactory(new PropertyValueFactory("name"));
        colCal.setCellValueFactory(new PropertyValueFactory("Calories"));
        colCarb.setCellValueFactory(new PropertyValueFactory("Carbohydrates"));
        colFat.setCellValueFactory(new PropertyValueFactory("Fat"));

        //colName2.setCellValueFactory(new PropertyValueFactory("Name"));
        //colDescription.setCellValueFactory(new PropertyValueFactory("Description"));
        tbElement.setItems(FXCollections.observableList(elements));
        //tbMenu.setItems(FXCollections.observableList(new ArrayList<>()));

    }


    public void addAliment(ActionEvent actionEvent) {
    }

    public void search(KeyEvent keyEvent) {
        tbElement.setItems(
                FXCollections.observableArrayList(
                        elements.stream().filter(e ->((Nameable) e)
                                .getName().toLowerCase()
                                .contains(txtSearch.getText().toString()))));
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