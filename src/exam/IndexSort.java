package exam;

/**
 * Sorts the indices of the array based on the corresponding value in alphabetical order.
 * Returns null if the input array is null.
 * <p>
 * Example: The array ["c","a","b"] will result in [1, 2, 0].
 */
public class IndexSort {

    /**
     * InsertionSort implementation (CHANGES THE INPUT ARRAY) 90/100
     *
     * @param arr array of Strings that stored the values
     * @return the indices in sorted order
     */
    public static int[] indexSort(String[] arr) {
        int res[] = new int[arr.length];
        if (arr == null || arr.length == 0) return res;

        for (int i = 0; i < arr.length; i++) res[i] = i;

        String tempLetter;
        int tempNum;

        for (int i = 1; i < arr.length; i++) {
            int j = i;

            while (j > 0 && arr[j].compareTo(arr[j - 1]) < 0) {
                tempLetter = arr[j];
                tempNum = res[j];

                arr[j] = arr[j - 1];
                res[j] = res[j - 1];

                arr[j - 1] = tempLetter;
                res[j - 1] = tempNum;

                j--;
            }
        }


        return res;
    }

    /**
     * BubbleSort implementation 90/100
     *
     * @param arr array of Strings that stored the values
     * @return the indices in sorted order
     */
    public static int[] bubbleSort(String[] arr) {
        if (arr == null) return null;
        int res[] = new int[arr.length];
        if (arr.length == 0) return res;

        for (int i = 0; i < arr.length; i++) res[i] = i;

        String tempLetter;
        int tempNum;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i].compareTo(arr[j]) > 0) {
                    tempLetter = arr[i];
                    tempNum = res[i];

                    arr[i] = arr[j];
                    res[i] = res[j];

                    arr[j] = tempLetter;
                    res[j] = tempNum;
                }
            }
        }

        return res;
    }

    /**
     * InsertionSort implementation (WITHOUT CHANGING INPUT ARRAY) 100/100
     *
     * @param arr array of Strings that stored the values
     * @return the indices in sorted order
     */
    public static int[] insertionSort(String[] arr) {
        if (arr == null) return null;
        int res[] = new int[arr.length];
        if (arr.length == 0) return res;

        for (int i = 0; i < arr.length; i++) res[i] = i;

        for (int i = 1; i < arr.length; i++) {
            int pos = 0;

            // Don't swap just increment
            while (arr[res[pos]].compareTo(arr[i]) < 0 && pos < i) {
                pos++;
            }

            for (int j = i; j > pos; j--)
                res[j] = res[j - 1];

            res[pos] = i;
        }

        return res;
    }

    /**
     * SelectionSort implementation 90/100
     *
     * @param arr array of Strings that stored the values
     * @return the indices in sorted order
     */
    public static int[] selectionSort(String[] arr) {
        if (arr == null) return null;
        int res[] = new int[arr.length];
        if (arr.length == 0) return res;

        for (int i = 0; i < arr.length; i++) res[i] = i;

        for (int i = 0; i < arr.length; i++) {
            String currentMin = arr[i];
            int min = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j].compareTo(currentMin) < 0) {
                    currentMin = arr[j];
                    min = j;
                }
            }
            if (min != i) {
                String tempLetter = arr[i];
                int tempNum = res[i];

                arr[i] = arr[min];
                res[i] = res[min];

                arr[min] = tempLetter;
                res[min] = tempNum;
            }
        }

        return res;
    }

    /**
     * QuickSort implementation 90/100
     *
     * @param arr array of Strings that stored the values
     * @return the indices in sorted order
     */
    public static int[] quickSort(String[] arr) {
        if (arr == null) return null;
        int res[] = new int[arr.length];
        if (arr.length == 0) return res;

        for (int i = 0; i < arr.length; i++) res[i] = i;

        return quickSort(arr, res, 0, res.length - 1);
    }

    public static int[] quickSort(String[] a, int[] index, int left, int right) {
        if (right <= left) return index;
        int i = partition(a, index, left, right);
        quickSort(a, index, left, i - 1);
        quickSort(a, index, i + 1, right);

        return index;
    }

    public static int partition(String[] a, int[] index, int left, int right) {
        int i = left - 1;
        int j = right;
        while (true) {
            while (a[++i].compareTo(a[right]) < 0)      // find item on left to swap
                ;                               // a[right] acts as sentinel
            while (a[right].compareTo(a[--j]) < 0)      // find item on right to swap
                if (j == left) break;           // don't go out-of-bounds
            if (i >= j) break;                  // check if pointers cross
            swap(a, index, i, j);               // swap two elements into place
        }
        swap(a, index, i, right);               // swap with partition element
        return i;
    }

    // exchange a[i] and a[j]
    private static void swap(String[] a, int[] index, int i, int j) {
        String swap = a[i];
        a[i] = a[j];
        a[j] = swap;
        int b = index[i];
        index[i] = index[j];
        index[j] = b;
    }

    /**
     * MergeSort implementation 90/100
     *
     * @param arr array of Strings that stored the values
     * @return the indices in sorted order
     */
    public static int[] mergeSort(String[] arr) {
        if (arr == null) return null;
        int res[] = new int[arr.length];
        if (arr.length == 0) return res;

        int[] scratch = new int[arr.length];

        for (int i = 0; i < res.length; i++) res[i] = i;

        mergeSortIndexed(arr, res, scratch, 0, arr.length - 1);
        return res;
    }

    public static int[] mergeSortIndexed(String[] arr, int[] res, int[] scratch, int left, int right) {
        if (left == right) return res;
        int mid = (left + right + 1) / 2;
        mergeSortIndexed(arr, res, scratch, left, mid - 1);
        mergeSortIndexed(arr, res, scratch, mid, right);
        mergeIndexed(arr, res, scratch, left, mid - 1, mid, right);

        return res;
    }

    public static void mergeIndexed(String[] arr, int[] res, int[] scratch, int left, int right, int l, int r) {
        int i = 0;
        int j = left;
        int k = l;
        int n = right - left + 1;

        while (j <= right && k <= r) {
            if (arr[res[j]].compareTo(arr[res[k]]) <= 0) scratch[i++] = res[j++];
            else scratch[i++] = res[k++];
        }

        while (j <= right)
            scratch[i++] = res[j++];

        while (k <= r)
            scratch[i++] = res[k++];

        for (int a = left; a <= right; a++)
            res[a] = scratch[a - left];

        for (int b = l; b <= r; b++)
            res[b] = scratch[b - l + n];
    }
}
