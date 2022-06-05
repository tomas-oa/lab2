import Comparators.Track;

import java.util.*;

public class AVLTree <T extends Comparable<T>>{
    private Node <T> root;
    private boolean eliminate = true;
    private ArrayList<String> l;

    public AVLTree() {
        this.root = null;
    }

    public Track maximum() {
        Node<T> local = this.root;

        if (local == null) {
            return null;
        }
        while (local.getRight() != null) {
            local = local.getRight();
        }

        return local.getData();
    }

    public Track minimum() {
        Node<T> local = this.root;

        if (local == null) {
            return null;
        }
        while (local.getLeft() != null) {
            local = local.getLeft();
        }

        return local.getData();
    }

    public Track getMin(Node<T> node) {
        if (node == null) {
            return null;
        }

        if (node.getLeft() == null) {
            return node.getData();
        }

        return getMin(node.getLeft());
    }

    private int depth(Node<T> root) {
        if (root == null) { return 0; }
        return root.getDepth();
    }


    public int balanceNumber(Node<T> node) {
        int left = depth(node.getLeft());
        int right =depth(node.getRight());

        if (left - right >= 2) {
            return -1;
        } else if (left - right <= -2) {
            return 1;
        }

        return 0;
    }
    public Node<T> insert(Node<T> node, Track data) {
        if (node == null) return new Node<>(data);

        if (node.getData().compareTo(data) > 0) {
            node = new Node<>(node.getData(), insert(node.getLeft(), data), node.getRight());
        } else if (node.getData().compareTo(data) < 0) {
            node = new Node<>(node.getData(), node.getLeft(), insert(node.getRight(), data));
        }

        switch (balanceNumber(node)) {
            case 1 -> node = rotateLeft(node);
            case -1 -> node = rotateRight(node);
            default -> { return node; }
        }

        return node;
    }

    public Node<T> insert(Track data) {
        root = insert(root, data);

        switch (balanceNumber(root)) {
            case 1 -> root = rotateLeft(root);
            case -1 -> root = rotateRight(root);
            default -> {}
        }

        return root;
    }

    private Node<T> rotateLeft(Node<T> node) {
        Node<T> q = node;
        Node<T> p = q.getRight();
        Node<T> c = q.getLeft();

        Node<T> a = p.getLeft();
        Node<T> b = p.getRight();

        q = new Node<>(q.getData(), c, a);
        p = new Node<>(p.getData(), q, b);

        return p;
    }

    private Node<T> rotateRight(Node<T> node) {
        Node<T> q = node;
        Node<T> p = q.getLeft();
        Node<T> c = q.getRight();

        Node<T> a = p.getLeft();
        Node<T> b = p.getRight();

        q = new Node<>(q.getData(), b, c);
        p = new Node<>(p.getData(), a, q);

        return p;
    }


    private boolean search2(String data, Track song) {
        Node<T> local = root;

        while (local != null) {
            if (local.getData().getSongName().compareTo(data) == 0) {
                song = local.getData();
                return true;
            } else if (local.getData().getSongName().compareTo(data) > 0) {
                local = local.getLeft();
            } else {
                local = local.getRight();
            }
        }

        return false;
    }

    public void search(String data) {
        Track song = root.getData();
        boolean flag = search2(data, song);

        if (flag) {
            System.out.println("Nombre de la cancion: " + song.getSongName());
            System.out.println("Artista/s de la cancion: " + song.getArtist());
            System.out.println("Popularidad de la cancion: " + song.getPopularity());
            System.out.println("ID de la cancion: " + song.getId());
        } else {
            System.out.println("Canción no encontrada.");
        }
    }

    @Override
    public String toString() {
        return root.toString();
    }

    int getHeight(Node<T> node) {
        if (node == null) return 0;
        return node.getDepth();
    }

    public void updateHeight(Node<T> node) {
        if (node == null) return;

        int leftHeight = getHeight(node.getLeft());
        int rightHeight = getHeight(node.getRight());
        int maxHeight = Math.max(leftHeight, rightHeight);

        node.setDepth(maxHeight + 1);
    }

    private Node<T> delete(Node<T> node, Track key) {

        this.eliminate = true;

        if(node == null){
            this.eliminate = false;
            return null;
        }

        if(key.compareTo(node.getData()) < 0) {
            node.setLeft(delete(node.getLeft(),key));
        } else if (key.compareTo(node.getData()) > 0) {
            node.setRight(delete(node.getRight(),key));
        } else {
            if (node.getLeft()==null) {
                node = node.getRight();
            }
            else if(node.getRight()==null){
                node = node.getLeft();
            } else {
                Track inorderSuccessorValue = getMin(node.getRight());
                node.setData(inorderSuccessorValue);
                node.setRight(delete(node.getRight(), inorderSuccessorValue));
            }
        }

        if (node == null) {
            this.eliminate = false;
            return null;
        }

        updateHeight(node);

        int balance = balanceNumber(node);

        if (balance > 1) {
            if (balanceNumber(node.getLeft()) >= 0) {
                node = rotateRight(node);
            }
            else {
                node.setLeft(rotateLeft(node.getLeft()));
                node = rotateRight(node);
            }
        }

        else if (balance < -1) {
            if (balanceNumber(node.getRight()) <= 0) {
                node = rotateLeft(node);
            }
            else {
                node.setRight(rotateRight(node.getRight()));
                node = rotateLeft(node);
            }
        }
        return node;
    }

    public boolean delete(Track key) {
        root = delete(this.root, key);

        return this.eliminate != false;
    }

    public void printTree() {
        root.setLevel(0);
        Queue<Node<T>> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node<T> node = q.poll();
            System.out.println(node);

            int level = node.getLevel();

            Node<T> left = node.getLeft();
            Node<T> right = node.getRight();

            if (left != null) {
                left.setLevel(level + 1);
                q.add(left);
            }
            if (right != null) {
                right.setLevel(level + 1);
                q.add(right);
            }
        }
    }

    public ArrayList<String> range(String n1, String n2) {
        this.l = new ArrayList<>();
        Track s1 = new Track(n1);
        Track s2 = new Track(n2);

        if(search2(n1, root.getData()) && search2(n2, root.getData())) {
            if (this.root == null) return null;

            if (n1.compareTo(n2) == 0) return null;
            else if (n1.compareTo(n2) > 0) return null;
            else {
                // this.l = rangeDelete(s1, s1);
            }
        } else return null;

        return null;
    }

    // private Node<T> deleteRange(Node<T> node, Comparators.Track key, Comparators.Track max) {}

    private void traverseInorder(Node<T> node) {
        if (node != null) {
            traverseInorder(node.getLeft());
            System.out.println(node.getData().getSongName());
            traverseInorder(node.getRight());
        }
    }

    public void printInorder() { traverseInorder(root); }
}
