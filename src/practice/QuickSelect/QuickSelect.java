package practice.QuickSelect;

import java.util.Random;

/**
 * Given a Graph g and two Vertex v, u check if there is a path between them
 * and return it.
 */
public class QuickSelect {
    public static int quickSelect(int[] array, int k) {
        if(array == null) return 0;

        return sort(array, 0, array.length-1, k-1);
    }

    public static int partition(int[] array, int left, int right, int index) {
        int pivot = left + new Random().nextInt(right - left + 1);
        swap(array, right, pivot);
        for (int i = left; i < right; i++) {
            if (array[i] > array[right]) {
                swap(array, i, left);
                left++;

            }
        }
        swap(array, left, right);
        return left;
    }

    private static void swap(int[] array, int x, int y) {
        int tmp = array[x];
        array[x] = array[y];
        array[y] = tmp;}

    public static int sort(int[] array, int left, int right, int k) {

        if (left <= right) {
            int pivot = partition(array, left, right, 1);
            if (pivot == k) return array[k];
            else if (pivot > k) return sort(array, left, pivot - 1, k);
            return sort(array, pivot + 1, right, k);
        }
        return Integer.MIN_VALUE;
    }
}
