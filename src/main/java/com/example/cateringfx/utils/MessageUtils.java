package com.example.cateringfx.utils;

import javafx.scene.control.Alert;

/**
 * Class to show messages.
 * @author Ugo Gianino
 * @version 1.0
 */

public class MessageUtils {

    /**
     * Shows an error message.
     * @param message Error message
     */

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
