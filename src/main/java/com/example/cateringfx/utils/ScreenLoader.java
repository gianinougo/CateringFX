package com.example.cateringfx.utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ScreenLoader {

    public static void loadScreen(String viewPath, Stage stage) throws IOException {
        Parent view1 = FXMLLoader.load(ScreenLoader.class.getResource(viewPath));
        Scene view1Scene = new Scene(view1);
        stage.hide();
        stage.setScene(view1Scene);
        stage.show();
    }

}
