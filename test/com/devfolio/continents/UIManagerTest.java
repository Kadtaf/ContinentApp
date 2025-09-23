package com.devfolio.continents;

import com.devfolio.continents.view.UIManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests unitaires pour la classe UIManager.
 * On capture le flux System.out pour vérifier les messages affichés.
 */
public class UIManagerTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    public void testDisplayBanner() {
        UIManager ui = new UIManager();
        ui.displayBanner();
        String output = outputStream.toString();

        assertTrue(output.contains("Bienvenue dans l'explorateur de continents"));
        assertTrue(output.contains("=========================================="));
    }

    @Test
    public void testDisplayInvalidInputMessage() {
        UIManager ui = new UIManager();
        ui.displayInvalidInputMessage();
        String output = outputStream.toString();

        assertTrue(output.contains("Entrée invalide"));
    }

    @Test
    public void testDisplayNoteSavedMessage() {
        UIManager ui = new UIManager();
        ui.displayNoteSavedMessage();
        String output = outputStream.toString();

        assertTrue(output.contains("Note enregistrée"));
    }

    @Test
    public void testDisplayGoodbyeMessage() {
        UIManager ui = new UIManager();
        ui.displayGoodbyeMessage();
        String output = outputStream.toString();

        assertTrue(output.contains("Merci d'avoir utilisé"));
    }
}