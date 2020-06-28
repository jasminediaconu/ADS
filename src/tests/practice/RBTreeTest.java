package practice;

import org.junit.jupiter.api.Test;
import practice.RedBlackTrees.RedBlackTree;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RBTreeTest {

    @Test
    public void testExample() {
//        RBTree tree = new RBTree(11, false);
//        // First level
//        RBTree left = new RBTree(5, true);
//        RBTree right = new RBTree(15, true);
//        // Second level
//        RBTree left2 = new RBTree(3, false);
//        RBTree right2 = new RBTree(7, false);
//        RBTree left3 = new RBTree(13, false);
//        RBTree right3 = new RBTree(20, false);
//        // Third level
//        RBTree right4 = new RBTree(4, true);
//        RBTree right5 = new RBTree(9, true);
//        RBTree left5 = new RBTree(19, true);
//        RBTree right6 = new RBTree(24, true);
//
//        // First level
//        tree.setLeft(left);
//        tree.setRight(right);
//        // Second level
//        left.setLeft(left2);
//        left.setRight(right2);
//        right.setLeft(left3);
//        right.setRight(right3);
//        // Third level
//        left2.setRight(right4);
//        right2.setRight(right5);
//        right3.setLeft(left5);
//        right3.setRight(right6);
//
//        assertTrue(RBTOperations.isRedBlackTree(tree));
//
//        RBTree result = RBTOperations.insert(tree, new RBTree(2, false));
//        assertFalse(RBTOperations.isRedBlackTree(result));
//        //RBTree result2 = RBTOperations.insert(tree, new RBTree(2, true));

    }

    @Test
    public void testExample2() {
        int[] values = {5, 8, 1, -4, 6, -2, 0, 7};
        RedBlackTree rbTree = new RedBlackTree();
        for (int v : values) rbTree.insert(v);

        System.out.printf("RB tree contains %d: %s\n", 6, rbTree.contains(6));
        System.out.printf("RB tree contains %d: %s\n", -5, rbTree.contains(-5));
        System.out.printf("RB tree contains %d: %s\n", 1, rbTree.contains(1));
        System.out.printf("RB tree contains %d: %s\n", 99, rbTree.contains(99));
    }
}






































