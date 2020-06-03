package practice.MergeSort;

/**
 * Merge Sort inplace implementation using two Sorted Linked Lists.
 */
public class MergeSortInPlaceSLL {

    public static Node mergeSort(Node head) {
        if (head == null || head.next == null) return head;

        Node[] result = frontBackSplit(head);
        Node front = result[0];
        Node tail = result[1];

        front = mergeSort(front);
        tail = mergeSort(tail);

        return mergeSorted(front, tail);
    }

    public static Node[] frontBackSplit(Node source) {
        if (source == null | source.next == null) return new Node[]{source, null};

        Node slow = source;
        Node fast = source.next;

        while (fast != null) {
            fast = fast.next;
            if (fast != null) {
                slow = slow.next;
                fast = fast.next;
            }
        }

        Node[] arr = new Node[]{source, slow.next};
        slow.next = null;

        return arr;
    }

    public static Node mergeSorted(Node first, Node second) {

        if (first == null) return second;
        else if (second == null) return first;

        Node result;

        if (first.data > second.data) {
            result = first;
            result.next = mergeSorted(first.next, second);
        } else {
            result = second;
            result.next = mergeSorted(first, second.next);
        }

        return result;
    }
}
