package exam.resit;

import exam.resit.SearchTree.BinarySearchTree;
import exam.resit.SearchTree.SearchTree;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class SearchTreeTest {
    @Test
    public void testBase() {
        BinarySearchTree tree = new BinarySearchTree(1, 42);
        assertEquals(1, SearchTree.higherEntry(tree, 0).key);
        assertNull(SearchTree.higherEntry(tree, 1));
        assertNull(SearchTree.higherEntry(tree, 2));
        assertNull(SearchTree.higherEntry(null, 42));
    }

    @Test
    public void testSmall() {
        BinarySearchTree tree = new BinarySearchTree(42, 42, new BinarySearchTree(21, 21, new BinarySearchTree(10, 10), new BinarySearchTree(30, 30)), new BinarySearchTree(84, 84, new BinarySearchTree(60, 60), new BinarySearchTree(100, 100)));
        assertEquals(10, SearchTree.higherEntry(tree, 2).key);
        assertEquals(60, SearchTree.higherEntry(tree, 42).key);
        assertEquals(30, SearchTree.higherEntry(tree, 29).key);
        assertEquals(100, SearchTree.higherEntry(tree, 88).key);
    }
}
