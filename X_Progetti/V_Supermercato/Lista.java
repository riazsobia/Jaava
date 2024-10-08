package X_Progetti.V_Supermercato;

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

    public T removeHead() {
        if (root==null) return null;
        Nodo<T> result = root;
        root = root.getSuccessivo();
        return result.getValore();
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

    public T removeTail() {
        if (isEmpty()) return null;
        Nodo<T> pAttuale, pPrecedente;
        pAttuale = pPrecedente = root;
        while (pAttuale.getSuccessivo()!=null) {
            pPrecedente = pAttuale;
            pAttuale = pAttuale.getSuccessivo();
        }
        pPrecedente.setSuccessivo(null);
        if (pAttuale==root) root = null;
        return pAttuale.getValore();
    }

    public T removePos( int pos ) {
        // elimina il nodo che si trova esattamente nella posizione di indice pos
        if ( isEmpty() || pos<0 ) return null;
        Nodo<T> pAttuale, pPrecedente;
        pAttuale = pPrecedente = root;
        for (int i=0; i<pos; i++) {
            if (pAttuale.getSuccessivo()!=null) {
                pPrecedente = pAttuale;
                pAttuale = pAttuale.getSuccessivo();
            } else return null;
        }
        if (pAttuale==root) root = null;
        pPrecedente.setSuccessivo(pAttuale.getSuccessivo());
        return pAttuale.getValore();
    }

    public boolean addAfter( int pos, T v ) {
        // aggiunge un nuovo nodo n avente valore v, solo dopo aver oltrepassato il nodo di indice pos nella lista
        Iteratore iter = this.getIterator();
        Nodo<T> n = new Nodo<>(v);
        int i; Nodo<T> npos=null;
        for (i=0; i<pos; i++) {
            if (iter.hasNext()) npos = iter.next();
            else return false;
        }
        n.setSuccessivo(npos.getSuccessivo());
        npos.setSuccessivo(n);
        return true;
    }
    
    // definizione della classe iteratore per i nodi della lista
    class Iteratore {
        private Nodo<T> nodo;
        private Iteratore(Nodo<T> nodo) {
            this.nodo = nodo;
        }
        public Nodo<T> getCurrent() {
            return nodo;
        }
        public boolean hasNext() {
            return nodo!=null;
        }
        public Nodo<T> next() {
            if (nodo==null) return null;
            Nodo<T> result = nodo;
            nodo = nodo.getSuccessivo();
            return result;
        }
    }
    // metodo per ottenere un iteratore sulla lista corrente
    public Iteratore getIterator() {
        Iteratore i = new Iteratore(root);
        return i;
    }

    // toString che usa l'iteratore
    public String toString() {
        String s = "\n---- LIST BEGIN ----\n";
        Iteratore iter = this.getIterator();
        while (iter.hasNext()) {
            s += iter.getCurrent() + "\n";
            iter.next();
        }
        s += "---- LIST END ----\n";
        return s;
    }

}
