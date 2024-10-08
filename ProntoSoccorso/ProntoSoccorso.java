package ProntoSoccorso;

public class ProntoSoccorso {

    Lista<Paziente> ps;

    public ProntoSoccorso() {
        ps = new Lista<>();
        loadFromFile();
    }

    public String cercaPazienti( String triage ) {
        String result = "Lista pazienti con triage=" + triage + ":\n";
        Nodo<Paziente> p = ps.getRoot();
        while (p!=null) {
            if (p.getValore().getTriage().equals(triage)) {
                result += p + "\n";
            }
            p = p.getSuccessivo();
        }
        return result;
    }



    private void loadFromFile() {
        // per il momento lo facciamo "sdozzo"
        ps.addTail( new Paziente("Mario", "Rossi", "white") );
        ps.addTail( new Paziente("Maria", "Rossi", "yellow") );
        ps.addTail( new Paziente("Benedetta", "Italia", "yellow") );
        ps.addTail( new Paziente("Riccardina", "Gamberini", "red") );
    }

    @Override
    public String toString() {
        return "ProntoSoccorso [ps=" + ps + "]";
    }
    





}
