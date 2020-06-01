package exam;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IndexSortTest {
    @Test
    public void testSort() {
        // Index Sort
        String[] arr = { "a", "d", "b", "c" };
        int[] res = IndexSort.indexSort(arr);
        int[] expected = { 0, 2, 3, 1 };
        assertArrayEquals(expected, res);

        // BubbleSort
        String[] arrBubble = { "a", "d", "b", "c" };
        int[] resBubble = IndexSort.bubbleSort(arrBubble);
        int[] expectedBubble = { 0, 2, 3, 1 };
        assertArrayEquals(expectedBubble, resBubble);

        // InsertionSort
        String[] arrInsertion = { "a", "d", "b", "c" };
        int[] resInsertion = IndexSort.insertionSort(arrInsertion);
        int[] expectedInsertion = { 0, 2, 3, 1 };
        assertArrayEquals(expectedInsertion, resInsertion);

        // SelectionSort
        String[] arrSelection = { "a", "d", "b", "c" };
        int[] resSelection = IndexSort.selectionSort(arrSelection);
        int[] expectedSelection = { 0, 2, 3, 1 };
        assertArrayEquals(expectedSelection, resSelection);

        // QuickSort
        String[] arrQuick = { "a", "d", "b", "c" };
        int[] resQuick = IndexSort.quickSort(arrQuick);
        int[] expectedQuick = { 0, 2, 3, 1 };
        assertArrayEquals(expectedQuick, resQuick);

        // MergeSort
        String[] arrMerge = { "a", "d", "b", "c" };
        int[] resMerge = IndexSort.mergeSort(arrMerge);
        int[] expectedMerge = { 0, 2, 3, 1 };
        assertArrayEquals(expectedMerge, resMerge);

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
}
