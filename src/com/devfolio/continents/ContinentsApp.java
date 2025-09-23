package com.devfolio.continents;

import java.util.Scanner;

/**
 * Application console interactive permettant à l'utilisateur de découvrir un continent
 * et sa plus grande ville en fonction d'un chiffre saisi. L'utilisateur peut ajouter une note,
 * et relancer l'exploration autant de fois qu'il le souhaite.
 */
public class ContinentsApp {



    // Méthode principale appelée depuis Main.java
    public static void run() {
        ContinentService continentService = new ContinentService();
        Scanner scanner = new Scanner(System.in);
        NoteManager noteManager = new NoteManager(); // Gestionnaire de notes
        UIManager ui = new UIManager();              // Gestionnaire d'affichage

        boolean continueExploration = true;

        // Boucle principale : permet à l'utilisateur de relancer l'exploration
        while (continueExploration) {
            ui.displayBanner();

            System.out.print("Veuillez entrer un chiffre entre 1 et 7 pour choisir un continent : ");

            // Vérification que l'entrée est bien un entier
            if (!scanner.hasNextInt()) {
                ui.displayInvalidInputMessage();
                scanner.nextLine(); // Nettoyer l'entrée
                continue;
            }

            int index = scanner.nextInt();
            scanner.nextLine(); // Consommer le retour à la ligne

            // Récupération du continent via l'enum
            ContinentType continent = continentService.getContinentByIndex(index);

            if (continent == null) {
                ui.displayOutOfRangeMessage();
                continue;
            }

            // Affichage du continent stylisé
            System.out.println(continent.getFormattedDisplay());

            // Proposition d'ajouter une note
            System.out.print("Souhaitez-vous ajouter une note ou un commentaire ? (oui/non) : ");
            String response = scanner.nextLine();

            if (response.equalsIgnoreCase("oui")) {
                System.out.print("Entrez votre note : ");
                String note = scanner.nextLine();
                noteManager.addNote(note); // Ajout via NoteManager
                ui.displayNoteSavedMessage();
            }

            // Proposition de relancer
            System.out.print("Voulez-vous explorer un autre continent ? (oui/non) : ");
            String restart = scanner.nextLine();
            continueExploration = restart.equalsIgnoreCase("oui");
        }

        // Affichage des notes enregistrées via NoteManager
        if (noteManager.hasNotes()) {
            noteManager.displayNotes();

            // Proposition d'export CSV
            System.out.print("\nSouhaitez-vous exporter vos notes au format CSV ? (oui/non) : ");
            String exportResponse = scanner.nextLine();

            if (exportResponse.equalsIgnoreCase("oui")) {
                noteManager.exportToCSV("notes.csv");
            }

        }

        ui.displayGoodbyeMessage();
        scanner.close();
    }
}