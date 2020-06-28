package practice;

import org.junit.jupiter.api.Test;
import practice.TreeTraversal.BinaryTree;
import practice.TreeTraversal.Traversals;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TreeTraversalsTest {

    private BinaryTree threeLevelTree = new BinaryTree(1, new BinaryTree(2, new BinaryTree(4), new BinaryTree(5)), new BinaryTree(3, new BinaryTree(6), new BinaryTree(7)));

    private BinaryTree skewTree1 = new BinaryTree(42, new BinaryTree(36, new BinaryTree(21), new BinaryTree(24)), new BinaryTree(47));

    private BinaryTree skewTree2 = new BinaryTree(42, new BinaryTree(36, new BinaryTree(21), new BinaryTree(24)), null);

    private BinaryTree skewTree3 = new BinaryTree(42, new BinaryTree(21, new BinaryTree(10, new BinaryTree(5), null), new BinaryTree(31)), new BinaryTree(63, new BinaryTree(52, new BinaryTree(47), null), new BinaryTree(84)));

    public static void assertListEquals(int[] expected, List<Integer> keys) {
        assertArrayEquals(expected, keys.stream().mapToInt(x -> x).toArray());
    }

    @Test
    public void testJustRoot() {
        BinaryTree tree = new BinaryTree(1);
        assertListEquals(new int[] { 1 }, Traversals.postOrder(tree));
    }

    @Test
    public void testTwoLevels() {
        BinaryTree tree = new BinaryTree(1, new BinaryTree(2), new BinaryTree(3));
        assertListEquals(new int[] { 2, 3, 1 }, Traversals.postOrder(tree));
        assertListEquals(new int[] { 1, 2, 3 }, Traversals.preOrder(tree));
        assertListEquals(new int[] { 2, 1, 3 }, Traversals.inOrder(tree));
        assertListEquals(new int[] { 1, 2, 3 }, Traversals.breadthFirst(tree));
    }

    @Test
    public void testThreeLevelTree() {
        // Post-order
        assertListEquals(new int[] {4, 5, 2, 6, 7, 3, 1}, Traversals.postOrder(threeLevelTree));
        // Pre-order
        assertListEquals(new int[] {1, 2, 4, 5, 3, 6, 7}, Traversals.preOrder(threeLevelTree));
        // In-order
        assertListEquals(new int[] {4, 2, 5, 1, 6, 3, 7}, Traversals.inOrder(threeLevelTree));
        // Breadth-first
        assertListEquals(new int[] {1, 2, 3, 4, 5, 6, 7}, Traversals.breadthFirst(threeLevelTree));
    }

    @Test
    public void testSkewTree1() {
        // Post-order
        assertListEquals(new int[] {21, 24, 36, 47, 42}, Traversals.postOrder(skewTree1));
        // Pre-order
        assertListEquals(new int[] {42, 36, 21, 24, 47}, Traversals.preOrder(skewTree1));
        // In-order
        assertListEquals(new int[] {21, 36, 24, 42, 47}, Traversals.inOrder(skewTree1));
        // Breadth-first
        assertListEquals(new int[] {42, 36, 47, 21, 24}, Traversals.breadthFirst(skewTree1));
    }

    @Test
    public void testSkewTree2() {
        // Post-order
        assertListEquals(new int[] {21, 24, 36, 42}, Traversals.postOrder(skewTree2));
        // Pre-order
        assertListEquals(new int[] {42, 36, 21, 24}, Traversals.preOrder(skewTree2));
        // In-order
        assertListEquals(new int[] {21, 36, 24, 42}, Traversals.inOrder(skewTree2));
        // Breadth-first
        assertListEquals(new int[] {42, 36, 21, 24}, Traversals.breadthFirst(skewTree2));
    }

    @Test
    public void testSkewTree3() {
        // Post-order
        assertListEquals(new int[] {5, 10, 31, 21, 47, 52, 84, 63, 42}, Traversals.postOrder(skewTree3));
        // Pre-order
        assertListEquals(new int[] {42, 21, 10, 5, 31, 63, 52, 47, 84}, Traversals.preOrder(skewTree3));
        // In-order
        assertListEquals(new int[] {5, 10, 21, 31, 42, 47, 52, 63, 84}, Traversals.inOrder(skewTree3));
        // Breadth-first
        assertListEquals(new int[] {42, 21, 63, 10, 31, 52, 84, 5, 47}, Traversals.breadthFirst(skewTree3));
    }
}
