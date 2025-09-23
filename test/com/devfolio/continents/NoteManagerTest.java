package com.devfolio.continents;

import com.devfolio.continents.model.NoteManager;
import org.junit.jupiter.api.Test;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests unitaires pour la classe NoteManager.
 */
public class NoteManagerTest {

    @Test
    public void testAddNote() {
        NoteManager manager = new NoteManager();
        manager.addNote("Ma première note");
        assertTrue(manager.hasNotes());
    }

    @Test
    public void testGetNotes() {
        NoteManager manager = new NoteManager();
        manager.addNote("Note A");
        manager.addNote("Note B");

        List<String> notes = manager.getNotes();
        assertEquals(2, notes.size());
        assertEquals("Note A", notes.get(0));
        assertEquals("Note B", notes.get(1));
    }

    @Test
    public void testHasNotesWhenEmpty() {
        NoteManager manager = new NoteManager();
        assertFalse(manager.hasNotes());
    }

    @Test
    public void testExportToCSV() throws IOException {
        NoteManager manager = new NoteManager();
        manager.addNote("Note 1");
        manager.addNote("Note 2");

        String filename = "test_notes.csv";
        manager.exportToCSV(filename);

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            assertEquals("Note", reader.readLine());
            assertEquals("Note 1", reader.readLine());
            assertEquals("Note 2", reader.readLine());
        }
    }

}