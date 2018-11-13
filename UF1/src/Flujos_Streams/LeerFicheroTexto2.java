import java.io.File;
import java.io.FileReader;
import java.io.IOException;
public class LeerFicheroTexto2 {
	public static void main ( String [] args) throws IOException {
		File fichero = new File (args[0]);  // declaración fichero
		FileReader flu = new FileReader (fichero); // creamos flujo de entrada hacia el fichero
		char[] text = new char[20];
		while ((flu.read(text,0,20))!=-1) {   //Vamos leyendo carácter a carácter
			System.out.println (text); //hacemos cast a char del entero leído
		}
		flu.close();
	}
}