package com.devfolio.continents;

public class ContinentService {

    /**
     * Retourne la description textuelle d'un continent selon son nom.
     */
    public static String getDescription(String continent) {
        switch (continent) {
            case "Afrique":
                return "L'Afrique est le deuxième plus grand continent, riche en diversité culturelle et naturelle.";
            case "Europe":
                return "L'Europe est connue pour son histoire, ses institutions et sa diversité linguistique.";
            case "Asie":
                return "L'Asie est le plus grand continent, abritant des civilisations anciennes et des économies modernes.";
            case "Amérique":
                return "L'Amérique regroupe le Nord, le Sud et le Centre, avec une grande variété de paysages et cultures.";
            case "Océanie":
                return "L'Océanie est composée d'îles et d'archipels, avec une biodiversité unique.";
            default:
                return "Continent inconnu.";
        }
    }

    /**
     * Retourne un objet ContinentType en fonction d'un index numérique.
     * @param index entier entre 1 et 7
     * @return ContinentType correspondant ou null si hors plage
     */
    public ContinentType getContinentByIndex(int index) {
        switch (index) {
            case 1: return ContinentType. AFRICA;
            case 2: return ContinentType.EUROPE;
            case 3: return ContinentType.ASIA;
            case 4: return ContinentType.NORTH_AMERICA;
            case 5: return ContinentType.AUSTRALIA;
            case 6: return ContinentType. ANTARCTICA;
            case 7: return ContinentType. SOUTH_AMERICA;
            default: return null;
        }
    }
}