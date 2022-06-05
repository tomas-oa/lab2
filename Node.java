class Node<T extends Comparable<T>> implements Comparable<Node<T>> {

    private Track data;
    private Node<T> left;
    private Node<T> right;
    public int level;
    private int depth;

    public Node(Track data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public Node(Track data, Node<T> left, Node<T> right) {
        super();
        this.data = data;
        this.left = left;
        this.right = right;

        if (left == null && right == null) setDepth(1);
        else if (left == null) setDepth(right.getDepth() + 1);
        else if (right == null) setDepth(left.getDepth() + 1);
        else setDepth(Math.max(left.getDepth(), right.getDepth()) + 1);
    }

    public Track getData() { return data; }
    public Node<T> getLeft() { return left; }
    public Node<T> getRight() { return right; }
    public int getDepth() { return depth; }
    public int getLevel() { return level; }

    public void setData(Track data) { this.data = data; }
    public void setLeft(Node<T> left) { this.left = left; }
    public void setRight(Node<T> right) { this.right = right; }
    public void setDepth(int depth) { this.depth = depth; }
    public void setLevel(int level) { this.level = level; }




    @Override
    public int compareTo(Node<T> o) {
        return this.data.compareTo(o.data);
    }

    @Override
    public String toString() {
        return "Level " + level + ": " + data;
    }
}