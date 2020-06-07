package practice;

import org.junit.jupiter.api.Test;
import practice.HashTables.HashTableDH;

import static org.junit.jupiter.api.Assertions.*;

public class HashTableDHTest {
    @Test
    public void testExample() {
        HashTableDH tab = new HashTableDH(1);
        assertTrue(tab.put("apple", "juice"));
        assertEquals("juice", tab.get("apple"));
        assertEquals(true, tab.remove("apple"));
        assertEquals(null, tab.table[0].getKey());
        assertEquals(null, tab.table[0].getValue());
        assertEquals(null, tab.get("apple"));
    }

    @Test
    public void testComplex() {
        HashTableDH tab = new HashTableDH(7);
        assertTrue(tab.put("L", "76"));
        assertTrue(tab.put("]", "93"));
        assertTrue(tab.put("(", "40"));
        assertTrue(tab.put("/", "47"));
        assertTrue(tab.put("\n", "10"));
        assertTrue(tab.put("7", "55"));
        for(int i = 0; i < 7; i++) {
            if(tab.table[i] != null) {
                System.out.println(i + " value: " + tab.table[i].value);
            }
        }
//        assertEquals("juice", tab.get("apple"));
//        assertEquals(true, tab.remove("apple"));
//        assertEquals(null, tab.myTable[0].getKey());
//        assertEquals(null, tab.myTable[0].getValue());
//        assertEquals(null, tab.get("apple"));
    }

    @Test
    public void testIllegalArgument() {
        try {
            new HashTableDH(0);
        } catch (IllegalArgumentException e1) {
            try {
                new HashTableDH(-42);
            } catch (IllegalArgumentException e2) {
                return;
            }
        }
        fail();
    }
}
