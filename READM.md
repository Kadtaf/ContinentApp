# 🌍 Explorateur de Continents — JavaFX MVC

# Application JavaFX modulaire permettant d’explorer les continents du monde, d’afficher des informations clés, de prendre des notes, et d’exporter en CSV. Conçue avec une architecture MVC claire, une interface stylisée en FXML/CSS, et des tests unitaires pour garantir la fiabilité.

---

##  Structure du projet
# src/ └── com/devfolio/continents/ ├── model/ 
                                    ├── view/
                                    ├── controller/
                                            └── ContinentsAppFX.java
# Logique métier (ContinentType, NoteManager, etc.)          
# Interface utilisateur (MainView.fxml, style.css)     
# Contrôleur JavaFX (MainController.java)   
# Point d’entrée JavaFX


---

##  Fonctionnalités

# Sélection d’un continent via `ComboBox`
# Affichage de la ville principale et couleur associée
# Ajout de notes personnalisées
# Liste des notes enregistrées
# Export des notes au format CSV
# Légende colorée des continents
# Interface stylisée avec CSS
# Architecture MVC + FXML
# Tests unitaires sur le modèle

---

## 🎮 Lancement de l’application

### Prérequis :
# Java 21+
# JavaFX SDK 21+
# IntelliJ IDEA (ou autre IDE compatible)

### Commande :
```bash
# java --module-path /chemin/javafx-sdk/lib --add-modules javafx.controls,javafx.fxml -jar ContinentsAppFX.jar

# Tests unitaires
# Les classes du modèle (NoteManager, ContinentService, etc.) sont testées avec JUnit 5. Les fichiers de test sont situés dans le dossier test/

# Interface
# Fichier FXML : MainView.fxml
# Feuille de style : style.css
# Composants centrés, espacés, et stylisés
# Légende colorée dynamique en bas de l’interface

# 📁 Export CSV
# Les notes sont exportées dans un fichier notes.csv au format 
# Note
# Ma première note
# Une autre idée