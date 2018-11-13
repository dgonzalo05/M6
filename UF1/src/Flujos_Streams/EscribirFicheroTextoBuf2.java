import java.io.*;
public class EscribirFicheroTextoBuf2 {
	public static void main (String [] args) {
	try {
		PrintWriter fichero = new PrintWriter( new FileWriter(args[0])); 
		String linea;
		for ( int i=1; i <= 10 ; i++) {
			linea = "linea"+i;
			fichero.println (linea);
		}
		fichero.close();
	} catch (FileNotFoundException fn) {System.out.println ("No se encuentra el fichero"); }
	  catch (IOException io) {System.out.println ("Error de E/S"); }
	}
}