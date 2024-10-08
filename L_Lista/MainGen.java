package L_Lista;

public class MainGen {

    public static void main( String[] args ) {

        ListaGen<String> ls = new ListaGen<>();

        ls.addTail( "Juve" );
        ls.addTail( "Catanzaro" );
        ls.addTail( "Bologna" );
        ls.addTail( "Roma" );

        System.out.println( ls );



    }
}
