package com.phimes.casaxbase;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CasaApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("menuBar.fxml"));
        Parent root = loader.load();

        MenuBarController controller = loader.getController();
        controller.setPrimaryStage(primaryStage);

        Scene scene = new Scene(root, 320, 240);

        primaryStage.setTitle("Casa S2S");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}