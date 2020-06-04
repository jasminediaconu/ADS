package practice;

import org.junit.jupiter.api.Test;
import practice.MergeSort.MergeSortArray;
import practice.MergeSort.MergeSortInPlaceArray;
import practice.MergeSort.MergeSortNonRecursive;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class MergeSortArrayTest {

    @Test
    public void emptyArrayInPlace() {
        int[] arr = null;
        MergeSortInPlaceArray.mergeSort(arr, 0, 0);
        assertNull(arr);
    }

    @Test
    public void oneElementArrayInPlace() {
        int[] arr = {10};
        MergeSortInPlaceArray.mergeSort(arr, 0, arr.length - 1);
        int[] result = {10};
        result.equals(arr);
    }

    @Test
    public void multipleElementsArrayInPlace() {
        int[] arr = {10, 3, 5, 6, 0, 1, 4};
        MergeSortInPlaceArray.mergeSort(arr, 0, arr.length - 1);
        int[] result = {0, 1, 3, 4, 5, 6, 10};
        result.equals(arr);
    }

    @Test
    public void multipleElementsArrayInPlace2() {
        int[] arr = {24, 63, 85, 45, 31, 17, 50, 96};
        MergeSortInPlaceArray.mergeSort(arr, 0, arr.length - 1);
        int[] result = {17, 24, 31, 45, 50, 63, 85, 96};
        result.equals(arr);
    }


    @Test
    public void emptyArrayBottomUp() {
        int[] arr = null;
        MergeSortNonRecursive.mergeSortBottomUp(arr);
        assertNull(arr);
    }

    @Test
    public void oneElementArrayBottomUp() {
        int[] arr = {10};
        MergeSortNonRecursive.mergeSortBottomUp(arr);
        int[] result = {10};
        result.equals(arr);
    }

    @Test
    public void multipleElementsArrayBottomUp() {
        int[] arr = {10, 3, 5, 6, 0, 1, 4};
        MergeSortNonRecursive.mergeSortBottomUp(arr);
        int[] result = {0, 1, 3, 4, 5, 6, 10};
        result.equals(arr);
    }

    @Test
    public void multipleElementsArrayBottomUp2() {
        int[] arr = {24, 63, 85, 45, 31, 17, 50, 96};
        MergeSortNonRecursive.mergeSortBottomUp(arr);
        int[] result = {17, 24, 31, 45, 50, 63, 85, 96};
        result.equals(arr);
    }
}
