//package practice.QuickSort;
//
//import java.util.LinkedList;
//
//public class QuickSortDLL {
//
//    public int partition(LinkedList<Integer> list) {
//        int size = list.size();
//
//        int x = list.getFirst();
//        int notLast = size - 2;
//
//        for(int i = 1; i < size; i++) {
//            if(list.get(i) <= x) {
//                notLast = (list.get(notLast) == null) ? size - 1 : notLast + 1;
//                int temp = list.get(notLast);
//                int temp2 = list.get(i);
//                list.remove(notLast);
//                list.remove(i);
//                list.add(notLast, temp2);
//                list.add(i, temp);
//            }
//        }
//
//        notLast = (list.get(notLast) == null) ? size - 1 : notLast + 1;
//
//        int temp = list.get(notLast);
//        int temp2 = list.getFirst();
//        list.remove(notLast);
//        list.removeFirst();
//        list.add(notLast, temp2);
//        list.addFirst(temp);
//
//        return notLast;
//    }
//
//    public void quickSort(LinkedList<Integer> list, int first, int last) {
//        if(list.get(first) != null &&
//                list.getLast() != list.get(first) && list.getLast() != ) {
//            int temp = partition(list);
//            quickSort(list);
//        }
//
//    }
//}
