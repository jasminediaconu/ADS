package practice.RedBlackTrees;

public class RBTOperations {
    /**
     * Checks whether the given RBTree is a Red Black Tree.
     * @param tree RBTree to check.
     * @return True if the given tree is a Red Black Tree, false otherwise.
     */
//    public static boolean isRedBlackTree(RBTree tree) {
//        if(tree.isRed()) return false;
//
//        return isTreeBST(tree, Integer.MIN_VALUE, Integer.MAX_VALUE) &&
//                checkRed(tree.getLeft()) &&
//                checkRed(tree.getRight()) && checkBlackHeight(tree) > 0;
//    }
//
//    public static boolean isTreeBST(RBTree tree, int min, int max) {
//        if(tree == null) return true;
//
//        if(tree.getValue() <= min || tree.getValue() >= max) return false;
//
//        return isTreeBST(tree.getLeft(), min, tree.getValue()) &&
//                isTreeBST(tree.getRight(), tree.getValue(), max);
//    }
//
//    public static int checkBlackHeight(RBTree tree) {
//        if(tree == null) return 1;
//
//        int left = checkBlackHeight(tree.getLeft());
//        int right = checkBlackHeight(tree.getRight());
//
//        if (left != right) return 0;
//
//        return left + (tree.isBlack() ? 1 : 0);
//    }
//
//    public static boolean checkRed(RBTree tree) {
//        if(tree == null) return true;
//
//        if(tree.isRed()) {
//            if(tree.hasLeft() && tree.getLeft().isRed()) return false;
//            if(tree.hasRight() && tree.getRight().isRed()) return false;
//        }
//
//        return checkRed(tree.getLeft()) && checkRed(tree.getRight());
//    }
}
