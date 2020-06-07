package exam.resit.SLL;

/**
 * Implement the method SLList insertionSort(SLList list),
 * which performs insertion sort on the given singly linked list of class SLList.
 * The method should return a new singly linked list with the elements of the original
 * list in non-decreasing order.
 *
 * In the case that the input list is null, you should return null.
 */
public class SLL {
    /**
     * @param list The singly linked list to sort.
     * @return A new singly linked list that contains the elements as
     * the input list sorted in non-decreasing order.
     */
    public static SLList insertionSort(SLList list) {
        if (list == null) return null;
        SLList result = new SLList();
        if (list.getFirst() == null) return result;

        while(list.getFirst() != null) {
            if(result.getFirst() == null || list.getFirst().getElement() <= result.getFirst().getElement()) {
                result.addFirst(list.getFirst().getElement());
            } else {
                traverseList(result, list.getFirst().getElement());
            }

            list.removeFirst();
        }

        return result;
    }

    public static void traverseList(SLList list, int curr) {
        SLList.Node next = list.getFirst();

        while(next != null) {
            if(next.getElement() <= curr && (next.getNext() == null || curr < next.getNext().getElement())) {
                list.addAfter(next, curr);
                return;
            }
            next = next.getNext();
        }
    }
}
