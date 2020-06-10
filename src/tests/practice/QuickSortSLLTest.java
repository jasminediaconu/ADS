//package practice;
//
//import org.junit.jupiter.api.Test;
//import practice.MergeSort.MergeSortInPlaceSLL;
//import practice.MergeSort.Node;
//import practice.QuickSort.QuickSortInPlaceArray;
//import practice.QuickSort.QuickSortSLL;
//
//import static org.junit.jupiter.api.Assertions.assertNull;
//
//public class QuickSortSLLTest {
//
//    @Test
//    public void emptyList() {
//        QuickSortSLL quickSortSLL = new QuickSortSLL();
//        quickSortSLL.sort(quickSortSLL.head, null);
//        assertNull(quickSortSLL.head);
//    }
//
//    @Test
//    public void oneElementList() {
//        QuickSortSLL quickSortSLL = new QuickSortSLL();
//        quickSortSLL.addNode(10);
//        quickSortSLL.sort(quickSortSLL.head, null);
//        QuickSortSLL result = new QuickSortSLL();
//        result.addNode(10);
//        quickSortSLL.equals(result);
//    }
//
//    @Test
//    public void multipleElementsList() {
//        QuickSortSLL quickSortSLL = new QuickSortSLL();
//        quickSortSLL.addNode(10);
//        quickSortSLL.addNode(3);
//        quickSortSLL.addNode(5);
//        quickSortSLL.addNode(6);
//        quickSortSLL.addNode(0);
//        quickSortSLL.addNode(1);
//        quickSortSLL.addNode(4);
//
//        Node n = quickSortSLL.head;
//
//        while(n.next != null) n = n.next;
//
//        quickSortSLL.sort(quickSortSLL.head, n);
//
//        QuickSortSLL result = new QuickSortSLL();
//        quickSortSLL.addNode(0);
//        quickSortSLL.addNode(1);
//        quickSortSLL.addNode(3);
//        quickSortSLL.addNode(4);
//        quickSortSLL.addNode(5);
//        quickSortSLL.addNode(6);
//        quickSortSLL.addNode(10);
//
//        quickSortSLL.equals(result);
//    }
//}
