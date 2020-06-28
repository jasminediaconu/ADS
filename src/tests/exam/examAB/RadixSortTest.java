package exam.examAB;

import exam.FinalA.RadixSort;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RadixSortTest {
    /**
     * MSD Radix Sort
     */
    @Test()
    public void testEmpty() {
        assertEquals(new ArrayList<>(), RadixSort.radixSortMSD(new ArrayList<>()));
    }

    @Test()
    public void testReversedMSD() {
        List<String> data = asList("donut", "cherry", "banana", "apple");
        List<String> data2 = asList("apple", "banana", "cherry", "donut");
        assertEquals(data2, RadixSort.radixSortMSD(data));
    }

    @Test
    public void testReversedLSD() {
        List<String> data = asList("0644444444", "0633333333", "0622222222", "0611111111");
        List<String> data2 = asList("0611111111", "0622222222", "0633333333", "0644444444");
        assertEquals(data2, exam.FinalB.RadixSort.radixSortLSD(data));
    }

    @Test
    public void testLSD() {
        List<String> data = asList("0687654321", "0612301345", "0612300123", "0612345678");
        List<String> data2 = asList("0612300123", "0612301345", "0612345678", "0687654321");
        assertEquals(data2, exam.FinalB.RadixSort.radixSortLSD(data));
    }

    @Test
    public void testLSD2() {
        List<String> data = asList("0612345672", "0612345671", "0612345674", "0612345673");
        List<String> data2 = asList("0612345671", "0612345672", "0612345673", "0612345674");
        assertEquals(data2, exam.FinalB.RadixSort.radixSortLSD(data));
    }
}
