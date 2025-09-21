package com.devfolio.continents;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsable de la gestion des notes utilisateurs.
 * Elle permet d'ajouter des notes, de les stocker et de les afficher.
 */

public class NoteManager {

    private final List<String> notes;

    //Constructeur : iliyialise la liste des notes
    public NoteManager() {
        this.notes = new ArrayList<>();
    }

    // Ajoute une note à la liste
    public void addNote(String note) {
        notes.add(note);
    }

    // Vérifie si des notes ont été enregistrées
    public boolean hasNotes() {
        return !notes.isEmpty();
    }

    // Affiche toutes les notes enregistrées
    public void displayNotes() {
        System.out.println("\n📚 Vos notes enregistrées :");
        for (int i = 0; i < notes.size(); i++) {
            System.out.println(" " + (i + 1) + " . " + notes.get(i));
        }
    }

    // Retourne la liste des notes (utile pour tests ou export)
    public List<String> getNotes() {
        return notes;
    }

}
