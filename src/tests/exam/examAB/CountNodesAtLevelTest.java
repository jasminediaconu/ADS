package exam.examAB;

import exam.FinalA.Tree.BinaryTree;
import exam.FinalA.Tree.CountNodesAtLevel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountNodesAtLevelTest {
    @Test
    public void testSmall() {
        BinaryTree tree = new BinaryTree(0, new BinaryTree(1, new BinaryTree(3), new BinaryTree(4)), new BinaryTree(2, new BinaryTree(5), new BinaryTree(6)));
        assertEquals(1, CountNodesAtLevel.countNodesAtLevel(tree, 0));
        assertEquals(2, CountNodesAtLevel.countNodesAtLevel(tree, 1));
        assertEquals(4, CountNodesAtLevel.countNodesAtLevel(tree, 2));
    }

    @Test
    public void testNull() {
        BinaryTree tree = null;
        assertEquals(0, CountNodesAtLevel.countNodesAtLevel(tree, 0));
    }
}
