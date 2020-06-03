package practice;

import org.junit.jupiter.api.Test;
import practice.MergeSort.MergeSortInPlaceSLL;
import practice.MergeSort.MergeSortQueue;
import practice.MergeSort.Node;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class MergeSortQueueTest {

    @Test
    public void emptyQueue() {
        Queue<Integer> queue = null;
        MergeSortQueue.mergeSort(queue);
        assertNull(queue);
    }

    @Test
    public void oneElementQueue() {
        Queue<Integer> queue = new LinkedList<Integer>(Arrays.asList(10));
        MergeSortQueue.mergeSort(queue);
        Queue<Integer> result = new LinkedList<>(Arrays.asList(10));
        assertEquals(result, queue);
    }

    @Test
    public void multipleElementsQueue() {
        Queue<Integer> queue = new LinkedList<Integer>(Arrays.asList(10, 3, 5, 6, 0, 1, 4));
        MergeSortQueue.mergeSort(queue);
        Queue<Integer> result = new LinkedList<>(Arrays.asList(0, 1, 3, 4, 5, 6, 10));
        assertEquals(result, queue);
    }

    @Test
    public void multipleElementsQueue2() {
        Queue<Integer> queue = new LinkedList<Integer>(Arrays.asList(24, 63, 85, 45, 31, 17, 50, 96));
        MergeSortQueue.mergeSort(queue);
        Queue<Integer> result = new LinkedList<>(Arrays.asList(17, 24, 31, 45, 50, 63, 85, 96));
        assertEquals(result, queue);
    }

    @Test
    public void emptyList() {
        Node head = null;
        MergeSortInPlaceSLL.mergeSort(head);
        assertNull(head);
    }

    @Test
    public void oneElementList() {
        Node head = new Node(10, null);
        MergeSortInPlaceSLL.mergeSort(head);
        Node result = new Node(10, null);
        head.equals(result);
    }

    @Test
    public void multipleElementsList() {
        int[] array = {10, 3, 5, 6, 0, 1, 4};
        Node head = null;
        for (int key : array) {
            head = new Node(key, head);
        }

        MergeSortInPlaceSLL.mergeSort(head);

        int[] sorted = {0, 1, 3, 4, 5, 6, 10};
        Node result = null;
        for (int key : sorted) {
            result = new Node(key, result);
        }

        head.equals(result);

    }

    @Test
    public void multipleElementsList2() {

        int[] array = {24, 63, 85, 45, 31, 17, 50, 96};
        Node head = null;
        for (int key : array) {
            head = new Node(key, head);
        }

        MergeSortInPlaceSLL.mergeSort(head);

        int[] sorted = {17, 24, 31, 45, 50, 63, 85, 96};
        Node result = null;
        for (int key : sorted) {
            result = new Node(key, result);
        }

        head.equals(result);
    }
}
