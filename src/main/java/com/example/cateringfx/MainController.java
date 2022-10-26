package com.example.cateringfx;

import com.example.cateringfx.model.MenuElement;
import com.example.cateringfx.model.Menu;
import com.example.cateringfx.utils.ScreenLoader;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static com.example.cateringfx.utils.FileUtils.loadelements;

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
    private TableColumn<MenuElement, Double> colName;
    @FXML
    private TableColumn<MenuElement, Double> colCal;
    @FXML
    private TableColumn<MenuElement, Double> colCarb;
    @FXML
    private TableColumn<MenuElement, Double> colFat;

    @FXML
    private TableView<MenuElement> tbElements;

    @FXML
    private DatePicker dateField;

    public static List<MenuElement> myListElements;

    ObservableList<MenuElement> data;

    public static Menu myMenu;
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

    ObservableList<MenuElement> myObservableMenu;



    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        fillElements();
    }

    private void fillElements() {
        myListElements = loadelements();
        data = FXCollections.observableArrayList(myListElements);

        colName.setCellValueFactory(new PropertyValueFactory("name"));
        colCal.setCellValueFactory(new PropertyValueFactory("Calories"));
        colCarb.setCellValueFactory(new PropertyValueFactory("Carbohydrates"));
        colFat.setCellValueFactory(new PropertyValueFactory("Fat"));

        tbElements.setItems(data);
        tbElements.setPlaceholder(new Label("No ites to show"));
        myObservableMenu= FXCollections.observableArrayList(new ArrayList<MenuElement>());
        colName2.setCellValueFactory(new PropertyValueFactory("name"));
        colDescription.setCellValueFactory(new PropertyValueFactory("description"));
        dateField.setValue(LocalDate.now());

        myMenu = new Menu(dateField.getValue());
        myMenu.setElements(myObservableMenu);

        tbMenu.setItems(myObservableMenu);
        tbElements.setPlaceholder(new Label("No items to show"));
    }


    public void addAliment(ActionEvent actionEvent) {
        myObservableMenu.add(tbElements.getItems().get(tbElements.getSelectionModel().getSelectedIndex()));
        drawNutrionalValues();
    }

    public void newAliment(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Stage secondaryStage = ScreenLoader.loadScreen(
                "new-aliment.fxml", stage
        );
        secondaryStage.setOnCloseRequest(e -> fillElements());
        secondaryStage.show();
    }

    public void newDish(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Stage secondaryStage = ScreenLoader.loadScreen(
                "new-dish.fxml", stage
        );
        secondaryStage.setOnCloseRequest(e -> fillElements());
        secondaryStage.show();
    }

    public void setLimits(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Stage secondaryStage = ScreenLoader.loadScreen(
                "new-limits.fxml", stage
        );
        secondaryStage.setOnCloseRequest(e -> fillElements());
        secondaryStage.show();
    }

    private void drawNutrionalValues() {
    }


    public void search(KeyEvent keyEvent) {
        //tbElements.setItems(FXCollections.observableArrayList(myListElements.stream().filter(e ->((Nameable)e).getName().toLowerCase().contains(txtSearch.getText().toString()))));
    }

    public void removeAliment(ActionEvent actionEvent) {
        myListElements.remove(myListElements.get(
                tbMenu.getSelectionModel().getSelectedIndex()));
    }




    public void saveMenu(ActionEvent actionEvent) {
        //if (myMenu.getElements().size)() > 0  && myMenu)
    }




}