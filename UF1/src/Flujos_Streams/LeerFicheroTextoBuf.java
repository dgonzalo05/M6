package Flujos_Streams;
import java.io.*;
public class LeerFicheroTextoBuf {
	public static void main (String [] args) {
	try {
		BufferedReader fichero = new BufferedReader ( new FileReader(args[0])); 
		String linea;
		while ((linea = fichero.readLine()) != null) {  
			System.out.println (linea);
		}
		fichero.close();
	} catch (FileNotFoundException fn) {System.out.println ("No se encuentra el fichero"); }
	  catch (IOException io) {System.out.println ("Error de E/S"); }
	}
}