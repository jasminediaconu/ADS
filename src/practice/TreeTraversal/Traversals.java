package practice.TreeTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Traversals {
    /**
     * @param tree
     *     The input BinaryTree.
     * @return A list of all keys in the tree, in post-order.
     */
    public static List<Integer> postOrder(BinaryTree tree) {
        List<Integer> list = new ArrayList<>();

        if(tree == null) return list;
        if(!tree.hasLeft() && !tree.hasRight()) {
            list.add(tree.getKey());
            return list;
        }

        return postOrder(tree, list);
    }

    public static List<Integer> postOrder(BinaryTree tree, List<Integer> list) {
        if(tree == null) return list;

        if(tree.hasLeft())
            postOrder(tree.getLeft(), list);

        if(tree.hasRight())
            postOrder(tree.getRight(), list);

        list.add(tree.getKey());

        return list;
    }

    /**
     * @param tree
     *     The input BinaryTree.
     * @return A list of all keys in the tree, in pre-order.
     */
    public static List<Integer> preOrder(BinaryTree tree) {
        List<Integer> list = new ArrayList<>();

        if(tree == null) return list;
        if(!tree.hasLeft() && !tree.hasRight()) {
            list.add(tree.getKey());
            return list;
        }

        return preOrder(tree, list);
    }

    public static List<Integer> preOrder(BinaryTree tree, List<Integer> list) {
        if(tree == null) return list;

        list.add(tree.getKey());

        if(tree.hasLeft())
            preOrder(tree.getLeft(), list);

        if(tree.hasRight())
            preOrder(tree.getRight(), list);

        return list;
    }

    /**
     * @param tree
     *     The input BinaryTree.
     * @return A list of all keys in the tree, in in-order.
     */
    public static List<Integer> inOrder(BinaryTree tree) {
        List<Integer> list = new ArrayList<>();

        if(tree == null) return list;
        if(!tree.hasLeft() && !tree.hasRight()) {
            list.add(tree.getKey());
            return list;
        }

        return inOrder(tree, list);
    }

    public static List<Integer> inOrder(BinaryTree tree, List<Integer> list) {
        if(tree == null) return list;

        if(tree.hasLeft())
            inOrder(tree.getLeft(), list);

        list.add(tree.getKey());

        if(tree.hasRight())
            inOrder(tree.getRight(), list);

        return list;
    }

    /**
     * @param tree
     *     The input BinaryTree.
     * @return A list of all keys in the tree, in breath-first.
     */
    public static List<Integer> breadthFirst(BinaryTree tree) {
        List<Integer> list = new ArrayList<>();

        if(tree == null) return list;
        if(!tree.hasLeft() && !tree.hasRight()) {
            list.add(tree.getKey());
            return list;
        }

        return breadthFirst(tree, list);
    }

    public static List<Integer> breadthFirst(BinaryTree tree, List<Integer> list) {
        if(tree == null) return list;

        Queue<BinaryTree> queue = new LinkedList<>();

        queue.add(tree);

        while(!queue.isEmpty()) {
            BinaryTree first = queue.remove();
            list.add(first.getKey());

            if(first.hasLeft()) queue.add(first.getLeft());
            if(first.hasRight()) queue.add(first.getRight());
        }

        return list;
    }

}
