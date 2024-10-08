package X_Progetti.V_Supermercato;

public class Prodotto {

    int codice;
    String descrizione;
    double costo;

    public Prodotto(int codice, String descrizione, double costo) {
        this.codice = codice;
        this.descrizione = descrizione;
        this.costo = costo;
    }

    public Prodotto( Prodotto original ) {
        this.codice = original.codice;
        this.descrizione = original.descrizione;
        this.costo = original.costo;
    }

    @Override
    public String toString() {
        return "Prodotto [codice=" + codice + ", descrizione=" + descrizione + ", costo=" + costo + "]";
    }

}
