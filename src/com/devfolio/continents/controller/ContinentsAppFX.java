package com.devfolio.continents.controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Objects;

public class ContinentsAppFX extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/devfolio/continents/view/MainView.fxml")));
        Scene scene = new Scene(root, 500, 500);
        primaryStage.setTitle("Explorateur de Continents");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}