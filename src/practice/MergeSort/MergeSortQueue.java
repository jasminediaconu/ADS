package practice.MergeSort;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Merge Sort non-implace implementation using a LinkedQueue.
 */
public class MergeSortQueue {

    public static void merge(Queue<Integer> left, Queue<Integer> right, Queue<Integer> result) {
        while (!left.isEmpty() && !right.isEmpty()) {
            if (left.peek() < right.peek()) result.add(left.remove());
            else result.add(right.remove());
        }

        while (!left.isEmpty()) result.add(left.remove());
        while (!right.isEmpty()) result.add(right.remove());
    }

    public static void mergeSort(Queue<Integer> input) {
        int size = input.size();

        if (input == null || size < 2) return;

        Queue<Integer> left = new LinkedList<>();
        Queue<Integer> right = new LinkedList<>();

        while (left.size() != size / 2) left.add(input.remove());
        while (!input.isEmpty()) right.add(input.remove());

        mergeSort(left);
        mergeSort(right);

        merge(left, right, input);
    }
}
