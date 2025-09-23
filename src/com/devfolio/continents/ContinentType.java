package com.devfolio.continents;

/**
 * Enumération représentant les 7 continents avec leur ville principale et couleur ANSI.
 */
public enum ContinentType {
    NORTH_AMERICA("North America", "Mexico City, Mexico", "blue"),
    SOUTH_AMERICA("South America", "Sao Paulo, Brazil", "green"),
    EUROPE("Europe", "Moscow, Russia", "purple"),
    AFRICA("Africa", "Lagos, Nigeria", "orange"),
    ASIA("Asia", "Shanghai, China", "teal"),
    AUSTRALIA("Australia", "Sydney, Australia", "red"),
    ANTARCTICA("Antarctica", "McMurdo Station, US", "gray");

    private final String name;
    private final String city;
    private final String color;

    // Constructeur de l'enum
    ContinentType(String name, String city, String color) {
        this.name = name;
        this.city = city;
        this.color = color;
    }

    // Retourne le nom du continent
    public String getName() {
        return name;
    }

    // Retourne la ville principale
    public String getCity() {
        return city;
    }

    // Retourne la couleur ANSI
    public String getColor() {
        return color;
    }

    // Retourne une chaîne stylisée pour l'affichage
    public String getFormattedDisplay() {
        return color + name + ": " + city + "\u001B[0m";
    }

    /**
     * Méthode utilitaire pour récupérer un continent par son index (1 à 7).
     * @param index Le chiffre saisi par l'utilisateur
     * @return Le continent correspondant ou null si invalide
     */
    public static ContinentType fromIndex(int index) {
        if (index < 1 || index > values().length) {
            return null;
        }
        return values()[index - 1];
    }

    /**
     * Méthode utilitaire pour appliquer des couleurs
     * @return la couleur correspondante au continent
     */
    public String getCssColor() {
        return color;
    }


}
