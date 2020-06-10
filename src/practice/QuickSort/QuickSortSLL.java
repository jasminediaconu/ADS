//package practice.QuickSort;
//
//public class QuickSortSLL {
//
//    public static SLList partitionLast(SLList list) {
//        if(list.getFirst() == list.getFirst().getNext()) return head;
//
//        Node piv_prev = head;
//        Node curr = head;
//        int pivot = tail.data;
//
//        while (head != tail) {
//            if(head.data < pivot) {
//                piv_prev = curr;
//                int temp = curr.data;
//                curr.data = head.data;
//                head.data = temp;
//            }
//            head = head.next;
//        }
//
//        int temp = curr.data;
//        curr.data = pivot;
//        tail.data = temp;
//
//        return piv_prev;
//    }
//
//    public void sort(SLList list) {
//        if(list.getFirst() == list.getFirst().getNext()) return;
//
//        Node piv_prev = partitionLast(head, tail);
//        sort(list);
//
//        if(piv_prev != null && piv_prev == head) sort(piv_prev.next, tail);
//        else if(piv_prev != null && piv_prev.next != null) sort(piv_prev.next.next, tail);
//    }
//}
