package exam.resit;

import exam.resit.SLL.SLL;
import exam.resit.SLL.SLList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class SLLTest {
    /**
     * Insertion Sort List (resit).
     */
    @Test
    public void testEmpty() {
        SLList input = new SLList();
        SLList output = new SLList();
        assertEquals(output, SLL.insertionSort(input));
    }

    @Test
    public void testNull() {
        assertNull(SLL.insertionSort(null));
    }

    @Test
    public void testExample() {
        SLList input = new SLList(3, 1, 2);
        SLList output = new SLList(1, 2, 3);
        assertEquals(output, SLL.insertionSort(input));
    }
}
