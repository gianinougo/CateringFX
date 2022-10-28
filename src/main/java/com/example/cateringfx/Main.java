package com.example.cateringfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Main class of the application.
 * @author Ugo Gianino
 * @version 1.0
 */
public class Main extends Application {
    /**
     * Overrides start method to show the main view.
     * @param stage Stage
     * @throws Exception Exception
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 770, 756);
        stage.setTitle("Menu designer!");
        stage.setScene(scene);
        stage.show();
    }
    /**
     * Main method. Launches the application.
     */
    public static void main(String[] args) {
        launch();
    }
}