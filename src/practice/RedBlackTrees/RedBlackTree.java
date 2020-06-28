package practice.RedBlackTrees;

public class RedBlackTree {
    public Node root;

    public int nodeCount = 0;

//    public Node NIL;
//
//    public RedBlackTree(Node nil) {
//        NIL = nil;
//        NIL = new Node(null, false);
//        NIL.setLeft(null);
//        NIL.setRight(null);
//        NIL.setParent(null);
//
//        root = NIL;
//    }

    public final Node NIL;

    public RedBlackTree() {
        NIL = new Node(null, false);
        NIL.setLeft(NIL);
        NIL.setRight(NIL);
        NIL.setParent(NIL);

        root = NIL;
    }

    /**
     * @return number of nodes in the tree.
     */
    public int size() {
        return nodeCount;
    }

    /**
     * @return true if the tree is empty, false otherwise.
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Check if NIL is present in the tree.
     * @param value
     * @return true if the NIL is found, false otherwise.
     */
    public boolean contains(Integer value) {
        Node node = root;

        if (node == null || value == null) return false;

        while (node != NIL) {
            int v = node.getValue();
            if (value < v) node = node.getLeft();
            else if (value > v) node = node.getRight();

            else return true;
        }

        return false;
    }

    /**
     * Inserts node in the tree.
     * @param value
     * @return true if the NIL is inserted, false otherwise.
     */
    public boolean insert(Integer value) {
        if (value == null) return false;

        Node x = root, y = NIL;

        while (x != NIL) {
            y = x;

            if (value < x.getValue()) x = x.getLeft();
            else if (value > x.getValue()) x = x.getRight();
            
            else return false;
        }

        Node z = new Node(value, true, y, null, null);

        if (y == NIL) root = z;
        else if (z.getValue() < y.getValue()) y.setLeft(z);
        else y.setRight(z);

        insertFix(z);

        nodeCount++;
        return true;
    }

    /**
     * Rebalances the tree according to the element inserted.
     * @param z inserted node.
     */
    private void insertFix(Node z) {
        Node y;
        while (z.getParent().isRed()) {
            if (z.getParent() == z.getParent().getParent().getLeft()) {
                y = z.getParent().getParent().getRight();
                if (y.isRed()) {
                    z.getParent().setRed(false);
                    y.setRed(false);
                    z.getParent().getParent().setRed(true);
                    z = z.getParent().getParent();
                } else {
                    if (z == z.getParent().getRight()) {
                        z = z.getParent();
                        leftRotate(z);
                    }
                    z.getParent().setRed(false);
                    z.getParent().getParent().setRed(true);
                    rightRotate(z.getParent().getParent());
                }
            } else {
                y = z.getParent().getParent().getLeft();
                if (y.isRed()) {
                    z.getParent().setRed(false);
                    y.setRed(false);
                    z.getParent().getParent().setRed(true);
                    z = z.getParent().getParent();
                } else {
                    if (z == z.getParent().getLeft()) {
                        z = z.getParent();
                        rightRotate(z);
                    }
                    z.getParent().setRed(false);
                    z.getParent().getParent().setRed(true);
                    leftRotate(z.getParent().getParent());
                }
            }
        }
        root.setRed(false);
        NIL.setParent(null);
    }

    /**
     * Rotates the tree on the left.
     * @param x
     */
    private void leftRotate(Node x) {
        Node y = x.getRight();
        x.setRight(y.getLeft());
        if (y.getLeft() != NIL) y.getLeft().setParent(x);
        y.setParent(x.getParent());
        if (x.getParent() == NIL) root = y;
        if (x == x.getParent().getLeft()) x.getParent().setLeft(y);
        else x.getParent().setRight(y);
        y.setLeft(x);
        x.setParent(y);
    }

    /**
     * Rotates the tree on the right.
     * @param y
     */
    private void rightRotate(Node y) {
        Node x = y.getLeft();
        y.setLeft(x.getRight());
        if (x.getRight() != NIL) x.getRight().setParent(y);
        x.setParent(y.getParent());
        if (y.getParent() == NIL) root = x;
        if (y == y.getParent().getLeft()) y.getParent().setLeft(x);
        else y.getParent().setRight(x);
        x.setRight(y);
        y.setParent(x);
    }

