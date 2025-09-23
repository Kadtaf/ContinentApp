package com.devfolio.continents.controller;

import com.devfolio.continents.model.ContinentType;
import com.devfolio.continents.model.NoteManager;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;

public class MainController {

    @FXML private Label welcomeLabel;
    @FXML private ComboBox<ContinentType> continentSelector;
    @FXML private TextArea infoArea;
    @FXML private TextField noteField;
    @FXML private ListView<String> noteList;
    @FXML private Button showInfoButton;
    @FXML private Button addNoteButton;
    @FXML private Button exportButton;
    @FXML private HBox legendBox;

    private final NoteManager noteManager = new NoteManager();

    @FXML
    public void initialize() {
        // Remplir le ComboBox avec les continents
        continentSelector.getItems().addAll(ContinentType.values());

        // Créer la légende colorée
        for (ContinentType continent : ContinentType.values()) {
            Label legendLabel = new Label(continent.getName());
            legendLabel.setStyle("-fx-text-fill: " + continent.getColor() + "; -fx-font-weight: bold;");
            legendBox.getChildren().add(legendLabel);
        }

        // Bouton "Afficher les infos"
        showInfoButton.setOnAction(e -> {
            ContinentType selected = continentSelector.getValue();
            if (selected != null) {
                infoArea.setText(selected.getName() + ": " + selected.getCity());
                infoArea.setStyle("-fx-text-fill: " + selected.getCssColor() + ";");
            } else {
                infoArea.setText("Veuillez sélectionner un continent.");
            }
        });

        // Bouton "Ajouter la note"
        addNoteButton.setOnAction(e -> {
            String note = noteField.getText();
            if (!note.isEmpty()) {
                noteManager.addNote(note);
                noteList.getItems().add(note);
                noteField.clear();
            }
        });

        // Bouton "Exporter en CSV"
        exportButton.setOnAction(e -> noteManager.exportToCSV("notes.csv"));
    }
}