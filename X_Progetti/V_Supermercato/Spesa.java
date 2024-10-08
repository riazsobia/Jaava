package X_Progetti.V_Supermercato;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Spesa {

    private Lista<Prodotto> magazzino, carrello;
    private final String fileMagazzino = "X_Progetti/V_Supermercato/magazzino.csv";
    private final String fileCarrello = "X_Progetti/V_Supermercato/carrello.txt";

    public Spesa() {
        magazzino = new Lista<>();
        carrello = new Lista<>();
        caricaMagazzino();
    }

    public Lista<Prodotto> getCarrello() {
        return carrello;
    }

    public void caricaMagazzino() {
        try {
            Scanner scanner = new Scanner(new File(fileMagazzino));
            while (scanner.hasNext()) {
                String s = scanner.nextLine();
                String[] flds = s.split(";");
                if (flds.length!=3) continue;
                magazzino.addTail( new Prodotto(Integer.parseInt(flds[0]), flds[1], Double.parseDouble(flds[2])) );
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println( "Errore leggendo il file dei prodotti: " + e.getMessage() );
        }
    }

    public Prodotto aggiungi(int codiceProdotto) {
        // cerca in magazzino il prodotto con il codice specificato e ne aggiunge una copia al carrello
        Lista<Prodotto>.Iteratore iteraMagazzino = magazzino.getIterator();
        while (iteraMagazzino.hasNext()) {
            Nodo<Prodotto> current = iteraMagazzino.getCurrent();
            if ( current.getValore().codice == codiceProdotto ) {
                // trovato, aggiungiamone una copia al carrello
                Prodotto copia = new Prodotto( current.getValore() );
                carrello.addHead( copia );
                return copia;
            }
            iteraMagazzino.next();
        }
        return null;
    }

    public Prodotto elimina() {
        // elimina l'ultimo prodotto inserito nel carrello
        return carrello.removeHead();
    }

    public Prodotto elimina(int codiceProdotto) {
        // cerca nel carrello il prodotto con codice indicato e lo rimuove, restituendolo al chiamante
        int count = 0;
        Lista<Prodotto>.Iteratore iteraCarrello = carrello.getIterator();
        while (iteraCarrello.hasNext()) {
            if ( iteraCarrello.getCurrent().getValore().codice == codiceProdotto ) {
                return carrello.removePos(count);
            }
            iteraCarrello.next();
            count++;
        }
        return null;
    }

    public double calcolaTotale() {
        double totale = 0.0;
        Lista<Prodotto>.Iteratore iteraCarrello = carrello.getIterator();
        while (iteraCarrello.hasNext()) {
            totale += iteraCarrello.getCurrent().getValore().costo;
            iteraCarrello.next();
        }
        return totale;
    }

    public void stampa() {
        System.out.println( carrello );
    }

    public void stampaMagazzino() {
        System.out.println( magazzino );
    }

    public void salva() {
        PrintWriter printer;
        try {
            printer = new PrintWriter( new File(fileCarrello) );
            printer.print( carrello );
            printer.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Errore: " + ex.getMessage());
        }
    }

}
