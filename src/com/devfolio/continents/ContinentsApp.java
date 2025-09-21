package com.devfolio.continents;

import java.util.Scanner;

/**
 * Ce programme affiche un continent et sa plus grande ville en fonction d'une valeur entière.
 * Il permet à l'utilisateur de saisir un chiffre, d'ajouter une note, et affiche le résultat avec style.
 */
public class ContinentsApp {

    public static void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("🌍 Bienvenue dans l'explorateur de continents !");
        System.out.print("Veuillez entrer un chiffre entre 1 et 7 pour choisir un continent : ");

        if (!scanner.hasNextInt()) {
            System.out.println("⚠️ Aucune entrée détectée. Veuillez relancer le programme et entrer un chiffre.");
            return;
        }

        int continent = scanner.nextInt();
        scanner.nextLine(); // Consommer le retour à la ligne

        String result = getContinentInfo(continent);
        System.out.println(result);

        System.out.print("Souhaitez-vous ajouter une note ou un commentaire ? (oui/non) : ");
        String response = scanner.nextLine();

        if (response.equalsIgnoreCase("oui")) {
            System.out.print("Entrez votre note : ");
            String note = scanner.nextLine();
            System.out.println("📝 Note enregistrée : " + note);
        }

        System.out.println("Merci d'avoir utilisé le programme !");
        scanner.close();
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