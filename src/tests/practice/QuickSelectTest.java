package practice;

import org.junit.jupiter.api.Test;
import practice.QuickSelect.QuickSelect;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuickSelectTest {
    @Test
    public void quickselectTest() {
        int[] array = {1, 4, 5, 9, 11};
        int goal = QuickSelect.quickSelect(array, 4);


        // 1, 4, 0, 9, 5
        // 1, 4, 0, 5, 9
        assertEquals(goal, 4);
    }
}
