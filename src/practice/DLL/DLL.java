package practice.DLL;

import java.util.LinkedList;

public class DLL {
    /**
     * @param list The doubly linked list to sort.
     * @return A new doubly linked list that contains the elements as
     * the input list sorted in non-decreasing order using Selection Sort.
     */
    public static void selectionSort(LinkedList<Integer> list) {
        if (list == null || list.size() < 2) return;

        int curr = -1;

        for(int i = 0; i < list.size()-1; i++) {
            int min = list.get(i);
            for (int j = i; j < list.size(); j++) {
                if (list.get(j) <= min) {
                    min = list.get(j);
                    curr = j;
                }
            }

            if(curr != -1) {
                int temp = list.remove(curr);
                list.add(i, temp);
            }
        }
    }

    /**
     * @param list The doubly linked list to sort.
     * @return A new doubly linked list that contains the elements as
     * the input list sorted in non-decreasing order using Insertion Sort.
     */
    public static void insertionSort(LinkedList<Integer> list) {
        if (list == null || list.size() < 2) return;

        int min = -1;

        for(int i = 0; i < list.size(); i++) {
            int j = i;

            while(j > 0 && list.get(j) < list.get(j-1)) {
                int temp = list.get(j);
                list.remove(j);
                list.add(j-1, temp);
                j--;
            }
        }

    }

}
