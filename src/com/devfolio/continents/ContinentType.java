package com.devfolio.continents;

/**
 * Enumération représentant les 7 continents avec leur ville principale et couleur ANSI.
 */
public enum ContinentType {
    NORTH_AMERICA("North America", "Mexico City, Mexico", "\u001B[34m"),
    SOUTH_AMERICA("South America", "Sao Paulo, Brazil", "\u001B[32m"),
    EUROPE("Europe", "Moscow, Russia", "\u001B[35m"),
    AFRICA("Africa", "Lagos, Nigeria", "\u001B[33m"),
    ASIA("Asia", "Shanghai, China", "\u001B[36m"),
    AUSTRALIA("Australia", "Sydney, Australia", "\u001B[31m"),
    ANTARCTICA("Antarctica", "McMurdo Station, US", "\u001B[37m");

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


}
