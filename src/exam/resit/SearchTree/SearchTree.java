package exam.resit.SearchTree;

public class SearchTree {
    /**
     * Given a Binary Search Tree and an Integer, returns the Entry in this tree
     * with the smallest key that is strictly larger than k.
     *
     * @param tree Binary search tree to search in.
     * @param k    The key of the resulting entry should be strictly larger than this k.
     * @return The entry with smallest key, strictly larger than k.
     */
    public static Entry higherEntry(BinarySearchTree tree, int k) {
        if (tree == null) return null;

        return findEntry(tree, k, null);
    }

    static Entry findEntry(BinarySearchTree tree, int k, Entry minEntry) {
        if (tree == null) return minEntry;

        if (tree.getKey() <= k) tree = tree.getRight();
        else {
            minEntry = tree.getEntry();
            tree = tree.getLeft();
        }

        return findEntry(tree, k, minEntry);
    }
}
