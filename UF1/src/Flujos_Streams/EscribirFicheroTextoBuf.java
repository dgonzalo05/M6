package Flujos_Streams;
import java.io.*;
public class EscribirFicheroTextoBuf {
	public static void main (String [] args) {
	try {
		BufferedWriter fichero = new BufferedWriter( new FileWriter(args[0])); 
		String linea;
		for ( int i=1; i <= 10 ; i++) {
			linea = "linea"+i;
			fichero.write (linea);
			fichero.newLine();
		}
		fichero.close();
	} catch (FileNotFoundException fn) {System.out.println ("No se encuentra el fichero"); }
	  catch (IOException io) {System.out.println ("Error de E/S"); }
	}
}