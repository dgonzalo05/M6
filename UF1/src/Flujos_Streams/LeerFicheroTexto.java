package Flujos_Streams;
import
 java.io.*;
public class LeerFicheroTexto {
	public static void main ( String [] args) throws IOException {
		File fichero = new File ("src/LeerFicheroTexto.java");  // declaración fichero
		FileReader flu = new FileReader (fichero); // creamos flujo de entrada hacia el fichero
		char[] text = new char[20];
		while ((flu.read(text,0,20))!=-1) {   //Vamos leyendo carácter a carácter
			System.out.println (text); //hacemos cast a char del entero leído
		}
		flu.close();
	}
}