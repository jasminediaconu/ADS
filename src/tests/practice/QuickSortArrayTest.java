package practice;

import org.junit.jupiter.api.Test;
import practice.QuickSort.QuickSortInPlaceArray;

import static org.junit.jupiter.api.Assertions.assertNull;

public class QuickSortArrayTest {
    @Test
    public void emptyArray() {
        int[] arr = null;
        QuickSortInPlaceArray.sortElements(arr, 0, 0);
        assertNull(arr);
    }

    @Test
    public void oneElementArray() {
        int[] arr = {10};
        QuickSortInPlaceArray.sortElements(arr, 0, arr.length - 1);
        int[] result = {10};
        result.equals(arr);
    }

    @Test
    public void multipleElementsArray() {
        int[] arr = {10, 3, 5, 6, 0, 1, 4};
        QuickSortInPlaceArray.sortElements(arr, 0, arr.length - 1);
        int[] result = {0, 1, 3, 4, 5, 6, 10};
        result.equals(arr);
    }

    @Test
    public void multipleElementsArray2() {
        int[] arr = {24, 63, 85, 45, 31, 17, 50, 96};
        QuickSortInPlaceArray.sortElements(arr, 0, arr.length - 1);
        int[] result = {17, 24, 31, 45, 50, 63, 85, 96};
        result.equals(arr);
    }

    @Test
    public void emptyArrayInPlace() {
        int[] arr = null;
        QuickSortInPlaceArray.sortElements(arr, 0, 0);
        assertNull(arr);
    }

    @Test
    public void oneElementArrayInPlace() {
        int[] arr = {10};
        QuickSortInPlaceArray.sortElements(arr, 0, arr.length - 1);
        int[] result = {10};
        result.equals(arr);
    }

    @Test
    public void multipleElementsArrayInPlace() {
        int[] arr = {10, 3, 5, 6, 0, 1, 4};
        QuickSortInPlaceArray.sortElements(arr, 0, arr.length - 1);
        int[] result = {0, 1, 3, 4, 5, 6, 10};
        result.equals(arr);
    }

    @Test
    public void multipleElementsArrayInPlace2() {
        int[] arr = {24, 63, 85, 45, 31, 17, 50, 96};
        QuickSortInPlaceArray.sortElements(arr, 0, arr.length - 1);
        int[] result = {17, 24, 31, 45, 50, 63, 85, 96};
        result.equals(arr);
    }
}

