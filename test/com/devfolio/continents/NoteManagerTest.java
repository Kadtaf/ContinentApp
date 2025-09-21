package com.devfolio.continents;

import org.junit.jupiter.api.Test;
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
}