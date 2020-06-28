package practice.RedBlackTrees;

public class Node {

    private Integer value;

    private Node parent, left, right;

    private boolean isRed;

    /**
     * Simple constructor.
     *
     * @param value Value for this tree set as value.
     * @param isRed True if this node is red, false otherwise.
     */
    public Node(Integer value, boolean isRed) {
        this.value = value;
        this.isRed = isRed;
    }

    /**
     * Extended constructor.
     *
     * @param value to set as value.
     * @param left to set as left child.
     * @param right to set as right child.
     */
    public Node(Integer value, boolean isRed, Node parent, Node left, Node right) {
        this(value, isRed);
        setParent(parent);
        setLeft(left);
        setRight(right);
    }

    /**
     * @return the value of this tree.
     */
    public Integer getValue() {
        return value;
    }

    /**
     * @param value the new value of this tree.
     */
    public void setValue(Integer value) {
        this.value = value;
    }

    /**
     * @return the left child.
     */
    public Node getLeft() {
        return left;
    }

    /**
     * @return the right child.
     */
    public Node getRight() {
        return right;
    }

    /**
     * @return the parent.
     */
    public Node getParent() {
        return parent;
    }

    /**
     * @return true if this node is red, false otherwise.
     */
    public boolean isRed() {
        return isRed;
    }

    /**
     * @return true if this node is black, false otherwise.
     */
    public boolean isBlack() {
        return !isRed;
    }

    /**
     * @return True if the tree has a left child, false otherwise.
     */
    public boolean hasLeft() {
        return left != null;
    }

    /**
     * @return True if the tree has a right child, false otherwise.
     */
    public boolean hasRight() {
        return right != null;
    }

    /**
     * @param left Left subtree to set.
     */
    public void setLeft(Node left) {
        this.left = left;
    }

    /**
     * @param right Right subtree to set.
     */
    public void setRight(Node right) {
        this.right = right;
    }

    /**
     * @param parent Parent Node to set.
     */
    public void setParent(Node parent) { this.parent = parent; }

    /**
     * @param red True if the new color is red, false otherwise.
     */
    public void setRed(boolean red) {
        this.isRed = red;
    }

}