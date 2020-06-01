package exam.examAB;

import exam.FinalB.Tree.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountEvenNodesTest {
    @Test
    public void testNull() {
        LibraryTree tree = null;
        assertEquals(0, CountEvenNodes.countNodesEvenChildren(tree));
    }

    @Test
    public void testRoot() {
        LibraryTree tree = new LibraryTree(0);
        assertEquals(1, CountEvenNodes.countNodesEvenChildren(tree));
    }

    @Test
    public void testSmall() {
        LibraryTree tree = new LibraryTree(0, Arrays.asList(new LibraryTree(1), new LibraryTree(2)));
        assertEquals(3, CountEvenNodes.countNodesEvenChildren(tree));
    }
}
