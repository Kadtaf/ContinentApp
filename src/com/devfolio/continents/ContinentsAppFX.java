package com.devfolio.continents;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ContinentsAppFX extends Application {

    private final NoteManager noteManager = new NoteManager();

    @Override
    public void start(Stage primaryStage) {
        Label welcomeLabel = new Label("🌍 Bienvenue dans l'explorateur de continents");

        ComboBox<ContinentType> continentSelector = new ComboBox<>();
        continentSelector.getItems().addAll(ContinentType.values());

        TextArea infoArea = new TextArea();
        infoArea.setEditable(false);
        infoArea.setWrapText(true);

        TextField noteField = new TextField();
        noteField.setPromptText("Ajouter une note...");

        ListView<String> noteList = new ListView<>();
        noteList.setPrefHeight(100);

        Button showInfoButton = new Button("Afficher les infos");
        Button addNoteButton = new Button("Ajouter la note");
        Button exportButton = new Button("Exporter en CSV");

        showInfoButton.setOnAction(e -> {
            ContinentType selected = continentSelector.getValue();
            if (selected != null) {
                infoArea.setText(selected.getName() + ": " + selected.getCity());
                infoArea.setStyle("-fx-text-fill: " + selected.getCssColor() + ";");
            } else {
                infoArea.setText("Veuillez sélectionner un continent.");
            }
        });

        addNoteButton.setOnAction(e -> {
            String note = noteField.getText();
            if (!note.isEmpty()) {
                noteManager.addNote(note);
                noteList.getItems().add(note);
                noteField.clear();
            }
        });

        exportButton.setOnAction(e -> {
            noteManager.exportToCSV("notes.csv");
        });

        HBox legendBox = new HBox(10);
        for (ContinentType continent : ContinentType.values()) {
            Label legendLabel = new Label(continent.getName());
            legendLabel.setStyle("-fx-text-fill: " + continent.getColor() + "; -fx-font-weight: bold;");
            legendBox.getChildren().add(legendLabel);
        }

        VBox root = new VBox(10, welcomeLabel, continentSelector, showInfoButton, infoArea,
                noteField, addNoteButton, noteList, exportButton, legendBox);
        root.setStyle("-fx-padding: 20; -fx-font-size: 14px;");

        Scene scene = new Scene(root, 500, 500);
        primaryStage.setTitle("Explorateur de Continents");
        primaryStage.setScene(scene);
        primaryStage.show();

        showInfoButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
        addNoteButton.setStyle("-fx-background-color: #2196F3; -fx-text-fill: white;");
        exportButton.setStyle("-fx-background-color: #FF9800; -fx-text-fill: white;");


    }



    public static void main(String[] args) {

        launch(args);
    }
}