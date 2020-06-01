package exam.FinalB.Tree;

import java.util.ArrayList;

public class CountEvenNodes {
    /**
     * Counts the number of nodes with an event number of children.
     *
     * @param tree The tree to count nodes with an even number of children in.
     * @return the number of nodes with an even number of children, or 0 if tree is null.
     */
    public static int countNodesEvenChildren(LibraryTree tree) {
        if (tree == null) return 0;

        int count = 0;
        if (hasEven(tree)) count++;

        ArrayList<LibraryTree> children = new ArrayList<>(tree.getChildren());

        while (!children.isEmpty()) {
            LibraryTree child = children.get(0);
            if (hasEven(child)) count++;
            children.addAll(child.getChildren());
            children.remove(child);
        }

        return count;
    }

    public static boolean hasEven(LibraryTree tree) {
        return tree.getChildren().size() % 2 == 0 ? true : false;
    }
}
