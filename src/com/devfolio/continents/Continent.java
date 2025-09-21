package com.devfolio.continents;

/**
 * Représente un continent avec son nom, sa ville principale et sa couleur ANSI.
 */

public class Continent {
    private final String name;
    private final String city;
    private final String color;

    public Continent(String name, String city, String color) {
        this.name = name;
        this.city = city;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getColor() {
        return color;
    }

    /**
     * Retourne une chaîne stylisée avec le nom du continent et sa ville.
     */
    public String getDisplay() {
        return color + name + "; " + city + "\u001B[0m";

    }
}
