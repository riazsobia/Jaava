package ProntoSoccorso;


public class Lista<T> {

    Nodo<T> root;

    public Lista() {
        this.root = null;
    }

    public Nodo<T> getRoot() {
        return root;
    }

    public boolean isEmpty() {
        return root==null;
    }

    public void addHead( T v ) {
        Nodo<T> n = new Nodo<>(v);
        if (isEmpty()) root=n;
        else {
            n.setSuccessivo(root);
            root = n;
        }
    }

    public void addTail( T v ) {
        Nodo<T> n = new Nodo<>(v);
        if (root==null) {
            root = n;
        } else {
            Nodo<T> tmp = root;
            while (tmp.getSuccessivo()!=null) tmp=tmp.getSuccessivo();
            tmp.setSuccessivo( n );
        }
    }

    public String toString() {
        String s = "\nLIST BEGIN *************\n";
        Nodo<T> tmp = root;
        while (tmp!=null) {
            s += tmp + "\n";
            tmp=tmp.getSuccessivo();
        }
        s += "********************* LIST END\n";
        return s;
    }


}
