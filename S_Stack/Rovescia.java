package S_Stack;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


public class Rovescia {
public static void main(String[] args) {

    Stack<String> s = new Stack<>();
    
    try {
        File inputFile = new File("S_Stack/input.txt");
        Scanner scanner = new Scanner(inputFile);
        
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            s.push(line);
        }
        scanner.close();
    } catch (FileNotFoundException e) {
        System.out.println("File non trovato.");
    }
    
    try {
        File outputFile = new File("S_Stack/output.txt");
        PrintWriter writer = new PrintWriter(outputFile);
        
        while(!s.isEmpty()) {
            writer.println(s.pop());
        }
        writer.close();
    } catch (FileNotFoundException e) {
        System.out.println("Errore nella scrittura del file di output.");
    }
}
}
