package X_Progetti.V_Supermercato;

import java.util.Scanner;

public class Main {

    public static int leggiCodiceProdotto( Scanner tastiera ) {
        int codice = 0;
        try {
            System.out.print("Inserire codice prodotto: ");
   			String scelta = tastiera.nextLine();
			codice = Integer.parseInt(scelta);
        } catch (Exception ex) {
            System.out.println("Errore in lettura codice prodotto: " + ex.getMessage());
        }
        return codice;
    }
    public static void main(String[] args) {

        boolean playAgain = true;
        Spesa spesa = new Spesa();
        String[] opzioni = { "Aggiungi prodotto", "Elimina ultimo prodotto inserito", "Elimina prodotto", "Calcolo totale", "Stampa carrello", "Salva carrello", "Mostra magazzino", "Esci" };
		int scelta, cod;
        Prodotto p;
        Scanner tastiera = new Scanner(System.in);

        do {
            scelta = Utility.scegli(opzioni, tastiera);
            switch (scelta) {
                case 1: // aggiungi prodotto
                    cod = leggiCodiceProdotto( tastiera );
                    if (cod==0) continue;
                    p = spesa.aggiungi(cod);
                    System.out.println( p==null ? "Codice " + cod + " non trovato!" : p + " aggiunto al carrello!" );
                    break;
                case 2: // elimina ultimo
                    p = spesa.elimina();
                    System.out.println( p==null ? "Nessun prodotto presente nel carrello!" : p + " eliminato!" );
                    break;
                case 3: // elimina prodotto indicandone il codice
                    cod = leggiCodiceProdotto( tastiera );
                    if (cod==0) continue;
                    p = spesa.elimina(cod);
                    System.out.println( p==null ? "Codice " + cod + " non trovato!" : p + " eliminato!" );
                    break;
                case 4:
                    System.out.println( "Totale costo dei prodotti nel carrello: " + spesa.calcolaTotale() );
                    break;
                case 5:
                    spesa.stampa();
                    break;
                case 6:
                    spesa.salva();
                    System.out.println("Lista prodotti nel carrello salvata su file!");
                    break;
                case 7:
                    spesa.stampaMagazzino();
                    break;
                case 8:
                    playAgain = false;
                    break;
                default:
                    System.out.println("\nScelta non valida\n");
            }
        } while (playAgain);
    }

}
