package practice.QuickSort;

public class QuickSortInPlaceArray {

    public static void sortElements(int[] elements, int low, int high) {
        if(elements == null || elements.length < 2) return;
        if(low < high) {
            int pivot = findPivot(elements, low, high);

            sortElements(elements, pivot + 1, high);
            sortElements(elements, low, pivot - 1);
        }
    }

    public static int findPivot(int[] elements, int low, int high) {
        int i = low;
        int pivot = elements[high];

        for(int j = i; j < high; j++) {
            if(elements[j] < pivot) {
                int temp = elements[i];
                elements[i] = elements[j];
                elements[j] = temp;
                i++;
            }
        }

        int tmp = elements[i];
        elements[i] = pivot;
        elements[high] = tmp;
        return i;
    }

}
