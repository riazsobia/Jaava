package X_Progetti.V_Supermercato;

import java.util.Scanner;

public class Utility {
	
	public static int like = 0;

	public static int scegli( String[] opzioni ) {
		// costruttore da usare quando il programma legge da tastiera solo per il menu
		Scanner lettore = new Scanner(System.in);
		return scegli( opzioni, lettore );
	}

	public static int scegli( String[] opzioni, Scanner tastiera ) {
		// costruttore da usare quando la lettura da tastiera è usata in più posti del programma
		like++;
		int nscelta=0, nopzioni=opzioni.length;
        System.out.println("\n******** OPZIONI del MENU ********");
		for (int i=1; i<=nopzioni; i++) {
			System.out.println("[" + i + "]\t" + opzioni[i-1]);
		}
		System.out.print("Digitare il numero dell'opzione scelta [1-"+nopzioni+"]: ");
		// Scanner lettore = new Scanner(System.in);
		do {
			if (tastiera.hasNextLine()) {
				String scelta = tastiera.nextLine();
				nscelta = Integer.parseInt(scelta);
			}
		} while (nscelta<=0 || nscelta>nopzioni);
		return nscelta;
	}

}
