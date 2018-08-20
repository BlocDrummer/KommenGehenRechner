package com.example.phili.kommengehenrechner;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ArbeitszeitUtilTest {
    @Test
    public void testAbrunden() {
        assertEquals(0, ArbeitszeitUtil.abrunden(0));
        assertEquals(0, ArbeitszeitUtil.abrunden(1));
        assertEquals(0, ArbeitszeitUtil.abrunden(2));
        assertEquals(0, ArbeitszeitUtil.abrunden(3));
        assertEquals(0, ArbeitszeitUtil.abrunden(4));
        assertEquals(5, ArbeitszeitUtil.abrunden(5));
        assertEquals(5, ArbeitszeitUtil.abrunden(6));
        assertEquals(5, ArbeitszeitUtil.abrunden(7));
        assertEquals(5, ArbeitszeitUtil.abrunden(8));
        assertEquals(5, ArbeitszeitUtil.abrunden(9));
        assertEquals(10, ArbeitszeitUtil.abrunden(10));
    }

    @Test
    public void testAufrunden() {
        assertEquals(0, ArbeitszeitUtil.aufrunden(0));
        assertEquals(5, ArbeitszeitUtil.aufrunden(1));
        assertEquals(5, ArbeitszeitUtil.aufrunden(2));
        assertEquals(5, ArbeitszeitUtil.aufrunden(3));
        assertEquals(5, ArbeitszeitUtil.aufrunden(4));
        assertEquals(5, ArbeitszeitUtil.aufrunden(5));
        assertEquals(10, ArbeitszeitUtil.aufrunden(6));
        assertEquals(10, ArbeitszeitUtil.aufrunden(7));
    }
}