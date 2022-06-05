import Comparators.Track;

public class Node <T extends Comparable <T>> implements Comparable <Node <T>> {
    private Track data;
    private Node <T> left;
    private Node <T> right;
    private int level;
    private int depth;

    public Node (Track data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public Node (Track data, Node <T> left, Node <T> right) {
        super();
        this.data = data;
        this.left = left;
        this.right = right;

        if (left == null && right == null) {

        }
    }

    public Track getData() { return this.data; }
    public Node<T> getLeft() { return this.left; }
    public Node<T> getRight() { return this.right; }
    public int getDepth() { return this.depth; }
    public int getLevel() { return this.level; }

    public void setData(Track data) { this.data = data; }
    public void setLeft(Node<T> left) { this.left = left; }
    public void setRight(Node<T> right) { this.right = right; }
    public void setDepth(int depth) { this.depth = depth; }
    public void setLevel(int level) { this.level = level; }

    @Override
    public int compareTo(Node<T> o) {
        return this.data.compareTo(o.getData());
    }

    @Override
    public String toString() {
        return "Level " + getLevel() + ": " + getData();
    }
}
