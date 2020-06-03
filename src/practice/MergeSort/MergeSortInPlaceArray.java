package practice.MergeSort;

public class MergeSortInPlaceArray {

    public static void merge(int[] arr, int low, int mid, int high) {

        int second = mid + 1;

        if (arr[mid] <= arr[second]) return;

        while (low <= mid && second <= high) {

            // Element is at the right place
            if (arr[low] <= arr[second]) low++;
            else {
                int val = arr[second];
                int index = second;

                // Shift all elements between element 1 and element 2
                while (index != low) {
                    arr[index] = arr[index - 1];
                    index--;
                }

                arr[low] = val;

                low++;
                mid++;
                second++;
            }
        }
    }

    public static void mergeSort(int[] res, int low, int high) {
        if (res == null || res.length < 2) return;

        if (low < high) {
            // If you don't add low => StackOverflow
            int mid = low + (high - low) / 2;

            mergeSort(res, low, mid);
            mergeSort(res, mid + 1, high);

            merge(res, low, mid, high);
        }
    }
}
