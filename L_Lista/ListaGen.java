package L_Lista;

public class ListaGen<T> {

    NodoGen<T> root;

    public ListaGen() {
        this.root = null;
    }

    public void addTail(T v ) {
        addTail( new NodoGen<T>( v ) );
    }

    public void addTail( NodoGen<T> n ) {
        if (root==null) {
            root = n;
        } else {
            NodoGen<T> tmp = root;
            while (tmp.getSuccessivo()!=null) tmp=tmp.getSuccessivo();
            tmp.setSuccessivo( n );
        }
    }
    
    public String toString() {
        String s = "\nLIST BEGIN *************\n";
        NodoGen<T> tmp = root;
        while (tmp!=null) {
            s += tmp + "\n";
            tmp=tmp.getSuccessivo();
        }
        s += "********************* LIST END\n";
        return s;
    }


}
