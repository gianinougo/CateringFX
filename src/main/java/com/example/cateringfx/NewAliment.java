package com.example.cateringfx;

import com.example.cateringfx.model.Aliment;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

import java.io.IOException;

import static com.example.cateringfx.utils.FileUtils.storeAliment;
import static com.example.cateringfx.utils.MessageUtils.showError;
import static com.example.cateringfx.utils.MessageUtils.showMessage;

/**
 * Controller of New aliment
 * @author Ugo Gianino
 * @version 1.0
 */

public class NewAliment {
    @FXML
    private CheckBox checkMilk;
    @FXML
    private CheckBox checkNuts;
    @FXML
    private CheckBox checkEgg;
    @FXML
    private CheckBox checkGluten;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtDescription;
    @FXML
    private TextField txtFrequency;
    @FXML
    private TextField txtCalories;
    @FXML
    private TextField txtCarb;
    @FXML
    private TextField txtFat;

    /**
     * Method to save the new aliment
     * @param actionEvent
     * @throws IOException
     */
    public void newAliment(ActionEvent actionEvent) throws IOException {

        if (txtName.getText().equals("") ||
            txtDescription.getText().equals("") ||
                txtCalories.getText().equals("") ||
                txtFat.getText().equals("") ||
                txtFrequency.getText().equals("") ||
                txtCarb.getText().equals("")){

            showError("Empty Value", "Some field is empty");
        }
        else {

            Aliment a = new Aliment(txtName.getText(), txtDescription.getText()
                    ,txtFrequency.getText(),
                    Boolean.parseBoolean(String.valueOf(checkMilk.getText())),
                    Boolean.parseBoolean(String.valueOf(checkEgg.getText())),
                    Boolean.parseBoolean(String.valueOf(checkNuts.getText())),
                    Boolean.parseBoolean(String.valueOf(checkGluten.getText())),
                    Double.parseDouble(txtCalories.getText()),
                    Double.parseDouble(txtFat.getText()),
                    Double.parseDouble(txtCarb.getText()));

            System.out.println(a);
            storeAliment(a);

            txtName.setText("");
            txtDescription.setText("");
            txtFrequency.setText("");
            txtCalories.setText("");
            txtCarb.setText("");
            txtFat.setText("");
            checkEgg.setSelected(false);
            checkMilk.setSelected(false);
            checkGluten.setSelected(false);
            checkNuts.setSelected(false);


            showMessage("Save ok", "You must select a menu to delete from de list.");
        }



    }
}
