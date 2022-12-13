package com.example.cateringfx;

import com.example.cateringfx.model.*;
import com.example.cateringfx.model.Menu;
import com.example.cateringfx.utils.FileUtils;
import com.example.cateringfx.utils.MessageUtils;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import static com.example.cateringfx.NewLimits.*;
import static com.example.cateringfx.utils.FileUtils.loadelements;


/**
 * Manages the main view.
 * @author Ugo Gianino
 * @version 1.0
 */
public class MainController implements Initializable {
    
    @FXML
    private Label lbCal;
    @FXML
    private Label lbCarb;
    @FXML
    private Label lbFat;
    @FXML
    private CheckBox checkGluten;
    @FXML
    private CheckBox checkEgg;
    @FXML
    private CheckBox checkNuts;
    @FXML
    private CheckBox checkMilk;
    @FXML
    private CheckBox radioMilk;
    @FXML
    private CheckBox radioNuts;
    @FXML
    private CheckBox radioEgg;
    @FXML
    private CheckBox radioGluten;
    @FXML
    private TableColumn<MenuElement, Aliment> colName;
    @FXML
    private TableColumn<MenuElement, Aliment> colCal;
    @FXML
    private TableColumn<MenuElement, Aliment> colCarb;
    @FXML
    private TableColumn<MenuElement, Aliment> colFat;
    @FXML
    private TableView<MenuElement> tbElements;
    @FXML
    private DatePicker dateField;
    public List<MenuElement> myListElements;
    public List<Nameable> myListElements2;
    ObservableList<MenuElement> myObservableMenu;
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


    /**
     * Initializes the FXML view.
     */

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        fillElements();
    }

    /**
     * Fills the table with the elements.
     */

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

        checkMilk.setDisable(true);
        checkEgg.setDisable(true);
        checkNuts.setDisable(true);
        checkGluten.setDisable(true);

    }


    /**
     * Adds a new element to the table.
     * @param actionEvent
     */
    public void addAliment(ActionEvent actionEvent) {
        if (tbElements.getSelectionModel().getSelectedItem() != null) {
            //myObservableMenu.add(tbElements.getItems().get(tbElements.getSelectionModel().getSelectedIndex()));

            tbElements.setItems(FXCollections.observableArrayList(myListElements));

            myMenu.addNewElement(tbElements.getSelectionModel().getSelectedItem());
            setUpNutritionalLimits();
        }
        else {
            MessageUtils.showMessage("Information", "You must select a menu to delete from de list.");
        }
    }


    /**
     * Removes an element from the table.
     * @param actionEvent
     */
    public void removeAliment(ActionEvent actionEvent) {
        if (tbElements.getSelectionModel().getSelectedItem() != null){
            myObservableMenu.remove(myListElements.get(
                    tbMenu.getSelectionModel().getSelectedIndex()));

            tbElements.setItems(FXCollections.observableArrayList(myListElements));
            myMenu.getElements().remove(tbElements.getSelectionModel().getSelectedItem());
            setUpNutritionalLimits();
        }
        else {
            MessageUtils.showMessage("Information", "You must select a menu to delete from de list.");
        }
    }

    /**
     * Saves the newAliment.
     * @param actionEvent
     * @throws IOException
     */
    public void newAliment(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Stage secondaryStage = ScreenLoader.loadScreen(
                "new-aliment.fxml", stage
        );
        secondaryStage.setOnCloseRequest(e -> fillElements());
        secondaryStage.show();
    }

    /**
     * Saves the newDish.
     * @param actionEvent
     * @throws IOException
     */
    public void newDish(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Stage secondaryStage = ScreenLoader.loadScreen(
                "new-dish.fxml", stage
        );
        secondaryStage.setOnCloseRequest(e -> fillElements());
        secondaryStage.show();
    }

    /**
     * Saves the setLimits.
     * @param actionEvent
     * @throws IOException
     */
    public void setLimits(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Stage secondaryStage = ScreenLoader.loadScreen(
                "new-limits.fxml", stage
        );
        secondaryStage.setOnCloseRequest(e -> fillElements());
        secondaryStage.show();
    }


    /**
     * Saves the search.
     * @param keyEvent
     */
    public void search(KeyEvent keyEvent) {
        tbElements.setItems(FXCollections.observableArrayList(
                myListElements).filtered(e -> ((Nameable)e).getName().toLowerCase().contains(txtSearch
                       .getText().toString())));


    }

    /**
     * Saves the saveMenu.
     * @param actionEvent
     */
    public void saveMenu(ActionEvent actionEvent) {
        if(myListElements.size() > 0 && myMenu != null){
            boolean result = MessageUtils.showConfirmation("Confirmation", "Do you want to save this menu?");
            if(result)
                FileUtils.storeMenu(myMenu);

        }else  MessageUtils.showError("Error", "No item has been selected for the menu");
    }


    /**
     * Method for select only on echeckbox
     * @param mouseEvent
     */
    public void Selected(MouseEvent mouseEvent) {

        if (radioEgg.isSelected()){
            radioMilk.setDisable(true);
            radioNuts.setDisable(true);
            radioGluten.setDisable(true);
        } else if (radioGluten.isSelected()) {
            radioMilk.setDisable(true);
            radioNuts.setDisable(true);
            radioEgg.setDisable(true);
        } else if (radioMilk.isSelected()) {
            radioGluten.setDisable(true);
            radioNuts.setDisable(true);
            radioEgg.setDisable(true);
        } else if (radioNuts.isSelected()) {
            radioMilk.setDisable(true);
            radioEgg.setDisable(true);
            radioGluten.setDisable(true);
        } else {
            radioMilk.setDisable(false);
            radioNuts.setDisable(false);
            radioGluten.setDisable(false);
            radioEgg.setDisable(false);
        }
    }

    private void setUpNutritionalLimits(){
        if(tbElements.getSelectionModel().getSelectedItem() != null){

            double calories = myMenu.getCalories();
            lbCal.setText(String.valueOf(calories));
            setUpLimitColours(lbCal, calories, limitCalories);

            double carbohydrates = myMenu.getCarbohydrates();
            lbCarb.setText(String.valueOf(carbohydrates));
            setUpLimitColours(lbCarb, carbohydrates, limitCarbohydrates);

            double fat = myMenu.getFat();
            lbFat.setText(String.valueOf(fat));
            setUpLimitColours(lbFat, fat, limitFats);

        }else
            MessageUtils.showError("Error", "You must select an item to add to the menu.");
    }

    private void setUpLimitColours(Label label, double itemValue, double limit){
        if(itemValue> limit)
            label.setTextFill(Color.RED);
        else label.setTextFill(Color.BLACK);
    }
}