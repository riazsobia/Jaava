package L_Lista;

public class NodoGen<T> {

    private T valore;
    private NodoGen<T> successivo;

    public NodoGen( T valore ) {
        this.valore = valore;
        successivo = null;
    }

    public void setValore( T valore ) {
        this.valore = valore;
    }

    public T getValore() {
        return valore;
    }

    public NodoGen<T> getSuccessivo() {
        return successivo;
    }

    public void setSuccessivo(NodoGen<T> successivo) {
        this.successivo = successivo;
    }
    
    public String toString() {
        return "Il mio valore è: " + valore;
    }

}
