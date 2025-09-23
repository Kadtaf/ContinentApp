package com.devfolio.continents;

import com.devfolio.continents.model.ContinentType;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests unitaires pour l'enum ContinentType.
 */
public class ContinentTypeTest {

    @Test
    public void testFromIndexValid() {
        ContinentType continent = ContinentType.fromIndex(1);
        assertEquals(ContinentType.NORTH_AMERICA, continent);
    }

    @Test
    public void testFromIndexInvalidLow() {
        ContinentType continent = ContinentType.fromIndex(0);
        assertNull(continent);
    }

    @Test
    public void testFromIndexInvalidHigh() {
        ContinentType continent = ContinentType.fromIndex(8);
        assertNull(continent);
    }

    @Test
    public void testFormattedDisplay() {
        String display = ContinentType.AFRICA.getFormattedDisplay();
        assertTrue(display.contains("Africa"));
        assertTrue(display.contains("Lagos"));
    }
}