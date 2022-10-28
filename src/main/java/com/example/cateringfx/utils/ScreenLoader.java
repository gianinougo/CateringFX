package com.example.cateringfx.utils;

import com.example.cateringfx.MainController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Class for Load Screens
 * @author Ugo Gianino
 */
public class ScreenLoader {

    public static Stage loadScreen(String path, Stage stage) throws IOException {
        Parent view1 = FXMLLoader.load(MainController.class.getResource(path));
        Scene viewScene = new Scene(view1);
        Stage secondaryStage = new Stage();
        secondaryStage.setScene(viewScene);
        secondaryStage.initModality(Modality.WINDOW_MODAL);
        secondaryStage.initOwner(stage);
        return secondaryStage;
    }

}
