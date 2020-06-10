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
    public void testReversed() {
        List<String> data = asList("donut", "cherry", "banana", "apple");
        List<String> data2 = asList("apple", "banana", "cherry", "donut");
        assertEquals(data2, RadixSort.radixSortMSD(data));
    }
}
