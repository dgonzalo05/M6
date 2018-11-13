import java.io.*;
public class EscribirFicheroTexto2 {
	public static void main (String [] args) throws IOException {
		File fichero = new File("FicheroTexto.txt");
		FileWriter fic = new FileWriter (fichero);
		String prov[] = {"Albacete", "Avila", "Badajoz", "Caceres", "Huelva", "Jaen", 
		"Madrid", "Segovia", "Soria", "Toledo", "Valladolid", "Zamora"};
		for ( int i=0; i < prov.length ; i++) {
			fic.write (prov[i]+"\n"); // se va escribiendo carácter a carácter
		}
		fic.close ();   // cerramos fichero
		}
}
