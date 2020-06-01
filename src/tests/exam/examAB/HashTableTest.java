package exam.examAB;

import exam.FinalB.HashTable.HashTable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HashTableTest {
    @Test
    public void testLinearProbing() {
        HashTable tab = new HashTable(1);
        assertTrue(tab.put("apple", "juice"));
        assertEquals("juice", tab.get("apple"));
        assertEquals(true, tab.remove("apple"));
        assertEquals(null, tab.table[0].getKey());
        assertEquals(null, tab.table[0].getValue());
        assertEquals(null, tab.get("apple"));
    }

    @Test
    public void testSeparateChaining() {
        exam.FinalA.HashTable tab = new exam.FinalA.HashTable(1);
        assertTrue(tab.put("apple", "juice"));
        assertEquals("juice", tab.get("apple"));
        assertEquals(true, tab.remove("apple"));
        assertEquals(null, tab.get("apple"));
    }

    @Test
    public void testIllegalArgument() {
        try {
            new HashTable(0);
        } catch (IllegalArgumentException e1) {
            try {
                new HashTable(-42);
            } catch (IllegalArgumentException e2) {
                return;
            }
        }
        try {
            new exam.FinalA.HashTable(0);
        } catch (IllegalArgumentException e1) {
            try {
                new exam.FinalA.HashTable(-42);
            } catch (IllegalArgumentException e2) {
                return;
            }
        }
        fail();
    }
}