    /**
     * Deletes the specified element from the tree.
     * @param key
     * @return true if the element is successfully deleted, false otherwise.
     */
    public boolean delete(Integer key) {
        Node z = search(key, root);
        if (key == null || (z == NIL)) return false;

        Node x;
        Node y = z; // temporary reference y
        boolean yOriginalColor = y.isRed();

        if (z.getLeft() == NIL) {
            x = z.getRight();
            transplant(z, z.getRight());
        } else if (z.getRight() == NIL) {
            x = z.getLeft();
            transplant(z, z.getLeft());
        } else {
            y = successor(z.getRight());
            yOriginalColor = y.isRed();
            x = y.getRight();
            if (y.getParent() == z) x.setParent(y);
            else {
                transplant(y, y.getRight());
                y.setRight(z.getRight());
                y.getRight().setParent(y);
            }
            transplant(z, y);
            y.setLeft(z.getLeft());
            y.getLeft().setParent(y);
            y.setRed(z.isRed());
        }
        if (!yOriginalColor) deleteFix(x);

        nodeCount--;

        return true;
    }

    /**
     * Rebalances the tree according to the element deleted.
     * @param x deleted node.
     */
    private void deleteFix(Node x) {
        while (x != root && x.isBlack()) {
            if (x == x.getParent().getLeft()) {
                Node w = x.getParent().getRight();
                if (w.isRed()) {
                    w.setRed(false);
                    x.getParent().setRed(true);
                    leftRotate(x.getParent());
                    w = x.getParent().getRight();
                }
                if (w.getLeft().isBlack() && w.getRight().isBlack()) {
                    w.setRed(true);
                    x = x.getParent();
                    continue;
                } else if (w.getRight().isBlack()) {
                    w.getLeft().setRed(false);
                    w.setRed(true);
                    rightRotate(w);
                    w = x.getParent().getRight();
                }
                if (w.getRight().isRed()) {
                    w.setRed(x.getParent().isRed());
                    x.getParent().setRed(false);
                    w.getRight().setRed(false);
                    leftRotate(x.getParent());
                    x = root;
                }
            } else {
                Node w = (x.getParent().getLeft());
                if (w.isRed()) {
                    w.setRed(false);
                    x.getParent().setRed(true);
                    rightRotate(x.getParent());
                    w = (x.getParent()).getLeft();
                }
                if (w.getRight().isBlack() && w.getLeft().isBlack()) {
                    w.setRed(true);
                    x = x.getParent();
                    continue;
                } else if (w.getLeft().isBlack()) {
                    w.getRight().setRed(false);
                    w.setRed(true);
                    leftRotate(w);
                    w = (x.getParent().getLeft());
                }
                if (w.getLeft().isRed()) {
                    w.setRed(x.getParent().isRed());
                    x.getParent().setRed(true);
                    w.getLeft().setRed(false);
                    rightRotate(x.getParent());
                    x = root;
                }
            }
        }

        x.setRed(false);
    }

    /**
     * Find the next node.
     * @param root
     * @return the next node.
     */
    private Node successor(Node root) {
        if (root == NIL || root.getLeft() == NIL) return root;
        else return successor(root.getLeft());
    }

    /**
     *
     * @param u
     * @param v
     */
    private void transplant(Node u, Node v) {
        if (u.getParent() == NIL) root = v;
        else if (u == u.getParent().getLeft()) u.getParent().setLeft(v);
        else u.getParent().setRight(v);

        v.setParent(u.getParent());
    }

    /**
     * Searches for a value.
     * @param value
     * @param curr
     * @return
     */
    private Node search(Integer value, Node curr) {
        if (curr == NIL) return NIL;
        else if (curr.getValue() == value) return curr;
        else if (curr.getValue() < value) return search(value, curr.getRight());
        else return search(value, curr.getLeft());
    }

    /**
     * Returns the height of the tree.
     * @return
     */
    public int height() {
        return height(root);
    }

    /**
     *
     * @param curr
     * @return
     */
    private int height(Node curr) {
        if (curr == NIL) return 0;
        if (curr.getLeft() == NIL && curr.getRight() == NIL) return 1;

        return 1 + Math.max(height(curr.getLeft()), height(curr.getRight()));
    }

    /**
     *
     * @param a
     * @param b
     */
    private void swapColors(Node a, Node b) {
        boolean tmpColor = a.isRed();
        a.setRed(b.isRed());
        b.setRed(tmpColor);
    }

    // Sometimes the left or right child node of a parent changes and the
    // parent's reference needs to be updated to point to the new child.
    // This is a helper method to do just that.
    private void updateParentChildLink(Node parent, Node oldChild, Node newChild) {
        if (parent != NIL) {
            if (parent.getLeft() == oldChild) parent.setLeft(newChild);
            else parent.setRight(newChild);
        }
    }
}
