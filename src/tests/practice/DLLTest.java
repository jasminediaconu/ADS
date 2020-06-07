package practice;

import org.junit.jupiter.api.Test;
import practice.DLL.DLL;

import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class DLLTest {
    @Test
    public void testNull() {
        LinkedList<Integer> list = null;
        DLL.selectionSort(list);
        assertNull(list);
    }

    @Test
    public void testEmpty() {
        LinkedList<Integer> list = new LinkedList<>();
        DLL.selectionSort(list);
        assertEquals(0, list.size());
    }

    @Test
    public void testExample() {
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(100, 30, 344, 12, 29));
        LinkedList<Integer> res = new LinkedList<>(Arrays.asList(12, 29, 30, 100, 344));
        DLL.selectionSort(list);
        assertEquals(res, list);
    }

    @Test
    public void testDuplicates() {
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(0, 10, 3, 0, 9, 0, 3));
        LinkedList<Integer> res = new LinkedList<>(Arrays.asList(0, 0, 0, 3, 3, 9, 10));
        DLL.insertionSort(list);
        assertEquals(res, list);
    }

    @Test
    public void testNull2() {
        LinkedList<Integer> list = null;
        DLL.insertionSort(list);
        assertNull(list);
    }

    @Test
    public void testEmpty2() {
        LinkedList<Integer> list = new LinkedList<>();
        DLL.insertionSort(list);
        assertEquals(0, list.size());
    }

    @Test
    public void testExample2() {
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(100, 30, 344, 12, 29));
        LinkedList<Integer> res = new LinkedList<>(Arrays.asList(12, 29, 30, 100, 344));
        DLL.insertionSort(list);
        assertEquals(res, list);
    }

    @Test
    public void testDuplicates2() {
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(0, 10, 3, 0, 9, 0, 3));
        LinkedList<Integer> res = new LinkedList<>(Arrays.asList(0, 0, 0, 3, 3, 9, 10));
        DLL.insertionSort(list);
        assertEquals(res, list);
    }
}
