import java.util.*;

class AVLTree<T extends Comparable<T>> {

    //ATRIBUTOS

    private Node<T> root;
    private Node<T> aux;
    private boolean eliminate = true;
    private ArrayList<Track> l;
    private ArrayList<String> l2;
    private boolean flag = true;
    private int size;
    private Track s;

    public AVLTree() {
        root = null;
        size = 0;
    }

    public Node<T> getRoot() { return this.root; }
    public Node<T> getAux() { return this.aux; }
    public boolean getEliminate() { return this.eliminate; }
    public ArrayList<Track> getL() {return this.l; }
    public ArrayList<String> getL2() {return this.l2; }
    public boolean getFlag() { return this.flag; }
    public int getsize() { return this.size; }
    public Track getS() { return this.s; }


    public Track max() {
        Node<T> local = root;

        if (local == null) return null;

        while (local.getRight() != null) {
            local = local.getRight();
        }

        return local.getData();
    }

    public Track min() {
        Node<T> local = root;

        if (local == null) return null;

        while (local.getLeft() != null) {
            local = local.getLeft();
        }

        return local.getData();
    }

    public Track getMin(Node<T> node) {
        if(node == null) return null;
        if(node.getLeft() == null) return node.getData();

        return getMin(node.getLeft());
    }

    private int depth(Node<T> node) {
        if (node == null) return 0;
        return node.getDepth();
    }

    private int balanceNumber(Node<T> node) {
        int L = depth(node.getLeft());
        int R = depth(node.getRight());
        if (L - R >= 2) return -1;
        else if (L - R <= -2) return 1;

        return 0;
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

    @Override
    public String toString() {
        return root.toString();
    }

    int getHeight(Node<T> node){
        if (node == null) return 0;
        return node.getDepth();
    }

    public void updateHeight(Node<T> node){
        if(node == null) return;

        int max = Math.max(getHeight(node.getLeft()), getHeight(node.getRight()));
        node.setDepth(max + 1);
    }

    //insertarAR

    public Node<T> insertar(String nombre, Track data) {
        size++;
        data.setKey(nombre);
        root = insertar(root, data);

        switch (balanceNumber(root)) {
            case 1 -> root = rotateLeft(root);
            case -1 -> root = rotateRight(root);
            default -> { }
        }
        return root;
    }

    private Node<T> insertar(Node<T> node, Track data) {
        if (node == null) return new Node<>(data);
        if (node.getData().compareTo(data) > 0) {
            node = new Node<>(node.getData(), insertar(node.getLeft(), data), node.getRight());
        } else if (node.getData().compareTo(data) < 0) {
            node = new Node<>(node.getData(), node.getLeft(), insertar(node.getRight(), data));
        }

        switch (balanceNumber(node)) {
            case 1 -> node = rotateLeft(node);
            case -1 -> node = rotateRight(node);
            default -> { return node; }
        }
        return node;
    }

    //BUSCAR

    private boolean buscar(String data) {
        Node<T> local = root;

        while (local != null) {
            if (local.getData().getSongName().compareTo(data) == 0) {
                this.s = local.getData();
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
        boolean flag = buscar(data);

        if (flag) {
            System.out.println("Nombre de la cancion: " + this.s.getSongName());
            System.out.println("Artista/s de la cancion: " + this.s.getArtist());
            System.out.println("Popularidad de la cancion: " + this.s.getPopularity());
            System.out.println("ID de la cancion: " + this.s.getId());
        } else System.out.println("Cancion no encontrada.");
    }

    //ELIMINAR

    private Node<T> eliminar(Node<T> node, String key) {
        this.eliminate = true;

        if(node == null) {
            this.eliminate = false;
            return null;
        }

        if (key.compareTo(node.getData().getSongName()) < 0) {
            node.setLeft(eliminar(node.getLeft(),key));
        } else if (key.compareTo(node.getData().getSongName()) > 0){
            node.setRight(eliminar(node.getRight(),key));
        }
        else {
            if(node.getLeft()==null) {
                node = node.getRight();
            } else if(node.getRight()==null){
                node = node.getLeft();
            } else {
                Track inorderSuccessorValue = getMin(node.getRight());
                node.setData(inorderSuccessorValue);
                node.setRight(eliminar(node.getRight(), inorderSuccessorValue.getSongName()));
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
            } else {
                node.setLeft(rotateLeft(node.getLeft()));
                node = rotateRight(node);
            }
        }

        else if (balance < -1) {
            if (balanceNumber(node.getRight()) <= 0) {
                node = rotateLeft(node);
            } else {
                node.setRight(rotateRight(node.getRight()));
                node = rotateLeft(node);
            }
        }
        return node;
    }

    public boolean eliminar(String key){
        root = eliminar(this.root, key);
        return this.eliminate != false;
    }


    //ELIMINAR DE UN RANGO

    public ArrayList<String> range(String name1, String name2) {
        this.l2 = new ArrayList<>();

        if(buscar(name1) && buscar(name2)) {
            Order2(root,name1,name2);
            System.out.print("Se ha(n) eliminado: ");
            return this.l2;
        }
        return null;
    }


    private void Order2(Node<T> node, String name1, String name2){
        if (node != null) {
            Order2(node.getLeft(),name1,name2);
            if (node.getData().getSongName().compareTo(name1) > 0 && node.getData().getSongName().compareTo(name2) < 0) {
                if(!l2.contains(node.getData().getSongName())) this.l2.add(node.getData().getSongName());
                eliminar(node.getData().getSongName());
            }

            Order2(node.getRight(),name1,name2);
            if(node.getData().getSongName().compareTo(name1) > 0 && node.getData().getSongName().compareTo(name2) < 0){
                if(!l2.contains(node.getData().getSongName())) this.l2.add(node.getData().getSongName());
                eliminar(node.getData().getSongName());
            }
        }
    }

    //IMPRIMIR

    public void PrintTree() {
        root.level = 0;
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node<T> node = queue.poll();
            System.out.println(node);
            int level = node.level;
            Node<T> left = node.getLeft();
            Node<T> right = node.getRight();
            if (left != null) {
                left.level = level + 1;
                queue.add(left);
            }
            if (right != null) {
                right.level = level + 1;
                queue.add(right);
            }
        }
    }

    private void traverseInOrder(Node<T> node) {
        if (node != null) {
            traverseInOrder(node.getLeft());
            System.out.println(node.getData().getSongName());
            traverseInOrder(node.getRight());
        }
    }

    public void printInOrder(){
        traverseInOrder(root);
    }
}