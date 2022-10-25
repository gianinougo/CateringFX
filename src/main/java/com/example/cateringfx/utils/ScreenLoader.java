package com.example.cateringfx.utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class ScreenLoader {

    public static void loadScreen(String viewPath, Stage stage) throws IOException {
        Parent view1 = FXMLLoader.load(ScreenLoader.class.getResource(viewPath));
        Scene viewScene = new Scene(view1);
        Stage secondaryStage = new Stage();
        secondaryStage.setScene(viewScene);
        secondaryStage.initModality(Modality.WINDOW_MODAL);
        stage.hide();
        stage.setScene(viewScene);
        stage.show();
    }

}
