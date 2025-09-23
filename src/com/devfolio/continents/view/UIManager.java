package com.devfolio.continents.view;

/**
 * Classe responsable de l'affichage console de l'application
 * Elle centralise les messages, bannières et styles pour faciliter la maintenance
 */

public class UIManager {

    // Affiche la bannière d'accueil
    public void displayBanner() {
        System.out.println("\n==============================================================");
        System.out.println("🌍 Bienvenue dans l'explorateur de continents !");
        System.out.println("=================================================================");
    }

    // Affiche un message d'erreur pour une entrée invalid
    public  void displayInvalidInputMessage() {
        System.out.println("❌ Entrée invalide. Veuillez saisir un chiffre entre 1 et 7.");
    }

    // Affiche un message d'erreur pour un chiffre hors plage
    public void displayOutOfRangeMessage() {
        System.out.println("⚠️ Le chiffre doit être compris entre 1 et 7.");
    }

    // Affiche un message de confirmation d'enregistrement de note
    public void displayNoteSavedMessage() {
        System.out.println("📝 Note enregistrée !");
    }

    // Affiche le message de fin
    public void displayGoodbyeMessage() {
        System.out.println("\n🌟 Merci d'avoir utilisé l'explorateur de continents !");
    }

}
