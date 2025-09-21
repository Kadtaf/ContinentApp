package com.devfolio.continents;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Application console interactive permettant à l'utilisateur de découvrir un continent
 * et sa plus grande ville en fonction d'un chiffre saisi. L'utilisateur peut ajouter une note,
 * et relancer l'exploration autant de fois qu'il le souhaite.
 */
public class ContinentsApp {

    // Méthode principale appelée depuis Main.java
    public static void run() {
        Scanner scanner = new Scanner(System.in);
        List<String> notes = new ArrayList<>(); // Liste pour stocker les notes utilisateur

        boolean continueExploration = true;

        // Boucle principale : permet à l'utilisateur de relancer l'exploration
        while (continueExploration) {
            displayBanner();

            System.out.print("Veuillez entrer un chiffre entre 1 et 7 pour choisir un continent : ");

            // Vérification que l'entrée est bien un entier
            if (!scanner.hasNextInt()) {
                System.out.println("❌ Entrée invalide. Veuillez saisir un chiffre entre 1 et 7.");
                scanner.nextLine(); // Nettoyer l'entrée
                continue;
            }

            int index = scanner.nextInt();
            scanner.nextLine(); // Consommer le retour à la ligne

            // Récupération du continent via l'enum
            ContinentType continent = ContinentType.fromIndex(index);

            if (continent == null) {
                System.out.println("⚠️ Le chiffre doit être compris entre 1 et 7.");
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
                notes.add(note); // Ajout à la liste
                System.out.println("📝 Note enregistrée !");
            }

            // Proposition de relancer
            System.out.print("Voulez-vous explorer un autre continent ? (oui/non) : ");
            String restart = scanner.nextLine();
            continueExploration = restart.equalsIgnoreCase("oui");
        }

        // Affichage des notes enregistrées
        if (!notes.isEmpty()) {
            System.out.println("\n📚 Vos notes enregistrées :");
            for (int i = 0; i < notes.size(); i++) {
                System.out.println("  " + (i + 1) + ". " + notes.get(i));
            }
        }

        System.out.println("\n🌟 Merci d'avoir utilisé l'explorateur de continents !");
        scanner.close();
    }

    /**
     * Affiche une bannière stylisée en début de session.
     */
    private static void displayBanner() {
        System.out.println("\n=============================================");
        System.out.println("🌍 Bienvenue dans l'explorateur de continents !");
        System.out.println("================================================");
    }
}