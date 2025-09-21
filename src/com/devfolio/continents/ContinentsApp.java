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

        boolean continuer = true;

        // Boucle principale : permet à l'utilisateur de relancer l'exploration
        while (continuer) {
            afficherBanniere();

            System.out.print("Veuillez entrer un chiffre entre 1 et 7 pour choisir un continent : ");

            // Vérification que l'entrée est bien un entier
            if (!scanner.hasNextInt()) {
                System.out.println("❌ Entrée invalide. Veuillez saisir un chiffre entre 1 et 7.");
                scanner.nextLine(); // Nettoyer l'entrée
                continue;
            }

            int continent = scanner.nextInt();
            scanner.nextLine(); // Consommer le retour à la ligne

            // Validation stricte de la plage de chiffres
            if (continent < 1 || continent > 7) {
                System.out.println("⚠️ Le chiffre doit être compris entre 1 et 7.");
                continue;
            }

            // Affichage du continent correspondant
            String result = getContinentInfo(continent);
            System.out.println(result);

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
            String relancer = scanner.nextLine();
            continuer = relancer.equalsIgnoreCase("oui");
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
    private static void afficherBanniere() {
        System.out.println("\n=================================================");
        System.out.println("🌍 Bienvenue dans l'explorateur de continents !");
        System.out.println("=================================================");
    }

    /**
     * Retourne une chaîne contenant le continent et sa plus grande ville.
     * @param continent Le numéro du continent (1 à 7)
     * @return Une chaîne formatée avec le nom du continent et sa ville principale
     */
    public static String getContinentInfo(int continent) {
        return switch (continent) {
            case 1 -> "\u001B[34mNorth America: Mexico City, Mexico\u001B[0m";
            case 2 -> "\u001B[32mSouth America: Sao Paulo, Brazil\u001B[0m";
            case 3 -> "\u001B[35mEurope: Moscow, Russia\u001B[0m";
            case 4 -> "\u001B[33mAfrica: Lagos, Nigeria\u001B[0m";
            case 5 -> "\u001B[36mAsia: Shanghai, China\u001B[0m";
            case 6 -> "\u001B[31mAustralia: Sydney, Australia\u001B[0m";
            case 7 -> "\u001B[37mAntarctica: McMurdo Station, US\u001B[0m";
            default -> "\u001B[41mUndefined continent!\u001B[0m";
        };
    }
}