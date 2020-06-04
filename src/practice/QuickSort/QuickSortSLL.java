package practice.QuickSort;

import practice.MergeSort.Node;

public class QuickSortSLL {

    public Node head;

    public void addNode(int data)
    {
        if(head == null)
        {
            head = new Node(data, null);
            return;
        }

        Node curr = head;
        while(curr.next != null)
            curr = curr.next;

        Node newNode = new Node(data, null);
        curr.next = newNode;
    }

    public static Node partitionLast(Node head, Node tail) {
        if(head == tail || head == null || tail == null) return head;

        Node piv_prev = head;
        Node curr = head;
        int pivot = tail.data;

        while (head != tail) {
            if(head.data < pivot) {
                piv_prev = curr;
                int temp = curr.data;
                curr.data = head.data;
                head.data = temp;
            }
            head = head.next;
        }

        int temp = curr.data;
        curr.data = pivot;
        tail.data = temp;

        return piv_prev;
    }

    public void sort(Node head, Node tail) {
        if(head == tail) return;;

        Node piv_prev = partitionLast(head, tail);
        sort(head, piv_prev);

        if(piv_prev != null && piv_prev == head) sort(piv_prev.next, tail);
        else if(piv_prev != null && piv_prev.next != null) sort(piv_prev.next.next, tail);
    }
}
