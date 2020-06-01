package exam.examAB;

import exam.FinalB.Tree.LibraryTree;
import exam.FinalB.Tree.Tree;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TreeTest {
    @Test
    public void testNull() {
        LibraryTree tree = null;
        assertEquals(0, Tree.countNodesEvenChildren(tree));
    }

    @Test
    public void testRoot() {
        LibraryTree tree = new LibraryTree(0);
        assertEquals(1, Tree.countNodesEvenChildren(tree));
    }

    @Test
    public void testSmall() {
        LibraryTree tree = new LibraryTree(0, Arrays.asList(new LibraryTree(1), new LibraryTree(2)));
        assertEquals(3, Tree.countNodesEvenChildren(tree));
    }
}
