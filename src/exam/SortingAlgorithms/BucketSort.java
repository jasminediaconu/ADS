package exam.SortingAlgorithms;

import java.lang.reflect.Array;
import java.util.*;

/**
 * First, implement the method fillBuckets() which sorts the elements from an array
 * into an array of buckets.
 * For simplicity, the input array only contains keys but no associated values.
 * The output is an array of buckets, where each bucket is represented as a Queue.
 *
 * First determine the minimum and maximum values of array and store them in variables
 * vmin and vmax. You should return an array of buckets of size vmax-vmin+1.
 * Each bucket should be represented as a Queue of values,
 * where bucket[i] stores values v = vmin + i.
 *
 * Do not implement the Queue interface yourself.
 * You can use any data structure from the Java libraries, which implement the Queue interface.
 *
 * After filling the buckets, implement the method readBuckets(),
 * which turns the buckets that you have created in fillBuckets() into a sorted array.
 */
public class BucketSort {
    @SuppressWarnings("unchecked")
    public static Queue<Integer>[] fillBuckets(int[] array) {
        //if(array == null || array.length == 0) return new Queue[0];
        int vmin = findMin(array); // 21
        int vmax = findMax(array);
        Queue<Integer>[] buckets = new Queue[vmax - vmin + 1];

        for(int i = 0; i < buckets.length; i++)
            buckets[i] = new LinkedList<>();

        for(int i = 0; i < array.length; i++) {
            int value = array[i];
            buckets[value-vmin].add(value);
        }

        return buckets;
    }

    public static int[] readBuckets(Queue<Integer>[] buckets) {
        if(buckets == null || buckets.length == 0) return new int[0];

        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i < buckets.length; i++) {
            while(!buckets[i].isEmpty()) list.add(buckets[i].remove());
        }

        int[] sorted = new int[list.size()];

        for(int j = 0; j < list.size(); j++) sorted[j] = list.get(j);

        return sorted;
    }

    public static int findMin(int[] arr) {
        if(arr == null || arr.length == 0) return 1;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] < min) min = arr[i];
        }
        return min;
    }

    public static int findMax(int[] arr) {
        if(arr == null || arr.length == 0) return 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > max) max = arr[i];
        }
        return max;
    }
}
