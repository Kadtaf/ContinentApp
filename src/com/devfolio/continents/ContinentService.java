package com.devfolio.continents;

/**
 * Service métier pour la gestion des continents.
 */
public class ContinentService {

    /**
     * Récupère un continent à partir d'un index utilisateur.
     * @param index entier entre 1 et 7
     * @return le continent correspondant ou null si invalide
     */
    public ContinentType getContinentByIndex(int index) {
        return ContinentType.fromIndex(index);
    }

    /**
     * Vérifie si l'index est valide (entre 1 et 7).
     * @param index entier saisi par l'utilisateur
     * @return true si l'index est dans la plage autorisée
     */
    public boolean isValidIndex(int index) {
        return getContinentByIndex(index) != null;
    }

    /**
     * Retourne l'affichage formaté d'un continent.
     * @param continent continent à afficher
     * @return chaîne stylisée avec nom et ville
     */
    public String getFormattedDisplay(ContinentType continent) {
        return continent.getFormattedDisplay();
    }
}