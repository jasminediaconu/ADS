package practice.MergeSort;

/**
 * Merge Sort non-inplace implementation using an Array.
 */
public class MergeSortArray {
    public static void merge(int[] res, int[] left, int[] right) {
        int i = 0;
        int j = 0;
        int k = 0;

        while (i != left.length && j != right.length) {
            if (left[i] < right[j]) {
                res[k] = left[i];
                i++;
            } else {
                res[k] = right[j];
                j++;
            }
            k++;
        }

        while (i != left.length) {
            res[k] = left[i];
            i++;
            k++;
        }

        while (j != right.length) {
            res[k] = right[j];
            j++;
            k++;
        }

    }

    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) return;

        int size = arr.length;

        int[] left = new int[size / 2];
        int[] right = new int[size - size / 2];

        for (int i = 0; i < left.length; i++) left[i] = arr[i];

        for (int j = 0; j < right.length; j++) right[j] = arr[left.length + j];

        mergeSort(left);
        mergeSort(right);
        merge(arr, left, right);
    }
}
