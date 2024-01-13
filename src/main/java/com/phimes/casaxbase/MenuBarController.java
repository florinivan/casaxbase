package com.phimes.casaxbase;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MenuBarController implements Initializable {

    @FXML
    private MenuBar menuBar;

    private Stage primaryStage;  // Reference to the primary stage

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Initialize any logic if needed
    }

    @FXML
    private void handleMenuItemAction(ActionEvent event) {
        MenuItem menuItem = (MenuItem) event.getSource();
        switch (menuItem.getText()) {
            case "Import":
                // Load and set the new scene (Replace with your FXML file and controller)
                setScene("loadcsv.fxml");
                break;
            case "Export":
                // Load and set the open scene (Replace with your FXML file and controller)
                setScene("export.fxml");
                break;
            // Add other menu items as needed
        }
    }

    private void setScene(String fxmlPath) {
        try {
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource(fxmlPath)), 320, 240);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}