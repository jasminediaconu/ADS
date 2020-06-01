package tests;

import exam.IndexSort.IndexSort;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IndexSortTest {
    @Test
    public void testExample() {
        String[] arr = { "a", "d", "b", "c" };
        int[] res = IndexSort.indexSort(arr);
        int[] expected = { 0, 2, 3, 1 };
        assertArrayEquals(expected, res);
    }

    @Test
    public void testNull() {
        String[] arr = null;
        int[] res = IndexSort.indexSort(arr);
        assertNull(res);
    }

    @Test
    public void testEmpty() {
        String[] arr = {};
        int[] res = IndexSort.indexSort(arr);
        int[] expected = {};
        assertArrayEquals(expected, res);
    }

    @Test
    public void testExample2() {
        String[] arr = { "a", "d", "b", "c" };
        int[] res = IndexSort.mergeSort(arr);
        int[] expected = { 0, 2, 3, 1 };
        assertArrayEquals(expected, res);
    }
}
