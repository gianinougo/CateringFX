package com.example.cateringfx.utils;

import javafx.scene.control.Alert;

public class MessageUtils {

    public static void showError(String message, String s)
    {
        Alert dialog = new Alert(Alert.AlertType.ERROR);
        dialog.setHeaderText("Error");
        dialog.setTitle("MenuAliment");
        dialog.setContentText(message);
        dialog.showAndWait();
    }

    /**
     * Shows an information message.
     * @param message Information message
     */
    public static void showMessage(String message)
    {
        Alert dialog = new Alert(Alert.AlertType.INFORMATION);
        dialog.setHeaderText("Information");
        dialog.setTitle("MenuAliment");
        dialog.setContentText(message);
        dialog.showAndWait();
    }
}
