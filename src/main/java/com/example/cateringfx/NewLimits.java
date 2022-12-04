package com.example.cateringfx;

import com.example.cateringfx.utils.MessageUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Limit Controller
 * @author Ugo Gianino
 * @version 1.0
 */
public class NewLimits implements Initializable {

    public static double limitCalories = 0;
    public static double limitCarbohydrates = 0;
    public static double limitFats = 0;
    @FXML
    private TextField txtFat;
    @FXML
    private TextField txtCarb;
    @FXML
    private TextField txtCalories;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        txtCalories.setText(String.valueOf(limitCalories));
        txtCarb.setText(String.valueOf(limitCarbohydrates));
        txtFat.setText(String.valueOf(limitFats));
    }




    public void newLimits(ActionEvent actionEvent) {
        if(txtFat.getText().isEmpty() || txtCarb.getText().isEmpty() || txtCalories.getText().isEmpty()){
            MessageUtils.showError("Error", "The fields cannot be left empty.");
        }else {
            limitCalories = Double.parseDouble(txtCalories.getText());
            limitCarbohydrates = Double.parseDouble(txtCarb.getText());
            limitFats = Double.parseDouble(txtFat.getText());
            closeThisWindow(actionEvent);
        }

    }

    private void closeThisWindow(ActionEvent actionEvent){
        Node node = (Node) actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
    }
}
