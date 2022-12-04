package com.example.cateringfx;

import com.example.cateringfx.model.Aliment;
import com.example.cateringfx.model.Dish;
import com.example.cateringfx.model.Ingredient;
import com.example.cateringfx.utils.FileUtils;
import com.example.cateringfx.utils.MessageUtils;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class NewDish implements Initializable {

    @FXML
    private TableView<Ingredient> tableViewIngredients;
    @FXML private TableColumn<Ingredient, String> columnName;
    @FXML private TableColumn<Ingredient, String> columnDescription;
    @FXML private TableColumn<Ingredient, Double> columnQuantity;
    @FXML private CheckBox checkGluten;
    @FXML private CheckBox checkEgg;
    @FXML private CheckBox checkNuts;
    @FXML private CheckBox checkMilk;
    @FXML private TextField txtIngredientFat;
    @FXML private TextField txtIngredientFrequency;
    @FXML private TextField txtIngredienteCarbo;
    @FXML private TextField txtIngredientDescription;
    @FXML private TextField txtIngredientQuantity;
    @FXML private TextField txtIngredientCalories;
    @FXML private TextField txtIngredientName;
    @FXML private TextField txtDescriptionDish;
    @FXML private TextField txtNameDish;

    private Dish newDish;
    private Ingredient ingredient;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) { fillElements(); }

    /**
     *Load and initialize the resources needed when the program start.
     */
    private void fillElements(){

        columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        columnQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
    }

    /**
     * Button event to add a new Ingredient to the Dish.
     * @param actionEvent ActionEvent.
     * @see Ingredient
     * @see Dish
     */

    @FXML
    private void addNewIngredient(ActionEvent actionEvent) {

        if(txtNameDish.getText().isEmpty() || txtDescriptionDish.getText().isEmpty()) {
            MessageUtils.showError("Error", "The name and description of the dish can not be empty.");

        }else {
            if(txtIngredientName.getText().isEmpty() || txtIngredientDescription.getText().isEmpty() ||
                    txtIngredientFrequency.getText().isEmpty() || txtIngredientCalories.getText().isEmpty() ||
                    txtIngredienteCarbo.getText().isEmpty() || txtIngredientFat.getText().isEmpty() ||
                    txtIngredientQuantity.getText().isEmpty()){

                MessageUtils.showError("Error", "All Ingredient fields are mandatory.");
            }
            else {
                newDish = new Dish(txtNameDish.getText(), txtDescriptionDish.getText());

                ingredient = new Ingredient(Double.parseDouble(txtIngredientQuantity.getText()),
                        new Aliment(txtIngredientName.getText(),
                                txtIngredientDescription.getText(),
                                txtIngredientFrequency.getText(),
                                checkGluten.isSelected(), checkMilk.isSelected(),
                                checkNuts.isSelected(), checkEgg.isSelected(),
                                Double.parseDouble(txtIngredientCalories.getText()),
                                Double.parseDouble(txtIngredienteCarbo.getText()),
                                Double.parseDouble(txtIngredientFat.getText())));

                newDish.addIngredients(ingredient);
                boolean confirmation = MessageUtils.showConfirmation("Confirmation", "Do you want to save this " +
                        "ingredient?");
                if (confirmation) {
                    tableViewIngredients.setItems(FXCollections.observableArrayList(newDish.getIngredients()));
                }
            }
        }
    }


    @FXML
    private void saveNewDish(ActionEvent actionEvent) throws IOException {
        if(newDish != null && ingredient != null){
            boolean confirmation = MessageUtils.showConfirmation("Confirmation","Do you want to save this dish?");
            if(confirmation){
                try {
                    FileUtils.storeDish(newDish);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                clearFields();
            }
        }
    }


    /**
     * Sets all the controls in its default state.
     */
    private void clearFields(){
        txtNameDish.setText("");
        txtDescriptionDish.setText("");
        txtIngredientName.setText("");
        txtIngredientDescription.setText("");
        txtIngredientFrequency.setText("");
        txtIngredientCalories.setText("");
        txtIngredienteCarbo.setText("");
        txtIngredientName.setText("");
        txtIngredientFat.setText("");
        txtIngredientQuantity.setText("");
        checkEgg.setSelected(false);
        checkGluten.setSelected(false);
        checkNuts.setSelected(false);
        checkMilk.setSelected(false);
    }

}

